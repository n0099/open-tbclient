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
    private int adS;
    private String bkl;
    private boolean bkm;
    private boolean bkn;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> bko;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bkn = false;
        this.bko = new ArrayList<>();
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
        if (!this.bkm && !a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.ST().SV()) {
            com.baidu.swan.games.binding.model.c i = i(jsObject);
            this.adS = i.optInt(UBC.CONTENT_KEY_DURATION, 10);
            if (this.adS <= 0) {
                this.adS = 10;
            }
            if (this.adS > 120) {
                this.adS = 120;
            }
            String SQ = SQ();
            jR(SQ);
            this.bkl = g.jr(SQ);
            if (this.bkl == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            this.bkm = true;
            if (i.optBoolean("microphoneEnabled", false)) {
                d.a(new d.a() { // from class: com.baidu.swan.games.screenrecord.a.1
                    @Override // com.baidu.swan.games.screenrecord.d.a
                    public void fd(int i2) {
                        if (!a.this.a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP)) {
                            a.this.fb(a.this.fc(i2));
                        }
                    }
                });
            } else {
                fb(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + this.adS + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bkl);
        }
        this.bkm = false;
        this.bko.clear();
        this.bkn = false;
        fe(i);
        d.ST().SU().a(i == 0, this.adS, this.bkl);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.ST().SU().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.ST().SV()) {
            d.ST().SU().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", IntentConfig.STOP);
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.ST().SU().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] iX = i.iX("timeRange");
            double[] dArr = !b(iX) ? new double[]{3.0d, 3.0d} : iX;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.ST().SU().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.bko.add(a);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.bkn);
        }
        if (this.bkn) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            b(i, "clipVideo can only called after onStop");
        } else if (this.bko.isEmpty()) {
            b(i, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.bko, g.jg(optString)).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.2
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.b(i, str);
                }
            });
            this.bko.clear();
            this.bkn = true;
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
        GameRecorderController.RecorderState SR = d.ST().SU().SR();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + SR);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (SR == recorderState) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fc(int i) {
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
    private String SQ() {
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
