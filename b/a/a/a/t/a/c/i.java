package b.a.a.a.t.a.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
/* loaded from: classes.dex */
public class i implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1172a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f1174c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1175d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f1176e;

    public i(h hVar, TTNativeAd tTNativeAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, tTNativeAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1176e = hVar;
        this.f1174c = tTNativeAd;
        this.f1175d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
            b.a.a.a.x.d.a();
            this.f1176e.f1057h.f(this.f1173b);
            this.f1173b = true;
            this.f1176e.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
            b.a.a.a.x.d.a();
            this.f1176e.f1057h.f(this.f1173b);
            this.f1173b = true;
            this.f1176e.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            b.a.a.a.x.d.a();
            this.f1176e.f1057h.k(this.f1172a);
            this.f1172a = true;
            this.f1176e.i(this.f1174c, this.f1175d);
        }
    }
}
