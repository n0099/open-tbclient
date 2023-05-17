package com.baidu.android.ext.widget.dialog;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\u0007\"\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/app/Activity;", "activity", "", "getWindowWidth", "(Landroid/app/Activity;)I", "Landroid/view/Window;", "window", "(Landroid/view/Window;)I", "", "COLOR_RES_TYPE", "Ljava/lang/String;", "lib-dialog_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class BdDialogKt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COLOR_RES_TYPE = "color";
    public transient /* synthetic */ FieldHolder $fh;

    public static final int getWindowWidth(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return getWindowWidth(activity.getWindow());
        }
        return invokeL.intValue;
    }

    public static final int getWindowWidth(Window window) {
        InterceptResult invokeL;
        WindowManager windowManager;
        Display defaultDisplay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, window)) == null) {
            Point point = new Point();
            if (window != null && (windowManager = window.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                defaultDisplay.getSize(point);
            }
            return point.x;
        }
        return invokeL.intValue;
    }
}
