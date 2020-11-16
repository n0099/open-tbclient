package com.baidu.fsg.base.restnet.beans.business;
/* loaded from: classes15.dex */
public class BeanErrorContent {
    private int mBeanId;
    private Object mErrContent;
    private String mMsg;
    private int mRet;

    public BeanErrorContent(int i, int i2, String str, Object obj) {
        this.mBeanId = i;
        this.mRet = i2;
        this.mMsg = str;
        this.mErrContent = obj;
    }

    public int getBeanId() {
        return this.mBeanId;
    }

    public int getRet() {
        return this.mRet;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public Object getErrContent() {
        return this.mErrContent;
    }
}
