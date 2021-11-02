package b.q.a;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e f33248e;

    public b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33248e = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                View rootView = this.f33248e.f33294a.getRootView();
                if (rootView != null && rootView.getVisibility() == 0 && rootView.isShown()) {
                    y2 a2 = c3.a(this.f33248e.f33295b.f33502a);
                    a2.d(new g3(this.f33248e.f33295b.f33504c), this.f33248e.f33294a.getWidth(), this.f33248e.f33294a.getHeight());
                    a2.m();
                    r0.n(this.f33248e.f33295b.f33504c);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
