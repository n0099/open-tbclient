package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes8.dex */
public class h {
    private int dsR;
    private int dsS;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.dsS = 0;
        int i = this.dsS;
        this.dsS = i + 1;
        this.dsR = i;
    }

    public String toString() {
        return "StatCallBack" + this.dsR;
    }
}
