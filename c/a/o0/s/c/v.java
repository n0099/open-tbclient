package c.a.o0.s.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f11268b;

    /* renamed from: c  reason: collision with root package name */
    public String f11269c;

    /* renamed from: d  reason: collision with root package name */
    public int f11270d;

    /* renamed from: e  reason: collision with root package name */
    public int f11271e;

    /* renamed from: f  reason: collision with root package name */
    public int f11272f;

    /* renamed from: g  reason: collision with root package name */
    public int f11273g;

    /* renamed from: h  reason: collision with root package name */
    public int f11274h;

    public v() {
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
