package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberClientInfoManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberRenderView;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.debug.DebugConfigManager;
import com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, ICyberVideoView, CyberPlayerManager.InstallListener {
    public static final int FILTER_MASK = 65280;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final String TAG = "CyberVideoView";
    public static boolean sIsFirstPlay;
    public String mClarityInfo;
    public CyberClientInfoManager mClientInfoManager;
    public Context mContext;
    public int mCurrentState;
    public CyberPlayer mCyberPlayer;
    public ICyberRenderView mCyberRenderView;
    public ICyberRenderView.ICyberSurfaceListener mCyberSurfaceListener;
    public int mDecodeMode;
    public WeakReference<Surface> mExternalSurface;
    public final int mFilterType;
    public Map<String, String> mHeaders;
    public CyberPlayerManager.HttpDNS mHttpDns;
    public boolean mIsAudioMuted;
    public boolean mIsLooping;
    public boolean mIsNeedMediacodecConfigRetry;
    public boolean mIsSwitchFromMediaPlayer;
    public String mJson;
    public CyberPlayerManager.MediaSourceSwitchMode mMediaSourceSwitchMode;
    public MediaPlayerReduceHelper mMpReduceHelper;
    public CyberPlayerManager.OnBufferingUpdateListener mOnBufferingUpdateListener;
    public CyberPlayerManager.OnCompletionListener mOnCompletionListener;
    public CyberPlayerManager.OnErrorListener mOnErrorListener;
    public CyberPlayerManager.OnInfoListener mOnInfoListener;
    public CyberPlayerManager.OnMediaSourceChangedListener mOnMediaSourceChangedListener;
    public CyberPlayerManager.OnPreparedListener mOnPreparedListener;
    public CyberPlayerManager.OnSeekCompleteListener mOnSeekCompleteListener;
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> mOnSnapShotCompleteListenerList;
    public CyberPlayerManager.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    public long mOpenVideoBeginTime;
    public HashMap<String, String> mOptions;
    public boolean mRemote;
    public final int mRenderType;
    public int mSeekMode;
    public int mSeekWhenPrepared;
    public float mSpeed;
    public Surface mSurface;
    public int mSwitchSourceWhenPrepared;
    public int mTargetState;
    public Uri mUri;
    public int mVideoHeight;
    public int mVideoWidth;

    private int ensureRenderType(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            return i;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
    public void onInstallError(int i, int i2, String str) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
    public void onInstallProgress(int i, int i2) {
    }

    public CyberVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean isPlayerNeedRelease(CyberPlayer cyberPlayer) {
        if (cyberPlayer != null) {
            int decodeMode = cyberPlayer.getDecodeMode();
            if (decodeMode == 4) {
                CyberLog.i(TAG, "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!");
                return true;
            } else if (decodeMode == 1) {
                CyberLog.i(TAG, "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SW!");
                return true;
            } else if (this.mRemote && !cyberPlayer.isRemotePlayer()) {
                CyberLog.i(TAG, "handlerLastPlay isPlayerNeedRelease mainprocess !");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void debugShowOptions(View view2) {
        CyberPlayer cyberPlayer;
        Context context = this.mContext;
        if (context != null && (cyberPlayer = this.mCyberPlayer) != null) {
            DebugConfigManager.showPlayerConfigOptions(this, context, cyberPlayer);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        getMediaRuntimeInfo(100, onMediaRuntimeInfoListener);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        if (this.mCyberPlayer != null) {
            if (isInPlaybackState()) {
                this.mCyberPlayer.seekTo(i);
            } else {
                this.mSeekWhenPrepared = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.mCyberPlayer;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
                return;
            } else {
                this.mClarityInfo = str;
                return;
            }
        }
        CyberLog.w(TAG, "setClarityInfo is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.mDecodeMode = i;
        if (Build.VERSION.SDK_INT < 21 && i == 2) {
            this.mDecodeMode = 1;
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.mHttpDns = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.mIsLooping = z;
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.mOnMediaSourceChangedListener = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.mCyberPlayer;
            if (cyberPlayer != null) {
                cyberPlayer.setPlayJson(str);
                return;
            } else {
                this.mJson = str;
                return;
            }
        }
        CyberLog.w(TAG, "setPlayJson is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.mRemote = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        CyberLog.i(TAG, "setSpeed()");
        this.mSpeed = f;
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f);
        } else {
            CyberLog.i(TAG, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null) {
            iCyberRenderView.setClientRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null) {
            iCyberRenderView.setDisplayMode(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setZOrderMediaOverlay(boolean z) {
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null) {
            iCyberRenderView.setZOrderMediaOverlay(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode;
        if (isInPlaybackState()) {
            this.mCyberPlayer.switchMediaSource(i);
            return;
        }
        this.mSwitchSourceWhenPrepared = i;
        if (i == -1) {
            mediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE;
        } else {
            mediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_FORCE_MODE;
        }
        this.mMediaSourceSwitchMode = mediaSourceSwitchMode;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0);
    }

    public CyberVideoView(Context context, int i) {
        this(context, null, i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(int i, CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.getMediaRuntimeInfo(i, onMediaRuntimeInfoListener);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i, int i2) {
        if (this.mCyberPlayer != null) {
            if (isInPlaybackState()) {
                this.mCyberPlayer.seekTo(i, i2);
                return;
            }
            this.mSeekMode = i2;
            this.mSeekWhenPrepared = i;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.mClientInfoManager.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        setVideoURI(uri, map, null);
    }

    public void setVolume(float f, float f2) {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.setVolume(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        if (isInPlaybackState()) {
            this.mCyberPlayer.switchMediaSource(i, mediaSourceSwitchMode);
            return;
        }
        this.mSwitchSourceWhenPrepared = i;
        this.mMediaSourceSwitchMode = mediaSourceSwitchMode;
    }

    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSeekMode = 3;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mOptions = new HashMap<>();
        this.mDecodeMode = 0;
        this.mRemote = true;
        this.mSpeed = 1.0f;
        this.mOpenVideoBeginTime = 0L;
        this.mIsNeedMediacodecConfigRetry = false;
        this.mJson = null;
        this.mClarityInfo = null;
        this.mSurface = null;
        this.mExternalSurface = null;
        this.mMpReduceHelper = null;
        this.mIsSwitchFromMediaPlayer = false;
        this.mCyberSurfaceListener = new ICyberRenderView.ICyberSurfaceListener() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceDestroyed(int i) {
                CyberLog.d(CyberVideoView.TAG, "onSurfaceDestroyed renderType:" + i);
                if ((i == 2 || i == 3) && CyberVideoView.this.mCyberPlayer != null) {
                    CyberVideoView.this.mCyberPlayer.setSurface(null);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSnapShotComplete(final int i, final int i2, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap rotateBitmap = Utils.rotateBitmap(createBitmap);
                            CyberLog.d(CyberVideoView.TAG, "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.mOnSnapShotCompleteListenerList) {
                                for (int i3 = 0; i3 < CyberVideoView.this.mOnSnapShotCompleteListenerList.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.mOnSnapShotCompleteListenerList.get(i3)).onSnapShotComplete(rotateBitmap);
                                }
                                CyberVideoView.this.mOnSnapShotCompleteListenerList.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceChanged(int i, int i2) {
                if (CyberVideoView.this.mCyberPlayer != null) {
                    try {
                        CyberVideoView.this.mCyberPlayer.updateDisplaySize(i, i2);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceFirstFrameDrawed(final long j) {
                if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JUDGE_THREAD_ON_FIRST_FRAME, false) && Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    CyberVideoView.this.onFirstFrameDrawed(j);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CyberVideoView.this.onFirstFrameDrawed(j);
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public boolean onSurfaceReady(int i) {
                Surface createNewSurface;
                CyberLog.d(CyberVideoView.TAG, "onSurfaceReady renderType:" + i);
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.mCyberPlayer != null && CyberVideoView.this.mCyberRenderView != null && (createNewSurface = CyberVideoView.this.mCyberRenderView.createNewSurface()) != null) {
                            CyberVideoView.this.mCyberPlayer.setSurface(createNewSurface);
                        }
                        return true;
                    }
                    return false;
                } else if (i == 1) {
                    if (CyberVideoView.this.mCyberPlayer != null && CyberVideoView.this.mCyberRenderView != null) {
                        Surface createNewSurface2 = CyberVideoView.this.mCyberRenderView.createNewSurface();
                        CyberVideoView.this.mSurface = createNewSurface2;
                        CyberLog.d(CyberVideoView.TAG, "onSurfaceReady s:" + createNewSurface2);
                        if (CyberVideoView.this.mExternalSurface != null && CyberVideoView.this.mExternalSurface.get() != null) {
                            CyberLog.d(CyberVideoView.TAG, "use external surface, do nothing!!!");
                            return false;
                        } else if (createNewSurface2 != null) {
                            CyberVideoView.this.mCyberPlayer.setSurface(createNewSurface2);
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return false;
                } else if ((i == 2 || i == 3) && CyberVideoView.this.mCyberPlayer != null && CyberVideoView.this.mCyberRenderView != null) {
                    Surface createNewSurface3 = CyberVideoView.this.mCyberRenderView.createNewSurface();
                    CyberLog.d(CyberVideoView.TAG, "onSurfaceReady s:" + createNewSurface3);
                    if (createNewSurface3 != null) {
                        CyberLog.d(CyberVideoView.TAG, "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.mCyberPlayer);
                        CyberVideoView.this.mCyberPlayer.setSurface(createNewSurface3);
                        return false;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        };
        this.mFilterType = 0;
        this.mRenderType = 0;
        CyberLog.d(TAG, "CyberVideoView mRenderType:" + this.mRenderType);
        this.mContext = context.getApplicationContext();
        this.mClientInfoManager = new CyberClientInfoManager();
        this.mOnSnapShotCompleteListenerList = new ArrayList<>();
        reset();
        initVideoView();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mSeekMode = 3;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mOptions = new HashMap<>();
        this.mDecodeMode = 0;
        this.mRemote = true;
        this.mSpeed = 1.0f;
        this.mOpenVideoBeginTime = 0L;
        this.mIsNeedMediacodecConfigRetry = false;
        this.mJson = null;
        this.mClarityInfo = null;
        this.mSurface = null;
        this.mExternalSurface = null;
        this.mMpReduceHelper = null;
        this.mIsSwitchFromMediaPlayer = false;
        this.mCyberSurfaceListener = new ICyberRenderView.ICyberSurfaceListener() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceDestroyed(int i2) {
                CyberLog.d(CyberVideoView.TAG, "onSurfaceDestroyed renderType:" + i2);
                if ((i2 == 2 || i2 == 3) && CyberVideoView.this.mCyberPlayer != null) {
                    CyberVideoView.this.mCyberPlayer.setSurface(null);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSnapShotComplete(final int i2, final int i22, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i22, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap rotateBitmap = Utils.rotateBitmap(createBitmap);
                            CyberLog.d(CyberVideoView.TAG, "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.mOnSnapShotCompleteListenerList) {
                                for (int i3 = 0; i3 < CyberVideoView.this.mOnSnapShotCompleteListenerList.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.mOnSnapShotCompleteListenerList.get(i3)).onSnapShotComplete(rotateBitmap);
                                }
                                CyberVideoView.this.mOnSnapShotCompleteListenerList.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceChanged(int i2, int i22) {
                if (CyberVideoView.this.mCyberPlayer != null) {
                    try {
                        CyberVideoView.this.mCyberPlayer.updateDisplaySize(i2, i22);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public void onSurfaceFirstFrameDrawed(final long j) {
                if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JUDGE_THREAD_ON_FIRST_FRAME, false) && Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    CyberVideoView.this.onFirstFrameDrawed(j);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CyberVideoView.this.onFirstFrameDrawed(j);
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.ICyberRenderView.ICyberSurfaceListener
            public boolean onSurfaceReady(int i2) {
                Surface createNewSurface;
                CyberLog.d(CyberVideoView.TAG, "onSurfaceReady renderType:" + i2);
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.mCyberPlayer != null && CyberVideoView.this.mCyberRenderView != null && (createNewSurface = CyberVideoView.this.mCyberRenderView.createNewSurface()) != null) {
                            CyberVideoView.this.mCyberPlayer.setSurface(createNewSurface);
                        }
                        return true;
                    }
                    return false;
                } else if (i2 == 1) {
                    if (CyberVideoView.this.mCyberPlayer != null && CyberVideoView.this.mCyberRenderView != null) {
                        Surface createNewSurface2 = CyberVideoView.this.mCyberRenderView.createNewSurface();
                        CyberVideoView.this.mSurface = createNewSurface2;
                        CyberLog.d(CyberVideoView.TAG, "onSurfaceReady s:" + createNewSurface2);
                        if (CyberVideoView.this.mExternalSurface != null && CyberVideoView.this.mExternalSurface.get() != null) {
                            CyberLog.d(CyberVideoView.TAG, "use external surface, do nothing!!!");
                            return false;
                        } else if (createNewSurface2 != null) {
                            CyberVideoView.this.mCyberPlayer.setSurface(createNewSurface2);
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return false;
                } else if ((i2 == 2 || i2 == 3) && CyberVideoView.this.mCyberPlayer != null && CyberVideoView.this.mCyberRenderView != null) {
                    Surface createNewSurface3 = CyberVideoView.this.mCyberRenderView.createNewSurface();
                    CyberLog.d(CyberVideoView.TAG, "onSurfaceReady s:" + createNewSurface3);
                    if (createNewSurface3 != null) {
                        CyberLog.d(CyberVideoView.TAG, "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.mCyberPlayer);
                        CyberVideoView.this.mCyberPlayer.setSurface(createNewSurface3);
                        return false;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        };
        this.mFilterType = 65280 & i;
        this.mRenderType = ensureRenderType((-65281) & i);
        this.mContext = context.getApplicationContext();
        this.mClientInfoManager = new CyberClientInfoManager();
        this.mOnSnapShotCompleteListenerList = new ArrayList<>();
        reset();
        initVideoView();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map, Map<String, String> map2) {
        Uri uri2 = this.mUri;
        boolean z = false;
        if (uri2 != null && uri != null && uri2.equals(uri) && CyberCfgManager.getInstance().getCfgBoolValue("enable_same_uri_check", false)) {
            CyberLog.i(TAG, "set same videoURI");
            return;
        }
        if (map2 != null) {
            this.mOptions.putAll(map2);
        }
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = -1;
        if (CyberCfgManager.getInstance().getCfgIntValue("set_video_uri_optimize", 1) == 1) {
            z = true;
        }
        if (z) {
            openVideoOptimize();
        } else {
            this.mOptions.remove(CyberPlayerManager.OPT_MPD_CONTENT);
            this.mOptions.remove(CyberPlayerManager.OPT_MPD_CLARITY);
            this.mOptions.remove(CyberPlayerManager.OPT_MPD_AUTO);
            openVideo();
        }
        requestLayout();
        invalidate();
    }

    private void handlerLastPlay() {
        this.mIsNeedMediacodecConfigRetry = false;
        if (this.mCyberPlayer != null) {
            if (this.mRenderType == 1 && CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_TEXTUREVIEW_PLAYER_REUSE, false) && !isPlayerNeedRelease(this.mCyberPlayer)) {
                resetLastPlayer();
                CyberLog.i(TAG, "handlerLastPlay called reset last player");
            } else {
                releaseLastPlayer();
                CyberLog.i(TAG, "handlerLastPlay called release last player");
                if (this.mRenderType == 1) {
                    this.mIsNeedMediacodecConfigRetry = true;
                }
            }
        }
        releaseLastSurface();
    }

    private void updateExternalInfoToPlayer() {
        ArrayList<CyberClientInfoManager.VideoClientInfoItem> itemsList;
        if (this.mCyberPlayer != null && (itemsList = this.mClientInfoManager.getItemsList()) != null) {
            int size = itemsList.size();
            for (int i = 0; i < size; i++) {
                CyberClientInfoManager.VideoClientInfoItem videoClientInfoItem = itemsList.get(i);
                if (videoClientInfoItem != null && videoClientInfoItem.getKey() != null) {
                    this.mCyberPlayer.setExternalInfo(videoClientInfoItem.getKey(), videoClientInfoItem.getData());
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        CyberLog.i(TAG, "start mCyberPlayer:" + this.mCyberPlayer + " mCurrentState:" + this.mCurrentState);
        if (isInPlaybackState()) {
            this.mCyberPlayer.start();
            this.mCurrentState = 3;
        } else {
            CyberPlayer cyberPlayer = this.mCyberPlayer;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.mTargetState = 3;
    }

    private void initVideoView() {
        if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_VIDEOVIEW_AUTO_REQUEST_FOCUS, false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        int i = this.mRenderType;
        if (i == 0) {
            if (this.mFilterType > 0 && CyberCfgManager.getInstance().getCfgBoolValueFast("videoview_ebable_filter", true)) {
                this.mCyberRenderView = new CyberGlSurfaceView(this.mContext, this.mFilterType);
            } else {
                this.mCyberRenderView = new CyberGlSurfaceView(this.mContext);
            }
        } else if (i == 1) {
            this.mCyberRenderView = new CyberTextureView(this.mContext);
            if (Build.VERSION.SDK_INT < 21) {
                setDecodeMode(1);
            }
        } else if (i != 2 && i != 3) {
            if (i == 4) {
                if (this.mFilterType > 0 && CyberCfgManager.getInstance().getCfgBoolValueFast("videoview_ebable_filter", true)) {
                    this.mCyberRenderView = new CyberGLTextureView(this.mContext, this.mFilterType);
                } else {
                    this.mCyberRenderView = new CyberGLTextureView(this.mContext);
                }
            }
        } else {
            this.mCyberRenderView = new CyberSurfaceView(this.mContext);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.mCyberRenderView.setCyberSurfaceListener(this.mCyberSurfaceListener);
        this.mCyberRenderView.getView().setLayoutParams(layoutParams);
        addView(this.mCyberRenderView.getView());
        CyberLog.d(TAG, "initVideoView mCyberRenderView:" + this.mCyberRenderView);
    }

    private boolean isInPlaybackState() {
        int i;
        if (this.mCyberPlayer != null && (i = this.mCurrentState) != -1 && i != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private boolean isPlayerReady() {
        int i;
        if (this.mCyberPlayer != null && (i = this.mCurrentState) != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private void releaseLastPlayer() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.mCyberPlayer.reset();
            }
            this.mCyberPlayer.release();
            this.mCyberPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
        }
    }

    private void releaseLastSurface() {
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null) {
            iCyberRenderView.release();
        }
    }

    private void resetLastPlayer() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            if (this.mCurrentState != -1) {
                cyberPlayer.reset();
            } else {
                cyberPlayer.release();
                this.mCyberPlayer = null;
            }
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.mCyberPlayer;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            return cyberPlayer.getDecodeMode();
        }
        return this.mDecodeMode;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null && this.mCurrentState != 0) {
            return cyberPlayer.getDownloadSpeed();
        }
        return -1L;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public MediaInfo getMediaInfo() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer == null) {
            return null;
        }
        return cyberPlayer.getMediaInfo();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (isPlayerReady()) {
            return this.mCyberPlayer.getPlayedTime();
        }
        return -1L;
    }

    public ICyberRenderView getRenderView() {
        return this.mCyberRenderView;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        if (isInPlaybackState() && this.mCurrentState == 3) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.mCurrentState = 5;
        this.mTargetState = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stepToNextFrame() {
        if (this.mCyberPlayer != null) {
            if (this.mCurrentState == 3) {
                pause();
            }
            this.mCyberPlayer.stepToNextFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirstFrameDrawed(long j) {
        CyberPlayer cyberPlayer;
        if (Build.VERSION.SDK_INT <= 16 && (cyberPlayer = this.mCyberPlayer) != null && cyberPlayer.getDecodeMode() == 4) {
            this.mCyberPlayer.sendCommand(1002, 0, j, null);
        }
        if (this.mCyberPlayer != null) {
            long j2 = this.mOpenVideoBeginTime;
            if (j2 > 0) {
                long j3 = j - j2;
                setStatisticInfoInternal(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, "surface_drawed", "" + j3);
            }
        }
        if (this.mFilterType > 0) {
            setStatisticInfoInternal(20488, "filter", "" + this.mFilterType);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        String str2;
        if (this.mCyberPlayer == null || !TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
            return;
        }
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            str2 = hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY);
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(str2)) {
                return;
            }
            this.mCyberPlayer.changeProxyDynamic(str, true);
        } else if (TextUtils.isEmpty(str2)) {
            return;
        } else {
            this.mCyberPlayer.changeProxyDynamic(null, false);
        }
        this.mCyberPlayer.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
        HashMap<String, String> hashMap2 = this.mOptions;
        if (hashMap2 != null) {
            hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
        }
    }

    private boolean onHDRInfo(int i) {
        int i2 = 0;
        if (this.mOnInfoListener == null) {
            return false;
        }
        boolean z = true;
        if (i > 0) {
            int i3 = this.mRenderType;
            if (i3 != 2 && i3 != 3) {
                i2 = 11016;
            } else if (CyberPlayerManager.getDeviceHDRSupported(i, this.mVideoWidth, this.mVideoHeight) <= 0) {
                i2 = 11014;
            }
            z = this.mOnInfoListener.onInfo(11011, i, 0);
        } else {
            int i4 = this.mRenderType;
            if (i4 == 2 || i4 == 3) {
                i2 = 11013;
            }
        }
        if (i2 != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20488");
            hashMap.put("hdr_warnning_msg", "" + i2);
            this.mCyberPlayer.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.mOnInfoListener.onInfo(i2, i, 0);
        }
        return z;
    }

    private void openVideo() {
        if (this.mUri == null) {
            return;
        }
        this.mOpenVideoBeginTime = System.currentTimeMillis();
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_OPEN_VIDEO);
        PlayerConfigManager.startRequestPlayerServerCfg();
        handlerLastPlay();
        try {
            if (this.mCyberPlayer == null) {
                CyberPlayer cyberPlayer = new CyberPlayer(this.mDecodeMode, this.mHttpDns, this.mRemote);
                this.mCyberPlayer = cyberPlayer;
                if (this.mMpReduceHelper == null && cyberPlayer.isMediaPlayer() && MediaPlayerReduceHelper.isMpReduceEnable()) {
                    this.mMpReduceHelper = new MediaPlayerReduceHelper();
                    CyberLog.d(TAG, "MpReduce, addCyberCoreInstallObserver.");
                    CyberCoreLoaderManager.getInstance().addCyberCoreInstallObserver(CyberPlayerManager.getInstallType(), this);
                }
            }
            this.mCyberPlayer.setOnPreparedListener(this);
            this.mCyberPlayer.setOnCompletionListener(this);
            this.mCyberPlayer.setOnVideoSizeChangedListener(this);
            this.mCyberPlayer.setOnSeekCompleteListener(this);
            this.mCyberPlayer.setOnBufferingUpdateListener(this);
            this.mCyberPlayer.setOnErrorListener(this);
            this.mCyberPlayer.setOnInfoListener(this);
            this.mCyberPlayer.setOnMediaSourceChangedListener(this);
            if (this.mJson != null) {
                this.mCyberPlayer.setPlayJson(this.mJson);
            }
            if (this.mClarityInfo != null) {
                this.mCyberPlayer.setClarityInfo(this.mClarityInfo);
            }
            if (this.mOptions != null) {
                for (String str : this.mOptions.keySet()) {
                    this.mCyberPlayer.setOption(str, this.mOptions.get(str));
                }
            }
            CyberPlayer cyberPlayer2 = this.mCyberPlayer;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.mOpenVideoBeginTime);
            if (this.mIsNeedMediacodecConfigRetry) {
                this.mCyberPlayer.setOption("mediacodec-config-need-retry", 1L);
            }
            if (this.mRenderType == 2 || this.mRenderType == 3) {
                this.mCyberPlayer.setOption("mediacodec-surface-update", 1L);
                this.mCyberPlayer.setOption("mediacodec-auto-rotate", 1L);
            }
            this.mCyberPlayer.setDataSource(this.mContext, this.mUri, this.mHeaders);
            this.mCyberPlayer.prepareAsync();
            if (this.mMpReduceHelper != null && this.mCyberPlayer.isMediaPlayer()) {
                this.mMpReduceHelper.setMediaPlayerPrepareTs(System.currentTimeMillis());
            }
            this.mCurrentState = 1;
            if (this.mCyberRenderView != null) {
                Surface createNewSurface = this.mCyberRenderView.createNewSurface();
                this.mSurface = createNewSurface;
                CyberLog.d(TAG, "openVideo s:" + createNewSurface + " mCyberPlayer:" + this.mCyberPlayer);
                if (this.mExternalSurface != null && this.mExternalSurface.get() != null) {
                    CyberLog.d(TAG, "ExternalSurface:" + this.mExternalSurface.get() + " isValid:" + this.mExternalSurface.get().isValid());
                    this.mCyberPlayer.setSurface(this.mExternalSurface.get());
                } else if (createNewSurface != null) {
                    this.mCyberPlayer.setSurface(createNewSurface);
                }
            }
            this.mCyberPlayer.setScreenOnWhilePlaying(true);
            if (this.mIsAudioMuted) {
                this.mCyberPlayer.muteOrUnmuteAudio(this.mIsAudioMuted);
            }
            if (this.mSpeed != 1.0f) {
                this.mCyberPlayer.setSpeed(this.mSpeed);
            }
            if (this.mIsLooping) {
                this.mCyberPlayer.setLooping(this.mIsLooping);
            }
            if (!sIsFirstPlay) {
                sIsFirstPlay = true;
                setStatisticInfoInternal(0, "is_first_play", "1");
            }
            updateExternalInfoToPlayer();
        } catch (Exception e) {
            e.printStackTrace();
            int i = -111;
            if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JAVA_ERROR_CODE_MAPPING, true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(-111);
            }
            onError(i, 0, null);
        }
    }

    private void openVideoOptimize() {
        if (this.mUri == null) {
            return;
        }
        this.mOpenVideoBeginTime = System.currentTimeMillis();
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_OPEN_VIDEO);
        PlayerConfigManager.startRequestPlayerServerCfg();
        handlerLastPlay();
        HashMap hashMap = new HashMap();
        try {
            if (this.mCyberPlayer == null) {
                CyberPlayer cyberPlayer = new CyberPlayer(this.mDecodeMode, this.mHttpDns, this.mRemote);
                this.mCyberPlayer = cyberPlayer;
                if (this.mMpReduceHelper == null && cyberPlayer.isMediaPlayer() && MediaPlayerReduceHelper.isMpReduceEnable()) {
                    this.mMpReduceHelper = new MediaPlayerReduceHelper();
                    CyberLog.d(TAG, "MpReduce, addCyberCoreInstallObserver.");
                    CyberCoreLoaderManager.getInstance().addCyberCoreInstallObserver(CyberPlayerManager.getInstallType(), this);
                }
            }
            this.mCyberPlayer.setOnPreparedListener(this);
            this.mCyberPlayer.setOnCompletionListener(this);
            this.mCyberPlayer.setOnVideoSizeChangedListener(this);
            this.mCyberPlayer.setOnSeekCompleteListener(this);
            this.mCyberPlayer.setOnBufferingUpdateListener(this);
            this.mCyberPlayer.setOnErrorListener(this);
            this.mCyberPlayer.setOnInfoListener(this);
            this.mCyberPlayer.setOnMediaSourceChangedListener(this);
            if (this.mJson != null) {
                this.mCyberPlayer.setPlayJson(this.mJson);
            }
            if (this.mClarityInfo != null) {
                this.mCyberPlayer.setClarityInfo(this.mClarityInfo);
            }
            if (this.mOptions != null) {
                for (String str : this.mOptions.keySet()) {
                    hashMap.put(str, this.mOptions.get(str));
                }
            }
            hashMap.put(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.mOpenVideoBeginTime);
            if (this.mIsNeedMediacodecConfigRetry) {
                hashMap.put("mediacodec-config-need-retry", String.valueOf(1));
            }
            if (this.mRenderType == 2 || this.mRenderType == 3) {
                hashMap.put("mediacodec-surface-update", String.valueOf(1));
                hashMap.put("mediacodec-auto-rotate", String.valueOf(1));
            }
            this.mCyberPlayer.setOptions(hashMap);
            this.mCyberPlayer.setDataSource(this.mContext, this.mUri, this.mHeaders);
            this.mCyberPlayer.prepareAsync();
            if (this.mMpReduceHelper != null && this.mCyberPlayer.isMediaPlayer()) {
                this.mMpReduceHelper.setMediaPlayerPrepareTs(System.currentTimeMillis());
            }
            this.mCurrentState = 1;
            if (this.mCyberRenderView != null) {
                Surface createNewSurface = this.mCyberRenderView.createNewSurface();
                this.mSurface = createNewSurface;
                CyberLog.d(TAG, "openVideo s:" + createNewSurface + " mCyberPlayer:" + this.mCyberPlayer);
                if (this.mExternalSurface != null && this.mExternalSurface.get() != null) {
                    CyberLog.d(TAG, "ExternalSurface:" + this.mExternalSurface.get() + " isValid:" + this.mExternalSurface.get().isValid());
                    this.mCyberPlayer.setSurface(this.mExternalSurface.get());
                } else if (createNewSurface != null) {
                    this.mCyberPlayer.setSurface(createNewSurface);
                }
            }
            this.mCyberPlayer.setScreenOnWhilePlaying(true);
            if (this.mIsAudioMuted) {
                this.mCyberPlayer.muteOrUnmuteAudio(this.mIsAudioMuted);
            }
            if (this.mSpeed != 1.0f) {
                this.mCyberPlayer.setSpeed(this.mSpeed);
            }
            if (this.mIsLooping) {
                this.mCyberPlayer.setLooping(this.mIsLooping);
            }
            if (!sIsFirstPlay) {
                sIsFirstPlay = true;
                setStatisticInfoInternal(0, "is_first_play", "1");
            }
            updateExternalInfoToPlayer();
        } catch (Exception unused) {
            int i = -111;
            if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JAVA_ERROR_CODE_MAPPING, true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(-111);
            }
            onError(i, 0, null);
        }
    }

    private void setStatisticInfoInternal(int i, String str, String str2) {
        if (this.mCyberPlayer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "" + i);
        hashMap.put(str, str2);
        this.mCyberPlayer.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.mOnMediaSourceChangedListener;
        if (onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i(TAG, "destory called");
        releaseLastPlayer();
        if (MediaPlayerReduceHelper.isMpReduceEnable()) {
            CyberCoreLoaderManager.getInstance().removeCyberCoreInstallObserver(this);
        }
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
            this.mOptions = null;
        }
        CyberClientInfoManager cyberClientInfoManager = this.mClientInfoManager;
        if (cyberClientInfoManager != null) {
            cyberClientInfoManager.clear();
            this.mClientInfoManager = null;
        }
        synchronized (this.mOnSnapShotCompleteListenerList) {
            if (this.mOnSnapShotCompleteListenerList != null) {
                this.mOnSnapShotCompleteListenerList.clear();
            }
        }
        Map<String, String> map = this.mHeaders;
        if (map != null) {
            map.clear();
            this.mHeaders = null;
        }
        this.mHttpDns = null;
        this.mOnPreparedListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnMediaSourceChangedListener = null;
        if (this.mCyberRenderView != null) {
            removeAllViews();
            this.mCyberRenderView.destory();
            this.mCyberRenderView = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.mCurrentState = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i = this.mSeekWhenPrepared;
        if (i > 0) {
            seekTo(i, this.mSeekMode);
        }
        this.mSeekWhenPrepared = -1;
        int i2 = this.mSwitchSourceWhenPrepared;
        if (i2 != Integer.MIN_VALUE) {
            switchMediaSource(i2, this.mMediaSourceSwitchMode);
            this.mSwitchSourceWhenPrepared = Integer.MIN_VALUE;
        }
        CyberLog.i(TAG, "onPrepared mTargetState::" + this.mTargetState);
        if (this.mTargetState == 3 && this.mCurrentState == 2) {
            start();
        } else if (this.mTargetState == 4 && this.mCurrentState == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (isInPlaybackState()) {
            this.mCyberPlayer.pause();
            this.mCurrentState = 4;
        } else if (this.mCyberPlayer != null && !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PAUSE_VV_STATISTIC_FIX, false)) {
            this.mCyberPlayer.sendCommand(1000, 0, 0L, null);
            setStatisticInfoInternal(20488, "preparing_paused_time", "" + System.currentTimeMillis());
        }
        this.mTargetState = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.mIsAudioMuted = false;
        this.mRemote = true;
        this.mIsLooping = false;
        this.mSpeed = 1.0f;
        this.mSeekWhenPrepared = -1;
        this.mSwitchSourceWhenPrepared = Integer.MIN_VALUE;
        this.mUri = null;
        this.mHeaders = null;
        this.mHttpDns = null;
        this.mJson = null;
        this.mClarityInfo = null;
        this.mSurface = null;
        this.mExternalSurface = null;
        this.mDecodeMode = 0;
        if (this.mCurrentState == -1 && (cyberPlayer = this.mCyberPlayer) != null) {
            cyberPlayer.release();
            this.mCyberPlayer = null;
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        CyberPlayer cyberPlayer2 = this.mCyberPlayer;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null) {
            iCyberRenderView.reset();
        }
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
        CyberClientInfoManager cyberClientInfoManager = this.mClientInfoManager;
        if (cyberClientInfoManager != null) {
            cyberClientInfoManager.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null) {
            cyberPlayer.stop();
            this.mCyberPlayer.release();
            this.mCyberPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null) {
            iCyberRenderView.reset();
            this.mCyberRenderView.release();
        }
        CyberClientInfoManager cyberClientInfoManager = this.mClientInfoManager;
        if (cyberClientInfoManager != null) {
            cyberClientInfoManager.clear();
        }
        this.mJson = null;
        this.mClarityInfo = null;
        this.mSurface = null;
        this.mExternalSurface = null;
        if (MediaPlayerReduceHelper.isMpReduceEnable()) {
            CyberCoreLoaderManager.getInstance().removeCyberCoreInstallObserver(this);
        }
        MediaPlayerReduceHelper mediaPlayerReduceHelper = this.mMpReduceHelper;
        if (mediaPlayerReduceHelper != null) {
            mediaPlayerReduceHelper.reset();
            this.mMpReduceHelper = null;
        }
        this.mIsSwitchFromMediaPlayer = false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.mIsAudioMuted = z;
        CyberLog.i(TAG, "muteOrUnmuteAudio flag:" + z);
        if (this.mCyberPlayer != null) {
            CyberLog.y(TAG, this.mCyberPlayer + ", muteOrUnmuteAudio flag:" + z);
            this.mCyberPlayer.muteOrUnmuteAudio(z);
            return;
        }
        CyberLog.i(TAG, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        CyberLog.e(TAG, "onError: (" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + SmallTailInfo.EMOTION_SUFFIX);
        this.mCurrentState = -1;
        this.mTargetState = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            return onErrorListener.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        CyberPlayer cyberPlayer;
        CyberPlayer cyberPlayer2;
        CyberPlayer cyberPlayer3;
        if (i == 10001 && (cyberPlayer3 = this.mCyberPlayer) != null && cyberPlayer3.getDecodeMode() != 4) {
            ICyberRenderView iCyberRenderView = this.mCyberRenderView;
            if (iCyberRenderView != null) {
                iCyberRenderView.setRawFrameRotation(i2);
            }
        } else if (i == 11011) {
            CyberLog.d(TAG, "MEDIA_INFO_HDR_VIDEO CyberVideoView mRenderType:" + this.mRenderType + " HDR:" + i2);
            return onHDRInfo(i2);
        } else if (i == 904) {
            setStatisticInfoInternal(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, "v_first_disp_msg_t", System.currentTimeMillis() + "");
            if (MediaPlayerReduceHelper.isMpReduceEnable() && this.mMpReduceHelper != null && (cyberPlayer2 = this.mCyberPlayer) != null && cyberPlayer2.isMediaPlayer()) {
                this.mMpReduceHelper.setIsMediaPlayerFirstDisp(true);
            }
            if (MediaPlayerReduceHelper.isMpReduceEnable() && this.mMpReduceHelper != null && (cyberPlayer = this.mCyberPlayer) != null && !cyberPlayer.isMediaPlayer() && this.mIsSwitchFromMediaPlayer) {
                this.mIsSwitchFromMediaPlayer = false;
                HashMap hashMap = new HashMap();
                hashMap.put("type", "20513");
                hashMap.put("switch_from_media_player", "1");
                hashMap.put("first_display_mp_duration", this.mMpReduceHelper.getMediaPlayerPlayDuration() + "");
                setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                CyberLog.d(TAG, "MpReduce, SESSION_TYPE_FIRST_SCREEN, switch from mp, MediaPlayerPrePlayDuration: " + this.mMpReduceHelper.getMediaPlayerPlayDuration());
            }
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.mOnInfoListener;
        if (onInfoListener != null && onInfoListener.onInfo(i, i2, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
    public void onInstallSuccess(int i, String str) {
        MediaPlayerReduceHelper mediaPlayerReduceHelper;
        CyberLog.d(TAG, "MpReduce, #into onInstallSuccess");
        CyberPlayer cyberPlayer = this.mCyberPlayer;
        if (cyberPlayer != null && cyberPlayer.isMediaPlayer() && (mediaPlayerReduceHelper = this.mMpReduceHelper) != null) {
            if (!mediaPlayerReduceHelper.shouldSwitchToCyberPlayer()) {
                CyberLog.d(TAG, "MpReduce, onInstallSuccess, shouldSwitchToCyberPlayer return.");
            } else if (this.mCyberPlayer.isMediaPlayerFirstDisp()) {
                CyberLog.d(TAG, "MpReduce, onInstallSuccess, MediaPlayerFirstDisp return.");
            } else {
                CyberLog.d(TAG, "MpReduce, onInstallSuccess, 1. Stop MediaPlayer.");
                CyberPlayer cyberPlayer2 = this.mCyberPlayer;
                if (cyberPlayer2 != null) {
                    cyberPlayer2.stop();
                    this.mCyberPlayer.release();
                    this.mCyberPlayer = null;
                }
                this.mSurface = null;
                CyberLog.d(TAG, "MpReduce, onInstallSuccess, 2. Start CyberPlayer.");
                this.mIsSwitchFromMediaPlayer = true;
                openVideoOptimize();
                if (this.mTargetState == 3) {
                    start();
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        CyberPlayer cyberPlayer;
        if (this.mCurrentState == 0) {
            HashMap<String, String> hashMap = this.mOptions;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.mCyberPlayer != null) {
                if (str != null && str.equals(CyberPlayerManager.OPT_HTTP_PROXY) && !TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
                    return;
                }
                this.mCyberPlayer.setOption(str, str2);
                return;
            }
            return;
        }
        CyberLog.i(TAG, "Do not set option when the video player playing");
        if (str != null) {
            if ((str.equals(CyberPlayerManager.OPT_BUFFER_CONFIG_JSON) || str.equals(CyberPlayerManager.OPT_FILECACHE_RESERVE_URL)) && isInPlaybackState() && (cyberPlayer = this.mCyberPlayer) != null) {
                cyberPlayer.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        CyberLog.d(TAG, "onVideoSizeChanged num:" + i3 + " den:" + i4 + " width:" + i + " height:" + i2);
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null) {
            iCyberRenderView.onVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, i3, i4);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        if (onSnapShotCompleteListener == null) {
            return false;
        }
        CyberLog.d(TAG, "takeSnapshotAsync called");
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView == null) {
            return false;
        }
        if (iCyberRenderView.isNeedTakeSnapShotAsync()) {
            synchronized (this.mOnSnapShotCompleteListenerList) {
                if (this.mOnSnapShotCompleteListenerList.isEmpty()) {
                    this.mCyberRenderView.takeSnapshot(f, i, i2);
                }
                this.mOnSnapShotCompleteListenerList.add(onSnapShotCompleteListener);
            }
            return true;
        }
        Bitmap takeSnapshot = this.mCyberRenderView.takeSnapshot(f, i, i2);
        if (onSnapShotCompleteListener != null) {
            onSnapShotCompleteListener.onSnapShotComplete(takeSnapshot);
            return true;
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalSurface(Surface surface) {
        CyberLog.d(TAG, "setExternalSurface: " + surface + " mCurrentState:" + this.mCurrentState);
        if (this.mRenderType != 1) {
            CyberLog.w(TAG, "ExternalSurface not support RenderType: " + this.mRenderType);
            return;
        }
        try {
            if (this.mExternalSurface == null) {
                this.mExternalSurface = new WeakReference<>(null);
            }
            if (this.mExternalSurface.get() != surface) {
                WeakReference<Surface> weakReference = new WeakReference<>(surface);
                this.mExternalSurface = weakReference;
                if (this.mCyberPlayer == null) {
                    return;
                }
                if (weakReference.get() != null) {
                    CyberLog.d(TAG, "setExternalSurface use external surface: " + this.mExternalSurface.get() + " isValid:" + this.mExternalSurface.get().isValid());
                    this.mCyberPlayer.setSurface(null);
                    Utils.clearSurface(this.mExternalSurface.get());
                    this.mCyberPlayer.setSurface(this.mExternalSurface.get());
                } else if (this.mSurface != null) {
                    CyberLog.d(TAG, "setExternalSurface use videoview surface: " + this.mSurface + " isValid:" + this.mSurface.isValid());
                    this.mCyberPlayer.setSurface(null);
                    Utils.clearSurface(this.mSurface);
                    this.mCyberPlayer.setSurface(this.mSurface);
                } else {
                    CyberLog.d(TAG, "setExternalSurface no valid surface");
                    this.mCyberPlayer.setSurface(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean setFilterRegion(float f, float f2, float f3, float f4) {
        int i;
        ICyberRenderView iCyberRenderView = this.mCyberRenderView;
        if (iCyberRenderView != null && (i = this.mFilterType) > 0) {
            return iCyberRenderView.setFilterRegion(i, f, f2, f3, f4);
        }
        return false;
    }
}
