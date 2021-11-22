package b.a.q0.t.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f14653a;

    /* renamed from: b  reason: collision with root package name */
    public String f14654b;

    /* renamed from: c  reason: collision with root package name */
    public String f14655c;

    /* renamed from: d  reason: collision with root package name */
    public int f14656d;

    /* renamed from: e  reason: collision with root package name */
    public int f14657e;

    /* renamed from: f  reason: collision with root package name */
    public int f14658f;

    /* renamed from: g  reason: collision with root package name */
    public int f14659g;

    /* renamed from: h  reason: collision with root package name */
    public int f14660h;

    public x() {
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
