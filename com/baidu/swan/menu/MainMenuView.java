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
    private List<j> aPr;
    private SwanAppMenuSlidableGridView bqH;
    private i bqI;
    private int bqJ;
    private boolean bqK;
    private SwanAppMenuMode bqL;
    private View bqM;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.bqK = false;
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2);
        this.bqH = new SwanAppMenuSlidableGridView(context, attributeSet, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.bqH.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        linearLayout.addView(this.bqH, layoutParams);
        a(linearLayout, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean VD() {
        return this.aPr != null && this.aPr.size() > 0 && this.aPr.size() > 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.menu.BaseMenuView
    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bqL = swanAppMenuMode;
        this.bqH.setMode(swanAppMenuMode);
        super.setMode(swanAppMenuMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.bqH.setCurrentPage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bqJ = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(List<j> list) {
        this.aPr = list;
        this.bqH.setGridViewPading(0, 0, 0, 0);
        this.bqH.setIndicatorColor(f.c.menu_indicator_normal, f.c.menu_indicator_selected);
        this.bqH.setBackground(null);
        if (this.bqI == null) {
            this.bqI = new i(this.mContext);
            this.bqH.setGridItemAdapter(this.bqI);
        }
        this.bqI.setMenuStyle(this.bqJ);
        this.bqI.dj(this.bqK);
        this.bqI.setData(list);
        this.bqI.VX();
        this.aPr = list;
    }

    public void setDismissCallback(a aVar) {
    }

    public void VE() {
    }

    public void setStatisticSource(String str) {
    }

    public void setMenuSource(String str) {
    }

    @Nullable
    public View getCoverView() {
        return this.bqM;
    }

    public void setCoverView(View view) {
        this.bqM = view;
    }
}
