package com.baidu.searchbox.ui;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TouchStateListener implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float PRESSED_ALPHA_IN_DAY_MODE = 0.2f;
    public static final float PRESSED_ALPHA_IN_NIGHT_MODE = 0.5f;
    public transient /* synthetic */ FieldHolder $fh;
    public View mTargetView;

    public TouchStateListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                View view2 = this.mTargetView;
                if (view2 == null) {
                    view.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
                    return false;
                }
                view2.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
                return false;
            } else if (action != 2) {
                View view3 = this.mTargetView;
                if (view3 == null) {
                    view.setAlpha(1.0f);
                    return false;
                }
                view3.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public TouchStateListener(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTargetView = view;
    }
}
