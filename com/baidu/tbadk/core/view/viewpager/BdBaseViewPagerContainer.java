package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.s.l0.u.a;
import c.a.t0.s.l0.u.b;
import c.a.u0.a4.d;
import c.a.u0.a4.f;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f40975e;

    /* renamed from: f  reason: collision with root package name */
    public a f40976f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdBaseViewPagerContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        b(context, this, true);
    }

    public final void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdBaseViewPagerContainerHolder) == null) || bdBaseViewPagerContainerHolder == null) {
            return;
        }
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.getView(), d.CAM_X0201);
        SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.title, d.CAM_X0108, 1);
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.divilerLine, d.CAM_X0204);
        SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.mMoreView, d.CAM_X0109, 1);
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.mMoreView, d.CAM_X0201);
        bdBaseViewPagerContainerHolder.mMoreView.setText(TbadkCoreApplication.getInst().getString(j.recommend_frs_hot_thread_more));
        bdBaseViewPagerContainerHolder.mIndicatorView.setSelector(SkinManager.getDrawable(f.icon_choose_dot_s));
        bdBaseViewPagerContainerHolder.mIndicatorView.setDrawable(SkinManager.getDrawable(f.icon_choose_dot_n));
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup, z) == null) {
            BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(h.bd_base_viewpager_container, viewGroup, z), context);
            this.f40975e = bdBaseViewPagerContainerHolder;
            a(bdBaseViewPagerContainerHolder);
            BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f40975e;
            this.f40976f = new a(context, bdBaseViewPagerContainerHolder2.mViewPager, bdBaseViewPagerContainerHolder2.mIndicatorView, bdBaseViewPagerContainerHolder2.mMoreView, 4, false, true);
        }
    }

    public IndicatorView getIndicatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40975e.mIndicatorView : (IndicatorView) invokeV.objValue;
    }

    public TextView getMoreView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40975e.mMoreView : (TextView) invokeV.objValue;
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40975e.getView() : (View) invokeV.objValue;
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40975e : (BdBaseViewPagerContainerHolder) invokeV.objValue;
    }

    public BdBaseViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40975e.mViewPager : (BdBaseViewPager) invokeV.objValue;
    }

    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f40976f.i();
        }
    }

    public void onSkinTypeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = this.f40975e;
            if (i2 != bdBaseViewPagerContainerHolder.skinType) {
                a(bdBaseViewPagerContainerHolder);
                this.f40976f.j(i2);
                this.f40975e.skinType = i2;
            }
        }
    }

    public void registerAdapter(Context context, b<?, ?> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, bVar) == null) {
            this.f40976f.k(context, bVar);
        }
    }

    public void registerAdapters(Context context, List<b<?, ?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, list) == null) {
            this.f40976f.l(context, list);
        }
    }

    public void setAutoScrollIntervalTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.f40976f.m(j2);
        }
    }

    public void setDatas(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f40976f.n(list);
        }
    }

    public void setIsAutoScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f40976f.o(z);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f40976f.p(z);
        }
    }

    public void setMaxScrollCountLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f40976f.q(i2);
        }
    }

    public void startAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f40976f.r();
        }
    }

    public void stopAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f40976f.s();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context, this, true);
    }
}
