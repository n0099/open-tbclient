package com.baidu.platform.comapi.longlink;
/* loaded from: classes15.dex */
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
    private int f4240a;

    /* renamed from: b  reason: collision with root package name */
    private int f4241b;

    ELongLinkStatus(int i) {
        this.f4240a = i;
    }

    public int getRequestId() {
        return this.f4241b;
    }

    public int getStatusCode() {
        return this.f4240a;
    }

    public void setRequestId(int i) {
        this.f4241b = i;
    }
}
