package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes5.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f40697b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f40698c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40699d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f40700e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f40701f;

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
        this.f40701f = lBSAuthManager;
        this.f40696a = i2;
        this.f40697b = z;
        this.f40698c = str;
        this.f40699d = str2;
        this.f40700e = hashtable;
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
            sb.append(this.f40696a);
            sb.append("; forced = ");
            sb.append(this.f40697b);
            sb.append("checkAK = ");
            b2 = this.f40701f.b(this.f40698c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.f40696a;
            if (i2 != 601 && !this.f40697b && i2 != -1) {
                b3 = this.f40701f.b(this.f40698c);
                if (!b3) {
                    if (602 == this.f40696a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f40672d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f40672d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f40701f.a((String) null, this.f40698c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.f40671a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f40701f.a(this.f40697b, this.f40699d, this.f40700e, this.f40698c);
                return;
            }
            a.a("more sha1 auth");
            this.f40701f.a(this.f40697b, this.f40699d, this.f40700e, b4, this.f40698c);
        }
    }
}
