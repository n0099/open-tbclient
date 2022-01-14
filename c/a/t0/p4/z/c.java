package c.a.t0.p4.z;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f21406b;

    /* renamed from: c  reason: collision with root package name */
    public String f21407c;

    /* renamed from: d  reason: collision with root package name */
    public String f21408d;

    /* renamed from: e  reason: collision with root package name */
    public String f21409e;

    /* renamed from: f  reason: collision with root package name */
    public String f21410f;

    /* renamed from: g  reason: collision with root package name */
    public String f21411g;

    /* renamed from: h  reason: collision with root package name */
    public String f21412h;

    /* renamed from: i  reason: collision with root package name */
    public String f21413i;

    /* renamed from: j  reason: collision with root package name */
    public String f21414j;
    public String k;
    public String l;
    public String m;

    public c() {
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
}
