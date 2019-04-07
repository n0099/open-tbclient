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
    private List<k> aMJ;
    private SwanAppMenuSlidableGridView bjQ;
    private j bjR;
    private int bjS;
    private boolean bjT;
    private SwanAppMenuMode bjU;
    private View bjV;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bjT = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.bjQ = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.bjQ.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.bjQ, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean QZ() {
        return this.aMJ != null && this.aMJ.size() > 0 && this.aMJ.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bjU = swanAppMenuMode;
        this.bjQ.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.bjQ.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjS = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(List<k> list) {
        this.aMJ = list;
        this.bjQ.setGridViewPading(0, 0, 0, 0);
        this.bjQ.setIndicatorColor(g.c.menu_indicator_normal, g.c.menu_indicator_selected);
        this.bjQ.setBackground(null);
        if (this.bjR == null) {
            this.bjR = new j(this.mContext);
            this.bjQ.setGridItemAdapter(this.bjR);
        }
        this.bjR.setMenuStyle(this.bjS);
        this.bjR.cN(this.bjT);
        this.bjR.setData(list);
        this.bjR.Rs();
        this.aMJ = list;
    }

    public void setDismissCallback(b bVar) {
    }

    public void Ra() {
    }

    public void setStatisticSource(String str) {
    }

    public void setMenuSource(String str) {
    }

    @Nullable
    public View getCoverView() {
        return this.bjV;
    }

    public void setCoverView(View view) {
        this.bjV = view;
    }
}
