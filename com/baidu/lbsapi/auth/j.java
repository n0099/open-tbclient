package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Hashtable e;
    public final /* synthetic */ LBSAuthManager f;

    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lBSAuthManager, Integer.valueOf(i), Boolean.valueOf(z), str, str2, hashtable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = lBSAuthManager;
        this.a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        Context context;
        boolean b2;
        m mVar;
        m mVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(this.a);
            sb.append("; forced = ");
            sb.append(this.b);
            sb.append("checkAK = ");
            b = this.f.b(this.c);
            sb.append(b);
            a.a(sb.toString());
            int i = this.a;
            if (i != 601 && !this.b && i != -1) {
                b2 = this.f.b(this.c);
                if (!b2) {
                    if (602 == this.a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f.a((String) null, this.c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.a;
            String[] b3 = b.b(context);
            a.a("authStrings.length:" + b3.length);
            if (b3 == null || b3.length <= 1) {
                this.f.a(this.b, this.d, this.e, this.c);
                return;
            }
            a.a("more sha1 auth");
            this.f.a(this.b, this.d, this.e, b3, this.c);
        }
    }
}
