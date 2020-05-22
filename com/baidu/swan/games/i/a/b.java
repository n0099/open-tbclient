package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class b {
    private int cYh;
    private int cYi;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.cYh = 0;
        int i = this.cYh;
        this.cYh = i + 1;
        this.cYi = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.cYi;
    }
}
