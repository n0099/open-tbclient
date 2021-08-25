package c.a.q0.u.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24792a;

    /* renamed from: b  reason: collision with root package name */
    public String f24793b;

    /* renamed from: c  reason: collision with root package name */
    public String f24794c;

    /* renamed from: d  reason: collision with root package name */
    public String f24795d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f24796e;

    /* renamed from: f  reason: collision with root package name */
    public String f24797f;

    /* renamed from: g  reason: collision with root package name */
    public String f24798g;

    /* renamed from: h  reason: collision with root package name */
    public String f24799h;

    public b() {
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
