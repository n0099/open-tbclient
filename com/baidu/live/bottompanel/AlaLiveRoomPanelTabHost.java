package com.baidu.live.bottompanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
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
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.tieba.view.GradientTextView;
import java.util.List;
/* loaded from: classes7.dex */
public class AlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private FrameLayout aBF;
    private LinearLayout aBG;
    private CustomViewPager aBH;
    private AlaAudienceLiveRoomBottomPanelAdapter aBI;
    private float aBJ;
    private float aBK;
    private int aBL;
    private float aBM;
    private int aBN;
    private boolean aBO;
    private boolean aBP;
    private int aBQ;
    private int aBR;
    private int aBS;
    private List<d> aBT;
    private boolean aBU;
    private a aBV;
    private b aBW;
    private View.OnClickListener aBX;
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

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, d dVar);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaLiveRoomPanelTabHost(Context context) {
        super(context);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aBX = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aBG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aBH != null) {
                        AlaLiveRoomPanelTabHost.this.aBH.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        an(context);
        init();
    }

    public AlaLiveRoomPanelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aBX = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aBG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aBH != null) {
                        AlaLiveRoomPanelTabHost.this.aBH.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void an(Context context) {
        this.aBJ = getResources().getDimensionPixelOffset(a.e.sdk_ds80);
        this.aBK = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aBL = getResources().getColor(a.d.sdk_color_727272);
        this.aBM = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aBO = true;
        this.aBP = true;
        this.aBQ = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aBJ = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        this.aBK = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aBL = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_727272));
        this.aBM = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aBN = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.sdk_color_ff174f));
        this.aBO = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aBP = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aBQ = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aBR = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aBS = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aBF = new FrameLayout(getContext());
        this.aBF.setClickable(true);
        addView(this.aBF, new LinearLayout.LayoutParams(-1, (int) this.aBJ));
        this.aBG = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.aBF.addView(this.aBG, layoutParams);
        this.aBH = new CustomViewPager(getContext());
        this.aBH.setOnPageChangeListener(this);
        addView(this.aBH);
        this.aBI = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aBH.setAdapter(this.aBI);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list, boolean z) {
        this.aBT = list;
        u(list);
        this.aBI.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaLiveRoomPanelTabHost.this.mCurrentTabIndex = AlaLiveRoomPanelTabHost.this.aBH.getCurrentItem();
            }
        });
        if (z) {
            int i = com.baidu.live.c.AD().getInt("ala_live_room_tab_id", -1);
            if (com.baidu.live.c.AD().getBoolean("ala_person_ala_entrance_same_live_room", false) && i >= 0 && i < this.aBI.getCount()) {
                this.aBH.setCurrentItem(i);
                com.baidu.live.c.AD().remove("ala_person_ala_entrance_same_live_room");
                return;
            }
            this.aBH.setCurrentItem(0);
            return;
        }
        this.aBH.setCurrentItem(0);
    }

    public void setData(List<d> list) {
        setData(list, false);
    }

    public void setCurrentIndex(int i) {
        if (this.aBH != null) {
            this.aBH.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void u(List<d> list) {
        for (d dVar : list) {
            c cVar = new c(getContext(), dVar.getTitle());
            cVar.setOnClickListener(this.aBX);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aBQ != -1) {
                layoutParams.gravity = this.aBQ;
            }
            a(cVar.By(), false, this.mSkinType);
            a((TextView) cVar.By(), false);
            this.aBG.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i) {
        if (gradientTextView != null) {
            if (!z) {
                if (this.aBL == getResources().getColor(a.d.sdk_color_727272)) {
                    SkinManager.setViewTextColor(gradientTextView, a.d.sdk_color_727272, 1, i);
                } else {
                    gradientTextView.setGradientTextColor(this.aBL, this.aBL);
                }
            } else if (this.aBR != 0 || this.aBS != 0) {
                gradientTextView.setGradientTextColor(this.aBR, this.aBS);
            } else {
                gradientTextView.setGradientTextColor(this.aBN, this.aBN);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aBK);
            } else {
                textView.setTextSize(0, this.aBM);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aBG.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aBG.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).By(), i == this.mCurrentTabIndex, this.mSkinType);
                a(((c) childAt).By(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aBU = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aBG.getChildCount() != 0) {
            int height = this.aBF.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aBG.getChildAt(this.mCurrentTabIndex);
            if (this.aBU) {
                paddingLeft = this.aBG.getLeft() + cVar.getLeft() + cVar.By().getLeft();
                f = paddingLeft + cVar.By().getWidth();
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aBG.getChildCount() - 1) {
                    c cVar2 = (c) this.aBG.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.By().getLeft() + this.aBG.getLeft();
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.By().getWidth() + left) * this.mCurrentPositionOffset) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aBG.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = paddingLeft + this.mIndicatorWidth;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aBG.getChildCount() - 1) {
                    View childAt = this.aBG.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aBG.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            }
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (this.aBP) {
                    this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aBO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aBF.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (this.aBP) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aBO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aBF.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (this.aBP) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aBO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aBF.getWidth(), height, this.mRectPaint);
                }
            } else {
                if (this.aBP) {
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aBO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aBF.getWidth(), height, this.mRectPaint);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aBG.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aBV != null) {
                this.aBV.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aBT, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aBV != null) {
                this.aBV.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aBT, this.mCurrentTabIndex));
            }
        }
        if (this.aBW != null) {
            this.aBW.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aBG.getChildCount() != 0 && this.aBH != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.mSelectorColor = SkinManager.getColor(i, a.d.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(i, a.d.sdk_cp_bg_line_c);
        if (!ListUtils.isEmpty(this.aBT)) {
            for (d dVar : this.aBT) {
                if (dVar != null) {
                    dVar.onChangeSkinType(i);
                }
            }
        }
        this.aBI.onChangeSkinType(i);
    }

    public void enterForeground() {
        this.aBI.Bv();
    }

    public void setOnPageChangeListener(a aVar) {
        this.aBV = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aBW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends FrameLayout {
        private GradientTextView aBZ;

        public c(@NonNull Context context, String str) {
            super(context);
            fH(str);
        }

        private void fH(String str) {
            this.aBZ = new GradientTextView(getContext());
            this.aBZ.setCheckStrEquals(false);
            this.aBZ.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize34));
            if (this.aBZ != null) {
                this.aBZ.getPaint().setFakeBoldText(true);
            }
            this.aBZ.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aBZ, layoutParams);
        }

        public GradientTextView By() {
            return this.aBZ;
        }
    }
}
