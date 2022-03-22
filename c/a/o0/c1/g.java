package c.a.o0.c1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f9941b;

    /* renamed from: c  reason: collision with root package name */
    public int f9942c;

    /* renamed from: d  reason: collision with root package name */
    public int f9943d;

    /* renamed from: e  reason: collision with root package name */
    public float f9944e;

    /* renamed from: f  reason: collision with root package name */
    public float f9945f;

    /* renamed from: g  reason: collision with root package name */
    public String f9946g;

    /* renamed from: h  reason: collision with root package name */
    public int f9947h;
    public int i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
