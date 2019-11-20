package com.baidu.swan.apps.media.audio;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.c;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.f.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.audio.b.a aUZ;
    private c aVh;
    private Context mContext;
    private com.baidu.swan.apps.media.audio.a aVi = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int aVj = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        Ma().pause();
        if (this.aUZ != null) {
            this.aUZ.fW("onPause");
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            Ma().seek(i * 1000);
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.aUZ != null) {
                this.aUZ.fW("onSeeking");
            }
        }
    }

    public void stop() {
        Ma().stop();
        if (this.aUZ != null) {
            this.aUZ.fW("onStop");
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.aVh != null) {
            Ma().release();
            e.LE().Li();
            this.aVh = null;
        }
    }

    public int getDuration() {
        return Ma().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !Ma().isPlaying();
    }

    private c Ma() {
        if (this.aVh == null) {
            this.aVh = new c(this.mContext);
            this.aVh.a(new a());
        }
        return this.aVh;
    }

    public com.baidu.swan.apps.media.audio.a Mb() {
        return this.aVi;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.aVi = aVar;
        if (this.aVi.aUC != null) {
            try {
                this.aUZ = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aVi.aUC));
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
        if (!this.aVi.LQ()) {
            String str = this.aVi.mUrl;
            com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
            if (this.aVi.aUD && Ra != null) {
                str = this.aUZ.Mc() ? g.kb(str) : com.baidu.swan.apps.storage.b.b(str, Ra);
            }
            Ma().av(this.aVi.fR(str), str);
            e.LE().Lh();
        }
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        Ma().resume();
    }

    public void bO(boolean z) {
        if (this.aVh != null) {
            Ma().bO(z);
            e.LE().Lh();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.aVi = aVar;
        if (this.aUZ != null) {
            this.aUZ.fV(this.aVi.aUC);
        }
        play();
    }

    public Object fS(String str) {
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
                return Integer.valueOf(Ma().getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.aVi.mUrl;
            case 4:
                return Integer.valueOf(this.aVi.aUA);
            case 5:
                return Integer.valueOf(this.aVj);
            case 6:
                return this.aVi.mTitle;
            case 7:
                return this.aVi.aUy;
            case '\b':
                return this.aVi.aUz;
            case '\t':
                return this.aVi.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements c.a {
        private boolean aVk;

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
                    if (d.this.aUZ != null) {
                        d.this.aUZ.fW("onCanplay");
                    }
                    this.aVk = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.aUZ != null) {
                        d.this.aUZ.fW("onPlay");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.aUZ != null) {
                        d.this.aUZ.fW("onPause");
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.aUZ != null) {
                        d.this.aUZ.fW("onStop");
                    }
                    this.aVk = true;
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.aUZ != null) {
                        d.this.aUZ.fW("onEnded");
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
                    if (d.this.aUZ != null) {
                        d.this.aUZ.f("onTimeUpdate", jSONObject);
                    }
                    if (this.aVk) {
                        d.this.seekTo(d.this.aVi.aUA);
                        this.aVk = false;
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
                    if (d.this.aUZ != null) {
                        d.this.aUZ.f("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    d.this.aVj = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.aVj);
                    if (d.this.aUZ == null || d.this.mCurrentPosition < d.this.aVj) {
                        return true;
                    }
                    d.this.aUZ.fW("onWaiting");
                    return true;
                default:
                    return false;
            }
        }
    }
}
