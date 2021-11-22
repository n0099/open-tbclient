package b.a.v0.a.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.v0.a.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f29979a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class b extends b.a.v0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f29980e;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29980e = context;
        }

        @Override // b.a.v0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.k(this.f29980e);
                if (b.a.v0.a.c.h().i() != null && !b.a.v0.a.c.h().i().equals("")) {
                    b.a.v0.a.f.i.a("BaiDuAB sdk  init success");
                } else {
                    String h2 = g.h(b.a.v0.a.c.h().getContext());
                    if (h2 == null || h2.equals("")) {
                        b.a.v0.a.f.i.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                        return;
                    }
                }
                g.d();
                g.c();
                b.a.v0.a.f.b.b(new k(), f.e(), f.c());
                b.a.v0.a.f.j.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends b.a.v0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f29983e;

        /* loaded from: classes6.dex */
        public class a implements b.a<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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
                    }
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // b.a.v0.a.d.b.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                b.a.v0.a.f.d.a("status_updated");
            }

            @Override // b.a.v0.a.d.b.a
            public final void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }
        }

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29983e = str;
        }

        @Override // b.a.v0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.a.v0.a.f.d.b("status_updated")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exids", this.f29983e);
            b.a.v0.a.d.b.c(b.a.v0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new a(this));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(974435738, "Lb/a/v0/a/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(974435738, "Lb/a/v0/a/e/g;");
        }
    }

    public static /* synthetic */ void a(String str) {
        b.a.v0.a.f.b.a(new e(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(b.a.v0.a.b bVar) {
        byte b2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            int g2 = bVar.g();
            if (g2 < 1000) {
                String e2 = i.e(bVar.a());
                int length = e2.length();
                int i3 = length << 1;
                byte[] bArr = new byte[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = e2.charAt(i5);
                    int i6 = i4 + 1;
                    bArr[i4] = (byte) (charAt & 255);
                    i4 = i6 + 1;
                    bArr[i6] = (byte) (charAt >> '\b');
                }
                int i7 = (-1756908916) ^ i3;
                int i8 = i3 / 4;
                for (int i9 = 0; i9 < i8; i9++) {
                    int i10 = i9 * 4;
                    int i11 = ((bArr[i10 + 0] & 255) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 2] & 255) << 16) + ((bArr[i10 + 3] & 255) << 24)) * 1540483477;
                    i7 = (i7 * 1540483477) ^ (((i11 >>> 24) ^ i11) * 1540483477);
                }
                int i12 = i3 % 4;
                if (i12 == 3) {
                    int i13 = i3 & (-4);
                    i7 = (i7 ^ ((bArr[i13 + 2] & 255) << 16)) ^ ((bArr[i13 + 1] & 255) << 8);
                    b2 = bArr[i13];
                } else if (i12 == 2) {
                    int i14 = i3 & (-4);
                    i7 ^= (bArr[i14 + 1] & 255) << 8;
                    b2 = bArr[i14];
                } else {
                    if (i12 == 1) {
                        b2 = bArr[i3 & (-4)];
                    }
                    i2 = (i7 ^ (i7 >>> 13)) * 1540483477;
                    if (Math.abs((i2 ^ (i2 >>> 15)) % 1000) >= g2) {
                        b.a.v0.a.a.f(false);
                        return;
                    }
                }
                i7 = (i7 ^ (b2 & 255)) * 1540483477;
                i2 = (i7 ^ (i7 >>> 13)) * 1540483477;
                if (Math.abs((i2 ^ (i2 >>> 15)) % 1000) >= g2) {
                }
            }
            b.a.v0.a.c.h().a(bVar.a());
            b.a.v0.a.a.f(true);
            b.a.v0.a.f.i.g(bVar.b());
            b.a.v0.a.f.a.b(com.baidu.ubs.analytics.d.a.c() + "-进行一次 初始化   " + new Date().toLocaleString() + GlideException.IndentedAppendable.INDENT + j(bVar.a()));
            f.b(bVar.c());
            f.f(bVar.d());
            f.g(bVar.f());
            f.h(bVar.e());
            b.a.v0.a.e.b.a(bVar.a());
            b.a.v0.a.f.b.a(new b(bVar.a()));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (TextUtils.isEmpty(b.a.v0.a.c.h().j())) {
                d();
            }
            if (TextUtils.isEmpty(b.a.v0.a.c.h().j())) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("package", b.a.v0.a.c.h().getContext().getPackageName());
            hashMap.put("cuid", b.a.v0.a.c.h().j());
            b.a.v0.a.d.b.c(b.a.v0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new a());
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            String e2 = b.a.v0.a.f.d.e("cuid", "");
            if (!TextUtils.isEmpty(e2)) {
                b.a.v0.a.f.a.b("本地 取得  cuid~~");
                b.a.v0.a.c.h().e(e2);
                return;
            }
            b.a.v0.a.f.a.b("网络请求  cuid~~");
            HashMap hashMap = new HashMap();
            hashMap.put("imei", i.g(b.a.v0.a.c.h().getContext()));
            hashMap.put("mac", i.h(b.a.v0.a.c.h().getContext()));
            b.a.v0.a.d.b.c(b.a.v0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new d());
        }
    }

    public static /* synthetic */ int f() {
        int i2 = f29979a;
        f29979a = i2 + 1;
        return i2;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String i2 = i(context);
            HashMap hashMap = new HashMap();
            hashMap.put("key", i2);
            hashMap.put("package", context.getPackageName());
            b.a.v0.a.d.b.c(b.a.v0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new c(currentTimeMillis, context));
            return b.a.v0.a.c.h().i();
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BAIDUAB_APPKEY");
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager.getRunningAppProcesses() == null) {
                return "unknow";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "unknow";
        }
        return (String) invokeL.objValue;
    }

    public static /* synthetic */ String k(Context context) {
        String e2 = b.a.v0.a.f.d.e("lastkey", "");
        long c2 = b.a.v0.a.f.d.c("token_update_time");
        if (e2.equals(i(context)) && c2 + 86400000 >= System.currentTimeMillis()) {
            String e3 = b.a.v0.a.f.d.e("token", "");
            if (!e3.equals("")) {
                b.a.v0.a.c.h().b(e3);
                return e3;
            }
        }
        return h(context);
    }

    /* loaded from: classes6.dex */
    public static class d implements b.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.v0.a.d.b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("cuid");
            if (TextUtils.isEmpty(optString)) {
                b.a.v0.a.c.h().e("");
                return;
            }
            b.a.v0.a.c.h().e(optString);
            b.a.v0.a.f.d.f("cuid", optString);
        }

        @Override // b.a.v0.a.d.b.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && str.equals("1")) {
                b.a.v0.a.c.h().e("");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements b.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f29981a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f29982b;

        public c(long j, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29981a = j;
            this.f29982b = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.v0.a.d.b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("token");
            if (optString == null || optString.isEmpty()) {
                return;
            }
            b.a.v0.a.c.h().b(optString);
            b.a.v0.a.f.d.f("token", optString);
            b.a.v0.a.f.d.g("token_update_time", this.f29981a);
            b.a.v0.a.f.d.f("lastkey", g.i(this.f29982b));
        }

        @Override // b.a.v0.a.d.b.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                b.a.v0.a.f.i.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements b.a<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.v0.a.d.b.a
        public final /* synthetic */ void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                com.baidu.ubs.analytics.a.g gVar = new com.baidu.ubs.analytics.a.g();
                gVar.setGroup(optJSONObject.optString("group"));
                gVar.setId(optJSONObject.optString("id"));
                gVar.y(optJSONObject.optString("sid"));
                if (i2 > 0) {
                    stringBuffer.append("_");
                }
                stringBuffer.append(gVar.getId());
                arrayList.add(gVar);
            }
            b.a.v0.a.c.h().c(arrayList);
            g.a(stringBuffer.toString());
        }

        @Override // b.a.v0.a.d.b.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                while (g.f29979a < 2) {
                    synchronized (this) {
                        g.f();
                    }
                    g.c();
                }
            }
        }
    }
}
