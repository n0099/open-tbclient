package com.baidu.swan.games.audio;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.audio.b.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends EventTargetImpl implements a, b {
    @V8JavascriptField
    public boolean autoplay;
    @V8JavascriptField
    public int buffered;
    private AudioPlayer cYD;
    private com.baidu.swan.games.f.b cYE;
    String cop;
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

    public g(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.cYE = bVar;
        ayI();
    }

    private void init() {
        if (this.cYD != null) {
            e eVar = new e(this, f.ayE());
            eVar.a(this);
            this.cYD.a(eVar);
        }
    }

    private void ayI() {
        String valueOf = String.valueOf(c.ayt());
        this.cop = valueOf;
        this.cYD = ri(valueOf);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(final boolean z) {
        if (this.cYD != null) {
            com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!z || g.this.cYD.ayB()) {
                        g.this.cYD.a(f.a(g.this));
                        if (g.this.autoplay) {
                            g.this.cYD.play();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void play() {
        if (this.cYD != null) {
            com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.cYD.play();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void pause() {
        if (this.cYD != null) {
            com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.cYD.pause();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void seek(final float f) {
        if (this.cYD != null) {
            com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.cYD.K(f);
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void stop() {
        if (this.cYD != null) {
            com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.cYD.stop();
                }
            });
        }
    }

    @Override // com.baidu.swan.games.audio.a
    @JavascriptInterface
    public void destroy() {
        if (this.cYD != null) {
            com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.g.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.cYD.release();
                }
            });
        }
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        com.baidu.swan.games.audio.b.b.ayL().a(jsArrayBuffer, new a.InterfaceC0427a() { // from class: com.baidu.swan.games.audio.g.7
            @Override // com.baidu.swan.games.audio.b.a.InterfaceC0427a
            public void ho(final String str) {
                g.this.cYE.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.audio.g.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.src = com.baidu.swan.apps.w.f.ajb().aiH().pj(str);
                        if (com.baidu.swan.apps.b.DEBUG) {
                            Log.d("Aigame AudioContext", "prepare path: " + g.this.src + " autoPlay: " + g.this.autoplay + " class: " + toString());
                        }
                        g.this.fM(true);
                    }
                });
            }

            @Override // com.baidu.swan.games.audio.b.a.InterfaceC0427a
            public void ayJ() {
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        if (this.cYD != null) {
            return (int) this.cYD.getDuration();
        }
        return 0;
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        if (this.cYD != null) {
            return this.cYD.getCurrentPosition();
        }
        return 0;
    }

    public int ayw() {
        if (this.cYD != null) {
            return this.cYD.ayw();
        }
        return 0;
    }

    private static AudioPlayer ri(String str) {
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
                if (str.equals(UserAccountActionItem.KEY_SRC)) {
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
                c(f.a(this));
                return;
            case 2:
                if (f.L(this.volume)) {
                    c(f.a(this));
                    return;
                } else {
                    this.volume = this.cYD.getVolume();
                    return;
                }
            case 3:
                fM(false);
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

    private void c(d dVar) {
        this.cYD.b(dVar);
    }

    @Override // com.baidu.swan.games.audio.b
    public void e(String str, JSONObject jSONObject) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1522036513:
                if (str.equals("buffered")) {
                    c = 0;
                    break;
                }
                break;
            case 3443508:
                if (str.equals(AlaStaticKeys.ALA_STATIC_VALUE_PLAY)) {
                    c = 2;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
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
                if (str.equals(BdStatsConstant.StatsType.ERROR)) {
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
            case 550609668:
                if (str.equals("canplay")) {
                    c = 7;
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
                this.buffered = ayw();
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
            case 7:
                this.duration = getDuration() / 1000;
                return;
            default:
                return;
        }
    }
}
