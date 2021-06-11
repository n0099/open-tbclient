package com.baidu.cloudbase.download.exception;
/* loaded from: classes2.dex */
public class DownloadException extends Exception {
    public int errorCode;
    public String errorMessage;

    public DownloadException() {
    }

    public DownloadException(int i2, String str) {
        super(str);
        this.errorCode = i2;
        this.errorMessage = str;
    }

    public DownloadException(int i2, String str, Throwable th) {
        super(str, th);
        this.errorCode = i2;
        this.errorMessage = str;
    }

    public DownloadException(int i2, Throwable th) {
        super(th);
        this.errorCode = i2;
    }

    public DownloadException(String str) {
        super(str);
        this.errorMessage = str;
    }

    public DownloadException(String str, Throwable th) {
        super(str, th);
        this.errorMessage = str;
    }

    public DownloadException(Throwable th) {
        super(th);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString();
    }
}
