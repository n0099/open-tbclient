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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes12.dex */
public abstract class a implements com.baidu.swan.apps.inlinewidget.f.c.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean eig = true;
    private AudioManager bph;
    protected a.InterfaceC0435a cQQ;
    protected String cUQ;
    private String cqC;
    private ZeusPluginFactory.Invoker eii;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int eih = -1;
    private boolean cYM = false;
    private boolean eij = false;
    private boolean eik = false;
    private com.baidu.swan.videoplayer.media.a.b.a eil = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.eil.mVideoWidth = a.this.getVideoWidth();
            a.this.eil.mVideoHeight = a.this.getVideoHeight();
            if (a.this.cQQ != null) {
                a.this.cQQ.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.iM(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.cQQ != null) {
                a.this.cQQ.onError(i3);
            }
            a.this.i(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.cQQ != null) {
                if (z) {
                    a.this.cQQ.onEnded();
                } else {
                    a.this.cQQ.oy(a.this.atG());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener eip = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.eil.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.eil.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.eil.eiF = i2;
                    break;
            }
            a.this.iM(i);
            a.this.cQQ.iL(i);
            if (i == 904) {
                a.this.bci();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener eiq = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener eir = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener eis = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.eil.mVideoWidth = i;
            a.this.eil.mVideoHeight = i2;
            if (a.this.cQQ != null) {
                a.this.cQQ.atx();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bpl = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    /* loaded from: classes12.dex */
    public interface InterfaceC0553a {
        void hV(boolean z);
    }

    public abstract void bci();

    public abstract void i(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.eii = invoker;
        if (this.eii != null) {
            Object obj = this.eii.get("id");
            if (obj instanceof String) {
                this.cUQ = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.aua();
        this.cqC = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.aua(), new InterfaceC0553a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0553a
            public void hV(boolean z) {
                aVar.eY(z);
            }
        });
    }

    private synchronized CyberPlayer bcg() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.aud().aej()) {
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
            this.mPlayer.setOnPreparedListener(this.eim);
            this.mPlayer.setOnVideoSizeChangedListener(this.eis);
            this.mPlayer.setOnCompletionListener(this.eio);
            this.mPlayer.setOnErrorListener(this.ein);
            this.mPlayer.setOnInfoListener(this.eip);
            this.mPlayer.setOnBufferingUpdateListener(this.eiq);
            this.mPlayer.setOnSeekCompleteListener(this.eir);
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
        this.eik = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String ou = ou(str);
        if (this.eii != null) {
            String str4 = (String) this.eii.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                bcg().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                bcg().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                bcg().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                bcg().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aKi = ab.aKi();
        if (!TextUtils.isEmpty(aKi) && ab.ub(ou)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aKi);
            }
            hashMap.put("Referer", aKi);
        }
        bcg().setDataSource(this.mContext, Uri.parse(ou), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        bcg().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        bcg().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            hU(true);
            if (this.cQQ != null) {
                this.cQQ.oy(atG());
                return;
            }
            return;
        }
        requestAudioFocus();
        bcg().start();
        setKeepScreenOn(true);
        if (this.cQQ != null) {
            this.cQQ.ox(atG());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String atG() {
        return this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        bcg().pause();
        setKeepScreenOn(false);
        hU(false);
        if (this.cQQ != null) {
            this.cQQ.oy(atG());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        bcg().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        bcg().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cUQ + " release()");
        }
        if (this.cQQ != null) {
            this.cQQ.hf(atG());
        }
        abandonAudioFocus();
        j.ahD().lB(atG());
        bcg().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return bcg().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return bcg().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return bcg().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return bcg().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return bcg().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void ff(boolean z) {
        if (z) {
            if (this.eii != null) {
                bcg().changeProxyDynamic((String) this.eii.get("Proxy"), true);
                return;
            }
            return;
        }
        bcg().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void atH() {
        this.eih = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            hU(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void iO(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void iN(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int atL() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void atI() {
        this.eih = 1;
        if (!isPlaying() && bch()) {
            hU(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.eij = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        bcg().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0435a interfaceC0435a) {
        this.cQQ = interfaceC0435a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0435a atJ() {
        return this.cQQ;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String atc() {
        return this.cUQ;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cqC;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean atK() {
        return this.eik;
    }

    private boolean bch() {
        return this.cYM;
    }

    private void hU(boolean z) {
        this.cYM = z;
    }

    private void requestAudioFocus() {
        if (this.eij) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bph == null) {
            this.bph = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.bph != null) {
            try {
                this.bph.requestAudioFocus(this.bpl, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0553a interfaceC0553a) {
        if (eig) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.auf().bq(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.eig = false;
                    if (InterfaceC0553a.this != null) {
                        InterfaceC0553a.this.hV(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.eig = false;
                    if (InterfaceC0553a.this != null) {
                        InterfaceC0553a.this.hV(true);
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
        if (interfaceC0553a != null) {
            interfaceC0553a.hV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.bph == null) {
            this.bph = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.bph != null) {
            this.bph.abandonAudioFocus(this.bpl);
        }
    }

    private void setKeepScreenOn(final boolean z) {
        ak.m(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aEO;
                Window window;
                e aEU = e.aEU();
                if (aEU != null && (aEO = aEU.aEO()) != null && (window = aEO.getWindow()) != null) {
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

    private static String ou(String str) {
        e aEU = e.aEU();
        if (!com.baidu.swan.apps.storage.b.ta(str) || aEU == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aEU);
    }

    private boolean isBackground() {
        if (this.eih == -1) {
            SwanAppActivity aEO = com.baidu.swan.apps.runtime.d.aEQ().aEO();
            if (aEO == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c adf = aEO.adf();
            if (adf == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!adf.asr().hasStarted()));
            }
            return !adf.asr().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.eih == 0));
        }
        return this.eih == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(int i) {
        int nh = com.baidu.swan.videoplayer.media.a.a.a.nh(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + nh + ")");
        }
        if (nh != 100) {
            if (nh == 2101 && this.cQQ != null) {
                this.cQQ.iM(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.cQQ != null) {
                this.cQQ.iM(nh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcj() {
        String jSONString = this.eil.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.cQQ != null) {
                this.cQQ.oz(jSONString);
            }
        }
    }
}
