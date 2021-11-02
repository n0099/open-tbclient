package b.a.p0.a.w0;

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
    public String f8701a;

    /* renamed from: b  reason: collision with root package name */
    public String f8702b;

    /* renamed from: c  reason: collision with root package name */
    public String f8703c;

    /* renamed from: d  reason: collision with root package name */
    public String f8704d;

    /* renamed from: e  reason: collision with root package name */
    public long f8705e;

    /* renamed from: f  reason: collision with root package name */
    public int f8706f;

    /* renamed from: g  reason: collision with root package name */
    public String f8707g;

    /* renamed from: h  reason: collision with root package name */
    public int f8708h;

    /* renamed from: i  reason: collision with root package name */
    public String f8709i;
    public String j;

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
    public static b a(@NonNull b.a.p0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            b bVar2 = new b();
            bVar2.f8701a = bVar.G();
            bVar2.f8703c = bVar.J();
            bVar2.f8704d = bVar.P();
            bVar2.f8706f = bVar.F();
            bVar2.f8709i = bVar.S();
            bVar2.f8708h = bVar.m1();
            bVar2.f8705e = System.currentTimeMillis();
            bVar2.f8707g = String.valueOf(bVar.getType());
            bVar2.f8702b = bVar.H();
            bVar2.j = bVar.s1();
            return bVar2;
        }
        return (b) invokeL.objValue;
    }
}
