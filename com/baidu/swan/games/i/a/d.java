package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class d {
    private int dcV;
    private int dcW;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public com.baidu.swan.games.i.d[] fileList;

    public d() {
        this.dcW = 0;
        int i = this.dcW;
        this.dcW = i + 1;
        this.dcV = i;
    }

    public String toString() {
        return "GetSavedFileListCallBack" + this.dcV;
    }
}
