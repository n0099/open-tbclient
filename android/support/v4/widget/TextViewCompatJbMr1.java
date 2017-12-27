package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
/* loaded from: classes2.dex */
class TextViewCompatJbMr1 {
    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = textView.getLayoutDirection() == 1;
        Drawable drawable5 = z ? drawable3 : drawable;
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = textView.getLayoutDirection() == 1;
        Drawable drawable5 = z ? drawable3 : drawable;
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
        boolean z = textView.getLayoutDirection() == 1;
        int i5 = z ? i3 : i;
        if (!z) {
            i = i3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }
}
