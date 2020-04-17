package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes.dex */
public class CyberPlayer {
    private PlayerProvider a;
    private boolean b;

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
        this.a = k.a().a(i, httpDNS, z);
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
        return 0;
    }

    public int getCurrentPositionSync() {
        if (this.a != null) {
            return this.a.getCurrentPositionSync();
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
    }

    public void pause() {
        if (this.a != null) {
            this.a.pause();
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
        m.j();
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
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.a != null) {
            if (this.b) {
                if (map == null) {
                    map = new HashMap<>();
                }
                String str = map.get("User-Agent");
                if (TextUtils.isEmpty(str)) {
                    str = "dumedia/7.7.2.14";
                } else if (str.indexOf("dumedia") == -1) {
                    str = str + " dumedia/" + SDKVersion.VERSION;
                }
                map.put("User-Agent", str);
            }
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(context, uri, map);
            } else {
                this.a.setDataSource(context, Uri.parse(a), map);
            }
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.a != null) {
            this.a.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        if (this.a != null) {
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(str);
            } else {
                this.a.setDataSource(a);
            }
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.a != null) {
            this.a.setDisplay(surfaceHolder);
        }
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

    public void setLooping(boolean z) {
        if (this.a != null) {
            this.a.setLooping(z);
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (this.a != null) {
            this.a.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        if (this.a != null) {
            this.a.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        if (this.a != null) {
            this.a.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        if (this.a != null) {
            this.a.setOnInfoListener(onInfoListener);
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        if (this.a != null) {
            this.a.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        if (this.a != null) {
            this.a.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (this.a != null) {
            this.a.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    public void setOption(String str, long j) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.setOption(str, j);
    }

    public void setOption(String str, String str2) {
        if (this.a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.a.setOption(str, str2);
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
