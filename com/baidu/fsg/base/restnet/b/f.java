package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.fsg.base.restnet.http.HttpStatus;
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
public class f implements com.baidu.fsg.base.restnet.rest.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InputStream f39452a;

    /* renamed from: b  reason: collision with root package name */
    public int f39453b;

    /* renamed from: c  reason: collision with root package name */
    public String f39454c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f39455d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.fsg.base.restnet.http.a f39456e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f39457f;

    public f(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
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
        this.f39452a = inputStream;
        this.f39453b = i2;
        this.f39454c = str;
        this.f39455d = map;
    }

    private InputStream a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, inputStream)) == null) {
            if (this.f39457f == null) {
                this.f39457f = new GZIPInputStream(inputStream);
            }
            return this.f39457f;
        }
        return (InputStream) invokeL.objValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String h2 = a().h();
            return !TextUtils.isEmpty(h2) && h2.contains(AsyncHttpClient.ENCODING_GZIP);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public com.baidu.fsg.base.restnet.http.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f39456e == null) {
                this.f39456e = new com.baidu.fsg.base.restnet.http.a(this.f39455d, false);
            }
            return this.f39456e;
        }
        return (com.baidu.fsg.base.restnet.http.a) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39453b : invokeV.intValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public String c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39454c : (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            InputStream inputStream = this.f39457f;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            InputStream inputStream2 = this.f39452a;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public InputStream d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? e() ? a(this.f39452a) : this.f39452a : (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.e
    public HttpStatus getStatusCode() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? HttpStatus.valueOf(b()) : (HttpStatus) invokeV.objValue;
    }
}
