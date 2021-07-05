package a.a.a.a.u.a.b;

import a.a.a.a.u.a.b.h;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class i implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1130a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1132c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h.b f1133d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1134e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ h f1135f;

    public i(h hVar, TTNativeExpressAd tTNativeExpressAd, h.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, tTNativeExpressAd, bVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1135f = hVar;
        this.f1132c = tTNativeExpressAd;
        this.f1133d = bVar;
        this.f1134e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            a.a.a.a.y.d.a();
            this.f1135f.f1017h.a(this.f1131b);
            this.f1131b = true;
            this.f1135f.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            a.a.a.a.y.d.a();
            this.f1135f.f1017h.b(this.f1130a);
            this.f1130a = true;
            h hVar = this.f1135f;
            TTNativeExpressAd tTNativeExpressAd = this.f1132c;
            hVar.a((h) tTNativeExpressAd, hVar.o.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            a.a.a.a.y.d.a();
            this.f1135f.f1017h.a(i2);
            h.b bVar = this.f1133d;
            if (bVar.f1128c) {
                return;
            }
            int i3 = bVar.f1126a + 1;
            bVar.f1126a = i3;
            if (i3 == bVar.f1127b) {
                bVar.f1129d.a(i2, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            a.a.a.a.y.d.a();
            this.f1135f.f1017h.e();
            this.f1135f.o.put(this.f1132c, this.f1134e);
            h.b bVar = this.f1133d;
            TTNativeExpressAd tTNativeExpressAd = this.f1132c;
            if (!bVar.f1128c) {
                h hVar = bVar.f1129d;
                hVar.a((h) tTNativeExpressAd);
                hVar.h();
                bVar.f1128c = true;
                return;
            }
            bVar.f1129d.a((h) tTNativeExpressAd);
        }
    }
}
