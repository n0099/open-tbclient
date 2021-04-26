package com.baidu.swan.apps.menu.fontsize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.res.ui.SliderBar;
import com.baidu.swan.menu.BaseMenuView;
import d.a.h0.a.c1.c.b;
import d.a.h0.a.d;
import d.a.h0.a.g;
/* loaded from: classes3.dex */
public class FontSizeSettingMenuView extends BaseMenuView {
    public Context k;
    public SliderBar l;
    public SliderBar.c m;

    public FontSizeSettingMenuView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean b() {
        return false;
    }

    public final void d() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.l = (SliderBar) FrameLayout.inflate(this.k, g.swan_app_font_setting, null);
        this.l.F(b.b());
        c(this.l, new FrameLayout.LayoutParams(-1, (int) this.k.getResources().getDimension(d.font_setting_font_slider_bar_height_pop)));
    }

    public void setOnSliderBarChangeListener(SliderBar.c cVar) {
        this.m = cVar;
        this.l.E(cVar);
    }

    public FontSizeSettingMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FontSizeSettingMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.k = context.getApplicationContext();
        d();
    }
}
