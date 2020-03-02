package com.baidu.swan.apps.media.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.c;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.h.l;
import com.baidu.swan.ubc.Flow;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Flow bBh;
    private com.baidu.swan.apps.media.audio.b.a bAX;
    private c bBe;
    @Nullable
    private com.baidu.swan.apps.y.a bBi;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a bBf = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int bBg = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.bBe != null) {
            this.bBe.pause();
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            if (this.bBe != null) {
                this.bBe.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.bAX != null) {
                this.bAX.jc("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.bBe != null) {
            this.bBe.stop();
        }
        if (this.bBi != null) {
            com.baidu.swan.apps.w.a.TW().unregisterActivityLifecycleCallbacks(this.bBi);
            this.bBi = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.bBe != null && !Xm()) {
            this.bBe.release();
            f.WS().Wu();
            this.bBe = null;
            bBh = null;
        }
    }

    public int getDuration() {
        if (this.bBe != null) {
            return this.bBe.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.bBe == null || !this.bBe.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Xj() {
        if (this.bBe == null) {
            this.bBe = new c(this.mContext);
            this.bBe.a(new a());
        }
        return this.bBe;
    }

    public com.baidu.swan.apps.media.audio.a Xk() {
        return this.bBf;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.bBf = aVar;
        if (this.bBf.bAE != null) {
            try {
                this.bAX = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bBf.bAE));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void Xl() {
        if (this.bBi != null) {
            com.baidu.swan.apps.w.a.TW().unregisterActivityLifecycleCallbacks(this.bBi);
        }
        this.bBi = new com.baidu.swan.apps.y.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.Xm()) {
                    if (d.this.isPaused()) {
                        Flow unused = d.bBh = null;
                        return;
                    } else if (d.bBh == null) {
                        Flow unused2 = d.bBh = com.baidu.swan.apps.statistic.f.lH("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                d.this.stop();
                com.baidu.swan.apps.console.c.w("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }

            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                d.this.mIsBackground = false;
                if (!d.this.isPaused()) {
                    d.this.Xn();
                }
            }
        };
        com.baidu.swan.apps.w.a.TW().registerActivityLifecycleCallbacks(this.bBi);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.bBf.Xe()) {
            Xl();
            String str = this.bBf.mUrl;
            e acF = e.acF();
            if (com.baidu.swan.apps.storage.b.ma(str) == PathType.CLOUD) {
                iX(str);
            } else {
                c(str, acF);
            }
            f.WS().Wt();
        }
    }

    private void iX(String str) {
        com.baidu.swan.apps.w.a.Uq().a(this.mContext, str, new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void D(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.Xj().aU(d.this.bBf.iW(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.bBf.bAF && eVar != null) {
            if (this.bAX.Xq()) {
                d = l.mg(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        Xj().aU(this.bBf.iW(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.bBe != null) {
            this.bBe.resume();
        }
    }

    public void cQ(boolean z) {
        if (this.bBe != null) {
            this.bBe.cQ(z);
            f.WS().Wt();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.bBf = aVar;
        if (this.bAX != null) {
            this.bAX.jb(this.bBf.bAE);
        }
        play();
    }

    public Object iY(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2129294769:
                if (str.equals("startTime")) {
                    c = 4;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    c = 0;
                    break;
                }
                break;
            case -1522036513:
                if (str.equals("buffered")) {
                    c = 5;
                    break;
                }
                break;
            case -1296614986:
                if (str.equals("epname")) {
                    c = 7;
                    break;
                }
                break;
            case -995321554:
                if (str.equals("paused")) {
                    c = 2;
                    break;
                }
                break;
            case -902265988:
                if (str.equals("singer")) {
                    c = '\b';
                    break;
                }
                break;
            case -453814973:
                if (str.equals("coverImgUrl")) {
                    c = '\t';
                    break;
                }
                break;
            case 114148:
                if (str.equals(UserAccountActionItem.KEY_SRC)) {
                    c = 3;
                    break;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    c = 6;
                    break;
                }
                break;
            case 601235430:
                if (str.equals("currentTime")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Integer.valueOf(getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.bBf.mUrl;
            case 4:
                return Integer.valueOf(this.bBf.bAC);
            case 5:
                return Integer.valueOf(this.bBg);
            case 6:
                return this.bBf.mTitle;
            case 7:
                return this.bBf.bAA;
            case '\b':
                return this.bBf.bAB;
            case '\t':
                return this.bBf.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xm() {
        SwanAppConfigData acL = e.acF() != null ? e.acF().acL() : null;
        return acL != null && acL.bPN.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xn() {
        if (e.acF() != null && e.acF().GE() != null && bBh != null) {
            b.a GE = e.acF().GE();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(GE.getAppFrameType());
            fVar.mAppId = GE.getAppId();
            fVar.mSource = GE.VJ();
            fVar.n("appid", GE.getAppId());
            fVar.n("cuid", com.baidu.swan.apps.w.a.Ub().br(com.baidu.swan.apps.w.a.TW()));
            JSONObject lI = com.baidu.swan.apps.statistic.f.lI(GE.VL());
            if (lI != null) {
                fVar.n("keyfeed", lI.optString("keyfeed"));
            }
            com.baidu.swan.apps.statistic.f.a(bBh, fVar);
        }
        bBh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentProgress() {
        int duration = getDuration();
        if (duration <= 0) {
            return 0;
        }
        return (int) ((getCurrentPosition() / duration) * 100.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements c.a {
        private boolean bBk;

        private a() {
        }

        @Override // com.baidu.swan.apps.media.audio.c.a
        public boolean m(Message message) {
            int i = message.what;
            int i2 = message.arg1;
            int i3 = message.arg2;
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1001:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onCanPlay");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc("onCanplay");
                    }
                    this.bBk = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        Flow unused = d.bBh = com.baidu.swan.apps.statistic.f.lH("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.Xn();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc(MissionEvent.MESSAGE_STOP);
                    }
                    this.bBk = true;
                    if (d.this.mIsBackground) {
                        d.this.Xn();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.Xn();
                        return true;
                    }
                    return true;
                case 1006:
                    d.this.mCurrentPosition = i3;
                    try {
                        jSONObject.putOpt("currentTime", Integer.valueOf(d.this.getCurrentPosition()));
                        jSONObject.putOpt("duration", Integer.valueOf(d.this.getDuration() / 1000));
                    } catch (JSONException e) {
                        if (d.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                    if (d.this.bAX != null) {
                        d.this.bAX.d("onTimeUpdate", jSONObject);
                    }
                    if (this.bBk) {
                        d.this.seekTo(d.this.bBf.bAC);
                        this.bBk = false;
                        return true;
                    }
                    return true;
                case 1007:
                    try {
                        jSONObject.putOpt(TiebaInitialize.LogFields.ERROR_CODE, Integer.valueOf(i2));
                    } catch (JSONException e2) {
                        if (d.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onError code:" + i2);
                    if (d.this.bAX != null) {
                        d.this.bAX.d("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.bBg = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.bBg);
                    if (d.this.bAX == null || currentProgress < d.this.bBg) {
                        return true;
                    }
                    d.this.bAX.jc("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.bAX != null) {
                        d.this.bAX.jc("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
