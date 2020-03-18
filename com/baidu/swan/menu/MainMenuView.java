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
    private RecyclerView cyO;
    private d cyP;
    private RecyclerView cyQ;
    private d cyR;
    private List<List<i>> cyS;
    private View cyT;
    private boolean cyU;
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
        this.cyO = new RecyclerView(context, attributeSet, i);
        this.cyO.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.cyO.setPadding(0, (int) this.mContext.getResources().getDimension(g.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.cyO, layoutParams);
        this.mDivider = new View(context);
        this.mDivider.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.mDivider, layoutParams2);
        this.cyQ = new RecyclerView(context, attributeSet, i);
        this.cyQ.setVisibility(8);
        this.cyQ.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.cyQ, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean asO() {
        return this.cyS != null && this.cyS.size() > 1;
    }

    public void a(List<List<i>> list, View view, boolean z, int i) {
        asP();
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
        this.cyS = list;
        this.cyU = z;
        if (z && list.size() > 1) {
            in(i);
        } else {
            io(i);
        }
    }

    private void in(int i) {
        this.mDivider.setVisibility(0);
        this.cyQ.setVisibility(0);
        if (this.cyP == null) {
            this.cyP = new d(getContext());
            this.cyO.setAdapter(this.cyP);
        }
        this.cyP.b(this.cyS.subList(0, 1), this.cyU, i);
        if (this.cyR == null) {
            this.cyR = new d(getContext());
            this.cyQ.setAdapter(this.cyR);
        }
        this.cyR.b(this.cyS.subList(1, 2), this.cyU, i);
    }

    private void io(int i) {
        this.mDivider.setVisibility(8);
        this.cyQ.setVisibility(8);
        if (this.cyP == null) {
            this.cyP = new d(getContext());
            this.cyO.setAdapter(this.cyP);
        }
        this.cyP.b(this.cyS, this.cyU, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cyO != null) {
            this.cyO.scrollToPosition(0);
        }
        if (this.cyQ != null) {
            this.cyO.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asQ() {
        if (this.cyP != null) {
            this.cyP.notifyDataSetChanged();
        }
        if (this.cyR != null) {
            this.cyR.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.cyT;
    }

    public void setCoverView(View view) {
        this.cyT = view;
    }
}
