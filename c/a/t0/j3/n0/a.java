package c.a.t0.j3.n0;

import androidx.annotation.Nullable;
import c.a.t0.j3.e0.c;
import c.a.t0.j3.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.recapp.view.AdVideoFlowView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.v.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f18999b;

    /* renamed from: c  reason: collision with root package name */
    public Map<AdvertAppInfo, AdVideoFlowView> f19000c;

    public a(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.a.t0.v.e.a aVar2 = new c.a.t0.v.e.a(PlaceId.VIDEO_FLOW, "VIDEO_FLOW", aVar);
        this.a = aVar2;
        aVar2.f(false);
        this.f19000c = new HashMap();
    }

    @Override // c.a.t0.j3.e0.c
    public void a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f18999b = tbPageContext;
        }
    }

    @Override // c.a.t0.j3.e0.c
    public void b(AdvertAppInfo advertAppInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z) == null) {
            AdVideoFlowView adVideoFlowView = this.f19000c.get(advertAppInfo);
            if (adVideoFlowView != null) {
                adVideoFlowView.onPageSelected(z);
            }
            for (AdVideoFlowView adVideoFlowView2 : this.f19000c.values()) {
                if (adVideoFlowView2 != adVideoFlowView) {
                    adVideoFlowView2.onPageSelected(false);
                }
            }
        }
    }

    @Override // c.a.t0.j3.e0.c
    @Nullable
    public m j(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo)) == null) {
            if (this.f18999b == null) {
                return null;
            }
            AdVideoFlowView adVideoFlowView = this.f19000c.get(advertAppInfo);
            if (adVideoFlowView == null) {
                adVideoFlowView = new AdVideoFlowView(this.f18999b.getPageActivity());
                this.f19000c.put(advertAppInfo, adVideoFlowView);
            }
            adVideoFlowView.setPageContext(this.f18999b);
            adVideoFlowView.setData(advertAppInfo);
            return adVideoFlowView;
        }
        return (m) invokeL.objValue;
    }

    @Override // c.a.t0.j3.e0.c
    public void loadAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.d(1, null);
        }
    }

    @Override // c.a.t0.j3.e0.c
    public void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, advertAppInfo) == null) {
            this.f19000c.remove(advertAppInfo);
        }
    }
}
