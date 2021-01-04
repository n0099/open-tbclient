package com.baidu.live.bottompanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.tieba.view.GradientTextView;
import java.util.List;
/* loaded from: classes11.dex */
public class NobilityAlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private FrameLayout aHD;
    private LinearLayout aHE;
    private CustomViewPager aHF;
    private AlaAudienceLiveRoomBottomPanelAdapter aHG;
    private float aHH;
    private float aHI;
    private int aHJ;
    private float aHK;
    private int aHL;
    private boolean aHM;
    private boolean aHN;
    private int aHO;
    private int aHP;
    private int aHQ;
    private List<d> aHS;
    private boolean aHT;
    private View.OnClickListener aHW;
    private ImageView aHZ;
    private int aIa;
    private a aIb;
    private b aIc;
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

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i, d dVar);
    }

    /* loaded from: classes11.dex */
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
        this.aHW = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aHE.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aHF != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aHF.setCurrentItem(indexOfChild, true);
                        }
                    });
                }
            }
        };
        aS(context);
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
        this.aHW = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aHE.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aHF != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aHF.setCurrentItem(indexOfChild, true);
                        }
                    });
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aS(Context context) {
        this.aHH = getResources().getDimensionPixelOffset(a.d.sdk_ds80);
        this.aHI = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aHJ = getResources().getColor(a.c.sdk_color_727272);
        this.aHK = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aHM = true;
        this.aHN = true;
        this.aHO = -1;
        this.aIa = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aHH = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds80));
        this.aHI = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aHJ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_727272));
        this.aHK = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aHL = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.sdk_color_ff174f));
        this.aHM = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aHN = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aHO = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aHP = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aHQ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        this.aIa = obtainStyledAttributes.getResourceId(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_rightIconResource, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aHD = new FrameLayout(getContext());
        this.aHD.setClickable(true);
        addView(this.aHD, new LinearLayout.LayoutParams(-1, (int) this.aHH));
        this.aHE = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aHD.addView(this.aHE, layoutParams);
        this.aHZ = new ImageView(getContext());
        this.aHZ.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 21;
        layoutParams2.setMargins(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
        if (this.aIa != -1) {
            this.aHZ.setImageResource(this.aIa);
        }
        this.aHD.addView(this.aHZ, layoutParams2);
        this.aHF = new CustomViewPager(getContext());
        this.aHF.setOnPageChangeListener(this);
        addView(this.aHF);
        this.aHG = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aHF.setAdapter(this.aHG);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aHS = list;
        x(list);
        this.aHG.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aHF.getCurrentItem();
            }
        });
    }

    public void setRightIconResourceId(int i) {
        this.aHZ.setImageResource(i);
    }

    public void setRightIconVisible(boolean z) {
        this.aHZ.setVisibility(z ? 0 : 8);
    }

    public void setRightIconClickListener(View.OnClickListener onClickListener) {
        this.aHZ.setOnClickListener(onClickListener);
    }

    public void setCurrentIndex(int i) {
        if (this.aHF != null) {
            this.aHF.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void x(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aHW);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aHO != -1) {
                layoutParams.gravity = this.aHO;
            }
            a(cVar.Dz(), false, this.mSkinType, i);
            a((TextView) cVar.Dz(), false);
            this.aHE.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aHJ, this.aHJ);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
            } else if (this.aHP != 0 || this.aHQ != 0) {
                gradientTextView.setGradientTextColor(this.aHP, this.aHQ);
            } else {
                gradientTextView.setGradientTextColor(this.aHL, this.aHL);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aHI);
            } else {
                textView.setTextSize(0, this.aHK);
            }
        }
    }

    private void a(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void updateTabStyles() {
        int childCount = this.aHE.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aHE.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Dz(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).Dz(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void C(String str, int i) {
        View childAt = this.aHE.getChildAt(i);
        if (childAt instanceof c) {
            a(((c) childAt).Dz(), str);
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aHT = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f;
        float f2;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aHE.getChildCount() != 0) {
            int height = this.aHD.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aHE.getChildAt(this.mCurrentTabIndex);
            if (this.aHT) {
                f2 = this.aHE.getLeft() + cVar.getLeft() + cVar.Dz().getLeft();
                float width = f2 + cVar.Dz().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aHE.getChildCount() - 1) {
                    f = width;
                } else {
                    c cVar2 = (c) this.aHE.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.Dz().getLeft() + this.aHE.getLeft();
                    f2 = (f2 * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.Dz().getWidth() + left) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                }
            } else {
                float paddingLeft = cVar.getPaddingLeft() + this.aHE.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aHE.getChildCount() - 1) {
                    f2 = paddingLeft;
                } else {
                    View childAt = this.aHE.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aHE.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    float f3 = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                    f2 = f3;
                }
            }
            if (this.aHN) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aHM) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aHD.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aHE.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aIb != null) {
                this.aIb.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aHS, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aIb != null) {
                this.aIb.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aHS, this.mCurrentTabIndex));
            }
        }
        if (this.aIc != null) {
            this.aIc.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aHE.getChildCount() != 0 && this.aHF != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.aIb = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aIc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends FrameLayout {
        private GradientTextView aHY;

        public c(@NonNull Context context, String str) {
            super(context);
            gf(str);
        }

        private void gf(String str) {
            this.aHY = new GradientTextView(getContext());
            this.aHY.setCheckStrEquals(false);
            this.aHY.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize34));
            if (this.aHY != null) {
                this.aHY.getPaint().setFakeBoldText(true);
            }
            this.aHY.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aHY, layoutParams);
        }

        public GradientTextView Dz() {
            return this.aHY;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aHD != null) {
            this.aHD.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aHF != null) {
            this.aHF.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
