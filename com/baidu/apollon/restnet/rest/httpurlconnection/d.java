package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
/* loaded from: classes5.dex */
public class d implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InputStream f38203a;

    /* renamed from: b  reason: collision with root package name */
    public int f38204b;

    /* renamed from: c  reason: collision with root package name */
    public String f38205c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f38206d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.apollon.restnet.http.a f38207e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f38208f;

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
        this.f38203a = inputStream;
        this.f38204b = i2;
        this.f38205c = str;
        this.f38206d = map;
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String g2 = d().g();
            return !TextUtils.isEmpty(g2) && g2.contains(AsyncHttpClient.ENCODING_GZIP);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public int a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38204b : invokeV.intValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public String b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38205c : (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public InputStream c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (g()) {
                return a(this.f38203a);
            }
            return this.f38203a;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.e
    public com.baidu.apollon.restnet.http.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f38207e == null) {
                this.f38207e = new com.baidu.apollon.restnet.http.a(this.f38206d, false);
            }
            return this.f38207e;
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
            InputStream inputStream = this.f38208f;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            InputStream inputStream2 = this.f38203a;
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
            if (this.f38208f == null) {
                this.f38208f = new GZIPInputStream(inputStream);
            }
            return this.f38208f;
        }
        return (InputStream) invokeL.objValue;
    }
}
