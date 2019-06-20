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
import com.baidu.ubc.UBC;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends c {
    private int adv;
    private boolean bjA;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> bjB;
    private String bjy;
    private boolean bjz;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bjA = false;
        this.bjB = new ArrayList<>();
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
        if (!this.bjz && !a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.Sa().Sc()) {
            com.baidu.swan.games.binding.model.c i = i(jsObject);
            this.adv = i.optInt(UBC.CONTENT_KEY_DURATION, 10);
            if (this.adv <= 0) {
                this.adv = 10;
            }
            if (this.adv > 120) {
                this.adv = 120;
            }
            String RX = RX();
            jJ(RX);
            this.bjy = g.jj(RX);
            if (this.bjy == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            this.bjz = true;
            if (i.optBoolean("microphoneEnabled", false)) {
                d.a(new d.a() { // from class: com.baidu.swan.games.screenrecord.a.1
                    @Override // com.baidu.swan.games.screenrecord.d.a
                    public void eZ(int i2) {
                        if (!a.this.a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP)) {
                            a.this.eX(a.this.eY(i2));
                        }
                    }
                });
            } else {
                eX(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + this.adv + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bjy);
        }
        this.bjz = false;
        this.bjB.clear();
        this.bjA = false;
        fa(i);
        d.Sa().Sb().a(i == 0, this.adv, this.bjy);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.Sa().Sb().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.Sa().Sc()) {
            d.Sa().Sb().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", IntentConfig.STOP);
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.Sa().Sb().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] iP = i.iP("timeRange");
            double[] dArr = !b(iP) ? new double[]{3.0d, 3.0d} : iP;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.Sa().Sb().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.bjB.add(a);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.bjA);
        }
        if (this.bjA) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            b(i, "clipVideo can only called after onStop");
        } else if (this.bjB.isEmpty()) {
            b(i, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.bjB, g.iY(optString)).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.2
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.b(i, str);
                }
            });
            this.bjB.clear();
            this.bjA = true;
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
        GameRecorderController.RecorderState RY = d.Sa().Sb().RY();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + RY);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (RY == recorderState) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eY(int i) {
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
    private String RX() {
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
