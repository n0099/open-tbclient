package a.a.a.a.u.a.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
/* loaded from: classes.dex */
public class f implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f1121a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1122b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f1123c;

    public f(d dVar, TTNativeAd tTNativeAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, tTNativeAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1123c = dVar;
        this.f1121a = tTNativeAd;
        this.f1122b = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
            a.a.a.a.y.d.a();
            this.f1123c.o.b(this.f1121a);
            this.f1123c.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
            a.a.a.a.y.d.a();
            this.f1123c.o.b(this.f1121a);
            this.f1123c.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            a.a.a.a.y.d.a();
            this.f1123c.o.c(this.f1121a);
            this.f1123c.a((d) this.f1121a, this.f1122b);
        }
    }
}
