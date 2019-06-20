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
    private com.baidu.swan.apps.media.audio.b.a aAW;
    private c aBe;
    private Context mContext;
    private com.baidu.swan.apps.media.audio.a aBf = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int aBg = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        Gr().pause();
        if (this.aAW != null) {
            this.aAW.fj("onPause");
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            Gr().seek(i * 1000);
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.aAW != null) {
                this.aAW.fj("onSeeking");
            }
        }
    }

    public void stop() {
        Gr().stop();
        if (this.aAW != null) {
            this.aAW.fj("onStop");
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.aBe != null) {
            Gr().release();
            e.FV().Fz();
            this.aBe = null;
        }
    }

    public int getDuration() {
        return Gr().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !Gr().isPlaying();
    }

    private c Gr() {
        if (this.aBe == null) {
            this.aBe = new c(this.mContext);
            this.aBe.a(new a());
        }
        return this.aBe;
    }

    public com.baidu.swan.apps.media.audio.a Gs() {
        return this.aBf;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.aBf = aVar;
        if (this.aBf.aAA != null) {
            try {
                this.aAW = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aBf.aAA));
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
        if (!this.aBf.Gh()) {
            String str = this.aBf.mUrl;
            com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
            if (this.aBf.aAB && Lq != null) {
                str = this.aAW.Gt() ? g.jp(str) : com.baidu.swan.apps.storage.b.b(str, Lq);
            }
            Gr().an(this.aBf.fe(str), str);
            e.FV().Fy();
        }
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        Gr().resume();
    }

    public void bt(boolean z) {
        if (this.aBe != null) {
            Gr().bt(z);
            e.FV().Fy();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.aBf = aVar;
        if (this.aAW != null) {
            this.aAW.fi(this.aBf.aAA);
        }
        play();
    }

    public Object ff(String str) {
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
                return Integer.valueOf(Gr().getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.aBf.mUrl;
            case 4:
                return Integer.valueOf(this.aBf.aAy);
            case 5:
                return Integer.valueOf(this.aBg);
            case 6:
                return this.aBf.mTitle;
            case 7:
                return this.aBf.aAw;
            case '\b':
                return this.aBf.aAx;
            case '\t':
                return this.aBf.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements c.a {
        private boolean aBh;

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
                    if (d.this.aAW != null) {
                        d.this.aAW.fj("onCanplay");
                    }
                    this.aBh = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.aAW != null) {
                        d.this.aAW.fj("onPlay");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.aAW != null) {
                        d.this.aAW.fj("onPause");
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.aAW != null) {
                        d.this.aAW.fj("onStop");
                    }
                    this.aBh = true;
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.aAW != null) {
                        d.this.aAW.fj("onEnded");
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
                    if (d.this.aAW != null) {
                        d.this.aAW.f("onTimeUpdate", jSONObject);
                    }
                    if (this.aBh) {
                        d.this.seekTo(d.this.aBf.aAy);
                        this.aBh = false;
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
                    if (d.this.aAW != null) {
                        d.this.aAW.f("onError", jSONObject);
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                    d.this.aBg = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.aBg);
                    if (d.this.aAW == null || d.this.mCurrentPosition < d.this.aBg) {
                        return true;
                    }
                    d.this.aAW.fj("onWaiting");
                    return true;
                default:
                    return false;
            }
        }
    }
}
