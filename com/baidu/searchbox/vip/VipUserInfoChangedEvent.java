package com.baidu.searchbox.vip;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/vip/VipUserInfoChangedEvent;", "", "reqSuccess", "", "isInfoChanged", "(ZZ)V", "()Z", "getReqSuccess", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VipUserInfoChangedEvent {
    public final boolean isInfoChanged;
    public final boolean reqSuccess;

    public VipUserInfoChangedEvent(boolean z, boolean z2) {
        this.reqSuccess = z;
        this.isInfoChanged = z2;
    }

    public /* synthetic */ VipUserInfoChangedEvent(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? false : z2);
    }

    public final boolean getReqSuccess() {
        return this.reqSuccess;
    }

    public final boolean isInfoChanged() {
        return this.isInfoChanged;
    }
}
