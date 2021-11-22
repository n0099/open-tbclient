package b.o.a;

import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class t implements ViewTreeObserver.OnScrollChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f34312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s0 f34313b;

    public t(s0 s0Var, p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s0Var, p0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34313b = s0Var;
        this.f34312a = p0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f34313b.f34299b || !this.f34313b.b(this.f34313b.f34298a)) {
                    return;
                }
                this.f34313b.f34302e.removeMessages(1101);
                this.f34313b.f34298a.getViewTreeObserver().removeOnScrollChangedListener(this);
                if (this.f34312a != null) {
                    this.f34312a.a();
                }
                this.f34313b.f34299b = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
