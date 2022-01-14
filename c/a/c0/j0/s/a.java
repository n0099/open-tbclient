package c.a.c0.j0.s;

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
    public long f2037b;

    /* renamed from: c  reason: collision with root package name */
    public long f2038c;

    /* renamed from: d  reason: collision with root package name */
    public long f2039d;

    /* renamed from: e  reason: collision with root package name */
    public long f2040e;

    /* renamed from: f  reason: collision with root package name */
    public long f2041f;

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
        this.f2037b = 0L;
        this.f2038c = 0L;
        this.f2039d = 0L;
        this.f2040e = 0L;
        this.f2041f = 0L;
    }
}
