package c.a.r0.a0.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.a.q0.i0.b;
import c.a.q0.i0.c;
import c.a.r0.d1.j0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaGameFrsLiveTabFragment a;

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
        this.a = new AlaGameFrsLiveTabFragment();
        getFragmentTabStructure().a = this.a;
    }

    public void a(j0 j0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, j0Var) == null) && j0Var != null && j0Var.h(2)) {
            j0Var.a(this);
        }
    }

    public void b(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (alaGameFrsLiveTabFragment = this.a) == null) {
            return;
        }
        alaGameFrsLiveTabFragment.setForumGameLabel(str);
    }

    public void c(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (alaGameFrsLiveTabFragment = this.a) == null) {
            return;
        }
        alaGameFrsLiveTabFragment.setForumId(str);
    }

    @Override // c.a.q0.i0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = new c();
            cVar.f12326e = 2;
            cVar.f12323b = R.string.ala_live;
            cVar.f12330i = c.f12322k;
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public void d(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (alaGameFrsLiveTabFragment = this.a) == null) {
            return;
        }
        alaGameFrsLiveTabFragment.setForumName(str);
    }

    @Override // c.a.q0.i0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.mIndicator = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // c.a.q0.i0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
