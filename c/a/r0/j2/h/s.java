package c.a.r0.j2.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f19688a;

    /* renamed from: b  reason: collision with root package name */
    public float f19689b;

    /* renamed from: c  reason: collision with root package name */
    public int f19690c;

    /* renamed from: d  reason: collision with root package name */
    public float f19691d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19692e;

    public s(float f2, float f3, int i2, float f4, boolean z) {
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
        this.f19688a = f2;
        this.f19689b = f3;
        this.f19690c = i2;
        this.f19691d = f4;
        this.f19692e = z;
    }
}
