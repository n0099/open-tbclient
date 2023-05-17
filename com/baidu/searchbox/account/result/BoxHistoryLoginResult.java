package com.baidu.searchbox.account.result;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/account/result/BoxHistoryLoginResult;", "Lcom/baidu/searchbox/account/result/LoginResult;", "()V", "historyModel", "Lcom/baidu/searchbox/account/result/BoxLoginHistoryModel;", "getHistoryModel", "()Lcom/baidu/searchbox/account/result/BoxLoginHistoryModel;", "setHistoryModel", "(Lcom/baidu/searchbox/account/result/BoxLoginHistoryModel;)V", "isSupport", "", "()Z", "setSupport", "(Z)V", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoxHistoryLoginResult extends LoginResult {
    public BoxLoginHistoryModel historyModel;
    public boolean isSupport;

    public final BoxLoginHistoryModel getHistoryModel() {
        return this.historyModel;
    }

    public final boolean isSupport() {
        return this.isSupport;
    }

    public final void setHistoryModel(BoxLoginHistoryModel boxLoginHistoryModel) {
        this.historyModel = boxLoginHistoryModel;
    }

    public final void setSupport(boolean z) {
        this.isSupport = z;
    }
}
