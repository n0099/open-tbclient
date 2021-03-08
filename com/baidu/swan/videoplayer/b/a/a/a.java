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
/* loaded from: classes14.dex */
public abstract class a implements com.baidu.swan.apps.inlinewidget.f.c.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean eBV = true;
    private AudioManager bzc;
    private String cFI;
    protected a.InterfaceC0435a dfQ;
    protected String djT;
    private ZeusPluginFactory.Invoker eBX;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int eBW = -1;
    private boolean dnW = false;
    private boolean eBY = false;
    private boolean eBZ = false;
    private com.baidu.swan.videoplayer.media.a.b.a eCa = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.eCa.mVideoWidth = a.this.getVideoWidth();
            a.this.eCa.mVideoHeight = a.this.getVideoHeight();
            if (a.this.dfQ != null) {
                a.this.dfQ.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.hJ(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.dfQ != null) {
                a.this.dfQ.onError(i3);
            }
            a.this.h(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.dfQ != null) {
                if (z) {
                    a.this.dfQ.onEnded();
                } else {
                    a.this.dfQ.ou(a.this.awF());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener eCe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.eCa.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.eCa.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.eCa.eCu = i2;
                    break;
            }
            a.this.hJ(i);
            a.this.dfQ.hI(i);
            if (i == 904) {
                a.this.bfY();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener eCf = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener eCg = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener eCh = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.eCa.mVideoWidth = i;
            a.this.eCa.mVideoHeight = i2;
            if (a.this.dfQ != null) {
                a.this.dfQ.aww();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bzg = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    /* loaded from: classes14.dex */
    public interface InterfaceC0552a {
        void iP(boolean z);
    }

    public abstract void bfY();

    public abstract void h(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.eBX = invoker;
        if (this.eBX != null) {
            Object obj = this.eBX.get("id");
            if (obj instanceof String) {
                this.djT = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.awZ();
        this.cFI = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.awZ(), new InterfaceC0552a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0552a
            public void iP(boolean z) {
                aVar.fG(z);
            }
        });
    }

    private synchronized CyberPlayer bfW() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.axc().agZ()) {
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
            this.mPlayer.setOnPreparedListener(this.eCb);
            this.mPlayer.setOnVideoSizeChangedListener(this.eCh);
            this.mPlayer.setOnCompletionListener(this.eCd);
            this.mPlayer.setOnErrorListener(this.eCc);
            this.mPlayer.setOnInfoListener(this.eCe);
            this.mPlayer.setOnBufferingUpdateListener(this.eCf);
            this.mPlayer.setOnSeekCompleteListener(this.eCg);
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
        this.eBZ = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String oq = oq(str);
        if (this.eBX != null) {
            String str4 = (String) this.eBX.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                bfW().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                bfW().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                bfW().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                bfW().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aOb = ab.aOb();
        if (!TextUtils.isEmpty(aOb) && ab.uf(oq)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aOb);
            }
            hashMap.put("Referer", aOb);
        }
        bfW().setDataSource(this.mContext, Uri.parse(oq), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        bfW().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        bfW().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            iO(true);
            if (this.dfQ != null) {
                this.dfQ.ou(awF());
                return;
            }
            return;
        }
        requestAudioFocus();
        bfW().start();
        setKeepScreenOn(true);
        if (this.dfQ != null) {
            this.dfQ.ot(awF());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String awF() {
        return this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        bfW().pause();
        setKeepScreenOn(false);
        iO(false);
        if (this.dfQ != null) {
            this.dfQ.ou(awF());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        bfW().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        bfW().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.djT + " release()");
        }
        if (this.dfQ != null) {
            this.dfQ.gE(awF());
        }
        abandonAudioFocus();
        j.akv().ly(awF());
        bfW().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return bfW().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return bfW().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return bfW().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return bfW().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return bfW().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void fN(boolean z) {
        if (z) {
            if (this.eBX != null) {
                bfW().changeProxyDynamic((String) this.eBX.get("Proxy"), true);
                return;
            }
            return;
        }
        bfW().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awG() {
        this.eBW = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            iO(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hL(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hK(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int awK() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awH() {
        this.eBW = 1;
        if (!isPlaying() && bfX()) {
            iO(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.eBY = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        bfW().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void o(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0435a interfaceC0435a) {
        this.dfQ = interfaceC0435a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0435a awI() {
        return this.dfQ;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String awb() {
        return this.djT;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cFI;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean awJ() {
        return this.eBZ;
    }

    private boolean bfX() {
        return this.dnW;
    }

    private void iO(boolean z) {
        this.dnW = z;
    }

    private void requestAudioFocus() {
        if (this.eBY) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bzc == null) {
            this.bzc = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bzc != null) {
            try {
                this.bzc.requestAudioFocus(this.bzg, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0552a interfaceC0552a) {
        if (eBV) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.axe().ca(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.eBV = false;
                    if (InterfaceC0552a.this != null) {
                        InterfaceC0552a.this.iP(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.eBV = false;
                    if (InterfaceC0552a.this != null) {
                        InterfaceC0552a.this.iP(true);
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
        if (interfaceC0552a != null) {
            interfaceC0552a.iP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.bzc == null) {
            this.bzc = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bzc != null) {
            this.bzc.abandonAudioFocus(this.bzg);
        }
    }

    private void setKeepScreenOn(final boolean z) {
        ak.j(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aIH;
                Window window;
                e aIN = e.aIN();
                if (aIN != null && (aIH = aIN.aIH()) != null && (window = aIH.getWindow()) != null) {
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

    private static String oq(String str) {
        e aIN = e.aIN();
        if (!com.baidu.swan.apps.storage.b.tc(str) || aIN == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aIN);
    }

    private boolean isBackground() {
        if (this.eBW == -1) {
            SwanAppActivity aIH = com.baidu.swan.apps.runtime.d.aIJ().aIH();
            if (aIH == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c afT = aIH.afT();
            if (afT == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!afT.avq().hasStarted()));
            }
            return !afT.avq().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.eBW == 0));
        }
        return this.eBW == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hJ(int i) {
        int ms = com.baidu.swan.videoplayer.media.a.a.a.ms(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + ms + ")");
        }
        if (ms != 100) {
            if (ms == 2101 && this.dfQ != null) {
                this.dfQ.hJ(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.dfQ != null) {
                this.dfQ.hJ(ms);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfZ() {
        String jSONString = this.eCa.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.dfQ != null) {
                this.dfQ.ov(jSONString);
            }
        }
    }
}
