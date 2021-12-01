package c.a.r0.d1.v2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f16083b;

    /* renamed from: c  reason: collision with root package name */
    public String f16084c;

    /* renamed from: d  reason: collision with root package name */
    public int f16085d;

    /* renamed from: e  reason: collision with root package name */
    public int f16086e;

    /* renamed from: f  reason: collision with root package name */
    public int f16087f;

    /* renamed from: g  reason: collision with root package name */
    public int f16088g;

    public b() {
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
        this.a = false;
        this.f16083b = 0;
        this.f16084c = null;
        this.f16085d = -1;
        this.f16086e = -1;
        this.f16087f = -1;
        this.f16088g = -1;
    }
}
