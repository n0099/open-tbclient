package a.a.a.a.u.a.e;

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
    public boolean f1262a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFeedAd f1264c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1265d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f1266e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f1267f;

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
        this.f1267f = eVar;
        this.f1264c = ksFeedAd;
        this.f1265d = str;
        this.f1266e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.y.d.a();
            this.f1267f.f1017h.a(this.f1263b);
            this.f1263b = true;
            this.f1267f.e();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.y.d.a();
            this.f1267f.f1017h.b(this.f1262a);
            this.f1262a = true;
            this.f1267f.a((e) this.f1264c, this.f1265d);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a.a.a.y.d.a();
            this.f1267f.f1017h.i();
            View view = this.f1266e;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f1266e.getParent()).removeView(this.f1266e);
            }
            this.f1267f.f();
        }
    }
}
