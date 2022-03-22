package c.a.p0.s4.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18402b;

    /* renamed from: c  reason: collision with root package name */
    public String f18403c;

    /* renamed from: d  reason: collision with root package name */
    public String f18404d;

    /* renamed from: e  reason: collision with root package name */
    public String f18405e;

    /* renamed from: f  reason: collision with root package name */
    public String f18406f;

    /* renamed from: g  reason: collision with root package name */
    public String f18407g;

    /* renamed from: h  reason: collision with root package name */
    public String f18408h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
