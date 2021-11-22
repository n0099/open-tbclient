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
    public static final boolean e0 = k.f6863a;

    /* loaded from: classes.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: b.a.p0.a.n0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0322b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, a> f7207a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7208b;

        /* renamed from: c  reason: collision with root package name */
        public int f7209c;

        /* renamed from: d  reason: collision with root package name */
        public int f7210d;

        public C0322b() {
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
            this.f7207a = new HashMap();
            this.f7208b = true;
            this.f7209c = 0;
            this.f7210d = 0;
        }
    }
}
