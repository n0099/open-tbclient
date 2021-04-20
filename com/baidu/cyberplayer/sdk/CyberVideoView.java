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
/* loaded from: classes.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public boolean A;
    public float B;
    public long C;
    public boolean D;
    public String E;
    public String F;
    public i.a G;

    /* renamed from: a  reason: collision with root package name */
    public Context f4853a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayer f4854b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f4855c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f4856d;

    /* renamed from: e  reason: collision with root package name */
    public int f4857e;

    /* renamed from: f  reason: collision with root package name */
    public int f4858f;

    /* renamed from: g  reason: collision with root package name */
    public int f4859g;

    /* renamed from: h  reason: collision with root package name */
    public int f4860h;
    public int i;
    public HashMap<String, String> j;
    public CyberPlayerManager.HttpDNS k;
    public CyberPlayerManager.OnPreparedListener l;
    public CyberPlayerManager.OnVideoSizeChangedListener m;
    public CyberPlayerManager.OnCompletionListener n;
    public CyberPlayerManager.OnSeekCompleteListener o;
    public CyberPlayerManager.OnBufferingUpdateListener p;
    public CyberPlayerManager.OnErrorListener q;
    public CyberPlayerManager.OnInfoListener r;
    public CyberPlayerManager.OnMediaSourceChangedListener s;
    public i t;
    public final int u;
    public a v;
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> w;
    public int x;
    public boolean y;
    public boolean z;

    public CyberVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CyberVideoView(Context context, int i) {
        this(context, null, i);
    }

    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4858f = 0;
        this.f4859g = 0;
        this.f4860h = 0;
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
                        if (CyberVideoView.this.f4854b != null && CyberVideoView.this.f4854b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f4854b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f4854b == null || CyberVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.C;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f4854b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i) {
                Surface d2;
                Surface d3;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i);
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.f4854b != null && CyberVideoView.this.t != null && (d3 = CyberVideoView.this.t.d()) != null) {
                            CyberVideoView.this.f4854b.setSurface(d3);
                        }
                        return true;
                    }
                    return false;
                }
                if (i == 1) {
                    if (CyberVideoView.this.f4854b == null || CyberVideoView.this.t == null) {
                        return false;
                    }
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                } else if (i != 2 || CyberVideoView.this.f4854b == null || CyberVideoView.this.t == null) {
                    return false;
                } else {
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f4854b);
                }
                CyberVideoView.this.f4854b.setSurface(d2);
                return false;
            }
        };
        this.u = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.u);
        this.f4853a = context.getApplicationContext();
        this.v = new a();
        this.w = new ArrayList<>();
        reset();
        a();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f4858f = 0;
        this.f4859g = 0;
        this.f4860h = 0;
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
                        if (CyberVideoView.this.f4854b != null && CyberVideoView.this.f4854b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f4854b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f4854b == null || CyberVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.C;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f4854b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
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
                        if (CyberVideoView.this.f4854b != null && CyberVideoView.this.t != null && (d3 = CyberVideoView.this.t.d()) != null) {
                            CyberVideoView.this.f4854b.setSurface(d3);
                        }
                        return true;
                    }
                    return false;
                }
                if (i2 == 1) {
                    if (CyberVideoView.this.f4854b == null || CyberVideoView.this.t == null) {
                        return false;
                    }
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                } else if (i2 != 2 || CyberVideoView.this.f4854b == null || CyberVideoView.this.t == null) {
                    return false;
                } else {
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f4854b);
                }
                CyberVideoView.this.f4854b.setSurface(d2);
                return false;
            }
        };
        this.u = a(i);
        this.f4853a = context.getApplicationContext();
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
        i gVar;
        if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.f4858f = 0;
        this.f4859g = 0;
        this.f4860h = 0;
        this.i = 0;
        int i = this.u;
        if (i != 0) {
            if (i == 1) {
                this.t = new h(this.f4853a);
                if (Build.VERSION.SDK_INT < 21) {
                    setDecodeMode(1);
                }
            } else if (i == 2) {
                gVar = new g(this.f4853a);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            this.t.setCyberSurfaceListener(this.G);
            this.t.getView().setLayoutParams(layoutParams);
            addView(this.t.getView());
            CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.t);
        }
        gVar = new b(this.f4853a);
        this.t = gVar;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
        this.t.setCyberSurfaceListener(this.G);
        this.t.getView().setLayoutParams(layoutParams2);
        addView(this.t.getView());
        CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.t);
    }

    private boolean a(CyberPlayer cyberPlayer) {
        String str;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                str = "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!";
            } else if (cyberPlayer.getDecodeMode() == 1) {
                str = "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SW!";
            } else if (!this.y || cyberPlayer.isRemotePlayer()) {
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
        if (this.f4855c == null) {
            return;
        }
        this.C = System.currentTimeMillis();
        d();
        try {
            if (this.f4854b == null) {
                this.f4854b = new CyberPlayer(this.x, this.k, this.y);
            }
            this.f4854b.setOnPreparedListener(this);
            this.f4854b.setOnCompletionListener(this);
            this.f4854b.setOnVideoSizeChangedListener(this);
            this.f4854b.setOnSeekCompleteListener(this);
            this.f4854b.setOnBufferingUpdateListener(this);
            this.f4854b.setOnErrorListener(this);
            this.f4854b.setOnInfoListener(this);
            this.f4854b.setOnMediaSourceChangedListener(this);
            if (this.E != null) {
                this.f4854b.setPlayJson(this.E);
            }
            if (this.F != null) {
                this.f4854b.setClarityInfo(this.F);
            }
            if (this.j != null) {
                for (String str : this.j.keySet()) {
                    this.f4854b.setOption(str, this.j.get(str));
                }
            }
            CyberPlayer cyberPlayer = this.f4854b;
            cyberPlayer.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.C);
            if (this.D) {
                this.f4854b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.f4854b.setDataSource(this.f4853a, this.f4855c, this.f4856d);
            this.f4854b.prepareAsync();
            this.f4858f = 1;
            if (this.t != null) {
                Surface d2 = this.t.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d2 + " mCyberPlayer:" + this.f4854b);
                if (d2 != null) {
                    this.f4854b.setSurface(d2);
                }
            }
            this.f4854b.setScreenOnWhilePlaying(true);
            if (this.z) {
                this.f4854b.muteOrUnmuteAudio(this.z);
            }
            if (this.B != 1.0f) {
                this.f4854b.setSpeed(this.B);
            }
            if (this.A) {
                this.f4854b.setLooping(this.A);
            }
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0069a> b2;
        if (this.f4854b == null || (b2 = this.v.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            a.C0069a c0069a = b2.get(i);
            if (c0069a != null && c0069a.a() != null) {
                this.f4854b.setExternalInfo(c0069a.a(), c0069a.b());
            }
        }
    }

    private void d() {
        this.D = false;
        if (this.f4854b != null) {
            if (this.u == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.f4854b)) {
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
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            if (this.f4858f != -1) {
                cyberPlayer.reset();
            } else {
                cyberPlayer.release();
                this.f4854b = null;
            }
            this.f4858f = 0;
            this.f4859g = 0;
            this.f4860h = 0;
            this.i = 0;
        }
    }

    private void f() {
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.f4854b.reset();
            }
            this.f4854b.release();
            this.f4854b = null;
            this.f4858f = 0;
            this.f4859g = 0;
            this.f4860h = 0;
            this.i = 0;
        }
    }

    private void g() {
        i iVar = this.t;
        if (iVar != null) {
            iVar.a();
        }
    }

    private boolean h() {
        int i;
        return (this.f4854b == null || (i = this.f4858f) == -1 || i == 0 || i == 1) ? false : true;
    }

    private boolean i() {
        int i;
        return (this.f4854b == null || (i = this.f4858f) == 0 || i == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f4854b != null && TextUtils.isEmpty(n.c())) {
            HashMap<String, String> hashMap = this.j;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4854b.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f4854b.changeProxyDynamic(str, true);
            }
            this.f4854b.seekTo(getCurrentPosition() + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL);
            HashMap<String, String> hashMap2 = this.j;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i("CyberVideoView", "destory called");
        f();
        g();
        HashMap<String, String> hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
            this.j = null;
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.a();
            this.v = null;
        }
        synchronized (this.w) {
            if (this.w != null) {
                this.w.clear();
            }
        }
        Map<String, String> map = this.f4856d;
        if (map != null) {
            map.clear();
            this.f4856d = null;
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
            return this.f4854b.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (i()) {
            return this.f4854b.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.f4854b;
    }

    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.f4854b;
        return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.x;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer == null || this.f4858f == 0) {
            return -1L;
        }
        return cyberPlayer.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (i()) {
            return this.f4854b.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (i()) {
            return this.f4854b.getPlayedTime();
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
        return this.f4860h;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return h() && this.f4858f == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.z = z;
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.p;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.f4858f = 5;
        this.f4859g = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.n;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.f4858f = -1;
        this.f4859g = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.q;
        if (onErrorListener != null) {
            return onErrorListener.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        CyberPlayer cyberPlayer;
        i iVar;
        if (i == 10001 && (cyberPlayer = this.f4854b) != null && cyberPlayer.getDecodeMode() != 4 && (iVar = this.t) != null) {
            iVar.setRawFrameRotation(i2);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.r;
        return onInfoListener != null && onInfoListener.onInfo(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.s;
        return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.f4858f = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.l;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i = this.f4857e;
        if (i > 0) {
            seekTo(i);
        }
        this.f4857e = -1;
        CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.f4859g);
        if (this.f4859g == 3 && this.f4858f == 2) {
            start();
        } else if (this.f4859g == 4 && this.f4858f == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.o;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.f4860h = i;
        this.i = i2;
        CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i3 + " den:" + i4 + " width:" + i + " height:" + i2);
        i iVar = this.t;
        if (iVar != null) {
            iVar.a(this.f4860h, this.i, i3, i4);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.m;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (h()) {
            this.f4854b.pause();
            this.f4858f = 4;
        } else {
            CyberPlayer cyberPlayer = this.f4854b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 0, 0L, null);
            }
        }
        this.f4859g = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.z = false;
        this.y = true;
        this.A = false;
        this.B = 1.0f;
        this.f4857e = -1;
        this.f4855c = null;
        this.f4856d = null;
        this.k = null;
        this.E = null;
        this.F = null;
        this.x = 0;
        if (this.f4858f == -1 && (cyberPlayer = this.f4854b) != null) {
            cyberPlayer.release();
            this.f4854b = null;
        }
        this.f4858f = 0;
        this.f4859g = 0;
        this.f4860h = 0;
        this.i = 0;
        CyberPlayer cyberPlayer2 = this.f4854b;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        i iVar = this.t;
        if (iVar != null) {
            iVar.c();
        }
        HashMap<String, String> hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        if (this.f4854b != null) {
            if (h()) {
                this.f4854b.seekTo(i);
            } else {
                this.f4857e = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setClarityInfo is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            cyberPlayer.setClarityInfo(str);
        } else {
            this.F = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.x = i;
        if (Build.VERSION.SDK_INT >= 21 || i != 2) {
            return;
        }
        this.x = 1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
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
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            cyberPlayer.setLooping(z);
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
        if (this.f4858f != 0) {
            CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
            return;
        }
        HashMap<String, String> hashMap = this.j;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.f4854b != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(n.c())) {
                this.f4854b.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setPlayJson is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
        } else {
            this.E = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.y = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        CyberLog.i("CyberVideoView", "setSpeed()");
        this.B = f2;
        CyberPlayer cyberPlayer = this.f4854b;
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
    public void setVideoRotation(int i) {
        i iVar = this.t;
        if (iVar != null) {
            iVar.setClientRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        i iVar = this.t;
        if (iVar != null) {
            iVar.setDisplayMode(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.f4855c = uri;
        this.f4856d = map;
        this.f4857e = -1;
        b();
        requestLayout();
        invalidate();
    }

    public void setZOrderMediaOverlay(boolean z) {
        i iVar = this.t;
        if (iVar != null) {
            iVar.setZOrderMediaOverlay(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.f4854b + " mCurrentState:" + this.f4858f);
        if (h()) {
            this.f4854b.start();
            this.f4858f = 3;
        } else {
            CyberPlayer cyberPlayer = this.f4854b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.f4859g = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.f4854b;
        if (cyberPlayer != null) {
            cyberPlayer.stop();
            this.f4854b.release();
            this.f4854b = null;
            this.f4858f = 0;
            this.f4859g = 0;
        }
        HashMap<String, String> hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
        i iVar = this.t;
        if (iVar != null) {
            iVar.c();
            this.t.a();
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        if (i()) {
            this.f4854b.switchMediaSource(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i, int i2) {
        if (onSnapShotCompleteListener == null) {
            return false;
        }
        CyberLog.d("CyberVideoView", "takeSnapshotAsync called");
        i iVar = this.t;
        if (iVar != null) {
            if (iVar.e()) {
                synchronized (this.w) {
                    if (this.w.isEmpty()) {
                        this.t.a(f2, i, i2);
                    }
                    this.w.add(onSnapShotCompleteListener);
                }
                return true;
            }
            Bitmap a2 = this.t.a(f2, i, i2);
            if (a2 == null || onSnapShotCompleteListener == null) {
                return true;
            }
            onSnapShotCompleteListener.onSnapShotComplete(a2);
            return true;
        }
        return false;
    }
}
