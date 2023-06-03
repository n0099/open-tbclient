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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.a;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.debug.DebugConfigManager;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public float F;
    public long G;
    public boolean H;
    public String I;
    public String J;
    public Surface K;
    public WeakReference<Surface> L;
    public i.a M;
    public Context a;
    public CyberPlayer b;
    public Uri c;
    public Map<String, String> d;
    public int e;
    public int f;
    public int g;
    public CyberPlayerManager.MediaSourceSwitchMode h;
    public int i;
    public int j;
    public int k;
    public int l;
    public HashMap<String, String> m;
    public CyberPlayerManager.HttpDNS n;
    public CyberPlayerManager.OnPreparedListener o;
    public CyberPlayerManager.OnVideoSizeChangedListener p;
    public CyberPlayerManager.OnCompletionListener q;
    public CyberPlayerManager.OnSeekCompleteListener r;
    public CyberPlayerManager.OnBufferingUpdateListener s;
    public CyberPlayerManager.OnErrorListener t;
    public CyberPlayerManager.OnInfoListener u;
    public CyberPlayerManager.OnMediaSourceChangedListener v;
    public i w;
    public final int x;
    public final int y;
    public a z;

    private int a(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            return i;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    public CyberVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void debugShowOptions(View view2) {
        CyberPlayer cyberPlayer;
        Context context = this.a;
        if (context != null && (cyberPlayer = this.b) != null) {
            DebugConfigManager.showPlayerConfigOptions(this, context, cyberPlayer);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.getMediaRuntimeInfo(onMediaRuntimeInfoListener);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.s;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
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
    public void setClarityInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
                return;
            } else {
                this.J = str;
                return;
            }
        }
        CyberLog.w("CyberVideoView", "setClarityInfo is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        this.B = i;
        if (Build.VERSION.SDK_INT < 21 && i == 2) {
            this.B = 1;
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.n = httpDNS;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        this.E = z;
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.s = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.q = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.t = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.u = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.v = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.o = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.r = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.p = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.setPlayJson(str);
                return;
            } else {
                this.I = str;
                return;
            }
        }
        CyberLog.w("CyberVideoView", "setPlayJson is null");
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.C = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        CyberLog.i("CyberVideoView", "setSpeed()");
        this.F = f;
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
        i iVar = this.w;
        if (iVar != null) {
            iVar.setClientRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.setDisplayMode(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setZOrderMediaOverlay(boolean z) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.setZOrderMediaOverlay(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode;
        if (h()) {
            this.b.switchMediaSource(i);
            return;
        }
        this.g = i;
        if (i == -1) {
            mediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE;
        } else {
            mediaSourceSwitchMode = CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_FORCE_MODE;
        }
        this.h = mediaSourceSwitchMode;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0);
    }

    public CyberVideoView(Context context, int i) {
        this(context, null, i);
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
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.z.a(str, obj);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        setVideoURI(uri, map, null);
    }

    public void setVolume(float f, float f2) {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.setVolume(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        if (h()) {
            this.b.switchMediaSource(i, mediaSourceSwitchMode);
            return;
        }
        this.g = i;
        this.h = mediaSourceSwitchMode;
    }

    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 3;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new HashMap<>();
        this.B = 0;
        this.C = true;
        this.F = 1.0f;
        this.G = 0L;
        this.H = false;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void b(int i) {
                CyberLog.d("CyberVideoView", "onSurfaceDestroyed renderType:" + i);
                if ((i == 2 || i == 3) && CyberVideoView.this.b != null) {
                    CyberVideoView.this.b.setSurface(null);
                }
            }

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
                            Bitmap a = q.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.A) {
                                for (int i3 = 0; i3 < CyberVideoView.this.A.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.A.get(i3)).onSnapShotComplete(a);
                                }
                                CyberVideoView.this.A.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final long j) {
                if (!CyberCfgManager.getInstance().a("judge_thread_on_first_frame", false) || Looper.getMainLooper().getThread() != Thread.currentThread()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CyberVideoView.this.a(j);
                        }
                    });
                } else {
                    CyberVideoView.this.a(j);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i) {
                Surface d;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i);
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.b != null && CyberVideoView.this.w != null && (d = CyberVideoView.this.w.d()) != null) {
                            CyberVideoView.this.b.setSurface(d);
                        }
                        return true;
                    }
                    return false;
                } else if (i == 1) {
                    if (CyberVideoView.this.b != null && CyberVideoView.this.w != null) {
                        Surface d2 = CyberVideoView.this.w.d();
                        CyberVideoView.this.K = d2;
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (CyberVideoView.this.L != null && CyberVideoView.this.L.get() != null) {
                            CyberLog.d("CyberVideoView", "use external surface, do nothing!!!");
                            return false;
                        } else if (d2 != null) {
                            CyberVideoView.this.b.setSurface(d2);
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return false;
                } else if ((i == 2 || i == 3) && CyberVideoView.this.b != null && CyberVideoView.this.w != null) {
                    Surface d3 = CyberVideoView.this.w.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d3);
                    if (d3 != null) {
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.b);
                        CyberVideoView.this.b.setSurface(d3);
                        return false;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        };
        this.y = 0;
        this.x = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.x);
        this.a = context.getApplicationContext();
        this.z = new a();
        this.A = new ArrayList<>();
        reset();
        a();
    }

    public CyberVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f = 3;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new HashMap<>();
        this.B = 0;
        this.C = true;
        this.F = 1.0f;
        this.G = 0L;
        this.H = false;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = new i.a() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            @Override // com.baidu.cyberplayer.sdk.i.a
            public void b(int i2) {
                CyberLog.d("CyberVideoView", "onSurfaceDestroyed renderType:" + i2);
                if ((i2 == 2 || i2 == 3) && CyberVideoView.this.b != null) {
                    CyberVideoView.this.b.setSurface(null);
                }
            }

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
                            Bitmap a = q.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (CyberVideoView.this.A) {
                                for (int i3 = 0; i3 < CyberVideoView.this.A.size(); i3++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) CyberVideoView.this.A.get(i3)).onSnapShotComplete(a);
                                }
                                CyberVideoView.this.A.clear();
                            }
                        }
                    }
                });
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(final long j) {
                if (!CyberCfgManager.getInstance().a("judge_thread_on_first_frame", false) || Looper.getMainLooper().getThread() != Thread.currentThread()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CyberVideoView.this.a(j);
                        }
                    });
                } else {
                    CyberVideoView.this.a(j);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i2) {
                Surface d;
                CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i2);
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 16) {
                        if (CyberVideoView.this.b != null && CyberVideoView.this.w != null && (d = CyberVideoView.this.w.d()) != null) {
                            CyberVideoView.this.b.setSurface(d);
                        }
                        return true;
                    }
                    return false;
                } else if (i2 == 1) {
                    if (CyberVideoView.this.b != null && CyberVideoView.this.w != null) {
                        Surface d2 = CyberVideoView.this.w.d();
                        CyberVideoView.this.K = d2;
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (CyberVideoView.this.L != null && CyberVideoView.this.L.get() != null) {
                            CyberLog.d("CyberVideoView", "use external surface, do nothing!!!");
                            return false;
                        } else if (d2 != null) {
                            CyberVideoView.this.b.setSurface(d2);
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return false;
                } else if ((i2 == 2 || i2 == 3) && CyberVideoView.this.b != null && CyberVideoView.this.w != null) {
                    Surface d3 = CyberVideoView.this.w.d();
                    CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d3);
                    if (d3 != null) {
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + CyberVideoView.this.b);
                        CyberVideoView.this.b.setSurface(d3);
                        return false;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        };
        this.y = 65280 & i;
        this.x = a((-65281) & i);
        this.a = context.getApplicationContext();
        this.z = new a();
        this.A = new ArrayList<>();
        reset();
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        CyberPlayer cyberPlayer;
        if (i == 10001 && (cyberPlayer = this.b) != null && cyberPlayer.getDecodeMode() != 4) {
            i iVar = this.w;
            if (iVar != null) {
                iVar.setRawFrameRotation(i2);
            }
        } else if (i == 11011) {
            CyberLog.d("CyberVideoView", "MEDIA_INFO_HDR_VIDEO CyberVideoView mRenderType:" + this.x + " HDR:" + i2);
            return b(i2);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.u;
        if (onInfoListener != null && onInfoListener.onInfo(i, i2, obj)) {
            return true;
        }
        return false;
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
        int i = this.x;
        if (i == 0) {
            if (this.y > 0 && CyberCfgManager.getInstance().a("videoview_ebable_filter", true)) {
                this.w = new d(this.a, this.y);
            } else {
                this.w = new d(this.a);
            }
        } else if (i == 1) {
            this.w = new k(this.a);
            if (Build.VERSION.SDK_INT < 21) {
                setDecodeMode(1);
            }
        } else if (i != 2 && i != 3) {
            if (i == 4) {
                if (this.y > 0 && CyberCfgManager.getInstance().a("videoview_ebable_filter", true)) {
                    this.w = new b(this.a, this.y);
                } else {
                    this.w = new b(this.a);
                }
            }
        } else {
            this.w = new j(this.a);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.w.setCyberSurfaceListener(this.M);
        this.w.getView().setLayoutParams(layoutParams);
        addView(this.w.getView());
        CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.w);
    }

    private void a(int i, String str, String str2) {
        if (this.b == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "" + i);
        hashMap.put(str, str2);
        this.b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.v;
        if (onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        CyberPlayer cyberPlayer;
        if (Build.VERSION.SDK_INT <= 16 && (cyberPlayer = this.b) != null && cyberPlayer.getDecodeMode() == 4) {
            this.b.sendCommand(1002, 0, j, null);
        }
        if (this.b != null) {
            long j2 = this.G;
            if (j2 > 0) {
                long j3 = j - j2;
                a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, "surface_drawed", "" + j3);
            }
        }
        if (this.y > 0) {
            a(20488, "filter", "" + this.y);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        String str2;
        if (this.b == null || !TextUtils.isEmpty(q.c())) {
            return;
        }
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            str2 = hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY);
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(str2)) {
                return;
            }
            this.b.changeProxyDynamic(str, true);
        } else if (TextUtils.isEmpty(str2)) {
            return;
        } else {
            this.b.changeProxyDynamic(null, false);
        }
        this.b.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
        HashMap<String, String> hashMap2 = this.m;
        if (hashMap2 != null) {
            hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
        }
    }

    private boolean a(CyberPlayer cyberPlayer) {
        if (cyberPlayer != null) {
            int decodeMode = cyberPlayer.getDecodeMode();
            if (decodeMode == 4) {
                CyberLog.i("CyberVideoView", "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!");
                return true;
            } else if (decodeMode == 1) {
                CyberLog.i("CyberVideoView", "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SW!");
                return true;
            } else if (this.C && !cyberPlayer.isRemotePlayer()) {
                CyberLog.i("CyberVideoView", "handlerLastPlay isPlayerNeedRelease mainprocess !");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void b() {
        if (this.c == null) {
            return;
        }
        this.G = System.currentTimeMillis();
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_OPEN_VIDEO);
        PlayerConfigManager.startRequestPlayerServerCfg();
        d();
        try {
            if (this.b == null) {
                this.b = new CyberPlayer(this.B, this.n, this.C);
            }
            this.b.setOnPreparedListener(this);
            this.b.setOnCompletionListener(this);
            this.b.setOnVideoSizeChangedListener(this);
            this.b.setOnSeekCompleteListener(this);
            this.b.setOnBufferingUpdateListener(this);
            this.b.setOnErrorListener(this);
            this.b.setOnInfoListener(this);
            this.b.setOnMediaSourceChangedListener(this);
            if (this.I != null) {
                this.b.setPlayJson(this.I);
            }
            if (this.J != null) {
                this.b.setClarityInfo(this.J);
            }
            if (this.m != null) {
                for (String str : this.m.keySet()) {
                    this.b.setOption(str, this.m.get(str));
                }
            }
            CyberPlayer cyberPlayer = this.b;
            cyberPlayer.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.G);
            if (this.H) {
                this.b.setOption("mediacodec-config-need-retry", 1L);
            }
            if (this.x == 2 || this.x == 3) {
                this.b.setOption("mediacodec-surface-update", 1L);
                this.b.setOption("mediacodec-auto-rotate", 1L);
            }
            this.b.setDataSource(this.a, this.c, this.d);
            this.b.prepareAsync();
            this.i = 1;
            if (this.w != null) {
                Surface d = this.w.d();
                this.K = d;
                CyberLog.d("CyberVideoView", "openVideo s:" + d + " mCyberPlayer:" + this.b);
                if (this.L != null && this.L.get() != null) {
                    CyberLog.d("CyberVideoView", "ExternalSurface:" + this.L.get() + " isValid:" + this.L.get().isValid());
                    this.b.setSurface(this.L.get());
                } else if (d != null) {
                    this.b.setSurface(d);
                }
            }
            this.b.setScreenOnWhilePlaying(true);
            if (this.D) {
                this.b.muteOrUnmuteAudio(this.D);
            }
            if (this.F != 1.0f) {
                this.b.setSpeed(this.F);
            }
            if (this.E) {
                this.b.setLooping(this.E);
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

    private boolean b(int i) {
        int i2 = 0;
        if (this.u == null) {
            return false;
        }
        boolean z = true;
        if (i > 0) {
            int i3 = this.x;
            if (i3 != 2 && i3 != 3) {
                i2 = 11016;
            } else if (CyberPlayerManager.getDeviceHDRSupported(i, this.k, this.l) <= 0) {
                i2 = 11014;
            }
            z = this.u.onInfo(11011, i, 0);
        } else {
            int i4 = this.x;
            if (i4 == 2 || i4 == 3) {
                i2 = 11013;
            }
        }
        if (i2 != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20488");
            hashMap.put("hdr_warnning_msg", "" + i2);
            this.b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.u.onInfo(i2, i, 0);
        }
        return z;
    }

    private void c() {
        ArrayList<a.C0090a> b;
        if (this.b != null && (b = this.z.b()) != null) {
            int size = b.size();
            for (int i = 0; i < size; i++) {
                a.C0090a c0090a = b.get(i);
                if (c0090a != null && c0090a.a() != null) {
                    this.b.setExternalInfo(c0090a.a(), c0090a.b());
                }
            }
        }
    }

    private void d() {
        this.H = false;
        if (this.b != null) {
            if (this.x == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.b)) {
                e();
                CyberLog.i("CyberVideoView", "handlerLastPlay called reset last player");
            } else {
                f();
                CyberLog.i("CyberVideoView", "handlerLastPlay called release last player");
                if (this.x == 1) {
                    this.H = true;
                }
            }
        }
        g();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.b + " mCurrentState:" + this.i);
        if (h()) {
            this.b.start();
            this.i = 3;
        } else {
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.sendCommand(1000, 1, 0L, null);
            }
        }
        this.j = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.stop();
            this.b.release();
            this.b = null;
            this.i = 0;
            this.j = 0;
        }
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.c();
            this.w.a();
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        }
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
    }

    private void e() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            if (this.i != -1) {
                cyberPlayer.reset();
            } else {
                cyberPlayer.release();
                this.b = null;
            }
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
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
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
        }
    }

    private void g() {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a();
        }
    }

    private boolean h() {
        int i;
        if (this.b != null && (i = this.i) != -1 && i != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private boolean i() {
        int i;
        if (this.b != null && (i = this.i) != 0 && i != 1) {
            return true;
        }
        return false;
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

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDecodeMode() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            return cyberPlayer.getDecodeMode();
        }
        return this.B;
    }

    public long getDownloadSpeed() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null && this.i != 0) {
            return cyberPlayer.getDownloadSpeed();
        }
        return -1L;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (i()) {
            return this.b.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public MediaInfo getMediaInfo() {
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer == null) {
            return null;
        }
        return cyberPlayer.getMediaInfo();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (i()) {
            return this.b.getPlayedTime();
        }
        return -1L;
    }

    public i getRenderView() {
        return this.w;
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
    public boolean isPlaying() {
        if (h() && this.i == 3) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        this.i = 5;
        this.j = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.q;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.r;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stepToNextFrame() {
        if (this.b != null) {
            if (this.i == 3) {
                pause();
            }
            this.b.stepToNextFrame();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        CyberLog.i("CyberVideoView", "destory called");
        f();
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
            this.m = null;
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
        Map<String, String> map = this.d;
        if (map != null) {
            map.clear();
            this.d = null;
        }
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.w != null) {
            removeAllViews();
            this.w.b();
            this.w = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.i = 2;
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.o;
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
            switchMediaSource(i2, this.h);
            this.g = Integer.MIN_VALUE;
        }
        CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.j);
        if (this.j == 3 && this.i == 2) {
            start();
        } else if (this.j == 4 && this.i == 2) {
            pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        if (h()) {
            this.b.pause();
            this.i = 4;
        } else if (this.b != null && !CyberCfgManager.getInstance().getCfgBoolValue("enable_pause_vv_stat_fix", false)) {
            this.b.sendCommand(1000, 0, 0L, null);
            a(20488, "preparing_paused_time", "" + System.currentTimeMillis());
        }
        this.j = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        this.D = false;
        this.C = true;
        this.E = false;
        this.F = 1.0f;
        this.e = -1;
        this.g = Integer.MIN_VALUE;
        this.c = null;
        this.d = null;
        this.n = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.B = 0;
        if (this.i == -1 && (cyberPlayer = this.b) != null) {
            cyberPlayer.release();
            this.b = null;
        }
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        CyberPlayer cyberPlayer2 = this.b;
        if (cyberPlayer2 != null) {
            cyberPlayer2.reset();
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.c();
        }
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.D = z;
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
        if (this.b != null) {
            CyberLog.y("CyberVideoView", this.b + ", muteOrUnmuteAudio flag:" + z);
            this.b.muteOrUnmuteAudio(z);
            return;
        }
        CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        CyberLog.e("CyberVideoView", "onError: (" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + SmallTailInfo.EMOTION_SUFFIX);
        this.i = -1;
        this.j = -1;
        CyberPlayerManager.OnErrorListener onErrorListener = this.t;
        if (onErrorListener != null) {
            return onErrorListener.onError(i, i2, obj);
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map, Map<String, String> map2) {
        Uri uri2 = this.c;
        if (uri2 != null && uri != null && uri2.equals(uri) && CyberCfgManager.getInstance().getCfgBoolValue("enable_same_uri_check", false)) {
            CyberLog.i("CyberVideoView", "set same videoURI");
            return;
        }
        if (map2 != null) {
            this.m.putAll(map2);
        }
        this.c = uri;
        this.d = map;
        this.e = -1;
        b();
        requestLayout();
        invalidate();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.k = i;
        this.l = i2;
        CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i3 + " den:" + i4 + " width:" + i + " height:" + i2);
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(this.k, this.l, i3, i4);
        }
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.p;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        if (onSnapShotCompleteListener == null) {
            return false;
        }
        CyberLog.d("CyberVideoView", "takeSnapshotAsync called");
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        if (iVar.e()) {
            synchronized (this.A) {
                if (this.A.isEmpty()) {
                    this.w.a(f, i, i2);
                }
                this.A.add(onSnapShotCompleteListener);
            }
            return true;
        }
        Bitmap a = this.w.a(f, i, i2);
        if (onSnapShotCompleteListener != null) {
            onSnapShotCompleteListener.onSnapShotComplete(a);
            return true;
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalSurface(Surface surface) {
        CyberLog.d("CyberVideoView", "setExternalSurface: " + surface + " mCurrentState:" + this.i);
        if (this.x != 1) {
            CyberLog.w("CyberVideoView", "ExternalSurface not support RenderType: " + this.x);
            return;
        }
        try {
            if (this.L == null) {
                this.L = new WeakReference<>(null);
            }
            if (this.L.get() != surface) {
                WeakReference<Surface> weakReference = new WeakReference<>(surface);
                this.L = weakReference;
                if (this.b == null) {
                    return;
                }
                if (weakReference.get() != null) {
                    CyberLog.d("CyberVideoView", "setExternalSurface use external surface: " + this.L.get() + " isValid:" + this.L.get().isValid());
                    this.b.setSurface(null);
                    q.a(this.L.get());
                    this.b.setSurface(this.L.get());
                } else if (this.K != null) {
                    CyberLog.d("CyberVideoView", "setExternalSurface use videoview surface: " + this.K + " isValid:" + this.K.isValid());
                    this.b.setSurface(null);
                    q.a(this.K);
                    this.b.setSurface(this.K);
                } else {
                    CyberLog.d("CyberVideoView", "setExternalSurface no valid surface");
                    this.b.setSurface(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean setFilterRegion(float f, float f2, float f3, float f4) {
        int i;
        i iVar = this.w;
        if (iVar != null && (i = this.y) > 0) {
            return iVar.a(i, f, f2, f3, f4);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        CyberPlayer cyberPlayer;
        if (this.i == 0) {
            HashMap<String, String> hashMap = this.m;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.b != null) {
                if (str != null && str.equals(CyberPlayerManager.OPT_HTTP_PROXY) && !TextUtils.isEmpty(q.c())) {
                    return;
                }
                this.b.setOption(str, str2);
                return;
            }
            return;
        }
        CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
        if (str != null) {
            if ((str.equals(CyberPlayerManager.OPT_BUFFER_CONFIG_JSON) || str.equals(CyberPlayerManager.OPT_FILECACHE_RESERVE_URL)) && h() && (cyberPlayer = this.b) != null) {
                cyberPlayer.setOption(str, str2);
            }
        }
    }
}
