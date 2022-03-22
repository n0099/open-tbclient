package c.a.z.a.h;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.j.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public File f22185b;

    /* renamed from: c  reason: collision with root package name */
    public File f22186c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f22187d;

    /* renamed from: e  reason: collision with root package name */
    public b f22188e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.z.a.g.a f22189f;

    /* renamed from: g  reason: collision with root package name */
    public long f22190g;

    /* renamed from: h  reason: collision with root package name */
    public int f22191h;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b<T> implements c.a.z.a.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f22192b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f22193c;

        /* loaded from: classes3.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f22194b;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22194b = bVar;
                this.a = str;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f22194b.f22193c.s(this.a);
                    this.f22194b.f(null);
                }
            }
        }

        /* renamed from: c.a.z.a.h.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1637b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Exception f22195b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f22196c;

            public RunnableC1637b(b bVar, boolean z, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Boolean.valueOf(z), exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22196c = bVar;
                this.a = z;
                this.f22195b = exc;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: c.a.z.a.h.i$c */
            /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: c.a.z.a.h.i$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i = 0;
                    if (this.a) {
                        while (i < this.f22196c.f22193c.f22187d.size()) {
                            c cVar = (c) this.f22196c.f22193c.f22187d.get(i);
                            if (cVar != 0) {
                                cVar.a(this.f22196c.a, this.f22196c.f22193c.f22185b.getAbsolutePath());
                            }
                            i++;
                        }
                        if (this.f22196c.f22193c.f22189f != null) {
                            this.f22196c.f22193c.f22189f.b(this.f22196c.f22193c.f22185b.getAbsolutePath());
                            return;
                        }
                        return;
                    }
                    while (i < this.f22196c.f22193c.f22187d.size()) {
                        c cVar2 = (c) this.f22196c.f22193c.f22187d.get(i);
                        if (cVar2 != 0) {
                            cVar2.b(this.f22196c.a, this.f22195b);
                        }
                        i++;
                    }
                    if (this.f22196c.f22193c.f22189f != null) {
                        this.f22196c.f22193c.f22189f.onFailed(this.f22195b);
                    }
                }
            }
        }

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22193c = iVar;
        }

        @Override // c.a.z.a.g.a
        public void a(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) || i == this.f22193c.f22191h) {
                return;
            }
            this.f22193c.f22190g = j2;
            this.f22193c.f22191h = i;
            for (int i2 = 0; i2 < this.f22193c.f22187d.size(); i2++) {
                c cVar = (c) this.f22193c.f22187d.get(i2);
                if (cVar != null) {
                    cVar.c(this.a, j, j2, i);
                }
            }
            if (this.f22193c.f22189f != null) {
                this.f22193c.f22189f.a(j, j2, i);
            }
        }

        @Override // c.a.z.a.g.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f22193c.p()) {
                    d("onCompleted(download): " + str);
                }
                new a(this, str).start();
                this.f22192b = false;
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                i.j("res:" + str);
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22192b : invokeV.booleanValue;
        }

        public void f(Exception exc) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, exc) == null) || this.f22193c.f22187d == null || this.f22193c.f22187d.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC1637b(this, this.f22193c.q(), exc));
        }

        public void g(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.a = t;
            }
        }

        @Override // c.a.z.a.g.a
        public void onFailed(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                if (this.f22193c.p()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFailed: ");
                    sb.append(this.f22193c.a);
                    sb.append("\n");
                    sb.append(exc != null ? exc.getMessage() : "");
                    d(sb.toString());
                }
                if (this.f22193c.f22186c.exists()) {
                    this.f22193c.f22186c.delete();
                }
                for (int i = 0; i < this.f22193c.f22187d.size(); i++) {
                    c cVar = (c) this.f22193c.f22187d.get(i);
                    if (cVar != null) {
                        cVar.b(this.a, exc);
                    }
                }
                if (this.f22193c.f22189f != null) {
                    this.f22193c.f22189f.onFailed(exc);
                }
                this.f22192b = false;
            }
        }

        @Override // c.a.z.a.g.a
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f22192b = true;
                if (this.f22193c.p()) {
                    d("onStarted");
                }
                for (int i = 0; i < this.f22193c.f22187d.size(); i++) {
                    c cVar = (c) this.f22193c.f22187d.get(i);
                    if (cVar != null) {
                        cVar.d(this.a);
                    }
                }
                if (this.f22193c.f22189f != null) {
                    this.f22193c.f22189f.onStarted();
                }
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(T t, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t, str) == null) {
            }
        }

        public void b(T t, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, exc) == null) {
            }
        }

        public void c(T t, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{t, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            }
        }

        public void d(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            }
        }
    }

    public i(String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f22185b = file;
        this.f22187d = new ArrayList();
        this.f22186c = new File(this.f22185b.getAbsolutePath() + ".loading");
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            Log.d("DuAr_FileLoader", str);
        }
    }

    public boolean i(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || q() || r()) {
            return;
        }
        synchronized (this) {
            if (!q() && !r()) {
                if (this.f22188e == null) {
                    b bVar = new b(this, null);
                    this.f22188e = bVar;
                    bVar.g(this);
                }
                c.a.z.a.g.b c2 = c.a.z.a.b.c();
                if (c2 != null) {
                    c2.a(this.a, this.f22186c.getParent(), this.f22186c.getName(), this.f22188e);
                }
            }
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (q()) {
                if (cVar != null) {
                    cVar.a(this, this.f22185b.getAbsolutePath());
                    return;
                }
                return;
            }
            if (cVar != null && !this.f22187d.contains(cVar)) {
                this.f22187d.add(cVar);
            }
            k();
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22185b : (File) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22191h : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.z.a.b.m() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            File file = this.f22185b;
            return file != null && file.exists();
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.f22188e;
            return bVar != null && bVar.e();
        }
        return invokeV.booleanValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            File file = new File(str);
            boolean z2 = false;
            try {
                if (p()) {
                    j("onCompleted-unzip:" + str + "\nto " + this.f22185b.getAbsolutePath());
                }
                File file2 = new File(this.f22185b + ".ziping");
                if (file2.exists()) {
                    if (p()) {
                        j("delete older exists " + file2);
                    }
                    c.a.z.a.j.e.e(file2);
                }
                boolean z3 = true;
                try {
                    k.a(file, file2);
                    z = true;
                } catch (Exception e2) {
                    j("unzipFile Exception : " + e2.getMessage() + " " + str);
                    z = false;
                }
                if (!z || !i(file2)) {
                    z3 = false;
                }
                if (!z3) {
                    if (p()) {
                        j("faild on afterUnziped " + file2);
                    }
                    c.a.z.a.j.e.e(file2);
                    z2 = z3;
                } else {
                    z2 = file2.renameTo(this.f22185b) & z3;
                }
            } catch (Exception e3) {
                j("Exception on onFileLoaderCompledted " + e3.getMessage());
                e3.printStackTrace();
            }
            c.a.z.a.j.e.d(file);
            return z2;
        }
        return invokeL.booleanValue;
    }
}
