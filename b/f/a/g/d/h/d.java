package b.f.a.g.d.h;

import android.text.TextUtils;
import b.f.a.g.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes6.dex */
public class d implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InputStream f30722a;

    /* renamed from: b  reason: collision with root package name */
    public int f30723b;

    /* renamed from: c  reason: collision with root package name */
    public String f30724c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f30725d;

    /* renamed from: e  reason: collision with root package name */
    public b.f.a.g.c.a f30726e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f30727f;

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
        this.f30722a = inputStream;
        this.f30723b = i2;
        this.f30724c = str;
        this.f30725d = map;
    }

    @Override // b.f.a.g.d.e
    public String a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30724c : (String) invokeV.objValue;
    }

    @Override // b.f.a.g.d.e
    public InputStream b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (g()) {
                return a(this.f30722a);
            }
            return this.f30722a;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // b.f.a.g.d.e
    public b.f.a.g.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f30726e == null) {
                this.f30726e = new b.f.a.g.c.a(this.f30725d, false);
            }
            return this.f30726e;
        }
        return (b.f.a.g.c.a) invokeV.objValue;
    }

    @Override // b.f.a.g.d.e
    public HttpStatus d() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? HttpStatus.valueOf(f()) : (HttpStatus) invokeV.objValue;
    }

    @Override // b.f.a.g.d.e
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            InputStream inputStream = this.f30727f;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            InputStream inputStream2 = this.f30722a;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public int f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30723b : invokeV.intValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String a2 = c().a();
            return !TextUtils.isEmpty(a2) && a2.contains(AsyncHttpClient.ENCODING_GZIP);
        }
        return invokeV.booleanValue;
    }

    public final InputStream a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) {
            if (this.f30727f == null) {
                this.f30727f = new GZIPInputStream(inputStream);
            }
            return this.f30727f;
        }
        return (InputStream) invokeL.objValue;
    }
}
