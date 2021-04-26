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
import d.a.h0.i.f;
import d.a.h0.i.g;
import d.a.h0.i.h;
import d.a.h0.i.i;
import d.a.h0.i.j;
/* loaded from: classes3.dex */
public abstract class BaseMenuView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f12551e;

    /* renamed from: f  reason: collision with root package name */
    public View f12552f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12553g;

    /* renamed from: h  reason: collision with root package name */
    public View f12554h;

    /* renamed from: i  reason: collision with root package name */
    public View f12555i;
    public final int j;

    public BaseMenuView(@NonNull Context context) {
        this(context, null);
    }

    public void a(int i2) {
        this.f12552f.getLayoutParams().height = i2 + this.j;
        this.f12552f.requestLayout();
    }

    public abstract boolean b();

    public void c(View view, FrameLayout.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height != 0) {
            this.f12552f.getLayoutParams().height = height + this.j;
        }
        this.f12555i = view;
        layoutParams.bottomMargin = this.j;
        addView(view, layoutParams);
    }

    public View getBgView() {
        return this.f12552f;
    }

    public View getContentView() {
        return this.f12555i;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f12553g.setOnClickListener(onClickListener);
    }

    public void setMode() {
        Resources resources = getResources();
        this.f12552f.setBackground(resources.getDrawable(h.swan_common_menu_content_bg));
        this.f12554h.setBackgroundColor(resources.getColor(f.aiapp_menu_split_line_day));
        this.f12553g.setBackgroundColor(resources.getColor(f.aiapp_menu_cancel_text_color_bg));
        this.f12553g.setTextColor(resources.getColorStateList(f.aiapp_menu_cancel_text_color_day));
        this.f12554h.setAlpha(1.0f);
        this.f12553g.setAlpha(1.0f);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f12551e = context;
        View inflate = FrameLayout.inflate(context, j.aiapp_menu_base_view_layout, this);
        this.f12552f = inflate.findViewById(i.background);
        this.f12553g = (TextView) inflate.findViewById(i.cancel);
        this.f12554h = inflate.findViewById(i.divider);
        Resources resources = context.getResources();
        this.j = ((int) resources.getDimension(g.aiapp_menu_divider_height)) + ((int) resources.getDimension(g.aiapp_menu_cancel_btn_height));
    }
}
