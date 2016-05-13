package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class NavigationBar extends RelativeLayout {
    private static final int ID_STATEBAR_FILL_VIEW = 1;
    private View barBgView;
    private View bottomLine;
    private int containerWidth;
    private boolean isAutoNight;
    private boolean isFixedHeight;
    private boolean isNeedAddStatusBarHeight;
    private ImageView mBackImageView;
    private int mBackImagedeepResId;
    private int mBackImagelightResId;
    private LinearLayout mCenterBox;
    private ImageView mCenterIcon;
    private LinearLayout mCenterImgBox;
    private boolean mClickIsVaild;
    private Activity mCurrentActivity;
    private LinearLayout mLeftBox;
    private View.OnClickListener mLoginListener;
    private TextView mLoginView;
    private final View.OnClickListener mOnClickListener;
    private View.OnClickListener mRegisterListener;
    private TextView mRegisterView;
    private LinearLayout mRightBox;
    private View mRootView;
    public TextView mTextTitle;
    private View mUnloginView;

    /* loaded from: classes.dex */
    public enum ControlAlign {
        HORIZONTAL_LEFT,
        HORIZONTAL_CENTER,
        HORIZONTAL_RIGHT;

        /* JADX DEBUG: Replace access to removed values field (abj) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ControlAlign[] valuesCustom() {
            ControlAlign[] valuesCustom = values();
            int length = valuesCustom.length;
            ControlAlign[] controlAlignArr = new ControlAlign[length];
            System.arraycopy(valuesCustom, 0, controlAlignArr, 0, length);
            return controlAlignArr;
        }
    }

    /* loaded from: classes.dex */
    public enum ControlType {
        BACK_BUTTON;

        /* JADX DEBUG: Replace access to removed values field (abk) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ControlType[] valuesCustom() {
            ControlType[] valuesCustom = values();
            int length = valuesCustom.length;
            ControlType[] controlTypeArr = new ControlType[length];
            System.arraycopy(valuesCustom, 0, controlTypeArr, 0, length);
            return controlTypeArr;
        }
    }

    public NavigationBar(Context context) {
        super(context);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.containerWidth = 0;
        this.mOnClickListener = new o(this);
        init(context, null);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.containerWidth = 0;
        this.mOnClickListener = new o(this);
        init(context, attributeSet);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.containerWidth = 0;
        this.mOnClickListener = new o(this);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        boolean z;
        this.mCurrentActivity = (Activity) context;
        this.mRootView = LayoutInflater.from(context).inflate(t.h.widget_navigation_bar, (ViewGroup) this, true);
        this.mLeftBox = (LinearLayout) this.mRootView.findViewById(t.g.leftBox);
        this.mCenterBox = (LinearLayout) this.mRootView.findViewById(t.g.centerBox);
        this.mRightBox = (LinearLayout) this.mRootView.findViewById(t.g.rightBox);
        this.mCenterImgBox = (LinearLayout) this.mRootView.findViewById(t.g.center_img_box);
        this.mCenterIcon = (ImageView) this.mRootView.findViewById(t.g.center_img);
        this.bottomLine = this.mRootView.findViewById(t.g.bottom_line);
        this.barBgView = this.mRootView.findViewById(t.g.navigation_bar_view_bg);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.NavigationBar);
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        this.isNeedAddStatusBarHeight = z && UtilHelper.canUseStyleImmersiveSticky();
        if (this.isNeedAddStatusBarHeight) {
            addView(createStateBarFillView());
            ((RelativeLayout.LayoutParams) this.mLeftBox.getLayoutParams()).addRule(3, 1);
            ((RelativeLayout.LayoutParams) this.mCenterBox.getLayoutParams()).addRule(3, 1);
            ((RelativeLayout.LayoutParams) this.mRightBox.getLayoutParams()).addRule(3, 1);
            ((RelativeLayout.LayoutParams) this.mCenterImgBox.getLayoutParams()).addRule(3, 1);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setGravity(48);
        initPadding();
        switchNaviBarStatus(true);
        this.mRootView.setOnClickListener(new p(this));
    }

    public void showNavigationBarExcludeStatusbar(boolean z) {
        if (z) {
            this.mLeftBox.setVisibility(0);
            this.mCenterBox.setVisibility(0);
            this.mRightBox.setVisibility(0);
            return;
        }
        this.mLeftBox.setVisibility(8);
        this.mCenterBox.setVisibility(8);
        this.mRightBox.setVisibility(8);
    }

    public boolean isNavigationBarExcludeStatusbarVisible() {
        return this.mLeftBox.getVisibility() == 0 || this.mCenterBox.getVisibility() == 0 || this.mRightBox.getVisibility() == 0;
    }

    private View createStateBarFillView() {
        View view = new View(getContext());
        view.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight());
        layoutParams.addRule(10, -1);
        view.setLayoutParams(layoutParams);
        return view;
    }

    public void switchNaviBarStatus(boolean z) {
        if (z) {
            this.mLeftBox.setVisibility(0);
            this.mCenterBox.setVisibility(0);
            this.mRightBox.setVisibility(0);
            if (this.mUnloginView != null) {
                this.mUnloginView.setVisibility(8);
                return;
            }
            return;
        }
        initUnloginView();
        this.mLeftBox.setVisibility(8);
        this.mCenterBox.setVisibility(8);
        this.mRightBox.setVisibility(8);
        this.mUnloginView.setVisibility(0);
    }

    private void initUnloginView() {
        if (this.mUnloginView == null) {
            this.mUnloginView = ((ViewStub) this.mRootView.findViewById(t.g.unlogin_view_stub)).inflate();
            this.mRegisterView = (TextView) this.mUnloginView.findViewById(t.g.top_navi_register);
            this.mLoginView = (TextView) this.mUnloginView.findViewById(t.g.top_navi_login);
            this.mLoginView.setOnClickListener(this.mLoginListener);
            this.mRegisterView.setOnClickListener(this.mRegisterListener);
        }
    }

    public void setLoginClickListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
        if (this.mLoginView != null) {
            this.mLoginView.setOnClickListener(onClickListener);
        }
    }

    public void setRegisterClickListener(View.OnClickListener onClickListener) {
        this.mRegisterListener = onClickListener;
        if (this.mRegisterView != null) {
            this.mRegisterView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPadding() {
        setPadding(com.baidu.adp.lib.util.k.dip2px(this.mCurrentActivity, getResources().getDimension(t.e.navi_padding_left)), com.baidu.adp.lib.util.k.dip2px(this.mCurrentActivity, getResources().getDimension(t.e.navi_padding_top)), com.baidu.adp.lib.util.k.dip2px(this.mCurrentActivity, getResources().getDimension(t.e.navi_padding_right)), com.baidu.adp.lib.util.k.dip2px(this.mCurrentActivity, getResources().getDimension(t.e.navi_padding_bottom)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.isFixedHeight) {
            i2 = View.MeasureSpec.makeMeasureSpec(com.baidu.adp.lib.util.k.c(getContext(), t.e.ds98), View.MeasureSpec.getMode(i2));
        }
        if (this.isNeedAddStatusBarHeight) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) + UtilHelper.getStatusBarHeight(), View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
        this.containerWidth = View.MeasureSpec.getSize(i);
        int measuredWidth = this.mLeftBox.getMeasuredWidth() + getPaddingLeft();
        this.mCenterBox.measure(((this.containerWidth - measuredWidth) - (this.mRightBox.getMeasuredWidth() + getPaddingRight())) + 1073741824, this.mCenterBox.getMeasuredHeight() + 1073741824);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mCenterBox.layout(this.mLeftBox.getMeasuredWidth() + getPaddingLeft(), this.mCenterBox.getTop(), this.containerWidth - (this.mRightBox.getMeasuredWidth() + getPaddingRight()), this.mCenterBox.getBottom());
    }

    public TextView setTitleText(String str) {
        if (this.mTextTitle == null) {
            this.mTextTitle = (TextView) getViewFromLayoutFile(t.h.widget_nb_item_title);
            getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
        }
        this.mTextTitle.setText(str);
        return this.mTextTitle;
    }

    public TextView setTitleText(String str, float f) {
        if (this.mTextTitle == null) {
            this.mTextTitle = (TextView) getViewFromLayoutFile(t.h.widget_nb_item_title);
            this.mTextTitle.setTextSize(0, f);
            getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
        }
        this.mTextTitle.setText(str);
        return this.mTextTitle;
    }

    public TextView setTitleText(int i) {
        return setTitleText(this.mCurrentActivity.getString(i));
    }

    public View setTitleView(View view, View.OnClickListener onClickListener) {
        return addCustomView(ControlAlign.HORIZONTAL_CENTER, view, onClickListener);
    }

    public boolean isFixedHeight() {
        return this.isFixedHeight;
    }

    public void setFixedHeight(boolean z) {
        this.isFixedHeight = z;
    }

    public View setTitleView(int i, View.OnClickListener onClickListener) {
        return addCustomView(ControlAlign.HORIZONTAL_CENTER, getViewFromLayoutFile(i), onClickListener);
    }

    public View getBarBgView() {
        return this.barBgView;
    }

    public View getBottomLine() {
        return this.bottomLine;
    }

    public View getCenterImgBox() {
        return this.mCenterIcon;
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType) {
        return addSystemImageButton(controlAlign, controlType, this.mOnClickListener);
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        LinearLayout linearLayout = null;
        if (controlType == ControlType.BACK_BUTTON && (linearLayout = (LinearLayout) findViewById(t.g.navigationBarGoBack)) == null) {
            linearLayout = (LinearLayout) getViewFromLayoutFile(t.h.widget_nb_item_back);
            this.mBackImageView = (ImageView) linearLayout.findViewById(t.g.widget_navi_back_button);
            this.mBackImageView.setContentDescription("返回");
            onBackBtnOnChangeSkin();
            if (linearLayout != null) {
                getViewGroup(controlAlign).addView(linearLayout);
                if (onClickListener != null) {
                    linearLayout.setOnClickListener(onClickListener);
                }
            }
        }
        return linearLayout;
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str) {
        TextView addTextButton = addTextButton(controlAlign, str, null);
        setDefTextButtonColor(addTextButton);
        return addTextButton;
    }

    public void setDefTextButtonColor(TextView textView) {
        com.baidu.tbadk.core.util.at.j((View) textView, t.d.navi_op_text);
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        TextView addTextButton = addTextButton(controlAlign, str, onClickListener, false);
        setDefTextButtonColor(addTextButton);
        return addTextButton;
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str, View.OnClickListener onClickListener, boolean z) {
        TextView addTextButton = addTextButton(controlAlign, str, onClickListener, z);
        setDefTextButtonColor(addTextButton);
        return addTextButton;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str) {
        return addTextButton(controlAlign, str, null);
    }

    public TextView addCreateGroupButton(ControlAlign controlAlign, View.OnClickListener onClickListener) {
        TextView textView = (TextView) getViewFromLayoutFile(t.h.widget_nb_item_create_group);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(t.e.navi_btn_margin_right);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
        }
        getViewGroup(controlAlign).addView(textView);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    public Button addRightButton(ControlAlign controlAlign, String str) {
        Button button = (Button) getViewFromLayoutFile(t.h.widget_nb_item_stepbtn);
        button.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(t.e.navi_btn_margin_right);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            button.setLayoutParams(layoutParams);
        }
        getViewGroup(controlAlign).addView(button);
        return button;
    }

    public void setSystemClickable(boolean z) {
        this.mClickIsVaild = z;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        return addTextButton(controlAlign, str, onClickListener, false);
    }

    public TextView addTextButton(ControlAlign controlAlign, String str, View.OnClickListener onClickListener, boolean z) {
        View viewFromLayoutFile = getViewFromLayoutFile(t.h.navigation_right_button_layout);
        TextView textView = (TextView) viewFromLayoutFile.findViewById(t.g.right_textview);
        textView.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(t.e.navi_btn_margin_right);
            if (z) {
                layoutParams.setMargins(dimension, dimension, dimension, dimension);
            } else {
                layoutParams.setMargins(dimension, dimension, 0, dimension);
            }
            textView.setLayoutParams(layoutParams);
        } else if (ControlAlign.HORIZONTAL_LEFT == controlAlign) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension2 = (int) getResources().getDimension(t.e.navi_btn_margin_right);
            if (z) {
                layoutParams2.setMargins(dimension2, dimension2, dimension2, dimension2);
            } else {
                layoutParams2.setMargins(dimension2, dimension2, 0, dimension2);
            }
            textView.setLayoutParams(layoutParams2);
        }
        getViewGroup(controlAlign).addView(viewFromLayoutFile);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    public void removeAllViews(ControlAlign controlAlign) {
        getViewGroup(controlAlign).removeAllViews();
    }

    public View addCustomView(ControlAlign controlAlign, View view, View.OnClickListener onClickListener) {
        getViewGroup(controlAlign).addView(view);
        if (onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
        if (controlAlign == ControlAlign.HORIZONTAL_CENTER) {
        }
        return view;
    }

    public View addCustomView(ControlAlign controlAlign, int i, View.OnClickListener onClickListener) {
        return addCustomView(controlAlign, getViewFromLayoutFile(i), onClickListener);
    }

    private ViewGroup getViewGroup(ControlAlign controlAlign) {
        if (controlAlign == ControlAlign.HORIZONTAL_LEFT) {
            return this.mLeftBox;
        }
        if (controlAlign == ControlAlign.HORIZONTAL_RIGHT) {
            return this.mRightBox;
        }
        return this.mCenterBox;
    }

    public void showBottomLine(boolean z) {
        this.bottomLine.setVisibility(z ? 0 : 8);
    }

    private View getViewFromLayoutFile(int i) {
        return LayoutInflater.from(this.mCurrentActivity).inflate(i, (ViewGroup) this, false);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        BitmapDrawable bitmapDrawable;
        if (this.isAutoNight) {
            bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.at.cA(t.f.s_navbar_bg));
        } else {
            bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.at.p(t.f.s_navbar_bg, i));
        }
        setBackgroundDrawable(bitmapDrawable);
        com.baidu.tbadk.core.util.at.e(this.bottomLine, t.d.cp_bg_line_a, i);
        onBackBtnOnChangeSkin(i);
        com.baidu.tbadk.core.util.at.b(this.mTextTitle, t.d.cp_cont_b, t.d.s_navbar_title_color);
        initPadding();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ae(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
    }

    public void onBackBtnOnChangeSkin() {
        onBackBtnOnChangeSkin(-1);
    }

    public void onBackBtnOnChangeSkin(int i) {
        if (i < 0) {
            i = TbadkCoreApplication.m11getInst().getSkinType();
        }
        if (this.mBackImagedeepResId > 0 && this.mBackImagelightResId > 0) {
            com.baidu.tbadk.core.util.at.a(this.mBackImageView, this.mBackImagedeepResId, this.mBackImagelightResId, i);
        } else {
            com.baidu.tbadk.core.util.at.a(this.mBackImageView, t.f.icon_return_bg_s, t.f.icon_return_bg, i);
        }
    }

    public ImageView getBackImageView() {
        return this.mBackImageView;
    }

    public void setmBackImageViewBg(int i, int i2) {
        this.mBackImagedeepResId = i;
        this.mBackImagelightResId = i2;
        com.baidu.tbadk.core.util.at.a(this.mBackImageView, this.mBackImagedeepResId, this.mBackImagelightResId);
    }

    public void release() {
        removeAllViews();
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }
}
