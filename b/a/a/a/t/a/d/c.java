package b.a.a.a.t.a.d;

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
    public boolean f1233a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1234b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f1235c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1236d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f1237e;

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
        this.f1237e = bVar;
        this.f1235c = nativeExpressADData2;
        this.f1236d = str;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.a.a.x.d.a();
            this.f1237e.f1057h.m();
            this.f1237e.s();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.a.a.x.d.a();
            this.f1237e.f1057h.f(this.f1234b);
            this.f1234b = true;
            this.f1237e.r();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.a.a.x.d.e();
            this.f1237e.f1057h.k(this.f1233a);
            this.f1233a = true;
            b bVar = this.f1237e;
            NativeExpressADData2 nativeExpressADData2 = this.f1235c;
            bVar.i(nativeExpressADData2, bVar.o.remove(nativeExpressADData2));
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.a.a.x.d.a();
            b.a.a.a.x.f.g.b.c(this.f1237e.f1057h.f1519a, "render_failed", new Object[0]);
            this.f1237e.n(0, "RenderFail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.a.a.x.d.a();
            this.f1237e.f1057h.n();
            this.f1237e.o.put(this.f1235c, this.f1236d);
            b bVar = this.f1237e;
            bVar.h(this.f1235c);
            bVar.u();
        }
    }
}
