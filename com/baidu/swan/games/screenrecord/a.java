package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.i.n;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.screenrecord.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a extends c {
    private int bWB;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> dYA;
    private List<String> dYB;
    private List<String> dYC;
    private String dYy;
    private boolean dYz;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dYz = false;
        this.dYA = new ArrayList<>();
        this.dYB = new ArrayList(3);
        this.dYC = new ArrayList(3);
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
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.aWN().aWP()) {
            com.baidu.swan.games.binding.model.c k = k(jsObject);
            this.bWB = k.optInt("duration", 10);
            if (this.bWB <= 0) {
                this.bWB = 10;
            }
            if (this.bWB > 120) {
                this.bWB = 120;
            }
            if (this.dYB.size() == 0) {
                com.baidu.swan.c.d.deleteFile(n.wY("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a2 = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.dYB, 3);
            xv(a2);
            this.dYy = n.wY(a2);
            if (this.dYy == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (k.optBoolean("microphoneEnabled", false)) {
                mj(2);
            }
            aWI();
            com.baidu.swan.games.u.b.a.aWY();
        }
    }

    private void aWI() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.bWB + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dYy);
        }
        this.dYA.clear();
        this.dYz = false;
        d.aWN().aWO().ay(this.bWB, this.dYy);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.aWN().aWO().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.aWN().aWP()) {
            d.aWN().aWO().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.aWN().aWO().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] wD = k.wD("timeRange");
            i(jsObject);
            double[] dArr = !c(wD) ? new double[]{3.0d, 3.0d} : wD;
            com.baidu.swan.games.screenrecord.a.b a2 = com.baidu.swan.games.screenrecord.a.b.a(d.aWN().aWO().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a2.toString());
            }
            this.dYA.add(a2);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.dYz);
        }
        if (this.dYz) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(k, "clipVideo can only called after onStop");
        } else if (this.dYA.isEmpty()) {
            c(k, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.dYA, n.wM(optString), n.wY(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.dYC, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(k, str);
                }
            });
            this.dYA.clear();
            this.dYz = true;
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
        GameRecorderController.RecorderState aWL = d.aWN().aWO().aWL();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + aWL);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (aWL == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.c.d.deleteFile(n.wY(remove));
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
