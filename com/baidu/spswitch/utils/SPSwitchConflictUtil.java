package com.baidu.spswitch.utils;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SPSwitchConflictUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface SwitchClickListener {
        void onClickSwitch(View view, boolean z);
    }

    public SPSwitchConflictUtil() {
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

    public static void attach(Window window, View view, View view2, View view3, SwitchClickListener switchClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, window, view, view2, view3, switchClickListener) == null) {
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener(view, view3, switchClickListener) { // from class: com.baidu.spswitch.utils.SPSwitchConflictUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View val$focusView;
                    public final /* synthetic */ View val$panelLayout;
                    public final /* synthetic */ SwitchClickListener val$switchClickListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {view, view3, switchClickListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$panelLayout = view;
                        this.val$focusView = view3;
                        this.val$switchClickListener = switchClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                            boolean switchPanelAndSoftInput = SPSwitchConflictUtil.switchPanelAndSoftInput(this.val$panelLayout, this.val$focusView);
                            SwitchClickListener switchClickListener2 = this.val$switchClickListener;
                            if (switchClickListener2 != null) {
                                switchClickListener2.onClickSwitch(view4, switchPanelAndSoftInput);
                            }
                        }
                    }
                });
            }
            if (isHandleByPlaceholder(view.getContext())) {
                view3.setOnTouchListener(new View.OnTouchListener(view) { // from class: com.baidu.spswitch.utils.SPSwitchConflictUtil.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View val$panelLayout;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {view};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$panelLayout = view;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view4, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view4, motionEvent)) == null) {
                            if (motionEvent.getAction() == 1) {
                                this.val$panelLayout.setVisibility(4);
                                return false;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
        }
    }

    public static void hidePanelAndSoftInput(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view, view2) == null) {
            if (view2 != null) {
                SoftInputUtil.hideSoftInput(view2);
                view2.clearFocus();
            }
            view.setVisibility(8);
        }
    }

    public static boolean isHandleByPlaceholder(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context instanceof Activity) {
                return isHandleByPlaceholder(ViewUtil.isFullScreen((Activity) context));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isHandleByPlaceholder(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) ? z : invokeZ.booleanValue;
    }

    public static boolean showPanel(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view, view2)) == null) {
            if (EmotionUtils.getInstance().isEmotionLoaded(EmotionType.EMOTION_CLASSIC_TYPE)) {
                view.setVisibility(0);
                if (view2 != null) {
                    SoftInputUtil.hideSoftInput(view2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void showSoftInput(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, view, view2) == null) {
            SoftInputUtil.showSoftInput(view2);
            if (isHandleByPlaceholder(view.getContext())) {
                view.setVisibility(4);
            }
        }
    }

    public static boolean switchPanelAndSoftInput(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, view, view2)) == null) {
            boolean z = view.getVisibility() != 0;
            if (z) {
                return showPanel(view, view2) ? z : !z;
            }
            showSoftInput(view, view2);
            return z;
        }
        return invokeLL.booleanValue;
    }
}
