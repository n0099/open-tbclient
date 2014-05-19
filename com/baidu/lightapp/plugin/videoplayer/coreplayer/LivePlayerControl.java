package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.LinearLayout;
import com.baidu.channelrtc.medialivesender.LiveNativeSender;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
public class LivePlayerControl implements BMediaController.RTMPConnControl, BMediaController.VideoViewControl {
    private static final String TAG = "Jave LivePlayerControl";
    private static EventHandler mEventHandler;
    public static Context mNativeContext = null;
    public static int returnvalue = 0;
    private HandlerThread mHandlerThread;
    private LinearLayout videodisplay;
    private Handler uihandler = new Handler();
    private String vpath = null;
    private PLAYER_STATUS playerstate = PLAYER_STATUS.PLAYER_IDLE;
    private LivePlayerControllerListener ctrlListener = null;
    private boolean isbuffering = false;
    private int cachingpercent = 0;
    public int duration = 0;
    public int posfrom = 0;

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
                    final int i = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onError(i);
                            }
                        }
                    });
                    return;
                case 101:
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_PREPARED, 0, 0);
                            }
                        }
                    });
                    LivePlayerControl.this.playerstate = PLAYER_STATUS.PLAYER_PLAYING;
                    if (LivePlayerControl.this.posfrom > 0) {
                        LivePlayerControl.this.nativeSeekto(LivePlayerControl.this.posfrom);
                        LivePlayerControl.this.posfrom = 0;
                    }
                    LivePlayerControl.this.nativePlay();
                    return;
                case 103:
                    LivePlayerControl.this.isbuffering = true;
                    LivePlayerControl.this.playerstate = PLAYER_STATUS.PLAYER_PAUSED;
                    final int i2 = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                if (i2 == 0) {
                                    LivePlayerControl.this.ctrlListener.onCacheStatusChanged(CACHE_STATUS.CACHE_START);
                                } else if (1 == i2) {
                                    LivePlayerControl.this.ctrlListener.onCacheStatusChanged(CACHE_STATUS.CACHE_END);
                                }
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_PLAYING /* 106 */:
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.2
                        @Override // java.lang.Runnable
                        public void run() {
                            LivePlayerControl.this.playerstate = PLAYER_STATUS.PLAYER_PLAYING;
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_PLAYING, 0, 0);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_CACHE_PERCENT /* 107 */:
                    LivePlayerControl.this.cachingpercent = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.9
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
                    LivePlayerControl.this.playerstate = PLAYER_STATUS.PLAYER_PAUSED;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_PAUSED, 0, 0);
                            }
                        }
                    });
                    return;
                case 110:
                    LivePlayerControl.this.duration = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onDurationUpdate(LivePlayerControl.this.duration);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_STOPPED /* 111 */:
                    LivePlayerControl.this.playerstate = PLAYER_STATUS.PLAYER_STOPPED;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_STOPPED, 0, 0);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_POSITION_UPDATE /* 112 */:
                    final int i3 = message.arg1;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPositionUpdate(i3);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_COMPLETE /* 113 */:
                    LivePlayerControl.this.playerstate = PLAYER_STATUS.PLAYER_COMPLETE;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_COMPLETE, 0, 0);
                            }
                        }
                    });
                    return;
                case Constants.MEDIA_CLOSED /* 114 */:
                    System.out.println("LivePlayerControl:: closed message");
                    LivePlayerControl.this.playerstate = PLAYER_STATUS.PLAYER_IDLE;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LivePlayerControl.this.ctrlListener != null) {
                                LivePlayerControl.this.ctrlListener.onPlayStatusChanged(PLAYER_STATUS.PLAYER_IDLE, 0, 0);
                            }
                        }
                    });
                    return;
                case Constants.CMD_PLAYERCLOSE /* 32773 */:
                    LivePlayerControl.this.nativeClose();
                    return;
                case Constants.CMD_PLAYERPAUSE /* 32778 */:
                    LivePlayerControl.this.nativePause();
                    return;
                case Constants.CMD_PLAYEREXIT /* 32779 */:
                    LivePlayerControl.this.nativeExit();
                    return;
                case Constants.CMD_SETSEEKACCURATE /* 32789 */:
                    LivePlayerControl.this.nativeSeekto(message.arg1);
                    return;
                case Constants.CMD_PLAYERINIT /* 32798 */:
                    LivePlayerControl.this.nativeInitpath(0, LivePlayerControl.this.vpath, null, null);
                    return;
                case Constants.CMD_PLAYERPLAY /* 32799 */:
                    LivePlayerControl.this.nativePlay();
                    return;
                case Constants.DEBUG_MESSAGE /* 32806 */:
                    final String str = (String) message.obj;
                    LivePlayerControl.this.uihandler.post(new Runnable() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl.EventHandler.12
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

    static {
        try {
            System.loadLibrary(LiveNativeSender.AUDIOENGINE);
            System.loadLibrary(LiveNativeSender.FFMPEGLIB);
            System.loadLibrary("liveplayer");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "load library failed");
        }
    }

    public LivePlayerControl() {
        initplayer();
    }

    public static void ReceiverDebugInfo_callback(String str) {
        if (mEventHandler != null) {
            Message message = new Message();
            message.what = Constants.DEBUG_MESSAGE;
            message.obj = str;
            mEventHandler.sendMessage(message);
        }
    }

    public static void ReceiverTitle_callback(String str) {
        System.out.println("Jave LivePlayerControl   " + str);
    }

    public static int ReceiverValue_callback(int i, int i2) {
        returnvalue = i;
        switch (i) {
            case -102:
            case -101:
            case -100:
                SendHandlerMessage(-100, i, 0);
                break;
            case 1:
                System.out.println("LivePlayer------prepared");
                SendHandlerMessage(101, 0, 0);
                break;
            case 2:
                System.out.println("LivePlayer------playing");
                SendHandlerMessage(Constants.MEDIA_PLAYING, 0, 0);
                break;
            case 3:
                System.out.println("LivePlayer------paused");
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
                System.out.println("LivePlayer------DURATION_7   " + i2);
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
        }
        return 0;
    }

    private static void SendHandlerMessage(int i, int i2, int i3) {
        if (mEventHandler != null) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            mEventHandler.sendMessage(message);
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
        System.out.println("CPU architeture is " + upperCase);
        return z;
    }

    private void initplayer() {
        this.mHandlerThread = new HandlerThread("player listeners handler thread", 0);
        this.mHandlerThread.start();
        mEventHandler = new EventHandler(this, this.mHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClose();

    private native int nativeDuration();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeExit();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitpath(int i, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePlay();

    private native int nativePosition();

    private native int nativeQueryAudioStrength();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSeekto(int i);

    private native void nativeSetLogLevel(int i);

    private native int nativeSetLoginInfo(String str, String str2, String str3, String str4, String str5, String str6);

    private native int nativeSetOption(String str, String str2);

    private native void nativeTest();

    private native int nativeVideoHeight();

    private native int nativeVideoWidth();

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.vpath = null;
        this.playerstate = PLAYER_STATUS.PLAYER_IDLE;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void close() {
        SendHandlerMessage(Constants.CMD_PLAYERCLOSE, 0, 0);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void exit() {
        if (mEventHandler != null) {
            mEventHandler.removeMessages(Constants.MEDIA_POSITION_UPDATE);
        }
        this.posfrom = 0;
        SendHandlerMessage(Constants.CMD_PLAYEREXIT, 0, 0);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public int getCurrentPosition() {
        return nativePosition();
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public int getDuration() {
        return nativeDuration();
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public int getSignalStrength() {
        return nativeQueryAudioStrength();
    }

    public int getVideoHeight() {
        return nativeVideoHeight();
    }

    public int getVideoWidth() {
        return nativeVideoWidth();
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public boolean isPlaying() {
        return this.playerstate == PLAYER_STATUS.PLAYER_PLAYING;
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void pause() {
        System.out.println("LivePlayerControl  pause");
        this.playerstate = PLAYER_STATUS.PLAYER_PAUSED;
        SendHandlerMessage(Constants.CMD_PLAYERPAUSE, 0, 0);
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.VideoViewControl
    public void play() {
        System.out.println("LivePlayerControl  play  ");
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

    public int returnvalue() {
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

    public void setLogLevel(Constants.LOGLEVEL loglevel) {
        nativeSetLogLevel(loglevel.ordinal());
    }

    @Override // com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.RTMPConnControl
    public void setOption(String str, String str2) {
        nativeSetOption(str, str2);
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
        if (mEventHandler != null) {
            mEventHandler.removeMessages(Constants.MEDIA_POSITION_UPDATE);
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
        if (mEventHandler != null) {
            mEventHandler.removeMessages(Constants.MEDIA_POSITION_UPDATE);
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
        nativeTest();
    }
}
