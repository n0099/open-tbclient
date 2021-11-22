package b.a.p0.u;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12180a;

    /* renamed from: b  reason: collision with root package name */
    public String f12181b;

    /* renamed from: c  reason: collision with root package name */
    public String f12182c;

    /* renamed from: d  reason: collision with root package name */
    public int f12183d;

    /* renamed from: e  reason: collision with root package name */
    public String f12184e;

    /* renamed from: f  reason: collision with root package name */
    public String f12185f;

    /* renamed from: g  reason: collision with root package name */
    public int f12186g;

    /* renamed from: h  reason: collision with root package name */
    public String f12187h;

    /* renamed from: i  reason: collision with root package name */
    public int f12188i;
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
        this.f12180a = str;
        this.f12181b = str2;
        this.f12182c = str3;
        this.f12183d = i2;
        this.f12184e = str4;
        this.f12185f = str5;
    }
}
