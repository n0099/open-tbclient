package a.a.a.a.u.a.e;

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
    public boolean f1287a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1288b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsSplashScreenAd f1289c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1290d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1291e;

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
        this.f1291e = lVar;
        this.f1289c = ksSplashScreenAd;
        this.f1290d = str;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.y.d.a();
            this.f1291e.f1017h.a(this.f1288b);
            this.f1288b = true;
            this.f1291e.e();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.y.d.a();
            this.f1291e.f1017h.d();
            this.f1291e.f();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            a.a.a.a.y.d.b("onAdShowError code: " + i2 + ", message: " + str, new Object[0]);
            this.f1291e.f1017h.b(Integer.valueOf(i2));
            this.f1291e.a(i2, str);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.y.d.a();
            this.f1291e.f1017h.b(this.f1287a);
            this.f1287a = true;
            this.f1291e.a((l) this.f1289c, this.f1290d);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a.a.a.a.y.d.a();
            this.f1291e.f1017h.h();
            this.f1291e.f();
        }
    }
}
