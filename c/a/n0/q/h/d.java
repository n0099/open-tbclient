package c.a.n0.q.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f9140b;

    /* renamed from: c  reason: collision with root package name */
    public long f9141c;

    /* renamed from: d  reason: collision with root package name */
    public long f9142d;

    /* renamed from: e  reason: collision with root package name */
    public int f9143e;

    /* renamed from: f  reason: collision with root package name */
    public long f9144f;

    public d() {
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
        this.a = "";
        this.f9140b = 0L;
        this.f9141c = 0L;
        this.f9142d = 0L;
        this.f9143e = 0;
    }
}
