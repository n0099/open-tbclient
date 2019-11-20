package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.games.screenrecord.b;
/* loaded from: classes2.dex */
public class c extends EventTargetImpl implements com.baidu.mario.b.b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int bCP;
    private b.C0259b bCQ;
    private String bCR;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.bCP = -1;
        this.bCQ = new b.C0259b();
        d.XM().XN().setGameRecordCallback(this);
    }

    private void i(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fZ(int i) {
        this.bCP = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kv(String str) {
        this.bCR = str;
    }

    @Override // com.baidu.mario.b.b
    public void onStart() {
        i("start", this.bCP == -1 ? this.bCQ : new b.c(this.bCP));
        f fVar = new f();
        fVar.mType = "start";
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void onPause() {
        i("pause", this.bCQ);
        f fVar = new f();
        fVar.mType = "pause";
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void onResume() {
        i("resume", this.bCQ);
        f fVar = new f();
        fVar.mType = "resume";
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void l(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.bCR);
        }
        i("stop", new b.d(this.bCR));
        f fVar = new f();
        fVar.mType = "stop";
        fVar.h("dura", String.valueOf(i / 1000.0f));
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void onError(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        i(BdStatsConstant.StatsType.ERROR, new b.a("internal error"));
    }
}
