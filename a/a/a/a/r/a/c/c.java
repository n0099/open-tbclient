package a.a.a.a.r.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes.dex */
public class c implements AdEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1176a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f1178c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1179d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f1180e;

    public c(b bVar, NativeExpressADData2 nativeExpressADData2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, nativeExpressADData2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1180e = bVar;
        this.f1178c = nativeExpressADData2;
        this.f1179d = str;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.v.d.a();
            this.f1180e.f1015h.d();
            this.f1180e.f();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.v.d.a();
            this.f1180e.f1015h.a(this.f1177b);
            this.f1177b = true;
            this.f1180e.e();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a.a.a.v.d.b();
            this.f1180e.f1015h.b(this.f1176a);
            this.f1176a = true;
            b bVar = this.f1180e;
            NativeExpressADData2 nativeExpressADData2 = this.f1178c;
            bVar.a((b) nativeExpressADData2, bVar.n.remove(nativeExpressADData2));
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.v.d.a();
            a.a.a.a.v.g.g.c.a(this.f1180e.f1015h.f1441a, "render_failed", new Object[0]);
            this.f1180e.b(0, "RenderFail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a.a.a.a.v.d.a();
            this.f1180e.f1015h.e();
            this.f1180e.n.put(this.f1178c, this.f1179d);
            b bVar = this.f1180e;
            bVar.a((b) this.f1178c);
            bVar.h();
        }
    }
}
