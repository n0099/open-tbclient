package com.baidu.crabsdk.lite.sender;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.crabsdk.lite.a.n;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f4749g = false;

    /* renamed from: h  reason: collision with root package name */
    public static final String f4750h = Environment.getExternalStorageDirectory().getPath() + File.separator + n.c() + File.separator + "oom_lite" + File.separator;
    public static a i = new a();

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4751e = null;

    /* renamed from: f  reason: collision with root package name */
    public Context f4752f = null;

    public static boolean a(Throwable th) {
        while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public static a c() {
        return i;
    }

    public final void b(Context context) {
        if (this.f4751e == null) {
            this.f4751e = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.f4752f == null) {
            this.f4752f = context.getApplicationContext();
        }
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Can't wrap try/catch for region: R(13:5|(2:11|(2:12|(2:14|(2:16|17))(1:18)))(0)|(1:22)|23|(10:27|28|(1:30)(1:98)|(1:34)|35|36|37|(5:41|(1:88)(1:45)|(4:49|50|(3:52|(1:54)(1:56)|55)|57)|61|(6:67|(1:73)|74|75|(2:76|(2:84|85)(2:78|(2:80|81)))|82))|89|(2:91|92)(1:93))|100|(2:32|34)|35|36|37|(7:39|41|(1:43)|88|(5:47|49|50|(0)|57)|61|(8:63|65|67|(2:71|73)|74|75|(3:76|(0)(0)|79)|82))|89|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
        com.baidu.crabsdk.lite.b.a.e(r2, "pw", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9 A[Catch: all -> 0x012e, TryCatch #3 {all -> 0x012e, blocks: (B:54:0x00cc, B:56:0x00d9, B:58:0x00df, B:59:0x00ed, B:60:0x00f1, B:61:0x0100), top: B:101:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019f A[Catch: Exception -> 0x01a9, TryCatch #1 {Exception -> 0x01a9, blocks: (B:79:0x017b, B:80:0x017f, B:82:0x0187, B:83:0x019b, B:84:0x019f), top: B:97:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b5  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void uncaughtException(java.lang.Thread r9, java.lang.Throwable r10) {
        /*
            r8 = this;
            boolean r0 = com.baidu.crabsdk.lite.a.k
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            com.baidu.crabsdk.lite.a.k = r0
            java.lang.String r1 = android.util.Log.getStackTraceString(r10)
            r2 = 0
            if (r1 == 0) goto L35
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r3 = com.baidu.crabsdk.lite.a.f4714a
            java.util.Set r3 = r3.keySet()
            if (r3 == 0) goto L35
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L1e
            goto L35
        L1e:
            java.util.Iterator r3 = r3.iterator()
        L22:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L35
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r1.contains(r4)
            if (r5 == 0) goto L22
            r2 = r4
        L35:
            if (r2 != 0) goto L44
            java.lang.Thread$UncaughtExceptionHandler r1 = r8.f4751e
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L44
            java.lang.Thread$UncaughtExceptionHandler r1 = r8.f4751e
            r1.uncaughtException(r9, r10)
        L44:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "SDK包名匹配成功："
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.crabsdk.lite.b.a.c(r2, r1)
            java.lang.String r1 = r10.toString()
            r3 = 0
            java.lang.String r4 = ""
            if (r1 == 0) goto L75
            boolean r5 = r1.equals(r4)
            if (r5 != 0) goto L75
            java.lang.String r5 = ":"
            java.lang.String[] r5 = r1.split(r5)     // Catch: java.lang.Exception -> L75
            int r6 = r1.length()     // Catch: java.lang.Exception -> L75
            if (r6 <= r0) goto L73
            r0 = r5[r3]     // Catch: java.lang.Exception -> L75
            goto L76
        L73:
            r0 = r1
            goto L76
        L75:
            r0 = r4
        L76:
            if (r0 == 0) goto L80
            boolean r5 = r0.equals(r4)
            if (r5 == 0) goto L7f
            goto L80
        L7f:
            r1 = r0
        L80:
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            java.io.PrintWriter r5 = new java.io.PrintWriter
            r5.<init>(r0)
            r10.printStackTrace(r5)
            java.lang.String r6 = r0.toString()
            r5.close()     // Catch: java.io.IOException -> L98
            r0.close()     // Catch: java.io.IOException -> L98
            goto L9e
        L98:
            r0 = move-exception
            java.lang.String r5 = "pw"
            com.baidu.crabsdk.lite.b.a.e(r2, r5, r0)
        L9e:
            if (r6 == 0) goto L1ad
            java.lang.String r0 = r1.trim()
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L1ad
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r0 = com.baidu.crabsdk.lite.a.f4714a
            java.lang.Object r0 = r0.get(r2)
            java.util.HashMap r0 = (java.util.HashMap) r0
            if (r0 == 0) goto Lc3
            java.lang.String r1 = "sdk_debug"
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto Lc3
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto Lc4
        Lc3:
            r0 = 0
        Lc4:
            if (r0 == 0) goto L144
            boolean r0 = a(r10)
            if (r0 == 0) goto L144
            java.lang.String r0 = com.baidu.crabsdk.lite.sender.a.f4750h     // Catch: java.lang.Throwable -> L12e
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L12e
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L12e
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> L12e
            if (r4 != 0) goto L100
            boolean r1 = r1.mkdirs()     // Catch: java.lang.Throwable -> L12e
            if (r1 != 0) goto Lf1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12e
            java.lang.String r4 = "app文件创建失败  fileName is "
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L12e
            r1.append(r0)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L12e
        Led:
            com.baidu.crabsdk.lite.b.a.d(r2, r1)     // Catch: java.lang.Throwable -> L12e
            goto L100
        Lf1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12e
            java.lang.String r4 = "app文件创建ok  fileName is "
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L12e
            r1.append(r0)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L12e
            goto Led
        L100:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12e
            r1.<init>()     // Catch: java.lang.Throwable -> L12e
            r1.append(r0)     // Catch: java.lang.Throwable -> L12e
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L12e
            r1.append(r4)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r0 = ".hprof"
            r1.append(r0)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L12e
            android.os.Debug.dumpHprofData(r0)     // Catch: java.lang.Throwable -> L12e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12e
            java.lang.String r4 = "输出OOM的dump信息 name="
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L12e
            r1.append(r0)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L12e
            com.baidu.crabsdk.lite.b.a.c(r2, r0)     // Catch: java.lang.Throwable -> L12e
            goto L144
        L12e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "oom save fail"
            r1.<init>(r4)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.baidu.crabsdk.lite.b.a.d(r2, r0)
        L144:
            boolean r0 = com.baidu.crabsdk.lite.sender.c.p(r2)
            if (r0 == 0) goto L1ad
            boolean r0 = com.baidu.crabsdk.lite.sender.c.b(r2)
            if (r0 == 0) goto L1ad
            boolean r0 = com.baidu.crabsdk.lite.sender.c.h(r2, r10)
            if (r0 == 0) goto L1ad
            com.baidu.crabsdk.lite.sender.a.f4749g = r3
            android.content.Context r0 = r8.f4752f
            if (r0 == 0) goto L17b
            if (r9 == 0) goto L17b
            if (r10 != 0) goto L161
            goto L17b
        L161:
            java.util.Map r0 = com.baidu.crabsdk.lite.sender.b.b(r2, r0, r10)
            if (r0 == 0) goto L17b
            java.lang.String r0 = com.baidu.crabsdk.lite.sender.d.b(r2, r0)
            android.content.Context r1 = r8.f4752f
            com.baidu.crabsdk.lite.sender.d.e(r2, r1, r0)
            com.baidu.crabsdk.lite.sender.c.k(r2, r10)
            com.baidu.crabsdk.lite.sender.c.c(r2)
            android.content.Context r0 = r8.f4752f
            com.baidu.crabsdk.lite.sender.e.c(r2, r0)
        L17b:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L1a9
        L17f:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L1a9
            boolean r5 = com.baidu.crabsdk.lite.sender.a.f4749g     // Catch: java.lang.Exception -> L1a9
            if (r5 == 0) goto L19f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1a9
            java.lang.String r6 = "^^ upload finished()! --> cost : "
            r5.<init>(r6)     // Catch: java.lang.Exception -> L1a9
            long r3 = r3 - r0
            r5.append(r3)     // Catch: java.lang.Exception -> L1a9
            java.lang.String r0 = "ms"
            r5.append(r0)     // Catch: java.lang.Exception -> L1a9
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L1a9
        L19b:
            com.baidu.crabsdk.lite.b.a.c(r2, r0)     // Catch: java.lang.Exception -> L1a9
            goto L1ad
        L19f:
            long r3 = r3 - r0
            r5 = 2500(0x9c4, double:1.235E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L17f
            java.lang.String r0 = "T^T upload timeout!"
            goto L19b
        L1a9:
            r0 = move-exception
            r0.printStackTrace()
        L1ad:
            java.lang.Thread$UncaughtExceptionHandler r0 = r8.f4751e
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L1ba
            java.lang.Thread$UncaughtExceptionHandler r0 = r8.f4751e
            r0.uncaughtException(r9, r10)
        L1ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crabsdk.lite.sender.a.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
