package c.a.b0.k0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f1712b;

    /* renamed from: c  reason: collision with root package name */
    public long f1713c;

    /* renamed from: d  reason: collision with root package name */
    public long f1714d;

    /* renamed from: e  reason: collision with root package name */
    public long f1715e;

    /* renamed from: f  reason: collision with root package name */
    public long f1716f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f1712b = 0L;
        this.f1713c = 0L;
        this.f1714d = 0L;
        this.f1715e = 0L;
        this.f1716f = 0L;
    }
}
