package com.baidu.cloudbase.download.exception;
/* loaded from: classes12.dex */
public class DownloadException extends Exception {
    public int errorCode;
    public String errorMessage;

    public DownloadException() {
    }

    public DownloadException(int i, String str) {
        super(str);
        this.errorCode = i;
        this.errorMessage = str;
    }

    public DownloadException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
        this.errorMessage = str;
    }

    public DownloadException(int i, Throwable th) {
        super(th);
        this.errorCode = i;
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

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString();
    }
}
