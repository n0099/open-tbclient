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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static View a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, viewGroup)) == null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
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

    public static boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            if (!(view2 instanceof ScrollView) && !(view2 instanceof HorizontalScrollView) && !(view2 instanceof NestedScrollView) && !(view2 instanceof AbsListView) && !(view2 instanceof ViewPager) && !(view2 instanceof WebView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            return rect.contains((int) f, (int) f2);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(View view2, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (view2 != null && a(view2, f, f2)) {
                return ViewCompat.canScrollVertically(view2, 1);
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(View view2, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (view2 != null && a(view2, f, f2)) {
                return ViewCompat.canScrollHorizontally(view2, 1);
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean c(View view2, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (view2 != null && a(view2, f, f2)) {
                return ViewCompat.canScrollHorizontally(view2, -1);
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean d(View view2, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (view2 != null && a(view2, f, f2)) {
                return ViewCompat.canScrollVertically(view2, -1);
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }
}
