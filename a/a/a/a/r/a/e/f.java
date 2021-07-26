package a.a.a.a.r.a.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsFeedAd;
/* loaded from: classes.dex */
public class f implements KsFeedAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1264a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1265b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFeedAd f1266c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1267d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f1268e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f1269f;

    public f(e eVar, KsFeedAd ksFeedAd, String str, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, ksFeedAd, str, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1269f = eVar;
        this.f1266c = ksFeedAd;
        this.f1267d = str;
        this.f1268e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.v.d.a();
            this.f1269f.f1015h.a(this.f1265b);
            this.f1265b = true;
            this.f1269f.e();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.v.d.a();
            this.f1269f.f1015h.b(this.f1264a);
            this.f1264a = true;
            this.f1269f.a((e) this.f1266c, this.f1267d);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a.a.a.v.d.a();
            this.f1269f.f1015h.i();
            View view = this.f1268e;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f1268e.getParent()).removeView(this.f1268e);
            }
            this.f1269f.f();
        }
    }
}
