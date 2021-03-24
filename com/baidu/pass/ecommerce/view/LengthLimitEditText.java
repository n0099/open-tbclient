package com.baidu.pass.ecommerce.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.baidu.sapi2.NoProguard;
/* loaded from: classes2.dex */
public class LengthLimitEditText extends EditText implements NoProguard {
    public int mLengthLimit;
    public OnTextBeyondLengthLimitListener onTextBeyondLengthLimitListener;

    /* loaded from: classes2.dex */
    public interface OnTextBeyondLengthLimitListener {
        void onBeyondLengthLimit();
    }

    public LengthLimitEditText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setLengthInputFilter() {
        setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.pass.ecommerce.view.LengthLimitEditText.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int length = LengthLimitEditText.this.mLengthLimit - (spanned.length() - (i4 - i3));
                if (length <= 0) {
                    if (LengthLimitEditText.this.onTextBeyondLengthLimitListener != null) {
                        LengthLimitEditText.this.onTextBeyondLengthLimitListener.onBeyondLengthLimit();
                    }
                    return "";
                } else if (length >= i2 - i) {
                    return null;
                } else {
                    int i5 = length + i;
                    return (Character.isHighSurrogate(charSequence.charAt(i5 + (-1))) && (i5 = i5 + (-1)) == i) ? "" : charSequence.subSequence(i, i5);
                }
            }
        }});
    }

    public void setLengthLimit(int i) {
        this.mLengthLimit = i;
        setLengthInputFilter();
    }

    public void setOnTextBeyondLengthLimitListener(OnTextBeyondLengthLimitListener onTextBeyondLengthLimitListener) {
        this.onTextBeyondLengthLimitListener = onTextBeyondLengthLimitListener;
    }

    public LengthLimitEditText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
