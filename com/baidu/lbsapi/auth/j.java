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
    public final /* synthetic */ int f40519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f40520b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f40521c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40522d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f40523e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f40524f;

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
        this.f40524f = lBSAuthManager;
        this.f40519a = i2;
        this.f40520b = z;
        this.f40521c = str;
        this.f40522d = str2;
        this.f40523e = hashtable;
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
            sb.append(this.f40519a);
            sb.append("; forced = ");
            sb.append(this.f40520b);
            sb.append("checkAK = ");
            b2 = this.f40524f.b(this.f40521c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.f40519a;
            if (i2 != 601 && !this.f40520b && i2 != -1) {
                b3 = this.f40524f.b(this.f40521c);
                if (!b3) {
                    if (602 == this.f40519a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f40495d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f40495d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f40524f.a((String) null, this.f40521c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.f40494a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f40524f.a(this.f40520b, this.f40522d, this.f40523e, this.f40521c);
                return;
            }
            a.a("more sha1 auth");
            this.f40524f.a(this.f40520b, this.f40522d, this.f40523e, b4, this.f40521c);
        }
    }
}
