package b.a.q0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13299a;

    /* renamed from: b  reason: collision with root package name */
    public int f13300b;

    /* renamed from: c  reason: collision with root package name */
    public int f13301c;

    /* renamed from: d  reason: collision with root package name */
    public int f13302d;

    /* renamed from: e  reason: collision with root package name */
    public int f13303e;

    /* renamed from: f  reason: collision with root package name */
    public int f13304f;

    /* renamed from: g  reason: collision with root package name */
    public int f13305g;

    /* renamed from: h  reason: collision with root package name */
    public int f13306h;

    /* renamed from: i  reason: collision with root package name */
    public int f13307i;
    public String j;

    public f() {
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
        this.f13299a = 0;
        this.f13300b = 0;
        this.f13301c = 1;
        this.f13302d = 1;
        this.f13303e = 0;
        this.f13304f = 0;
        this.f13305g = 1;
        this.f13306h = 0;
        this.f13307i = 0;
    }
}
