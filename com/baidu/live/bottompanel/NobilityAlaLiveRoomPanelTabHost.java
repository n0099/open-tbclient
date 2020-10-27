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
    private FrameLayout aFA;
    private LinearLayout aFB;
    private CustomViewPager aFC;
    private AlaAudienceLiveRoomBottomPanelAdapter aFD;
    private float aFE;
    private float aFF;
    private int aFG;
    private float aFH;
    private int aFI;
    private boolean aFJ;
    private boolean aFK;
    private int aFL;
    private int aFM;
    private int aFN;
    private List<d> aFP;
    private boolean aFQ;
    private View.OnClickListener aFT;
    private a aFW;
    private b aFX;
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
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds8);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds36);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aFT = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aFB.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aFC != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aFC.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aq(context);
        init();
    }

    public NobilityAlaLiveRoomPanelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds8);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds36);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aFT = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aFB.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aFC != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aFC.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aq(Context context) {
        this.aFE = getResources().getDimensionPixelOffset(a.e.sdk_ds80);
        this.aFF = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aFG = getResources().getColor(a.d.sdk_color_727272);
        this.aFH = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aFJ = true;
        this.aFK = true;
        this.aFL = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aFE = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        this.aFF = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aFG = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_727272));
        this.aFH = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aFI = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.sdk_color_ff174f));
        this.aFJ = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aFK = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aFL = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aFM = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aFN = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aFA = new FrameLayout(getContext());
        this.aFA.setClickable(true);
        addView(this.aFA, new LinearLayout.LayoutParams(-1, (int) this.aFE));
        this.aFB = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.aFA.addView(this.aFB, layoutParams);
        this.aFC = new CustomViewPager(getContext());
        this.aFC.setOnPageChangeListener(this);
        addView(this.aFC);
        this.aFD = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aFC.setAdapter(this.aFD);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aFP = list;
        w(list);
        this.aFD.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aFC.getCurrentItem();
            }
        });
    }

    public void setCurrentIndex(int i) {
        if (this.aFC != null) {
            this.aFC.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aFT);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aFL != -1) {
                layoutParams.gravity = this.aFL;
            }
            a(cVar.CQ(), false, this.mSkinType, i);
            a((TextView) cVar.CQ(), false);
            this.aFB.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aFG, this.aFG);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_C39B5F));
            } else if (this.aFM != 0 || this.aFN != 0) {
                gradientTextView.setGradientTextColor(this.aFM, this.aFN);
            } else {
                gradientTextView.setGradientTextColor(this.aFI, this.aFI);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aFF);
            } else {
                textView.setTextSize(0, this.aFH);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aFB.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aFB.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).CQ(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).CQ(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aFQ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aFB.getChildCount() != 0) {
            int height = this.aFA.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aFB.getChildAt(this.mCurrentTabIndex);
            if (this.aFQ) {
                float left = this.aFB.getLeft() + cVar.getLeft() + cVar.CQ().getLeft();
                float width = left + cVar.CQ().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aFB.getChildCount() - 1) {
                    f = width;
                    paddingLeft = left;
                } else {
                    c cVar2 = (c) this.aFB.getChildAt(this.mCurrentTabIndex + 1);
                    float left2 = cVar2.getLeft() + cVar2.CQ().getLeft() + this.aFB.getLeft();
                    float f2 = (left * (1.0f - this.mCurrentPositionOffset)) + (left2 * this.mCurrentPositionOffset);
                    f = ((cVar2.CQ().getWidth() + left2) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                    paddingLeft = f2;
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aFB.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aFB.getChildCount() - 1) {
                    View childAt = this.aFB.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aFB.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                }
            }
            if (this.aFK) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aFJ) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aFA.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aFB.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aFW != null) {
                this.aFW.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aFP, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aFW != null) {
                this.aFW.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aFP, this.mCurrentTabIndex));
            }
        }
        if (this.aFX != null) {
            this.aFX.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aFB.getChildCount() != 0 && this.aFC != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.aFW = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aFX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aFV;

        public c(@NonNull Context context, String str) {
            super(context);
            gb(str);
        }

        private void gb(String str) {
            this.aFV = new GradientTextView(getContext());
            this.aFV.setCheckStrEquals(false);
            this.aFV.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize34));
            if (this.aFV != null) {
                this.aFV.getPaint().setFakeBoldText(true);
            }
            this.aFV.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aFV, layoutParams);
        }

        public GradientTextView CQ() {
            return this.aFV;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aFA != null) {
            this.aFA.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aFC != null) {
            this.aFC.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
