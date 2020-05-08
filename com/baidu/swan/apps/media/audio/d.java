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
    private static Flow bZG;
    private c bZD;
    @Nullable
    private com.baidu.swan.apps.y.a bZH;
    private com.baidu.swan.apps.media.audio.b.a bZw;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a bZE = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int bZF = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.bZD != null) {
            this.bZD.pause();
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            if (this.bZD != null) {
                this.bZD.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.bZw != null) {
                this.bZw.ko("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.bZD != null) {
            this.bZD.stop();
        }
        if (this.bZH != null) {
            com.baidu.swan.apps.w.a.abN().unregisterActivityLifecycleCallbacks(this.bZH);
            this.bZH = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.bZD != null && !aff()) {
            this.bZD.release();
            f.aeJ().ael();
            this.bZD = null;
            bZG = null;
        }
    }

    public int getDuration() {
        if (this.bZD != null) {
            return this.bZD.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.bZD == null || !this.bZD.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c afc() {
        if (this.bZD == null) {
            this.bZD = new c(this.mContext);
            this.bZD.a(new a());
        }
        return this.bZD;
    }

    public com.baidu.swan.apps.media.audio.a afd() {
        return this.bZE;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.bZE = aVar;
        if (this.bZE.bZd != null) {
            try {
                this.bZw = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bZE.bZd));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void afe() {
        if (this.bZH != null) {
            com.baidu.swan.apps.w.a.abN().unregisterActivityLifecycleCallbacks(this.bZH);
        }
        this.bZH = new com.baidu.swan.apps.y.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aff()) {
                    if (d.this.isPaused()) {
                        Flow unused = d.bZG = null;
                        return;
                    } else if (d.bZG == null) {
                        Flow unused2 = d.bZG = com.baidu.swan.apps.statistic.f.mT("1044");
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
                    d.this.afg();
                }
            }
        };
        com.baidu.swan.apps.w.a.abN().registerActivityLifecycleCallbacks(this.bZH);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.bZE.aeW()) {
            afe();
            String str = this.bZE.mUrl;
            e akM = e.akM();
            if (com.baidu.swan.apps.storage.b.nm(str) == PathType.CLOUD) {
                kj(str);
            } else {
                c(str, akM);
            }
            f.aeJ().aek();
        }
    }

    private void kj(String str) {
        com.baidu.swan.apps.w.a.ach().a(this.mContext, str, new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void F(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.afc().bd(d.this.bZE.ki(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.bZE.bZe && eVar != null) {
            if (this.bZw.afj()) {
                d = l.ns(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        afc().bd(this.bZE.ki(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.bZD != null) {
            this.bZD.resume();
        }
    }

    public void dN(boolean z) {
        if (this.bZD != null) {
            this.bZD.dN(z);
            f.aeJ().aek();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.bZE = aVar;
        if (this.bZw != null) {
            this.bZw.kn(this.bZE.bZd);
        }
        play();
    }

    public Object kk(String str) {
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
                return this.bZE.mUrl;
            case 4:
                return Integer.valueOf(this.bZE.bZb);
            case 5:
                return Integer.valueOf(this.bZF);
            case 6:
                return this.bZE.mTitle;
            case 7:
                return this.bZE.bYZ;
            case '\b':
                return this.bZE.bZa;
            case '\t':
                return this.bZE.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aff() {
        SwanAppConfigData akS = e.akM() != null ? e.akM().akS() : null;
        return akS != null && akS.coR.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afg() {
        if (e.akM() != null && e.akM().Ov() != null && bZG != null) {
            b.a Ov = e.akM().Ov();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Ov.getAppFrameType());
            fVar.mAppId = Ov.getAppId();
            fVar.mSource = Ov.adA();
            fVar.s("appid", Ov.getAppId());
            fVar.s("cuid", com.baidu.swan.apps.w.a.abS().aS(com.baidu.swan.apps.w.a.abN()));
            JSONObject mU = com.baidu.swan.apps.statistic.f.mU(Ov.adC());
            if (mU != null) {
                fVar.s("keyfeed", mU.optString("keyfeed"));
            }
            com.baidu.swan.apps.statistic.f.a(bZG, fVar);
        }
        bZG = null;
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
        private boolean bZJ;

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
                    if (d.this.bZw != null) {
                        d.this.bZw.ko("onCanplay");
                    }
                    this.bZJ = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        Flow unused = d.bZG = com.baidu.swan.apps.statistic.f.mT("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.afg();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko(MissionEvent.MESSAGE_STOP);
                    }
                    this.bZJ = true;
                    if (d.this.mIsBackground) {
                        d.this.afg();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.afg();
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
                    if (d.this.bZw != null) {
                        d.this.bZw.e("onTimeUpdate", jSONObject);
                    }
                    if (this.bZJ) {
                        d.this.seekTo(d.this.bZE.bZb);
                        this.bZJ = false;
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
                    if (d.this.bZw != null) {
                        d.this.bZw.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.bZF = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.bZF);
                    if (d.this.bZw == null || currentProgress < d.this.bZF) {
                        return true;
                    }
                    d.this.bZw.ko("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.bZw != null) {
                        d.this.bZw.ko("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
