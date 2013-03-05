package com.baidu.browser.webkit;

import android.net.http.SslError;
/* loaded from: classes.dex */
public class BdSslError {
    public static final int SSL_EXPIRED = 1;
    public static final int SSL_IDMISMATCH = 2;
    public static final int SSL_MAX_ERROR = 4;
    public static final int SSL_NOTYETVALID = 0;
    public static final int SSL_UNTRUSTED = 3;
    private SslError mSysSslError;
    private com.baidu.zeus.SslError mZeusSslError;

    public BdSslError(SslError sslError) {
        this.mSysSslError = sslError;
    }

    public BdSslError(com.baidu.zeus.SslError sslError) {
        this.mZeusSslError = sslError;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdSslError) && unwrap() == ((BdSslError) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusSslError != null ? this.mZeusSslError.hashCode() : this.mSysSslError.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusSslError != null ? this.mZeusSslError == obj : this.mSysSslError == obj;
    }

    public Object unwrap() {
        return this.mZeusSslError != null ? this.mZeusSslError : this.mSysSslError;
    }

    public boolean addError(int i) {
        if (this.mZeusSslError != null) {
            switch (i) {
                case 0:
                    return this.mZeusSslError.addError(0);
                case 1:
                    return this.mZeusSslError.addError(1);
                case 2:
                    return this.mZeusSslError.addError(2);
                case 3:
                    return this.mZeusSslError.addError(3);
                default:
                    return false;
            }
        }
        switch (i) {
            case 0:
                return this.mSysSslError.addError(0);
            case 1:
                return this.mSysSslError.addError(1);
            case 2:
                return this.mSysSslError.addError(2);
            case 3:
                return this.mSysSslError.addError(3);
            default:
                return false;
        }
    }

    public boolean hasError(int i) {
        if (this.mZeusSslError != null) {
            switch (i) {
                case 0:
                    return this.mZeusSslError.hasError(0);
                case 1:
                    return this.mZeusSslError.hasError(1);
                case 2:
                    return this.mZeusSslError.hasError(2);
                case 3:
                    return this.mZeusSslError.hasError(3);
                default:
                    return false;
            }
        }
        switch (i) {
            case 0:
                return this.mSysSslError.addError(0);
            case 1:
                return this.mSysSslError.addError(1);
            case 2:
                return this.mSysSslError.addError(2);
            case 3:
                return this.mSysSslError.addError(3);
            default:
                return false;
        }
    }

    public int getPrimaryError() {
        if (this.mZeusSslError != null) {
            switch (this.mZeusSslError.getPrimaryError()) {
                case 0:
                default:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
            }
        }
        switch (this.mSysSslError.getPrimaryError()) {
            case 0:
            default:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    public String toString() {
        return this.mZeusSslError != null ? this.mZeusSslError.toString() : this.mSysSslError.toString();
    }
}
