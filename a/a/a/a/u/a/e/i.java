package a.a.a.a.u.a.e;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes.dex */
public class i implements KsNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f1275a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1276b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f1277c;

    public i(g gVar, KsNativeAd ksNativeAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, ksNativeAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1277c = gVar;
        this.f1275a = ksNativeAd;
        this.f1276b = str;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, ksNativeAd) == null) {
            this.f1277c.n.b(this.f1275a);
            this.f1277c.e();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksNativeAd) == null) {
            this.f1277c.n.c(this.f1275a);
            this.f1277c.a((g) this.f1275a, this.f1276b);
        }
    }
}
