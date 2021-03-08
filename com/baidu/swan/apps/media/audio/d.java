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
    private static com.baidu.swan.apps.statistic.a dkD;
    private c dkA;
    @Nullable
    private com.baidu.swan.apps.v.a dkE;
    private com.baidu.swan.apps.media.audio.b.a dkt;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a dkB = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int dkC = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.dkA != null) {
            this.dkA.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.dkA != null) {
                this.dkA.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.dkt != null) {
                this.dkt.pE("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.dkA != null) {
            this.dkA.stop();
        }
        if (this.dkE != null) {
            com.baidu.swan.apps.t.a.awZ().unregisterActivityLifecycleCallbacks(this.dkE);
            this.dkE = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.dkA != null && !aAT()) {
            this.dkA.release();
            f.aAo().azP();
            this.dkA = null;
            dkD = null;
        }
    }

    public int getDuration() {
        if (this.dkA != null) {
            return this.dkA.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.dkA == null || !this.dkA.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aAQ() {
        if (this.dkA == null) {
            this.dkA = new c(this.mContext);
            this.dkA.a(new a());
        }
        return this.dkA;
    }

    public com.baidu.swan.apps.media.audio.a aAR() {
        return this.dkB;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.dkB = aVar;
        if (this.dkB.djZ != null) {
            try {
                this.dkt = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.dkB.djZ));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void aAS() {
        if (this.dkE != null) {
            com.baidu.swan.apps.t.a.awZ().unregisterActivityLifecycleCallbacks(this.dkE);
        }
        this.dkE = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aAT()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.dkD = null;
                        return;
                    } else if (d.dkD == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.dkD = h.sP("1044");
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
                    d.this.aAU();
                }
            }
        };
        com.baidu.swan.apps.t.a.awZ().registerActivityLifecycleCallbacks(this.dkE);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.dkB.aAK()) {
            aAS();
            String str = this.dkB.mUrl;
            e aIN = e.aIN();
            if (com.baidu.swan.apps.storage.b.tl(str) == PathType.CLOUD) {
                pz(str);
            } else {
                b(str, aIN);
            }
            f.aAo().azO();
        }
    }

    private void pz(String str) {
        com.baidu.swan.apps.t.a.axs().a(this.mContext, str, new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: onCallback */
            public void N(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.aAQ().bV(d.this.dkB.py(str2), str2);
                }
            }
        });
    }

    private void b(String str, e eVar) {
        String c;
        if (this.dkB.dka && eVar != null) {
            if (this.dkt.aAX()) {
                c = n.tt(str);
            } else {
                c = com.baidu.swan.apps.storage.b.c(str, eVar);
            }
            str = c;
        }
        aAQ().bV(this.dkB.py(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.dkA != null) {
            this.dkA.resume();
        }
    }

    public void fX(boolean z) {
        if (this.dkA != null) {
            this.dkA.fX(z);
            f.aAo().azO();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.dkB = aVar;
        if (this.dkt != null) {
            this.dkt.pD(this.dkB.djZ);
        }
        play();
    }

    public Object pA(String str) {
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
                return this.dkB.mUrl;
            case 4:
                return Integer.valueOf(this.dkB.djX);
            case 5:
                return Integer.valueOf(this.dkC);
            case 6:
                return this.dkB.mTitle;
            case 7:
                return this.dkB.djU;
            case '\b':
                return this.dkB.djV;
            case '\t':
                return this.dkB.mCoverUrl;
            case '\n':
                return this.dkB.djW;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAT() {
        SwanAppConfigData aIW = e.aIN() != null ? e.aIN().aIW() : null;
        return aIW != null && aIW.dGE.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAU() {
        if (e.aIN() != null && e.aIN().agc() != null && dkD != null) {
            b.a agc = e.aIN().agc();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jv(agc.getAppFrameType());
            fVar.mAppId = agc.getAppId();
            fVar.mSource = agc.azd();
            fVar.s("appid", agc.getAppId());
            fVar.s("cuid", com.baidu.swan.apps.t.a.axe().ca(com.baidu.swan.apps.t.a.awZ()));
            JSONObject sR = h.sR(agc.azf());
            if (sR != null) {
                fVar.s("keyfeed", sR.optString("keyfeed"));
            }
            h.a(dkD, fVar);
        }
        dkD = null;
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
        private boolean dkG;

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
                    if (d.this.dkt != null) {
                        d.this.dkt.pE("onCanplay");
                    }
                    this.dkG = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.dkD = h.sP("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAU();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE(MissionEvent.MESSAGE_STOP);
                    }
                    this.dkG = true;
                    if (d.this.mIsBackground) {
                        d.this.aAU();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.aAU();
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
                    if (d.this.dkt != null) {
                        d.this.dkt.i("onTimeUpdate", jSONObject);
                    }
                    if (this.dkG) {
                        if (d.this.dkB.djX > 0) {
                            d.this.seekTo(d.this.dkB.djX);
                        }
                        this.dkG = false;
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
                    if (d.this.dkt != null) {
                        d.this.dkt.i("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.dkC = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.dkC);
                    if (d.this.dkt == null || currentProgress < d.this.dkC) {
                        return true;
                    }
                    d.this.dkt.pE("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.dkt != null) {
                        d.this.dkt.pE("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
