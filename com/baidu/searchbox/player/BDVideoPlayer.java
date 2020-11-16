package com.baidu.searchbox.player;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.event.StatisticsEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.model.VideoTask;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.plugin.PluginManager;
import com.baidu.searchbox.player.session.VideoKernelState;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher;
import com.baidu.searchbox.player.ubc.SimpleVideoStatisticsDispatcher;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes11.dex */
public abstract class BDVideoPlayer implements IBVideoPlayer, IKernelPlayer {
    private static final String TAG = "BDVideoPlayer";
    private static boolean sGlobalMute = false;
    private AudioFocusChangedListener mAudioFocusListener;
    private AudioManager mAudioManager;
    protected VideoPlayerCallbackBaseManager mCallbackManager;
    private ViewGroup.LayoutParams mContainerLayoutParams;
    protected boolean mHasAudioFocus;
    private boolean mIsForeground;
    protected boolean mIsMute;
    @Nullable
    protected BaseKernelLayer mKernelLayer;
    @NonNull
    protected String mKey;
    protected LayerContainer mLayerContainer;
    protected ViewGroup mPlayerContainer;
    protected PluginManager mPluginManager;
    private StatisticsEventTrigger mStatEventTrigger;
    protected int mVideoLoopCount;
    protected VideoSession mVideoSession;
    protected VideoTask mVideoTask;

    protected abstract void setupLayers(@NonNull Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public BDVideoPlayer(@Nullable Context context) {
        this(context, new BaseKernelLayer(AbsVideoKernel.NORMAL_PLAYER));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        this(context, baseKernelLayer, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str) {
        this.mIsForeground = false;
        this.mStatEventTrigger = new StatisticsEventTrigger();
        this.mKey = "";
        this.mIsMute = false;
        this.mVideoLoopCount = 0;
        this.mKey = str;
        getStatDispatcher().startInitPlayer();
        context = context == null ? getAppContext() : context;
        createEnv(context);
        initPlayer();
        setupPlayer(context, baseKernelLayer);
        getStatDispatcher().endInitPlayer();
    }

    protected void initPlayer() {
    }

    private void createEnv(Context context) {
        this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.mVideoTask = new VideoTask();
        this.mPluginManager = new PluginManager(this);
        this.mLayerContainer = new LayerContainer(context);
        this.mLayerContainer.bindPlayer(this);
        this.mLayerContainer.setClickable(true);
        initCallBackManager();
    }

    protected void initCallBackManager() {
        this.mCallbackManager = new VideoPlayerCallbackBaseManager();
    }

    @PublicMethod
    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        getPlayerCallbackManager().setVideoPlayerCallback(iVideoPlayerCallback);
    }

    private void setupPlayer(@Nullable Context context) {
        setupPlayer(context, new BaseKernelLayer(AbsVideoKernel.NORMAL_PLAYER));
    }

    protected void setupPlayer(Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        bindSession();
        getStatEventTrigger().setMessenger(this.mVideoSession.getMessenger());
        setupKernel(baseKernelLayer);
        setupLayers(context);
        setupPlugin(context);
    }

    @PublicMethod
    public void setupKernel(@Nullable BaseKernelLayer baseKernelLayer) {
        getStatDispatcher().startInitPlayerKernel();
        if (baseKernelLayer != null) {
            attachKernelLayer(baseKernelLayer);
        }
        getStatDispatcher().endInitPlayerKernel();
    }

    @PublicMethod
    public void attachKernelLayer(@NonNull BaseKernelLayer baseKernelLayer) {
        detachKernelLayer();
        this.mKernelLayer = baseKernelLayer;
        this.mKernelLayer.setKernelCallBack(this);
        this.mKernelLayer.setVideoSession(this.mVideoSession);
        this.mKernelLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.attachKernelLayer(baseKernelLayer);
    }

    @PublicMethod
    @Nullable
    public BaseKernelLayer detachKernelLayer() {
        if (this.mKernelLayer != null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            this.mVideoSession.unregisterLayer(this.mKernelLayer);
            this.mLayerContainer.detachLayer(this.mKernelLayer);
            this.mKernelLayer = null;
            return baseKernelLayer;
        }
        return null;
    }

    @PublicMethod
    @Nullable
    public BaseKernelLayer getPlayerKernelLayer() {
        return this.mKernelLayer;
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        absLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.addLayer(absLayer, layoutParams);
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer) {
        absLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.insertLayer(absLayer, (FrameLayout.LayoutParams) null);
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer) {
        absLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.addLayer(absLayer);
    }

    @PublicMethod
    public void addPlugin(@NonNull AbsPlugin absPlugin) {
        absPlugin.attachMessenger(this.mVideoSession.getMessenger());
        this.mPluginManager.addPlugin(absPlugin);
    }

    @PublicMethod
    public void removePlugin(@NonNull AbsPlugin absPlugin) {
        absPlugin.detachMessenger();
        this.mPluginManager.removePlugin(absPlugin);
    }

    private void bindSession() {
        bindSession(requireVideoSession());
    }

    protected VideoSession requireVideoSession() {
        return VideoSessionManager.getInstance().getVideoSession();
    }

    private void bindSession(@NonNull VideoSession videoSession) {
        this.mVideoSession = videoSession;
        this.mVideoSession.bind(this);
    }

    protected void unbindSession() {
        if (this.mVideoSession != null) {
            VideoSessionManager.getInstance().recycle(this.mVideoSession);
        }
    }

    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        this.mVideoSession.syncSession(videoSession);
    }

    @PublicMethod
    public void syncState(@NonNull BDVideoPlayer bDVideoPlayer) {
        if (this.mVideoSession != null && bDVideoPlayer.getVideoSession() != null) {
            this.mVideoSession.getState().stateChangeNotify(bDVideoPlayer.getVideoSession().getStatus());
        }
    }

    @PublicMethod
    public void syncState(@NonNull VideoKernelState videoKernelState) {
        if (this.mVideoSession != null) {
            this.mVideoSession.getState().stateChangeNotify(videoKernelState.getStatus());
        }
    }

    @PublicMethod
    public static boolean isGlobalMute() {
        return sGlobalMute;
    }

    @PublicMethod
    public void setGlobalMuteMode(boolean z) {
        sGlobalMute = z;
        setMuteMode(z);
    }

    @PublicMethod
    public boolean isMute() {
        return this.mIsMute;
    }

    @PublicMethod
    public void setMuteMode(boolean z) {
        this.mIsMute = z;
        if (this.mKernelLayer != null) {
            this.mKernelLayer.mute(z);
        }
        if (z) {
            abandonAudioFocus();
        } else if (isPlaying()) {
            requestAudioFocus();
        }
    }

    @PublicMethod
    public int getLoopCount() {
        return this.mVideoLoopCount;
    }

    protected void setStageInfo(String str, String str2, String str3) {
        String str4;
        if (this.mKernelLayer != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            hashMap.put(CyberPlayerManager.STAGE_INFO_SOURCE, str2);
            hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, str3);
            this.mKernelLayer.setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
            if (getPlayerStageType() != 1) {
                if ((getPlayerStageType() != 22) & (getPlayerStageType() != 6)) {
                    str4 = "0";
                    this.mKernelLayer.setOption(CyberPlayerManager.OPT_FEED_VIDEO, str4);
                }
            }
            str4 = "1";
            this.mKernelLayer.setOption(CyberPlayerManager.OPT_FEED_VIDEO, str4);
        }
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        attachToContainer(viewGroup, true);
    }

    @PublicMethod
    public void replaceVideoHolder(@NonNull ViewGroup viewGroup) {
        this.mPlayerContainer = viewGroup;
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup, boolean z) {
        detachFromContainer(z);
        this.mPlayerContainer = viewGroup;
        this.mPlayerContainer.addView(this.mLayerContainer, this.mContainerLayoutParams);
        getPlayerEventTrigger().onPlayerAttach();
    }

    @PublicMethod
    public boolean isAttachToContainer() {
        return this.mLayerContainer.getParent() != null;
    }

    @PublicMethod
    public void detachFromContainer() {
        detachFromContainer(true);
    }

    @PublicMethod
    public void detachFromContainer(boolean z) {
        if (this.mLayerContainer.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mLayerContainer.getParent()).removeView(this.mLayerContainer);
            if (z) {
                this.mLayerContainer.onContainerDetach();
                getPlayerEventTrigger().onPlayerDetach();
            }
            this.mPlayerContainer = null;
        }
    }

    @PublicMethod
    public void setHasReplaceUrl(boolean z) {
        if (z && this.mKernelLayer != null) {
            this.mKernelLayer.updateFreeProxy(null);
        }
    }

    @PublicMethod
    public ViewGroup getAttachedContainer() {
        return this.mPlayerContainer;
    }

    @PublicMethod
    public int getDuration() {
        if (this.mKernelLayer == null) {
            return 0;
        }
        return this.mKernelLayer.getDuration();
    }

    @PublicMethod
    public int getDurationMs() {
        if (this.mKernelLayer == null) {
            return 0;
        }
        return this.mKernelLayer.getDurationMs();
    }

    @PublicMethod
    public int getPosition() {
        if (this.mKernelLayer == null) {
            return 0;
        }
        return this.mKernelLayer.getPosition();
    }

    @PublicMethod
    public int getPositionMs() {
        if (this.mKernelLayer == null) {
            return 0;
        }
        return this.mKernelLayer.getPositionMs();
    }

    @PublicMethod
    public int getSyncPositionMs() {
        if (this.mKernelLayer == null) {
            return 0;
        }
        return this.mKernelLayer.getSyncPositionMs();
    }

    @PublicMethod
    public int getBufferingPosition() {
        if (this.mKernelLayer == null) {
            return 0;
        }
        return this.mKernelLayer.getBufferingPosition();
    }

    @PublicMethod
    public String getVideoUrl() {
        return this.mKernelLayer == null ? "" : this.mKernelLayer.getVideoUrl();
    }

    @PublicMethod
    public void resumePlayer(boolean z) {
        if (this.mKernelLayer != null) {
            if (z) {
                this.mVideoTask.position = 0;
                this.mVideoTask.duration = 0;
            } else {
                this.mVideoTask.position = this.mKernelLayer.getPosition();
                this.mVideoTask.duration = this.mKernelLayer.getDuration();
            }
            if (this.mVideoSession.getStatus() == PlayerStatus.PAUSE) {
                resume();
            } else {
                start();
            }
        }
    }

    public void resumeFromError() {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.stopPlayback();
        }
        setVideoUrl(this.mVideoTask.videoUrl);
        resumePlayer(false);
    }

    @PublicMethod
    @NonNull
    public LayerContainer getLayerContainer() {
        return this.mLayerContainer;
    }

    @PublicMethod
    public VideoSession getVideoSession() {
        return this.mVideoSession;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void start() {
        doPlay();
    }

    @PublicMethod
    public void doPlay() {
        if (this.mKernelLayer != null && this.mVideoSession.getStatus() != PlayerStatus.PAUSE) {
            if (this.mKernelLayer.getContentView() != null) {
                this.mKernelLayer.getContentView().setVisibility(0);
            }
            String str = this.mVideoTask.videoUrl;
            if (!isPlayerMute()) {
                requestAudioFocus();
            }
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), true);
            this.mVideoSession.getControlEventTrigger().start();
            this.mKernelLayer.play(str);
            getStatDispatcher().start();
            getStatEventTrigger().onPlayerStart();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void pause() {
        pauseInternal(0);
    }

    protected void pauseInternal(int i) {
        if (this.mKernelLayer != null) {
            abandonAudioFocus();
            this.mVideoSession.getControlEventTrigger().pause(i);
            this.mKernelLayer.pause();
            getStatDispatcher().pause();
        }
    }

    @PublicMethod
    public void pauseInternal(boolean z) {
        if (this.mKernelLayer != null) {
            abandonAudioFocus();
            this.mVideoSession.getControlEventTrigger().pause(z);
            this.mKernelLayer.pause();
            getStatDispatcher().pause();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void resume() {
        if (this.mKernelLayer != null) {
            if (this.mVideoSession.getStatus() == PlayerStatus.PAUSE || this.mVideoSession.getStatus() == PlayerStatus.PREPARED || this.mVideoSession.getStatus() == PlayerStatus.PREPARING) {
                if (!isPlayerMute()) {
                    requestAudioFocus();
                }
                this.mVideoSession.getControlEventTrigger().resume();
                this.mKernelLayer.resume();
                getStatDispatcher().resume();
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoUrl(@NonNull String str) {
        setVideoUrl(str, true);
    }

    @PublicMethod
    public void setVideoUrl(@NonNull String str, boolean z) {
        if (this.mKernelLayer != null) {
            this.mVideoTask.videoUrl = str;
            if (z) {
                this.mKernelLayer.setVideoUrl(str);
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void stop() {
        if (this.mKernelLayer != null) {
            abandonAudioFocus();
            getStatDispatcher().stop(getLoopCount());
            this.mVideoSession.getControlEventTrigger().stop();
            getStatEventTrigger().onPlayerStop(getLoopCount());
            this.mKernelLayer.stop();
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void play(String str) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.play(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public boolean isPlaying() {
        return this.mVideoSession.isPlaying();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void prepare() {
        if (this.mKernelLayer != null) {
            this.mVideoSession.getControlEventTrigger().prepare();
            this.mKernelLayer.prepare();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void seekTo(int i) {
        if (this.mKernelLayer != null) {
            this.mVideoSession.getControlEventTrigger().seekTo(i);
        }
    }

    @PublicMethod
    public void seekToMs(int i) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.seekToMs(i);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoScalingMode(int i) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoRotation(int i) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setVideoRotation(i);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setParameter(String str, int i) {
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setUserAgent(String str) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setUserAgent(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void mute(boolean z) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.mute(z);
        }
    }

    @PublicMethod
    public boolean isPrepared() {
        return this.mVideoSession.isPrepared();
    }

    @PublicMethod
    public boolean isPreparing() {
        return this.mVideoSession.isPreparing();
    }

    @PublicMethod
    public boolean isPause() {
        return this.mVideoSession.isPause();
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setProxy(str);
        }
    }

    @PublicMethod
    public void setLooping(boolean z) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setLooping(z);
        }
    }

    @PublicMethod
    public void goBackOrForeground(boolean z) {
        this.mIsForeground = z;
        getStatDispatcher().goBackOrForeground(z, getLoopCount());
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), z);
        this.mVideoSession.getControlEventTrigger().goBackOrForeground(z);
        getPlayerCallbackManager().onGoBackOrForeground(z);
    }

    protected PlayerEventTrigger getPlayerEventTrigger() {
        return this.mVideoSession.getPlayerEventTrigger();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        abandonAudioFocus();
        getPlayerEventTrigger().onCompletion();
        getStatDispatcher().end(getLoopCount());
        getStatEventTrigger().onPlayerComplete(getLoopCount());
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        getPlayerEventTrigger().onError(i, i2, obj);
        getStatDispatcher().onError(i, i2, obj);
        getStatEventTrigger().onError(i, i2, obj);
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        getPlayerEventTrigger().onInfo(i, i2, obj);
        getStatDispatcher().onInfo(i, i2, obj != null ? obj.toString() : "");
        getStatEventTrigger().onInfo(i, i2, obj);
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        getPlayerEventTrigger().onPrepared();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        getPlayerEventTrigger().onSeekComplete();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        getPlayerEventTrigger().onVideoSizeChanged(i, i2, i3, i4);
    }

    @PublicMethod
    public void release() {
        BdVideoLog.d("release player : " + this);
        getStatDispatcher().stop(getLoopCount());
        getStatEventTrigger().onPlayerStop(getLoopCount());
        getStatDispatcher().release();
        if (this.mKernelLayer != null) {
            this.mKernelLayer.pause();
            this.mKernelLayer.stop();
            this.mKernelLayer.release();
        }
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
        getPlayerCallbackManager().release();
        abandonAudioFocus();
        this.mPluginManager.release();
        this.mLayerContainer.release();
        detachFromContainer(false);
        getStatEventTrigger().release();
        unbindSession();
        this.mPlayerContainer = null;
    }

    public void requestAudioFocus() {
        if (!this.mHasAudioFocus) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.mAudioManager != null) {
                if (this.mAudioFocusListener == null) {
                    this.mAudioFocusListener = new AudioFocusChangedListener();
                }
                this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, 3, 2) == 1;
                BdVideoLog.d(TAG, "video player requestAudioFocus");
            }
        }
    }

    protected void abandonAudioFocus() {
        if (this.mAudioManager != null && this.mAudioFocusListener != null) {
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
            this.mAudioManager = null;
            this.mAudioFocusListener = null;
        }
        this.mHasAudioFocus = false;
        BdVideoLog.d(TAG, "video player abandonAudioFocus");
    }

    @PublicMethod
    public boolean isHasAudioFocus() {
        return this.mHasAudioFocus;
    }

    @PublicMethod
    public boolean isComplete() {
        return this.mVideoSession.isComplete();
    }

    @PublicMethod
    public boolean isError() {
        return this.mVideoSession.isError();
    }

    @PublicMethod
    public boolean isStop() {
        return this.mVideoSession.isStop();
    }

    @PublicMethod
    public int getPlayerStageType() {
        return -1;
    }

    @PublicMethod
    @NonNull
    public Context getAppContext() {
        return BDPlayerConfig.getAppContext();
    }

    @PublicMethod
    @Nullable
    public Activity getActivity() {
        if (this.mPlayerContainer == null || !(this.mPlayerContainer.getContext() instanceof Activity)) {
            return null;
        }
        return (Activity) this.mPlayerContainer.getContext();
    }

    @PublicMethod
    public void setSpeed(float f) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setSpeed(f);
        }
    }

    @PublicMethod
    public void sendEvent(@NonNull VideoEvent videoEvent) {
        if (this.mVideoSession != null) {
            this.mVideoSession.sendEvent(videoEvent);
        }
    }

    @PublicMethod
    public boolean isForeground() {
        return this.mIsForeground;
    }

    @PublicMethod
    public void setVideoUniqueKey(String str) {
        this.mKey = str;
    }

    @PublicMethod
    @NonNull
    public String getVideoUniqueKey() {
        return this.mKey;
    }

    @PublicMethod
    public VideoTask getVideoTask() {
        return this.mVideoTask;
    }

    @PublicMethod
    @NonNull
    public VideoPlayerCallbackBaseManager getPlayerCallbackManager() {
        return this.mCallbackManager;
    }

    protected void setupPlugin(@NonNull Context context) {
    }

    @PublicMethod
    @NonNull
    public IPlayerStatisticsDispatcher getStatDispatcher() {
        return SimpleVideoStatisticsDispatcher.EMPTY;
    }

    @PublicMethod
    public boolean isPlayerMute() {
        return isGlobalMute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class AudioFocusChangedListener implements AudioManager.OnAudioFocusChangeListener {
        private AudioFocusChangedListener() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            BDVideoPlayer.this.onAudioFocusChanged(i);
        }
    }

    protected void onAudioFocusChanged(final int i) {
        Activity activity = getActivity();
        if (activity != null && !isPlayerMute()) {
            activity.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.player.BDVideoPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (BDVideoPlayer.this.isPlaying()) {
                                BDVideoPlayer.this.pauseInternal(2);
                                BDVideoPlayer.this.abandonAudioFocus();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    @PublicMethod
    @Nullable
    public String getServerIpInfo() {
        if (this.mKernelLayer != null) {
            return this.mKernelLayer.getServerIpInfo();
        }
        return null;
    }

    @PublicMethod
    public void setHttpHeader(HashMap<String, String> hashMap) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setHttpHeader(hashMap);
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setExternalInfo(String str, Object obj) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setExternalInfo(str, obj);
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setOption(String str, String str2) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setOption(str, str2);
        }
    }

    @PublicMethod(version = "11.24.0.0")
    @NonNull
    public StatisticsEventTrigger getStatEventTrigger() {
        return this.mStatEventTrigger;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoWidth() {
        if (this.mKernelLayer != null) {
            return this.mKernelLayer.getVideoWidth();
        }
        return 0;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoHeight() {
        if (this.mKernelLayer != null) {
            return this.mKernelLayer.getVideoHeight();
        }
        return 0;
    }

    @PublicMethod(version = "11.23.0.0")
    public void updateFreeProxy(@Nullable String str) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.updateFreeProxy(str);
        }
    }
}
