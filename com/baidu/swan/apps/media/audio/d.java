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
    private c aAh;
    private com.baidu.swan.apps.media.audio.b.a azZ;
    private Context mContext;
    private com.baidu.swan.apps.media.audio.a aAi = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int aAj = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        Ev().pause();
        if (this.azZ != null) {
            this.azZ.eZ("onPause");
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            Ev().seek(i * 1000);
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.azZ != null) {
                this.azZ.eZ("onSeeking");
            }
        }
    }

    public void stop() {
        Ev().stop();
        if (this.azZ != null) {
            this.azZ.eZ("onStop");
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.aAh != null) {
            Ev().release();
            e.Ea().DE();
            this.aAh = null;
        }
    }

    public int getDuration() {
        return Ev().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !Ev().isPlaying();
    }

    private c Ev() {
        if (this.aAh == null) {
            this.aAh = new c(this.mContext);
            this.aAh.a(new a());
        }
        return this.aAh;
    }

    public com.baidu.swan.apps.media.audio.a Ew() {
        return this.aAi;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.aAi = aVar;
        if (this.aAi.azD != null) {
            try {
                this.azZ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aAi.azD));
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
        if (!this.aAi.El()) {
            String str = this.aAi.mUrl;
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            if (this.aAi.azE && IV != null) {
                str = this.azZ.Ex() ? g.iG(str) : com.baidu.swan.apps.storage.b.b(str, IV);
            }
            Ev().am(this.aAi.eU(str), str);
            e.Ea().DD();
        }
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        Ev().resume();
    }

    public void bk(boolean z) {
        if (this.aAh != null) {
            Ev().bk(z);
            e.Ea().DD();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.aAi = aVar;
        if (this.azZ != null) {
            this.azZ.eY(this.aAi.azD);
        }
        play();
    }

    public Object eV(String str) {
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
                return Integer.valueOf(Ev().getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.aAi.mUrl;
            case 4:
                return Integer.valueOf(this.aAi.azB);
            case 5:
                return Integer.valueOf(this.aAj);
            case 6:
                return this.aAi.mTitle;
            case 7:
                return this.aAi.azy;
            case '\b':
                return this.aAi.azz;
            case '\t':
                return this.aAi.azA;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements c.a {
        private boolean aAk;

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
                    if (d.this.azZ != null) {
                        d.this.azZ.eZ("onCanplay");
                    }
                    this.aAk = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.azZ != null) {
                        d.this.azZ.eZ("onPlay");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.azZ != null) {
                        d.this.azZ.eZ("onPause");
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.azZ != null) {
                        d.this.azZ.eZ("onStop");
                    }
                    this.aAk = true;
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.azZ != null) {
                        d.this.azZ.eZ("onEnded");
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
                    if (d.this.azZ != null) {
                        d.this.azZ.f("onTimeUpdate", jSONObject);
                    }
                    if (this.aAk) {
                        d.this.seekTo(d.this.aAi.azB);
                        this.aAk = false;
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
                    if (d.this.azZ != null) {
                        d.this.azZ.f("onError", jSONObject);
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                    d.this.aAj = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.aAj);
                    if (d.this.azZ == null || d.this.mCurrentPosition < d.this.aAj) {
                        return true;
                    }
                    d.this.azZ.eZ("onWaiting");
                    return true;
                default:
                    return false;
            }
        }
    }
}
