package com.baidu.searchbox.ng.ai.apps.view.coverview;

import android.view.View;
/* loaded from: classes2.dex */
public interface OnActionCallback {
    public static final int ACTION_CLK = 2;
    public static final int ACTION_IMAGE_LOAD_END = 1;
    public static final int ACTION_IMAGE_LOAD_FAILED = 0;

    void onAction(int i, View view, Object obj);
}
