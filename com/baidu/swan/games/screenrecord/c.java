package com.baidu.swan.games.screenrecord;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.games.screenrecord.b;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class c extends EventTargetImpl implements com.baidu.mario.b.b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int bku;
    private b.C0213b bkv;
    private String bkw;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.bku = -1;
        this.bkv = new b.C0213b();
        d.ST().SU().setGameRecordCallback(this);
    }

    private void l(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fe(int i) {
        this.bku = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jR(String str) {
        this.bkw = str;
    }

    @Override // com.baidu.mario.b.b
    public void onStart() {
        l(IntentConfig.START, this.bku == -1 ? this.bkv : new b.c(this.bku));
        f fVar = new f();
        fVar.mType = IntentConfig.START;
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void onPause() {
        l("pause", this.bkv);
        f fVar = new f();
        fVar.mType = "pause";
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void onResume() {
        l("resume", this.bkv);
        f fVar = new f();
        fVar.mType = "resume";
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void h(int i, String str) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.bkw);
        }
        l(IntentConfig.STOP, new b.d(this.bkw));
        f fVar = new f();
        fVar.mType = IntentConfig.STOP;
        fVar.k("dura", String.valueOf(i / 1000.0f));
        e.c(fVar);
    }

    @Override // com.baidu.mario.b.b
    public void onError(int i) {
        if (DEBUG) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        l("error", new b.a("internal error"));
    }
}
