package com.baidu.live.bottompanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
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
/* loaded from: classes4.dex */
public class AlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
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
    private boolean aET;
    private List<d> aEU;
    private boolean aEV;
    private a aEW;
    private b aEX;
    private View.OnClickListener aEY;
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

    public AlaLiveRoomPanelTabHost(Context context) {
        super(context);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aEY = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aEG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aEH != null) {
                        AlaLiveRoomPanelTabHost.this.aEH.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aq(context);
        init();
    }

    public AlaLiveRoomPanelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aEY = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aEG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aEH != null) {
                        AlaLiveRoomPanelTabHost.this.aEH.setCurrentItem(indexOfChild);
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

    public void setData(List<d> list, boolean z) {
        this.aEU = list;
        w(list);
        this.aEI.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaLiveRoomPanelTabHost.this.mCurrentTabIndex = AlaLiveRoomPanelTabHost.this.aEH.getCurrentItem();
            }
        });
        if (z) {
            int i = com.baidu.live.d.Aq().getInt("ala_live_room_tab_id", -1);
            if (com.baidu.live.d.Aq().getBoolean("ala_person_ala_entrance_same_live_room", false) && i >= 0 && i < this.aEI.getCount()) {
                this.aEH.setCurrentItem(i);
                com.baidu.live.d.Aq().remove("ala_person_ala_entrance_same_live_room");
                return;
            }
            this.aEH.setCurrentItem(0);
            return;
        }
        this.aEH.setCurrentItem(0);
    }

    public void setData(List<d> list) {
        setData(list, false);
    }

    public void setCurrentIndex(int i) {
        if (this.aEH != null) {
            this.aEH.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<d> list) {
        for (d dVar : list) {
            c cVar = new c(getContext(), dVar.getTitle());
            cVar.setOnClickListener(this.aEY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aEQ != -1) {
                layoutParams.gravity = this.aEQ;
            }
            a(cVar.CA(), false, this.mSkinType);
            a((TextView) cVar.CA(), false);
            this.aEG.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i) {
        if (gradientTextView != null) {
            if (!z) {
                if (this.aEL == getResources().getColor(a.c.sdk_color_727272)) {
                    SkinManager.setViewTextColor(gradientTextView, a.c.sdk_color_727272, 1, i);
                } else {
                    gradientTextView.setGradientTextColor(this.aEL, this.aEL);
                }
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
                a(((c) childAt).CA(), i == this.mCurrentTabIndex, this.mSkinType);
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
                paddingLeft = this.aEG.getLeft() + cVar.getLeft() + cVar.CA().getLeft();
                f = paddingLeft + cVar.CA().getWidth();
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aEG.getChildCount() - 1) {
                    c cVar2 = (c) this.aEG.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.CA().getLeft() + this.aEG.getLeft();
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.CA().getWidth() + left) * this.mCurrentPositionOffset) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aEG.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = paddingLeft + this.mIndicatorWidth;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aEG.getChildCount() - 1) {
                    View childAt = this.aEG.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aEG.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            }
            if (this.aET) {
                if (this.aEP) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
                if (this.aEO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aEF.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                if (this.aEP) {
                    this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aEO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aEF.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.aEP) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aEO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aEF.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (this.aEP) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aEO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aEF.getWidth(), height, this.mRectPaint);
                }
            } else {
                if (this.aEP) {
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aEO) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aEF.getWidth(), height, this.mRectPaint);
                }
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
            if (this.aEW != null) {
                this.aEW.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aEU, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aEW != null) {
                this.aEW.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aEU, this.mCurrentTabIndex));
            }
        }
        if (this.aEX != null) {
            this.aEX.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aEG.getChildCount() != 0 && this.aEH != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.mSelectorColor = SkinManager.getColor(i, a.c.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(i, a.c.sdk_cp_bg_line_c);
        if (!ListUtils.isEmpty(this.aEU)) {
            for (d dVar : this.aEU) {
                if (dVar != null) {
                    dVar.onChangeSkinType(i);
                }
            }
        }
        this.aEI.onChangeSkinType(i);
    }

    public void enterForeground() {
        this.aEI.Cx();
    }

    public void setOnPageChangeListener(a aVar) {
        this.aEW = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aEX = bVar;
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

    public void setmIsYuyinLive(boolean z) {
        this.aET = z;
    }
}
