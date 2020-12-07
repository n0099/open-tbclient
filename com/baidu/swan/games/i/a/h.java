package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes25.dex */
public class h {
    private int eaA;
    private int eaz;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.eaA = 0;
        int i = this.eaA;
        this.eaA = i + 1;
        this.eaz = i;
    }

    public String toString() {
        return "StatCallBack" + this.eaz;
    }
}
