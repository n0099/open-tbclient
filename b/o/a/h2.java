package b.o.a;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k2 f34168e;

    public h2(k2 k2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34168e = k2Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                View rootView = this.f34168e.f34204a.getRootView();
                if (rootView != null && rootView.getVisibility() == 0 && rootView.isShown()) {
                    y2 a2 = c3.a(this.f34168e.f34205b.f34352a);
                    a2.d(new g3(this.f34168e.f34205b.f34354c), this.f34168e.f34204a.getWidth(), this.f34168e.f34204a.getHeight());
                    a2.m();
                    r0.n(this.f34168e.f34205b.f34354c);
                    if (this.f34168e.f34205b.f34357f != null) {
                        this.f34168e.f34205b.f34357f.onDisplayed();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
