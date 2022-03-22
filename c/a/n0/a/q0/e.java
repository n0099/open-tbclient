package c.a.n0.a.q0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q;
import c.a.n0.a.q0.d;
import c.a.n0.a.q0.f;
import c.a.n0.a.q0.g.a;
import c.a.n0.a.v0.g.b;
import c.a.n0.q.e.j;
import c.a.n0.w.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes.dex */
public class e extends f.AbstractC0423f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5966g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.n0.q.h.f f5967d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.n0.q.e.f f5968e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.h2.f.b f5969f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1220345809, "Lc/a/n0/a/q0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1220345809, "Lc/a/n0/a/q0/e;");
                return;
            }
        }
        f5966g = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.n0.q.h.f fVar, c.a.n0.q.e.f fVar2) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, fVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5967d = fVar;
        this.f5968e = fVar2;
    }

    @Override // c.a.n0.a.q0.f.AbstractC0423f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e();
            if (b().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = b().getString("result_output_dir");
                c.a.n0.a.u.d.k("SwanExtractor", "#onInstallFaild del: " + string);
                c.a.n0.w.d.M(string);
            }
        }
    }

    @Override // c.a.n0.a.q0.f.AbstractC0423f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        c.a.n0.a.v0.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (f5966g) {
                aVar = c.a.n0.a.v0.g.a.d(string);
                b.C0486b e2 = aVar.e();
                e2.b("SwanExtractor");
                e2.d(1);
            } else {
                aVar = null;
            }
            boolean k = k(Channels.newInputStream(sourceChannel), string);
            if (aVar != null && f5966g) {
                aVar.g("SwanExtractor", "done: " + k);
            }
            return k;
        }
        return invokeLL.booleanValue;
    }

    public final void j() {
        c.a.n0.q.h.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fVar = this.f5967d) == null || fVar.f9146h != 0 || d.w()) {
            return;
        }
        d.e(this.f5967d.f9145g + File.separator + this.f5967d.i);
    }

    public final boolean k(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            c.a.n0.a.k2.a q = q(new BufferedInputStream(inputStream), str);
            if (q == null) {
                return true;
            }
            c.a.n0.a.u.d.k("SwanExtractor", "#extract error=" + q);
            if (f5966g) {
                c.a.n0.a.v0.g.a d2 = c.a.n0.a.v0.g.a.d(str);
                d2.g("SwanExtractor", "onProcess installe error=" + q);
            }
            b().putLong("result_error_code", q.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                p("670", "package_end_decrypt");
                p("770", "na_package_end_decrypt");
                return;
            }
            p("670", "package_end_unzip");
            p("770", "na_package_end_unzip");
        }
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                p("670", "package_start_decrypt");
                p("770", "na_package_start_decrypt");
                return;
            }
            p("670", "package_start_unzip");
            p("770", "na_package_start_unzip");
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || c.a.n0.a.h2.f.a.c() <= 0) {
            return;
        }
        if (f5966g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f5969f == null) {
            c.a.n0.a.h2.f.b bVar = new c.a.n0.a.h2.f.b(str);
            this.f5969f = bVar;
            bVar.startWatching();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || c.a.n0.a.h2.f.a.c() <= 0) {
            return;
        }
        if (f5966g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        c.a.n0.a.h2.f.b bVar = this.f5969f;
        if (bVar == null) {
            return;
        }
        bVar.stopWatching();
        this.f5969f = null;
    }

    public final void p(String str, String str2) {
        c.a.n0.q.e.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (fVar = this.f5968e) == null) {
            return;
        }
        fVar.n(str, str2);
    }

    public final c.a.n0.a.k2.a q(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            c.a.n0.a.v0.g.a d2 = c.a.n0.a.v0.g.a.d(str);
            c.a.n0.q.h.f fVar = this.f5967d;
            if (fVar == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(11L);
                aVar.i(2320L);
                aVar.f("pkg info is empty");
                c.a.n0.a.k2.e.a().f(aVar);
                return aVar;
            }
            int i2 = fVar.f9146h;
            boolean z = true;
            if (i2 == 1) {
                c.a.n0.a.f.b.a.e g2 = c.a.n0.a.s0.b.g();
                c.a.n0.q.h.f fVar2 = this.f5967d;
                i = g2.a(fVar2.f9145g, String.valueOf(fVar2.i));
            } else if (i2 == 0) {
                i = d.e.i(fVar.f9145g, String.valueOf(fVar.i));
            } else {
                c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                aVar2.k(11L);
                aVar2.i(2320L);
                aVar2.f("pkh category illegal");
                c.a.n0.a.k2.e.a().f(aVar2);
                return aVar2;
            }
            if (i == null) {
                c.a.n0.a.k2.a aVar3 = new c.a.n0.a.k2.a();
                aVar3.k(11L);
                aVar3.i(2320L);
                aVar3.f("获取解压目录失败");
                c.a.n0.a.k2.e.a().f(aVar3);
                return aVar3;
            } else if (i.isFile() && !i.delete()) {
                if (f5966g) {
                    d2.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                c.a.n0.a.k2.a aVar4 = new c.a.n0.a.k2.a();
                aVar4.k(11L);
                aVar4.i(2320L);
                aVar4.f("解压失败：解压目录被文件占用，且无法删除");
                c.a.n0.a.k2.e.a().f(aVar4);
                return aVar4;
            } else {
                if (!i.exists()) {
                    b().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (f5966g) {
                            d2.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        q.k(new a(this), "doFallbackIfNeeded");
                        c.a.n0.a.k2.a aVar5 = new c.a.n0.a.k2.a();
                        aVar5.k(11L);
                        aVar5.i(2320L);
                        aVar5.f("解压失败：解压文件夹创建失败");
                        c.a.n0.a.k2.e.a().f(aVar5);
                        return aVar5;
                    }
                }
                n(i.getPath());
                if (f5966g) {
                    d2.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                b().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    a.c i3 = c.a.n0.a.q0.g.a.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.f5985b;
                    boolean z2 = i4 != -1;
                    m(z2);
                    if (z2) {
                        bVar = c.a.n0.a.q0.g.a.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = g.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    l(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (f5966g) {
                        c.a.n0.a.q0.g.a.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.f5968e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        j.a(this.f5968e, bundle, "event_download_package_type");
                    }
                    o();
                    if (z) {
                        return null;
                    }
                    c.a.n0.a.k2.a aVar6 = new c.a.n0.a.k2.a();
                    aVar6.k(11L);
                    if (z2) {
                        aVar6.i(2330L);
                        aVar6.f("decrypt failed:" + bVar.f5984b);
                    } else {
                        aVar6.i(2320L);
                        aVar6.f("unzip failed");
                    }
                    c.a.n0.a.k2.e.a().f(aVar6);
                    return aVar6;
                } catch (IOException e2) {
                    if (f5966g) {
                        d2.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e2.toString());
                        e2.printStackTrace();
                    }
                    c.a.n0.a.k2.a aVar7 = new c.a.n0.a.k2.a();
                    aVar7.k(11L);
                    aVar7.i(2320L);
                    aVar7.f("obtainEncryptedBundle Exception: " + e2.toString());
                    c.a.n0.a.k2.e.a().f(aVar7);
                    return aVar7;
                }
            }
        }
        return (c.a.n0.a.k2.a) invokeLL.objValue;
    }
}
