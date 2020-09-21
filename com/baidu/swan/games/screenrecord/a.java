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
/* loaded from: classes3.dex */
public class a extends c {
    private int bBU;
    private String dyi;
    private boolean dyj;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> dyk;
    private List<String> dyl;
    private List<String> dym;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dyj = false;
        this.dyk = new ArrayList<>();
        this.dyl = new ArrayList(3);
        this.dym = new ArrayList(3);
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
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.aPK().aPM()) {
            com.baidu.swan.games.binding.model.c k = k(jsObject);
            this.bBU = k.optInt("duration", 10);
            if (this.bBU <= 0) {
                this.bBU = 10;
            }
            if (this.bBU > 120) {
                this.bBU = 120;
            }
            if (this.dyl.size() == 0) {
                com.baidu.swan.c.d.deleteFile(n.vF("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.dyl, 3);
            wc(a);
            this.dyi = n.vF(a);
            if (this.dyi == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (k.optBoolean("microphoneEnabled", false)) {
                lr(2);
            }
            aPF();
            com.baidu.swan.games.u.b.a.aPV();
        }
    }

    private void aPF() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.bBU + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dyi);
        }
        this.dyk.clear();
        this.dyj = false;
        d.aPK().aPL().ah(this.bBU, this.dyi);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.aPK().aPL().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.aPK().aPM()) {
            d.aPK().aPL().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.aPK().aPL().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] vk = k.vk("timeRange");
            i(jsObject);
            double[] dArr = !c(vk) ? new double[]{3.0d, 3.0d} : vk;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.aPK().aPL().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.dyk.add(a);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.dyj);
        }
        if (this.dyj) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(k, "clipVideo can only called after onStop");
        } else if (this.dyk.isEmpty()) {
            c(k, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.dyk, n.vt(optString), n.vF(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.dym, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(k, str);
                }
            });
            this.dyk.clear();
            this.dyj = true;
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
        GameRecorderController.RecorderState aPI = d.aPK().aPL().aPI();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + aPI);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (aPI == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.c.d.deleteFile(n.vF(remove));
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
