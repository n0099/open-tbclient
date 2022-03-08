package c.a.q0.s.c;

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
    public String f13717b;

    /* renamed from: c  reason: collision with root package name */
    public String f13718c;

    /* renamed from: d  reason: collision with root package name */
    public int f13719d;

    /* renamed from: e  reason: collision with root package name */
    public int f13720e;

    /* renamed from: f  reason: collision with root package name */
    public int f13721f;

    /* renamed from: g  reason: collision with root package name */
    public int f13722g;

    /* renamed from: h  reason: collision with root package name */
    public int f13723h;

    public v() {
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
