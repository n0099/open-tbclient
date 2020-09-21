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
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a cAY;
    private com.baidu.swan.apps.media.audio.b.a cAO;
    private c cAV;
    @Nullable
    private com.baidu.swan.apps.v.a cAZ;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a cAW = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int cAX = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.cAV != null) {
            this.cAV.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.cAV != null) {
                this.cAV.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.cAO != null) {
                this.cAO.oD("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.cAV != null) {
            this.cAV.stop();
        }
        if (this.cAZ != null) {
            com.baidu.swan.apps.t.a.apu().unregisterActivityLifecycleCallbacks(this.cAZ);
            this.cAZ = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.cAV != null && !ato()) {
            this.cAV.release();
            f.asJ().asj();
            this.cAV = null;
            cAY = null;
        }
    }

    public int getDuration() {
        if (this.cAV != null) {
            return this.cAV.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.cAV == null || !this.cAV.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c atl() {
        if (this.cAV == null) {
            this.cAV = new c(this.mContext);
            this.cAV.a(new a());
        }
        return this.cAV;
    }

    public com.baidu.swan.apps.media.audio.a atm() {
        return this.cAW;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.cAW = aVar;
        if (this.cAW.cAv != null) {
            try {
                this.cAO = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cAW.cAv));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void atn() {
        if (this.cAZ != null) {
            com.baidu.swan.apps.t.a.apu().unregisterActivityLifecycleCallbacks(this.cAZ);
        }
        this.cAZ = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.ato()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.cAY = null;
                        return;
                    } else if (d.cAY == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.cAY = h.rH("1044");
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
                    d.this.atp();
                }
            }
        };
        com.baidu.swan.apps.t.a.apu().registerActivityLifecycleCallbacks(this.cAZ);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.cAW.atf()) {
            atn();
            String str = this.cAW.mUrl;
            e aAr = e.aAr();
            if (com.baidu.swan.apps.storage.b.sd(str) == PathType.CLOUD) {
                oy(str);
            } else {
                c(str, aAr);
            }
            f.asJ().asi();
        }
    }

    private void oy(String str) {
        com.baidu.swan.apps.t.a.apN().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void J(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.atl().bL(d.this.cAW.ox(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.cAW.cAw && eVar != null) {
            if (this.cAO.atr()) {
                d = n.sl(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        atl().bL(this.cAW.ox(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.cAV != null) {
            this.cAV.resume();
        }
    }

    public void eG(boolean z) {
        if (this.cAV != null) {
            this.cAV.eG(z);
            f.asJ().asi();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.cAW = aVar;
        if (this.cAO != null) {
            this.cAO.oC(this.cAW.cAv);
        }
        play();
    }

    public Object oz(String str) {
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
                return this.cAW.mUrl;
            case 4:
                return Integer.valueOf(this.cAW.cAt);
            case 5:
                return Integer.valueOf(this.cAX);
            case 6:
                return this.cAW.mTitle;
            case 7:
                return this.cAW.cAq;
            case '\b':
                return this.cAW.cAr;
            case '\t':
                return this.cAW.mCoverUrl;
            case '\n':
                return this.cAW.cAs;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ato() {
        SwanAppConfigData aAA = e.aAr() != null ? e.aAr().aAA() : null;
        return aAA != null && aAA.cTj.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atp() {
        if (e.aAr() != null && e.aAr().YI() != null && cAY != null) {
            b.a YI = e.aAr().YI();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jG(YI.getAppFrameType());
            fVar.mAppId = YI.getAppId();
            fVar.mSource = YI.arx();
            fVar.u("appid", YI.getAppId());
            fVar.u("cuid", com.baidu.swan.apps.t.a.apz().bk(com.baidu.swan.apps.t.a.apu()));
            JSONObject rJ = h.rJ(YI.arz());
            if (rJ != null) {
                fVar.u("keyfeed", rJ.optString("keyfeed"));
            }
            h.a(cAY, fVar);
        }
        cAY = null;
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
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private boolean cBb;

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
                    if (d.this.cAO != null) {
                        d.this.cAO.oD("onCanplay");
                    }
                    this.cBb = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.cAY = h.rH("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.atp();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD(MissionEvent.MESSAGE_STOP);
                    }
                    this.cBb = true;
                    if (d.this.mIsBackground) {
                        d.this.atp();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.atp();
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
                    if (d.this.cAO != null) {
                        d.this.cAO.e("onTimeUpdate", jSONObject);
                    }
                    if (this.cBb) {
                        if (d.this.cAW.cAt > 0) {
                            d.this.seekTo(d.this.cAW.cAt);
                        }
                        this.cBb = false;
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
                    if (d.this.cAO != null) {
                        d.this.cAO.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.cAX = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.cAX);
                    if (d.this.cAO == null || currentProgress < d.this.cAX) {
                        return true;
                    }
                    d.this.cAO.oD("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.cAO != null) {
                        d.this.cAO.oD("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
