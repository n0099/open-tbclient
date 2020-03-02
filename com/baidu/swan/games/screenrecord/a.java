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
/* loaded from: classes11.dex */
public class a extends c {
    private int aJB;
    private String cru;
    private boolean crv;
    private ArrayList<com.baidu.swan.games.screenrecord.a.b> crw;
    private List<String> crx;
    private List<String> cry;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.crv = false;
        this.crw = new ArrayList<>();
        this.crx = new ArrayList(3);
        this.cry = new ArrayList(3);
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
        if (!a(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !d.app().apr()) {
            com.baidu.swan.games.binding.model.c i = i(jsObject);
            this.aJB = i.optInt("duration", 10);
            if (this.aJB <= 0) {
                this.aJB = 10;
            }
            if (this.aJB > 120) {
                this.aJB = 120;
            }
            if (this.crx.size() == 0) {
                com.baidu.swan.d.c.deleteFile(l.oY("bdfile://tmp/SwanVideoRecorder/"));
            }
            String a = a("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.crx, 3);
            pw(a);
            this.cru = l.oY(a);
            if (this.cru == null) {
                if (DEBUG) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (i.optBoolean("microphoneEnabled", false)) {
                hV(2);
            }
            apk();
            com.baidu.swan.games.t.b.a.apA();
        }
    }

    private void apk() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "doStartRecorder:" + this.aJB + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cru);
        }
        this.crw.clear();
        this.crv = false;
        d.app().apq().K(this.aJB, this.cru);
    }

    @JavascriptInterface
    public void pause() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "pause");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING)) {
            d.app().apq().pauseRecord();
        }
    }

    @JavascriptInterface
    public void resume() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "resume");
        }
        if (!a(GameRecorderController.RecorderState.PAUSE) && !d.app().apr()) {
            d.app().apq().resumeRecord();
        }
    }

    @JavascriptInterface
    public void stop() {
        if (DEBUG) {
            Log.d("GameRecorderApi", "stop");
        }
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            d.app().apq().stopRecord();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        if (!a(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
            double[] oE = i.oE("timeRange");
            g(jsObject);
            double[] dArr = !b(oE) ? new double[]{3.0d, 3.0d} : oE;
            com.baidu.swan.games.screenrecord.a.b a = com.baidu.swan.games.screenrecord.a.b.a(d.app().apq().getCurrentRecordProcess(), dArr[0], dArr[1]);
            if (DEBUG) {
                Log.d("GameRecorderApi", "recordClip:" + a.toString());
            }
            this.crw.add(a);
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
            Log.d("GameRecorderApi", "clipPath:" + optString + "，hasExecutedClip：" + this.crv);
        }
        if (this.crv) {
            return;
        }
        if (a(GameRecorderController.RecorderState.STOP)) {
            c(i, "clipVideo can only called after onStop");
        } else if (this.crw.isEmpty()) {
            c(i, "range is illegal");
        } else {
            new com.baidu.swan.games.screenrecord.a.e(this.crw, l.oN(optString), l.oY(a("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.cry, 3))).a(new com.baidu.swan.games.screenrecord.a.c() { // from class: com.baidu.swan.games.screenrecord.a.1
                @Override // com.baidu.swan.games.screenrecord.a.c
                public void a(com.baidu.swan.games.screenrecord.a.d dVar, String str) {
                    a.this.c(i, str);
                }
            });
            this.crw.clear();
            this.crv = true;
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
        GameRecorderController.RecorderState apn = d.app().apq().apn();
        if (DEBUG) {
            Log.d("GameRecorderApi", "RecorderState:" + apn);
        }
        if (recorderStateArr == null) {
            return true;
        }
        for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
            if (apn == recorderState) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    private String a(String str, @NonNull List<String> list, int i) {
        if (list.size() >= i) {
            String remove = list.remove(0);
            com.baidu.swan.d.c.deleteFile(l.oY(remove));
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
