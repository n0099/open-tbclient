package c.a.p0.a.d0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface b {
    public static final boolean m0 = c.a.p0.a.a.a;

    /* loaded from: classes.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: c.a.p0.a.d0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0248b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, a> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4794b;

        /* renamed from: c  reason: collision with root package name */
        public int f4795c;

        /* renamed from: d  reason: collision with root package name */
        public int f4796d;

        public C0248b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashMap();
            this.f4794b = true;
            this.f4795c = 0;
            this.f4796d = 0;
        }
    }
}
