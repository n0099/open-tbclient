package c.a.p0.a.w0;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9448a;

    /* renamed from: b  reason: collision with root package name */
    public String f9449b;

    /* renamed from: c  reason: collision with root package name */
    public String f9450c;

    /* renamed from: d  reason: collision with root package name */
    public String f9451d;

    /* renamed from: e  reason: collision with root package name */
    public long f9452e;

    /* renamed from: f  reason: collision with root package name */
    public int f9453f;

    /* renamed from: g  reason: collision with root package name */
    public String f9454g;

    /* renamed from: h  reason: collision with root package name */
    public int f9455h;

    /* renamed from: i  reason: collision with root package name */
    public String f9456i;

    /* renamed from: j  reason: collision with root package name */
    public String f9457j;

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
            }
        }
    }

    @NonNull
    public static b a(@NonNull c.a.p0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            b bVar2 = new b();
            bVar2.f9448a = bVar.H();
            bVar2.f9450c = bVar.K();
            bVar2.f9451d = bVar.Q();
            bVar2.f9453f = bVar.G();
            bVar2.f9456i = bVar.T();
            bVar2.f9455h = bVar.n1();
            bVar2.f9452e = System.currentTimeMillis();
            bVar2.f9454g = String.valueOf(bVar.t1());
            bVar2.f9449b = bVar.I();
            bVar2.f9457j = bVar.u1();
            return bVar2;
        }
        return (b) invokeL.objValue;
    }
}
