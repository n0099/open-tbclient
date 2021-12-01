package c.a.q0.d1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f11878b;

    /* renamed from: c  reason: collision with root package name */
    public int f11879c;

    /* renamed from: d  reason: collision with root package name */
    public int f11880d;

    /* renamed from: e  reason: collision with root package name */
    public float f11881e;

    /* renamed from: f  reason: collision with root package name */
    public float f11882f;

    /* renamed from: g  reason: collision with root package name */
    public String f11883g;

    /* renamed from: h  reason: collision with root package name */
    public int f11884h;

    /* renamed from: i  reason: collision with root package name */
    public int f11885i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f11886j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f11887k;
    public String l;
    public String m;

    public e() {
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
