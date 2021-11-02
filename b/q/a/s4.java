package b.q.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes6.dex */
public class s4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Info f33476e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a5 f33477f;

    public s4(a5 a5Var, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a5Var, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33477f = a5Var;
        this.f33476e = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a5 a5Var = this.f33477f;
            if (a5Var.f33244g != null) {
                Context context = a5Var.f33238a;
                Info info = this.f33476e;
                if (a2.c(info)) {
                    try {
                        j a2 = j.a();
                        if (a2.f33348a == null) {
                            a2.f33348a = new AdvancedWebView(context.getApplicationContext());
                        }
                        a2.f33348a.loadUrl(info.getOpen());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.f33477f.f33244g.a(this.f33476e);
            }
        }
    }
}
