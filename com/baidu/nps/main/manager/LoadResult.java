package com.baidu.nps.main.manager;
/* loaded from: classes.dex */
public class LoadResult {
    public String errMsg;
    public Class retClass;
    public int retCode;

    public void setRet(int i, String str, Class cls) {
        this.retCode = i;
        this.errMsg = str;
        this.retClass = cls;
    }
}
