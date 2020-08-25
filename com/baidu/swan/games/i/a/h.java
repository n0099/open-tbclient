package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes8.dex */
public class h {
    private int dsN;
    private int dsO;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.dsO = 0;
        int i = this.dsO;
        this.dsO = i + 1;
        this.dsN = i;
    }

    public String toString() {
        return "StatCallBack" + this.dsN;
    }
}
