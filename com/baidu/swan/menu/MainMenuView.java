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
    private List<k> aMK;
    private SwanAppMenuSlidableGridView bjR;
    private j bjS;
    private int bjT;
    private boolean bjU;
    private SwanAppMenuMode bjV;
    private View bjW;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bjU = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.bjR = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.bjR.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.bjR, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean QZ() {
        return this.aMK != null && this.aMK.size() > 0 && this.aMK.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bjV = swanAppMenuMode;
        this.bjR.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.bjR.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjT = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(List<k> list) {
        this.aMK = list;
        this.bjR.setGridViewPading(0, 0, 0, 0);
        this.bjR.setIndicatorColor(g.c.menu_indicator_normal, g.c.menu_indicator_selected);
        this.bjR.setBackground(null);
        if (this.bjS == null) {
            this.bjS = new j(this.mContext);
            this.bjR.setGridItemAdapter(this.bjS);
        }
        this.bjS.setMenuStyle(this.bjT);
        this.bjS.cN(this.bjU);
        this.bjS.setData(list);
        this.bjS.Rs();
        this.aMK = list;
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
        return this.bjW;
    }

    public void setCoverView(View view) {
        this.bjW = view;
    }
}
