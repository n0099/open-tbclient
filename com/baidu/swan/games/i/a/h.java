package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes8.dex */
public class h {
    private int eis;
    private int eit;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.eit = 0;
        int i = this.eit;
        this.eit = i + 1;
        this.eis = i;
    }

    public String toString() {
        return "StatCallBack" + this.eis;
    }
}
