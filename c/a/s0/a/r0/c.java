package c.a.s0.a.r0;

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
    public String f8692b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f8693c;

    /* renamed from: d  reason: collision with root package name */
    public j f8694d;

    /* renamed from: e  reason: collision with root package name */
    public long f8695e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f8696f;

    /* renamed from: g  reason: collision with root package name */
    public String f8697g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f8698h;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
