package c.a.q0.z1;

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
    public Context f29316a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f29317b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f29318c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29319d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f29320e;

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
        this.f29316a = context;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29318c == null || this.f29319d == null) {
            return;
        }
        this.f29317b.removeCallbacks(this.f29320e);
        this.f29317b.post(this.f29320e);
    }
}
