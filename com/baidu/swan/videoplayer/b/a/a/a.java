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
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.module.k.j;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.swan.apps.inlinewidget.f.c.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.apache.http.cookie.SM;
/* loaded from: classes9.dex */
public abstract class a implements com.baidu.swan.apps.inlinewidget.f.c.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dLB = true;
    private String bTJ;
    private AudioManager bgN;
    protected a.InterfaceC0409a cuh;
    protected String cyk;
    private ZeusPluginFactory.Invoker dLD;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int dLC = -1;
    private boolean cCi = false;
    private boolean dLE = false;
    private boolean dLF = false;
    private com.baidu.swan.videoplayer.media.a.b.a dLG = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.dLG.mVideoWidth = a.this.getVideoWidth();
            a.this.dLG.mVideoHeight = a.this.getVideoHeight();
            if (a.this.cuh != null) {
                a.this.cuh.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.onStateChange(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.cuh != null) {
                a.this.cuh.onError(i3);
            }
            a.this.f(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.cuh != null) {
                if (z) {
                    a.this.cuh.onEnded();
                } else {
                    a.this.cuh.mX(a.this.aop());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener dLK = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.dLG.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.dLG.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.dLG.dMa = i2;
                    break;
            }
            a.this.onStateChange(i);
            a.this.cuh.hU(i);
            if (i == 904) {
                a.this.aWV();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener dLL = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener dLM = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener dLN = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.dLG.mVideoWidth = i;
            a.this.dLG.mVideoHeight = i2;
            if (a.this.cuh != null) {
                a.this.cuh.aog();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bgQ = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    /* loaded from: classes9.dex */
    public interface InterfaceC0527a {
        void ho(boolean z);
    }

    public abstract void aWV();

    public abstract void f(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.dLD = invoker;
        if (this.dLD != null) {
            Object obj = this.dLD.get("id");
            if (obj instanceof String) {
                this.cyk = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.aoJ();
        this.bTJ = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.aoJ(), new InterfaceC0527a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0527a
            public void ho(boolean z) {
                aVar.eq(z);
            }
        });
    }

    private synchronized CyberPlayer aWT() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.aoM().YU()) {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                }
                this.mPlayer = new CyberPlayer(0);
            } else {
                if (DEBUG) {
                    Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                }
                this.mPlayer = new CyberPlayer(0);
            }
            this.mPlayer.setOnPreparedListener(this.dLH);
            this.mPlayer.setOnVideoSizeChangedListener(this.dLN);
            this.mPlayer.setOnCompletionListener(this.dLJ);
            this.mPlayer.setOnErrorListener(this.dLI);
            this.mPlayer.setOnInfoListener(this.dLK);
            this.mPlayer.setOnBufferingUpdateListener(this.dLL);
            this.mPlayer.setOnSeekCompleteListener(this.dLM);
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "create " + this.mPlayer.hashCode() + " player");
            }
        }
        return this.mPlayer;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean c(String str, String str2, String str3, boolean z) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.dLF = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String mT = mT(str);
        if (this.dLD != null) {
            String str4 = (String) this.dLD.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                aWT().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                aWT().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                aWT().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                aWT().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aEV = ab.aEV();
        if (!TextUtils.isEmpty(aEV) && ab.sC(mT)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aEV);
            }
            hashMap.put("Referer", aEV);
        }
        aWT().setDataSource(this.mContext, Uri.parse(mT), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        aWT().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        aWT().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cyk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.cyk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            hm(true);
            if (this.cuh != null) {
                this.cuh.mX(aop());
                return;
            }
            return;
        }
        requestAudioFocus();
        aWT().start();
        hn(true);
        if (this.cuh != null) {
            this.cuh.mW(aop());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String aop() {
        return this.cyk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cyk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        aWT().pause();
        hn(false);
        hm(false);
        if (this.cuh != null) {
            this.cuh.mX(aop());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        aWT().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        aWT().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cyk + " release()");
        }
        if (this.cuh != null) {
            this.cuh.gv(aop());
        }
        abandonAudioFocus();
        j.aco().kc(aop());
        aWT().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return aWT().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return aWT().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return aWT().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return aWT().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return aWT().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void ex(boolean z) {
        if (z) {
            if (this.dLD != null) {
                aWT().changeProxyDynamic((String) this.dLD.get("Proxy"), true);
                return;
            }
            return;
        }
        aWT().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void aoq() {
        this.dLC = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            hm(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hW(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hV(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int aou() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void aor() {
        this.dLC = 1;
        if (!isPlaying() && aWU()) {
            hm(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.dLE = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        aWT().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0409a interfaceC0409a) {
        this.cuh = interfaceC0409a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0409a aos() {
        return this.cuh;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String anL() {
        return this.cyk;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.bTJ;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean aot() {
        return this.dLF;
    }

    private boolean aWU() {
        return this.cCi;
    }

    private void hm(boolean z) {
        this.cCi = z;
    }

    private void requestAudioFocus() {
        if (this.dLE) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bgN == null) {
            this.bgN = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bgN != null) {
            try {
                this.bgN.requestAudioFocus(this.bgQ, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0527a interfaceC0527a) {
        if (dLB) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.aoO().bl(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.dLB = false;
                    if (InterfaceC0527a.this != null) {
                        InterfaceC0527a.this.ho(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.dLB = false;
                    if (InterfaceC0527a.this != null) {
                        InterfaceC0527a.this.ho(true);
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
        if (interfaceC0527a != null) {
            interfaceC0527a.ho(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.bgN == null) {
            this.bgN = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bgN != null) {
            this.bgN.abandonAudioFocus(this.bgQ);
        }
    }

    private void hn(final boolean z) {
        ak.m(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity azC;
                Window window;
                e azI = e.azI();
                if (azI != null && (azC = azI.azC()) != null && (window = azC.getWindow()) != null) {
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

    private static String mT(String str) {
        e azI = e.azI();
        if (!com.baidu.swan.apps.storage.b.rA(str) || azI == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, azI);
    }

    private boolean isBackground() {
        if (this.dLC == -1) {
            SwanAppActivity azC = com.baidu.swan.apps.runtime.d.azE().azC();
            if (azC == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c XQ = azC.XQ();
            if (XQ == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!XQ.ana().hasStarted()));
            }
            return !XQ.ana().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.dLC == 0));
        }
        return this.dLC == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChange(int i) {
        int mo = com.baidu.swan.videoplayer.media.a.a.a.mo(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + mo + ")");
        }
        if (mo != 100) {
            if (mo == 2101 && this.cuh != null) {
                this.cuh.onStateChange(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.cuh != null) {
                this.cuh.onStateChange(mo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aWW() {
        String jSONString = this.dLG.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.cuh != null) {
                this.cuh.mY(jSONString);
            }
        }
    }
}
