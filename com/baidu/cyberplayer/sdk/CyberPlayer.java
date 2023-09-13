package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.player.util.YYUtil;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class CyberPlayer implements MediaInstanceManagerProvider.OnClientInstanceHandler, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener {
    public static final String TAG = "CyberPlayer";
    public boolean mEnableDumediaUA;
    public int mInstanceID;
    public boolean mIsInMainProcess;
    public MediaInfo mMediaInfo;
    public CyberPlayerManager.OnErrorListener mOnErrorListener;
    public CyberPlayerManager.OnInfoListener mOnInfoListener;
    public PlayerProvider mProvider;
    public MediaInstanceState mState;
    public int resumeTimes;

    public CyberPlayer() {
        this(0, null);
    }

    private boolean canUseMutliInstance() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, true);
    }

    public void cleanFilecacheAsyn() {
        Utils.cleanFilecacheAsyn();
    }

    public int getCurrentPosition() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getCurrentPosition();
        }
        if (this.mInstanceID > 0) {
            return this.mState.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getCurrentPositionSync();
        }
        if (this.mInstanceID > 0) {
            return this.mState.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getDecodeMode();
        }
        return 0;
    }

    public long getDownloadSpeed() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getDownloadSpeed();
        }
        return 0L;
    }

    public int getDuration() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getDuration();
        }
        return -1;
    }

    public MediaInfo getMediaInfo() {
        return this.mMediaInfo;
    }

    public long getPlayedTime() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getPlayedTime();
        }
        if (this.mInstanceID > 0) {
            return this.mState.getPlayedTime();
        }
        return 0L;
    }

    public String getPlayerConfigOptions() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getPlayerConfigOptions();
        }
        return "";
    }

    public int getVideoHeight() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.getVideoWidth();
        }
        return 0;
    }

    public boolean isLooping() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null && playerProvider.isLooping()) {
            return true;
        }
        return false;
    }

    public boolean isMediaPlayer() {
        PlayerProvider playerProvider = this.mProvider;
        if (!(playerProvider instanceof MediaPlayerImpl) && !(playerProvider instanceof MediaPlayerAsync)) {
            return false;
        }
        return true;
    }

    public boolean isMediaPlayerFirstDisp() {
        if (isMediaPlayer()) {
            PlayerProvider playerProvider = this.mProvider;
            if (playerProvider instanceof MediaPlayerImpl) {
                return ((MediaPlayerImpl) playerProvider).isFirstDisp();
            }
            if (playerProvider instanceof MediaPlayerAsync) {
                return ((MediaPlayerAsync) playerProvider).isFirstDisp();
            }
            return false;
        }
        return false;
    }

    public boolean isPlaying() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null && playerProvider.isPlaying()) {
            return true;
        }
        return false;
    }

    public boolean isRemotePlayer() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            return playerProvider.isRemotePlayer();
        }
        return false;
    }

    public void pause() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.pause();
        }
        if (this.mInstanceID > 0) {
            this.mState.updatePlayingStatus(false);
            this.mState.updateSeekPos(getCurrentPosition(), getDuration());
            if (MultiInstanceManager.getInstance() != null) {
                MultiInstanceManager.getInstance().updateInstanceTimestamp(this.mInstanceID, System.currentTimeMillis());
            }
        }
    }

    public void prepareAsync() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.prepareAsync();
        }
    }

    public void reset() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.reset();
        }
    }

    public void stepToNextFrame() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.stepToNextFrame();
        }
    }

    public void stop() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.stop();
        }
    }

    public CyberPlayer(int i) {
        this(i, null, true);
    }

    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.getMediaRuntimeInfo(100, onMediaRuntimeInfoListener);
        }
    }

    public void muteOrUnmuteAudio(boolean z) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.muteOrUnmuteAudio(z);
        }
        if (this.mInstanceID > 0 && (mediaInstanceState = this.mState) != null) {
            mediaInstanceState.updatePlayStateByType(0, z);
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        seekTo(j, 3);
    }

    public void setClarityInfo(String str) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setClarityInfo(str);
        }
        if (this.mInstanceID > 0) {
            this.mState.setClarityInfo(str);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setDataSource(fileDescriptor);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setDisplay(surfaceHolder);
        }
        if (this.mInstanceID > 0 && surfaceHolder != null) {
            this.mState.updateSurface(surfaceHolder.getSurface());
        }
    }

    public void setEnableDumediaUA(boolean z) {
        this.mEnableDumediaUA = z;
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setEnableDumediaUA(z);
        }
    }

    public void setIsInMainProcess(boolean z) {
        this.mIsInMainProcess = z;
    }

    public void setLooping(boolean z) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setLooping(z);
        }
        if (this.mInstanceID > 0) {
            this.mState.updatePlayStateByType(1, z);
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
        if (this.mInstanceID > 0) {
            this.mState.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnCompletionListener(onCompletionListener);
        }
        if (this.mInstanceID > 0) {
            this.mState.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnErrorListener(this);
        } else if (onErrorListener != null) {
            CyberLog.d(TAG, "CyberPlayer::setOnErrorListener playerProvider is null");
            int i = -112;
            if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JAVA_ERROR_CODE_MAPPING, true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(-112);
            }
            onErrorListener.onError(i, 0, null);
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        MediaInstanceState mediaInstanceState;
        this.mOnInfoListener = onInfoListener;
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnInfoListener(this);
        }
        if (this.mInstanceID > 0 && (mediaInstanceState = this.mState) != null) {
            mediaInstanceState.setOnInfoListener(onInfoListener);
        }
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
        if (this.mInstanceID > 0) {
            this.mState.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnPreparedListener(onPreparedListener);
        }
        if (this.mInstanceID > 0) {
            this.mState.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnSeekCompleteListener(onSeekCompleteListener);
        }
        if (this.mInstanceID > 0) {
            this.mState.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
        if (this.mInstanceID > 0) {
            this.mState.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    public void setPlayJson(String str) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setPlayJson(str);
        }
        if (this.mInstanceID > 0) {
            this.mState.setPlayJson(str);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setScreenOnWhilePlaying(z);
        }
    }

    public void setSpeed(float f) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setSpeed(f);
        }
    }

    public void setSurface(Surface surface) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setSurface(surface);
        }
        if (this.mInstanceID > 0) {
            this.mState.updateSurface(surface);
        }
    }

    @Deprecated
    public void switchMediaSource(int i) {
        CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode;
        if (i == -1) {
            mediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE;
        } else {
            mediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_FORCE_MODE;
        }
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.switchMediaSource(i, mediaSourceSwitchMode);
        }
        if (this.mInstanceID > 0) {
            this.mState.setMediaSourceSwitchInfo(i, mediaSourceSwitchMode);
        }
    }

    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS) {
        this(i, httpDNS, true);
    }

    public void changeProxyDynamic(String str, boolean z) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.changeProxyDynamic(str, z);
        }
    }

    public void getMediaRuntimeInfo(int i, CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.getMediaRuntimeInfo(i, onMediaRuntimeInfoListener);
        }
    }

    public void seekTo(long j, int i) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.seekTo(j, i);
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.mProvider != null) {
            String cfgValueFast = CyberCfgManager.getInstance().getCfgValueFast(CyberCfgManager.KEY_STR_FORCE_URL, null);
            if (!TextUtils.isEmpty(cfgValueFast)) {
                this.mProvider.setDataSource(context, Uri.parse(cfgValueFast));
            } else {
                this.mProvider.setDataSource(context, uri);
            }
            preparseHostWithURI(uri);
        }
        if (this.mInstanceID > 0) {
            this.mState.updateDataSource(context, uri, null);
        }
    }

    public void setOption(String str, long j) {
        if (this.mProvider != null && !TextUtils.isEmpty(str)) {
            this.mProvider.setOption(str, j);
        }
    }

    public void setVolume(float f, float f2) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setVolume(f, f2);
        }
    }

    public void setWakeMode(Context context, int i) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.setWakeMode(context, i);
        }
    }

    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.switchMediaSource(i, mediaSourceSwitchMode);
        }
        if (this.mInstanceID > 0) {
            this.mState.setMediaSourceSwitchInfo(i, mediaSourceSwitchMode);
        }
    }

    public void updateDisplaySize(int i, int i2) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.updateDisplaySize(i, i2);
        }
    }

    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        this.mEnableDumediaUA = true;
        this.mIsInMainProcess = true;
        this.mInstanceID = 0;
        this.resumeTimes = 0;
        this.mProvider = PlayerProviderFactory.getInstance().create(i, httpDNS, z);
        CyberLog.d(TAG, "MpReduce, create provider: " + this.mProvider);
        if (z && canUseMutliInstance() && MultiInstanceManager.getInstance() != null) {
            this.mInstanceID = MultiInstanceManager.getInstance().registerInstance(this);
            CyberLog.i(TAG, "[MultiInstanceManager] register instance: " + this.mInstanceID);
            if (this.mInstanceID > 0) {
                MediaInstanceState mediaInstanceState = new MediaInstanceState();
                this.mState = mediaInstanceState;
                mediaInstanceState.updateInstanceState(0);
                this.mState.updateDns(httpDNS);
                this.mState.updateDecoderMode(i);
                this.mState.updateRemote(z);
            }
        }
    }

    private void resumeInstance(boolean z) {
        MediaInstanceState mediaInstanceState;
        Bundle instanceStatusByType;
        if (this.mState != null) {
            this.mProvider = PlayerProviderFactory.getInstance().create(this.mState.getDecoderMode(), this.mState.dns(), z);
        }
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null && (mediaInstanceState = this.mState) != null) {
            if (!z) {
                playerProvider.setOnPreparedListener(mediaInstanceState.getOnPreparedListener());
            }
            this.mProvider.setOnCompletionListener(this.mState.getOnCompletionListener());
            this.mProvider.setOnBufferingUpdateListener(this.mState.getOnBufferingUpdateListener());
            this.mProvider.setOnSeekCompleteListener(this.mState.getOnSeekCompleteListener());
            this.mProvider.setOnVideoSizeChangedListener(this.mState.getOnVideoSizeChangedListener());
            this.mProvider.setOnErrorListener(this);
            this.mProvider.setOnInfoListener(this);
            this.mProvider.setOnMediaSourceChangedListener(this.mState.getOnMediaSourceChangedListener());
            if (MultiInstanceManager.getInstance() != null && (instanceStatusByType = MultiInstanceManager.getInstance().getInstanceStatusByType(this.mInstanceID, 0)) != null) {
                for (String str : instanceStatusByType.keySet()) {
                    setOption(str, instanceStatusByType.getString(str));
                }
            }
            float lRVolume = this.mState.getLRVolume();
            if (lRVolume >= 0.0f) {
                setVolume(lRVolume, lRVolume);
            }
            this.mProvider.muteOrUnmuteAudio(this.mState.getPlayStateByType(0));
            this.mProvider.setLooping(this.mState.getPlayStateByType(1));
            this.mProvider.setEnableDumediaUA(this.mEnableDumediaUA);
            if (this.mState.getInstanceContext() == null) {
                if (this.mState.getInstanceUri() != null) {
                    setDataSource(this.mState.getInstanceUri().toString(), this.mState.getInstanceHeader());
                } else {
                    CyberLog.i(TAG, "[MultiInstanceManager] esumeInstance failed, source is null");
                }
            } else {
                setDataSource(this.mState.getInstanceContext(), this.mState.getInstanceUri(), this.mState.getInstanceHeader());
            }
            if (this.mState.getClarityInfo() != null) {
                setClarityInfo(this.mState.getClarityInfo());
            }
            if (this.mState.getPlayJson() != null) {
                setPlayJson(this.mState.getPlayJson());
            }
            int mediaSourceSwitchRank = this.mState.getMediaSourceSwitchRank();
            if (mediaSourceSwitchRank != Integer.MIN_VALUE) {
                switchMediaSource(mediaSourceSwitchRank, this.mState.getMediaSourceSwitchMode());
            }
            this.mProvider.setSurface(this.mState.getInstanceSurface());
            this.mProvider.prepareAsync();
            if (this.mState.getCurrentPosition() >= 0) {
                seekTo(this.mState.getCurrentPosition());
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        MediaInstanceState mediaInstanceState;
        CyberLog.i(TAG, "[MultiInstanceManager] onDestroyInstance:" + this.mInstanceID);
        if (this.mProvider == null || this.mInstanceID <= 0 || (mediaInstanceState = this.mState) == null) {
            return false;
        }
        mediaInstanceState.updateSeekPos(getCurrentPosition(), getDuration());
        this.mState.updatePlayedTime(getPlayedTime());
        this.mState.updateDownLoadSpeed(getDownloadSpeed());
        this.mState.updateDecoderMode(getDecodeMode());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_destroy", this.mState.getInstanceStaticsCount(true));
            sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mProvider.stop();
        this.mProvider.release();
        this.mProvider = null;
        this.mState.updateInstanceState(0);
        return true;
    }

    public void release() {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.release();
        }
        if (this.mIsInMainProcess) {
            setOnPreparedListener(null);
            setOnCompletionListener(null);
            setOnBufferingUpdateListener(null);
            setOnSeekCompleteListener(null);
            setOnVideoSizeChangedListener(null);
            setOnErrorListener(null);
            setOnInfoListener(null);
        }
        if (this.mInstanceID > 0) {
            if (MultiInstanceManager.getInstance() != null) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.mInstanceID);
            }
            CyberLog.i(TAG, "[MultiInstanceManager] unRegister instance:" + this.mInstanceID);
            this.mInstanceID = 0;
            this.mState.release();
            this.mState = null;
        }
        this.mOnErrorListener = null;
        Utils.cleanFilecacheAsyn();
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_pull_cloud_config", false)) {
            CyberCfgManager.getInstance().update();
        }
    }

    public void start() {
        if (this.mInstanceID > 0) {
            if (this.mState.needActiveInstance()) {
                CyberLog.i(TAG, "[MultiInstanceManager] active instance: " + this.mInstanceID);
                if (MultiInstanceManager.getInstance() != null) {
                    MultiInstanceManager.getInstance().activeInstance(this.mInstanceID);
                    if (this.mProvider == null) {
                        onResumeInstance();
                    }
                } else {
                    CyberLog.e(TAG, "[MultiInstanceManager]resume instance: " + this.mInstanceID + " failed");
                }
                this.mState.updateInstanceState(1);
            }
            this.mState.updatePlayingStatus(true);
        }
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.start();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.stop();
            this.mProvider.release();
            this.mProvider = null;
        }
        if (i == -30000 || i == -30001) {
            if (this.mInstanceID > 0 && !CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, false)) {
                if (this.mState != null) {
                    resumeInstance(true);
                    this.resumeTimes++;
                    if (this.mState.getPlayingStatus()) {
                        start();
                    } else {
                        pause();
                    }
                }
                if (this.mProvider != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("multi_instance_resume_process", String.valueOf(this.resumeTimes));
                        sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            }
            if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_JAVA_ERROR_CODE_MAPPING, true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(i);
            }
        }
        if (this.mInstanceID > 0) {
            if (MultiInstanceManager.getInstance() != null) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.mInstanceID);
            }
            CyberLog.i(TAG, "[MultiInstanceManager] unRegister instance:" + this.mInstanceID);
            this.mInstanceID = 0;
            this.mState.release();
            this.mState = null;
        }
        CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener == null || !onErrorListener.onError(i, i2, obj)) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (this.mIsInMainProcess && i == 20500) {
            if (this.mMediaInfo == null) {
                this.mMediaInfo = new MediaInfo();
            }
            this.mMediaInfo.setMediaInfoJson((String) obj);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.mOnInfoListener;
        if (onInfoListener != null) {
            return onInfoListener.onInfo(i, i2, obj);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onResumeInstance() {
        CyberLog.i(TAG, "[MultiInstanceManager] onResumeInstance:" + this.mInstanceID);
        if (this.mInstanceID <= 0 || this.mProvider != null) {
            return false;
        }
        resumeInstance(this.mState.isRemote());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_resume", this.mState.getInstanceStaticsCount(false));
            sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void preparseHostWithURI(Uri uri) {
        String host;
        if (!this.mIsInMainProcess || uri == null || (host = uri.getHost()) == null) {
            return;
        }
        String uri2 = uri.toString();
        if ((!uri2.contains(YYUtil.FLV_SUFFIX) && !uri2.contains(".m3u8")) || !CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_USE_HTTPDNS_FIRST, false)) {
            return;
        }
        List<String> iPListWithHost = CyberPlayerManager.getIPListWithHost(host);
        CyberLog.d(TAG, "preparseHostWithURI ips: " + iPListWithHost);
        if (iPListWithHost != null && iPListWithHost.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : iPListWithHost) {
                sb.append(str);
                sb.append(ParamableElem.DIVIDE_PARAM);
            }
            setOption(CyberPlayerManager.OPT_PREPARSE_IP, sb.toString());
        }
    }

    public void sendCommand(int i, int i2, long j, String str) {
        PlayerProvider playerProvider = this.mProvider;
        if (playerProvider != null) {
            playerProvider.sendCommand(i, i2, j, str);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.mProvider != null) {
            if (this.mEnableDumediaUA) {
                map = Utils.appendDuMediaUA(map);
            }
            String cfgValueFast = CyberCfgManager.getInstance().getCfgValueFast(CyberCfgManager.KEY_STR_FORCE_URL, null);
            if (!TextUtils.isEmpty(cfgValueFast)) {
                this.mProvider.setDataSource(context, Uri.parse(cfgValueFast), map);
            } else {
                this.mProvider.setDataSource(context, uri, map);
            }
            preparseHostWithURI(uri);
        }
        if (this.mInstanceID > 0) {
            this.mState.updateDataSource(context, uri, map);
        }
    }

    public void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (this.mProvider != null) {
            if (this.mEnableDumediaUA) {
                map = Utils.appendDuMediaUA(map);
            }
            String cfgValueFast = CyberCfgManager.getInstance().getCfgValueFast(CyberCfgManager.KEY_STR_FORCE_URL, null);
            if (!TextUtils.isEmpty(cfgValueFast)) {
                this.mProvider.setDataSource(cfgValueFast, map);
            } else {
                this.mProvider.setDataSource(str, map);
            }
        }
        if (this.mInstanceID > 0) {
            this.mState.updateDataSource(null, Uri.parse(str), map);
        }
    }

    public void setExternalInfo(String str, Object obj) {
        int i;
        String str2;
        if (!TextUtils.isEmpty(str) && this.mProvider != null) {
            if (str.equals("is_feed_video")) {
                if (obj != null && (obj instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    JSONObject jSONObject = new JSONObject();
                    if (booleanValue) {
                        str2 = YYOption.IsLive.VALUE_TRUE;
                    } else {
                        str2 = "false";
                    }
                    try {
                        jSONObject.put("is_feed_video", str2);
                        sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (str.equals(CyberPlayerManager.STR_STAGE_INFO)) {
                if (obj != null && (obj instanceof Map)) {
                    sendCommand(1001, 0, 0L, new JSONObject((Map) obj).toString());
                }
            } else if (str.equals(CyberPlayerManager.STR_STATISTICS_INFO) && obj != null && (obj instanceof Map)) {
                Map map = (Map) obj;
                String str3 = (String) map.get("type");
                if (!TextUtils.isEmpty(str3)) {
                    i = Integer.parseInt(str3);
                } else {
                    i = 0;
                }
                map.remove("type");
                sendCommand(1003, i, 0L, new JSONObject(map).toString());
            }
        }
    }

    public void setOption(String str, String str2) {
        if (this.mProvider != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mProvider.setOption(str, str2);
        }
        if (this.mInstanceID > 0 && MultiInstanceManager.getInstance() != null) {
            MultiInstanceManager.getInstance().updateStringOption(this.mInstanceID, str, str2);
        }
    }

    public void setOptions(Map<String, String> map) {
        if (this.mProvider != null && map != null && map.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (hashMap.size() > 0) {
                this.mProvider.setOptions(hashMap);
            }
        }
    }
}
