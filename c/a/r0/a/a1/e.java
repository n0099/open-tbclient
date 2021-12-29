package c.a.r0.a.a1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.a1.f;
import c.a.r0.a.a1.g.a;
import c.a.r0.a.f1.g.b;
import c.a.r0.a.k;
import c.a.r0.a.z2.q;
import c.a.r0.q.f.j;
import c.a.r0.w.g;
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
public class e extends f.AbstractC0252f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f5252k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.q.i.f f5253h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.r0.q.f.f f5254i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.a.r2.f.b f5255j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5256e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5256e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5256e.j();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(419545244, "Lc/a/r0/a/a1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(419545244, "Lc/a/r0/a/a1/e;");
                return;
            }
        }
        f5252k = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.r0.q.i.f fVar, c.a.r0.q.f.f fVar2) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, fVar2};
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
        this.f5253h = fVar;
        this.f5254i = fVar2;
    }

    @Override // c.a.r0.a.a1.f.AbstractC0252f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e();
            if (b().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = b().getString("result_output_dir");
                c.a.r0.a.e0.d.k("SwanExtractor", "#onInstallFaild del: " + string);
                c.a.r0.w.d.M(string);
            }
        }
    }

    @Override // c.a.r0.a.a1.f.AbstractC0252f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        c.a.r0.a.f1.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (f5252k) {
                aVar = c.a.r0.a.f1.g.a.d(string);
                b.C0311b e2 = aVar.e();
                e2.b("SwanExtractor");
                e2.d(1);
            } else {
                aVar = null;
            }
            boolean k2 = k(Channels.newInputStream(sourceChannel), string);
            if (aVar != null && f5252k) {
                aVar.g("SwanExtractor", "done: " + k2);
            }
            return k2;
        }
        return invokeLL.booleanValue;
    }

    public final void j() {
        c.a.r0.q.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fVar = this.f5253h) == null || fVar.f11762h != 0 || d.w()) {
            return;
        }
        d.e(this.f5253h.f11761g + File.separator + this.f5253h.f11763i);
    }

    public final boolean k(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            c.a.r0.a.u2.a q = q(new BufferedInputStream(inputStream), str);
            if (q == null) {
                return true;
            }
            c.a.r0.a.e0.d.k("SwanExtractor", "#extract error=" + q);
            if (f5252k) {
                c.a.r0.a.f1.g.a d2 = c.a.r0.a.f1.g.a.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || c.a.r0.a.r2.f.a.c() <= 0) {
            return;
        }
        boolean z = f5252k;
        if (this.f5255j == null) {
            c.a.r0.a.r2.f.b bVar = new c.a.r0.a.r2.f.b(str);
            this.f5255j = bVar;
            bVar.startWatching();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || c.a.r0.a.r2.f.a.c() <= 0) {
            return;
        }
        boolean z = f5252k;
        c.a.r0.a.r2.f.b bVar = this.f5255j;
        if (bVar == null) {
            return;
        }
        bVar.stopWatching();
        this.f5255j = null;
    }

    public final void p(String str, String str2) {
        c.a.r0.q.f.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (fVar = this.f5254i) == null) {
            return;
        }
        fVar.n(str, str2);
    }

    public final c.a.r0.a.u2.a q(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i2;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            c.a.r0.a.f1.g.a d2 = c.a.r0.a.f1.g.a.d(str);
            c.a.r0.q.i.f fVar = this.f5253h;
            if (fVar == null) {
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(11L);
                aVar.i(2320L);
                aVar.f("pkg info is empty");
                c.a.r0.a.u2.e.a().f(aVar);
                return aVar;
            }
            int i3 = fVar.f11762h;
            boolean z = true;
            if (i3 == 1) {
                c.a.r0.a.p.b.a.e g2 = c.a.r0.a.c1.b.g();
                c.a.r0.q.i.f fVar2 = this.f5253h;
                i2 = g2.a(fVar2.f11761g, String.valueOf(fVar2.f11763i));
            } else if (i3 == 0) {
                i2 = d.e.i(fVar.f11761g, String.valueOf(fVar.f11763i));
            } else {
                c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                aVar2.k(11L);
                aVar2.i(2320L);
                aVar2.f("pkh category illegal");
                c.a.r0.a.u2.e.a().f(aVar2);
                return aVar2;
            }
            if (i2 == null) {
                c.a.r0.a.u2.a aVar3 = new c.a.r0.a.u2.a();
                aVar3.k(11L);
                aVar3.i(2320L);
                aVar3.f("获取解压目录失败");
                c.a.r0.a.u2.e.a().f(aVar3);
                return aVar3;
            } else if (i2.isFile() && !i2.delete()) {
                if (f5252k) {
                    d2.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                c.a.r0.a.u2.a aVar4 = new c.a.r0.a.u2.a();
                aVar4.k(11L);
                aVar4.i(2320L);
                aVar4.f("解压失败：解压目录被文件占用，且无法删除");
                c.a.r0.a.u2.e.a().f(aVar4);
                return aVar4;
            } else {
                if (!i2.exists()) {
                    b().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i2.mkdirs()) {
                        if (f5252k) {
                            d2.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        q.k(new a(this), "doFallbackIfNeeded");
                        c.a.r0.a.u2.a aVar5 = new c.a.r0.a.u2.a();
                        aVar5.k(11L);
                        aVar5.i(2320L);
                        aVar5.f("解压失败：解压文件夹创建失败");
                        c.a.r0.a.u2.e.a().f(aVar5);
                        return aVar5;
                    }
                }
                n(i2.getPath());
                if (f5252k) {
                    d2.g("SwanExtractor", "开始执行解压操作, folder:" + i2.getPath());
                }
                b().putString("result_output_dir", i2.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    a.c i4 = c.a.r0.a.a1.g.a.i(bufferedInputStream);
                    int i5 = i4 == null ? -1 : i4.f5278b;
                    boolean z2 = i5 != -1;
                    m(z2);
                    if (z2) {
                        bVar = c.a.r0.a.a1.g.a.d(bufferedInputStream, i2, i5);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = g.d(bufferedInputStream, i2.getPath());
                        bVar = null;
                        i5 = 0;
                    }
                    l(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (f5252k) {
                        c.a.r0.a.a1.g.a.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.f5254i != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i5);
                        j.a(this.f5254i, bundle, "event_download_package_type");
                    }
                    o();
                    if (z) {
                        return null;
                    }
                    c.a.r0.a.u2.a aVar6 = new c.a.r0.a.u2.a();
                    aVar6.k(11L);
                    if (z2) {
                        aVar6.i(2330L);
                        aVar6.f("decrypt failed:" + bVar.f5277b);
                    } else {
                        aVar6.i(2320L);
                        aVar6.f("unzip failed");
                    }
                    c.a.r0.a.u2.e.a().f(aVar6);
                    return aVar6;
                } catch (IOException e2) {
                    if (f5252k) {
                        d2.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e2.toString());
                        e2.printStackTrace();
                    }
                    c.a.r0.a.u2.a aVar7 = new c.a.r0.a.u2.a();
                    aVar7.k(11L);
                    aVar7.i(2320L);
                    aVar7.f("obtainEncryptedBundle Exception: " + e2.toString());
                    c.a.r0.a.u2.e.a().f(aVar7);
                    return aVar7;
                }
            }
        }
        return (c.a.r0.a.u2.a) invokeLL.objValue;
    }
}
