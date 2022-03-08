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
import com.baidu.sapi2.activity.BaseActivity;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static final String f29566j = "failed";
    public static final String k = "scheme_failed";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public volatile IAlixPay f29567b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f29568c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29569d;

    /* renamed from: e  reason: collision with root package name */
    public e f29570e;

    /* renamed from: f  reason: collision with root package name */
    public final com.alipay.sdk.sys.a f29571f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29572g;

    /* renamed from: h  reason: collision with root package name */
    public String f29573h;

    /* renamed from: i  reason: collision with root package name */
    public String f29574i;

    /* loaded from: classes3.dex */
    public class a implements AlipayResultActivity.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f29575b;

        public a(f fVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29575b = fVar;
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                this.f29575b.f29573h = com.alipay.sdk.app.b.a(i2, str, str2);
                this.a.countDown();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements APayEntranceActivity.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f29576b;

        public b(f fVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29576b = fVar;
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29576b.f29574i = str;
                this.a.countDown();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends IRemoteServiceCallback.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public c(f fVar) {
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
            this.a = fVar;
        }

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

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, map) == null) {
                com.alipay.sdk.app.statistic.a.a(this.a.f29571f, com.alipay.sdk.app.statistic.b.q, str, str2);
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i2, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048580, this, str, str2, i2, bundle) == null) {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                try {
                    bundle.putInt("CallingPid", i2);
                    intent.putExtras(bundle);
                } catch (Exception e2) {
                    com.alipay.sdk.app.statistic.a.a(this.a.f29571f, "biz", com.alipay.sdk.app.statistic.b.d0, e2);
                }
                intent.setClassName(str, str2);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        com.alipay.sdk.sys.a aVar = this.a.f29571f;
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                    }
                } catch (Throwable unused) {
                }
                try {
                    if (this.a.a == null) {
                        com.alipay.sdk.app.statistic.a.b(this.a.f29571f, "biz", "ErrActNull", "");
                        Context a = this.a.f29571f.a();
                        if (a != null) {
                            a.startActivity(intent);
                        }
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        this.a.a.startActivity(intent);
                        com.alipay.sdk.sys.a aVar2 = this.a.f29571f;
                        com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                    this.a.f29570e.a();
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(this.a.f29571f, "biz", "ErrActNull", th);
                    throw th;
                }
            }
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                com.alipay.sdk.app.statistic.a.a(this.a.f29571f, "biz", "srvCon");
                synchronized (this.a.f29568c) {
                    this.a.f29567b = IAlixPay.Stub.asInterface(iBinder);
                    this.a.f29568c.notify();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                com.alipay.sdk.app.statistic.a.a(this.a.f29571f, "biz", "srvDis");
                this.a.f29567b = null;
            }
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b();
    }

    public f(Activity activity, com.alipay.sdk.sys.a aVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, aVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29568c = IAlixPay.class;
        this.f29572g = false;
        this.f29573h = null;
        this.f29574i = null;
        this.a = activity;
        this.f29571f = aVar;
        this.f29570e = eVar;
    }

    private String b(String str, String str2, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, str, str2, packageInfo)) == null) {
            if (packageInfo != null) {
                int i2 = packageInfo.versionCode;
            }
            String str3 = packageInfo != null ? packageInfo.versionName : "";
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind or scheme");
            com.alipay.sdk.sys.a aVar = this.f29571f;
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.b0, str2 + "|" + str3);
            Activity activity = this.a;
            com.alipay.sdk.sys.a aVar2 = this.f29571f;
            com.alipay.sdk.app.statistic.a.a(activity, aVar2, str, aVar2.f29536d);
            return b(str, str2);
        }
        return (String) invokeLLL.objValue;
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
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        String str2 = "";
        try {
            List<a.b> k2 = com.alipay.sdk.data.a.u().k();
            if (!com.alipay.sdk.data.a.u().f29480g || k2 == null) {
                k2 = com.alipay.sdk.app.a.f29425d;
            }
            a2 = l.a(this.f29571f, this.a, k2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", com.alipay.sdk.app.statistic.b.R, th);
        }
        if (a2 == null || a2.a(this.f29571f) || a2.a() || l.a(a2.a)) {
            return f29566j;
        }
        if (a2.a != null && !l.f29587b.equals(a2.a.packageName)) {
            str2 = a2.a.packageName;
            r1 = a2.a != null ? a2.a : null;
            b2 = com.alipay.sdk.data.a.u().b();
            if (b2 != null && b2.length() > 0) {
                try {
                    optJSONObject = new JSONObject(b2).optJSONObject(str2);
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            int parseInt = Integer.parseInt(next);
                            if (r1 != null && r1.versionCode >= parseInt) {
                                try {
                                    boolean a3 = com.alipay.sdk.data.a.u().a(this.a, Integer.parseInt(optJSONObject.getString(next)));
                                    this.f29572g = a3;
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
            if (!this.f29572g && !com.alipay.sdk.data.a.u().o()) {
                a(a2);
            }
            if (!this.f29572g) {
                return b(str, str2, r1);
            }
            return a(str, str2, r1);
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
        if (!this.f29572g) {
            a(a2);
        }
        if (!this.f29572g) {
        }
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
            com.alipay.sdk.sys.a aVar = this.f29571f;
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BSAStart", a2 + "|" + elapsedRealtime);
            a.C1689a.a(this.f29571f, a2);
            APayEntranceActivity.f29377g.put(a2, new b(this, countDownLatch));
            try {
                HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.f29571f);
                a3.put("ts_intent", String.valueOf(elapsedRealtime));
                jSONObject = new JSONObject(a3);
            } catch (Throwable th) {
                try {
                    com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSALocEx", th);
                    jSONObject = null;
                } catch (InterruptedException e2) {
                    com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSAWaiting", e2);
                    return com.alipay.sdk.app.b.a(com.alipay.sdk.app.c.f29433i.b(), com.alipay.sdk.app.c.f29433i.a(), "");
                } catch (Throwable th2) {
                    com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSAEx", th2);
                    return k;
                }
            }
            Intent intent = new Intent(this.a, APayEntranceActivity.class);
            intent.putExtra(APayEntranceActivity.f29373c, str);
            intent.putExtra(APayEntranceActivity.f29374d, str2);
            intent.putExtra(APayEntranceActivity.f29375e, a2);
            if (jSONObject != null) {
                intent.putExtra(APayEntranceActivity.f29376f, jSONObject.toString());
            }
            com.alipay.sdk.app.statistic.a.a(this.a, this.f29571f, str, this.f29571f.f29536d);
            this.a.startActivity(intent);
            com.alipay.sdk.data.a.u().a(this.f29571f, this.a.getApplicationContext());
            countDownLatch.await();
            String str4 = this.f29574i;
            try {
                str3 = j.a(this.f29571f, str4).get("resultStatus");
                if (str3 == null) {
                    str3 = StringUtil.NULL_STRING;
                }
            } catch (Throwable th3) {
                com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSAStatEx", th3);
                str3 = "unknown";
            }
            com.alipay.sdk.sys.a aVar2 = this.f29571f;
            com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "BSADone-" + str3);
            if (TextUtils.isEmpty(str4)) {
                com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSAEmpty");
                return k;
            }
            return str4;
        }
        return (String) invokeLL.objValue;
    }

    private void a(l.b bVar) throws InterruptedException {
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, bVar) == null) || bVar == null || (packageInfo = bVar.a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.a.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", com.alipay.sdk.app.statistic.b.h0, th);
        }
        Thread.sleep(200L);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, String str2, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        String str3;
        com.alipay.sdk.sys.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, str, str2, packageInfo)) == null) {
            int i2 = packageInfo != null ? packageInfo.versionCode : 0;
            String str4 = packageInfo != null ? packageInfo.versionName : "";
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind or scheme");
            com.alipay.sdk.sys.a aVar2 = this.f29571f;
            com.alipay.sdk.app.statistic.a.a(aVar2, "biz", com.alipay.sdk.app.statistic.b.b0, str2 + "|" + str4);
            if (l.g()) {
                com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BindSkipByModel");
            } else if (l.d(this.f29571f, str2)) {
                com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BindSkipByL");
            } else {
                Pair<String, Boolean> a2 = a(str, str2, this.f29571f);
                str3 = (String) a2.first;
                try {
                    if (f29566j.equals(str3) && ((Boolean) a2.second).booleanValue() && com.alipay.sdk.data.a.u().m()) {
                        com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BindRetry");
                        str3 = (String) a(str, str2, this.f29571f).first;
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BindRetryEx", th);
                }
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind result: " + str3);
                Activity activity = this.a;
                com.alipay.sdk.sys.a aVar3 = this.f29571f;
                com.alipay.sdk.app.statistic.a.a(activity, aVar3, str, aVar3.f29536d);
                if (f29566j.equals(str3)) {
                    if (!com.alipay.sdk.data.a.u().h()) {
                        com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPNotStartByConfig", "");
                        return str3;
                    } else if (l.f29587b.equals(str2) && i2 > 125) {
                        if (com.alipay.sdk.data.a.u().l() && (aVar = this.f29571f) != null && l.b(aVar.f29538f) != 0) {
                            com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPNotStartByUsr");
                            return str3;
                        }
                        Activity activity2 = this.a;
                        return (activity2 == null || !a(str2, activity2, this.f29571f)) ? k : a(str, str2);
                    } else {
                        com.alipay.sdk.sys.a aVar4 = this.f29571f;
                        com.alipay.sdk.app.statistic.a.a(aVar4, "biz", "BSPNotStartByPkg", str2 + "|" + i2);
                    }
                }
                return str3;
            }
            str3 = f29566j;
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind result: " + str3);
            Activity activity3 = this.a;
            com.alipay.sdk.sys.a aVar32 = this.f29571f;
            com.alipay.sdk.app.statistic.a.a(activity3, aVar32, str, aVar32.f29536d);
            if (f29566j.equals(str3)) {
            }
            return str3;
        }
        return (String) invokeLLL.objValue;
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
            com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPStart", a2 + "|" + elapsedRealtime);
            a.C1689a.a(this.f29571f, a2);
            AlipayResultActivity.a.put(a2, new a(this, countDownLatch));
            try {
                try {
                    String[] split = str7.split("&", -1);
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        jSONObject = null;
                        if (i2 >= length) {
                            str4 = "";
                            str5 = str4;
                            str6 = null;
                            break;
                        }
                        str6 = split[i2];
                        if (str6.startsWith(com.alipay.sdk.sys.a.m)) {
                            String substring = str6.substring(str6.indexOf("{"), str6.lastIndexOf("}") + 1);
                            int indexOf = str6.indexOf(substring);
                            str5 = str6.substring(0, indexOf);
                            str4 = str6.substring(indexOf + substring.length());
                            JSONObject jSONObject2 = new JSONObject(substring);
                            if (jSONObject2.optString("sc").equals("h5tonative")) {
                                jSONObject2.put("sc", "h5tonative_scheme");
                            } else {
                                jSONObject2.put("sc", "h5tonative_sdkscheme");
                            }
                            jSONObject = jSONObject2;
                        } else {
                            i2++;
                        }
                    }
                } catch (Exception e2) {
                    try {
                        com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPSCReplaceEx", e2, Base64.encodeToString(str.getBytes(), 2));
                    } catch (InterruptedException e3) {
                        com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPWaiting", e3);
                        return com.alipay.sdk.app.b.a(com.alipay.sdk.app.c.f29433i.b(), com.alipay.sdk.app.c.f29433i.a(), "");
                    }
                }
                if (!TextUtils.isEmpty(str6)) {
                    if (str7.indexOf(str6) == str7.lastIndexOf(str6)) {
                        str7 = str7.replace(str6, str5 + jSONObject.toString() + str4);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("sourcePid", Binder.getCallingPid());
                        jSONObject3.put(com.alipay.sdk.cons.b.f29459d, str7);
                        jSONObject3.put("pkgName", this.a.getPackageName());
                        jSONObject3.put("session", a2);
                        String encodeToString = Base64.encodeToString(jSONObject3.toString().getBytes("UTF-8"), 2);
                        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "20000125");
                        appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
                        try {
                            HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.f29571f);
                            a3.put("ts_scheme", String.valueOf(elapsedRealtime));
                            appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(a3).toString());
                        } catch (Throwable th) {
                            com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPLocEx", th);
                        }
                        String uri = appendQueryParameter.build().toString();
                        Intent intent = new Intent();
                        intent.setPackage(str2);
                        intent.addFlags(268435456);
                        intent.setData(Uri.parse(uri));
                        com.alipay.sdk.app.statistic.a.a(this.a, this.f29571f, str7, this.f29571f.f29536d);
                        this.a.startActivity(intent);
                        com.alipay.sdk.data.a.u().a(this.f29571f, this.a.getApplicationContext());
                        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay scheme waiting " + uri);
                        countDownLatch.await();
                        String str8 = this.f29573h;
                        try {
                            str3 = j.a(this.f29571f, str8).get("resultStatus");
                            if (str3 == null) {
                                str3 = StringUtil.NULL_STRING;
                            }
                        } catch (Throwable th2) {
                            com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPStatEx", th2);
                            str3 = "unknown";
                        }
                        com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPDone-" + str3);
                        if (TextUtils.isEmpty(str8)) {
                            com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPEmpty");
                            return k;
                        }
                        return str8;
                    }
                    throw new RuntimeException("multi ctx_args");
                }
                throw new RuntimeException("empty ctx_args");
            } catch (Throwable th3) {
                com.alipay.sdk.app.statistic.a.a(this.f29571f, "biz", "BSPEx", th3);
                return k;
            }
        }
        return (String) invokeLL.objValue;
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

    private Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLLL;
        int i2;
        d dVar;
        c cVar;
        Activity activity;
        Activity activity2;
        String Pay;
        Activity activity3;
        Activity activity4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, aVar)) != null) {
            return (Pair) invokeLLL.objValue;
        }
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(l.b(str2));
        String a2 = l.a(this.a, str2);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(elapsedRealtime);
        sb.append("|");
        sb.append(str != null ? str.length() : 0);
        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.V, sb.toString());
        com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f29536d);
        try {
            if (!com.alipay.sdk.data.a.u().e()) {
                ComponentName startService = this.a.getApplication().startService(intent);
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "stSrv", startService != null ? startService.getPackageName() : StringUtil.NULL_STRING);
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
                synchronized (this.f29568c) {
                    if (this.f29567b == null) {
                        try {
                            this.f29568c.wait(com.alipay.sdk.data.a.u().j());
                        } catch (InterruptedException e2) {
                            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.P, e2);
                        }
                    }
                }
                IAlixPay iAlixPay = this.f29567b;
                try {
                    if (iAlixPay == null) {
                        String a3 = l.a(this.a, str2);
                        com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.I, a2 + "|" + a3);
                        Pair<String, Boolean> pair = new Pair<>(f29566j, Boolean.TRUE);
                        try {
                            this.a.getApplicationContext().unbindService(dVar2);
                        } catch (Throwable th) {
                            com.alipay.sdk.util.c.a(th);
                        }
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f29536d);
                        this.f29567b = null;
                        if (this.f29569d && (activity4 = this.a) != null) {
                            activity4.setRequestedOrientation(0);
                            this.f29569d = false;
                        }
                        return pair;
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.W, "" + elapsedRealtime2);
                    if (this.f29570e != null) {
                        this.f29570e.b();
                    }
                    if (this.a.getRequestedOrientation() == 0) {
                        this.a.setRequestedOrientation(1);
                        this.f29569d = true;
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
                            String str3 = Pay;
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
                            com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f29536d);
                            this.f29567b = null;
                            if (this.f29569d && (activity3 = this.a) != null) {
                                activity3.setRequestedOrientation(0);
                                this.f29569d = false;
                            }
                            return new Pair<>(str3, Boolean.FALSE);
                        } catch (Throwable th4) {
                            th = th4;
                            dVar = dVar2;
                            try {
                                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.I, th, "in_bind");
                                Pair<String, Boolean> pair2 = new Pair<>(f29566j, Boolean.TRUE);
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
                                com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f29536d);
                                this.f29567b = null;
                                if (this.f29569d && (activity2 = this.a) != null) {
                                    activity2.setRequestedOrientation(0);
                                    this.f29569d = false;
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
                                com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f29536d);
                                this.f29567b = null;
                                if (this.f29569d && (activity = this.a) != null) {
                                    activity.setRequestedOrientation(0);
                                    this.f29569d = false;
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
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.f29570e = null;
        }
    }
}
