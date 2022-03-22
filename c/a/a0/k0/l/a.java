package c.a.a0.k0.l;

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
    public long f1328b;

    /* renamed from: c  reason: collision with root package name */
    public long f1329c;

    /* renamed from: d  reason: collision with root package name */
    public long f1330d;

    /* renamed from: e  reason: collision with root package name */
    public long f1331e;

    /* renamed from: f  reason: collision with root package name */
    public long f1332f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f1328b = 0L;
        this.f1329c = 0L;
        this.f1330d = 0L;
        this.f1331e = 0L;
        this.f1332f = 0L;
    }
}
