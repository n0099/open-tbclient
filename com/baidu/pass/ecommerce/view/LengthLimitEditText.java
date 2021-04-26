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
            public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                int length = LengthLimitEditText.this.mLengthLimit - (spanned.length() - (i5 - i4));
                if (length <= 0) {
                    if (LengthLimitEditText.this.onTextBeyondLengthLimitListener != null) {
                        LengthLimitEditText.this.onTextBeyondLengthLimitListener.onBeyondLengthLimit();
                    }
                    return "";
                } else if (length >= i3 - i2) {
                    return null;
                } else {
                    int i6 = length + i2;
                    return (Character.isHighSurrogate(charSequence.charAt(i6 + (-1))) && (i6 = i6 + (-1)) == i2) ? "" : charSequence.subSequence(i2, i6);
                }
            }
        }});
    }

    public void setLengthLimit(int i2) {
        this.mLengthLimit = i2;
        setLengthInputFilter();
    }

    public void setOnTextBeyondLengthLimitListener(OnTextBeyondLengthLimitListener onTextBeyondLengthLimitListener) {
        this.onTextBeyondLengthLimitListener = onTextBeyondLengthLimitListener;
    }

    public LengthLimitEditText(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
