package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.screenrecord.b;
/* loaded from: classes11.dex */
public class c extends EventTargetImpl implements com.baidu.mario.a.c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int crH;
    private b.C0348b crI;
    private String crJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.crH = -1;
        this.crI = new b.C0348b();
        d.apn().apo().setGameRecordCallback(this);
    }

    private void o(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hV(int i) {
        this.crH = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pw(String str) {
        this.crJ = str;
    }

    @Override // com.baidu.mario.a.c
    public void onStart() {
        o("start", this.crH == -1 ? this.crI : new b.c(this.crH));
        e eVar = new e();
        eVar.mType = "start";
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onPause() {
        o("pause", this.crI);
        e eVar = new e();
        eVar.mType = "pause";
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onResume() {
        o("resume", this.crI);
        e eVar = new e();
        eVar.mType = "resume";
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void q(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.crJ);
        }
        o("stop", new b.d(this.crJ));
        e eVar = new e();
        eVar.mType = "stop";
        eVar.n("dura", String.valueOf(i / 1000.0f));
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onError(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        o(BdStatsConstant.StatsType.ERROR, new b.a("internal error"));
    }
}
