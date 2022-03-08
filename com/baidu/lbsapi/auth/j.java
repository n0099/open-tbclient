package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes4.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f33249b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f33250c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f33251d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f33252e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f33253f;

    public j(LBSAuthManager lBSAuthManager, int i2, boolean z, String str, String str2, Hashtable hashtable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lBSAuthManager, Integer.valueOf(i2), Boolean.valueOf(z), str, str2, hashtable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33253f = lBSAuthManager;
        this.a = i2;
        this.f33249b = z;
        this.f33250c = str;
        this.f33251d = str2;
        this.f33252e = hashtable;
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
            sb.append(this.f33249b);
            sb.append("checkAK = ");
            b2 = this.f33253f.b(this.f33250c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.a;
            if (i2 != 601 && !this.f33249b && i2 != -1) {
                b3 = this.f33253f.b(this.f33250c);
                if (!b3) {
                    if (602 == this.a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f33233d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f33233d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f33253f.a((String) null, this.f33250c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f33253f.a(this.f33249b, this.f33251d, this.f33252e, this.f33250c);
                return;
            }
            a.a("more sha1 auth");
            this.f33253f.a(this.f33249b, this.f33251d, this.f33252e, b4, this.f33250c);
        }
    }
}
