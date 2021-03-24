package com.baidu.searchbox.player;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.event.StatisticsEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
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
/* loaded from: classes3.dex */
public abstract class BDVideoPlayer implements IBVideoPlayer, IKernelPlayer {
    public static final String TAG = "BDVideoPlayer";
    public static boolean sGlobalMute = false;
    public AudioFocusChangedListener mAudioFocusListener;
    public AudioManager mAudioManager;
    public VideoPlayerCallbackBaseManager mCallbackManager;
    public ViewGroup.LayoutParams mContainerLayoutParams;
    public boolean mHasAudioFocus;
    public boolean mIsForeground;
    public boolean mIsMute;
    @Nullable
    public BaseKernelLayer mKernelLayer;
    @NonNull
    public String mKey;
    public LayerContainer mLayerContainer;
    public ViewGroup mPlayerContainer;
    public PluginManager mPluginManager;
    public StatisticsEventTrigger mStatEventTrigger;
    public int mVideoLoopCount;
    public VideoSession mVideoSession;
    public VideoTask mVideoTask;

    /* loaded from: classes3.dex */
    public class AudioFocusChangedListener implements AudioManager.OnAudioFocusChangeListener {
        public AudioFocusChangedListener() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            BDVideoPlayer.this.onAudioFocusChanged(i);
        }
    }

    public BDVideoPlayer(@Nullable Context context) {
        this(context, new BaseKernelLayer("NormalVideoKernel"));
    }

    private void bindSession() {
        bindSession(requireVideoSession());
    }

    private void createEnv(Context context) {
        this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.mVideoTask = new VideoTask();
        this.mPluginManager = new PluginManager(this);
        LayerContainer layerContainer = new LayerContainer(context);
        this.mLayerContainer = layerContainer;
        layerContainer.bindPlayer(this);
        this.mLayerContainer.setClickable(true);
        initCallBackManager();
    }

    @PublicMethod
    public static boolean isGlobalMute() {
        return sGlobalMute;
    }

    private void setupPlayer(@Nullable Context context) {
        setupPlayer(context, new BaseKernelLayer("NormalVideoKernel"));
    }

    public void abandonAudioFocus() {
        AudioFocusChangedListener audioFocusChangedListener;
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null && (audioFocusChangedListener = this.mAudioFocusListener) != null) {
            audioManager.abandonAudioFocus(audioFocusChangedListener);
            this.mAudioManager = null;
            this.mAudioFocusListener = null;
        }
        this.mHasAudioFocus = false;
        BdVideoLog.d(TAG, "video player abandonAudioFocus");
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        absLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.addLayer(absLayer, layoutParams);
    }

    @PublicMethod
    public void addPlugin(@NonNull AbsPlugin absPlugin) {
        absPlugin.attachMessenger(this.mVideoSession.getMessenger());
        this.mPluginManager.addPlugin(absPlugin);
    }

    @PublicMethod
    public void attachKernelLayer(@NonNull BaseKernelLayer baseKernelLayer) {
        detachKernelLayer();
        this.mKernelLayer = baseKernelLayer;
        baseKernelLayer.setKernelCallBack(this);
        this.mKernelLayer.setVideoSession(this.mVideoSession);
        this.mKernelLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.attachKernelLayer(baseKernelLayer);
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        attachToContainer(viewGroup, true);
    }

    @PublicMethod
    public void detachFromContainer() {
        detachFromContainer(true);
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer detachKernelLayer() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            this.mVideoSession.unregisterLayer(baseKernelLayer);
            this.mLayerContainer.detachLayer(this.mKernelLayer);
            this.mKernelLayer = null;
            return baseKernelLayer;
        }
        return null;
    }

    @PublicMethod
    public void doPlay() {
        if (this.mKernelLayer == null || this.mVideoSession.getStatus() == PlayerStatus.PAUSE) {
            return;
        }
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

    @Nullable
    @PublicMethod
    public Activity getActivity() {
        ViewGroup viewGroup = this.mPlayerContainer;
        if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
            return null;
        }
        return (Activity) this.mPlayerContainer.getContext();
    }

    @NonNull
    @PublicMethod
    public Context getAppContext() {
        return BDPlayerConfig.getAppContext();
    }

    @PublicMethod
    public ViewGroup getAttachedContainer() {
        return this.mPlayerContainer;
    }

    @PublicMethod
    public int getBufferingPosition() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getBufferingPosition();
    }

    @PublicMethod
    public int getDuration() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getDuration();
    }

    @PublicMethod
    public int getDurationMs() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getDurationMs();
    }

    @NonNull
    @PublicMethod
    public LayerContainer getLayerContainer() {
        return this.mLayerContainer;
    }

    @PublicMethod
    public int getLoopCount() {
        return this.mVideoLoopCount;
    }

    @NonNull
    @PublicMethod
    public VideoPlayerCallbackBaseManager getPlayerCallbackManager() {
        return this.mCallbackManager;
    }

    public PlayerEventTrigger getPlayerEventTrigger() {
        return this.mVideoSession.getPlayerEventTrigger();
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer getPlayerKernelLayer() {
        return this.mKernelLayer;
    }

    @PublicMethod
    public int getPlayerStageType() {
        return -1;
    }

    @PublicMethod
    public int getPosition() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getPosition();
    }

    @PublicMethod
    public int getPositionMs() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getPositionMs();
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getServerIpInfo();
        }
        return null;
    }

    @NonNull
    @PublicMethod
    public IPlayerStatisticsDispatcher getStatDispatcher() {
        return SimpleVideoStatisticsDispatcher.EMPTY;
    }

    @NonNull
    @PublicMethod(version = "11.24.0.0")
    public StatisticsEventTrigger getStatEventTrigger() {
        return this.mStatEventTrigger;
    }

    @PublicMethod
    public int getSyncPositionMs() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getSyncPositionMs();
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoHeight() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getVideoHeight();
        }
        return 0;
    }

    @PublicMethod
    public VideoSession getVideoSession() {
        return this.mVideoSession;
    }

    @PublicMethod
    public VideoTask getVideoTask() {
        return this.mVideoTask;
    }

    @NonNull
    @PublicMethod
    public String getVideoUniqueKey() {
        return this.mKey;
    }

    @PublicMethod
    public String getVideoUrl() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        return baseKernelLayer == null ? "" : baseKernelLayer.getVideoUrl();
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoWidth() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getVideoWidth();
        }
        return 0;
    }

    @PublicMethod
    public void goBackOrForeground(boolean z) {
        this.mIsForeground = z;
        getStatDispatcher().goBackOrForeground(z, getLoopCount());
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), z);
        this.mVideoSession.getControlEventTrigger().goBackOrForeground(z);
        getPlayerCallbackManager().onGoBackOrForeground(z);
    }

    public void initCallBackManager() {
        this.mCallbackManager = new VideoPlayerCallbackBaseManager();
    }

    public void initPlayer() {
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer) {
        absLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.insertLayer(absLayer, (FrameLayout.LayoutParams) null);
    }

    @PublicMethod
    public boolean isAttachToContainer() {
        return this.mLayerContainer.getParent() != null;
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
    public boolean isForeground() {
        return this.mIsForeground;
    }

    @PublicMethod
    public boolean isHasAudioFocus() {
        return this.mHasAudioFocus;
    }

    @PublicMethod
    public boolean isMute() {
        return this.mIsMute;
    }

    @PublicMethod
    public boolean isPause() {
        return this.mVideoSession.isPause();
    }

    @PublicMethod
    public boolean isPlayerMute() {
        return isGlobalMute();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public boolean isPlaying() {
        return this.mVideoSession.isPlaying();
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
    public boolean isStop() {
        return this.mVideoSession.isStop();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void mute(boolean z) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.mute(z);
    }

    public void onAudioFocusChanged(final int i) {
        Activity activity = getActivity();
        if (activity == null || isPlayerMute()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.player.BDVideoPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = i;
                if ((i2 == -2 || i2 == -1) && BDVideoPlayer.this.isPlaying()) {
                    BDVideoPlayer.this.pauseInternal(2);
                    BDVideoPlayer.this.abandonAudioFocus();
                }
            }
        });
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

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void pause() {
        pauseInternal(0);
    }

    public void pauseInternal(int i) {
        if (this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        this.mVideoSession.getControlEventTrigger().pause(i);
        this.mKernelLayer.pause();
        getStatDispatcher().pause();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void play(String str) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.play(str);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void prepare() {
        if (this.mKernelLayer == null) {
            return;
        }
        this.mVideoSession.getControlEventTrigger().prepare();
        this.mKernelLayer.prepare();
    }

    @PublicMethod
    public void release() {
        BdVideoLog.d("release player : " + this);
        getStatDispatcher().stop(getLoopCount());
        getStatEventTrigger().onPlayerStop(getLoopCount());
        getStatDispatcher().release();
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.pause();
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

    @PublicMethod
    public void removePlugin(@NonNull AbsPlugin absPlugin) {
        absPlugin.detachMessenger();
        this.mPluginManager.removePlugin(absPlugin);
    }

    @PublicMethod
    public void replaceVideoHolder(@NonNull ViewGroup viewGroup) {
        this.mPlayerContainer = viewGroup;
    }

    public void requestAudioFocus() {
        if (this.mHasAudioFocus) {
            return;
        }
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) getAppContext().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            if (this.mAudioFocusListener == null) {
                this.mAudioFocusListener = new AudioFocusChangedListener();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, 3, 2) == 1;
            BdVideoLog.d(TAG, "video player requestAudioFocus");
        }
    }

    public VideoSession requireVideoSession() {
        return VideoSessionManager.getInstance().getVideoSession();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void resume() {
        if (this.mKernelLayer == null) {
            return;
        }
        if (this.mVideoSession.getStatus() == PlayerStatus.PAUSE || this.mVideoSession.getStatus() == PlayerStatus.PREPARED || this.mVideoSession.getStatus() == PlayerStatus.PREPARING) {
            if (!isPlayerMute()) {
                requestAudioFocus();
            }
            this.mVideoSession.getControlEventTrigger().resume();
            this.mKernelLayer.resume();
            getStatDispatcher().resume();
        }
    }

    public void resumeFromError() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.stopPlayback();
        }
        setVideoUrl(this.mVideoTask.videoUrl);
        resumePlayer(false);
    }

    @PublicMethod
    public void resumePlayer(boolean z) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        if (z) {
            VideoTask videoTask = this.mVideoTask;
            videoTask.position = 0;
            videoTask.duration = 0;
        } else {
            this.mVideoTask.position = baseKernelLayer.getPosition();
            this.mVideoTask.duration = this.mKernelLayer.getDuration();
        }
        if (this.mVideoSession.getStatus() == PlayerStatus.PAUSE) {
            resume();
        } else {
            start();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void seekTo(int i) {
        if (this.mKernelLayer == null) {
            return;
        }
        this.mVideoSession.getControlEventTrigger().seekTo(i);
    }

    @PublicMethod
    public void seekToMs(int i) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.seekToMs(i);
    }

    @PublicMethod
    public void sendEvent(@NonNull VideoEvent videoEvent) {
        VideoSession videoSession = this.mVideoSession;
        if (videoSession == null) {
            return;
        }
        videoSession.sendEvent(videoEvent);
    }

    @PublicMethod(version = "11.24.0.0")
    public void setExternalInfo(String str, Object obj) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setExternalInfo(str, obj);
        }
    }

    @PublicMethod
    public void setGlobalMuteMode(boolean z) {
        sGlobalMute = z;
        setMuteMode(z);
    }

    @PublicMethod
    public void setHasReplaceUrl(boolean z) {
        BaseKernelLayer baseKernelLayer;
        if (!z || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.updateFreeProxy(null);
    }

    @PublicMethod
    public void setHttpHeader(HashMap<String, String> hashMap) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setHttpHeader(hashMap);
        }
    }

    @PublicMethod
    public void setLooping(boolean z) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setLooping(z);
    }

    @PublicMethod
    public void setMuteMode(boolean z) {
        this.mIsMute = z;
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.mute(z);
        }
        if (z) {
            abandonAudioFocus();
        } else if (isPlaying()) {
            requestAudioFocus();
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setOption(String str, String str2) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setOption(str, str2);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setParameter(String str, int i) {
    }

    @PublicMethod
    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        getPlayerCallbackManager().setVideoPlayerCallback(iVideoPlayerCallback);
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setProxy(str);
    }

    @PublicMethod
    public void setSpeed(float f2) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setSpeed(f2);
        }
    }

    public void setStageInfo(String str, String str2, String str3) {
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

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setUserAgent(String str) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setUserAgent(str);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoRotation(int i) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setVideoRotation(i);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoScalingMode(int i) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setVideoScalingMode(i);
    }

    @PublicMethod
    public void setVideoUniqueKey(String str) {
        this.mKey = str;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoUrl(@NonNull String str) {
        setVideoUrl(str, true);
    }

    @PublicMethod
    public void setupKernel(@Nullable BaseKernelLayer baseKernelLayer) {
        getStatDispatcher().startInitPlayerKernel();
        if (baseKernelLayer != null) {
            attachKernelLayer(baseKernelLayer);
        }
        getStatDispatcher().endInitPlayerKernel();
    }

    public abstract void setupLayers(@NonNull Context context);

    public void setupPlugin(@NonNull Context context) {
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void start() {
        doPlay();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void stop() {
        if (this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        getStatDispatcher().stop(getLoopCount());
        this.mVideoSession.getControlEventTrigger().stop();
        getStatEventTrigger().onPlayerStop(getLoopCount());
        this.mKernelLayer.stop();
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
    }

    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        this.mVideoSession.syncSession(videoSession);
    }

    @PublicMethod
    public void syncState(@NonNull BDVideoPlayer bDVideoPlayer) {
        if (this.mVideoSession == null || bDVideoPlayer.getVideoSession() == null) {
            return;
        }
        this.mVideoSession.getState().stateChangeNotify(bDVideoPlayer.getVideoSession().getStatus());
    }

    public void unbindSession() {
        if (this.mVideoSession != null) {
            VideoSessionManager.getInstance().recycle(this.mVideoSession);
        }
    }

    @PublicMethod(version = "11.23.0.0")
    public void updateFreeProxy(@Nullable String str) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.updateFreeProxy(str);
        }
    }

    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        this(context, baseKernelLayer, "");
    }

    private void bindSession(@NonNull VideoSession videoSession) {
        this.mVideoSession = videoSession;
        videoSession.bind(this);
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup, boolean z) {
        detachFromContainer(z);
        this.mPlayerContainer = viewGroup;
        viewGroup.addView(this.mLayerContainer, this.mContainerLayoutParams);
        getPlayerEventTrigger().onPlayerAttach();
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
    public void setVideoUrl(@NonNull String str, boolean z) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        this.mVideoTask.videoUrl = str;
        if (z) {
            baseKernelLayer.setVideoUrl(str);
        }
    }

    public void setupPlayer(Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        bindSession();
        getStatEventTrigger().setMessenger(this.mVideoSession.getMessenger());
        setupKernel(baseKernelLayer);
        setupLayers(context);
        setupPlugin(context);
    }

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

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer) {
        absLayer.injectMessenger(this.mVideoSession.getMessenger());
        this.mLayerContainer.addLayer(absLayer);
    }

    @PublicMethod
    public void syncState(@NonNull VideoKernelState videoKernelState) {
        VideoSession videoSession = this.mVideoSession;
        if (videoSession != null) {
            videoSession.getState().stateChangeNotify(videoKernelState.getStatus());
        }
    }

    @PublicMethod
    public void pauseInternal(boolean z) {
        if (this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        this.mVideoSession.getControlEventTrigger().pause(z);
        this.mKernelLayer.pause();
        getStatDispatcher().pause();
    }
}
