package c.a.q0.a.e0.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import c.a.q0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public int f5088b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f5089c;

    /* renamed from: d  reason: collision with root package name */
    public b f5090d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f5091e;

    /* renamed from: c.a.q0.a.e0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0243a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.f5089c == null) {
                return;
            }
            this.a.f5089c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.a.f5089c.entrySet()) {
                try {
                    jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.a.e(jSONObject.toString());
            c.a.q0.a.e0.d.i("PropertyLogcat", jSONObject.toString());
            if (this.a.f5090d != null) {
                this.a.f5090d.sendEmptyMessageDelayed(100, this.a.f5088b);
            }
        }

        public /* synthetic */ b(a aVar, C0243a c0243a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1446559666, "Lc/a/q0/a/e0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1446559666, "Lc/a/q0/a/e0/g/a;");
                return;
            }
        }
        boolean z = k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "performance_" + System.currentTimeMillis();
        this.f5088b = 3000;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bufferedWriter = this.f5091e) == null) {
            return;
        }
        try {
            bufferedWriter.write(str);
            this.f5091e.write(10);
            c.a.q0.a.e0.d.i("PropertyLogcat", "Export logcat success");
        } catch (IOException e2) {
            c.a.q0.a.e0.d.d("PropertyLogcat", "Logcat write fail", e2);
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.q0.a.o2.b.n(c.a.q0.a.d2.e.f0(), this.a, TbConfig.TMP_LOG_DIR_NAME) : (String) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 < 1000) {
            return;
        }
        this.f5088b = i2;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f5089c == null) {
                this.f5089c = c.a.q0.a.e0.g.b.g().h();
                c.a.q0.a.e0.d.i("PropertyLogcat", "Start monitor logcat");
            }
            if (this.f5090d == null) {
                this.f5090d = new b(this, null);
            }
            if (this.f5091e == null) {
                File file = new File(f());
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    this.f5091e = new BufferedWriter(new FileWriter(file, true));
                } catch (IOException e2) {
                    c.a.q0.a.e0.d.d("PropertyLogcat", "Create log file fail", e2);
                }
            }
            this.f5090d.removeMessages(100);
            this.f5090d.sendEmptyMessage(100);
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f5089c != null) {
                c.a.q0.a.e0.g.b.g().i();
                this.f5089c = null;
                c.a.q0.a.e0.d.i("PropertyLogcat", "Stop monitor logcat");
            }
            c.a.q0.w.d.d(this.f5091e);
            this.f5091e = null;
            return c.a.q0.a.o2.b.I(f(), c.a.q0.a.d2.e.f0());
        }
        return (String) invokeV.objValue;
    }
}
