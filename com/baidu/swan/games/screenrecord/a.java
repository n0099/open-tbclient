package com.baidu.swan.games.screenrecord;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.i.n;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.screenrecord.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class a extends c {
    private int cgQ;
    private String emM;
    private boolean emN;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> emO;
    private List<String> emP;
    private List<String> emQ;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.emN = false;
        this.emO = new ArrayList<>();
        this.emP = new ArrayList(3);
        this.emQ = new ArrayList(3);
    }

    @JavascriptInterface
    public void start() {
        start(null);
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "start");
        }
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.bbE().bbG()) {
            com.baidu.swan.games.binding.model.c k = k(jsObject);
            this.cgQ = k.optInt("duration", 10);
            if (this.cgQ <= 0) {
                this.cgQ = 10;
            }
            if (this.cgQ > 120) {
                this.cgQ = 120;
            }
            if (this.emP.size() == 0) {
                com.baidu.swan.c.d.deleteFile(n.xz("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a2 = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.emP, 3);
            xW(a2);
            this.emM = n.xz(a2);
            if (this.emM == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (k.optBoolean("microphoneEnabled", false)) {
                mL(2);
            }
            bbz();
            com.baidu.swan.games.u.b.a.bbP();
        }
    }

    private void bbz() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.cgQ + "," + this.emM);
        }
        this.emO.clear();
        this.emN = false;
        d.bbE().bbF().aA(this.cgQ, this.emM);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.bbE().bbF().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.bbE().bbG()) {
            d.bbE().bbF().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.bbE().bbF().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] xe = k.xe("timeRange");
            i(jsObject);
            double[] dArr = !c(xe) ? new double[]{3.0d, 3.0d} : xe;
            com.baidu.swan.games.screenrecord.a.b a2 = com.baidu.swan.games.screenrecord.a.b.a(d.bbE().bbF().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a2.toString());
            }
            this.emO.add(a2);
            e eVar = new e();
            eVar.mType = "recordClip";
            h.d(eVar);
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c k = k(jsObject);
        String optString = k.optString("path");
        if (DEBUG) {
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.emN);
        }
        if (this.emN) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(k, "clipVideo can only called after onStop");
        } else if (this.emO.isEmpty()) {
            c(k, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.emO, n.xn(optString), n.xz(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.emQ, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(k, str);
                }
            });
            this.emO.clear();
            this.emN = true;
            e eVar = new e();
            eVar.mType = "clipVideo";
            h.d(eVar);
        }
    }

    private boolean c(double[] dArr) {
        if (dArr == null || dArr.length < 2) {
            return false;
        }
        long j = (long) (dArr[0] * 1000.0d);
        long j2 = (long) (dArr[1] * 1000.0d);
        return j >= 0 && j2 >= 0 && j + j2 > 0;
    }

    private boolean a(GameRecorderController.RecorderState... recorderStateArr) {
        GameRecorderController.RecorderState bbC = d.bbE().bbF().bbC();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + bbC);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (bbC == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.c.d.deleteFile(n.xz(remove));
            if (DEBUG) {
                Log.d("GameRecorderApi", "deleteFile: " + remove);
            }
        }
        String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
        list.add(format);
        return format;
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c k(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        return e == null ? new com.baidu.swan.games.binding.model.c() : e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.games.binding.model.c cVar, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
        }
        com.baidu.swan.games.utils.b.a(cVar, false, new b.a(str));
    }

    private void i(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }
}
