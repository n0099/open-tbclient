package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.screenrecord.b;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl implements com.baidu.mario.a.c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int dyw;
    private b.C0501b dyx;
    private String dyy;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.dyw = -1;
        this.dyx = new b.C0501b();
        d.aPK().aPL().setGameRecordCallback(this);
    }

    private void v(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lr(int i) {
        this.dyw = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wc(String str) {
        this.dyy = str;
    }

    @Override // com.baidu.mario.a.c
    public void onStart() {
        v("start", this.dyw == -1 ? this.dyx : new b.c(this.dyw));
        e eVar = new e();
        eVar.mType = "start";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onPause() {
        v("pause", this.dyx);
        e eVar = new e();
        eVar.mType = "pause";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onResume() {
        v("resume", this.dyx);
        e eVar = new e();
        eVar.mType = "resume";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void H(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.dyy);
        }
        v("stop", new b.d(this.dyy));
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
