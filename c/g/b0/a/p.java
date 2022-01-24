package c.g.b0.a;

import android.app.Activity;
import android.view.View;
import c.g.b0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes9.dex */
public class p implements FunNativeAd2Bridger<TTNativeAd, com.fun.module.csj.e0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f28244b;

    public p(k kVar, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, tTNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28244b = kVar;
        this.a = new k.b(kVar, tTNativeAd);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.csj.e0, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.csj.e0 createExpressView(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tTNativeAd)) == null) ? l.a(tTNativeAd) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, TTNativeAd tTNativeAd, BaseNativeAd2<TTNativeAd, com.fun.module.csj.e0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, tTNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            this.f28244b.c(activity, tTNativeAd, str, customInflater.inflate(), customInflater.getClickViews(), customInflater.getCreativeViews(), this.a, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, TTNativeAd tTNativeAd, BaseNativeAd2<TTNativeAd, com.fun.module.csj.e0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, tTNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            TTNativeAd tTNativeAd2 = tTNativeAd;
            k kVar = this.f28244b;
            FunNativeAdListenerHelper<TTNativeAd, TTNativeAd.AdInteractionListener> funNativeAdListenerHelper = kVar.f28220i;
            pid = kVar.mPid;
            funNativeAdListenerHelper.startShow(tTNativeAd2, str, pid, this.a, funAdInteractionListener);
            k kVar2 = this.f28244b;
            kVar2.getClass();
            kVar2.b(activity, tTNativeAd2, expressInflater.inflate(), baseNativeAd2.getExpressView(), new n(kVar2, funAdInteractionListener, str, tTNativeAd2));
        }
    }
}
