package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.screenrecord.b;
/* loaded from: classes8.dex */
public class c extends EventTargetImpl implements com.baidu.mario.a.c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int dwr;
    private b.C0506b dws;
    private String dwt;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.dwr = -1;
        this.dws = new b.C0506b();
        d.aOZ().aPa().setGameRecordCallback(this);
    }

    private void v(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lg(int i) {
        this.dwr = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vI(String str) {
        this.dwt = str;
    }

    @Override // com.baidu.mario.a.c
    public void onStart() {
        v("start", this.dwr == -1 ? this.dws : new b.c(this.dwr));
        e eVar = new e();
        eVar.mType = "start";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onPause() {
        v("pause", this.dws);
        e eVar = new e();
        eVar.mType = "pause";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onResume() {
        v("resume", this.dws);
        e eVar = new e();
        eVar.mType = "resume";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void G(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.dwt);
        }
        v("stop", new b.d(this.dwt));
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
