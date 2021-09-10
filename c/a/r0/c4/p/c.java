package c.a.r0.c4.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f16806a;

    /* renamed from: b  reason: collision with root package name */
    public String f16807b;

    /* renamed from: c  reason: collision with root package name */
    public String f16808c;

    /* renamed from: d  reason: collision with root package name */
    public String f16809d;

    /* renamed from: e  reason: collision with root package name */
    public String f16810e;

    /* renamed from: f  reason: collision with root package name */
    public String f16811f;

    /* renamed from: g  reason: collision with root package name */
    public String f16812g;

    /* renamed from: h  reason: collision with root package name */
    public String f16813h;

    /* renamed from: i  reason: collision with root package name */
    public String f16814i;

    /* renamed from: j  reason: collision with root package name */
    public String f16815j;
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
