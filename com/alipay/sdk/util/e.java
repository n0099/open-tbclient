package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1967a = "failed";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1968b = "scheme_failed";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Activity f1969c;

    /* renamed from: d  reason: collision with root package name */
    public IAlixPay f1970d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1971e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1972f;

    /* renamed from: g  reason: collision with root package name */
    public a f1973g;

    /* renamed from: h  reason: collision with root package name */
    public ServiceConnection f1974h;

    /* renamed from: i  reason: collision with root package name */
    public String f1975i;
    public IRemoteServiceCallback j;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public e(Activity activity, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1971e = IAlixPay.class;
        this.f1974h = new f(this);
        this.f1975i = null;
        this.j = new h(this);
        this.f1969c = activity;
        this.f1973g = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:5:0x0007, B:9:0x001b, B:12:0x0025, B:14:0x002b, B:17:0x0032, B:20:0x003b, B:22:0x003f, B:25:0x004c, B:27:0x0055, B:29:0x0059, B:30:0x005d, B:26:0x0051, B:8:0x0019), top: B:41:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        InterceptResult invokeL;
        n.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = "";
            try {
                List<a.C0016a> f2 = com.alipay.sdk.data.a.g().f();
                if (!com.alipay.sdk.data.a.g().q || f2 == null) {
                    f2 = com.alipay.sdk.app.i.f1804a;
                }
                a2 = n.a(this.f1969c, f2);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.F, th);
            }
            if (a2 == null || a2.a() || a2.b() || n.a(a2.f2001a)) {
                return f1967a;
            }
            if (a2.f2001a != null && !n.f1995a.equals(a2.f2001a.packageName)) {
                str2 = a2.f2001a.packageName;
                r1 = a2.f2001a != null ? a2.f2001a.versionCode : 0;
                a(a2);
                return a(str, str2, r1);
            }
            str2 = n.a();
            if (a2.f2001a != null) {
            }
            a(a2);
            return a(str, str2, r1);
        }
        return (String) invokeL.objValue;
    }

    private void a(n.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar) == null) || aVar == null || (packageInfo = aVar.f2001a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f1969c.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.J, th);
        }
        Thread.sleep(200L);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:52:0x01a2
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.lang.String a(java.lang.String r17, java.lang.String r18, int r19) {
        /*
            r16 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.alipay.sdk.util.e.$ic
            if (r0 != 0) goto L1ec
        L4:
            r1 = r16
            r2 = r17
            r3 = r18
            r0 = r19
            java.lang.String r4 = "sc"
            java.lang.String r5 = r16.a(r17, r18)
            com.alipay.sdk.data.a r6 = com.alipay.sdk.data.a.g()
            boolean r6 = r6.b()
            java.lang.String r7 = "failed"
            boolean r8 = r7.equals(r5)
            r9 = 125(0x7d, float:1.75E-43)
            java.lang.String r10 = "com.eg.android.AlipayGphone"
            java.lang.String r11 = ""
            java.lang.String r12 = "biz"
            if (r8 == 0) goto L39
            boolean r8 = r10.equals(r3)
            if (r8 == 0) goto L39
            if (r0 <= r9) goto L39
            if (r6 != 0) goto L39
            java.lang.String r8 = "BSPNotStartByConfig"
            com.alipay.sdk.app.statistic.a.a(r12, r8, r11)
        L39:
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L1eb
            boolean r7 = r10.equals(r3)
            if (r7 == 0) goto L1eb
            if (r0 <= r9) goto L1eb
            if (r6 == 0) goto L1eb
            android.app.Activity r0 = r1.f1969c
            java.lang.String r5 = "scheme_failed"
            if (r0 == 0) goto L1eb
            boolean r0 = a(r3, r0)
            if (r0 != 0) goto L57
            goto L1eb
        L57:
            java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch
            r0 = 1
            r6.<init>(r0)
            r7 = 32
            java.lang.String r7 = com.alipay.sdk.util.n.a(r7)
            java.lang.String r8 = "BSPStart"
            com.alipay.sdk.app.statistic.a.a(r12, r8, r7)
            com.alipay.sdk.util.g r8 = new com.alipay.sdk.util.g
            r8.<init>(r1, r6)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.sdk.app.AlipayResultActivity$a> r9 = com.alipay.sdk.app.AlipayResultActivity.f1750a
            r9.put(r7, r8)
            java.lang.String r9 = "&"
            r10 = -1
            java.lang.String[] r9 = r2.split(r9, r10)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            int r10 = r9.length     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            r13 = 0
            r14 = 0
        L7c:
            r15 = 0
            if (r14 >= r10) goto Lcb
            r15 = r9[r14]     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r8 = "bizcontext="
            boolean r8 = r15.startsWith(r8)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            if (r8 == 0) goto Lc8
            java.lang.String r8 = "{"
            int r8 = r15.indexOf(r8)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r9 = "}"
            int r9 = r15.lastIndexOf(r9)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            int r9 = r9 + r0
            java.lang.String r0 = r15.substring(r8, r9)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            int r8 = r15.indexOf(r0)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r9 = r15.substring(r13, r8)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            int r10 = r0.length()     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            int r8 = r8 + r10
            java.lang.String r8 = r15.substring(r8)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r0 = r10.optString(r4)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r13 = "h5tonative"
            boolean r0 = r0.equals(r13)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            if (r0 == 0) goto Lc2
            java.lang.String r0 = "h5tonative_scheme"
            r10.put(r4, r0)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            goto Lce
        Lc2:
            java.lang.String r0 = "h5tonative_sdkscheme"
            r10.put(r4, r0)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            goto Lce
        Lc8:
            int r14 = r14 + 1
            goto L7c
        Lcb:
            r8 = r11
            r9 = r8
            r10 = r15
        Lce:
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            if (r0 != 0) goto L101
            int r0 = r2.indexOf(r15)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            int r4 = r2.lastIndexOf(r15)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            if (r0 != r4) goto Lf9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            r0.<init>()     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            r0.append(r9)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r4 = r10.toString()     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            r0.append(r4)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            r0.append(r8)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r0 = r2.replace(r15, r0)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            goto L11c
        Lf9:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r4 = "multi ctx_args"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            throw r0     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
        L101:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            java.lang.String r4 = "empty ctx_args"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            throw r0     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
        L109:
            r0 = move-exception
            goto L1d0
        L10c:
            r0 = move-exception
            java.lang.String r4 = "BSPSCReplaceEx"
            byte[] r8 = r17.getBytes()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r9 = 2
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r9)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            com.alipay.sdk.app.statistic.a.a(r12, r4, r0, r8)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r0 = r2
        L11c:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.<init>()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r4 = "sourcePid"
            int r8 = android.os.Binder.getCallingPid()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.put(r4, r8)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r4 = "external_info"
            r2.put(r4, r0)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r0 = "pkgName"
            android.app.Activity r4 = r1.f1969c     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.put(r0, r4)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r0 = "session"
            r2.put(r0, r7)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r2 = "UTF-8"
            byte[] r0 = r0.getBytes(r2)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.<init>()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r4 = "alipays://platformapi/startapp?appId=20000125&mqpSchemePay="
            r2.append(r4)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r0 = android.net.Uri.encode(r0)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.append(r0)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.<init>()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.setPackage(r3)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r3 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r3)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r2.setData(r0)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            android.app.Activity r0 = r1.f1969c     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r0.startActivity(r2)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            com.alipay.sdk.data.a r0 = com.alipay.sdk.data.a.g()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            android.app.Activity r2 = r1.f1969c     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r0.a(r2)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r6.await()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r2 = r1.f1975i     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r3 = "unknown"
            java.util.Map r0 = com.alipay.sdk.util.l.a(r2)     // Catch: java.lang.Throwable -> L1a5
            java.lang.String r4 = "resultStatus"
            java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.Throwable -> L1a5
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L1a5
            if (r4 != 0) goto L1ac
            java.lang.String r4 = "null"
            goto L1ac
        L1a2:
            r0 = move-exception
            r3 = r4
            goto L1a6
        L1a5:
            r0 = move-exception
        L1a6:
            java.lang.String r4 = "BSPStatEx"
            com.alipay.sdk.app.statistic.a.a(r12, r4, r0)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r4 = r3
        L1ac:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r0.<init>()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r3 = "BSPDone-"
            r0.append(r3)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            r0.append(r4)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            com.alipay.sdk.app.statistic.a.a(r12, r0, r11)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            if (r0 == 0) goto L1cc
            java.lang.String r0 = "BSPEmpty"
            com.alipay.sdk.app.statistic.a.a(r12, r0, r11)     // Catch: java.lang.Throwable -> L109 java.lang.InterruptedException -> L1ce
            goto L1eb
        L1cc:
            r5 = r2
            goto L1eb
        L1ce:
            r0 = move-exception
            goto L1d6
        L1d0:
            java.lang.String r2 = "BSPEx"
            com.alipay.sdk.app.statistic.a.a(r12, r2, r0)
            goto L1eb
        L1d6:
            java.lang.String r2 = "BSPWaiting"
            com.alipay.sdk.app.statistic.a.a(r12, r2, r0)
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.f1816g
            int r0 = r0.a()
            com.alipay.sdk.app.k r2 = com.alipay.sdk.app.k.f1816g
            java.lang.String r2 = r2.b()
            java.lang.String r5 = com.alipay.sdk.app.j.a(r0, r2, r11)
        L1eb:
            return r5
        L1ec:
            r14 = r0
            r15 = 65541(0x10005, float:9.1843E-41)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r14.invokeLLI(r15, r16, r17, r18, r19)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.e.a(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public static boolean a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, context)) == null) {
            try {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
                if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                    com.alipay.sdk.app.statistic.a.a("biz", "BSPDetectFail", "");
                    return false;
                }
                return true;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a("biz", "BSPDetectFail", th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f1, code lost:
        if (r9 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f3, code lost:
        r9.setRequestedOrientation(0);
        r7.f1972f = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012f, code lost:
        if (r9 != null) goto L51;
     */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.alipay.android.app.IAlixPay, android.content.ServiceConnection, com.alipay.sdk.util.e$a, com.alipay.android.app.IRemoteServiceCallback] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Activity activity;
        String c2;
        Activity activity2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.setAction(n.a(str2));
            String a2 = n.a(this.f1969c, str2);
            try {
                if (this.f1969c.getApplicationContext().bindService(intent, this.f1974h, 1)) {
                    synchronized (this.f1971e) {
                        if (this.f1970d == null) {
                            try {
                                this.f1971e.wait(com.alipay.sdk.data.a.g().a());
                            } catch (InterruptedException e2) {
                                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.D, e2);
                            }
                        }
                    }
                    try {
                    } catch (Throwable th) {
                        try {
                            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.A, th);
                            c2 = com.alipay.sdk.app.j.c();
                            try {
                                this.f1970d.unregisterCallback(this.j);
                            } catch (Throwable th2) {
                                c.a(th2);
                            }
                            try {
                                this.f1969c.getApplicationContext().unbindService(this.f1974h);
                            } catch (Throwable th3) {
                                c.a(th3);
                            }
                            this.f1973g = null;
                            this.j = null;
                            this.f1974h = null;
                            this.f1970d = null;
                            if (this.f1972f) {
                                activity2 = this.f1969c;
                            }
                        } finally {
                            try {
                                this.f1970d.unregisterCallback(this.j);
                            } catch (Throwable th4) {
                                c.a(th4);
                            }
                            try {
                                this.f1969c.getApplicationContext().unbindService(this.f1974h);
                            } catch (Throwable th5) {
                                c.a(th5);
                            }
                            this.f1973g = null;
                            this.j = null;
                            this.f1974h = null;
                            this.f1970d = null;
                            if (this.f1972f && (activity = this.f1969c) != null) {
                                activity.setRequestedOrientation(0);
                                this.f1972f = false;
                            }
                        }
                    }
                    if (this.f1970d == null) {
                        String a3 = n.a(this.f1969c, str2);
                        com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.x, a2 + "|" + a3);
                        return f1967a;
                    }
                    if (this.f1973g != null) {
                        this.f1973g.a();
                    }
                    if (this.f1969c.getRequestedOrientation() == 0) {
                        this.f1969c.setRequestedOrientation(1);
                        this.f1972f = true;
                    }
                    this.f1970d.registerCallback(this.j);
                    c2 = this.f1970d.Pay(str);
                    try {
                        this.f1970d.unregisterCallback(this.j);
                    } catch (Throwable th6) {
                        c.a(th6);
                    }
                    try {
                        this.f1969c.getApplicationContext().unbindService(this.f1974h);
                    } catch (Throwable th7) {
                        c.a(th7);
                    }
                    this.f1973g = null;
                    this.j = null;
                    this.f1974h = null;
                    this.f1970d = null;
                    if (this.f1972f) {
                        activity2 = this.f1969c;
                    }
                    return c2;
                }
                throw new Throwable("bindService fail");
            } catch (Throwable th8) {
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.C, th8);
                return f1967a;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1969c = null;
        }
    }
}
