package a.a.a.a.r.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsFullScreenVideoAd;
/* loaded from: classes.dex */
public class d implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1257a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1258b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFullScreenVideoAd f1259c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1260d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c f1261e;

    public d(c cVar, KsFullScreenVideoAd ksFullScreenVideoAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, ksFullScreenVideoAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1261e = cVar;
        this.f1259c = ksFullScreenVideoAd;
        this.f1260d = str;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.v.d.a();
            this.f1261e.f1015h.a(this.f1258b);
            this.f1258b = true;
            this.f1261e.e();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.v.d.a();
            this.f1261e.f1015h.d();
            this.f1261e.f();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a.a.a.v.d.a();
            this.f1261e.f1015h.n();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.v.d.a();
            this.f1261e.f1015h.j();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            a.a.a.a.v.d.b("onVideoPlayError code:%d extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            this.f1261e.f1015h.k();
            this.f1261e.a(i2, String.valueOf(i3));
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a.a.a.a.v.d.a();
            this.f1261e.f1015h.o();
            this.f1261e.f1015h.b(this.f1257a);
            this.f1257a = true;
            this.f1261e.a((c) this.f1259c, this.f1260d);
        }
    }
}
