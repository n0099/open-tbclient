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
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.FileDescriptor;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, MediaInstanceManagerProvider.OnClientInstanceHandler {
    public PlayerProvider a;
    public boolean b;
    public boolean c;
    public int d;
    public MediaInstanceState e;
    public CyberPlayerManager.OnErrorListener f;

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
        this.a = m.a().a(i, httpDNS, z);
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

    private boolean a() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, true);
    }

    private boolean a(boolean z) {
        MediaInstanceState mediaInstanceState;
        boolean z2;
        if (this.e != null) {
            this.a = m.a().a(this.e.getDecoderMode(), this.e.dns(), z);
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
            this.a.setOnInfoListener(this.e.getOnInfoListener());
            this.a.setOnMediaSourceChangedListener(this.e.getOnMediaSourceChangedListener());
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
            if (this.e.getInstanceUrl() != null) {
                if (this.e.isProcessDied()) {
                    z2 = this.e.getInstanceUrl().startsWith("http://") || this.e.getInstanceUrl().startsWith("https://") || this.e.getInstanceUrl().startsWith("file://");
                    this.e.setProcessDied(false);
                } else {
                    z2 = true;
                }
                if (z2) {
                    setDataSource(this.e.getInstanceUrl(), this.e.getInstanceHeader());
                }
            } else if (this.e.getInstanceUri() != null) {
                setDataSource(this.e.getInstanceContext(), this.e.getInstanceUri(), this.e.getInstanceHeader());
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("media_process_resume_abnormal", this.e.getInstanceUrl());
                    sendCommand(1003, 0, 0L, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return false;
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
            this.a.setSurface(this.e.getInstanceSurface());
            this.a.prepareAsync();
            if (this.e.getCurrentPosition() >= 0) {
                seekTo(this.e.getCurrentPosition());
            }
        }
        return true;
    }

    public void changeProxyDynamic(String str, boolean z) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.changeProxyDynamic(str, z);
        }
    }

    public void cleanFilecacheAsyn() {
        o.j();
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
        return playerProvider != null && playerProvider.isLooping();
    }

    public boolean isPlaying() {
        PlayerProvider playerProvider = this.a;
        return playerProvider != null && playerProvider.isPlaying();
    }

    public boolean isRemotePlayer() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            return playerProvider.isRemotePlayer();
        }
        return false;
    }

    public void muteOrUnmuteAudio(boolean z) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.muteOrUnmuteAudio(z);
        }
        if (this.d <= 0 || (mediaInstanceState = this.e) == null) {
            return;
        }
        mediaInstanceState.updatePlayStateByType(0, z);
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
        if (this.d > 0 && !CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, false) && (i == -30000 || i == -30001)) {
            MediaInstanceState mediaInstanceState = this.e;
            if (mediaInstanceState != null) {
                mediaInstanceState.setProcessDied(true);
            }
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.stop();
                this.a.release();
                if (a(true)) {
                    MediaInstanceState mediaInstanceState2 = this.e;
                    if (mediaInstanceState2 != null) {
                        if (mediaInstanceState2.getPlayingStatus()) {
                            start();
                        } else {
                            pause();
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("multi_instance_resume_process", "1");
                        sendCommand(1003, 0, 0L, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            }
        }
        if (this.d > 0) {
            MultiInstanceManager.getInstance().unRegisterInstance(this.d);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
            this.d = 0;
            this.e.release();
            this.e = null;
        }
        CyberPlayerManager.OnErrorListener onErrorListener = this.f;
        return onErrorListener != null && onErrorListener.onError(i, i2, obj);
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
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void pause() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.pause();
        }
        if (this.d > 0) {
            this.e.updatePlayingStatus(false);
            this.e.updateSeekPos(getCurrentPosition(), getDuration());
            MultiInstanceManager.getInstance().updateInstanceTimestamp(this.d, System.currentTimeMillis());
        }
    }

    public void prepareAsync() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.prepareAsync();
        }
    }

    public void preparseHostWithURI(Uri uri) {
        String host;
        if (!this.c || uri == null || (host = uri.getHost()) == null) {
            return;
        }
        String uri2 = uri.toString();
        if ((uri2.contains(".flv") || uri2.contains(".m3u8")) && CyberCfgManager.getInstance().a("use_httpdns_first", false)) {
            List<String> iPListWithHost = CyberPlayerManager.getIPListWithHost(host);
            CyberLog.d("CyberPlayer", "preparseHostWithURI ips: " + iPListWithHost);
            if (iPListWithHost == null || iPListWithHost.size() <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : iPListWithHost) {
                sb.append(str);
                sb.append(ParamableElem.DIVIDE_PARAM);
            }
            setOption(CyberPlayerManager.OPT_PREPARSE_IP, sb.toString());
        }
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
            MultiInstanceManager.getInstance().unRegisterInstance(this.d);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
            this.d = 0;
            this.e.release();
            this.e = null;
        }
        this.f = null;
        o.j();
        CyberCfgManager.getInstance().a();
    }

    public void reset() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.reset();
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        seekTo(j, 3);
    }

    public void seekTo(long j, int i) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.seekTo(j, i);
        }
    }

    public void sendCommand(int i, int i2, long j, String str) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.sendCommand(i, i2, j, str);
        }
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

    public void setDataSource(Context context, Uri uri) {
        if (this.a != null) {
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(context, uri);
            } else {
                this.a.setDataSource(context, Uri.parse(a));
            }
            preparseHostWithURI(uri);
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, null);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.a != null) {
            if (this.b) {
                map = o.a(map);
            }
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(context, uri, map);
            } else {
                this.a.setDataSource(context, Uri.parse(a), map);
            }
            preparseHostWithURI(uri);
        }
        if (this.d > 0) {
            this.e.updateDataSource(context, uri, map);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (this.a != null) {
            if (this.b) {
                map = o.a(map);
            }
            String a = CyberCfgManager.getInstance().a("force_url", (String) null);
            if (TextUtils.isEmpty(a)) {
                this.a.setDataSource(str, map);
            } else {
                this.a.setDataSource(a, map);
            }
        }
        if (this.d > 0) {
            this.e.updateDataSource(str, map);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setDisplay(surfaceHolder);
        }
        if (this.d <= 0 || surfaceHolder == null) {
            return;
        }
        this.e.updateSurface(surfaceHolder.getSurface());
    }

    public void setEnableDumediaUA(boolean z) {
        this.b = z;
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setEnableDumediaUA(z);
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
                jSONObject.put("is_feed_video", booleanValue ? "true" : CommandUBCHelper.COMMAND_UBC_VALUE_FALSE);
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
            int parseInt = !TextUtils.isEmpty(str2) ? Integer.parseInt(str2) : 0;
            map.remove("type");
            sendCommand(1003, parseInt, 0L, new JSONObject(map).toString());
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
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        MediaInstanceState mediaInstanceState;
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.setOnInfoListener(onInfoListener);
        }
        if (this.d <= 0 || (mediaInstanceState = this.e) == null) {
            return;
        }
        mediaInstanceState.setOnInfoListener(onInfoListener);
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

    public void start() {
        if (this.d > 0) {
            if (this.e.needActiveInstance()) {
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] active instance: " + this.d);
                if (MultiInstanceManager.getInstance().activeInstance(this.d) && this.a == null) {
                    onResumeInstance();
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

    public void stop() {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.stop();
        }
    }

    public void switchMediaSource(int i) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.switchMediaSource(i);
        }
        if (this.d > 0) {
            this.e.setMediaSourceRank(i);
        }
    }

    public void updateDisplaySize(int i, int i2) {
        PlayerProvider playerProvider = this.a;
        if (playerProvider != null) {
            playerProvider.updateDisplaySize(i, i2);
        }
    }
}
