package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
/* loaded from: classes2.dex */
class r {
    private static final int[] sq = {R.attr.colorPrimary};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(sq);
        boolean z = obtainStyledAttributes.hasValue(0) ? false : true;
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
