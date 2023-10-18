package com.baidu.swan.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class BaseMenuView extends FrameLayout {
    public Context a;
    public View b;
    public TextView c;
    public View d;
    public final int e;

    public abstract boolean a();

    public BaseMenuView(@NonNull Context context) {
        this(context, null);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b(View view2, FrameLayout.LayoutParams layoutParams) {
        if (view2 == null) {
            return;
        }
        this.d = view2;
        layoutParams.bottomMargin = this.e;
        addView(view2, layoutParams);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.a = context;
        View inflate = FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0092, this);
        this.b = inflate.findViewById(R.id.obfuscated_res_0x7f09032d);
        this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09053b);
        this.e = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f0700e3);
    }

    public View getBgView() {
        return this.b;
    }

    public View getContentView() {
        return this.d;
    }

    public void setMode() {
        Resources resources = getResources();
        this.b.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08143a));
        this.c.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f0603f3));
        this.c.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f0603f4));
        this.c.setAlpha(1.0f);
    }
}
