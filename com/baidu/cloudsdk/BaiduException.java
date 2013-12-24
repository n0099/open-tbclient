package com.baidu.cloudsdk;
/* loaded from: classes.dex */
public class BaiduException extends Exception {
    private int a;

    public BaiduException(int i, String str) {
        super("errcode: " + i + ", errmsg: " + str);
        this.a = i;
    }

    public BaiduException(String str) {
        super(str);
        this.a = -1;
    }

    public BaiduException(String str, Throwable th) {
        super(str, th);
        if (th instanceof BaiduException) {
            this.a = ((BaiduException) th).getErrorCode();
        } else {
            this.a = -1;
        }
    }

    public BaiduException(Throwable th) {
        super(th);
        if (th instanceof BaiduException) {
            this.a = ((BaiduException) th).getErrorCode();
        } else {
            this.a = -1;
        }
    }

    public int getErrorCode() {
        return this.a;
    }
}
