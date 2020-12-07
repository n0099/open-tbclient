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
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a dgJ;
    private c dgG;
    @Nullable
    private com.baidu.swan.apps.v.a dgK;
    private com.baidu.swan.apps.media.audio.b.a dgz;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a dgH = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int dgI = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.dgG != null) {
            this.dgG.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.dgG != null) {
                this.dgG.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.dgz != null) {
                this.dgz.qx("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.dgG != null) {
            this.dgG.stop();
        }
        if (this.dgK != null) {
            com.baidu.swan.apps.t.a.aza().unregisterActivityLifecycleCallbacks(this.dgK);
            this.dgK = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.dgG != null && !aCU()) {
            this.dgG.release();
            f.aCp().aBQ();
            this.dgG = null;
            dgJ = null;
        }
    }

    public int getDuration() {
        if (this.dgG != null) {
            return this.dgG.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.dgG == null || !this.dgG.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aCR() {
        if (this.dgG == null) {
            this.dgG = new c(this.mContext);
            this.dgG.a(new a());
        }
        return this.dgG;
    }

    public com.baidu.swan.apps.media.audio.a aCS() {
        return this.dgH;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.dgH = aVar;
        if (this.dgH.dgg != null) {
            try {
                this.dgz = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dgH.dgg));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void aCT() {
        if (this.dgK != null) {
            com.baidu.swan.apps.t.a.aza().unregisterActivityLifecycleCallbacks(this.dgK);
        }
        this.dgK = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aCU()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.dgJ = null;
                        return;
                    } else if (d.dgJ == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.dgJ = h.tD("1044");
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
                    d.this.aCV();
                }
            }
        };
        com.baidu.swan.apps.t.a.aza().registerActivityLifecycleCallbacks(this.dgK);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.dgH.aCL()) {
            aCT();
            String str = this.dgH.mUrl;
            e aJU = e.aJU();
            if (com.baidu.swan.apps.storage.b.tZ(str) == PathType.CLOUD) {
                qs(str);
            } else {
                c(str, aJU);
            }
            f.aCp().aBP();
        }
    }

    private void qs(String str) {
        com.baidu.swan.apps.t.a.azt().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void M(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.aCR().cd(d.this.dgH.qr(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.dgH.dgh && eVar != null) {
            if (this.dgz.aCX()) {
                d = n.uh(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        aCR().cd(this.dgH.qr(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.dgG != null) {
            this.dgG.resume();
        }
    }

    public void fQ(boolean z) {
        if (this.dgG != null) {
            this.dgG.fQ(z);
            f.aCp().aBP();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.dgH = aVar;
        if (this.dgz != null) {
            this.dgz.qw(this.dgH.dgg);
        }
        play();
    }

    public Object qt(String str) {
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
                return this.dgH.mUrl;
            case 4:
                return Integer.valueOf(this.dgH.dge);
            case 5:
                return Integer.valueOf(this.dgI);
            case 6:
                return this.dgH.mTitle;
            case 7:
                return this.dgH.dgb;
            case '\b':
                return this.dgH.dgc;
            case '\t':
                return this.dgH.mCoverUrl;
            case '\n':
                return this.dgH.dgd;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCU() {
        SwanAppConfigData aKd = e.aJU() != null ? e.aJU().aKd() : null;
        return aKd != null && aKd.dzg.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCV() {
        if (e.aJU() != null && e.aJU().aio() != null && dgJ != null) {
            b.a aio = e.aJU().aio();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.kS(aio.getAppFrameType());
            fVar.mAppId = aio.getAppId();
            fVar.mSource = aio.aBe();
            fVar.t("appid", aio.getAppId());
            fVar.t("cuid", com.baidu.swan.apps.t.a.azf().bW(com.baidu.swan.apps.t.a.aza()));
            JSONObject tF = h.tF(aio.aBg());
            if (tF != null) {
                fVar.t("keyfeed", tF.optString("keyfeed"));
            }
            h.a(dgJ, fVar);
        }
        dgJ = null;
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
    /* loaded from: classes25.dex */
    public class a implements c.a {
        private boolean dgM;

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
                    if (d.this.dgz != null) {
                        d.this.dgz.qx("onCanplay");
                    }
                    this.dgM = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.dgJ = h.tD("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.aCV();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx(MissionEvent.MESSAGE_STOP);
                    }
                    this.dgM = true;
                    if (d.this.mIsBackground) {
                        d.this.aCV();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.aCV();
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
                    if (d.this.dgz != null) {
                        d.this.dgz.g("onTimeUpdate", jSONObject);
                    }
                    if (this.dgM) {
                        if (d.this.dgH.dge > 0) {
                            d.this.seekTo(d.this.dgH.dge);
                        }
                        this.dgM = false;
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
                    if (d.this.dgz != null) {
                        d.this.dgz.g("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.dgI = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.dgI);
                    if (d.this.dgz == null || currentProgress < d.this.dgI) {
                        return true;
                    }
                    d.this.dgz.qx("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.dgz != null) {
                        d.this.dgz.qx("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
