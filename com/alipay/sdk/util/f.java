package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String j = "failed";
    public static final String k = "scheme_failed";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public volatile IAlixPay b;
    public final Object c;
    public boolean d;
    public e e;
    public final com.alipay.sdk.sys.a f;
    public boolean g;
    public String h;
    public String i;

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public class a implements AlipayResultActivity.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;
        public final /* synthetic */ f b;

        public a(f fVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fVar;
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.b.h = com.alipay.sdk.app.b.a(i, str, str2);
                this.a.countDown();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements APayEntranceActivity.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;
        public final /* synthetic */ f b;

        public b(f fVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fVar;
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.b.i = str;
            this.a.countDown();
        }
    }

    /* loaded from: classes.dex */
    public class c extends IRemoteServiceCallback.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
            }
        }

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this(fVar);
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, map) == null) {
                com.alipay.sdk.app.statistic.a.a(this.a.f, com.alipay.sdk.app.statistic.b.q, str, str2);
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048580, this, str, str2, i, bundle) == null) {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                try {
                    bundle.putInt("CallingPid", i);
                    intent.putExtras(bundle);
                } catch (Exception e) {
                    com.alipay.sdk.app.statistic.a.a(this.a.f, "biz", com.alipay.sdk.app.statistic.b.d0, e);
                }
                intent.setClassName(str, str2);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        com.alipay.sdk.sys.a aVar = this.a.f;
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                    }
                } catch (Throwable unused) {
                }
                try {
                    if (this.a.a != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        this.a.a.startActivity(intent);
                        com.alipay.sdk.sys.a aVar2 = this.a.f;
                        com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    } else {
                        com.alipay.sdk.app.statistic.a.b(this.a.f, "biz", "ErrActNull", "");
                        Context a = this.a.f.a();
                        if (a != null) {
                            a.startActivity(intent);
                        }
                    }
                    this.a.e.a();
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(this.a.f, "biz", "ErrActNull", th);
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                com.alipay.sdk.app.statistic.a.a(this.a.f, "biz", "srvDis");
                this.a.b = null;
            }
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this(fVar);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                com.alipay.sdk.app.statistic.a.a(this.a.f, "biz", "srvCon");
                synchronized (this.a.c) {
                    this.a.b = IAlixPay.Stub.asInterface(iBinder);
                    this.a.c.notify();
                }
            }
        }
    }

    public f(Activity activity, com.alipay.sdk.sys.a aVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, aVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = IAlixPay.class;
        this.g = false;
        this.h = null;
        this.i = null;
        this.a = activity;
        this.f = aVar;
        this.e = eVar;
    }

    private String b(String str, String str2, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, str, str2, packageInfo)) == null) {
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
            }
            if (packageInfo != null) {
                str3 = packageInfo.versionName;
            } else {
                str3 = "";
            }
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind or scheme");
            com.alipay.sdk.sys.a aVar = this.f;
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.b0, str2 + "|" + str3);
            Activity activity = this.a;
            com.alipay.sdk.sys.a aVar2 = this.f;
            com.alipay.sdk.app.statistic.a.a(activity, aVar2, str, aVar2.d);
            return b(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    private Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        d dVar;
        c cVar;
        Activity activity;
        Activity activity2;
        String Pay;
        Activity activity3;
        Activity activity4;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, aVar)) == null) {
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.setAction(l.b(str2));
            String a2 = l.a(this.a, str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(elapsedRealtime);
            sb.append("|");
            if (str != null) {
                i = str.length();
            } else {
                i = 0;
            }
            sb.append(i);
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.V, sb.toString());
            com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
            try {
                if (!com.alipay.sdk.data.a.u().e()) {
                    ComponentName startService = this.a.getApplication().startService(intent);
                    if (startService != null) {
                        str3 = startService.getPackageName();
                    } else {
                        str3 = StringUtil.NULL_STRING;
                    }
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", "stSrv", str3);
                } else {
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", "stSrv", "skipped");
                }
                if (com.alipay.sdk.data.a.u().a()) {
                    i2 = 65;
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", "bindFlg", "imp");
                } else {
                    i2 = 1;
                }
                d dVar2 = new d(this, null);
                if (this.a.getApplicationContext().bindService(intent, dVar2, i2)) {
                    synchronized (this.c) {
                        if (this.b == null) {
                            try {
                                this.c.wait(com.alipay.sdk.data.a.u().j());
                            } catch (InterruptedException e2) {
                                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.P, e2);
                            }
                        }
                    }
                    IAlixPay iAlixPay = this.b;
                    try {
                        if (iAlixPay == null) {
                            String a3 = l.a(this.a, str2);
                            com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.I, a2 + "|" + a3);
                            Pair<String, Boolean> pair = new Pair<>(j, Boolean.TRUE);
                            try {
                                this.a.getApplicationContext().unbindService(dVar2);
                            } catch (Throwable th) {
                                com.alipay.sdk.util.c.a(th);
                            }
                            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                            this.b = null;
                            if (this.d && (activity4 = this.a) != null) {
                                activity4.setRequestedOrientation(0);
                                this.d = false;
                            }
                            return pair;
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.W, "" + elapsedRealtime2);
                        if (this.e != null) {
                            this.e.b();
                        }
                        if (this.a.getRequestedOrientation() == 0) {
                            this.a.setRequestedOrientation(1);
                            this.d = true;
                        }
                        int version = iAlixPay.getVersion();
                        cVar = new c(this, null);
                        try {
                            if (version >= 3) {
                                iAlixPay.registerCallback03(cVar, str, null);
                            } else {
                                iAlixPay.registerCallback(cVar);
                            }
                            long elapsedRealtime3 = SystemClock.elapsedRealtime();
                            StringBuilder sb2 = new StringBuilder();
                            try {
                                sb2.append("");
                                sb2.append(elapsedRealtime3);
                                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.Y, sb2.toString());
                                if (version >= 3) {
                                    iAlixPay.r03("biz", "bind_pay", null);
                                }
                                if (version >= 2) {
                                    HashMap<String, String> a4 = com.alipay.sdk.sys.a.a(aVar);
                                    a4.put("ts_bind", String.valueOf(elapsedRealtime));
                                    a4.put("ts_bend", String.valueOf(elapsedRealtime2));
                                    a4.put("ts_pay", String.valueOf(elapsedRealtime3));
                                    Pay = iAlixPay.pay02(str, a4);
                                } else {
                                    Pay = iAlixPay.Pay(str);
                                }
                                String str4 = Pay;
                                try {
                                    iAlixPay.unregisterCallback(cVar);
                                } catch (Throwable th2) {
                                    com.alipay.sdk.util.c.a(th2);
                                }
                                try {
                                    this.a.getApplicationContext().unbindService(dVar2);
                                } catch (Throwable th3) {
                                    com.alipay.sdk.util.c.a(th3);
                                }
                                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                                com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                                this.b = null;
                                if (this.d && (activity3 = this.a) != null) {
                                    activity3.setRequestedOrientation(0);
                                    this.d = false;
                                }
                                return new Pair<>(str4, Boolean.FALSE);
                            } catch (Throwable th4) {
                                th = th4;
                                dVar = dVar2;
                                try {
                                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.I, th, "in_bind");
                                    Pair<String, Boolean> pair2 = new Pair<>(j, Boolean.TRUE);
                                    if (cVar != null) {
                                        try {
                                            iAlixPay.unregisterCallback(cVar);
                                        } catch (Throwable th5) {
                                            com.alipay.sdk.util.c.a(th5);
                                        }
                                    }
                                    try {
                                        this.a.getApplicationContext().unbindService(dVar);
                                    } catch (Throwable th6) {
                                        com.alipay.sdk.util.c.a(th6);
                                    }
                                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                                    com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                                    this.b = null;
                                    if (this.d && (activity2 = this.a) != null) {
                                        activity2.setRequestedOrientation(0);
                                        this.d = false;
                                    }
                                    return pair2;
                                } catch (Throwable th7) {
                                    if (cVar != null) {
                                        try {
                                            iAlixPay.unregisterCallback(cVar);
                                        } catch (Throwable th8) {
                                            com.alipay.sdk.util.c.a(th8);
                                        }
                                    }
                                    try {
                                        this.a.getApplicationContext().unbindService(dVar);
                                    } catch (Throwable th9) {
                                        com.alipay.sdk.util.c.a(th9);
                                    }
                                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                                    com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                                    this.b = null;
                                    if (this.d && (activity = this.a) != null) {
                                        activity.setRequestedOrientation(0);
                                        this.d = false;
                                    }
                                    throw th7;
                                }
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            dVar = dVar2;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        dVar = dVar2;
                        cVar = null;
                    }
                } else {
                    throw new Throwable("bindService fail");
                }
            }
        } else {
            return (Pair) invokeLLL.objValue;
        }
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        JSONObject jSONObject;
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, str2)) == null) {
            String str7 = str;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            String a2 = l.a(32);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPStart", a2 + "|" + elapsedRealtime);
            a.C0013a.a(this.f, a2);
            AlipayResultActivity.a.put(a2, new a(this, countDownLatch));
            try {
                try {
                    String[] split = str7.split("&", -1);
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        jSONObject = null;
                        if (i >= length) {
                            str4 = "";
                            str5 = str4;
                            str6 = null;
                            break;
                        }
                        str6 = split[i];
                        if (str6.startsWith(com.alipay.sdk.sys.a.m)) {
                            String substring = str6.substring(str6.indexOf("{"), str6.lastIndexOf("}") + 1);
                            int indexOf = str6.indexOf(substring);
                            str5 = str6.substring(0, indexOf);
                            str4 = str6.substring(indexOf + substring.length());
                            JSONObject jSONObject2 = new JSONObject(substring);
                            if (jSONObject2.optString(Config.STAT_SDK_CHANNEL).equals("h5tonative")) {
                                jSONObject2.put(Config.STAT_SDK_CHANNEL, "h5tonative_scheme");
                            } else {
                                jSONObject2.put(Config.STAT_SDK_CHANNEL, "h5tonative_sdkscheme");
                            }
                            jSONObject = jSONObject2;
                        } else {
                            i++;
                        }
                    }
                } catch (Exception e2) {
                    try {
                        com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPSCReplaceEx", e2, Base64.encodeToString(str.getBytes(), 2));
                    } catch (InterruptedException e3) {
                        com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPWaiting", e3);
                        return com.alipay.sdk.app.b.a(com.alipay.sdk.app.c.i.b(), com.alipay.sdk.app.c.i.a(), "");
                    }
                }
                if (!TextUtils.isEmpty(str6)) {
                    if (str7.indexOf(str6) == str7.lastIndexOf(str6)) {
                        str7 = str7.replace(str6, str5 + jSONObject.toString() + str4);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("sourcePid", Binder.getCallingPid());
                        jSONObject3.put(com.alipay.sdk.cons.b.d, str7);
                        jSONObject3.put("pkgName", this.a.getPackageName());
                        jSONObject3.put("session", a2);
                        String encodeToString = Base64.encodeToString(jSONObject3.toString().getBytes("UTF-8"), 2);
                        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "20000125");
                        appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
                        try {
                            HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.f);
                            a3.put("ts_scheme", String.valueOf(elapsedRealtime));
                            appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(a3).toString());
                        } catch (Throwable th) {
                            com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPLocEx", th);
                        }
                        String uri = appendQueryParameter.build().toString();
                        Intent intent = new Intent();
                        intent.setPackage(str2);
                        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                        intent.setData(Uri.parse(uri));
                        com.alipay.sdk.app.statistic.a.a(this.a, this.f, str7, this.f.d);
                        this.a.startActivity(intent);
                        com.alipay.sdk.data.a.u().a(this.f, this.a.getApplicationContext());
                        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay scheme waiting " + uri);
                        countDownLatch.await();
                        String str8 = this.h;
                        try {
                            str3 = j.a(this.f, str8).get(j.a);
                            if (str3 == null) {
                                str3 = StringUtil.NULL_STRING;
                            }
                        } catch (Throwable th2) {
                            com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPStatEx", th2);
                            str3 = "unknown";
                        }
                        com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPDone-" + str3);
                        if (TextUtils.isEmpty(str8)) {
                            com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPEmpty");
                            return k;
                        }
                        return str8;
                    }
                    throw new RuntimeException("multi ctx_args");
                }
                throw new RuntimeException("empty ctx_args");
            } catch (Throwable th3) {
                com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPEx", th3);
                return k;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, String str2, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        int i;
        String str3;
        String str4;
        com.alipay.sdk.sys.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, str, str2, packageInfo)) == null) {
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            } else {
                i = 0;
            }
            if (packageInfo == null) {
                str3 = "";
            } else {
                str3 = packageInfo.versionName;
            }
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind or scheme");
            com.alipay.sdk.sys.a aVar2 = this.f;
            com.alipay.sdk.app.statistic.a.a(aVar2, "biz", com.alipay.sdk.app.statistic.b.b0, str2 + "|" + str3);
            if (l.g()) {
                com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BindSkipByModel");
            } else if (l.d(this.f, str2)) {
                com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BindSkipByL");
            } else {
                Pair<String, Boolean> a2 = a(str, str2, this.f);
                str4 = (String) a2.first;
                try {
                    if (j.equals(str4) && ((Boolean) a2.second).booleanValue() && com.alipay.sdk.data.a.u().m()) {
                        com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BindRetry");
                        str4 = (String) a(str, str2, this.f).first;
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BindRetryEx", th);
                }
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind result: " + str4);
                Activity activity = this.a;
                com.alipay.sdk.sys.a aVar3 = this.f;
                com.alipay.sdk.app.statistic.a.a(activity, aVar3, str, aVar3.d);
                if (j.equals(str4)) {
                    if (!com.alipay.sdk.data.a.u().h()) {
                        com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPNotStartByConfig", "");
                        return str4;
                    } else if (l.b.equals(str2) && i > 125) {
                        if (com.alipay.sdk.data.a.u().l() && (aVar = this.f) != null && l.b(aVar.f) != 0) {
                            com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSPNotStartByUsr");
                            return str4;
                        }
                        Activity activity2 = this.a;
                        if (activity2 != null && a(str2, activity2, this.f)) {
                            return a(str, str2);
                        }
                        return k;
                    } else {
                        com.alipay.sdk.sys.a aVar4 = this.f;
                        com.alipay.sdk.app.statistic.a.a(aVar4, "biz", "BSPNotStartByPkg", str2 + "|" + i);
                    }
                }
                return str4;
            }
            str4 = j;
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind result: " + str4);
            Activity activity3 = this.a;
            com.alipay.sdk.sys.a aVar32 = this.f;
            com.alipay.sdk.app.statistic.a.a(activity3, aVar32, str, aVar32.d);
            if (j.equals(str4)) {
            }
            return str4;
        }
        return (String) invokeLLL.objValue;
    }

    private void a(l.b bVar) throws InterruptedException {
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, this, bVar) != null) || bVar == null || (packageInfo = bVar.a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.a.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.f, "biz", com.alipay.sdk.app.statistic.b.h0, th);
        }
        Thread.sleep(200L);
    }

    public static boolean a(String str, Context context, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, context, aVar)) == null) {
            try {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
                if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BSPDetectFail");
                    return false;
                }
                return true;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BSPDetectFail", th);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private String b(String str, String str2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, str2)) == null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            String a2 = l.a(32);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.alipay.sdk.sys.a aVar = this.f;
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BSAStart", a2 + "|" + elapsedRealtime);
            a.C0013a.a(this.f, a2);
            APayEntranceActivity.g.put(a2, new b(this, countDownLatch));
            try {
                HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.f);
                a3.put("ts_intent", String.valueOf(elapsedRealtime));
                jSONObject = new JSONObject(a3);
            } catch (Throwable th) {
                try {
                    com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSALocEx", th);
                    jSONObject = null;
                } catch (InterruptedException e2) {
                    com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSAWaiting", e2);
                    return com.alipay.sdk.app.b.a(com.alipay.sdk.app.c.i.b(), com.alipay.sdk.app.c.i.a(), "");
                } catch (Throwable th2) {
                    com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSAEx", th2);
                    return k;
                }
            }
            Intent intent = new Intent(this.a, APayEntranceActivity.class);
            intent.putExtra(APayEntranceActivity.c, str);
            intent.putExtra(APayEntranceActivity.d, str2);
            intent.putExtra(APayEntranceActivity.e, a2);
            if (jSONObject != null) {
                intent.putExtra(APayEntranceActivity.f, jSONObject.toString());
            }
            com.alipay.sdk.app.statistic.a.a(this.a, this.f, str, this.f.d);
            this.a.startActivity(intent);
            com.alipay.sdk.data.a.u().a(this.f, this.a.getApplicationContext());
            countDownLatch.await();
            String str4 = this.i;
            try {
                str3 = j.a(this.f, str4).get(j.a);
                if (str3 == null) {
                    str3 = StringUtil.NULL_STRING;
                }
            } catch (Throwable th3) {
                com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSAStatEx", th3);
                str3 = "unknown";
            }
            com.alipay.sdk.sys.a aVar2 = this.f;
            com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "BSADone-" + str3);
            if (TextUtils.isEmpty(str4)) {
                com.alipay.sdk.app.statistic.a.a(this.f, "biz", "BSAEmpty");
                return k;
            }
            return str4;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e A[Catch: all -> 0x00c4, TryCatch #1 {all -> 0x00c4, blocks: (B:5:0x0007, B:9:0x001b, B:12:0x0027, B:14:0x002f, B:17:0x0037, B:20:0x0040, B:23:0x0046, B:26:0x0051, B:28:0x005a, B:30:0x005e, B:31:0x0060, B:33:0x006a, B:48:0x00b1, B:50:0x00b5, B:52:0x00bf, B:27:0x0056, B:8:0x0019), top: B:71:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:35:0x0070, B:37:0x007b, B:39:0x0081, B:40:0x0085, B:42:0x008b, B:44:0x0097, B:46:0x009b), top: B:69:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        InterceptResult invokeL;
        l.b a2;
        String b2;
        JSONObject optJSONObject;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = "";
            PackageInfo packageInfo = null;
            try {
                List<a.b> k2 = com.alipay.sdk.data.a.u().k();
                if (!com.alipay.sdk.data.a.u().g || k2 == null) {
                    k2 = com.alipay.sdk.app.a.d;
                }
                a2 = l.a(this.f, this.a, k2);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.f, "biz", com.alipay.sdk.app.statistic.b.R, th);
            }
            if (a2 == null || a2.a(this.f) || a2.a() || l.a(a2.a)) {
                return j;
            }
            if (a2.a != null && !l.b.equals(a2.a.packageName)) {
                str2 = a2.a.packageName;
                if (a2.a != null) {
                    packageInfo = a2.a;
                }
                b2 = com.alipay.sdk.data.a.u().b();
                if (b2 != null && b2.length() > 0) {
                    try {
                        optJSONObject = new JSONObject(b2).optJSONObject(str2);
                        if (optJSONObject != null && optJSONObject.length() > 0) {
                            keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                int parseInt = Integer.parseInt(next);
                                if (packageInfo != null && packageInfo.versionCode >= parseInt) {
                                    try {
                                        boolean a3 = com.alipay.sdk.data.a.u().a(this.a, Integer.parseInt(optJSONObject.getString(next)));
                                        this.g = a3;
                                        if (a3) {
                                            break;
                                        }
                                    } catch (Exception unused) {
                                        continue;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (!this.g && !com.alipay.sdk.data.a.u().o()) {
                    a(a2);
                }
                if (!this.g) {
                    return b(str, str2, packageInfo);
                }
                return a(str, str2, packageInfo);
            }
            str2 = l.a();
            if (a2.a != null) {
            }
            b2 = com.alipay.sdk.data.a.u().b();
            if (b2 != null) {
                optJSONObject = new JSONObject(b2).optJSONObject(str2);
                if (optJSONObject != null) {
                    keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                    }
                }
            }
            if (!this.g) {
                a(a2);
            }
            if (!this.g) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.e = null;
        }
    }
}
