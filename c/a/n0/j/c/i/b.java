package c.a.n0.j.c.i;

import android.util.Log;
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
/* loaded from: classes2.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8635f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, c> a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f8636b;

    /* renamed from: c  reason: collision with root package name */
    public String f8637c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.j.z.b f8638d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f8639e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1576351159, "Lc/a/n0/j/c/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1576351159, "Lc/a/n0/j/c/i/b;");
                return;
            }
        }
        f8635f = c.a.n0.a.a.a;
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f8636b = new HashMap<>();
        this.f8639e = new Object();
        this.f8637c = str;
    }

    @Override // c.a.n0.j.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.f8639e) {
                if (d(str) && (arrayList = this.f8636b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.get(i).a(str, str2);
                        if (f8635f) {
                            Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
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
            if (this.f8636b.containsKey(str)) {
                this.f8636b.get(str).add(aVar);
                return;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            arrayList.add(aVar);
            this.f8636b.put(str, arrayList);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f8635f) {
                Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
            }
            if (this.f8638d == null) {
                this.f8638d = c.a.n0.j.z.b.b();
            }
            c cVar = new c(this.f8638d, this.f8637c, str, this);
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
            synchronized (this.f8639e) {
                if (!d(str)) {
                    if (f8635f) {
                        Log.e("AudioDownloadManager", "start load url = " + str);
                    }
                    c(str);
                } else if (f8635f) {
                    Log.e("AudioDownloadManager", "re load url = " + str);
                }
                b(str, aVar);
            }
        }
    }

    @Override // c.a.n0.j.c.i.a
    public void fail(int i, String str) {
        ArrayList<a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            synchronized (this.f8639e) {
                if (d(str) && (arrayList = this.f8636b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).fail(i, str);
                    }
                    this.a.remove(str);
                }
            }
        }
    }
}
