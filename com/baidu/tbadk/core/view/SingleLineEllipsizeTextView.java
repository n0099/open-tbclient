package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class SingleLineEllipsizeTextView extends EMTextView {
    private String fgX;

    public SingleLineEllipsizeTextView(Context context) {
        super(context);
        this.fgX = StringHelper.STRING_MORE;
        setSingleLine();
    }

    public SingleLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgX = StringHelper.STRING_MORE;
        setSingleLine();
    }

    public SingleLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgX = StringHelper.STRING_MORE;
        setSingleLine();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        CharSequence text = getText();
        if (!at.isEmpty(text.toString())) {
            TextPaint paint = getPaint();
            float measureText = paint.measureText(this.fgX);
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
                if (length > 0 && paint.measureText(((Object) text.subSequence(0, length - 1)) + this.fgX) > measuredWidth) {
                    length--;
                }
                if (length > 0) {
                    text = ((Object) text.subSequence(0, length - 1)) + this.fgX;
                }
                float measureText3 = paint.measureText(text.toString());
                setText(text);
                setMeasuredDimension((int) (paddingRight + measureText3), getMeasuredHeight());
            }
        }
    }

    public void setEllipsisSuffix(String str) {
        this.fgX = str;
    }
}
