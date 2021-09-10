package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.k;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36070a = "failed";

    /* renamed from: b  reason: collision with root package name */
    public static final String f36071b = "scheme_failed";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Activity f36072c;

    /* renamed from: d  reason: collision with root package name */
    public volatile IAlixPay f36073d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f36074e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36075f;

    /* renamed from: g  reason: collision with root package name */
    public c f36076g;

    /* renamed from: h  reason: collision with root package name */
    public final com.alipay.sdk.sys.a f36077h;

    /* renamed from: i  reason: collision with root package name */
    public String f36078i;

    /* loaded from: classes4.dex */
    public class a extends IRemoteServiceCallback.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f36081a;

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
            this.f36081a = eVar;
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
                com.alipay.sdk.app.statistic.a.b(this.f36081a.f36077h, com.alipay.sdk.app.statistic.b.f35919g, str, str2);
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
                    com.alipay.sdk.app.statistic.a.a(this.f36081a.f36077h, "biz", com.alipay.sdk.app.statistic.b.T, e2);
                }
                intent.setClassName(str, str2);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        com.alipay.sdk.sys.a aVar = this.f36081a.f36077h;
                        com.alipay.sdk.app.statistic.a.b(aVar, "biz", "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                    }
                } catch (Throwable unused) {
                }
                try {
                    if (this.f36081a.f36072c == null) {
                        com.alipay.sdk.app.statistic.a.a(this.f36081a.f36077h, "biz", "ErrActNull", "");
                        Context d2 = this.f36081a.f36077h.d();
                        if (d2 != null) {
                            d2.startActivity(intent);
                        }
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        this.f36081a.f36072c.startActivity(intent);
                        com.alipay.sdk.sys.a aVar2 = this.f36081a.f36077h;
                        com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                    this.f36081a.f36076g.b();
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(this.f36081a.f36077h, "biz", "ErrActNull", th);
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f36082a;

        public b(e eVar) {
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
            this.f36082a = eVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                com.alipay.sdk.app.statistic.a.a(this.f36082a.f36077h, "biz", "srvCon");
                synchronized (this.f36082a.f36074e) {
                    this.f36082a.f36073d = IAlixPay.Stub.asInterface(iBinder);
                    this.f36082a.f36074e.notify();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                com.alipay.sdk.app.statistic.a.a(this.f36082a.f36077h, "biz", "srvDis");
                this.f36082a.f36073d = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b();
    }

    public e(Activity activity, com.alipay.sdk.sys.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36074e = IAlixPay.class;
        this.f36078i = null;
        this.f36072c = activity;
        this.f36077h = aVar;
        this.f36076g = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:5:0x0007, B:9:0x001b, B:12:0x0027, B:14:0x002f, B:17:0x0036, B:20:0x003f, B:22:0x0043, B:25:0x0050, B:27:0x0059, B:29:0x005d, B:30:0x005f, B:32:0x0069, B:26:0x0055, B:8:0x0019), top: B:43:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069 A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #0 {all -> 0x006e, blocks: (B:5:0x0007, B:9:0x001b, B:12:0x0027, B:14:0x002f, B:17:0x0036, B:20:0x003f, B:22:0x0043, B:25:0x0050, B:27:0x0059, B:29:0x005d, B:30:0x005f, B:32:0x0069, B:26:0x0055, B:8:0x0019), top: B:43:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        InterceptResult invokeL;
        k.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = "";
            try {
                List<a.C1563a> o = com.alipay.sdk.data.a.p().o();
                if (!com.alipay.sdk.data.a.p().f35962a || o == null) {
                    o = com.alipay.sdk.app.a.f35891a;
                }
                a2 = k.a(this.f36077h, this.f36072c, o);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.f36077h, "biz", com.alipay.sdk.app.statistic.b.H, th);
            }
            if (a2 == null || a2.a(this.f36077h) || a2.a() || k.a(a2.f36105a)) {
                return f36070a;
            }
            if (a2.f36105a != null && !k.f36098a.equals(a2.f36105a.packageName)) {
                str2 = a2.f36105a.packageName;
                r1 = a2.f36105a != null ? a2.f36105a : null;
                if (!com.alipay.sdk.data.a.p().m()) {
                    a(a2);
                }
                return a(str, str2, r1);
            }
            str2 = k.a();
            if (a2.f36105a != null) {
            }
            if (!com.alipay.sdk.data.a.p().m()) {
            }
            return a(str, str2, r1);
        }
        return (String) invokeL.objValue;
    }

    private void a(k.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, aVar) == null) || aVar == null || (packageInfo = aVar.f36105a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f36072c.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.f36077h, "biz", com.alipay.sdk.app.statistic.b.X, th);
        }
        Thread.sleep(200L);
    }

    private String a(String str, String str2, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        String str3;
        com.alipay.sdk.sys.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, str, str2, packageInfo)) == null) {
            int i2 = packageInfo != null ? packageInfo.versionCode : 0;
            String str4 = packageInfo != null ? packageInfo.versionName : "";
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay bind or scheme");
            com.alipay.sdk.sys.a aVar2 = this.f36077h;
            com.alipay.sdk.app.statistic.a.b(aVar2, "biz", com.alipay.sdk.app.statistic.b.R, str2 + "|" + str4);
            if (k.e()) {
                com.alipay.sdk.app.statistic.a.a(this.f36077h, "biz", "BindSkipByModel");
                str3 = f36070a;
            } else {
                Pair<String, Boolean> a2 = a(str, str2, this.f36077h);
                str3 = (String) a2.first;
                try {
                    if (f36070a.equals(str3) && ((Boolean) a2.second).booleanValue() && com.alipay.sdk.data.a.p().l()) {
                        com.alipay.sdk.app.statistic.a.a(this.f36077h, "biz", "BindRetry");
                        str3 = (String) a(str, str2, this.f36077h).first;
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(this.f36077h, "biz", "BindRetryEx", th);
                }
            }
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay bind result: " + str3);
            Activity activity = this.f36072c;
            com.alipay.sdk.sys.a aVar3 = this.f36077h;
            com.alipay.sdk.app.statistic.a.a(activity, aVar3, str, aVar3.q);
            if (f36070a.equals(str3)) {
                if (!com.alipay.sdk.data.a.p().c()) {
                    com.alipay.sdk.app.statistic.a.b(this.f36077h, "biz", "BSPNotStartByConfig", "");
                    return str3;
                } else if (k.f36098a.equals(str2) && i2 > 125) {
                    if (com.alipay.sdk.data.a.p().i() && (aVar = this.f36077h) != null && k.b(aVar.s) != 0) {
                        com.alipay.sdk.app.statistic.a.a(this.f36077h, "biz", "BSPNotStartByUsr");
                        return str3;
                    }
                    Activity activity2 = this.f36072c;
                    return (activity2 == null || !a(str2, activity2, this.f36077h)) ? f36071b : a(str, str2);
                } else {
                    com.alipay.sdk.sys.a aVar4 = this.f36077h;
                    com.alipay.sdk.app.statistic.a.b(aVar4, "biz", "BSPNotStartByPkg", str2 + "|" + i2);
                }
            }
            return str3;
        }
        return (String) invokeLLL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:40:0x01e8
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.lang.String a(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.alipay.sdk.util.e.$ic
            if (r0 != 0) goto L23b
        L4:
            r1 = r17
            r2 = r18
            java.lang.String r3 = "scheme_failed"
            java.lang.String r0 = "sc"
            java.lang.String r4 = ""
            java.util.concurrent.CountDownLatch r5 = new java.util.concurrent.CountDownLatch
            r6 = 1
            r5.<init>(r6)
            r7 = 32
            java.lang.String r7 = com.alipay.sdk.util.k.a(r7)
            long r8 = android.os.SystemClock.elapsedRealtime()
            com.alipay.sdk.sys.a r10 = r1.f36077h
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r7)
            java.lang.String r12 = "|"
            r11.append(r12)
            r11.append(r8)
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = "biz"
            java.lang.String r13 = "BSPStart"
            com.alipay.sdk.app.statistic.a.b(r10, r12, r13, r11)
            com.alipay.sdk.sys.a r10 = r1.f36077h
            com.alipay.sdk.sys.a.C1565a.a(r10, r7)
            com.alipay.sdk.util.e$1 r10 = new com.alipay.sdk.util.e$1
            r10.<init>(r1, r5)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.sdk.app.AlipayResultActivity$a> r11 = com.alipay.sdk.app.AlipayResultActivity.f35834a
            r11.put(r7, r10)
            java.lang.String r11 = "&"
            r13 = -1
            java.lang.String[] r11 = r2.split(r11, r13)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            int r13 = r11.length     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r15 = 0
        L54:
            r16 = 0
            if (r15 >= r13) goto Laa
            r10 = r11[r15]     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r14 = "bizcontext="
            boolean r14 = r10.startsWith(r14)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            if (r14 == 0) goto La6
            java.lang.String r11 = "{"
            int r11 = r10.indexOf(r11)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r13 = "}"
            int r13 = r10.lastIndexOf(r13)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            int r13 = r13 + r6
            java.lang.String r6 = r10.substring(r11, r13)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            int r11 = r10.indexOf(r6)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r14 = 0
            java.lang.String r13 = r10.substring(r14, r11)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            int r14 = r6.length()     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            int r11 = r11 + r14
            java.lang.String r11 = r10.substring(r11)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r14.<init>(r6)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r6 = r14.optString(r0)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r15 = "h5tonative"
            boolean r6 = r6.equals(r15)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            if (r6 == 0) goto L9e
            java.lang.String r6 = "h5tonative_scheme"
            r14.put(r0, r6)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            goto La3
        L9e:
            java.lang.String r6 = "h5tonative_sdkscheme"
            r14.put(r0, r6)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
        La3:
            r16 = r14
            goto Lae
        La6:
            r14 = 0
            int r15 = r15 + 1
            goto L54
        Laa:
            r11 = r4
            r13 = r11
            r10 = r16
        Lae:
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            if (r0 != 0) goto Le2
            int r0 = r2.indexOf(r10)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            int r6 = r2.lastIndexOf(r10)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            if (r0 != r6) goto Lda
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r0.<init>()     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r0.append(r13)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r6 = r16.toString()     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r0.append(r6)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r0.append(r11)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r0 = r2.replace(r10, r0)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            r2 = r0
            goto Lfe
        Lda:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r6 = "multi ctx_args"
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            throw r0     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
        Le2:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            java.lang.String r6 = "empty ctx_args"
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
            throw r0     // Catch: java.lang.Throwable -> Lea java.lang.Exception -> Led
        Lea:
            r0 = move-exception
            goto L21a
        Led:
            r0 = move-exception
            com.alipay.sdk.sys.a r6 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r10 = "BSPSCReplaceEx"
            byte[] r11 = r18.getBytes()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r13 = 2
            java.lang.String r11 = android.util.Base64.encodeToString(r11, r13)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.app.statistic.a.a(r6, r12, r10, r0, r11)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
        Lfe:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r0.<init>()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r6 = "sourcePid"
            int r10 = android.os.Binder.getCallingPid()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r0.put(r6, r10)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r6 = "external_info"
            r0.put(r6, r2)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r6 = "pkgName"
            android.app.Activity r10 = r1.f36072c     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r10 = r10.getPackageName()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r0.put(r6, r10)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r6 = "session"
            r0.put(r6, r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r6 = "UTF-8"
            byte[] r0 = r0.getBytes(r6)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r6 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r6)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            android.net.Uri$Builder r6 = new android.net.Uri$Builder     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r6.<init>()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "alipays"
            android.net.Uri$Builder r6 = r6.scheme(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "platformapi"
            android.net.Uri$Builder r6 = r6.authority(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "startapp"
            android.net.Uri$Builder r6 = r6.path(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "appId"
            java.lang.String r10 = "20000125"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r7, r10)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "mqpSchemePay"
            r6.appendQueryParameter(r7, r0)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.sys.a r0 = r1.f36077h     // Catch: java.lang.Throwable -> L172
            java.util.HashMap r0 = com.alipay.sdk.sys.a.a(r0)     // Catch: java.lang.Throwable -> L172
            java.lang.String r7 = "ts_scheme"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L172
            r0.put(r7, r8)     // Catch: java.lang.Throwable -> L172
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L172
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L172
            java.lang.String r0 = "mqpLoc"
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L172
            r6.appendQueryParameter(r0, r7)     // Catch: java.lang.Throwable -> L172
            goto L17a
        L172:
            r0 = move-exception
            com.alipay.sdk.sys.a r7 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r8 = "BSPLocEx"
            com.alipay.sdk.app.statistic.a.a(r7, r12, r8, r0)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
        L17a:
            android.net.Uri r0 = r6.build()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            android.content.Intent r6 = new android.content.Intent     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r6.<init>()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r7 = r19
            r6.setPackage(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r7 = 268435456(0x10000000, float:2.524355E-29)
            r6.addFlags(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            android.net.Uri r7 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r6.setData(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            android.app.Activity r7 = r1.f36072c     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.sys.a r8 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.sys.a r9 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r9 = r9.q     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.app.statistic.a.a(r7, r8, r2, r9)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            android.app.Activity r2 = r1.f36072c     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r2.startActivity(r6)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.data.a r2 = com.alipay.sdk.data.a.p()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.sys.a r6 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            android.app.Activity r7 = r1.f36072c     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r2.a(r6, r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r2 = "mspl"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r6.<init>()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "pay scheme waiting "
            r6.append(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r6.append(r0)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.util.c.b(r2, r0)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r5.await()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r2 = r1.f36078i     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r5 = "unknown"
            com.alipay.sdk.sys.a r0 = r1.f36077h     // Catch: java.lang.Throwable -> L1eb
            java.util.Map r0 = com.alipay.sdk.util.i.a(r0, r2)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r6 = "resultStatus"
            java.lang.Object r0 = r0.get(r6)     // Catch: java.lang.Throwable -> L1eb
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L1eb
            if (r6 != 0) goto L1f4
            java.lang.String r6 = "null"
            goto L1f4
        L1e8:
            r0 = move-exception
            r5 = r6
            goto L1ec
        L1eb:
            r0 = move-exception
        L1ec:
            com.alipay.sdk.sys.a r6 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "BSPStatEx"
            com.alipay.sdk.app.statistic.a.a(r6, r12, r7, r0)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r6 = r5
        L1f4:
            com.alipay.sdk.sys.a r0 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r5.<init>()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r7 = "BSPDone-"
            r5.append(r7)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            r5.append(r6)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            com.alipay.sdk.app.statistic.a.a(r0, r12, r5)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            if (r0 == 0) goto L218
            com.alipay.sdk.sys.a r0 = r1.f36077h     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            java.lang.String r2 = "BSPEmpty"
            com.alipay.sdk.app.statistic.a.a(r0, r12, r2)     // Catch: java.lang.Throwable -> Lea java.lang.InterruptedException -> L222
            goto L23a
        L218:
            r3 = r2
            goto L23a
        L21a:
            com.alipay.sdk.sys.a r2 = r1.f36077h
            java.lang.String r4 = "BSPEx"
            com.alipay.sdk.app.statistic.a.a(r2, r12, r4, r0)
            goto L23a
        L222:
            r0 = move-exception
            com.alipay.sdk.sys.a r2 = r1.f36077h
            java.lang.String r3 = "BSPWaiting"
            com.alipay.sdk.app.statistic.a.a(r2, r12, r3, r0)
            com.alipay.sdk.app.c r0 = com.alipay.sdk.app.c.f35903g
            int r0 = r0.a()
            com.alipay.sdk.app.c r2 = com.alipay.sdk.app.c.f35903g
            java.lang.String r2 = r2.b()
            java.lang.String r3 = com.alipay.sdk.app.b.a(r0, r2, r4)
        L23a:
            return r3
        L23b:
            r15 = r0
            r16 = 65541(0x10005, float:9.1843E-41)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r15.invokeLL(r16, r17, r18, r19)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.e.a(java.lang.String, java.lang.String):java.lang.String");
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
        b bVar;
        a aVar2;
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
        intent.setAction(k.a(str2));
        String a2 = k.a(this.f36072c, str2);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(elapsedRealtime);
        sb.append("|");
        sb.append(str != null ? str.length() : 0);
        com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.L, sb.toString());
        com.alipay.sdk.app.statistic.a.a(this.f36072c, aVar, str, aVar.q);
        try {
            if (!com.alipay.sdk.data.a.p().h()) {
                ComponentName startService = this.f36072c.getApplication().startService(intent);
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "stSrv", startService != null ? startService.getPackageName() : StringUtil.NULL_STRING);
            } else {
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "stSrv", "skipped");
            }
            if (com.alipay.sdk.data.a.p().k()) {
                i2 = 65;
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "bindFlg", "imp");
            } else {
                i2 = 1;
            }
            b bVar2 = new b();
            if (this.f36072c.getApplicationContext().bindService(intent, bVar2, i2)) {
                synchronized (this.f36074e) {
                    if (this.f36073d == null) {
                        try {
                            this.f36074e.wait(com.alipay.sdk.data.a.p().a());
                        } catch (InterruptedException e2) {
                            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.F, e2);
                        }
                    }
                }
                IAlixPay iAlixPay = this.f36073d;
                try {
                    if (iAlixPay == null) {
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.y, a2 + "|" + k.a(this.f36072c, str2));
                        Pair<String, Boolean> pair = new Pair<>(f36070a, Boolean.TRUE);
                        try {
                            this.f36072c.getApplicationContext().unbindService(bVar2);
                        } catch (Throwable th) {
                            com.alipay.sdk.util.c.a(th);
                        }
                        com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.N, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.app.statistic.a.a(this.f36072c, aVar, str, aVar.q);
                        this.f36073d = null;
                        if (this.f36075f && (activity4 = this.f36072c) != null) {
                            activity4.setRequestedOrientation(0);
                            this.f36075f = false;
                        }
                        return pair;
                    }
                    try {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.M, "" + elapsedRealtime2);
                        if (this.f36076g != null) {
                            this.f36076g.a();
                        }
                        if (this.f36072c.getRequestedOrientation() == 0) {
                            this.f36072c.setRequestedOrientation(1);
                            this.f36075f = true;
                        }
                        int version = iAlixPay.getVersion();
                        aVar2 = new a();
                        try {
                            if (version >= 3) {
                                iAlixPay.registerCallback03(aVar2, str, null);
                            } else {
                                iAlixPay.registerCallback(aVar2);
                            }
                            long elapsedRealtime3 = SystemClock.elapsedRealtime();
                            StringBuilder sb2 = new StringBuilder();
                            try {
                                sb2.append("");
                                sb2.append(elapsedRealtime3);
                                com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.O, sb2.toString());
                                if (version >= 3) {
                                    iAlixPay.r03("biz", "bind_pay", null);
                                }
                                if (version >= 2) {
                                    HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(aVar);
                                    a3.put("ts_bind", String.valueOf(elapsedRealtime));
                                    a3.put("ts_bend", String.valueOf(elapsedRealtime2));
                                    a3.put("ts_pay", String.valueOf(elapsedRealtime3));
                                    Pay = iAlixPay.pay02(str, a3);
                                } else {
                                    Pay = iAlixPay.Pay(str);
                                }
                                String str3 = Pay;
                                try {
                                    iAlixPay.unregisterCallback(aVar2);
                                } catch (Throwable th2) {
                                    com.alipay.sdk.util.c.a(th2);
                                }
                                try {
                                    this.f36072c.getApplicationContext().unbindService(bVar2);
                                } catch (Throwable th3) {
                                    com.alipay.sdk.util.c.a(th3);
                                }
                                com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.N, "" + SystemClock.elapsedRealtime());
                                com.alipay.sdk.app.statistic.a.a(this.f36072c, aVar, str, aVar.q);
                                this.f36073d = null;
                                if (this.f36075f && (activity3 = this.f36072c) != null) {
                                    activity3.setRequestedOrientation(0);
                                    this.f36075f = false;
                                }
                                return new Pair<>(str3, Boolean.FALSE);
                            } catch (Throwable th4) {
                                th = th4;
                                bVar = bVar2;
                                try {
                                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.y, th, "in_bind");
                                    Pair<String, Boolean> pair2 = new Pair<>(f36070a, Boolean.TRUE);
                                    if (aVar2 != null) {
                                        try {
                                            iAlixPay.unregisterCallback(aVar2);
                                        } catch (Throwable th5) {
                                            com.alipay.sdk.util.c.a(th5);
                                        }
                                    }
                                    try {
                                        this.f36072c.getApplicationContext().unbindService(bVar);
                                    } catch (Throwable th6) {
                                        com.alipay.sdk.util.c.a(th6);
                                    }
                                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.N, "" + SystemClock.elapsedRealtime());
                                    com.alipay.sdk.app.statistic.a.a(this.f36072c, aVar, str, aVar.q);
                                    this.f36073d = null;
                                    if (this.f36075f && (activity2 = this.f36072c) != null) {
                                        activity2.setRequestedOrientation(0);
                                        this.f36075f = false;
                                    }
                                    return pair2;
                                } catch (Throwable th7) {
                                    if (aVar2 != null) {
                                        try {
                                            iAlixPay.unregisterCallback(aVar2);
                                        } catch (Throwable th8) {
                                            com.alipay.sdk.util.c.a(th8);
                                        }
                                    }
                                    try {
                                        this.f36072c.getApplicationContext().unbindService(bVar);
                                    } catch (Throwable th9) {
                                        com.alipay.sdk.util.c.a(th9);
                                    }
                                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.N, "" + SystemClock.elapsedRealtime());
                                    com.alipay.sdk.app.statistic.a.a(this.f36072c, aVar, str, aVar.q);
                                    this.f36073d = null;
                                    if (this.f36075f && (activity = this.f36072c) != null) {
                                        activity.setRequestedOrientation(0);
                                        this.f36075f = false;
                                    }
                                    throw th7;
                                }
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            bVar = bVar2;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        bVar = bVar2;
                        aVar2 = null;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    bVar = bVar2;
                    aVar2 = null;
                }
            } else {
                throw new Throwable("bindService fail");
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f36072c = null;
            this.f36076g = null;
        }
    }
}
