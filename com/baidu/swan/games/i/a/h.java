package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes10.dex */
public class h {
    private int dVj;
    private int dVk;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.dVk = 0;
        int i = this.dVk;
        this.dVk = i + 1;
        this.dVj = i;
    }

    public String toString() {
        return "StatCallBack" + this.dVj;
    }
}
