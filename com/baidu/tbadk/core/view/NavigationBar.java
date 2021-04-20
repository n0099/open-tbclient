package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
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
import androidx.annotation.ColorRes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.c.a.f;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class NavigationBar extends RelativeLayout {
    public View barBgView;
    public int containerWidth;
    public boolean isAutoNight;
    public boolean isFixedHeight;
    public boolean isNeedAddStatusBarHeight;
    public LinearLayout mAbsoluteCenterBox;
    public ImageView mBackImageView;
    public int mBackImagedeepResId;
    public int mBackImagelightResId;
    public View mBottomLine;
    public int mBottomLineColor;
    public LinearLayout mCenterBox;
    public ImageView mCenterIcon;
    public LinearLayout mCenterImgBox;
    public TextView mCenterText;
    public boolean mClickIsVaild;
    public FrameLayout mContentLayout;
    public Activity mCurrentActivity;
    public int mFixedNavHeight;
    public boolean mIsClose;
    public boolean mIsCorner;
    public LinearLayout mLeftBox;
    public View.OnClickListener mLoginListener;
    public TextView mLoginView;
    public ValueAnimator.AnimatorUpdateListener mNavAnimatorUpdateListener;
    public int mNavHeight;
    public ValueAnimator mNavInAnimator;
    public boolean mNavIsShow;
    public ValueAnimator mNavOutAnimator;
    public final View.OnClickListener mOnClickListener;
    public View.OnClickListener mRegisterListener;
    public TextView mRegisterView;
    public LinearLayout mRightBox;
    public View mRootView;
    public int mSpecialBackgroundBackupColorId;
    public Drawable mSpecialBackgroundDrawable;
    public Paint mSpecialBackgroundPaint;
    public View mStatusBarView;
    public TextView mTextTitle;
    public int mTopPadding;
    public View mUnloginView;
    public View topCoverBgView;

    /* loaded from: classes3.dex */
    public enum ControlAlign {
        HORIZONTAL_LEFT,
        HORIZONTAL_CENTER,
        HORIZONTAL_RIGHT,
        HORIZONTAL_ABSOLUTE_CENTER
    }

    /* loaded from: classes3.dex */
    public enum ControlType {
        BACK_BUTTON
    }

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = NavigationBar.this.mContentLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = intValue;
                NavigationBar.this.mContentLayout.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NavigationBar.this.mClickIsVaild) {
                int id = view.getId();
                if (id == R.id.navigationBarGoBack) {
                    NavigationBar.this.mCurrentActivity.finish();
                } else if (id == R.id.navigationBarHome) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002004, NavigationBar.this.mCurrentActivity));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            NavigationBar.this.mNavIsShow = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            NavigationBar.this.mNavIsShow = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            NavigationBar.this.mNavIsShow = true;
        }
    }

    public NavigationBar(Context context) {
        super(context);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mTopPadding = 0;
        this.mNavHeight = l.g(getContext(), R.dimen.ds88);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a();
        this.containerWidth = 0;
        this.mOnClickListener = new c();
        init(context, null);
    }

    private View createStateBarFillView() {
        View view = new View(getContext());
        view.setId(R.id.navigation_bar_status_bar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight());
        layoutParams.addRule(10, -1);
        view.setLayoutParams(layoutParams);
        return view;
    }

    private View getViewFromLayoutFile(int i) {
        return LayoutInflater.from(this.mCurrentActivity).inflate(i, (ViewGroup) this, false);
    }

    private void init(Context context, AttributeSet attributeSet) {
        boolean z;
        this.mFixedNavHeight = this.mNavHeight;
        this.mCurrentActivity = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_navigation_bar, (ViewGroup) this, true);
        this.mRootView = inflate;
        this.mContentLayout = (FrameLayout) inflate.findViewById(R.id.navigation_bar_content_layout);
        this.mLeftBox = (LinearLayout) this.mRootView.findViewById(R.id.leftBox);
        this.mCenterBox = (LinearLayout) this.mRootView.findViewById(R.id.centerBox);
        this.mRightBox = (LinearLayout) this.mRootView.findViewById(R.id.rightBox);
        this.mAbsoluteCenterBox = (LinearLayout) this.mRootView.findViewById(R.id.absoluteCenterBox);
        this.mCenterImgBox = (LinearLayout) this.mRootView.findViewById(R.id.center_img_box);
        this.mCenterIcon = (ImageView) this.mRootView.findViewById(R.id.center_img);
        this.mCenterText = (TextView) this.mRootView.findViewById(R.id.center_text);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        View findViewById = this.mRootView.findViewById(R.id.navigation_bar_view_cover_bg);
        this.topCoverBgView = findViewById;
        boolean z2 = false;
        findViewById.setBackgroundDrawable(SkinManager.getDrawable(0, R.drawable.navigation_cover_top_bg));
        this.barBgView = this.mRootView.findViewById(R.id.navigation_bar_view_bg);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NavigationBar);
            z = obtainStyledAttributes.getBoolean(R$styleable.NavigationBar_canSpread, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z && UtilHelper.canUseStyleImmersiveSticky()) {
            z2 = true;
        }
        this.isNeedAddStatusBarHeight = z2;
        if (z2) {
            View createStateBarFillView = createStateBarFillView();
            this.mStatusBarView = createStateBarFillView;
            addView(createStateBarFillView);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
            layoutParams.addRule(3, this.mStatusBarView.getId());
            this.mContentLayout.setLayoutParams(layoutParams);
            this.mFixedNavHeight += UtilHelper.getStatusBarHeight();
        }
        setGravity(48);
        initPadding();
        switchNaviBarStatus(true);
        this.mRootView.setOnClickListener(new b());
        this.mNavIsShow = true;
    }

    private void initUnloginView() {
        if (this.mUnloginView == null) {
            View inflate = ((ViewStub) this.mRootView.findViewById(R.id.unlogin_view_stub)).inflate();
            this.mUnloginView = inflate;
            this.mRegisterView = (TextView) inflate.findViewById(R.id.top_navi_register);
            TextView textView = (TextView) this.mUnloginView.findViewById(R.id.top_navi_login);
            this.mLoginView = textView;
            textView.setOnClickListener(this.mLoginListener);
            this.mRegisterView.setOnClickListener(this.mRegisterListener);
        }
    }

    public TextView addCreateGroupButton(ControlAlign controlAlign, View.OnClickListener onClickListener) {
        TextView textView = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_create_group);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
        }
        getViewGroup(controlAlign).addView(textView);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
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

    public Button addRightButton(ControlAlign controlAlign, String str) {
        Button button = (Button) getViewFromLayoutFile(R.layout.widget_nb_item_stepbtn);
        button.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            button.setLayoutParams(layoutParams);
        }
        getViewGroup(controlAlign).addView(button);
        return button;
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType) {
        return addSystemImageButton(controlAlign, controlType, this.mOnClickListener);
    }

    public TextView addTextButton(ControlAlign controlAlign, String str) {
        return addTextButton(controlAlign, str, null);
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str) {
        TextView addTextButton = addTextButton(controlAlign, str, null);
        setDefTextButtonColor(addTextButton);
        return addTextButton;
    }

    public ImageView getBackImageView() {
        return this.mBackImageView;
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

    public TextView getCenterText() {
        return this.mCenterText;
    }

    public CharSequence getCenterTextTitleText() {
        return this.mCenterText.getText();
    }

    public FrameLayout getContentLayout() {
        return this.mContentLayout;
    }

    public int getFixedNavHeight() {
        return this.mFixedNavHeight;
    }

    public boolean getNavBarIsShow() {
        return this.mNavIsShow;
    }

    public View getTopCoverBgView() {
        return this.topCoverBgView;
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

    public void hideBottomLine() {
        this.mBottomLine.setVisibility(8);
    }

    public void hideNavigationBarWithAnimation() {
        ValueAnimator valueAnimator = this.mNavOutAnimator;
        if (valueAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 0 - this.mFixedNavHeight);
            this.mNavOutAnimator = ofInt;
            ofInt.addUpdateListener(this.mNavAnimatorUpdateListener);
            this.mNavOutAnimator.addListener(new d());
            this.mNavOutAnimator.setDuration(300L);
            this.mNavOutAnimator.setInterpolator(new LinearInterpolator());
        } else if (valueAnimator.isRunning()) {
            return;
        } else {
            if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin < 0) {
                return;
            }
        }
        this.mNavOutAnimator.start();
    }

    public void initPadding() {
        setPadding(l.e(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), this.mTopPadding, l.e(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), l.e(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)));
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public boolean isFixedHeight() {
        return this.isFixedHeight;
    }

    public boolean isNavigationBarExcludeStatusbarVisible() {
        return this.mLeftBox.getVisibility() == 0 || this.mCenterBox.getVisibility() == 0 || this.mRightBox.getVisibility() == 0;
    }

    public void isShowBottomLine(boolean z) {
        this.mBottomLine.setVisibility(z ? 0 : 8);
    }

    public void onBackBtnOnChangeSkin() {
        onBackBtnOnChangeSkin(-1);
    }

    public void onCenterTextOnChangeSkin(int i) {
        if (i < 0) {
            i = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setViewTextColor(this.mCenterText, R.color.CAM_X0105, 1, i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(f<?> fVar, int i) {
        if (this.mIsCorner) {
            SkinManager.setBackgroundResource(this, R.drawable.nav_bg_corner_shape, i);
        } else {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i);
        }
        SkinManager.setBackgroundColor(this.mBottomLine, this.mBottomLineColor, i);
        onBackBtnOnChangeSkin(i);
        SkinManager.setNavbarTitleColor(this.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SkinManager.setNavbarTitleColor(this.mCenterText, R.color.CAM_X0105, R.color.s_navbar_title_color);
        TextView textView = this.mRegisterView;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        }
        TextView textView2 = this.mLoginView;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0106, 1);
        }
        initPadding();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(i == 1);
            tbPageContext.getLayoutMode().j(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mSpecialBackgroundDrawable;
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight() - ((int) ((drawable.getIntrinsicHeight() / this.mSpecialBackgroundDrawable.getIntrinsicWidth()) * getWidth()));
            this.mSpecialBackgroundDrawable.setBounds(0, measuredHeight, getMeasuredWidth(), getMeasuredHeight());
            this.mSpecialBackgroundDrawable.draw(canvas);
            if (measuredHeight > 0) {
                if (this.mSpecialBackgroundPaint == null) {
                    Paint paint = new Paint();
                    this.mSpecialBackgroundPaint = paint;
                    paint.setColor(SkinManager.getColor(this.mSpecialBackgroundBackupColorId));
                }
                canvas.drawRect(0.0f, 0.0f, getWidth(), measuredHeight, this.mSpecialBackgroundPaint);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = this.mLeftBox.getMeasuredWidth() + getPaddingLeft();
        int measuredWidth2 = this.mRightBox.getMeasuredWidth() + getPaddingRight();
        LinearLayout linearLayout = this.mCenterBox;
        linearLayout.layout(measuredWidth, linearLayout.getTop(), this.containerWidth - measuredWidth2, this.mCenterBox.getBottom());
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        View view;
        int i3;
        int i4;
        if (this.isFixedHeight) {
            int mode = View.MeasureSpec.getMode(i2);
            int i5 = this.mNavHeight;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
            if (Math.abs(layoutParams.topMargin) > this.mContentLayout.getHeight()) {
                if (layoutParams.topMargin >= 0) {
                    i3 = this.mContentLayout.getHeight();
                } else {
                    i4 = i5 - this.mContentLayout.getHeight();
                    i2 = View.MeasureSpec.makeMeasureSpec(i4, mode);
                }
            } else {
                i3 = layoutParams.topMargin;
            }
            i4 = i5 + i3;
            i2 = View.MeasureSpec.makeMeasureSpec(i4, mode);
        }
        if (this.isNeedAddStatusBarHeight && (view = this.mStatusBarView) != null && view.getVisibility() == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) + UtilHelper.getStatusBarHeight(), View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
        this.containerWidth = View.MeasureSpec.getSize(i);
        int measuredWidth = this.mLeftBox.getMeasuredWidth() + getPaddingLeft();
        int measuredWidth2 = this.mRightBox.getMeasuredWidth() + getPaddingRight();
        LinearLayout linearLayout = this.mCenterBox;
        linearLayout.measure(((this.containerWidth - measuredWidth) - measuredWidth2) + 1073741824, linearLayout.getMeasuredHeight() + 1073741824);
    }

    public void release() {
        removeAllViews();
    }

    public void removeAllViews(ControlAlign controlAlign) {
        getViewGroup(controlAlign).removeAllViews();
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void setBottomLineColor(int i) {
        this.mBottomLineColor = i;
    }

    public void setBottomLineHeight(int i) {
        this.mBottomLine.getLayoutParams().height = i;
        requestLayout();
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

    public void setContentPaddingTop(int i) {
        this.mContentLayout.setPadding(l.e(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), i, l.e(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), l.e(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)));
    }

    public void setCustomContent(View view) {
        this.mContentLayout.addView(view);
    }

    public void setDefTextButtonColor(TextView textView) {
        SkinManager.setViewTextColor(textView, R.color.navi_op_text);
    }

    public void setFixedHeight(boolean z) {
        this.isFixedHeight = z;
    }

    public void setIsClose(boolean z) {
        this.mIsClose = z;
    }

    public void setIsCorner(boolean z) {
        this.mIsCorner = z;
    }

    public void setLoginClickListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
        TextView textView = this.mLoginView;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setNavHeight(int i) {
        this.mNavHeight = i;
    }

    public void setRegisterClickListener(View.OnClickListener onClickListener) {
        this.mRegisterListener = onClickListener;
        TextView textView = this.mRegisterView;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setSpecialBackground(Drawable drawable, int i) {
        this.mSpecialBackgroundDrawable = drawable;
        this.mSpecialBackgroundBackupColorId = i;
    }

    public void setStatusBarVisibility(int i) {
        View view = this.mStatusBarView;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setSystemClickable(boolean z) {
        this.mClickIsVaild = z;
    }

    public TextView setTitleText(String str) {
        if (this.mTextTitle == null) {
            this.mTextTitle = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_title);
            getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
        }
        this.mTextTitle.setText(str);
        return this.mTextTitle;
    }

    public View setTitleView(View view, View.OnClickListener onClickListener) {
        return addCustomView(ControlAlign.HORIZONTAL_CENTER, view, onClickListener);
    }

    public void setmBackImageViewBg(int i, int i2) {
        this.mBackImagedeepResId = i;
        this.mBackImagelightResId = i2;
        SkinManager.setNavbarIconSrc(this.mBackImageView, i, i2);
    }

    public void showBottomLine(boolean z) {
        this.mBottomLine.setVisibility(8);
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

    public void showNavigationBarWithAnimation() {
        ValueAnimator valueAnimator = this.mNavInAnimator;
        if (valueAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0 - this.mFixedNavHeight, 0);
            this.mNavInAnimator = ofInt;
            ofInt.addUpdateListener(this.mNavAnimatorUpdateListener);
            this.mNavInAnimator.addListener(new e());
            this.mNavInAnimator.setDuration(300L);
            this.mNavInAnimator.setInterpolator(new LinearInterpolator());
        } else if (valueAnimator.isRunning()) {
            return;
        } else {
            if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin >= 0) {
                return;
            }
        }
        this.mNavInAnimator.start();
    }

    public void switchNaviBarStatus(boolean z) {
        if (z) {
            this.mLeftBox.setVisibility(0);
            this.mCenterBox.setVisibility(0);
            this.mRightBox.setVisibility(0);
            this.mAbsoluteCenterBox.setVisibility(0);
            View view = this.mUnloginView;
            if (view != null) {
                view.setVisibility(8);
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

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        if (controlType == ControlType.BACK_BUTTON) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.navigationBarGoBack);
            if (linearLayout == null) {
                LinearLayout linearLayout2 = (LinearLayout) getViewFromLayoutFile(R.layout.widget_nb_item_back);
                ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.widget_navi_back_button);
                this.mBackImageView = imageView;
                imageView.setContentDescription("返回");
                onBackBtnOnChangeSkin();
                if (linearLayout2 != null) {
                    getViewGroup(controlAlign).addView(linearLayout2);
                    if (onClickListener != null) {
                        linearLayout2.setOnClickListener(onClickListener);
                        return linearLayout2;
                    }
                    return linearLayout2;
                }
                return linearLayout2;
            }
            return linearLayout;
        }
        return null;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        return addTextButton(controlAlign, str, onClickListener, false);
    }

    public void onBackBtnOnChangeSkin(int i) {
        int i2;
        if (i < 0) {
            i = TbadkCoreApplication.getInst().getSkinType();
        }
        int i3 = this.mBackImagedeepResId;
        if (i3 > 0 && (i2 = this.mBackImagelightResId) > 0) {
            SkinManager.setNavbarIconSrc(this.mBackImageView, i3, i2, i);
        } else if (this.mIsClose) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, null);
        }
    }

    public View setTitleView(int i, View.OnClickListener onClickListener) {
        return addCustomView(ControlAlign.HORIZONTAL_CENTER, getViewFromLayoutFile(i), onClickListener);
    }

    public void showBottomLine() {
        this.mBottomLine.setVisibility(8);
    }

    public TextView addTextButton(ControlAlign controlAlign, String str, View.OnClickListener onClickListener, boolean z) {
        View viewFromLayoutFile = getViewFromLayoutFile(R.layout.navigation_right_button_layout);
        TextView textView = (TextView) viewFromLayoutFile.findViewById(R.id.right_textview);
        textView.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(R.dimen.M_H_X003);
            if (z) {
                layoutParams.setMargins(dimension, dimension, dimension, dimension);
            } else {
                layoutParams.setMargins(dimension, dimension, 0, dimension);
            }
            textView.setLayoutParams(layoutParams);
        } else if (ControlAlign.HORIZONTAL_LEFT == controlAlign) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension2 = (int) getResources().getDimension(R.dimen.M_H_X003);
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

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        TextView addTextButton = addTextButton(controlAlign, str, onClickListener, false);
        setDefTextButtonColor(addTextButton);
        return addTextButton;
    }

    public View addCustomView(ControlAlign controlAlign, int i, View.OnClickListener onClickListener) {
        return addCustomView(controlAlign, getViewFromLayoutFile(i), onClickListener);
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str, View.OnClickListener onClickListener, boolean z) {
        TextView addTextButton = addTextButton(controlAlign, str, onClickListener, z);
        setDefTextButtonColor(addTextButton);
        return addTextButton;
    }

    public TextView setTitleText(String str, float f2) {
        if (this.mTextTitle == null) {
            TextView textView = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_title);
            this.mTextTitle = textView;
            textView.setTextSize(0, f2);
            getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
        }
        this.mTextTitle.setText(str);
        return this.mTextTitle;
    }

    public void onBackBtnOnChangeSkin(int i, @ColorRes int i2) {
        int i3;
        if (i < 0) {
            i = TbadkCoreApplication.getInst().getSkinType();
        }
        int i4 = this.mBackImagedeepResId;
        if (i4 > 0 && (i3 = this.mBackImagelightResId) > 0) {
            SkinManager.setNavbarIconSrc(this.mBackImageView, i4, i3, i);
        } else if (this.mIsClose) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.icon_pure_topbar_close44_svg, i2, null);
        } else {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, i2, null);
        }
    }

    public TextView setTitleText(int i) {
        return setTitleText(this.mCurrentActivity.getString(i));
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mTopPadding = 0;
        this.mNavHeight = l.g(getContext(), R.dimen.ds88);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a();
        this.containerWidth = 0;
        this.mOnClickListener = new c();
        init(context, attributeSet);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mTopPadding = 0;
        this.mNavHeight = l.g(getContext(), R.dimen.ds88);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a();
        this.containerWidth = 0;
        this.mOnClickListener = new c();
        init(context, attributeSet);
    }
}
