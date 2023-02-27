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
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
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
    public Context a;
    public CyberPlayer b;
    public Uri c;
    public Map<String, String> d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
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

    public CyberVideoView(Context context, int i) {
        this(context, null, i);
    }

    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 3;
        this.h = 0;
        this.i = 0;
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
            public void a(int i, int i2) {
                if (CyberVideoView.this.b != null) {
                    try {
                        CyberVideoView.this.b.updateDisplaySize(i, i2);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i, final int i2, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.y) {
                                for (int i3 = 0; i3 < CyberVideoView.this.y.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.y.get(i3)).onSnapShotComplete(a);
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
                        if (Build.VERSION.SDK_INT <= 16 && CyberVideoView.this.b != null && CyberVideoView.this.b.getDecodeMode() == 4) {
                            CyberVideoView.this.b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.b == null || CyberVideoView.this.E <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.E;
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
                Surface d2;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i);
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.b != null && CyberVideoView.this.v != null && (d2 = CyberVideoView.this.v.d()) != null) {
                            CyberVideoView.this.b.setSurface(d2);
                        }
                        return true;
                    }
                    return false;
                }
                if (i == 1) {
                    if (CyberVideoView.this.b == null || CyberVideoView.this.v == null) {
                        return false;
                    }
                    d = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                    if (d == null) {
                        return false;
                    }
                } else if (i != 2 || CyberVideoView.this.b == null || CyberVideoView.this.v == null) {
                    return false;
                } else {
                    d = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                    if (d == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.b);
                }
                CyberVideoView.this.b.setSurface(d);
                return false;
            }
        };
        this.w = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.w);
        this.a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList<>();
        reset();
        a();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f = 3;
        this.h = 0;
        this.i = 0;
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
            public void a(int i2, int i22) {
                if (CyberVideoView.this.b != null) {
                    try {
                        CyberVideoView.this.b.updateDisplaySize(i2, i22);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i2, final int i22, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i22, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.y) {
                                for (int i3 = 0; i3 < CyberVideoView.this.y.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.y.get(i3)).onSnapShotComplete(a);
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
                        if (Build.VERSION.SDK_INT <= 16 && CyberVideoView.this.b != null && CyberVideoView.this.b.getDecodeMode() == 4) {
                            CyberVideoView.this.b.sendCommand(1002, 0, j, null);
                        }
                        if (CyberVideoView.this.b == null || CyberVideoView.this.E <= 0) {
                            return;
                        }
                        long j2 = j - CyberVideoView.this.E;
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
                Surface d2;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i2);
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.b != null && CyberVideoView.this.v != null && (d2 = CyberVideoView.this.v.d()) != null) {
                            CyberVideoView.this.b.setSurface(d2);
                        }
                        return true;
                    }
                    return false;
                }
                if (i2 == 1) {
                    if (CyberVideoView.this.b == null || CyberVideoView.this.v == null) {
                        return false;
                    }
                    d = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                    if (d == null) {
                        return false;
                    }
                } else if (i2 != 2 || CyberVideoView.this.b == null || CyberVideoView.this.v == null) {
                    return false;
                } else {
                    d = CyberVideoView.this.v.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                    if (d == null) {
                        return false;
                    }
                    CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.b);
                }
                CyberVideoView.this.b.setSurface(d);
                return false;
            }
        };
        this.w = a(i);
        this.a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList<>();
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
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        int i = this.w;
        if (i != 0) {
            if (i == 1) {
                this.v = new h(this.a);
                if (Build.VERSION.SDK_INT < 21) {
                    setDecodeMode(1);
                }
            } else if (i == 2) {
                gVar = new g(this.a);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            this.v.setCyberSurfaceListener(this.I);
            this.v.getView().setLayoutParams(layoutParams);
            addView(this.v.getView());
            CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.v);
        }
        gVar = new b(this.a);
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
            int decodeMode = cyberPlayer.getDecodeMode();
            if (decodeMode == 4) {
                str = "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!";
            } else if (decodeMode == 1) {
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
        if (this.c == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        l.b();
        d();
        try {
            if (this.b == null) {
                this.b = new CyberPlayer(this.z, this.m, this.A);
            }
            this.b.setOnPreparedListener(this);
            this.b.setOnCompletionListener(this);
            this.b.setOnVideoSizeChangedListener(this);
            this.b.setOnSeekCompleteListener(this);
            this.b.setOnBufferingUpdateListener(this);
            this.b.setOnErrorListener(this);
            this.b.setOnInfoListener(this);
            this.b.setOnMediaSourceChangedListener(this);
            if (this.G != null) {
                this.b.setPlayJson(this.G);
            }
            if (this.H != null) {
                this.b.setClarityInfo(this.H);
            }
            if (this.l != null) {
                for (String str : this.l.keySet()) {
                    this.b.setOption(str, this.l.get(str));
                }
            }
            CyberPlayer cyberPlayer = this.b;
            cyberPlayer.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            if (this.F) {
                this.b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.b.setDataSource(this.a, this.c, this.d);
            this.b.prepareAsync();
            this.h = 1;
            if (this.v != null) {
                Surface d = this.v.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d + " mCyberPlayer:" + this.b);
                if (d != null) {
                    this.b.setSurface(d);
                }
            }
            this.b.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.b.muteOrUnmuteAudio(this.B);
            }
            if (this.D != 1.0f) {
                this.b.setSpeed(this.D);
            }
            if (this.C) {
                this.b.setLooping(this.C);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0087a> b;
        if (this.b == null || (b = this.x.b()) == null) {
            return;
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            a.C0087a c0087a = b.get(i);
            if (c0087a != null && c0087a.a() != null) {
                this.b.setExternalInfo(c0087a.a(), c0087a.b());
            }
        }
    }

    private void d() {
        this.F = false;
        if (this.b != null) {
            if (this.w == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.b)) {
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
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            if (this.h != -1) {
                cyberPlayer.reset();
            } else {
                cyberPlayer.release();
                this.b = null;
            }
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
        }
    }

    private void f() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.b.reset();
            }
            this.b.release();
            this.b = null;
            this.h = 0;
            this.i = 0;
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
        int i;
        return (this.b == null || (i = this.h) == -1 || i == 0 || i == 1) ? false : true;
    }

    private boolean i() {
        int i;
        return (this.b == null || (i = this.h) == 0 || i == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.b != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.l;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
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
            this.b.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
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
        Map<String, String> map = this.d;
        if (map != null) {
            map.clear();
            this.d = null;
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
        CyberPlayer cyberPlayer = this.b;
        return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.z;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer == null || this.h == 0) {
            return -1L;
        }
        return cyberPlayer.getDownloadSpeed();
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
        return h() && this.h == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.B = z;
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.r;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.h = 5;
        this.i = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.p;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.h = -1;
        this.i = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.s;
        if (onErrorListener != null) {
            return onErrorListener.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        CyberPlayer cyberPlayer;
        i iVar;
        if (i == 10001 && (cyberPlayer = this.b) != null && cyberPlayer.getDecodeMode() != 4 && (iVar = this.v) != null) {
            iVar.setRawFrameRotation(i2);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.t;
        return onInfoListener != null && onInfoListener.onInfo(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.u;
        return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.h = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.n;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i = this.e;
        if (i > 0) {
            seekTo(i, this.f);
        }
        this.e = -1;
        int i2 = this.g;
        if (i2 != Integer.MIN_VALUE) {
            switchMediaSource(i2);
            this.g = Integer.MIN_VALUE;
        }
        CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.i);
        if (this.i == 3 && this.h == 2) {
            start();
        } else if (this.i == 4 && this.h == 2) {
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
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.j = i;
        this.k = i2;
        CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i3 + " den:" + i4 + " width:" + i + " height:" + i2);
        i iVar = this.v;
        if (iVar != null) {
            iVar.a(this.j, this.k, i3, i4);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.o;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (h()) {
            this.b.pause();
            this.h = 4;
        } else {
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 0, 0L, null);
            }
        }
        this.i = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.B = false;
        this.A = true;
        this.C = false;
        this.D = 1.0f;
        this.e = -1;
        this.g = Integer.MIN_VALUE;
        this.c = null;
        this.d = null;
        this.m = null;
        this.G = null;
        this.H = null;
        this.z = 0;
        if (this.h == -1 && (cyberPlayer = this.b) != null) {
            cyberPlayer.release();
            this.b = null;
        }
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        CyberPlayer cyberPlayer2 = this.b;
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
    public void seekTo(int i, int i2) {
        if (this.b != null) {
            if (h()) {
                this.b.seekTo(i, i2);
                return;
            }
            this.f = i2;
            this.e = i;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setClarityInfo is null");
            return;
        }
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.setClarityInfo(str);
        } else {
            this.H = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.z = i;
        if (Build.VERSION.SDK_INT >= 21 || i != 2) {
            return;
        }
        this.z = 1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.b;
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
        CyberPlayer cyberPlayer = this.b;
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
        if (this.h != 0) {
            CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
            return;
        }
        HashMap<String, String> hashMap = this.l;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.b != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                this.b.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w("CyberVideoView", "setPlayJson is null");
            return;
        }
        CyberPlayer cyberPlayer = this.b;
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
    public void setSpeed(float f) {
        CyberLog.i("CyberVideoView", "setSpeed()");
        this.D = f;
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f);
        } else {
            CyberLog.i("CyberVideoView", "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        i iVar = this.v;
        if (iVar != null) {
            iVar.setClientRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        i iVar = this.v;
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
        this.c = uri;
        this.d = map;
        this.e = -1;
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
        CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.b + " mCurrentState:" + this.h);
        if (h()) {
            this.b.start();
            this.h = 3;
        } else {
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.i = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.stop();
            this.b.release();
            this.b = null;
            this.h = 0;
            this.i = 0;
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
    public void switchMediaSource(int i) {
        if (h()) {
            this.b.switchMediaSource(i);
        } else {
            this.g = i;
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
        i iVar = this.v;
        if (iVar != null) {
            if (iVar.e()) {
                synchronized (this.y) {
                    if (this.y.isEmpty()) {
                        this.v.a(f, i, i2);
                    }
                    this.y.add(onSnapShotCompleteListener);
                }
                return true;
            }
            Bitmap a = this.v.a(f, i, i2);
            if (a == null || onSnapShotCompleteListener == null) {
                return true;
            }
            onSnapShotCompleteListener.onSnapShotComplete(a);
            return true;
        }
        return false;
    }
}
