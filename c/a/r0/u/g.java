package c.a.r0.u;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f12104b;

    /* renamed from: c  reason: collision with root package name */
    public String f12105c;

    /* renamed from: d  reason: collision with root package name */
    public int f12106d;

    /* renamed from: e  reason: collision with root package name */
    public String f12107e;

    /* renamed from: f  reason: collision with root package name */
    public String f12108f;

    /* renamed from: g  reason: collision with root package name */
    public int f12109g;

    /* renamed from: h  reason: collision with root package name */
    public String f12110h;

    /* renamed from: i  reason: collision with root package name */
    public int f12111i;

    /* renamed from: j  reason: collision with root package name */
    public int f12112j;

    /* renamed from: k  reason: collision with root package name */
    public String f12113k;

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
        this.a = str;
        this.f12104b = str2;
        this.f12105c = str3;
        this.f12106d = i2;
        this.f12107e = str4;
        this.f12108f = str5;
    }
}
