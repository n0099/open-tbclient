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
    private static boolean enZ = true;
    private AudioManager bqA;
    protected a.InterfaceC0447a cWJ;
    private String cwA;
    protected String daK;
    private ZeusPluginFactory.Invoker eob;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int eoa = -1;
    private boolean deJ = false;
    private boolean eoc = false;
    private boolean eod = false;
    private com.baidu.swan.videoplayer.media.a.b.a eoe = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.eoe.mVideoWidth = a.this.getVideoWidth();
            a.this.eoe.mVideoHeight = a.this.getVideoHeight();
            if (a.this.cWJ != null) {
                a.this.cWJ.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.iW(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.cWJ != null) {
                a.this.cWJ.onError(i3);
            }
            a.this.i(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.cWJ != null) {
                if (z) {
                    a.this.cWJ.onEnded();
                } else {
                    a.this.cWJ.oM(a.this.awg());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener eoj = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.eoe.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.eoe.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.eoe.eoz = i2;
                    break;
            }
            a.this.iW(i);
            a.this.cWJ.iV(i);
            if (i == 904) {
                a.this.beI();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener eok = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener eol = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener eom = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.eoe.mVideoWidth = i;
            a.this.eoe.mVideoHeight = i2;
            if (a.this.cWJ != null) {
                a.this.cWJ.avX();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bqE = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    public interface InterfaceC0565a {
        void ie(boolean z);
    }

    public abstract void beI();

    public abstract void i(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.eob = invoker;
        if (this.eob != null) {
            Object obj = this.eob.get("id");
            if (obj instanceof String) {
                this.daK = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.awA();
        this.cwA = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.awA(), new InterfaceC0565a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0565a
            public void ie(boolean z) {
                aVar.fh(z);
            }
        });
    }

    private synchronized CyberPlayer beG() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.awD().agJ()) {
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
            this.mPlayer.setOnPreparedListener(this.eog);
            this.mPlayer.setOnVideoSizeChangedListener(this.eom);
            this.mPlayer.setOnCompletionListener(this.eoi);
            this.mPlayer.setOnErrorListener(this.eoh);
            this.mPlayer.setOnInfoListener(this.eoj);
            this.mPlayer.setOnBufferingUpdateListener(this.eok);
            this.mPlayer.setOnSeekCompleteListener(this.eol);
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
        this.eod = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String oI = oI(str);
        if (this.eob != null) {
            String str4 = (String) this.eob.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                beG().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                beG().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                beG().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                beG().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aMI = ab.aMI();
        if (!TextUtils.isEmpty(aMI) && ab.up(oI)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aMI);
            }
            hashMap.put("Referer", aMI);
        }
        beG().setDataSource(this.mContext, Uri.parse(oI), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        beG().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        beG().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            id(true);
            if (this.cWJ != null) {
                this.cWJ.oM(awg());
                return;
            }
            return;
        }
        requestAudioFocus();
        beG().start();
        setKeepScreenOn(true);
        if (this.cWJ != null) {
            this.cWJ.oL(awg());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String awg() {
        return this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        beG().pause();
        setKeepScreenOn(false);
        id(false);
        if (this.cWJ != null) {
            this.cWJ.oM(awg());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        beG().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        beG().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.daK + " release()");
        }
        if (this.cWJ != null) {
            this.cWJ.hm(awg());
        }
        abandonAudioFocus();
        j.akd().lQ(awg());
        beG().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return beG().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return beG().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return beG().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return beG().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return beG().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void fo(boolean z) {
        if (z) {
            if (this.eob != null) {
                beG().changeProxyDynamic((String) this.eob.get("Proxy"), true);
                return;
            }
            return;
        }
        beG().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awh() {
        this.eoa = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            id(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void iY(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void iX(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int awl() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awi() {
        this.eoa = 1;
        if (!isPlaying() && beH()) {
            id(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.eoc = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        beG().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0447a interfaceC0447a) {
        this.cWJ = interfaceC0447a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0447a awj() {
        return this.cWJ;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avC() {
        return this.daK;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cwA;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean awk() {
        return this.eod;
    }

    private boolean beH() {
        return this.deJ;
    }

    private void id(boolean z) {
        this.deJ = z;
    }

    private void requestAudioFocus() {
        if (this.eoc) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bqA == null) {
            this.bqA = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.bqA != null) {
            try {
                this.bqA.requestAudioFocus(this.bqE, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0565a interfaceC0565a) {
        if (enZ) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.awF().bq(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.enZ = false;
                    if (InterfaceC0565a.this != null) {
                        InterfaceC0565a.this.ie(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.enZ = false;
                    if (InterfaceC0565a.this != null) {
                        InterfaceC0565a.this.ie(true);
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
        if (interfaceC0565a != null) {
            interfaceC0565a.ie(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.bqA == null) {
            this.bqA = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.bqA != null) {
            this.bqA.abandonAudioFocus(this.bqE);
        }
    }

    private void setKeepScreenOn(final boolean z) {
        ak.m(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aHo;
                Window window;
                e aHu = e.aHu();
                if (aHu != null && (aHo = aHu.aHo()) != null && (window = aHo.getWindow()) != null) {
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

    private static String oI(String str) {
        e aHu = e.aHu();
        if (!com.baidu.swan.apps.storage.b.to(str) || aHu == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aHu);
    }

    private boolean isBackground() {
        if (this.eoa == -1) {
            SwanAppActivity aHo = com.baidu.swan.apps.runtime.d.aHq().aHo();
            if (aHo == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c afF = aHo.afF();
            if (afF == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!afF.auR().hasStarted()));
            }
            return !afF.auR().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.eoa == 0));
        }
        return this.eoa == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW(int i) {
        int nr = com.baidu.swan.videoplayer.media.a.a.a.nr(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + nr + ")");
        }
        if (nr != 100) {
            if (nr == 2101 && this.cWJ != null) {
                this.cWJ.iW(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.cWJ != null) {
                this.cWJ.iW(nr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beJ() {
        String jSONString = this.eoe.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.cWJ != null) {
                this.cWJ.oN(jSONString);
            }
        }
    }
}
