package com.baidu.cloudsdk;
/* loaded from: classes.dex */
public class BaiduException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f836a;

    public BaiduException(int i, String str) {
        super("errcode: " + i + ", errmsg: " + str);
        this.f836a = i;
    }

    public BaiduException(String str) {
        super(str);
        this.f836a = -1;
    }

    public BaiduException(String str, Throwable th) {
        super(str, th);
        if (th instanceof BaiduException) {
            this.f836a = ((BaiduException) th).getErrorCode();
        } else {
            this.f836a = -1;
        }
    }

    public BaiduException(Throwable th) {
        super(th);
        if (th instanceof BaiduException) {
            this.f836a = ((BaiduException) th).getErrorCode();
        } else {
            this.f836a = -1;
        }
    }

    public int getErrorCode() {
        return this.f836a;
    }
}
