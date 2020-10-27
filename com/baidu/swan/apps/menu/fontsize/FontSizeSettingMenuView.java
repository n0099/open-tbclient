package com.baidu.swan.apps.menu.fontsize;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SliderBar;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes10.dex */
public class FontSizeSettingMenuView extends BaseMenuView {
    private SliderBar cZS;
    private SliderBar.b cZT;
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
        this.cZS = (SliderBar) inflate(this.mContext, a.g.swan_app_font_setting, null);
        this.cZS.jC(b.azs());
        a(this.cZS, new FrameLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(a.d.font_setting_font_slider_bar_height_pop)));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean azu() {
        return false;
    }

    public void setOnSliderBarChangeListener(SliderBar.b bVar) {
        this.cZT = bVar;
        this.cZS.a(this.cZT);
    }
}
