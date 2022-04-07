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
/* loaded from: classes2.dex */
public class SPSwitchConflictUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface SwitchClickListener {
        void onClickSwitch(View view2, boolean z);
    }

    public SPSwitchConflictUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void attach(Window window, View view2, View view3, View view4, SwitchClickListener switchClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, window, view2, view3, view4, switchClickListener) == null) {
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener(view2, view4, switchClickListener) { // from class: com.baidu.spswitch.utils.SPSwitchConflictUtil.1
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
                            Object[] objArr = {view2, view4, switchClickListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$panelLayout = view2;
                        this.val$focusView = view4;
                        this.val$switchClickListener = switchClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view5) == null) {
                            boolean switchPanelAndSoftInput = SPSwitchConflictUtil.switchPanelAndSoftInput(this.val$panelLayout, this.val$focusView);
                            SwitchClickListener switchClickListener2 = this.val$switchClickListener;
                            if (switchClickListener2 != null) {
                                switchClickListener2.onClickSwitch(view5, switchPanelAndSoftInput);
                            }
                        }
                    }
                });
            }
            if (isHandleByPlaceholder(view2.getContext())) {
                view4.setOnTouchListener(new View.OnTouchListener(view2) { // from class: com.baidu.spswitch.utils.SPSwitchConflictUtil.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View val$panelLayout;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {view2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$panelLayout = view2;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view5, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view5, motionEvent)) == null) {
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

    public static void hidePanelAndSoftInput(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, view3) == null) {
            if (view3 != null) {
                SoftInputUtil.hideSoftInput(view3);
                view3.clearFocus();
            }
            view2.setVisibility(8);
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

    public static boolean showPanel(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, view3)) == null) {
            if (EmotionUtils.getInstance().isEmotionLoaded(EmotionType.EMOTION_CLASSIC_TYPE)) {
                view2.setVisibility(0);
                if (view3 != null) {
                    SoftInputUtil.hideSoftInput(view3);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void showSoftInput(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, view2, view3) == null) {
            SoftInputUtil.showSoftInput(view3);
            if (isHandleByPlaceholder(view2.getContext())) {
                view2.setVisibility(4);
            }
        }
    }

    public static boolean switchPanelAndSoftInput(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, view2, view3)) == null) {
            boolean z = view2.getVisibility() != 0;
            if (z) {
                return showPanel(view2, view3) ? z : !z;
            }
            showSoftInput(view2, view3);
            return z;
        }
        return invokeLL.booleanValue;
    }
}
