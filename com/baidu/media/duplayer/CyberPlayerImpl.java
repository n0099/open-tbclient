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
/* loaded from: classes16.dex */
public class CyberPlayerImpl extends PlayerProvider implements IjkMediaPlayer.e, b.a, b.InterfaceC1127b, b.c, b.d, b.e, b.f, b.g, b.i {
    private CyberPlayerManager.OnPreparedListener b;
    private IjkMediaPlayer bYy;
    private CyberPlayerManager.OnMediaSourceChangedListener bYz;
    private CyberPlayerManager.OnCompletionListener c;
    private CyberPlayerManager.OnBufferingUpdateListener d;
    private CyberPlayerManager.OnSeekCompleteListener e;
    private CyberPlayerManager.OnVideoSizeChangedListener f;
    private CyberPlayerManager.OnErrorListener g;
    private CyberPlayerManager.OnInfoListener h;
    private String l;
    private int m;
    private boolean j = true;
    private boolean k = false;
    private long n = -1;
    private long o = -1;
    private int p = 0;
    private int q = 0;

    CyberPlayerImpl(int i, CyberPlayerManager.HttpDNS httpDNS) {
        try {
            this.bYy = new IjkMediaPlayer();
            this.m = i;
            this.bYy.c(this.m);
            this.bYy.a((b.f) this);
            this.bYy.a((b.InterfaceC1127b) this);
            this.bYy.a((b.a) this);
            this.bYy.a((b.g) this);
            this.bYy.a((b.i) this);
            this.bYy.a((b.c) this);
            this.bYy.a((b.d) this);
            this.bYy.a((IjkMediaPlayer.e) this);
            this.bYy.a(httpDNS);
            this.bYy.a((b.e) this);
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
        if (d() && this.j && !this.k) {
            this.bYy.a(1, "proxytcp-enable", 1L);
        } else {
            this.bYy.a(1, "proxytcp-enable", 0L);
        }
    }

    private boolean c() {
        return (CyberCfgManager.getInstance().getCfgBoolValue("pcdn_forbidden", false) || b.b() == null) ? false : true;
    }

    @Keep
    public static PlayerProvider create(int i, CyberPlayerManager.HttpDNS httpDNS) {
        int a2 = a(i);
        if (a2 == 4) {
            return null;
        }
        return new CyberPlayerImpl(a2, httpDNS);
    }

    private boolean d() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_FILE_CACHE, true) && !CyberCfgManager.getInstance().isBlackUrl(this.l);
    }

    private void e() {
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_BSO, false)) {
            this.bYy.a(1, "bso_enable", 1L);
            int random = ((int) (Math.random() * 12.0d)) + 3;
            if (random > 0) {
                this.bYy.a(1, "min_buffer_frame_size", random);
            }
        }
    }

    private boolean f() {
        return (this.bYy == null || this.p == -1 || this.p == 0 || this.p == 1) ? false : true;
    }

    private boolean g() {
        return (this.bYy == null || this.p == 0 || this.p == 1) ? false : true;
    }

    private long jn(String str) {
        try {
            return Math.min(Math.max(Long.parseLong(str), 1048576L), 20971520L);
        } catch (Exception e) {
            return PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.f
    public void a(tv.danmaku.ijk.media.player.b bVar) {
        this.p = 2;
        if (this.b != null) {
            this.b.onPrepared();
        }
        if (this.o > 0) {
            seekTo(this.o);
        }
        this.o = -1L;
        if (this.q == 3 && this.p == 2) {
            start();
        } else if (this.q == 4 && this.p == 2) {
            pause();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.a
    public void a(tv.danmaku.ijk.media.player.b bVar, int i) {
        if (this.d != null) {
            this.d.onBufferingUpdate(i);
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.i
    public void a(tv.danmaku.ijk.media.player.b bVar, int i, int i2, int i3, int i4) {
        if (this.f != null) {
            this.f.onVideoSizeChanged(i, i2, i3, i4);
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
        this.p = -1;
        this.q = -1;
        return this.g != null && this.g.onError(i, i2, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.InterfaceC1127b
    public void b(tv.danmaku.ijk.media.player.b bVar) {
        this.p = 5;
        this.q = 5;
        if (this.c != null) {
            this.c.onCompletion();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.d
    public boolean b(tv.danmaku.ijk.media.player.b bVar, int i, int i2, Object obj) {
        CyberLog.v("CyberPlayerImpl", "onInfo what:" + i + " extra:" + i2 + " obj:" + obj);
        if (i == 10102) {
            this.m = i2;
        }
        return this.h != null && this.h.onInfo(i, i2, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.g
    public void c(tv.danmaku.ijk.media.player.b bVar) {
        this.n = -1L;
        if (this.e != null) {
            this.e.onSeekComplete();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.e
    public boolean c(tv.danmaku.ijk.media.player.b bVar, int i, int i2, Object obj) {
        return this.bYz != null && this.bYz.onMediaSourceChanged(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        if (this.bYy != null) {
            if (!TextUtils.isEmpty(str)) {
                str = "http://" + str;
            }
            this.bYy.a(str, z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.bYy != null) {
            return this.n > -1 ? (int) this.n : (int) this.bYy.m();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        if (this.bYy != null) {
            return this.n > -1 ? (int) this.n : (int) this.bYy.n();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return this.m;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        if (f()) {
            return this.bYy.t();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (g()) {
            return (int) this.bYy.o();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (g()) {
            return this.bYy.s();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        if (this.bYy != null) {
            return this.bYy.l();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        if (this.bYy != null) {
            return this.bYy.k();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        return this.bYy != null && this.bYy.r();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        return f() && this.p == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bYy != null) {
            this.bYy.d(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        if (f()) {
            if (this.p != 4) {
                this.p = 4;
                this.bYy.j();
            }
        } else if (this.bYy != null) {
            sendCommand(1000, 0, 0L, null);
        }
        this.q = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        if (this.bYy != null) {
            this.p = 1;
            a();
            b();
            e();
            this.bYy.g();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        if (this.bYy != null) {
            this.o = -1L;
            this.p = 0;
            this.q = 0;
            this.bYy.p();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        this.o = -1L;
        this.n = -1L;
        this.p = 0;
        this.q = 0;
        if (this.bYy != null) {
            this.bYy.q();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        if (this.bYy != null) {
            if (f()) {
                this.bYy.a(j);
            } else {
                this.o = j;
            }
            this.n = j;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        if (this.bYy == null) {
            return;
        }
        switch (i) {
            case 1000:
                this.bYy.c(i2 == 1);
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
                        this.bYy.b(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
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
                        this.bYy.b(i2, next2, jSONObject2.getString(next2));
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        if (this.bYy != null) {
            this.bYy.c(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.bYy != null) {
            try {
                this.l = uri.getHost();
                this.bYy.a(context, uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.bYy != null) {
            try {
                this.l = uri.getHost();
                this.bYy.a(context, uri, map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.bYy != null) {
            try {
                this.bYy.b(fileDescriptor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        if (this.bYy != null) {
            try {
                this.l = str;
                this.bYy.b(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        if (this.bYy != null) {
            try {
                this.l = str;
                this.bYy.a(str, map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.bYy != null) {
            this.bYy.a(surfaceHolder);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.bYy != null) {
            this.bYy.b(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.d = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.c = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.g = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.h = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.bYz = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.b = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.e = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        if (this.bYy != null) {
            if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                this.bYy.a(1, str, j);
            } else {
                this.bYy.a(4, str, j);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        CyberLog.v("CyberPlayerImpl", "setOption: " + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        if (this.bYy != null) {
            if (str.equals(CyberPlayerManager.OPT_FILE_MIN_SIZE)) {
                this.bYy.a(1, str, a(str2));
            } else if (str.equals(CyberPlayerManager.OPT_FILE_MAX_SIZE)) {
                this.bYy.a(1, str, b(str2));
            } else if (str.equals(CyberPlayerManager.OPT_BUFFER_SIZE)) {
                this.bYy.a(4, str, jn(str2));
            } else if (str.equals(CyberPlayerManager.OPT_HTTP_PROXY)) {
                this.bYy.a(1, str, "http://" + str2);
            } else if (str.equals(CyberPlayerManager.OPT_NEED_T5_AUTH)) {
                this.bYy.a(1, str, Boolean.parseBoolean(str2) ? 1L : 0L);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_FILECACHE)) {
                this.j = Boolean.parseBoolean(str2);
            } else if (str.equals(CyberPlayerManager.OPT_IS_LIVE_VIDEO)) {
                this.k = Boolean.valueOf(str2).booleanValue();
            } else if (str.equals(CyberPlayerManager.OPT_SUPPORT_PROCESS)) {
                this.bYy.a(1, str, Boolean.parseBoolean(str2) ? 1L : 0L);
            } else if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                this.bYy.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
                if (c()) {
                    PcdnApi.nativePcdnInit(b.b(), Long.parseLong(str2));
                }
            } else if (str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
                KernelNetApi.nativeKernelNetInit(Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_PREBUFFER)) {
                this.bYy.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_PCDN)) {
                if (c()) {
                    this.bYy.a(1, str, Long.parseLong(str2));
                }
                this.bYy.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "pcdn_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_P2P)) {
                if (c()) {
                    this.bYy.a(1, str, Long.parseLong(str2));
                }
                this.bYy.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "p2p_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_ENABLE_KERNEL_NET)) {
                this.bYy.a(1, str, Long.parseLong(str2));
                this.bYy.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "kernel_net_enable", str2);
            } else if (str.equals(CyberPlayerManager.OPT_PCDN_TYPE)) {
                this.bYy.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_FILE_SIZE)) {
                this.bYy.a(1, str, Long.parseLong(str2));
            } else if (str.equals(CyberPlayerManager.OPT_STAGE_TYPE)) {
                this.bYy.a(1, str, str2);
            } else if (!str.equals(CyberPlayerManager.OPT_SR_OPTION)) {
                if (str.equals(CyberPlayerManager.OPT_NEED_HTTP_REFERER)) {
                    this.bYy.a(1, str, str2);
                } else {
                    this.bYy.a(4, str, str2);
                }
            } else if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
                this.bYy.a(1, str, str2);
                CyberLog.v("CyberPlayerImpl", "enable sr");
            } else {
                this.bYy.a(1, str, 0L);
                CyberLog.v("CyberPlayerImpl", "disable sr");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        if (this.bYy != null) {
            this.bYy.a(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.bYy != null) {
            this.bYy.a(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (this.bYy != null) {
            this.bYy.a(f);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.bYy != null) {
            this.bYy.a(surface);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.bYy != null) {
            this.bYy.a(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        if (this.bYy != null) {
            this.bYy.a(context, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        if (f()) {
            this.p = 3;
            this.bYy.h();
        } else if (this.bYy != null) {
            sendCommand(1000, 1, 0L, null);
        }
        this.q = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        if (this.bYy != null) {
            this.o = -1L;
            this.p = 0;
            this.q = 0;
            this.bYy.i();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i) {
        if (this.bYy != null) {
            this.bYy.b(i);
        }
    }
}
