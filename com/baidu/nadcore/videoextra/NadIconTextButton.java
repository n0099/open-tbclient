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
import com.baidu.tieba.l81;
import com.baidu.tieba.q61;
import com.baidu.tieba.uo0;
import com.baidu.tieba.zb1;
/* loaded from: classes3.dex */
public class NadIconTextButton extends AppCompatTextView {

    /* loaded from: classes3.dex */
    public class a implements uo0 {
        @Override // com.baidu.tieba.uo0
        public void a() {
        }

        public a() {
        }

        @Override // com.baidu.tieba.uo0
        public void b(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(NadIconTextButton.this.getResources(), bitmap);
                bitmapDrawable.setBounds(0, 0, q61.c.a(NadIconTextButton.this.getContext(), 12.0f), q61.c.a(NadIconTextButton.this.getContext(), 12.0f));
                NadIconTextButton.this.setCompoundDrawables(bitmapDrawable, null, null, null);
            }
        }
    }

    public NadIconTextButton(@NonNull Context context) {
        this(context, null);
    }

    public final void f(@Nullable l81 l81Var) {
        if (l81Var != null && !TextUtils.isEmpty(l81Var.b)) {
            setText(l81Var.b);
        } else {
            setText(getContext().getString(R.string.nad_icon_text));
        }
    }

    public void update(@Nullable l81 l81Var) {
        f(l81Var);
        e(l81Var);
    }

    public NadIconTextButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadIconTextButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }

    public final void d(@NonNull Context context) {
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

    public final void e(@Nullable l81 l81Var) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_sv_button_icon);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        setCompoundDrawables(drawable, null, null, null);
        if (l81Var != null && !TextUtils.isEmpty(l81Var.a)) {
            zb1.a().c(l81Var.a, new a());
        }
    }
}
