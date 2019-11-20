package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.screenrecord.b;
import com.baidu.swan.games.screenrecord.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends c {
    private int awY;
    private String bCG;
    private boolean bCH;
    private boolean bCI;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> bCJ;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bCI = false;
        this.bCJ = new ArrayList<>();
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
        if (!this.bCH && !a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.XM().XO()) {
            com.baidu.swan.games.binding.model.c i = i(jsObject);
            this.awY = i.optInt("duration", 10);
            if (this.awY <= 0) {
                this.awY = 10;
            }
            if (this.awY > 120) {
                this.awY = 120;
            }
            String XJ = XJ();
            kv(XJ);
            this.bCG = g.jW(XJ);
            if (this.bCG == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            this.bCH = true;
            if (i.optBoolean("microphoneEnabled", false)) {
                d.a(new d.a() { // from class: com.baidu.swan.games.screenrecord.a.1
                    @Override // com.baidu.swan.games.screenrecord.d.a
                    public void fY(int i2) {
                        if (!a.this.a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP)) {
                            a.this.fW(a.this.fX(i2));
                        }
                    }
                });
            } else {
                fW(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + this.awY + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bCG);
        }
        this.bCH = false;
        this.bCJ.clear();
        this.bCI = false;
        fZ(i);
        d.XM().XN().a(i == 0, this.awY, this.bCG);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.XM().XN().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.XM().XO()) {
            d.XM().XN().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.XM().XN().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] jC = i.jC("timeRange");
            double[] dArr = !b(jC) ? new double[]{3.0d, 3.0d} : jC;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.XM().XN().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.bCJ.add(a);
            f fVar = new f();
            fVar.mType = "recordClip";
            e.c(fVar);
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c i = i(jsObject);
        String optString = i.optString("path");
        if (DEBUG) {
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.bCI);
        }
        if (this.bCI) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            b(i, "clipVideo can only called after onStop");
        } else if (this.bCJ.isEmpty()) {
            b(i, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.bCJ, g.jL(optString)).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.2
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.b(i, str);
                }
            });
            this.bCJ.clear();
            this.bCI = true;
            f fVar = new f();
            fVar.mType = "clipVideo";
            e.c(fVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(GameRecorderController.RecorderState... recorderStateArr) {
        GameRecorderController.RecorderState XK = d.XM().XN().XK();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + XK);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (XK == recorderState) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fX(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
            default:
                return 2;
        }
    }

    @NonNull
    private String XJ() {
        return "bdfile://tmp" + File.separator + String.format(Locale.CHINA, "videoRecorder_%d.mp4", Long.valueOf(System.currentTimeMillis()));
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c i(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        return c == null ? new com.baidu.swan.games.binding.model.c() : c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.binding.model.c cVar, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
        }
        com.baidu.swan.games.utils.a.a(cVar, false, new b.a(str));
    }
}
