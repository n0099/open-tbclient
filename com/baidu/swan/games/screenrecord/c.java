package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.screenrecord.b;
/* loaded from: classes10.dex */
public class c extends EventTargetImpl implements com.baidu.mario.a.c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int dYM;
    private b.C0544b dYN;
    private String dYO;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.dYM = -1;
        this.dYN = new b.C0544b();
        d.aWN().aWO().setGameRecordCallback(this);
    }

    private void v(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mj(int i) {
        this.dYM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv(String str) {
        this.dYO = str;
    }

    @Override // com.baidu.mario.a.c
    public void onStart() {
        v("start", this.dYM == -1 ? this.dYN : new b.c(this.dYM));
        e eVar = new e();
        eVar.mType = "start";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onPause() {
        v("pause", this.dYN);
        e eVar = new e();
        eVar.mType = "pause";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onResume() {
        v("resume", this.dYN);
        e eVar = new e();
        eVar.mType = "resume";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void Y(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.dYO);
        }
        v("stop", new b.d(this.dYO));
        e eVar = new e();
        eVar.mType = "stop";
        eVar.u("dura", String.valueOf(i / 1000.0f));
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onError(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        v(BdStatsConstant.StatsType.ERROR, new b.a("internal error"));
    }
}
