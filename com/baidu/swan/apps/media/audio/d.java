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
    private static Flow bBg;
    private com.baidu.swan.apps.media.audio.b.a bAW;
    private c bBd;
    @Nullable
    private com.baidu.swan.apps.y.a bBh;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a bBe = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int bBf = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.bBd != null) {
            this.bBd.pause();
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            if (this.bBd != null) {
                this.bBd.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.bAW != null) {
                this.bAW.jc("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.bBd != null) {
            this.bBd.stop();
        }
        if (this.bBh != null) {
            com.baidu.swan.apps.w.a.TU().unregisterActivityLifecycleCallbacks(this.bBh);
            this.bBh = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.bBd != null && !Xk()) {
            this.bBd.release();
            f.WQ().Ws();
            this.bBd = null;
            bBg = null;
        }
    }

    public int getDuration() {
        if (this.bBd != null) {
            return this.bBd.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.bBd == null || !this.bBd.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Xh() {
        if (this.bBd == null) {
            this.bBd = new c(this.mContext);
            this.bBd.a(new a());
        }
        return this.bBd;
    }

    public com.baidu.swan.apps.media.audio.a Xi() {
        return this.bBe;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.bBe = aVar;
        if (this.bBe.bAD != null) {
            try {
                this.bAW = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.bBe.bAD));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void Xj() {
        if (this.bBh != null) {
            com.baidu.swan.apps.w.a.TU().unregisterActivityLifecycleCallbacks(this.bBh);
        }
        this.bBh = new com.baidu.swan.apps.y.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.Xk()) {
                    if (d.this.isPaused()) {
                        Flow unused = d.bBg = null;
                        return;
                    } else if (d.bBg == null) {
                        Flow unused2 = d.bBg = com.baidu.swan.apps.statistic.f.lH("1044");
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
                    d.this.Xl();
                }
            }
        };
        com.baidu.swan.apps.w.a.TU().registerActivityLifecycleCallbacks(this.bBh);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.bBe.Xc()) {
            Xj();
            String str = this.bBe.mUrl;
            e acD = e.acD();
            if (com.baidu.swan.apps.storage.b.ma(str) == PathType.CLOUD) {
                iX(str);
            } else {
                c(str, acD);
            }
            f.WQ().Wr();
        }
    }

    private void iX(String str) {
        com.baidu.swan.apps.w.a.Uo().a(this.mContext, str, new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void D(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.Xh().aU(d.this.bBe.iW(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.bBe.bAE && eVar != null) {
            if (this.bAW.Xo()) {
                d = l.mg(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        Xh().aU(this.bBe.iW(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.bBd != null) {
            this.bBd.resume();
        }
    }

    public void cQ(boolean z) {
        if (this.bBd != null) {
            this.bBd.cQ(z);
            f.WQ().Wr();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.bBe = aVar;
        if (this.bAW != null) {
            this.bAW.jb(this.bBe.bAD);
        }
        play();
    }

    public Object iY(String str) {
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
                return this.bBe.mUrl;
            case 4:
                return Integer.valueOf(this.bBe.bAB);
            case 5:
                return Integer.valueOf(this.bBf);
            case 6:
                return this.bBe.mTitle;
            case 7:
                return this.bBe.bAz;
            case '\b':
                return this.bBe.bAA;
            case '\t':
                return this.bBe.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xk() {
        SwanAppConfigData acJ = e.acD() != null ? e.acD().acJ() : null;
        return acJ != null && acJ.bPM.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xl() {
        if (e.acD() != null && e.acD().GC() != null && bBg != null) {
            b.a GC = e.acD().GC();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(GC.getAppFrameType());
            fVar.mAppId = GC.getAppId();
            fVar.mSource = GC.VH();
            fVar.n("appid", GC.getAppId());
            fVar.n("cuid", com.baidu.swan.apps.w.a.TZ().br(com.baidu.swan.apps.w.a.TU()));
            JSONObject lI = com.baidu.swan.apps.statistic.f.lI(GC.VJ());
            if (lI != null) {
                fVar.n("keyfeed", lI.optString("keyfeed"));
            }
            com.baidu.swan.apps.statistic.f.a(bBg, fVar);
        }
        bBg = null;
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
        private boolean bBj;

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
                    if (d.this.bAW != null) {
                        d.this.bAW.jc("onCanplay");
                    }
                    this.bBj = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        Flow unused = d.bBg = com.baidu.swan.apps.statistic.f.lH("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.Xl();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc(MissionEvent.MESSAGE_STOP);
                    }
                    this.bBj = true;
                    if (d.this.mIsBackground) {
                        d.this.Xl();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.Xl();
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
                    if (d.this.bAW != null) {
                        d.this.bAW.d("onTimeUpdate", jSONObject);
                    }
                    if (this.bBj) {
                        d.this.seekTo(d.this.bBe.bAB);
                        this.bBj = false;
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
                    if (d.this.bAW != null) {
                        d.this.bAW.d("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.bBf = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.bBf);
                    if (d.this.bAW == null || currentProgress < d.this.bBf) {
                        return true;
                    }
                    d.this.bAW.jc("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.bAW != null) {
                        d.this.bAW.jc("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
