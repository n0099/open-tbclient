package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class b {
    private int eeI;
    private int eeJ;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.eeI = 0;
        int i = this.eeI;
        this.eeI = i + 1;
        this.eeJ = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.eeJ;
    }
}
