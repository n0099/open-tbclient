package c.a.r0.q.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f11631b;

    /* renamed from: c  reason: collision with root package name */
    public long f11632c;

    /* renamed from: d  reason: collision with root package name */
    public long f11633d;

    /* renamed from: e  reason: collision with root package name */
    public int f11634e;

    /* renamed from: f  reason: collision with root package name */
    public long f11635f;

    public d() {
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
        this.a = "";
        this.f11631b = 0L;
        this.f11632c = 0L;
        this.f11633d = 0L;
        this.f11634e = 0;
    }
}
