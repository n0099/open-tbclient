package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bi implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ IOAdEvent a;
    public final /* synthetic */ bf.a b;

    public bi(bf.a aVar, IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, iOAdEvent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = aVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        IOAdEvent iOAdEvent;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iOAdEvent = this.a) != null && !TextUtils.isEmpty(iOAdEvent.getType())) {
            String type = this.a.getType();
            if (w.J.equals(type)) {
                this.b.a.a(this.a);
            } else if (w.M.equals(type)) {
                this.b.a.n = this.a.getMessage();
                this.b.a.q();
            } else if (w.N.equals(type)) {
                this.b.a.e(this.a);
            } else if (w.O.equals(type)) {
                this.b.a.f(this.a);
            } else if (w.W.equals(type)) {
                this.b.a.g(this.a);
            } else {
                String str = "";
                boolean z = false;
                int i = 0;
                int i2 = 0;
                r5 = false;
                boolean z2 = false;
                boolean z3 = false;
                if (w.r.equals(type)) {
                    HashMap hashMap2 = (HashMap) this.a.getData();
                    if (hashMap2 != null) {
                        str = (String) hashMap2.get("error_message");
                        Object obj = hashMap2.get("error_code");
                        Integer num = obj;
                        if (obj == null) {
                            num = 0;
                        }
                        i = ((Integer) num).intValue();
                    }
                    this.b.a.b(str, i);
                } else if (w.L.equals(type)) {
                    HashMap hashMap3 = (HashMap) this.a.getData();
                    if (hashMap3 != null) {
                        str = (String) hashMap3.get("error_message");
                        Object obj2 = hashMap3.get("error_code");
                        Integer num2 = obj2;
                        if (obj2 == null) {
                            num2 = 0;
                        }
                        i2 = ((Integer) num2).intValue();
                    }
                    this.b.a.a(i2, str);
                } else if (w.H.equals(type)) {
                    this.b.a.h(this.a);
                } else if (w.X.equals(type)) {
                    this.b.a.d();
                } else if (w.Y.equals(type)) {
                    this.b.a.d(this.a);
                } else if (w.aa.equals(type)) {
                    this.b.a.s();
                } else if (w.ab.equals(type)) {
                    IOAdEvent iOAdEvent2 = this.a;
                    if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                        z2 = "1".equals((String) hashMap.get("serverVerify"));
                    }
                    this.b.a.b(z2);
                } else if (w.ac.equals(type)) {
                    this.b.a.b_();
                } else if (w.ad.equals(type)) {
                    this.b.a.c_();
                } else if (w.K.equals(type)) {
                    this.b.a.b(this.a);
                } else if (w.ae.equals(type)) {
                    bf bfVar = this.b.a;
                    String message = this.a.getMessage();
                    if (1 == this.a.getCode()) {
                        z3 = true;
                    }
                    bfVar.a(message, z3);
                } else if (w.af.equals(type)) {
                    this.b.a.e(this.a.getMessage());
                } else if (w.ag.equals(type)) {
                    this.b.a.f(this.a.getMessage());
                } else if (w.ah.equals(type)) {
                    this.b.a.d(this.a.getMessage());
                } else if (w.D.equals(type)) {
                    this.b.a.g(this.a.getMessage());
                } else if (w.Z.equals(type)) {
                    this.b.a.t();
                } else if (w.ai.equals(type)) {
                    bf bfVar2 = this.b.a;
                    String message2 = this.a.getMessage();
                    if (1 == this.a.getCode()) {
                        z = true;
                    }
                    bfVar2.b(message2, z);
                } else if (w.al.equals(type)) {
                    this.b.a.c(this.a);
                } else if (w.aj.equals(type)) {
                    this.b.a.u();
                } else if (w.ak.equals(type)) {
                    this.b.a.v();
                } else if (w.an.equals(type)) {
                    this.b.a.i(this.a);
                } else if (w.ao.equals(type)) {
                    this.b.a.j(this.a);
                } else if (w.am.equals(type)) {
                    this.b.a.k(this.a);
                }
            }
        }
    }
}
