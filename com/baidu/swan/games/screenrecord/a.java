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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends c {
    private int adS;
    private String bkJ;
    private boolean bkK;
    private boolean bkL;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> bkM;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bkL = false;
        this.bkM = new ArrayList<>();
    }

    @JavascriptInterface
    public void start() {
        start(null);
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        if (DEBUG) {
            Log.d("GameRecorderApi", IntentConfig.START);
        }
        if (!this.bkK && !a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.SX().SZ()) {
            com.baidu.swan.games.binding.model.c i = i(jsObject);
            this.adS = i.optInt("duration", 10);
            if (this.adS <= 0) {
                this.adS = 10;
            }
            if (this.adS > 120) {
                this.adS = 120;
            }
            String SU = SU();
            jT(SU);
            this.bkJ = g.jt(SU);
            if (this.bkJ == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            this.bkK = true;
            if (i.optBoolean("microphoneEnabled", false)) {
                d.a(new d.a() { // from class: com.baidu.swan.games.screenrecord.a.1
                    @Override // com.baidu.swan.games.screenrecord.d.a
                    public void fe(int i2) {
                        if (!a.this.a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP)) {
                            a.this.fc(a.this.fd(i2));
                        }
                    }
                });
            } else {
                fc(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + this.adS + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bkJ);
        }
        this.bkK = false;
        this.bkM.clear();
        this.bkL = false;
        ff(i);
        d.SX().SY().a(i == 0, this.adS, this.bkJ);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.SX().SY().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.SX().SZ()) {
            d.SX().SY().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", IntentConfig.STOP);
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.SX().SY().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] iZ = i.iZ("timeRange");
            double[] dArr = !b(iZ) ? new double[]{3.0d, 3.0d} : iZ;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.SX().SY().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.bkM.add(a);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.bkL);
        }
        if (this.bkL) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            b(i, "clipVideo can only called after onStop");
        } else if (this.bkM.isEmpty()) {
            b(i, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.bkM, g.ji(optString)).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.2
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.b(i, str);
                }
            });
            this.bkM.clear();
            this.bkL = true;
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
        GameRecorderController.RecorderState SV = d.SX().SY().SV();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + SV);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (SV == recorderState) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fd(int i) {
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
    private String SU() {
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
