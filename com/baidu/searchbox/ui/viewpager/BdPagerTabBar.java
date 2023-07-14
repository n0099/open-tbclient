package com.baidu.searchbox.ui.viewpager;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.searchbox.ui.viewpager.AdapterLinearLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class BdPagerTabBar extends HorizontalScrollView {
    public static final int NEW_COUNT_TEXT_SIZE = 9;
    public static final int[] SHADOWS_COLORS = {-1717986919, 11184810, 11184810};
    public static final int SHADOWS_WIDTH = 45;
    public Adapter mAdapter;
    public AdapterLinearLayout mAdapterLayout;
    public ColorStateList mColorStateList;
    public boolean mLayoutInActionBar;
    public Drawable mLeftShadow;
    public int mMinTabWidth;
    public boolean mNeedBold;
    public OnTabSelectedListener mOnTabSelectedListener;
    public Drawable mRightShadow;
    public boolean mShadowsEnable;
    public int mTabBackgroundId;
    public int mTabSelTextColor;
    public int mTabTextColor;
    public int mTabTextSize;
    public boolean mUseStandardStyle;

    /* loaded from: classes4.dex */
    public interface OnTabSelectedListener {
        void onTabSelected(BdPagerTabBar bdPagerTabBar, int i);
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends AdapterLinearLayout.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    /* loaded from: classes4.dex */
    public static class NewTipsTabAdapter extends TabAdapter {
        public NewTipsTabAdapter(Context context) {
            super(context, true, true);
        }

        public NewTipsTabAdapter(Context context, boolean z, boolean z2) {
            super(context, z, z2);
        }

        @Override // com.baidu.searchbox.ui.viewpager.BdPagerTabBar.TabAdapter
        public void onConfigConvertView(Context context, int i, View view2) {
            BdPagerTab bdPagerTab = this.mTabs.get(i);
            PagerNewTipsTabBarItem pagerNewTipsTabBarItem = (PagerNewTipsTabBarItem) view2;
            if (!this.mUseStandardStyle) {
                pagerNewTipsTabBarItem.setTextViewMinAndMaxWidth(this.mMinTabWidth, this.mMaxTabWidth);
            }
            pagerNewTipsTabBarItem.setBdPagerTab(bdPagerTab);
        }

        @Override // com.baidu.searchbox.ui.viewpager.BdPagerTabBar.TabAdapter
        public View onCreateView(Context context, ViewGroup viewGroup) {
            return new PagerNewTipsTabBarItem(context, this.mUseStandardStyle, this.mLayoutInActionBar);
        }
    }

    /* loaded from: classes4.dex */
    public static class PagerNewTipsTabBarItem extends RelativeLayout {
        public BadgeView mBadgeView;
        public boolean mLayoutInActionBar;
        public PagerTabBarItem mPagerTabBarItem;
        public boolean mUseStandardStyle;

        public PagerNewTipsTabBarItem(Context context) {
            super(context);
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            init(context);
        }

        private void init(Context context) {
            PagerTabBarItem pagerTabBarItem = new PagerTabBarItem(context);
            this.mPagerTabBarItem = pagerTabBarItem;
            pagerTabBarItem.setUIStandard(this.mUseStandardStyle, this.mLayoutInActionBar);
            this.mPagerTabBarItem.setId(R.id.obfuscated_res_0x7f09179c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView(this.mPagerTabBarItem, layoutParams);
            this.mBadgeView = new BadgeView(context);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            this.mPagerTabBarItem.setSelected(z);
        }

        public PagerNewTipsTabBarItem(Context context, int i, int i2) {
            super(context);
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            init(context);
            this.mPagerTabBarItem.setMinWidth(i);
            this.mPagerTabBarItem.setMaxWidth(i2);
        }

        public PagerNewTipsTabBarItem(Context context, int i, int i2, boolean z, boolean z2) {
            super(context);
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
            init(context);
            this.mPagerTabBarItem.setMinWidth(i);
            this.mPagerTabBarItem.setMaxWidth(i2);
        }

        public PagerNewTipsTabBarItem(Context context, boolean z, boolean z2) {
            super(context);
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
            init(context);
        }

        public PagerTabBarItem getPagerTabBarItem() {
            return this.mPagerTabBarItem;
        }

        public void setBdPagerTab(BdPagerTab bdPagerTab) {
            this.mPagerTabBarItem.setBdPagerTab(bdPagerTab);
            if (!TextUtils.isEmpty(bdPagerTab.getNewCount())) {
                this.mBadgeView.setType(BadgeView.Type.SMALL_TEXT);
                this.mBadgeView.setBadgeText(bdPagerTab.getNewCount());
                this.mBadgeView.bindViewInRelativeLayout(this.mPagerTabBarItem, this, BadgeView.DefaultPosition.TXT_SMALL_TXT);
            } else if (bdPagerTab.isNew()) {
                this.mBadgeView.setType(BadgeView.Type.DOT);
                this.mBadgeView.bindViewInRelativeLayout(this.mPagerTabBarItem, this, BadgeView.DefaultPosition.TXT_DOT);
            } else {
                removeView(this.mBadgeView);
            }
        }

        public void setTextViewMinAndMaxWidth(int i, int i2) {
            this.mPagerTabBarItem.setMinWidth(i);
            this.mPagerTabBarItem.setMaxWidth(i2);
        }

        public void setUIStandard(boolean z, boolean z2) {
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
        }
    }

    /* loaded from: classes4.dex */
    public static class PagerTabBarItem extends TextView {
        public boolean mLayoutInActionBar;
        public boolean mNeedBold;
        public int mSelTextColor;
        public int mTextColor;
        public boolean mUseStandardStyle;

        public PagerTabBarItem(Context context) {
            super(context);
            this.mTextColor = -1;
            this.mSelTextColor = -1;
            this.mUseStandardStyle = true;
            this.mLayoutInActionBar = true;
            init(context);
        }

        private void init(Context context) {
            setGravity(17);
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.END);
        }

        public void setBoldWhenSelect(boolean z) {
            this.mNeedBold = z;
        }

        @Override // android.widget.TextView, android.view.View
        public void setSelected(boolean z) {
            int i;
            super.setSelected(z);
            int i2 = this.mSelTextColor;
            if (-1 != i2 && -1 != (i = this.mTextColor)) {
                if (!z) {
                    i2 = i;
                }
                setTextColor(i2);
            }
            if (this.mNeedBold) {
                if (z) {
                    setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    setTypeface(Typeface.defaultFromStyle(0));
                }
            }
            invalidate();
        }

        public PagerTabBarItem(Context context, int i, int i2) {
            super(context);
            this.mTextColor = -1;
            this.mSelTextColor = -1;
            this.mUseStandardStyle = true;
            this.mLayoutInActionBar = true;
            init(context);
            setMinWidth(i);
            setMaxWidth(i2);
        }

        private void setTextColor(int i, int i2) {
            this.mTextColor = i;
            this.mSelTextColor = i2;
        }

        public void setUIStandard(boolean z, boolean z2) {
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
        }

        public void setBdPagerTab(BdPagerTab bdPagerTab) {
            setText(bdPagerTab.getTitle());
            if (this.mUseStandardStyle) {
                Resources resources = getResources();
                if (this.mLayoutInActionBar) {
                    setTextSize(0, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701bb));
                } else {
                    setTextSize(0, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701bc));
                }
                setBoldWhenSelect(true);
                setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0603a9), resources.getColor(R.color.obfuscated_res_0x7f0603a8));
                return;
            }
            setTextSize(0, bdPagerTab.getTextSize());
            setBoldWhenSelect(bdPagerTab.isBoldWhenSelect());
            ColorStateList colorStateList = bdPagerTab.getColorStateList();
            if (colorStateList != null) {
                setTextColor(colorStateList);
                setTextColor(-1, -1);
                return;
            }
            setTextColor(bdPagerTab.getTextColor(), bdPagerTab.getSelTextColor());
        }
    }

    /* loaded from: classes4.dex */
    public static class TabAdapter extends BaseAdapter {
        public Context mContext;
        public boolean mLayoutInActionBar;
        public int mMaxTabWidth;
        public int mMinTabWidth;
        public int mTabWidth;
        public ArrayList<BdPagerTab> mTabs;
        public boolean mUseStandardStyle;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public TabAdapter(Context context) {
            this(context, true, false);
        }

        public void addTab(BdPagerTab bdPagerTab) {
            this.mTabs.add(bdPagerTab);
        }

        public void addTabs(List<BdPagerTab> list) {
            if (list != null) {
                this.mTabs.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.mTabs.get(i);
        }

        public TabAdapter(Context context, boolean z, boolean z2) {
            this.mTabs = new ArrayList<>();
            this.mContext = context;
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
        }

        public void onConfigConvertView(Context context, int i, View view2) {
            PagerTabBarItem pagerTabBarItem = (PagerTabBarItem) view2;
            pagerTabBarItem.setMinWidth(this.mMinTabWidth);
            pagerTabBarItem.setMaxWidth(this.mMaxTabWidth);
            pagerTabBarItem.setUIStandard(this.mUseStandardStyle, this.mLayoutInActionBar);
            pagerTabBarItem.setBdPagerTab(this.mTabs.get(i));
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mTabs.size();
        }

        public void removeAllTabs() {
            this.mTabs.clear();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            BdPagerTab bdPagerTab = this.mTabs.get(i);
            if (view2 == null) {
                LayoutParams layoutParams = new LayoutParams(this.mTabWidth, -1);
                if (this.mTabWidth == 0) {
                    ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
                }
                View onCreateView = onCreateView(this.mContext, viewGroup);
                onCreateView.setLayoutParams(layoutParams);
                int tabBackgroundResId = bdPagerTab.getTabBackgroundResId();
                if (tabBackgroundResId != 0) {
                    onCreateView.setBackgroundResource(tabBackgroundResId);
                }
                view2 = onCreateView;
            } else {
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 != null) {
                    int i2 = this.mTabWidth;
                    layoutParams2.width = i2;
                    if (i2 == 0 && (layoutParams2 instanceof LayoutParams)) {
                        ((LinearLayout.LayoutParams) ((LayoutParams) layoutParams2)).weight = 1.0f;
                    }
                }
                int tabBackgroundResId2 = bdPagerTab.getTabBackgroundResId();
                if (tabBackgroundResId2 != 0) {
                    view2.setBackgroundResource(tabBackgroundResId2);
                }
            }
            onConfigConvertView(this.mContext, i, view2);
            return view2;
        }

        public View onCreateView(Context context, ViewGroup viewGroup) {
            return new PagerTabBarItem(context, this.mMinTabWidth, this.mMaxTabWidth);
        }

        public void setUIStandard(boolean z, boolean z2) {
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
        }

        public void setWidthParams(int i, int i2) {
            this.mMinTabWidth = i;
            if (i2 == 0) {
                this.mTabWidth = 0;
                return;
            }
            int count = getCount();
            if (count != 0) {
                int i3 = i2 / count;
                if (i3 < i) {
                    this.mTabWidth = i;
                    this.mMaxTabWidth = i;
                    return;
                }
                this.mTabWidth = 0;
                this.mMaxTabWidth = i3;
            }
        }
    }

    public Adapter getAdapter() {
        return this.mAdapterLayout.getAdapter();
    }

    public int getSelectedIndex() {
        return this.mAdapterLayout.getSelectedPosition();
    }

    public int getTabCount() {
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            return adapter.getCount();
        }
        return 0;
    }

    public void removeAllTabs() {
        Adapter adapter = getAdapter();
        if (adapter instanceof TabAdapter) {
            ((TabAdapter) adapter).removeAllTabs();
        }
    }

    public void updateTabs() {
        updateTabs(false);
    }

    public BdPagerTabBar(Context context) {
        this(context, null);
    }

    public void addTab(BdPagerTab bdPagerTab) {
        if (bdPagerTab != null) {
            bdPagerTab.setTextSize((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070756));
            Adapter adapter = getAdapter();
            if (adapter instanceof TabAdapter) {
                ((TabAdapter) adapter).addTab(bdPagerTab);
            }
        }
    }

    public void addTabs(List<BdPagerTab> list) {
        if (list != null) {
            Adapter adapter = getAdapter();
            if (adapter instanceof TabAdapter) {
                ((TabAdapter) adapter).addTabs(list);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mShadowsEnable) {
            drawShadows(canvas);
        }
    }

    public BdPagerTab getTabAt(int i) {
        Adapter adapter;
        int tabCount = getTabCount();
        if (i >= 0 && i < tabCount && (adapter = this.mAdapter) != null) {
            return (BdPagerTab) adapter.getItem(i);
        }
        return null;
    }

    public void selectTab(int i) {
        AdapterLinearLayout adapterLinearLayout = this.mAdapterLayout;
        if (adapterLinearLayout != null) {
            adapterLinearLayout.selectChild(i);
        }
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
        this.mAdapterLayout.setAdapter(adapter);
    }

    public void setBoldWhenSelect(boolean z) {
        this.mNeedBold = z;
    }

    public void setDividerDrawable(Drawable drawable) {
        AdapterLinearLayout adapterLinearLayout = this.mAdapterLayout;
        if (adapterLinearLayout != null) {
            adapterLinearLayout.setDividerDrawable(drawable);
        }
    }

    public void setDividerWidth(int i) {
        AdapterLinearLayout adapterLinearLayout = this.mAdapterLayout;
        if (adapterLinearLayout != null) {
            adapterLinearLayout.setDividerSize(i);
        }
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListener = onTabSelectedListener;
        this.mAdapterLayout.setOnItemClickListener(new AdapterLinearLayout.OnItemClickListener() { // from class: com.baidu.searchbox.ui.viewpager.BdPagerTabBar.1
            @Override // com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.OnItemClickListener
            public void onItemClick(AdapterLinearLayout adapterLinearLayout, View view2, int i) {
                if (BdPagerTabBar.this.mOnTabSelectedListener != null && BdPagerTabBar.this.mAdapterLayout.getSelectedPosition() != i) {
                    BdPagerTabBar.this.mOnTabSelectedListener.onTabSelected(BdPagerTabBar.this, i);
                }
            }
        });
    }

    public void setShadowsEnabled(boolean z) {
        this.mShadowsEnable = z;
    }

    public void setTabBackground(int i) {
        this.mTabBackgroundId = i;
    }

    public void setTabMinWidth(int i) {
        this.mMinTabWidth = i;
    }

    public void setTabSpace(int i) {
        AdapterLinearLayout adapterLinearLayout = this.mAdapterLayout;
        if (adapterLinearLayout != null) {
            adapterLinearLayout.setSpace(i);
        }
    }

    public void setTabTextColor(ColorStateList colorStateList) {
        this.mColorStateList = colorStateList;
    }

    public void setTabTextSize(int i) {
        this.mTabTextSize = i;
    }

    public void updateTabs(boolean z) {
        if (z) {
            post(new Runnable() { // from class: com.baidu.searchbox.ui.viewpager.BdPagerTabBar.2
                @Override // java.lang.Runnable
                public void run() {
                    BdPagerTabBar.this.performUpdateTabs();
                }
            });
        } else {
            performUpdateTabs();
        }
    }

    public BdPagerTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTabTextColor(int i, int i2) {
        this.mTabTextColor = i;
        this.mTabSelTextColor = i2;
    }

    public void setUIStandard(boolean z, boolean z2) {
        this.mUseStandardStyle = z;
        this.mLayoutInActionBar = z2;
        Adapter adapter = this.mAdapter;
        if (adapter instanceof TabAdapter) {
            ((TabAdapter) adapter).setUIStandard(z, z2);
        }
    }

    public BdPagerTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShadowsEnable = false;
        this.mAdapterLayout = null;
        this.mLeftShadow = null;
        this.mRightShadow = null;
        this.mOnTabSelectedListener = null;
        this.mAdapter = null;
        this.mTabTextColor = -1;
        this.mTabSelTextColor = -1;
        this.mColorStateList = null;
        this.mTabTextSize = -1;
        this.mTabBackgroundId = 0;
        this.mMinTabWidth = 50;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        this.mMinTabWidth = DeviceUtil.ScreenInfo.dp2px(context, 50);
        init(context, attributeSet);
    }

    public BdPagerTabBar(Context context, boolean z, boolean z2) {
        super(context);
        this.mShadowsEnable = false;
        this.mAdapterLayout = null;
        this.mLeftShadow = null;
        this.mRightShadow = null;
        this.mOnTabSelectedListener = null;
        this.mAdapter = null;
        this.mTabTextColor = -1;
        this.mTabSelTextColor = -1;
        this.mColorStateList = null;
        this.mTabTextSize = -1;
        this.mTabBackgroundId = 0;
        this.mMinTabWidth = 50;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        this.mUseStandardStyle = z;
        this.mLayoutInActionBar = z2;
        init(context, null);
    }

    private void drawShadows(Canvas canvas) {
        boolean z;
        if (getChildCount() == 0) {
            return;
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int measuredWidth = this.mAdapterLayout.getMeasuredWidth();
        boolean z2 = true;
        if (scrollX > 0) {
            z = true;
        } else {
            z = false;
        }
        z2 = (measuredWidth <= width || width + scrollX >= measuredWidth) ? false : false;
        if (!z && !z2) {
            return;
        }
        canvas.save();
        canvas.translate(scrollX, 0.0f);
        if (z) {
            this.mLeftShadow.draw(canvas);
        }
        if (z2) {
            this.mRightShadow.draw(canvas);
        }
        canvas.restore();
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.R.styleable.tab);
            this.mUseStandardStyle = obtainStyledAttributes.getBoolean(1, true);
            this.mLayoutInActionBar = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(context);
        this.mAdapterLayout = adapterLinearLayout;
        adapterLinearLayout.setGravity(17);
        this.mAdapterLayout.setOrientation(0);
        setAdapter(new TabAdapter(getContext(), this.mUseStandardStyle, this.mLayoutInActionBar));
        addView(this.mAdapterLayout, new FrameLayout.LayoutParams(-1, -1));
        this.mLeftShadow = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, SHADOWS_COLORS);
        this.mRightShadow = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, SHADOWS_COLORS);
        setFillViewport(true);
        setTabTextSize((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070756));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performUpdateTabs() {
        Adapter adapter = getAdapter();
        if (adapter instanceof TabAdapter) {
            TabAdapter tabAdapter = (TabAdapter) adapter;
            ArrayList<BdPagerTab> arrayList = tabAdapter.mTabs;
            if (arrayList != null) {
                Iterator<BdPagerTab> it = arrayList.iterator();
                while (it.hasNext()) {
                    BdPagerTab next = it.next();
                    next.setColorStateList(this.mColorStateList);
                    next.setTextColor(this.mTabTextColor);
                    next.setSelTextColor(this.mTabSelTextColor);
                    next.setTextSize(this.mTabTextSize);
                    next.setBoldWhenSelect(this.mNeedBold);
                    next.setTabBackgroundResId(this.mTabBackgroundId);
                }
            }
            tabAdapter.setWidthParams(this.mMinTabWidth, getWidth());
            tabAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = (int) (getResources().getDisplayMetrics().density * 45.0f);
        this.mLeftShadow.setBounds(0, 0, i5, i2);
        this.mRightShadow.setBounds(i - i5, 0, i, i2);
    }

    public void setAdapterLayoutPadding(int i, int i2, int i3, int i4) {
        this.mAdapterLayout.setPadding(i, i2, i3, i4);
    }
}
