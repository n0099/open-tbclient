package c.a.p0.j.c.i;

import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f10063f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, c> a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f10064b;

    /* renamed from: c  reason: collision with root package name */
    public String f10065c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.j.z.b f10066d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f10067e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2017551559, "Lc/a/p0/j/c/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2017551559, "Lc/a/p0/j/c/i/b;");
                return;
            }
        }
        f10063f = k.a;
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f10064b = new HashMap<>();
        this.f10067e = new Object();
        this.f10065c = str;
    }

    @Override // c.a.p0.j.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.f10067e) {
                if (d(str) && (arrayList = this.f10064b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).a(str, str2);
                        if (f10063f) {
                            String str3 = i2 + " load success url = " + str + " path = " + str2;
                        }
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public final void b(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            if (this.f10064b.containsKey(str)) {
                this.f10064b.get(str).add(aVar);
                return;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            arrayList.add(aVar);
            this.f10064b.put(str, arrayList);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f10063f) {
                String str2 = "AudioDownloader SwanGamePreloadManager url:" + str;
            }
            if (this.f10066d == null) {
                this.f10066d = c.a.p0.j.z.b.b();
            }
            c cVar = new c(this.f10066d, this.f10065c, str, this);
            this.a.put(str, cVar);
            cVar.e();
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.a.containsKey(str) : invokeL.booleanValue;
    }

    public void e(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, aVar) == null) {
            synchronized (this.f10067e) {
                if (!d(str)) {
                    if (f10063f) {
                        String str2 = "start load url = " + str;
                    }
                    c(str);
                } else if (f10063f) {
                    String str3 = "re load url = " + str;
                }
                b(str, aVar);
            }
        }
    }

    @Override // c.a.p0.j.c.i.a
    public void fail(int i2, String str) {
        ArrayList<a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            synchronized (this.f10067e) {
                if (d(str) && (arrayList = this.f10064b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList.get(i3).fail(i2, str);
                    }
                    this.a.remove(str);
                }
            }
        }
    }
}
