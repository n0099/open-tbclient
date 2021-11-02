package b.g.a0.a;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class s implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30866a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30867b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f30868c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ r f30869d;

    public s(r rVar, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar, tTNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30869d = rVar;
        this.f30868c = tTNativeAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            adReporter = this.f30869d.mReporter;
            adReporter.recordOnClicked(this.f30867b);
            this.f30867b = true;
            this.f30869d.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            adReporter = this.f30869d.mReporter;
            adReporter.recordOnClicked(this.f30867b);
            this.f30867b = true;
            this.f30869d.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            LogPrinter.d();
            adReporter = this.f30869d.mReporter;
            adReporter.recordShowSucceed(this.f30866a);
            this.f30866a = true;
            this.f30869d.onAdShow(this.f30868c);
        }
    }
}
