package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.n;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1950a = "failed";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1951b = "scheme_failed";

    /* renamed from: c  reason: collision with root package name */
    public Activity f1952c;

    /* renamed from: d  reason: collision with root package name */
    public IAlixPay f1953d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1955f;

    /* renamed from: g  reason: collision with root package name */
    public a f1956g;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1954e = IAlixPay.class;

    /* renamed from: h  reason: collision with root package name */
    public ServiceConnection f1957h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public String f1958i = null;
    public IRemoteServiceCallback j = new h(this);

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public e(Activity activity, a aVar) {
        this.f1952c = activity;
        this.f1956g = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:3:0x0003, B:7:0x0017, B:10:0x0021, B:12:0x0027, B:15:0x002e, B:18:0x0037, B:20:0x003b, B:23:0x0048, B:25:0x0051, B:27:0x0055, B:28:0x0059, B:24:0x004d, B:6:0x0015), top: B:35:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        n.a a2;
        String str2 = "";
        try {
            List<a.C0015a> f2 = com.alipay.sdk.data.a.g().f();
            if (!com.alipay.sdk.data.a.g().q || f2 == null) {
                f2 = com.alipay.sdk.app.i.f1787a;
            }
            a2 = n.a(this.f1952c, f2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.F, th);
        }
        if (a2 == null || a2.a() || a2.b() || n.a(a2.f1984a)) {
            return f1950a;
        }
        if (a2.f1984a != null && !n.f1978a.equals(a2.f1984a.packageName)) {
            str2 = a2.f1984a.packageName;
            r1 = a2.f1984a != null ? a2.f1984a.versionCode : 0;
            a(a2);
            return a(str, str2, r1);
        }
        str2 = n.a();
        if (a2.f1984a != null) {
        }
        a(a2);
        return a(str, str2, r1);
    }

    private void a(n.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (aVar == null || (packageInfo = aVar.f1984a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f1952c.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.J, th);
        }
        Thread.sleep(200L);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:50:0x019e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.lang.String a(java.lang.String r17, java.lang.String r18, int r19) {
        /*
            r16 = this;
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
            if (r8 == 0) goto L35
            boolean r8 = r10.equals(r3)
            if (r8 == 0) goto L35
            if (r0 <= r9) goto L35
            if (r6 != 0) goto L35
            java.lang.String r8 = "BSPNotStartByConfig"
            com.alipay.sdk.app.statistic.a.a(r12, r8, r11)
        L35:
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L1e7
            boolean r7 = r10.equals(r3)
            if (r7 == 0) goto L1e7
            if (r0 <= r9) goto L1e7
            if (r6 == 0) goto L1e7
            android.app.Activity r0 = r1.f1952c
            java.lang.String r5 = "scheme_failed"
            if (r0 == 0) goto L1e7
            boolean r0 = a(r3, r0)
            if (r0 != 0) goto L53
            goto L1e7
        L53:
            java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch
            r0 = 1
            r6.<init>(r0)
            r7 = 32
            java.lang.String r7 = com.alipay.sdk.util.n.a(r7)
            java.lang.String r8 = "BSPStart"
            com.alipay.sdk.app.statistic.a.a(r12, r8, r7)
            com.alipay.sdk.util.g r8 = new com.alipay.sdk.util.g
            r8.<init>(r1, r6)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.sdk.app.AlipayResultActivity$a> r9 = com.alipay.sdk.app.AlipayResultActivity.f1733a
            r9.put(r7, r8)
            java.lang.String r9 = "&"
            r10 = -1
            java.lang.String[] r9 = r2.split(r9, r10)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            int r10 = r9.length     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            r13 = 0
            r14 = 0
        L78:
            r15 = 0
            if (r14 >= r10) goto Lc7
            r15 = r9[r14]     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r8 = "bizcontext="
            boolean r8 = r15.startsWith(r8)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            if (r8 == 0) goto Lc4
            java.lang.String r8 = "{"
            int r8 = r15.indexOf(r8)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r9 = "}"
            int r9 = r15.lastIndexOf(r9)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            int r9 = r9 + r0
            java.lang.String r0 = r15.substring(r8, r9)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            int r8 = r15.indexOf(r0)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r9 = r15.substring(r13, r8)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            int r10 = r0.length()     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            int r8 = r8 + r10
            java.lang.String r8 = r15.substring(r8)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r0 = r10.optString(r4)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r13 = "h5tonative"
            boolean r0 = r0.equals(r13)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            if (r0 == 0) goto Lbe
            java.lang.String r0 = "h5tonative_scheme"
            r10.put(r4, r0)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            goto Lca
        Lbe:
            java.lang.String r0 = "h5tonative_sdkscheme"
            r10.put(r4, r0)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            goto Lca
        Lc4:
            int r14 = r14 + 1
            goto L78
        Lc7:
            r8 = r11
            r9 = r8
            r10 = r15
        Lca:
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            if (r0 != 0) goto Lfd
            int r0 = r2.indexOf(r15)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            int r4 = r2.lastIndexOf(r15)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            if (r0 != r4) goto Lf5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            r0.<init>()     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            r0.append(r9)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r4 = r10.toString()     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            r0.append(r4)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            r0.append(r8)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r0 = r2.replace(r15, r0)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            goto L118
        Lf5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r4 = "multi ctx_args"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            throw r0     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
        Lfd:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            java.lang.String r4 = "empty ctx_args"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
            throw r0     // Catch: java.lang.Throwable -> L105 java.lang.Exception -> L108
        L105:
            r0 = move-exception
            goto L1cc
        L108:
            r0 = move-exception
            java.lang.String r4 = "BSPSCReplaceEx"
            byte[] r8 = r17.getBytes()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r9 = 2
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r9)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            com.alipay.sdk.app.statistic.a.a(r12, r4, r0, r8)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r0 = r2
        L118:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.<init>()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r4 = "sourcePid"
            int r8 = android.os.Binder.getCallingPid()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.put(r4, r8)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r4 = "external_info"
            r2.put(r4, r0)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r0 = "pkgName"
            android.app.Activity r4 = r1.f1952c     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.put(r0, r4)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r0 = "session"
            r2.put(r0, r7)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r2 = "UTF-8"
            byte[] r0 = r0.getBytes(r2)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.<init>()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r4 = "alipays://platformapi/startapp?appId=20000125&mqpSchemePay="
            r2.append(r4)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r0 = android.net.Uri.encode(r0)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.append(r0)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.<init>()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.setPackage(r3)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r3 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r3)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r2.setData(r0)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            android.app.Activity r0 = r1.f1952c     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r0.startActivity(r2)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            com.alipay.sdk.data.a r0 = com.alipay.sdk.data.a.g()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            android.app.Activity r2 = r1.f1952c     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r0.a(r2)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r6.await()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r2 = r1.f1958i     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r3 = "unknown"
            java.util.Map r0 = com.alipay.sdk.util.l.a(r2)     // Catch: java.lang.Throwable -> L1a1
            java.lang.String r4 = "resultStatus"
            java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.Throwable -> L1a1
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L1a1
            if (r4 != 0) goto L1a8
            java.lang.String r4 = "null"
            goto L1a8
        L19e:
            r0 = move-exception
            r3 = r4
            goto L1a2
        L1a1:
            r0 = move-exception
        L1a2:
            java.lang.String r4 = "BSPStatEx"
            com.alipay.sdk.app.statistic.a.a(r12, r4, r0)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r4 = r3
        L1a8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r0.<init>()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r3 = "BSPDone-"
            r0.append(r3)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            r0.append(r4)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            com.alipay.sdk.app.statistic.a.a(r12, r0, r11)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            if (r0 == 0) goto L1c8
            java.lang.String r0 = "BSPEmpty"
            com.alipay.sdk.app.statistic.a.a(r12, r0, r11)     // Catch: java.lang.Throwable -> L105 java.lang.InterruptedException -> L1ca
            goto L1e7
        L1c8:
            r5 = r2
            goto L1e7
        L1ca:
            r0 = move-exception
            goto L1d2
        L1cc:
            java.lang.String r2 = "BSPEx"
            com.alipay.sdk.app.statistic.a.a(r12, r2, r0)
            goto L1e7
        L1d2:
            java.lang.String r2 = "BSPWaiting"
            com.alipay.sdk.app.statistic.a.a(r12, r2, r0)
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.PAY_WAITTING
            int r0 = r0.a()
            com.alipay.sdk.app.k r2 = com.alipay.sdk.app.k.PAY_WAITTING
            java.lang.String r2 = r2.b()
            java.lang.String r5 = com.alipay.sdk.app.j.a(r0, r2, r11)
        L1e7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.e.a(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public static boolean a(String str, Context context) {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IF, IPUT, IPUT, IPUT, IPUT, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ed, code lost:
        if (r9 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ef, code lost:
        r9.setRequestedOrientation(0);
        r7.f1955f = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
        if (r9 != null) goto L49;
     */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.alipay.android.app.IAlixPay, android.content.ServiceConnection, com.alipay.sdk.util.e$a, com.alipay.android.app.IRemoteServiceCallback] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, String str2) {
        Activity activity;
        String c2;
        Activity activity2;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(n.a(str2));
        String a2 = n.a(this.f1952c, str2);
        try {
            if (this.f1952c.getApplicationContext().bindService(intent, this.f1957h, 1)) {
                synchronized (this.f1954e) {
                    if (this.f1953d == null) {
                        try {
                            this.f1954e.wait(com.alipay.sdk.data.a.g().a());
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
                            this.f1953d.unregisterCallback(this.j);
                        } catch (Throwable th2) {
                            c.a(th2);
                        }
                        try {
                            this.f1952c.getApplicationContext().unbindService(this.f1957h);
                        } catch (Throwable th3) {
                            c.a(th3);
                        }
                        this.f1956g = null;
                        this.j = null;
                        this.f1957h = null;
                        this.f1953d = null;
                        if (this.f1955f) {
                            activity2 = this.f1952c;
                        }
                    } finally {
                        try {
                            this.f1953d.unregisterCallback(this.j);
                        } catch (Throwable th4) {
                            c.a(th4);
                        }
                        try {
                            this.f1952c.getApplicationContext().unbindService(this.f1957h);
                        } catch (Throwable th5) {
                            c.a(th5);
                        }
                        this.f1956g = null;
                        this.j = null;
                        this.f1957h = null;
                        this.f1953d = null;
                        if (this.f1955f && (activity = this.f1952c) != null) {
                            activity.setRequestedOrientation(0);
                            this.f1955f = false;
                        }
                    }
                }
                if (this.f1953d == null) {
                    String a3 = n.a(this.f1952c, str2);
                    com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.x, a2 + FieldBuilder.SE + a3);
                    return f1950a;
                }
                if (this.f1956g != null) {
                    this.f1956g.a();
                }
                if (this.f1952c.getRequestedOrientation() == 0) {
                    this.f1952c.setRequestedOrientation(1);
                    this.f1955f = true;
                }
                this.f1953d.registerCallback(this.j);
                c2 = this.f1953d.Pay(str);
                try {
                    this.f1953d.unregisterCallback(this.j);
                } catch (Throwable th6) {
                    c.a(th6);
                }
                try {
                    this.f1952c.getApplicationContext().unbindService(this.f1957h);
                } catch (Throwable th7) {
                    c.a(th7);
                }
                this.f1956g = null;
                this.j = null;
                this.f1957h = null;
                this.f1953d = null;
                if (this.f1955f) {
                    activity2 = this.f1952c;
                }
                return c2;
            }
            throw new Throwable("bindService fail");
        } catch (Throwable th8) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.C, th8);
            return f1950a;
        }
    }

    public void a() {
        this.f1952c = null;
    }
}
