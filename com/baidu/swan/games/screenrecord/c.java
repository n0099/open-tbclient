package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.screenrecord.b;
/* loaded from: classes25.dex */
public class c extends EventTargetImpl implements com.baidu.mario.a.c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int eed;
    private b.C0554b eee;
    private String eef;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.eed = -1;
        this.eee = new b.C0554b();
        d.aZk().aZl().setGameRecordCallback(this);
    }

    private void u(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mD(int i) {
        this.eed = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xX(String str) {
        this.eef = str;
    }

    @Override // com.baidu.mario.a.c
    public void onStart() {
        u("start", this.eed == -1 ? this.eee : new b.c(this.eed));
        e eVar = new e();
        eVar.mType = "start";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onPause() {
        u("pause", this.eee);
        e eVar = new e();
        eVar.mType = "pause";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onResume() {
        u("resume", this.eee);
        e eVar = new e();
        eVar.mType = "resume";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void Y(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.eef);
        }
        u("stop", new b.d(this.eef));
        e eVar = new e();
        eVar.mType = "stop";
        eVar.t("dura", String.valueOf(i / 1000.0f));
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onError(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        u(BdStatsConstant.StatsType.ERROR, new b.a("internal error"));
    }
}
