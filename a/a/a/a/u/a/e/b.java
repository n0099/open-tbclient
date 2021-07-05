package a.a.a.a.u.a.e;

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
    public boolean f1248a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1249b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsDrawAd f1250c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1251d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1252e;

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
        this.f1252e = aVar;
        this.f1250c = ksDrawAd;
        this.f1251d = str;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.y.d.a();
            this.f1252e.f1017h.a(this.f1249b);
            this.f1249b = true;
            this.f1252e.e();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.y.d.a();
            this.f1252e.f1017h.b(this.f1248a);
            this.f1248a = true;
            this.f1252e.a((a) this.f1250c, this.f1251d);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1252e.f1017h.j();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.y.d.b();
            this.f1252e.f1017h.k();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1252e.f1017h.l();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f1252e.f1017h.m();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1252e.f1017h.o();
        }
    }
}
