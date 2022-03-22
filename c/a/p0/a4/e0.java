package c.a.p0.a4;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f12181b;

    /* renamed from: c  reason: collision with root package name */
    public String f12182c;

    /* renamed from: d  reason: collision with root package name */
    public String f12183d;

    /* renamed from: e  reason: collision with root package name */
    public String f12184e;

    /* renamed from: f  reason: collision with root package name */
    public f0 f12185f;

    /* renamed from: g  reason: collision with root package name */
    public String f12186g;

    /* renamed from: h  reason: collision with root package name */
    public int f12187h;
    public List<String> i;

    public e0() {
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
