package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class MorePopupWindow extends PopupWindow {
    private Activity mActivity;
    private u mContainer;
    private View mContentView;
    private View mHostView;
    private boolean mIsIntercepted;
    private int mPadding_10;
    private int mShowLeftCenterXOff;
    private int mShowRightTopXOff;
    private int mWindowHeight;

    public MorePopupWindow(Activity activity, View view, View view2, Drawable drawable, v vVar) {
        super(activity);
        this.mShowRightTopXOff = 0;
        this.mShowLeftCenterXOff = 0;
        this.mWindowHeight = 0;
        this.mHostView = null;
        this.mContainer = null;
        this.mContentView = null;
        this.mPadding_10 = 0;
        this.mIsIntercepted = false;
        this.mHostView = view2;
        init(activity, view, drawable, vVar);
    }

    public MorePopupWindow(Activity activity, View view, Drawable drawable, v vVar) {
        super(activity);
        this.mShowRightTopXOff = 0;
        this.mShowLeftCenterXOff = 0;
        this.mWindowHeight = 0;
        this.mHostView = null;
        this.mContainer = null;
        this.mContentView = null;
        this.mPadding_10 = 0;
        this.mIsIntercepted = false;
        init(activity, view, drawable, vVar);
    }

    private void init(Activity activity, View view, Drawable drawable, v vVar) {
        this.mActivity = activity;
        this.mContentView = view;
        this.mContainer = new u(activity, this.mContentView, vVar);
        setContentView(this.mContainer);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(drawable);
        refresh();
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }

    protected MorePopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShowRightTopXOff = 0;
        this.mShowLeftCenterXOff = 0;
        this.mWindowHeight = 0;
        this.mHostView = null;
        this.mContainer = null;
        this.mContentView = null;
        this.mPadding_10 = 0;
        this.mIsIntercepted = false;
    }

    public void onChangeSkinType(BaseActivity baseActivity, int i, Drawable drawable) {
        applaySkin(baseActivity.getLayoutMode(), i, drawable);
    }

    public void onChangeSkinType(BaseFragmentActivity baseFragmentActivity, int i, Drawable drawable) {
        applaySkin(baseFragmentActivity.getLayoutMode(), i, drawable);
    }

    public void onChangeSkinType(com.baidu.tbadk.core.c cVar, int i, Drawable drawable) {
        applaySkin(cVar, i, drawable);
    }

    private void applaySkin(com.baidu.tbadk.core.c cVar, int i, Drawable drawable) {
        if (this.mContentView != null) {
            setBackgroundDrawable(drawable);
            cVar.ab(i == 1);
            try {
                cVar.h(this.mContentView);
            } catch (IllegalArgumentException e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void reLayoutWidth() {
        this.mContentView.measure(0, 0);
        int measuredWidth = this.mContentView.getMeasuredWidth();
        this.mShowLeftCenterXOff = -(this.mPadding_10 + measuredWidth);
        setWidth(measuredWidth);
    }

    public void setWidthAsWidthOfDeviceScreen(Context context) {
        int M = com.baidu.adp.lib.util.l.M(context);
        this.mContentView.getLayoutParams().width = M;
        setWidth(M);
    }

    public void setWindowHeight(int i) {
        setHeight(i);
    }

    public void showWindowInRightBottomOfHost() {
        if (isShowing()) {
            com.baidu.adp.lib.g.k.a(this, this.mActivity);
        } else if (this.mHostView != null) {
            com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this, this.mHostView, this.mShowRightTopXOff, 0);
        }
    }

    public void showWindowInCustomPosition(int i, int i2) {
        if (isShowing()) {
            com.baidu.adp.lib.g.k.a(this, this.mActivity);
        } else if (this.mHostView != null) {
            com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this, this.mHostView, i, i2);
        }
    }

    public void showWindowInLeftCenterOfHost(View view, boolean z) {
        setAnimationStyle(com.baidu.tieba.aa.pop_window_anim);
        setFocusable(z);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this, view, this.mShowLeftCenterXOff, (-this.mWindowHeight) + ((this.mWindowHeight - view.getHeight()) / 2));
    }

    public void refresh() {
        if (this.mContentView != null && this.mActivity != null) {
            this.mContentView.measure(0, 0);
            int measuredWidth = this.mContentView.getMeasuredWidth();
            int measuredHeight = this.mContentView.getMeasuredHeight();
            setWidth(measuredWidth);
            this.mWindowHeight = measuredHeight + ((int) this.mActivity.getResources().getDimension(com.baidu.tieba.u.ds4));
            setHeight(this.mWindowHeight);
            int[] P = com.baidu.adp.lib.util.l.P(this.mActivity);
            if (P != null && P.length > 1 && P[1] > measuredWidth) {
                this.mShowRightTopXOff = P[1] - measuredWidth;
            }
            this.mPadding_10 = 0;
            this.mShowLeftCenterXOff = -(measuredWidth + this.mPadding_10);
        }
    }

    public boolean getIsIntercepted() {
        return this.mIsIntercepted;
    }

    public void setIsIntercepted(boolean z) {
        this.mIsIntercepted = z;
    }
}
