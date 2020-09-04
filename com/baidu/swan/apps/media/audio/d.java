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
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a cyX;
    private com.baidu.swan.apps.media.audio.b.a cyN;
    private c cyU;
    @Nullable
    private com.baidu.swan.apps.v.a cyY;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a cyV = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int cyW = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.cyU != null) {
            this.cyU.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.cyU != null) {
                this.cyU.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.cyN != null) {
                this.cyN.oj("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.cyU != null) {
            this.cyU.stop();
        }
        if (this.cyY != null) {
            com.baidu.swan.apps.t.a.aoJ().unregisterActivityLifecycleCallbacks(this.cyY);
            this.cyY = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.cyU != null && !asE()) {
            this.cyU.release();
            f.arY().arz();
            this.cyU = null;
            cyX = null;
        }
    }

    public int getDuration() {
        if (this.cyU != null) {
            return this.cyU.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.cyU == null || !this.cyU.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c asB() {
        if (this.cyU == null) {
            this.cyU = new c(this.mContext);
            this.cyU.a(new a());
        }
        return this.cyU;
    }

    public com.baidu.swan.apps.media.audio.a asC() {
        return this.cyV;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.cyV = aVar;
        if (this.cyV.cyu != null) {
            try {
                this.cyN = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cyV.cyu));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void asD() {
        if (this.cyY != null) {
            com.baidu.swan.apps.t.a.aoJ().unregisterActivityLifecycleCallbacks(this.cyY);
        }
        this.cyY = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.asE()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.cyX = null;
                        return;
                    } else if (d.cyX == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.cyX = h.ro("1044");
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
                    d.this.asF();
                }
            }
        };
        com.baidu.swan.apps.t.a.aoJ().registerActivityLifecycleCallbacks(this.cyY);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.cyV.asv()) {
            asD();
            String str = this.cyV.mUrl;
            e azI = e.azI();
            if (com.baidu.swan.apps.storage.b.rK(str) == PathType.CLOUD) {
                od(str);
            } else {
                c(str, azI);
            }
            f.arY().ary();
        }
    }

    private void od(String str) {
        com.baidu.swan.apps.t.a.apc().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void I(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.asB().bL(d.this.cyV.oc(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.cyV.cyv && eVar != null) {
            if (this.cyN.asI()) {
                d = n.rS(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        asB().bL(this.cyV.oc(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.cyU != null) {
            this.cyU.resume();
        }
    }

    public void eI(boolean z) {
        if (this.cyU != null) {
            this.cyU.eI(z);
            f.arY().ary();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.cyV = aVar;
        if (this.cyN != null) {
            this.cyN.oi(this.cyV.cyu);
        }
        play();
    }

    public Object oe(String str) {
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
                return this.cyV.mUrl;
            case 4:
                return Integer.valueOf(this.cyV.cys);
            case 5:
                return Integer.valueOf(this.cyW);
            case 6:
                return this.cyV.mTitle;
            case 7:
                return this.cyV.cyp;
            case '\b':
                return this.cyV.cyq;
            case '\t':
                return this.cyV.mCoverUrl;
            case '\n':
                return this.cyV.cyr;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asE() {
        SwanAppConfigData azR = e.azI() != null ? e.azI().azR() : null;
        return azR != null && azR.cRj.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asF() {
        if (e.azI() != null && e.azI().XZ() != null && cyX != null) {
            b.a XZ = e.azI().XZ();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jv(XZ.getAppFrameType());
            fVar.mAppId = XZ.getAppId();
            fVar.mSource = XZ.aqN();
            fVar.u("appid", XZ.getAppId());
            fVar.u("cuid", com.baidu.swan.apps.t.a.aoO().bl(com.baidu.swan.apps.t.a.aoJ()));
            JSONObject rq = h.rq(XZ.aqP());
            if (rq != null) {
                fVar.u("keyfeed", rq.optString("keyfeed"));
            }
            h.a(cyX, fVar);
        }
        cyX = null;
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
        private boolean cza;

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
                    if (d.this.cyN != null) {
                        d.this.cyN.oj("onCanplay");
                    }
                    this.cza = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.cyX = h.ro("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.asF();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj(MissionEvent.MESSAGE_STOP);
                    }
                    this.cza = true;
                    if (d.this.mIsBackground) {
                        d.this.asF();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.asF();
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
                    if (d.this.cyN != null) {
                        d.this.cyN.e("onTimeUpdate", jSONObject);
                    }
                    if (this.cza) {
                        if (d.this.cyV.cys > 0) {
                            d.this.seekTo(d.this.cyV.cys);
                        }
                        this.cza = false;
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
                    if (d.this.cyN != null) {
                        d.this.cyN.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.cyW = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.cyW);
                    if (d.this.cyN == null || currentProgress < d.this.cyW) {
                        return true;
                    }
                    d.this.cyN.oj("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.cyN != null) {
                        d.this.cyN.oj("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
