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
import com.baidu.live.liveroom.c.d;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private static final int UC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds60);
    private static final int UD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
    private FrameLayout UE;
    private LinearLayout UF;
    private CustomViewPager UG;
    private AlaAudienceLiveRoomBottomPanelAdapter UH;
    private float UJ;
    private float UK;
    private int UL;
    private float UM;
    private boolean UN;
    private boolean UO;
    private int UQ;
    private List<d> UR;
    private boolean US;
    private a UT;
    private b UU;
    private View.OnClickListener UV;
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

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, d dVar);
    }

    /* loaded from: classes2.dex */
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
        this.UV = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.UF.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.UG != null) {
                        AlaLiveRoomPanelTabHost.this.UG.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        ay(context);
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
        this.UV = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.UF.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.UG != null) {
                        AlaLiveRoomPanelTabHost.this.UG.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void ay(Context context) {
        this.UJ = getResources().getDimensionPixelOffset(a.e.sdk_ds80);
        this.UK = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.UL = getResources().getColor(a.d.sdk_color_727272);
        this.UM = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.UN = true;
        this.UO = true;
        this.UQ = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.UJ = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        this.UK = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.UL = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_727272));
        this.UM = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.UN = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.UO = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.UQ = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.UE = new FrameLayout(getContext());
        this.UE.setClickable(true);
        addView(this.UE, new LinearLayout.LayoutParams(-1, (int) this.UJ));
        this.UF = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.UE.addView(this.UF, layoutParams);
        this.UG = new CustomViewPager(getContext());
        this.UG.setOnPageChangeListener(this);
        addView(this.UG);
        this.UH = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.UG.setAdapter(this.UH);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list, boolean z) {
        this.UR = list;
        l(list);
        this.UH.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaLiveRoomPanelTabHost.this.mCurrentTabIndex = AlaLiveRoomPanelTabHost.this.UG.getCurrentItem();
            }
        });
        if (z) {
            int i = com.baidu.live.c.oJ().getInt("ala_live_room_tab_id", -1);
            if (com.baidu.live.c.oJ().getBoolean("ala_person_ala_entrance_same_live_room", false) && i >= 0 && i < this.UH.getCount()) {
                this.UG.setCurrentItem(i);
                com.baidu.live.c.oJ().remove("ala_person_ala_entrance_same_live_room");
                return;
            }
            this.UG.setCurrentItem(0);
            return;
        }
        this.UG.setCurrentItem(0);
    }

    public void setData(List<d> list) {
        setData(list, false);
    }

    public void setCurrentIndex(int i) {
        if (this.UG != null) {
            this.UG.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void l(List<d> list) {
        for (d dVar : list) {
            c cVar = new c(getContext(), dVar.getTitle());
            cVar.setOnClickListener(this.UV);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.UQ != -1) {
                layoutParams.gravity = this.UQ;
            }
            a(cVar.oW(), false, this.mSkinType);
            a(cVar.oW(), false);
            this.UF.addView(cVar, layoutParams);
        }
    }

    private void a(TextView textView, boolean z, int i) {
        if (textView != null) {
            if (!z) {
                if (this.UL == getResources().getColor(a.d.sdk_color_727272)) {
                    SkinManager.setViewTextColor(textView, a.d.sdk_color_727272, 1, i);
                    return;
                } else {
                    textView.setTextColor(this.UL);
                    return;
                }
            }
            SkinManager.setViewTextColor(textView, a.d.sdk_color_ff174f, 1, i);
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.UK);
            } else {
                textView.setTextSize(0, this.UM);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.UF.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.UF.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).oW(), i == this.mCurrentTabIndex, this.mSkinType);
                a(((c) childAt).oW(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.US = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.UF.getChildCount() != 0) {
            int height = this.UE.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.UF.getChildAt(this.mCurrentTabIndex);
            if (this.US) {
                paddingLeft = this.UF.getLeft() + cVar.getLeft() + cVar.oW().getLeft();
                f = paddingLeft + cVar.oW().getWidth();
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.UF.getChildCount() - 1) {
                    c cVar2 = (c) this.UF.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.oW().getLeft() + this.UF.getLeft();
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.oW().getWidth() + left) * this.mCurrentPositionOffset) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.UF.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = paddingLeft + this.mIndicatorWidth;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.UF.getChildCount() - 1) {
                    View childAt = this.UF.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.UF.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            }
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (this.UO) {
                    this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.UN) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.UE.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (this.UO) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.UN) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.UE.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (this.UO) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.UN) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.UE.getWidth(), height, this.mRectPaint);
                }
            } else {
                if (this.UO) {
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.UN) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.UE.getWidth(), height, this.mRectPaint);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.UF.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.UT != null) {
                this.UT.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.UR, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.UT != null) {
                this.UT.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.UR, this.mCurrentTabIndex));
            }
        }
        if (this.UU != null) {
            this.UU.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.UF.getChildCount() != 0 && this.UG != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.mSelectorColor = SkinManager.getColor(i, a.d.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(i, a.d.sdk_cp_bg_line_c);
        if (!ListUtils.isEmpty(this.UR)) {
            for (d dVar : this.UR) {
                if (dVar != null) {
                    dVar.onChangeSkinType(i);
                }
            }
        }
        this.UH.onChangeSkinType(i);
    }

    public void enterForeground() {
        this.UH.oT();
    }

    public void setOnPageChangeListener(a aVar) {
        this.UT = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.UU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends FrameLayout {
        private TextView UX;

        public c(@NonNull Context context, String str) {
            super(context);
            cK(str);
        }

        private void cK(String str) {
            this.UX = new TextView(getContext());
            this.UX.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize34));
            this.UX.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.UX, layoutParams);
        }

        public TextView oW() {
            return this.UX;
        }
    }
}
