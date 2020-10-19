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
    private static com.baidu.swan.apps.statistic.a cNd;
    private com.baidu.swan.apps.media.audio.b.a cMT;
    private c cNa;
    @Nullable
    private com.baidu.swan.apps.v.a cNe;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a cNb = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int cNc = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.cNa != null) {
            this.cNa.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.cNa != null) {
                this.cNa.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.cMT != null) {
                this.cMT.pp("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.cNa != null) {
            this.cNa.stop();
        }
        if (this.cNe != null) {
            com.baidu.swan.apps.t.a.asf().unregisterActivityLifecycleCallbacks(this.cNe);
            this.cNe = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.cNa != null && !avZ()) {
            this.cNa.release();
            f.avu().auV();
            this.cNa = null;
            cNd = null;
        }
    }

    public int getDuration() {
        if (this.cNa != null) {
            return this.cNa.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.cNa == null || !this.cNa.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c avW() {
        if (this.cNa == null) {
            this.cNa = new c(this.mContext);
            this.cNa.a(new a());
        }
        return this.cNa;
    }

    public com.baidu.swan.apps.media.audio.a avX() {
        return this.cNb;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.cNb = aVar;
        if (this.cNb.cMA != null) {
            try {
                this.cMT = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cNb.cMA));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void avY() {
        if (this.cNe != null) {
            com.baidu.swan.apps.t.a.asf().unregisterActivityLifecycleCallbacks(this.cNe);
        }
        this.cNe = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.avZ()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.cNd = null;
                        return;
                    } else if (d.cNd == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.cNd = h.su("1044");
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
                    d.this.awa();
                }
            }
        };
        com.baidu.swan.apps.t.a.asf().registerActivityLifecycleCallbacks(this.cNe);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.cNb.avQ()) {
            avY();
            String str = this.cNb.mUrl;
            e aDa = e.aDa();
            if (com.baidu.swan.apps.storage.b.sQ(str) == PathType.CLOUD) {
                pk(str);
            } else {
                c(str, aDa);
            }
            f.avu().auU();
        }
    }

    private void pk(String str) {
        com.baidu.swan.apps.t.a.asz().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void M(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.avW().bQ(d.this.cNb.pj(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.cNb.cMB && eVar != null) {
            if (this.cMT.awc()) {
                d = n.sY(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        avW().bQ(this.cNb.pj(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.cNa != null) {
            this.cNa.resume();
        }
    }

    public void fc(boolean z) {
        if (this.cNa != null) {
            this.cNa.fc(z);
            f.avu().auU();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.cNb = aVar;
        if (this.cMT != null) {
            this.cMT.po(this.cNb.cMA);
        }
        play();
    }

    public Object pl(String str) {
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
                return this.cNb.mUrl;
            case 4:
                return Integer.valueOf(this.cNb.cMy);
            case 5:
                return Integer.valueOf(this.cNc);
            case 6:
                return this.cNb.mTitle;
            case 7:
                return this.cNb.cMv;
            case '\b':
                return this.cNb.cMw;
            case '\t':
                return this.cNb.mCoverUrl;
            case '\n':
                return this.cNb.cMx;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avZ() {
        SwanAppConfigData aDj = e.aDa() != null ? e.aDa().aDj() : null;
        return aDj != null && aDj.dfr.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awa() {
        if (e.aDa() != null && e.aDa().abu() != null && cNd != null) {
            b.a abu = e.aDa().abu();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.kd(abu.getAppFrameType());
            fVar.mAppId = abu.getAppId();
            fVar.mSource = abu.auj();
            fVar.u("appid", abu.getAppId());
            fVar.u("cuid", com.baidu.swan.apps.t.a.ask().bq(com.baidu.swan.apps.t.a.asf()));
            JSONObject sw = h.sw(abu.aul());
            if (sw != null) {
                fVar.u("keyfeed", sw.optString("keyfeed"));
            }
            h.a(cNd, fVar);
        }
        cNd = null;
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
        private boolean cNg;

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
                    if (d.this.cMT != null) {
                        d.this.cMT.pp("onCanplay");
                    }
                    this.cNg = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.cNd = h.su("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.awa();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp(MissionEvent.MESSAGE_STOP);
                    }
                    this.cNg = true;
                    if (d.this.mIsBackground) {
                        d.this.awa();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.awa();
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
                    if (d.this.cMT != null) {
                        d.this.cMT.e("onTimeUpdate", jSONObject);
                    }
                    if (this.cNg) {
                        if (d.this.cNb.cMy > 0) {
                            d.this.seekTo(d.this.cNb.cMy);
                        }
                        this.cNg = false;
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
                    if (d.this.cMT != null) {
                        d.this.cMT.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.cNc = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.cNc);
                    if (d.this.cMT == null || currentProgress < d.this.cNc) {
                        return true;
                    }
                    d.this.cMT.pp("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.cMT != null) {
                        d.this.cMT.pp("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
