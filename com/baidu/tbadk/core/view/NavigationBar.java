package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBar extends RelativeLayout {
    private View barBgView;
    private int containerWidth;
    private boolean isAutoNight;
    private boolean isFixedHeight;
    private boolean isNeedAddStatusBarHeight;
    private LinearLayout mAbsoluteCenterBox;
    private ImageView mBackImageView;
    private int mBackImagedeepResId;
    private int mBackImagelightResId;
    private View mBottomLine;
    private int mBottomLineColor;
    private LinearLayout mCenterBox;
    private ImageView mCenterIcon;
    private LinearLayout mCenterImgBox;
    public TextView mCenterText;
    private boolean mClickIsVaild;
    private FrameLayout mContentLayout;
    private Activity mCurrentActivity;
    private int mFixedNavHeight;
    private LinearLayout mLeftBox;
    private View.OnClickListener mLoginListener;
    private TextView mLoginView;
    private ValueAnimator.AnimatorUpdateListener mNavAnimatorUpdateListener;
    private ValueAnimator mNavInAnimator;
    private boolean mNavIsShow;
    private ValueAnimator mNavOutAnimator;
    private final View.OnClickListener mOnClickListener;
    private View.OnClickListener mRegisterListener;
    private TextView mRegisterView;
    private LinearLayout mRightBox;
    private View mRootView;
    private View mStatusBarView;
    public TextView mTextTitle;
    private View mUnloginView;
    private View topCoverBgView;

    /* loaded from: classes.dex */
    public enum ControlAlign {
        HORIZONTAL_LEFT,
        HORIZONTAL_CENTER,
        HORIZONTAL_RIGHT,
        HORIZONTAL_ABSOLUTE_CENTER
    }

    /* loaded from: classes.dex */
    public enum ControlType {
        BACK_BUTTON
    }

    public int getFixedNavHeight() {
        return this.mFixedNavHeight;
    }

    public NavigationBar(Context context) {
        super(context);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = d.C0277d.cp_bg_line_c;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = NavigationBar.this.mContentLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = intValue;
                    NavigationBar.this.mContentLayout.setLayoutParams(layoutParams);
                }
            }
        };
        this.containerWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NavigationBar.this.mClickIsVaild) {
                    int id = view.getId();
                    if (id == d.g.navigationBarGoBack) {
                        NavigationBar.this.mCurrentActivity.finish();
                    } else if (id == d.g.navigationBarHome) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002004, NavigationBar.this.mCurrentActivity));
                    }
                }
            }
        };
        init(context, null);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = d.C0277d.cp_bg_line_c;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = NavigationBar.this.mContentLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = intValue;
                    NavigationBar.this.mContentLayout.setLayoutParams(layoutParams);
                }
            }
        };
        this.containerWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NavigationBar.this.mClickIsVaild) {
                    int id = view.getId();
                    if (id == d.g.navigationBarGoBack) {
                        NavigationBar.this.mCurrentActivity.finish();
                    } else if (id == d.g.navigationBarHome) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002004, NavigationBar.this.mCurrentActivity));
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = d.C0277d.cp_bg_line_c;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = NavigationBar.this.mContentLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = intValue;
                    NavigationBar.this.mContentLayout.setLayoutParams(layoutParams);
                }
            }
        };
        this.containerWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NavigationBar.this.mClickIsVaild) {
                    int id = view.getId();
                    if (id == d.g.navigationBarGoBack) {
                        NavigationBar.this.mCurrentActivity.finish();
                    } else if (id == d.g.navigationBarHome) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002004, NavigationBar.this.mCurrentActivity));
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    public void setStatusBarVisibility(int i) {
        if (this.mStatusBarView != null) {
            this.mStatusBarView.setVisibility(i);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        boolean z;
        this.mFixedNavHeight = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds94);
        this.mCurrentActivity = (Activity) context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.widget_navigation_bar, (ViewGroup) this, true);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(d.g.navigation_bar_content_layout);
        this.mLeftBox = (LinearLayout) this.mRootView.findViewById(d.g.leftBox);
        this.mCenterBox = (LinearLayout) this.mRootView.findViewById(d.g.centerBox);
        this.mRightBox = (LinearLayout) this.mRootView.findViewById(d.g.rightBox);
        this.mAbsoluteCenterBox = (LinearLayout) this.mRootView.findViewById(d.g.absoluteCenterBox);
        this.mCenterImgBox = (LinearLayout) this.mRootView.findViewById(d.g.center_img_box);
        this.mCenterIcon = (ImageView) this.mRootView.findViewById(d.g.center_img);
        this.mCenterText = (TextView) this.mRootView.findViewById(d.g.center_text);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        this.topCoverBgView = this.mRootView.findViewById(d.g.navigation_bar_view_cover_bg);
        this.topCoverBgView.setBackgroundDrawable(al.T(0, d.f.navigation_cover_top_bg));
        this.barBgView = this.mRootView.findViewById(d.g.navigation_bar_view_bg);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.NavigationBar);
            z = obtainStyledAttributes.getBoolean(d.l.NavigationBar_canSpread, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        this.isNeedAddStatusBarHeight = z && UtilHelper.canUseStyleImmersiveSticky();
        if (this.isNeedAddStatusBarHeight) {
            this.mStatusBarView = createStateBarFillView();
            addView(this.mStatusBarView);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
            layoutParams.addRule(3, this.mStatusBarView.getId());
            this.mContentLayout.setLayoutParams(layoutParams);
            this.mFixedNavHeight += UtilHelper.getStatusBarHeight();
        }
        setGravity(48);
        initPadding();
        switchNaviBarStatus(true);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mNavIsShow = true;
    }

    public void showNavigationBarExcludeStatusbar(boolean z) {
        if (z) {
            this.mLeftBox.setVisibility(0);
            this.mCenterBox.setVisibility(0);
            this.mRightBox.setVisibility(0);
            this.mAbsoluteCenterBox.setVisibility(0);
            return;
        }
        this.mLeftBox.setVisibility(8);
        this.mCenterBox.setVisibility(8);
        this.mRightBox.setVisibility(8);
        this.mAbsoluteCenterBox.setVisibility(8);
    }

    public boolean isNavigationBarExcludeStatusbarVisible() {
        return this.mLeftBox.getVisibility() == 0 || this.mCenterBox.getVisibility() == 0 || this.mRightBox.getVisibility() == 0;
    }

    private View createStateBarFillView() {
        View view = new View(getContext());
        view.setId(d.g.navigation_bar_status_bar);
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
            this.mAbsoluteCenterBox.setVisibility(0);
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
        this.mAbsoluteCenterBox.setVisibility(8);
        this.mUnloginView.setVisibility(0);
    }

    private void initUnloginView() {
        if (this.mUnloginView == null) {
            this.mUnloginView = ((ViewStub) this.mRootView.findViewById(d.g.unlogin_view_stub)).inflate();
            this.mRegisterView = (TextView) this.mUnloginView.findViewById(d.g.top_navi_register);
            this.mLoginView = (TextView) this.mUnloginView.findViewById(d.g.top_navi_login);
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
        setPadding(com.baidu.adp.lib.util.l.dip2px(this.mCurrentActivity, getResources().getDimension(d.e.ds0)), com.baidu.adp.lib.util.l.dip2px(this.mCurrentActivity, getResources().getDimension(d.e.ds0)), com.baidu.adp.lib.util.l.dip2px(this.mCurrentActivity, getResources().getDimension(d.e.ds0)), com.baidu.adp.lib.util.l.dip2px(this.mCurrentActivity, getResources().getDimension(d.e.ds0)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        if (this.isFixedHeight) {
            int mode = View.MeasureSpec.getMode(i2);
            int h = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds94);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
            if (Math.abs(layoutParams.topMargin) > this.mContentLayout.getHeight()) {
                if (layoutParams.topMargin >= 0) {
                    i3 = this.mContentLayout.getHeight() + h;
                } else {
                    i3 = h - this.mContentLayout.getHeight();
                }
            } else {
                i3 = layoutParams.topMargin + h;
            }
            i2 = View.MeasureSpec.makeMeasureSpec(i3, mode);
        }
        if (this.isNeedAddStatusBarHeight && this.mStatusBarView != null && this.mStatusBarView.getVisibility() == 0) {
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

    public TextView setCenterTextTitle(String str) {
        if (str != null) {
            this.mCenterText.setText(str);
            this.mCenterText.setVisibility(0);
            this.mCenterIcon.setVisibility(8);
        } else {
            this.mCenterText.setVisibility(8);
            this.mCenterIcon.setVisibility(0);
        }
        return this.mCenterText;
    }

    public CharSequence getCenterTextTitleText() {
        return this.mCenterText.getText();
    }

    public TextView setTitleText(String str) {
        if (this.mTextTitle == null) {
            this.mTextTitle = (TextView) getViewFromLayoutFile(d.h.widget_nb_item_title);
            getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
        }
        this.mTextTitle.setText(str);
        return this.mTextTitle;
    }

    public TextView setTitleText(String str, float f) {
        if (this.mTextTitle == null) {
            this.mTextTitle = (TextView) getViewFromLayoutFile(d.h.widget_nb_item_title);
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

    public View getTopCoverBgView() {
        return this.topCoverBgView;
    }

    public View getBarBgView() {
        return this.barBgView;
    }

    public View getBottomLine() {
        return this.mBottomLine;
    }

    public View getCenterImgBox() {
        return this.mCenterIcon;
    }

    public View getCenterImgBoxLayout() {
        return this.mCenterImgBox;
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType) {
        return addSystemImageButton(controlAlign, controlType, this.mOnClickListener);
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        LinearLayout linearLayout = null;
        if (controlType == ControlType.BACK_BUTTON && (linearLayout = (LinearLayout) findViewById(d.g.navigationBarGoBack)) == null) {
            linearLayout = (LinearLayout) getViewFromLayoutFile(d.h.widget_nb_item_back);
            this.mBackImageView = (ImageView) linearLayout.findViewById(d.g.widget_navi_back_button);
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
        al.j(textView, d.C0277d.navi_op_text);
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
        TextView textView = (TextView) getViewFromLayoutFile(d.h.widget_nb_item_create_group);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(d.e.ds16);
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
        Button button = (Button) getViewFromLayoutFile(d.h.widget_nb_item_stepbtn);
        button.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(d.e.ds16);
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
        View viewFromLayoutFile = getViewFromLayoutFile(d.h.navigation_right_button_layout);
        TextView textView = (TextView) viewFromLayoutFile.findViewById(d.g.right_textview);
        textView.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(d.e.ds20);
            if (z) {
                layoutParams.setMargins(dimension, dimension, dimension, dimension);
            } else {
                layoutParams.setMargins(dimension, dimension, 0, dimension);
            }
            textView.setLayoutParams(layoutParams);
        } else if (ControlAlign.HORIZONTAL_LEFT == controlAlign) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension2 = (int) getResources().getDimension(d.e.ds20);
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

    public ViewGroup getViewGroup(ControlAlign controlAlign) {
        if (controlAlign == ControlAlign.HORIZONTAL_LEFT) {
            return this.mLeftBox;
        }
        if (controlAlign == ControlAlign.HORIZONTAL_RIGHT) {
            return this.mRightBox;
        }
        if (controlAlign == ControlAlign.HORIZONTAL_ABSOLUTE_CENTER) {
            return this.mAbsoluteCenterBox;
        }
        return this.mCenterBox;
    }

    public void showBottomLine(boolean z) {
        this.mBottomLine.setVisibility(8);
    }

    public void showBottomLine() {
        this.mBottomLine.setVisibility(0);
    }

    public void hideBottomLine() {
        this.mBottomLine.setVisibility(8);
    }

    private View getViewFromLayoutFile(int i) {
        return LayoutInflater.from(this.mCurrentActivity).inflate(i, (ViewGroup) this, false);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        al.f(this, d.C0277d.cp_bg_line_d, i);
        al.f(this.mBottomLine, this.mBottomLineColor, i);
        onBackBtnOnChangeSkin(i);
        al.c(this.mTextTitle, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.c(this.mCenterText, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        if (this.mRegisterView != null) {
            al.d(this.mRegisterView, d.C0277d.cp_cont_f, 1);
        }
        if (this.mLoginView != null) {
            al.d(this.mLoginView, d.C0277d.cp_cont_f, 1);
        }
        initPadding();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this);
        }
    }

    public void onBackBtnOnChangeSkin() {
        onBackBtnOnChangeSkin(-1);
    }

    public void onBackBtnOnChangeSkin(int i) {
        if (i < 0) {
            i = TbadkCoreApplication.getInst().getSkinType();
        }
        if (this.mBackImagedeepResId > 0 && this.mBackImagelightResId > 0) {
            al.a(this.mBackImageView, this.mBackImagedeepResId, this.mBackImagelightResId, i);
        } else {
            al.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        }
    }

    public void onCenterTextOnChangeSkin(int i) {
        if (i < 0) {
            i = TbadkCoreApplication.getInst().getSkinType();
        }
        al.c(this.mCenterText, d.C0277d.cp_cont_b, 1, i);
    }

    public ImageView getBackImageView() {
        return this.mBackImageView;
    }

    public void setmBackImageViewBg(int i, int i2) {
        this.mBackImagedeepResId = i;
        this.mBackImagelightResId = i2;
        al.a(this.mBackImageView, this.mBackImagedeepResId, this.mBackImagelightResId);
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

    public void hideNavigationBarWithAnimation() {
        if (this.mNavOutAnimator == null) {
            this.mNavOutAnimator = ValueAnimator.ofInt(0, 0 - this.mFixedNavHeight);
            this.mNavOutAnimator.addUpdateListener(this.mNavAnimatorUpdateListener);
            this.mNavOutAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    NavigationBar.this.mNavIsShow = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mNavOutAnimator.setDuration(300L);
            this.mNavOutAnimator.setInterpolator(new LinearInterpolator());
        } else if (this.mNavOutAnimator.isRunning()) {
            return;
        } else {
            if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin < 0) {
                return;
            }
        }
        this.mNavOutAnimator.start();
    }

    public void showNavigationBarWithAnimation() {
        if (this.mNavInAnimator == null) {
            this.mNavInAnimator = ValueAnimator.ofInt(0 - this.mFixedNavHeight, 0);
            this.mNavInAnimator.addUpdateListener(this.mNavAnimatorUpdateListener);
            this.mNavInAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.core.view.NavigationBar.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    NavigationBar.this.mNavIsShow = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    NavigationBar.this.mNavIsShow = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mNavInAnimator.setDuration(300L);
            this.mNavInAnimator.setInterpolator(new LinearInterpolator());
        } else if (this.mNavInAnimator.isRunning()) {
            return;
        } else {
            if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin >= 0) {
                return;
            }
        }
        this.mNavInAnimator.start();
    }

    public boolean getNavBarIsShow() {
        return this.mNavIsShow;
    }

    public void setBottomLineColor(int i) {
        this.mBottomLineColor = i;
    }

    public void setBottomLineHeight(int i) {
        this.mBottomLine.getLayoutParams().height = i;
        requestLayout();
    }
}
