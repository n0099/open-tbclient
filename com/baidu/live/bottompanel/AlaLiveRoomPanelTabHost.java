package com.baidu.live.bottompanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.tieba.view.GradientTextView;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private boolean aGc;
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
    private boolean aGr;
    private List<d> aGs;
    private boolean aGt;
    private a aGu;
    private b aGv;
    private View.OnClickListener aGw;
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

    public AlaLiveRoomPanelTabHost(Context context) {
        super(context);
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.aGc = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGw = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aGf != null) {
                        AlaLiveRoomPanelTabHost.this.aGf.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aQ(context);
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
        this.aGc = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGw = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aGf != null) {
                        AlaLiveRoomPanelTabHost.this.aGf.setCurrentItem(indexOfChild);
                    }
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
        this.aGf = new CustomViewPager(getContext());
        this.aGf.setOnPageChangeListener(this);
        addView(this.aGf);
        this.aGg = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aGf.setAdapter(this.aGg);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list, boolean z) {
        if (list != null && list.size() < 2) {
            this.aGn = false;
        }
        this.aGs = list;
        x(list);
        this.aGg.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaLiveRoomPanelTabHost.this.mCurrentTabIndex = AlaLiveRoomPanelTabHost.this.aGf.getCurrentItem();
            }
        });
        if (z) {
            int i = com.baidu.live.d.xf().getInt("ala_live_room_tab_id", -1);
            if (com.baidu.live.d.xf().getBoolean("ala_person_ala_entrance_same_live_room", false) && i >= 0 && i < this.aGg.getCount()) {
                this.aGf.setCurrentItem(i);
                com.baidu.live.d.xf().remove("ala_person_ala_entrance_same_live_room");
                return;
            }
            this.aGf.setCurrentItem(0);
            return;
        }
        this.aGf.setCurrentItem(0);
    }

    public void setData(List<d> list) {
        setData(list, false);
    }

    public void setCurrentIndex(int i) {
        if (this.aGf != null) {
            this.aGf.setCurrentItem(i);
        }
        updateTabStyles();
    }

    public void setIndicatorShow(boolean z) {
        this.aGn = z;
        updateTabStyles();
    }

    private void x(List<d> list) {
        for (d dVar : list) {
            c cVar = new c(getContext(), dVar.getTitle());
            cVar.setOnClickListener(this.aGw);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aGo != -1) {
                layoutParams.gravity = this.aGo;
            }
            a(cVar.Ar(), false, this.mSkinType);
            a((TextView) cVar.Ar(), false);
            this.aGe.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i) {
        if (gradientTextView != null) {
            if (!z) {
                if (this.aGj == getResources().getColor(a.c.sdk_color_727272)) {
                    SkinManager.setViewTextColor(gradientTextView, a.c.sdk_color_727272, 1, i);
                } else {
                    gradientTextView.setGradientTextColor(this.aGj, this.aGj);
                }
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

    private void updateTabStyles() {
        int childCount = this.aGe.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aGe.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Ar(), i == this.mCurrentTabIndex, this.mSkinType);
                a(((c) childAt).Ar(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aGt = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aGe.getChildCount() != 0) {
            int height = this.aGd.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aGe.getChildAt(this.mCurrentTabIndex);
            if (this.aGt) {
                paddingLeft = this.aGe.getLeft() + cVar.getLeft() + cVar.Ar().getLeft();
                f = paddingLeft + cVar.Ar().getWidth();
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aGe.getChildCount() - 1) {
                    c cVar2 = (c) this.aGe.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.Ar().getLeft() + this.aGe.getLeft();
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.Ar().getWidth() + left) * this.mCurrentPositionOffset) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aGe.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = paddingLeft + this.mIndicatorWidth;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aGe.getChildCount() - 1) {
                    View childAt = this.aGe.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aGe.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            }
            if (this.aGr) {
                if (this.aGn) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
                if (this.aGm) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGd.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                if (this.aGn) {
                    this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGm) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGd.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.aGn) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGm) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGd.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (this.aGn) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGm) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGd.getWidth(), height, this.mRectPaint);
                }
            } else {
                if (this.aGn) {
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aGm) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aGd.getWidth(), height, this.mRectPaint);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aGe.getChildCount() != 0) {
            if (!this.mIsClicked || this.aGc) {
                this.mCurrentTabIndex = i;
                this.mCurrentPositionOffset = f;
                updateTabStyles();
                invalidate();
                if (this.aGu != null) {
                    this.aGu.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aGu != null) {
                this.aGu.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
            }
        }
        if (this.aGv != null) {
            this.aGv.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGe.getChildCount() != 0 && this.aGf != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.mSelectorColor = SkinManager.getColor(i, a.c.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(i, a.c.sdk_cp_bg_line_c);
        if (!ListUtils.isEmpty(this.aGs)) {
            for (d dVar : this.aGs) {
                if (dVar != null) {
                    dVar.onChangeSkinType(i);
                }
            }
        }
        this.aGg.onChangeSkinType(i);
    }

    public void enterForeground() {
        this.aGg.Ao();
    }

    public void setOnPageChangeListener(a aVar) {
        this.aGu = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aGv = bVar;
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

    public void setmIsYuyinLive(boolean z) {
        this.aGr = z;
    }

    public void setIsIndicatorFollow(boolean z) {
        this.aGc = z;
    }
}
