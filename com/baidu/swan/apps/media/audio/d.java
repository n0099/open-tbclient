package com.baidu.swan.apps.media.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
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
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a cZJ;
    private c cZG;
    @Nullable
    private com.baidu.swan.apps.v.a cZK;
    private com.baidu.swan.apps.media.audio.b.a cZz;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a cZH = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int cZI = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.cZG != null) {
            this.cZG.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.cZG != null) {
                this.cZG.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.cZz != null) {
                this.cZz.pQ("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.cZG != null) {
            this.cZG.stop();
        }
        if (this.cZK != null) {
            com.baidu.swan.apps.t.a.avS().unregisterActivityLifecycleCallbacks(this.cZK);
            this.cZK = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.cZG != null && !azL()) {
            this.cZG.release();
            f.azg().ayH();
            this.cZG = null;
            cZJ = null;
        }
    }

    public int getDuration() {
        if (this.cZG != null) {
            return this.cZG.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.cZG == null || !this.cZG.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c azI() {
        if (this.cZG == null) {
            this.cZG = new c(this.mContext);
            this.cZG.a(new a());
        }
        return this.cZG;
    }

    public com.baidu.swan.apps.media.audio.a azJ() {
        return this.cZH;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.cZH = aVar;
        if (this.cZH.cZg != null) {
            try {
                this.cZz = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cZH.cZg));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void azK() {
        if (this.cZK != null) {
            com.baidu.swan.apps.t.a.avS().unregisterActivityLifecycleCallbacks(this.cZK);
        }
        this.cZK = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.azL()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.cZJ = null;
                        return;
                    } else if (d.cZJ == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.cZJ = h.sW("1044");
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
                    d.this.azM();
                }
            }
        };
        com.baidu.swan.apps.t.a.avS().registerActivityLifecycleCallbacks(this.cZK);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.cZH.azC()) {
            azK();
            String str = this.cZH.mUrl;
            e aGM = e.aGM();
            if (com.baidu.swan.apps.storage.b.ts(str) == PathType.CLOUD) {
                pL(str);
            } else {
                c(str, aGM);
            }
            f.azg().ayG();
        }
    }

    private void pL(String str) {
        com.baidu.swan.apps.t.a.awl().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void M(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.azI().bW(d.this.cZH.pK(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.cZH.cZh && eVar != null) {
            if (this.cZz.azO()) {
                d = n.tA(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        azI().bW(this.cZH.pK(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.cZG != null) {
            this.cZG.resume();
        }
    }

    public void fB(boolean z) {
        if (this.cZG != null) {
            this.cZG.fB(z);
            f.azg().ayG();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.cZH = aVar;
        if (this.cZz != null) {
            this.cZz.pP(this.cZH.cZg);
        }
        play();
    }

    public Object pM(String str) {
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
                if (str.equals("src")) {
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
                return this.cZH.mUrl;
            case 4:
                return Integer.valueOf(this.cZH.cZe);
            case 5:
                return Integer.valueOf(this.cZI);
            case 6:
                return this.cZH.mTitle;
            case 7:
                return this.cZH.cZb;
            case '\b':
                return this.cZH.cZc;
            case '\t':
                return this.cZH.mCoverUrl;
            case '\n':
                return this.cZH.cZd;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azL() {
        SwanAppConfigData aGV = e.aGM() != null ? e.aGM().aGV() : null;
        return aGV != null && aGV.dsf.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azM() {
        if (e.aGM() != null && e.aGM().afg() != null && cZJ != null) {
            b.a afg = e.aGM().afg();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ku(afg.getAppFrameType());
            fVar.mAppId = afg.getAppId();
            fVar.mSource = afg.axV();
            fVar.u("appid", afg.getAppId());
            fVar.u("cuid", com.baidu.swan.apps.t.a.avX().bq(com.baidu.swan.apps.t.a.avS()));
            JSONObject sY = h.sY(afg.axX());
            if (sY != null) {
                fVar.u("keyfeed", sY.optString("keyfeed"));
            }
            h.a(cZJ, fVar);
        }
        cZJ = null;
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
    /* loaded from: classes7.dex */
    public class a implements c.a {
        private boolean cZM;

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
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ("onCanplay");
                    }
                    this.cZM = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.cZJ = h.sW("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.azM();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ(MissionEvent.MESSAGE_STOP);
                    }
                    this.cZM = true;
                    if (d.this.mIsBackground) {
                        d.this.azM();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.azM();
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
                    if (d.this.cZz != null) {
                        d.this.cZz.g("onTimeUpdate", jSONObject);
                    }
                    if (this.cZM) {
                        if (d.this.cZH.cZe > 0) {
                            d.this.seekTo(d.this.cZH.cZe);
                        }
                        this.cZM = false;
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
                    if (d.this.cZz != null) {
                        d.this.cZz.g("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.cZI = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.cZI);
                    if (d.this.cZz == null || currentProgress < d.this.cZI) {
                        return true;
                    }
                    d.this.cZz.pQ("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.cZz != null) {
                        d.this.cZz.pQ("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
