package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.a;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public boolean A;
    public boolean B;
    public boolean C;
    public float D;
    public long E;
    public boolean F;
    public String G;
    public String H;
    public i.a I;

    /* renamed from: a  reason: collision with root package name */
    public Context f4746a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayer f4747b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f4748c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f4749d;

    /* renamed from: e  reason: collision with root package name */
    public int f4750e;

    /* renamed from: f  reason: collision with root package name */
    public int f4751f;

    /* renamed from: g  reason: collision with root package name */
    public int f4752g;

    /* renamed from: h  reason: collision with root package name */
    public int f4753h;

    /* renamed from: i  reason: collision with root package name */
    public int f4754i;
    public int j;
    public int k;
    public HashMap<String, String> l;
    public CyberPlayerManager.HttpDNS m;
    public CyberPlayerManager.OnPreparedListener n;
    public CyberPlayerManager.OnVideoSizeChangedListener o;
    public CyberPlayerManager.OnCompletionListener p;
    public CyberPlayerManager.OnSeekCompleteListener q;
    public CyberPlayerManager.OnBufferingUpdateListener r;
    public CyberPlayerManager.OnErrorListener s;
    public CyberPlayerManager.OnInfoListener t;
    public CyberPlayerManager.OnMediaSourceChangedListener u;
    public i v;
    public final int w;
    public a x;
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> y;
    public int z;

    public CyberVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CyberVideoView(Context context, int i2) {
        this(context, null, i2);
    }

    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4751f = 3;
        this.f4753h = 0;
        this.f4754i = 0;
        this.j = 0;
        this.k = 0;
        this.l = new HashMap<>();
        this.z = 0;
        this.A = true;
        this.D = 1.0f;
        this.E = 0L;
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i2, int i3) {
                if (CyberVideoView.this.f4747b != null) {
                    try {
                        CyberVideoView.this.f4747b.updateDisplaySize(i2, i3);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i2, final int i3, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.y) {
                                for (int i4 = 0; i4 < CyberVideoView.this.y.size(); i4++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.y.get(i4)).onSnapShotComplete(a2);
                                }
                                CyberVideoView.this.y.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final long j) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CyberVideoView.this.f4747b != null && CyberVideoView.this.f4747b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f4747b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f4747b == null || CyberVideoView.this.E <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.E;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f4747b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i2) {
                Surface d2;
                Surface d3;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i2);
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.f4747b != null && CyberVideoView.this.v != null && (d3 = CyberVideoView.this.v.d()) != null) {
                            CyberVideoView.this.f4747b.setSurface(d3);
                        }
                        return true;
                    }
                    return false;
                }
                if (i2 == 1) {
                    if (CyberVideoView.this.f4747b == null || CyberVideoView.this.v == null) {
                        return false;
                    }
                    d2 = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                } else if (i2 != 2 || CyberVideoView.this.f4747b == null || CyberVideoView.this.v == null) {
                    return false;
                } else {
                    d2 = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f4747b);
                }
                CyberVideoView.this.f4747b.setSurface(d2);
                return false;
            }
        };
        this.w = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.w);
        this.f4746a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList<>();
        reset();
        a();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f4751f = 3;
        this.f4753h = 0;
        this.f4754i = 0;
        this.j = 0;
        this.k = 0;
        this.l = new HashMap<>();
        this.z = 0;
        this.A = true;
        this.D = 1.0f;
        this.E = 0L;
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i22, int i3) {
                if (CyberVideoView.this.f4747b != null) {
                    try {
                        CyberVideoView.this.f4747b.updateDisplaySize(i22, i3);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i22, final int i3, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i22, i3, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.y) {
                                for (int i4 = 0; i4 < CyberVideoView.this.y.size(); i4++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.y.get(i4)).onSnapShotComplete(a2);
                                }
                                CyberVideoView.this.y.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final long j) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CyberVideoView.this.f4747b != null && CyberVideoView.this.f4747b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f4747b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f4747b == null || CyberVideoView.this.E <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.E;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f4747b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i22) {
                Surface d2;
                Surface d3;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i22);
                if (i22 == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.f4747b != null && CyberVideoView.this.v != null && (d3 = CyberVideoView.this.v.d()) != null) {
                            CyberVideoView.this.f4747b.setSurface(d3);
                        }
                        return true;
                    }
                    return false;
                }
                if (i22 == 1) {
                    if (CyberVideoView.this.f4747b == null || CyberVideoView.this.v == null) {
                        return false;
                    }
                    d2 = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                } else if (i22 != 2 || CyberVideoView.this.f4747b == null || CyberVideoView.this.v == null) {
                    return false;
                } else {
                    d2 = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f4747b);
                }
                CyberVideoView.this.f4747b.setSurface(d2);
                return false;
            }
        };
        this.w = a(i2);
        this.f4746a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList<>();
        reset();
        a();
    }

    private int a(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    private void a() {
        i gVar;
        if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.f4753h = 0;
        this.f4754i = 0;
        this.j = 0;
        this.k = 0;
        int i2 = this.w;
        if (i2 != 0) {
            if (i2 == 1) {
                this.v = new h(this.f4746a);
                if (Build.VERSION.SDK_INT < 21) {
                    setDecodeMode(1);
                }
            } else if (i2 == 2) {
                gVar = new g(this.f4746a);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            this.v.setCyberSurfaceListener(this.I);
            this.v.getView().setLayoutParams(layoutParams);
            addView(this.v.getView());
            CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.v);
        }
        gVar = new b(this.f4746a);
        this.v = gVar;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
        this.v.setCyberSurfaceListener(this.I);
        this.v.getView().setLayoutParams(layoutParams2);
        addView(this.v.getView());
        CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.v);
    }

    private boolean a(CyberPlayer cyberPlayer) {
        String str;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                str = "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!";
            } else if (cyberPlayer.getDecodeMode() == 1) {
                str = "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SW!";
            } else if (!this.A || cyberPlayer.isRemotePlayer()) {
                return false;
            } else {
                str = "handlerLastPlay isPlayerNeedRelease mainprocess !";
            }
            CyberLog.i("CyberVideoView", str);
            return true;
        }
        return false;
    }

    private void b() {
        if (this.f4748c == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        PlayerPolicyManager.getInstance().update();
        d();
        try {
            if (this.f4747b == null) {
                this.f4747b = new CyberPlayer(this.z, this.m, this.A);
            }
            this.f4747b.setOnPreparedListener(this);
            this.f4747b.setOnCompletionListener(this);
            this.f4747b.setOnVideoSizeChangedListener(this);
            this.f4747b.setOnSeekCompleteListener(this);
            this.f4747b.setOnBufferingUpdateListener(this);
            this.f4747b.setOnErrorListener(this);
            this.f4747b.setOnInfoListener(this);
            this.f4747b.setOnMediaSourceChangedListener(this);
            if (this.G != null) {
                this.f4747b.setPlayJson(this.G);
            }
            if (this.H != null) {
                this.f4747b.setClarityInfo(this.H);
            }
            if (this.l != null) {
                for (String str : this.l.keySet()) {
                    this.f4747b.setOption(str, this.l.get(str));
                }
            }
            CyberPlayer cyberPlayer = this.f4747b;
            cyberPlayer.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            if (this.F) {
                this.f4747b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.f4747b.setDataSource(this.f4746a, this.f4748c, this.f4749d);
            this.f4747b.prepareAsync();
            this.f4753h = 1;
            if (this.v != null) {
                Surface d2 = this.v.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d2 + " mCyberPlayer:" + this.f4747b);
                if (d2 != null) {
                    this.f4747b.setSurface(d2);
                }
            }
            this.f4747b.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.f4747b.muteOrUnmuteAudio(this.B);
            }
            if (this.D != 1.0f) {
                this.f4747b.setSpeed(this.D);
            }
            if (this.C) {
                this.f4747b.setLooping(this.C);
            }
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0070a> b2;
        if (this.f4747b == null || (b2 = this.x.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0070a c0070a = b2.get(i2);
            if (c0070a != null && c0070a.a() != null) {
                this.f4747b.setExternalInfo(c0070a.a(), c0070a.b());
            }
        }
    }

    private void d() {
        this.F = false;
        if (this.f4747b != null) {
            if (this.w == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.f4747b)) {
                e();
                CyberLog.i("CyberVideoView", "handlerLastPlay called reset last player");
            } else {
                f();
                CyberLog.i("CyberVideoView", "handlerLastPlay called release last player");
                if (this.w == 1) {
                    this.F = true;
                }
            }
        }
        g();
    }

    private void e() {
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            if (this.f4753h != -1) {
                cyberPlayer.reset();
            } else {
                cyberPlayer.release();
                this.f4747b = null;
            }
            this.f4753h = 0;
            this.f4754i = 0;
            this.j = 0;
            this.k = 0;
        }
    }

    private void f() {
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.f4747b.reset();
            }
            this.f4747b.release();
            this.f4747b = null;
            this.f4753h = 0;
            this.f4754i = 0;
            this.j = 0;
            this.k = 0;
        }
    }

    private void g() {
        i iVar = this.v;
        if (iVar != null) {
            iVar.a();
        }
    }

    private boolean h() {
        int i2;
        return (this.f4747b == null || (i2 = this.f4753h) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    private boolean i() {
        int i2;
        return (this.f4747b == null || (i2 = this.f4753h) == 0 || i2 == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f4747b != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.l;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4747b.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f4747b.changeProxyDynamic(str, true);
            }
            this.f4747b.seekTo(getCurrentPosition() - 500);
            HashMap<String, String> hashMap2 = this.l;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i("CyberVideoView", "destory called");
        f();
        HashMap<String, String> hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
            this.l = null;
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.a();
            this.x = null;
        }
        synchronized (this.y) {
            if (this.y != null) {
                this.y.clear();
            }
        }
        Map<String, String> map = this.f4749d;
        if (map != null) {
            map.clear();
            this.f4749d = null;
        }
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        if (this.v != null) {
            removeAllViews();
            this.v.b();
            this.v = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (i()) {
            return this.f4747b.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (i()) {
            return this.f4747b.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.f4747b;
    }

    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.f4747b;
        return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.z;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer == null || this.f4753h == 0) {
            return -1L;
        }
        return cyberPlayer.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (i()) {
            return this.f4747b.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (i()) {
            return this.f4747b.getPlayedTime();
        }
        return -1L;
    }

    public i getRenderView() {
        return this.v;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.k;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.j;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return h() && this.f4753h == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.B = z;
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.r;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.f4753h = 5;
        this.f4754i = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.p;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        this.f4753h = -1;
        this.f4754i = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.s;
        if (onErrorListener != null) {
            return onErrorListener.onError(i2, i3, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        CyberPlayer cyberPlayer;
        i iVar;
        if (i2 == 10001 && (cyberPlayer = this.f4747b) != null && cyberPlayer.getDecodeMode() != 4 && (iVar = this.v) != null) {
            iVar.setRawFrameRotation(i3);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.t;
        return onInfoListener != null && onInfoListener.onInfo(i2, i3, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.u;
        return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.f4753h = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.n;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i2 = this.f4750e;
        if (i2 > 0) {
            seekTo(i2, this.f4751f);
        }
        this.f4750e = -1;
        int i3 = this.f4752g;
        if (i3 != Integer.MIN_VALUE) {
            switchMediaSource(i3);
            this.f4752g = Integer.MIN_VALUE;
        }
        CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.f4754i);
        if (this.f4754i == 3 && this.f4753h == 2) {
            start();
        } else if (this.f4754i == 4 && this.f4753h == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.q;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        this.j = i2;
        this.k = i3;
        CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i4 + " den:" + i5 + " width:" + i2 + " height:" + i3);
        i iVar = this.v;
        if (iVar != null) {
            iVar.a(this.j, this.k, i4, i5);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.o;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (h()) {
            this.f4747b.pause();
            this.f4753h = 4;
        } else {
            CyberPlayer cyberPlayer = this.f4747b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 0, 0L, null);
            }
        }
        this.f4754i = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.B = false;
        this.A = true;
        this.C = false;
        this.D = 1.0f;
        this.f4750e = -1;
        this.f4752g = Integer.MIN_VALUE;
        this.f4748c = null;
        this.f4749d = null;
        this.m = null;
        this.G = null;
        this.H = null;
        this.z = 0;
        if (this.f4753h == -1 && (cyberPlayer = this.f4747b) != null) {
            cyberPlayer.release();
            this.f4747b = null;
        }
        this.f4753h = 0;
        this.f4754i = 0;
        this.j = 0;
        this.k = 0;
        CyberPlayer cyberPlayer2 = this.f4747b;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        i iVar = this.v;
        if (iVar != null) {
            iVar.c();
        }
        HashMap<String, String> hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2) {
        if (this.f4747b != null) {
            if (h()) {
                this.f4747b.seekTo(i2);
            } else {
                this.f4750e = i2;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2, int i3) {
        if (this.f4747b != null) {
            if (h()) {
                this.f4747b.seekTo(i2, i3);
                return;
            }
            this.f4751f = i3;
            this.f4750e = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setClarityInfo is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            cyberPlayer.setClarityInfo(str);
        } else {
            this.H = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.z = i2;
        if (Build.VERSION.SDK_INT >= 21 || i2 != 2) {
            return;
        }
        this.z = 1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.x.a(str, obj);
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.m = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.C = z;
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            cyberPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.r = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.p = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.s = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.t = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.u = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.n = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.q = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.o = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.f4753h != 0) {
            CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
            return;
        }
        HashMap<String, String> hashMap = this.l;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.f4747b != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                this.f4747b.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setPlayJson is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
        } else {
            this.G = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.A = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        CyberLog.i("CyberVideoView", "setSpeed()");
        this.D = f2;
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f2);
        } else {
            CyberLog.i("CyberVideoView", "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i2) {
        i iVar = this.v;
        if (iVar != null) {
            iVar.setClientRotation(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
        i iVar = this.v;
        if (iVar != null) {
            iVar.setDisplayMode(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.f4748c = uri;
        this.f4749d = map;
        this.f4750e = -1;
        b();
        requestLayout();
        invalidate();
    }

    public void setZOrderMediaOverlay(boolean z) {
        i iVar = this.v;
        if (iVar != null) {
            iVar.setZOrderMediaOverlay(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.f4747b + " mCurrentState:" + this.f4753h);
        if (h()) {
            this.f4747b.start();
            this.f4753h = 3;
        } else {
            CyberPlayer cyberPlayer = this.f4747b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.f4754i = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.f4747b;
        if (cyberPlayer != null) {
            cyberPlayer.stop();
            this.f4747b.release();
            this.f4747b = null;
            this.f4753h = 0;
            this.f4754i = 0;
        }
        HashMap<String, String> hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
        i iVar = this.v;
        if (iVar != null) {
            iVar.c();
            this.v.a();
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.a();
        }
        this.G = null;
        this.H = null;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i2) {
        if (h()) {
            this.f4747b.switchMediaSource(i2);
        } else {
            this.f4752g = i2;
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
        CyberLog.d("CyberVideoView", "takeSnapshotAsync called");
        i iVar = this.v;
        if (iVar != null) {
            if (iVar.e()) {
                synchronized (this.y) {
                    if (this.y.isEmpty()) {
                        this.v.a(f2, i2, i3);
                    }
                    this.y.add(onSnapShotCompleteListener);
                }
                return true;
            }
            Bitmap a2 = this.v.a(f2, i2, i3);
            if (a2 == null || onSnapShotCompleteListener == null) {
                return true;
            }
            onSnapShotCompleteListener.onSnapShotComplete(a2);
            return true;
        }
        return false;
    }
}
