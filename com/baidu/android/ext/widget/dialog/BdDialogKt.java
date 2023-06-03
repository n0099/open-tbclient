package com.baidu.android.ext.widget.dialog;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"COLOR_RES_TYPE", "", "getWindowWidth", "", "activity", "Landroid/app/Activity;", ApkCheckUBCManagerKt.VALUE_WINDOW, "Landroid/view/Window;", "lib-dialog_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
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
