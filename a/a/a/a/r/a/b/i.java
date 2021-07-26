package a.a.a.a.r.a.b;

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
    public boolean f1116a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1117b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f1118c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1119d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f1120e;

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
        this.f1120e = hVar;
        this.f1118c = tTNativeAd;
        this.f1119d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
            a.a.a.a.v.d.a();
            this.f1120e.f1015h.a(this.f1117b);
            this.f1117b = true;
            this.f1120e.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
            a.a.a.a.v.d.a();
            this.f1120e.f1015h.a(this.f1117b);
            this.f1117b = true;
            this.f1120e.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            a.a.a.a.v.d.a();
            this.f1120e.f1015h.b(this.f1116a);
            this.f1116a = true;
            this.f1120e.a((h) this.f1118c, this.f1119d);
        }
    }
}
