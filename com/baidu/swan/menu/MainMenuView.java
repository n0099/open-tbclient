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
    private RecyclerView dnE;
    private d dnF;
    private RecyclerView dnG;
    private d dnH;
    private List<List<i>> dnI;
    private View dnJ;
    private boolean dnK;
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
        this.dnE = new RecyclerView(context, attributeSet, i);
        this.dnE.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dnE.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.dnE, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.dnG = new RecyclerView(context, attributeSet, i);
        this.dnG.setVisibility(8);
        this.dnG.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.dnG, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aFW() {
        return this.dnI != null && this.dnI.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        aFX();
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
        this.dnI = list;
        this.dnK = z;
        if (z && list.size() > 1) {
            iY(i);
        } else {
            iZ(i);
        }
    }

    private void iY(int i) {
        this.mDivider.setVisibility(0);
        this.dnG.setVisibility(0);
        if (this.dnF == null) {
            this.dnF = new d(getContext());
            this.dnE.setAdapter(this.dnF);
        }
        this.dnF.b(this.dnI.subList(0, 1), this.dnK, i);
        if (this.dnH == null) {
            this.dnH = new d(getContext());
            this.dnG.setAdapter(this.dnH);
        }
        this.dnH.b(this.dnI.subList(1, 2), this.dnK, i);
    }

    private void iZ(int i) {
        this.mDivider.setVisibility(8);
        this.dnG.setVisibility(8);
        if (this.dnF == null) {
            this.dnF = new d(getContext());
            this.dnE.setAdapter(this.dnF);
        }
        this.dnF.b(this.dnI, this.dnK, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dnE != null) {
            this.dnE.scrollToPosition(0);
        }
        if (this.dnG != null) {
            this.dnE.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aFY() {
        if (this.dnF != null) {
            this.dnF.notifyDataSetChanged();
        }
        if (this.dnH != null) {
            this.dnH.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.dnJ;
    }

    public void setCoverView(View view) {
        this.dnJ = view;
    }
}
