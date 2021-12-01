package c.a.r0.f1;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d implements c.a.r0.e1.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // c.a.r0.e1.d
    public c.a.d.m.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.G4) {
                c.a.r0.f1.e.b bVar = new c.a.r0.f1.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0(c.a.r0.e1.e.c.e().d("pb_banner"));
                bVar.j0("pb");
                bVar.k0("pb_banner");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.J4) {
                c.a.r0.f1.e.b bVar2 = new c.a.r0.f1.e.b(baseFragmentActivity, bdUniqueId);
                bVar2.l0("6051002523-210422477");
                bVar2.j0("pb");
                return bVar2;
            } else if (bdUniqueId == AdvertAppInfo.H4) {
                return new c.a.r0.f1.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (c.a.d.m.e.a) invokeLL.objValue;
    }

    @Override // c.a.r0.e1.d
    public c.a.d.m.e.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.I4) {
                c.a.r0.f1.e.b bVar = new c.a.r0.f1.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0(c.a.r0.e1.e.c.e().d("frs_feed"));
                bVar.j0("frs");
                bVar.k0("frs_feed");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.H4) {
                return new c.a.r0.f1.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (c.a.d.m.e.a) invokeLL.objValue;
    }

    @Override // c.a.r0.e1.d
    public c.a.d.m.e.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.I4) {
                c.a.r0.f1.e.b bVar = new c.a.r0.f1.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0("6051001980-1210572494");
                bVar.j0("personalize");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.H4) {
                return new c.a.r0.f1.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (c.a.d.m.e.a) invokeLL.objValue;
    }

    @Override // c.a.r0.e1.d
    public c.a.d.m.e.a<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.I4) {
                c.a.r0.f1.e.b bVar = new c.a.r0.f1.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0(c.a.r0.e1.e.c.e().d("frs_feed"));
                bVar.j0("frs");
                bVar.k0("frs_feed");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.H4) {
                return new c.a.r0.f1.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (c.a.d.m.e.a) invokeLL.objValue;
    }
}
