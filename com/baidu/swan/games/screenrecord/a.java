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
/* loaded from: classes7.dex */
public class a extends c {
    private int bsH;
    private String dlY;
    private boolean dlZ;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> dma;
    private List<String> dmb;
    private List<String> dmc;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dlZ = false;
        this.dma = new ArrayList<>();
        this.dmb = new ArrayList(3);
        this.dmc = new ArrayList(3);
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
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.aGi().aGk()) {
            com.baidu.swan.games.binding.model.c k = k(jsObject);
            this.bsH = k.optInt("duration", 10);
            if (this.bsH <= 0) {
                this.bsH = 10;
            }
            if (this.bsH > 120) {
                this.bsH = 120;
            }
            if (this.dmb.size() == 0) {
                com.baidu.swan.d.d.deleteFile(n.sU("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.dmb, 3);
            ts(a);
            this.dlY = n.sU(a);
            if (this.dlY == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (k.optBoolean("microphoneEnabled", false)) {
                iX(2);
            }
            aGd();
            com.baidu.swan.games.u.b.a.aGt();
        }
    }

    private void aGd() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.bsH + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dlY);
        }
        this.dma.clear();
        this.dlZ = false;
        d.aGi().aGj().ai(this.bsH, this.dlY);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.aGi().aGj().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.aGi().aGk()) {
            d.aGi().aGj().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.aGi().aGj().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] sz = k.sz("timeRange");
            i(jsObject);
            double[] dArr = !b(sz) ? new double[]{3.0d, 3.0d} : sz;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.aGi().aGj().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.dma.add(a);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.dlZ);
        }
        if (this.dlZ) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(k, "clipVideo can only called after onStop");
        } else if (this.dma.isEmpty()) {
            c(k, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.dma, n.sI(optString), n.sU(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.dmc, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(k, str);
                }
            });
            this.dma.clear();
            this.dlZ = true;
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
        GameRecorderController.RecorderState aGg = d.aGi().aGj().aGg();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + aGg);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (aGg == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.d.d.deleteFile(n.sU(remove));
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
