package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f39423b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f39424c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39425d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f39426e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f39427f;

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
        this.f39427f = lBSAuthManager;
        this.f39422a = i2;
        this.f39423b = z;
        this.f39424c = str;
        this.f39425d = str2;
        this.f39426e = hashtable;
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
            sb.append(this.f39422a);
            sb.append("; forced = ");
            sb.append(this.f39423b);
            sb.append("checkAK = ");
            b2 = this.f39427f.b(this.f39424c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.f39422a;
            if (i2 != 601 && !this.f39423b && i2 != -1) {
                b3 = this.f39427f.b(this.f39424c);
                if (!b3) {
                    if (602 == this.f39422a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f39398d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f39398d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f39427f.a((String) null, this.f39424c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.f39397a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f39427f.a(this.f39423b, this.f39425d, this.f39426e, this.f39424c);
                return;
            }
            a.a("more sha1 auth");
            this.f39427f.a(this.f39423b, this.f39425d, this.f39426e, b4, this.f39424c);
        }
    }
}
