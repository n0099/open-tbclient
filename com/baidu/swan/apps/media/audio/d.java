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
    private com.baidu.swan.apps.media.audio.b.a aVr;
    private c aVz;
    private Context mContext;
    private com.baidu.swan.apps.media.audio.a aVA = new com.baidu.swan.apps.media.audio.a();
    private int mCurrentPosition = 0;
    private int aVB = 0;

    public d(Context context) {
        this.mContext = context;
    }

    public void pause() {
        LZ().pause();
        if (this.aVr != null) {
            this.aVr.fW("onPause");
        }
    }

    public void seekTo(int i) {
        if (i > 0) {
            LZ().seek(i * 1000);
            com.baidu.swan.apps.console.c.d("backgroundAudio", "seekTo " + i);
            if (this.aVr != null) {
                this.aVr.fW("onSeeking");
            }
        }
    }

    public void stop() {
        LZ().stop();
        if (this.aVr != null) {
            this.aVr.fW("onStop");
        }
    }

    public void release() {
        com.baidu.swan.apps.console.c.d("backgroundAudio", "release ");
        if (this.aVz != null) {
            LZ().release();
            e.LD().Lh();
            this.aVz = null;
        }
    }

    public int getDuration() {
        return LZ().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !LZ().isPlaying();
    }

    private c LZ() {
        if (this.aVz == null) {
            this.aVz = new c(this.mContext);
            this.aVz.a(new a());
        }
        return this.aVz;
    }

    public com.baidu.swan.apps.media.audio.a Ma() {
        return this.aVA;
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
        }
        this.aVA = aVar;
        if (this.aVA.aUU != null) {
            try {
                this.aVr = new com.baidu.swan.apps.media.audio.b.a(callbackHandler, new JSONObject(this.aVA.aUU));
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
        if (!this.aVA.LP()) {
            String str = this.aVA.mUrl;
            com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
            if (this.aVA.aUV && QZ != null) {
                str = this.aVr.Mb() ? g.kb(str) : com.baidu.swan.apps.storage.b.b(str, QZ);
            }
            LZ().av(this.aVA.fR(str), str);
            e.LD().Lg();
        }
    }

    public void resume() {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "play");
        }
        LZ().resume();
    }

    public void bO(boolean z) {
        if (this.aVz != null) {
            LZ().bO(z);
            e.LD().Lg();
        }
    }

    public void a(com.baidu.swan.apps.media.audio.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
        }
        this.aVA = aVar;
        if (this.aVr != null) {
            this.aVr.fV(this.aVA.aUU);
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
                return Integer.valueOf(LZ().getDuration() / 1000);
            case 1:
                return Integer.valueOf(this.mCurrentPosition);
            case 2:
                return Boolean.valueOf(isPaused());
            case 3:
                return this.aVA.mUrl;
            case 4:
                return Integer.valueOf(this.aVA.aUS);
            case 5:
                return Integer.valueOf(this.aVB);
            case 6:
                return this.aVA.mTitle;
            case 7:
                return this.aVA.aUQ;
            case '\b':
                return this.aVA.aUR;
            case '\t':
                return this.aVA.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements c.a {
        private boolean aVC;

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
                    if (d.this.aVr != null) {
                        d.this.aVr.fW("onCanplay");
                    }
                    this.aVC = true;
                    return true;
                case 1002:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPlay");
                    if (d.this.aVr != null) {
                        d.this.aVr.fW("onPlay");
                        return true;
                    }
                    return true;
                case 1003:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onPause");
                    if (d.this.aVr != null) {
                        d.this.aVr.fW("onPause");
                        return true;
                    }
                    return true;
                case 1004:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onStop");
                    if (d.this.aVr != null) {
                        d.this.aVr.fW("onStop");
                    }
                    this.aVC = true;
                    return true;
                case 1005:
                    com.baidu.swan.apps.console.c.i("backgroundAudio", "event onEnd");
                    if (d.this.aVr != null) {
                        d.this.aVr.fW("onEnded");
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
                    if (d.this.aVr != null) {
                        d.this.aVr.f("onTimeUpdate", jSONObject);
                    }
                    if (this.aVC) {
                        d.this.seekTo(d.this.aVA.aUS);
                        this.aVC = false;
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
                    if (d.this.aVr != null) {
                        d.this.aVr.f("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    d.this.aVB = i2;
                    com.baidu.swan.apps.console.c.d("backgroundAudio", "event onDownloadProgress " + d.this.aVB);
                    if (d.this.aVr == null || d.this.mCurrentPosition < d.this.aVB) {
                        return true;
                    }
                    d.this.aVr.fW("onWaiting");
                    return true;
                default:
                    return false;
            }
        }
    }
}
