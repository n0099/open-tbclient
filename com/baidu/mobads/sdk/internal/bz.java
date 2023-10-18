package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bz extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bx a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(bx bxVar, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bxVar, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bxVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        br brVar;
        boolean z;
        Context context;
        br brVar2;
        boolean z2;
        boolean p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            String string = message.getData().getString(bx.n);
            bv bvVar = (bv) message.getData().getParcelable(bx.m);
            if (bx.k.equals(string)) {
                String e = bvVar.e();
                context = this.a.y;
                bq bqVar = new bq(e, context, bvVar);
                try {
                    try {
                        if (this.a.u == bx.t) {
                            bqVar.a();
                            bqVar.a(bx.f());
                            if (bx.p != null) {
                                bx.p.b = bvVar.b();
                            }
                            this.a.l();
                            z2 = this.a.A;
                            if (z2) {
                                this.a.A = false;
                                bx bxVar = this.a;
                                p = this.a.p();
                                bxVar.a(p, "load remote file just downloaded");
                            }
                        } else {
                            this.a.a(bqVar);
                            bqVar.a(bx.f());
                            this.a.a(true);
                        }
                    } catch (bx.a e2) {
                        this.a.a(false);
                        brVar2 = this.a.z;
                        brVar2.a(bx.a, "download apk file failed: " + e2.toString());
                    }
                    return;
                } finally {
                    bqVar.delete();
                }
            }
            brVar = this.a.z;
            brVar.a(bx.a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.a.a(false);
            z = this.a.A;
            if (!z) {
                return;
            }
            this.a.A = false;
            this.a.a(false, "Refused to download remote for version...");
        }
    }
}
