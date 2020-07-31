package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.i.j;
/* loaded from: classes7.dex */
public class h {
    private int diG;
    private int diH;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public j stats;

    public h() {
        this.diH = 0;
        int i = this.diH;
        this.diH = i + 1;
        this.diG = i;
    }

    public String toString() {
        return "StatCallBack" + this.diG;
    }
}
