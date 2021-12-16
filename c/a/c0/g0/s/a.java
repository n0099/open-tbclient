package c.a.c0.g0.s;

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
    public long f1601b;

    /* renamed from: c  reason: collision with root package name */
    public long f1602c;

    /* renamed from: d  reason: collision with root package name */
    public long f1603d;

    /* renamed from: e  reason: collision with root package name */
    public long f1604e;

    /* renamed from: f  reason: collision with root package name */
    public long f1605f;

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
        this.f1601b = 0L;
        this.f1602c = 0L;
        this.f1603d = 0L;
        this.f1604e = 0L;
        this.f1605f = 0L;
    }
}
