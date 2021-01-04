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
/* loaded from: classes3.dex */
public abstract class a implements com.baidu.swan.apps.inlinewidget.f.c.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean eCZ = true;
    private AudioManager byK;
    private String cGy;
    protected a.InterfaceC0449a dgQ;
    protected String dkT;
    private ZeusPluginFactory.Invoker eDb;
    protected Context mContext;
    protected String mCurrentUrl;
    private CyberPlayer mPlayer;
    private int eDa = -1;
    private boolean dpa = false;
    private boolean eDc = false;
    private boolean eDd = false;
    private com.baidu.swan.videoplayer.media.a.b.a eDe = new com.baidu.swan.videoplayer.media.a.b.a();
    private final CyberPlayerManager.OnPreparedListener eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.6
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onPrepared()");
            }
            a.this.eDe.mVideoWidth = a.this.getVideoWidth();
            a.this.eDe.mVideoHeight = a.this.getVideoHeight();
            if (a.this.dgQ != null) {
                a.this.dgQ.onPrepared();
            }
        }
    };
    private final CyberPlayerManager.OnErrorListener eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            String obj2 = obj != null ? obj.toString() : "null";
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onError(" + i + ", " + i2 + ", " + obj2 + ")");
            }
            a.this.abandonAudioFocus();
            a.this.jl(i);
            int i3 = i == -10000 ? 0 : i;
            if (a.this.dgQ != null) {
                a.this.dgQ.onError(i3);
            }
            a.this.i(i, i2, obj2);
            return false;
        }
    };
    private final CyberPlayerManager.OnCompletionListener eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.8
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            boolean z = a.this.getDuration() != 0 && a.this.getCurrentPosition() >= a.this.getDuration();
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onCompletion:(" + z + ")");
            }
            a.this.abandonAudioFocus();
            if (a.this.dgQ != null) {
                if (z) {
                    a.this.dgQ.onEnded();
                } else {
                    a.this.dgQ.pg(a.this.azX());
                }
            }
        }
    };
    private final CyberPlayerManager.OnInfoListener eDi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onInfo(" + i + ", " + i2 + ", " + (obj != null ? obj.toString() : "null") + ")");
            }
            switch (i) {
                case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                    a.this.eDe.mAudioBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                    a.this.eDe.mVideoBitrate = i2;
                    break;
                case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                    a.this.eDe.eDy = i2;
                    break;
            }
            a.this.jl(i);
            a.this.dgQ.jk(i);
            if (i == 904) {
                a.this.bjC();
                return false;
            }
            return false;
        }
    };
    private final CyberPlayerManager.OnBufferingUpdateListener eDj = new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onBufferingUpdate(" + i + ")");
            }
        }
    };
    private final CyberPlayerManager.OnSeekCompleteListener eDk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.11
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onSeekComplete()");
            }
        }
    };
    private final CyberPlayerManager.OnVideoSizeChangedListener eDl = new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            if (a.DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + a.this.hashCode() + " - onVideoSizeChanged(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ")");
            }
            a.this.eDe.mVideoWidth = i;
            a.this.eDe.mVideoHeight = i2;
            if (a.this.dgQ != null) {
                a.this.dgQ.azO();
            }
        }
    };
    private final AudioManager.OnAudioFocusChangeListener byO = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.3
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
    public interface InterfaceC0566a {
        void iR(boolean z);
    }

    public abstract void bjC();

    public abstract void i(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.eDb = invoker;
        if (this.eDb != null) {
            Object obj = this.eDb.get("id");
            if (obj instanceof String) {
                this.dkT = (String) obj;
            }
        }
        this.mContext = com.baidu.swan.apps.t.a.aAr();
        this.cGy = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull final d.a aVar) {
        a(com.baidu.swan.apps.t.a.aAr(), new InterfaceC0566a() { // from class: com.baidu.swan.videoplayer.b.a.a.a.1
            @Override // com.baidu.swan.videoplayer.b.a.a.a.InterfaceC0566a
            public void iR(boolean z) {
                aVar.fI(z);
            }
        });
    }

    private synchronized CyberPlayer bjA() {
        if (this.mPlayer == null) {
            if (com.baidu.swan.apps.t.a.aAu().akr()) {
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
            this.mPlayer.setOnPreparedListener(this.eDf);
            this.mPlayer.setOnVideoSizeChangedListener(this.eDl);
            this.mPlayer.setOnCompletionListener(this.eDh);
            this.mPlayer.setOnErrorListener(this.eDg);
            this.mPlayer.setOnInfoListener(this.eDi);
            this.mPlayer.setOnBufferingUpdateListener(this.eDj);
            this.mPlayer.setOnSeekCompleteListener(this.eDk);
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
        this.eDd = true;
        this.mCurrentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file:///")) {
            str = str.substring("file:///".length());
        }
        String pc = pc(str);
        if (this.eDb != null) {
            String str4 = (String) this.eDb.get("Proxy");
            if (!TextUtils.isEmpty(str4)) {
                bjA().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                bjA().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
            } else {
                bjA().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                bjA().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
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
        String aRy = ab.aRy();
        if (!TextUtils.isEmpty(aRy) && ab.uQ(pc)) {
            if (DEBUG) {
                Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + aRy);
            }
            hashMap.put("Referer", aRy);
        }
        bjA().setDataSource(this.mContext, Uri.parse(pc), hashMap);
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSurface(Surface surface) {
        bjA().setSurface(surface);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        requestAudioFocus();
        bjA().prepareAsync();
        return true;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void start() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start()");
        }
        if (isBackground()) {
            if (DEBUG) {
                Log.e("SwanInlineCyberWidget", this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start ignored, widget is in background");
            }
            iQ(true);
            if (this.dgQ != null) {
                this.dgQ.pg(azX());
                return;
            }
            return;
        }
        requestAudioFocus();
        bjA().start();
        setKeepScreenOn(true);
        if (this.dgQ != null) {
            this.dgQ.pf(azX());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public String azX() {
        return this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pause() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " pause()");
        }
        bjA().pause();
        setKeepScreenOn(false);
        iQ(false);
        if (this.dgQ != null) {
            this.dgQ.pg(azX());
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void seekTo(int i) {
        bjA().seekTo(i);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setSpeed(float f) {
        bjA().setSpeed(f);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", this.dkT + " release()");
        }
        if (this.dgQ != null) {
            this.dgQ.hm(azX());
        }
        abandonAudioFocus();
        j.anN().mk(azX());
        bjA().release();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getDuration() {
        return bjA().getDuration();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getCurrentPosition() {
        return bjA().getCurrentPosition();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean isPlaying() {
        return bjA().isPlaying();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoWidth() {
        return bjA().getVideoWidth();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int getVideoHeight() {
        return bjA().getVideoHeight();
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void fP(boolean z) {
        if (z) {
            if (this.eDb != null) {
                bjA().changeProxyDynamic((String) this.eDb.get("Proxy"), true);
                return;
            }
            return;
        }
        bjA().changeProxyDynamic(null, false);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void azY() {
        this.eDa = 0;
        boolean isPlaying = isPlaying();
        pause();
        if (isPlaying) {
            iQ(true);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void jn(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void jm(int i) {
        if (DEBUG) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i);
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public int aAc() {
        return 0;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    @CallSuper
    public void azZ() {
        this.eDa = 1;
        if (!isPlaying() && bjB()) {
            iQ(false);
            start();
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void setMuted(boolean z) {
        if (DEBUG) {
            Log.i("SwanInlineCyberWidget", "setMuted: " + z);
        }
        this.eDc = z;
        if (z) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        bjA().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void o(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void a(@NonNull a.InterfaceC0449a interfaceC0449a) {
        this.dgQ = interfaceC0449a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public a.InterfaceC0449a aAa() {
        return this.dgQ;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String azt() {
        return this.dkT;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cGy;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean aAb() {
        return this.eDd;
    }

    private boolean bjB() {
        return this.dpa;
    }

    private void iQ(boolean z) {
        this.dpa = z;
    }

    private void requestAudioFocus() {
        if (this.eDc) {
            if (DEBUG) {
                Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                return;
            }
            return;
        }
        if (this.byK == null) {
            this.byK = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.byK != null) {
            try {
                this.byK.requestAudioFocus(this.byO, 3, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(@NonNull Context context, @Nullable final InterfaceC0566a interfaceC0566a) {
        if (eCZ) {
            if (DEBUG) {
                Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
            }
            CyberPlayerManager.install(context.getApplicationContext(), com.baidu.swan.apps.t.a.aAw().cd(context), null, 7, null, null, new CyberPlayerManager.InstallListener() { // from class: com.baidu.swan.videoplayer.b.a.a.a.4
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = a.eCZ = false;
                    if (InterfaceC0566a.this != null) {
                        InterfaceC0566a.this.iR(false);
                    }
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (a.DEBUG) {
                        Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = a.eCZ = false;
                    if (InterfaceC0566a.this != null) {
                        InterfaceC0566a.this.iR(true);
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
        if (interfaceC0566a != null) {
            interfaceC0566a.iR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.byK == null) {
            this.byK = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.byK != null) {
            this.byK.abandonAudioFocus(this.byO);
        }
    }

    private void setKeepScreenOn(final boolean z) {
        ak.l(new Runnable() { // from class: com.baidu.swan.videoplayer.b.a.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity aMe;
                Window window;
                e aMk = e.aMk();
                if (aMk != null && (aMe = aMk.aMe()) != null && (window = aMe.getWindow()) != null) {
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

    private static String pc(String str) {
        e aMk = e.aMk();
        if (!com.baidu.swan.apps.storage.b.tN(str) || aMk == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, aMk);
    }

    private boolean isBackground() {
        if (this.eDa == -1) {
            SwanAppActivity aMe = com.baidu.swan.apps.runtime.d.aMg().aMe();
            if (aMe == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    return true;
                }
                return true;
            }
            com.baidu.swan.apps.framework.c ajl = aMe.ajl();
            if (ajl == null) {
                if (DEBUG) {
                    Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    return true;
                }
                return true;
            }
            if (DEBUG) {
                Log.v("SwanInlineCyberWidget", "check background by frame lifeState, background ? " + (!ajl.ayI().hasStarted()));
            }
            return !ajl.ayI().hasStarted();
        }
        if (DEBUG) {
            Log.v("SwanInlineCyberWidget", "check background by kernel state, background ? " + (this.eDa == 0));
        }
        return this.eDa == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(int i) {
        int nU = com.baidu.swan.videoplayer.media.a.a.a.nU(i);
        if (DEBUG) {
            Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i + ", statusCode " + nU + ")");
        }
        if (nU != 100) {
            if (nU == 2101 && this.dgQ != null) {
                this.dgQ.jl(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2);
            }
            if (this.dgQ != null) {
                this.dgQ.jl(nU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjD() {
        String jSONString = this.eDe.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            if (DEBUG) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + jSONString + ")");
            }
            if (this.dgQ != null) {
                this.dgQ.ph(jSONString);
            }
        }
    }
}
