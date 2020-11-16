package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class b {
    private int dTA;
    private int dTB;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.dTA = 0;
        int i = this.dTA;
        this.dTA = i + 1;
        this.dTB = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.dTB;
    }
}
