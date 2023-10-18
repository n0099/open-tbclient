package com.baidu.nadcore.videoextra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.c11;
import com.baidu.tieba.l61;
import com.baidu.tieba.qj0;
import com.baidu.tieba.x21;
/* loaded from: classes3.dex */
public class NadIconTextButton extends AppCompatTextView {

    /* loaded from: classes3.dex */
    public class a implements qj0 {
        @Override // com.baidu.tieba.qj0
        public void a() {
        }

        public a() {
        }

        @Override // com.baidu.tieba.qj0
        public void b(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(NadIconTextButton.this.getResources(), bitmap);
                bitmapDrawable.setBounds(0, 0, c11.c.a(NadIconTextButton.this.getContext(), 12.0f), c11.c.a(NadIconTextButton.this.getContext(), 12.0f));
                NadIconTextButton.this.setCompoundDrawables(bitmapDrawable, null, null, null);
            }
        }
    }

    public NadIconTextButton(@NonNull Context context) {
        this(context, null);
    }

    public void f(@Nullable x21 x21Var) {
        i(x21Var);
        h(x21Var);
    }

    public final void i(@Nullable x21 x21Var) {
        if (x21Var != null && !TextUtils.isEmpty(x21Var.b)) {
            setText(x21Var.b);
        } else {
            setText(getContext().getString(R.string.nad_icon_text));
        }
    }

    public NadIconTextButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadIconTextButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context);
    }

    public final void e(@NonNull Context context) {
        setGravity(16);
        setTextSize(0, context.getResources().getDimension(R.dimen.nad_dimen_12dp));
        setTextColor(ContextCompat.getColor(context, R.color.nad_icon_text_color));
        setCompoundDrawablePadding(context.getResources().getDimensionPixelOffset(R.dimen.nad_dimen_5dp));
        setIncludeFontPadding(false);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen.nad_dimen_90dp));
        gradientDrawable.setColor(ContextCompat.getColor(context, R.color.nad_icon_text_background));
        setBackground(gradientDrawable);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.nad_dimen_9dp);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.nad_dimen_5_5dp);
        setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
    }

    public final void h(@Nullable x21 x21Var) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_sv_button_icon);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        setCompoundDrawables(drawable, null, null, null);
        if (x21Var != null && !TextUtils.isEmpty(x21Var.a)) {
            l61.a().c(x21Var.a, new a());
        }
    }
}
