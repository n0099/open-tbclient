package c.a.r0.a.n0.l;

import c.a.r0.a.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface b {
    public static final boolean m0 = k.a;

    /* loaded from: classes.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: c.a.r0.a.n0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0480b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, a> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7966b;

        /* renamed from: c  reason: collision with root package name */
        public int f7967c;

        /* renamed from: d  reason: collision with root package name */
        public int f7968d;

        public C0480b() {
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
            this.f7966b = true;
            this.f7967c = 0;
            this.f7968d = 0;
        }
    }
}
