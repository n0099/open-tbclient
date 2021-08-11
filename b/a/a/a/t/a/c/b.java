package b.a.a.a.t.a.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class b implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1153a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1155c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1156d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1157e;

    public b(a aVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, tTNativeExpressAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1157e = aVar;
        this.f1155c = tTNativeExpressAd;
        this.f1156d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            b.a.a.a.x.d.a();
            this.f1157e.f1057h.f(this.f1154b);
            this.f1154b = true;
            this.f1157e.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            b.a.a.a.x.d.a();
            this.f1157e.f1057h.k(this.f1153a);
            this.f1153a = true;
            a aVar = this.f1157e;
            TTNativeExpressAd tTNativeExpressAd = this.f1155c;
            aVar.i(tTNativeExpressAd, aVar.p.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            b.a.a.a.x.d.f("onRenderFail message: " + str + ", code = " + i2, new Object[0]);
            this.f1157e.f1057h.b(i2);
            this.f1157e.n = false;
            this.f1157e.g(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            b.a.a.a.x.d.a();
            this.f1157e.f1057h.n();
            this.f1157e.p.put(this.f1155c, this.f1156d);
            a aVar = this.f1157e;
            aVar.h(this.f1155c);
            aVar.u();
        }
    }
}
