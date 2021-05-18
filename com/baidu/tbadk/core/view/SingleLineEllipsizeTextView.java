package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.c.e.p.k;
/* loaded from: classes3.dex */
public class SingleLineEllipsizeTextView extends EMTextView {

    /* renamed from: f  reason: collision with root package name */
    public String f12428f;

    public SingleLineEllipsizeTextView(Context context) {
        super(context);
        this.f12428f = StringHelper.STRING_MORE;
        setSingleLine();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        CharSequence text = getText();
        if (k.isEmpty(text.toString())) {
            return;
        }
        TextPaint paint = getPaint();
        float measureText = paint.measureText(this.f12428f);
        float measureText2 = paint.measureText(text.toString());
        float paddingRight = getPaddingRight() + getPaddingLeft();
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables.length == 4) {
            if (compoundDrawables[0] != null) {
                paddingRight += compoundDrawables[0].getBounds().width() + getCompoundDrawablePadding();
            }
            if (compoundDrawables[2] != null) {
                paddingRight += compoundDrawables[2].getBounds().width() + getCompoundDrawablePadding();
            }
        }
        float measuredWidth = getMeasuredWidth() - paddingRight;
        if (measureText2 > measuredWidth) {
            int length = text.length();
            while (measureText2 + measureText > measuredWidth && length > 1) {
                length--;
                measureText2 = paint.measureText(text, 0, length - 1);
            }
            if (length > 0) {
                if (paint.measureText(((Object) text.subSequence(0, length - 1)) + this.f12428f) > measuredWidth) {
                    length--;
                }
            }
            if (length > 0) {
                text = ((Object) text.subSequence(0, length - 1)) + this.f12428f;
            }
            float measureText3 = paint.measureText(text.toString());
            setText(text);
            setMeasuredDimension((int) (measureText3 + paddingRight), getMeasuredHeight());
        }
    }

    public void setEllipsisSuffix(String str) {
        this.f12428f = str;
    }

    public SingleLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12428f = StringHelper.STRING_MORE;
        setSingleLine();
    }

    public SingleLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12428f = StringHelper.STRING_MORE;
        setSingleLine();
    }
}
