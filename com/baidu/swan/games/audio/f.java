package com.baidu.swan.games.audio;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends EventTargetImpl implements a, b {
    @V8JavascriptField
    public boolean autoplay;
    String azv;
    private com.baidu.swan.games.e.b bac;
    private AudioPlayer bad;
    @V8JavascriptField
    public int buffered;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;
    @V8JavascriptField
    public boolean loop;
    @V8JavascriptField
    public boolean obeyMuteSwitch;
    @V8JavascriptField
    public boolean paused;
    @V8JavascriptField
    public String src;
    @V8JavascriptField
    public int startTime;
    @V8JavascriptField
    public float volume;

    public f(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.bac = bVar;
        No();
    }

    private void init() {
        if (this.bad != null) {
            d dVar = new d(this, e.Nk());
            dVar.a(this);
            this.bad.a(dVar);
        }
    }

    private void No() {
        String valueOf = String.valueOf(c.Ne());
        this.azv = valueOf;
        this.bad = hX(valueOf);
        init();
    }

    private void prepare() {
        com.baidu.swan.games.audio.b.b.Nr().Ns().post(new Runnable() { // from class: com.baidu.swan.games.audio.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.bad.b(e.a(f.this));
                if (f.this.autoplay) {
                    f.this.bad.play();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void play() {
        if (this.bad != null) {
            com.baidu.swan.games.audio.b.b.Nr().Ns().post(new Runnable() { // from class: com.baidu.swan.games.audio.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.bad.play();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void pause() {
        if (this.bad != null) {
            com.baidu.swan.games.audio.b.b.Nr().Ns().post(new Runnable() { // from class: com.baidu.swan.games.audio.f.3
                @Override // java.lang.Runnable
                public void run() {
                    f.this.bad.pause();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void seek(final int i) {
        if (this.bad != null) {
            com.baidu.swan.games.audio.b.b.Nr().Ns().post(new Runnable() { // from class: com.baidu.swan.games.audio.f.4
                @Override // java.lang.Runnable
                public void run() {
                    f.this.bad.seekTo(i);
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void stop() {
        if (this.bad != null) {
            com.baidu.swan.games.audio.b.b.Nr().Ns().post(new Runnable() { // from class: com.baidu.swan.games.audio.f.5
                @Override // java.lang.Runnable
                public void run() {
                    f.this.bad.stop();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void destroy() {
        if (this.bad != null) {
            com.baidu.swan.games.audio.b.b.Nr().Ns().post(new Runnable() { // from class: com.baidu.swan.games.audio.f.6
                @Override // java.lang.Runnable
                public void run() {
                    f.this.bad.release();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        if (this.bad != null) {
            return this.bad.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        if (this.bad != null) {
            return this.bad.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        if (this.bad != null) {
            this.bad.isPaused();
            return true;
        }
        return true;
    }

    public int Ng() {
        if (this.bad != null) {
            return this.bad.Ng();
        }
        return 0;
    }

    private static AudioPlayer hX(String str) {
        return new AudioPlayer(str);
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("Aigame AudioContext", str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2129294769:
                if (str.equals("startTime")) {
                    c = 1;
                    break;
                }
                break;
            case -810883302:
                if (str.equals("volume")) {
                    c = 2;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c = 3;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c = 0;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                this.bad.a(e.a(this));
                return;
            case 2:
                if (e.ag(this.volume)) {
                    this.bad.a(e.a(this));
                    return;
                } else {
                    this.volume = this.bad.getVolume();
                    return;
                }
            case 3:
                prepare();
                return;
            case 4:
                if (this.autoplay) {
                    play();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.swan.games.audio.b
    public void f(String str, JSONObject jSONObject) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1522036513:
                if (str.equals("buffered")) {
                    c = 0;
                    break;
                }
                break;
            case 3443508:
                if (str.equals("play")) {
                    c = 2;
                    break;
                }
                break;
            case 3540994:
                if (str.equals(IntentConfig.STOP)) {
                    c = 6;
                    break;
                }
                break;
            case 96651962:
                if (str.equals("ended")) {
                    c = 3;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 4;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c = 5;
                    break;
                }
                break;
            case 1762557398:
                if (str.equals("timeupdate")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.buffered = Ng();
                return;
            case 1:
                if (jSONObject != null) {
                    this.duration = getDuration() / 1000;
                    this.currentTime = getCurrentTime() / 1000.0d;
                    return;
                }
                return;
            case 2:
                this.paused = false;
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.paused = true;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public void removeEventListener(String str) {
        Map<String, List<JsFunction>> targetMap = getTargetMap();
        if (targetMap != null && targetMap.containsKey(str)) {
            targetMap.remove(str);
        }
    }
}
