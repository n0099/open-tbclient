package c.a.b0.a.h;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.a.j.j;
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
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public File f1187b;

    /* renamed from: c  reason: collision with root package name */
    public File f1188c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f1189d;

    /* renamed from: e  reason: collision with root package name */
    public b f1190e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.b0.a.g.a f1191f;

    /* renamed from: g  reason: collision with root package name */
    public long f1192g;

    /* renamed from: h  reason: collision with root package name */
    public int f1193h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b<T> implements c.a.b0.a.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1194b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f1195c;

        /* loaded from: classes.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f1196e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f1197f;

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
                this.f1197f = bVar;
                this.f1196e = str;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1197f.f1195c.s(this.f1196e);
                    this.f1197f.f(null);
                }
            }
        }

        /* renamed from: c.a.b0.a.h.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0013b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f1198e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Exception f1199f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f1200g;

            public RunnableC0013b(b bVar, boolean z, Exception exc) {
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
                this.f1200g = bVar;
                this.f1198e = z;
                this.f1199f = exc;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: c.a.b0.a.h.i$c */
            /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: c.a.b0.a.h.i$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = 0;
                    if (this.f1198e) {
                        while (i2 < this.f1200g.f1195c.f1189d.size()) {
                            c cVar = (c) this.f1200g.f1195c.f1189d.get(i2);
                            if (cVar != 0) {
                                cVar.a(this.f1200g.a, this.f1200g.f1195c.f1187b.getAbsolutePath());
                            }
                            i2++;
                        }
                        if (this.f1200g.f1195c.f1191f != null) {
                            this.f1200g.f1195c.f1191f.b(this.f1200g.f1195c.f1187b.getAbsolutePath());
                            return;
                        }
                        return;
                    }
                    while (i2 < this.f1200g.f1195c.f1189d.size()) {
                        c cVar2 = (c) this.f1200g.f1195c.f1189d.get(i2);
                        if (cVar2 != 0) {
                            cVar2.b(this.f1200g.a, this.f1199f);
                        }
                        i2++;
                    }
                    if (this.f1200g.f1195c.f1191f != null) {
                        this.f1200g.f1195c.f1191f.onFailed(this.f1199f);
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
            this.f1195c = iVar;
        }

        @Override // c.a.b0.a.g.a
        public void a(long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) || i2 == this.f1195c.f1193h) {
                return;
            }
            this.f1195c.f1192g = j3;
            this.f1195c.f1193h = i2;
            for (int i3 = 0; i3 < this.f1195c.f1189d.size(); i3++) {
                c cVar = (c) this.f1195c.f1189d.get(i3);
                if (cVar != null) {
                    cVar.c(this.a, j2, j3, i2);
                }
            }
            if (this.f1195c.f1191f != null) {
                this.f1195c.f1191f.a(j2, j3, i2);
            }
        }

        @Override // c.a.b0.a.g.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f1195c.p()) {
                    d("onCompleted(download): " + str);
                }
                new a(this, str).start();
                this.f1194b = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1194b : invokeV.booleanValue;
        }

        public void f(Exception exc) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, exc) == null) || this.f1195c.f1189d == null || this.f1195c.f1189d.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC0013b(this, this.f1195c.q(), exc));
        }

        public void g(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.a = t;
            }
        }

        @Override // c.a.b0.a.g.a
        public void onFailed(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                if (this.f1195c.p()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFailed: ");
                    sb.append(this.f1195c.a);
                    sb.append(StringUtils.LF);
                    sb.append(exc != null ? exc.getMessage() : "");
                    d(sb.toString());
                }
                if (this.f1195c.f1188c.exists()) {
                    this.f1195c.f1188c.delete();
                }
                for (int i2 = 0; i2 < this.f1195c.f1189d.size(); i2++) {
                    c cVar = (c) this.f1195c.f1189d.get(i2);
                    if (cVar != null) {
                        cVar.b(this.a, exc);
                    }
                }
                if (this.f1195c.f1191f != null) {
                    this.f1195c.f1191f.onFailed(exc);
                }
                this.f1194b = false;
            }
        }

        @Override // c.a.b0.a.g.a
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f1194b = true;
                if (this.f1195c.p()) {
                    d("onStarted");
                }
                for (int i2 = 0; i2 < this.f1195c.f1189d.size(); i2++) {
                    c cVar = (c) this.f1195c.f1189d.get(i2);
                    if (cVar != null) {
                        cVar.d(this.a);
                    }
                }
                if (this.f1195c.f1191f != null) {
                    this.f1195c.f1191f.onStarted();
                }
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes.dex */
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
        this.a = str;
        this.f1187b = file;
        this.f1189d = new ArrayList();
        this.f1188c = new File(this.f1187b.getAbsolutePath() + ".loading");
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
                if (this.f1190e == null) {
                    b bVar = new b(this, null);
                    this.f1190e = bVar;
                    bVar.g(this);
                }
                c.a.b0.a.g.b c2 = c.a.b0.a.b.c();
                if (c2 != null) {
                    c2.a(this.a, this.f1188c.getParent(), this.f1188c.getName(), this.f1190e);
                }
            }
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (q()) {
                if (cVar != null) {
                    cVar.a(this, this.f1187b.getAbsolutePath());
                    return;
                }
                return;
            }
            if (cVar != null && !this.f1189d.contains(cVar)) {
                this.f1189d.add(cVar);
            }
            k();
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1187b : (File) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1193h : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.b0.a.b.m() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            File file = this.f1187b;
            return file != null && file.exists();
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.f1190e;
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
                    j("onCompleted-unzip:" + str + "\nto " + this.f1187b.getAbsolutePath());
                }
                File file2 = new File(this.f1187b + ".ziping");
                if (file2.exists()) {
                    if (p()) {
                        j("delete older exists " + file2);
                    }
                    c.a.b0.a.j.e.e(file2);
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
                    c.a.b0.a.j.e.e(file2);
                    z2 = z3;
                } else {
                    z2 = file2.renameTo(this.f1187b) & z3;
                }
            } catch (Exception e3) {
                j("Exception on onFileLoaderCompledted " + e3.getMessage());
                e3.printStackTrace();
            }
            c.a.b0.a.j.e.d(file);
            return z2;
        }
        return invokeL.booleanValue;
    }
}
