package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cd implements am.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ double a;
    public final /* synthetic */ bx b;

    public cd(bx bxVar, double d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bxVar, Double.valueOf(d)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bxVar;
        this.a = d;
    }

    @Override // com.baidu.mobads.sdk.internal.am.b
    public void a(String str, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) {
            return;
        }
        z = this.b.A;
        if (!z) {
            return;
        }
        this.b.A = false;
        this.b.a(false, "remote update Network access failed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
        if (r9 == java.lang.Math.floor(r4.b())) goto L10;
     */
    @Override // com.baidu.mobads.sdk.internal.am.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2) {
        SharedPreferences m;
        bv bvVar;
        boolean z;
        bv bvVar2;
        br brVar;
        bv bvVar3;
        boolean z2;
        bv bvVar4;
        bv bvVar5;
        bv bvVar6;
        bv bvVar7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.b.w = new bv(str);
            double b = ck.b();
            m = this.b.m();
            float f = m.getFloat(bx.c, 0.0f);
            bvVar = this.b.w;
            boolean z3 = true;
            if (((float) bvVar.b()) == f) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            bvVar2 = this.b.w;
            if (b <= bvVar2.b()) {
                double floor = Math.floor(b);
                bvVar7 = this.b.w;
            }
            z3 = false;
            Boolean valueOf2 = Boolean.valueOf(z3);
            brVar = this.b.z;
            brVar.a(bx.a, "try to download apk badVer=" + f + ", isBad=" + valueOf + ", compatible=" + valueOf2);
            double d = this.a;
            bvVar3 = this.b.w;
            if (d < bvVar3.b()) {
                bvVar4 = this.b.w;
                if (bvVar4 != null) {
                    bvVar5 = this.b.w;
                    if (bvVar5.a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                        bx bxVar = this.b;
                        bvVar6 = bxVar.w;
                        bxVar.a(bvVar6);
                        return;
                    }
                }
            }
            z2 = this.b.A;
            if (!z2) {
                return;
            }
            this.b.A = false;
            this.b.a(false, "Refused to download remote for version...");
        }
    }
}
