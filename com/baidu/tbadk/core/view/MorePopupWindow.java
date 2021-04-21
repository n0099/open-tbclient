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
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tieba.R;
import d.b.c.e.m.g;
import d.b.c.e.p.l;
import d.b.i0.r.c;
/* loaded from: classes3.dex */
public class MorePopupWindow extends PopupWindow {
    public Activity mActivity;
    public KeyEventDealContainerView mContainer;
    public View mContentView;
    public View mHostView;
    public boolean mIsIntercepted;
    public int mPadding_10;
    public int mShowLeftCenterXOff;
    public int mShowRightTopXOff;
    public int mWindowHeight;

    public MorePopupWindow(Activity activity, View view, View view2, Drawable drawable, KeyEventDealContainerView.a aVar) {
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
        init(activity, view, drawable, aVar);
    }

    private void applaySkin(c cVar, int i, Drawable drawable) {
        if (this.mContentView != null) {
            setBackgroundDrawable(drawable);
            cVar.k(i == 1);
            try {
                cVar.j(this.mContentView);
            } catch (IllegalArgumentException e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    private void init(Activity activity, View view, Drawable drawable, KeyEventDealContainerView.a aVar) {
        this.mActivity = activity;
        this.mContentView = view;
        KeyEventDealContainerView keyEventDealContainerView = new KeyEventDealContainerView(activity, this.mContentView, aVar);
        this.mContainer = keyEventDealContainerView;
        setContentView(keyEventDealContainerView);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(drawable);
        refresh();
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }

    public boolean getIsIntercepted() {
        return this.mIsIntercepted;
    }

    public void onChangeSkinType(BaseActivity baseActivity, int i, Drawable drawable) {
        applaySkin(baseActivity.getLayoutMode(), i, drawable);
    }

    public void reLayoutWidth() {
        this.mContentView.measure(0, 0);
        int measuredWidth = this.mContentView.getMeasuredWidth();
        this.mShowLeftCenterXOff = -(this.mPadding_10 + measuredWidth);
        setWidth(measuredWidth);
    }

    public void refresh() {
        View view = this.mContentView;
        if (view == null || this.mActivity == null) {
            return;
        }
        view.measure(0, 0);
        int measuredWidth = this.mContentView.getMeasuredWidth();
        int measuredHeight = this.mContentView.getMeasuredHeight();
        setWidth(measuredWidth);
        int dimension = measuredHeight + ((int) this.mActivity.getResources().getDimension(R.dimen.ds4));
        this.mWindowHeight = dimension;
        setHeight(dimension);
        int[] p = l.p(this.mActivity);
        if (p != null && p.length > 1 && p[0] > measuredWidth) {
            this.mShowRightTopXOff = p[0] - measuredWidth;
        }
        this.mPadding_10 = 0;
        this.mShowLeftCenterXOff = -(measuredWidth + 0);
    }

    public void setIsIntercepted(boolean z) {
        this.mIsIntercepted = z;
    }

    public void setWidthAsWidthOfDeviceScreen(Context context) {
        int k = l.k(context);
        this.mContentView.getLayoutParams().width = k;
        setWidth(k);
    }

    public void setWindowHeight(int i) {
        setHeight(i);
    }

    public void showWindowInCustomPosition(int i, int i2) {
        if (isShowing()) {
            g.d(this, this.mActivity);
            return;
        }
        View view = this.mHostView;
        if (view == null) {
            return;
        }
        g.l(this, view, i, i2);
    }

    public void showWindowInLeftCenterOfHost(View view, boolean z) {
        setAnimationStyle(R.style.pop_window_anim);
        setFocusable(z);
        int i = this.mShowLeftCenterXOff;
        int i2 = this.mWindowHeight;
        g.l(this, view, i, (-i2) + ((i2 - view.getHeight()) / 2));
    }

    public void showWindowInRightBottomOfHost() {
        if (isShowing()) {
            g.d(this, this.mActivity);
            return;
        }
        View view = this.mHostView;
        if (view == null) {
            return;
        }
        g.l(this, view, this.mShowRightTopXOff, 0);
    }

    public void onChangeSkinType(BaseFragmentActivity baseFragmentActivity, int i, Drawable drawable) {
        applaySkin(baseFragmentActivity.getLayoutMode(), i, drawable);
    }

    public void onChangeSkinType(c cVar, int i, Drawable drawable) {
        applaySkin(cVar, i, drawable);
    }

    public void showWindowInRightBottomOfHost(int i) {
        if (isShowing()) {
            g.d(this, this.mActivity);
            return;
        }
        View view = this.mHostView;
        if (view == null) {
            return;
        }
        g.l(this, view, this.mShowRightTopXOff - i, 0);
    }

    public MorePopupWindow(Activity activity, View view, Drawable drawable, KeyEventDealContainerView.a aVar) {
        super(activity);
        this.mShowRightTopXOff = 0;
        this.mShowLeftCenterXOff = 0;
        this.mWindowHeight = 0;
        this.mHostView = null;
        this.mContainer = null;
        this.mContentView = null;
        this.mPadding_10 = 0;
        this.mIsIntercepted = false;
        init(activity, view, drawable, aVar);
    }

    public MorePopupWindow(Context context, AttributeSet attributeSet) {
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
}
