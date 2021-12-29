package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes10.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f35774c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f35775d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f35776e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f35777f;

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
        this.f35777f = lBSAuthManager;
        this.a = i2;
        this.f35773b = z;
        this.f35774c = str;
        this.f35775d = str2;
        this.f35776e = hashtable;
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
            sb.append(this.f35773b);
            sb.append("checkAK = ");
            b2 = this.f35777f.b(this.f35774c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.a;
            if (i2 != 601 && !this.f35773b && i2 != -1) {
                b3 = this.f35777f.b(this.f35774c);
                if (!b3) {
                    if (602 == this.a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f35757d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f35757d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f35777f.a((String) null, this.f35774c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f35777f.a(this.f35773b, this.f35775d, this.f35776e, this.f35774c);
                return;
            }
            a.a("more sha1 auth");
            this.f35777f.a(this.f35773b, this.f35775d, this.f35776e, b4, this.f35774c);
        }
    }
}
