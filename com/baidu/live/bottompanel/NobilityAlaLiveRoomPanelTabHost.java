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
    private FrameLayout aED;
    private LinearLayout aEE;
    private CustomViewPager aEF;
    private AlaAudienceLiveRoomBottomPanelAdapter aEG;
    private float aEH;
    private float aEI;
    private int aEJ;
    private float aEK;
    private int aEL;
    private boolean aEM;
    private boolean aEN;
    private int aEO;
    private int aEP;
    private int aEQ;
    private List<d> aES;
    private boolean aET;
    private View.OnClickListener aEW;
    private ImageView aEZ;
    private int aFa;
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
        this.aEW = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aEE.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aEF != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aEF.setCurrentItem(indexOfChild, true);
                        }
                    });
                }
            }
        };
        aR(context);
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
        this.aEW = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aEE.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aEF != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aEF.setCurrentItem(indexOfChild, true);
                        }
                    });
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aR(Context context) {
        this.aEH = getResources().getDimensionPixelOffset(a.d.sdk_ds80);
        this.aEI = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aEJ = getResources().getColor(a.c.sdk_color_727272);
        this.aEK = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aEM = true;
        this.aEN = true;
        this.aEO = -1;
        this.aFa = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aEH = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds80));
        this.aEI = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aEJ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_727272));
        this.aEK = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aEL = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.sdk_color_ff174f));
        this.aEM = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aEN = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aEO = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aEP = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aEQ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        this.aFa = obtainStyledAttributes.getResourceId(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_rightIconResource, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aED = new FrameLayout(getContext());
        this.aED.setClickable(true);
        addView(this.aED, new LinearLayout.LayoutParams(-1, (int) this.aEH));
        this.aEE = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aED.addView(this.aEE, layoutParams);
        this.aEZ = new ImageView(getContext());
        this.aEZ.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 21;
        layoutParams2.setMargins(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
        if (this.aFa != -1) {
            this.aEZ.setImageResource(this.aFa);
        }
        this.aED.addView(this.aEZ, layoutParams2);
        this.aEF = new CustomViewPager(getContext());
        this.aEF.setOnPageChangeListener(this);
        addView(this.aEF);
        this.aEG = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aEF.setAdapter(this.aEG);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aES = list;
        x(list);
        this.aEG.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aEF.getCurrentItem();
            }
        });
    }

    public void setRightIconResourceId(int i) {
        this.aEZ.setImageResource(i);
    }

    public void setRightIconVisible(boolean z) {
        this.aEZ.setVisibility(z ? 0 : 8);
    }

    public void setRightIconClickListener(View.OnClickListener onClickListener) {
        this.aEZ.setOnClickListener(onClickListener);
    }

    public void setCurrentIndex(int i) {
        if (this.aEF != null) {
            this.aEF.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void x(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aEW);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aEO != -1) {
                layoutParams.gravity = this.aEO;
            }
            a(cVar.Ao(), false, this.mSkinType, i);
            a((TextView) cVar.Ao(), false);
            this.aEE.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aEJ, this.aEJ);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
            } else if (this.aEP != 0 || this.aEQ != 0) {
                gradientTextView.setGradientTextColor(this.aEP, this.aEQ);
            } else {
                gradientTextView.setGradientTextColor(this.aEL, this.aEL);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aEI);
            } else {
                textView.setTextSize(0, this.aEK);
            }
        }
    }

    private void a(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void updateTabStyles() {
        int childCount = this.aEE.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aEE.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Ao(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).Ao(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void C(String str, int i) {
        View childAt = this.aEE.getChildAt(i);
        if (childAt instanceof c) {
            a(((c) childAt).Ao(), str);
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aET = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f;
        float f2;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aEE.getChildCount() != 0) {
            int height = this.aED.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aEE.getChildAt(this.mCurrentTabIndex);
            if (this.aET) {
                f2 = this.aEE.getLeft() + cVar.getLeft() + cVar.Ao().getLeft();
                float width = f2 + cVar.Ao().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aEE.getChildCount() - 1) {
                    f = width;
                } else {
                    c cVar2 = (c) this.aEE.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.Ao().getLeft() + this.aEE.getLeft();
                    f2 = (f2 * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.Ao().getWidth() + left) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                }
            } else {
                float paddingLeft = cVar.getPaddingLeft() + this.aEE.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aEE.getChildCount() - 1) {
                    f2 = paddingLeft;
                } else {
                    View childAt = this.aEE.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aEE.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    float f3 = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                    f2 = f3;
                }
            }
            if (this.aEN) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aEM) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aED.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEE.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aFb != null) {
                this.aFb.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aES, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aFb != null) {
                this.aFb.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aES, this.mCurrentTabIndex));
            }
        }
        if (this.aFc != null) {
            this.aFc.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aEE.getChildCount() != 0 && this.aEF != null && i == 0) {
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
    /* loaded from: classes11.dex */
    public class c extends FrameLayout {
        private GradientTextView aEY;

        public c(@NonNull Context context, String str) {
            super(context);
            fn(str);
        }

        private void fn(String str) {
            this.aEY = new GradientTextView(getContext());
            this.aEY.setCheckStrEquals(false);
            this.aEY.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize34));
            if (this.aEY != null) {
                this.aEY.getPaint().setFakeBoldText(true);
            }
            this.aEY.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aEY, layoutParams);
        }

        public GradientTextView Ao() {
            return this.aEY;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aED != null) {
            this.aED.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aEF != null) {
            this.aEF.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
