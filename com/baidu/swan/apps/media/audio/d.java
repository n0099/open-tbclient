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
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a dbt;
    private com.baidu.swan.apps.media.audio.b.a dbj;
    private c dbq;
    @Nullable
    private com.baidu.swan.apps.v.a dbu;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a dbr = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int dbs = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.dbq != null) {
            this.dbq.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.dbq != null) {
                this.dbq.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.dbj != null) {
                this.dbj.pW("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.dbq != null) {
            this.dbq.stop();
        }
        if (this.dbu != null) {
            com.baidu.swan.apps.t.a.awA().unregisterActivityLifecycleCallbacks(this.dbu);
            this.dbu = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.dbq != null && !aAt()) {
            this.dbq.release();
            f.azO().azp();
            this.dbq = null;
            dbt = null;
        }
    }

    public int getDuration() {
        if (this.dbq != null) {
            return this.dbq.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.dbq == null || !this.dbq.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aAq() {
        if (this.dbq == null) {
            this.dbq = new c(this.mContext);
            this.dbq.a(new a());
        }
        return this.dbq;
    }

    public com.baidu.swan.apps.media.audio.a aAr() {
        return this.dbr;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.dbr = aVar;
        if (this.dbr.daQ != null) {
            try {
                this.dbj = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dbr.daQ));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void aAs() {
        if (this.dbu != null) {
            com.baidu.swan.apps.t.a.awA().unregisterActivityLifecycleCallbacks(this.dbu);
        }
        this.dbu = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aAt()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.dbt = null;
                        return;
                    } else if (d.dbt == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.dbt = h.tb("1044");
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
                    d.this.aAu();
                }
            }
        };
        com.baidu.swan.apps.t.a.awA().registerActivityLifecycleCallbacks(this.dbu);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.dbr.aAk()) {
            aAs();
            String str = this.dbr.mUrl;
            e aHu = e.aHu();
            if (com.baidu.swan.apps.storage.b.tx(str) == PathType.CLOUD) {
                pR(str);
            } else {
                c(str, aHu);
            }
            f.azO().azo();
        }
    }

    private void pR(String str) {
        com.baidu.swan.apps.t.a.awT().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void M(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.aAq().bX(d.this.dbr.pQ(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.dbr.daR && eVar != null) {
            if (this.dbj.aAw()) {
                d = n.tF(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        aAq().bX(this.dbr.pQ(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.dbq != null) {
            this.dbq.resume();
        }
    }

    public void fy(boolean z) {
        if (this.dbq != null) {
            this.dbq.fy(z);
            f.azO().azo();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.dbr = aVar;
        if (this.dbj != null) {
            this.dbj.pV(this.dbr.daQ);
        }
        play();
    }

    public Object pS(String str) {
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
                return this.dbr.mUrl;
            case 4:
                return Integer.valueOf(this.dbr.daO);
            case 5:
                return Integer.valueOf(this.dbs);
            case 6:
                return this.dbr.mTitle;
            case 7:
                return this.dbr.daL;
            case '\b':
                return this.dbr.daM;
            case '\t':
                return this.dbr.mCoverUrl;
            case '\n':
                return this.dbr.daN;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAt() {
        SwanAppConfigData aHD = e.aHu() != null ? e.aHu().aHD() : null;
        return aHD != null && aHD.dtO.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAu() {
        if (e.aHu() != null && e.aHu().afO() != null && dbt != null) {
            b.a afO = e.aHu().afO();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ky(afO.getAppFrameType());
            fVar.mAppId = afO.getAppId();
            fVar.mSource = afO.ayD();
            fVar.u("appid", afO.getAppId());
            fVar.u("cuid", com.baidu.swan.apps.t.a.awF().bq(com.baidu.swan.apps.t.a.awA()));
            JSONObject td = h.td(afO.ayF());
            if (td != null) {
                fVar.u("keyfeed", td.optString("keyfeed"));
            }
            h.a(dbt, fVar);
        }
        dbt = null;
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
    /* loaded from: classes10.dex */
    public class a implements c.a {
        private boolean dbw;

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
                    if (d.this.dbj != null) {
                        d.this.dbj.pW("onCanplay");
                    }
                    this.dbw = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.dbt = h.tb("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAu();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW(MissionEvent.MESSAGE_STOP);
                    }
                    this.dbw = true;
                    if (d.this.mIsBackground) {
                        d.this.aAu();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAu();
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
                    if (d.this.dbj != null) {
                        d.this.dbj.g("onTimeUpdate", jSONObject);
                    }
                    if (this.dbw) {
                        if (d.this.dbr.daO > 0) {
                            d.this.seekTo(d.this.dbr.daO);
                        }
                        this.dbw = false;
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
                    if (d.this.dbj != null) {
                        d.this.dbj.g("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.dbs = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.dbs);
                    if (d.this.dbj == null || currentProgress < d.this.dbs) {
                        return true;
                    }
                    d.this.dbj.pW("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.dbj != null) {
                        d.this.dbj.pW("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
