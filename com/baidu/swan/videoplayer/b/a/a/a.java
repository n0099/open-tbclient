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
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.k.h;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.p.d;
import com.baidu.swan.apps.p.f.b.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.apache.http.cookie.SM;
/* loaded from: classes3.dex */
public abstract class a implements com.baidu.swan.apps.p.f.b.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dCq = true;
    private String bOl;
    private AudioManager bbr;
    protected a.InterfaceC0373a cmQ;
    protected String cqu;
    private ZeusPluginFactory.Invoker dCs;
    private CyberPlayer dCt;
    protected Context mContext;
    protected String mCurrentUrl;
    private int dCr = -1;
    private boolean cuy = false;
    private boolean dCu = false;
    private boolean dCv = false;
    private com.baidu.swan.videoplayer.media.a.b.a dCw = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.dCw.mVideoWidth = a.this.getVideoWidth();
            a.this.dCw.mVideoHeight = a.this.getVideoHeight();
            if (a.this.cmQ != null) {
                a.this.cmQ.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.Gv();
            a.this.onStateChange(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.cmQ != null) {
                a.this.cmQ.onError(i3);
            }
            a.this.g(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.Gv();
            if (a.this.cmQ != null) {
                if (z) {
                    a.this.cmQ.onEnded();
                } else {
                    a.this.cmQ.lf(a.this.agP());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.dCw.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.dCw.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.dCw.dCQ = i2;
                    break;
            }
            a.this.onStateChange(i);
            a.this.cmQ.fQ(i);
            if (i == 904) {
                a.this.aOx();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener dCB = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener dCC = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener dCD = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.dCw.mVideoWidth = i;
            a.this.dCw.mVideoHeight = i2;
            if (a.this.cmQ != null) {
                a.this.cmQ.agO();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bbt = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    /* loaded from: classes3.dex */
    public interface InterfaceC0481a {
        void gU(boolean z);
    }

    public abstract void aOx();

    public abstract void g(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.dCs = invoker;
        if (this.dCs != null) {
            Object obj = this.dCs.get("id");
            if (obj instanceof String) {
                this.cqu = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.ahj();
        this.bOl = str;
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.ahj(), new InterfaceC0481a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0481a
            public void gU(boolean z) {
                aVar.ed(z);
            }
        });
    }

    private synchronized CyberPlayer aOv() {
        if (this.dCt == null) {
            if (com.baidu.swan.apps.t.a.ahm().Ta()) {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                }
                this.dCt = new CyberPlayer(0);
            } else {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                }
                this.dCt = new CyberPlayer(0);
            }
            this.dCt.setOnPreparedListener(this.dCx);
            this.dCt.setOnVideoSizeChangedListener(this.dCD);
            this.dCt.setOnCompletionListener(this.dCz);
            this.dCt.setOnErrorListener(this.dCy);
            this.dCt.setOnInfoListener(this.dCA);
            this.dCt.setOnBufferingUpdateListener(this.dCB);
            this.dCt.setOnSeekCompleteListener(this.dCC);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "create " + this.dCt.hashCode() + " player");
            }
        }
        return this.dCt;
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public boolean c(String str, String str2, String str3, boolean z) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.dCv = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String lb = lb(str);
        if (this.dCs != null) {
            String str4 = (String) this.dCs.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                aOv().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                aOv().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                aOv().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                aOv().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String awL = aa.awL();
        if (!TextUtils.isEmpty(awL) && aa.qB(lb)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + awL);
            }
            hashMap.put("Referer", awL);
        }
        aOv().setDataSource(this.mContext, Uri.parse(lb), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void setSurface(Surface surface) {
        aOv().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public boolean prepareAsync() {
        Gu();
        aOv().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cqu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.cqu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            gS(true);
            if (this.cmQ != null) {
                this.cmQ.lf(agP());
                return;
            }
            return;
        }
        Gu();
        aOv().start();
        gT(true);
        if (this.cmQ != null) {
            this.cmQ.le(agP());
        }
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public String agP() {
        return this.cqu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cqu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        aOv().pause();
        gT(false);
        gS(false);
        if (this.cmQ != null) {
            this.cmQ.lf(agP());
        }
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void seekTo(int i) {
        aOv().seekTo(i);
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void setSpeed(float f) {
        aOv().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cqu + " release()");
        }
        if (this.cmQ != null) {
            this.cmQ.fa(agP());
        }
        Gv();
        h.Wh().iD(agP());
        aOv().release();
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public int getDuration() {
        return aOv().getDuration();
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public int getCurrentPosition() {
        return aOv().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public boolean isPlaying() {
        return aOv().isPlaying();
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public int getVideoWidth() {
        return aOv().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public int getVideoHeight() {
        return aOv().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void ee(boolean z) {
        if (z) {
            if (this.dCs != null) {
                aOv().changeProxyDynamic((String) this.dCs.get("Proxy"), true);
                return;
            }
            return;
        }
        aOv().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    @CallSuper
    public void agQ() {
        this.dCr = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            gS(true);
        }
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void fS(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void fR(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public int agU() {
        return 0;
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    @CallSuper
    public void agR() {
        this.dCr = 1;
        if (!isPlaying() && aOw()) {
            gS(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.dCu = z;
        if (z) {
            Gv();
        } else {
            Gu();
        }
        aOv().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public void a(@NonNull a.InterfaceC0373a interfaceC0373a) {
        this.cmQ = interfaceC0373a;
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public a.InterfaceC0373a agS() {
        return this.cmQ;
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String agD() {
        return this.cqu;
    }

    @Override // com.baidu.swan.apps.p.f.b.a
    public boolean agT() {
        return this.dCv;
    }

    private boolean aOw() {
        return this.cuy;
    }

    private void gS(boolean z) {
        this.cuy = z;
    }

    private void Gu() {
        if (this.dCu) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bbr == null) {
            this.bbr = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bbr != null) {
            try {
                this.bbr.requestAudioFocus(this.bbt, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0481a interfaceC0481a) {
        if (dCq) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.aho().bf(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.dCq = false;
                    if (InterfaceC0481a.this != null) {
                        InterfaceC0481a.this.gU(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.dCq = false;
                    if (InterfaceC0481a.this != null) {
                        InterfaceC0481a.this.gU(true);
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
        if (interfaceC0481a != null) {
            interfaceC0481a.gU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv() {
        if (this.bbr == null) {
            this.bbr = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bbr != null) {
            this.bbr.abandonAudioFocus(this.bbt);
        }
    }

    private void gT(final boolean z) {
        al.p(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity arp;
                Window window;
                e arv = e.arv();
                if (arv != null && (arp = arv.arp()) != null && (window = arp.getWindow()) != null) {
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

    private static String lb(String str) {
        e arv = e.arv();
        if (!com.baidu.swan.apps.storage.b.pA(str) || arv == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, arv);
    }

    private boolean isBackground() {
        if (this.dCr == -1) {
            SwanAppActivity arp = com.baidu.swan.apps.runtime.d.arr().arp();
            if (arp == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c RV = arp.RV();
            if (RV == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!RV.afT().hasStarted()));
            }
            return !RV.afT().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.dCr == 0));
        }
        return this.dCr == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChange(int i) {
        int ki = com.baidu.swan.videoplayer.media.a.a.a.ki(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + ki + ")");
        }
        if (ki != 100) {
            if (ki == 2101 && this.cmQ != null) {
                this.cmQ.onStateChange(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.cmQ != null) {
                this.cmQ.onStateChange(ki);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aOy() {
        String jSONString = this.dCw.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.cmQ != null) {
                this.cmQ.lg(jSONString);
            }
        }
    }
}
