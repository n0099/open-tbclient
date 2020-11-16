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
    private FrameLayout aEF;
    private LinearLayout aEG;
    private CustomViewPager aEH;
    private AlaAudienceLiveRoomBottomPanelAdapter aEI;
    private float aEJ;
    private float aEK;
    private int aEL;
    private float aEM;
    private int aEN;
    private boolean aEO;
    private boolean aEP;
    private int aEQ;
    private int aER;
    private int aES;
    private List<d> aEU;
    private boolean aEV;
    private View.OnClickListener aEY;
    private a aFb;
    private b aFc;
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
        this.aEY = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aEG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aEH != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aEH.setCurrentItem(indexOfChild);
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
        this.aEY = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aEG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aEH != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aEH.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aq(Context context) {
        this.aEJ = getResources().getDimensionPixelOffset(a.d.sdk_ds80);
        this.aEK = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aEL = getResources().getColor(a.c.sdk_color_727272);
        this.aEM = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aEO = true;
        this.aEP = true;
        this.aEQ = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aEJ = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds80));
        this.aEK = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aEL = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_727272));
        this.aEM = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aEN = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.sdk_color_ff174f));
        this.aEO = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aEP = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aEQ = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aER = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aES = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aEF = new FrameLayout(getContext());
        this.aEF.setClickable(true);
        addView(this.aEF, new LinearLayout.LayoutParams(-1, (int) this.aEJ));
        this.aEG = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aEF.addView(this.aEG, layoutParams);
        this.aEH = new CustomViewPager(getContext());
        this.aEH.setOnPageChangeListener(this);
        addView(this.aEH);
        this.aEI = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aEH.setAdapter(this.aEI);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aEU = list;
        w(list);
        this.aEI.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aEH.getCurrentItem();
            }
        });
    }

    public void setCurrentIndex(int i) {
        if (this.aEH != null) {
            this.aEH.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aEY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aEQ != -1) {
                layoutParams.gravity = this.aEQ;
            }
            a(cVar.CA(), false, this.mSkinType, i);
            a((TextView) cVar.CA(), false);
            this.aEG.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aEL, this.aEL);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
            } else if (this.aER != 0 || this.aES != 0) {
                gradientTextView.setGradientTextColor(this.aER, this.aES);
            } else {
                gradientTextView.setGradientTextColor(this.aEN, this.aEN);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aEK);
            } else {
                textView.setTextSize(0, this.aEM);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aEG.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aEG.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).CA(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).CA(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aEV = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aEG.getChildCount() != 0) {
            int height = this.aEF.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aEG.getChildAt(this.mCurrentTabIndex);
            if (this.aEV) {
                float left = this.aEG.getLeft() + cVar.getLeft() + cVar.CA().getLeft();
                float width = left + cVar.CA().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aEG.getChildCount() - 1) {
                    f = width;
                    paddingLeft = left;
                } else {
                    c cVar2 = (c) this.aEG.getChildAt(this.mCurrentTabIndex + 1);
                    float left2 = cVar2.getLeft() + cVar2.CA().getLeft() + this.aEG.getLeft();
                    float f2 = (left * (1.0f - this.mCurrentPositionOffset)) + (left2 * this.mCurrentPositionOffset);
                    f = ((cVar2.CA().getWidth() + left2) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                    paddingLeft = f2;
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aEG.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aEG.getChildCount() - 1) {
                    View childAt = this.aEG.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aEG.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                }
            }
            if (this.aEP) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aEO) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aEF.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEG.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aFb != null) {
                this.aFb.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aEU, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aFb != null) {
                this.aFb.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aEU, this.mCurrentTabIndex));
            }
        }
        if (this.aFc != null) {
            this.aFc.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aEG.getChildCount() != 0 && this.aEH != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.aFb = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aFc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aFa;

        public c(@NonNull Context context, String str) {
            super(context);
            ga(str);
        }

        private void ga(String str) {
            this.aFa = new GradientTextView(getContext());
            this.aFa.setCheckStrEquals(false);
            this.aFa.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize34));
            if (this.aFa != null) {
                this.aFa.getPaint().setFakeBoldText(true);
            }
            this.aFa.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aFa, layoutParams);
        }

        public GradientTextView CA() {
            return this.aFa;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aEF != null) {
            this.aEF.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aEH != null) {
            this.aEH.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
