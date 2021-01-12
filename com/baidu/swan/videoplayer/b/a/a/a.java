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
    private static boolean eyn = true;
    private AudioManager btX;
    private String cBM;
    protected a.InterfaceC0432a dcb;
    protected String dge;
    private ZeusPluginFactory.Invoker eyp;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int eyo = -1;
    private boolean dkl = false;
    private boolean eyq = false;
    private boolean eyr = false;
    private com.baidu.swan.videoplayer.media.a.b.a eys = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.eys.mVideoWidth = a.this.getVideoWidth();
            a.this.eys.mVideoHeight = a.this.getVideoHeight();
            if (a.this.dcb != null) {
                a.this.dcb.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.hF(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.dcb != null) {
                a.this.dcb.onError(i3);
            }
            a.this.i(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.dcb != null) {
                if (z) {
                    a.this.dcb.onEnded();
                } else {
                    a.this.dcb.nT(a.this.awe());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener eyw = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.eys.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.eys.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.eys.eyM = i2;
                    break;
            }
            a.this.hF(i);
            a.this.dcb.hE(i);
            if (i == 904) {
                a.this.bfJ();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener eyx = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener eyy = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener eyz = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.eys.mVideoWidth = i;
            a.this.eys.mVideoHeight = i2;
            if (a.this.dcb != null) {
                a.this.dcb.avV();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener bub = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    public interface InterfaceC0549a {
        void iN(boolean z);
    }

    public abstract void bfJ();

    public abstract void i(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.eyp = invoker;
        if (this.eyp != null) {
            Object obj = this.eyp.get("id");
            if (obj instanceof String) {
                this.dge = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.awy();
        this.cBM = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.awy(), new InterfaceC0549a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0549a
            public void iN(boolean z) {
                aVar.fE(z);
            }
        });
    }

    private synchronized CyberPlayer bfH() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.awB().agy()) {
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
            this.mPlayer.setOnPreparedListener(this.eyt);
            this.mPlayer.setOnVideoSizeChangedListener(this.eyz);
            this.mPlayer.setOnCompletionListener(this.eyv);
            this.mPlayer.setOnErrorListener(this.eyu);
            this.mPlayer.setOnInfoListener(this.eyw);
            this.mPlayer.setOnBufferingUpdateListener(this.eyx);
            this.mPlayer.setOnSeekCompleteListener(this.eyy);
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
        this.eyr = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String nP = nP(str);
        if (this.eyp != null) {
            String str4 = (String) this.eyp.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                bfH().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                bfH().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                bfH().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                bfH().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aNF = ab.aNF();
        if (!TextUtils.isEmpty(aNF) && ab.tF(nP)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aNF);
            }
            hashMap.put("Referer", aNF);
        }
        bfH().setDataSource(this.mContext, Uri.parse(nP), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        bfH().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        bfH().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            iM(true);
            if (this.dcb != null) {
                this.dcb.nT(awe());
                return;
            }
            return;
        }
        requestAudioFocus();
        bfH().start();
        setKeepScreenOn(true);
        if (this.dcb != null) {
            this.dcb.nS(awe());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String awe() {
        return this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        bfH().pause();
        setKeepScreenOn(false);
        iM(false);
        if (this.dcb != null) {
            this.dcb.nT(awe());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        bfH().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        bfH().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dge + " release()");
        }
        if (this.dcb != null) {
            this.dcb.ga(awe());
        }
        abandonAudioFocus();
        j.ajU().kZ(awe());
        bfH().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return bfH().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return bfH().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return bfH().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return bfH().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return bfH().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void fL(boolean z) {
        if (z) {
            if (this.eyp != null) {
                bfH().changeProxyDynamic((String) this.eyp.get("Proxy"), true);
                return;
            }
            return;
        }
        bfH().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awf() {
        this.eyo = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            iM(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hH(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void hG(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int awj() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void awg() {
        this.eyo = 1;
        if (!isPlaying() && bfI()) {
            iM(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.eyq = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        bfH().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void o(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0432a interfaceC0432a) {
        this.dcb = interfaceC0432a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0432a awh() {
        return this.dcb;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avA() {
        return this.dge;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cBM;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean awi() {
        return this.eyr;
    }

    private boolean bfI() {
        return this.dkl;
    }

    private void iM(boolean z) {
        this.dkl = z;
    }

    private void requestAudioFocus() {
        if (this.eyq) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.btX == null) {
            this.btX = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.btX != null) {
            try {
                this.btX.requestAudioFocus(this.bub, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0549a interfaceC0549a) {
        if (eyn) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.awD().cc(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.eyn = false;
                    if (InterfaceC0549a.this != null) {
                        InterfaceC0549a.this.iN(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.eyn = false;
                    if (InterfaceC0549a.this != null) {
                        InterfaceC0549a.this.iN(true);
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
        if (interfaceC0549a != null) {
            interfaceC0549a.iN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.btX == null) {
            this.btX = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.btX != null) {
            this.btX.abandonAudioFocus(this.bub);
        }
    }

    private void setKeepScreenOn(final boolean z) {
        ak.l(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aIl;
                Window window;
                e aIr = e.aIr();
                if (aIr != null && (aIl = aIr.aIl()) != null && (window = aIl.getWindow()) != null) {
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

    private static String nP(String str) {
        e aIr = e.aIr();
        if (!com.baidu.swan.apps.storage.b.sC(str) || aIr == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aIr);
    }

    private boolean isBackground() {
        if (this.eyo == -1) {
            SwanAppActivity aIl = com.baidu.swan.apps.runtime.d.aIn().aIl();
            if (aIl == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c afs = aIl.afs();
            if (afs == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!afs.auP().hasStarted()));
            }
            return !afs.auP().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.eyo == 0));
        }
        return this.eyo == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hF(int i) {
        int mo = com.baidu.swan.videoplayer.media.a.a.a.mo(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + mo + ")");
        }
        if (mo != 100) {
            if (mo == 2101 && this.dcb != null) {
                this.dcb.hF(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.dcb != null) {
                this.dcb.hF(mo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfK() {
        String jSONString = this.eys.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.dcb != null) {
                this.dcb.nU(jSONString);
            }
        }
    }
}
