package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class b {
    private int ejv;
    private int ejw;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.ejv = 0;
        int i = this.ejv;
        this.ejv = i + 1;
        this.ejw = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.ejw;
    }
}
