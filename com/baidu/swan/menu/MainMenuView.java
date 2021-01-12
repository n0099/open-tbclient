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
    private View dyW;
    private RecyclerView epD;
    private MenuContentAdapter epE;
    private RecyclerView epF;
    private MenuContentAdapter epG;
    private List<List<h>> epH;
    private View epI;
    private boolean epJ;
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
        this.epD = new RecyclerView(context, attributeSet, i);
        this.epD.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.epD.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.epD, layoutParams);
        this.dyW = new View(context);
        this.dyW.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.dyW, layoutParams2);
        this.epF = new RecyclerView(context, attributeSet, i);
        this.epF.setVisibility(8);
        this.epF.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.epF, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aBV() {
        return this.epH != null && this.epH.size() > 1;
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
        this.epH = list;
        this.epJ = z;
        if (z && list.size() > 1) {
            lx(i);
        } else {
            ly(i);
        }
    }

    private void lx(int i) {
        this.dyW.setVisibility(0);
        this.epF.setVisibility(0);
        if (this.epE == null) {
            this.epE = new MenuContentAdapter(getContext());
            this.epD.setAdapter(this.epE);
        }
        this.epE.b(this.epH.subList(0, 1), this.epJ, i);
        if (this.epG == null) {
            this.epG = new MenuContentAdapter(getContext());
            this.epF.setAdapter(this.epG);
        }
        this.epG.b(this.epH.subList(1, 2), this.epJ, i);
    }

    private void ly(int i) {
        this.dyW.setVisibility(8);
        this.epF.setVisibility(8);
        if (this.epE == null) {
            this.epE = new MenuContentAdapter(getContext());
            this.epD.setAdapter(this.epE);
        }
        this.epE.b(this.epH, this.epJ, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.epD != null) {
            this.epD.scrollToPosition(0);
        }
        if (this.epF != null) {
            this.epD.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbp() {
        if (this.epE != null) {
            this.epE.notifyDataSetChanged();
        }
        if (this.epG != null) {
            this.epG.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.epI;
    }

    public void setCoverView(View view) {
        this.epI = view;
    }
}
