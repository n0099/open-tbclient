package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class MediaPlayerAsync extends PlayerProvider implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener {
    public static final int EVENT_BUFFERING_UPDATE = 3;
    public static final int EVENT_DELAY_UPLOAD_STATISTICS = 100;
    public static final int EVENT_ERROR = 7;
    public static final int EVENT_INFO = 8;
    public static final int EVENT_MEDIA_SOURCE_CHANGED = 9;
    public static final int EVENT_PLAYBACK_COMPLETE = 2;
    public static final int EVENT_PREPARED = 1;
    public static final int EVENT_SEEK_COMPLETE = 4;
    public static final int EVENT_VIDEO_SIZE_CHANGED = 5;
    public static final int REQ_CHANGE_PROXY_DYNAMIC = 22;
    public static final int REQ_MUTE_OR_UNMUTE = 11;
    public static final int REQ_PAUSE = 4;
    public static final int REQ_PREPARE_ASYNC = 6;
    public static final int REQ_RELEASE = 2;
    public static final int REQ_RESET = 3;
    public static final int REQ_SEEK_TO = 7;
    public static final int REQ_SET_DATA_SOURCE_FD = 10;
    public static final int REQ_SET_DATA_SOURCE_PATH = 14;
    public static final int REQ_SET_DATA_SOURCE_PATH_HEADERS = 15;
    public static final int REQ_SET_DATA_SOURCE_URI = 12;
    public static final int REQ_SET_DATA_SOURCE_URI_HEADERS = 13;
    public static final int REQ_SET_DISPLAY = 18;
    public static final int REQ_SET_LOOPING = 19;
    public static final int REQ_SET_OPT = 24;
    public static final int REQ_SET_OPTS = 25;
    public static final int REQ_SET_SCREEN_ON_WHILE_PLAYING = 17;
    public static final int REQ_SET_SPEED = 21;
    public static final int REQ_SET_UP = 8;
    public static final int REQ_SET_VIDEO_SURFACE = 9;
    public static final int REQ_SET_VOLUME = 20;
    public static final int REQ_SET_WAKE_MODE = 16;
    public static final int REQ_START = 5;
    public static final int REQ_STOP = 1;
    public static final int REQ_UPDATE_POSITION = 23;
    public static final String TAG = "MediaPlayerAsync";
    public CyberPlayerManager.OnBufferingUpdateListener mBufferingUpdateListener;
    public CyberPlayerManager.OnCompletionListener mCompletionListener;
    public CyberPlayerManager.OnErrorListener mErrorListener;
    public EventHandler mEventHandler;
    public DuplayerHandlerThread mHandlerThread;
    public CyberPlayerManager.OnInfoListener mInfoListener;
    public boolean mIsUsedHandlerThread;
    public CyberPlayerManager.OnMediaSourceChangedListener mMediaSourceChangedListener;
    public MediaPlayerImpl mPlayer;
    public CyberPlayerManager.OnPreparedListener mPreparedListener;
    public RequestHandler mRequestHandler;
    public CyberPlayerManager.OnSeekCompleteListener mSeekCompleteListener;
    public int mVideoHeight;
    public CyberPlayerManager.OnVideoSizeChangedListener mVideoSizeChangeListener;
    public int mVideoWidth;

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void getMediaRuntimeInfo(int i, CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public String getPlayerConfigOptions() {
        return "";
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stepToNextFrame() {
    }

    /* loaded from: classes3.dex */
    public static class EventHandler extends Handler {
        public boolean mEnableHeartbeatUploadStatistics;
        public int mHeartbeatUploadCountMax;
        public int mHeartbeatUploadStatisticsPeriod;
        public final WeakReference<MediaPlayerAsync> mWeakPlayer;

        public EventHandler(MediaPlayerAsync mediaPlayerAsync, Looper looper) {
            super(looper);
            this.mEnableHeartbeatUploadStatistics = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_HEARTBEAT_UPLOAD_STATISTICS, true);
            this.mHeartbeatUploadStatisticsPeriod = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_HEARTBEAT_UPLOAD_STATISTICS_PERIOD, 3600);
            this.mHeartbeatUploadCountMax = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_HEARTBEAT_UPLOAD_COUNT_MAX, 10);
            this.mWeakPlayer = new WeakReference<>(mediaPlayerAsync);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaPlayerAsync mediaPlayerAsync = this.mWeakPlayer.get();
            if (mediaPlayerAsync == null) {
                CyberLog.e(MediaPlayerAsync.TAG, "EventHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i(MediaPlayerAsync.TAG, "EventHandler handleMessage what=" + message.what);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i != 9) {
                                            if (i != 100) {
                                                CyberLog.e(MediaPlayerAsync.TAG, "EventHandler Unknown message type=" + message.what);
                                                return;
                                            }
                                            int i2 = message.arg1;
                                            mediaPlayerAsync.mPlayer.heartBeatUploadSession(i2);
                                            int i3 = i2 + 1;
                                            Message obtainMessage = obtainMessage(100, i3, -1, null);
                                            if (i3 < this.mHeartbeatUploadCountMax) {
                                                sendMessageDelayed(obtainMessage, this.mHeartbeatUploadStatisticsPeriod * 1000);
                                                return;
                                            }
                                            return;
                                        } else if (mediaPlayerAsync.mMediaSourceChangedListener != null) {
                                            mediaPlayerAsync.mMediaSourceChangedListener.onMediaSourceChanged(message.arg1, message.arg2, null);
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (mediaPlayerAsync.mInfoListener != null) {
                                        mediaPlayerAsync.mInfoListener.onInfo(message.arg1, message.arg2, null);
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (mediaPlayerAsync.mErrorListener != null) {
                                    mediaPlayerAsync.mErrorListener.onError(message.arg1, message.arg2, null);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            mediaPlayerAsync.mVideoWidth = message.arg1;
                            mediaPlayerAsync.mVideoHeight = message.arg2;
                            if (mediaPlayerAsync.mVideoSizeChangeListener != null) {
                                mediaPlayerAsync.mVideoSizeChangeListener.onVideoSizeChanged(message.arg1, message.arg2, 1, 1);
                                return;
                            }
                            return;
                        } else if (mediaPlayerAsync.mSeekCompleteListener != null) {
                            mediaPlayerAsync.mSeekCompleteListener.onSeekComplete();
                            mediaPlayerAsync.sendEventMessage(8, 910, mediaPlayerAsync.mPlayer.getCurrentPosition(), null);
                            return;
                        } else {
                            return;
                        }
                    } else if (mediaPlayerAsync.mBufferingUpdateListener != null) {
                        mediaPlayerAsync.mBufferingUpdateListener.onBufferingUpdate(message.arg1);
                        return;
                    } else {
                        return;
                    }
                } else if (mediaPlayerAsync.mCompletionListener != null) {
                    mediaPlayerAsync.mCompletionListener.onCompletion();
                    return;
                } else {
                    return;
                }
            }
            if (mediaPlayerAsync.mPreparedListener != null) {
                mediaPlayerAsync.mPreparedListener.onPrepared();
            }
            if (this.mEnableHeartbeatUploadStatistics) {
                sendMessageDelayed(obtainMessage(100, 0, -1, null), this.mHeartbeatUploadStatisticsPeriod * 1000);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class RequestHandler extends Handler {
        public final WeakReference<MediaPlayerAsync> mWeakPlayer;

        public RequestHandler(MediaPlayerAsync mediaPlayerAsync, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(mediaPlayerAsync);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            float f;
            MediaPlayerAsync mediaPlayerAsync = this.mWeakPlayer.get();
            if (mediaPlayerAsync != null && (mediaPlayerAsync.mPlayer != null || message.what == 8)) {
                CyberLog.i(MediaPlayerAsync.TAG, "RequestHandler handleMessage what=" + message.what);
                switch (message.what) {
                    case 1:
                        mediaPlayerAsync.mPlayer.stop();
                        return;
                    case 2:
                        try {
                            mediaPlayerAsync.mPlayer.setOnPreparedListener(null);
                            mediaPlayerAsync.mPlayer.setOnCompletionListener(null);
                            mediaPlayerAsync.mPlayer.setOnBufferingUpdateListener(null);
                            mediaPlayerAsync.mPlayer.setOnSeekCompleteListener(null);
                            mediaPlayerAsync.mPlayer.setOnVideoSizeChangedListener(null);
                            mediaPlayerAsync.mPlayer.setOnErrorListener(null);
                            mediaPlayerAsync.mPlayer.setOnInfoListener(null);
                            mediaPlayerAsync.mPlayer.release();
                            mediaPlayerAsync.mPlayer = null;
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    case 3:
                        mediaPlayerAsync.mPlayer.reset();
                        return;
                    case 4:
                        mediaPlayerAsync.mPlayer.pause();
                        return;
                    case 5:
                        mediaPlayerAsync.mPlayer.start();
                        sendEmptyMessageDelayed(23, 1000L);
                        return;
                    case 6:
                        mediaPlayerAsync.mPlayer.prepareAsync();
                        return;
                    case 7:
                        if (message.obj instanceof Long) {
                            mediaPlayerAsync.mPlayer.seekTo((int) ((Long) message.obj).longValue(), message.arg1);
                            return;
                        }
                        return;
                    case 8:
                        mediaPlayerAsync.createPlayer();
                        return;
                    case 9:
                        Object obj = message.obj;
                        if (obj != null) {
                            if ((obj instanceof Surface) && ((Surface) obj).isValid()) {
                                try {
                                    mediaPlayerAsync.mPlayer.setSurface((Surface) message.obj);
                                    return;
                                } catch (Exception unused2) {
                                    CyberLog.e(MediaPlayerAsync.TAG, "setSurface exception!");
                                    return;
                                }
                            }
                            return;
                        }
                        mediaPlayerAsync.mPlayer.setSurface(null);
                        return;
                    case 10:
                        if (message.obj instanceof FileDescriptor) {
                            mediaPlayerAsync.mPlayer.setDataSource((FileDescriptor) message.obj);
                            return;
                        }
                        return;
                    case 11:
                        Object obj2 = message.obj;
                        if (obj2 instanceof Boolean) {
                            if (((Boolean) obj2).booleanValue()) {
                                f = 0.0f;
                            } else {
                                f = 1.0f;
                            }
                            mediaPlayerAsync.mPlayer.setVolume(f, f);
                            return;
                        }
                        return;
                    case 12:
                        Object obj3 = message.obj;
                        if (obj3 instanceof ArrayList) {
                            ArrayList arrayList = (ArrayList) obj3;
                            mediaPlayerAsync.mPlayer.setDataSource((Context) arrayList.get(0), (Uri) arrayList.get(1));
                            return;
                        }
                        return;
                    case 13:
                        Object obj4 = message.obj;
                        if (obj4 instanceof ArrayList) {
                            ArrayList arrayList2 = (ArrayList) obj4;
                            mediaPlayerAsync.mPlayer.setDataSource((Context) arrayList2.get(0), (Uri) arrayList2.get(1), (Map) arrayList2.get(2));
                            return;
                        }
                        return;
                    case 14:
                        if (message.obj instanceof String) {
                            mediaPlayerAsync.mPlayer.setDataSource(String.valueOf(message.obj));
                            return;
                        }
                        return;
                    case 15:
                        Object obj5 = message.obj;
                        if (obj5 instanceof ArrayList) {
                            ArrayList arrayList3 = (ArrayList) obj5;
                            try {
                                mediaPlayerAsync.mPlayer.setDataSource((String) arrayList3.get(0), (Map) arrayList3.get(1));
                                return;
                            } catch (IllegalArgumentException e) {
                                mediaPlayerAsync.sendEventMessage(7, -1004, -1004, null);
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    case 16:
                        Object obj6 = message.obj;
                        if (obj6 instanceof ArrayList) {
                            ArrayList arrayList4 = (ArrayList) obj6;
                            int intValue = ((Integer) arrayList4.get(1)).intValue();
                            mediaPlayerAsync.mPlayer.setWakeMode((Context) arrayList4.get(0), intValue);
                            return;
                        }
                        return;
                    case 17:
                        if (message.obj instanceof Boolean) {
                            mediaPlayerAsync.mPlayer.setScreenOnWhilePlaying(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 18:
                        Object obj7 = message.obj;
                        if (obj7 != null) {
                            if ((obj7 instanceof SurfaceHolder) && ((SurfaceHolder) obj7).getSurface() != null && ((SurfaceHolder) message.obj).getSurface().isValid()) {
                                try {
                                    mediaPlayerAsync.mPlayer.setDisplay((SurfaceHolder) message.obj);
                                    return;
                                } catch (Exception unused3) {
                                    CyberLog.e(MediaPlayerAsync.TAG, "setDisplay exception!");
                                    return;
                                }
                            }
                            return;
                        }
                        mediaPlayerAsync.mPlayer.setDisplay(null);
                        return;
                    case 19:
                        if (message.obj instanceof Boolean) {
                            mediaPlayerAsync.mPlayer.setLooping(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 20:
                        Object obj8 = message.obj;
                        if (obj8 instanceof ArrayList) {
                            ArrayList arrayList5 = (ArrayList) obj8;
                            mediaPlayerAsync.mPlayer.setVolume(((Float) arrayList5.get(0)).floatValue(), ((Float) arrayList5.get(1)).floatValue());
                            return;
                        }
                        return;
                    case 21:
                        Object obj9 = message.obj;
                        if (obj9 instanceof Float) {
                            mediaPlayerAsync.mPlayer.setSpeed(((Float) obj9).floatValue());
                            return;
                        }
                        return;
                    case 22:
                        Object obj10 = message.obj;
                        if (obj10 instanceof ArrayList) {
                            ArrayList arrayList6 = (ArrayList) obj10;
                            boolean booleanValue = ((Boolean) arrayList6.get(1)).booleanValue();
                            mediaPlayerAsync.mPlayer.changeProxyDynamic((String) arrayList6.get(0), booleanValue);
                            return;
                        }
                        return;
                    case 23:
                        try {
                            if (!mediaPlayerAsync.mPlayer.isPlaying()) {
                                return;
                            }
                            mediaPlayerAsync.sendEventMessage(8, 910, mediaPlayerAsync.mPlayer.getCurrentPosition(), null);
                            if (!hasMessages(23)) {
                                sendEmptyMessageDelayed(23, 1000L);
                                return;
                            }
                            return;
                        } catch (Exception unused4) {
                            CyberLog.e(MediaPlayerAsync.TAG, "REQ_UPDATE_POSITION exception!");
                            return;
                        }
                    case 24:
                        Object obj11 = message.obj;
                        if (obj11 instanceof Pair) {
                            Pair pair = (Pair) obj11;
                            mediaPlayerAsync.mPlayer.setOption((String) pair.first, (String) pair.second);
                            return;
                        }
                        return;
                    case 25:
                        Object obj12 = message.obj;
                        if (obj12 instanceof HashMap) {
                            mediaPlayerAsync.mPlayer.setOptions((HashMap) obj12);
                            return;
                        }
                        return;
                    default:
                        CyberLog.e(MediaPlayerAsync.TAG, "RequestHandler Unknown message type=" + message.what);
                        return;
                }
            }
            CyberLog.e(MediaPlayerAsync.TAG, "RequestHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
        }
    }

    public MediaPlayerAsync() {
        initPlayer();
    }

    public static PlayerProvider create() {
        MediaPlayerAsync mediaPlayerAsync = new MediaPlayerAsync();
        if (!mediaPlayerAsync.isUsedHandlerThread()) {
            mediaPlayerAsync.release();
            return null;
        }
        return mediaPlayerAsync;
    }

    private synchronized void quitRequestHandlerThread() {
        CyberLog.i(TAG, "quitRequestHandlerThread");
        if (this.mIsUsedHandlerThread) {
            DuplayerHandlerThreadPool.getInstance().recycle(this.mHandlerThread);
            this.mHandlerThread = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl != null) {
            return mediaPlayerImpl.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl != null) {
            return mediaPlayerImpl.getCurrentPositionSync();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl != null) {
            return mediaPlayerImpl.getDownloadSpeed();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl != null) {
            return mediaPlayerImpl.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl != null) {
            return mediaPlayerImpl.getPlayedTime();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isFirstDisp() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl == null) {
            return false;
        }
        return mediaPlayerImpl.isFirstDisp();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl != null && mediaPlayerImpl.isLooping()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        MediaPlayerImpl mediaPlayerImpl = this.mPlayer;
        if (mediaPlayerImpl != null && mediaPlayerImpl.isPlaying()) {
            return true;
        }
        return false;
    }

    public boolean isUsedHandlerThread() {
        if (this.mIsUsedHandlerThread && this.mRequestHandler != null && this.mHandlerThread != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        sendEmptyEventMessage(2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        sendEmptyEventMessage(1);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        sendEmptyEventMessage(4);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        sendEmptyRequestMessage(4);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        sendEmptyRequestMessage(6);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        RequestHandler requestHandler = this.mRequestHandler;
        if (requestHandler != null) {
            requestHandler.removeCallbacksAndMessages(null);
        }
        this.mEventHandler.removeCallbacksAndMessages(null);
        sendEmptyRequestMessage(2);
        quitRequestHandlerThread();
        this.mRequestHandler = null;
        this.mPreparedListener = null;
        this.mCompletionListener = null;
        this.mBufferingUpdateListener = null;
        this.mSeekCompleteListener = null;
        this.mVideoSizeChangeListener = null;
        this.mErrorListener = null;
        this.mInfoListener = null;
        this.mMediaSourceChangedListener = null;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        RequestHandler requestHandler = this.mRequestHandler;
        if (requestHandler != null) {
            requestHandler.removeCallbacksAndMessages(null);
        }
        this.mEventHandler.removeCallbacksAndMessages(null);
        sendEmptyRequestMessage(3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        sendEmptyRequestMessage(5);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        sendEmptyRequestMessage(1);
    }

    private ArrayList<Object> getArrayListParams(Object... objArr) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    private boolean sendEmptyEventMessage(int i) {
        if (this.mIsUsedHandlerThread) {
            EventHandler eventHandler = this.mEventHandler;
            if (eventHandler != null) {
                eventHandler.sendEmptyMessage(i);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean sendEmptyRequestMessage(int i) {
        if (this.mIsUsedHandlerThread) {
            RequestHandler requestHandler = this.mRequestHandler;
            if (requestHandler != null) {
                requestHandler.sendEmptyMessage(i);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        sendRequestMessage(11, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        sendEventMessage(3, i, -1, null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        sendRequestMessage(10, -1, -1, fileDescriptor);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        sendRequestMessage(18, -1, -1, surfaceHolder);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        sendRequestMessage(19, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mErrorListener = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mInfoListener = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.mMediaSourceChangedListener = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mPreparedListener = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mVideoSizeChangeListener = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOptions(Map<String, String> map) {
        super.setOptions(map);
        sendRequestMessage(25, -1, -1, map);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        sendRequestMessage(17, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        sendRequestMessage(21, -1, -1, Float.valueOf(f));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        sendRequestMessage(9, 0, 0, surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        sendRequestMessage(22, -1, -1, getArrayListParams(str, Boolean.valueOf(z)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        sendRequestMessage(7, i, -1, Long.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        sendRequestMessage(12, -1, -1, getArrayListParams(context, uri));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        super.setOption(str, str2);
        sendRequestMessage(24, -1, -1, new Pair(str, str2));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        sendRequestMessage(20, -1, -1, getArrayListParams(Float.valueOf(f), Float.valueOf(f2)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        sendRequestMessage(16, -1, -1, getArrayListParams(context, Integer.valueOf(i)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        if (this.mMediaSourceChangedListener != null) {
            if (mediaSourceSwitchMode == CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE) {
                sendEventMessage(9, 0, i, null);
            } else {
                sendEventMessage(9, -100, i, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void createPlayer() {
        this.mPlayer = new MediaPlayerImpl();
        CyberLog.i(TAG, "createPlayer mPlayer=" + this.mPlayer);
        this.mPlayer.setOnPreparedListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnBufferingUpdateListener(this);
        this.mPlayer.setOnSeekCompleteListener(this);
        this.mPlayer.setOnVideoSizeChangedListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnInfoListener(this);
    }

    private void initPlayer() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        this.mIsUsedHandlerThread = false;
        if (Utils.isMainProcess() && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            CyberLog.i(TAG, "initPlayer, don't use request handler. thread:" + Thread.currentThread().getName());
            this.mRequestHandler = null;
        } else {
            this.mHandlerThread = DuplayerHandlerThreadPool.getInstance().obtain();
            this.mRequestHandler = new RequestHandler(this, this.mHandlerThread.getLooper());
            CyberLog.i(TAG, "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.mHandlerThread.getName() + " mRequestHandler:" + this.mRequestHandler);
            this.mIsUsedHandlerThread = true;
        }
        sendEmptyRequestMessage(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendEventMessage(int i, int i2, int i3, Object obj) {
        if (this.mIsUsedHandlerThread) {
            EventHandler eventHandler = this.mEventHandler;
            if (eventHandler != null) {
                this.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj));
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean sendRequestMessage(int i, int i2, int i3, Object obj) {
        if (this.mIsUsedHandlerThread) {
            RequestHandler requestHandler = this.mRequestHandler;
            if (requestHandler != null) {
                this.mRequestHandler.sendMessage(requestHandler.obtainMessage(i, i2, i3, obj));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        sendEventMessage(5, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        try {
            if (this.mPlayer != null) {
                this.mPlayer.sendCommand(i, i2, j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        return sendEventMessage(7, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        return sendEventMessage(8, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        sendRequestMessage(13, -1, -1, getArrayListParams(context, uri, map));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        sendRequestMessage(14, -1, -1, str);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        sendRequestMessage(15, -1, -1, getArrayListParams(str, map));
    }
}
