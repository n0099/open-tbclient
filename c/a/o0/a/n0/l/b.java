package c.a.o0.a.n0.l;

import c.a.o0.a.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface b {
    public static final boolean e0 = k.f7049a;

    /* loaded from: classes.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: c.a.o0.a.n0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0313b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, a> f7539a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7540b;

        /* renamed from: c  reason: collision with root package name */
        public int f7541c;

        /* renamed from: d  reason: collision with root package name */
        public int f7542d;

        public C0313b() {
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
            this.f7539a = new HashMap();
            this.f7540b = true;
            this.f7541c = 0;
            this.f7542d = 0;
        }
    }
}
