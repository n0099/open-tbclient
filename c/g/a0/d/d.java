package c.g.a0.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    public RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        List<AdTemplate> list;
        AdInfo adInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("a");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null) {
                    return null;
                }
                AdResultData adResultData = new com.fun.module.ks.q(obj2).a;
                if ((adResultData != null) && (list = adResultData.adTemplateList) != null && !list.isEmpty()) {
                    AdTemplate adTemplate = list.get(0);
                    List<AdInfo> list2 = adTemplate == null ? null : adTemplate.adInfoList;
                    if (list2 == null || list2.isEmpty() || (adInfo = list2.get(0)) == null) {
                        return null;
                    }
                    return e.a(adInfo);
                }
                return null;
            } catch (Exception e2) {
                LogPrinter.e(e2);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
