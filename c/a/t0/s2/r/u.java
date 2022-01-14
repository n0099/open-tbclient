package c.a.t0.s2.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f22459b;

    /* renamed from: c  reason: collision with root package name */
    public int f22460c;

    /* renamed from: d  reason: collision with root package name */
    public float f22461d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22462e;

    public u(float f2, float f3, int i2, float f4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Float.valueOf(f4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f2;
        this.f22459b = f3;
        this.f22460c = i2;
        this.f22461d = f4;
        this.f22462e = z;
    }
}
