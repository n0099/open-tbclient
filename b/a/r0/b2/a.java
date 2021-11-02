package b.a.r0.b2;

import android.content.Context;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f14986a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f14987b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f14988c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14989d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f14990e;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14986a = context;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14988c == null || this.f14989d == null) {
            return;
        }
        this.f14987b.removeCallbacks(this.f14990e);
        this.f14987b.post(this.f14990e);
    }
}
