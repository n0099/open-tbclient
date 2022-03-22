package c.a.n0.u;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9441b;

    /* renamed from: c  reason: collision with root package name */
    public String f9442c;

    /* renamed from: d  reason: collision with root package name */
    public int f9443d;

    /* renamed from: e  reason: collision with root package name */
    public String f9444e;

    /* renamed from: f  reason: collision with root package name */
    public String f9445f;

    /* renamed from: g  reason: collision with root package name */
    public int f9446g;

    /* renamed from: h  reason: collision with root package name */
    public String f9447h;
    public int i;
    public int j;
    public String k;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f9441b = str2;
        this.f9442c = str3;
        this.f9443d = i;
        this.f9444e = str4;
        this.f9445f = str5;
    }
}
