package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes10.dex */
public class h {
    private int dPr;
    private int dPs;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.dPs = 0;
        int i = this.dPs;
        this.dPs = i + 1;
        this.dPr = i;
    }

    public String toString() {
        return "StatCallBack" + this.dPr;
    }
}
