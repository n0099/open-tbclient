package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f25602b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25603c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25604d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f25605e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f25606f;

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
        this.f25606f = lBSAuthManager;
        this.a = i;
        this.f25602b = z;
        this.f25603c = str;
        this.f25604d = str2;
        this.f25605e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        Context context;
        boolean b3;
        m mVar;
        m mVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(this.a);
            sb.append("; forced = ");
            sb.append(this.f25602b);
            sb.append("checkAK = ");
            b2 = this.f25606f.b(this.f25603c);
            sb.append(b2);
            a.a(sb.toString());
            int i = this.a;
            if (i != 601 && !this.f25602b && i != -1) {
                b3 = this.f25606f.b(this.f25603c);
                if (!b3) {
                    if (602 == this.a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f25587d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f25587d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f25606f.a((String) null, this.f25603c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f25606f.a(this.f25602b, this.f25604d, this.f25605e, this.f25603c);
                return;
            }
            a.a("more sha1 auth");
            this.f25606f.a(this.f25602b, this.f25604d, this.f25605e, b4, this.f25603c);
        }
    }
}
