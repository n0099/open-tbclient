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
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class BVideoView extends GLSurfaceView implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {

    /* renamed from: a  reason: collision with root package name */
    public static String f4783a = "BVideoView";
    public boolean A;
    public float B;
    public long C;
    public String D;
    public String E;
    public i.a F;

    /* renamed from: b  reason: collision with root package name */
    public Context f4784b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayer f4785c;

    /* renamed from: d  reason: collision with root package name */
    public Uri f4786d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f4787e;

    /* renamed from: f  reason: collision with root package name */
    public int f4788f;

    /* renamed from: g  reason: collision with root package name */
    public int f4789g;

    /* renamed from: h  reason: collision with root package name */
    public int f4790h;

    /* renamed from: i  reason: collision with root package name */
    public int f4791i;
    public int j;
    public HashMap<String, String> k;
    public CyberPlayerManager.HttpDNS l;
    public boolean m;
    public CyberPlayerManager.OnPreparedListener n;
    public CyberPlayerManager.OnVideoSizeChangedListener o;
    public CyberPlayerManager.OnCompletionListener p;
    public CyberPlayerManager.OnSeekCompleteListener q;
    public CyberPlayerManager.OnBufferingUpdateListener r;
    public CyberPlayerManager.OnErrorListener s;
    public CyberPlayerManager.OnInfoListener t;
    public CyberPlayerManager.OnMediaSourceChangedListener u;
    public e v;
    public a w;
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> x;
    public int y;
    public boolean z;

    public BVideoView(Context context) {
        this(context, null);
    }

    public BVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4789g = 0;
        this.f4790h = 0;
        this.f4791i = 0;
        this.j = 0;
        this.k = new HashMap<>();
        this.m = true;
        this.y = 0;
        this.B = 1.0f;
        this.C = 0L;
        this.D = null;
        this.E = null;
        this.F = new i.a() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final int i2, final int i3, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = n.a(createBitmap);
                            CyberLog.d(BVideoView.f4783a, "onTakeSnapShot rotate bmp finished");
                            synchronized (BVideoView.this.x) {
                                for (int i4 = 0; i4 < BVideoView.this.x.size(); i4++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) BVideoView.this.x.get(i4)).onSnapShotComplete(a2);
                                }
                                BVideoView.this.x.clear();
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
                        if (BVideoView.this.f4785c != null && BVideoView.this.f4785c.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            BVideoView.this.f4785c.sendCommand(1002, 0, j, null);
                        }
                        if (BVideoView.this.f4785c == null || BVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - BVideoView.this.C;
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "20513");
                        hashMap.put("surface_drawed", "" + j2);
                        BVideoView.this.f4785c.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i2) {
                Surface c2;
                String str = BVideoView.f4783a;
                CyberLog.d(str, "onSurfaceReady renderType:" + i2);
                if (i2 != 0 || Build.VERSION.SDK_INT >= 16) {
                    return false;
                }
                if (BVideoView.this.f4785c == null || BVideoView.this.v == null || (c2 = BVideoView.this.v.c()) == null) {
                    return true;
                }
                BVideoView.this.f4785c.setSurface(c2);
                return true;
            }
        };
        this.f4784b = context.getApplicationContext();
        this.w = new a();
        this.x = new ArrayList<>();
        reset();
        a();
    }

    private void a() {
        if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.f4789g = 0;
        this.f4790h = 0;
        this.f4791i = 0;
        this.j = 0;
        setEGLContextClientVersion(2);
        e eVar = new e();
        this.v = eVar;
        setRenderer(eVar);
        setRenderMode(0);
        this.v.a(this.F);
        this.v.a(new e.a() { // from class: com.baidu.cyberplayer.sdk.BVideoView.1
            @Override // com.baidu.cyberplayer.sdk.e.a
            public void a() {
                BVideoView.this.requestRender();
            }
        });
    }

    public static boolean a(String str) {
        try {
            if (CyberCfgManager.getInstance().a("enable_hls_force_mediaplayer", false) && str.split("\\?")[0].endsWith(".m3u8")) {
                CyberLog.d(f4783a, "force mediaplayer");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void b() {
        Surface c2;
        if (this.f4786d == null) {
            return;
        }
        this.C = System.currentTimeMillis();
        d();
        try {
            if (a(this.f4786d.toString())) {
                this.y = 4;
            }
            CyberPlayer cyberPlayer = new CyberPlayer(this.y, this.l, this.m);
            this.f4785c = cyberPlayer;
            cyberPlayer.setOnPreparedListener(this);
            this.f4785c.setOnCompletionListener(this);
            this.f4785c.setOnVideoSizeChangedListener(this);
            this.f4785c.setOnSeekCompleteListener(this);
            this.f4785c.setOnBufferingUpdateListener(this);
            this.f4785c.setOnErrorListener(this);
            this.f4785c.setOnInfoListener(this);
            this.f4785c.setOnMediaSourceChangedListener(this);
            if (this.k != null) {
                for (String str : this.k.keySet()) {
                    this.f4785c.setOption(str, this.k.get(str));
                }
            }
            if (this.D != null) {
                this.f4785c.setPlayJson(this.D);
            }
            if (this.E != null) {
                this.f4785c.setClarityInfo(this.E);
            }
            CyberPlayer cyberPlayer2 = this.f4785c;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.C);
            this.f4785c.setDataSource(this.f4784b, this.f4786d, this.f4787e);
            this.f4785c.prepareAsync();
            this.f4789g = 1;
            if (this.v != null && (c2 = this.v.c()) != null) {
                this.f4785c.setSurface(c2);
            }
            this.f4785c.setScreenOnWhilePlaying(true);
            if (this.z) {
                this.f4785c.muteOrUnmuteAudio(this.z);
            }
            if (this.A) {
                this.f4785c.setLooping(this.A);
            }
            if (this.B != 1.0f) {
                this.f4785c.setSpeed(this.B);
            }
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0068a> b2;
        if (this.f4785c == null || (b2 = this.w.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0068a c0068a = b2.get(i2);
            if (c0068a != null && c0068a.a() != null) {
                this.f4785c.setExternalInfo(c0068a.a(), c0068a.b());
            }
        }
    }

    private void d() {
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer != null) {
            if (cyberPlayer.getDecodeMode() == 4) {
                this.f4785c.reset();
            }
            this.f4785c.release();
            this.f4785c = null;
            this.f4789g = 0;
            this.f4790h = 0;
            this.f4791i = 0;
            this.j = 0;
        }
        e eVar = this.v;
        if (eVar != null) {
            eVar.a();
        }
    }

    private boolean e() {
        int i2;
        return (this.f4785c == null || (i2 = this.f4789g) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    private boolean f() {
        int i2;
        return (this.f4785c == null || (i2 = this.f4789g) == 0 || i2 == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f4785c != null && TextUtils.isEmpty(n.c())) {
            HashMap<String, String> hashMap = this.k;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4785c.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f4785c.changeProxyDynamic(str, true);
            }
            this.f4785c.seekTo(getCurrentPosition() + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL);
            HashMap<String, String> hashMap2 = this.k;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i(f4783a, "destory called");
        d();
        HashMap<String, String> hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
            this.k = null;
        }
        a aVar = this.w;
        if (aVar != null) {
            aVar.a();
            this.w = null;
        }
        synchronized (this.x) {
            if (this.x != null) {
                this.x.clear();
            }
        }
        Map<String, String> map = this.f4787e;
        if (map != null) {
            map.clear();
            this.f4787e = null;
        }
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (f()) {
            return this.f4785c.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (f()) {
            return this.f4785c.getCurrentPositionSync();
        }
        return 0;
    }

    public CyberPlayer getCyberPlayer() {
        return this.f4785c;
    }

    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.f4785c;
        return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.y;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer == null || this.f4789g == 0) {
            return -1L;
        }
        return cyberPlayer.getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (f()) {
            return this.f4785c.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (f()) {
            return this.f4785c.getPlayedTime();
        }
        return -1L;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.j;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.f4791i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return e() && this.f4789g == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.z = z;
        String str = f4783a;
        CyberLog.i(str, "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i(f4783a, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
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
        this.f4789g = 5;
        this.f4790h = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.p;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        this.f4789g = -1;
        this.f4790h = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.s;
        if (onErrorListener != null) {
            return onErrorListener.onError(i2, i3, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        CyberPlayer cyberPlayer;
        if (i2 == 10001 && (cyberPlayer = this.f4785c) != null && cyberPlayer.getDecodeMode() != 4) {
            this.v.c(i3);
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
        this.f4789g = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.n;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int i2 = this.f4788f;
        if (i2 > 0) {
            seekTo(i2);
        }
        this.f4788f = -1;
        String str = f4783a;
        CyberLog.i(str, "onPrepared mTargetState::" + this.f4790h);
        if (this.f4790h == 3 && this.f4789g == 2) {
            start();
        } else if (this.f4790h == 4 && this.f4789g == 2) {
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
        this.f4791i = i2;
        this.j = i3;
        e eVar = this.v;
        if (eVar != null) {
            eVar.a(i2, i3, i4, i5);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.o;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (e()) {
            this.f4785c.pause();
            this.f4789g = 4;
        } else {
            CyberPlayer cyberPlayer = this.f4785c;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 0, 0L, null);
            }
        }
        this.f4790h = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.z = false;
        this.m = true;
        this.A = false;
        this.B = 1.0f;
        this.f4788f = -1;
        this.f4786d = null;
        this.f4787e = null;
        this.l = null;
        this.E = null;
        this.D = null;
        if (this.f4789g == -1 && (cyberPlayer = this.f4785c) != null) {
            cyberPlayer.release();
            this.f4785c = null;
        }
        this.y = 0;
        this.f4789g = 0;
        this.f4790h = 0;
        this.f4791i = 0;
        this.j = 0;
        CyberPlayer cyberPlayer2 = this.f4785c;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        e eVar = this.v;
        if (eVar != null) {
            eVar.b();
        }
        HashMap<String, String> hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
        a aVar = this.w;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2) {
        if (this.f4785c != null) {
            if (e()) {
                this.f4785c.seekTo(i2);
            } else {
                this.f4788f = i2;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(f4783a, "setClarityInfo is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer != null) {
            cyberPlayer.setClarityInfo(str);
        } else {
            this.E = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.y = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.w.a(str, obj);
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.l = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.A = z;
        CyberPlayer cyberPlayer = this.f4785c;
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
        if (this.f4789g != 0) {
            CyberLog.i(f4783a, "Do not set option when the video player playing");
            return;
        }
        HashMap<String, String> hashMap = this.k;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.f4785c != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(n.c())) {
                this.f4785c.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(f4783a, "setPlayJson is null");
            return;
        }
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
        } else {
            this.D = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        CyberLog.i(f4783a, "setSpeed()");
        this.B = f2;
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f2);
        } else {
            CyberLog.i(f4783a, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i2) {
        e eVar = this.v;
        if (eVar != null) {
            eVar.b(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
        e eVar = this.v;
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
        this.f4786d = uri;
        this.f4787e = map;
        this.f4788f = -1;
        b();
        requestLayout();
        invalidate();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        String str = f4783a;
        CyberLog.i(str, "start mCyberPlayer:" + this.f4785c + " mCurrentState:" + this.f4789g);
        if (e()) {
            this.f4785c.start();
            this.f4789g = 3;
        } else {
            CyberPlayer cyberPlayer = this.f4785c;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.f4790h = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.f4785c;
        if (cyberPlayer != null) {
            cyberPlayer.setOnPreparedListener(null);
            this.f4785c.setOnCompletionListener(null);
            this.f4785c.setOnVideoSizeChangedListener(null);
            this.f4785c.setOnSeekCompleteListener(null);
            this.f4785c.setOnBufferingUpdateListener(null);
            this.f4785c.setOnErrorListener(null);
            this.f4785c.setOnInfoListener(null);
            this.f4785c.setOnMediaSourceChangedListener(null);
            this.f4785c.stop();
            this.f4785c.release();
            this.f4785c = null;
            this.f4789g = 0;
            this.f4790h = 0;
        }
        HashMap<String, String> hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
        e eVar = this.v;
        if (eVar != null) {
            eVar.a();
        }
        a aVar = this.w;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i2) {
        if (f()) {
            this.f4785c.switchMediaSource(i2);
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
        CyberLog.d(f4783a, "takeSnapshotAsync called");
        if (this.v != null) {
            synchronized (this.x) {
                if (this.x.isEmpty()) {
                    this.v.a(f2, i2, i3);
                }
                this.x.add(onSnapShotCompleteListener);
            }
            return true;
        }
        return false;
    }
}
