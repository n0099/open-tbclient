package com.baidu.graph.sdk.framework.bdbox;
/* loaded from: classes3.dex */
public interface IBDBoxHostInvokeCallback {
    public static final int STATUS_CODE_NOT_INSTALL = -2;
    public static final int STATUS_CODE_NOT_SUPPORT = -1;
    public static final int STATUS_CODE_SUCCESS = 0;

    void onResult(int i, Object obj);
}
