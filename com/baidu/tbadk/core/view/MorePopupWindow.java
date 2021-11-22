package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.g;
import b.a.e.f.p.l;
import b.a.q0.s.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class MorePopupWindow extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public KeyEventDealContainerView mContainer;
    public View mContentView;
    public View mHostView;
    public boolean mIsIntercepted;
    public int mPadding_10;
    public int mShowLeftCenterXOff;
    public int mShowRightTopXOff;
    public int mWindowHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MorePopupWindow(Activity activity, View view, View view2, Drawable drawable, KeyEventDealContainerView.a aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, view, view2, drawable, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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

    private void applaySkin(c cVar, int i2, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, this, cVar, i2, drawable) == null) || this.mContentView == null) {
            return;
        }
        setBackgroundDrawable(drawable);
        cVar.k(i2 == 1);
        try {
            cVar.j(this.mContentView);
        } catch (IllegalArgumentException e2) {
            BdLog.e(e2.toString());
        }
    }

    private void init(Activity activity, View view, Drawable drawable, KeyEventDealContainerView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, view, drawable, aVar) == null) {
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
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mContentView : (View) invokeV.objValue;
    }

    public boolean getIsIntercepted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsIntercepted : invokeV.booleanValue;
    }

    public void onChangeSkinType(BaseActivity baseActivity, int i2, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, baseActivity, i2, drawable) == null) {
            applaySkin(baseActivity.getLayoutMode(), i2, drawable);
        }
    }

    public void reLayoutWidth() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mContentView.measure(0, 0);
            int measuredWidth = this.mContentView.getMeasuredWidth();
            this.mShowLeftCenterXOff = -(this.mPadding_10 + measuredWidth);
            setWidth(measuredWidth);
        }
    }

    public void refresh() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (view = this.mContentView) == null || this.mActivity == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mIsIntercepted = z;
        }
    }

    public void setWidthAsWidthOfDeviceScreen(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            int k = l.k(context);
            this.mContentView.getLayoutParams().width = k;
            setWidth(k);
        }
    }

    public void setWindowHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            setHeight(i2);
        }
    }

    public void showWindowInCustomPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            if (isShowing()) {
                g.d(this, this.mActivity);
                return;
            }
            View view = this.mHostView;
            if (view == null) {
                return;
            }
            g.l(this, view, i2, i3);
        }
    }

    public void showWindowInLeftCenterOfHost(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, view, z) == null) {
            setAnimationStyle(R.style.pop_window_anim);
            setFocusable(z);
            int i2 = this.mShowLeftCenterXOff;
            int i3 = this.mWindowHeight;
            g.l(this, view, i2, (-i3) + ((i3 - view.getHeight()) / 2));
        }
    }

    public void showWindowInRightBottomOfHost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
    }

    public void onChangeSkinType(BaseFragmentActivity baseFragmentActivity, int i2, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, baseFragmentActivity, i2, drawable) == null) {
            applaySkin(baseFragmentActivity.getLayoutMode(), i2, drawable);
        }
    }

    public void onChangeSkinType(c cVar, int i2, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, cVar, i2, drawable) == null) {
            applaySkin(cVar, i2, drawable);
        }
    }

    public void showWindowInRightBottomOfHost(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (isShowing()) {
                g.d(this, this.mActivity);
                return;
            }
            View view = this.mHostView;
            if (view == null) {
                return;
            }
            g.l(this, view, this.mShowRightTopXOff - i2, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MorePopupWindow(Activity activity, View view, Drawable drawable, KeyEventDealContainerView.a aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, view, drawable, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MorePopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
