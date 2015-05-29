package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class NavigationBar extends RelativeLayout {
    private static final int ID_STATEBAR_FILL_VIEW = 1;
    private int containerWidth;
    private LinearLayout mCenterBox;
    private boolean mClickIsVaild;
    private Activity mCurrentActivity;
    private LinearLayout mLeftBox;
    private View.OnClickListener mLoginListener;
    private TextView mLoginView;
    private TextView mNavBottomLine;
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

        /* JADX DEBUG: Replace access to removed values field (Zl) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Zm) with 'values()' method */
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
        this.containerWidth = 0;
        this.mOnClickListener = new w(this);
        init(context, null);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClickIsVaild = true;
        this.containerWidth = 0;
        this.mOnClickListener = new w(this);
        init(context, attributeSet);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClickIsVaild = true;
        this.containerWidth = 0;
        this.mOnClickListener = new w(this);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        boolean z;
        this.mCurrentActivity = (Activity) context;
        this.mRootView = com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.widget_navigation_bar, this, true);
        this.mLeftBox = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.leftBox);
        this.mCenterBox = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.centerBox);
        this.mRightBox = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.rightBox);
        this.mNavBottomLine = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.navBottomLine);
        this.mNavBottomLine.setVisibility(8);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.v.NavigationBar);
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z && UtilHelper.canUseStyleImmersiveSticky()) {
            addView(createStateBarFillView());
            ((RelativeLayout.LayoutParams) this.mLeftBox.getLayoutParams()).addRule(3, 1);
            ((RelativeLayout.LayoutParams) this.mCenterBox.getLayoutParams()).addRule(3, 1);
            ((RelativeLayout.LayoutParams) this.mRightBox.getLayoutParams()).addRule(3, 1);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setGravity(48);
        initPadding();
        switchNaviBarStatus(true);
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
            this.mUnloginView = ((ViewStub) this.mRootView.findViewById(com.baidu.tieba.q.unlogin_view_stub)).inflate();
            this.mRegisterView = (TextView) this.mUnloginView.findViewById(com.baidu.tieba.q.top_navi_register);
            this.mLoginView = (TextView) this.mUnloginView.findViewById(com.baidu.tieba.q.top_navi_login);
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
        setPadding(com.baidu.adp.lib.util.n.dip2px(this.mCurrentActivity, getResources().getDimension(com.baidu.tieba.o.navi_padding_left)), com.baidu.adp.lib.util.n.dip2px(this.mCurrentActivity, getResources().getDimension(com.baidu.tieba.o.navi_padding_top)), com.baidu.adp.lib.util.n.dip2px(this.mCurrentActivity, getResources().getDimension(com.baidu.tieba.o.navi_padding_right)), com.baidu.adp.lib.util.n.dip2px(this.mCurrentActivity, getResources().getDimension(com.baidu.tieba.o.navi_padding_bottom)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
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
            this.mTextTitle = (TextView) getViewFromLayoutFile(com.baidu.tieba.r.widget_nb_item_title);
            getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
        }
        this.mTextTitle.setText(str);
        return this.mTextTitle;
    }

    public TextView setTitleText(String str, float f) {
        if (this.mTextTitle == null) {
            this.mTextTitle = (TextView) getViewFromLayoutFile(com.baidu.tieba.r.widget_nb_item_title);
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

    public View setTitleView(int i, View.OnClickListener onClickListener) {
        return addCustomView(ControlAlign.HORIZONTAL_CENTER, getViewFromLayoutFile(i), onClickListener);
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType) {
        return addSystemImageButton(controlAlign, controlType, this.mOnClickListener);
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        LinearLayout linearLayout = null;
        if (controlType == ControlType.BACK_BUTTON && (linearLayout = (LinearLayout) findViewById(com.baidu.tieba.q.navigationBarGoBack)) == null && (linearLayout = (LinearLayout) getViewFromLayoutFile(com.baidu.tieba.r.widget_nb_item_back)) != null) {
            getViewGroup(controlAlign).addView(linearLayout);
            if (onClickListener != null) {
                linearLayout.setOnClickListener(onClickListener);
            }
        }
        return linearLayout;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str) {
        return addTextButton(controlAlign, str, null);
    }

    public TextView addCreateGroupButton(ControlAlign controlAlign, View.OnClickListener onClickListener) {
        TextView textView = (TextView) getViewFromLayoutFile(com.baidu.tieba.r.widget_nb_item_create_group);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(com.baidu.tieba.o.navi_btn_margin_right);
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
        Button button = (Button) getViewFromLayoutFile(com.baidu.tieba.r.widget_nb_item_stepbtn);
        button.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(com.baidu.tieba.o.navi_btn_margin_right);
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
        TextView textView = (TextView) getViewFromLayoutFile(com.baidu.tieba.r.widget_nb_item_textbtn);
        textView.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(com.baidu.tieba.o.navi_btn_margin_right);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
        } else if (ControlAlign.HORIZONTAL_LEFT == controlAlign) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension2 = (int) getResources().getDimension(com.baidu.tieba.o.navi_btn_margin_right);
            layoutParams2.setMargins(dimension2, dimension2, 0, dimension2);
            textView.setLayoutParams(layoutParams2);
        }
        getViewGroup(controlAlign).addView(textView);
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

    public View getViewFromLayoutFile(int i) {
        return com.baidu.adp.lib.g.b.hr().a(this.mCurrentActivity, i, this, false);
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        com.baidu.tbadk.core.util.ay.i(this, com.baidu.tieba.p.bg_bar);
        com.baidu.tbadk.core.util.ay.j((View) this.mNavBottomLine, com.baidu.tieba.n.cp_other_f_1);
        initPadding();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) jVar).getLayoutMode().j(this);
        } else if (this.mCurrentActivity instanceof ActivityProxy) {
            ActivityProxy activityProxy = (ActivityProxy) this.mCurrentActivity;
            if (activityProxy.kN() instanceof ProxyAdkBaseActivity) {
                ProxyAdkBaseActivity proxyAdkBaseActivity = (ProxyAdkBaseActivity) activityProxy.kN();
                proxyAdkBaseActivity.getLayoutMode().ab(i == 1);
                proxyAdkBaseActivity.getLayoutMode().j(this);
            }
        }
    }
}
