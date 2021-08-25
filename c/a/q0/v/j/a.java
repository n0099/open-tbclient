package c.a.q0.v.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.a.p0.g0.b;
import c.a.p0.g0.c;
import c.a.q0.v0.i0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.AlaPersonCenterFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaPersonCenterFragment f25621a;

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
                return;
            }
        }
        this.f25621a = new AlaPersonCenterFragment();
        getFragmentTabStructure().f13476a = this.f25621a;
    }

    public void a(i0 i0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, i0Var) == null) && i0Var != null && i0Var.i(5)) {
            i0Var.a(this);
        }
    }

    public void b(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (alaPersonCenterFragment = this.f25621a) == null) {
            return;
        }
        alaPersonCenterFragment.setForumGameLabel(str);
    }

    public void c(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (alaPersonCenterFragment = this.f25621a) == null) {
            return;
        }
        alaPersonCenterFragment.setForumId(str);
    }

    @Override // c.a.p0.g0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = new c();
            cVar.f13480e = 5;
            cVar.f13477b = R.string.ala_live;
            cVar.f13484i = c.k;
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public void d(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (alaPersonCenterFragment = this.f25621a) == null) {
            return;
        }
        alaPersonCenterFragment.setForumName(str);
    }

    public void e(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (alaPersonCenterFragment = this.f25621a) == null) {
            return;
        }
        alaPersonCenterFragment.setForumType(str);
    }

    @Override // c.a.p0.g0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.mIndicator = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // c.a.p0.g0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
