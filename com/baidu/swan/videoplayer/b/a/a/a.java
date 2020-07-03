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
    private static boolean dwy = true;
    private String bNv;
    private AudioManager bbt;
    protected a.InterfaceC0370a ckL;
    protected String cop;
    private ZeusPluginFactory.Invoker dwA;
    private CyberPlayer dwB;
    protected Context mContext;
    protected String mCurrentUrl;
    private int dwz = -1;
    private boolean csu = false;
    private boolean dwC = false;
    private boolean dwD = false;
    private com.baidu.swan.videoplayer.media.a.b.a dwE = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener dwF = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.dwE.mVideoWidth = a.this.getVideoWidth();
            a.this.dwE.mVideoHeight = a.this.getVideoHeight();
            if (a.this.ckL != null) {
                a.this.ckL.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener dwG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.GA();
            a.this.onStateChange(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.ckL != null) {
                a.this.ckL.onError(i3);
            }
            a.this.g(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener dwH = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.GA();
            if (a.this.ckL != null) {
                if (z) {
                    a.this.ckL.onEnded();
                } else {
                    a.this.ckL.kI(a.this.afE());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener dwI = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.dwE.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.dwE.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.dwE.dwY = i2;
                    break;
            }
            a.this.onStateChange(i);
            a.this.ckL.fG(i);
            if (i == 904) {
                a.this.aKJ();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener dwJ = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener dwK = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener dwL = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.dwE.mVideoWidth = i;
            a.this.dwE.mVideoHeight = i2;
            if (a.this.ckL != null) {
                a.this.ckL.afD();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bbv = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    public interface InterfaceC0469a {
        void gz(boolean z);
    }

    public abstract void aKJ();

    public abstract void g(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.dwA = invoker;
        if (this.dwA != null) {
            Object obj = this.dwA.get("id");
            if (obj instanceof String) {
                this.cop = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.u.a.afX();
        this.bNv = str;
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.u.a.afX(), new InterfaceC0469a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0469a
            public void gz(boolean z) {
                aVar.dX(z);
            }
        });
    }

    private synchronized CyberPlayer aKH() {
        if (this.dwB == null) {
            if (com.baidu.swan.apps.u.a.aga().SK()) {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                }
                this.dwB = new CyberPlayer(0);
            } else {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                }
                this.dwB = new CyberPlayer(0);
            }
            this.dwB.setOnPreparedListener(this.dwF);
            this.dwB.setOnVideoSizeChangedListener(this.dwL);
            this.dwB.setOnCompletionListener(this.dwH);
            this.dwB.setOnErrorListener(this.dwG);
            this.dwB.setOnInfoListener(this.dwI);
            this.dwB.setOnBufferingUpdateListener(this.dwJ);
            this.dwB.setOnSeekCompleteListener(this.dwK);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "create " + this.dwB.hashCode() + " player");
            }
        }
        return this.dwB;
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
        this.dwD = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String ma = ma(str);
        if (this.dwA != null) {
            String str4 = (String) this.dwA.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                aKH().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                aKH().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                aKH().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                aKH().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String auJ = z.auJ();
        if (!TextUtils.isEmpty(auJ) && z.pQ(ma)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + auJ);
            }
            hashMap.put("Referer", auJ);
        }
        aKH().setDataSource(this.mContext, Uri.parse(ma), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void setSurface(Surface surface) {
        aKH().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public boolean prepareAsync() {
        Gz();
        aKH().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cop + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.cop + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            gx(true);
            if (this.ckL != null) {
                this.ckL.kI(afE());
                return;
            }
            return;
        }
        Gz();
        aKH().start();
        gy(true);
        if (this.ckL != null) {
            this.ckL.kH(afE());
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public String afE() {
        return this.cop + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cop + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        aKH().pause();
        gy(false);
        gx(false);
        if (this.ckL != null) {
            this.ckL.kI(afE());
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void seekTo(int i) {
        aKH().seekTo(i);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void setSpeed(float f) {
        aKH().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cop + " release()");
        }
        if (this.ckL != null) {
            this.ckL.fb(afE());
        }
        GA();
        h.VB().it(afE());
        aKH().release();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getDuration() {
        return aKH().getDuration();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getCurrentPosition() {
        return aKH().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public boolean isPlaying() {
        return aKH().isPlaying();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getVideoWidth() {
        return aKH().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int getVideoHeight() {
        return aKH().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void dY(boolean z) {
        if (z) {
            if (this.dwA != null) {
                aKH().changeProxyDynamic((String) this.dwA.get("Proxy"), true);
                return;
            }
            return;
        }
        aKH().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    @CallSuper
    public void afF() {
        this.dwz = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            gx(true);
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void fI(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void fH(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public int afJ() {
        return 0;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    @CallSuper
    public void afG() {
        this.dwz = 1;
        if (!isPlaying() && aKI()) {
            gx(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.dwC = z;
        if (z) {
            GA();
        } else {
            Gz();
        }
        aKH().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public void a(@NonNull a.InterfaceC0370a interfaceC0370a) {
        this.ckL = interfaceC0370a;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public a.InterfaceC0370a afH() {
        return this.ckL;
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String afs() {
        return this.cop;
    }

    @Override // com.baidu.swan.apps.p.e.b.a
    public boolean afI() {
        return this.dwD;
    }

    private boolean aKI() {
        return this.csu;
    }

    private void gx(boolean z) {
        this.csu = z;
    }

    private void Gz() {
        if (this.dwC) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bbt == null) {
            this.bbt = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bbt != null) {
            try {
                this.bbt.requestAudioFocus(this.bbv, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0469a interfaceC0469a) {
        if (dwy) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.u.a.agc().bd(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.dwy = false;
                    if (InterfaceC0469a.this != null) {
                        InterfaceC0469a.this.gz(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.dwy = false;
                    if (InterfaceC0469a.this != null) {
                        InterfaceC0469a.this.gz(true);
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
        if (interfaceC0469a != null) {
            interfaceC0469a.gz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GA() {
        if (this.bbt == null) {
            this.bbt = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bbt != null) {
            this.bbt.abandonAudioFocus(this.bbv);
        }
    }

    private void gy(final boolean z) {
        aj.p(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity apG;
                Window window;
                e apM = e.apM();
                if (apM != null && (apG = apM.apG()) != null && (window = apG.getWindow()) != null) {
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

    private static String ma(String str) {
        e apM = e.apM();
        if (!com.baidu.swan.apps.storage.b.oP(str) || apM == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, apM);
    }

    private boolean isBackground() {
        if (this.dwz == -1) {
            SwanAppActivity apG = com.baidu.swan.apps.runtime.d.apI().apG();
            if (apG == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c RG = apG.RG();
            if (RG == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!RG.aeH().hasStarted()));
            }
            return !RG.aeH().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.dwz == 0));
        }
        return this.dwz == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChange(int i) {
        int jP = com.baidu.swan.videoplayer.media.a.a.a.jP(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + jP + ")");
        }
        if (jP != 100) {
            if (jP == 2101 && this.ckL != null) {
                this.ckL.onStateChange(2102);
            }
            if (this.ckL != null) {
                this.ckL.onStateChange(jP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aKK() {
        String jSONString = this.dwE.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.ckL != null) {
                this.ckL.kJ(jSONString);
            }
        }
    }
}
