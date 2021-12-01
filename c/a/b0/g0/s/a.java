package c.a.b0.g0.s;

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
    public long f1583b;

    /* renamed from: c  reason: collision with root package name */
    public long f1584c;

    /* renamed from: d  reason: collision with root package name */
    public long f1585d;

    /* renamed from: e  reason: collision with root package name */
    public long f1586e;

    /* renamed from: f  reason: collision with root package name */
    public long f1587f;

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
        this.f1583b = 0L;
        this.f1584c = 0L;
        this.f1585d = 0L;
        this.f1586e = 0L;
        this.f1587f = 0L;
    }
}
