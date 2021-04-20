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
import d.b.g0.i.f;
import d.b.g0.i.g;
import d.b.g0.i.h;
import d.b.g0.i.i;
import d.b.g0.i.j;
/* loaded from: classes3.dex */
public abstract class BaseMenuView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f12643e;

    /* renamed from: f  reason: collision with root package name */
    public View f12644f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12645g;

    /* renamed from: h  reason: collision with root package name */
    public View f12646h;
    public View i;
    public final int j;

    public BaseMenuView(@NonNull Context context) {
        this(context, null);
    }

    public void a(int i) {
        this.f12644f.getLayoutParams().height = i + this.j;
        this.f12644f.requestLayout();
    }

    public abstract boolean b();

    public void c(View view, FrameLayout.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height != 0) {
            this.f12644f.getLayoutParams().height = height + this.j;
        }
        this.i = view;
        layoutParams.bottomMargin = this.j;
        addView(view, layoutParams);
    }

    public View getBgView() {
        return this.f12644f;
    }

    public View getContentView() {
        return this.i;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f12645g.setOnClickListener(onClickListener);
    }

    public void setMode() {
        Resources resources = getResources();
        this.f12644f.setBackground(resources.getDrawable(h.swan_common_menu_content_bg));
        this.f12646h.setBackgroundColor(resources.getColor(f.aiapp_menu_split_line_day));
        this.f12645g.setBackgroundColor(resources.getColor(f.aiapp_menu_cancel_text_color_bg));
        this.f12645g.setTextColor(resources.getColorStateList(f.aiapp_menu_cancel_text_color_day));
        this.f12646h.setAlpha(1.0f);
        this.f12645g.setAlpha(1.0f);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f12643e = context;
        View inflate = FrameLayout.inflate(context, j.aiapp_menu_base_view_layout, this);
        this.f12644f = inflate.findViewById(i.background);
        this.f12645g = (TextView) inflate.findViewById(i.cancel);
        this.f12646h = inflate.findViewById(i.divider);
        Resources resources = context.getResources();
        this.j = ((int) resources.getDimension(g.aiapp_menu_divider_height)) + ((int) resources.getDimension(g.aiapp_menu_cancel_btn_height));
    }
}
