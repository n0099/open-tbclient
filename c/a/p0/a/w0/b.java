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
    public String f9456a;

    /* renamed from: b  reason: collision with root package name */
    public String f9457b;

    /* renamed from: c  reason: collision with root package name */
    public String f9458c;

    /* renamed from: d  reason: collision with root package name */
    public String f9459d;

    /* renamed from: e  reason: collision with root package name */
    public long f9460e;

    /* renamed from: f  reason: collision with root package name */
    public int f9461f;

    /* renamed from: g  reason: collision with root package name */
    public String f9462g;

    /* renamed from: h  reason: collision with root package name */
    public int f9463h;

    /* renamed from: i  reason: collision with root package name */
    public String f9464i;

    /* renamed from: j  reason: collision with root package name */
    public String f9465j;

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
            bVar2.f9456a = bVar.H();
            bVar2.f9458c = bVar.K();
            bVar2.f9459d = bVar.Q();
            bVar2.f9461f = bVar.G();
            bVar2.f9464i = bVar.T();
            bVar2.f9463h = bVar.n1();
            bVar2.f9460e = System.currentTimeMillis();
            bVar2.f9462g = String.valueOf(bVar.t1());
            bVar2.f9457b = bVar.I();
            bVar2.f9465j = bVar.u1();
            return bVar2;
        }
        return (b) invokeL.objValue;
    }
}
