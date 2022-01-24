package c.a.t0.x3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25041b;

    /* renamed from: c  reason: collision with root package name */
    public String f25042c;

    /* renamed from: d  reason: collision with root package name */
    public String f25043d;

    /* renamed from: e  reason: collision with root package name */
    public String f25044e;

    /* renamed from: f  reason: collision with root package name */
    public e0 f25045f;

    /* renamed from: g  reason: collision with root package name */
    public String f25046g;

    /* renamed from: h  reason: collision with root package name */
    public int f25047h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f25048i;

    public d0() {
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
