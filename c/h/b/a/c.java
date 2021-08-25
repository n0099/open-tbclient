package c.h.b.a;

import android.os.Environment;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import c.h.b.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static c f32274e;

    /* renamed from: f  reason: collision with root package name */
    public static c.h.b.a.b f32275f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f32276a;

    /* renamed from: b  reason: collision with root package name */
    public i f32277b;

    /* renamed from: c  reason: collision with root package name */
    public h f32278c;

    /* renamed from: d  reason: collision with root package name */
    public List<d> f32279d;

    /* loaded from: classes4.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f32280a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32280a = cVar;
        }

        @Override // c.h.b.a.g.b
        public void a(long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) {
                ArrayList<String> e2 = this.f32280a.f32277b.e(j2, j3);
                if (e2.isEmpty()) {
                    return;
                }
                c.h.b.a.j.a b2 = c.h.b.a.j.a.b();
                b2.c(j2, j3, j4, j5);
                b2.d(this.f32280a.f32278c.e());
                b2.e(e2);
                b2.a();
                if (c.d().displayNotification()) {
                    f.c(b2.toString());
                }
                if (this.f32280a.f32279d.size() != 0) {
                    for (d dVar : this.f32280a.f32279d) {
                        dVar.onBlock(c.d().provideContext(), b2);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f32281a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32281a = ".log";
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(this.f32281a) : invokeLL.booleanValue;
        }
    }

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
                return;
            }
        }
        this.f32279d = new LinkedList();
        this.f32277b = new i(Looper.getMainLooper().getThread(), f32275f.provideDumpInterval());
        this.f32278c = new h(f32275f.provideDumpInterval());
        m(new g(new a(this), d().provideBlockThreshold(), d().stopWhenDebugging()));
        f.b();
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File file = new File(i());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static c.h.b.a.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f32275f : (c.h.b.a.b) invokeV.objValue;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f32274e == null) {
                synchronized (c.class) {
                    if (f32274e == null) {
                        f32274e = new c();
                    }
                }
            }
            return f32274e;
        }
        return (c) invokeV.objValue;
    }

    public static File[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            File c2 = c();
            if (c2.exists() && c2.isDirectory()) {
                return c2.listFiles(new b());
            }
            return null;
        }
        return (File[]) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            String providePath = d() == null ? "" : d().providePath();
            if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
                return Environment.getExternalStorageDirectory().getPath() + providePath;
            }
            return d().provideContext().getFilesDir() + d().providePath();
        }
        return (String) invokeV.objValue;
    }

    public static void l(c.h.b.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            f32275f = bVar;
        }
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f32279d.add(dVar);
        }
    }

    public h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32278c : (h) invokeV.objValue;
    }

    public g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32276a : (g) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d().provideBlockThreshold() * 0.8f : invokeV.longValue;
    }

    public i k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32277b : (i) invokeV.objValue;
    }

    public final void m(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f32276a = gVar;
        }
    }
}
