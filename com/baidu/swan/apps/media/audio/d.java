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
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.i.n;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.statistic.a ckj;
    private com.baidu.swan.apps.media.audio.b.a cjZ;
    private c ckg;
    @Nullable
    private com.baidu.swan.apps.w.a ckk;
    private Context mContext;
    private boolean mIsBackground;
    private com.baidu.swan.apps.media.audio.a ckh = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int cki = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        if (this.ckg != null) {
            this.ckg.pause();
        }
    }

    public void seekTo(int i) {
        if (i >= 0) {
            if (this.ckg != null) {
                this.ckg.seek(i * 1000);
            }
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.cjZ != null) {
                this.cjZ.lB("onSeeking");
            }
        }
    }

    public void stop() {
        if (this.ckg != null) {
            this.ckg.stop();
        }
        if (this.ckk != null) {
            com.baidu.swan.apps.u.a.aeR().unregisterActivityLifecycleCallbacks(this.ckk);
            this.ckk = null;
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.ckg != null && !aiu()) {
            this.ckg.release();
            f.ahV().ahw();
            this.ckg = null;
            ckj = null;
        }
    }

    public int getDuration() {
        if (this.ckg != null) {
            return this.ckg.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return this.ckg == null || !this.ckg.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c air() {
        if (this.ckg == null) {
            this.ckg = new c(this.mContext);
            this.ckg.a(new a());
        }
        return this.ckg;
    }

    public com.baidu.swan.apps.media.audio.a ais() {
        return this.ckh;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.ckh = aVar;
        if (this.ckh.cjG != null) {
            try {
                this.cjZ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.ckh.cjG));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void ait() {
        if (this.ckk != null) {
            com.baidu.swan.apps.u.a.aeR().unregisterActivityLifecycleCallbacks(this.ckk);
        }
        this.ckk = new com.baidu.swan.apps.w.a() { // from class: com.baidu.swan.apps.media.audio.d.1
            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                d.this.mIsBackground = true;
                if (d.this.aiu()) {
                    if (d.this.isPaused()) {
                        com.baidu.swan.apps.statistic.a unused = d.ckj = null;
                        return;
                    } else if (d.ckj == null) {
                        com.baidu.swan.apps.statistic.a unused2 = d.ckj = h.ow("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                d.this.stop();
                com.baidu.swan.apps.console.c.w("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }

            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                d.this.mIsBackground = false;
                if (!d.this.isPaused()) {
                    d.this.aiv();
                }
            }
        };
        com.baidu.swan.apps.u.a.aeR().registerActivityLifecycleCallbacks(this.ckk);
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (!this.ckh.aik()) {
            ait();
            String str = this.ckh.mUrl;
            e aoF = e.aoF();
            if (com.baidu.swan.apps.storage.b.oQ(str) == PathType.CLOUD) {
                lw(str);
            } else {
                c(str, aoF);
            }
            f.ahV().ahv();
        }
    }

    private void lw(String str) {
        com.baidu.swan.apps.u.a.afk().a(this.mContext, str, new com.baidu.swan.apps.aq.e.b<String>() { // from class: com.baidu.swan.apps.media.audio.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: onCallback */
            public void H(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    d.this.air().bu(d.this.ckh.lv(str2), str2);
                }
            }
        });
    }

    private void c(String str, e eVar) {
        String d;
        if (this.ckh.cjH && eVar != null) {
            if (this.cjZ.aiy()) {
                d = n.oY(str);
            } else {
                d = com.baidu.swan.apps.storage.b.d(str, eVar);
            }
            str = d;
        }
        air().bu(this.ckh.lv(str), str);
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        }
        if (this.ckg != null) {
            this.ckg.resume();
        }
    }

    public void ee(boolean z) {
        if (this.ckg != null) {
            this.ckg.ee(z);
            f.ahV().ahv();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.ckh = aVar;
        if (this.cjZ != null) {
            this.cjZ.lA(this.ckh.cjG);
        }
        play();
    }

    public Object lx(String str) {
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
                return this.ckh.mUrl;
            case 4:
                return Integer.valueOf(this.ckh.cjE);
            case 5:
                return Integer.valueOf(this.cki);
            case 6:
                return this.ckh.mTitle;
            case 7:
                return this.ckh.cjB;
            case '\b':
                return this.ckh.cjC;
            case '\t':
                return this.ckh.mCoverUrl;
            case '\n':
                return this.ckh.cjD;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiu() {
        SwanAppConfigData aoO = e.aoF() != null ? e.aoF().aoO() : null;
        return aoO != null && aoO.cAF.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiv() {
        if (e.aoF() != null && e.aoF().QJ() != null && ckj != null) {
            b.a QJ = e.aoF().QJ();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.gU(QJ.getAppFrameType());
            fVar.mAppId = QJ.getAppId();
            fVar.mSource = QJ.agK();
            fVar.v("appid", QJ.getAppId());
            fVar.v("cuid", com.baidu.swan.apps.u.a.aeW().bc(com.baidu.swan.apps.u.a.aeR()));
            JSONObject ox = h.ox(QJ.agM());
            if (ox != null) {
                fVar.v("keyfeed", ox.optString("keyfeed"));
            }
            h.a(ckj, fVar);
        }
        ckj = null;
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
        private boolean ckm;

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
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB("onCanplay");
                    }
                    this.ckm = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB("onPlay");
                    }
                    if (d.this.mIsBackground) {
                        com.baidu.swan.apps.statistic.a unused = d.ckj = h.ow("1044");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB(MissionEvent.MESSAGE_PAUSE);
                    }
                    if (d.this.mIsBackground) {
                        d.this.aiv();
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB(MissionEvent.MESSAGE_STOP);
                    }
                    this.ckm = true;
                    if (d.this.mIsBackground) {
                        d.this.aiv();
                        return true;
                    }
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB("onEnded");
                    }
                    if (d.this.mIsBackground) {
                        d.this.aiv();
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
                    if (d.this.cjZ != null) {
                        d.this.cjZ.e("onTimeUpdate", jSONObject);
                    }
                    if (this.ckm) {
                        if (d.this.ckh.cjE > 0) {
                            d.this.seekTo(d.this.ckh.cjE);
                        }
                        this.ckm = false;
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
                    if (d.this.cjZ != null) {
                        d.this.cjZ.e("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    int currentProgress = d.this.getCurrentProgress();
                    d.this.cki = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.cki);
                    if (d.this.cjZ == null || currentProgress < d.this.cki) {
                        return true;
                    }
                    d.this.cjZ.lB("onWaiting");
                    return true;
                case 1009:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onPrev");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB("onPrev");
                        return true;
                    }
                    return true;
                case 1010:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onNext");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB("onNext");
                        return true;
                    }
                    return true;
                case 1011:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeekEnd");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB("onSeeked");
                        return true;
                    }
                    return true;
                case 1012:
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onSeeking");
                    if (d.this.cjZ != null) {
                        d.this.cjZ.lB("onSeeking");
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
