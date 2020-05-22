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
/* loaded from: classes11.dex */
public class MainMenuView extends BaseMenuView {
    private RecyclerView diU;
    private d diV;
    private RecyclerView diW;
    private d diX;
    private List<List<i>> diY;
    private View diZ;
    private boolean dja;
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
        this.diU = new RecyclerView(context, attributeSet, i);
        this.diU.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.diU.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.diU, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.diW = new RecyclerView(context, attributeSet, i);
        this.diW.setVisibility(8);
        this.diW.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.diW, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aEQ() {
        return this.diY != null && this.diY.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        aER();
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
        this.diY = list;
        this.dja = z;
        if (z && list.size() > 1) {
            iL(i);
        } else {
            iM(i);
        }
    }

    private void iL(int i) {
        this.mDivider.setVisibility(0);
        this.diW.setVisibility(0);
        if (this.diV == null) {
            this.diV = new d(getContext());
            this.diU.setAdapter(this.diV);
        }
        this.diV.b(this.diY.subList(0, 1), this.dja, i);
        if (this.diX == null) {
            this.diX = new d(getContext());
            this.diW.setAdapter(this.diX);
        }
        this.diX.b(this.diY.subList(1, 2), this.dja, i);
    }

    private void iM(int i) {
        this.mDivider.setVisibility(8);
        this.diW.setVisibility(8);
        if (this.diV == null) {
            this.diV = new d(getContext());
            this.diU.setAdapter(this.diV);
        }
        this.diV.b(this.diY, this.dja, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.diU != null) {
            this.diU.scrollToPosition(0);
        }
        if (this.diW != null) {
            this.diU.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aES() {
        if (this.diV != null) {
            this.diV.notifyDataSetChanged();
        }
        if (this.diX != null) {
            this.diX.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.diZ;
    }

    public void setCoverView(View view) {
        this.diZ = view;
    }
}
