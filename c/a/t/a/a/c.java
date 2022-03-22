package c.a.t.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f21242g = "Flow";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f21243b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21244c;

    /* renamed from: d  reason: collision with root package name */
    public long f21245d;

    /* renamed from: e  reason: collision with root package name */
    public Context f21246e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f21247f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f21248b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f21249c;

        public a(c cVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21249c = cVar;
            this.a = str;
            this.f21248b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21249c.f21247f.put(this.a, this.f21248b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1469079797, "Lc/a/t/a/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1469079797, "Lc/a/t/a/a/c;");
        }
    }

    public c(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21245d = 0L;
        this.f21246e = context;
        this.a = i;
        this.f21243b = i2;
        this.f21244c = System.currentTimeMillis();
        this.f21247f = new ConcurrentHashMap();
    }

    public c b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str)) {
                c.a.t.a.a.a.h(this.f21246e).f().execute(new a(this, str, String.valueOf(i)));
            }
            String str2 = f21242g;
            c.a.t.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + i);
            return this;
        }
        return (c) invokeLI.objValue;
    }

    public c c(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            if (!TextUtils.isEmpty(str)) {
                c.a.t.a.a.a.h(this.f21246e).f().execute(new a(this, str, String.valueOf(j)));
            }
            String str2 = f21242g;
            c.a.t.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + j);
            return this;
        }
        return (c) invokeLJ.objValue;
    }

    public c d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                c.a.t.a.a.a.h(this.f21246e).f().execute(new a(this, str, str2));
            }
            String str3 = f21242g;
            c.a.t.a.h.e.a(str3, "flow addEvent id:" + str + ",value:" + str2);
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21245d = System.currentTimeMillis();
            c.a.t.a.a.a.h(this.f21246e).e(this);
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f21247f.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21247f : (Map) invokeV.objValue;
    }
}
