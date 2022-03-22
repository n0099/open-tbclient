package c.a.n0.a.m1.d.b;

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
    public String f5442b;

    /* renamed from: c  reason: collision with root package name */
    public String f5443c;

    /* renamed from: d  reason: collision with root package name */
    public int f5444d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5445e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5446f;

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
                return;
            }
        }
        this.f5444d = -1;
        this.f5445e = false;
        this.f5446f = false;
    }
}
