package c.a.d0.d.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.l.h;
import c.a.d0.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.CallActionLoadingDialog;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
@Service
/* loaded from: classes.dex */
public class a extends c.a.d0.f.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f2580b;

    /* renamed from: c  reason: collision with root package name */
    public long f2581c;

    /* renamed from: d  reason: collision with root package name */
    public long f2582d;

    /* renamed from: e  reason: collision with root package name */
    public long f2583e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f2584f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f2585g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f2586h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2587i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2588j;
    public boolean k;
    public PhoneStateListener l;

    /* renamed from: c.a.d0.d.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0067a extends c.a.d0.u.p.c<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallActionLoadingDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f2590c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2591d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.f.h.d f2592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.f.g.a f2593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HashMap f2594g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f2595h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f2596i;

        public C0067a(a aVar, CallActionLoadingDialog callActionLoadingDialog, String str, Context context, String str2, c.a.d0.f.h.d dVar, c.a.d0.f.g.a aVar2, HashMap hashMap, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callActionLoadingDialog, str, context, str2, dVar, aVar2, hashMap, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2596i = aVar;
            this.a = callActionLoadingDialog;
            this.f2589b = str;
            this.f2590c = context;
            this.f2591d = str2;
            this.f2592e = dVar;
            this.f2593f = aVar2;
            this.f2594g = hashMap;
            this.f2595h = str3;
        }

        @Override // c.a.d0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                this.a.dismiss();
                this.f2596i.x("4", this.f2589b);
                boolean v = this.f2596i.v(this.f2590c, this.f2591d, this.f2589b);
                this.f2596i.c(this.f2592e, this.f2593f, v ? 0 : 1001, v);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, @Nullable Map<String, String> map, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, map, i2) == null) {
                this.a.dismiss();
                if (map == null) {
                    this.f2596i.x("8", this.f2589b);
                    boolean v = this.f2596i.v(this.f2590c, this.f2591d, this.f2589b);
                    this.f2596i.c(this.f2592e, this.f2593f, v ? 0 : 1001, v);
                    return;
                }
                String str = (String) c.a.d0.x.c.b(map, "virtualPhone");
                if (TextUtils.isEmpty(str)) {
                    this.f2596i.x("5", this.f2589b);
                    boolean v2 = this.f2596i.v(this.f2590c, this.f2591d, this.f2589b);
                    this.f2596i.c(this.f2592e, this.f2593f, v2 ? 0 : 1001, v2);
                    return;
                }
                String str2 = (String) c.a.d0.x.c.b(map, "solutionId");
                if (TextUtils.isEmpty(str2)) {
                    this.f2596i.x("6", this.f2589b);
                    boolean v3 = this.f2596i.v(this.f2590c, this.f2591d, this.f2589b);
                    this.f2596i.c(this.f2592e, this.f2593f, v3 ? 0 : 1001, v3);
                    return;
                }
                String str3 = (String) c.a.d0.x.c.b(this.f2594g, "log_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    this.f2596i.x("3", this.f2589b);
                } else {
                    this.f2596i.x("7", this.f2589b);
                    String replaceAll = str3.replaceAll("\\__TIMESTAMP__", this.f2595h).replaceAll("\\__VIRTUALPHONE__", str).replaceAll("\\__SOLUTIONID__", str2);
                    c.a.d0.u.s.d dVar = new c.a.d0.u.s.d();
                    dVar.k(replaceAll);
                    dVar.g(3000);
                    dVar.c();
                    g.b().a().a(dVar, null);
                }
                boolean v4 = this.f2596i.v(this.f2590c, str, this.f2589b);
                this.f2596i.c(this.f2592e, this.f2593f, v4 ? 0 : 1001, v4);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d0.u.p.b
        @Nullable
        /* renamed from: f */
        public Map<String, String> d(Headers headers, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? a.w(str) : (Map) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f2597b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TelephonyManager f2598c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2599d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2600e;

        public b(a aVar, TelephonyManager telephonyManager, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, telephonyManager, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2600e = aVar;
            this.f2598c = telephonyManager;
            this.f2599d = str;
            this.a = 0;
            this.f2597b = 0;
        }

        public final void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a = this.f2597b;
                this.f2597b = i2;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 == 0) {
                    a(i2);
                    if (this.a == 2) {
                        this.f2600e.f2581c = System.currentTimeMillis();
                        this.f2600e.r(this.f2598c, this, this.f2599d);
                    }
                } else if (i2 == 1) {
                    a(i2);
                    this.f2600e.k = true;
                } else if (i2 != 2) {
                } else {
                    a(i2);
                    if (this.a == 0) {
                        this.f2600e.f2580b = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TelephonyManager f2601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PhoneStateListener f2602f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f2603g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f2604h;

        public c(a aVar, TelephonyManager telephonyManager, PhoneStateListener phoneStateListener, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, telephonyManager, phoneStateListener, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2604h = aVar;
            this.f2601e = telephonyManager;
            this.f2602f = phoneStateListener;
            this.f2603g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f2601e.getCallState() != 0) {
                    this.f2604h.s(this.f2601e, this.f2602f, this.f2603g);
                    return;
                }
                this.f2601e.listen(this.f2602f, 0);
                this.f2604h.f2583e = System.currentTimeMillis();
                this.f2604h.y(this.f2603g);
            }
        }
    }

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
                return;
            }
        }
        this.a = 0L;
        this.f2580b = 0L;
        this.f2581c = 0L;
        this.f2582d = 0L;
        this.f2583e = 0L;
        this.f2585g = new Handler(Looper.getMainLooper());
        this.f2586h = h.b().info().a("psl_switch", 1) == 1;
        this.f2587i = h.b().info().a("psl_time", 20);
        this.f2588j = false;
        this.k = false;
    }

    @Nullable
    public static Map<String, String> w(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONArray optJSONArray = c.a.d0.x.b.b(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            hashMap.put("virtualPhone", optJSONObject.optString("virtualPhone"));
            hashMap.put("solutionId", optJSONObject.optString("solutionId"));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.d0.f.e.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NotificationCompat.CATEGORY_CALL : (String) invokeV.objValue;
    }

    @Override // c.a.d0.f.e.a
    public boolean b(@NonNull Context context, @NonNull c.a.d0.f.g.a aVar, @Nullable Map<String, Object> map, @Nullable c.a.d0.f.h.d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = (String) c.a.d0.x.c.b(d2, "ext_info");
            String str2 = (String) c.a.d0.x.c.b(d2, "phone");
            if (TextUtils.isEmpty(str2)) {
                x("1", str);
                c(dVar, aVar, 202, false);
                return true;
            }
            if (TextUtils.equals(d2.containsKey("type") ? (String) c.a.d0.x.c.b(d2, "type") : "0", "1")) {
                String str3 = (String) c.a.d0.x.c.b(d2, "number_url");
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str3;
                if (TextUtils.isEmpty(str4)) {
                    x("2", str);
                    boolean v = v(context, str2, str);
                    c(dVar, aVar, v ? 0 : 1001, v);
                    return true;
                }
                CallActionLoadingDialog cancelWhenTouchOutside = new CallActionLoadingDialog(context).setMessage(context.getString(c.a.d0.d.h.nad_ocpc_phone_call_toast_text)).setCancelWhenBackKey(false).setCancelWhenTouchOutside(false);
                c.a.d0.h0.a.b(cancelWhenTouchOutside);
                C0067a c0067a = new C0067a(this, cancelWhenTouchOutside, str, context, str2, dVar, aVar, d2, valueOf);
                String replaceAll = str4.replaceAll("\\__TIMESTAMP__", valueOf);
                c.a.d0.u.s.d dVar2 = new c.a.d0.u.s.d();
                dVar2.k(replaceAll);
                dVar2.g(3000);
                dVar2.c();
                g.b().a().a(dVar2, c0067a);
            } else {
                boolean v2 = v(context, str2, str);
                c(dVar, aVar, v2 ? 0 : 1001, v2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, telephonyManager, phoneStateListener, str) == null) {
            long j2 = this.f2580b;
            if (j2 != 0) {
                long j3 = this.f2581c;
                if (j3 != 0 && j3 > j2) {
                    this.f2585g.removeCallbacks(this.f2584f);
                    telephonyManager.listen(phoneStateListener, 0);
                    this.f2583e = System.currentTimeMillis();
                    y(str);
                    return;
                }
            }
            s(telephonyManager, phoneStateListener, str);
        }
    }

    public final void s(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, telephonyManager, phoneStateListener, str) == null) {
            Runnable runnable = this.f2584f;
            if (runnable != null) {
                this.f2585g.removeCallbacks(runnable);
            } else {
                this.f2584f = new c(this, telephonyManager, phoneStateListener, str);
            }
            telephonyManager.listen(phoneStateListener, 32);
            this.f2585g.postDelayed(this.f2584f, TimeUnit.SECONDS.toMillis(this.f2587i));
        }
    }

    public final int t(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            if (j2 <= 0) {
                return 0;
            }
            return (int) TimeUnit.MILLISECONDS.toSeconds(j2);
        }
        return invokeJ.intValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j2 = this.f2581c;
            if (j2 != 0) {
                long j3 = this.f2580b;
                if (j3 != 0 && j2 > j3) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean v(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.a.d0.h0.a.c(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)))) {
                x("11", str2);
                if (this.f2586h) {
                    z(context, str2);
                    return true;
                }
                return true;
            }
            x("9", str2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void x(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        c.a.d0.a0.a.b(new ClogBuilder().q(ClogBuilder.Page.AD_CALL).g(ClogBuilder.Area.AD_CALL).s(ClogBuilder.LogType.AD_CALL).i(str).n(str2));
    }

    public final void y(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f2588j) {
            return;
        }
        this.f2588j = true;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = u() ? "1" : "0";
        String str4 = "-1";
        if (u()) {
            str2 = "" + t(this.f2581c - this.f2580b);
        } else {
            str2 = "-1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(this.f2587i);
        sb.append(",");
        sb.append(t(this.f2583e - this.f2582d));
        sb.append(",");
        if (u()) {
            str4 = "" + t(this.f2580b - this.a);
        }
        sb.append(str4);
        sb.append(",");
        sb.append(this.k ? "1" : "0");
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.PHONE_STATE_LISTEN).n(str).i(str3).j(str2).k(sb.toString()));
    }

    public final void z(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) {
            this.f2580b = 0L;
            this.f2581c = 0L;
            this.f2582d = 0L;
            this.f2583e = 0L;
            this.a = 0L;
            this.a = System.currentTimeMillis();
            this.f2588j = false;
            this.k = false;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            b bVar = new b(this, telephonyManager, str);
            this.l = bVar;
            s(telephonyManager, bVar, str);
            this.f2582d = System.currentTimeMillis();
        }
    }
}
