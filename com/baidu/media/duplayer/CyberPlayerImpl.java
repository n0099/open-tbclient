package com.baidu.media.duplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.media.kernelnet.KernelNetApi;
import com.baidu.media.pcdn.PcdnApi;
import d.a.w.a.c;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.b;
/* loaded from: classes2.dex */
public class CyberPlayerImpl extends PlayerProvider implements IjkMediaPlayer.e, b.a, b.InterfaceC1891b, b.c, b.d, b.e, b.f, b.g, b.i {

    /* renamed from: e  reason: collision with root package name */
    public IjkMediaPlayer f8257e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f8258f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f8259g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f8260h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f8261i;
    public CyberPlayerManager.OnVideoSizeChangedListener j;
    public CyberPlayerManager.OnErrorListener k;
    public CyberPlayerManager.OnInfoListener l;
    public CyberPlayerManager.OnMediaSourceChangedListener m;
    public String p;
    public int q;
    public boolean n = true;
    public boolean o = false;
    public long r = -1;
    public long s = -1;
    public int t = 0;
    public int u = 0;

    public CyberPlayerImpl(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        try {
            IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
            this.f8257e = ijkMediaPlayer;
            this.q = i2;
            ijkMediaPlayer.c(i2);
            this.f8257e.a((b.f) this);
            this.f8257e.a((b.InterfaceC1891b) this);
            this.f8257e.a((b.a) this);
            this.f8257e.a((b.g) this);
            this.f8257e.a((b.i) this);
            this.f8257e.a((b.c) this);
            this.f8257e.a((b.d) this);
            this.f8257e.a((IjkMediaPlayer.e) this);
            this.f8257e.a(httpDNS);
            this.f8257e.a((b.e) this);
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }

    public static int c(int i2) {
        if (i2 != 4) {
            int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("decode_mode", i2);
            if ((cfgIntValue == 2 || cfgIntValue == 0) && !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_HW_DECODE, true)) {
                return 1;
            }
            return cfgIntValue;
        }
        return i2;
    }

    @Keep
    public static PlayerProvider create(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        int c2 = c(i2);
        if (c2 == 4) {
            return null;
        }
        return new CyberPlayerImpl(c2, httpDNS);
    }

    @Override // tv.danmaku.ijk.media.player.b.f
    public void a(b bVar) {
        this.t = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.f8258f;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        long j = this.s;
        if (j > 0) {
            seekTo(j);
        }
        this.s = -1L;
        if (this.u == 3 && this.t == 2) {
            start();
        } else if (this.u == 4 && this.t == 2) {
            pause();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.a
    public void a(b bVar, int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.f8260h;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i2);
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.i
    public void a(b bVar, int i2, int i3, int i4, int i5) {
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.j;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.e
    public boolean a(int i2, Bundle bundle) {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.b.c
    public boolean a(b bVar, int i2, int i3, Object obj) {
        this.t = -1;
        this.u = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.k;
        return onErrorListener != null && onErrorListener.onError(i2, i3, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.InterfaceC1891b
    public void b(b bVar) {
        this.t = 5;
        this.u = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.f8259g;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.d
    public boolean b(b bVar, int i2, int i3, Object obj) {
        CyberLog.v("CyberPlayerImpl", "onInfo what:" + i2 + " extra:" + i3 + " obj:" + obj);
        if (i2 == 10102) {
            this.q = i3;
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.l;
        return onInfoListener != null && onInfoListener.onInfo(i2, i3, obj);
    }

    @Override // tv.danmaku.ijk.media.player.b.g
    public void c(b bVar) {
        this.r = -1L;
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.f8261i;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.e
    public boolean c(b bVar, int i2, int i3, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.m;
        return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        if (this.f8257e != null) {
            if (!TextUtils.isEmpty(str)) {
                str = "http://" + str;
            }
            this.f8257e.a(str, z);
        }
    }

    public final long d(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                return parseLong;
            }
            return 512000L;
        } catch (Exception unused) {
            return 512000L;
        }
    }

    public final boolean d() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_FILE_CACHE, true) && !CyberCfgManager.getInstance().isBlackUrl(this.p);
    }

    public final void e() {
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_BSO, false)) {
            this.f8257e.a(1, "bso_enable", 1L);
            int random = ((int) (Math.random() * 12.0d)) + 3;
            if (random > 0) {
                this.f8257e.a(1, "min_buffer_frame_size", random);
            }
        }
    }

    public boolean f() {
        String i2 = Utils.i();
        if (i2 == null || i2.length() <= 0) {
            return false;
        }
        setOption(CyberPlayerManager.OPT_HTTP_PROXY, i2);
        setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        return true;
    }

    public final long g(String str) {
        try {
            return Math.max(Long.parseLong(str), 3145728L);
        } catch (Exception unused) {
            return 3145728L;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            long j = this.r;
            return j > -1 ? (int) j : (int) ijkMediaPlayer.m();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            long j = this.r;
            return j > -1 ? (int) j : (int) ijkMediaPlayer.n();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return this.q;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        if (k()) {
            return this.f8257e.t();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (l()) {
            return (int) this.f8257e.o();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (l()) {
            return this.f8257e.s();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.l();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.k();
        }
        return 0;
    }

    public final void h() {
        IjkMediaPlayer ijkMediaPlayer;
        long j;
        if (d() && this.n && !this.o) {
            ijkMediaPlayer = this.f8257e;
            j = 1;
        } else {
            ijkMediaPlayer = this.f8257e;
            j = 0;
        }
        ijkMediaPlayer.a(1, "proxytcp-enable", j);
    }

    public final long i(String str) {
        try {
            return Math.min(Math.max(Long.parseLong(str), 1048576L), (long) DownloadManager.MIN_LEFT_SIZE);
        } catch (Exception unused) {
            return 2097152L;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        return ijkMediaPlayer != null && ijkMediaPlayer.r();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        return k() && this.t == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    public final boolean j() {
        return (CyberCfgManager.getInstance().getCfgBoolValue("pcdn_forbidden", false) || c.g() == null) ? false : true;
    }

    public final boolean k() {
        int i2;
        return (this.f8257e == null || (i2 = this.t) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public final boolean l() {
        int i2;
        return (this.f8257e == null || (i2 = this.t) == 0 || i2 == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.d(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        if (k()) {
            if (this.t != 4) {
                this.t = 4;
                this.f8257e.j();
            }
        } else if (this.f8257e != null) {
            sendCommand(1000, 0, 0L, null);
        }
        this.u = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        if (this.f8257e != null) {
            this.t = 1;
            f();
            h();
            e();
            this.f8257e.g();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            this.s = -1L;
            this.t = 0;
            this.u = 0;
            ijkMediaPlayer.p();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        this.s = -1L;
        this.r = -1L;
        this.t = 0;
        this.u = 0;
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.q();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        if (this.f8257e != null) {
            if (k()) {
                this.f8257e.a(j);
            } else {
                this.s = j;
            }
            this.r = j;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i2, int i3, long j, String str) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer == null) {
            return;
        }
        if (i2 == 1000) {
            ijkMediaPlayer.c(i3 == 1);
            return;
        }
        try {
            if (i2 == 1001) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.f8257e.b(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                }
            } else if (i2 == 1003 && !TextUtils.isEmpty(str)) {
                if (i3 == 0) {
                    i3 = DpStatConstants.SESSION_TYPE_PLAY_COMMON;
                }
                JSONObject jSONObject2 = new JSONObject(str);
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    this.f8257e.b(i3, next2, jSONObject2.getString(next2));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.c(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.f8257e != null) {
            try {
                this.p = uri.getHost();
                this.f8257e.a(context, uri);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f8257e != null) {
            try {
                this.p = uri.getHost();
                this.f8257e.a(context, uri, map);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            try {
                ijkMediaPlayer.b(fileDescriptor);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            try {
                this.p = str;
                ijkMediaPlayer.b(str);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            try {
                this.p = str;
                ijkMediaPlayer.a(str, map);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.a(surfaceHolder);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.b(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f8260h = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f8259g = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.k = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.l = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.m = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f8258f = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f8261i = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.j = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        IjkMediaPlayer ijkMediaPlayer;
        int i2;
        if (this.f8257e != null) {
            if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                ijkMediaPlayer = this.f8257e;
                i2 = 1;
            } else {
                ijkMediaPlayer = this.f8257e;
                i2 = 4;
            }
            ijkMediaPlayer.a(i2, str, j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008c, code lost:
        if (java.lang.Boolean.parseBoolean(r10) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
        r0.a(1, r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (java.lang.Boolean.parseBoolean(r10) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:?, code lost:
        return;
     */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setOption(String str, String str2) {
        IjkMediaPlayer ijkMediaPlayer;
        long parseLong;
        String str3;
        IjkMediaPlayer ijkMediaPlayer2;
        IjkMediaPlayer ijkMediaPlayer3;
        String str4;
        IjkMediaPlayer ijkMediaPlayer4;
        CyberLog.v("CyberPlayerImpl", "setOption: " + str + "," + str2);
        if (this.f8257e != null) {
            if (str.equals(CyberPlayerManager.OPT_FILE_MIN_SIZE)) {
                ijkMediaPlayer = this.f8257e;
                parseLong = d(str2);
            } else if (!str.equals(CyberPlayerManager.OPT_FILE_MAX_SIZE)) {
                if (str.equals(CyberPlayerManager.OPT_BUFFER_SIZE)) {
                    this.f8257e.a(4, str, i(str2));
                    return;
                }
                if (str.equals(CyberPlayerManager.OPT_HTTP_PROXY)) {
                    ijkMediaPlayer2 = this.f8257e;
                    str2 = "http://" + str2;
                } else {
                    long j = 1;
                    if (str.equals(CyberPlayerManager.OPT_NEED_T5_AUTH)) {
                        ijkMediaPlayer4 = this.f8257e;
                    } else if (str.equals(CyberPlayerManager.OPT_ENABLE_FILECACHE)) {
                        this.n = Boolean.parseBoolean(str2);
                        return;
                    } else if (str.equals(CyberPlayerManager.OPT_IS_LIVE_VIDEO)) {
                        this.o = Boolean.valueOf(str2).booleanValue();
                        return;
                    } else if (str.equals(CyberPlayerManager.OPT_SUPPORT_PROCESS)) {
                        ijkMediaPlayer4 = this.f8257e;
                    } else {
                        if (!str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) && !str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                            if (str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
                                if (j()) {
                                    PcdnApi.nativePcdnInit(c.g(), Long.parseLong(str2));
                                    return;
                                }
                                return;
                            } else if (str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
                                KernelNetApi.nativeKernelNetInit(Long.parseLong(str2));
                                return;
                            } else if (!str.equals(CyberPlayerManager.OPT_ENABLE_PREBUFFER)) {
                                if (str.equals(CyberPlayerManager.OPT_ENABLE_PCDN)) {
                                    if (j()) {
                                        this.f8257e.a(1, str, Long.parseLong(str2));
                                    }
                                    ijkMediaPlayer3 = this.f8257e;
                                    str4 = "pcdn_enable";
                                } else if (str.equals(CyberPlayerManager.OPT_ENABLE_P2P)) {
                                    if (j()) {
                                        this.f8257e.a(1, str, Long.parseLong(str2));
                                    }
                                    ijkMediaPlayer3 = this.f8257e;
                                    str4 = "p2p_enable";
                                } else if (str.equals(CyberPlayerManager.OPT_ENABLE_KERNEL_NET)) {
                                    this.f8257e.a(1, str, Long.parseLong(str2));
                                    ijkMediaPlayer3 = this.f8257e;
                                    str4 = "kernel_net_enable";
                                } else if (!str.equals(CyberPlayerManager.OPT_PCDN_TYPE) && !str.equals(CyberPlayerManager.OPT_FILE_SIZE)) {
                                    if (!str.equals(CyberPlayerManager.OPT_STAGE_TYPE)) {
                                        if (str.equals(CyberPlayerManager.OPT_SR_OPTION)) {
                                            if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
                                                this.f8257e.a(1, str, str2);
                                                str3 = "enable sr";
                                            } else {
                                                this.f8257e.a(1, str, 0L);
                                                str3 = "disable sr";
                                            }
                                            CyberLog.v("CyberPlayerImpl", str3);
                                            return;
                                        } else if (!str.equals(CyberPlayerManager.OPT_NEED_HTTP_REFERER)) {
                                            this.f8257e.a(4, str, str2);
                                            return;
                                        }
                                    }
                                    ijkMediaPlayer2 = this.f8257e;
                                }
                                ijkMediaPlayer3.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, str4, str2);
                                return;
                            }
                        }
                        ijkMediaPlayer = this.f8257e;
                        parseLong = Long.parseLong(str2);
                    }
                }
                ijkMediaPlayer2.a(1, str, str2);
                return;
            } else {
                ijkMediaPlayer = this.f8257e;
                parseLong = g(str2);
            }
            ijkMediaPlayer.a(1, str, parseLong);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.a(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.a(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.a(f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.a(surface);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.a(f2, f3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i2) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.a(context, i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        if (k()) {
            this.t = 3;
            this.f8257e.h();
        } else if (this.f8257e != null) {
            sendCommand(1000, 1, 0L, null);
        }
        this.u = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            this.s = -1L;
            this.t = 0;
            this.u = 0;
            ijkMediaPlayer.i();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i2) {
        IjkMediaPlayer ijkMediaPlayer = this.f8257e;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.b(i2);
        }
    }
}
