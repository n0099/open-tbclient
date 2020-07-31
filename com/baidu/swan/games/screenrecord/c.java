package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.screenrecord.b;
/* loaded from: classes7.dex */
public class c extends EventTargetImpl implements com.baidu.mario.a.c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int dmm;
    private b.C0458b dmn;
    private String dmo;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.dmm = -1;
        this.dmn = new b.C0458b();
        d.aGi().aGj().setGameRecordCallback(this);
    }

    private void w(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iX(int i) {
        this.dmm = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ts(String str) {
        this.dmo = str;
    }

    @Override // com.baidu.mario.a.c
    public void onStart() {
        w("start", this.dmm == -1 ? this.dmn : new b.c(this.dmm));
        e eVar = new e();
        eVar.mType = "start";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onPause() {
        w("pause", this.dmn);
        e eVar = new e();
        eVar.mType = "pause";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onResume() {
        w("resume", this.dmn);
        e eVar = new e();
        eVar.mType = "resume";
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void H(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.dmo);
        }
        w("stop", new b.d(this.dmo));
        e eVar = new e();
        eVar.mType = "stop";
        eVar.v("dura", String.valueOf(i / 1000.0f));
        h.d(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onError(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        w(BdStatsConstant.StatsType.ERROR, new b.a("internal error"));
    }
}
