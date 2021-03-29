package com.baidu.fsg.base.restnet.beans.business;
/* loaded from: classes.dex */
public class BeanErrorContent {
    public int mBeanId;
    public Object mErrContent;
    public String mMsg;
    public int mRet;

    public BeanErrorContent(int i, int i2, String str, Object obj) {
        this.mBeanId = i;
        this.mRet = i2;
        this.mMsg = str;
        this.mErrContent = obj;
    }

    public int getBeanId() {
        return this.mBeanId;
    }

    public Object getErrContent() {
        return this.mErrContent;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public int getRet() {
        return this.mRet;
    }
}
