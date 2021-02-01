package com.baidu.swan.apps.media.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.c;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.i.n;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a djc;
    private com.baidu.swan.apps.media.audio.b.a diS;
    private c diZ;
    @Nullable
    private com.baidu.swan.apps.v.a djd;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a dja = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int djb = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.diZ != null) {
            this.diZ.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.diZ != null) {
                this.diZ.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.diS != null) {
                this.diS.px("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.diZ != null) {
            this.diZ.stop();
        }
        if (this.djd != null) {
            com.baidu.swan.apps.t.a.awW().unregisterActivityLifecycleCallbacks(this.djd);
            this.djd = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.diZ != null && !aAQ()) {
            this.diZ.release();
            f.aAl().azM();
            this.diZ = null;
            djc = null;
        }
    }

    public int getDuration() {
        if (this.diZ != null) {
            return this.diZ.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.diZ == null || !this.diZ.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aAN() {
        if (this.diZ == null) {
            this.diZ = new c(this.mContext);
            this.diZ.a(new a());
        }
        return this.diZ;
    }

    public com.baidu.swan.apps.media.audio.a aAO() {
        return this.dja;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.dja = aVar;
        if (this.dja.diy != null) {
            try {
                this.diS = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dja.diy));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void aAP() {
        if (this.djd != null) {
            com.baidu.swan.apps.t.a.awW().unregisterActivityLifecycleCallbacks(this.djd);
        }
        this.djd = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aAQ()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.djc = null;
                        return;
                    } else if (d.djc == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.djc = h.sI("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                d.this.stop();
                com.baidu.swan.apps.console.c.w("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                d.this.mIsBackground = false;
                if (!d.this.isPaused()) {
                    d.this.aAR();
                }
            }
        };
        com.baidu.swan.apps.t.a.awW().registerActivityLifecycleCallbacks(this.djd);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.dja.aAH()) {
            aAP();
            String str = this.dja.mUrl;
            e aIK = e.aIK();
            if (com.baidu.swan.apps.storage.b.te(str) == PathType.CLOUD) {
                ps(str);
            } else {
                b(str, aIK);
            }
            f.aAl().azL();
        }
    }

    private void ps(String str) {
        com.baidu.swan.apps.t.a.axp().a(this.mContext, str, new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: onCallback */
            public void L(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.aAN().bV(d.this.dja.pr(str2), str2);
                }
            }
        });
    }

    private void b(String str, e eVar) {
        String c;
        if (this.dja.diz && eVar != null) {
            if (this.diS.aAU()) {
                c = n.tm(str);
            } else {
                c = com.baidu.swan.apps.storage.b.c(str, eVar);
            }
            str = c;
        }
        aAN().bV(this.dja.pr(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.diZ != null) {
            this.diZ.resume();
        }
    }

    public void fX(boolean z) {
        if (this.diZ != null) {
            this.diZ.fX(z);
            f.aAl().azL();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.dja = aVar;
        if (this.diS != null) {
            this.diS.pw(this.dja.diy);
        }
        play();
    }

    public Object pt(String str) {
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
            case -1094703982:
                if (str.equals("lrcURL")) {
                    c = '\n';
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
                return this.dja.mUrl;
            case 4:
                return Integer.valueOf(this.dja.diw);
            case 5:
                return Integer.valueOf(this.djb);
            case 6:
                return this.dja.mTitle;
            case 7:
                return this.dja.dit;
            case '\b':
                return this.dja.diu;
            case '\t':
                return this.dja.mCoverUrl;
            case '\n':
                return this.dja.div;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAQ() {
        SwanAppConfigData aIT = e.aIK() != null ? e.aIK().aIT() : null;
        return aIT != null && aIT.dFd.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAR() {
        if (e.aIK() != null && e.aIK().afZ() != null && djc != null) {
            b.a afZ = e.aIK().afZ();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ju(afZ.getAppFrameType());
            fVar.mAppId = afZ.getAppId();
            fVar.mSource = afZ.aza();
            fVar.r("appid", afZ.getAppId());
            fVar.r("cuid", com.baidu.swan.apps.t.a.axb().cb(com.baidu.swan.apps.t.a.awW()));
            JSONObject sK = h.sK(afZ.azc());
            if (sK != null) {
                fVar.r("keyfeed", sK.optString("keyfeed"));
            }
            h.a(djc, fVar);
        }
        djc = null;
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
    /* loaded from: classes9.dex */
    public class a implements c.a {
        private boolean djf;

        private a() {
        }

        @Override // com.baidu.swan.apps.media.audio.c.a
        public boolean l(Message message) {
            int i = message.what;
            int i2 = message.arg1;
            int i3 = message.arg2;
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1001:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onCanPlay");
                    if (d.this.diS != null) {
                        d.this.diS.px("onCanplay");
                    }
                    this.djf = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.diS != null) {
                        d.this.diS.px("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.djc = h.sI("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.diS != null) {
                        d.this.diS.px(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAR();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.diS != null) {
                        d.this.diS.px(MissionEvent.MESSAGE_STOP);
                    }
                    this.djf = true;
                    if (d.this.mIsBackground) {
                        d.this.aAR();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.diS != null) {
                        d.this.diS.px("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAR();
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
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                    if (d.this.diS != null) {
                        d.this.diS.h("onTimeUpdate", jSONObject);
                    }
                    if (this.djf) {
                        if (d.this.dja.diw > 0) {
                            d.this.seekTo(d.this.dja.diw);
                        }
                        this.djf = false;
                        return true;
                    }
                    return true;
                case 1007:
                    try {
                        jSONObject.putOpt("errCode", Integer.valueOf(i2));
                    } catch (JSONException e2) {
                        if (d.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onError code:" + i2);
                    if (d.this.diS != null) {
                        d.this.diS.h("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.djb = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.djb);
                    if (d.this.diS == null || currentProgress < d.this.djb) {
                        return true;
                    }
                    d.this.diS.px("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.diS != null) {
                        d.this.diS.px("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.diS != null) {
                        d.this.diS.px("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.diS != null) {
                        d.this.diS.px("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.diS != null) {
                        d.this.diS.px("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
