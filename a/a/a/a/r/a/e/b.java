package a.a.a.a.r.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsDrawAd;
/* loaded from: classes.dex */
public class b implements KsDrawAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1250a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsDrawAd f1252c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1253d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1254e;

    public b(a aVar, KsDrawAd ksDrawAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, ksDrawAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1254e = aVar;
        this.f1252c = ksDrawAd;
        this.f1253d = str;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.v.d.a();
            this.f1254e.f1015h.a(this.f1251b);
            this.f1251b = true;
            this.f1254e.e();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.v.d.a();
            this.f1254e.f1015h.b(this.f1250a);
            this.f1250a = true;
            this.f1254e.a((a) this.f1252c, this.f1253d);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1254e.f1015h.j();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.v.d.b();
            this.f1254e.f1015h.k();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1254e.f1015h.l();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f1254e.f1015h.m();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1254e.f1015h.o();
        }
    }
}
