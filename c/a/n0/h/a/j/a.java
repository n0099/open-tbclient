package c.a.n0.h.a.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8394b;

    /* renamed from: c  reason: collision with root package name */
    public String f8395c;

    /* renamed from: d  reason: collision with root package name */
    public String f8396d;

    /* renamed from: e  reason: collision with root package name */
    public String f8397e;

    /* renamed from: f  reason: collision with root package name */
    public String f8398f;

    /* renamed from: g  reason: collision with root package name */
    public String f8399g;

    /* renamed from: h  reason: collision with root package name */
    public String f8400h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;

    public a() {
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
