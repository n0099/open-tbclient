package com.baidu.crabsdk.lite.sender;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crabsdk.lite.a.n;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f4741g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f4742h;

    /* renamed from: i  reason: collision with root package name */
    public static a f4743i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4744e;

    /* renamed from: f  reason: collision with root package name */
    public Context f4745f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-78364218, "Lcom/baidu/crabsdk/lite/sender/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-78364218, "Lcom/baidu/crabsdk/lite/sender/a;");
                return;
            }
        }
        f4742h = Environment.getExternalStorageDirectory().getPath() + File.separator + n.c() + File.separator + "oom_lite" + File.separator;
        f4743i = new a();
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
        this.f4744e = null;
        this.f4745f = null;
    }

    public static boolean a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
                th = th.getCause();
                if (th == null) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f4743i : (a) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (this.f4744e == null) {
                this.f4744e = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
            }
            if (this.f4745f == null) {
                this.f4745f = context.getApplicationContext();
            }
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
    /* JADX WARN: Can't wrap try/catch for region: R(13:7|(2:13|(2:14|(2:16|(2:18|19))(1:20)))(0)|(1:24)|25|(10:29|30|(1:32)(1:100)|(1:36)|37|38|39|(5:43|(1:90)(1:47)|(4:51|52|(3:54|(1:56)(1:58)|57)|59)|63|(6:69|(1:75)|76|77|(2:78|(2:86|87)(2:80|(2:82|83)))|84))|91|(2:93|94)(1:95))|102|(2:34|36)|37|38|39|(7:41|43|(1:45)|90|(5:49|51|52|(0)|59)|63|(8:65|67|69|(2:73|75)|76|77|(3:78|(0)(0)|81)|84))|91|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009d, code lost:
        com.baidu.crabsdk.lite.b.a.e(r2, "pw", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de A[Catch: all -> 0x0133, TryCatch #1 {all -> 0x0133, blocks: (B:56:0x00d1, B:58:0x00de, B:60:0x00e4, B:61:0x00f2, B:62:0x00f6, B:63:0x0105), top: B:102:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a4 A[Catch: Exception -> 0x01ae, TryCatch #0 {Exception -> 0x01ae, blocks: (B:81:0x0180, B:82:0x0184, B:84:0x018c, B:85:0x01a0, B:86:0x01a4), top: B:100:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ba  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void uncaughtException(java.lang.Thread r9, java.lang.Throwable r10) {
        /*
            r8 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.crabsdk.lite.sender.a.$ic
            if (r0 != 0) goto L1c0
        L4:
            boolean r0 = com.baidu.crabsdk.lite.a.k
            if (r0 == 0) goto L9
            return
        L9:
            r0 = 1
            com.baidu.crabsdk.lite.a.k = r0
            java.lang.String r1 = android.util.Log.getStackTraceString(r10)
            r2 = 0
            if (r1 == 0) goto L39
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r3 = com.baidu.crabsdk.lite.a.f4705a
            java.util.Set r3 = r3.keySet()
            if (r3 == 0) goto L39
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L22
            goto L39
        L22:
            java.util.Iterator r3 = r3.iterator()
        L26:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L39
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r1.contains(r4)
            if (r5 == 0) goto L26
            r2 = r4
        L39:
            if (r2 != 0) goto L48
            java.lang.Thread$UncaughtExceptionHandler r1 = r8.f4744e
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L48
            java.lang.Thread$UncaughtExceptionHandler r1 = r8.f4744e
            r1.uncaughtException(r9, r10)
        L48:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "SDK包名匹配成功："
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.crabsdk.lite.b.a.c(r2, r1)
            java.lang.String r1 = r10.toString()
            r3 = 0
            java.lang.String r4 = ""
            if (r1 == 0) goto L79
            boolean r5 = r1.equals(r4)
            if (r5 != 0) goto L79
            java.lang.String r5 = ":"
            java.lang.String[] r5 = r1.split(r5)     // Catch: java.lang.Exception -> L79
            int r6 = r1.length()     // Catch: java.lang.Exception -> L79
            if (r6 <= r0) goto L77
            r0 = r5[r3]     // Catch: java.lang.Exception -> L79
            goto L7a
        L77:
            r0 = r1
            goto L7a
        L79:
            r0 = r4
        L7a:
            if (r0 == 0) goto L84
            boolean r5 = r0.equals(r4)
            if (r5 == 0) goto L83
            goto L84
        L83:
            r1 = r0
        L84:
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            java.io.PrintWriter r5 = new java.io.PrintWriter
            r5.<init>(r0)
            r10.printStackTrace(r5)
            java.lang.String r6 = r0.toString()
            r5.close()     // Catch: java.io.IOException -> L9c
            r0.close()     // Catch: java.io.IOException -> L9c
            goto La2
        L9c:
            r0 = move-exception
            java.lang.String r5 = "pw"
            com.baidu.crabsdk.lite.b.a.e(r2, r5, r0)
        La2:
            if (r6 == 0) goto L1b2
            java.lang.String r0 = r1.trim()
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L1b2
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r0 = com.baidu.crabsdk.lite.a.f4705a
            java.lang.Object r0 = r0.get(r2)
            java.util.HashMap r0 = (java.util.HashMap) r0
            if (r0 == 0) goto Lc8
            java.lang.String r1 = "sdk_debug"
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto Lc8
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto Lc9
        Lc8:
            r0 = 0
        Lc9:
            if (r0 == 0) goto L149
            boolean r0 = a(r10)
            if (r0 == 0) goto L149
            java.lang.String r0 = com.baidu.crabsdk.lite.sender.a.f4742h     // Catch: java.lang.Throwable -> L133
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L133
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L133
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> L133
            if (r4 != 0) goto L105
            boolean r1 = r1.mkdirs()     // Catch: java.lang.Throwable -> L133
            if (r1 != 0) goto Lf6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L133
            java.lang.String r4 = "app文件创建失败  fileName is "
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L133
            r1.append(r0)     // Catch: java.lang.Throwable -> L133
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L133
        Lf2:
            com.baidu.crabsdk.lite.b.a.d(r2, r1)     // Catch: java.lang.Throwable -> L133
            goto L105
        Lf6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L133
            java.lang.String r4 = "app文件创建ok  fileName is "
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L133
            r1.append(r0)     // Catch: java.lang.Throwable -> L133
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L133
            goto Lf2
        L105:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L133
            r1.<init>()     // Catch: java.lang.Throwable -> L133
            r1.append(r0)     // Catch: java.lang.Throwable -> L133
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L133
            r1.append(r4)     // Catch: java.lang.Throwable -> L133
            java.lang.String r0 = ".hprof"
            r1.append(r0)     // Catch: java.lang.Throwable -> L133
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L133
            android.os.Debug.dumpHprofData(r0)     // Catch: java.lang.Throwable -> L133
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L133
            java.lang.String r4 = "输出OOM的dump信息 name="
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L133
            r1.append(r0)     // Catch: java.lang.Throwable -> L133
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L133
            com.baidu.crabsdk.lite.b.a.c(r2, r0)     // Catch: java.lang.Throwable -> L133
            goto L149
        L133:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "oom save fail"
            r1.<init>(r4)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.baidu.crabsdk.lite.b.a.d(r2, r0)
        L149:
            boolean r0 = com.baidu.crabsdk.lite.sender.c.p(r2)
            if (r0 == 0) goto L1b2
            boolean r0 = com.baidu.crabsdk.lite.sender.c.b(r2)
            if (r0 == 0) goto L1b2
            boolean r0 = com.baidu.crabsdk.lite.sender.c.h(r2, r10)
            if (r0 == 0) goto L1b2
            com.baidu.crabsdk.lite.sender.a.f4741g = r3
            android.content.Context r0 = r8.f4745f
            if (r0 == 0) goto L180
            if (r9 == 0) goto L180
            if (r10 != 0) goto L166
            goto L180
        L166:
            java.util.Map r0 = com.baidu.crabsdk.lite.sender.b.b(r2, r0, r10)
            if (r0 == 0) goto L180
            java.lang.String r0 = com.baidu.crabsdk.lite.sender.d.b(r2, r0)
            android.content.Context r1 = r8.f4745f
            com.baidu.crabsdk.lite.sender.d.e(r2, r1, r0)
            com.baidu.crabsdk.lite.sender.c.k(r2, r10)
            com.baidu.crabsdk.lite.sender.c.c(r2)
            android.content.Context r0 = r8.f4745f
            com.baidu.crabsdk.lite.sender.e.c(r2, r0)
        L180:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L1ae
        L184:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L1ae
            boolean r5 = com.baidu.crabsdk.lite.sender.a.f4741g     // Catch: java.lang.Exception -> L1ae
            if (r5 == 0) goto L1a4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1ae
            java.lang.String r6 = "^^ upload finished()! --> cost : "
            r5.<init>(r6)     // Catch: java.lang.Exception -> L1ae
            long r3 = r3 - r0
            r5.append(r3)     // Catch: java.lang.Exception -> L1ae
            java.lang.String r0 = "ms"
            r5.append(r0)     // Catch: java.lang.Exception -> L1ae
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L1ae
        L1a0:
            com.baidu.crabsdk.lite.b.a.c(r2, r0)     // Catch: java.lang.Exception -> L1ae
            goto L1b2
        L1a4:
            long r3 = r3 - r0
            r5 = 2500(0x9c4, double:1.235E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L184
            java.lang.String r0 = "T^T upload timeout!"
            goto L1a0
        L1ae:
            r0 = move-exception
            r0.printStackTrace()
        L1b2:
            java.lang.Thread$UncaughtExceptionHandler r0 = r8.f4744e
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L1bf
            java.lang.Thread$UncaughtExceptionHandler r0 = r8.f4744e
            r0.uncaughtException(r9, r10)
        L1bf:
            return
        L1c0:
            r6 = r0
            r7 = 1048577(0x100001, float:1.46937E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r6.invokeLL(r7, r8, r9, r10)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crabsdk.lite.sender.a.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
