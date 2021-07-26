package a.a.a.a.r.a.b;

import a.a.a.a.r.a.b.j;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class k implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1127a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1128b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1129c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j.b f1130d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1131e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ j f1132f;

    public k(j jVar, TTNativeExpressAd tTNativeExpressAd, j.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, tTNativeExpressAd, bVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1132f = jVar;
        this.f1129c = tTNativeExpressAd;
        this.f1130d = bVar;
        this.f1131e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1132f.f1015h.a(this.f1128b);
            this.f1128b = true;
            this.f1132f.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1132f.f1015h.b(this.f1127a);
            this.f1127a = true;
            j jVar = this.f1132f;
            TTNativeExpressAd tTNativeExpressAd = this.f1129c;
            jVar.a((j) tTNativeExpressAd, jVar.o.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1132f.f1015h.a(i2);
            j.b bVar = this.f1130d;
            if (bVar.f1125c) {
                return;
            }
            int i3 = bVar.f1123a + 1;
            bVar.f1123a = i3;
            if (i3 == bVar.f1124b) {
                bVar.f1126d.a(i2, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            a.a.a.a.v.d.a();
            this.f1132f.f1015h.e();
            this.f1132f.o.put(this.f1129c, this.f1131e);
            j.b bVar = this.f1130d;
            TTNativeExpressAd tTNativeExpressAd = this.f1129c;
            if (!bVar.f1125c) {
                j jVar = bVar.f1126d;
                jVar.a((j) tTNativeExpressAd);
                jVar.h();
                bVar.f1125c = true;
                return;
            }
            bVar.f1126d.a((j) tTNativeExpressAd);
        }
    }
}
