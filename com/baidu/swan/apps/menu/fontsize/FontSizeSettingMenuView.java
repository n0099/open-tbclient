package com.baidu.swan.apps.menu.fontsize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SliderBar;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes9.dex */
public class FontSizeSettingMenuView extends BaseMenuView {
    private SliderBar dnA;
    private SliderBar.b dnB;
    private Context mContext;

    public FontSizeSettingMenuView(@NonNull Context context) {
        this(context, null);
    }

    public FontSizeSettingMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FontSizeSettingMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mContext = context.getApplicationContext();
        init();
    }

    private void init() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.dnA = (SliderBar) inflate(this.mContext, a.g.swan_app_font_setting, null);
        this.dnA.iC(b.aCq());
        a(this.dnA, new FrameLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(a.d.font_setting_font_slider_bar_height_pop)));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aCs() {
        return false;
    }

    public void setOnSliderBarChangeListener(SliderBar.b bVar) {
        this.dnB = bVar;
        this.dnA.a(this.dnB);
    }
}
