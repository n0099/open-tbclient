package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.widget.LinearLayout;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
public class LivePlayerControl implements BMediaController.RTMPConnControl, BMediaController.VideoViewControl {
    public static final int DECODE_HW = 0;
    public static final int DECODE_MHW = 2;
    public static final int DECODE_MHW_AUTO = 3;
    public static final int DECODE_SW = 1;
    private static final String TAG = "Java LivePlayerControl";
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static Context mNativeContext = null;
    public static int returnvalue = 0;
    private EventHandler mEventHandler;
    private HandlerThread mHandlerThread;
    private LinearLayout videodisplay;
    private Handler uihandler = new Handler();
    private String vpath = null;
    private PLAYER_STATUS playerstate = PLAYER_STATUS.PLAYER_IDLE;
    private LivePlayerControllerListener ctrlListener = null;
    private LivePlayerControllerListener testListener = null;
    private int mErrorCode = 0;
    private int mListenType = 0;
    private boolean isbuffering = false;
    private int cachingpercent = 0;
    public int duration = 0;
    public int posfrom = 0;
    public int playeridx = -1;
    private int mDecodeMode = 1;
    public int mScaleMode = 2;

    /* loaded from: classes.dex */
    public enum CACHE_STATUS {
        CACHE_START,
        CACHE_END
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class EventHandler extends Handler {
        public EventHandler(LivePlayerControl livePlayerControl, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case -100:
                    LivePlayerControl.this.reset();
                    LivePlayerControl.this.NotifyError(message.arg1, 0);
                    LivePlayerControl.this.NotifyUIError(message.arg1, 0);
                    return;
                case 101:
                    LivePlayerControl.this.NotifyTestListener(PLAYER_STATUS.PLAYER_PREPARED);
                    LivePlayerControl.this.NotifyUIListener(PLAYER_STATUS.PLAYER_PREPARED);
                    if (LivePlayerControl.this.posfrom > 0) {
                        LivePlayerControl.this.nativeSeekto(LivePlayerControl.this.playeridx, LivePlayerControl.this.posfrom);
                        LivePlayerControl.this.posfrom = 0;
                    }
                    LivePlayerControl.this.nativePlay(LivePlayerControl.this.playeridx);
                    return;
                case 103:
                    LivePlayerControl.this.isbuffering = true;
                    final int i = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                if (i == 0) {
                                    LivePlayerControl.this.ctrlListener.onCacheStatusChanged(CACHE_STATUS.CACHE_START);
                                } else if (1 == i) {
                                    LivePlayerControl.this.ctrlListener.onCacheStatusChanged(CACHE_STATUS.CACHE_END);
                                }
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_PLAYING /* 106 */:
                    LivePlayerControl.this.NotifyTestListener(PLAYER_STATUS.PLAYER_PLAYING);
                    LivePlayerControl.this.NotifyUIListener(PLAYER_STATUS.PLAYER_PLAYING);
                    return;
                case Constants.MEDIA_CACHE_PERCENT /* 107 */:
                    LivePlayerControl.this.cachingpercent = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onCachingUpdate(LivePlayerControl.this.cachingpercent);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_FRAME_REFRESH /* 108 */:
                default:
                    return;
                case Constants.MEDIA_PAUSED /* 109 */:
                    LivePlayerControl.this.NotifyTestListener(PLAYER_STATUS.PLAYER_PAUSED);
                    LivePlayerControl.this.NotifyUIListener(PLAYER_STATUS.PLAYER_PAUSED);
                    return;
                case 110:
                    LivePlayerControl.this.duration = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onDurationUpdate(LivePlayerControl.this.duration);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_STOPPED /* 111 */:
                    LivePlayerControl.this.NotifyTestListener(PLAYER_STATUS.PLAYER_STOPPED);
                    LivePlayerControl.this.NotifyUIListener(PLAYER_STATUS.PLAYER_STOPPED);
                    return;
                case Constants.MEDIA_POSITION_UPDATE /* 112 */:
                    final int i2 = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPositionUpdate(i2);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_COMPLETE /* 113 */:
                    LivePlayerControl.this.NotifyTestListener(PLAYER_STATUS.PLAYER_COMPLETE);
                    LivePlayerControl.this.NotifyUIListener(PLAYER_STATUS.PLAYER_COMPLETE);
                    return;
                case Constants.MEDIA_CLOSED /* 114 */:
                    LivePlayerControl.this.NotifyTestListener(PLAYER_STATUS.PLAYER_IDLE);
                    LivePlayerControl.this.NotifyUIListener(PLAYER_STATUS.PLAYER_IDLE);
                    return;
                case Constants.MEDIA_WARNING /* 115 */:
                    LivePlayerControl.this.NotifyError(0, 2);
                    LivePlayerControl.this.NotifyUIError(0, 2);
                    return;
                case Constants.MEDIA_HARD_DECODE_FAILED /* 116 */:
                    LivePlayerControl.this.NotifyError(message.arg1, 1);
                    LivePlayerControl.this.NotifyUIError(message.arg1, 1);
                    return;
                case Constants.MEDIA_READED_BYTES /* 117 */:
                    final int i3 = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onReadedBytes(i3);
                            }
                        }
                    });
                    return;
                case Constants.CMD_PLAYERCLOSE /* 32773 */:
                    LivePlayerControl.this.nativeClose(LivePlayerControl.this.playeridx);
                    return;
                case Constants.CMD_PLAYERRESUME /* 32777 */:
                    LivePlayerControl.this.nativeResume(LivePlayerControl.this.playeridx);
                    return;
                case Constants.CMD_PLAYERPAUSE /* 32778 */:
                    LivePlayerControl.this.nativePause(LivePlayerControl.this.playeridx);
                    return;
                case Constants.CMD_PLAYEREXIT /* 32779 */:
                    LivePlayerControl.this.nativeExit(LivePlayerControl.this.playeridx);
                    return;
                case Constants.CMD_SETSEEKACCURATE /* 32789 */:
                    LivePlayerControl.this.nativeSeekto(LivePlayerControl.this.playeridx, message.arg1);
                    return;
                case Constants.CMD_PLAYERINIT /* 32798 */:
                    Log.i(LivePlayerControl.TAG, "cmd playerinit = " + LivePlayerControl.this.playeridx);
                    LivePlayerControl.this.nativeInitpath(LivePlayerControl.this.playeridx, 0, LivePlayerControl.this.vpath, null, null, null, LivePlayerControl.this.mDecodeMode);
                    return;
                case Constants.CMD_PLAYERPLAY /* 32799 */:
                    LivePlayerControl.this.nativePlay(LivePlayerControl.this.playeridx);
                    return;
                case Constants.DEBUG_MESSAGE /* 32806 */:
                    final String str = (String) message.obj;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onDebugInfoUpdate(str);
                            }
                        }
                    });
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public enum PLAYER_STATUS {
        PLAYER_IDLE,
        PLAYER_INIT,
        PLAYER_PREPARED,
        PLAYER_PLAYING,
        PLAYER_PAUSED,
        PLAYER_STOPPED,
        PLAYER_COMPLETE
    }

    public LivePlayerControl() {
        initplayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NotifyError(int i, int i2) {
        if (this.testListener != null) {
            if (i2 == 1) {
                this.testListener.onHardDecodeFailed(i);
            }
            if (i2 == 0) {
                this.testListener.onError(i);
            }
            if (i2 == 2) {
                this.testListener.onWarning(Constants.MEDIA_WARNING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NotifyTestListener(PLAYER_STATUS player_status) {
        if (this.testListener != null) {
            this.testListener.onPlayStatusChanged(player_status, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NotifyUIError(int i, int i2) {
        this.mErrorCode = i;
        this.mListenType = i2;
        this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.2
            @Override // java.lang.Runnable
            public void run() {
                if (LivePlayerControl.this.ctrlListener != null) {
                    if (LivePlayerControl.this.mListenType == 1) {
                        LivePlayerControl.this.ctrlListener.onHardDecodeFailed(LivePlayerControl.this.mErrorCode);
                    }
                    if (LivePlayerControl.this.mListenType == 0) {
                        LivePlayerControl.this.ctrlListener.onError(LivePlayerControl.this.mErrorCode);
                    }
                    if (LivePlayerControl.this.mListenType == 2) {
                        LivePlayerControl.this.ctrlListener.onWarning(Constants.MEDIA_WARNING);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NotifyUIListener(PLAYER_STATUS player_status) {
        this.playerstate = player_status;
        this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.1
            @Override // java.lang.Runnable
            public void run() {
                if (LivePlayerControl.this.ctrlListener != null) {
                    LivePlayerControl.this.ctrlListener.onPlayStatusChanged(LivePlayerControl.this.playerstate, 0, 0);
                }
            }
        });
    }

    public static void ReceiverTitle_callback(String str) {
        System.out.println("Java LivePlayerControl   " + str);
    }

    private void SendHandlerMessage(int i, int i2, int i3) {
        if (this.mEventHandler != null) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            this.mEventHandler.sendMessage(message);
        }
    }

    public static boolean checkSDKCap() {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 10) {
            System.out.println("Android ADK version " + Build.VERSION.SDK_INT + " is low.");
            return false;
        }
        String upperCase = Build.CPU_ABI.substring(0, 3).toUpperCase();
        if (!upperCase.equals("ARM") && !upperCase.equals("X86")) {
            z = false;
        }
        return z;
    }

    private void initplayer() {
        this.mHandlerThread = new HandlerThread("player listeners handler thread", 0);
        this.mHandlerThread.start();
        this.mEventHandler = new EventHandler(this, this.mHandlerThread.getLooper());
        this.playeridx = nativeCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClose(int i);

    private native int nativeCreate();

    private native int nativeDuration(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeExit(int i);

    private native void nativeInitObject();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeInitpath(int i, int i2, String str, String str2, String str3, Surface surface, int i3);

    private native void nativeMute(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePause(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePlay(int i);

    private native int nativePosition(int i);

    private native int nativeQueryAudioStrength(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeResume(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSeekto(int i, int i2);

    private native void nativeSetLogLevel(int i);

    private native int nativeSetOption(int i, String str, String str2);

    private native void nativeSetRender(int i, int i2);

    private native int nativeVideoHeight(int i);

    private native int nativeVideoWidth(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.vpath = null;
        this.playerstate = PLAYER_STATUS.PLAYER_IDLE;
    }

    public int ReceiverDebugInfo_callback(String str) {
        if (this.mEventHandler != null) {
            Message message = new Message();
            message.what = Constants.DEBUG_MESSAGE;
            message.obj = str;
            this.mEventHandler.sendMessage(message);
            return 0;
        }
        return 0;
    }

    public int ReceiverValue_callback(int i, int i2) {
        returnvalue = i;
        switch (i) {
            case -102:
            case -101:
            case -100:
                SendHandlerMessage(-100, i, 0);
                break;
            case 1:
                LogbyLevel.i(TAG, "LivePlayer------prepared");
                SendHandlerMessage(101, 0, 0);
                break;
            case 2:
                LogbyLevel.i(TAG, "LivePlayer------playing");
                SendHandlerMessage(Constants.MEDIA_PLAYING, 0, 0);
                break;
            case 3:
                LogbyLevel.i(TAG, "LivePlayer------paused");
                SendHandlerMessage(Constants.MEDIA_PAUSED, 0, 0);
                break;
            case 4:
                SendHandlerMessage(103, i2, 0);
                break;
            case 5:
                SendHandlerMessage(Constants.MEDIA_STOPPED, 0, 0);
                break;
            case 6:
                SendHandlerMessage(Constants.MEDIA_COMPLETE, 0, 0);
                break;
            case 7:
                LogbyLevel.i(TAG, "LivePlayer------DURATION_7   " + i2);
                SendHandlerMessage(110, i2, 0);
                break;
            case 8:
                SendHandlerMessage(Constants.MEDIA_CACHE_PERCENT, i2, 0);
                break;
            case 9:
                SendHandlerMessage(Constants.MEDIA_POSITION_UPDATE, i2, 0);
                break;
            case 10:
                SendHandlerMessage(Constants.MEDIA_CLOSED, i2, 0);
                break;
            case 11:
                SendHandlerMessage(Constants.MEDIA_WARNING, i2, 0);
                break;
            case 12:
                SendHandlerMessage(Constants.MEDIA_HARD_DECODE_FAILED, i2, i);
                break;
            case 13:
                SendHandlerMessage(Constants.MEDIA_READED_BYTES, i2, i);
                break;
        }
        return 0;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void close() {
        SendHandlerMessage(Constants.CMD_PLAYERCLOSE, 0, 0);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void exit() {
        if (this.mEventHandler != null) {
            this.mEventHandler.removeMessages(Constants.MEDIA_POSITION_UPDATE);
        }
        this.posfrom = 0;
        SendHandlerMessage(Constants.CMD_PLAYEREXIT, 0, 0);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public int getCurrentPosition() {
        return nativePosition(this.playeridx);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public int getDuration() {
        return nativeDuration(this.playeridx);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public int getSignalStrength() {
        return nativeQueryAudioStrength(this.playeridx);
    }

    public int getVideoHeight() {
        return nativeVideoHeight(this.playeridx);
    }

    public int getVideoWidth() {
        return nativeVideoWidth(this.playeridx);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public boolean isPlaying() {
        LogbyLevel.d(TAG, "LivePlayerControl check isPlaying" + this.playerstate);
        return this.playerstate == PLAYER_STATUS.PLAYER_PLAYING;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void mute(int i) {
        if (this.playerstate == PLAYER_STATUS.PLAYER_PLAYING) {
            nativeMute(this.playeridx, i);
        }
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void pause() {
        LogbyLevel.d(TAG, "LivePlayerControl  pause");
        SendHandlerMessage(Constants.CMD_PLAYERPAUSE, 0, 0);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void play() {
        LogbyLevel.i(TAG, "LivePlayerControl  play  ");
        if (PLAYER_STATUS.PLAYER_STOPPED != this.playerstate) {
            SendHandlerMessage(Constants.CMD_PLAYERPLAY, 0, 0);
            return;
        }
        this.playerstate = PLAYER_STATUS.PLAYER_INIT;
        if (this.ctrlListener != null) {
            this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_INIT, 0, 0);
        }
        SendHandlerMessage(Constants.CMD_PLAYERINIT, 0, 0);
    }

    public PLAYER_STATUS playerstatus() {
        return this.playerstate;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void resume() {
        LogbyLevel.d(TAG, "LivePlayerControl  resume");
        SendHandlerMessage(Constants.CMD_PLAYERRESUME, 0, 0);
    }

    public int returnvalue() {
        LogbyLevel.i(TAG, "LivePlayerControl  returnvalue call back  ");
        return returnvalue;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void seekTo(double d) {
        if (this.playerstate == PLAYER_STATUS.PLAYER_PAUSED || this.playerstate == PLAYER_STATUS.PLAYER_PLAYING) {
            SendHandlerMessage(Constants.CMD_SETSEEKACCURATE, (int) d, 0);
        }
    }

    public void setControllerListener(LivePlayerControllerListener livePlayerControllerListener) {
        this.ctrlListener = livePlayerControllerListener;
    }

    public void setDecodeMode(int i) {
        this.mDecodeMode = i;
    }

    public void setLogLevel(Constants.LOGLEVEL loglevel) {
        nativeSetLogLevel(loglevel.ordinal());
        LogbyLevel.setLogLevel(loglevel.ordinal());
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.RTMPConnControl
    public void setOption(String str, String str2) {
        nativeSetOption(this.playeridx, str, str2);
    }

    public void setRender(int i) {
        nativeSetRender(this.playeridx, i);
    }

    public void setTestListener(LivePlayerControllerListener livePlayerControllerListener) {
        this.testListener = livePlayerControllerListener;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void setVideoPath(String str) {
        this.vpath = str;
        this.playerstate = PLAYER_STATUS.PLAYER_IDLE;
    }

    public void setplayerstatus(PLAYER_STATUS player_status) {
        this.playerstate = player_status;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void start() {
        if (this.mEventHandler != null) {
            this.mEventHandler.removeMessages(Constants.MEDIA_POSITION_UPDATE);
        }
        if (this.vpath == null || this.playerstate != PLAYER_STATUS.PLAYER_IDLE) {
            return;
        }
        this.playerstate = PLAYER_STATUS.PLAYER_INIT;
        if (this.ctrlListener != null) {
            this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_INIT, 0, 0);
        }
        SendHandlerMessage(Constants.CMD_PLAYERINIT, 0, 0);
    }

    public void start(int i) {
        if (this.mEventHandler != null) {
            this.mEventHandler.removeMessages(Constants.MEDIA_POSITION_UPDATE);
        }
        if (this.vpath == null || this.playerstate != PLAYER_STATUS.PLAYER_IDLE) {
            return;
        }
        this.posfrom = i;
        this.playerstate = PLAYER_STATUS.PLAYER_INIT;
        if (this.ctrlListener != null) {
            this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_INIT, 0, 0);
        }
        SendHandlerMessage(Constants.CMD_PLAYERINIT, 0, 0);
    }

    public void test() {
        LogbyLevel.i(TAG, "LivePlayerControl  test call back  ");
    }
}
