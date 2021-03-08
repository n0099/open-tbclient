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
/* loaded from: classes4.dex */
public class MainMenuView extends BaseMenuView {
    private View dCC;
    private RecyclerView etm;
    private MenuContentAdapter etn;
    private RecyclerView eto;
    private MenuContentAdapter etp;
    private List<List<h>> etq;
    private View etr;
    private boolean ets;
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
        this.etm = new RecyclerView(context, attributeSet, i);
        this.etm.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.etm.setPadding(0, (int) this.mContext.getResources().getDimension(f.b.aiapp_menu_gridview_padding_top), 0, 0);
        this.mContentView.addView(this.etm, layoutParams);
        this.dCC = new View(context);
        this.dCC.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.b.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.mContentView.addView(this.dCC, layoutParams2);
        this.eto = new RecyclerView(context, attributeSet, i);
        this.eto.setVisibility(8);
        this.eto.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mContentView.addView(this.eto, new LinearLayout.LayoutParams(-1, -2));
        a(this.mContentView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean aCv() {
        return this.etq != null && this.etq.size() > 1;
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
        this.etq = list;
        this.ets = z;
        if (z && list.size() > 1) {
            lB(i);
        } else {
            lC(i);
        }
    }

    private void lB(int i) {
        this.dCC.setVisibility(0);
        this.eto.setVisibility(0);
        if (this.etn == null) {
            this.etn = new MenuContentAdapter(getContext());
            this.etm.setAdapter(this.etn);
        }
        this.etn.b(this.etq.subList(0, 1), this.ets, i);
        if (this.etp == null) {
            this.etp = new MenuContentAdapter(getContext());
            this.eto.setAdapter(this.etp);
        }
        this.etp.b(this.etq.subList(1, 2), this.ets, i);
    }

    private void lC(int i) {
        this.dCC.setVisibility(8);
        this.eto.setVisibility(8);
        if (this.etn == null) {
            this.etn = new MenuContentAdapter(getContext());
            this.etm.setAdapter(this.etn);
        }
        this.etn.b(this.etq, this.ets, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.etm != null) {
            this.etm.scrollToPosition(0);
        }
        if (this.eto != null) {
            this.etm.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bbE() {
        if (this.etn != null) {
            this.etn.notifyDataSetChanged();
        }
        if (this.etp != null) {
            this.etp.notifyDataSetChanged();
        }
    }

    @Nullable
    public View getCoverView() {
        return this.etr;
    }

    public void setCoverView(View view) {
        this.etr = view;
    }
}
