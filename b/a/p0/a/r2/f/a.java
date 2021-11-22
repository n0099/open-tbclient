package b.a.p0.a.r2.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.d;
import b.a.p0.a.k;
import b.a.p0.a.n2.c;
import b.a.p0.a.z2.o0;
import b.a.p0.a.z2.q;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8171a;

    /* renamed from: b  reason: collision with root package name */
    public static int f8172b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.r2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0386a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8174f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8175g;

        public RunnableC0386a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8173e = str;
            this.f8174f = str2;
            this.f8175g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                File file = new File(this.f8173e);
                try {
                    jSONObject.put("file_name", this.f8174f);
                    jSONObject.put("file_tree", a.d(file));
                    jSONObject.put("file_stack_info", this.f8175g);
                    jSONObject.put("file_free_space", file.getFreeSpace());
                    jSONObject.put("file_total_space", file.getTotalSpace());
                } catch (JSONException e2) {
                    if (a.f8171a) {
                        e2.printStackTrace();
                    }
                }
                c.b bVar = new c.b(10018);
                bVar.j(this.f8174f);
                bVar.h(d.J().getAppId());
                bVar.i(jSONObject.toString());
                bVar.m();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8176e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8177f;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8176e = str;
            this.f8177f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f8176e);
                    jSONObject.put("pagePath", this.f8177f);
                } catch (JSONException e2) {
                    if (a.f8171a) {
                        e2.printStackTrace();
                    }
                }
                c.b bVar = new c.b(10018);
                bVar.i(jSONObject.toString());
                bVar.h(d.J().getAppId());
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1939733564, "Lb/a/p0/a/r2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1939733564, "Lb/a/p0/a/r2/f/a;");
                return;
            }
        }
        f8171a = k.f6863a;
        f8172b = -1;
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || c() <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f2 = o0.f(str2);
            if (new File(str, f2 + ".swan.js").exists()) {
                return;
            }
            f(str, f2);
            return;
        }
        e(str, str2);
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f8172b < 0) {
                b.a.p0.a.c1.a.g0().getSwitch("swan_app_file_analysis_switch", 0);
                f8172b = 0;
            }
            return f8172b;
        }
        return invokeV.intValue;
    }

    public static String d(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file != null && file.exists() && file.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Stack stack = new Stack();
                stack.push(file);
                while (!stack.isEmpty()) {
                    File file2 = (File) stack.pop();
                    if (file2 != null) {
                        if (file2.isFile()) {
                            arrayList.add(file2);
                        } else if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            Collections.addAll(stack, listFiles);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        File file3 = (File) arrayList.get(i2);
                        arrayList2.add(file3.getAbsolutePath() + "|" + new Date(file3.lastModified()));
                    }
                }
                return Arrays.toString(arrayList2.toArray());
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            q.f().execute(new b(str, str2));
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            q.f().execute(new RunnableC0386a(str, str2, Arrays.toString(new Exception().getStackTrace())));
        }
    }
}
