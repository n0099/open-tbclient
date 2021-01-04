package com.baidu.swan.apps.media.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
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
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a dlD;
    private c dlA;
    @Nullable
    private com.baidu.swan.apps.v.a dlE;
    private com.baidu.swan.apps.media.audio.b.a dlt;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a dlB = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int dlC = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.dlA != null) {
            this.dlA.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.dlA != null) {
                this.dlA.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.dlt != null) {
                this.dlt.qq("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.dlA != null) {
            this.dlA.stop();
        }
        if (this.dlE != null) {
            com.baidu.swan.apps.t.a.aAr().unregisterActivityLifecycleCallbacks(this.dlE);
            this.dlE = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.dlA != null && !aEl()) {
            this.dlA.release();
            f.aDG().aDh();
            this.dlA = null;
            dlD = null;
        }
    }

    public int getDuration() {
        if (this.dlA != null) {
            return this.dlA.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.dlA == null || !this.dlA.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aEi() {
        if (this.dlA == null) {
            this.dlA = new c(this.mContext);
            this.dlA.a(new a());
        }
        return this.dlA;
    }

    public com.baidu.swan.apps.media.audio.a aEj() {
        return this.dlB;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.dlB = aVar;
        if (this.dlB.dkZ != null) {
            try {
                this.dlt = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dlB.dkZ));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void aEk() {
        if (this.dlE != null) {
            com.baidu.swan.apps.t.a.aAr().unregisterActivityLifecycleCallbacks(this.dlE);
        }
        this.dlE = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aEl()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.dlD = null;
                        return;
                    } else if (d.dlD == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.dlD = h.tA("1044");
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
                    d.this.aEm();
                }
            }
        };
        com.baidu.swan.apps.t.a.aAr().registerActivityLifecycleCallbacks(this.dlE);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.dlB.aEc()) {
            aEk();
            String str = this.dlB.mUrl;
            e aMk = e.aMk();
            if (com.baidu.swan.apps.storage.b.tW(str) == PathType.CLOUD) {
                ql(str);
            } else {
                b(str, aMk);
            }
            f.aDG().aDg();
        }
    }

    private void ql(String str) {
        com.baidu.swan.apps.t.a.aAK().a(this.mContext, str, new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: onCallback */
            public void L(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.aEi().cc(d.this.dlB.qk(str2), str2);
                }
            }
        });
    }

    private void b(String str, e eVar) {
        String c;
        if (this.dlB.dla && eVar != null) {
            if (this.dlt.aEp()) {
                c = n.ue(str);
            } else {
                c = com.baidu.swan.apps.storage.b.c(str, eVar);
            }
            str = c;
        }
        aEi().cc(this.dlB.qk(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.dlA != null) {
            this.dlA.resume();
        }
    }

    public void fZ(boolean z) {
        if (this.dlA != null) {
            this.dlA.fZ(z);
            f.aDG().aDg();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.dlB = aVar;
        if (this.dlt != null) {
            this.dlt.qp(this.dlB.dkZ);
        }
        play();
    }

    public Object qm(String str) {
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
                return this.dlB.mUrl;
            case 4:
                return Integer.valueOf(this.dlB.dkX);
            case 5:
                return Integer.valueOf(this.dlC);
            case 6:
                return this.dlB.mTitle;
            case 7:
                return this.dlB.dkU;
            case '\b':
                return this.dlB.dkV;
            case '\t':
                return this.dlB.mCoverUrl;
            case '\n':
                return this.dlB.dkW;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEl() {
        SwanAppConfigData aMt = e.aMk() != null ? e.aMk().aMt() : null;
        return aMt != null && aMt.dHL.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEm() {
        if (e.aMk() != null && e.aMk().aju() != null && dlD != null) {
            b.a aju = e.aMk().aju();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.kX(aju.getAppFrameType());
            fVar.mAppId = aju.getAppId();
            fVar.mSource = aju.aCv();
            fVar.t("appid", aju.getAppId());
            fVar.t("cuid", com.baidu.swan.apps.t.a.aAw().cd(com.baidu.swan.apps.t.a.aAr()));
            JSONObject tC = h.tC(aju.aCx());
            if (tC != null) {
                fVar.t("keyfeed", tC.optString("keyfeed"));
            }
            h.a(dlD, fVar);
        }
        dlD = null;
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
        private boolean dlG;

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
                    if (d.this.dlt != null) {
                        d.this.dlt.qq("onCanplay");
                    }
                    this.dlG = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.dlD = h.tA("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.aEm();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq(MissionEvent.MESSAGE_STOP);
                    }
                    this.dlG = true;
                    if (d.this.mIsBackground) {
                        d.this.aEm();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.aEm();
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
                    if (d.this.dlt != null) {
                        d.this.dlt.h("onTimeUpdate", jSONObject);
                    }
                    if (this.dlG) {
                        if (d.this.dlB.dkX > 0) {
                            d.this.seekTo(d.this.dlB.dkX);
                        }
                        this.dlG = false;
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
                    if (d.this.dlt != null) {
                        d.this.dlt.h("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.dlC = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.dlC);
                    if (d.this.dlt == null || currentProgress < d.this.dlC) {
                        return true;
                    }
                    d.this.dlt.qq("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.dlt != null) {
                        d.this.dlt.qq("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
