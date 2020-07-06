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
import com.baidu.media.kernelnet.KernelNetApi;
import com.baidu.media.pcdn.PcdnApi;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.b;
/* loaded from: classes.dex */
public class CyberPlayerImpl extends PlayerProvider implements IjkMediaPlayer.e, b.a, b.InterfaceC0947b, b.c, b.d, b.e, b.f, b.h {
    private IjkMediaPlayer buk;
    private CyberPlayerManager.OnPreparedListener bul;
    private CyberPlayerManager.OnCompletionListener bum;
    private CyberPlayerManager.OnBufferingUpdateListener bun;
    private CyberPlayerManager.OnSeekCompleteListener buo;
    private CyberPlayerManager.OnVideoSizeChangedListener bup;
    private CyberPlayerManager.OnErrorListener buq;
    private CyberPlayerManager.OnInfoListener bur;
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
            this.buk = new IjkMediaPlayer();
            this.l = i;
            this.buk.b(this.l);
            this.buk.a((b.e) this);
            this.buk.a((b.InterfaceC0947b) this);
            this.buk.a((b.a) this);
            this.buk.a((b.f) this);
            this.buk.a((b.h) this);
            this.buk.a((b.c) this);
            this.buk.a((b.d) this);
            this.buk.a((IjkMediaPlayer.e) this);
            this.buk.a(httpDNS);
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }

    private static int a(int i) {
        if (i != 4) {
            int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("decode_mode", i);
            if ((cfgIntValue == 2 || cfgIntValue == 0) && !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_HW_DECODE, true)) {
                return 1;
            }
            return cfgIntValue;
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
            this.buk.a(1, "proxytcp-enable", 1L);
        } else {
            this.buk.a(1, "proxytcp-enable", 0L);
        }
    }

    private boolean c() {
        return (CyberCfgManager.getInstance().getCfgBoolValue("pcdn_forbidden", false) || b.b() == null) ? false : true;
    }

    @Keep
    public static PlayerProvider create(int i, CyberPlayerManager.HttpDNS httpDNS) {
        int a = a(i);
        if (a == 4) {
            return null;
        }
        return new CyberPlayerImpl(a, httpDNS);
    }

    private boolean d() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_FILE_CACHE, true) && !CyberCfgManager.getInstance().isBlackUrl(this.k);
    }

    private boolean e() {
        return (this.buk == null || this.o == -1 || this.o == 0 || this.o == 1) ? false : true;
    }

    private boolean f() {
        return (this.buk == null || this.o == 0 || this.o == 1) ? false : true;
    }

    private long gp(String str) {
        try {
            return Math.min(Math.max(Long.parseLong(str), 1048576L), 20971520L);
        } catch (Exception e) {
            return PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.e
    public void a(tv.danmaku.ijk.media.player.b bVar) {
        this.o = 2;
        if (this.bul != null) {
            this.bul.onPrepared();
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
        if (this.bun != null) {
            this.bun.onBufferingUpdate(i);
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.h
    public void a(tv.danmaku.ijk.media.player.b bVar, int i, int i2, int i3, int i4) {
        if (this.bup != null) {
            this.bup.onVideoSizeChanged(i, i2, i3, i4);
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
        return this.buq != null && this.buq.onError(i, i2, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.InterfaceC0947b
    public void b(tv.danmaku.ijk.media.player.b bVar) {
        this.o = 5;
        this.p = 5;
        if (this.bum != null) {
            this.bum.onCompletion();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.d
    public boolean b(tv.danmaku.ijk.media.player.b bVar, int i, int i2, Object obj) {
        CyberLog.v("CyberPlayerImpl", "onInfo what:" + i + " extra:" + i2 + " obj:" + obj);
        return this.bur != null && this.bur.onInfo(i, i2, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.f
    public void c(tv.danmaku.ijk.media.player.b bVar) {
        this.m = -1L;
        if (this.buo != null) {
            this.buo.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        if (this.buk != null) {
            if (!TextUtils.isEmpty(str)) {
                str = "http://" + str;
            }
            this.buk.a(str, z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.buk != null) {
            return this.m > -1 ? (int) this.m : (int) this.buk.m();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        if (this.buk != null) {
            return this.m > -1 ? (int) this.m : (int) this.buk.n();
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
            return this.buk.t();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (f()) {
            return (int) this.buk.o();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (f()) {
            return this.buk.s();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        if (this.buk != null) {
            return this.buk.l();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        if (this.buk != null) {
            return this.buk.k();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        return this.buk != null && this.buk.r();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        return e() && this.o == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        if (this.buk != null) {
            this.buk.d(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        if (e()) {
            if (this.o != 4) {
                this.o = 4;
                this.buk.j();
            }
        } else if (this.buk != null) {
            sendCommand(1000, 0, 0L, null);
        }
        this.p = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        if (this.buk != null) {
            this.o = 1;
            a();
            b();
            this.buk.g();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        if (this.buk != null) {
            this.n = -1L;
            this.o = 0;
            this.p = 0;
            this.bul = null;
            this.bum = null;
            this.bun = null;
            this.buo = null;
            this.bup = null;
            this.buq = null;
            this.bur = null;
            this.buk.p();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        this.n = -1L;
        this.m = -1L;
        this.o = 0;
        this.p = 0;
        if (this.buk != null) {
            this.buk.q();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        if (this.buk != null) {
            if (e()) {
                this.buk.a(j);
            } else {
                this.n = j;
            }
            this.m = j;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        if (this.buk == null) {
            return;
        }
        switch (i) {
            case 1000:
                this.buk.c(i2 == 1);
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
                        this.buk.b(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
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
                if (i2 == 0) {
                    i2 = DpStatConstants.SESSION_TYPE_PLAY_COMMON;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        this.buk.b(i2, next2, jSONObject2.getString(next2));
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.buk != null) {
            try {
                this.k = uri.getHost();
                this.buk.a(context, uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.buk != null) {
            try {
                this.k = uri.getHost();
                this.buk.a(context, uri, map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.buk != null) {
            try {
                this.buk.b(fileDescriptor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        if (this.buk != null) {
            try {
                this.k = str;
                this.buk.a(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.buk != null) {
            this.buk.a(surfaceHolder);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.buk != null) {
            this.buk.b(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.bun = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.bum = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.buq = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.bur = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.bul = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.buo = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.bup = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        if (this.buk != null) {
            if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                this.buk.a(1, str, j);
            } else {
                this.buk.a(4, str, j);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        CyberLog.v("CyberPlayerImpl", "setOption: " + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        if (this.buk != null) {
            if (str.equals(CyberPlayerManager.OPT_FILE_MIN_SIZE)) {
                this.buk.a(1, str, a(str2));
            } else if (str.equals(CyberPlayerManager.OPT_FILE_MAX_SIZE)) {
                this.buk.a(1, str, b(str2));
            } else if (str.equals(CyberPlayerManager.OPT_BUFFER_SIZE)) {
                this.buk.a(4, str, gp(str2));
            } else if (str.equals(CyberPlayerManager.OPT_HTTP_PROXY)) {
                this.buk.a(1, str, "http://" + str2);
            } else if (str.equals(CyberPlayerManager.OPT_NEED_T5_AUTH)) {
                this.buk.a(1, str, Boolean.parseBoolean(str2) ? 1L : 0L);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_FILECACHE)) {
                this.i = Boolean.parseBoolean(str2);
            } else if (str.equals(CyberPlayerManager.OPT_IS_LIVE_VIDEO)) {
                this.j = Boolean.valueOf(str2).booleanValue();
                if (this.j) {
                }
            } else if (str.equals(CyberPlayerManager.OPT_SUPPORT_PROCESS)) {
                this.buk.a(1, str, Boolean.parseBoolean(str2) ? 1L : 0L);
            } else if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                this.buk.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
                if (c()) {
                    PcdnApi.nativePcdnInit(b.b(), Long.parseLong(str2));
                }
            } else if (str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
                KernelNetApi.nativeKernelNetInit(Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_PCDN)) {
                if (c()) {
                    this.buk.a(1, str, Long.parseLong(str2));
                }
                this.buk.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "pcdn_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_P2P)) {
                if (c()) {
                    this.buk.a(1, str, Long.parseLong(str2));
                }
                this.buk.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "p2p_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_KERNEL_NET)) {
                this.buk.a(1, str, Long.parseLong(str2));
                this.buk.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "kernel_net_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_PCDN_TYPE)) {
                this.buk.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_FILE_SIZE)) {
                this.buk.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_STAGE_TYPE)) {
                this.buk.a(1, str, str2);
            } else if (!str.equals(CyberPlayerManager.OPT_SR_OPTION)) {
                this.buk.a(4, str, str2);
            } else if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
                this.buk.a(1, str, str2);
                CyberLog.v("CyberPlayerImpl", "enable sr");
            } else {
                this.buk.a(1, str, 0L);
                CyberLog.v("CyberPlayerImpl", "disable sr");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.buk != null) {
            this.buk.a(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (this.buk != null) {
            this.buk.a(f);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.buk != null) {
            this.buk.a(surface);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.buk != null) {
            this.buk.a(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        if (this.buk != null) {
            this.buk.a(context, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        if (e()) {
            this.o = 3;
            this.buk.h();
        } else if (this.buk != null) {
            sendCommand(1000, 1, 0L, null);
        }
        this.p = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        if (this.buk != null) {
            this.n = -1L;
            this.o = 0;
            this.p = 0;
            this.buk.i();
        }
    }
}
