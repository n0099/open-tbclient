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

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6399a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6400b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6401c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6402d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6403e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6404f;

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
        this.f6404f = lBSAuthManager;
        this.f6399a = i2;
        this.f6400b = z;
        this.f6401c = str;
        this.f6402d = str2;
        this.f6403e = hashtable;
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
            sb.append(this.f6399a);
            sb.append("; forced = ");
            sb.append(this.f6400b);
            sb.append("checkAK = ");
            b2 = this.f6404f.b(this.f6401c);
            sb.append(b2);
            a.a(sb.toString());
            int i2 = this.f6399a;
            if (i2 != 601 && !this.f6400b && i2 != -1) {
                b3 = this.f6404f.b(this.f6401c);
                if (!b3) {
                    if (602 == this.f6399a) {
                        a.a("authenticate wait ");
                        mVar = LBSAuthManager.f6375d;
                        if (mVar != null) {
                            mVar2 = LBSAuthManager.f6375d;
                            mVar2.b();
                        }
                    } else {
                        a.a("authenticate else");
                    }
                    this.f6404f.a((String) null, this.f6401c);
                    return;
                }
            }
            a.a("authenticate sendAuthRequest");
            context = LBSAuthManager.f6374a;
            String[] b4 = b.b(context);
            a.a("authStrings.length:" + b4.length);
            if (b4 == null || b4.length <= 1) {
                this.f6404f.a(this.f6400b, this.f6402d, this.f6403e, this.f6401c);
                return;
            }
            a.a("more sha1 auth");
            this.f6404f.a(this.f6400b, this.f6402d, this.f6403e, b4, this.f6401c);
        }
    }
}
