package c.a.p0.c.a.k;

import android.text.TextUtils;
import android.util.Base64;
import c.a.p0.n.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a<T> extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f10364d;

    /* renamed from: e  reason: collision with root package name */
    public String f10365e;

    /* renamed from: f  reason: collision with root package name */
    public a.c f10366f;

    /* renamed from: g  reason: collision with root package name */
    public String f10367g;

    /* renamed from: h  reason: collision with root package name */
    public int f10368h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10364d = null;
        this.f10365e = null;
        this.f10366f = null;
    }

    @Override // c.a.p0.c.a.k.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10367g : (String) invokeV.objValue;
    }

    @Override // c.a.p0.c.a.k.c
    public void e(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
        }
    }

    @Override // c.a.p0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
        }
    }

    @Override // c.a.p0.c.a.k.c
    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.f10376a) {
                hashMap.put("Bdtls", TextUtils.equals(b(), "GET") ? Base64.encodeToString(bArr, 2) : "Bdtls");
            } else {
                hashMap.put("Bdtls-Downgrade", "1");
            }
            this.f10366f.a(hashMap, bArr, this.f10364d);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k(this.f10364d, this.f10365e, this.f10366f);
        }
    }

    public void k(String str, String str2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, cVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f10364d = str;
        this.f10365e = str2;
        this.f10366f = cVar;
        if (str2 == null) {
            this.f10367g = "GET";
        } else {
            this.f10367g = "POST";
        }
        if (c.a.p0.c.a.a.f10319a) {
            String str3 = "requestPost url=" + str;
            String str4 = "requestPost body=" + str2;
        }
        a(this.f10365e);
    }
}
