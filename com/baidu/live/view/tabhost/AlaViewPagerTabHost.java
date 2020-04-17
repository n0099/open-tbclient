package com.baidu.live.view.tabhost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaViewPagerTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private List<com.baidu.live.view.tabhost.a> aoK;
    private View.OnClickListener aoO;
    private FrameLayout aow;
    private LinearLayout aox;
    private CustomViewPager aoy;
    private final int bbR;
    private final int bbS;
    private AlaViewPagerAdapter bbT;
    private a bbU;
    private b bbV;
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

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, com.baidu.live.view.tabhost.a aVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaViewPagerTabHost(Context context) {
        super(context);
        this.bbR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds60);
        this.bbS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aoO = new View.OnClickListener() { // from class: com.baidu.live.view.tabhost.AlaViewPagerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaViewPagerTabHost.this.aox.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaViewPagerTabHost.this.mIsClicked = true;
                    if (AlaViewPagerTabHost.this.aoy != null) {
                        AlaViewPagerTabHost.this.aoy.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        init();
    }

    public AlaViewPagerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds60);
        this.bbS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aoO = new View.OnClickListener() { // from class: com.baidu.live.view.tabhost.AlaViewPagerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaViewPagerTabHost.this.aox.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaViewPagerTabHost.this.mIsClicked = true;
                    if (AlaViewPagerTabHost.this.aoy != null) {
                        AlaViewPagerTabHost.this.aoy.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        setOrientation(1);
        this.aow = new FrameLayout(getContext());
        addView(this.aow, new LinearLayout.LayoutParams(-1, -2));
        this.aox = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.aow.addView(this.aox, layoutParams);
        this.aoy = new CustomViewPager(getContext());
        this.aoy.setOnPageChangeListener(this);
        addView(this.aoy);
        this.bbT = new AlaViewPagerAdapter();
        this.aoy.setAdapter(this.bbT);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<com.baidu.live.view.tabhost.a> list) {
        this.aoK = list;
        o(list);
        this.bbT.setData(list);
        this.aoy.setCurrentItem(0);
    }

    public void setCurrentIndex(int i) {
        if (this.aoy != null) {
            this.aoy.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void o(List<com.baidu.live.view.tabhost.a> list) {
        for (com.baidu.live.view.tabhost.a aVar : list) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            textView.setText(aVar.getTitle());
            textView.setPadding(0, this.bbS, 0, this.bbS);
            textView.setGravity(17);
            textView.setOnClickListener(this.aoO);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            a(textView, false, this.mSkinType);
            this.aox.addView(textView, layoutParams);
        }
    }

    private void a(TextView textView, boolean z, int i) {
        if (textView != null) {
            if (!z) {
                SkinManager.setViewTextColor(textView, a.d.sdk_cp_cont_j, 1, i);
            } else {
                SkinManager.setViewTextColor(textView, a.d.sdk_cp_cont_b, 1, i);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aox.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aox.getChildAt(i);
            if (childAt instanceof TextView) {
                a((TextView) childAt, i == this.mCurrentTabIndex, this.mSkinType);
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aox.getChildCount() != 0) {
            int height = this.aox.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            View childAt = this.aox.getChildAt(this.mCurrentTabIndex);
            float paddingLeft = childAt.getPaddingLeft() + this.aox.getLeft() + childAt.getLeft() + ((((childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight()) - this.mIndicatorWidth) / 2);
            float f = paddingLeft + this.mIndicatorWidth;
            if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aox.getChildCount() - 1) {
                View childAt2 = this.aox.getChildAt(this.mCurrentTabIndex + 1);
                float paddingLeft2 = childAt2.getPaddingLeft() + childAt2.getLeft() + this.aox.getLeft() + ((((childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
            }
            this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_common_color_10273), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b), Shader.TileMode.CLAMP));
            RectF rectF = new RectF(paddingLeft, height - this.mIndicatorHeight, f, height);
            canvas.drawRoundRect(rectF, rectF.height(), rectF.height(), this.mRectPaint);
            this.mRectPaint.setShader(null);
            this.mRectPaint.setColor(this.mDividerColor);
            canvas.drawRect(0.0f, height - this.mDividerHeight, this.aow.getWidth(), height, this.mRectPaint);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aox.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.bbU != null) {
                this.bbU.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aoK, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.bbU != null) {
                this.bbU.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aoK, this.mCurrentTabIndex));
            }
        }
        if (this.bbV != null) {
            this.bbV.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aox.getChildCount() != 0 && this.aoy != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.bbU = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.bbV = bVar;
    }
}
