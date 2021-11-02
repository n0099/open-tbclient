package b.a.a0.a.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.a0.a.b;
import b.a.a0.a.h.i;
import b.a.a0.a.j.f;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static g f1188b;

    /* renamed from: c  reason: collision with root package name */
    public static b.a.a0.a.j.b f1189c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f1190a;

    /* loaded from: classes.dex */
    public class a extends i.c<b.a.a0.a.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a f1191a;

        public a(g gVar, b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1191a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.a0.a.h.i.c
        /* renamed from: e */
        public void a(b.a.a0.a.h.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, str) == null) {
                if (b.a.a0.a.b.m()) {
                    g.c("loadSDK onCompleted filePath: " + str);
                }
                super.a(aVar, str);
                b.a aVar2 = this.f1191a;
                if (aVar2 != null) {
                    aVar2.onResult(true, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.a0.a.h.i.c
        /* renamed from: f */
        public void b(b.a.a0.a.h.a aVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, exc) == null) {
                if (b.a.a0.a.b.m()) {
                    g.c("loadSDK onFailed failed: " + exc);
                }
                super.b(aVar, exc);
                b.a aVar2 = this.f1191a;
                if (aVar2 != null) {
                    aVar2.onResult(false, exc == null ? "unkown" : exc.getMessage());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.a0.a.h.i.c
        /* renamed from: g */
        public void c(b.a.a0.a.h.a aVar, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{aVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                super.c(aVar, j, j2, i2);
                b.a aVar2 = this.f1191a;
                if (aVar2 != null) {
                    aVar2.onProgress((int) j2, i2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a f1192a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f1194c;

        public b(g gVar, b.a aVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1192a = aVar;
            this.f1193b = str;
            this.f1194c = file;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
            if (r1 == false) goto L22;
         */
        @Override // b.a.a0.a.j.f.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i2, b.a.a0.a.j.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
                boolean z = false;
                boolean z2 = i2 == 2;
                if (b.a.a0.a.b.m()) {
                    g.c("onLoadAssets " + z2 + ", state " + i2);
                }
                if (this.f1192a != null) {
                    String str = z2 ? null : this.f1193b;
                    if (this.f1194c != null) {
                        b.a.a0.a.b.s(new b.a.a0.a.c(this.f1194c.getAbsolutePath()));
                    }
                    if (z2) {
                        boolean k0 = b.a.a0.a.a.k0();
                        if (b.a.a0.a.b.m()) {
                            g.c("loadAssets ARControllerProxy.loadSoFile " + k0);
                        }
                    }
                    z = z2;
                    this.f1192a.onResult(z, str);
                }
            }
        }
    }

    public g() {
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

    public static synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (g.class) {
                if (f1188b == null) {
                    f1188b = new g();
                }
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            String str2 = "ar->" + str;
        }
    }

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f1188b == null) {
                b();
            }
            return f1188b;
        }
        return (g) invokeV.objValue;
    }

    public final b.a.a0.a.j.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f1189c == null) {
                b.a.a0.a.j.b k = b.a.a0.a.j.b.k();
                b.a.a0.a.b.g();
                k.m(b.a.a0.a.b.getContext(), "arsource", new File(b.a.a0.a.c.a()));
                f1189c = k;
            }
            return f1189c;
        }
        return (b.a.a0.a.j.b) invokeV.objValue;
    }

    public File f() {
        InterceptResult invokeV;
        File l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = b.a.a0.a.b.o() && g();
            if (z) {
                l = d.d().h();
            } else {
                l = b.a.a0.a.h.a.j(b.a.a0.a.b.e()).l();
            }
            if (b.a.a0.a.b.m()) {
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
            if (this.f1190a == null) {
                this.f1190a = Boolean.FALSE;
                try {
                    String[] list = b.a.a0.a.b.getContext().getAssets().list("arsource");
                    this.f1190a = Boolean.valueOf(list != null && list.length > 0);
                    if (b.a.a0.a.b.m()) {
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
            return this.f1190a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = b.a.a0.a.b.o() && g();
            if (z) {
                q = d().o();
            } else {
                q = b.a.a0.a.h.a.j("live").q();
            }
            if (b.a.a0.a.b.m()) {
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
            if (b.a.a0.a.b.m()) {
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
            if (b.a.a0.a.b.m()) {
                c("loadAssets hasAssetsResource=" + g());
            }
            if (b.a.a0.a.b.g() == null) {
                c("DuArResConfig null when loadAssets");
            } else if (TextUtils.isEmpty(b.a.a0.a.c.a())) {
                c("DuArResConfig data empty when loadAssets");
            } else {
                i(b.a.a0.a.b.getContext(), "arsource", new File(b.a.a0.a.c.a()), aVar);
            }
        }
    }

    public void k(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (b.a.a0.a.b.o() && g()) {
                j(aVar);
            } else if (b.a.a0.a.b.c() == null) {
                c("loadSDK with Downlader==null");
            } else {
                b.a.a0.a.h.a.j(b.a.a0.a.b.e()).u(b.a.a0.a.b.getContext(), new a(this, aVar));
            }
        }
    }
}
