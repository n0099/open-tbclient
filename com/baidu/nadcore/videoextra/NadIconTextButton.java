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
import com.baidu.tieba.b41;
import com.baidu.tieba.dn0;
import com.baidu.tieba.qa1;
import com.baidu.tieba.s51;
/* loaded from: classes2.dex */
public class NadIconTextButton extends AppCompatTextView {

    /* loaded from: classes2.dex */
    public class a implements dn0 {
        public a() {
        }

        @Override // com.baidu.tieba.dn0
        public void b(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(NadIconTextButton.this.getResources(), bitmap);
                bitmapDrawable.setBounds(0, 0, b41.c.a(NadIconTextButton.this.getContext(), 12.0f), b41.c.a(NadIconTextButton.this.getContext(), 12.0f));
                NadIconTextButton.this.setCompoundDrawables(bitmapDrawable, null, null, null);
            }
        }

        @Override // com.baidu.tieba.dn0
        public void a() {
            Drawable drawable = ContextCompat.getDrawable(NadIconTextButton.this.getContext(), R.drawable.nad_sv_button_icon);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            NadIconTextButton.this.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public NadIconTextButton(@NonNull Context context) {
        this(context, null);
    }

    public final void d(@Nullable s51 s51Var) {
        if (s51Var != null && !TextUtils.isEmpty(s51Var.b)) {
            setText(s51Var.b);
        } else {
            setText(getContext().getString(R.string.nad_icon_text));
        }
    }

    public void update(@Nullable s51 s51Var) {
        d(s51Var);
        c(s51Var);
    }

    public NadIconTextButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadIconTextButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public final void a(@NonNull Context context) {
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

    public final void c(@Nullable s51 s51Var) {
        if (s51Var != null && !TextUtils.isEmpty(s51Var.a)) {
            qa1.a().c(s51Var.a, new a());
            return;
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_sv_button_icon);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        setCompoundDrawables(drawable, null, null, null);
    }
}
