package c.a.p0.n.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11887a;

    /* renamed from: b  reason: collision with root package name */
    public long f11888b;

    /* renamed from: c  reason: collision with root package name */
    public long f11889c;

    /* renamed from: d  reason: collision with root package name */
    public long f11890d;

    /* renamed from: e  reason: collision with root package name */
    public int f11891e;

    /* renamed from: f  reason: collision with root package name */
    public long f11892f;

    public c() {
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
        this.f11887a = "";
        this.f11888b = 0L;
        this.f11889c = 0L;
        this.f11890d = 0L;
        this.f11891e = 0;
    }
}
