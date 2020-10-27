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
    private static com.baidu.swan.apps.statistic.a cVz;
    @Nullable
    private com.baidu.swan.apps.v.a cVA;
    private com.baidu.swan.apps.media.audio.b.a cVp;
    private c cVw;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a cVx = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int cVy = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.cVw != null) {
            this.cVw.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.cVw != null) {
                this.cVw.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.cVp != null) {
                this.cVp.pI("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.cVw != null) {
            this.cVw.stop();
        }
        if (this.cVA != null) {
            com.baidu.swan.apps.t.a.aua().unregisterActivityLifecycleCallbacks(this.cVA);
            this.cVA = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.cVw != null && !axT()) {
            this.cVw.release();
            f.axo().awP();
            this.cVw = null;
            cVz = null;
        }
    }

    public int getDuration() {
        if (this.cVw != null) {
            return this.cVw.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.cVw == null || !this.cVw.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c axQ() {
        if (this.cVw == null) {
            this.cVw = new c(this.mContext);
            this.cVw.a(new a());
        }
        return this.cVw;
    }

    public com.baidu.swan.apps.media.audio.a axR() {
        return this.cVx;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.cVx = aVar;
        if (this.cVx.cUW != null) {
            try {
                this.cVp = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cVx.cUW));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void axS() {
        if (this.cVA != null) {
            com.baidu.swan.apps.t.a.aua().unregisterActivityLifecycleCallbacks(this.cVA);
        }
        this.cVA = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.axT()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.cVz = null;
                        return;
                    } else if (d.cVz == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.cVz = h.sN("1044");
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
                    d.this.axU();
                }
            }
        };
        com.baidu.swan.apps.t.a.aua().registerActivityLifecycleCallbacks(this.cVA);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.cVx.axK()) {
            axS();
            String str = this.cVx.mUrl;
            e aEU = e.aEU();
            if (com.baidu.swan.apps.storage.b.tj(str) == PathType.CLOUD) {
                pD(str);
            } else {
                c(str, aEU);
            }
            f.axo().awO();
        }
    }

    private void pD(String str) {
        com.baidu.swan.apps.t.a.aut().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void M(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.axQ().bX(d.this.cVx.pC(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.cVx.cUX && eVar != null) {
            if (this.cVp.axW()) {
                d = n.tr(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        axQ().bX(this.cVx.pC(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.cVw != null) {
            this.cVw.resume();
        }
    }

    public void fp(boolean z) {
        if (this.cVw != null) {
            this.cVw.fp(z);
            f.axo().awO();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.cVx = aVar;
        if (this.cVp != null) {
            this.cVp.pH(this.cVx.cUW);
        }
        play();
    }

    public Object pE(String str) {
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
                return this.cVx.mUrl;
            case 4:
                return Integer.valueOf(this.cVx.cUU);
            case 5:
                return Integer.valueOf(this.cVy);
            case 6:
                return this.cVx.mTitle;
            case 7:
                return this.cVx.cUR;
            case '\b':
                return this.cVx.cUS;
            case '\t':
                return this.cVx.mCoverUrl;
            case '\n':
                return this.cVx.cUT;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axT() {
        SwanAppConfigData aFd = e.aEU() != null ? e.aEU().aFd() : null;
        return aFd != null && aFd.dnR.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axU() {
        if (e.aEU() != null && e.aEU().ado() != null && cVz != null) {
            b.a ado = e.aEU().ado();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ko(ado.getAppFrameType());
            fVar.mAppId = ado.getAppId();
            fVar.mSource = ado.awd();
            fVar.u("appid", ado.getAppId());
            fVar.u("cuid", com.baidu.swan.apps.t.a.auf().bq(com.baidu.swan.apps.t.a.aua()));
            JSONObject sP = h.sP(ado.awf());
            if (sP != null) {
                fVar.u("keyfeed", sP.optString("keyfeed"));
            }
            h.a(cVz, fVar);
        }
        cVz = null;
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
        private boolean cVC;

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
                    if (d.this.cVp != null) {
                        d.this.cVp.pI("onCanplay");
                    }
                    this.cVC = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.cVz = h.sN("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.axU();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI(MissionEvent.MESSAGE_STOP);
                    }
                    this.cVC = true;
                    if (d.this.mIsBackground) {
                        d.this.axU();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.axU();
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
                    if (d.this.cVp != null) {
                        d.this.cVp.e("onTimeUpdate", jSONObject);
                    }
                    if (this.cVC) {
                        if (d.this.cVx.cUU > 0) {
                            d.this.seekTo(d.this.cVx.cUU);
                        }
                        this.cVC = false;
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
                    if (d.this.cVp != null) {
                        d.this.cVp.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.cVy = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.cVy);
                    if (d.this.cVp == null || currentProgress < d.this.cVy) {
                        return true;
                    }
                    d.this.cVp.pI("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.cVp != null) {
                        d.this.cVp.pI("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
