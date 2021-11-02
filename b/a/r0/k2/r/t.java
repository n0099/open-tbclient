package b.a.r0.k2.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f18814a;

    /* renamed from: b  reason: collision with root package name */
    public float f18815b;

    /* renamed from: c  reason: collision with root package name */
    public int f18816c;

    /* renamed from: d  reason: collision with root package name */
    public float f18817d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18818e;

    public t(float f2, float f3, int i2, float f4, boolean z) {
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
        this.f18814a = f2;
        this.f18815b = f3;
        this.f18816c = i2;
        this.f18817d = f4;
        this.f18818e = z;
    }
}
