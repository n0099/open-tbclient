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
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    private float A;
    private long B;
    private boolean C;
    private i.a D;
    private Context a;
    private CyberPlayer b;
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
    private i s;
    private final int t;
    private a u;
    private ArrayList<ICyberVideoView.OnSnapShotCompleteListener> v;
    private int w;
    private boolean x;
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
        this.w = 0;
        this.x = true;
        this.A = 1.0f;
        this.B = 0L;
        this.C = false;
        this.D = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i, final int i2, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a = m.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.v) {
                                for (int i3 = 0; i3 < CyberVideoView.this.v.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.v.get(i3)).onSnapShotComplete(a);
                                }
                                CyberVideoView.this.v.clear();
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
                        if (CyberVideoView.this.b != null && CyberVideoView.this.b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.b == null || CyberVideoView.this.B <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.B;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i) {
                Surface d;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i);
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.b == null || CyberVideoView.this.s == null || (d = CyberVideoView.this.s.d()) == null) {
                            return true;
                        }
                        CyberVideoView.this.b.setSurface(d);
                        return true;
                    }
                } else if (i == 1) {
                    if (CyberVideoView.this.b != null && CyberVideoView.this.s != null) {
                        Surface d2 = CyberVideoView.this.s.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 != null) {
                            CyberVideoView.this.b.setSurface(d2);
                        }
                    }
                } else if (i == 2 && CyberVideoView.this.b != null && CyberVideoView.this.s != null) {
                    Surface d3 = CyberVideoView.this.s.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d3);
                    if (d3 != null) {
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.b);
                        CyberVideoView.this.b.setSurface(d3);
                    }
                }
                return false;
            }
        };
        this.t = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.t);
        this.a = context.getApplicationContext();
        this.u = new a();
        this.v = new ArrayList<>();
        reset();
        a();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, null);
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new HashMap<>();
        this.w = 0;
        this.x = true;
        this.A = 1.0f;
        this.B = 0L;
        this.C = false;
        this.D = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i2, final int i22, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i22, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a = m.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.v) {
                                for (int i3 = 0; i3 < CyberVideoView.this.v.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.v.get(i3)).onSnapShotComplete(a);
                                }
                                CyberVideoView.this.v.clear();
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
                        if (CyberVideoView.this.b != null && CyberVideoView.this.b.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            CyberVideoView.this.b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.b == null || CyberVideoView.this.B <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.B;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        CyberVideoView.this.b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i2) {
                Surface d;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i2);
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.b == null || CyberVideoView.this.s == null || (d = CyberVideoView.this.s.d()) == null) {
                            return true;
                        }
                        CyberVideoView.this.b.setSurface(d);
                        return true;
                    }
                } else if (i2 == 1) {
                    if (CyberVideoView.this.b != null && CyberVideoView.this.s != null) {
                        Surface d2 = CyberVideoView.this.s.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 != null) {
                            CyberVideoView.this.b.setSurface(d2);
                        }
                    }
                } else if (i2 == 2 && CyberVideoView.this.b != null && CyberVideoView.this.s != null) {
                    Surface d3 = CyberVideoView.this.s.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d3);
                    if (d3 != null) {
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.b);
                        CyberVideoView.this.b.setSurface(d3);
                    }
                }
                return false;
            }
        };
        this.t = a(i);
        this.a = context.getApplicationContext();
        this.u = new a();
        this.v = new ArrayList<>();
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
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        if (this.t == 0) {
            this.s = new b(this.a);
        } else if (this.t == 1) {
            this.s = new h(this.a);
            if (Build.VERSION.SDK_INT < 21) {
                setDecodeMode(1);
            }
        } else if (this.t == 2) {
            this.s = new g(this.a);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.s.setCyberSurfaceListener(this.D);
        this.s.getView().setLayoutParams(layoutParams);
        addView(this.s.getView());
        CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.s);
    }

    private boolean a(CyberPlayer cyberPlayer) {
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                CyberLog.i("CyberVideoView", "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!");
                return true;
            } else if (this.x && !cyberPlayer.isRemotePlayer()) {
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
        this.B = System.currentTimeMillis();
        d();
        try {
            if (this.b == null) {
                this.b = new CyberPlayer(this.w, this.k, this.x);
            }
            this.b.setOnPreparedListener(this);
            this.b.setOnCompletionListener(this);
            this.b.setOnVideoSizeChangedListener(this);
            this.b.setOnSeekCompleteListener(this);
            this.b.setOnBufferingUpdateListener(this);
            this.b.setOnErrorListener(this);
            this.b.setOnInfoListener(this);
            if (this.j != null) {
                for (String str : this.j.keySet()) {
                    this.b.setOption(str, this.j.get(str));
                }
            }
            this.b.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.B);
            if (this.C) {
                this.b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.b.setDataSource(this.a, this.c, this.d);
            this.b.prepareAsync();
            this.f = 1;
            if (this.s != null) {
                Surface d = this.s.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d + " mCyberPlayer:" + this.b);
                if (d != null) {
                    this.b.setSurface(d);
                }
            }
            this.b.setScreenOnWhilePlaying(true);
            if (this.y) {
                this.b.muteOrUnmuteAudio(this.y);
            }
            if (this.A != 1.0f) {
                this.b.setSpeed(this.A);
            }
            if (this.z) {
                this.b.setLooping(this.z);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0107a> b;
        if (this.b == null || (b = this.u.b()) == null) {
            return;
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            a.C0107a c0107a = b.get(i);
            if (c0107a != null && c0107a.a() != null) {
                this.b.setExternalInfo(c0107a.a(), c0107a.b());
            }
        }
    }

    private void d() {
        this.C = false;
        if (this.b != null) {
            if (this.t == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", true) && !a(this.b)) {
                e();
                CyberLog.i("CyberVideoView", "handlerLastPlay called reset last player");
            } else {
                f();
                CyberLog.i("CyberVideoView", "handlerLastPlay called release last player");
                if (this.t == 1) {
                    this.C = true;
                }
            }
        }
        g();
    }

    private void e() {
        if (this.b != null) {
            if (this.f != -1) {
                this.b.reset();
            } else {
                this.b.release();
                this.b = null;
            }
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
        }
    }

    private void f() {
        if (this.b != null) {
            if (this.b.getDecodeMode() == 4) {
                this.b.reset();
            }
            this.b.release();
            this.b = null;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
        }
    }

    private void g() {
        if (this.s != null) {
            this.s.a();
        }
    }

    private boolean h() {
        return (this.b == null || this.f == -1 || this.f == 0 || this.f == 1) ? false : true;
    }

    private boolean i() {
        return (this.b == null || this.f == 0 || this.f == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.b != null && TextUtils.isEmpty(m.c())) {
            String str2 = this.j != null ? this.j.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.b.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.b.changeProxyDynamic(str, true);
            }
            this.b.seekTo(getCurrentPosition() - 500);
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
        if (this.u != null) {
            this.u.a();
            this.u = null;
        }
        synchronized (this.v) {
            if (this.v != null) {
                this.v.clear();
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
        if (this.s != null) {
            removeAllViews();
            this.s.b();
            this.s = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (i()) {
            return this.b.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (i()) {
            return this.b.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.b;
    }

    public int getDecodeMode() {
        return this.w;
    }

    public long getDownloadSpeed() {
        if (this.b == null || this.f == 0) {
            return -1L;
        }
        return this.b.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (i()) {
            return this.b.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (i()) {
            return this.b.getPlayedTime();
        }
        return -1L;
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
        this.y = z;
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
        if (this.b != null) {
            this.b.muteOrUnmuteAudio(z);
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
        if (i == 10001 && this.b != null && this.b.getDecodeMode() != 4 && this.s != null) {
            this.s.setRawFrameRotation(i2);
        }
        return this.r != null && this.r.onInfo(i, i2, obj);
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
        if (this.s != null) {
            this.s.a(this.h, this.i, i3, i4);
        }
        if (this.m != null) {
            this.m.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (h()) {
            this.b.pause();
            this.f = 4;
        } else if (this.b != null) {
            this.b.sendCommand(1000, 0, 0L, null);
        }
        this.g = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        this.y = false;
        this.x = true;
        this.z = false;
        this.A = 1.0f;
        this.e = -1;
        this.c = null;
        this.d = null;
        this.k = null;
        this.w = 0;
        if (this.f == -1 && this.b != null) {
            this.b.release();
            this.b = null;
        }
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        if (this.b != null) {
            this.b.reset();
        }
        if (this.s != null) {
            this.s.c();
        }
        if (this.j != null) {
            this.j.clear();
        }
        if (this.u != null) {
            this.u.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        if (this.b != null) {
            if (h()) {
                this.b.seekTo(i);
            } else {
                this.e = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.w = i;
        if (Build.VERSION.SDK_INT >= 21 || this.w != 2) {
            return;
        }
        this.w = 1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.b != null) {
            this.b.setExternalInfo(str, obj);
        } else {
            this.u.a(str, obj);
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.k = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.z = z;
        if (this.b != null) {
            this.b.setLooping(z);
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
        if (this.b != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(m.c())) {
                this.b.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.x = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        CyberLog.i("CyberVideoView", "setSpeed()");
        this.A = f;
        if (this.b != null) {
            this.b.setSpeed(f);
        } else {
            CyberLog.i("CyberVideoView", "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        if (this.s != null) {
            this.s.setClientRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        if (this.s != null) {
            this.s.setDisplayMode(i);
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
        if (this.s != null) {
            this.s.setZOrderMediaOverlay(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.b + " mCurrentState:" + this.f);
        if (h()) {
            this.b.start();
            this.f = 3;
        } else if (this.b != null) {
            this.b.sendCommand(1000, 1, 0L, null);
        }
        this.g = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.b != null) {
            this.b.stop();
            this.b.release();
            this.b = null;
            this.f = 0;
            this.g = 0;
        }
        if (this.j != null) {
            this.j.clear();
        }
        if (this.s != null) {
            this.s.c();
            this.s.a();
        }
        if (this.u != null) {
            this.u.a();
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
        if (this.s != null) {
            if (this.s.e()) {
                synchronized (this.v) {
                    if (this.v.isEmpty()) {
                        this.s.a(f, i, i2);
                    }
                    this.v.add(onSnapShotCompleteListener);
                }
            } else {
                Bitmap a = this.s.a(f, i, i2);
                if (a != null && onSnapShotCompleteListener != null) {
                    onSnapShotCompleteListener.onSnapShotComplete(a);
                }
            }
            return true;
        }
        return false;
    }
}
