package com.baidu.fsg.base.restnet.beans.business;
/* loaded from: classes2.dex */
public class BeanErrorContent {
    public int mBeanId;
    public Object mErrContent;
    public String mMsg;
    public int mRet;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.mBeanId = i2;
        this.mRet = i3;
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
