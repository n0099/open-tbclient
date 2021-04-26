package com.baidu.nps.main.manager;
/* loaded from: classes2.dex */
public class LoadResult {
    public String errMsg;
    public Class retClass;
    public int retCode;

    public void setRet(int i2, String str, Class cls) {
        this.retCode = i2;
        this.errMsg = str;
        this.retClass = cls;
    }
}
