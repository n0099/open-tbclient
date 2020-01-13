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
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Flow bwY;
    private com.baidu.swan.apps.media.audio.b.a bwO;
    private c bwV;
    @Nullable
    private com.baidu.swan.apps.y.a bwZ;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a bwW = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int bwX = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.bwV != null) {
            this.bwV.pause();
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            if (this.bwV != null) {
                this.bwV.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.bwO != null) {
                this.bwO.iN("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.bwV != null) {
            this.bwV.stop();
        }
        if (this.bwZ != null) {
            com.baidu.swan.apps.w.a.RG().unregisterActivityLifecycleCallbacks(this.bwZ);
            this.bwZ = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.bwV != null && !UW()) {
            this.bwV.release();
            f.UC().Ue();
            this.bwV = null;
            bwY = null;
        }
    }

    public int getDuration() {
        if (this.bwV != null) {
            return this.bwV.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.bwV == null || !this.bwV.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c UT() {
        if (this.bwV == null) {
            this.bwV = new c(this.mContext);
            this.bwV.a(new a());
        }
        return this.bwV;
    }

    public com.baidu.swan.apps.media.audio.a UU() {
        return this.bwW;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.bwW = aVar;
        if (this.bwW.bwu != null) {
            try {
                this.bwO = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bwW.bwu));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void UV() {
        if (this.bwZ != null) {
            com.baidu.swan.apps.w.a.RG().unregisterActivityLifecycleCallbacks(this.bwZ);
        }
        this.bwZ = new com.baidu.swan.apps.y.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.UW()) {
                    if (d.this.isPaused()) {
                        Flow unused = d.bwY = null;
                        return;
                    } else if (d.bwY == null) {
                        Flow unused2 = d.bwY = com.baidu.swan.apps.statistic.f.ls("1044");
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
                    d.this.UX();
                }
            }
        };
        com.baidu.swan.apps.w.a.RG().registerActivityLifecycleCallbacks(this.bwZ);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.bwW.UO()) {
            UV();
            String str = this.bwW.mUrl;
            e aap = e.aap();
            if (com.baidu.swan.apps.storage.b.lL(str) == PathType.CLOUD) {
                iI(str);
            } else {
                c(str, aap);
            }
            f.UC().Ud();
        }
    }

    private void iI(String str) {
        com.baidu.swan.apps.w.a.Sa().a(this.mContext, str, new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void B(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.UT().aL(d.this.bwW.iH(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.bwW.bwv && eVar != null) {
            if (this.bwO.Va()) {
                d = l.lR(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        UT().aL(this.bwW.iH(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.bwV != null) {
            this.bwV.resume();
        }
    }

    public void cJ(boolean z) {
        if (this.bwV != null) {
            this.bwV.cJ(z);
            f.UC().Ud();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.bwW = aVar;
        if (this.bwO != null) {
            this.bwO.iM(this.bwW.bwu);
        }
        play();
    }

    public Object iJ(String str) {
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
                return this.bwW.mUrl;
            case 4:
                return Integer.valueOf(this.bwW.bws);
            case 5:
                return Integer.valueOf(this.bwX);
            case 6:
                return this.bwW.mTitle;
            case 7:
                return this.bwW.bwq;
            case '\b':
                return this.bwW.bwr;
            case '\t':
                return this.bwW.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean UW() {
        SwanAppConfigData aav = e.aap() != null ? e.aap().aav() : null;
        return aav != null && aav.bLH.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UX() {
        if (e.aap() != null && e.aap().En() != null && bwY != null) {
            b.a En = e.aap().En();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(En.getAppFrameType());
            fVar.mAppId = En.getAppId();
            fVar.mSource = En.Tt();
            fVar.n("appid", En.getAppId());
            fVar.n("cuid", com.baidu.swan.apps.w.a.RL().bn(com.baidu.swan.apps.w.a.RG()));
            JSONObject lt = com.baidu.swan.apps.statistic.f.lt(En.Tv());
            if (lt != null) {
                fVar.n("keyfeed", lt.optString("keyfeed"));
            }
            com.baidu.swan.apps.statistic.f.a(bwY, fVar);
        }
        bwY = null;
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
        private boolean bxb;

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
                    if (d.this.bwO != null) {
                        d.this.bwO.iN("onCanplay");
                    }
                    this.bxb = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        Flow unused = d.bwY = com.baidu.swan.apps.statistic.f.ls("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.UX();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN(MissionEvent.MESSAGE_STOP);
                    }
                    this.bxb = true;
                    if (d.this.mIsBackground) {
                        d.this.UX();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.UX();
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
                    if (d.this.bwO != null) {
                        d.this.bwO.d("onTimeUpdate", jSONObject);
                    }
                    if (this.bxb) {
                        d.this.seekTo(d.this.bwW.bws);
                        this.bxb = false;
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
                    if (d.this.bwO != null) {
                        d.this.bwO.d("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.bwX = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.bwX);
                    if (d.this.bwO == null || currentProgress < d.this.bwX) {
                        return true;
                    }
                    d.this.bwO.iN("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.bwO != null) {
                        d.this.bwO.iN("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
