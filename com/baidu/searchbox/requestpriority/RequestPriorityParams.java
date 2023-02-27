package com.baidu.searchbox.requestpriority;
/* loaded from: classes2.dex */
public class RequestPriorityParams {
    public int requestPriorityDelayTime;
    public boolean requestPriorityEnabled;
    public String requestPriorityWhitelist;

    public int getRequestPriorityDelayTime() {
        return this.requestPriorityDelayTime;
    }

    public String getRequestPriorityWhitelist() {
        return this.requestPriorityWhitelist;
    }

    public boolean isRequestPriorityEnabled() {
        return this.requestPriorityEnabled;
    }

    public RequestPriorityParams requestPriorityDelayTime(int i) {
        this.requestPriorityDelayTime = i;
        return this;
    }

    public RequestPriorityParams requestPriorityEnabled(boolean z) {
        this.requestPriorityEnabled = z;
        return this;
    }

    public RequestPriorityParams requestPriorityWhitelist(String str) {
        this.requestPriorityWhitelist = str;
        return this;
    }
}
