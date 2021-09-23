package com.baidu.sofire.m;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f45478a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45479b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sofire.k.c f45480c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f45481d;

    /* renamed from: e  reason: collision with root package name */
    public String f45482e;

    /* renamed from: f  reason: collision with root package name */
    public String f45483f;

    public b(Context context, com.baidu.sofire.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45478a = null;
        this.f45482e = null;
        this.f45483f = null;
        this.f45481d = new d(this);
        this.f45479b = context;
        this.f45480c = cVar;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        String str2;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str3 = null;
            try {
                if (TextUtils.isEmpty(this.f45482e)) {
                    this.f45482e = this.f45479b.getPackageName();
                }
                if (TextUtils.isEmpty(this.f45483f)) {
                    try {
                        signatureArr = this.f45479b.getPackageManager().getPackageInfo(this.f45482e, 64).signatures;
                    } catch (PackageManager.NameNotFoundException unused) {
                        signatureArr = null;
                    }
                    if (signatureArr != null && signatureArr.length > 0) {
                        try {
                            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            str3 = sb.toString();
                        } catch (NoSuchAlgorithmException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f45483f = str3;
                }
                str2 = this.f45478a.a(this.f45482e, this.f45483f, str);
            } catch (Throwable th) {
                th.printStackTrace();
                str2 = str3;
            }
            return TextUtils.isEmpty(str2) ? "" : str2;
        }
        return (String) invokeL.objValue;
    }
}
