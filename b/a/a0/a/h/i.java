package b.a.a0.a.h;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import b.a.a0.a.j.j;
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

    /* renamed from: a  reason: collision with root package name */
    public String f1200a;

    /* renamed from: b  reason: collision with root package name */
    public File f1201b;

    /* renamed from: c  reason: collision with root package name */
    public File f1202c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f1203d;

    /* renamed from: e  reason: collision with root package name */
    public b f1204e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.a0.a.g.a f1205f;

    /* renamed from: g  reason: collision with root package name */
    public long f1206g;

    /* renamed from: h  reason: collision with root package name */
    public int f1207h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b<T> implements b.a.a0.a.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f1208a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f1210c;

        /* loaded from: classes.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f1211e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f1212f;

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
                this.f1212f = bVar;
                this.f1211e = str;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1212f.f1210c.s(this.f1211e);
                    this.f1212f.f(null);
                }
            }
        }

        /* renamed from: b.a.a0.a.h.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0010b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f1213e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Exception f1214f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f1215g;

            public RunnableC0010b(b bVar, boolean z, Exception exc) {
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
                this.f1215g = bVar;
                this.f1213e = z;
                this.f1214f = exc;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: b.a.a0.a.h.i$c */
            /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: b.a.a0.a.h.i$c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = 0;
                    if (this.f1213e) {
                        while (i2 < this.f1215g.f1210c.f1203d.size()) {
                            c cVar = (c) this.f1215g.f1210c.f1203d.get(i2);
                            if (cVar != 0) {
                                cVar.a(this.f1215g.f1208a, this.f1215g.f1210c.f1201b.getAbsolutePath());
                            }
                            i2++;
                        }
                        if (this.f1215g.f1210c.f1205f != null) {
                            this.f1215g.f1210c.f1205f.b(this.f1215g.f1210c.f1201b.getAbsolutePath());
                            return;
                        }
                        return;
                    }
                    while (i2 < this.f1215g.f1210c.f1203d.size()) {
                        c cVar2 = (c) this.f1215g.f1210c.f1203d.get(i2);
                        if (cVar2 != 0) {
                            cVar2.b(this.f1215g.f1208a, this.f1214f);
                        }
                        i2++;
                    }
                    if (this.f1215g.f1210c.f1205f != null) {
                        this.f1215g.f1210c.f1205f.onFailed(this.f1214f);
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
            this.f1210c = iVar;
        }

        @Override // b.a.a0.a.g.a
        public void a(long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) || i2 == this.f1210c.f1207h) {
                return;
            }
            this.f1210c.f1206g = j2;
            this.f1210c.f1207h = i2;
            for (int i3 = 0; i3 < this.f1210c.f1203d.size(); i3++) {
                c cVar = (c) this.f1210c.f1203d.get(i3);
                if (cVar != null) {
                    cVar.c(this.f1208a, j, j2, i2);
                }
            }
            if (this.f1210c.f1205f != null) {
                this.f1210c.f1205f.a(j, j2, i2);
            }
        }

        @Override // b.a.a0.a.g.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f1210c.p()) {
                    d("onCompleted(download): " + str);
                }
                new a(this, str).start();
                this.f1209b = false;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1209b : invokeV.booleanValue;
        }

        public void f(Exception exc) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, exc) == null) || this.f1210c.f1203d == null || this.f1210c.f1203d.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC0010b(this, this.f1210c.q(), exc));
        }

        public void g(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.f1208a = t;
            }
        }

        @Override // b.a.a0.a.g.a
        public void onFailed(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                if (this.f1210c.p()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFailed: ");
                    sb.append(this.f1210c.f1200a);
                    sb.append(StringUtils.LF);
                    sb.append(exc != null ? exc.getMessage() : "");
                    d(sb.toString());
                }
                if (this.f1210c.f1202c.exists()) {
                    this.f1210c.f1202c.delete();
                }
                for (int i2 = 0; i2 < this.f1210c.f1203d.size(); i2++) {
                    c cVar = (c) this.f1210c.f1203d.get(i2);
                    if (cVar != null) {
                        cVar.b(this.f1208a, exc);
                    }
                }
                if (this.f1210c.f1205f != null) {
                    this.f1210c.f1205f.onFailed(exc);
                }
                this.f1209b = false;
            }
        }

        @Override // b.a.a0.a.g.a
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f1209b = true;
                if (this.f1210c.p()) {
                    d("onStarted");
                }
                for (int i2 = 0; i2 < this.f1210c.f1203d.size(); i2++) {
                    c cVar = (c) this.f1210c.f1203d.get(i2);
                    if (cVar != null) {
                        cVar.d(this.f1208a);
                    }
                }
                if (this.f1210c.f1205f != null) {
                    this.f1210c.f1205f.onStarted();
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

        public void c(T t, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{t, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
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
        this.f1200a = str;
        this.f1201b = file;
        this.f1203d = new ArrayList();
        this.f1202c = new File(this.f1201b.getAbsolutePath() + ".loading");
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
                if (this.f1204e == null) {
                    b bVar = new b(this, null);
                    this.f1204e = bVar;
                    bVar.g(this);
                }
                b.a.a0.a.g.b c2 = b.a.a0.a.b.c();
                if (c2 != null) {
                    c2.a(this.f1200a, this.f1202c.getParent(), this.f1202c.getName(), this.f1204e);
                }
            }
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (q()) {
                if (cVar != null) {
                    cVar.a(this, this.f1201b.getAbsolutePath());
                    return;
                }
                return;
            }
            if (cVar != null && !this.f1203d.contains(cVar)) {
                this.f1203d.add(cVar);
            }
            k();
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1201b : (File) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1207h : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1200a : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b.a.a0.a.b.m() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            File file = this.f1201b;
            return file != null && file.exists();
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.f1204e;
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
                    j("onCompleted-unzip:" + str + "\nto " + this.f1201b.getAbsolutePath());
                }
                File file2 = new File(this.f1201b + ".ziping");
                if (file2.exists()) {
                    if (p()) {
                        j("delete older exists " + file2);
                    }
                    b.a.a0.a.j.e.e(file2);
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
                    b.a.a0.a.j.e.e(file2);
                    z2 = z3;
                } else {
                    z2 = file2.renameTo(this.f1201b) & z3;
                }
            } catch (Exception e3) {
                j("Exception on onFileLoaderCompledted " + e3.getMessage());
                e3.printStackTrace();
            }
            b.a.a0.a.j.e.d(file);
            return z2;
        }
        return invokeL.booleanValue;
    }
}
