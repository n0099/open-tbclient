package com.baidu.live.view.tabhost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaViewPagerTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private FrameLayout aCQ;
    private LinearLayout aCR;
    private CustomViewPager aCS;
    private List<com.baidu.live.view.tabhost.a> aDf;
    private View.OnClickListener aDj;
    private b bRA;
    private final int bRw;
    private final int bRx;
    private AlaViewPagerAdapter bRy;
    private a bRz;
    private float mCurrentPositionOffset;
    private int mCurrentTabIndex;
    private int mDividerColor;
    private final int mDividerHeight;
    private final int mIndicatorHeight;
    private final int mIndicatorWidth;
    private boolean mIsClicked;
    private Paint mRectPaint;
    private int mSelectorColor;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, com.baidu.live.view.tabhost.a aVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaViewPagerTabHost(Context context) {
        super(context);
        this.bRw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds60);
        this.bRx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aDj = new View.OnClickListener() { // from class: com.baidu.live.view.tabhost.AlaViewPagerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaViewPagerTabHost.this.aCR.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaViewPagerTabHost.this.mIsClicked = true;
                    if (AlaViewPagerTabHost.this.aCS != null) {
                        AlaViewPagerTabHost.this.aCS.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        init();
    }

    public AlaViewPagerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds60);
        this.bRx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aDj = new View.OnClickListener() { // from class: com.baidu.live.view.tabhost.AlaViewPagerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaViewPagerTabHost.this.aCR.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaViewPagerTabHost.this.mIsClicked = true;
                    if (AlaViewPagerTabHost.this.aCS != null) {
                        AlaViewPagerTabHost.this.aCS.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        setOrientation(1);
        this.aCQ = new FrameLayout(getContext());
        addView(this.aCQ, new LinearLayout.LayoutParams(-1, -2));
        this.aCR = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aCQ.addView(this.aCR, layoutParams);
        this.aCS = new CustomViewPager(getContext());
        this.aCS.setOnPageChangeListener(this);
        addView(this.aCS);
        this.bRy = new AlaViewPagerAdapter();
        this.aCS.setAdapter(this.bRy);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<com.baidu.live.view.tabhost.a> list) {
        this.aDf = list;
        x(list);
        this.bRy.setData(list);
        this.aCS.setCurrentItem(0);
    }

    public void setCurrentIndex(int i) {
        if (this.aCS != null) {
            this.aCS.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void x(List<com.baidu.live.view.tabhost.a> list) {
        for (com.baidu.live.view.tabhost.a aVar : list) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            textView.setText(aVar.getTitle());
            textView.setPadding(0, this.bRx, 0, this.bRx);
            textView.setGravity(17);
            textView.setOnClickListener(this.aDj);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            a(textView, false, this.mSkinType);
            this.aCR.addView(textView, layoutParams);
        }
    }

    private void a(TextView textView, boolean z, int i) {
        if (textView != null) {
            if (!z) {
                SkinManager.setViewTextColor(textView, a.c.sdk_cp_cont_j, 1, i);
            } else {
                SkinManager.setViewTextColor(textView, a.c.sdk_cp_cont_b, 1, i);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aCR.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aCR.getChildAt(i);
            if (childAt instanceof TextView) {
                a((TextView) childAt, i == this.mCurrentTabIndex, this.mSkinType);
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aCR.getChildCount() != 0) {
            int height = this.aCR.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            View childAt = this.aCR.getChildAt(this.mCurrentTabIndex);
            float paddingLeft = childAt.getPaddingLeft() + this.aCR.getLeft() + childAt.getLeft() + ((((childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight()) - this.mIndicatorWidth) / 2);
            float f = paddingLeft + this.mIndicatorWidth;
            if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aCR.getChildCount() - 1) {
                View childAt2 = this.aCR.getChildAt(this.mCurrentTabIndex + 1);
                float paddingLeft2 = childAt2.getPaddingLeft() + childAt2.getLeft() + this.aCR.getLeft() + ((((childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
            }
            this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_common_color_10273), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_other_b), Shader.TileMode.CLAMP));
            RectF rectF = new RectF(paddingLeft, height - this.mIndicatorHeight, f, height);
            canvas.drawRoundRect(rectF, rectF.height(), rectF.height(), this.mRectPaint);
            this.mRectPaint.setShader(null);
            this.mRectPaint.setColor(this.mDividerColor);
            canvas.drawRect(0.0f, height - this.mDividerHeight, this.aCQ.getWidth(), height, this.mRectPaint);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aCR.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.bRz != null) {
                this.bRz.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aDf, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.bRz != null) {
                this.bRz.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aDf, this.mCurrentTabIndex));
            }
        }
        if (this.bRA != null) {
            this.bRA.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aCR.getChildCount() != 0 && this.aCS != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.bRz = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.bRA = bVar;
    }
}
