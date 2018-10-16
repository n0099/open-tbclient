package com.baidu.searchbox.ng.ai.apps.account;
/* loaded from: classes2.dex */
public interface OnAiAppLoginResultListener {
    public static final int CANCELD = -2;
    public static final int FAILED = -1;
    public static final int SUCCESS = 0;

    void onResult(int i);
}
