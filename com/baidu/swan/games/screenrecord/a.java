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
/* loaded from: classes8.dex */
public class a extends c {
    private int ccb;
    private String eia;
    private boolean eib;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> eic;
    private List<String> eid;
    private List<String> eie;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.eib = false;
        this.eic = new ArrayList<>();
        this.eid = new ArrayList(3);
        this.eie = new ArrayList(3);
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
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.aXL().aXN()) {
            com.baidu.swan.games.binding.model.c k = k(jsObject);
            this.ccb = k.optInt("duration", 10);
            if (this.ccb <= 0) {
                this.ccb = 10;
            }
            if (this.ccb > 120) {
                this.ccb = 120;
            }
            if (this.eid.size() == 0) {
                com.baidu.swan.c.d.deleteFile(n.wo("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a2 = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.eid, 3);
            wL(a2);
            this.eia = n.wo(a2);
            if (this.eia == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (k.optBoolean("microphoneEnabled", false)) {
                lf(2);
            }
            aXG();
            com.baidu.swan.games.u.b.a.aXW();
        }
    }

    private void aXG() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.ccb + "," + this.eia);
        }
        this.eic.clear();
        this.eib = false;
        d.aXL().aXM().aB(this.ccb, this.eia);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.aXL().aXM().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.aXL().aXN()) {
            d.aXL().aXM().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.aXL().aXM().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] vT = k.vT("timeRange");
            i(jsObject);
            double[] dArr = !b(vT) ? new double[]{3.0d, 3.0d} : vT;
            com.baidu.swan.games.screenrecord.a.b a2 = com.baidu.swan.games.screenrecord.a.b.a(d.aXL().aXM().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a2.toString());
            }
            this.eic.add(a2);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.eib);
        }
        if (this.eib) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(k, "clipVideo can only called after onStop");
        } else if (this.eic.isEmpty()) {
            c(k, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.eic, n.wc(optString), n.wo(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.eie, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(k, str);
                }
            });
            this.eic.clear();
            this.eib = true;
            e eVar = new e();
            eVar.mType = "clipVideo";
            h.d(eVar);
        }
    }

    private boolean b(double[] dArr) {
        if (dArr == null || dArr.length < 2) {
            return false;
        }
        long j = (long) (dArr[0] * 1000.0d);
        long j2 = (long) (dArr[1] * 1000.0d);
        return j >= 0 && j2 >= 0 && j + j2 > 0;
    }

    private boolean a(GameRecorderController.RecorderState... recorderStateArr) {
        GameRecorderController.RecorderState aXJ = d.aXL().aXM().aXJ();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + aXJ);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (aXJ == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.c.d.deleteFile(n.wo(remove));
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
