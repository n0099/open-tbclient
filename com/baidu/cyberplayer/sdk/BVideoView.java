package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.a;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.e;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class BVideoView extends GLSurfaceView implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {

    /* renamed from: a  reason: collision with root package name */
    public static String f4702a = "BVideoView";
    public int A;
    public boolean B;
    public boolean C;
    public float D;
    public long E;
    public String F;
    public String G;
    public i.a H;

    /* renamed from: b  reason: collision with root package name */
    public Context f4703b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayer f4704c;

    /* renamed from: d  reason: collision with root package name */
    public Uri f4705d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f4706e;

    /* renamed from: f  reason: collision with root package name */
    public int f4707f;

    /* renamed from: g  reason: collision with root package name */
    public int f4708g;

    /* renamed from: h  reason: collision with root package name */
    public int f4709h;

    /* renamed from: i  reason: collision with root package name */
    public int f4710i;
    public int j;
    public int k;
    public int l;
    public HashMap<String, String> m;
    public CyberPlayerManager.HttpDNS n;
    public boolean o;
    public CyberPlayerManager.OnPreparedListener p;
    public CyberPlayerManager.OnVideoSizeChangedListener q;
    public CyberPlayerManager.OnCompletionListener r;
    public CyberPlayerManager.OnSeekCompleteListener s;
    public CyberPlayerManager.OnBufferingUpdateListener t;
    public CyberPlayerManager.OnErrorListener u;
    public CyberPlayerManager.OnInfoListener v;
    public CyberPlayerManager.OnMediaSourceChangedListener w;
    public e x;
    public a y;
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> z;

    public BVideoView(Context context) {
        this(context, null);
    }

    public BVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4708g = 3;
        this.f4710i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new HashMap<>();
        this.o = true;
        this.A = 0;
        this.D = 1.0f;
        this.E = 0L;
        this.F = null;
        this.G = null;
        this.H = new i.a() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i2, int i3) {
                if (BVideoView.this.f4704c != null) {
                    try {
                        BVideoView.this.f4704c.updateDisplaySize(i2, i3);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i2, final int i3, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = o.a(createBitmap);
                            CyberLog.d(BVideoView.f4702a, "onTakeSnapShot rotate bmp finished");
                            synchronized (BVideoView.this.z) {
                                for (int i4 = 0; i4 < BVideoView.this.z.size(); i4++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) BVideoView.this.z.get(i4)).onSnapShotComplete(a2);
                                }
                                BVideoView.this.z.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final long j) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BVideoView.this.f4704c != null && BVideoView.this.f4704c.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            BVideoView.this.f4704c.sendCommand(1002, 0, j, null);
                        }
                        if (BVideoView.this.f4704c == null || BVideoView.this.E <= 0) {
                            return;
                        }
                        long j2 = j - BVideoView.this.E;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        BVideoView.this.f4704c.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i2) {
                Surface c2;
                String str = BVideoView.f4702a;
                CyberLog.d(str, "onSurfaceReady renderType:" + i2);
                if (i2 != 0 || Build.VERSION.SDK_INT >= 16) {
                    return false;
                }
                if (BVideoView.this.f4704c == null || BVideoView.this.x == null || (c2 = BVideoView.this.x.c()) == null) {
                    return true;
                }
                BVideoView.this.f4704c.setSurface(c2);
                return true;
            }
        };
        this.f4703b = context.getApplicationContext();
        this.y = new a();
        this.z = new ArrayList<>();
        reset();
        a();
    }

    private void a() {
        if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.f4710i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        setEGLContextClientVersion(2);
        e eVar = new e();
        this.x = eVar;
        setRenderer(eVar);
        setRenderMode(0);
        this.x.a(this.H);
        this.x.a(new e.a() { // from class: com.baidu.cyberplayer.sdk.BVideoView.1
            @Override // com.baidu.cyberplayer.sdk.e.a
            public void a() {
                BVideoView.this.requestRender();
            }
        });
    }

    public static boolean a(String str) {
        try {
            if (CyberCfgManager.getInstance().a("enable_hls_force_mediaplayer", false) && str.split("\\?")[0].endsWith(".m3u8")) {
                CyberLog.d(f4702a, "force mediaplayer");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void b() {
        Surface c2;
        if (this.f4705d == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        PlayerPolicyManager.getInstance().update();
        d();
        try {
            if (a(this.f4705d.toString())) {
                this.A = 4;
            }
            CyberPlayer cyberPlayer = new CyberPlayer(this.A, this.n, this.o);
            this.f4704c = cyberPlayer;
            cyberPlayer.setOnPreparedListener(this);
            this.f4704c.setOnCompletionListener(this);
            this.f4704c.setOnVideoSizeChangedListener(this);
            this.f4704c.setOnSeekCompleteListener(this);
            this.f4704c.setOnBufferingUpdateListener(this);
            this.f4704c.setOnErrorListener(this);
            this.f4704c.setOnInfoListener(this);
            this.f4704c.setOnMediaSourceChangedListener(this);
            if (this.m != null) {
                for (String str : this.m.keySet()) {
                    this.f4704c.setOption(str, this.m.get(str));
                }
            }
            if (this.F != null) {
                this.f4704c.setPlayJson(this.F);
            }
            if (this.G != null) {
                this.f4704c.setClarityInfo(this.G);
            }
            CyberPlayer cyberPlayer2 = this.f4704c;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            this.f4704c.setDataSource(this.f4703b, this.f4705d, this.f4706e);
            this.f4704c.prepareAsync();
            this.f4710i = 1;
            if (this.x != null && (c2 = this.x.c()) != null) {
                this.f4704c.setSurface(c2);
            }
            this.f4704c.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.f4704c.muteOrUnmuteAudio(this.B);
            }
            if (this.C) {
                this.f4704c.setLooping(this.C);
            }
            if (this.D != 1.0f) {
                this.f4704c.setSpeed(this.D);
            }
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0070a> b2;
        if (this.f4704c == null || (b2 = this.y.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0070a c0070a = b2.get(i2);
            if (c0070a != null && c0070a.a() != null) {
                this.f4704c.setExternalInfo(c0070a.a(), c0070a.b());
            }
        }
    }

    private void d() {
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.f4704c.reset();
            }
            this.f4704c.release();
            this.f4704c = null;
            this.f4710i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
        }
        e eVar = this.x;
        if (eVar != null) {
            eVar.a();
        }
    }

    private boolean e() {
        int i2;
        return (this.f4704c == null || (i2 = this.f4710i) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    private boolean f() {
        int i2;
        return (this.f4704c == null || (i2 = this.f4710i) == 0 || i2 == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f4704c != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.m;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4704c.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f4704c.changeProxyDynamic(str, true);
            }
            this.f4704c.seekTo(getCurrentPosition() - 500);
            HashMap<String, String> hashMap2 = this.m;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i(f4702a, "destory called");
        d();
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
            this.m = null;
        }
        a aVar = this.y;
        if (aVar != null) {
            aVar.a();
            this.y = null;
        }
        synchronized (this.z) {
            if (this.z != null) {
                this.z.clear();
            }
        }
        Map<String, String> map = this.f4706e;
        if (map != null) {
            map.clear();
            this.f4706e = null;
        }
        this.n = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (f()) {
            return this.f4704c.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (f()) {
            return this.f4704c.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.f4704c;
    }

    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.f4704c;
        return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.A;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer == null || this.f4710i == 0) {
            return -1L;
        }
        return cyberPlayer.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (f()) {
            return this.f4704c.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (f()) {
            return this.f4704c.getPlayedTime();
        }
        return -1L;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.l;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.k;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return e() && this.f4710i == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.B = z;
        String str = f4702a;
        CyberLog.i(str, "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i(f4702a, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.t;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.f4710i = 5;
        this.j = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.r;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        this.f4710i = -1;
        this.j = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.u;
        if (onErrorListener != null) {
            return onErrorListener.onError(i2, i3, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        CyberPlayer cyberPlayer;
        if (i2 == 10001 && (cyberPlayer = this.f4704c) != null && cyberPlayer.getDecodeMode() != 4) {
            this.x.c(i3);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.v;
        return onInfoListener != null && onInfoListener.onInfo(i2, i3, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.w;
        return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.f4710i = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.p;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i2 = this.f4707f;
        if (i2 > 0) {
            seekTo(i2, this.f4708g);
        }
        this.f4707f = -1;
        int i3 = this.f4709h;
        if (i3 != Integer.MIN_VALUE) {
            switchMediaSource(i3);
            this.f4709h = Integer.MIN_VALUE;
        }
        String str = f4702a;
        CyberLog.i(str, "onPrepared mTargetState::" + this.j);
        if (this.j == 3 && this.f4710i == 2) {
            start();
        } else if (this.j == 4 && this.f4710i == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.s;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        this.k = i2;
        this.l = i3;
        e eVar = this.x;
        if (eVar != null) {
            eVar.a(i2, i3, i4, i5);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.q;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (e()) {
            this.f4704c.pause();
            this.f4710i = 4;
        } else {
            CyberPlayer cyberPlayer = this.f4704c;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 0, 0L, null);
            }
        }
        this.j = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.B = false;
        this.o = true;
        this.C = false;
        this.D = 1.0f;
        this.f4707f = -1;
        this.f4709h = Integer.MIN_VALUE;
        this.f4705d = null;
        this.f4706e = null;
        this.n = null;
        this.G = null;
        this.F = null;
        if (this.f4710i == -1 && (cyberPlayer = this.f4704c) != null) {
            cyberPlayer.release();
            this.f4704c = null;
        }
        this.A = 0;
        this.f4710i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        CyberPlayer cyberPlayer2 = this.f4704c;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        e eVar = this.x;
        if (eVar != null) {
            eVar.b();
        }
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
        a aVar = this.y;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2) {
        if (this.f4704c != null) {
            if (e()) {
                this.f4704c.seekTo(i2);
            } else {
                this.f4707f = i2;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2, int i3) {
        if (this.f4704c != null) {
            if (e()) {
                this.f4704c.seekTo(i2, i3);
                return;
            }
            this.f4708g = i3;
            this.f4707f = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(f4702a, "setClarityInfo is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            cyberPlayer.setClarityInfo(str);
        } else {
            this.G = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.A = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.y.a(str, obj);
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.n = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.C = z;
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            cyberPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.t = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.r = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.u = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.v = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.w = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.p = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.s = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.q = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.f4710i != 0) {
            CyberLog.i(f4702a, "Do not set option when the video player playing");
            return;
        }
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.f4704c != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                this.f4704c.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(f4702a, "setPlayJson is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
        } else {
            this.F = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.o = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        CyberLog.i(f4702a, "setSpeed()");
        this.D = f2;
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f2);
        } else {
            CyberLog.i(f4702a, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i2) {
        e eVar = this.x;
        if (eVar != null) {
            eVar.b(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
        e eVar = this.x;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.f4705d = uri;
        this.f4706e = map;
        this.f4707f = -1;
        b();
        requestLayout();
        invalidate();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        String str = f4702a;
        CyberLog.i(str, "start mCyberPlayer:" + this.f4704c + " mCurrentState:" + this.f4710i);
        if (e()) {
            this.f4704c.start();
            this.f4710i = 3;
        } else {
            CyberPlayer cyberPlayer = this.f4704c;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.j = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.f4704c;
        if (cyberPlayer != null) {
            cyberPlayer.setOnPreparedListener(null);
            this.f4704c.setOnCompletionListener(null);
            this.f4704c.setOnVideoSizeChangedListener(null);
            this.f4704c.setOnSeekCompleteListener(null);
            this.f4704c.setOnBufferingUpdateListener(null);
            this.f4704c.setOnErrorListener(null);
            this.f4704c.setOnInfoListener(null);
            this.f4704c.setOnMediaSourceChangedListener(null);
            this.f4704c.stop();
            this.f4704c.release();
            this.f4704c = null;
            this.f4710i = 0;
            this.j = 0;
        }
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
        e eVar = this.x;
        if (eVar != null) {
            eVar.a();
        }
        a aVar = this.y;
        if (aVar != null) {
            aVar.a();
        }
        this.F = null;
        this.G = null;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i2) {
        if (e()) {
            this.f4704c.switchMediaSource(i2);
        } else {
            this.f4709h = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i2, int i3) {
        if (onSnapShotCompleteListener == null) {
            return false;
        }
        CyberLog.d(f4702a, "takeSnapshotAsync called");
        if (this.x != null) {
            synchronized (this.z) {
                if (this.z.isEmpty()) {
                    this.x.a(f2, i2, i3);
                }
                this.z.add(onSnapShotCompleteListener);
            }
            return true;
        }
        return false;
    }
}
