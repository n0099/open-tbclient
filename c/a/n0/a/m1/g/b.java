package c.a.n0.a.m1.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f5475b;

    /* renamed from: c  reason: collision with root package name */
    public long f5476c;

    /* renamed from: d  reason: collision with root package name */
    public int f5477d;

    /* renamed from: e  reason: collision with root package name */
    public String f5478e;

    /* renamed from: f  reason: collision with root package name */
    public String f5479f;

    public b() {
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
        this.a = null;
        this.f5475b = null;
        this.f5476c = -1L;
        this.f5477d = -1;
        this.f5478e = null;
        this.f5479f = null;
    }
}
