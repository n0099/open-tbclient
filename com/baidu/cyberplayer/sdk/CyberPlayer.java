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
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, MediaInstanceManagerProvider.OnClientInstanceHandler {
    public PlayerProvider a;
    public boolean b;
    public boolean c;
    public int d;
    public MediaInstanceState e;
    public CyberPlayerManager.OnErrorListener f;
    public int g;
    public CyberPlayerManager.OnInfoListener h;
    public MediaInfo i;

    public CyberPlayer() {
        this(0, null);
    }

    private boolean a() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, true);
    }

    public void cleanFilecacheAsyn() {
        q.k();
    }

    public int getCurrentPosition() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getCurrentPosition();
        }
        if (this.d > 0) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getCurrentPositionSync();
        }
        if (this.d > 0) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getDecodeMode();
        }
        return 0;
    }

    public long getDownloadSpeed() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getDownloadSpeed();
        }
        return 0L;
    }

    public int getDuration() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getDuration();
        }
        return -1;
    }

    public MediaInfo getMediaInfo() {
        return this.i;
    }

    public long getPlayedTime() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getPlayedTime();
        }
        if (this.d > 0) {
            return this.e.getPlayedTime();
        }
        return 0L;
    }

    public String getPlayerConfigOptions() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getPlayerConfigOptions();
        }
        return "";
    }

    public int getVideoHeight() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.getVideoWidth();
        }
        return 0;
    }

    public boolean isLooping() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null && playerProvider.isLooping()) {
            return true;
        }
        return false;
    }

    public boolean isPlaying() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null && playerProvider.isPlaying()) {
            return true;
        }
        return false;
    }

    public boolean isRemotePlayer() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.isRemotePlayer();
        }
        return false;
    }

    public void pause() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.pause();
        }
        if (this.d > 0) {
            this.e.updatePlayingStatus(false);
            this.e.updateSeekPos(getCurrentPosition(), getDuration());
            if (MultiInstanceManager.getInstance() != null) {
                MultiInstanceManager.getInstance().updateInstanceTimestamp(this.d, System.currentTimeMillis());
            }
        }
    }

    public void prepareAsync() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.prepareAsync();
        }
    }

    public void reset() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.reset();
        }
    }

    public void stepToNextFrame() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.stepToNextFrame();
        }
    }

    public void stop() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.stop();
        }
    }

    public CyberPlayer(int i) {
        this(i, null, true);
    }

    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.getMediaRuntimeInfo(onMediaRuntimeInfoListener);
        }
    }

    public void muteOrUnmuteAudio(boolean z) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.muteOrUnmuteAudio(z);
        }
        if (this.d > 0 && (mediaInstanceState = this.e) != null) {
            mediaInstanceState.updatePlayStateByType(0, z);
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        seekTo(j, 3);
    }

    public void setClarityInfo(String str) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setClarityInfo(str);
        }
        if (this.d > 0) {
            this.e.setClarityInfo(str);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setDataSource(fileDescriptor);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setDisplay(surfaceHolder);
        }
        if (this.d > 0 && surfaceHolder != null) {
            this.e.updateSurface(surfaceHolder.getSurface());
        }
    }

    public void setEnableDumediaUA(boolean z) {
        this.b = z;
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setEnableDumediaUA(z);
        }
    }

    public void setIsInMainProcess(boolean z) {
        this.c = z;
    }

    public void setLooping(boolean z) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setLooping(z);
        }
        if (this.d > 0) {
            this.e.updatePlayStateByType(1, z);
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
        if (this.d > 0) {
            this.e.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnCompletionListener(onCompletionListener);
        }
        if (this.d > 0) {
            this.e.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f = onErrorListener;
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnErrorListener(this);
        } else if (onErrorListener != null) {
            CyberLog.d("CyberPlayer", "CyberPlayer::setOnErrorListener playerProvider is null");
            int i = -112;
            if (CyberCfgManager.getInstance().a("java_error_code_mapping", true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(-112);
            }
            onErrorListener.onError(i, 0, null);
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        MediaInstanceState mediaInstanceState;
        this.h = onInfoListener;
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnInfoListener(this);
        }
        if (this.d > 0 && (mediaInstanceState = this.e) != null) {
            mediaInstanceState.setOnInfoListener(onInfoListener);
        }
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
        if (this.d > 0) {
            this.e.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnPreparedListener(onPreparedListener);
        }
        if (this.d > 0) {
            this.e.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnSeekCompleteListener(onSeekCompleteListener);
        }
        if (this.d > 0) {
            this.e.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
        if (this.d > 0) {
            this.e.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    public void setPlayJson(String str) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setPlayJson(str);
        }
        if (this.d > 0) {
            this.e.setPlayJson(str);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setScreenOnWhilePlaying(z);
        }
    }

    public void setSpeed(float f) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setSpeed(f);
        }
    }

    public void setSurface(Surface surface) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setSurface(surface);
        }
        if (this.d > 0) {
            this.e.updateSurface(surface);
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
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.switchMediaSource(i, mediaSourceSwitchMode);
        }
        if (this.d > 0) {
            this.e.setMediaSourceSwitchInfo(i, mediaSourceSwitchMode);
        }
    }

    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS) {
        this(i, httpDNS, true);
    }

    public void changeProxyDynamic(String str, boolean z) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.changeProxyDynamic(str, z);
        }
    }

    public void seekTo(long j, int i) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.seekTo(j, i);
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.a != null) {
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (!TextUtils.isEmpty(a)) {
                this.a.setDataSource(context, Uri.parse(a));
            } else {
                this.a.setDataSource(context, uri);
            }
            preparseHostWithURI(uri);
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, null);
        }
    }

    public void setOption(String str, long j) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            this.a.setOption(str, j);
        }
    }

    public void setVolume(float f, float f2) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setVolume(f, f2);
        }
    }

    public void setWakeMode(Context context, int i) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setWakeMode(context, i);
        }
    }

    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.switchMediaSource(i, mediaSourceSwitchMode);
        }
        if (this.d > 0) {
            this.e.setMediaSourceSwitchInfo(i, mediaSourceSwitchMode);
        }
    }

    public void updateDisplaySize(int i, int i2) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.updateDisplaySize(i, i2);
        }
    }

    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        this.b = true;
        this.c = true;
        this.d = 0;
        this.g = 0;
        this.a = n.a().a(i, httpDNS, z);
        if (z && a() && MultiInstanceManager.getInstance() != null) {
            this.d = MultiInstanceManager.getInstance().registerInstance(this);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] register instance: " + this.d);
            if (this.d > 0) {
                MediaInstanceState mediaInstanceState = new MediaInstanceState();
                this.e = mediaInstanceState;
                mediaInstanceState.updateInstanceState(0);
                this.e.updateDns(httpDNS);
                this.e.updateDecoderMode(i);
                this.e.updateRemote(z);
            }
        }
    }

    private void a(boolean z) {
        MediaInstanceState mediaInstanceState;
        Bundle instanceStatusByType;
        if (this.e != null) {
            this.a = n.a().a(this.e.getDecoderMode(), this.e.dns(), z);
        }
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null && (mediaInstanceState = this.e) != null) {
            if (!z) {
                playerProvider.setOnPreparedListener(mediaInstanceState.getOnPreparedListener());
            }
            this.a.setOnCompletionListener(this.e.getOnCompletionListener());
            this.a.setOnBufferingUpdateListener(this.e.getOnBufferingUpdateListener());
            this.a.setOnSeekCompleteListener(this.e.getOnSeekCompleteListener());
            this.a.setOnVideoSizeChangedListener(this.e.getOnVideoSizeChangedListener());
            this.a.setOnErrorListener(this);
            this.a.setOnInfoListener(this);
            this.a.setOnMediaSourceChangedListener(this.e.getOnMediaSourceChangedListener());
            if (MultiInstanceManager.getInstance() != null && (instanceStatusByType = MultiInstanceManager.getInstance().getInstanceStatusByType(this.d, 0)) != null) {
                for (String str : instanceStatusByType.keySet()) {
                    setOption(str, instanceStatusByType.getString(str));
                }
            }
            float lRVolume = this.e.getLRVolume();
            if (lRVolume >= 0.0f) {
                setVolume(lRVolume, lRVolume);
            }
            this.a.muteOrUnmuteAudio(this.e.getPlayStateByType(0));
            this.a.setLooping(this.e.getPlayStateByType(1));
            this.a.setEnableDumediaUA(this.b);
            if (this.e.getInstanceContext() == null) {
                if (this.e.getInstanceUri() != null) {
                    setDataSource(this.e.getInstanceUri().toString(), this.e.getInstanceHeader());
                } else {
                    CyberLog.i("CyberPlayer", "[MultiInstanceManager] esumeInstance failed, source is null");
                }
            } else {
                setDataSource(this.e.getInstanceContext(), this.e.getInstanceUri(), this.e.getInstanceHeader());
            }
            if (this.e.getClarityInfo() != null) {
                setClarityInfo(this.e.getClarityInfo());
            }
            if (this.e.getPlayJson() != null) {
                setPlayJson(this.e.getPlayJson());
            }
            int mediaSourceSwitchRank = this.e.getMediaSourceSwitchRank();
            if (mediaSourceSwitchRank != Integer.MIN_VALUE) {
                switchMediaSource(mediaSourceSwitchRank, this.e.getMediaSourceSwitchMode());
            }
            this.a.setSurface(this.e.getInstanceSurface());
            this.a.prepareAsync();
            if (this.e.getCurrentPosition() >= 0) {
                seekTo(this.e.getCurrentPosition());
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        MediaInstanceState mediaInstanceState;
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onDestroyInstance:" + this.d);
        if (this.a == null || this.d <= 0 || (mediaInstanceState = this.e) == null) {
            return false;
        }
        mediaInstanceState.updateSeekPos(getCurrentPosition(), getDuration());
        this.e.updatePlayedTime(getPlayedTime());
        this.e.updateDownLoadSpeed(getDownloadSpeed());
        this.e.updateDecoderMode(getDecodeMode());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_destroy", this.e.getInstanceStaticsCount(true));
            sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.a.stop();
        this.a.release();
        this.a = null;
        this.e.updateInstanceState(0);
        return true;
    }

    public void release() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.release();
        }
        if (this.c) {
            setOnPreparedListener(null);
            setOnCompletionListener(null);
            setOnBufferingUpdateListener(null);
            setOnSeekCompleteListener(null);
            setOnVideoSizeChangedListener(null);
            setOnErrorListener(null);
            setOnInfoListener(null);
        }
        if (this.d > 0) {
            if (MultiInstanceManager.getInstance() != null) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.d);
            }
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
            this.d = 0;
            this.e.release();
            this.e = null;
        }
        this.f = null;
        q.k();
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_pull_cloud_config", false)) {
            CyberCfgManager.getInstance().a();
        }
    }

    public void start() {
        if (this.d > 0) {
            if (this.e.needActiveInstance()) {
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] active instance: " + this.d);
                if (MultiInstanceManager.getInstance() != null) {
                    MultiInstanceManager.getInstance().activeInstance(this.d);
                    if (this.a == null) {
                        onResumeInstance();
                    }
                } else {
                    CyberLog.e("CyberPlayer", "[MultiInstanceManager]resume instance: " + this.d + " failed");
                }
                this.e.updateInstanceState(1);
            }
            this.e.updatePlayingStatus(true);
        }
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.start();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.stop();
            this.a.release();
            this.a = null;
        }
        if (i == -30000 || i == -30001) {
            if (this.d > 0 && !CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, false)) {
                if (this.e != null) {
                    a(true);
                    this.g++;
                    if (this.e.getPlayingStatus()) {
                        start();
                    } else {
                        pause();
                    }
                }
                if (this.a != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("multi_instance_resume_process", String.valueOf(this.g));
                        sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            }
            if (CyberCfgManager.getInstance().a("java_error_code_mapping", true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(i);
            }
        }
        if (this.d > 0) {
            if (MultiInstanceManager.getInstance() != null) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.d);
            }
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
            this.d = 0;
            this.e.release();
            this.e = null;
        }
        CyberPlayerManager.OnErrorListener onErrorListener = this.f;
        if (onErrorListener == null || !onErrorListener.onError(i, i2, obj)) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (this.c && i == 20500) {
            if (this.i == null) {
                this.i = new MediaInfo();
            }
            this.i.a((String) obj);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.h;
        if (onInfoListener != null) {
            return onInfoListener.onInfo(i, i2, obj);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onResumeInstance() {
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onResumeInstance:" + this.d);
        if (this.d <= 0 || this.a != null) {
            return false;
        }
        a(this.e.isRemote());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_resume", this.e.getInstanceStaticsCount(false));
            sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void preparseHostWithURI(Uri uri) {
        String host;
        if (!this.c || uri == null || (host = uri.getHost()) == null) {
            return;
        }
        String uri2 = uri.toString();
        if ((!uri2.contains(YYUtil.FLV_SUFFIX) && !uri2.contains(".m3u8")) || !CyberCfgManager.getInstance().a("use_httpdns_first", false)) {
            return;
        }
        List<String> iPListWithHost = CyberPlayerManager.getIPListWithHost(host);
        CyberLog.d("CyberPlayer", "preparseHostWithURI ips: " + iPListWithHost);
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
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.sendCommand(i, i2, j, str);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.a != null) {
            if (this.b) {
                map = q.a(map);
            }
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (!TextUtils.isEmpty(a)) {
                this.a.setDataSource(context, Uri.parse(a), map);
            } else {
                this.a.setDataSource(context, uri, map);
            }
            preparseHostWithURI(uri);
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, map);
        }
    }

    public void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (this.a != null) {
            if (this.b) {
                map = q.a(map);
            }
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (!TextUtils.isEmpty(a)) {
                this.a.setDataSource(a, map);
            } else {
                this.a.setDataSource(str, map);
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(null, Uri.parse(str), map);
        }
    }

    public void setExternalInfo(String str, Object obj) {
        int i;
        String str2;
        if (!TextUtils.isEmpty(str) && this.a != null) {
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
        if (this.a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.a.setOption(str, str2);
        }
        if (this.d > 0 && MultiInstanceManager.getInstance() != null) {
            MultiInstanceManager.getInstance().updateStringOption(this.d, str, str2);
        }
    }
}
