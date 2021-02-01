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
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes4.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    private boolean A;
    private float B;
    private long C;
    private boolean D;
    private String E;
    private String F;
    private i.a G;

    /* renamed from: a  reason: collision with root package name */
    private Context f1708a;

    /* renamed from: b  reason: collision with root package name */
    private CyberPlayer f1709b;
    private Uri c;
    private Map<String, String> d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private HashMap<String, String> j;
    private CyberPlayerManager.HttpDNS k;
    private CyberPlayerManager.OnPreparedListener l;
    private CyberPlayerManager.OnVideoSizeChangedListener m;
    private CyberPlayerManager.OnCompletionListener n;
    private CyberPlayerManager.OnSeekCompleteListener o;
    private CyberPlayerManager.OnBufferingUpdateListener p;
    private CyberPlayerManager.OnErrorListener q;
    private CyberPlayerManager.OnInfoListener r;
    private CyberPlayerManager.OnMediaSourceChangedListener s;
    private i t;
    private final int u;
    private a v;
    private ArrayList<ICyberVideoView.OnSnapShotCompleteListener> w;
    private int x;
    private boolean y;
    private boolean z;

    public CyberVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CyberVideoView(Context context, int i) {
        this(context, null, i);
    }

    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new HashMap<>();
        this.x = 0;
        this.y = true;
        this.B = 1.0f;
        this.C = 0L;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i, final int i2, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = n.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.w) {
                                for (int i3 = 0; i3 < CyberVideoView.this.w.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.w.get(i3)).onSnapShotComplete(a2);
                                }
                                CyberVideoView.this.w.clear();
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
                        if (CyberVideoView.this.f1709b != null && CyberVideoView.this.f1709b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f1709b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f1709b == null || CyberVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.C;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f1709b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i) {
                Surface d;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i);
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.f1709b == null || CyberVideoView.this.t == null || (d = CyberVideoView.this.t.d()) == null) {
                            return true;
                        }
                        CyberVideoView.this.f1709b.setSurface(d);
                        return true;
                    }
                } else if (i == 1) {
                    if (CyberVideoView.this.f1709b != null && CyberVideoView.this.t != null) {
                        Surface d2 = CyberVideoView.this.t.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 != null) {
                            CyberVideoView.this.f1709b.setSurface(d2);
                        }
                    }
                } else if (i == 2 && CyberVideoView.this.f1709b != null && CyberVideoView.this.t != null) {
                    Surface d3 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d3);
                    if (d3 != null) {
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f1709b);
                        CyberVideoView.this.f1709b.setSurface(d3);
                    }
                }
                return false;
            }
        };
        this.u = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.u);
        this.f1708a = context.getApplicationContext();
        this.v = new a();
        this.w = new ArrayList<>();
        reset();
        a();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new HashMap<>();
        this.x = 0;
        this.y = true;
        this.B = 1.0f;
        this.C = 0L;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i2, final int i22, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i22, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = n.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.w) {
                                for (int i3 = 0; i3 < CyberVideoView.this.w.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.w.get(i3)).onSnapShotComplete(a2);
                                }
                                CyberVideoView.this.w.clear();
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
                        if (CyberVideoView.this.f1709b != null && CyberVideoView.this.f1709b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f1709b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f1709b == null || CyberVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.C;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f1709b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i2) {
                Surface d;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i2);
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.f1709b == null || CyberVideoView.this.t == null || (d = CyberVideoView.this.t.d()) == null) {
                            return true;
                        }
                        CyberVideoView.this.f1709b.setSurface(d);
                        return true;
                    }
                } else if (i2 == 1) {
                    if (CyberVideoView.this.f1709b != null && CyberVideoView.this.t != null) {
                        Surface d2 = CyberVideoView.this.t.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 != null) {
                            CyberVideoView.this.f1709b.setSurface(d2);
                        }
                    }
                } else if (i2 == 2 && CyberVideoView.this.f1709b != null && CyberVideoView.this.t != null) {
                    Surface d3 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d3);
                    if (d3 != null) {
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f1709b);
                        CyberVideoView.this.f1709b.setSurface(d3);
                    }
                }
                return false;
            }
        };
        this.u = a(i);
        this.f1708a = context.getApplicationContext();
        this.v = new a();
        this.w = new ArrayList<>();
        reset();
        a();
    }

    private int a(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    private void a() {
        if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        if (this.u == 0) {
            this.t = new b(this.f1708a);
        } else if (this.u == 1) {
            this.t = new h(this.f1708a);
            if (Build.VERSION.SDK_INT < 21) {
                setDecodeMode(1);
            }
        } else if (this.u == 2) {
            this.t = new g(this.f1708a);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.t.setCyberSurfaceListener(this.G);
        this.t.getView().setLayoutParams(layoutParams);
        addView(this.t.getView());
        CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.t);
    }

    private boolean a(CyberPlayer cyberPlayer) {
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                CyberLog.i("CyberVideoView", "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!");
                return true;
            } else if (cyberPlayer.getDecodeMode() == 1) {
                CyberLog.i("CyberVideoView", "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SW!");
                return true;
            } else if (this.y && !cyberPlayer.isRemotePlayer()) {
                CyberLog.i("CyberVideoView", "handlerLastPlay isPlayerNeedRelease mainprocess !");
                return true;
            }
        }
        return false;
    }

    private void b() {
        if (this.c == null) {
            return;
        }
        this.C = System.currentTimeMillis();
        d();
        try {
            if (this.f1709b == null) {
                this.f1709b = new CyberPlayer(this.x, this.k, this.y);
            }
            this.f1709b.setOnPreparedListener(this);
            this.f1709b.setOnCompletionListener(this);
            this.f1709b.setOnVideoSizeChangedListener(this);
            this.f1709b.setOnSeekCompleteListener(this);
            this.f1709b.setOnBufferingUpdateListener(this);
            this.f1709b.setOnErrorListener(this);
            this.f1709b.setOnInfoListener(this);
            this.f1709b.setOnMediaSourceChangedListener(this);
            if (this.E != null) {
                this.f1709b.setPlayJson(this.E);
            }
            if (this.F != null) {
                this.f1709b.setClarityInfo(this.F);
            }
            if (this.j != null) {
                for (String str : this.j.keySet()) {
                    this.f1709b.setOption(str, this.j.get(str));
                }
            }
            this.f1709b.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.C);
            if (this.D) {
                this.f1709b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.f1709b.setDataSource(this.f1708a, this.c, this.d);
            this.f1709b.prepareAsync();
            this.f = 1;
            if (this.t != null) {
                Surface d = this.t.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d + " mCyberPlayer:" + this.f1709b);
                if (d != null) {
                    this.f1709b.setSurface(d);
                }
            }
            this.f1709b.setScreenOnWhilePlaying(true);
            if (this.z) {
                this.f1709b.muteOrUnmuteAudio(this.z);
            }
            if (this.B != 1.0f) {
                this.f1709b.setSpeed(this.B);
            }
            if (this.A) {
                this.f1709b.setLooping(this.A);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0099a> b2;
        if (this.f1709b == null || (b2 = this.v.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            a.C0099a c0099a = b2.get(i);
            if (c0099a != null && c0099a.a() != null) {
                this.f1709b.setExternalInfo(c0099a.a(), c0099a.b());
            }
        }
    }

    private void d() {
        this.D = false;
        if (this.f1709b != null) {
            if (this.u == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.f1709b)) {
                e();
                CyberLog.i("CyberVideoView", "handlerLastPlay called reset last player");
            } else {
                f();
                CyberLog.i("CyberVideoView", "handlerLastPlay called release last player");
                if (this.u == 1) {
                    this.D = true;
                }
            }
        }
        g();
    }

    private void e() {
        if (this.f1709b != null) {
            if (this.f != -1) {
                this.f1709b.reset();
            } else {
                this.f1709b.release();
                this.f1709b = null;
            }
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
        }
    }

    private void f() {
        if (this.f1709b != null) {
            if (this.f1709b.getDecodeMode() == 4) {
                this.f1709b.reset();
            }
            this.f1709b.release();
            this.f1709b = null;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
        }
    }

    private void g() {
        if (this.t != null) {
            this.t.a();
        }
    }

    private boolean h() {
        return (this.f1709b == null || this.f == -1 || this.f == 0 || this.f == 1) ? false : true;
    }

    private boolean i() {
        return (this.f1709b == null || this.f == 0 || this.f == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f1709b != null && TextUtils.isEmpty(n.c())) {
            String str2 = this.j != null ? this.j.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f1709b.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f1709b.changeProxyDynamic(str, true);
            }
            this.f1709b.seekTo(getCurrentPosition() + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL);
            if (this.j != null) {
                this.j.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i("CyberVideoView", "destory called");
        f();
        g();
        if (this.j != null) {
            this.j.clear();
            this.j = null;
        }
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        synchronized (this.w) {
            if (this.w != null) {
                this.w.clear();
            }
        }
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.t != null) {
            removeAllViews();
            this.t.b();
            this.t = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (i()) {
            return this.f1709b.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (i()) {
            return this.f1709b.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.f1709b;
    }

    public int getDecodeMode() {
        return this.f1709b != null ? this.f1709b.getDecodeMode() : this.x;
    }

    public long getDownloadSpeed() {
        if (this.f1709b == null || this.f == 0) {
            return -1L;
        }
        return this.f1709b.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (i()) {
            return this.f1709b.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (i()) {
            return this.f1709b.getPlayedTime();
        }
        return -1L;
    }

    public i getRenderView() {
        return this.t;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.h;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return h() && this.f == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.z = z;
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
        if (this.f1709b != null) {
            this.f1709b.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        if (this.p != null) {
            this.p.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.f = 5;
        this.g = 5;
        if (this.n != null) {
            this.n.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.f = -1;
        this.g = -1;
        if (this.q != null) {
            return this.q.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 10001 && this.f1709b != null && this.f1709b.getDecodeMode() != 4 && this.t != null) {
            this.t.setRawFrameRotation(i2);
        }
        return this.r != null && this.r.onInfo(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        return this.s != null && this.s.onMediaSourceChanged(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.f = 2;
        if (this.l != null) {
            this.l.onPrepared();
        }
        if (this.e > 0) {
            seekTo(this.e);
        }
        this.e = -1;
        CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.g);
        if (this.g == 3 && this.f == 2) {
            start();
        } else if (this.g == 4 && this.f == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        if (this.o != null) {
            this.o.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.h = i;
        this.i = i2;
        CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i3 + " den:" + i4 + " width:" + i + " height:" + i2);
        if (this.t != null) {
            this.t.a(this.h, this.i, i3, i4);
        }
        if (this.m != null) {
            this.m.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (h()) {
            this.f1709b.pause();
            this.f = 4;
        } else if (this.f1709b != null) {
            this.f1709b.sendCommand(1000, 0, 0L, null);
        }
        this.g = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        this.z = false;
        this.y = true;
        this.A = false;
        this.B = 1.0f;
        this.e = -1;
        this.c = null;
        this.d = null;
        this.k = null;
        this.E = null;
        this.F = null;
        this.x = 0;
        if (this.f == -1 && this.f1709b != null) {
            this.f1709b.release();
            this.f1709b = null;
        }
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        if (this.f1709b != null) {
            this.f1709b.reset();
        }
        if (this.t != null) {
            this.t.c();
        }
        if (this.j != null) {
            this.j.clear();
        }
        if (this.v != null) {
            this.v.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        if (this.f1709b != null) {
            if (h()) {
                this.f1709b.seekTo(i);
            } else {
                this.e = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setClarityInfo is null");
        } else if (this.f1709b != null) {
            this.f1709b.setClarityInfo(str);
        } else {
            this.F = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.x = i;
        if (Build.VERSION.SDK_INT >= 21 || this.x != 2) {
            return;
        }
        this.x = 1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f1709b != null) {
            this.f1709b.setExternalInfo(str, obj);
        } else {
            this.v.a(str, obj);
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.k = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.A = z;
        if (this.f1709b != null) {
            this.f1709b.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.p = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.n = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.q = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.r = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.s = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.l = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.o = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.m = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.f != 0) {
            CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
            return;
        }
        if (this.j != null) {
            this.j.put(str, str2);
        }
        if (this.f1709b != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(n.c())) {
                this.f1709b.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setPlayJson is null");
        } else if (this.f1709b != null) {
            this.f1709b.setPlayJson(str);
        } else {
            this.E = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.y = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        CyberLog.i("CyberVideoView", "setSpeed()");
        this.B = f;
        if (this.f1709b != null) {
            this.f1709b.setSpeed(f);
        } else {
            CyberLog.i("CyberVideoView", "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        if (this.t != null) {
            this.t.setClientRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        if (this.t != null) {
            this.t.setDisplayMode(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.c = uri;
        this.d = map;
        this.e = -1;
        b();
        requestLayout();
        invalidate();
    }

    public void setZOrderMediaOverlay(boolean z) {
        if (this.t != null) {
            this.t.setZOrderMediaOverlay(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.f1709b + " mCurrentState:" + this.f);
        if (h()) {
            this.f1709b.start();
            this.f = 3;
        } else if (this.f1709b != null) {
            this.f1709b.sendCommand(1000, 1, 0L, null);
        }
        this.g = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.f1709b != null) {
            this.f1709b.stop();
            this.f1709b.release();
            this.f1709b = null;
            this.f = 0;
            this.g = 0;
        }
        if (this.j != null) {
            this.j.clear();
        }
        if (this.t != null) {
            this.t.c();
            this.t.a();
        }
        if (this.v != null) {
            this.v.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        if (i()) {
            this.f1709b.switchMediaSource(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        if (onSnapShotCompleteListener == null) {
            return false;
        }
        CyberLog.d("CyberVideoView", "takeSnapshotAsync called");
        if (this.t != null) {
            if (this.t.e()) {
                synchronized (this.w) {
                    if (this.w.isEmpty()) {
                        this.t.a(f, i, i2);
                    }
                    this.w.add(onSnapShotCompleteListener);
                }
            } else {
                Bitmap a2 = this.t.a(f, i, i2);
                if (a2 != null && onSnapShotCompleteListener != null) {
                    onSnapShotCompleteListener.onSnapShotComplete(a2);
                }
            }
            return true;
        }
        return false;
    }
}
