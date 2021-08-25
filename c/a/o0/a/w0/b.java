package c.a.o0.a.w0;

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
    public String f9420a;

    /* renamed from: b  reason: collision with root package name */
    public String f9421b;

    /* renamed from: c  reason: collision with root package name */
    public String f9422c;

    /* renamed from: d  reason: collision with root package name */
    public String f9423d;

    /* renamed from: e  reason: collision with root package name */
    public long f9424e;

    /* renamed from: f  reason: collision with root package name */
    public int f9425f;

    /* renamed from: g  reason: collision with root package name */
    public String f9426g;

    /* renamed from: h  reason: collision with root package name */
    public int f9427h;

    /* renamed from: i  reason: collision with root package name */
    public String f9428i;

    /* renamed from: j  reason: collision with root package name */
    public String f9429j;

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
    public static b a(@NonNull c.a.o0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            b bVar2 = new b();
            bVar2.f9420a = bVar.H();
            bVar2.f9422c = bVar.K();
            bVar2.f9423d = bVar.Q();
            bVar2.f9425f = bVar.G();
            bVar2.f9428i = bVar.T();
            bVar2.f9427h = bVar.n1();
            bVar2.f9424e = System.currentTimeMillis();
            bVar2.f9426g = String.valueOf(bVar.t1());
            bVar2.f9421b = bVar.I();
            bVar2.f9429j = bVar.u1();
            return bVar2;
        }
        return (b) invokeL.objValue;
    }
}
