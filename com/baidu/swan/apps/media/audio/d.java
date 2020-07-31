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
    private static com.baidu.swan.apps.statistic.a cre;
    private com.baidu.swan.apps.media.audio.b.a cqT;
    private c cra;
    @Nullable
    private com.baidu.swan.apps.v.a crf;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a crb = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int crd = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.cra != null) {
            this.cra.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.cra != null) {
                this.cra.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.cqT != null) {
                this.cqT.mk("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.cra != null) {
            this.cra.stop();
        }
        if (this.crf != null) {
            com.baidu.swan.apps.t.a.ahj().unregisterActivityLifecycleCallbacks(this.crf);
            this.crf = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.cra != null && !akQ()) {
            this.cra.release();
            f.akr().ajS();
            this.cra = null;
            cre = null;
        }
    }

    public int getDuration() {
        if (this.cra != null) {
            return this.cra.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.cra == null || !this.cra.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c akN() {
        if (this.cra == null) {
            this.cra = new c(this.mContext);
            this.cra.a(new a());
        }
        return this.cra;
    }

    public com.baidu.swan.apps.media.audio.a akO() {
        return this.crb;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.crb = aVar;
        if (this.crb.cqA != null) {
            try {
                this.cqT = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.crb.cqA));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void akP() {
        if (this.crf != null) {
            com.baidu.swan.apps.t.a.ahj().unregisterActivityLifecycleCallbacks(this.crf);
        }
        this.crf = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.akQ()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.cre = null;
                        return;
                    } else if (d.cre == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.cre = h.pn("1044");
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
                    d.this.akR();
                }
            }
        };
        com.baidu.swan.apps.t.a.ahj().registerActivityLifecycleCallbacks(this.crf);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.crb.akG()) {
            akP();
            String str = this.crb.mUrl;
            e arv = e.arv();
            if (com.baidu.swan.apps.storage.b.pJ(str) == PathType.CLOUD) {
                mf(str);
            } else {
                c(str, arv);
            }
            f.akr().ajR();
        }
    }

    private void mf(String str) {
        com.baidu.swan.apps.t.a.ahC().a(this.mContext, str, new com.baidu.swan.apps.aq.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: onCallback */
            public void H(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.akN().by(d.this.crb.me(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.crb.cqB && eVar != null) {
            if (this.cqT.akU()) {
                d = n.pR(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        akN().by(this.crb.me(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.cra != null) {
            this.cra.resume();
        }
    }

    public void er(boolean z) {
        if (this.cra != null) {
            this.cra.er(z);
            f.akr().ajR();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.crb = aVar;
        if (this.cqT != null) {
            this.cqT.mj(this.crb.cqA);
        }
        play();
    }

    public Object mg(String str) {
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
                return this.crb.mUrl;
            case 4:
                return Integer.valueOf(this.crb.cqy);
            case 5:
                return Integer.valueOf(this.crd);
            case 6:
                return this.crb.mTitle;
            case 7:
                return this.crb.cqv;
            case '\b':
                return this.crb.cqw;
            case '\t':
                return this.crb.mCoverUrl;
            case '\n':
                return this.crb.cqx;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akQ() {
        SwanAppConfigData arE = e.arv() != null ? e.arv().arE() : null;
        return arE != null && arE.cIg.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akR() {
        if (e.arv() != null && e.arv().Se() != null && cre != null) {
            b.a Se = e.arv().Se();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ho(Se.getAppFrameType());
            fVar.mAppId = Se.getAppId();
            fVar.mSource = Se.ajg();
            fVar.v("appid", Se.getAppId());
            fVar.v("cuid", com.baidu.swan.apps.t.a.aho().bf(com.baidu.swan.apps.t.a.ahj()));
            JSONObject pp = h.pp(Se.aji());
            if (pp != null) {
                fVar.v("keyfeed", pp.optString("keyfeed"));
            }
            h.a(cre, fVar);
        }
        cre = null;
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
        private boolean crh;

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
                    if (d.this.cqT != null) {
                        d.this.cqT.mk("onCanplay");
                    }
                    this.crh = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.cre = h.pn("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.akR();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk(MissionEvent.MESSAGE_STOP);
                    }
                    this.crh = true;
                    if (d.this.mIsBackground) {
                        d.this.akR();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.akR();
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
                    if (d.this.cqT != null) {
                        d.this.cqT.e("onTimeUpdate", jSONObject);
                    }
                    if (this.crh) {
                        if (d.this.crb.cqy > 0) {
                            d.this.seekTo(d.this.crb.cqy);
                        }
                        this.crh = false;
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
                    if (d.this.cqT != null) {
                        d.this.cqT.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.crd = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.crd);
                    if (d.this.cqT == null || currentProgress < d.this.crd) {
                        return true;
                    }
                    d.this.cqT.mk("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.cqT != null) {
                        d.this.cqT.mk("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
