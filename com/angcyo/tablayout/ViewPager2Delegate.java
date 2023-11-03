package com.angcyo.tablayout;

import androidx.viewpager2.widget.ViewPager2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.u0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J(\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/angcyo/tablayout/ViewPager2Delegate;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "Lcom/angcyo/tablayout/ViewPagerDelegate;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "dslTabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "forceSmoothScroll", "", "(Landroidx/viewpager2/widget/ViewPager2;Lcom/angcyo/tablayout/DslTabLayout;Ljava/lang/Boolean;)V", "getDslTabLayout", "()Lcom/angcyo/tablayout/DslTabLayout;", "getForceSmoothScroll", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "onGetCurrentItem", "", "onPageScrollStateChanged", "", "state", "onPageScrolled", CriusAttrConstants.POSITION, "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onSetCurrentItem", "fromIndex", "toIndex", "reselect", "fromUser", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class ViewPager2Delegate extends ViewPager2.OnPageChangeCallback implements u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewPager2 a;
    public final DslTabLayout b;
    public final Boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-337064100, "Lcom/angcyo/tablayout/ViewPager2Delegate;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-337064100, "Lcom/angcyo/tablayout/ViewPager2Delegate;");
        }
    }

    @Override // com.baidu.tieba.u0
    public void a(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z2) {
            Boolean bool = this.c;
            boolean z3 = true;
            if (bool != null) {
                z3 = bool.booleanValue();
            } else if (Math.abs(i2 - i) > 1) {
                z3 = false;
            }
            this.a.setCurrentItem(i2, z3);
        }
    }

    @Override // com.baidu.tieba.u0
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.getCurrentItem();
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        DslTabLayout dslTabLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (dslTabLayout = this.b) != null) {
            dslTabLayout.u(i);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        DslTabLayout dslTabLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (dslTabLayout = this.b) != null) {
            dslTabLayout.w(i);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        DslTabLayout dslTabLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && (dslTabLayout = this.b) != null) {
            dslTabLayout.v(i, f, i2);
        }
    }
}
