package c.a.n0.j.c.j;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.j.c.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8644e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f8645f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ArrayList<b>> a;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f8646b;

    /* renamed from: c  reason: collision with root package name */
    public String f8647c;

    /* renamed from: d  reason: collision with root package name */
    public Object f8648d;

    /* renamed from: c.a.n0.j.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0694a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JsArrayBuffer a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8649b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8650c;

        public RunnableC0694a(a aVar, JsArrayBuffer jsArrayBuffer, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jsArrayBuffer, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8650c = aVar;
            this.a = jsArrayBuffer;
            this.f8649b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String g2 = this.f8650c.g(this.a.buffer());
                File file = new File(g2);
                if (!file.exists()) {
                    if (this.f8650c.e(g2, this.f8649b)) {
                        return;
                    }
                    this.f8650c.i(g2, this.a.buffer());
                } else if (!file.isDirectory()) {
                    this.f8649b.b(g2);
                } else {
                    this.f8649b.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1576380919, "Lc/a/n0/j/c/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1576380919, "Lc/a/n0/j/c/j/a;");
                return;
            }
        }
        f8644e = c.a.n0.a.a.a;
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
        this.a = new HashMap<>();
        this.f8646b = Executors.newCachedThreadPool();
        this.f8648d = new Object();
        this.f8647c = f.g() + f.f();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f8645f == null) {
                synchronized (a.class) {
                    if (f8645f == null) {
                        f8645f = new a();
                    }
                }
            }
            return f8645f;
        }
        return (a) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.f8648d) {
                ArrayList<b> arrayList = this.a.get(str);
                if (arrayList == null) {
                    return;
                }
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (!isEmpty) {
                        if (f8644e) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.b(str);
                    } else {
                        next.a();
                    }
                }
                this.a.remove(str);
            }
        }
    }

    public final boolean e(String str, b bVar) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) {
            synchronized (this.f8648d) {
                ArrayList<b> arrayList = this.a.get(str);
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(str, arrayList);
                    z = false;
                }
                arrayList.add(bVar);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final String g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            String h2 = f.h(bArr);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8647c);
            sb.append(bArr.length);
            if (TextUtils.isEmpty(h2)) {
                h2 = "";
            }
            sb.append(h2);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void h(JsArrayBuffer jsArrayBuffer, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jsArrayBuffer, bVar) == null) {
            this.f8646b.execute(new RunnableC0694a(this, jsArrayBuffer, bVar));
        }
    }

    public final void i(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) {
            File file = new File(this.f8647c);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + ".bdsave");
            Closeable closeable = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        File file3 = new File(str);
                        if (file3.exists() && !file3.isDirectory()) {
                            file3.delete();
                        }
                        if (file2.renameTo(file3)) {
                            if (f8644e) {
                                Log.e("AudioBufferManager", "buffer load rename success path = " + str);
                            }
                            d(str);
                        } else {
                            if (f8644e) {
                                Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                            }
                            file2.delete();
                            d(null);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f8644e) {
                            e.printStackTrace();
                        }
                        if (file2.exists()) {
                            file2.delete();
                        }
                        d(null);
                        c.a.n0.w.d.d(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable = ".bdsave";
                    c.a.n0.w.d.d(closeable);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.w.d.d(closeable);
                throw th;
            }
            c.a.n0.w.d.d(fileOutputStream);
        }
    }
}
