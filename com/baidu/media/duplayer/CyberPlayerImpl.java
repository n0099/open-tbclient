package com.baidu.media.duplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.media.pcdn.PcdnApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.b;
/* loaded from: classes.dex */
public class CyberPlayerImpl extends PlayerProvider implements IjkMediaPlayer.e, b.a, b.InterfaceC0819b, b.c, b.d, b.e, b.f, b.h {
    private IjkMediaPlayer aLH;
    private CyberPlayerManager.OnPreparedListener aLI;
    private CyberPlayerManager.OnCompletionListener aLJ;
    private CyberPlayerManager.OnBufferingUpdateListener aLK;
    private CyberPlayerManager.OnSeekCompleteListener aLL;
    private CyberPlayerManager.OnVideoSizeChangedListener aLM;
    private CyberPlayerManager.OnErrorListener aLN;
    private CyberPlayerManager.OnInfoListener aLO;
    private String k;
    private int l;
    private boolean i = true;
    private boolean j = false;
    private long m = -1;
    private long n = -1;
    private int o = 0;
    private int p = 0;

    CyberPlayerImpl(int i, CyberPlayerManager.HttpDNS httpDNS) {
        try {
            this.aLH = new IjkMediaPlayer();
            this.l = i;
            this.aLH.b(this.l);
            this.aLH.a((b.e) this);
            this.aLH.a((b.InterfaceC0819b) this);
            this.aLH.a((b.a) this);
            this.aLH.a((b.f) this);
            this.aLH.a((b.h) this);
            this.aLH.a((b.c) this);
            this.aLH.a((b.d) this);
            this.aLH.a((IjkMediaPlayer.e) this);
            this.aLH.a(httpDNS);
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }

    private static int a(int i) {
        if (i != 4) {
            int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("decode_mode", i);
            if (cfgIntValue != 2 || CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_HW_DECODE, true)) {
                return cfgIntValue;
            }
            return 1;
        }
        return i;
    }

    private long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                return parseLong;
            }
            return 512000L;
        } catch (Exception e) {
            return 512000L;
        }
    }

    private long b(String str) {
        try {
            return Math.max(Long.parseLong(str), 3145728L);
        } catch (Exception e) {
            return 3145728L;
        }
    }

    private void b() {
        if (d() && this.i && !this.j) {
            this.aLH.a(1, "proxytcp-enable", 1L);
        } else {
            this.aLH.a(1, "proxytcp-enable", 0L);
        }
    }

    private boolean c() {
        return (CyberCfgManager.getInstance().getCfgBoolValue("pcdn_forbidden", false) || a.a() == null) ? false : true;
    }

    @Keep
    public static PlayerProvider create(int i, CyberPlayerManager.HttpDNS httpDNS) {
        int a = a(i);
        if (a == 4) {
            return null;
        }
        CyberCfgManager.getInstance().init();
        return new CyberPlayerImpl(a, httpDNS);
    }

    private boolean d() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_FILE_CACHE, true) && !CyberCfgManager.getInstance().isBlackUrl(this.k);
    }

    private boolean e() {
        return (this.aLH == null || this.o == -1 || this.o == 0 || this.o == 1) ? false : true;
    }

    private long eC(String str) {
        try {
            return Math.min(Math.max(Long.parseLong(str), 1048576L), 20971520L);
        } catch (Exception e) {
            return PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
    }

    private boolean f() {
        return (this.aLH == null || this.o == 0 || this.o == 1) ? false : true;
    }

    @Override // tv.danmaku.ijk.media.player.b.e
    public void a(tv.danmaku.ijk.media.player.b bVar) {
        this.o = 2;
        if (this.aLI != null) {
            this.aLI.onPrepared();
        }
        if (this.n > 0) {
            seekTo(this.n);
        }
        this.n = -1L;
        if (this.p == 3 && this.o == 2) {
            start();
        } else if (this.p == 4 && this.o == 2) {
            pause();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.a
    public void a(tv.danmaku.ijk.media.player.b bVar, int i) {
        if (this.aLK != null) {
            this.aLK.onBufferingUpdate(i);
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.h
    public void a(tv.danmaku.ijk.media.player.b bVar, int i, int i2, int i3, int i4) {
        if (this.aLM != null) {
            this.aLM.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    public boolean a() {
        String b = Utils.b();
        if (b == null || b.length() <= 0) {
            return false;
        }
        setOption(CyberPlayerManager.OPT_HTTP_PROXY, b);
        setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.e
    public boolean a(int i, Bundle bundle) {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.b.c
    public boolean a(tv.danmaku.ijk.media.player.b bVar, int i, int i2, Object obj) {
        this.o = -1;
        this.p = -1;
        return this.aLN != null && this.aLN.onError(i, i2, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.InterfaceC0819b
    public void b(tv.danmaku.ijk.media.player.b bVar) {
        this.o = 5;
        this.p = 5;
        if (this.aLJ != null) {
            this.aLJ.onCompletion();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.d
    public boolean b(tv.danmaku.ijk.media.player.b bVar, int i, int i2, Object obj) {
        CyberLog.v("CyberPlayerImpl", "onInfo what:" + i + " extra:" + i2 + " obj:" + obj);
        return this.aLO != null && this.aLO.onInfo(i, i2, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.f
    public void c(tv.danmaku.ijk.media.player.b bVar) {
        this.m = -1L;
        if (this.aLL != null) {
            this.aLL.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        if (this.aLH != null) {
            if (!TextUtils.isEmpty(str)) {
                str = "http://" + str;
            }
            this.aLH.a(str, z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.aLH != null) {
            return this.m > -1 ? (int) this.m : (int) this.aLH.m();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        if (this.aLH != null) {
            return this.m > -1 ? (int) this.m : (int) this.aLH.n();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return this.l;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        if (e()) {
            return this.aLH.t();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (f()) {
            return (int) this.aLH.o();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (f()) {
            return this.aLH.s();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        if (this.aLH != null) {
            return this.aLH.l();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        if (this.aLH != null) {
            return this.aLH.k();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        return this.aLH != null && this.aLH.r();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        return e() && this.o == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        if (this.aLH != null) {
            this.aLH.d(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        if (e()) {
            this.o = 4;
            this.aLH.j();
        } else if (this.aLH != null) {
            sendCommand(1000, 0, 0L, null);
        }
        this.p = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        if (this.aLH != null) {
            this.o = 1;
            a();
            b();
            this.aLH.g();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        if (this.aLH != null) {
            this.n = -1L;
            this.o = 0;
            this.p = 0;
            this.aLH.p();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        this.n = -1L;
        this.m = -1L;
        this.o = 0;
        this.p = 0;
        if (this.aLH != null) {
            this.aLH.q();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        if (this.aLH != null) {
            if (e()) {
                this.aLH.a(j);
            } else {
                this.n = j;
            }
            this.m = j;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        if (this.aLH == null) {
            return;
        }
        switch (i) {
            case 1000:
                this.aLH.c(i2 == 1);
                return;
            case 1001:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.aLH.b(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            case 1002:
            default:
                return;
            case 1003:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        this.aLH.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, next2, jSONObject2.getString(next2));
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            case 1004:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject3 = new JSONObject(str);
                    Iterator<String> keys3 = jSONObject3.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        this.aLH.b(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, next3, jSONObject3.getString(next3));
                    }
                    return;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.aLH != null) {
            try {
                this.k = uri.getHost();
                this.aLH.a(context, uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.aLH != null) {
            try {
                this.k = uri.getHost();
                this.aLH.a(context, uri, map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.aLH != null) {
            try {
                this.aLH.b(fileDescriptor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        if (this.aLH != null) {
            try {
                this.k = str;
                this.aLH.a(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.aLH != null) {
            this.aLH.a(surfaceHolder);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.aLH != null) {
            this.aLH.b(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.aLK = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.aLJ = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.aLN = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.aLO = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.aLI = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.aLL = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.aLM = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        if (this.aLH != null) {
            if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                this.aLH.a(1, str, j);
            } else {
                this.aLH.a(4, str, j);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        if (this.aLH != null) {
            if (str.equals(CyberPlayerManager.OPT_FILE_MIN_SIZE)) {
                this.aLH.a(1, str, a(str2));
            } else if (str.equals(CyberPlayerManager.OPT_FILE_MAX_SIZE)) {
                this.aLH.a(1, str, b(str2));
            } else if (str.equals(CyberPlayerManager.OPT_BUFFER_SIZE)) {
                this.aLH.a(4, str, eC(str2));
            } else if (str.equals(CyberPlayerManager.OPT_HTTP_PROXY)) {
                this.aLH.a(1, str, "http://" + str2);
            } else if (str.equals(CyberPlayerManager.OPT_NEED_T5_AUTH)) {
                this.aLH.a(1, str, Boolean.parseBoolean(str2) ? 1L : 0L);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_FILECACHE)) {
                this.i = Boolean.parseBoolean(str2);
            } else if (str.equals(CyberPlayerManager.OPT_IS_LIVE_VIDEO)) {
                this.j = Boolean.valueOf(str2).booleanValue();
                if (this.j) {
                    this.aLH.a(1, "opt-init-video-delay", 0L);
                    this.aLH.a(1, "opt-open-audio-delay", 0L);
                }
            } else if (str.equals(CyberPlayerManager.OPT_SUPPORT_PROCESS)) {
                this.aLH.a(1, str, Boolean.parseBoolean(str2) ? 1L : 0L);
            } else if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                this.aLH.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
                if (c()) {
                    PcdnApi.nativePcdnInit(a.a(), Long.parseLong(str2));
                }
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_PCDN)) {
                if (c()) {
                    this.aLH.a(1, str, Long.parseLong(str2));
                }
                this.aLH.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "pcdn_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_P2P)) {
                if (c()) {
                    this.aLH.a(1, str, Long.parseLong(str2));
                }
                this.aLH.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "p2p_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_PCDN_TYPE)) {
                this.aLH.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_FILE_SIZE)) {
                this.aLH.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_STAGE_TYPE)) {
                this.aLH.a(1, str, str2);
            } else {
                this.aLH.a(4, str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.aLH != null) {
            this.aLH.a(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (this.aLH != null) {
            this.aLH.a(f);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.aLH != null) {
            this.aLH.a(surface);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.aLH != null) {
            this.aLH.a(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        if (this.aLH != null) {
            this.aLH.a(context, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        if (e()) {
            this.o = 3;
            this.aLH.h();
        } else if (this.aLH != null) {
            sendCommand(1000, 1, 0L, null);
        }
        this.p = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        if (this.aLH != null) {
            this.n = -1L;
            this.o = 0;
            this.p = 0;
            this.aLH.i();
        }
    }
}
