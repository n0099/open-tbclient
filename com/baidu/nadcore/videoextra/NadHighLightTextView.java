package com.baidu.nadcore.videoextra;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.w21;
import com.baidu.tieba.y01;
/* loaded from: classes3.dex */
public class NadHighLightTextView extends AppCompatTextView {
    public NadHighLightTextView(@NonNull Context context) {
        this(context, null);
    }

    public NadHighLightTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadHighLightTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
    }

    public final void e() {
        setTypeface(Typeface.DEFAULT_BOLD);
        setMinLines(1);
        setMaxLines(2);
        setEllipsize(TextUtils.TruncateAt.END);
        setLineSpacing(getContext().getResources().getDimension(R.dimen.nad_dimen_5dp), 1.0f);
        setTextSize(1, 18.0f);
    }

    public void f(@Nullable w21 w21Var) {
        if (w21Var != null && !TextUtils.isEmpty(w21Var.a)) {
            SpannableString spannableString = new SpannableString(w21Var.a);
            for (w21.a aVar : w21Var.c) {
                int[] iArr = aVar.a;
                if (iArr != null && iArr.length == 2) {
                    int a = y01.a(aVar.b, R.color.nad_high_light_text_default_color);
                    aVar.a[1] = Math.min(w21Var.a.length(), aVar.a[1]);
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(a);
                    int[] iArr2 = aVar.a;
                    spannableString.setSpan(foregroundColorSpan, iArr2[0], iArr2[1], 17);
                }
            }
            setText(spannableString);
            setTextColor(y01.a(w21Var.b, R.color.nad_high_light_text_default_color));
        }
    }
}
