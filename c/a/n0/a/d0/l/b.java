package c.a.n0.a.d0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface b {
    public static final boolean c0 = c.a.n0.a.a.a;

    /* loaded from: classes.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: c.a.n0.a.d0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0236b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, a> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4077b;

        /* renamed from: c  reason: collision with root package name */
        public int f4078c;

        /* renamed from: d  reason: collision with root package name */
        public int f4079d;

        public C0236b() {
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
            this.a = new HashMap();
            this.f4077b = true;
            this.f4078c = 0;
            this.f4079d = 0;
        }
    }
}
