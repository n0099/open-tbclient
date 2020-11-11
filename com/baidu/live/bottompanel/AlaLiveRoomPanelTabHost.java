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
    private boolean aGA;
    private int aGB;
    private int aGC;
    private int aGD;
    private boolean aGE;
    private List<d> aGF;
    private boolean aGG;
    private a aGH;
    private b aGI;
    private View.OnClickListener aGJ;
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
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aGs != null) {
                        AlaLiveRoomPanelTabHost.this.aGs.setCurrentItem(indexOfChild);
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
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aGs != null) {
                        AlaLiveRoomPanelTabHost.this.aGs.setCurrentItem(indexOfChild);
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

    public void setData(List<d> list, boolean z) {
        this.aGF = list;
        w(list);
        this.aGt.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaLiveRoomPanelTabHost.this.mCurrentTabIndex = AlaLiveRoomPanelTabHost.this.aGs.getCurrentItem();
            }
        });
        if (z) {
            int i = com.baidu.live.d.AZ().getInt("ala_live_room_tab_id", -1);
            if (com.baidu.live.d.AZ().getBoolean("ala_person_ala_entrance_same_live_room", false) && i >= 0 && i < this.aGt.getCount()) {
                this.aGs.setCurrentItem(i);
                com.baidu.live.d.AZ().remove("ala_person_ala_entrance_same_live_room");
                return;
            }
            this.aGs.setCurrentItem(0);
            return;
        }
        this.aGs.setCurrentItem(0);
    }

    public void setData(List<d> list) {
        setData(list, false);
    }

    public void setCurrentIndex(int i) {
        if (this.aGs != null) {
            this.aGs.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<d> list) {
        for (d dVar : list) {
            c cVar = new c(getContext(), dVar.getTitle());
            cVar.setOnClickListener(this.aGJ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aGB != -1) {
                layoutParams.gravity = this.aGB;
            }
            a(cVar.Dj(), false, this.mSkinType);
            a((TextView) cVar.Dj(), false);
            this.aGr.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i) {
        if (gradientTextView != null) {
            if (!z) {
                if (this.aGw == getResources().getColor(a.c.sdk_color_727272)) {
                    SkinManager.setViewTextColor(gradientTextView, a.c.sdk_color_727272, 1, i);
                } else {
                    gradientTextView.setGradientTextColor(this.aGw, this.aGw);
                }
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
                a(((c) childAt).Dj(), i == this.mCurrentTabIndex, this.mSkinType);
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
                paddingLeft = this.aGr.getLeft() + cVar.getLeft() + cVar.Dj().getLeft();
                f = paddingLeft + cVar.Dj().getWidth();
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aGr.getChildCount() - 1) {
                    c cVar2 = (c) this.aGr.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.Dj().getLeft() + this.aGr.getLeft();
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.Dj().getWidth() + left) * this.mCurrentPositionOffset) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aGr.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = paddingLeft + this.mIndicatorWidth;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aGr.getChildCount() - 1) {
                    View childAt = this.aGr.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aGr.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            }
            if (this.aGE) {
                if (this.aGA) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
                if (this.aGz) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGq.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                if (this.aGA) {
                    this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGz) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGq.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.aGA) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGz) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGq.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (this.aGA) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGz) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGq.getWidth(), height, this.mRectPaint);
                }
            } else {
                if (this.aGA) {
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGz) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGq.getWidth(), height, this.mRectPaint);
                }
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
            if (this.aGH != null) {
                this.aGH.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aGH != null) {
                this.aGH.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
        if (this.aGI != null) {
            this.aGI.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGr.getChildCount() != 0 && this.aGs != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.mSelectorColor = SkinManager.getColor(i, a.c.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(i, a.c.sdk_cp_bg_line_c);
        if (!ListUtils.isEmpty(this.aGF)) {
            for (d dVar : this.aGF) {
                if (dVar != null) {
                    dVar.onChangeSkinType(i);
                }
            }
        }
        this.aGt.onChangeSkinType(i);
    }

    public void enterForeground() {
        this.aGt.Dg();
    }

    public void setOnPageChangeListener(a aVar) {
        this.aGH = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aGI = bVar;
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

    public void setmIsYuyinLive(boolean z) {
        this.aGE = z;
    }
}
