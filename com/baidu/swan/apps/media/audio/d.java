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
    private static com.baidu.swan.apps.statistic.a cyT;
    private com.baidu.swan.apps.media.audio.b.a cyJ;
    private c cyQ;
    @Nullable
    private com.baidu.swan.apps.v.a cyU;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a cyR = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int cyS = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.cyQ != null) {
            this.cyQ.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.cyQ != null) {
                this.cyQ.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.i("backgroundAudio", "seekTo " + i);
            if (this.cyJ != null) {
                this.cyJ.oi("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.cyQ != null) {
            this.cyQ.stop();
        }
        if (this.cyU != null) {
            com.baidu.swan.apps.t.a.aoJ().unregisterActivityLifecycleCallbacks(this.cyU);
            this.cyU = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.i("backgroundAudio", "release ");
        if (this.cyQ != null && !asE()) {
            this.cyQ.release();
            f.arY().arz();
            this.cyQ = null;
            cyT = null;
        }
    }

    public int getDuration() {
        if (this.cyQ != null) {
            return this.cyQ.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.cyQ == null || !this.cyQ.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c asB() {
        if (this.cyQ == null) {
            this.cyQ = new c(this.mContext);
            this.cyQ.a(new a());
        }
        return this.cyQ;
    }

    public com.baidu.swan.apps.media.audio.a asC() {
        return this.cyR;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.cyR = aVar;
        if (this.cyR.cyq != null) {
            try {
                this.cyJ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.cyR.cyq));
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
        if (this.cyU != null) {
            com.baidu.swan.apps.t.a.aoJ().unregisterActivityLifecycleCallbacks(this.cyU);
        }
        this.cyU = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.asE()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.cyT = null;
                        return;
                    } else if (d.cyT == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.cyT = h.rn("1044");
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
        com.baidu.swan.apps.t.a.aoJ().registerActivityLifecycleCallbacks(this.cyU);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.cyR.asv()) {
            asD();
            String str = this.cyR.mUrl;
            e azI = e.azI();
            if (com.baidu.swan.apps.storage.b.rJ(str) == PathType.CLOUD) {
                oc(str);
            } else {
                c(str, azI);
            }
            f.arY().ary();
        }
    }

    private void oc(String str) {
        com.baidu.swan.apps.t.a.apc().a(this.mContext, str, new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void I(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.asB().bL(d.this.cyR.ob(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.cyR.cyr && eVar != null) {
            if (this.cyJ.asI()) {
                d = n.rR(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        asB().bL(this.cyR.ob(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.cyQ != null) {
            this.cyQ.resume();
        }
    }

    public void eH(boolean z) {
        if (this.cyQ != null) {
            this.cyQ.eH(z);
            f.arY().ary();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.cyR = aVar;
        if (this.cyJ != null) {
            this.cyJ.oh(this.cyR.cyq);
        }
        play();
    }

    public Object od(String str) {
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
                return this.cyR.mUrl;
            case 4:
                return Integer.valueOf(this.cyR.cyo);
            case 5:
                return Integer.valueOf(this.cyS);
            case 6:
                return this.cyR.mTitle;
            case 7:
                return this.cyR.cyl;
            case '\b':
                return this.cyR.cym;
            case '\t':
                return this.cyR.mCoverUrl;
            case '\n':
                return this.cyR.cyn;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asE() {
        SwanAppConfigData azR = e.azI() != null ? e.azI().azR() : null;
        return azR != null && azR.cRf.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asF() {
        if (e.azI() != null && e.azI().XZ() != null && cyT != null) {
            b.a XZ = e.azI().XZ();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jv(XZ.getAppFrameType());
            fVar.mAppId = XZ.getAppId();
            fVar.mSource = XZ.aqN();
            fVar.u("appid", XZ.getAppId());
            fVar.u("cuid", com.baidu.swan.apps.t.a.aoO().bl(com.baidu.swan.apps.t.a.aoJ()));
            JSONObject rp = h.rp(XZ.aqP());
            if (rp != null) {
                fVar.u("keyfeed", rp.optString("keyfeed"));
            }
            h.a(cyT, fVar);
        }
        cyT = null;
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
        private boolean cyW;

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
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi("onCanplay");
                    }
                    this.cyW = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.cyT = h.rn("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.asF();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi(MissionEvent.MESSAGE_STOP);
                    }
                    this.cyW = true;
                    if (d.this.mIsBackground) {
                        d.this.asF();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi("onEnded");
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
                    if (d.this.cyJ != null) {
                        d.this.cyJ.e("onTimeUpdate", jSONObject);
                    }
                    if (this.cyW) {
                        if (d.this.cyR.cyo > 0) {
                            d.this.seekTo(d.this.cyR.cyo);
                        }
                        this.cyW = false;
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
                    if (d.this.cyJ != null) {
                        d.this.cyJ.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.cyS = i2;
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onDownloadProgress " + d.this.cyS);
                    if (d.this.cyJ == null || currentProgress < d.this.cyS) {
                        return true;
                    }
                    d.this.cyJ.oi("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPrev");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onNext");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeekEnd");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onSeeking");
                    if (d.this.cyJ != null) {
                        d.this.cyJ.oi("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
