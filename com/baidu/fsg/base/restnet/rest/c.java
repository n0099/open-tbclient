package com.baidu.fsg.base.restnet.rest;

import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.utils.LogUtil;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5232a = 30000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5233b = 30000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5234c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5235d = 10;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5236e = 8192;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5237f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5238g = 1000;

    /* renamed from: h  reason: collision with root package name */
    public static final String f5239h = "RestHttpNetwork";
    public final b i;
    public final g j = new g(3, 1000);

    public c(b bVar) {
        this.i = bVar;
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
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2 A[SYNTHETIC] */
    @Override // com.baidu.fsg.base.restnet.rest.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d r11) throws java.lang.Exception {
        /*
            r10 = this;
            java.lang.String r0 = r11.k()
            com.baidu.fsg.base.restnet.RestRequestCallbacker$IRestRequestCallback r1 = com.baidu.fsg.base.restnet.RestRequestCallbacker.getRequestCallback()
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1
            r6 = 0
        Ld:
            if (r5 == 0) goto Lde
            com.baidu.fsg.base.restnet.rest.b r4 = r10.i     // Catch: java.io.IOException -> L2d java.util.concurrent.TimeoutException -> L38 java.lang.NullPointerException -> L5c java.net.UnknownHostException -> L83
            com.baidu.fsg.base.restnet.rest.e r4 = r4.a(r11)     // Catch: java.io.IOException -> L2d java.util.concurrent.TimeoutException -> L38 java.lang.NullPointerException -> L5c java.net.UnknownHostException -> L83
            if (r4 == 0) goto L2c
            com.baidu.fsg.base.restnet.http.HttpStatus r5 = r4.e()     // Catch: java.io.IOException -> L2d java.util.concurrent.TimeoutException -> L38 java.lang.NullPointerException -> L5c java.net.UnknownHostException -> L83
            com.baidu.fsg.base.restnet.http.HttpStatus r7 = com.baidu.fsg.base.restnet.http.HttpStatus.OK     // Catch: java.io.IOException -> L2d java.util.concurrent.TimeoutException -> L38 java.lang.NullPointerException -> L5c java.net.UnknownHostException -> L83
            if (r5 != r7) goto L2c
            if (r1 == 0) goto L2c
            java.lang.String r5 = r11.k()     // Catch: java.io.IOException -> L2d java.util.concurrent.TimeoutException -> L38 java.lang.NullPointerException -> L5c java.net.UnknownHostException -> L83
            java.lang.String r7 = r11.d()     // Catch: java.io.IOException -> L2d java.util.concurrent.TimeoutException -> L38 java.lang.NullPointerException -> L5c java.net.UnknownHostException -> L83
            r1.onSuccess(r5, r7)     // Catch: java.io.IOException -> L2d java.util.concurrent.TimeoutException -> L38 java.lang.NullPointerException -> L5c java.net.UnknownHostException -> L83
        L2c:
            return r4
        L2d:
            r4 = move-exception
            com.baidu.fsg.base.restnet.rest.g r5 = r10.j
            int r6 = r6 + 1
            boolean r5 = r5.a(r4, r6)
            goto Lae
        L38:
            r4 = move-exception
            java.util.concurrent.TimeoutException r5 = new java.util.concurrent.TimeoutException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TimeoutException exception: "
            r7.append(r8)
            java.lang.String r8 = r4.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            com.baidu.fsg.base.restnet.rest.g r7 = r10.j
            int r6 = r6 + 1
            boolean r4 = r7.a(r4, r6)
            goto L7f
        L5c:
            r4 = move-exception
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "NPE in HttpClient: "
            r7.append(r8)
            java.lang.String r4 = r4.getMessage()
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r5.<init>(r4)
            com.baidu.fsg.base.restnet.rest.g r4 = r10.j
            int r6 = r6 + 1
            boolean r4 = r4.a(r5, r6)
        L7f:
            r9 = r5
            r5 = r4
            r4 = r9
            goto Lae
        L83:
            r4 = move-exception
            java.net.UnknownHostException r5 = new java.net.UnknownHostException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "UnknownHostException exception: "
            r7.append(r8)
            java.lang.String r8 = r4.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            if (r6 <= 0) goto Lac
            com.baidu.fsg.base.restnet.rest.g r7 = r10.j
            int r6 = r6 + 1
            boolean r4 = r7.a(r4, r6)
            if (r4 == 0) goto Lac
            r4 = 1
            goto L7f
        Lac:
            r4 = 0
            goto L7f
        Lae:
            if (r5 == 0) goto Lb2
            goto Ld
        Lb2:
            if (r1 == 0) goto Lde
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RestHttpNetwork performRequest retry count:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " failure, url:"
            r1.append(r2)
            java.lang.String r11 = r11.d()
            r1.append(r11)
            java.lang.String r11 = ", origUrl:"
            r1.append(r11)
            r1.append(r0)
            java.lang.String r11 = r1.toString()
            java.lang.String r0 = "RestHttpNetwork"
            com.baidu.fsg.base.utils.LogUtil.errord(r0, r11)
        Lde:
            goto Le0
        Ldf:
            throw r4
        Le0:
            goto Ldf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.base.restnet.rest.c.a(com.baidu.fsg.base.restnet.rest.d):com.baidu.fsg.base.restnet.rest.e");
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void a() {
        this.i.a();
    }
}
