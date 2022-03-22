package c.a.n0.a.h0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f4586b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f4587c;

    /* renamed from: d  reason: collision with root package name */
    public j f4588d;

    /* renamed from: e  reason: collision with root package name */
    public long f4589e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f4590f;

    /* renamed from: g  reason: collision with root package name */
    public String f4591g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f4592h;

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
