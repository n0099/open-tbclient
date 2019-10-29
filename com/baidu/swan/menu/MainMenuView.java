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
    private SwanAppMenuSlidableGridView bJQ;
    private i bJR;
    private int bJS;
    private boolean bJT;
    private SwanAppMenuMode bJU;
    private View bJV;
    private List<j> mItems;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bJT = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.bJQ = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.bJQ.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.bJQ, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aaw() {
        return this.mItems != null && this.mItems.size() > 0 && this.mItems.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bJU = swanAppMenuMode;
        this.bJQ.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.bJQ.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bJS = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(List<j> list) {
        this.mItems = list;
        this.bJQ.setGridViewPading(0, 0, 0, 0);
        this.bJQ.setIndicatorColor(f.c.menu_indicator_normal, f.c.menu_indicator_selected);
        this.bJQ.setBackground(null);
        if (this.bJR == null) {
            this.bJR = new i(this.mContext);
            this.bJQ.setGridItemAdapter(this.bJR);
        }
        this.bJR.setMenuStyle(this.bJS);
        this.bJR.dA(this.bJT);
        this.bJR.setData(list);
        this.bJR.aaQ();
        this.mItems = list;
    }

    public void setDismissCallback(a aVar) {
    }

    public void aax() {
    }

    public void setStatisticSource(String str) {
    }

    public void setMenuSource(String str) {
    }

    @Nullable
    public View getCoverView() {
        return this.bJV;
    }

    public void setCoverView(View view) {
        this.bJV = view;
    }
}
