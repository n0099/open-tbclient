package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.os.Bundle;
/* loaded from: classes2.dex */
public interface IAiAppFeedbackIoc {

    /* loaded from: classes2.dex */
    public interface OnFeedbackResultCallback {
        void onResult(String str);
    }

    void feedback(Bundle bundle, OnFeedbackResultCallback onFeedbackResultCallback);
}
