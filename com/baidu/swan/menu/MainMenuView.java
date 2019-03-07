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
    private List<k> aMF;
    private SwanAppMenuSlidableGridView bjM;
    private j bjN;
    private int bjO;
    private boolean bjP;
    private SwanAppMenuMode bjQ;
    private View bjR;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bjP = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.bjM = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.bjM.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.bjM, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean Rb() {
        return this.aMF != null && this.aMF.size() > 0 && this.aMF.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bjQ = swanAppMenuMode;
        this.bjM.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.bjM.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjO = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(List<k> list) {
        this.aMF = list;
        this.bjM.setGridViewPading(0, 0, 0, 0);
        this.bjM.setIndicatorColor(g.c.menu_indicator_normal, g.c.menu_indicator_selected);
        this.bjM.setBackground(null);
        if (this.bjN == null) {
            this.bjN = new j(this.mContext);
            this.bjM.setGridItemAdapter(this.bjN);
        }
        this.bjN.setMenuStyle(this.bjO);
        this.bjN.cN(this.bjP);
        this.bjN.setData(list);
        this.bjN.Ru();
        this.aMF = list;
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
        return this.bjR;
    }

    public void setCoverView(View view) {
        this.bjR = view;
    }
}
