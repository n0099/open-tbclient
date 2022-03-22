package c.a.z.a.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.b;
import c.a.z.a.h.i;
import c.a.z.a.j.f;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static g f22178b;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.z.a.j.b f22179c;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    /* loaded from: classes3.dex */
    public class a extends i.c<c.a.z.a.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a a;

        public a(g gVar, b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.z.a.h.i.c
        /* renamed from: e */
        public void a(c.a.z.a.h.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, str) == null) {
                if (c.a.z.a.b.m()) {
                    g.c("loadSDK onCompleted filePath: " + str);
                }
                super.a(aVar, str);
                b.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.onResult(true, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.z.a.h.i.c
        /* renamed from: f */
        public void b(c.a.z.a.h.a aVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, exc) == null) {
                if (c.a.z.a.b.m()) {
                    g.c("loadSDK onFailed failed: " + exc);
                }
                super.b(aVar, exc);
                b.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.onResult(false, exc == null ? "unkown" : exc.getMessage());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.z.a.h.i.c
        /* renamed from: g */
        public void c(c.a.z.a.h.a aVar, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{aVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(aVar, j, j2, i);
                b.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.onProgress((int) j2, i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22180b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f22181c;

        public b(g gVar, b.a aVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f22180b = str;
            this.f22181c = file;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
            if (r1 == false) goto L22;
         */
        @Override // c.a.z.a.j.f.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i, c.a.z.a.j.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, fVar) == null) {
                boolean z = false;
                boolean z2 = i == 2;
                if (c.a.z.a.b.m()) {
                    g.c("onLoadAssets " + z2 + ", state " + i);
                }
                if (this.a != null) {
                    String str = z2 ? null : this.f22180b;
                    if (this.f22181c != null) {
                        c.a.z.a.b.s(new c.a.z.a.c(this.f22181c.getAbsolutePath()));
                    }
                    if (z2) {
                        boolean k0 = c.a.z.a.a.k0();
                        if (c.a.z.a.b.m()) {
                            g.c("loadAssets ARControllerProxy.loadSoFile " + k0);
                        }
                    }
                    z = z2;
                    this.a.onResult(z, str);
                }
            }
        }
    }

    public g() {
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

    public static synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (g.class) {
                if (f22178b == null) {
                    f22178b = new g();
                }
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            Log.e("DuAr_SDKLoader", "ar->" + str);
        }
    }

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f22178b == null) {
                b();
            }
            return f22178b;
        }
        return (g) invokeV.objValue;
    }

    public final c.a.z.a.j.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f22179c == null) {
                c.a.z.a.j.b k = c.a.z.a.j.b.k();
                c.a.z.a.b.g();
                k.m(c.a.z.a.b.getContext(), "arsource", new File(c.a.z.a.c.a()));
                f22179c = k;
            }
            return f22179c;
        }
        return (c.a.z.a.j.b) invokeV.objValue;
    }

    public File f() {
        InterceptResult invokeV;
        File l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = c.a.z.a.b.o() && g();
            if (z) {
                l = d.d().h();
            } else {
                l = c.a.z.a.h.a.j(c.a.z.a.b.e()).l();
            }
            if (c.a.z.a.b.m()) {
                c("sdkPath useLocal " + z + ", SDKPath " + l);
            }
            return l;
        }
        return (File) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == null) {
                this.a = Boolean.FALSE;
                try {
                    String[] list = c.a.z.a.b.getContext().getAssets().list("arsource");
                    this.a = Boolean.valueOf(list != null && list.length > 0);
                    if (c.a.z.a.b.m()) {
                        if (list == null) {
                            str = StringUtil.NULL_STRING;
                        } else {
                            str = "" + list.length;
                        }
                        c("hasAssetsResource: " + str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = c.a.z.a.b.o() && g();
            if (z) {
                q = d().o();
            } else {
                q = c.a.z.a.h.a.j("live").q();
            }
            if (c.a.z.a.b.m()) {
                c("isLocal " + z + ", isSDKLoaded " + q);
            }
            return q;
        }
        return invokeV.booleanValue;
    }

    public void i(Context context, String str, File file, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, file, aVar) == null) {
            String str2 = "loadAssets context=" + context + ", assetPath=" + str + ", SDcardFile=" + file;
            if (c.a.z.a.b.m()) {
                c(str2);
            }
            if ((context == null || TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(file.getAbsolutePath())) && aVar != null) {
                aVar.onResult(false, str2);
            }
            d().r(context, str, file, new b(this, aVar, str2, file));
        }
    }

    public void j(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (c.a.z.a.b.m()) {
                c("loadAssets hasAssetsResource=" + g());
            }
            if (c.a.z.a.b.g() == null) {
                c("DuArResConfig null when loadAssets");
            } else if (TextUtils.isEmpty(c.a.z.a.c.a())) {
                c("DuArResConfig data empty when loadAssets");
            } else {
                i(c.a.z.a.b.getContext(), "arsource", new File(c.a.z.a.c.a()), aVar);
            }
        }
    }

    public void k(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (c.a.z.a.b.o() && g()) {
                j(aVar);
            } else if (c.a.z.a.b.c() == null) {
                c("loadSDK with Downlader==null");
            } else {
                c.a.z.a.h.a.j(c.a.z.a.b.e()).u(c.a.z.a.b.getContext(), new a(this, aVar));
            }
        }
    }
}
