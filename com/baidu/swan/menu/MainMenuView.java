package com.baidu.swan.menu;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.swan.menu.g;
import com.baidu.swan.menu.viewpager.SwanAppMenuSlidableGridView;
import java.util.List;
/* loaded from: classes2.dex */
public class MainMenuView extends BaseMenuView {
    private List<k> aMG;
    private SwanAppMenuSlidableGridView bjN;
    private j bjO;
    private int bjP;
    private boolean bjQ;
    private SwanAppMenuMode bjR;
    private View bjS;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bjQ = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.bjN = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.bjN.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.bjN, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean Rb() {
        return this.aMG != null && this.aMG.size() > 0 && this.aMG.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bjR = swanAppMenuMode;
        this.bjN.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.bjN.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjP = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(List<k> list) {
        this.aMG = list;
        this.bjN.setGridViewPading(0, 0, 0, 0);
        this.bjN.setIndicatorColor(g.c.menu_indicator_normal, g.c.menu_indicator_selected);
        this.bjN.setBackground(null);
        if (this.bjO == null) {
            this.bjO = new j(this.mContext);
            this.bjN.setGridItemAdapter(this.bjO);
        }
        this.bjO.setMenuStyle(this.bjP);
        this.bjO.cN(this.bjQ);
        this.bjO.setData(list);
        this.bjO.Ru();
        this.aMG = list;
    }

    public void setDismissCallback(b bVar) {
    }

    public void Rc() {
    }

    public void setStatisticSource(String str) {
    }

    public void setMenuSource(String str) {
    }

    @Nullable
    public View getCoverView() {
        return this.bjS;
    }

    public void setCoverView(View view) {
        this.bjS = view;
    }
}
