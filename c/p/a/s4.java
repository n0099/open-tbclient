package c.p.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes7.dex */
public class s4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Info f30921e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a5 f30922f;

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
        this.f30922f = a5Var;
        this.f30921e = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a5 a5Var = this.f30922f;
            if (a5Var.f30738g != null) {
                Context context = a5Var.a;
                Info info = this.f30921e;
                if (a2.c(info)) {
                    try {
                        j a = j.a();
                        if (a.a == null) {
                            a.a = new AdvancedWebView(context.getApplicationContext());
                        }
                        a.a.loadUrl(info.getOpen());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.f30922f.f30738g.a(this.f30921e);
            }
        }
    }
}
