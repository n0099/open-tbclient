package c.a.u0.z3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26152b;

    /* renamed from: c  reason: collision with root package name */
    public String f26153c;

    /* renamed from: d  reason: collision with root package name */
    public String f26154d;

    /* renamed from: e  reason: collision with root package name */
    public String f26155e;

    /* renamed from: f  reason: collision with root package name */
    public f0 f26156f;

    /* renamed from: g  reason: collision with root package name */
    public String f26157g;

    /* renamed from: h  reason: collision with root package name */
    public int f26158h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f26159i;

    public e0() {
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
