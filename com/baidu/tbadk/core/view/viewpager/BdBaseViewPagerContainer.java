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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.sz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdBaseViewPagerContainerHolder a;
    public sz4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdBaseViewPagerContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.getView(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.b, R.color.CAM_X0108, 1);
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(bdBaseViewPagerContainerHolder.c, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundColor(bdBaseViewPagerContainerHolder.c, R.color.CAM_X0201);
        bdBaseViewPagerContainerHolder.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc2));
        bdBaseViewPagerContainerHolder.d.setSelector(SkinManager.getDrawable(R.drawable.icon_choose_dot_s));
        bdBaseViewPagerContainerHolder.d.setDrawable(SkinManager.getDrawable(R.drawable.icon_choose_dot_n));
    }

    public final void b(Context context, ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup, z) == null) {
            BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d014a, viewGroup, z), context);
            this.a = bdBaseViewPagerContainerHolder;
            a(bdBaseViewPagerContainerHolder);
            BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder2 = this.a;
            this.b = new sz4(context, bdBaseViewPagerContainerHolder2.f, bdBaseViewPagerContainerHolder2.d, bdBaseViewPagerContainerHolder2.c, 4, false, true);
        }
    }

    public IndicatorView getIndicatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.d : (IndicatorView) invokeV.objValue;
    }

    public TextView getMoreView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.c : (TextView) invokeV.objValue;
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getView() : (View) invokeV.objValue;
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (BdBaseViewPagerContainerHolder) invokeV.objValue;
    }

    public BdBaseViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.f : (BdBaseViewPager) invokeV.objValue;
    }

    public void setAutoScrollIntervalTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.b.j(j);
        }
    }

    public void setDatas(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.b.k(list);
        }
    }

    public void setIsAutoScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.b.l(z);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.b.m(z);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.b.n(i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
