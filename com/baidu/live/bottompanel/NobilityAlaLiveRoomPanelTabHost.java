package com.baidu.live.bottompanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.tieba.view.GradientTextView;
import java.util.List;
/* loaded from: classes4.dex */
public class NobilityAlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private boolean aGA;
    private int aGB;
    private int aGC;
    private int aGD;
    private List<d> aGF;
    private boolean aGG;
    private View.OnClickListener aGJ;
    private a aGM;
    private b aGN;
    private FrameLayout aGq;
    private LinearLayout aGr;
    private CustomViewPager aGs;
    private AlaAudienceLiveRoomBottomPanelAdapter aGt;
    private float aGu;
    private float aGv;
    private int aGw;
    private float aGx;
    private int aGy;
    private boolean aGz;
    private float mCurrentPositionOffset;
    private int mCurrentTabIndex;
    private int mDividerColor;
    private final int mDividerHeight;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private boolean mIsClicked;
    private Paint mRectPaint;
    private int mSelectorColor;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, d dVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public NobilityAlaLiveRoomPanelTabHost(Context context) {
        super(context);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds36);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aGs != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aGs.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aq(context);
        init();
    }

    public NobilityAlaLiveRoomPanelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds8);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds36);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aGs != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aGs.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aq(Context context) {
        this.aGu = getResources().getDimensionPixelOffset(a.d.sdk_ds80);
        this.aGv = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aGw = getResources().getColor(a.c.sdk_color_727272);
        this.aGx = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aGz = true;
        this.aGA = true;
        this.aGB = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aGu = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds80));
        this.aGv = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aGw = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_727272));
        this.aGx = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aGy = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.sdk_color_ff174f));
        this.aGz = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aGA = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aGB = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aGC = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aGD = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aGq = new FrameLayout(getContext());
        this.aGq.setClickable(true);
        addView(this.aGq, new LinearLayout.LayoutParams(-1, (int) this.aGu));
        this.aGr = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aGq.addView(this.aGr, layoutParams);
        this.aGs = new CustomViewPager(getContext());
        this.aGs.setOnPageChangeListener(this);
        addView(this.aGs);
        this.aGt = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aGs.setAdapter(this.aGt);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aGF = list;
        w(list);
        this.aGt.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aGs.getCurrentItem();
            }
        });
    }

    public void setCurrentIndex(int i) {
        if (this.aGs != null) {
            this.aGs.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aGJ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aGB != -1) {
                layoutParams.gravity = this.aGB;
            }
            a(cVar.Dj(), false, this.mSkinType, i);
            a((TextView) cVar.Dj(), false);
            this.aGr.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aGw, this.aGw);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
            } else if (this.aGC != 0 || this.aGD != 0) {
                gradientTextView.setGradientTextColor(this.aGC, this.aGD);
            } else {
                gradientTextView.setGradientTextColor(this.aGy, this.aGy);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aGv);
            } else {
                textView.setTextSize(0, this.aGx);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aGr.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aGr.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Dj(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).Dj(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aGG = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aGr.getChildCount() != 0) {
            int height = this.aGq.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aGr.getChildAt(this.mCurrentTabIndex);
            if (this.aGG) {
                float left = this.aGr.getLeft() + cVar.getLeft() + cVar.Dj().getLeft();
                float width = left + cVar.Dj().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aGr.getChildCount() - 1) {
                    f = width;
                    paddingLeft = left;
                } else {
                    c cVar2 = (c) this.aGr.getChildAt(this.mCurrentTabIndex + 1);
                    float left2 = cVar2.getLeft() + cVar2.Dj().getLeft() + this.aGr.getLeft();
                    float f2 = (left * (1.0f - this.mCurrentPositionOffset)) + (left2 * this.mCurrentPositionOffset);
                    f = ((cVar2.Dj().getWidth() + left2) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                    paddingLeft = f2;
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aGr.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aGr.getChildCount() - 1) {
                    View childAt = this.aGr.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aGr.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                }
            }
            if (this.aGA) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aGz) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGq.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aGr.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aGM != null) {
                this.aGM.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aGM != null) {
                this.aGM.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
        if (this.aGN != null) {
            this.aGN.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGr.getChildCount() != 0 && this.aGs != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.aGM = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aGN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aGL;

        public c(@NonNull Context context, String str) {
            super(context);
            gg(str);
        }

        private void gg(String str) {
            this.aGL = new GradientTextView(getContext());
            this.aGL.setCheckStrEquals(false);
            this.aGL.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize34));
            if (this.aGL != null) {
                this.aGL.getPaint().setFakeBoldText(true);
            }
            this.aGL.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aGL, layoutParams);
        }

        public GradientTextView Dj() {
            return this.aGL;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aGq != null) {
            this.aGq.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aGs != null) {
            this.aGs.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
