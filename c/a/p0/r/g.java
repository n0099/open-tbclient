package c.a.p0.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12277a;

    /* renamed from: b  reason: collision with root package name */
    public String f12278b;

    /* renamed from: c  reason: collision with root package name */
    public String f12279c;

    /* renamed from: d  reason: collision with root package name */
    public int f12280d;

    /* renamed from: e  reason: collision with root package name */
    public String f12281e;

    /* renamed from: f  reason: collision with root package name */
    public String f12282f;

    /* renamed from: g  reason: collision with root package name */
    public int f12283g;

    /* renamed from: h  reason: collision with root package name */
    public String f12284h;

    /* renamed from: i  reason: collision with root package name */
    public int f12285i;

    /* renamed from: j  reason: collision with root package name */
    public int f12286j;
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
        this.f12277a = str;
        this.f12278b = str2;
        this.f12279c = str3;
        this.f12280d = i2;
        this.f12281e = str4;
        this.f12282f = str5;
    }
}
