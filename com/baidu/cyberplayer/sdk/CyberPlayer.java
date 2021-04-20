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
import java.io.FileDescriptor;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, MediaInstanceManagerProvider.OnClientInstanceHandler {

    /* renamed from: a  reason: collision with root package name */
    public PlayerProvider f4830a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4831b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4832c;

    /* renamed from: d  reason: collision with root package name */
    public int f4833d;

    /* renamed from: e  reason: collision with root package name */
    public MediaInstanceState f4834e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f4835f;

    public CyberPlayer() {
        this(0, null);
    }

    public CyberPlayer(int i) {
        this(i, null, true);
    }

    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS) {
        this(i, httpDNS, true);
    }

    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        this.f4831b = true;
        this.f4832c = true;
        this.f4833d = 0;
        this.f4830a = l.a().a(i, httpDNS, z);
        if (z && a() && MultiInstanceManager.getInstance() != null) {
            this.f4833d = MultiInstanceManager.getInstance().registerInstance(this);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] register instance: " + this.f4833d);
            if (this.f4833d > 0) {
                MediaInstanceState mediaInstanceState = new MediaInstanceState();
                this.f4834e = mediaInstanceState;
                mediaInstanceState.updateInstanceState(0);
                this.f4834e.updateDns(httpDNS);
                this.f4834e.updateDecoderMode(i);
                this.f4834e.updateRemote(z);
            }
        }
    }

    private void a(boolean z) {
        MediaInstanceState mediaInstanceState;
        if (this.f4834e != null) {
            this.f4830a = l.a().a(this.f4834e.getDecoderMode(), this.f4834e.dns(), z);
        }
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider == null || (mediaInstanceState = this.f4834e) == null) {
            return;
        }
        if (!z) {
            playerProvider.setOnPreparedListener(mediaInstanceState.getOnPreparedListener());
        }
        this.f4830a.setOnCompletionListener(this.f4834e.getOnCompletionListener());
        this.f4830a.setOnBufferingUpdateListener(this.f4834e.getOnBufferingUpdateListener());
        this.f4830a.setOnSeekCompleteListener(this.f4834e.getOnSeekCompleteListener());
        this.f4830a.setOnVideoSizeChangedListener(this.f4834e.getOnVideoSizeChangedListener());
        this.f4830a.setOnErrorListener(this);
        this.f4830a.setOnInfoListener(this.f4834e.getOnInfoListener());
        this.f4830a.setOnMediaSourceChangedListener(this.f4834e.getOnMediaSourceChangedListener());
        Bundle instanceStatusByType = MultiInstanceManager.getInstance().getInstanceStatusByType(this.f4833d, 0);
        if (instanceStatusByType != null) {
            for (String str : instanceStatusByType.keySet()) {
                setOption(str, instanceStatusByType.getString(str));
            }
        }
        float lRVolume = this.f4834e.getLRVolume();
        if (lRVolume >= 0.0f) {
            setVolume(lRVolume, lRVolume);
        }
        this.f4830a.muteOrUnmuteAudio(this.f4834e.getPlayStateByType(0));
        this.f4830a.setLooping(this.f4834e.getPlayStateByType(1));
        this.f4830a.setEnableDumediaUA(this.f4831b);
        if (this.f4834e.getInstanceContext() != null) {
            setDataSource(this.f4834e.getInstanceContext(), this.f4834e.getInstanceUri(), this.f4834e.getInstanceHeader());
        } else if (this.f4834e.getInstanceUri() != null) {
            setDataSource(this.f4834e.getInstanceUri().getPath(), this.f4834e.getInstanceHeader());
        } else {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] esumeInstance failed, source is null");
        }
        if (this.f4834e.getClarityInfo() != null) {
            setClarityInfo(this.f4834e.getClarityInfo());
        }
        if (this.f4834e.getPlayJson() != null) {
            setPlayJson(this.f4834e.getPlayJson());
        }
        if (this.f4834e.getMediaSourceRank() != Integer.MIN_VALUE) {
            switchMediaSource(this.f4834e.getMediaSourceRank());
        }
        this.f4830a.setSurface(this.f4834e.getInstanceSurface());
        this.f4830a.prepareAsync();
        if (this.f4834e.getCurrentPosition() >= 0) {
            seekTo(this.f4834e.getCurrentPosition());
        }
    }

    private boolean a() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, false);
    }

    public void changeProxyDynamic(String str, boolean z) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.changeProxyDynamic(str, z);
        }
    }

    public int getCurrentPosition() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getCurrentPosition();
        }
        if (this.f4833d > 0) {
            return this.f4834e.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getCurrentPositionSync();
        }
        if (this.f4833d > 0) {
            return this.f4834e.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getDecodeMode();
        }
        return 0;
    }

    public long getDownloadSpeed() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getDownloadSpeed();
        }
        return 0L;
    }

    public int getDuration() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getDuration();
        }
        return -1;
    }

    public long getPlayedTime() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getPlayedTime();
        }
        if (this.f4833d > 0) {
            return this.f4834e.getPlayedTime();
        }
        return 0L;
    }

    public int getVideoHeight() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.getVideoWidth();
        }
        return 0;
    }

    public boolean isLooping() {
        PlayerProvider playerProvider = this.f4830a;
        return playerProvider != null && playerProvider.isLooping();
    }

    public boolean isPlaying() {
        PlayerProvider playerProvider = this.f4830a;
        return playerProvider != null && playerProvider.isPlaying();
    }

    public boolean isRemotePlayer() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            return playerProvider.isRemotePlayer();
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.muteOrUnmuteAudio(z);
        }
        if (this.f4833d <= 0 || (mediaInstanceState = this.f4834e) == null) {
            return;
        }
        mediaInstanceState.updatePlayStateByType(0, z);
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onDestroyInstance:" + this.f4833d);
        if (this.f4830a == null || this.f4833d <= 0) {
            return false;
        }
        this.f4834e.updateSeekPos(getCurrentPosition(), getDuration());
        this.f4834e.updatePlayedTime(getPlayedTime());
        this.f4834e.updateDownLoadSpeed(getDownloadSpeed());
        this.f4834e.updateDecoderMode(getDecodeMode());
        this.f4834e.updateInstanceDecodeMode(getDecodeMode());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_destroy", this.f4834e.getInstanceStaticsCount(true));
            sendCommand(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f4830a.stop();
        this.f4830a.release();
        this.f4830a = null;
        this.f4834e.updateInstanceState(0);
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        PlayerProvider playerProvider;
        if (this.f4833d <= 0 || CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, true) || (!(i == -30000 || i == -30001) || (playerProvider = this.f4830a) == null)) {
            if (this.f4833d > 0) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.f4833d);
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.f4833d);
                this.f4833d = 0;
                this.f4834e.release();
                this.f4834e = null;
            }
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4835f;
            return onErrorListener != null && onErrorListener.onError(i, i2, obj);
        }
        playerProvider.stop();
        this.f4830a.release();
        a(true);
        MediaInstanceState mediaInstanceState = this.f4834e;
        if (mediaInstanceState != null) {
            if (mediaInstanceState.getPlayingStatus()) {
                start();
            } else {
                pause();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_resume_process", "1");
            sendCommand(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onResumeInstance() {
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onResumeInstance:" + this.f4833d);
        if (this.f4833d <= 0 || this.f4830a != null) {
            return false;
        }
        a(this.f4834e.isRemote());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_resume", this.f4834e.getInstanceStaticsCount(false));
            sendCommand(1003, 0, 0L, jSONObject.toString());
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public void pause() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.pause();
        }
        if (this.f4833d > 0) {
            this.f4834e.updatePlayingStatus(false);
            this.f4834e.updateSeekPos(getCurrentPosition(), getDuration());
            MultiInstanceManager.getInstance().updateInstanceTimestamp(this.f4833d, System.currentTimeMillis());
        }
    }

    public void prepareAsync() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.prepareAsync();
        }
    }

    public void release() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.release();
        }
        if (this.f4832c) {
            setOnPreparedListener(null);
            setOnCompletionListener(null);
            setOnBufferingUpdateListener(null);
            setOnSeekCompleteListener(null);
            setOnVideoSizeChangedListener(null);
            setOnErrorListener(null);
            setOnInfoListener(null);
        }
        if (this.f4833d > 0) {
            MultiInstanceManager.getInstance().unRegisterInstance(this.f4833d);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.f4833d);
            this.f4833d = 0;
            this.f4834e.release();
            this.f4834e = null;
        }
        this.f4835f = null;
        n.j();
        CyberCfgManager.getInstance().a();
    }

    public void reset() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.reset();
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.seekTo(j);
        }
    }

    public void sendCommand(int i, int i2, long j, String str) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.sendCommand(i, i2, j, str);
        }
    }

    public void setClarityInfo(String str) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setClarityInfo(str);
        }
        if (this.f4833d > 0) {
            this.f4834e.setClarityInfo(str);
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.f4830a != null) {
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f4830a.setDataSource(context, uri);
            } else {
                this.f4830a.setDataSource(context, Uri.parse(a2));
            }
        }
        if (this.f4833d > 0) {
            this.f4834e.updateDataSource(context, uri, null);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f4830a != null) {
            if (this.f4831b) {
                map = n.a(map);
            }
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f4830a.setDataSource(context, uri, map);
            } else {
                this.f4830a.setDataSource(context, Uri.parse(a2), map);
            }
        }
        if (this.f4833d > 0) {
            this.f4834e.updateDataSource(context, uri, map);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (this.f4830a != null) {
            if (this.f4831b) {
                map = n.a(map);
            }
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f4830a.setDataSource(str, map);
            } else {
                this.f4830a.setDataSource(a2, map);
            }
        }
        if (this.f4833d > 0) {
            this.f4834e.updateDataSource(null, Uri.parse(str), map);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setDisplay(surfaceHolder);
        }
        if (this.f4833d <= 0 || surfaceHolder == null) {
            return;
        }
        this.f4834e.updateSurface(surfaceHolder.getSurface());
    }

    public void setEnableDumediaUA(boolean z) {
        this.f4831b = z;
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setEnableDumediaUA(z);
        }
    }

    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str) || this.f4830a == null) {
            return;
        }
        if (str.equals("is_feed_video")) {
            if (obj == null || !(obj instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_feed_video", booleanValue ? "true" : "false");
                sendCommand(1003, 0, 0L, jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (str.equals(CyberPlayerManager.STR_STAGE_INFO)) {
            if (obj == null || !(obj instanceof Map)) {
                return;
            }
            sendCommand(1001, 0, 0L, new JSONObject((Map) obj).toString());
        } else if (str.equals(CyberPlayerManager.STR_STATISTICS_INFO) && obj != null && (obj instanceof Map)) {
            Map map = (Map) obj;
            String str2 = (String) map.get("type");
            int parseInt = !TextUtils.isEmpty(str2) ? Integer.parseInt(str2) : 0;
            map.remove("type");
            sendCommand(1003, parseInt, 0L, new JSONObject(map).toString());
        }
    }

    public void setIsInMainProcess(boolean z) {
        this.f4832c = z;
    }

    public void setLooping(boolean z) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setLooping(z);
        }
        if (this.f4833d > 0) {
            this.f4834e.updatePlayStateByType(1, z);
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
        if (this.f4833d > 0) {
            this.f4834e.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnCompletionListener(onCompletionListener);
        }
        if (this.f4833d > 0) {
            this.f4834e.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f4835f = onErrorListener;
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnErrorListener(this);
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnInfoListener(onInfoListener);
        }
        if (this.f4833d <= 0 || (mediaInstanceState = this.f4834e) == null) {
            return;
        }
        mediaInstanceState.setOnInfoListener(onInfoListener);
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
        if (this.f4833d > 0) {
            this.f4834e.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnPreparedListener(onPreparedListener);
        }
        if (this.f4833d > 0) {
            this.f4834e.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnSeekCompleteListener(onSeekCompleteListener);
        }
        if (this.f4833d > 0) {
            this.f4834e.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
        if (this.f4833d > 0) {
            this.f4834e.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    public void setOption(String str, long j) {
        if (this.f4830a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f4830a.setOption(str, j);
    }

    public void setOption(String str, String str2) {
        if (this.f4830a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f4830a.setOption(str, str2);
        }
        if (this.f4833d > 0) {
            MultiInstanceManager.getInstance().updateStringOption(this.f4833d, str, str2);
        }
    }

    public void setPlayJson(String str) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setPlayJson(str);
        }
        if (this.f4833d > 0) {
            this.f4834e.setPlayJson(str);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setScreenOnWhilePlaying(z);
        }
    }

    public void setSpeed(float f2) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setSpeed(f2);
        }
    }

    public void setSurface(Surface surface) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setSurface(surface);
        }
        if (this.f4833d > 0) {
            this.f4834e.updateSurface(surface);
        }
    }

    public void setVolume(float f2, float f3) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setVolume(f2, f3);
        }
    }

    public void setWakeMode(Context context, int i) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.setWakeMode(context, i);
        }
    }

    public void start() {
        if (this.f4833d > 0) {
            if (this.f4834e.needActiveInstance()) {
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] active instance: " + this.f4833d);
                MultiInstanceManager.getInstance().activeInstance(this.f4833d);
                this.f4834e.updateInstanceState(1);
            }
            this.f4834e.updatePlayingStatus(true);
        }
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.start();
        }
    }

    public void stop() {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.stop();
        }
    }

    public void switchMediaSource(int i) {
        PlayerProvider playerProvider = this.f4830a;
        if (playerProvider != null) {
            playerProvider.switchMediaSource(i);
        }
        if (this.f4833d > 0) {
            this.f4834e.setMediaSourceRank(i);
        }
    }
}
