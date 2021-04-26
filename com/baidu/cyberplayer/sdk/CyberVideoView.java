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
/* loaded from: classes2.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public boolean A;
    public float B;
    public long C;
    public boolean D;
    public String E;
    public String F;
    public i.a G;

    /* renamed from: a  reason: collision with root package name */
    public Context f4971a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayer f4972b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f4973c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f4974d;

    /* renamed from: e  reason: collision with root package name */
    public int f4975e;

    /* renamed from: f  reason: collision with root package name */
    public int f4976f;

    /* renamed from: g  reason: collision with root package name */
    public int f4977g;

    /* renamed from: h  reason: collision with root package name */
    public int f4978h;

    /* renamed from: i  reason: collision with root package name */
    public int f4979i;
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

    public CyberVideoView(Context context, int i2) {
        this(context, null, i2);
    }

    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4976f = 0;
        this.f4977g = 0;
        this.f4978h = 0;
        this.f4979i = 0;
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
            public void a(final int i2, final int i3, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = n.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.w) {
                                for (int i4 = 0; i4 < CyberVideoView.this.w.size(); i4++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.w.get(i4)).onSnapShotComplete(a2);
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
                        if (CyberVideoView.this.f4972b != null && CyberVideoView.this.f4972b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f4972b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f4972b == null || CyberVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.C;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f4972b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
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
                        if (CyberVideoView.this.f4972b != null && CyberVideoView.this.t != null && (d3 = CyberVideoView.this.t.d()) != null) {
                            CyberVideoView.this.f4972b.setSurface(d3);
                        }
                        return true;
                    }
                    return false;
                }
                if (i2 == 1) {
                    if (CyberVideoView.this.f4972b == null || CyberVideoView.this.t == null) {
                        return false;
                    }
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                } else if (i2 != 2 || CyberVideoView.this.f4972b == null || CyberVideoView.this.t == null) {
                    return false;
                } else {
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f4972b);
                }
                CyberVideoView.this.f4972b.setSurface(d2);
                return false;
            }
        };
        this.u = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.u);
        this.f4971a = context.getApplicationContext();
        this.v = new a();
        this.w = new ArrayList<>();
        reset();
        a();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f4976f = 0;
        this.f4977g = 0;
        this.f4978h = 0;
        this.f4979i = 0;
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
            public void a(final int i22, final int i3, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i22, i3, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = n.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.w) {
                                for (int i4 = 0; i4 < CyberVideoView.this.w.size(); i4++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.w.get(i4)).onSnapShotComplete(a2);
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
                        if (CyberVideoView.this.f4972b != null && CyberVideoView.this.f4972b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.f4972b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.f4972b == null || CyberVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.C;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.f4972b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
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
                        if (CyberVideoView.this.f4972b != null && CyberVideoView.this.t != null && (d3 = CyberVideoView.this.t.d()) != null) {
                            CyberVideoView.this.f4972b.setSurface(d3);
                        }
                        return true;
                    }
                    return false;
                }
                if (i22 == 1) {
                    if (CyberVideoView.this.f4972b == null || CyberVideoView.this.t == null) {
                        return false;
                    }
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                } else if (i22 != 2 || CyberVideoView.this.f4972b == null || CyberVideoView.this.t == null) {
                    return false;
                } else {
                    d2 = CyberVideoView.this.t.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                    if (d2 == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.f4972b);
                }
                CyberVideoView.this.f4972b.setSurface(d2);
                return false;
            }
        };
        this.u = a(i2);
        this.f4971a = context.getApplicationContext();
        this.v = new a();
        this.w = new ArrayList<>();
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
        this.f4976f = 0;
        this.f4977g = 0;
        this.f4978h = 0;
        this.f4979i = 0;
        int i2 = this.u;
        if (i2 != 0) {
            if (i2 == 1) {
                this.t = new h(this.f4971a);
                if (Build.VERSION.SDK_INT < 21) {
                    setDecodeMode(1);
                }
            } else if (i2 == 2) {
                gVar = new g(this.f4971a);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            this.t.setCyberSurfaceListener(this.G);
            this.t.getView().setLayoutParams(layoutParams);
            addView(this.t.getView());
            CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.t);
        }
        gVar = new b(this.f4971a);
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
        if (this.f4973c == null) {
            return;
        }
        this.C = System.currentTimeMillis();
        d();
        try {
            if (this.f4972b == null) {
                this.f4972b = new CyberPlayer(this.x, this.k, this.y);
            }
            this.f4972b.setOnPreparedListener(this);
            this.f4972b.setOnCompletionListener(this);
            this.f4972b.setOnVideoSizeChangedListener(this);
            this.f4972b.setOnSeekCompleteListener(this);
            this.f4972b.setOnBufferingUpdateListener(this);
            this.f4972b.setOnErrorListener(this);
            this.f4972b.setOnInfoListener(this);
            this.f4972b.setOnMediaSourceChangedListener(this);
            if (this.E != null) {
                this.f4972b.setPlayJson(this.E);
            }
            if (this.F != null) {
                this.f4972b.setClarityInfo(this.F);
            }
            if (this.j != null) {
                for (String str : this.j.keySet()) {
                    this.f4972b.setOption(str, this.j.get(str));
                }
            }
            CyberPlayer cyberPlayer = this.f4972b;
            cyberPlayer.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.C);
            if (this.D) {
                this.f4972b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.f4972b.setDataSource(this.f4971a, this.f4973c, this.f4974d);
            this.f4972b.prepareAsync();
            this.f4976f = 1;
            if (this.t != null) {
                Surface d2 = this.t.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d2 + " mCyberPlayer:" + this.f4972b);
                if (d2 != null) {
                    this.f4972b.setSurface(d2);
                }
            }
            this.f4972b.setScreenOnWhilePlaying(true);
            if (this.z) {
                this.f4972b.muteOrUnmuteAudio(this.z);
            }
            if (this.B != 1.0f) {
                this.f4972b.setSpeed(this.B);
            }
            if (this.A) {
                this.f4972b.setLooping(this.A);
            }
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0069a> b2;
        if (this.f4972b == null || (b2 = this.v.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0069a c0069a = b2.get(i2);
            if (c0069a != null && c0069a.a() != null) {
                this.f4972b.setExternalInfo(c0069a.a(), c0069a.b());
            }
        }
    }

    private void d() {
        this.D = false;
        if (this.f4972b != null) {
            if (this.u == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.f4972b)) {
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
        CyberPlayer cyberPlayer = this.f4972b;
        if (cyberPlayer != null) {
            if (this.f4976f != -1) {
                cyberPlayer.reset();
            } else {
                cyberPlayer.release();
                this.f4972b = null;
            }
            this.f4976f = 0;
            this.f4977g = 0;
            this.f4978h = 0;
            this.f4979i = 0;
        }
    }

    private void f() {
        CyberPlayer cyberPlayer = this.f4972b;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.f4972b.reset();
            }
            this.f4972b.release();
            this.f4972b = null;
            this.f4976f = 0;
            this.f4977g = 0;
            this.f4978h = 0;
            this.f4979i = 0;
        }
    }

    private void g() {
        i iVar = this.t;
        if (iVar != null) {
            iVar.a();
        }
    }

    private boolean h() {
        int i2;
        return (this.f4972b == null || (i2 = this.f4976f) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    private boolean i() {
        int i2;
        return (this.f4972b == null || (i2 = this.f4976f) == 0 || i2 == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f4972b != null && TextUtils.isEmpty(n.c())) {
            HashMap<String, String> hashMap = this.j;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4972b.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f4972b.changeProxyDynamic(str, true);
            }
            this.f4972b.seekTo(getCurrentPosition() + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL);
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
        Map<String, String> map = this.f4974d;
        if (map != null) {
            map.clear();
            this.f4974d = null;
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
            return this.f4972b.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (i()) {
            return this.f4972b.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.f4972b;
    }

    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.f4972b;
        return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.x;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.f4972b;
        if (cyberPlayer == null || this.f4976f == 0) {
            return -1L;
        }
        return cyberPlayer.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (i()) {
            return this.f4972b.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (i()) {
            return this.f4972b.getPlayedTime();
        }
        return -1L;
    }

    public i getRenderView() {
        return this.t;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.f4979i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.f4978h;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return h() && this.f4976f == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.z = z;
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.f4972b;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.p;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.f4976f = 5;
        this.f4977g = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.n;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        this.f4976f = -1;
        this.f4977g = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.q;
        if (onErrorListener != null) {
            return onErrorListener.onError(i2, i3, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        CyberPlayer cyberPlayer;
        i iVar;
        if (i2 == 10001 && (cyberPlayer = this.f4972b) != null && cyberPlayer.getDecodeMode() != 4 && (iVar = this.t) != null) {
            iVar.setRawFrameRotation(i3);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.r;
        return onInfoListener != null && onInfoListener.onInfo(i2, i3, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.s;
        return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.f4976f = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.l;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i2 = this.f4975e;
        if (i2 > 0) {
            seekTo(i2);
        }
        this.f4975e = -1;
        CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.f4977g);
        if (this.f4977g == 3 && this.f4976f == 2) {
            start();
        } else if (this.f4977g == 4 && this.f4976f == 2) {
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
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        this.f4978h = i2;
        this.f4979i = i3;
        CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i4 + " den:" + i5 + " width:" + i2 + " height:" + i3);
        i iVar = this.t;
        if (iVar != null) {
            iVar.a(this.f4978h, this.f4979i, i4, i5);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.m;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (h()) {
            this.f4972b.pause();
            this.f4976f = 4;
        } else {
            CyberPlayer cyberPlayer = this.f4972b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 0, 0L, null);
            }
        }
        this.f4977g = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.z = false;
        this.y = true;
        this.A = false;
        this.B = 1.0f;
        this.f4975e = -1;
        this.f4973c = null;
        this.f4974d = null;
        this.k = null;
        this.E = null;
        this.F = null;
        this.x = 0;
        if (this.f4976f == -1 && (cyberPlayer = this.f4972b) != null) {
            cyberPlayer.release();
            this.f4972b = null;
        }
        this.f4976f = 0;
        this.f4977g = 0;
        this.f4978h = 0;
        this.f4979i = 0;
        CyberPlayer cyberPlayer2 = this.f4972b;
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
    public void seekTo(int i2) {
        if (this.f4972b != null) {
            if (h()) {
                this.f4972b.seekTo(i2);
            } else {
                this.f4975e = i2;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setClarityInfo is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4972b;
        if (cyberPlayer != null) {
            cyberPlayer.setClarityInfo(str);
        } else {
            this.F = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.x = i2;
        if (Build.VERSION.SDK_INT >= 21 || i2 != 2) {
            return;
        }
        this.x = 1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.f4972b;
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
        CyberPlayer cyberPlayer = this.f4972b;
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
        if (this.f4976f != 0) {
            CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
            return;
        }
        HashMap<String, String> hashMap = this.j;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.f4972b != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(n.c())) {
                this.f4972b.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setPlayJson is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4972b;
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
        CyberPlayer cyberPlayer = this.f4972b;
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
        i iVar = this.t;
        if (iVar != null) {
            iVar.setClientRotation(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
        i iVar = this.t;
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
        this.f4973c = uri;
        this.f4974d = map;
        this.f4975e = -1;
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
        CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.f4972b + " mCurrentState:" + this.f4976f);
        if (h()) {
            this.f4972b.start();
            this.f4976f = 3;
        } else {
            CyberPlayer cyberPlayer = this.f4972b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.f4977g = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.f4972b;
        if (cyberPlayer != null) {
            cyberPlayer.stop();
            this.f4972b.release();
            this.f4972b = null;
            this.f4976f = 0;
            this.f4977g = 0;
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
    public void switchMediaSource(int i2) {
        if (i()) {
            this.f4972b.switchMediaSource(i2);
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
        i iVar = this.t;
        if (iVar != null) {
            if (iVar.e()) {
                synchronized (this.w) {
                    if (this.w.isEmpty()) {
                        this.t.a(f2, i2, i3);
                    }
                    this.w.add(onSnapShotCompleteListener);
                }
                return true;
            }
            Bitmap a2 = this.t.a(f2, i2, i3);
            if (a2 == null || onSnapShotCompleteListener == null) {
                return true;
            }
            onSnapShotCompleteListener.onSnapShotComplete(a2);
            return true;
        }
        return false;
    }
}
