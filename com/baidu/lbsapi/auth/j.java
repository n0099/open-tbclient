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
    public final /* synthetic */ boolean f34846b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34847c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34848d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f34849e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f34850f;

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
        this.f34850f = lBSAuthManager;
        this.a = i2;
        this.f34846b = z;
        this.f34847c = str;
        this.f34848d = str2;
        this.f34849e = hashtable;
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
            sb.append(this.f34846b);
            sb.append("checkAK = ");
            b2 = this.f34850f.b(this.f34847c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.a;
            if (i2 != 601 && !this.f34846b && i2 != -1) {
                b3 = this.f34850f.b(this.f34847c);
                if (!b3) {
                    if (602 == this.a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f34830d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f34830d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f34850f.a((String) null, this.f34847c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f34850f.a(this.f34846b, this.f34848d, this.f34849e, this.f34847c);
                return;
            }
            a.a("more sha1 auth");
            this.f34850f.a(this.f34846b, this.f34848d, this.f34849e, b4, this.f34847c);
        }
    }
}
