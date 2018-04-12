package android.support.v4.app;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityGingerbread {
    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view2, str, context, attributeSet);
        if (dispatchFragmentsOnCreateView == null && Build.VERSION.SDK_INT >= 11) {
            return super.onCreateView(view2, str, context, attributeSet);
        }
        return dispatchFragmentsOnCreateView;
    }
}
