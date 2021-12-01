package com.baidu.fsg.base.restnet.rest;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
/* loaded from: classes8.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 30000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f34241b = 30000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f34242c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static final int f34243d = 10;

    /* renamed from: e  reason: collision with root package name */
    public static final int f34244e = 8192;

    /* renamed from: f  reason: collision with root package name */
    public static final int f34245f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static final int f34246g = 1000;

    /* renamed from: h  reason: collision with root package name */
    public static final String f34247h = "RestHttpNetwork";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final b f34248i;

    /* renamed from: j  reason: collision with root package name */
    public final g f34249j;

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = objArr;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34248i = bVar;
        this.f34249j = new g(3, 1000);
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
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7 A[SYNTHETIC] */
    @Override // com.baidu.fsg.base.restnet.rest.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d r11) throws java.lang.Exception {
        /*
            r10 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.fsg.base.restnet.rest.c.$ic
            if (r0 != 0) goto Le4
        L4:
            java.lang.String r0 = r11.c()
            com.baidu.fsg.base.restnet.RestRequestCallbacker$IRestRequestCallback r1 = com.baidu.fsg.base.restnet.RestRequestCallbacker.getRequestCallback()
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1
            r6 = 0
        L11:
            if (r5 == 0) goto Le3
            com.baidu.fsg.base.restnet.rest.b r4 = r10.f34248i     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            com.baidu.fsg.base.restnet.rest.e r4 = r4.a(r11)     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            if (r4 == 0) goto L30
            com.baidu.fsg.base.restnet.http.HttpStatus r5 = r4.getStatusCode()     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            com.baidu.fsg.base.restnet.http.HttpStatus r7 = com.baidu.fsg.base.restnet.http.HttpStatus.OK     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            if (r5 != r7) goto L30
            if (r1 == 0) goto L30
            java.lang.String r5 = r11.c()     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            java.lang.String r7 = r11.getUrl()     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            r1.onSuccess(r5, r7)     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
        L30:
            return r4
        L31:
            r4 = move-exception
            com.baidu.fsg.base.restnet.rest.g r5 = r10.f34249j
            int r6 = r6 + 1
            boolean r5 = r5.a(r4, r6)
            goto Lb3
        L3c:
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
            com.baidu.fsg.base.restnet.rest.g r7 = r10.f34249j
            int r6 = r6 + 1
            boolean r4 = r7.a(r4, r6)
            goto L83
        L60:
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
            com.baidu.fsg.base.restnet.rest.g r4 = r10.f34249j
            int r6 = r6 + 1
            boolean r4 = r4.a(r5, r6)
        L83:
            r9 = r5
            r5 = r4
            r4 = r9
            goto Lb3
        L87:
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
            if (r6 <= 0) goto Lb1
            com.baidu.fsg.base.restnet.rest.g r7 = r10.f34249j
            int r6 = r6 + 1
            boolean r4 = r7.a(r4, r6)
            if (r4 == 0) goto Lb1
            r4 = r5
            r5 = 1
            goto Lb3
        Lb1:
            r4 = r5
            r5 = 0
        Lb3:
            if (r5 == 0) goto Lb7
            goto L11
        Lb7:
            if (r1 == 0) goto Le3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RestHttpNetwork performRequest retry count:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " failure, url:"
            r1.append(r2)
            java.lang.String r11 = r11.getUrl()
            r1.append(r11)
            java.lang.String r11 = ", origUrl:"
            r1.append(r11)
            r1.append(r0)
            java.lang.String r11 = r1.toString()
            java.lang.String r0 = "RestHttpNetwork"
            com.baidu.fsg.base.utils.LogUtil.errord(r0, r11)
        Le3:
            throw r4
        Le4:
            r8 = r0
            r9 = 1048576(0x100000, float:1.469368E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r8.invokeL(r9, r10, r11)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.baidu.fsg.base.restnet.rest.e r1 = (com.baidu.fsg.base.restnet.rest.e) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.base.restnet.rest.c.a(com.baidu.fsg.base.restnet.rest.d):com.baidu.fsg.base.restnet.rest.e");
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34248i.close();
        }
    }
}
