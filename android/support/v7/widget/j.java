package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes2.dex */
class j extends i {
    private t NJ;
    private t NK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TextView textView) {
        super(textView);
    }

    @Override // android.support.v7.widget.i
    void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.NJ = a(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.NK = a(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.widget.i
    void fQ() {
        super.fQ();
        if (this.NJ != null || this.NK != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.NJ);
            a(compoundDrawablesRelative[2], this.NK);
        }
    }
}
