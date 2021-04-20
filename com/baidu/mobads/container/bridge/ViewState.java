package com.baidu.mobads.container.bridge;

import java.util.Locale;
/* loaded from: classes2.dex */
public enum ViewState {
    LOADING,
    DEFAULT,
    RESIZED,
    EXPANDED,
    HIDDEN;

    public String toJavascriptString() {
        return toString().toLowerCase(Locale.US);
    }
}
