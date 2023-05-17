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
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class BVideoView extends GLSurfaceView implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public static String a = "BVideoView";
    public int A;
    public boolean B;
    public boolean C;
    public float D;
    public long E;
    public String F;
    public String G;
    public i.a H;
    public Context b;
    public CyberPlayer c;
    public Uri d;
    public Map<String, String> e;
    public int f;
    public int g;
    public int h;
    public int i;
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
        this.g = 3;
        this.i = 0;
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
            public void a(int i, int i2) {
                if (BVideoView.this.c != null) {
                    try {
                        BVideoView.this.c.updateDisplaySize(i, i2);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i, final int i2, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = o.a(createBitmap);
                            CyberLog.d(BVideoView.a, "onTakeSnapShot rotate bmp finished");
                            synchronized (BVideoView.this.z) {
                                for (int i3 = 0; i3 < BVideoView.this.z.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) BVideoView.this.z.get(i3)).onSnapShotComplete(a2);
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
                        if (BVideoView.this.c != null && Build.VERSION.SDK_INT <= 16 && BVideoView.this.c.getDecodeMode() == 4) {
                            BVideoView.this.c.sendCommand(1002, 0, j, null);
                        }
                        if (BVideoView.this.c == null || BVideoView.this.E <= 0) {
                            return;
                        }
                        long j2 = j - BVideoView.this.E;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        BVideoView.this.c.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i) {
                Surface c;
                String str = BVideoView.a;
                CyberLog.d(str, "onSurfaceReady renderType:" + i);
                if (i != 0 || Build.VERSION.SDK_INT >= 16) {
                    return false;
                }
                if (BVideoView.this.c == null || BVideoView.this.x == null || (c = BVideoView.this.x.c()) == null) {
                    return true;
                }
                BVideoView.this.c.setSurface(c);
                return true;
            }
        };
        this.b = context.getApplicationContext();
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
        this.i = 0;
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
                CyberLog.d(a, "force mediaplayer");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void b() {
        Surface c;
        if (this.d == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        l.b();
        d();
        try {
            if (a(this.d.toString())) {
                this.A = 4;
            }
            CyberPlayer cyberPlayer = new CyberPlayer(this.A, this.n, this.o);
            this.c = cyberPlayer;
            cyberPlayer.setOnPreparedListener(this);
            this.c.setOnCompletionListener(this);
            this.c.setOnVideoSizeChangedListener(this);
            this.c.setOnSeekCompleteListener(this);
            this.c.setOnBufferingUpdateListener(this);
            this.c.setOnErrorListener(this);
            this.c.setOnInfoListener(this);
            this.c.setOnMediaSourceChangedListener(this);
            if (this.m != null) {
                for (String str : this.m.keySet()) {
                    this.c.setOption(str, this.m.get(str));
                }
            }
            if (this.F != null) {
                this.c.setPlayJson(this.F);
            }
            if (this.G != null) {
                this.c.setClarityInfo(this.G);
            }
            CyberPlayer cyberPlayer2 = this.c;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            this.c.setDataSource(this.b, this.d, this.e);
            this.c.prepareAsync();
            this.i = 1;
            if (this.x != null && (c = this.x.c()) != null) {
                this.c.setSurface(c);
            }
            this.c.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.c.muteOrUnmuteAudio(this.B);
            }
            if (this.C) {
                this.c.setLooping(this.C);
            }
            if (this.D != 1.0f) {
                this.c.setSpeed(this.D);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0090a> b;
        if (this.c == null || (b = this.y.b()) == null) {
            return;
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            a.C0090a c0090a = b.get(i);
            if (c0090a != null && c0090a.a() != null) {
                this.c.setExternalInfo(c0090a.a(), c0090a.b());
            }
        }
    }

    private void d() {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.c.reset();
            }
            this.c.release();
            this.c = null;
            this.i = 0;
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
        int i;
        return (this.c == null || (i = this.i) == -1 || i == 0 || i == 1) ? false : true;
    }

    private boolean f() {
        int i;
        return (this.c == null || (i = this.i) == 0 || i == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.c != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.m;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.c.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.c.changeProxyDynamic(str, true);
            }
            this.c.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
            HashMap<String, String> hashMap2 = this.m;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i(a, "destory called");
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
        Map<String, String> map = this.e;
        if (map != null) {
            map.clear();
            this.e = null;
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
            return this.c.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (f()) {
            return this.c.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.c;
    }

    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.c;
        return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.A;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer == null || this.i == 0) {
            return -1L;
        }
        return cyberPlayer.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (f()) {
            return this.c.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (f()) {
            return this.c.getPlayedTime();
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
        return e() && this.i == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.B = z;
        String str = a;
        CyberLog.i(str, "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i(a, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.t;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.i = 5;
        this.j = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.r;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.i = -1;
        this.j = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.u;
        if (onErrorListener != null) {
            return onErrorListener.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        CyberPlayer cyberPlayer;
        if (i == 10001 && (cyberPlayer = this.c) != null && cyberPlayer.getDecodeMode() != 4) {
            this.x.c(i2);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.v;
        return onInfoListener != null && onInfoListener.onInfo(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.w;
        return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.i = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.p;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i = this.f;
        if (i > 0) {
            seekTo(i, this.g);
        }
        this.f = -1;
        int i2 = this.h;
        if (i2 != Integer.MIN_VALUE) {
            switchMediaSource(i2);
            this.h = Integer.MIN_VALUE;
        }
        String str = a;
        CyberLog.i(str, "onPrepared mTargetState::" + this.j);
        if (this.j == 3 && this.i == 2) {
            start();
        } else if (this.j == 4 && this.i == 2) {
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
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.k = i;
        this.l = i2;
        e eVar = this.x;
        if (eVar != null) {
            eVar.a(i, i2, i3, i4);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.q;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (e()) {
            this.c.pause();
            this.i = 4;
        } else {
            CyberPlayer cyberPlayer = this.c;
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
        this.f = -1;
        this.h = Integer.MIN_VALUE;
        this.d = null;
        this.e = null;
        this.n = null;
        this.G = null;
        this.F = null;
        if (this.i == -1 && (cyberPlayer = this.c) != null) {
            cyberPlayer.release();
            this.c = null;
        }
        this.A = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        CyberPlayer cyberPlayer2 = this.c;
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
    public void seekTo(int i) {
        if (this.c != null) {
            if (e()) {
                this.c.seekTo(i);
            } else {
                this.f = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i, int i2) {
        if (this.c != null) {
            if (e()) {
                this.c.seekTo(i, i2);
                return;
            }
            this.g = i2;
            this.f = i;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(a, "setClarityInfo is null");
            return;
        }
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.setClarityInfo(str);
        } else {
            this.G = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.A = i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.c;
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
        CyberPlayer cyberPlayer = this.c;
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
        if (this.i != 0) {
            CyberLog.i(a, "Do not set option when the video player playing");
            return;
        }
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.c != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                this.c.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(a, "setPlayJson is null");
            return;
        }
        CyberPlayer cyberPlayer = this.c;
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
    public void setSpeed(float f) {
        CyberLog.i(a, "setSpeed()");
        this.D = f;
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f);
        } else {
            CyberLog.i(a, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        e eVar = this.x;
        if (eVar != null) {
            eVar.b(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        e eVar = this.x;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.d = uri;
        this.e = map;
        this.f = -1;
        b();
        requestLayout();
        invalidate();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        String str = a;
        CyberLog.i(str, "start mCyberPlayer:" + this.c + " mCurrentState:" + this.i);
        if (e()) {
            this.c.start();
            this.i = 3;
        } else {
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.j = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.setOnPreparedListener(null);
            this.c.setOnCompletionListener(null);
            this.c.setOnVideoSizeChangedListener(null);
            this.c.setOnSeekCompleteListener(null);
            this.c.setOnBufferingUpdateListener(null);
            this.c.setOnErrorListener(null);
            this.c.setOnInfoListener(null);
            this.c.setOnMediaSourceChangedListener(null);
            this.c.stop();
            this.c.release();
            this.c = null;
            this.i = 0;
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
    public void switchMediaSource(int i) {
        if (e()) {
            this.c.switchMediaSource(i);
        } else {
            this.h = i;
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
        CyberLog.d(a, "takeSnapshotAsync called");
        if (this.x != null) {
            synchronized (this.z) {
                if (this.z.isEmpty()) {
                    this.x.a(f, i, i2);
                }
                this.z.add(onSnapShotCompleteListener);
            }
            return true;
        }
        return false;
    }
}
