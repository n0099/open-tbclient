package c.a.o0.n.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11851a;

    /* renamed from: b  reason: collision with root package name */
    public long f11852b;

    /* renamed from: c  reason: collision with root package name */
    public long f11853c;

    /* renamed from: d  reason: collision with root package name */
    public long f11854d;

    /* renamed from: e  reason: collision with root package name */
    public int f11855e;

    /* renamed from: f  reason: collision with root package name */
    public long f11856f;

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
        this.f11851a = "";
        this.f11852b = 0L;
        this.f11853c = 0L;
        this.f11854d = 0L;
        this.f11855e = 0;
    }
}
