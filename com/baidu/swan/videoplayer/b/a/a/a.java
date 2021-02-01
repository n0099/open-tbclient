package com.baidu.swan.videoplayer.b.a.a;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.api.module.k.j;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.swan.apps.inlinewidget.f.c.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.apache.http.cookie.SM;
/* loaded from: classes15.dex */
public abstract class a implements com.baidu.swan.apps.inlinewidget.f.c.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean eAu = true;
    private AudioManager bxC;
    private String cEi;
    protected a.InterfaceC0429a deo;
    protected String diq;
    private ZeusPluginFactory.Invoker eAw;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int eAv = -1;
    private boolean dmu = false;
    private boolean eAx = false;
    private boolean eAy = false;
    private com.baidu.swan.videoplayer.media.a.b.a eAz = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.eAz.mVideoWidth = a.this.getVideoWidth();
            a.this.eAz.mVideoHeight = a.this.getVideoHeight();
            if (a.this.deo != null) {
                a.this.deo.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.hI(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.deo != null) {
                a.this.deo.onError(i3);
            }
            a.this.h(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.deo != null) {
                if (z) {
                    a.this.deo.onEnded();
                } else {
                    a.this.deo.om(a.this.awC());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.eAz.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.eAz.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.eAz.eAT = i2;
                    break;
            }
            a.this.hI(i);
            a.this.deo.hH(i);
            if (i == 904) {
                a.this.bfW();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener eAE = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener eAG = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.eAz.mVideoWidth = i;
            a.this.eAz.mVideoHeight = i2;
            if (a.this.deo != null) {
                a.this.deo.awt();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bxG = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    /* loaded from: classes15.dex */
    public interface InterfaceC0546a {
        void iP(boolean z);
    }

    public abstract void bfW();

    public abstract void h(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.eAw = invoker;
        if (this.eAw != null) {
            Object obj = this.eAw.get("id");
            if (obj instanceof String) {
                this.diq = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.awW();
        this.cEi = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.awW(), new InterfaceC0546a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0546a
            public void iP(boolean z) {
                aVar.fG(z);
            }
        });
    }

    private synchronized CyberPlayer bfU() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.awZ().agW()) {
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
            this.mPlayer.setOnPreparedListener(this.eAA);
            this.mPlayer.setOnVideoSizeChangedListener(this.eAG);
            this.mPlayer.setOnCompletionListener(this.eAC);
            this.mPlayer.setOnErrorListener(this.eAB);
            this.mPlayer.setOnInfoListener(this.eAD);
            this.mPlayer.setOnBufferingUpdateListener(this.eAE);
            this.mPlayer.setOnSeekCompleteListener(this.eAF);
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
    public boolean e(String str, String str2, String str3, boolean z) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
        }
        this.eAy = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String oi = oi(str);
        if (this.eAw != null) {
            String str4 = (String) this.eAw.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                bfU().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                bfU().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                bfU().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                bfU().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aNY = ab.aNY();
        if (!TextUtils.isEmpty(aNY) && ab.tY(oi)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aNY);
            }
            hashMap.put("Referer", aNY);
        }
        bfU().setDataSource(this.mContext, Uri.parse(oi), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        bfU().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        bfU().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            iO(true);
            if (this.deo != null) {
                this.deo.om(awC());
                return;
            }
            return;
        }
        requestAudioFocus();
        bfU().start();
        setKeepScreenOn(true);
        if (this.deo != null) {
            this.deo.ol(awC());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String awC() {
        return this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        bfU().pause();
        setKeepScreenOn(false);
        iO(false);
        if (this.deo != null) {
            this.deo.om(awC());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        bfU().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        bfU().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.diq + " release()");
        }
        if (this.deo != null) {
            this.deo.gy(awC());
        }
        abandonAudioFocus();
        j.aks().lr(awC());
        bfU().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return bfU().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return bfU().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return bfU().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return bfU().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return bfU().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void fN(boolean z) {
        if (z) {
            if (this.eAw != null) {
                bfU().changeProxyDynamic((String) this.eAw.get("Proxy"), true);
                return;
            }
            return;
        }
        bfU().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awD() {
        this.eAv = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            iO(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hK(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hJ(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int awH() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awE() {
        this.eAv = 1;
        if (!isPlaying() && bfV()) {
            iO(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.eAx = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        bfU().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void o(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0429a interfaceC0429a) {
        this.deo = interfaceC0429a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0429a awF() {
        return this.deo;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avY() {
        return this.diq;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cEi;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean awG() {
        return this.eAy;
    }

    private boolean bfV() {
        return this.dmu;
    }

    private void iO(boolean z) {
        this.dmu = z;
    }

    private void requestAudioFocus() {
        if (this.eAx) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bxC == null) {
            this.bxC = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxC != null) {
            try {
                this.bxC.requestAudioFocus(this.bxG, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0546a interfaceC0546a) {
        if (eAu) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.axb().cb(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.eAu = false;
                    if (InterfaceC0546a.this != null) {
                        InterfaceC0546a.this.iP(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.eAu = false;
                    if (InterfaceC0546a.this != null) {
                        InterfaceC0546a.this.iP(true);
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
        if (interfaceC0546a != null) {
            interfaceC0546a.iP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.bxC == null) {
            this.bxC = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bxC != null) {
            this.bxC.abandonAudioFocus(this.bxG);
        }
    }

    private void setKeepScreenOn(final boolean z) {
        ak.k(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aIE;
                Window window;
                e aIK = e.aIK();
                if (aIK != null && (aIE = aIK.aIE()) != null && (window = aIE.getWindow()) != null) {
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

    private static String oi(String str) {
        e aIK = e.aIK();
        if (!com.baidu.swan.apps.storage.b.sV(str) || aIK == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aIK);
    }

    private boolean isBackground() {
        if (this.eAv == -1) {
            SwanAppActivity aIE = com.baidu.swan.apps.runtime.d.aIG().aIE();
            if (aIE == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c afQ = aIE.afQ();
            if (afQ == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!afQ.avn().hasStarted()));
            }
            return !afQ.avn().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.eAv == 0));
        }
        return this.eAv == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(int i) {
        int mr = com.baidu.swan.videoplayer.media.a.a.a.mr(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + mr + ")");
        }
        if (mr != 100) {
            if (mr == 2101 && this.deo != null) {
                this.deo.hI(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.deo != null) {
                this.deo.hI(mr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfX() {
        String jSONString = this.eAz.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.deo != null) {
                this.deo.oo(jSONString);
            }
        }
    }
}
