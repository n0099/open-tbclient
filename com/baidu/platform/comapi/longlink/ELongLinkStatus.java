package com.baidu.platform.comapi.longlink;
/* loaded from: classes7.dex */
public enum ELongLinkStatus {
    OK(0),
    SendFormatError(OK.getStatusCode() + 1),
    SendUnRegistered(OK.getStatusCode() + 2),
    SendLimited(OK.getStatusCode() + 3),
    SendDataLenLimited(OK.getStatusCode() + 4),
    SendInvalidReqID(OK.getStatusCode() + 5),
    ResultConnectError(OK.getStatusCode() + 6),
    ResultSendError(OK.getStatusCode() + 7),
    ResultTimeout(OK.getStatusCode() + 8),
    ResultServerError(OK.getStatusCode() + 9),
    CloudStop(OK.getStatusCode() + 10),
    CloudRestart(OK.getStatusCode() + 11);
    

    /* renamed from: a  reason: collision with root package name */
    private int f2863a;
    private int b;

    ELongLinkStatus(int i) {
        this.f2863a = i;
    }

    public int getRequestId() {
        return this.b;
    }

    public int getStatusCode() {
        return this.f2863a;
    }

    public void setRequestId(int i) {
        this.b = i;
    }
}
