package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes3.dex */
public class d implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public int f31276b;

    /* renamed from: c  reason: collision with root package name */
    public String f31277c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f31278d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.apollon.restnet.http.a f31279e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f31280f;

    public d(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), str, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = inputStream;
        this.f31276b = i2;
        this.f31277c = str;
        this.f31278d = map;
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String g2 = d().g();
            return !TextUtils.isEmpty(g2) && g2.contains("gzip");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public int a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31276b : invokeV.intValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public String b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31277c : (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public InputStream c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (g()) {
                return a(this.a);
            }
            return this.a;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public com.baidu.apollon.restnet.http.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f31279e == null) {
                this.f31279e = new com.baidu.apollon.restnet.http.a(this.f31278d, false);
            }
            return this.f31279e;
        }
        return (com.baidu.apollon.restnet.http.a) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public HttpStatus e() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? HttpStatus.valueOf(a()) : (HttpStatus) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            InputStream inputStream = this.f31280f;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            InputStream inputStream2 = this.a;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private InputStream a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, inputStream)) == null) {
            if (this.f31280f == null) {
                this.f31280f = new GZIPInputStream(inputStream);
            }
            return this.f31280f;
        }
        return (InputStream) invokeL.objValue;
    }
}
