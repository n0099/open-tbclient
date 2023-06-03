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
import com.baidu.cyberplayer.sdk.debug.DebugConfigManager;
import com.baidu.cyberplayer.sdk.g;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class BVideoView extends GLSurfaceView implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public static String a = "BVideoView";
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> A;
    public int B;
    public boolean C;
    public boolean D;
    public float E;
    public long F;
    public String G;
    public String H;
    public i.a I;
    public Context b;
    public CyberPlayer c;
    public Uri d;
    public Map<String, String> e;
    public int f;
    public int g;
    public int h;
    public CyberPlayerManager.MediaSourceSwitchMode i;
    public int j;
    public int k;
    public int l;
    public int m;
    public HashMap<String, String> n;
    public CyberPlayerManager.HttpDNS o;
    public boolean p;
    public CyberPlayerManager.OnPreparedListener q;
    public CyberPlayerManager.OnVideoSizeChangedListener r;
    public CyberPlayerManager.OnCompletionListener s;
    public CyberPlayerManager.OnSeekCompleteListener t;
    public CyberPlayerManager.OnBufferingUpdateListener u;
    public CyberPlayerManager.OnErrorListener v;
    public CyberPlayerManager.OnInfoListener w;
    public CyberPlayerManager.OnMediaSourceChangedListener x;
    public g y;
    public a z;

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalSurface(Surface surface) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean setFilterRegion(float f, float f2, float f3, float f4) {
        return false;
    }

    public BVideoView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void debugShowOptions(View view2) {
        CyberPlayer cyberPlayer;
        Context context = this.b;
        if (context != null && (cyberPlayer = this.c) != null) {
            DebugConfigManager.showPlayerConfigOptions(view2, context, cyberPlayer);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.getMediaRuntimeInfo(onMediaRuntimeInfoListener);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.u;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
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
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
                return;
            } else {
                this.H = str;
                return;
            }
        }
        CyberLog.w(a, "setClarityInfo is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.B = i;
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.o = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.D = z;
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.u = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.s = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.v = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.w = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.x = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.q = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.t = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.r = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.setPlayJson(str);
                return;
            } else {
                this.G = str;
                return;
            }
        }
        CyberLog.w(a, "setPlayJson is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.p = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        CyberLog.i(a, "setSpeed()");
        this.E = f;
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
        g gVar = this.y;
        if (gVar != null) {
            gVar.b(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        g gVar = this.y;
        if (gVar != null) {
            gVar.a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        if (e()) {
            this.c.switchMediaSource(i);
            return;
        }
        this.h = i;
        if (i == -1) {
            this.i = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE;
        } else {
            this.i = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_FORCE_MODE;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0);
    }

    public BVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 3;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = new HashMap<>();
        this.p = true;
        this.B = 0;
        this.E = 1.0f;
        this.F = 0L;
        this.G = null;
        this.H = null;
        this.I = new i.a() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void b(int i) {
            }

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
                            Bitmap a2 = q.a(createBitmap);
                            CyberLog.d(BVideoView.a, "onTakeSnapShot rotate bmp finished");
                            synchronized (BVideoView.this.A) {
                                for (int i3 = 0; i3 < BVideoView.this.A.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) BVideoView.this.A.get(i3)).onSnapShotComplete(a2);
                                }
                                BVideoView.this.A.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final long j) {
                if (!CyberCfgManager.getInstance().a("judge_thread_on_first_frame", false) || Looper.getMainLooper().getThread() != Thread.currentThread()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BVideoView.this.a(j);
                        }
                    });
                } else {
                    BVideoView.this.a(j);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i) {
                Surface d;
                String str = BVideoView.a;
                CyberLog.d(str, "onSurfaceReady renderType:" + i);
                if (i == 0 && Build.VERSION.SDK_INT < 16) {
                    if (BVideoView.this.c != null && BVideoView.this.y != null && (d = BVideoView.this.y.d()) != null) {
                        BVideoView.this.c.setSurface(d);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        };
        this.b = context.getApplicationContext();
        this.z = new a();
        this.A = new ArrayList<>();
        reset();
        a();
    }

    private void a() {
        if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        setEGLContextClientVersion(2);
        g gVar = new g();
        this.y = gVar;
        setRenderer(gVar);
        setRenderMode(0);
        this.y.a(this.I);
        this.y.a(new g.a() { // from class: com.baidu.cyberplayer.sdk.BVideoView.1
            @Override // com.baidu.cyberplayer.sdk.g.a
            public void a() {
                BVideoView.this.requestRender();
            }
        });
    }

    private void c() {
        ArrayList<a.C0090a> b;
        if (this.c != null && (b = this.z.b()) != null) {
            int size = b.size();
            for (int i = 0; i < size; i++) {
                a.C0090a c0090a = b.get(i);
                if (c0090a != null && c0090a.a() != null) {
                    this.c.setExternalInfo(c0090a.a(), c0090a.b());
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        String str = a;
        CyberLog.i(str, "start mCyberPlayer:" + this.c + " mCurrentState:" + this.j);
        if (e()) {
            this.c.start();
            this.j = 3;
        } else {
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.k = 3;
    }

    private void a(int i, String str, String str2) {
        if (this.c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "" + i);
        hashMap.put(str, str2);
        this.c.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.j = -1;
        this.k = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.v;
        if (onErrorListener != null) {
            return onErrorListener.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        CyberPlayer cyberPlayer;
        if (i == 10001 && (cyberPlayer = this.c) != null && cyberPlayer.getDecodeMode() != 4) {
            this.y.c(i2);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.w;
        if (onInfoListener != null && onInfoListener.onInfo(i, i2, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.x;
        if (onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map, Map<String, String> map2) {
        if (map2 != null) {
            this.n.putAll(map2);
        }
        this.d = uri;
        this.e = map;
        this.f = -1;
        b();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        CyberPlayer cyberPlayer;
        if (Build.VERSION.SDK_INT <= 16 && (cyberPlayer = this.c) != null && cyberPlayer.getDecodeMode() == 4) {
            this.c.sendCommand(1002, 0, j, null);
        }
        if (this.c != null) {
            long j2 = this.F;
            if (j2 > 0) {
                a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, "surface_drawed", "" + (j - j2));
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.C = z;
        String str = a;
        CyberLog.i(str, "muteOrUnmuteAudio flag:" + z);
        if (this.c != null) {
            String str2 = a;
            CyberLog.y(str2, this.c + ", muteOrUnmuteAudio flag:" + z);
            this.c.muteOrUnmuteAudio(z);
            return;
        }
        CyberLog.i(a, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
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
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.z.a(str, obj);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.j == 0) {
            HashMap<String, String> hashMap = this.n;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.c != null) {
                if (str != null && str.equals(CyberPlayerManager.OPT_HTTP_PROXY) && !TextUtils.isEmpty(q.c())) {
                    return;
                }
                this.c.setOption(str, str2);
                return;
            }
            return;
        }
        CyberLog.i(a, "Do not set option when the video player playing");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        setVideoURI(uri, map, null);
    }

    public void setVolume(float f, float f2) {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.setVolume(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        if (e()) {
            this.c.switchMediaSource(i, mediaSourceSwitchMode);
            return;
        }
        this.h = i;
        this.i = mediaSourceSwitchMode;
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
        Surface d;
        if (this.d == null) {
            return;
        }
        this.F = System.currentTimeMillis();
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_OPEN_VIDEO);
        PlayerConfigManager.startRequestPlayerServerCfg();
        d();
        try {
            if (a(this.d.toString())) {
                this.B = 4;
            }
            CyberPlayer cyberPlayer = new CyberPlayer(this.B, this.o, this.p);
            this.c = cyberPlayer;
            cyberPlayer.setOnPreparedListener(this);
            this.c.setOnCompletionListener(this);
            this.c.setOnVideoSizeChangedListener(this);
            this.c.setOnSeekCompleteListener(this);
            this.c.setOnBufferingUpdateListener(this);
            this.c.setOnErrorListener(this);
            this.c.setOnInfoListener(this);
            this.c.setOnMediaSourceChangedListener(this);
            if (this.n != null) {
                for (String str : this.n.keySet()) {
                    this.c.setOption(str, this.n.get(str));
                }
            }
            if (this.G != null) {
                this.c.setPlayJson(this.G);
            }
            if (this.H != null) {
                this.c.setClarityInfo(this.H);
            }
            CyberPlayer cyberPlayer2 = this.c;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.F);
            this.c.setDataSource(this.b, this.d, this.e);
            this.c.prepareAsync();
            this.j = 1;
            if (this.y != null && (d = this.y.d()) != null) {
                this.c.setSurface(d);
            }
            this.c.setScreenOnWhilePlaying(true);
            if (this.C) {
                this.c.muteOrUnmuteAudio(this.C);
            }
            if (this.D) {
                this.c.setLooping(this.D);
            }
            if (this.E != 1.0f) {
                this.c.setSpeed(this.E);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            int i = -111;
            if (CyberCfgManager.getInstance().a("java_error_code_mapping", true)) {
                i = CyberErrorMapper.getInstance().mapErrNo(-111);
            }
            onError(i, 0, null);
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
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
        }
        g gVar = this.y;
        if (gVar != null) {
            gVar.c();
        }
    }

    private boolean e() {
        int i;
        if (this.c != null && (i = this.j) != -1 && i != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private boolean f() {
        int i;
        if (this.c != null && (i = this.j) != 0 && i != 1) {
            return true;
        }
        return false;
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

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            return cyberPlayer.getDecodeMode();
        }
        return this.B;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null && this.j != 0) {
            return cyberPlayer.getDownloadSpeed();
        }
        return -1L;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (f()) {
            return this.c.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public MediaInfo getMediaInfo() {
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer == null) {
            return null;
        }
        return cyberPlayer.getMediaInfo();
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
        return this.m;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.l;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        if (e() && this.j == 3) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.j = 5;
        this.k = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.s;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.t;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stepToNextFrame() {
        if (this.c != null) {
            if (this.j == 3) {
                pause();
            }
            this.c.stepToNextFrame();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        String str2;
        if (this.c == null || !TextUtils.isEmpty(q.c())) {
            return;
        }
        HashMap<String, String> hashMap = this.n;
        if (hashMap != null) {
            str2 = hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY);
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(str2)) {
                return;
            }
            this.c.changeProxyDynamic(str, true);
        } else if (TextUtils.isEmpty(str2)) {
            return;
        } else {
            this.c.changeProxyDynamic(null, false);
        }
        this.c.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
        HashMap<String, String> hashMap2 = this.n;
        if (hashMap2 != null) {
            hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i(a, "destory called");
        d();
        HashMap<String, String> hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
            this.n = null;
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
            this.z = null;
        }
        synchronized (this.A) {
            if (this.A != null) {
                this.A.clear();
            }
        }
        Map<String, String> map = this.e;
        if (map != null) {
            map.clear();
            this.e = null;
        }
        this.o = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.j = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.q;
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
            switchMediaSource(i2, this.i);
            this.h = Integer.MIN_VALUE;
        }
        String str = a;
        CyberLog.i(str, "onPrepared mTargetState::" + this.k);
        if (this.k == 3 && this.j == 2) {
            start();
        } else if (this.k == 4 && this.j == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (e()) {
            this.c.pause();
            this.j = 4;
        } else if (this.c != null && !CyberCfgManager.getInstance().getCfgBoolValue("enable_pause_vv_stat_fix", false)) {
            this.c.sendCommand(1000, 0, 0L, null);
            a(20488, "preparing_paused_time", "" + System.currentTimeMillis());
        }
        this.k = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.C = false;
        this.p = true;
        this.D = false;
        this.E = 1.0f;
        this.f = -1;
        this.h = Integer.MIN_VALUE;
        this.d = null;
        this.e = null;
        this.o = null;
        this.H = null;
        this.G = null;
        if (this.j == -1 && (cyberPlayer = this.c) != null) {
            cyberPlayer.release();
            this.c = null;
        }
        this.B = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        CyberPlayer cyberPlayer2 = this.c;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        g gVar = this.y;
        if (gVar != null) {
            gVar.a();
        }
        HashMap<String, String> hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        }
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
            this.j = 0;
            this.k = 0;
        }
        HashMap<String, String> hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
        g gVar = this.y;
        if (gVar != null) {
            gVar.c();
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        }
        this.G = null;
        this.H = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.l = i;
        this.m = i2;
        g gVar = this.y;
        if (gVar != null) {
            gVar.a(i, i2, i3, i4);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.r;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        if (onSnapShotCompleteListener == null) {
            return false;
        }
        CyberLog.d(a, "takeSnapshotAsync called");
        if (this.y == null) {
            return false;
        }
        synchronized (this.A) {
            if (this.A.isEmpty()) {
                this.y.a(f, i, i2);
            }
            this.A.add(onSnapShotCompleteListener);
        }
        return true;
    }
}
