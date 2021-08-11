package b.a.a.a.t.a.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes.dex */
public class m implements KsSplashScreenAd.SplashScreenAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1368a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1369b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsSplashScreenAd f1370c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1371d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1372e;

    public m(l lVar, KsSplashScreenAd ksSplashScreenAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, ksSplashScreenAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1372e = lVar;
        this.f1370c = ksSplashScreenAd;
        this.f1371d = str;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.a.a.x.d.a();
            this.f1372e.f1057h.f(this.f1369b);
            this.f1369b = true;
            this.f1372e.r();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.a.a.x.d.a();
            this.f1372e.f1057h.m();
            this.f1372e.s();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            b.a.a.a.x.d.f("onAdShowError code: " + i2 + ", message: " + str, new Object[0]);
            this.f1372e.f1057h.j(Integer.valueOf(i2));
            this.f1372e.g(i2, str);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.a.a.x.d.a();
            this.f1372e.f1057h.k(this.f1368a);
            this.f1368a = true;
            this.f1372e.i(this.f1370c, this.f1371d);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.a.a.x.d.a();
            this.f1372e.f1057h.q();
            this.f1372e.s();
        }
    }
}
