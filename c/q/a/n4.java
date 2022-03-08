package c.q.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes3.dex */
public class n4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Info f29048e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ v4 f29049f;

    public n4(v4 v4Var, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v4Var, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29049f = v4Var;
        this.f29048e = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            v4 v4Var = this.f29049f;
            if (v4Var.f29158g != null) {
                Context context = v4Var.a;
                Info info = this.f29048e;
                if (v1.c(info)) {
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
                this.f29049f.f29158g.a(this.f29048e);
            }
        }
    }
}
