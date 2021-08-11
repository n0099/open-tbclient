package c.a.n0.a.w0;

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
    public String f9174a;

    /* renamed from: b  reason: collision with root package name */
    public String f9175b;

    /* renamed from: c  reason: collision with root package name */
    public String f9176c;

    /* renamed from: d  reason: collision with root package name */
    public String f9177d;

    /* renamed from: e  reason: collision with root package name */
    public long f9178e;

    /* renamed from: f  reason: collision with root package name */
    public int f9179f;

    /* renamed from: g  reason: collision with root package name */
    public String f9180g;

    /* renamed from: h  reason: collision with root package name */
    public int f9181h;

    /* renamed from: i  reason: collision with root package name */
    public String f9182i;

    /* renamed from: j  reason: collision with root package name */
    public String f9183j;

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
    public static b a(@NonNull c.a.n0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            b bVar2 = new b();
            bVar2.f9174a = bVar.H();
            bVar2.f9176c = bVar.K();
            bVar2.f9177d = bVar.Q();
            bVar2.f9179f = bVar.G();
            bVar2.f9182i = bVar.T();
            bVar2.f9181h = bVar.n1();
            bVar2.f9178e = System.currentTimeMillis();
            bVar2.f9180g = String.valueOf(bVar.t1());
            bVar2.f9175b = bVar.I();
            bVar2.f9183j = bVar.u1();
            return bVar2;
        }
        return (b) invokeL.objValue;
    }
}
