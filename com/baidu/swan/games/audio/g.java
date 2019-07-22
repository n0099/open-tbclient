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
public class g extends EventTargetImpl implements a, b {
    String aBc;
    @V8JavascriptField
    public boolean autoplay;
    private com.baidu.swan.games.e.b beU;
    private AudioPlayer beV;
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
    public float startTime;
    @V8JavascriptField
    public float volume;

    public g(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.beU = bVar;
        Ra();
    }

    private void init() {
        if (this.beV != null) {
            e eVar = new e(this, f.QW());
            eVar.a(this);
            this.beV.a(eVar);
        }
    }

    private void Ra() {
        String valueOf = String.valueOf(c.QO());
        this.aBc = valueOf;
        this.beV = iP(valueOf);
        init();
    }

    private void prepare() {
        com.baidu.swan.games.audio.b.b.Rd().Re().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.beV.a(f.a(g.this));
                if (g.this.autoplay) {
                    g.this.beV.play();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void play() {
        if (this.beV != null) {
            com.baidu.swan.games.audio.b.b.Rd().Re().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.beV.play();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void pause() {
        if (this.beV != null) {
            com.baidu.swan.games.audio.b.b.Rd().Re().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.beV.pause();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void seek(final float f) {
        if (this.beV != null) {
            com.baidu.swan.games.audio.b.b.Rd().Re().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.beV.ah(f);
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void stop() {
        if (this.beV != null) {
            com.baidu.swan.games.audio.b.b.Rd().Re().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.beV.stop();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void destroy() {
        if (this.beV != null) {
            com.baidu.swan.games.audio.b.b.Rd().Re().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.beV.release();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        if (this.beV != null) {
            return this.beV.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        if (this.beV != null) {
            return this.beV.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        if (this.beV != null) {
            this.beV.isPaused();
            return true;
        }
        return true;
    }

    public int QQ() {
        if (this.beV != null) {
            return this.beV.QQ();
        }
        return 0;
    }

    private static AudioPlayer iP(String str) {
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
                this.beV.b(f.a(this));
                return;
            case 2:
                if (f.ai(this.volume)) {
                    this.beV.b(f.a(this));
                    return;
                } else {
                    this.volume = this.beV.getVolume();
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
                this.buffered = QQ();
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
