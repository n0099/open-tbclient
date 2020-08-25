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
/* loaded from: classes8.dex */
public class a extends c {
    private int byu;
    private String dwd;
    private boolean dwe;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> dwf;
    private List<String> dwg;
    private List<String> dwh;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dwe = false;
        this.dwf = new ArrayList<>();
        this.dwg = new ArrayList(3);
        this.dwh = new ArrayList(3);
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
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.aOZ().aPb()) {
            com.baidu.swan.games.binding.model.c k = k(jsObject);
            this.byu = k.optInt("duration", 10);
            if (this.byu <= 0) {
                this.byu = 10;
            }
            if (this.byu > 120) {
                this.byu = 120;
            }
            if (this.dwg.size() == 0) {
                com.baidu.swan.c.d.deleteFile(n.vl("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.dwg, 3);
            vI(a);
            this.dwd = n.vl(a);
            if (this.dwd == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (k.optBoolean("microphoneEnabled", false)) {
                lg(2);
            }
            aOU();
            com.baidu.swan.games.u.b.a.aPk();
        }
    }

    private void aOU() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.byu + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dwd);
        }
        this.dwf.clear();
        this.dwe = false;
        d.aOZ().aPa().ag(this.byu, this.dwd);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.aOZ().aPa().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.aOZ().aPb()) {
            d.aOZ().aPa().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.aOZ().aPa().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] uQ = k.uQ("timeRange");
            i(jsObject);
            double[] dArr = !c(uQ) ? new double[]{3.0d, 3.0d} : uQ;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.aOZ().aPa().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.dwf.add(a);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.dwe);
        }
        if (this.dwe) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(k, "clipVideo can only called after onStop");
        } else if (this.dwf.isEmpty()) {
            c(k, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.dwf, n.uZ(optString), n.vl(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.dwh, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(k, str);
                }
            });
            this.dwf.clear();
            this.dwe = true;
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
        GameRecorderController.RecorderState aOX = d.aOZ().aPa().aOX();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + aOX);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (aOX == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.c.d.deleteFile(n.vl(remove));
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
