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
/* loaded from: classes2.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, MediaInstanceManagerProvider.OnClientInstanceHandler {

    /* renamed from: a  reason: collision with root package name */
    public PlayerProvider f4794a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4795b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4796c;

    /* renamed from: d  reason: collision with root package name */
    public int f4797d;

    /* renamed from: e  reason: collision with root package name */
    public MediaInstanceState f4798e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f4799f;

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
        this.f4795b = true;
        this.f4796c = true;
        this.f4797d = 0;
        this.f4794a = l.a().a(i, httpDNS, z);
        if (z && a() && MultiInstanceManager.getInstance() != null) {
            this.f4797d = MultiInstanceManager.getInstance().registerInstance(this);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] register instance: " + this.f4797d);
            if (this.f4797d > 0) {
                MediaInstanceState mediaInstanceState = new MediaInstanceState();
                this.f4798e = mediaInstanceState;
                mediaInstanceState.updateInstanceState(0);
                this.f4798e.updateDns(httpDNS);
                this.f4798e.updateDecoderMode(i);
                this.f4798e.updateRemote(z);
            }
        }
    }

    private void a(boolean z) {
        MediaInstanceState mediaInstanceState;
        if (this.f4798e != null) {
            this.f4794a = l.a().a(this.f4798e.getDecoderMode(), this.f4798e.dns(), z);
        }
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider == null || (mediaInstanceState = this.f4798e) == null) {
            return;
        }
        if (!z) {
            playerProvider.setOnPreparedListener(mediaInstanceState.getOnPreparedListener());
        }
        this.f4794a.setOnCompletionListener(this.f4798e.getOnCompletionListener());
        this.f4794a.setOnBufferingUpdateListener(this.f4798e.getOnBufferingUpdateListener());
        this.f4794a.setOnSeekCompleteListener(this.f4798e.getOnSeekCompleteListener());
        this.f4794a.setOnVideoSizeChangedListener(this.f4798e.getOnVideoSizeChangedListener());
        this.f4794a.setOnErrorListener(this);
        this.f4794a.setOnInfoListener(this.f4798e.getOnInfoListener());
        this.f4794a.setOnMediaSourceChangedListener(this.f4798e.getOnMediaSourceChangedListener());
        Bundle instanceStatusByType = MultiInstanceManager.getInstance().getInstanceStatusByType(this.f4797d, 0);
        if (instanceStatusByType != null) {
            for (String str : instanceStatusByType.keySet()) {
                setOption(str, instanceStatusByType.getString(str));
            }
        }
        float lRVolume = this.f4798e.getLRVolume();
        if (lRVolume >= 0.0f) {
            setVolume(lRVolume, lRVolume);
        }
        this.f4794a.muteOrUnmuteAudio(this.f4798e.getPlayStateByType(0));
        this.f4794a.setLooping(this.f4798e.getPlayStateByType(1));
        this.f4794a.setEnableDumediaUA(this.f4795b);
        if (this.f4798e.getInstanceContext() != null) {
            setDataSource(this.f4798e.getInstanceContext(), this.f4798e.getInstanceUri(), this.f4798e.getInstanceHeader());
        } else if (this.f4798e.getInstanceUri() != null) {
            setDataSource(this.f4798e.getInstanceUri().getPath(), this.f4798e.getInstanceHeader());
        } else {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] esumeInstance failed, source is null");
        }
        if (this.f4798e.getClarityInfo() != null) {
            setClarityInfo(this.f4798e.getClarityInfo());
        }
        if (this.f4798e.getPlayJson() != null) {
            setPlayJson(this.f4798e.getPlayJson());
        }
        if (this.f4798e.getMediaSourceRank() != Integer.MIN_VALUE) {
            switchMediaSource(this.f4798e.getMediaSourceRank());
        }
        this.f4794a.setSurface(this.f4798e.getInstanceSurface());
        this.f4794a.prepareAsync();
        if (this.f4798e.getCurrentPosition() >= 0) {
            seekTo(this.f4798e.getCurrentPosition());
        }
    }

    private boolean a() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, false);
    }

    public void changeProxyDynamic(String str, boolean z) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.changeProxyDynamic(str, z);
        }
    }

    public int getCurrentPosition() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getCurrentPosition();
        }
        if (this.f4797d > 0) {
            return this.f4798e.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getCurrentPositionSync();
        }
        if (this.f4797d > 0) {
            return this.f4798e.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getDecodeMode();
        }
        return 0;
    }

    public long getDownloadSpeed() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getDownloadSpeed();
        }
        return 0L;
    }

    public int getDuration() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getDuration();
        }
        return -1;
    }

    public long getPlayedTime() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getPlayedTime();
        }
        if (this.f4797d > 0) {
            return this.f4798e.getPlayedTime();
        }
        return 0L;
    }

    public int getVideoHeight() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.getVideoWidth();
        }
        return 0;
    }

    public boolean isLooping() {
        PlayerProvider playerProvider = this.f4794a;
        return playerProvider != null && playerProvider.isLooping();
    }

    public boolean isPlaying() {
        PlayerProvider playerProvider = this.f4794a;
        return playerProvider != null && playerProvider.isPlaying();
    }

    public boolean isRemotePlayer() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            return playerProvider.isRemotePlayer();
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.muteOrUnmuteAudio(z);
        }
        if (this.f4797d <= 0 || (mediaInstanceState = this.f4798e) == null) {
            return;
        }
        mediaInstanceState.updatePlayStateByType(0, z);
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onDestroyInstance:" + this.f4797d);
        if (this.f4794a == null || this.f4797d <= 0) {
            return false;
        }
        this.f4798e.updateSeekPos(getCurrentPosition(), getDuration());
        this.f4798e.updatePlayedTime(getPlayedTime());
        this.f4798e.updateDownLoadSpeed(getDownloadSpeed());
        this.f4798e.updateDecoderMode(getDecodeMode());
        this.f4798e.updateInstanceDecodeMode(getDecodeMode());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_destroy", this.f4798e.getInstanceStaticsCount(true));
            sendCommand(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f4794a.stop();
        this.f4794a.release();
        this.f4794a = null;
        this.f4798e.updateInstanceState(0);
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        PlayerProvider playerProvider;
        if (this.f4797d <= 0 || CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, true) || (!(i == -30000 || i == -30001) || (playerProvider = this.f4794a) == null)) {
            if (this.f4797d > 0) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.f4797d);
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.f4797d);
                this.f4797d = 0;
                this.f4798e.release();
                this.f4798e = null;
            }
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4799f;
            return onErrorListener != null && onErrorListener.onError(i, i2, obj);
        }
        playerProvider.stop();
        this.f4794a.release();
        a(true);
        MediaInstanceState mediaInstanceState = this.f4798e;
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
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onResumeInstance:" + this.f4797d);
        if (this.f4797d <= 0 || this.f4794a != null) {
            return false;
        }
        a(this.f4798e.isRemote());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_resume", this.f4798e.getInstanceStaticsCount(false));
            sendCommand(1003, 0, 0L, jSONObject.toString());
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public void pause() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.pause();
        }
        if (this.f4797d > 0) {
            this.f4798e.updatePlayingStatus(false);
            this.f4798e.updateSeekPos(getCurrentPosition(), getDuration());
            MultiInstanceManager.getInstance().updateInstanceTimestamp(this.f4797d, System.currentTimeMillis());
        }
    }

    public void prepareAsync() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.prepareAsync();
        }
    }

    public void release() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.release();
        }
        if (this.f4796c) {
            setOnPreparedListener(null);
            setOnCompletionListener(null);
            setOnBufferingUpdateListener(null);
            setOnSeekCompleteListener(null);
            setOnVideoSizeChangedListener(null);
            setOnErrorListener(null);
            setOnInfoListener(null);
        }
        if (this.f4797d > 0) {
            MultiInstanceManager.getInstance().unRegisterInstance(this.f4797d);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.f4797d);
            this.f4797d = 0;
            this.f4798e.release();
            this.f4798e = null;
        }
        this.f4799f = null;
        n.j();
        CyberCfgManager.getInstance().a();
    }

    public void reset() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.reset();
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.seekTo(j);
        }
    }

    public void sendCommand(int i, int i2, long j, String str) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.sendCommand(i, i2, j, str);
        }
    }

    public void setClarityInfo(String str) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setClarityInfo(str);
        }
        if (this.f4797d > 0) {
            this.f4798e.setClarityInfo(str);
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.f4794a != null) {
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f4794a.setDataSource(context, uri);
            } else {
                this.f4794a.setDataSource(context, Uri.parse(a2));
            }
        }
        if (this.f4797d > 0) {
            this.f4798e.updateDataSource(context, uri, null);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f4794a != null) {
            if (this.f4795b) {
                map = n.a(map);
            }
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f4794a.setDataSource(context, uri, map);
            } else {
                this.f4794a.setDataSource(context, Uri.parse(a2), map);
            }
        }
        if (this.f4797d > 0) {
            this.f4798e.updateDataSource(context, uri, map);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (this.f4794a != null) {
            if (this.f4795b) {
                map = n.a(map);
            }
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f4794a.setDataSource(str, map);
            } else {
                this.f4794a.setDataSource(a2, map);
            }
        }
        if (this.f4797d > 0) {
            this.f4798e.updateDataSource(null, Uri.parse(str), map);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setDisplay(surfaceHolder);
        }
        if (this.f4797d <= 0 || surfaceHolder == null) {
            return;
        }
        this.f4798e.updateSurface(surfaceHolder.getSurface());
    }

    public void setEnableDumediaUA(boolean z) {
        this.f4795b = z;
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setEnableDumediaUA(z);
        }
    }

    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str) || this.f4794a == null) {
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
        this.f4796c = z;
    }

    public void setLooping(boolean z) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setLooping(z);
        }
        if (this.f4797d > 0) {
            this.f4798e.updatePlayStateByType(1, z);
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
        if (this.f4797d > 0) {
            this.f4798e.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnCompletionListener(onCompletionListener);
        }
        if (this.f4797d > 0) {
            this.f4798e.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f4799f = onErrorListener;
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnErrorListener(this);
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnInfoListener(onInfoListener);
        }
        if (this.f4797d <= 0 || (mediaInstanceState = this.f4798e) == null) {
            return;
        }
        mediaInstanceState.setOnInfoListener(onInfoListener);
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
        if (this.f4797d > 0) {
            this.f4798e.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnPreparedListener(onPreparedListener);
        }
        if (this.f4797d > 0) {
            this.f4798e.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnSeekCompleteListener(onSeekCompleteListener);
        }
        if (this.f4797d > 0) {
            this.f4798e.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
        if (this.f4797d > 0) {
            this.f4798e.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    public void setOption(String str, long j) {
        if (this.f4794a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f4794a.setOption(str, j);
    }

    public void setOption(String str, String str2) {
        if (this.f4794a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f4794a.setOption(str, str2);
        }
        if (this.f4797d > 0) {
            MultiInstanceManager.getInstance().updateStringOption(this.f4797d, str, str2);
        }
    }

    public void setPlayJson(String str) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setPlayJson(str);
        }
        if (this.f4797d > 0) {
            this.f4798e.setPlayJson(str);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setScreenOnWhilePlaying(z);
        }
    }

    public void setSpeed(float f2) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setSpeed(f2);
        }
    }

    public void setSurface(Surface surface) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setSurface(surface);
        }
        if (this.f4797d > 0) {
            this.f4798e.updateSurface(surface);
        }
    }

    public void setVolume(float f2, float f3) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setVolume(f2, f3);
        }
    }

    public void setWakeMode(Context context, int i) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.setWakeMode(context, i);
        }
    }

    public void start() {
        if (this.f4797d > 0) {
            if (this.f4798e.needActiveInstance()) {
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] active instance: " + this.f4797d);
                MultiInstanceManager.getInstance().activeInstance(this.f4797d);
                this.f4798e.updateInstanceState(1);
            }
            this.f4798e.updatePlayingStatus(true);
        }
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.start();
        }
    }

    public void stop() {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.stop();
        }
    }

    public void switchMediaSource(int i) {
        PlayerProvider playerProvider = this.f4794a;
        if (playerProvider != null) {
            playerProvider.switchMediaSource(i);
        }
        if (this.f4797d > 0) {
            this.f4798e.setMediaSourceRank(i);
        }
    }
}
