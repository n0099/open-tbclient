package com.baidu.browser.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.browser.core.util.BdUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BdWindowTabCtrl extends FrameLayout implements View.OnClickListener {
    private int UI_PADDING;
    private int UI_SEARCH_TAB_WIDTH;
    private int UI_TAB_ADD_WIDTH;
    private int UI_TAB_WIDTH;
    private ImageView mAdd;
    private BdWindowTabButton mCurTabButton;
    private BdTabCtrlListener mListener;
    private int mMaxTabCount;
    private List mTabList;
    private float scale;

    /* loaded from: classes.dex */
    public interface BdTabCtrlListener {
        void onCloseTab(BdWindow bdWindow);

        void onCreateTabMax();

        BdWindow onCreateWindow();

        void onTabSelected(BdWindowTabButton bdWindowTabButton);
    }

    public BdWindowTabCtrl(Context context) {
        this(context, null);
    }

    public BdWindowTabCtrl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scale = 1.85f;
        this.UI_TAB_WIDTH = 0;
        this.UI_SEARCH_TAB_WIDTH = 0;
        this.UI_TAB_ADD_WIDTH = 40;
        this.UI_PADDING = 2;
        this.mMaxTabCount = 4;
        this.mTabList = new ArrayList();
        this.UI_PADDING = BdUtil.dip2pix(context, this.UI_PADDING);
        this.UI_TAB_ADD_WIDTH = BdUtil.dip2pix(context, this.UI_TAB_ADD_WIDTH);
        this.mAdd = new ImageView(getContext());
        this.mAdd.setOnClickListener(this);
        this.mAdd.setImageResource(getContext().getResources().getIdentifier("browser_tabwindow_tab_add_selector", "drawable", getContext().getPackageName()));
        addView(this.mAdd);
    }

    public void createSearchTab(BdWindow bdWindow) {
        BdWindowTabButton bdWindowTabButton = new BdWindowTabButton(getContext(), true, this);
        bdWindowTabButton.setWindow(bdWindow);
        bdWindowTabButton.setSearchMode(true);
        bdWindowTabButton.setOnClickListener(this);
        this.mTabList.add(bdWindowTabButton);
        addView(bdWindowTabButton, 0);
        selectToFocus(bdWindowTabButton);
        checkTabNum();
    }

    public void createNewTab(BdWindow bdWindow) {
        createNewTab(bdWindow, this.mTabList.size() - 1);
    }

    public void createNewTab(BdWindow bdWindow, int i) {
        BdWindowTabButton bdWindowTabButton = new BdWindowTabButton(getContext(), false, this);
        bdWindowTabButton.setOnClickListener(this);
        bdWindowTabButton.setWindow(bdWindow);
        this.mTabList.add(i, bdWindowTabButton);
        addView(bdWindowTabButton, i);
        selectToFocus(bdWindowTabButton);
        checkTabNum();
    }

    public void createTab() {
        createTab(-1);
    }

    public void createTab(int i) {
        if (this.mMaxTabCount > this.mTabList.size()) {
            BdWindowTabButton bdWindowTabButton = new BdWindowTabButton(getContext(), false, this);
            bdWindowTabButton.setOnClickListener(this);
            if (i >= 0) {
                this.mTabList.add(i, bdWindowTabButton);
                addView(bdWindowTabButton, i);
            } else {
                this.mTabList.add(bdWindowTabButton);
                addView(bdWindowTabButton, this.mTabList.size() - 1);
            }
            selectToFocus(bdWindowTabButton);
            if (this.mListener != null) {
                bdWindowTabButton.setWindow(this.mListener.onCreateWindow());
            }
        }
        checkTabNum();
    }

    public void removeTab(BdWindowTabButton bdWindowTabButton) {
        if (bdWindowTabButton != null) {
            this.mTabList.remove(bdWindowTabButton);
            removeView(bdWindowTabButton);
            if (this.mListener != null) {
                this.mListener.onCloseTab(bdWindowTabButton.getWindow());
            }
            checkTabNum();
        }
    }

    public void checkTabNum() {
        if (this.mTabList.size() >= this.mMaxTabCount) {
            this.mAdd.setVisibility(4);
        } else {
            this.mAdd.setVisibility(0);
        }
    }

    public void selectToFocus(BdWindowTabButton bdWindowTabButton) {
        if (!bdWindowTabButton.equals(this.mCurTabButton)) {
            setVisibility(0);
        }
        selectToFocus(this.mTabList.indexOf(bdWindowTabButton));
    }

    public void selectWindowToFocus(BdWindowTabButton bdWindowTabButton) {
        selectToFocus(bdWindowTabButton);
        if (this.mListener != null) {
            this.mListener.onTabSelected(bdWindowTabButton);
        }
    }

    public void selectToFocus(int i) {
        if (i >= 0 && i < this.mTabList.size()) {
            lostAllFocus();
            this.mCurTabButton = (BdWindowTabButton) this.mTabList.get(i);
            this.mCurTabButton.setSelected(true);
        }
    }

    public void lostAllFocus() {
        for (BdWindowTabButton bdWindowTabButton : this.mTabList) {
            bdWindowTabButton.setSelected(false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        super.onMeasure(i, i2);
        float measuredWidth = (getMeasuredWidth() - (this.UI_PADDING * (this.mMaxTabCount + 1))) / (1.0f + (3.0f * this.scale));
        this.UI_SEARCH_TAB_WIDTH = Math.round(measuredWidth);
        this.UI_TAB_WIDTH = Math.round(measuredWidth * this.scale);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof BdWindowTabButton) {
                if (((BdWindowTabButton) childAt).isSearchMode()) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.UI_SEARCH_TAB_WIDTH, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.UI_TAB_WIDTH, 1073741824);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.UI_TAB_ADD_WIDTH, 1073741824);
            }
            childAt.measure(makeMeasureSpec, i2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.UI_PADDING;
        int childCount = getChildCount();
        int i6 = i5;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                if (childAt instanceof BdWindowTabButton) {
                    childAt.layout(i6, this.UI_PADDING, i6 + measuredWidth, getHeight());
                    i6 += this.UI_PADDING + measuredWidth;
                } else {
                    childAt.layout(i6, this.UI_PADDING, i6 + measuredWidth, getHeight());
                    i6 += this.UI_PADDING + measuredWidth;
                }
            }
        }
    }

    public BdTabCtrlListener getListener() {
        return this.mListener;
    }

    public void setListener(BdTabCtrlListener bdTabCtrlListener) {
        this.mListener = bdTabCtrlListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.mAdd)) {
            createTab();
        }
    }
}
