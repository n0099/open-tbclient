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
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a dgO;
    private com.baidu.swan.apps.media.audio.b.a dgE;
    private c dgL;
    @Nullable
    private com.baidu.swan.apps.v.a dgP;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a dgM = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int dgN = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.dgL != null) {
            this.dgL.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.dgL != null) {
                this.dgL.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.dgE != null) {
                this.dgE.pf("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.dgL != null) {
            this.dgL.stop();
        }
        if (this.dgP != null) {
            com.baidu.swan.apps.t.a.awy().unregisterActivityLifecycleCallbacks(this.dgP);
            this.dgP = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.dgL != null && !aAs()) {
            this.dgL.release();
            f.azN().azo();
            this.dgL = null;
            dgO = null;
        }
    }

    public int getDuration() {
        if (this.dgL != null) {
            return this.dgL.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.dgL == null || !this.dgL.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aAp() {
        if (this.dgL == null) {
            this.dgL = new c(this.mContext);
            this.dgL.a(new a());
        }
        return this.dgL;
    }

    public com.baidu.swan.apps.media.audio.a aAq() {
        return this.dgM;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.dgM = aVar;
        if (this.dgM.dgk != null) {
            try {
                this.dgE = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dgM.dgk));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void aAr() {
        if (this.dgP != null) {
            com.baidu.swan.apps.t.a.awy().unregisterActivityLifecycleCallbacks(this.dgP);
        }
        this.dgP = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aAs()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.dgO = null;
                        return;
                    } else if (d.dgO == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.dgO = h.so("1044");
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
                    d.this.aAt();
                }
            }
        };
        com.baidu.swan.apps.t.a.awy().registerActivityLifecycleCallbacks(this.dgP);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.dgM.aAj()) {
            aAr();
            String str = this.dgM.mUrl;
            e aIr = e.aIr();
            if (com.baidu.swan.apps.storage.b.sL(str) == PathType.CLOUD) {
                pa(str);
            } else {
                b(str, aIr);
            }
            f.azN().azn();
        }
    }

    private void pa(String str) {
        com.baidu.swan.apps.t.a.awR().a(this.mContext, str, new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: onCallback */
            public void L(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.aAp().cb(d.this.dgM.oZ(str2), str2);
                }
            }
        });
    }

    private void b(String str, e eVar) {
        String c;
        if (this.dgM.dgl && eVar != null) {
            if (this.dgE.aAw()) {
                c = n.sT(str);
            } else {
                c = com.baidu.swan.apps.storage.b.c(str, eVar);
            }
            str = c;
        }
        aAp().cb(this.dgM.oZ(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.dgL != null) {
            this.dgL.resume();
        }
    }

    public void fV(boolean z) {
        if (this.dgL != null) {
            this.dgL.fV(z);
            f.azN().azn();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.dgM = aVar;
        if (this.dgE != null) {
            this.dgE.pe(this.dgM.dgk);
        }
        play();
    }

    public Object pb(String str) {
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
                return this.dgM.mUrl;
            case 4:
                return Integer.valueOf(this.dgM.dgi);
            case 5:
                return Integer.valueOf(this.dgN);
            case 6:
                return this.dgM.mTitle;
            case 7:
                return this.dgM.dgf;
            case '\b':
                return this.dgM.dgg;
            case '\t':
                return this.dgM.mCoverUrl;
            case '\n':
                return this.dgM.dgh;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAs() {
        SwanAppConfigData aIA = e.aIr() != null ? e.aIr().aIA() : null;
        return aIA != null && aIA.dCZ.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAt() {
        if (e.aIr() != null && e.aIr().afB() != null && dgO != null) {
            b.a afB = e.aIr().afB();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jr(afB.getAppFrameType());
            fVar.mAppId = afB.getAppId();
            fVar.mSource = afB.ayC();
            fVar.t("appid", afB.getAppId());
            fVar.t("cuid", com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy()));
            JSONObject sq = h.sq(afB.ayE());
            if (sq != null) {
                fVar.t("keyfeed", sq.optString("keyfeed"));
            }
            h.a(dgO, fVar);
        }
        dgO = null;
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
    /* loaded from: classes8.dex */
    public class a implements c.a {
        private boolean dgR;

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
                    if (d.this.dgE != null) {
                        d.this.dgE.pf("onCanplay");
                    }
                    this.dgR = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.dgO = h.so("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAt();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf(MissionEvent.MESSAGE_STOP);
                    }
                    this.dgR = true;
                    if (d.this.mIsBackground) {
                        d.this.aAt();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAt();
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
                    if (d.this.dgE != null) {
                        d.this.dgE.h("onTimeUpdate", jSONObject);
                    }
                    if (this.dgR) {
                        if (d.this.dgM.dgi > 0) {
                            d.this.seekTo(d.this.dgM.dgi);
                        }
                        this.dgR = false;
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
                    if (d.this.dgE != null) {
                        d.this.dgE.h("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.dgN = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.dgN);
                    if (d.this.dgE == null || currentProgress < d.this.dgN) {
                        return true;
                    }
                    d.this.dgE.pf("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.dgE != null) {
                        d.this.dgE.pf("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
