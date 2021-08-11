package b.a.a.a.t.a.f;

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
    public boolean f1343a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFeedAd f1345c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1346d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f1347e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f1348f;

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
        this.f1348f = eVar;
        this.f1345c = ksFeedAd;
        this.f1346d = str;
        this.f1347e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.a.a.x.d.a();
            this.f1348f.f1057h.f(this.f1344b);
            this.f1344b = true;
            this.f1348f.r();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.a.a.x.d.a();
            this.f1348f.f1057h.k(this.f1343a);
            this.f1343a = true;
            this.f1348f.i(this.f1345c, this.f1346d);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.a.a.x.d.a();
            this.f1348f.f1057h.r();
            View view = this.f1347e;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f1347e.getParent()).removeView(this.f1347e);
            }
            this.f1348f.s();
        }
    }
}
