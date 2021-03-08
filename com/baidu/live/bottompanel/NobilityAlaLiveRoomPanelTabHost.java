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
/* loaded from: classes10.dex */
public class NobilityAlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int aGA;
    private a aGB;
    private b aGC;
    private FrameLayout aGd;
    private LinearLayout aGe;
    private CustomViewPager aGf;
    private AlaAudienceLiveRoomBottomPanelAdapter aGg;
    private float aGh;
    private float aGi;
    private int aGj;
    private float aGk;
    private int aGl;
    private boolean aGm;
    private boolean aGn;
    private int aGo;
    private int aGp;
    private int aGq;
    private List<d> aGs;
    private boolean aGt;
    private View.OnClickListener aGw;
    private ImageView aGz;
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

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, d dVar);
    }

    /* loaded from: classes10.dex */
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
        this.aGw = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aGf != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aGf.setCurrentItem(indexOfChild, true);
                        }
                    });
                }
            }
        };
        aQ(context);
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
        this.aGw = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aGf != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aGf.setCurrentItem(indexOfChild, true);
                        }
                    });
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aQ(Context context) {
        this.aGh = getResources().getDimensionPixelOffset(a.d.sdk_ds80);
        this.aGi = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aGj = getResources().getColor(a.c.sdk_color_727272);
        this.aGk = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aGm = true;
        this.aGn = true;
        this.aGo = -1;
        this.aGA = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aGh = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds80));
        this.aGi = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aGj = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_727272));
        this.aGk = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aGl = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.sdk_color_ff174f));
        this.aGm = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aGn = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aGo = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aGp = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aGq = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        this.aGA = obtainStyledAttributes.getResourceId(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_rightIconResource, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aGd = new FrameLayout(getContext());
        this.aGd.setClickable(true);
        addView(this.aGd, new LinearLayout.LayoutParams(-1, (int) this.aGh));
        this.aGe = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aGd.addView(this.aGe, layoutParams);
        this.aGz = new ImageView(getContext());
        this.aGz.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 21;
        layoutParams2.setMargins(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
        if (this.aGA != -1) {
            this.aGz.setImageResource(this.aGA);
        }
        this.aGd.addView(this.aGz, layoutParams2);
        this.aGf = new CustomViewPager(getContext());
        this.aGf.setOnPageChangeListener(this);
        addView(this.aGf);
        this.aGg = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aGf.setAdapter(this.aGg);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aGs = list;
        x(list);
        this.aGg.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aGf.getCurrentItem();
            }
        });
    }

    public void setRightIconResourceId(int i) {
        this.aGz.setImageResource(i);
    }

    public void setRightIconVisible(boolean z) {
        this.aGz.setVisibility(z ? 0 : 8);
    }

    public void setRightIconClickListener(View.OnClickListener onClickListener) {
        this.aGz.setOnClickListener(onClickListener);
    }

    public void setCurrentIndex(int i) {
        if (this.aGf != null) {
            this.aGf.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void x(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aGw);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aGo != -1) {
                layoutParams.gravity = this.aGo;
            }
            a(cVar.Ar(), false, this.mSkinType, i);
            a((TextView) cVar.Ar(), false);
            this.aGe.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aGj, this.aGj);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
            } else if (this.aGp != 0 || this.aGq != 0) {
                gradientTextView.setGradientTextColor(this.aGp, this.aGq);
            } else {
                gradientTextView.setGradientTextColor(this.aGl, this.aGl);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aGi);
            } else {
                textView.setTextSize(0, this.aGk);
            }
        }
    }

    private void a(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void updateTabStyles() {
        int childCount = this.aGe.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aGe.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Ar(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).Ar(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void C(String str, int i) {
        View childAt = this.aGe.getChildAt(i);
        if (childAt instanceof c) {
            a(((c) childAt).Ar(), str);
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aGt = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f;
        float f2;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aGe.getChildCount() != 0) {
            int height = this.aGd.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aGe.getChildAt(this.mCurrentTabIndex);
            if (this.aGt) {
                f2 = this.aGe.getLeft() + cVar.getLeft() + cVar.Ar().getLeft();
                float width = f2 + cVar.Ar().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aGe.getChildCount() - 1) {
                    f = width;
                } else {
                    c cVar2 = (c) this.aGe.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.Ar().getLeft() + this.aGe.getLeft();
                    f2 = (f2 * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.Ar().getWidth() + left) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                }
            } else {
                float paddingLeft = cVar.getPaddingLeft() + this.aGe.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aGe.getChildCount() - 1) {
                    f2 = paddingLeft;
                } else {
                    View childAt = this.aGe.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aGe.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    float f3 = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                    f2 = f3;
                }
            }
            if (this.aGn) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aGm) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGd.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aGe.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aGB != null) {
                this.aGB.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aGB != null) {
                this.aGB.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
            }
        }
        if (this.aGC != null) {
            this.aGC.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGe.getChildCount() != 0 && this.aGf != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.aGB = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aGC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends FrameLayout {
        private GradientTextView aGy;

        public c(@NonNull Context context, String str) {
            super(context);
            ft(str);
        }

        private void ft(String str) {
            this.aGy = new GradientTextView(getContext());
            this.aGy.setCheckStrEquals(false);
            this.aGy.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize34));
            if (this.aGy != null) {
                this.aGy.getPaint().setFakeBoldText(true);
            }
            this.aGy.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aGy, layoutParams);
        }

        public GradientTextView Ar() {
            return this.aGy;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aGd != null) {
            this.aGd.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aGf != null) {
            this.aGf.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
