package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VirtualBarAssist {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View childOfContent;
    public final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    public int usableHeightPrevious;
    public ViewTreeObserver viewTreeObserver;

    public VirtualBarAssist(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.tbadk.core.util.VirtualBarAssist.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VirtualBarAssist this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.possiblyResizeChildOfContent();
                }
            }
        };
        this.childOfContent = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
    }

    private void addOnGlobalLayoutListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            measureIsAliveViewTreeObserver();
            ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                return;
            }
            this.viewTreeObserver.addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    public static VirtualBarAssist assistActivity(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            VirtualBarAssist virtualBarAssist = new VirtualBarAssist(activity);
            virtualBarAssist.addOnGlobalLayoutListener();
            UtilHelper.setTranslucentVirtualNavigation(activity);
            return virtualBarAssist;
        }
        return (VirtualBarAssist) invokeL.objValue;
    }

    private void measureIsAliveViewTreeObserver() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
            if ((viewTreeObserver == null || !viewTreeObserver.isAlive()) && (view = this.childOfContent) != null) {
                this.viewTreeObserver = view.getViewTreeObserver();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.childOfContent == null) {
            return;
        }
        Rect rect = new Rect();
        this.childOfContent.getWindowVisibleDisplayFrame(rect);
        int i2 = rect.bottom - rect.top;
        if (i2 != this.usableHeightPrevious) {
            int height = this.childOfContent.getRootView().getHeight();
            int i3 = height - rect.bottom;
            int i4 = (height - i2) - i3;
            if (i4 > height / 4) {
                this.childOfContent.getLayoutParams().height = height - i4;
            } else {
                this.childOfContent.getLayoutParams().height = height - i3;
            }
            this.childOfContent.requestLayout();
            this.usableHeightPrevious = i2;
        }
    }

    private void removeOnGlobalLayoutListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            measureIsAliveViewTreeObserver();
            ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                return;
            }
            this.viewTreeObserver.removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeOnGlobalLayoutListener();
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            removeOnGlobalLayoutListener();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            addOnGlobalLayoutListener();
        }
    }
}
