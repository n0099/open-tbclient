package c.a.z.a.h;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.j.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30960a;

    /* renamed from: b  reason: collision with root package name */
    public File f30961b;

    /* renamed from: c  reason: collision with root package name */
    public File f30962c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f30963d;

    /* renamed from: e  reason: collision with root package name */
    public b f30964e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.z.a.g.a f30965f;

    /* renamed from: g  reason: collision with root package name */
    public long f30966g;

    /* renamed from: h  reason: collision with root package name */
    public int f30967h;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b<T> implements c.a.z.a.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f30968a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f30970c;

        /* loaded from: classes4.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f30971e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f30972f;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30972f = bVar;
                this.f30971e = str;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f30972f.f30970c.s(this.f30971e);
                    this.f30972f.f(null);
                }
            }
        }

        /* renamed from: c.a.z.a.h.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1436b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f30973e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Exception f30974f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f30975g;

            public RunnableC1436b(b bVar, boolean z, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Boolean.valueOf(z), exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30975g = bVar;
                this.f30973e = z;
                this.f30974f = exc;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: c.a.z.a.h.i$c */
            /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: c.a.z.a.h.i$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = 0;
                    if (this.f30973e) {
                        while (i2 < this.f30975g.f30970c.f30963d.size()) {
                            c cVar = (c) this.f30975g.f30970c.f30963d.get(i2);
                            if (cVar != 0) {
                                cVar.a(this.f30975g.f30968a, this.f30975g.f30970c.f30961b.getAbsolutePath());
                            }
                            i2++;
                        }
                        if (this.f30975g.f30970c.f30965f != null) {
                            this.f30975g.f30970c.f30965f.b(this.f30975g.f30970c.f30961b.getAbsolutePath());
                            return;
                        }
                        return;
                    }
                    while (i2 < this.f30975g.f30970c.f30963d.size()) {
                        c cVar2 = (c) this.f30975g.f30970c.f30963d.get(i2);
                        if (cVar2 != 0) {
                            cVar2.b(this.f30975g.f30968a, this.f30974f);
                        }
                        i2++;
                    }
                    if (this.f30975g.f30970c.f30965f != null) {
                        this.f30975g.f30970c.f30965f.onFailed(this.f30974f);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30970c = iVar;
        }

        @Override // c.a.z.a.g.a
        public void a(long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) || i2 == this.f30970c.f30967h) {
                return;
            }
            this.f30970c.f30966g = j3;
            this.f30970c.f30967h = i2;
            for (int i3 = 0; i3 < this.f30970c.f30963d.size(); i3++) {
                c cVar = (c) this.f30970c.f30963d.get(i3);
                if (cVar != null) {
                    cVar.c(this.f30968a, j2, j3, i2);
                }
            }
            if (this.f30970c.f30965f != null) {
                this.f30970c.f30965f.a(j2, j3, i2);
            }
        }

        @Override // c.a.z.a.g.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f30970c.p()) {
                    d("onCompleted(download): " + str);
                }
                new a(this, str).start();
                this.f30969b = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30969b : invokeV.booleanValue;
        }

        public void f(Exception exc) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, exc) == null) || this.f30970c.f30963d == null || this.f30970c.f30963d.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC1436b(this, this.f30970c.q(), exc));
        }

        public void g(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.f30968a = t;
            }
        }

        @Override // c.a.z.a.g.a
        public void onFailed(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                if (this.f30970c.p()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFailed: ");
                    sb.append(this.f30970c.f30960a);
                    sb.append(StringUtils.LF);
                    sb.append(exc != null ? exc.getMessage() : "");
                    d(sb.toString());
                }
                if (this.f30970c.f30962c.exists()) {
                    this.f30970c.f30962c.delete();
                }
                for (int i2 = 0; i2 < this.f30970c.f30963d.size(); i2++) {
                    c cVar = (c) this.f30970c.f30963d.get(i2);
                    if (cVar != null) {
                        cVar.b(this.f30968a, exc);
                    }
                }
                if (this.f30970c.f30965f != null) {
                    this.f30970c.f30965f.onFailed(exc);
                }
                this.f30969b = false;
            }
        }

        @Override // c.a.z.a.g.a
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f30969b = true;
                if (this.f30970c.p()) {
                    d("onStarted");
                }
                for (int i2 = 0; i2 < this.f30970c.f30963d.size(); i2++) {
                    c cVar = (c) this.f30970c.f30963d.get(i2);
                    if (cVar != null) {
                        cVar.d(this.f30968a);
                    }
                }
                if (this.f30970c.f30965f != null) {
                    this.f30970c.f30965f.onStarted();
                }
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public void c(T t, long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{t, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30960a = str;
        this.f30961b = file;
        this.f30963d = new ArrayList();
        this.f30962c = new File(this.f30961b.getAbsolutePath() + ".loading");
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
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
                if (this.f30964e == null) {
                    b bVar = new b(this, null);
                    this.f30964e = bVar;
                    bVar.g(this);
                }
                c.a.z.a.g.b d2 = c.a.z.a.b.d();
                if (d2 != null) {
                    d2.a(this.f30960a, this.f30962c.getParent(), this.f30962c.getName(), this.f30964e);
                }
            }
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (q()) {
                if (cVar != null) {
                    cVar.a(this, this.f30961b.getAbsolutePath());
                    return;
                }
                return;
            }
            if (cVar != null && !this.f30963d.contains(cVar)) {
                this.f30963d.add(cVar);
            }
            k();
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30961b : (File) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30967h : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30960a : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.z.a.b.n() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            File file = this.f30961b;
            return file != null && file.exists();
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.f30964e;
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
                    j("onCompleted-unzip:" + str + "\nto " + this.f30961b.getAbsolutePath());
                }
                File file2 = new File(this.f30961b + ".ziping");
                if (file2.exists()) {
                    if (p()) {
                        j("delete older exists " + file2);
                    }
                    c.a.z.a.j.e.e(file2);
                }
                boolean z3 = true;
                try {
                    j.a(file, file2);
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
                    z2 = file2.renameTo(this.f30961b) & z3;
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
