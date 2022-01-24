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
    public final /* synthetic */ boolean f34640b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34641c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34642d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f34643e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f34644f;

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
        this.f34644f = lBSAuthManager;
        this.a = i2;
        this.f34640b = z;
        this.f34641c = str;
        this.f34642d = str2;
        this.f34643e = hashtable;
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
            sb.append(this.f34640b);
            sb.append("checkAK = ");
            b2 = this.f34644f.b(this.f34641c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.a;
            if (i2 != 601 && !this.f34640b && i2 != -1) {
                b3 = this.f34644f.b(this.f34641c);
                if (!b3) {
                    if (602 == this.a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f34624d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f34624d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f34644f.a((String) null, this.f34641c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f34644f.a(this.f34640b, this.f34642d, this.f34643e, this.f34641c);
                return;
            }
            a.a("more sha1 auth");
            this.f34644f.a(this.f34640b, this.f34642d, this.f34643e, b4, this.f34641c);
        }
    }
}
