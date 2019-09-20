package com.baidu.swan.menu;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.viewpager.SwanAppMenuSlidableGridView;
import java.util.List;
/* loaded from: classes2.dex */
public class MainMenuView extends BaseMenuView {
    private List<j> aPP;
    private SwanAppMenuSlidableGridView brf;
    private i brg;
    private int brh;
    private boolean bri;
    private SwanAppMenuMode brj;
    private View brk;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bri = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.brf = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.brf.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.brf, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean VH() {
        return this.aPP != null && this.aPP.size() > 0 && this.aPP.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.brj = swanAppMenuMode;
        this.brf.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.brf.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.brh = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(List<j> list) {
        this.aPP = list;
        this.brf.setGridViewPading(0, 0, 0, 0);
        this.brf.setIndicatorColor(f.c.menu_indicator_normal, f.c.menu_indicator_selected);
        this.brf.setBackground(null);
        if (this.brg == null) {
            this.brg = new i(this.mContext);
            this.brf.setGridItemAdapter(this.brg);
        }
        this.brg.setMenuStyle(this.brh);
        this.brg.dj(this.bri);
        this.brg.setData(list);
        this.brg.Wb();
        this.aPP = list;
    }

    public void setDismissCallback(a aVar) {
    }

    public void VI() {
    }

    public void setStatisticSource(String str) {
    }

    public void setMenuSource(String str) {
    }

    @Nullable
    public View getCoverView() {
        return this.brk;
    }

    public void setCoverView(View view) {
        this.brk = view;
    }
}
