package c.a.a0.v.m0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1809b;

    /* renamed from: c  reason: collision with root package name */
    public String f1810c;

    /* renamed from: d  reason: collision with root package name */
    public int f1811d;

    /* renamed from: e  reason: collision with root package name */
    public int f1812e;

    /* renamed from: f  reason: collision with root package name */
    public int f1813f;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1809b = "";
        this.f1811d = 0;
        this.f1812e = 0;
        this.f1813f = 0;
    }
}
