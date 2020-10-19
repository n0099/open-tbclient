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
/* loaded from: classes14.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView dRF;
    private d dRG;
    private RecyclerView dRH;
    private d dRI;
    private List<List<i>> dRJ;
    private View dRK;
    private boolean dRL;
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
        this.dRF = new RecyclerView(context, attributeSet, i);
        this.dRF.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dRF.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.dRF, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.dRH = new RecyclerView(context, attributeSet, i);
        this.dRH.setVisibility(8);
        this.dRH.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.dRH, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean axA() {
        return this.dRJ != null && this.dRJ.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        setMode();
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
        this.dRJ = list;
        this.dRL = z;
        if (z && list.size() > 1) {
            mg(i);
        } else {
            mh(i);
        }
    }

    private void mg(int i) {
        this.mDivider.setVisibility(0);
        this.dRH.setVisibility(0);
        if (this.dRG == null) {
            this.dRG = new d(getContext());
            this.dRF.setAdapter(this.dRG);
        }
        this.dRG.b(this.dRJ.subList(0, 1), this.dRL, i);
        if (this.dRI == null) {
            this.dRI = new d(getContext());
            this.dRH.setAdapter(this.dRI);
        }
        this.dRI.b(this.dRJ.subList(1, 2), this.dRL, i);
    }

    private void mh(int i) {
        this.mDivider.setVisibility(8);
        this.dRH.setVisibility(8);
        if (this.dRG == null) {
            this.dRG = new d(getContext());
            this.dRF.setAdapter(this.dRG);
        }
        this.dRG.b(this.dRJ, this.dRL, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dRF != null) {
            this.dRF.scrollToPosition(0);
        }
        if (this.dRH != null) {
            this.dRF.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVY() {
        if (this.dRG != null) {
            this.dRG.notifyDataSetChanged();
        }
        if (this.dRI != null) {
            this.dRI.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.dRK;
    }

    public void setCoverView(View view) {
        this.dRK = view;
    }
}
