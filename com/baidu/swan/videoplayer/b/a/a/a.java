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
/* loaded from: classes6.dex */
public abstract class a implements com.baidu.swan.apps.inlinewidget.f.c.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean ets = true;
    private AudioManager btY;
    private String cBI;
    protected a.InterfaceC0457a dbV;
    protected String dga;
    private ZeusPluginFactory.Invoker etu;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int ett = -1;
    private boolean dka = false;
    private boolean etv = false;
    private boolean etw = false;
    private com.baidu.swan.videoplayer.media.a.b.a etx = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.etx.mVideoWidth = a.this.getVideoWidth();
            a.this.etx.mVideoHeight = a.this.getVideoHeight();
            if (a.this.dbV != null) {
                a.this.dbV.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.jq(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.dbV != null) {
                a.this.dbV.onError(i3);
            }
            a.this.i(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.dbV != null) {
                if (z) {
                    a.this.dbV.onEnded();
                } else {
                    a.this.dbV.pn(a.this.ayG());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.etx.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.etx.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.etx.etR = i2;
                    break;
            }
            a.this.jq(i);
            a.this.dbV.jp(i);
            if (i == 904) {
                a.this.bhg();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener etC = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener etE = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.etx.mVideoWidth = i;
            a.this.etx.mVideoHeight = i2;
            if (a.this.dbV != null) {
                a.this.dbV.ayx();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener buc = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    /* loaded from: classes6.dex */
    public interface InterfaceC0575a {
        void iw(boolean z);
    }

    public abstract void bhg();

    public abstract void i(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.etu = invoker;
        if (this.etu != null) {
            Object obj = this.etu.get("id");
            if (obj instanceof String) {
                this.dga = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.aza();
        this.cBI = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.aza(), new InterfaceC0575a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0575a
            public void iw(boolean z) {
                aVar.fz(z);
            }
        });
    }

    private synchronized CyberPlayer bhe() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.azd().ajj()) {
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
            this.mPlayer.setOnPreparedListener(this.ety);
            this.mPlayer.setOnVideoSizeChangedListener(this.etE);
            this.mPlayer.setOnCompletionListener(this.etA);
            this.mPlayer.setOnErrorListener(this.etz);
            this.mPlayer.setOnInfoListener(this.etB);
            this.mPlayer.setOnBufferingUpdateListener(this.etC);
            this.mPlayer.setOnSeekCompleteListener(this.etD);
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
        this.etw = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String pj = pj(str);
        if (this.etu != null) {
            String str4 = (String) this.etu.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                bhe().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                bhe().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                bhe().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                bhe().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aPh = ab.aPh();
        if (!TextUtils.isEmpty(aPh) && ab.uR(pj)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aPh);
            }
            hashMap.put("Referer", aPh);
        }
        bhe().setDataSource(this.mContext, Uri.parse(pj), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        bhe().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        bhe().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dga + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.dga + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            iv(true);
            if (this.dbV != null) {
                this.dbV.pn(ayG());
                return;
            }
            return;
        }
        requestAudioFocus();
        bhe().start();
        setKeepScreenOn(true);
        if (this.dbV != null) {
            this.dbV.pm(ayG());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String ayG() {
        return this.dga + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dga + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        bhe().pause();
        setKeepScreenOn(false);
        iv(false);
        if (this.dbV != null) {
            this.dbV.pn(ayG());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        bhe().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        bhe().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dga + " release()");
        }
        if (this.dbV != null) {
            this.dbV.hB(ayG());
        }
        abandonAudioFocus();
        j.amD().mr(ayG());
        bhe().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return bhe().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return bhe().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return bhe().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return bhe().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return bhe().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void fG(boolean z) {
        if (z) {
            if (this.etu != null) {
                bhe().changeProxyDynamic((String) this.etu.get("Proxy"), true);
                return;
            }
            return;
        }
        bhe().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void ayH() {
        this.ett = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            iv(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void js(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void jr(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int ayL() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void ayI() {
        this.ett = 1;
        if (!isPlaying() && bhf()) {
            iv(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.etv = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        bhe().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void o(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0457a interfaceC0457a) {
        this.dbV = interfaceC0457a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0457a ayJ() {
        return this.dbV;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String ayc() {
        return this.dga;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cBI;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean ayK() {
        return this.etw;
    }

    private boolean bhf() {
        return this.dka;
    }

    private void iv(boolean z) {
        this.dka = z;
    }

    private void requestAudioFocus() {
        if (this.etv) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.btY == null) {
            this.btY = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.btY != null) {
            try {
                this.btY.requestAudioFocus(this.buc, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0575a interfaceC0575a) {
        if (ets) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.azf().bW(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.ets = false;
                    if (InterfaceC0575a.this != null) {
                        InterfaceC0575a.this.iw(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.ets = false;
                    if (InterfaceC0575a.this != null) {
                        InterfaceC0575a.this.iw(true);
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
        if (interfaceC0575a != null) {
            interfaceC0575a.iw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.btY == null) {
            this.btY = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.btY != null) {
            this.btY.abandonAudioFocus(this.buc);
        }
    }

    private void setKeepScreenOn(final boolean z) {
        ak.m(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aJO;
                Window window;
                e aJU = e.aJU();
                if (aJU != null && (aJO = aJU.aJO()) != null && (window = aJO.getWindow()) != null) {
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

    private static String pj(String str) {
        e aJU = e.aJU();
        if (!com.baidu.swan.apps.storage.b.tQ(str) || aJU == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aJU);
    }

    private boolean isBackground() {
        if (this.ett == -1) {
            SwanAppActivity aJO = com.baidu.swan.apps.runtime.d.aJQ().aJO();
            if (aJO == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c aif = aJO.aif();
            if (aif == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!aif.axr().hasStarted()));
            }
            return !aif.axr().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.ett == 0));
        }
        return this.ett == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(int i) {
        int nL = com.baidu.swan.videoplayer.media.a.a.a.nL(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + nL + ")");
        }
        if (nL != 100) {
            if (nL == 2101 && this.dbV != null) {
                this.dbV.jq(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.dbV != null) {
                this.dbV.jq(nL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhh() {
        String jSONString = this.etx.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.dbV != null) {
                this.dbV.po(jSONString);
            }
        }
    }
}
