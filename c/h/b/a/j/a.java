package c.h.b.a.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static String A;
    public static int B;
    public static final SimpleDateFormat x;
    public static String y;
    public static String z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f32199a;

    /* renamed from: b  reason: collision with root package name */
    public String f32200b;

    /* renamed from: c  reason: collision with root package name */
    public String f32201c;

    /* renamed from: d  reason: collision with root package name */
    public int f32202d;

    /* renamed from: e  reason: collision with root package name */
    public String f32203e;

    /* renamed from: f  reason: collision with root package name */
    public String f32204f;

    /* renamed from: g  reason: collision with root package name */
    public String f32205g;

    /* renamed from: h  reason: collision with root package name */
    public int f32206h;

    /* renamed from: i  reason: collision with root package name */
    public String f32207i;

    /* renamed from: j  reason: collision with root package name */
    public String f32208j;
    public String k;
    public long l;
    public long m;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public String r;
    public ArrayList<String> s;
    public StringBuilder t;
    public StringBuilder u;
    public StringBuilder v;
    public StringBuilder w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1212061639, "Lc/h/b/a/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1212061639, "Lc/h/b/a/j/a;");
                return;
            }
        }
        x = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
        A = "";
        B = -1;
        B = b.b();
        z = Build.MODEL;
        A = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
        y = c.h.b.a.c.d().provideQualifier();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32201c = "";
        this.f32202d = -1;
        this.f32205g = "";
        this.r = "-1";
        this.s = new ArrayList<>();
        this.t = new StringBuilder();
        this.u = new StringBuilder();
        this.v = new StringBuilder();
        this.w = new StringBuilder();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a aVar = new a();
            Context provideContext = c.h.b.a.c.d().provideContext();
            String str = aVar.f32205g;
            if (str == null || str.length() == 0) {
                try {
                    PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                    aVar.f32206h = packageInfo.versionCode;
                    aVar.f32205g = packageInfo.versionName;
                } catch (Throwable unused) {
                }
            }
            aVar.f32202d = B;
            aVar.f32200b = z;
            aVar.f32201c = A;
            aVar.f32199a = y;
            aVar.f32203e = c.h.b.a.c.d().provideUid();
            aVar.f32204f = c.a();
            aVar.f32207i = c.h.b.a.c.d().provideNetworkType();
            aVar.f32208j = String.valueOf(b.a());
            aVar.k = String.valueOf(b.c());
            if (Build.VERSION.SDK_INT >= 24) {
                aVar.r = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = this.t;
            sb.append("qua");
            sb.append(" = ");
            sb.append(this.f32199a);
            sb.append(Part.CRLF);
            StringBuilder sb2 = this.t;
            sb2.append(PushManager.APP_VERSION_NAME);
            sb2.append(" = ");
            sb2.append(this.f32205g);
            sb2.append(Part.CRLF);
            StringBuilder sb3 = this.t;
            sb3.append(PushManager.APP_VERSION_CODE);
            sb3.append(" = ");
            sb3.append(this.f32206h);
            sb3.append(Part.CRLF);
            StringBuilder sb4 = this.t;
            sb4.append("uid");
            sb4.append(" = ");
            sb4.append(this.f32203e);
            sb4.append(Part.CRLF);
            StringBuilder sb5 = this.t;
            sb5.append("network");
            sb5.append(" = ");
            sb5.append(this.f32207i);
            sb5.append(Part.CRLF);
            StringBuilder sb6 = this.t;
            sb6.append("model");
            sb6.append(" = ");
            sb6.append(this.f32200b);
            sb6.append(Part.CRLF);
            StringBuilder sb7 = this.t;
            sb7.append("api-level");
            sb7.append(" = ");
            sb7.append(this.f32201c);
            sb7.append(Part.CRLF);
            StringBuilder sb8 = this.t;
            sb8.append("cpu-core");
            sb8.append(" = ");
            sb8.append(this.f32202d);
            sb8.append(Part.CRLF);
            StringBuilder sb9 = this.t;
            sb9.append("process");
            sb9.append(" = ");
            sb9.append(this.f32204f);
            sb9.append(Part.CRLF);
            StringBuilder sb10 = this.t;
            sb10.append("freeMemory");
            sb10.append(" = ");
            sb10.append(this.f32208j);
            sb10.append(Part.CRLF);
            StringBuilder sb11 = this.t;
            sb11.append("totalMemory");
            sb11.append(" = ");
            sb11.append(this.k);
            sb11.append(Part.CRLF);
            StringBuilder sb12 = this.v;
            sb12.append("time");
            sb12.append(" = ");
            sb12.append(this.l);
            sb12.append(Part.CRLF);
            StringBuilder sb13 = this.v;
            sb13.append("thread-time");
            sb13.append(" = ");
            sb13.append(this.m);
            sb13.append(Part.CRLF);
            StringBuilder sb14 = this.v;
            sb14.append("time-start");
            sb14.append(" = ");
            sb14.append(this.n);
            sb14.append(Part.CRLF);
            StringBuilder sb15 = this.v;
            sb15.append("time-end");
            sb15.append(" = ");
            sb15.append(this.o);
            sb15.append(Part.CRLF);
            StringBuilder sb16 = this.u;
            sb16.append("cpu-busy");
            sb16.append(" = ");
            sb16.append(this.p);
            sb16.append(Part.CRLF);
            StringBuilder sb17 = this.u;
            sb17.append("cpu-rate");
            sb17.append(" = ");
            sb17.append(this.q);
            sb17.append(Part.CRLF);
            ArrayList<String> arrayList = this.s;
            if (arrayList != null && !arrayList.isEmpty()) {
                StringBuilder sb18 = new StringBuilder();
                Iterator<String> it = this.s.iterator();
                while (it.hasNext()) {
                    sb18.append(it.next());
                    sb18.append(Part.CRLF);
                }
                StringBuilder sb19 = this.w;
                sb19.append("stack");
                sb19.append(" = ");
                sb19.append(sb18.toString());
                sb19.append(Part.CRLF);
            }
            return this;
        }
        return (a) invokeV.objValue;
    }

    public a c(long j2, long j3, long j4, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)})) == null) {
            this.l = j3 - j2;
            this.m = j5 - j4;
            this.n = Long.toString(j2);
            this.o = Long.toString(j3);
            return this;
        }
        return (a) invokeCommon.objValue;
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a e(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            this.s = arrayList;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return String.valueOf(this.t) + ((Object) this.v) + ((Object) this.u) + ((Object) this.w);
        }
        return (String) invokeV.objValue;
    }
}
