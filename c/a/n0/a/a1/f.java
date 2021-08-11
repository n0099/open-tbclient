package c.a.n0.a.a1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a1.e;
import c.a.n0.a.a1.g;
import c.a.n0.a.a1.h.a;
import c.a.n0.a.f1.g.b;
import c.a.n0.a.k;
import c.a.n0.a.v2.q;
import c.a.n0.n.f.h;
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
public class f extends g.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.n0.n.h.e f4226h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.n0.n.f.d f4227i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.n0.a.n2.g.b f4228j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4229e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4229e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4229e.j();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1205599295, "Lc/a/n0/a/a1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1205599295, "Lc/a/n0/a/a1/f;");
                return;
            }
        }
        k = k.f6803a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.n0.n.h.e eVar, c.a.n0.n.f.d dVar) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4226h = eVar;
        this.f4227i = dVar;
    }

    @Override // c.a.n0.a.a1.g.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e();
            if (b().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = b().getString("result_output_dir");
                c.a.n0.a.e0.d.h("SwanExtractor", "#onInstallFaild del: " + string);
                c.a.n0.t.d.L(string);
            }
        }
    }

    @Override // c.a.n0.a.a1.g.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        c.a.n0.a.f1.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (k) {
                aVar = c.a.n0.a.f1.g.a.d(string);
                b.C0178b e2 = aVar.e();
                e2.b("SwanExtractor");
                e2.d(1);
            } else {
                aVar = null;
            }
            boolean k2 = k(Channels.newInputStream(sourceChannel), string);
            if (aVar != null && k) {
                aVar.g("SwanExtractor", "done: " + k2);
            }
            return k2;
        }
        return invokeLL.booleanValue;
    }

    public final void j() {
        c.a.n0.n.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (eVar = this.f4226h) == null || eVar.f11612h != 0 || e.w()) {
            return;
        }
        e.e(this.f4226h.f11611g + File.separator + this.f4226h.f11613i);
    }

    public final boolean k(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            c.a.n0.a.q2.a q = q(new BufferedInputStream(inputStream), str);
            if (q == null) {
                return true;
            }
            c.a.n0.a.e0.d.h("SwanExtractor", "#extract error=" + q);
            if (k) {
                c.a.n0.a.f1.g.a d2 = c.a.n0.a.f1.g.a.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || c.a.n0.a.n2.g.a.c() <= 0) {
            return;
        }
        boolean z = k;
        if (this.f4228j == null) {
            c.a.n0.a.n2.g.b bVar = new c.a.n0.a.n2.g.b(str);
            this.f4228j = bVar;
            bVar.startWatching();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || c.a.n0.a.n2.g.a.c() <= 0) {
            return;
        }
        boolean z = k;
        c.a.n0.a.n2.g.b bVar = this.f4228j;
        if (bVar == null) {
            return;
        }
        bVar.stopWatching();
        this.f4228j = null;
    }

    public final void p(String str, String str2) {
        c.a.n0.n.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (dVar = this.f4227i) == null) {
            return;
        }
        dVar.n(str, str2);
    }

    public final c.a.n0.a.q2.a q(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i2;
        a.C0105a c0105a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            c.a.n0.a.f1.g.a d2 = c.a.n0.a.f1.g.a.d(str);
            c.a.n0.n.h.e eVar = this.f4226h;
            if (eVar == null) {
                c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                aVar.j(11L);
                aVar.h(2320L);
                aVar.e("pkg info is empty");
                c.a.n0.a.q2.e.a().f(aVar);
                return aVar;
            }
            int i3 = eVar.f11612h;
            boolean z = true;
            if (i3 == 1) {
                c.a.n0.a.p.b.a.e g2 = c.a.n0.a.c1.b.g();
                c.a.n0.n.h.e eVar2 = this.f4226h;
                i2 = g2.a(eVar2.f11611g, String.valueOf(eVar2.f11613i));
            } else if (i3 == 0) {
                i2 = e.C0104e.i(eVar.f11611g, String.valueOf(eVar.f11613i));
            } else {
                c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(2320L);
                aVar2.e("pkh category illegal");
                c.a.n0.a.q2.e.a().f(aVar2);
                return aVar2;
            }
            if (i2 == null) {
                c.a.n0.a.q2.a aVar3 = new c.a.n0.a.q2.a();
                aVar3.j(11L);
                aVar3.h(2320L);
                aVar3.e("获取解压目录失败");
                c.a.n0.a.q2.e.a().f(aVar3);
                return aVar3;
            } else if (i2.isFile() && !i2.delete()) {
                if (k) {
                    d2.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                c.a.n0.a.q2.a aVar4 = new c.a.n0.a.q2.a();
                aVar4.j(11L);
                aVar4.h(2320L);
                aVar4.e("解压失败：解压目录被文件占用，且无法删除");
                c.a.n0.a.q2.e.a().f(aVar4);
                return aVar4;
            } else {
                if (!i2.exists()) {
                    b().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i2.mkdirs()) {
                        if (k) {
                            d2.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        q.j(new a(this), "doFallbackIfNeeded");
                        c.a.n0.a.q2.a aVar5 = new c.a.n0.a.q2.a();
                        aVar5.j(11L);
                        aVar5.h(2320L);
                        aVar5.e("解压失败：解压文件夹创建失败");
                        c.a.n0.a.q2.e.a().f(aVar5);
                        return aVar5;
                    }
                }
                n(i2.getPath());
                if (k) {
                    d2.g("SwanExtractor", "开始执行解压操作, folder:" + i2.getPath());
                }
                b().putString("result_output_dir", i2.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    a.b h2 = c.a.n0.a.a1.h.a.h(bufferedInputStream);
                    int i4 = h2 == null ? -1 : h2.f4249b;
                    boolean z2 = i4 != -1;
                    m(z2);
                    if (z2) {
                        c0105a = c.a.n0.a.a1.h.a.c(bufferedInputStream, i2, i4);
                        if (c0105a == null || !c0105a.f4246a) {
                            z = false;
                        }
                    } else {
                        z = c.a.n0.t.g.d(bufferedInputStream, i2.getPath());
                        c0105a = null;
                        i4 = 0;
                    }
                    l(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (k) {
                        c.a.n0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.f4227i != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        h.a(this.f4227i, bundle, "event_download_package_type");
                    }
                    o();
                    if (z) {
                        return null;
                    }
                    c.a.n0.a.q2.a aVar6 = new c.a.n0.a.q2.a();
                    aVar6.j(11L);
                    if (z2) {
                        aVar6.h(2330L);
                        aVar6.e("decrypt failed:" + c0105a.f4247b);
                    } else {
                        aVar6.h(2320L);
                        aVar6.e("unzip failed");
                    }
                    c.a.n0.a.q2.e.a().f(aVar6);
                    return aVar6;
                } catch (IOException e2) {
                    if (k) {
                        d2.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e2.toString());
                        e2.printStackTrace();
                    }
                    c.a.n0.a.q2.a aVar7 = new c.a.n0.a.q2.a();
                    aVar7.j(11L);
                    aVar7.h(2320L);
                    aVar7.e("obtainEncryptedBundle Exception: " + e2.toString());
                    c.a.n0.a.q2.e.a().f(aVar7);
                    return aVar7;
                }
            }
        }
        return (c.a.n0.a.q2.a) invokeLL.objValue;
    }
}
