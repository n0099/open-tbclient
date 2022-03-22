package c.a.n0.a.u.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
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
    public int f6488b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f6489c;

    /* renamed from: d  reason: collision with root package name */
    public b f6490d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f6491e;

    /* renamed from: c.a.n0.a.u.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0468a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.f6489c == null) {
                return;
            }
            this.a.f6489c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.a.f6489c.entrySet()) {
                try {
                    jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.a.e(jSONObject.toString());
            c.a.n0.a.u.d.i("PropertyLogcat", jSONObject.toString());
            if (this.a.f6490d != null) {
                this.a.f6490d.sendEmptyMessageDelayed(100, this.a.f6488b);
            }
        }

        public /* synthetic */ b(a aVar, C0468a c0468a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-708774863, "Lc/a/n0/a/u/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-708774863, "Lc/a/n0/a/u/g/a;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "performance_" + System.currentTimeMillis();
        this.f6488b = 3000;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bufferedWriter = this.f6491e) == null) {
            return;
        }
        try {
            bufferedWriter.write(str);
            this.f6491e.write(10);
            c.a.n0.a.u.d.i("PropertyLogcat", "Export logcat success");
        } catch (IOException e2) {
            c.a.n0.a.u.d.d("PropertyLogcat", "Logcat write fail", e2);
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.n0.a.e2.b.n(c.a.n0.a.t1.e.f0(), this.a, TbConfig.TMP_LOG_DIR_NAME) : (String) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i < 1000) {
            return;
        }
        this.f6488b = i;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f6489c == null) {
                this.f6489c = c.a.n0.a.u.g.b.g().h();
                c.a.n0.a.u.d.i("PropertyLogcat", "Start monitor logcat");
            }
            if (this.f6490d == null) {
                this.f6490d = new b(this, null);
            }
            if (this.f6491e == null) {
                File file = new File(f());
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    this.f6491e = new BufferedWriter(new FileWriter(file, true));
                } catch (IOException e2) {
                    c.a.n0.a.u.d.d("PropertyLogcat", "Create log file fail", e2);
                }
            }
            this.f6490d.removeMessages(100);
            this.f6490d.sendEmptyMessage(100);
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f6489c != null) {
                c.a.n0.a.u.g.b.g().i();
                this.f6489c = null;
                c.a.n0.a.u.d.i("PropertyLogcat", "Stop monitor logcat");
            }
            c.a.n0.w.d.d(this.f6491e);
            this.f6491e = null;
            return c.a.n0.a.e2.b.I(f(), c.a.n0.a.t1.e.f0());
        }
        return (String) invokeV.objValue;
    }
}
