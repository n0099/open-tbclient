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
    private int cQU;
    private b.C0399b cQV;
    private String cQW;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.cQU = -1;
        this.cQV = new b.C0399b();
        d.axE().axF().setGameRecordCallback(this);
    }

    private void t(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ic(int i) {
        this.cQU = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qI(String str) {
        this.cQW = str;
    }

    @Override // com.baidu.mario.a.c
    public void onStart() {
        t("start", this.cQU == -1 ? this.cQV : new b.c(this.cQU));
        e eVar = new e();
        eVar.mType = "start";
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onPause() {
        t("pause", this.cQV);
        e eVar = new e();
        eVar.mType = "pause";
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onResume() {
        t("resume", this.cQV);
        e eVar = new e();
        eVar.mType = "resume";
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void F(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.cQW);
        }
        t("stop", new b.d(this.cQW));
        e eVar = new e();
        eVar.mType = "stop";
        eVar.s("dura", String.valueOf(i / 1000.0f));
        f.a(eVar);
    }

    @Override // com.baidu.mario.a.c
    public void onError(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        t(BdStatsConstant.StatsType.ERROR, new b.a("internal error"));
    }
}
