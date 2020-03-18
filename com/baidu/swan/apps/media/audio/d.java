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
    private static Flow bBt;
    private com.baidu.swan.apps.media.audio.b.a bBj;
    private c bBq;
    @Nullable
    private com.baidu.swan.apps.y.a bBu;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a bBr = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int bBs = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.bBq != null) {
            this.bBq.pause();
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            if (this.bBq != null) {
                this.bBq.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.bBj != null) {
                this.bBj.jb("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.bBq != null) {
            this.bBq.stop();
        }
        if (this.bBu != null) {
            com.baidu.swan.apps.w.a.TZ().unregisterActivityLifecycleCallbacks(this.bBu);
            this.bBu = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.bBq != null && !Xp()) {
            this.bBq.release();
            f.WV().Wx();
            this.bBq = null;
            bBt = null;
        }
    }

    public int getDuration() {
        if (this.bBq != null) {
            return this.bBq.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.bBq == null || !this.bBq.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Xm() {
        if (this.bBq == null) {
            this.bBq = new c(this.mContext);
            this.bBq.a(new a());
        }
        return this.bBq;
    }

    public com.baidu.swan.apps.media.audio.a Xn() {
        return this.bBr;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.bBr = aVar;
        if (this.bBr.bAQ != null) {
            try {
                this.bBj = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bBr.bAQ));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void Xo() {
        if (this.bBu != null) {
            com.baidu.swan.apps.w.a.TZ().unregisterActivityLifecycleCallbacks(this.bBu);
        }
        this.bBu = new com.baidu.swan.apps.y.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.Xp()) {
                    if (d.this.isPaused()) {
                        Flow unused = d.bBt = null;
                        return;
                    } else if (d.bBt == null) {
                        Flow unused2 = d.bBt = com.baidu.swan.apps.statistic.f.lG("1044");
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
                    d.this.Xq();
                }
            }
        };
        com.baidu.swan.apps.w.a.TZ().registerActivityLifecycleCallbacks(this.bBu);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.bBr.Xh()) {
            Xo();
            String str = this.bBr.mUrl;
            e acI = e.acI();
            if (com.baidu.swan.apps.storage.b.lZ(str) == PathType.CLOUD) {
                iW(str);
            } else {
                c(str, acI);
            }
            f.WV().Ww();
        }
    }

    private void iW(String str) {
        com.baidu.swan.apps.w.a.Ut().a(this.mContext, str, new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void D(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.Xm().aT(d.this.bBr.iV(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.bBr.bAR && eVar != null) {
            if (this.bBj.Xt()) {
                d = l.mf(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        Xm().aT(this.bBr.iV(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.bBq != null) {
            this.bBq.resume();
        }
    }

    public void cR(boolean z) {
        if (this.bBq != null) {
            this.bBq.cR(z);
            f.WV().Ww();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.bBr = aVar;
        if (this.bBj != null) {
            this.bBj.ja(this.bBr.bAQ);
        }
        play();
    }

    public Object iX(String str) {
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
                return this.bBr.mUrl;
            case 4:
                return Integer.valueOf(this.bBr.bAO);
            case 5:
                return Integer.valueOf(this.bBs);
            case 6:
                return this.bBr.mTitle;
            case 7:
                return this.bBr.bAM;
            case '\b':
                return this.bBr.bAN;
            case '\t':
                return this.bBr.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xp() {
        SwanAppConfigData acO = e.acI() != null ? e.acI().acO() : null;
        return acO != null && acO.bPZ.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xq() {
        if (e.acI() != null && e.acI().GJ() != null && bBt != null) {
            b.a GJ = e.acI().GJ();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(GJ.getAppFrameType());
            fVar.mAppId = GJ.getAppId();
            fVar.mSource = GJ.VM();
            fVar.n("appid", GJ.getAppId());
            fVar.n("cuid", com.baidu.swan.apps.w.a.Ue().bq(com.baidu.swan.apps.w.a.TZ()));
            JSONObject lH = com.baidu.swan.apps.statistic.f.lH(GJ.VO());
            if (lH != null) {
                fVar.n("keyfeed", lH.optString("keyfeed"));
            }
            com.baidu.swan.apps.statistic.f.a(bBt, fVar);
        }
        bBt = null;
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
        private boolean bBw;

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
                    if (d.this.bBj != null) {
                        d.this.bBj.jb("onCanplay");
                    }
                    this.bBw = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        Flow unused = d.bBt = com.baidu.swan.apps.statistic.f.lG("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.Xq();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb(MissionEvent.MESSAGE_STOP);
                    }
                    this.bBw = true;
                    if (d.this.mIsBackground) {
                        d.this.Xq();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.Xq();
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
                    if (d.this.bBj != null) {
                        d.this.bBj.d("onTimeUpdate", jSONObject);
                    }
                    if (this.bBw) {
                        d.this.seekTo(d.this.bBr.bAO);
                        this.bBw = false;
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
                    if (d.this.bBj != null) {
                        d.this.bBj.d("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.bBs = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.bBs);
                    if (d.this.bBj == null || currentProgress < d.this.bBs) {
                        return true;
                    }
                    d.this.bBj.jb("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.bBj != null) {
                        d.this.bBj.jb("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
