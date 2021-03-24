package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.crabsdk.OnAnrCrashListener;
import com.baidu.crabsdk.b.p;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes2.dex */
public final class f implements Thread.UncaughtExceptionHandler {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f4765g = false;

    /* renamed from: h  reason: collision with root package name */
    public static final String f4766h = Environment.getExternalStorageDirectory().getPath() + File.separator + p.b() + File.separator + "oom" + File.separator;
    public static f i = new f();

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4767e = null;

    /* renamed from: f  reason: collision with root package name */
    public Context f4768f = null;

    public static f a() {
        return i;
    }

    public static boolean b(Throwable th) {
        while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public final void c(Context context) {
        if (this.f4767e == null) {
            this.f4767e = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.f4768f == null) {
            this.f4768f = context.getApplicationContext();
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
    /* JADX WARN: Can't wrap try/catch for region: R(12:5|(1:7)|8|(10:12|13|(1:15)(1:76)|(1:19)|20|21|22|(4:26|(4:30|31|(3:33|(1:35)(1:37)|36)|38)|42|(6:48|(1:52)|53|54|(2:55|(2:63|64)(2:57|(2:59|60)))|61))|67|(2:69|70)(1:71))|78|(2:17|19)|20|21|22|(5:24|26|(5:28|30|31|(0)|38)|42|(8:44|46|48|(1:52)|53|54|(3:55|(0)(0)|58)|61))|67|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        com.baidu.crabsdk.c.a.a("pw", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:35:0x006e, B:37:0x007b, B:39:0x0081, B:40:0x008f, B:41:0x0093, B:42:0x00a2), top: B:74:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0142 A[Catch: Exception -> 0x014c, TryCatch #2 {Exception -> 0x014c, blocks: (B:58:0x011e, B:59:0x0122, B:61:0x012a, B:62:0x013e, B:63:0x0142), top: B:78:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void uncaughtException(java.lang.Thread r8, java.lang.Throwable r9) {
        /*
            r7 = this;
            boolean r0 = com.baidu.crabsdk.a.J
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            com.baidu.crabsdk.a.J = r0
            com.baidu.crabsdk.OnAnrCrashListener r1 = com.baidu.crabsdk.a.P
            if (r1 == 0) goto Lf
            r1.onCrashStarted(r8, r9)
        Lf:
            java.lang.String r1 = r9.toString()
            r2 = 0
            java.lang.String r3 = ""
            if (r1 == 0) goto L2f
            boolean r4 = r1.equals(r3)
            if (r4 != 0) goto L2f
            java.lang.String r4 = ":"
            java.lang.String[] r4 = r1.split(r4)     // Catch: java.lang.Exception -> L2f
            int r5 = r1.length()     // Catch: java.lang.Exception -> L2f
            if (r5 <= r0) goto L2d
            r0 = r4[r2]     // Catch: java.lang.Exception -> L2f
            goto L30
        L2d:
            r0 = r1
            goto L30
        L2f:
            r0 = r3
        L30:
            if (r0 == 0) goto L3a
            boolean r4 = r0.equals(r3)
            if (r4 == 0) goto L39
            goto L3a
        L39:
            r1 = r0
        L3a:
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            java.io.PrintWriter r4 = new java.io.PrintWriter
            r4.<init>(r0)
            r9.printStackTrace(r4)
            java.lang.String r5 = r0.toString()
            r4.close()     // Catch: java.io.IOException -> L52
            r0.close()     // Catch: java.io.IOException -> L52
            goto L58
        L52:
            r0 = move-exception
            java.lang.String r4 = "pw"
            com.baidu.crabsdk.c.a.a(r4, r0)
        L58:
            if (r5 == 0) goto L150
            java.lang.String r0 = r1.trim()
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L150
            boolean r0 = com.baidu.crabsdk.a.n
            if (r0 == 0) goto Le6
            boolean r0 = b(r9)
            if (r0 == 0) goto Le6
            java.lang.String r0 = com.baidu.crabsdk.sender.f.f4766h     // Catch: java.lang.Throwable -> Ld0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Ld0
            r1.<init>(r0)     // Catch: java.lang.Throwable -> Ld0
            boolean r3 = r1.exists()     // Catch: java.lang.Throwable -> Ld0
            if (r3 != 0) goto La2
            boolean r1 = r1.mkdirs()     // Catch: java.lang.Throwable -> Ld0
            if (r1 != 0) goto L93
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r3 = "app文件创建失败  fileName is "
            r1.<init>(r3)     // Catch: java.lang.Throwable -> Ld0
            r1.append(r0)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Ld0
        L8f:
            com.baidu.crabsdk.c.a.d(r1)     // Catch: java.lang.Throwable -> Ld0
            goto La2
        L93:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r3 = "app文件创建ok  fileName is "
            r1.<init>(r3)     // Catch: java.lang.Throwable -> Ld0
            r1.append(r0)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Ld0
            goto L8f
        La2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            r1.<init>()     // Catch: java.lang.Throwable -> Ld0
            r1.append(r0)     // Catch: java.lang.Throwable -> Ld0
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld0
            r1.append(r3)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r0 = ".hprof"
            r1.append(r0)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> Ld0
            android.os.Debug.dumpHprofData(r0)     // Catch: java.lang.Throwable -> Ld0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r3 = "输出OOM的dump信息 name="
            r1.<init>(r3)     // Catch: java.lang.Throwable -> Ld0
            r1.append(r0)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> Ld0
            com.baidu.crabsdk.c.a.c(r0)     // Catch: java.lang.Throwable -> Ld0
            goto Le6
        Ld0:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "oom save fail"
            r1.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.baidu.crabsdk.c.a.d(r0)
        Le6:
            boolean r0 = com.baidu.crabsdk.sender.h.a()
            if (r0 == 0) goto L150
            boolean r0 = com.baidu.crabsdk.sender.h.g()
            if (r0 == 0) goto L150
            boolean r0 = com.baidu.crabsdk.sender.h.n(r9)
            if (r0 == 0) goto L150
            com.baidu.crabsdk.sender.f.f4765g = r2
            android.content.Context r0 = r7.f4768f
            if (r0 == 0) goto L11e
            if (r8 == 0) goto L11e
            if (r9 != 0) goto L103
            goto L11e
        L103:
            java.util.Map r0 = com.baidu.crabsdk.sender.g.c(r0, r9, r2)
            java.lang.String r0 = com.baidu.crabsdk.sender.i.h(r0)
            android.content.Context r1 = r7.f4768f
            com.baidu.crabsdk.sender.i.g(r1, r0)
            com.baidu.crabsdk.sender.h.o(r9)
            com.baidu.crabsdk.sender.h.p(r9)
            com.baidu.crabsdk.sender.h.j()
            android.content.Context r0 = r7.f4768f
            com.baidu.crabsdk.sender.k.b(r2, r0)
        L11e:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L14c
        L122:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L14c
            boolean r4 = com.baidu.crabsdk.sender.f.f4765g     // Catch: java.lang.Exception -> L14c
            if (r4 == 0) goto L142
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L14c
            java.lang.String r5 = "^^ upload finished()! --> cost : "
            r4.<init>(r5)     // Catch: java.lang.Exception -> L14c
            long r2 = r2 - r0
            r4.append(r2)     // Catch: java.lang.Exception -> L14c
            java.lang.String r0 = "ms"
            r4.append(r0)     // Catch: java.lang.Exception -> L14c
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Exception -> L14c
        L13e:
            com.baidu.crabsdk.c.a.c(r0)     // Catch: java.lang.Exception -> L14c
            goto L150
        L142:
            long r2 = r2 - r0
            r4 = 2500(0x9c4, double:1.235E-320)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L122
            java.lang.String r0 = "T^T upload timeout!"
            goto L13e
        L14c:
            r0 = move-exception
            r0.printStackTrace()
        L150:
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f4767e
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L15d
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f4767e
            r0.uncaughtException(r8, r9)
        L15d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crabsdk.sender.f.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
