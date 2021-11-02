package b.a.r0.z2.n0;

import androidx.annotation.Nullable;
import b.a.r0.z2.e0.c;
import b.a.r0.z2.m;
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
/* loaded from: classes6.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.r.c.a f28243a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f28244b;

    /* renamed from: c  reason: collision with root package name */
    public Map<AdvertAppInfo, AdVideoFlowView> f28245c;

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
        b.a.r0.r.c.a aVar2 = new b.a.r0.r.c.a(PlaceId.VIDEO_FLOW, "VIDEO_FLOW", aVar);
        this.f28243a = aVar2;
        aVar2.f(false);
        this.f28245c = new HashMap();
    }

    @Override // b.a.r0.z2.e0.c
    public void a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f28244b = tbPageContext;
        }
    }

    @Override // b.a.r0.z2.e0.c
    public void b(AdvertAppInfo advertAppInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z) == null) {
            AdVideoFlowView adVideoFlowView = this.f28245c.get(advertAppInfo);
            if (adVideoFlowView != null) {
                adVideoFlowView.onPageSelected(z);
            }
            for (AdVideoFlowView adVideoFlowView2 : this.f28245c.values()) {
                if (adVideoFlowView2 != adVideoFlowView) {
                    adVideoFlowView2.onPageSelected(false);
                }
            }
        }
    }

    @Override // b.a.r0.z2.e0.c
    @Nullable
    public m j(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo)) == null) {
            if (this.f28244b == null) {
                return null;
            }
            AdVideoFlowView adVideoFlowView = this.f28245c.get(advertAppInfo);
            if (adVideoFlowView == null) {
                adVideoFlowView = new AdVideoFlowView(this.f28244b.getPageActivity());
                this.f28245c.put(advertAppInfo, adVideoFlowView);
            }
            adVideoFlowView.setPageContext(this.f28244b);
            adVideoFlowView.setData(advertAppInfo);
            return adVideoFlowView;
        }
        return (m) invokeL.objValue;
    }

    @Override // b.a.r0.z2.e0.c
    public void loadAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f28243a.d(1, null);
        }
    }

    @Override // b.a.r0.z2.e0.c
    public void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, advertAppInfo) == null) {
            this.f28245c.remove(advertAppInfo);
        }
    }
}
