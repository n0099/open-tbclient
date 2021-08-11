package b.a.a.a.t.a.c;

import android.view.View;
import b.a.a.a.t.a.c.j;
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
    public boolean f1183a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1184b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1185c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j.b f1186d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1187e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ j f1188f;

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
        this.f1188f = jVar;
        this.f1185c = tTNativeExpressAd;
        this.f1186d = bVar;
        this.f1187e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            b.a.a.a.x.d.a();
            this.f1188f.f1057h.f(this.f1184b);
            this.f1184b = true;
            this.f1188f.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            b.a.a.a.x.d.a();
            this.f1188f.f1057h.k(this.f1183a);
            this.f1183a = true;
            j jVar = this.f1188f;
            TTNativeExpressAd tTNativeExpressAd = this.f1185c;
            jVar.i(tTNativeExpressAd, jVar.p.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            b.a.a.a.x.d.a();
            this.f1188f.f1057h.b(i2);
            j.b bVar = this.f1186d;
            if (bVar.f1181c) {
                return;
            }
            int i3 = bVar.f1179a + 1;
            bVar.f1179a = i3;
            if (i3 == bVar.f1180b) {
                bVar.f1182d.g(i2, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            b.a.a.a.x.d.a();
            this.f1188f.f1057h.n();
            this.f1188f.p.put(this.f1185c, this.f1187e);
            j.b bVar = this.f1186d;
            TTNativeExpressAd tTNativeExpressAd = this.f1185c;
            if (!bVar.f1181c) {
                j jVar = bVar.f1182d;
                jVar.h(tTNativeExpressAd);
                jVar.u();
                bVar.f1181c = true;
                return;
            }
            bVar.f1182d.h(tTNativeExpressAd);
        }
    }
}
