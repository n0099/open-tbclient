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
    private c aAd;
    private com.baidu.swan.apps.media.audio.b.a azV;
    private Context mContext;
    private com.baidu.swan.apps.media.audio.a aAe = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int aAf = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        Ex().pause();
        if (this.azV != null) {
            this.azV.eY("onPause");
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            Ex().seek(i * 1000);
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.azV != null) {
                this.azV.eY("onSeeking");
            }
        }
    }

    public void stop() {
        Ex().stop();
        if (this.azV != null) {
            this.azV.eY("onStop");
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.aAd != null) {
            Ex().release();
            e.Ec().DG();
            this.aAd = null;
        }
    }

    public int getDuration() {
        return Ex().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !Ex().isPlaying();
    }

    private c Ex() {
        if (this.aAd == null) {
            this.aAd = new c(this.mContext);
            this.aAd.a(new a());
        }
        return this.aAd;
    }

    public com.baidu.swan.apps.media.audio.a Ey() {
        return this.aAe;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.aAe = aVar;
        if (this.aAe.azz != null) {
            try {
                this.azV = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aAe.azz));
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
        if (!this.aAe.En()) {
            String str = this.aAe.mUrl;
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            if (this.aAe.azA && IX != null) {
                str = this.azV.Ez() ? g.iF(str) : com.baidu.swan.apps.storage.b.b(str, IX);
            }
            Ex().am(this.aAe.eT(str), str);
            e.Ec().DF();
        }
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        Ex().resume();
    }

    public void bk(boolean z) {
        if (this.aAd != null) {
            Ex().bk(z);
            e.Ec().DF();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.aAe = aVar;
        if (this.azV != null) {
            this.azV.eX(this.aAe.azz);
        }
        play();
    }

    public Object eU(String str) {
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
                return Integer.valueOf(Ex().getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.aAe.mUrl;
            case 4:
                return Integer.valueOf(this.aAe.azx);
            case 5:
                return Integer.valueOf(this.aAf);
            case 6:
                return this.aAe.mTitle;
            case 7:
                return this.aAe.azu;
            case '\b':
                return this.aAe.azv;
            case '\t':
                return this.aAe.azw;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements c.a {
        private boolean aAg;

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
                    if (d.this.azV != null) {
                        d.this.azV.eY("onCanplay");
                    }
                    this.aAg = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.azV != null) {
                        d.this.azV.eY("onPlay");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.azV != null) {
                        d.this.azV.eY("onPause");
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.azV != null) {
                        d.this.azV.eY("onStop");
                    }
                    this.aAg = true;
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.azV != null) {
                        d.this.azV.eY("onEnded");
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
                    if (d.this.azV != null) {
                        d.this.azV.f("onTimeUpdate", jSONObject);
                    }
                    if (this.aAg) {
                        d.this.seekTo(d.this.aAe.azx);
                        this.aAg = false;
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
                    if (d.this.azV != null) {
                        d.this.azV.f("onError", jSONObject);
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                    d.this.aAf = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.aAf);
                    if (d.this.azV == null || d.this.mCurrentPosition < d.this.aAf) {
                        return true;
                    }
                    d.this.azV.eY("onWaiting");
                    return true;
                default:
                    return false;
            }
        }
    }
}
