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
    private static Flow bZA;
    @Nullable
    private com.baidu.swan.apps.y.a bZB;
    private com.baidu.swan.apps.media.audio.b.a bZq;
    private c bZx;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a bZy = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int bZz = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.bZx != null) {
            this.bZx.pause();
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            if (this.bZx != null) {
                this.bZx.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.bZq != null) {
                this.bZq.ko("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.bZx != null) {
            this.bZx.stop();
        }
        if (this.bZB != null) {
            com.baidu.swan.apps.w.a.abO().unregisterActivityLifecycleCallbacks(this.bZB);
            this.bZB = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.bZx != null && !afg()) {
            this.bZx.release();
            f.aeK().aem();
            this.bZx = null;
            bZA = null;
        }
    }

    public int getDuration() {
        if (this.bZx != null) {
            return this.bZx.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.bZx == null || !this.bZx.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c afd() {
        if (this.bZx == null) {
            this.bZx = new c(this.mContext);
            this.bZx.a(new a());
        }
        return this.bZx;
    }

    public com.baidu.swan.apps.media.audio.a afe() {
        return this.bZy;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.bZy = aVar;
        if (this.bZy.bYX != null) {
            try {
                this.bZq = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bZy.bYX));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void aff() {
        if (this.bZB != null) {
            com.baidu.swan.apps.w.a.abO().unregisterActivityLifecycleCallbacks(this.bZB);
        }
        this.bZB = new com.baidu.swan.apps.y.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.afg()) {
                    if (d.this.isPaused()) {
                        Flow unused = d.bZA = null;
                        return;
                    } else if (d.bZA == null) {
                        Flow unused2 = d.bZA = com.baidu.swan.apps.statistic.f.mT("1044");
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
                    d.this.afh();
                }
            }
        };
        com.baidu.swan.apps.w.a.abO().registerActivityLifecycleCallbacks(this.bZB);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.bZy.aeX()) {
            aff();
            String str = this.bZy.mUrl;
            e akN = e.akN();
            if (com.baidu.swan.apps.storage.b.nm(str) == PathType.CLOUD) {
                kj(str);
            } else {
                c(str, akN);
            }
            f.aeK().ael();
        }
    }

    private void kj(String str) {
        com.baidu.swan.apps.w.a.aci().a(this.mContext, str, new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void E(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.afd().bd(d.this.bZy.ki(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.bZy.bYY && eVar != null) {
            if (this.bZq.afk()) {
                d = l.ns(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        afd().bd(this.bZy.ki(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.bZx != null) {
            this.bZx.resume();
        }
    }

    public void dN(boolean z) {
        if (this.bZx != null) {
            this.bZx.dN(z);
            f.aeK().ael();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.bZy = aVar;
        if (this.bZq != null) {
            this.bZq.kn(this.bZy.bYX);
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
                return this.bZy.mUrl;
            case 4:
                return Integer.valueOf(this.bZy.bYV);
            case 5:
                return Integer.valueOf(this.bZz);
            case 6:
                return this.bZy.mTitle;
            case 7:
                return this.bZy.bYT;
            case '\b':
                return this.bZy.bYU;
            case '\t':
                return this.bZy.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afg() {
        SwanAppConfigData akT = e.akN() != null ? e.akN().akT() : null;
        return akT != null && akT.coL.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (e.akN() != null && e.akN().Ow() != null && bZA != null) {
            b.a Ow = e.akN().Ow();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Ow.getAppFrameType());
            fVar.mAppId = Ow.getAppId();
            fVar.mSource = Ow.adB();
            fVar.s("appid", Ow.getAppId());
            fVar.s("cuid", com.baidu.swan.apps.w.a.abT().be(com.baidu.swan.apps.w.a.abO()));
            JSONObject mU = com.baidu.swan.apps.statistic.f.mU(Ow.adD());
            if (mU != null) {
                fVar.s("keyfeed", mU.optString("keyfeed"));
            }
            com.baidu.swan.apps.statistic.f.a(bZA, fVar);
        }
        bZA = null;
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
        private boolean bZD;

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
                    if (d.this.bZq != null) {
                        d.this.bZq.ko("onCanplay");
                    }
                    this.bZD = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        Flow unused = d.bZA = com.baidu.swan.apps.statistic.f.mT("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.afh();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko(MissionEvent.MESSAGE_STOP);
                    }
                    this.bZD = true;
                    if (d.this.mIsBackground) {
                        d.this.afh();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.afh();
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
                    if (d.this.bZq != null) {
                        d.this.bZq.e("onTimeUpdate", jSONObject);
                    }
                    if (this.bZD) {
                        d.this.seekTo(d.this.bZy.bYV);
                        this.bZD = false;
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
                    if (d.this.bZq != null) {
                        d.this.bZq.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.bZz = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.bZz);
                    if (d.this.bZq == null || currentProgress < d.this.bZz) {
                        return true;
                    }
                    d.this.bZq.ko("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.bZq != null) {
                        d.this.bZq.ko("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
