package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes9.dex */
public class h {
    private int ejw;
    private int ejx;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.ejx = 0;
        int i = this.ejx;
        this.ejx = i + 1;
        this.ejw = i;
    }

    public String toString() {
        return "StatCallBack" + this.ejw;
    }
}
