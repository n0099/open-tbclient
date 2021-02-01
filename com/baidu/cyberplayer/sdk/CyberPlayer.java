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
/* loaded from: classes4.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, MediaInstanceManagerProvider.OnClientInstanceHandler {

    /* renamed from: a  reason: collision with root package name */
    private PlayerProvider f1700a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1701b;
    private boolean c;
    private int d;
    private MediaInstanceState e;
    private CyberPlayerManager.OnErrorListener f;

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
        this.f1701b = true;
        this.c = true;
        this.d = 0;
        this.f1700a = l.a().a(i, httpDNS, z);
        if (z && a() && MultiInstanceManager.getInstance() != null) {
            this.d = MultiInstanceManager.getInstance().registerInstance(this);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] register instance: " + this.d);
            if (this.d > 0) {
                this.e = new MediaInstanceState();
                this.e.updateInstanceState(0);
                this.e.updateDns(httpDNS);
                this.e.updateDecoderMode(i);
                this.e.updateRemote(z);
            }
        }
    }

    private void a(boolean z) {
        if (this.e != null) {
            this.f1700a = l.a().a(this.e.getDecoderMode(), this.e.dns(), z);
        }
        if (this.f1700a == null || this.e == null) {
            return;
        }
        if (!z) {
            this.f1700a.setOnPreparedListener(this.e.getOnPreparedListener());
        }
        this.f1700a.setOnCompletionListener(this.e.getOnCompletionListener());
        this.f1700a.setOnBufferingUpdateListener(this.e.getOnBufferingUpdateListener());
        this.f1700a.setOnSeekCompleteListener(this.e.getOnSeekCompleteListener());
        this.f1700a.setOnVideoSizeChangedListener(this.e.getOnVideoSizeChangedListener());
        this.f1700a.setOnErrorListener(this);
        this.f1700a.setOnInfoListener(this.e.getOnInfoListener());
        this.f1700a.setOnMediaSourceChangedListener(this.e.getOnMediaSourceChangedListener());
        Bundle instanceStatusByType = MultiInstanceManager.getInstance().getInstanceStatusByType(this.d, 0);
        if (instanceStatusByType != null) {
            for (String str : instanceStatusByType.keySet()) {
                setOption(str, instanceStatusByType.getString(str));
            }
        }
        float lRVolume = this.e.getLRVolume();
        if (lRVolume >= 0.0f) {
            setVolume(lRVolume, lRVolume);
        }
        this.f1700a.muteOrUnmuteAudio(this.e.getPlayStateByType(0));
        this.f1700a.setLooping(this.e.getPlayStateByType(1));
        this.f1700a.setEnableDumediaUA(this.f1701b);
        if (this.e.getInstanceContext() != null) {
            setDataSource(this.e.getInstanceContext(), this.e.getInstanceUri(), this.e.getInstanceHeader());
        } else if (this.e.getInstanceUri() != null) {
            setDataSource(this.e.getInstanceUri().getPath(), this.e.getInstanceHeader());
        } else {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] esumeInstance failed, source is null");
        }
        if (this.e.getClarityInfo() != null) {
            setClarityInfo(this.e.getClarityInfo());
        }
        if (this.e.getPlayJson() != null) {
            setPlayJson(this.e.getPlayJson());
        }
        if (this.e.getMediaSourceRank() != Integer.MIN_VALUE) {
            switchMediaSource(this.e.getMediaSourceRank());
        }
        this.f1700a.setSurface(this.e.getInstanceSurface());
        this.f1700a.prepareAsync();
        if (this.e.getCurrentPosition() >= 0) {
            seekTo(this.e.getCurrentPosition());
        }
    }

    private boolean a() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, false);
    }

    public void changeProxyDynamic(String str, boolean z) {
        if (this.f1700a != null) {
            this.f1700a.changeProxyDynamic(str, z);
        }
    }

    public int getCurrentPosition() {
        if (this.f1700a != null) {
            return this.f1700a.getCurrentPosition();
        }
        if (this.d > 0) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (this.f1700a != null) {
            return this.f1700a.getCurrentPositionSync();
        }
        if (this.d > 0) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        if (this.f1700a != null) {
            return this.f1700a.getDecodeMode();
        }
        return 0;
    }

    public long getDownloadSpeed() {
        if (this.f1700a != null) {
            return this.f1700a.getDownloadSpeed();
        }
        return 0L;
    }

    public int getDuration() {
        if (this.f1700a != null) {
            return this.f1700a.getDuration();
        }
        return -1;
    }

    public long getPlayedTime() {
        if (this.f1700a != null) {
            return this.f1700a.getPlayedTime();
        }
        if (this.d > 0) {
            return this.e.getPlayedTime();
        }
        return 0L;
    }

    public int getVideoHeight() {
        if (this.f1700a != null) {
            return this.f1700a.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.f1700a != null) {
            return this.f1700a.getVideoWidth();
        }
        return 0;
    }

    public boolean isLooping() {
        return this.f1700a != null && this.f1700a.isLooping();
    }

    public boolean isPlaying() {
        return this.f1700a != null && this.f1700a.isPlaying();
    }

    public boolean isRemotePlayer() {
        if (this.f1700a != null) {
            return this.f1700a.isRemotePlayer();
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.f1700a != null) {
            this.f1700a.muteOrUnmuteAudio(z);
        }
        if (this.d <= 0 || this.e == null) {
            return;
        }
        this.e.updatePlayStateByType(0, z);
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onDestroyInstance:" + this.d);
        if (this.f1700a == null || this.d <= 0) {
            return false;
        }
        this.e.updateSeekPos(getCurrentPosition(), getDuration());
        this.e.updatePlayedTime(getPlayedTime());
        this.e.updateDownLoadSpeed(getDownloadSpeed());
        this.e.updateDecoderMode(getDecodeMode());
        this.e.updateInstanceDecodeMode(getDecodeMode());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_destroy", this.e.getInstanceStaticsCount(true));
            sendCommand(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f1700a.stop();
        this.f1700a.release();
        this.f1700a = null;
        this.e.updateInstanceState(0);
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        if (this.d <= 0 || CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, true) || (!(i == -30000 || i == -30001) || this.f1700a == null)) {
            if (this.d > 0) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.d);
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
                this.d = 0;
                this.e.release();
                this.e = null;
            }
            return this.f != null && this.f.onError(i, i2, obj);
        }
        this.f1700a.stop();
        this.f1700a.release();
        a(true);
        if (this.e != null) {
            if (this.e.getPlayingStatus()) {
                start();
            } else {
                pause();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_resume_process", "1");
            sendCommand(1003, 0, 0L, jSONObject.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onResumeInstance() {
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onResumeInstance:" + this.d);
        if (this.d <= 0 || this.f1700a != null) {
            return false;
        }
        a(this.e.isRemote());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("multi_instance_resume", this.e.getInstanceStaticsCount(false));
            sendCommand(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void pause() {
        if (this.f1700a != null) {
            this.f1700a.pause();
        }
        if (this.d > 0) {
            this.e.updatePlayingStatus(false);
            this.e.updateSeekPos(getCurrentPosition(), getDuration());
            MultiInstanceManager.getInstance().updateInstanceTimestamp(this.d, System.currentTimeMillis());
        }
    }

    public void prepareAsync() {
        if (this.f1700a != null) {
            this.f1700a.prepareAsync();
        }
    }

    public void release() {
        if (this.f1700a != null) {
            this.f1700a.release();
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
            MultiInstanceManager.getInstance().unRegisterInstance(this.d);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
            this.d = 0;
            this.e.release();
            this.e = null;
        }
        this.f = null;
        n.j();
        CyberCfgManager.getInstance().a();
    }

    public void reset() {
        if (this.f1700a != null) {
            this.f1700a.reset();
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        if (this.f1700a != null) {
            this.f1700a.seekTo(j);
        }
    }

    public void sendCommand(int i, int i2, long j, String str) {
        if (this.f1700a != null) {
            this.f1700a.sendCommand(i, i2, j, str);
        }
    }

    public void setClarityInfo(String str) {
        if (this.f1700a != null) {
            this.f1700a.setClarityInfo(str);
        }
        if (this.d > 0) {
            this.e.setClarityInfo(str);
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.f1700a != null) {
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f1700a.setDataSource(context, uri);
            } else {
                this.f1700a.setDataSource(context, Uri.parse(a2));
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, null);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f1700a != null) {
            if (this.f1701b) {
                map = n.a(map);
            }
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f1700a.setDataSource(context, uri, map);
            } else {
                this.f1700a.setDataSource(context, Uri.parse(a2), map);
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, map);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.f1700a != null) {
            this.f1700a.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (this.f1700a != null) {
            if (this.f1701b) {
                map = n.a(map);
            }
            String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                this.f1700a.setDataSource(str, map);
            } else {
                this.f1700a.setDataSource(a2, map);
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(null, Uri.parse(str), map);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.f1700a != null) {
            this.f1700a.setDisplay(surfaceHolder);
        }
        if (this.d <= 0 || surfaceHolder == null) {
            return;
        }
        this.e.updateSurface(surfaceHolder.getSurface());
    }

    public void setEnableDumediaUA(boolean z) {
        this.f1701b = z;
        if (this.f1700a != null) {
            this.f1700a.setEnableDumediaUA(z);
        }
    }

    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str) || this.f1700a == null) {
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (str.equals(CyberPlayerManager.STR_STAGE_INFO)) {
            if (obj == null || !(obj instanceof Map)) {
                return;
            }
            sendCommand(1001, 0, 0L, new JSONObject((Map) obj).toString());
        } else if (str.equals(CyberPlayerManager.STR_STATISTICS_INFO) && obj != null && (obj instanceof Map)) {
            Map map = (Map) obj;
            String str2 = (String) map.get("type");
            int parseInt = TextUtils.isEmpty(str2) ? 0 : Integer.parseInt(str2);
            map.remove("type");
            sendCommand(1003, parseInt, 0L, new JSONObject((Map) obj).toString());
        }
    }

    public void setIsInMainProcess(boolean z) {
        this.c = z;
    }

    public void setLooping(boolean z) {
        if (this.f1700a != null) {
            this.f1700a.setLooping(z);
        }
        if (this.d > 0) {
            this.e.updatePlayStateByType(1, z);
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (this.f1700a != null) {
            this.f1700a.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
        if (this.d > 0) {
            this.e.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        if (this.f1700a != null) {
            this.f1700a.setOnCompletionListener(onCompletionListener);
        }
        if (this.d > 0) {
            this.e.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f = onErrorListener;
        if (this.f1700a != null) {
            this.f1700a.setOnErrorListener(this);
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        if (this.f1700a != null) {
            this.f1700a.setOnInfoListener(onInfoListener);
        }
        if (this.d <= 0 || this.e == null) {
            return;
        }
        this.e.setOnInfoListener(onInfoListener);
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        if (this.f1700a != null) {
            this.f1700a.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
        if (this.d > 0) {
            this.e.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        if (this.f1700a != null) {
            this.f1700a.setOnPreparedListener(onPreparedListener);
        }
        if (this.d > 0) {
            this.e.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        if (this.f1700a != null) {
            this.f1700a.setOnSeekCompleteListener(onSeekCompleteListener);
        }
        if (this.d > 0) {
            this.e.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (this.f1700a != null) {
            this.f1700a.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
        if (this.d > 0) {
            this.e.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    public void setOption(String str, long j) {
        if (this.f1700a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f1700a.setOption(str, j);
    }

    public void setOption(String str, String str2) {
        if (this.f1700a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f1700a.setOption(str, str2);
        }
        if (this.d > 0) {
            MultiInstanceManager.getInstance().updateStringOption(this.d, str, str2);
        }
    }

    public void setPlayJson(String str) {
        if (this.f1700a != null) {
            this.f1700a.setPlayJson(str);
        }
        if (this.d > 0) {
            this.e.setPlayJson(str);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        if (this.f1700a != null) {
            this.f1700a.setScreenOnWhilePlaying(z);
        }
    }

    public void setSpeed(float f) {
        if (this.f1700a != null) {
            this.f1700a.setSpeed(f);
        }
    }

    public void setSurface(Surface surface) {
        if (this.f1700a != null) {
            this.f1700a.setSurface(surface);
        }
        if (this.d > 0) {
            this.e.updateSurface(surface);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.f1700a != null) {
            this.f1700a.setVolume(f, f2);
        }
    }

    public void setWakeMode(Context context, int i) {
        if (this.f1700a != null) {
            this.f1700a.setWakeMode(context, i);
        }
    }

    public void start() {
        if (this.d > 0) {
            if (this.e.needActiveInstance()) {
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] active instance: " + this.d);
                MultiInstanceManager.getInstance().activeInstance(this.d);
                this.e.updateInstanceState(1);
            }
            this.e.updatePlayingStatus(true);
        }
        if (this.f1700a != null) {
            this.f1700a.start();
        }
    }

    public void stop() {
        if (this.f1700a != null) {
            this.f1700a.stop();
        }
    }

    public void switchMediaSource(int i) {
        if (this.f1700a != null) {
            this.f1700a.switchMediaSource(i);
        }
        if (this.d > 0) {
            this.e.setMediaSourceRank(i);
        }
    }
}
