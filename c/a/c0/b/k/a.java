package c.a.c0.b.k;

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
import c.a.c0.i.h;
import c.a.c0.r.g;
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
public class a extends c.a.c0.d.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f1771b;

    /* renamed from: c  reason: collision with root package name */
    public long f1772c;

    /* renamed from: d  reason: collision with root package name */
    public long f1773d;

    /* renamed from: e  reason: collision with root package name */
    public long f1774e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f1775f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1776g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1777h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1778i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1779j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1780k;
    public PhoneStateListener l;

    /* renamed from: c.a.c0.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0039a extends c.a.c0.r.p.c<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallActionLoadingDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1781b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f1782c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1783d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f1784e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f1785f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f1786g;

        public C0039a(a aVar, CallActionLoadingDialog callActionLoadingDialog, String str, Context context, String str2, HashMap hashMap, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callActionLoadingDialog, str, context, str2, hashMap, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1786g = aVar;
            this.a = callActionLoadingDialog;
            this.f1781b = str;
            this.f1782c = context;
            this.f1783d = str2;
            this.f1784e = hashMap;
            this.f1785f = str3;
        }

        @Override // c.a.c0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                this.a.dismiss();
                this.f1786g.s("4", this.f1781b);
                this.f1786g.q(this.f1782c, this.f1783d, this.f1781b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.r.p.b
        /* renamed from: e */
        public void b(Headers headers, @Nullable Map<String, String> map, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, map, i2) == null) {
                this.a.dismiss();
                if (map == null) {
                    this.f1786g.s("8", this.f1781b);
                    this.f1786g.q(this.f1782c, this.f1783d, this.f1781b);
                    return;
                }
                String str = (String) c.a.c0.u.c.b(map, "virtualPhone");
                if (TextUtils.isEmpty(str)) {
                    this.f1786g.s("5", this.f1781b);
                    this.f1786g.q(this.f1782c, this.f1783d, this.f1781b);
                    return;
                }
                String str2 = (String) c.a.c0.u.c.b(map, "solutionId");
                if (TextUtils.isEmpty(str2)) {
                    this.f1786g.s("6", this.f1781b);
                    this.f1786g.q(this.f1782c, this.f1783d, this.f1781b);
                    return;
                }
                String str3 = (String) c.a.c0.u.c.b(this.f1784e, "log_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    this.f1786g.s("3", this.f1781b);
                } else {
                    this.f1786g.s("7", this.f1781b);
                    String replaceAll = str3.replaceAll("\\__TIMESTAMP__", this.f1785f).replaceAll("\\__VIRTUALPHONE__", str).replaceAll("\\__SOLUTIONID__", str2);
                    c.a.c0.r.s.d dVar = new c.a.c0.r.s.d();
                    dVar.k(replaceAll);
                    dVar.g(3000);
                    dVar.c();
                    g.b().a().a(dVar, null);
                }
                this.f1786g.q(this.f1782c, str, this.f1781b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.r.p.b
        @Nullable
        /* renamed from: f */
        public Map<String, String> d(Headers headers, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? a.r(str) : (Map) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f1787b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TelephonyManager f1788c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1789d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1790e;

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
            this.f1790e = aVar;
            this.f1788c = telephonyManager;
            this.f1789d = str;
            this.a = 0;
            this.f1787b = 0;
        }

        public final void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a = this.f1787b;
                this.f1787b = i2;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 == 0) {
                    a(i2);
                    if (this.a == 2) {
                        this.f1790e.f1772c = System.currentTimeMillis();
                        this.f1790e.m(this.f1788c, this, this.f1789d);
                    }
                } else if (i2 == 1) {
                    a(i2);
                    this.f1790e.f1780k = true;
                } else if (i2 != 2) {
                } else {
                    a(i2);
                    if (this.a == 0) {
                        this.f1790e.f1771b = System.currentTimeMillis();
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
        public final /* synthetic */ TelephonyManager f1791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PhoneStateListener f1792f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f1793g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f1794h;

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
            this.f1794h = aVar;
            this.f1791e = telephonyManager;
            this.f1792f = phoneStateListener;
            this.f1793g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1791e.getCallState() != 0) {
                    this.f1794h.n(this.f1791e, this.f1792f, this.f1793g);
                    return;
                }
                this.f1791e.listen(this.f1792f, 0);
                this.f1794h.f1774e = System.currentTimeMillis();
                this.f1794h.t(this.f1793g);
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
        this.f1771b = 0L;
        this.f1772c = 0L;
        this.f1773d = 0L;
        this.f1774e = 0L;
        this.f1776g = new Handler(Looper.getMainLooper());
        this.f1777h = h.b().info().a("psl_switch", 1) == 1;
        this.f1778i = h.b().info().a("psl_time", 20);
        this.f1779j = false;
        this.f1780k = false;
    }

    @Nullable
    public static Map<String, String> r(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONArray optJSONArray = c.a.c0.u.b.b(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            hashMap.put("virtualPhone", optJSONObject.optString("virtualPhone"));
            hashMap.put("solutionId", optJSONObject.optString("solutionId"));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.c0.d.d.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NotificationCompat.CATEGORY_CALL : (String) invokeV.objValue;
    }

    @Override // c.a.c0.d.d.a
    public boolean b(@NonNull Context context, @NonNull c.a.c0.d.f.a aVar, @Nullable Map<String, Object> map, @Nullable c.a.c0.d.g.d dVar) {
        InterceptResult invokeLLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = (String) c.a.c0.u.c.b(d2, "ext_info");
            String str2 = (String) c.a.c0.u.c.b(d2, "phone");
            if (TextUtils.isEmpty(str2)) {
                s("1", str);
                c(false, null, dVar);
                return false;
            }
            if (TextUtils.equals(d2.containsKey("type") ? (String) c.a.c0.u.c.b(d2, "type") : "0", "1")) {
                String str3 = (String) c.a.c0.u.c.b(d2, "number_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    s("2", str);
                    boolean q2 = q(context, str2, str);
                    c(q2, null, dVar);
                    return q2;
                }
                CallActionLoadingDialog cancelWhenTouchOutside = new CallActionLoadingDialog(context).setMessage(context.getString(c.a.c0.b.h.nad_ocpc_phone_call_toast_text)).setCancelWhenBackKey(false).setCancelWhenTouchOutside(false);
                c.a.c0.d0.a.b(cancelWhenTouchOutside);
                C0039a c0039a = new C0039a(this, cancelWhenTouchOutside, str, context, str2, d2, valueOf);
                String replaceAll = str3.replaceAll("\\__TIMESTAMP__", valueOf);
                c.a.c0.r.s.d dVar2 = new c.a.c0.r.s.d();
                dVar2.k(replaceAll);
                dVar2.g(3000);
                dVar2.c();
                g.b().a().a(dVar2, c0039a);
                q = true;
            } else {
                q = q(context, str2, str);
            }
            c(q, null, dVar);
            return q;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, telephonyManager, phoneStateListener, str) == null) {
            long j2 = this.f1771b;
            if (j2 != 0) {
                long j3 = this.f1772c;
                if (j3 != 0 && j3 > j2) {
                    this.f1776g.removeCallbacks(this.f1775f);
                    telephonyManager.listen(phoneStateListener, 0);
                    this.f1774e = System.currentTimeMillis();
                    t(str);
                    return;
                }
            }
            n(telephonyManager, phoneStateListener, str);
        }
    }

    public final void n(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, telephonyManager, phoneStateListener, str) == null) {
            Runnable runnable = this.f1775f;
            if (runnable != null) {
                this.f1776g.removeCallbacks(runnable);
            } else {
                this.f1775f = new c(this, telephonyManager, phoneStateListener, str);
            }
            telephonyManager.listen(phoneStateListener, 32);
            this.f1776g.postDelayed(this.f1775f, TimeUnit.SECONDS.toMillis(this.f1778i));
        }
    }

    public final int o(long j2) {
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

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j2 = this.f1772c;
            if (j2 != 0) {
                long j3 = this.f1771b;
                if (j3 != 0 && j2 > j3) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.a.c0.d0.a.c(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)))) {
                s("11", str2);
                if (this.f1777h) {
                    u(context, str2);
                    return true;
                }
                return true;
            }
            s("9", str2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void s(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        c.a.c0.x.a.b(new ClogBuilder().p(ClogBuilder.Page.AD_CALL).f(ClogBuilder.Area.AD_CALL).r(ClogBuilder.LogType.AD_CALL).h(str).m(str2));
    }

    public final void t(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f1779j) {
            return;
        }
        this.f1779j = true;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = p() ? "1" : "0";
        String str4 = "-1";
        if (p()) {
            str2 = "" + o(this.f1772c - this.f1771b);
        } else {
            str2 = "-1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(this.f1778i);
        sb.append(",");
        sb.append(o(this.f1774e - this.f1773d));
        sb.append(",");
        if (p()) {
            str4 = "" + o(this.f1771b - this.a);
        }
        sb.append(str4);
        sb.append(",");
        sb.append(this.f1780k ? "1" : "0");
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        c.a.c0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.PHONE_STATE_LISTEN).m(str).h(str3).i(str2).j(sb.toString()));
    }

    public final void u(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) {
            this.f1771b = 0L;
            this.f1772c = 0L;
            this.f1773d = 0L;
            this.f1774e = 0L;
            this.a = 0L;
            this.a = System.currentTimeMillis();
            this.f1779j = false;
            this.f1780k = false;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            b bVar = new b(this, telephonyManager, str);
            this.l = bVar;
            n(telephonyManager, bVar, str);
            this.f1773d = System.currentTimeMillis();
        }
    }
}
