package b.a.p0.a.n0.l;

import b.a.p0.a.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface b {
    public static final boolean e0 = k.f6397a;

    /* loaded from: classes.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: b.a.p0.a.n0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0310b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, a> f6878a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6879b;

        /* renamed from: c  reason: collision with root package name */
        public int f6880c;

        /* renamed from: d  reason: collision with root package name */
        public int f6881d;

        public C0310b() {
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
            this.f6878a = new HashMap();
            this.f6879b = true;
            this.f6880c = 0;
            this.f6881d = 0;
        }
    }
}
