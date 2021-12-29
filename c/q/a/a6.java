package c.q.a;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a6 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e6 f31255e;

    public a6(e6 e6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31255e = e6Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                View rootView = this.f31255e.a.getRootView();
                if (rootView != null && rootView.getVisibility() == 0 && rootView.isShown()) {
                    y2 a = c3.a(this.f31255e.f31293b.a);
                    a.d(new g3(this.f31255e.f31293b.f31340c), this.f31255e.a.getWidth(), this.f31255e.a.getHeight());
                    a.m();
                    r0.n(this.f31255e.f31293b.f31340c);
                    if (this.f31255e.f31293b.f31343f != null) {
                        this.f31255e.f31293b.f31343f.onDisplayed();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
