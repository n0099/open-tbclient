package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes5.dex */
abstract class g extends f {
    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        if (dispatchFragmentsOnCreateView == null && Build.VERSION.SDK_INT >= 11) {
            return super.onCreateView(view, str, context, attributeSet);
        }
        return dispatchFragmentsOnCreateView;
    }
}
