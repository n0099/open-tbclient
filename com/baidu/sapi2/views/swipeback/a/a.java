package com.baidu.sapi2.views.swipeback.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static boolean a(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollVertically(view, 1) : invokeCommon.booleanValue;
    }

    public static boolean b(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollHorizontally(view, 1) : invokeCommon.booleanValue;
    }

    public static boolean c(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollHorizontally(view, -1) : invokeCommon.booleanValue;
    }

    public static boolean d(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? (view == null || !a(view, f2, f3)) ? z : ViewCompat.canScrollVertically(view, -1) : invokeCommon.booleanValue;
    }

    public static View a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, viewGroup)) == null) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    if (a(childAt)) {
                        return childAt;
                    }
                    if ((childAt instanceof ViewGroup) && (a = a((ViewGroup) childAt)) != null) {
                        return a;
                    }
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static boolean a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) ? (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || (view instanceof NestedScrollView) || (view instanceof AbsListView) || (view instanceof ViewPager) || (view instanceof WebView) : invokeL.booleanValue;
    }

    public static boolean a(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            return rect.contains((int) f2, (int) f3);
        }
        return invokeCommon.booleanValue;
    }
}
