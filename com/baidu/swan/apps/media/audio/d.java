package com.baidu.swan.apps.media.audio;

import android.content.Context;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.c;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.f.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.audio.b.a aCc;
    private c aCk;
    private Context mContext;
    private com.baidu.swan.apps.media.audio.a aCl = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int aCm = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        Hf().pause();
        if (this.aCc != null) {
            this.aCc.fq("onPause");
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            Hf().seek(i * 1000);
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.aCc != null) {
                this.aCc.fq("onSeeking");
            }
        }
    }

    public void stop() {
        Hf().stop();
        if (this.aCc != null) {
            this.aCc.fq("onStop");
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.aCk != null) {
            Hf().release();
            e.GJ().Gn();
            this.aCk = null;
        }
    }

    public int getDuration() {
        return Hf().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !Hf().isPlaying();
    }

    private c Hf() {
        if (this.aCk == null) {
            this.aCk = new c(this.mContext);
            this.aCk.a(new a());
        }
        return this.aCk;
    }

    public com.baidu.swan.apps.media.audio.a Hg() {
        return this.aCl;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.aCl = aVar;
        if (this.aCl.aBG != null) {
            try {
                this.aCc = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aCl.aBG));
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
        if (!this.aCl.GV()) {
            String str = this.aCl.mUrl;
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (this.aCl.aBH && Mh != null) {
                str = this.aCc.Hh() ? g.jz(str) : com.baidu.swan.apps.storage.b.b(str, Mh);
            }
            Hf().an(this.aCl.fl(str), str);
            e.GJ().Gm();
        }
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        Hf().resume();
    }

    public void bw(boolean z) {
        if (this.aCk != null) {
            Hf().bw(z);
            e.GJ().Gm();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.aCl = aVar;
        if (this.aCc != null) {
            this.aCc.fp(this.aCl.aBG);
        }
        play();
    }

    public Object fm(String str) {
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
                return Integer.valueOf(Hf().getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.aCl.mUrl;
            case 4:
                return Integer.valueOf(this.aCl.aBE);
            case 5:
                return Integer.valueOf(this.aCm);
            case 6:
                return this.aCl.mTitle;
            case 7:
                return this.aCl.aBC;
            case '\b':
                return this.aCl.aBD;
            case '\t':
                return this.aCl.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements c.a {
        private boolean aCn;

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
                    if (d.this.aCc != null) {
                        d.this.aCc.fq("onCanplay");
                    }
                    this.aCn = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.aCc != null) {
                        d.this.aCc.fq("onPlay");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.aCc != null) {
                        d.this.aCc.fq("onPause");
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.aCc != null) {
                        d.this.aCc.fq("onStop");
                    }
                    this.aCn = true;
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.aCc != null) {
                        d.this.aCc.fq("onEnded");
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
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
                    if (d.this.aCc != null) {
                        d.this.aCc.f("onTimeUpdate", jSONObject);
                    }
                    if (this.aCn) {
                        d.this.seekTo(d.this.aCl.aBE);
                        this.aCn = false;
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
                    if (d.this.aCc != null) {
                        d.this.aCc.f("onError", jSONObject);
                        return true;
                    }
                    return true;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                    d.this.aCm = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.aCm);
                    if (d.this.aCc == null || d.this.mCurrentPosition < d.this.aCm) {
                        return true;
                    }
                    d.this.aCc.fq("onWaiting");
                    return true;
                default:
                    return false;
            }
        }
    }
}
