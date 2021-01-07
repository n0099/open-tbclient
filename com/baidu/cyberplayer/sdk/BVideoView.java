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
/* loaded from: classes6.dex */
public class BVideoView extends GLSurfaceView implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {

    /* renamed from: a  reason: collision with root package name */
    static String f1743a = "BVideoView";
    private boolean A;
    private float B;
    private long C;
    private String D;
    private String E;
    private i.a F;

    /* renamed from: b  reason: collision with root package name */
    private Context f1744b;
    private CyberPlayer c;
    private Uri d;
    private Map<String, String> e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private HashMap<String, String> k;
    private CyberPlayerManager.HttpDNS l;
    private boolean m;
    private CyberPlayerManager.OnPreparedListener n;
    private CyberPlayerManager.OnVideoSizeChangedListener o;
    private CyberPlayerManager.OnCompletionListener p;
    private CyberPlayerManager.OnSeekCompleteListener q;
    private CyberPlayerManager.OnBufferingUpdateListener r;
    private CyberPlayerManager.OnErrorListener s;
    private CyberPlayerManager.OnInfoListener t;
    private CyberPlayerManager.OnMediaSourceChangedListener u;
    private e v;
    private a w;
    private ArrayList<ICyberVideoView.OnSnapShotCompleteListener> x;
    private int y;
    private boolean z;

    public BVideoView(Context context) {
        this(context, null);
    }

    public BVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.h = 0;
        this.i = 0;
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
            public void a(final int i, final int i2, final Buffer buffer) {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (buffer != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(buffer);
                            Bitmap a2 = n.a(createBitmap);
                            CyberLog.d(BVideoView.f1743a, "onTakeSnapShot rotate bmp finished");
                            synchronized (BVideoView.this.x) {
                                for (int i3 = 0; i3 < BVideoView.this.x.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) BVideoView.this.x.get(i3)).onSnapShotComplete(a2);
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
                        if (BVideoView.this.c != null && BVideoView.this.c.getDecodeMode() == 4 && Build.VERSION.SDK_INT <= 16) {
                            BVideoView.this.c.sendCommand(1002, 0, j, null);
                        }
                        if (BVideoView.this.c == null || BVideoView.this.C <= 0) {
                            return;
                        }
                        long j2 = j - BVideoView.this.C;
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
                CyberLog.d(BVideoView.f1743a, "onSurfaceReady renderType:" + i);
                if (i != 0 || Build.VERSION.SDK_INT >= 16) {
                    return false;
                }
                if (BVideoView.this.c != null && BVideoView.this.v != null && (c = BVideoView.this.v.c()) != null) {
                    BVideoView.this.c.setSurface(c);
                }
                return true;
            }
        };
        this.f1744b = context.getApplicationContext();
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
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        setEGLContextClientVersion(2);
        this.v = new e();
        setRenderer(this.v);
        setRenderMode(0);
        this.v.a(this.F);
        this.v.a(new e.a() { // from class: com.baidu.cyberplayer.sdk.BVideoView.1
            @Override // com.baidu.cyberplayer.sdk.e.a
            public void a() {
                BVideoView.this.requestRender();
            }
        });
    }

    private static boolean a(String str) {
        try {
            if (CyberCfgManager.getInstance().a("enable_hls_force_mediaplayer", false) && str.split("\\?")[0].endsWith(".m3u8")) {
                CyberLog.d(f1743a, "force mediaplayer");
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private void b() {
        Surface c;
        if (this.d == null) {
            return;
        }
        this.C = System.currentTimeMillis();
        d();
        try {
            if (a(this.d.toString())) {
                this.y = 4;
            }
            this.c = new CyberPlayer(this.y, this.l, this.m);
            this.c.setOnPreparedListener(this);
            this.c.setOnCompletionListener(this);
            this.c.setOnVideoSizeChangedListener(this);
            this.c.setOnSeekCompleteListener(this);
            this.c.setOnBufferingUpdateListener(this);
            this.c.setOnErrorListener(this);
            this.c.setOnInfoListener(this);
            this.c.setOnMediaSourceChangedListener(this);
            if (this.k != null) {
                for (String str : this.k.keySet()) {
                    this.c.setOption(str, this.k.get(str));
                }
            }
            if (this.D != null) {
                this.c.setPlayJson(this.D);
            }
            if (this.E != null) {
                this.c.setClarityInfo(this.E);
            }
            this.c.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.C);
            this.c.setDataSource(this.f1744b, this.d, this.e);
            this.c.prepareAsync();
            this.g = 1;
            if (this.v != null && (c = this.v.c()) != null) {
                this.c.setSurface(c);
            }
            this.c.setScreenOnWhilePlaying(true);
            if (this.z) {
                this.c.muteOrUnmuteAudio(this.z);
            }
            if (this.A) {
                this.c.setLooping(this.A);
            }
            if (this.B != 1.0f) {
                this.c.setSpeed(this.B);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0100a> b2;
        if (this.c == null || (b2 = this.w.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            a.C0100a c0100a = b2.get(i);
            if (c0100a != null && c0100a.a() != null) {
                this.c.setExternalInfo(c0100a.a(), c0100a.b());
            }
        }
    }

    private void d() {
        if (this.c != null) {
            if (this.c.getDecodeMode() == 4) {
                this.c.reset();
            }
            this.c.release();
            this.c = null;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
        }
        if (this.v != null) {
            this.v.a();
        }
    }

    private boolean e() {
        return (this.c == null || this.g == -1 || this.g == 0 || this.g == 1) ? false : true;
    }

    private boolean f() {
        return (this.c == null || this.g == 0 || this.g == 1) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.c != null && TextUtils.isEmpty(n.c())) {
            String str2 = this.k != null ? this.k.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
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
            this.c.seekTo(getCurrentPosition() + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL);
            if (this.k != null) {
                this.k.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i(f1743a, "destory called");
        d();
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        if (this.w != null) {
            this.w.a();
            this.w = null;
        }
        synchronized (this.x) {
            if (this.x != null) {
                this.x.clear();
            }
        }
        if (this.e != null) {
            this.e.clear();
            this.e = null;
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
        return this.c != null ? this.c.getDecodeMode() : this.y;
    }

    public long getDownloadSpeed() {
        if (this.c == null || this.g == 0) {
            return -1L;
        }
        return this.c.getDownloadSpeed();
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
        return this.j;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return e() && this.g == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.z = z;
        CyberLog.i(f1743a, "muteOrUnmuteAudio flag:" + z);
        if (this.c != null) {
            this.c.muteOrUnmuteAudio(z);
        } else {
            CyberLog.i(f1743a, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        if (this.r != null) {
            this.r.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.g = 5;
        this.h = 5;
        if (this.p != null) {
            this.p.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.g = -1;
        this.h = -1;
        if (this.s != null) {
            return this.s.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 10001 && this.c != null && this.c.getDecodeMode() != 4) {
            this.v.c(i2);
        }
        return this.t != null && this.t.onInfo(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        return this.u != null && this.u.onMediaSourceChanged(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.g = 2;
        if (this.n != null) {
            this.n.onPrepared();
        }
        if (this.f > 0) {
            seekTo(this.f);
        }
        this.f = -1;
        CyberLog.i(f1743a, "onPrepared mTargetState::" + this.h);
        if (this.h == 3 && this.g == 2) {
            start();
        } else if (this.h == 4 && this.g == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        if (this.q != null) {
            this.q.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        if (this.v != null) {
            this.v.a(this.i, this.j, i3, i4);
        }
        if (this.o != null) {
            this.o.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (e()) {
            this.c.pause();
            this.g = 4;
        } else if (this.c != null) {
            this.c.sendCommand(1000, 0, 0L, null);
        }
        this.h = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        this.z = false;
        this.m = true;
        this.A = false;
        this.B = 1.0f;
        this.f = -1;
        this.d = null;
        this.e = null;
        this.l = null;
        this.E = null;
        this.D = null;
        if (this.g == -1 && this.c != null) {
            this.c.release();
            this.c = null;
        }
        this.y = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        if (this.c != null) {
            this.c.reset();
        }
        if (this.v != null) {
            this.v.b();
        }
        if (this.k != null) {
            this.k.clear();
        }
        if (this.w != null) {
            this.w.a();
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
    public void setClarityInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(f1743a, "setClarityInfo is null");
        } else if (this.c != null) {
            this.c.setClarityInfo(str);
        } else {
            this.E = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.y = i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.c != null) {
            this.c.setExternalInfo(str, obj);
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
        if (this.c != null) {
            this.c.setLooping(z);
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
        if (this.g != 0) {
            CyberLog.i(f1743a, "Do not set option when the video player playing");
            return;
        }
        if (this.k != null) {
            this.k.put(str, str2);
        }
        if (this.c != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(n.c())) {
                this.c.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (TextUtils.isEmpty(str)) {
            CyberLog.w(f1743a, "setPlayJson is null");
        } else if (this.c != null) {
            this.c.setPlayJson(str);
        } else {
            this.D = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        CyberLog.i(f1743a, "setSpeed()");
        this.B = f;
        if (this.c != null) {
            this.c.setSpeed(f);
        } else {
            CyberLog.i(f1743a, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        if (this.v != null) {
            this.v.b(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        if (this.v != null) {
            this.v.a(i);
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
        CyberLog.i(f1743a, "start mCyberPlayer:" + this.c + " mCurrentState:" + this.g);
        if (e()) {
            this.c.start();
            this.g = 3;
        } else if (this.c != null) {
            this.c.sendCommand(1000, 1, 0L, null);
        }
        this.h = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.c != null) {
            this.c.setOnPreparedListener(null);
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
            this.g = 0;
            this.h = 0;
        }
        if (this.k != null) {
            this.k.clear();
        }
        if (this.v != null) {
            this.v.a();
        }
        if (this.w != null) {
            this.w.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        if (f()) {
            this.c.switchMediaSource(i);
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
        CyberLog.d(f1743a, "takeSnapshotAsync called");
        if (this.v != null) {
            synchronized (this.x) {
                if (this.x.isEmpty()) {
                    this.v.a(f, i, i2);
                }
                this.x.add(onSnapShotCompleteListener);
            }
            return true;
        }
        return false;
    }
}
