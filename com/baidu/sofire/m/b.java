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
    public a f45390a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45391b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sofire.k.c f45392c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f45393d;

    /* renamed from: e  reason: collision with root package name */
    public String f45394e;

    /* renamed from: f  reason: collision with root package name */
    public String f45395f;

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
        this.f45390a = null;
        this.f45394e = null;
        this.f45395f = null;
        this.f45393d = new d(this);
        this.f45391b = context;
        this.f45392c = cVar;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        String str2;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str3 = null;
            try {
                if (TextUtils.isEmpty(this.f45394e)) {
                    this.f45394e = this.f45391b.getPackageName();
                }
                if (TextUtils.isEmpty(this.f45395f)) {
                    try {
                        signatureArr = this.f45391b.getPackageManager().getPackageInfo(this.f45394e, 64).signatures;
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
                    this.f45395f = str3;
                }
                str2 = this.f45390a.a(this.f45394e, this.f45395f, str);
            } catch (Throwable th) {
                th.printStackTrace();
                str2 = str3;
            }
            return TextUtils.isEmpty(str2) ? "" : str2;
        }
        return (String) invokeL.objValue;
    }
}
