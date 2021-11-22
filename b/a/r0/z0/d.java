package b.a.r0.z0;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d implements b.a.r0.y0.d {
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

    @Override // b.a.r0.y0.d
    public b.a.e.m.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.B4) {
                b.a.r0.z0.e.b bVar = new b.a.r0.z0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0(b.a.r0.y0.e.c.e().d("pb_banner"));
                bVar.j0("pb");
                bVar.k0("pb_banner");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.E4) {
                b.a.r0.z0.e.b bVar2 = new b.a.r0.z0.e.b(baseFragmentActivity, bdUniqueId);
                bVar2.l0("6051002523-210422477");
                bVar2.j0("pb");
                return bVar2;
            } else if (bdUniqueId == AdvertAppInfo.C4) {
                return new b.a.r0.z0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (b.a.e.m.e.a) invokeLL.objValue;
    }

    @Override // b.a.r0.y0.d
    public b.a.e.m.e.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.D4) {
                b.a.r0.z0.e.b bVar = new b.a.r0.z0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0(b.a.r0.y0.e.c.e().d("frs_feed"));
                bVar.j0("frs");
                bVar.k0("frs_feed");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.C4) {
                return new b.a.r0.z0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (b.a.e.m.e.a) invokeLL.objValue;
    }

    @Override // b.a.r0.y0.d
    public b.a.e.m.e.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.D4) {
                b.a.r0.z0.e.b bVar = new b.a.r0.z0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0("6051001980-1210572494");
                bVar.j0("personalize");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.C4) {
                return new b.a.r0.z0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (b.a.e.m.e.a) invokeLL.objValue;
    }

    @Override // b.a.r0.y0.d
    public b.a.e.m.e.a<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.D4) {
                b.a.r0.z0.e.b bVar = new b.a.r0.z0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.l0(b.a.r0.y0.e.c.e().d("frs_feed"));
                bVar.j0("frs");
                bVar.k0("frs_feed");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.C4) {
                return new b.a.r0.z0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (b.a.e.m.e.a) invokeLL.objValue;
    }
}
