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
    private RecyclerView cXL;
    private d cXM;
    private RecyclerView cXN;
    private d cXO;
    private List<List<i>> cXP;
    private View cXQ;
    private boolean cXR;
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
        this.cXL = new RecyclerView(context, attributeSet, i);
        this.cXL.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.cXL.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.cXL, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.cXN = new RecyclerView(context, attributeSet, i);
        this.cXN.setVisibility(8);
        this.cXN.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.cXN, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aAY() {
        return this.cXP != null && this.cXP.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        aAZ();
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
        this.cXP = list;
        this.cXR = z;
        if (z && list.size() > 1) {
            iu(i);
        } else {
            iv(i);
        }
    }

    private void iu(int i) {
        this.mDivider.setVisibility(0);
        this.cXN.setVisibility(0);
        if (this.cXM == null) {
            this.cXM = new d(getContext());
            this.cXL.setAdapter(this.cXM);
        }
        this.cXM.b(this.cXP.subList(0, 1), this.cXR, i);
        if (this.cXO == null) {
            this.cXO = new d(getContext());
            this.cXN.setAdapter(this.cXO);
        }
        this.cXO.b(this.cXP.subList(1, 2), this.cXR, i);
    }

    private void iv(int i) {
        this.mDivider.setVisibility(8);
        this.cXN.setVisibility(8);
        if (this.cXM == null) {
            this.cXM = new d(getContext());
            this.cXL.setAdapter(this.cXM);
        }
        this.cXM.b(this.cXP, this.cXR, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cXL != null) {
            this.cXL.scrollToPosition(0);
        }
        if (this.cXN != null) {
            this.cXL.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aBa() {
        if (this.cXM != null) {
            this.cXM.notifyDataSetChanged();
        }
        if (this.cXO != null) {
            this.cXO.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.cXQ;
    }

    public void setCoverView(View view) {
        this.cXQ = view;
    }
}
