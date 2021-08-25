package c.a.o0.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12241a;

    /* renamed from: b  reason: collision with root package name */
    public String f12242b;

    /* renamed from: c  reason: collision with root package name */
    public String f12243c;

    /* renamed from: d  reason: collision with root package name */
    public int f12244d;

    /* renamed from: e  reason: collision with root package name */
    public String f12245e;

    /* renamed from: f  reason: collision with root package name */
    public String f12246f;

    /* renamed from: g  reason: collision with root package name */
    public int f12247g;

    /* renamed from: h  reason: collision with root package name */
    public String f12248h;

    /* renamed from: i  reason: collision with root package name */
    public int f12249i;

    /* renamed from: j  reason: collision with root package name */
    public int f12250j;
    public String k;

    public g(String str, String str2, String str3, int i2, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i2), str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12241a = str;
        this.f12242b = str2;
        this.f12243c = str3;
        this.f12244d = i2;
        this.f12245e = str4;
        this.f12246f = str5;
    }
}
