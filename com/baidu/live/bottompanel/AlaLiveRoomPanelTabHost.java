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
    private int aCA;
    private boolean aCB;
    private List<d> aCC;
    private boolean aCD;
    private a aCE;
    private b aCF;
    private View.OnClickListener aCG;
    private FrameLayout aCn;
    private LinearLayout aCo;
    private CustomViewPager aCp;
    private AlaAudienceLiveRoomBottomPanelAdapter aCq;
    private float aCr;
    private float aCs;
    private int aCt;
    private float aCu;
    private int aCv;
    private boolean aCw;
    private boolean aCx;
    private int aCy;
    private int aCz;
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
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mDividerHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds1);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aCG = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aCo.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aCp != null) {
                        AlaLiveRoomPanelTabHost.this.aCp.setCurrentItem(indexOfChild);
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
        this.aCG = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.aCo.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.aCp != null) {
                        AlaLiveRoomPanelTabHost.this.aCp.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void an(Context context) {
        this.aCr = getResources().getDimensionPixelOffset(a.e.sdk_ds80);
        this.aCs = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aCt = getResources().getColor(a.d.sdk_color_727272);
        this.aCu = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.aCw = true;
        this.aCx = true;
        this.aCy = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aCr = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        this.aCs = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aCt = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_727272));
        this.aCu = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.aCv = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.sdk_color_ff174f));
        this.aCw = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.aCx = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.aCy = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aCz = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aCA = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aCn = new FrameLayout(getContext());
        this.aCn.setClickable(true);
        addView(this.aCn, new LinearLayout.LayoutParams(-1, (int) this.aCr));
        this.aCo = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.aCn.addView(this.aCo, layoutParams);
        this.aCp = new CustomViewPager(getContext());
        this.aCp.setOnPageChangeListener(this);
        addView(this.aCp);
        this.aCq = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.aCp.setAdapter(this.aCq);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list, boolean z) {
        this.aCC = list;
        u(list);
        this.aCq.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaLiveRoomPanelTabHost.this.mCurrentTabIndex = AlaLiveRoomPanelTabHost.this.aCp.getCurrentItem();
            }
        });
        if (z) {
            int i = com.baidu.live.c.AR().getInt("ala_live_room_tab_id", -1);
            if (com.baidu.live.c.AR().getBoolean("ala_person_ala_entrance_same_live_room", false) && i >= 0 && i < this.aCq.getCount()) {
                this.aCp.setCurrentItem(i);
                com.baidu.live.c.AR().remove("ala_person_ala_entrance_same_live_room");
                return;
            }
            this.aCp.setCurrentItem(0);
            return;
        }
        this.aCp.setCurrentItem(0);
    }

    public void setData(List<d> list) {
        setData(list, false);
    }

    public void setCurrentIndex(int i) {
        if (this.aCp != null) {
            this.aCp.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void u(List<d> list) {
        for (d dVar : list) {
            c cVar = new c(getContext(), dVar.getTitle());
            cVar.setOnClickListener(this.aCG);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.aCy != -1) {
                layoutParams.gravity = this.aCy;
            }
            a(cVar.BN(), false, this.mSkinType);
            a((TextView) cVar.BN(), false);
            this.aCo.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z, int i) {
        if (gradientTextView != null) {
            if (!z) {
                if (this.aCt == getResources().getColor(a.d.sdk_color_727272)) {
                    SkinManager.setViewTextColor(gradientTextView, a.d.sdk_color_727272, 1, i);
                } else {
                    gradientTextView.setGradientTextColor(this.aCt, this.aCt);
                }
            } else if (this.aCz != 0 || this.aCA != 0) {
                gradientTextView.setGradientTextColor(this.aCz, this.aCA);
            } else {
                gradientTextView.setGradientTextColor(this.aCv, this.aCv);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aCs);
            } else {
                textView.setTextSize(0, this.aCu);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aCo.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aCo.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).BN(), i == this.mCurrentTabIndex, this.mSkinType);
                a(((c) childAt).BN(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.aCD = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.aCo.getChildCount() != 0) {
            int height = this.aCn.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.aCo.getChildAt(this.mCurrentTabIndex);
            if (this.aCD) {
                paddingLeft = this.aCo.getLeft() + cVar.getLeft() + cVar.BN().getLeft();
                f = paddingLeft + cVar.BN().getWidth();
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aCo.getChildCount() - 1) {
                    c cVar2 = (c) this.aCo.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.BN().getLeft() + this.aCo.getLeft();
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.BN().getWidth() + left) * this.mCurrentPositionOffset) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.aCo.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = paddingLeft + this.mIndicatorWidth;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.aCo.getChildCount() - 1) {
                    View childAt = this.aCo.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.aCo.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            }
            if (this.aCB) {
                if (this.aCx) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_ff1e66));
                    canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 20.0f, 20.0f, this.mRectPaint);
                }
                if (this.aCw) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aCn.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                if (this.aCx) {
                    this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aCw) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aCn.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (this.aCx) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aCw) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aCn.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (this.aCx) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aCw) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aCn.getWidth(), height, this.mRectPaint);
                }
            } else {
                if (this.aCx) {
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.aCw) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.aCn.getWidth(), height, this.mRectPaint);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aCo.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.aCE != null) {
                this.aCE.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aCC, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.aCE != null) {
                this.aCE.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.aCC, this.mCurrentTabIndex));
            }
        }
        if (this.aCF != null) {
            this.aCF.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aCo.getChildCount() != 0 && this.aCp != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.mSelectorColor = SkinManager.getColor(i, a.d.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(i, a.d.sdk_cp_bg_line_c);
        if (!ListUtils.isEmpty(this.aCC)) {
            for (d dVar : this.aCC) {
                if (dVar != null) {
                    dVar.onChangeSkinType(i);
                }
            }
        }
        this.aCq.onChangeSkinType(i);
    }

    public void enterForeground() {
        this.aCq.BK();
    }

    public void setOnPageChangeListener(a aVar) {
        this.aCE = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.aCF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aCI;

        public c(@NonNull Context context, String str) {
            super(context);
            fM(str);
        }

        private void fM(String str) {
            this.aCI = new GradientTextView(getContext());
            this.aCI.setCheckStrEquals(false);
            this.aCI.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize34));
            if (this.aCI != null) {
                this.aCI.getPaint().setFakeBoldText(true);
            }
            this.aCI.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aCI, layoutParams);
        }

        public GradientTextView BN() {
            return this.aCI;
        }
    }

    public void setTabWidgetBg(int i) {
        if (this.aCn != null) {
            this.aCn.setBackgroundResource(i);
        }
    }

    public void setViewPagerBg(int i) {
        if (this.aCp != null) {
            this.aCp.setBackgroundResource(i);
        }
    }

    public void setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }

    public void setmIsYuyinLive(boolean z) {
        this.aCB = z;
    }
}
