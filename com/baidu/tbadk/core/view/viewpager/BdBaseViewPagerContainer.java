package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.f0.t.a;
import java.util.List;
/* loaded from: classes4.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerContainerHolder f12764e;

    /* renamed from: f  reason: collision with root package name */
    public a f12765f;

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
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.a(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12767b, R.color.CAM_X0108, 1);
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12770e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.f12768c, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.f12768c, R.color.CAM_X0201);
        bdBaseViewPagerContainerHolder.f12768c.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
        bdBaseViewPagerContainerHolder.f12769d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
        bdBaseViewPagerContainerHolder.f12769d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup, z) == null) {
            BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
            this.f12764e = bdBaseViewPagerContainerHolder;
            a(bdBaseViewPagerContainerHolder);
            BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.f12764e;
            this.f12765f = new a(context, bdBaseViewPagerContainerHolder2.f12771f, bdBaseViewPagerContainerHolder2.f12769d, bdBaseViewPagerContainerHolder2.f12768c, 4, false, true);
        }
    }

    public IndicatorView getIndicatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12764e.f12769d : (IndicatorView) invokeV.objValue;
    }

    public TextView getMoreView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12764e.f12768c : (TextView) invokeV.objValue;
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12764e.a() : (View) invokeV.objValue;
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12764e : (BdBaseViewPagerContainerHolder) invokeV.objValue;
    }

    public BdBaseViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12764e.f12771f : (BdBaseViewPager) invokeV.objValue;
    }

    public void setAutoScrollIntervalTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f12765f.j(j);
        }
    }

    public void setDatas(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f12765f.k(list);
        }
    }

    public void setIsAutoScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f12765f.l(z);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f12765f.m(z);
        }
    }

    public void setMaxScrollCountLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f12765f.n(i2);
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
