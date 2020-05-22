package com.baidu.swan.videoplayer.b.a.a;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.k.h;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.p.d;
import com.baidu.swan.apps.p.e.b.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.apache.http.cookie.SM;
/* loaded from: classes11.dex */
public abstract class a implements com.baidu.swan.apps.p.e.b.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean drN = true;
    private AudioManager aYA;
    private String bIH;
    protected a.InterfaceC0364a cfX;
    protected String cjA;
    private ZeusPluginFactory.Invoker drP;
    private CyberPlayer drQ;
    protected Context mContext;
    protected String mCurrentUrl;
    private int drO = -1;
    private boolean cnH = false;
    private boolean drR = false;
    private boolean drS = false;
    private com.baidu.swan.videoplayer.media.a.b.a drT = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener drU = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.drT.mVideoWidth = a.this.getVideoWidth();
            a.this.drT.mVideoHeight = a.this.getVideoHeight();
            if (a.this.cfX != null) {
                a.this.cfX.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener drV = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.FR();
            a.this.onStateChange(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.cfX != null) {
                a.this.cfX.onError(i3);
            }
            a.this.g(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener drW = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.FR();
            if (a.this.cfX != null) {
                if (z) {
                    a.this.cfX.onEnded();
                } else {
                    a.this.cfX.kA(a.this.aey());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener drX = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.drT.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.drT.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.drT.dsn = i2;
                    break;
            }
            a.this.onStateChange(i);
            a.this.cfX.ft(i);
            if (i == 904) {
                a.this.aJD();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener drY = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener drZ = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener dsa = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.drT.mVideoWidth = i;
            a.this.drT.mVideoHeight = i2;
            if (a.this.cfX != null) {
                a.this.cfX.aex();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener aYC = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (a.DEBUG) {
                Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange " + i);
            }
            if (i == -1) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.videoplayer.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0463a {
        void gu(boolean z);
    }

    public abstract void aJD();

    public abstract void g(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.drP = invoker;
        if (this.drP != null) {
            Object obj = this.drP.get("id");
            if (obj instanceof String) {
                this.cjA = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.u.a.aeR();
        this.bIH = str;
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.u.a.aeR(), new InterfaceC0463a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0463a
            public void gu(boolean z) {
                aVar.dS(z);
            }
        });
    }

    private synchronized CyberPlayer aJB() {
        if (this.drQ == null) {
            if (com.baidu.swan.apps.u.a.aeU().RE()) {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                }
                this.drQ = new CyberPlayer(0);
            } else {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                }
                this.drQ = new CyberPlayer(0);
            }
            this.drQ.setOnPreparedListener(this.drU);
            this.drQ.setOnVideoSizeChangedListener(this.dsa);
            this.drQ.setOnCompletionListener(this.drW);
            this.drQ.setOnErrorListener(this.drV);
            this.drQ.setOnInfoListener(this.drX);
            this.drQ.setOnBufferingUpdateListener(this.drY);
            this.drQ.setOnSeekCompleteListener(this.drZ);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "create " + this.drQ.hashCode() + " player");
            }
        }
        return this.drQ;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public boolean c(String str, String str2, String str3, boolean z) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.drS = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String lS = lS(str);
        if (this.drP != null) {
            String str4 = (String) this.drP.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                aJB().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                aJB().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                aJB().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                aJB().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
            }
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SM.COOKIE, str2);
        }
        if (z) {
            hashMap.put("x-hide-urls-from-log", "true");
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("User-Agent", str3);
        }
        String atD = z.atD();
        if (!TextUtils.isEmpty(atD) && z.pI(lS)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + atD);
            }
            hashMap.put("Referer", atD);
        }
        aJB().setDataSource(this.mContext, Uri.parse(lS), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void setSurface(Surface surface) {
        aJB().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public boolean prepareAsync() {
        FQ();
        aJB().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            gs(true);
            if (this.cfX != null) {
                this.cfX.kA(aey());
                return;
            }
            return;
        }
        FQ();
        aJB().start();
        gt(true);
        if (this.cfX != null) {
            this.cfX.kz(aey());
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public String aey() {
        return this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        aJB().pause();
        gt(false);
        gs(false);
        if (this.cfX != null) {
            this.cfX.kA(aey());
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void seekTo(int i) {
        aJB().seekTo(i);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void setSpeed(float f) {
        aJB().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cjA + " release()");
        }
        if (this.cfX != null) {
            this.cfX.eV(aey());
        }
        FR();
        h.Uv().il(aey());
        aJB().release();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getDuration() {
        return aJB().getDuration();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getCurrentPosition() {
        return aJB().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public boolean isPlaying() {
        return aJB().isPlaying();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getVideoWidth() {
        return aJB().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getVideoHeight() {
        return aJB().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void dT(boolean z) {
        if (z) {
            if (this.drP != null) {
                aJB().changeProxyDynamic((String) this.drP.get("Proxy"), true);
                return;
            }
            return;
        }
        aJB().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    @CallSuper
    public void aez() {
        this.drO = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            gs(true);
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void fv(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void fu(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int aeD() {
        return 0;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    @CallSuper
    public void aeA() {
        this.drO = 1;
        if (!isPlaying() && aJC()) {
            gs(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.drR = z;
        if (z) {
            FR();
        } else {
            FQ();
        }
        aJB().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void a(@NonNull a.InterfaceC0364a interfaceC0364a) {
        this.cfX = interfaceC0364a;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public a.InterfaceC0364a aeB() {
        return this.cfX;
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String aem() {
        return this.cjA;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public boolean aeC() {
        return this.drS;
    }

    private boolean aJC() {
        return this.cnH;
    }

    private void gs(boolean z) {
        this.cnH = z;
    }

    private void FQ() {
        if (this.drR) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.aYA == null) {
            this.aYA = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.aYA != null) {
            try {
                this.aYA.requestAudioFocus(this.aYC, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0463a interfaceC0463a) {
        if (drN) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.u.a.aeW().bc(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.drN = false;
                    if (InterfaceC0463a.this != null) {
                        InterfaceC0463a.this.gu(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.drN = false;
                    if (InterfaceC0463a.this != null) {
                        InterfaceC0463a.this.gu(true);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallProgress(int i, int i2) {
                }
            });
            return;
        }
        if (DEBUG) {
            Log.v("【CyberCallback】", "CyberPlayer播放内核已安装，无需重复安装");
        }
        if (interfaceC0463a != null) {
            interfaceC0463a.gu(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR() {
        if (this.aYA == null) {
            this.aYA = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.aYA != null) {
            this.aYA.abandonAudioFocus(this.aYC);
        }
    }

    private void gt(final boolean z) {
        aj.p(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aoz;
                Window window;
                e aoF = e.aoF();
                if (aoF != null && (aoz = aoF.aoz()) != null && (window = aoz.getWindow()) != null) {
                    try {
                        if (z) {
                            window.addFlags(128);
                        } else {
                            window.clearFlags(128);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            throw new RuntimeException("inline video set screenOn/Off in wrong thread", e);
                        }
                    }
                    if (a.DEBUG) {
                        Log.d("SwanInlineCyberWidget", "setKeepScreenOn: " + z);
                    }
                }
            }
        });
    }

    private static String lS(String str) {
        e aoF = e.aoF();
        if (!com.baidu.swan.apps.storage.b.oH(str) || aoF == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aoF);
    }

    private boolean isBackground() {
        if (this.drO == -1) {
            SwanAppActivity aoz = com.baidu.swan.apps.runtime.d.aoB().aoz();
            if (aoz == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c QA = aoz.QA();
            if (QA == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!QA.adB().hasStarted()));
            }
            return !QA.adB().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.drO == 0));
        }
        return this.drO == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChange(int i) {
        int jC = com.baidu.swan.videoplayer.media.a.a.a.jC(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + jC + ")");
        }
        if (jC != 100) {
            if (jC == 2101 && this.cfX != null) {
                this.cfX.onStateChange(2102);
            }
            if (this.cfX != null) {
                this.cfX.onStateChange(jC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJE() {
        String jSONString = this.drT.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.cfX != null) {
                this.cfX.kB(jSONString);
            }
        }
    }
}
