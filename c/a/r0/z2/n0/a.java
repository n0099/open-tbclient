package c.a.r0.z2.n0;

import androidx.annotation.Nullable;
import c.a.r0.z2.e0.c;
import c.a.r0.z2.m;
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
/* loaded from: classes4.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.r.c.a f29840a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f29841b;

    /* renamed from: c  reason: collision with root package name */
    public Map<AdvertAppInfo, AdVideoFlowView> f29842c;

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
        c.a.r0.r.c.a aVar2 = new c.a.r0.r.c.a(PlaceId.VIDEO_FLOW, "VIDEO_FLOW", aVar);
        this.f29840a = aVar2;
        aVar2.f(false);
        this.f29842c = new HashMap();
    }

    @Override // c.a.r0.z2.e0.c
    public void a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f29841b = tbPageContext;
        }
    }

    @Override // c.a.r0.z2.e0.c
    public void b(AdvertAppInfo advertAppInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z) == null) {
            AdVideoFlowView adVideoFlowView = this.f29842c.get(advertAppInfo);
            if (adVideoFlowView != null) {
                adVideoFlowView.onPageSelected(z);
            }
            for (AdVideoFlowView adVideoFlowView2 : this.f29842c.values()) {
                if (adVideoFlowView2 != adVideoFlowView) {
                    adVideoFlowView2.onPageSelected(false);
                }
            }
        }
    }

    @Override // c.a.r0.z2.e0.c
    @Nullable
    public m k(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo)) == null) {
            if (this.f29841b == null) {
                return null;
            }
            AdVideoFlowView adVideoFlowView = this.f29842c.get(advertAppInfo);
            if (adVideoFlowView == null) {
                adVideoFlowView = new AdVideoFlowView(this.f29841b.getPageActivity());
                this.f29842c.put(advertAppInfo, adVideoFlowView);
            }
            adVideoFlowView.setPageContext(this.f29841b);
            adVideoFlowView.setData(advertAppInfo);
            return adVideoFlowView;
        }
        return (m) invokeL.objValue;
    }

    @Override // c.a.r0.z2.e0.c
    public void loadAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29840a.d(1, null);
        }
    }

    @Override // c.a.r0.z2.e0.c
    public void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, advertAppInfo) == null) {
            this.f29842c.remove(advertAppInfo);
        }
    }
}
