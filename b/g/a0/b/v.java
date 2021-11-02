package b.g.a0.b;

import android.app.Activity;
import android.view.View;
import b.g.a0.b.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.channel.model.gdt.GDTNativeUnifiedVideoView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes6.dex */
public class v implements FunNativeAd2Bridger<NativeUnifiedADData, com.fun.module.gdt.x> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final o.c f30951a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f30952b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f30953c;

    public v(o oVar, NativeUnifiedADData nativeUnifiedADData, String str, c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar, nativeUnifiedADData, str, c0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30953c = oVar;
        this.f30952b = c0Var;
        this.f30951a = new o.c(oVar, nativeUnifiedADData, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.gdt.x, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.x createExpressView(NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nativeUnifiedADData)) == null) ? this.f30953c.b(FunAdSdk.getAppContext(), nativeUnifiedADData) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, NativeUnifiedADData nativeUnifiedADData, BaseNativeAd2<NativeUnifiedADData, com.fun.module.gdt.x> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, nativeUnifiedADData, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.f30952b.f30913c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.f30951a.f30938d = new t(this, gdtADStatusChangeListener, nativeUnifiedADData2);
            } else {
                this.f30951a.f30938d = null;
            }
            this.f30953c.f(nativeUnifiedADData2, str, customInflater.getGdtNativeAdContainer(), this.f30952b.f30914d, customInflater.getClickViews(), this.f30951a, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, NativeUnifiedADData nativeUnifiedADData, BaseNativeAd2<NativeUnifiedADData, com.fun.module.gdt.x> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, nativeUnifiedADData, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            com.fun.module.gdt.x xVar = (com.fun.module.gdt.x) expressInflater.getExpressView();
            o oVar = this.f30953c;
            FunNativeAdListenerHelper<NativeUnifiedADData, NativeADEventListener> funNativeAdListenerHelper = oVar.f30931h;
            pid = oVar.mPid;
            funNativeAdListenerHelper.startShow(nativeUnifiedADData2, str, pid, this.f30951a, funAdInteractionListener);
            o.c cVar = this.f30951a;
            cVar.f30938d = new u(this, xVar, nativeUnifiedADData2);
            o oVar2 = this.f30953c;
            oVar2.getClass();
            if (xVar instanceof GDTNativeUnifiedVideoView) {
                ((GDTNativeUnifiedVideoView) xVar).setVideoOnClickListener(new q(oVar2));
            }
            nativeUnifiedADData2.setNativeAdEventListener(cVar);
            xVar.a(nativeUnifiedADData2);
            expressInflater.inflate();
        }
    }
}
