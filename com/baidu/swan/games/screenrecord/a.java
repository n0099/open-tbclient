package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.h.l;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.screenrecord.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a extends c {
    private int aFu;
    private String cnq;
    private boolean cnr;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> cns;
    private List<String> cnu;
    private List<String> cnv;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.cnr = false;
        this.cns = new ArrayList<>();
        this.cnu = new ArrayList(3);
        this.cnv = new ArrayList(3);
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
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.amZ().anb()) {
            com.baidu.swan.games.binding.model.c i = i(jsObject);
            this.aFu = i.optInt("duration", 10);
            if (this.aFu <= 0) {
                this.aFu = 10;
            }
            if (this.aFu > 120) {
                this.aFu = 120;
            }
            if (this.cnu.size() == 0) {
                com.baidu.swan.d.c.deleteFile(l.oJ("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.cnu, 3);
            ph(a);
            this.cnq = l.oJ(a);
            if (this.cnq == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (i.optBoolean("microphoneEnabled", false)) {
                hE(2);
            }
            amU();
            com.baidu.swan.games.t.b.a.ank();
        }
    }

    private void amU() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.aFu + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cnq);
        }
        this.cns.clear();
        this.cnr = false;
        d.amZ().ana().I(this.aFu, this.cnq);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.amZ().ana().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.amZ().anb()) {
            d.amZ().ana().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.amZ().ana().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] op = i.op("timeRange");
            g(jsObject);
            double[] dArr = !b(op) ? new double[]{3.0d, 3.0d} : op;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.amZ().ana().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.cns.add(a);
            e eVar = new e();
            eVar.mType = "recordClip";
            f.a(eVar);
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c i = i(jsObject);
        String optString = i.optString("path");
        if (DEBUG) {
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.cnr);
        }
        if (this.cnr) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(i, "clipVideo can only called after onStop");
        } else if (this.cns.isEmpty()) {
            c(i, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.cns, l.oy(optString), l.oJ(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.cnv, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(i, str);
                }
            });
            this.cns.clear();
            this.cnr = true;
            e eVar = new e();
            eVar.mType = "clipVideo";
            f.a(eVar);
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
        GameRecorderController.RecorderState amX = d.amZ().ana().amX();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + amX);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (amX == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.d.c.deleteFile(l.oJ(remove));
            if (DEBUG) {
                Log.d("GameRecorderApi", "deleteFile: " + remove);
            }
        }
        String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
        list.add(format);
        return format;
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c i(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        return c == null ? new com.baidu.swan.games.binding.model.c() : c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.games.binding.model.c cVar, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
        }
        com.baidu.swan.games.utils.b.a(cVar, false, new b.a(str));
    }

    private void g(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }
}
