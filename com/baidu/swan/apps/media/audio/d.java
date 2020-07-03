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
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.i.n;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a coY;
    private com.baidu.swan.apps.media.audio.b.a coO;
    private c coV;
    @Nullable
    private com.baidu.swan.apps.w.a coZ;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a coW = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int coX = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.coV != null) {
            this.coV.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.coV != null) {
                this.coV.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.coO != null) {
                this.coO.lJ("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.coV != null) {
            this.coV.stop();
        }
        if (this.coZ != null) {
            com.baidu.swan.apps.u.a.afX().unregisterActivityLifecycleCallbacks(this.coZ);
            this.coZ = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.coV != null && !ajA()) {
            this.coV.release();
            f.ajb().aiC();
            this.coV = null;
            coY = null;
        }
    }

    public int getDuration() {
        if (this.coV != null) {
            return this.coV.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.coV == null || !this.coV.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ajx() {
        if (this.coV == null) {
            this.coV = new c(this.mContext);
            this.coV.a(new a());
        }
        return this.coV;
    }

    public com.baidu.swan.apps.media.audio.a ajy() {
        return this.coW;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.coW = aVar;
        if (this.coW.cov != null) {
            try {
                this.coO = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.coW.cov));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void ajz() {
        if (this.coZ != null) {
            com.baidu.swan.apps.u.a.afX().unregisterActivityLifecycleCallbacks(this.coZ);
        }
        this.coZ = new com.baidu.swan.apps.w.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.ajA()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.coY = null;
                        return;
                    } else if (d.coY == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.coY = h.oE("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                d.this.stop();
                com.baidu.swan.apps.console.c.w("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }

            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                d.this.mIsBackground = false;
                if (!d.this.isPaused()) {
                    d.this.ajB();
                }
            }
        };
        com.baidu.swan.apps.u.a.afX().registerActivityLifecycleCallbacks(this.coZ);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.coW.ajq()) {
            ajz();
            String str = this.coW.mUrl;
            e apM = e.apM();
            if (com.baidu.swan.apps.storage.b.oY(str) == PathType.CLOUD) {
                lE(str);
            } else {
                c(str, apM);
            }
            f.ajb().aiB();
        }
    }

    private void lE(String str) {
        com.baidu.swan.apps.u.a.agq().a(this.mContext, str, new com.baidu.swan.apps.aq.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: onCallback */
            public void H(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.ajx().bw(d.this.coW.lD(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.coW.cow && eVar != null) {
            if (this.coO.ajE()) {
                d = n.pg(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        ajx().bw(this.coW.lD(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.coV != null) {
            this.coV.resume();
        }
    }

    public void ej(boolean z) {
        if (this.coV != null) {
            this.coV.ej(z);
            f.ajb().aiB();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.coW = aVar;
        if (this.coO != null) {
            this.coO.lI(this.coW.cov);
        }
        play();
    }

    public Object lF(String str) {
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
                return this.coW.mUrl;
            case 4:
                return Integer.valueOf(this.coW.cot);
            case 5:
                return Integer.valueOf(this.coX);
            case 6:
                return this.coW.mTitle;
            case 7:
                return this.coW.coq;
            case '\b':
                return this.coW.cor;
            case '\t':
                return this.coW.mCoverUrl;
            case '\n':
                return this.coW.cos;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajA() {
        SwanAppConfigData apV = e.apM() != null ? e.apM().apV() : null;
        return apV != null && apV.cFp.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajB() {
        if (e.apM() != null && e.apM().RP() != null && coY != null) {
            b.a RP = e.apM().RP();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.hf(RP.getAppFrameType());
            fVar.mAppId = RP.getAppId();
            fVar.mSource = RP.ahQ();
            fVar.v("appid", RP.getAppId());
            fVar.v("cuid", com.baidu.swan.apps.u.a.agc().bd(com.baidu.swan.apps.u.a.afX()));
            JSONObject oF = h.oF(RP.ahS());
            if (oF != null) {
                fVar.v("keyfeed", oF.optString("keyfeed"));
            }
            h.a(coY, fVar);
        }
        coY = null;
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
        private boolean cpb;

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
                    if (d.this.coO != null) {
                        d.this.coO.lJ("onCanplay");
                    }
                    this.cpb = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.coO != null) {
                        d.this.coO.lJ("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.coY = h.oE("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.coO != null) {
                        d.this.coO.lJ(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.ajB();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.coO != null) {
                        d.this.coO.lJ(MissionEvent.MESSAGE_STOP);
                    }
                    this.cpb = true;
                    if (d.this.mIsBackground) {
                        d.this.ajB();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.coO != null) {
                        d.this.coO.lJ("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.ajB();
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
                    if (d.this.coO != null) {
                        d.this.coO.e("onTimeUpdate", jSONObject);
                    }
                    if (this.cpb) {
                        if (d.this.coW.cot > 0) {
                            d.this.seekTo(d.this.coW.cot);
                        }
                        this.cpb = false;
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
                    if (d.this.coO != null) {
                        d.this.coO.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.coX = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.coX);
                    if (d.this.coO == null || currentProgress < d.this.coX) {
                        return true;
                    }
                    d.this.coO.lJ("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.coO != null) {
                        d.this.coO.lJ("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.coO != null) {
                        d.this.coO.lJ("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.coO != null) {
                        d.this.coO.lJ("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.coO != null) {
                        d.this.coO.lJ("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
