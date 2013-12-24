package com.baidu.adp.lib.network;

import java.io.IOException;
/* loaded from: classes.dex */
public class BdHttpErrorException extends IOException {
    private int mHttpResponseCode;
    private boolean mNeedRetry;

    public BdHttpErrorException() {
        this.mHttpResponseCode = -1;
        this.mNeedRetry = false;
    }

    public BdHttpErrorException(String str) {
        super(str);
        this.mHttpResponseCode = -1;
        this.mNeedRetry = false;
    }

    public BdHttpErrorException(String str, int i) {
        super(str);
        this.mHttpResponseCode = -1;
        this.mNeedRetry = false;
        this.mHttpResponseCode = i;
    }

    public BdHttpErrorException(String str, int i, boolean z) {
        super(str);
        this.mHttpResponseCode = -1;
        this.mNeedRetry = false;
        this.mHttpResponseCode = i;
        this.mNeedRetry = z;
    }

    public BdHttpErrorException(String str, Throwable th, int i) {
        super(str);
        this.mHttpResponseCode = -1;
        this.mNeedRetry = false;
        initCause(th);
        this.mHttpResponseCode = i;
    }

    public BdHttpErrorException(String str, Throwable th, int i, boolean z) {
        super(str);
        this.mHttpResponseCode = -1;
        this.mNeedRetry = false;
        initCause(th);
        this.mHttpResponseCode = i;
        this.mNeedRetry = z;
    }

    public BdHttpErrorException(String str, Throwable th) {
        super(str);
        this.mHttpResponseCode = -1;
        this.mNeedRetry = false;
        initCause(th);
    }

    public int getHttpResponseCode() {
        return this.mHttpResponseCode;
    }

    public boolean needRetry() {
        return this.mNeedRetry;
    }
}
