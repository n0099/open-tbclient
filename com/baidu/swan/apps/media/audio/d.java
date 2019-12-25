package com.baidu.swan.apps.media.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Flow bwl;
    private com.baidu.swan.apps.media.audio.b.a bwb;
    private c bwi;
    @Nullable
    private com.baidu.swan.apps.y.a bwm;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a bwj = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int bwk = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.bwi != null) {
            this.bwi.pause();
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            if (this.bwi != null) {
                this.bwi.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.bwb != null) {
                this.bwb.iK("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.bwi != null) {
            this.bwi.stop();
        }
        if (this.bwm != null) {
            com.baidu.swan.apps.w.a.Rk().unregisterActivityLifecycleCallbacks(this.bwm);
            this.bwm = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.bwi != null && !Uz()) {
            this.bwi.release();
            f.Uf().TH();
            this.bwi = null;
            bwl = null;
        }
    }

    public int getDuration() {
        if (this.bwi != null) {
            return this.bwi.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.bwi == null || !this.bwi.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Uw() {
        if (this.bwi == null) {
            this.bwi = new c(this.mContext);
            this.bwi.a(new a());
        }
        return this.bwi;
    }

    public com.baidu.swan.apps.media.audio.a Ux() {
        return this.bwj;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.bwj = aVar;
        if (this.bwj.bvH != null) {
            try {
                this.bwb = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bwj.bvH));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void Uy() {
        if (this.bwm != null) {
            com.baidu.swan.apps.w.a.Rk().unregisterActivityLifecycleCallbacks(this.bwm);
        }
        this.bwm = new com.baidu.swan.apps.y.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.Uz()) {
                    if (d.this.isPaused()) {
                        Flow unused = d.bwl = null;
                        return;
                    } else if (d.bwl == null) {
                        Flow unused2 = d.bwl = com.baidu.swan.apps.statistic.f.lp("1044");
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
                    d.this.UA();
                }
            }
        };
        com.baidu.swan.apps.w.a.Rk().registerActivityLifecycleCallbacks(this.bwm);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        if (!this.bwj.Ur()) {
            Uy();
            String str = this.bwj.mUrl;
            e ZS = e.ZS();
            if (com.baidu.swan.apps.storage.b.lI(str) == PathType.CLOUD) {
                iF(str);
            } else {
                c(str, ZS);
            }
            f.Uf().TG();
        }
    }

    private void iF(String str) {
        com.baidu.swan.apps.w.a.RE().a(this.mContext, str, new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void B(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.Uw().aK(d.this.bwj.iE(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.bwj.bvI && eVar != null) {
            if (this.bwb.UD()) {
                d = l.lO(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        Uw().aK(this.bwj.iE(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        if (this.bwi != null) {
            this.bwi.resume();
        }
    }

    public void cE(boolean z) {
        if (this.bwi != null) {
            this.bwi.cE(z);
            f.Uf().TG();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.bwj = aVar;
        if (this.bwb != null) {
            this.bwb.iJ(this.bwj.bvH);
        }
        play();
    }

    public Object iG(String str) {
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
                return this.bwj.mUrl;
            case 4:
                return Integer.valueOf(this.bwj.bvF);
            case 5:
                return Integer.valueOf(this.bwk);
            case 6:
                return this.bwj.mTitle;
            case 7:
                return this.bwj.bvD;
            case '\b':
                return this.bwj.bvE;
            case '\t':
                return this.bwj.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uz() {
        SwanAppConfigData ZY = e.ZS() != null ? e.ZS().ZY() : null;
        return ZY != null && ZY.bKX.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        if (e.ZS() != null && e.ZS().DR() != null && bwl != null) {
            b.a DR = e.ZS().DR();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(DR.getAppFrameType());
            fVar.mAppId = DR.getAppId();
            fVar.mSource = DR.SW();
            fVar.n("appid", DR.getAppId());
            fVar.n("cuid", com.baidu.swan.apps.w.a.Rp().bn(com.baidu.swan.apps.w.a.Rk()));
            JSONObject lq = com.baidu.swan.apps.statistic.f.lq(DR.SY());
            if (lq != null) {
                fVar.n("keyfeed", lq.optString("keyfeed"));
            }
            com.baidu.swan.apps.statistic.f.a(bwl, fVar);
        }
        bwl = null;
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
    /* loaded from: classes9.dex */
    public class a implements c.a {
        private boolean bwo;

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
                    if (d.this.bwb != null) {
                        d.this.bwb.iK("onCanplay");
                    }
                    this.bwo = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        Flow unused = d.bwl = com.baidu.swan.apps.statistic.f.lp("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.UA();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK(MissionEvent.MESSAGE_STOP);
                    }
                    this.bwo = true;
                    if (d.this.mIsBackground) {
                        d.this.UA();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.UA();
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
                    if (d.this.bwb != null) {
                        d.this.bwb.d("onTimeUpdate", jSONObject);
                    }
                    if (this.bwo) {
                        d.this.seekTo(d.this.bwj.bvF);
                        this.bwo = false;
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
                    if (d.this.bwb != null) {
                        d.this.bwb.d("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.bwk = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.bwk);
                    if (d.this.bwb == null || currentProgress < d.this.bwk) {
                        return true;
                    }
                    d.this.bwb.iK("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.bwb != null) {
                        d.this.bwb.iK("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
