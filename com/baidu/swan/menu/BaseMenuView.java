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
import d.a.l0.k.f;
import d.a.l0.k.g;
import d.a.l0.k.h;
import d.a.l0.k.i;
import d.a.l0.k.j;
/* loaded from: classes3.dex */
public abstract class BaseMenuView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f11856e;

    /* renamed from: f  reason: collision with root package name */
    public View f11857f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11858g;

    /* renamed from: h  reason: collision with root package name */
    public View f11859h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11860i;

    public BaseMenuView(@NonNull Context context) {
        this(context, null);
    }

    public void a(int i2) {
        this.f11857f.getLayoutParams().height = i2 + this.f11860i;
        this.f11857f.requestLayout();
    }

    public abstract boolean b();

    public void c(View view, FrameLayout.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height != 0) {
            this.f11857f.getLayoutParams().height = height + this.f11860i;
        }
        this.f11859h = view;
        layoutParams.bottomMargin = this.f11860i;
        addView(view, layoutParams);
    }

    public View getBgView() {
        return this.f11857f;
    }

    public View getContentView() {
        return this.f11859h;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f11858g.setOnClickListener(onClickListener);
    }

    public void setMode() {
        Resources resources = getResources();
        this.f11857f.setBackground(resources.getDrawable(h.swan_app_menu_content_bg));
        this.f11858g.setBackgroundColor(resources.getColor(f.aiapp_menu_cancel_text_color_bg));
        this.f11858g.setTextColor(resources.getColorStateList(f.aiapp_menu_cancel_text_color_day));
        this.f11858g.setAlpha(1.0f);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f11856e = context;
        View inflate = FrameLayout.inflate(context, j.aiapp_menu_base_view_layout, this);
        this.f11857f = inflate.findViewById(i.background);
        this.f11858g = (TextView) inflate.findViewById(i.cancel);
        this.f11860i = (int) context.getResources().getDimension(g.aiapp_menu_cancel_btn_height);
    }
}
