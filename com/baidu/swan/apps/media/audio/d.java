package com.baidu.swan.apps.media.audio;

import android.content.Context;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.c;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.f.g;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.audio.b.a aBE;
    private c aBM;
    private Context mContext;
    private com.baidu.swan.apps.media.audio.a aBN = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int aBO = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        Hb().pause();
        if (this.aBE != null) {
            this.aBE.fo("onPause");
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            Hb().seek(i * 1000);
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.aBE != null) {
                this.aBE.fo("onSeeking");
            }
        }
    }

    public void stop() {
        Hb().stop();
        if (this.aBE != null) {
            this.aBE.fo("onStop");
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.aBM != null) {
            Hb().release();
            e.GF().Gj();
            this.aBM = null;
        }
    }

    public int getDuration() {
        return Hb().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !Hb().isPlaying();
    }

    private c Hb() {
        if (this.aBM == null) {
            this.aBM = new c(this.mContext);
            this.aBM.a(new a());
        }
        return this.aBM;
    }

    public com.baidu.swan.apps.media.audio.a Hc() {
        return this.aBN;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.aBN = aVar;
        if (this.aBN.aBi != null) {
            try {
                this.aBE = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aBN.aBi));
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (DEBUG) {
                    Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                }
            }
        }
        play();
    }

    private void play() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        if (!this.aBN.GR()) {
            String str = this.aBN.mUrl;
            com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
            if (this.aBN.aBj && Md != null) {
                str = this.aBE.Hd() ? g.jx(str) : com.baidu.swan.apps.storage.b.b(str, Md);
            }
            Hb().an(this.aBN.fj(str), str);
            e.GF().Gi();
        }
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        Hb().resume();
    }

    public void bw(boolean z) {
        if (this.aBM != null) {
            Hb().bw(z);
            e.GF().Gi();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.aBN = aVar;
        if (this.aBE != null) {
            this.aBE.fn(this.aBN.aBi);
        }
        play();
    }

    public Object fk(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2129294769:
                if (str.equals("startTime")) {
                    c = 4;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals(UBC.CONTENT_KEY_DURATION)) {
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
                return Integer.valueOf(Hb().getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.aBN.mUrl;
            case 4:
                return Integer.valueOf(this.aBN.aBg);
            case 5:
                return Integer.valueOf(this.aBO);
            case 6:
                return this.aBN.mTitle;
            case 7:
                return this.aBN.aBe;
            case '\b':
                return this.aBN.aBf;
            case '\t':
                return this.aBN.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements c.a {
        private boolean aBP;

        private a() {
        }

        @Override // com.baidu.swan.apps.media.audio.c.a
        public boolean j(Message message) {
            int i = message.what;
            int i2 = message.arg1;
            int i3 = message.arg2;
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1001:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onCanPlay");
                    if (d.this.aBE != null) {
                        d.this.aBE.fo("onCanplay");
                    }
                    this.aBP = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.aBE != null) {
                        d.this.aBE.fo("onPlay");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.aBE != null) {
                        d.this.aBE.fo("onPause");
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.aBE != null) {
                        d.this.aBE.fo("onStop");
                    }
                    this.aBP = true;
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.aBE != null) {
                        d.this.aBE.fo("onEnded");
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    d.this.mCurrentPosition = i3;
                    try {
                        jSONObject.putOpt("currentTime", Integer.valueOf(d.this.getCurrentPosition()));
                        jSONObject.putOpt(UBC.CONTENT_KEY_DURATION, Integer.valueOf(d.this.getDuration() / 1000));
                    } catch (JSONException e) {
                        if (d.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                    if (d.this.aBE != null) {
                        d.this.aBE.f("onTimeUpdate", jSONObject);
                    }
                    if (this.aBP) {
                        d.this.seekTo(d.this.aBN.aBg);
                        this.aBP = false;
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                    try {
                        jSONObject.putOpt("errorCode", Integer.valueOf(i2));
                    } catch (JSONException e2) {
                        if (d.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onError code:" + i2);
                    if (d.this.aBE != null) {
                        d.this.aBE.f("onError", jSONObject);
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                    d.this.aBO = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.aBO);
                    if (d.this.aBE == null || d.this.mCurrentPosition < d.this.aBO) {
                        return true;
                    }
                    d.this.aBE.fo("onWaiting");
                    return true;
                default:
                    return false;
            }
        }
    }
}
