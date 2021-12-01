package c.a.r0.a0.g.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends c.a.q0.i0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaFrsLiveFragment a;

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AlaFrsLiveFragment alaFrsLiveFragment = new AlaFrsLiveFragment();
        this.a = alaFrsLiveFragment;
        alaFrsLiveFragment.setIsNeedScrollDispatch(z);
        getFragmentTabStructure().a = this.a;
    }

    public void a(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (alaFrsLiveFragment = this.a) == null) {
            return;
        }
        alaFrsLiveFragment.setForumGameLabel(str);
    }

    public void b(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (alaFrsLiveFragment = this.a) == null) {
            return;
        }
        alaFrsLiveFragment.setForumId(str);
    }

    public void c(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (alaFrsLiveFragment = this.a) == null) {
            return;
        }
        alaFrsLiveFragment.setForumName(str);
    }

    @Override // c.a.q0.i0.b
    public c.a.q0.i0.c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.q0.i0.c cVar = new c.a.q0.i0.c();
            cVar.f12326e = 2;
            cVar.f12323b = R.string.ala_live;
            cVar.f12330i = c.a.q0.i0.c.f12322k;
            return cVar;
        }
        return (c.a.q0.i0.c) invokeV.objValue;
    }

    public void d(int i2) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (alaFrsLiveFragment = this.a) == null) {
            return;
        }
        alaFrsLiveFragment.setFromType(i2);
    }

    public void e(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alaFrsLiveFragment = this.a) == null) {
            return;
        }
        alaFrsLiveFragment.setIsShowNavi(z);
    }

    @Override // c.a.q0.i0.b
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

    @Override // c.a.q0.i0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
