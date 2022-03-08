package c.a.r0.d1.o2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f15917b;

    /* renamed from: c  reason: collision with root package name */
    public String f15918c;

    /* renamed from: d  reason: collision with root package name */
    public String f15919d;

    /* renamed from: e  reason: collision with root package name */
    public int f15920e;

    /* renamed from: f  reason: collision with root package name */
    public int f15921f;

    /* renamed from: g  reason: collision with root package name */
    public int f15922g;

    /* renamed from: h  reason: collision with root package name */
    public int f15923h;

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
        this.f15917b = 0;
        this.f15918c = null;
        this.f15919d = null;
        this.f15920e = -1;
        this.f15921f = -1;
        this.f15922g = -1;
        this.f15923h = -1;
    }
}
