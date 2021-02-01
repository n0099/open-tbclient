package com.baidu.swan.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.menu.f;
import java.util.List;
/* loaded from: classes5.dex */
public class MainMenuView extends BaseMenuView {
    private View dBb;
    private RecyclerView erK;
    private MenuContentAdapter erL;
    private RecyclerView erM;
    private MenuContentAdapter erN;
    private List<List<h>> erO;
    private View erP;
    private boolean erQ;
    private LinearLayout mContentView;
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
        this.erK = new RecyclerView(context, attributeSet, i);
        this.erK.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.erK.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.erK, layoutParams);
        this.dBb = new View(context);
        this.dBb.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.dBb, layoutParams2);
        this.erM = new RecyclerView(context, attributeSet, i);
        this.erM.setVisibility(8);
        this.erM.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.erM, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aCs() {
        return this.erO != null && this.erO.size() > 1;
    }

    public void a(List<List<h>> list, View view, boolean z, int i) {
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

    private void a(List<List<h>> list, boolean z, int i) {
        this.erO = list;
        this.erQ = z;
        if (z && list.size() > 1) {
            lA(i);
        } else {
            lB(i);
        }
    }

    private void lA(int i) {
        this.dBb.setVisibility(0);
        this.erM.setVisibility(0);
        if (this.erL == null) {
            this.erL = new MenuContentAdapter(getContext());
            this.erK.setAdapter(this.erL);
        }
        this.erL.b(this.erO.subList(0, 1), this.erQ, i);
        if (this.erN == null) {
            this.erN = new MenuContentAdapter(getContext());
            this.erM.setAdapter(this.erN);
        }
        this.erN.b(this.erO.subList(1, 2), this.erQ, i);
    }

    private void lB(int i) {
        this.dBb.setVisibility(8);
        this.erM.setVisibility(8);
        if (this.erL == null) {
            this.erL = new MenuContentAdapter(getContext());
            this.erK.setAdapter(this.erL);
        }
        this.erL.b(this.erO, this.erQ, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.erK != null) {
            this.erK.scrollToPosition(0);
        }
        if (this.erM != null) {
            this.erK.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbC() {
        if (this.erL != null) {
            this.erL.notifyDataSetChanged();
        }
        if (this.erN != null) {
            this.erN.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.erP;
    }

    public void setCoverView(View view) {
        this.erP = view;
    }
}
