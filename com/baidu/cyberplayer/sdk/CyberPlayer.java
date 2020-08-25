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
/* loaded from: classes7.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, MediaInstanceManagerProvider.OnClientInstanceHandler {
    private PlayerProvider a;
    private boolean b;
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
        this.b = true;
        this.c = true;
        this.d = 0;
        this.a = l.a().a(i, httpDNS, z);
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
            this.a = l.a().a(this.e.getDecoderMode(), this.e.dns(), z);
        }
        if (this.a == null || this.e == null) {
            return;
        }
        if (!z) {
            this.a.setOnPreparedListener(this.e.getOnPreparedListener());
        }
        this.a.setOnCompletionListener(this.e.getOnCompletionListener());
        this.a.setOnBufferingUpdateListener(this.e.getOnBufferingUpdateListener());
        this.a.setOnSeekCompleteListener(this.e.getOnSeekCompleteListener());
        this.a.setOnVideoSizeChangedListener(this.e.getOnVideoSizeChangedListener());
        this.a.setOnErrorListener(this);
        this.a.setOnInfoListener(this.e.getOnInfoListener());
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
        this.a.muteOrUnmuteAudio(this.e.getPlayStateByType(0));
        this.a.setLooping(this.e.getPlayStateByType(1));
        this.a.setEnableDumediaUA(this.b);
        if (this.e.getInstanceContext() != null) {
            setDataSource(this.e.getInstanceContext(), this.e.getInstanceUri(), this.e.getInstanceHeader());
        } else if (this.e.getInstanceUri() != null) {
            setDataSource(this.e.getInstanceUri().getPath(), this.e.getInstanceHeader());
        } else {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] esumeInstance failed, source is null");
        }
        this.a.setSurface(this.e.getInstanceSurface());
        this.a.prepareAsync();
        if (this.e.getCurrentPosition() >= 0) {
            seekTo(this.e.getCurrentPosition());
        }
    }

    private boolean a() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, false);
    }

    public void changeProxyDynamic(String str, boolean z) {
        if (this.a != null) {
            this.a.changeProxyDynamic(str, z);
        }
    }

    public int getCurrentPosition() {
        if (this.a != null) {
            return this.a.getCurrentPosition();
        }
        if (this.d > 0) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (this.a != null) {
            return this.a.getCurrentPositionSync();
        }
        if (this.d > 0) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        if (this.a != null) {
            return this.a.getDecodeMode();
        }
        return 0;
    }

    public long getDownloadSpeed() {
        if (this.a != null) {
            return this.a.getDownloadSpeed();
        }
        return 0L;
    }

    public int getDuration() {
        if (this.a != null) {
            return this.a.getDuration();
        }
        return -1;
    }

    public long getPlayedTime() {
        if (this.a != null) {
            return this.a.getPlayedTime();
        }
        if (this.d > 0) {
            return this.e.getPlayedTime();
        }
        return 0L;
    }

    public int getVideoHeight() {
        if (this.a != null) {
            return this.a.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.a != null) {
            return this.a.getVideoWidth();
        }
        return 0;
    }

    public boolean isLooping() {
        return this.a != null && this.a.isLooping();
    }

    public boolean isPlaying() {
        return this.a != null && this.a.isPlaying();
    }

    public boolean isRemotePlayer() {
        if (this.a != null) {
            return this.a.isRemotePlayer();
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        if (this.a != null) {
            this.a.muteOrUnmuteAudio(z);
        }
        if (this.d <= 0 || this.e == null) {
            return;
        }
        this.e.updatePlayStateByType(0, z);
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        CyberLog.i("CyberPlayer", "[MultiInstanceManager] onDestroyInstance:" + this.d);
        if (this.a == null || this.d <= 0) {
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
        this.a.stop();
        this.a.release();
        this.a = null;
        this.e.updateInstanceState(0);
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        if (CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, false) || !(i == -30000 || i == -30001)) {
            if (this.d > 0) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.d);
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
                this.d = 0;
                this.e.release();
                this.e = null;
            }
            return this.f != null && this.f.onError(i, i2, obj);
        } else if (this.d <= 0 || this.a == null) {
            return true;
        } else {
            this.a.stop();
            this.a.release();
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
            sendCommand(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void pause() {
        if (this.a != null) {
            this.a.pause();
        }
        if (this.d > 0) {
            this.e.updatePlayingStatus(false);
            this.e.updateSeekPos(getCurrentPosition(), getDuration());
            MultiInstanceManager.getInstance().updateInstanceTimestamp(this.d, System.currentTimeMillis());
        }
    }

    public void prepareAsync() {
        if (this.a != null) {
            this.a.prepareAsync();
        }
    }

    public void release() {
        if (this.a != null) {
            this.a.release();
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
        if (this.a != null) {
            this.a.reset();
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        if (this.a != null) {
            this.a.seekTo(j);
        }
    }

    public void sendCommand(int i, int i2, long j, String str) {
        if (this.a != null) {
            this.a.sendCommand(i, i2, j, str);
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.a != null) {
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(context, uri);
            } else {
                this.a.setDataSource(context, Uri.parse(a));
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, null);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.a != null) {
            if (this.b) {
                map = n.a(map);
            }
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(context, uri, map);
            } else {
                this.a.setDataSource(context, Uri.parse(a), map);
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, map);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.a != null) {
            this.a.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (this.a != null) {
            if (this.b) {
                map = n.a(map);
            }
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(str, map);
            } else {
                this.a.setDataSource(a, map);
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(null, Uri.parse(str), map);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.a != null) {
            this.a.setDisplay(surfaceHolder);
        }
        if (this.d <= 0 || surfaceHolder == null) {
            return;
        }
        this.e.updateSurface(surfaceHolder.getSurface());
    }

    public void setEnableDumediaUA(boolean z) {
        this.b = z;
        if (this.a != null) {
            this.a.setEnableDumediaUA(z);
        }
    }

    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str) || this.a == null) {
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
        if (this.a != null) {
            this.a.setLooping(z);
        }
        if (this.d > 0) {
            this.e.updatePlayStateByType(1, z);
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (this.a != null) {
            this.a.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
        if (this.d > 0) {
            this.e.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        if (this.a != null) {
            this.a.setOnCompletionListener(onCompletionListener);
        }
        if (this.d > 0) {
            this.e.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f = onErrorListener;
        if (this.a != null) {
            this.a.setOnErrorListener(this);
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        if (this.a != null) {
            this.a.setOnInfoListener(onInfoListener);
        }
        if (this.d <= 0 || this.e == null) {
            return;
        }
        this.e.setOnInfoListener(onInfoListener);
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        if (this.a != null) {
            this.a.setOnPreparedListener(onPreparedListener);
        }
        if (this.d > 0) {
            this.e.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        if (this.a != null) {
            this.a.setOnSeekCompleteListener(onSeekCompleteListener);
        }
        if (this.d > 0) {
            this.e.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (this.a != null) {
            this.a.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
        if (this.d > 0) {
            this.e.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    public void setOption(String str, long j) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.setOption(str, j);
    }

    public void setOption(String str, String str2) {
        if (this.a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.a.setOption(str, str2);
        }
        if (this.d > 0) {
            MultiInstanceManager.getInstance().updateStringOption(this.d, str, str2);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        if (this.a != null) {
            this.a.setScreenOnWhilePlaying(z);
        }
    }

    public void setSpeed(float f) {
        if (this.a != null) {
            this.a.setSpeed(f);
        }
    }

    public void setSurface(Surface surface) {
        if (this.a != null) {
            this.a.setSurface(surface);
        }
        if (this.d > 0) {
            this.e.updateSurface(surface);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.a != null) {
            this.a.setVolume(f, f2);
        }
    }

    public void setWakeMode(Context context, int i) {
        if (this.a != null) {
            this.a.setWakeMode(context, i);
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
        if (this.a != null) {
            this.a.start();
        }
    }

    public void stop() {
        if (this.a != null) {
            this.a.stop();
        }
    }
}
