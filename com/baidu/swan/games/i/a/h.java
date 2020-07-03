package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes11.dex */
public class h {
    private int dcV;
    private int dcW;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.dcW = 0;
        int i = this.dcW;
        this.dcW = i + 1;
        this.dcV = i;
    }

    public String toString() {
        return "StatCallBack" + this.dcV;
    }
}
