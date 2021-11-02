package b.a.p0.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11457a;

    /* renamed from: b  reason: collision with root package name */
    public String f11458b;

    /* renamed from: c  reason: collision with root package name */
    public String f11459c;

    /* renamed from: d  reason: collision with root package name */
    public int f11460d;

    /* renamed from: e  reason: collision with root package name */
    public String f11461e;

    /* renamed from: f  reason: collision with root package name */
    public String f11462f;

    /* renamed from: g  reason: collision with root package name */
    public int f11463g;

    /* renamed from: h  reason: collision with root package name */
    public String f11464h;

    /* renamed from: i  reason: collision with root package name */
    public int f11465i;
    public int j;
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
        this.f11457a = str;
        this.f11458b = str2;
        this.f11459c = str3;
        this.f11460d = i2;
        this.f11461e = str4;
        this.f11462f = str5;
    }
}
