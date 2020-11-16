package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes7.dex */
public class h {
    private int dTB;
    private int dTC;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.dTC = 0;
        int i = this.dTC;
        this.dTC = i + 1;
        this.dTB = i;
    }

    public String toString() {
        return "StatCallBack" + this.dTB;
    }
}
