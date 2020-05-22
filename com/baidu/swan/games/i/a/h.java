package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes11.dex */
public class h {
    private int cYi;
    private int cYj;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.cYj = 0;
        int i = this.cYj;
        this.cYj = i + 1;
        this.cYi = i;
    }

    public String toString() {
        return "StatCallBack" + this.cYi;
    }
}
