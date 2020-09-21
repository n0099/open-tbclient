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
/* loaded from: classes25.dex */
public abstract class a implements com.baidu.swan.apps.inlinewidget.f.c.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dNI = true;
    private String bVN;
    private AudioManager bjH;
    protected String cAp;
    protected a.InterfaceC0404a cwo;
    private ZeusPluginFactory.Invoker dNK;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int dNJ = -1;
    private boolean cEm = false;
    private boolean dNL = false;
    private boolean dNM = false;
    private com.baidu.swan.videoplayer.media.a.b.a dNN = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.dNN.mVideoWidth = a.this.getVideoWidth();
            a.this.dNN.mVideoHeight = a.this.getVideoHeight();
            if (a.this.cwo != null) {
                a.this.cwo.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.ie(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.cwo != null) {
                a.this.cwo.onError(i3);
            }
            a.this.g(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.cwo != null) {
                if (z) {
                    a.this.cwo.onEnded();
                } else {
                    a.this.cwo.nr(a.this.aoZ());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener dNR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.dNN.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.dNN.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.dNN.dOh = i2;
                    break;
            }
            a.this.ie(i);
            a.this.cwo.id(i);
            if (i == 904) {
                a.this.aXH();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener dNS = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener dNT = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener dNU = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.dNN.mVideoWidth = i;
            a.this.dNN.mVideoHeight = i2;
            if (a.this.cwo != null) {
                a.this.cwo.aoQ();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bjL = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    /* loaded from: classes25.dex */
    public interface InterfaceC0522a {
        void hn(boolean z);
    }

    public abstract void aXH();

    public abstract void g(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.dNK = invoker;
        if (this.dNK != null) {
            Object obj = this.dNK.get("id");
            if (obj instanceof String) {
                this.cAp = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.apu();
        this.bVN = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.apu(), new InterfaceC0522a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0522a
            public void hn(boolean z) {
                aVar.ep(z);
            }
        });
    }

    private synchronized CyberPlayer aXF() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.apx().ZD()) {
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
            this.mPlayer.setOnPreparedListener(this.dNO);
            this.mPlayer.setOnVideoSizeChangedListener(this.dNU);
            this.mPlayer.setOnCompletionListener(this.dNQ);
            this.mPlayer.setOnErrorListener(this.dNP);
            this.mPlayer.setOnInfoListener(this.dNR);
            this.mPlayer.setOnBufferingUpdateListener(this.dNS);
            this.mPlayer.setOnSeekCompleteListener(this.dNT);
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
        this.dNM = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String nn = nn(str);
        if (this.dNK != null) {
            String str4 = (String) this.dNK.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                aXF().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                aXF().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                aXF().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                aXF().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aFF = ab.aFF();
        if (!TextUtils.isEmpty(aFF) && ab.sW(nn)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aFF);
            }
            hashMap.put("Referer", aFF);
        }
        aXF().setDataSource(this.mContext, Uri.parse(nn), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        aXF().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        aXF().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cAp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.cAp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            hl(true);
            if (this.cwo != null) {
                this.cwo.nr(aoZ());
                return;
            }
            return;
        }
        requestAudioFocus();
        aXF().start();
        hm(true);
        if (this.cwo != null) {
            this.cwo.nq(aoZ());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String aoZ() {
        return this.cAp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cAp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        aXF().pause();
        hm(false);
        hl(false);
        if (this.cwo != null) {
            this.cwo.nr(aoZ());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        aXF().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        aXF().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.cAp + " release()");
        }
        if (this.cwo != null) {
            this.cwo.gG(aoZ());
        }
        abandonAudioFocus();
        j.acX().kw(aoZ());
        aXF().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return aXF().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return aXF().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return aXF().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return aXF().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return aXF().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void ew(boolean z) {
        if (z) {
            if (this.dNK != null) {
                aXF().changeProxyDynamic((String) this.dNK.get("Proxy"), true);
                return;
            }
            return;
        }
        aXF().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void apa() {
        this.dNJ = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            hl(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void ig(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    /* renamed from: if */
    public void mo34if(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int ape() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void apb() {
        this.dNJ = 1;
        if (!isPlaying() && aXG()) {
            hl(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.dNL = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        aXF().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void l(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0404a interfaceC0404a) {
        this.cwo = interfaceC0404a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0404a apc() {
        return this.cwo;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String aov() {
        return this.cAp;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.bVN;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean apd() {
        return this.dNM;
    }

    private boolean aXG() {
        return this.cEm;
    }

    private void hl(boolean z) {
        this.cEm = z;
    }

    private void requestAudioFocus() {
        if (this.dNL) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.bjH == null) {
            this.bjH = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bjH != null) {
            try {
                this.bjH.requestAudioFocus(this.bjL, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0522a interfaceC0522a) {
        if (dNI) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.apz().bk(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.dNI = false;
                    if (InterfaceC0522a.this != null) {
                        InterfaceC0522a.this.hn(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.dNI = false;
                    if (InterfaceC0522a.this != null) {
                        InterfaceC0522a.this.hn(true);
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
        if (interfaceC0522a != null) {
            interfaceC0522a.hn(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.bjH == null) {
            this.bjH = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.bjH != null) {
            this.bjH.abandonAudioFocus(this.bjL);
        }
    }

    private void hm(final boolean z) {
        ak.m(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aAl;
                Window window;
                e aAr = e.aAr();
                if (aAr != null && (aAl = aAr.aAl()) != null && (window = aAl.getWindow()) != null) {
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

    private static String nn(String str) {
        e aAr = e.aAr();
        if (!com.baidu.swan.apps.storage.b.rU(str) || aAr == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, aAr);
    }

    private boolean isBackground() {
        if (this.dNJ == -1) {
            SwanAppActivity aAl = com.baidu.swan.apps.runtime.d.aAn().aAl();
            if (aAl == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c Yz = aAl.Yz();
            if (Yz == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!Yz.anK().hasStarted()));
            }
            return !Yz.anK().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.dNJ == 0));
        }
        return this.dNJ == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(int i) {
        int mz = com.baidu.swan.videoplayer.media.a.a.a.mz(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + mz + ")");
        }
        if (mz != 100) {
            if (mz == 2101 && this.cwo != null) {
                this.cwo.ie(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.cwo != null) {
                this.cwo.ie(mz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aXI() {
        String jSONString = this.dNN.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.cwo != null) {
                this.cwo.ns(jSONString);
            }
        }
    }
}
