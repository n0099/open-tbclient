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
import com.baidu.live.k.a;
import com.baidu.live.liveroom.c.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaLiveRoomPanelTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private static final int No = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds60);
    private static final int Np = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
    private int NB;
    private List<d> NC;
    private boolean ND;
    private a NE;
    private b NF;
    private View.OnClickListener NG;
    private FrameLayout Nq;
    private LinearLayout Nr;
    private CustomViewPager Ns;
    private AlaAudienceLiveRoomBottomPanelAdapter Nt;
    private float Nu;
    private float Nv;
    private int Nw;
    private float Nx;
    private boolean Ny;
    private boolean Nz;
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

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, d dVar);
    }

    /* loaded from: classes6.dex */
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
        this.NG = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.Nr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.Ns != null) {
                        AlaLiveRoomPanelTabHost.this.Ns.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        ap(context);
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
        this.NG = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaLiveRoomPanelTabHost.this.Nr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaLiveRoomPanelTabHost.this.mIsClicked = true;
                    if (AlaLiveRoomPanelTabHost.this.Ns != null) {
                        AlaLiveRoomPanelTabHost.this.Ns.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void ap(Context context) {
        this.Nu = getResources().getDimensionPixelOffset(a.e.sdk_ds80);
        this.Nv = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.Nw = getResources().getColor(a.d.sdk_color_727272);
        this.Nx = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.Ny = true;
        this.Nz = true;
        this.NB = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.Nu = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        this.Nv = getResources().getDimensionPixelOffset(a.e.sdk_fontsize34);
        this.Nw = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_727272));
        this.Nx = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize34));
        this.Ny = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_dividerShow, true);
        this.Nz = obtainStyledAttributes.getBoolean(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_indicatorShow, true);
        this.NB = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.Nq = new FrameLayout(getContext());
        this.Nq.setClickable(true);
        addView(this.Nq, new LinearLayout.LayoutParams(-1, (int) this.Nu));
        this.Nr = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.Nq.addView(this.Nr, layoutParams);
        this.Ns = new CustomViewPager(getContext());
        this.Ns.setOnPageChangeListener(this);
        addView(this.Ns);
        this.Nt = new AlaAudienceLiveRoomBottomPanelAdapter();
        this.Ns.setAdapter(this.Nt);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<d> list, boolean z) {
        this.NC = list;
        m(list);
        this.Nt.setData(list);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AlaLiveRoomPanelTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AlaLiveRoomPanelTabHost.this.mCurrentTabIndex = AlaLiveRoomPanelTabHost.this.Ns.getCurrentItem();
            }
        });
        if (z) {
            int i = com.baidu.live.c.np().getInt("ala_live_room_tab_id", -1);
            if (com.baidu.live.c.np().getBoolean("ala_person_ala_entrance_same_live_room", false) && i >= 0 && i < this.Nt.getCount()) {
                this.Ns.setCurrentItem(i);
                com.baidu.live.c.np().remove("ala_person_ala_entrance_same_live_room");
                return;
            }
            this.Ns.setCurrentItem(0);
            return;
        }
        this.Ns.setCurrentItem(0);
    }

    public void setData(List<d> list) {
        setData(list, false);
    }

    public void setCurrentIndex(int i) {
        if (this.Ns != null) {
            this.Ns.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void m(List<d> list) {
        for (d dVar : list) {
            c cVar = new c(getContext(), dVar.getTitle());
            cVar.setOnClickListener(this.NG);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (this.NB != -1) {
                layoutParams.gravity = this.NB;
            }
            a(cVar.nx(), false, this.mSkinType);
            a(cVar.nx(), false);
            this.Nr.addView(cVar, layoutParams);
        }
    }

    private void a(TextView textView, boolean z, int i) {
        if (textView != null) {
            if (!z) {
                if (this.Nw == getResources().getColor(a.d.sdk_color_727272)) {
                    SkinManager.setViewTextColor(textView, a.d.sdk_color_727272, 1, i);
                    return;
                } else {
                    textView.setTextColor(this.Nw);
                    return;
                }
            }
            SkinManager.setViewTextColor(textView, a.d.sdk_color_ff174f, 1, i);
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.Nv);
            } else {
                textView.setTextSize(0, this.Nx);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.Nr.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.Nr.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).nx(), i == this.mCurrentTabIndex, this.mSkinType);
                a(((c) childAt).nx(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    public void setIndicatorWidthAuto(boolean z) {
        this.ND = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft;
        float f;
        super.dispatchDraw(canvas);
        if (!isInEditMode() && this.Nr.getChildCount() != 0) {
            int height = this.Nq.getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            c cVar = (c) this.Nr.getChildAt(this.mCurrentTabIndex);
            if (this.ND) {
                paddingLeft = this.Nr.getLeft() + cVar.getLeft() + cVar.nx().getLeft();
                f = paddingLeft + cVar.nx().getWidth();
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.Nr.getChildCount() - 1) {
                    c cVar2 = (c) this.Nr.getChildAt(this.mCurrentTabIndex + 1);
                    float left = cVar2.getLeft() + cVar2.nx().getLeft() + this.Nr.getLeft();
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (left * this.mCurrentPositionOffset);
                    f = ((cVar2.nx().getWidth() + left) * this.mCurrentPositionOffset) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            } else {
                paddingLeft = cVar.getPaddingLeft() + this.Nr.getLeft() + cVar.getLeft() + ((((cVar.getWidth() - cVar.getPaddingLeft()) - cVar.getPaddingRight()) - this.mIndicatorWidth) / 2);
                f = paddingLeft + this.mIndicatorWidth;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.Nr.getChildCount() - 1) {
                    View childAt = this.Nr.getChildAt(this.mCurrentTabIndex + 1);
                    float paddingLeft2 = childAt.getPaddingLeft() + childAt.getLeft() + this.Nr.getLeft() + ((((childAt.getWidth() - childAt.getPaddingRight()) - childAt.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                    paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                    f = (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2)) + ((1.0f - this.mCurrentPositionOffset) * f);
                }
            }
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (this.Nz) {
                    this.mRectPaint.setShader(new LinearGradient(paddingLeft, height - this.mIndicatorHeight, f, height, TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.Ny) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    this.mRectPaint.setShader(null);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.Nq.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (this.Nz) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.Ny) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.Nq.getWidth(), height, this.mRectPaint);
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (this.Nz) {
                    this.mRectPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
                    canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                }
                if (this.Ny) {
                    this.mRectPaint.setColor(this.mDividerColor);
                    canvas.drawRect(0.0f, height - this.mDividerHeight, this.Nq.getWidth(), height, this.mRectPaint);
                }
            } else {
                canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
                this.mRectPaint.setColor(this.mDividerColor);
                canvas.drawRect(0.0f, height - this.mDividerHeight, this.Nq.getWidth(), height, this.mRectPaint);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.Nr.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.NE != null) {
                this.NE.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.NC, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.NE != null) {
                this.NE.a(this.mCurrentTabIndex, (d) ListUtils.getItem(this.NC, this.mCurrentTabIndex));
            }
        }
        if (this.NF != null) {
            this.NF.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.Nr.getChildCount() != 0 && this.Ns != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.mSelectorColor = SkinManager.getColor(i, a.d.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(i, a.d.sdk_cp_bg_line_c);
        if (!ListUtils.isEmpty(this.NC)) {
            for (d dVar : this.NC) {
                if (dVar != null) {
                    dVar.onChangeSkinType(i);
                }
            }
        }
        this.Nt.onChangeSkinType(i);
    }

    public void enterForeground() {
        this.Nt.nt();
    }

    public void setOnPageChangeListener(a aVar) {
        this.NE = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.NF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c extends FrameLayout {
        private TextView NI;

        public c(@NonNull Context context, String str) {
            super(context);
            bS(str);
        }

        private void bS(String str) {
            this.NI = new TextView(getContext());
            this.NI.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize34));
            this.NI.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.NI, layoutParams);
        }

        public TextView nx() {
            return this.NI;
        }
    }
}
