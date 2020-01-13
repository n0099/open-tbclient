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
/* loaded from: classes10.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView cuD;
    private d cuE;
    private RecyclerView cuF;
    private d cuG;
    private List<List<i>> cuH;
    private View cuI;
    private boolean cuJ;
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
        this.cuD = new RecyclerView(context, attributeSet, i);
        this.cuD.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.cuD.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.cuD, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.cuF = new RecyclerView(context, attributeSet, i);
        this.cuF.setVisibility(8);
        this.cuF.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.cuF, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aqv() {
        return this.cuH != null && this.cuH.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        aqw();
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
        this.cuH = list;
        this.cuJ = z;
        if (z && list.size() > 1) {
            hW(i);
        } else {
            hX(i);
        }
    }

    private void hW(int i) {
        this.mDivider.setVisibility(0);
        this.cuF.setVisibility(0);
        if (this.cuE == null) {
            this.cuE = new d(getContext());
            this.cuD.setAdapter(this.cuE);
        }
        this.cuE.b(this.cuH.subList(0, 1), this.cuJ, i);
        if (this.cuG == null) {
            this.cuG = new d(getContext());
            this.cuF.setAdapter(this.cuG);
        }
        this.cuG.b(this.cuH.subList(1, 2), this.cuJ, i);
    }

    private void hX(int i) {
        this.mDivider.setVisibility(8);
        this.cuF.setVisibility(8);
        if (this.cuE == null) {
            this.cuE = new d(getContext());
            this.cuD.setAdapter(this.cuE);
        }
        this.cuE.b(this.cuH, this.cuJ, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cuD != null) {
            this.cuD.scrollToPosition(0);
        }
        if (this.cuF != null) {
            this.cuD.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqx() {
        if (this.cuE != null) {
            this.cuE.notifyDataSetChanged();
        }
        if (this.cuG != null) {
            this.cuG.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.cuI;
    }

    public void setCoverView(View view) {
        this.cuI = view;
    }
}
