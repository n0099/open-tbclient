package c.a.o0.a.l0.m;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7174f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f7175g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f7176a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f7177b;

    /* renamed from: c  reason: collision with root package name */
    public String f7178c;

    /* renamed from: d  reason: collision with root package name */
    public HttpManager f7179d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f7180e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(213012144, "Lc/a/o0/a/l0/m/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(213012144, "Lc/a/o0/a/l0/m/b;");
                return;
            }
        }
        f7174f = k.f7049a;
    }

    public b() {
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
        this.f7176a = new HashMap<>();
        this.f7177b = new HashMap<>();
        this.f7180e = new Object();
        this.f7179d = c.a.o0.a.c1.b.l().b();
        this.f7178c = c.a.o0.a.c1.b.f().a();
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7175g == null) {
                synchronized (b.class) {
                    if (f7175g == null) {
                        f7175g = new b();
                    }
                }
            }
            return f7175g;
        }
        return (b) invokeV.objValue;
    }

    @Override // c.a.o0.a.l0.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.f7180e) {
                if (f(str) && (arrayList = this.f7177b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).onReceiveValue(str2);
                        if (f7174f) {
                            String str3 = i2 + " load success url = " + str + " path = " + str2;
                        }
                    }
                    this.f7176a.remove(str);
                }
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, valueCallback) == null) {
            if (this.f7177b.containsKey(str)) {
                this.f7177b.get(str).add(valueCallback);
                return;
            }
            ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
            arrayList.add(valueCallback);
            this.f7177b.put(str, arrayList);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f7174f) {
                String str2 = "ImageDownloadManager SwanGamePreloadManager url:" + str;
            }
            c cVar = new c(this.f7179d, this.f7178c, str, this);
            this.f7176a.put(str, cVar);
            cVar.e();
        }
    }

    public final String d(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.f7178c + c.a.o0.a.c1.b.f().c(str);
        }
        return (String) invokeL.objValue;
    }

    public final boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f7176a.containsKey(str) : invokeL.booleanValue;
    }

    @Override // c.a.o0.a.l0.m.a
    public void fail(int i2, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            synchronized (this.f7180e) {
                if (f(str) && (arrayList = this.f7177b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList.get(i3).onReceiveValue("");
                    }
                    this.f7176a.remove(str);
                }
            }
        }
    }

    public void g(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, valueCallback) == null) {
            if (TextUtils.isEmpty(str)) {
                valueCallback.onReceiveValue(null);
                return;
            }
            try {
                String d2 = d(str);
                if (TextUtils.isEmpty(d2)) {
                    return;
                }
                File file = new File(d(str));
                if (file.exists() && !file.isDirectory()) {
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(d2);
                        return;
                    }
                    return;
                }
                synchronized (this.f7180e) {
                    if (!f(str)) {
                        c(str);
                    }
                    b(str, valueCallback);
                }
            } catch (Exception e2) {
                if (f7174f) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
