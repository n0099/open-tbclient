package com.baidu.swan.menu;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.swan.menu.g;
import java.util.List;
/* loaded from: classes9.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView dtA;
    private d dtB;
    private RecyclerView dtC;
    private d dtD;
    private List<List<i>> dtE;
    private View dtF;
    private boolean dtG;
    private LinearLayout mContentView;
    private View mDivider;
    private View mHeaderView;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mContentView = new LinearLayout(context, attributeSet, i);
        this.mContentView.setOrientation(1);
        this.dtA = new RecyclerView(context, attributeSet, i);
        this.dtA.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dtA.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.dtA, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.dtC = new RecyclerView(context, attributeSet, i);
        this.dtC.setVisibility(8);
        this.dtC.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.dtC, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aJN() {
        return this.dtE != null && this.dtE.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        aJO();
        setMenuHeader(view);
        a(list, z, i);
    }

    private void setMenuHeader(View view) {
        if (view != null && view != this.mHeaderView) {
            if (this.mHeaderView != null) {
                this.mContentView.removeView(this.mHeaderView);
            }
            this.mHeaderView = view;
            this.mContentView.addView(this.mHeaderView, 0);
        }
    }

    private void a(List<List<i>> list, boolean z, int i) {
        this.dtE = list;
        this.dtG = z;
        if (z && list.size() > 1) {
            jp(i);
        } else {
            jq(i);
        }
    }

    private void jp(int i) {
        this.mDivider.setVisibility(0);
        this.dtC.setVisibility(0);
        if (this.dtB == null) {
            this.dtB = new d(getContext());
            this.dtA.setAdapter(this.dtB);
        }
        this.dtB.b(this.dtE.subList(0, 1), this.dtG, i);
        if (this.dtD == null) {
            this.dtD = new d(getContext());
            this.dtC.setAdapter(this.dtD);
        }
        this.dtD.b(this.dtE.subList(1, 2), this.dtG, i);
    }

    private void jq(int i) {
        this.mDivider.setVisibility(8);
        this.dtC.setVisibility(8);
        if (this.dtB == null) {
            this.dtB = new d(getContext());
            this.dtA.setAdapter(this.dtB);
        }
        this.dtB.b(this.dtE, this.dtG, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dtA != null) {
            this.dtA.scrollToPosition(0);
        }
        if (this.dtC != null) {
            this.dtA.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJP() {
        if (this.dtB != null) {
            this.dtB.notifyDataSetChanged();
        }
        if (this.dtD != null) {
            this.dtD.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.dtF;
    }

    public void setCoverView(View view) {
        this.dtF = view;
    }
}
