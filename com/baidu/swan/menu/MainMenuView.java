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
    private List<j> aOH;
    private SwanAppMenuSlidableGridView bpU;
    private i bpV;
    private int bpW;
    private boolean bpX;
    private SwanAppMenuMode bpY;
    private View bpZ;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bpX = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.bpU = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.bpU.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.bpU, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean UL() {
        return this.aOH != null && this.aOH.size() > 0 && this.aOH.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bpY = swanAppMenuMode;
        this.bpU.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.bpU.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bpW = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(List<j> list) {
        this.aOH = list;
        this.bpU.setGridViewPading(0, 0, 0, 0);
        this.bpU.setIndicatorColor(f.c.menu_indicator_normal, f.c.menu_indicator_selected);
        this.bpU.setBackground(null);
        if (this.bpV == null) {
            this.bpV = new i(this.mContext);
            this.bpU.setGridItemAdapter(this.bpV);
        }
        this.bpV.setMenuStyle(this.bpW);
        this.bpV.de(this.bpX);
        this.bpV.setData(list);
        this.bpV.Ve();
        this.aOH = list;
    }

    public void setDismissCallback(a aVar) {
    }

    public void UM() {
    }

    public void setStatisticSource(String str) {
    }

    public void setMenuSource(String str) {
    }

    @Nullable
    public View getCoverView() {
        return this.bpZ;
    }

    public void setCoverView(View view) {
        this.bpZ = view;
    }
}
