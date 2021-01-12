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
    private FrameLayout aCQ;
    private LinearLayout aCR;
    private CustomViewPager aCS;
    private AlaAudienceLiveRoomBottomPanelAdapter aCT;
    private float aCU;
    private float aCV;
    private int aCW;
    private float aCX;
    private int aCY;
    private boolean aCZ;
    private boolean aDa;
    private int aDb;
    private int aDc;
    private int aDd;
    private List<d> aDf;
    private boolean aDg;
    private View.OnClickListener aDj;
    private ImageView aDm;
    private int aDn;
    private a aDo;
    private b aDp;
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
        this.aDj = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aCR.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aCS != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aCS.setCurrentItem(indexOfChild, true);
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
        this.aDj = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final int indexOfChild = NobilityAlaLiveRoomPanelTabHost.this.aCR.indexOfChild(view);
                if (indexOfChild >= 0 && NobilityAlaLiveRoomPanelTabHost.this.aCS != null) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NobilityAlaLiveRoomPanelTabHost.this.aCS.setCurrentItem(indexOfChild, true);
                        }
                    });
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aR(Context context) {
        this.aCU = getResources().getDimensionPixelOffset(a.d.sdk_ds80);
        this.aCV = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aCW = getResources().getColor(a.c.sdk_color_727272);
        this.aCX = getResources().getDimensionPixelOffset(a.d.sdk_fontsize34);
        this.aCZ = true;
        this.aDa = true;
        this.aDb = -1;
        this.aDn = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aCU = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds80));
        this.aCV = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aCW = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_727272));
        this.aCX = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize34));
        this.aCY = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.sdk_color_ff174f));
        this.aCZ = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aDa = obtainStyledAttributes.getBoolean(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aDb = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aDc = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aDd = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        this.aDn = obtainStyledAttributes.getResourceId(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_rightIconResource, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aCQ = new FrameLayout(getContext());
        this.aCQ.setClickable(true);
        addView(this.aCQ, new LinearLayout.LayoutParams(-1, (int) this.aCU));
        this.aCR = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aCQ.addView(this.aCR, layoutParams);
        this.aDm = new ImageView(getContext());
        this.aDm.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20), getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 21;
        layoutParams2.setMargins(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
        if (this.aDn != -1) {
            this.aDm.setImageResource(this.aDn);
        }
        this.aCQ.addView(this.aDm, layoutParams2);
        this.aCS = new CustomViewPager(getContext());
        this.aCS.setOnPageChangeListener(this);
        addView(this.aCS);
        this.aCT = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aCS.setAdapter(this.aCT);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list) {
        this.aDf = list;
        x(list);
        this.aCT.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.NobilityAlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NobilityAlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NobilityAlaLiveRoomPanelTabHost.this.mCurrentTabIndex = NobilityAlaLiveRoomPanelTabHost.this.aCS.getCurrentItem();
            }
        });
    }

    public void setRightIconResourceId(int i) {
        this.aDm.setImageResource(i);
    }

    public void setRightIconVisible(boolean z) {
        this.aDm.setVisibility(z ? 0 : 8);
    }

    public void setRightIconClickListener(View.OnClickListener onClickListener) {
        this.aDm.setOnClickListener(onClickListener);
    }

    public void setCurrentIndex(int i) {
        if (this.aCS != null) {
            this.aCS.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void x(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = new c(getContext(), list.get(i).getTitle());
            cVar.setOnClickListener(this.aDj);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aDb != -1) {
                layoutParams.gravity = this.aDb;
            }
            a(cVar.zE(), false, this.mSkinType, i);
            a((TextView) cVar.zE(), false);
            this.aCR.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i, int i2) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aCW, this.aCW);
            } else if (i2 == 1) {
                gradientTextView.setGradientTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
            } else if (this.aDc != 0 || this.aDd != 0) {
                gradientTextView.setGradientTextColor(this.aDc, this.aDd);
            } else {
                gradientTextView.setGradientTextColor(this.aCY, this.aCY);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aCV);
            } else {
                textView.setTextSize(0, this.aCX);
            }
        }
    }

    private void a(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void updateTabStyles() {
        int childCount = this.aCR.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aCR.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).zE(), i == this.mCurrentTabIndex, this.mSkinType, i);
                a(((c) childAt).zE(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void C(String str, int i) {
        View childAt = this.aCR.getChildAt(i);
        if (childAt instanceof c) {
            a(((c) childAt).zE(), str);
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aDg = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f;
        float f2;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aCR.getChildCount() != 0) {
            int height = this.aCQ.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aCR.getChildAt(this.mCurrentTabIndex);
            if (this.aDg) {
                f2 = this.aCR.getLeft() + cVar.getLeft() + cVar.zE().getLeft();
                float width = f2 + cVar.zE().getWidth();
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aCR.getChildCount() - 1) {
                    f = width;
                } else {
                    c cVar2 = (c) this.aCR.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.zE().getLeft() + this.aCR.getLeft();
                    f2 = (f2 * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.zE().getWidth() + left) * this.mCurrentPositionOffset) + (width * (1.0f - this.mCurrentPositionOffset));
                }
            } else {
                float paddingLeft = cVar.getPaddingLeft() + this.aCR.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = this.mIndicatorWidth + paddingLeft;
                if (this.mCurrentPositionOffset <= 0.0f || this.mCurrentTabIndex >= this.aCR.getChildCount() - 1) {
                    f2 = paddingLeft;
                } else {
                    View childAt = this.aCR.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aCR.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    float f3 = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
                    f2 = f3;
                }
            }
            if (this.aDa) {
                if (this.mCurrentTabIndex == 1) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_C39B5F));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                } else {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
            }
            if (this.aCZ) {
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.aCQ.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aCR.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aDo != null) {
                this.aDo.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aDf, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aDo != null) {
                this.aDo.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aDf, this.mCurrentTabIndex));
            }
        }
        if (this.aDp != null) {
            this.aDp.onPageSelected(i);
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
        this.aDo = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aDp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends FrameLayout {
        private GradientTextView aDl;

        public c(@NonNull Context context, String str) {
            super(context);
            eU(str);
        }

        private void eU(String str) {
            this.aDl = new GradientTextView(getContext());
            this.aDl.setCheckStrEquals(false);
            this.aDl.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize34));
            if (this.aDl != null) {
                this.aDl.getPaint().setFakeBoldText(true);
            }
            this.aDl.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aDl, layoutParams);
        }

        public GradientTextView zE() {
            return this.aDl;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aCQ != null) {
            this.aCQ.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aCS != null) {
            this.aCS.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }
}
