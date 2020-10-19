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
    private int aFA;
    private boolean aFB;
    private boolean aFC;
    private int aFD;
    private int aFE;
    private int aFF;
    private List<d> aFH;
    private boolean aFI;
    private View.OnClickListener aFL;
    private a aFO;
    private b aFP;
    private FrameLayout aFs;
    private LinearLayout aFt;
    private CustomViewPager aFu;
    private AlaAudienceLiveRoomBottomPanelAdapter aFv;
    private float aFw;
    private float aFx;
    private int aFy;
    private float aFz;
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
        this.aFL = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aFt.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aFu != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aFu.setCurrentItem(indexOfChild);
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
        this.aFL = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aFt.indexOfChild(view);
                if (indexOfChild >= 0) {
                    NobilityAlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (NobilityAlaLiveRoomPanelTabHost.this.aFu != null) {
                        NobilityAlaLiveRoomPanelTabHost.this.aFu.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aq(Context context) {
        this.aFw = getResources().getDimensionPixelOffset(a.e.sdk_ds80);
        this.aFx = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aFy = getResources().getColor(a.d.sdk_color_727272);
        this.aFz = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aFB = true;
        this.aFC = true;
        this.aFD = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aFw = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        this.aFx = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aFy = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_727272));
        this.aFz = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aFA = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.sdk_color_ff174f));
        this.aFB = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aFC = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aFD = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aFE = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aFF = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aFs = new FrameLayout(getContext());
        this.aFs.setClickable(true);
        addView(this.aFs, new LinearLayout.LayoutParams(-1, (int) this.aFw));
        this.aFt = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.aFs.addView(this.aFt, layoutParams);
        this.aFu = new CustomViewPager(getContext());
        this.aFu.setOnPageChangeListener(this);
        addView(this.aFu);
        this.aFv = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aFu.setAdapter(this.aFv);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aFH = list;
        w(list);
        this.aFv.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aFu.getCurrentItem();
            }
        });
    }

    public void setCurrentIndex(int i) {
        if (this.aFu != null) {
            this.aFu.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aFL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aFD != -1) {
                layoutParams.gravity = this.aFD;
            }
            a(cVar.CK(), false, this.mSkinType, i);
            a((TextView) cVar.CK(), false);
            this.aFt.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aFy, this.aFy);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_C39B5F));
            } else if (this.aFE != 0 || this.aFF != 0) {
                gradientTextView.setGradientTextColor(this.aFE, this.aFF);
            } else {
                gradientTextView.setGradientTextColor(this.aFA, this.aFA);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aFx);
            } else {
                textView.setTextSize(0, this.aFz);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aFt.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aFt.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).CK(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).CK(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aFI = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aFt.getChildCount() != 0) {
            int height = this.aFs.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aFt.getChildAt(this.mCurrentTabIndex);
            if (this.aFI) {
                float left = this.aFt.getLeft() + cVar.getLeft() + cVar.CK().getLeft();
                float width = left + cVar.CK().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aFt.getChildCount() - 1) {
                    f = width;
                    paddingLeft = left;
                } else {
                    c cVar2 = (c) this.aFt.getChildAt(this.mCurrentTabIndex + 1);
                    float left2 = cVar2.getLeft() + cVar2.CK().getLeft() + this.aFt.getLeft();
                    float f2 = (left * (1.0f - this.mCurrentPositionOffset)) + (left2 * this.mCurrentPositionOffset);
                    f = ((cVar2.CK().getWidth() + left2) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                    paddingLeft = f2;
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aFt.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aFt.getChildCount() - 1) {
                    View childAt = this.aFt.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aFt.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                }
            }
            if (this.aFC) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aFB) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aFs.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aFt.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aFO != null) {
                this.aFO.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aFH, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aFO != null) {
                this.aFO.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aFH, this.mCurrentTabIndex));
            }
        }
        if (this.aFP != null) {
            this.aFP.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aFt.getChildCount() != 0 && this.aFu != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.aFO = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aFP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aFN;

        public c(@NonNull Context context, String str) {
            super(context);
            ga(str);
        }

        private void ga(String str) {
            this.aFN = new GradientTextView(getContext());
            this.aFN.setCheckStrEquals(false);
            this.aFN.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize34));
            if (this.aFN != null) {
                this.aFN.getPaint().setFakeBoldText(true);
            }
            this.aFN.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aFN, layoutParams);
        }

        public GradientTextView CK() {
            return this.aFN;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aFs != null) {
            this.aFs.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aFu != null) {
            this.aFu.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
