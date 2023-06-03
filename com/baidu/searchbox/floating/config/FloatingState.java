package com.baidu.searchbox.floating.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/floating/config/FloatingState;", "", "invokeFloatingMode", "Lcom/baidu/searchbox/floating/config/InvokeFloatingMode;", "(Lcom/baidu/searchbox/floating/config/InvokeFloatingMode;)V", "getInvokeFloatingMode", "()Lcom/baidu/searchbox/floating/config/InvokeFloatingMode;", "setInvokeFloatingMode", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatingState {
    public InvokeFloatingMode invokeFloatingMode;

    public FloatingState() {
        this(null, 1, null);
    }

    public FloatingState(InvokeFloatingMode invokeFloatingMode) {
        this.invokeFloatingMode = invokeFloatingMode;
    }

    public final void setInvokeFloatingMode(InvokeFloatingMode invokeFloatingMode) {
        this.invokeFloatingMode = invokeFloatingMode;
    }

    public /* synthetic */ FloatingState(InvokeFloatingMode invokeFloatingMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : invokeFloatingMode);
    }

    public final InvokeFloatingMode getInvokeFloatingMode() {
        return this.invokeFloatingMode;
    }
}
