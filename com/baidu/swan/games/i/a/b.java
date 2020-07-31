package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class b {
    private int diF;
    private int diG;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.diF = 0;
        int i = this.diF;
        this.diF = i + 1;
        this.diG = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.diG;
    }
}
