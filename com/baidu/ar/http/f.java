package com.baidu.ar.http;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f implements IHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g qK;
    public IProgressCallback qN;
    public HttpRequestFactory qW;
    public o qX;
    public k qY;
    public l qZ;

    public f(HttpRequestFactory httpRequestFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRequestFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.qW = httpRequestFactory;
        this.qX = new o();
        this.qY = null;
        g gVar = new g();
        this.qK = gVar;
        gVar.method = "GET";
        gVar.rd = new HashMap();
        this.qK.rc = new h();
        this.qZ = null;
    }

    private IHttpRequest a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, bArr, str)) == null) {
            if (ao(str)) {
                ((n) this.qY).setData(bArr);
            }
            return this;
        }
        return (IHttpRequest) invokeLL.objValue;
    }

    private String a(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, kVar)) == null) ? kVar instanceof n ? "该请求已通过setBody设置请求体数据，不能再使用其他方式添加数据" : kVar instanceof b ? "该请求是FormData方式传输数据，请使用addFormData或addFormField添加请求体数据" : kVar instanceof m ? "该请求是Multipart方式传输数据，请使用addPart、addPartMap或addFile添加请求体数据" : "" : (String) invokeL.objValue;
    }

    private void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, str2) == null) {
            this.qK.rd.put(str, str2);
        }
    }

    private boolean an(String str) {
        InterceptResult invokeL;
        g gVar;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            k kVar = this.qY;
            if (kVar != null && !(kVar instanceof m)) {
                gVar = this.qK;
                str2 = a(kVar);
            } else if (this.qY == null) {
                m mVar = new m();
                this.qY = mVar;
                mVar.a(this.qK.rb);
                m mVar2 = (m) this.qY;
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                mVar2.at(str);
                return true;
            } else if (TextUtils.isEmpty(str)) {
                return true;
            } else {
                m mVar3 = (m) this.qY;
                if (mVar3.isEmpty() || str.equals(mVar3.getBoundary())) {
                    return true;
                }
                gVar = this.qK;
                str2 = "已经添加请求体内容，不能再更改boundary";
            }
            gVar.ap(str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean ao(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            k kVar = this.qY;
            if (kVar != null && !(kVar instanceof n)) {
                this.qK.ap(a(kVar));
                return false;
            }
            if (this.qY == null) {
                n nVar = new n();
                this.qY = nVar;
                nVar.a(this.qK.rb);
            }
            if (TextUtils.isEmpty(str) || this.qK.rd.containsKey("Content-Type")) {
                return true;
            }
            addHeader("Content-Type", str);
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean eL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            k kVar = this.qY;
            if (kVar != null && !(kVar instanceof b)) {
                this.qK.ap(a(kVar));
                return false;
            } else if (this.qY == null) {
                b bVar = new b();
                this.qY = bVar;
                bVar.a(this.qK.rb);
                return true;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private g eM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.qK.hasError()) {
                throw new HttpException(3, this.qK.eN());
            }
            Charset charset = this.qK.rb;
            if (charset != null) {
                addHeader("charset", charset.name());
            }
            try {
                this.qK.url = this.qX.eO();
                if (this.qY != null) {
                    if (!this.qK.rd.containsKey("Content-Type")) {
                        String contentType = this.qY.getContentType();
                        if (!TextUtils.isEmpty(contentType)) {
                            this.qK.rd.put("Content-Type", contentType);
                        }
                    }
                    this.qK.re = this.qY;
                }
                return this.qK;
            } catch (MalformedURLException e2) {
                throw new HttpException(3, e2);
            }
        }
        return (g) invokeV.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (an(null)) {
                ((m) this.qY).h(str, str2);
            }
            return this;
        }
        return (IHttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFile(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (an(null)) {
                ((m) this.qY).a(str, bArr);
            }
            return this;
        }
        return (IHttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormData(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            if (map != null && eL()) {
                b bVar = (b) this.qY;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        bVar.f(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addFormField(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, obj)) == null) {
            if (!TextUtils.isEmpty(str) && obj != null && eL()) {
                ((b) this.qY).f(str, obj.toString());
            }
            return this;
        }
        return (IHttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String[] aq = j.aq(str);
            if (aq == null) {
                this.qK.ap(String.format("Header 格式必须是： \\\"Name: Value\\\". Found: \\\"%s\\\"", str));
                return this;
            }
            addHeader(aq[0], aq[1]);
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addHeaders(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
            if (strArr != null) {
                for (String str : strArr) {
                    addHeader(str);
                }
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPart(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, obj)) == null) {
            if (obj != null && an(null)) {
                ((m) this.qY).g(str, obj.toString());
            }
            return this;
        }
        return (IHttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addPartMap(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, map)) == null) {
            if (map != null && an(null)) {
                m mVar = (m) this.qY;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        mVar.g(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryField(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj)) == null) {
            if (obj != null) {
                this.qX.i(str, obj.toString());
            }
            return this;
        }
        return (IHttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest addQueryMap(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, map)) == null) {
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        this.qX.i(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.qN = null;
            l lVar = this.qZ;
            if (lVar != null) {
                lVar.cancel();
            }
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void enqueue(com.baidu.ar.ihttp.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            l lVar = this.qZ;
            if (lVar != null) {
                lVar.cancel();
            }
            e executor = this.qW.getExecutor();
            try {
                g eM = eM();
                if (eM != null) {
                    this.qZ = executor.a(eM, aVar, this.qN);
                }
            } catch (HttpException e2) {
                this.qZ = executor.a(e2, aVar);
            }
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpResponse execute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            l lVar = this.qZ;
            if (lVar != null) {
                lVar.cancel();
            }
            l a2 = this.qW.getExecutor().a(eM(), this.qN);
            this.qZ = a2;
            return a2.eH();
        }
        return (IHttpResponse) invokeV.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            k kVar = this.qY;
            return (kVar == null || !(kVar instanceof m)) ? setAsMultipart(d.MULTIPART_BOUNDARY) : this;
        }
        return (IHttpRequest) invokeV.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setAsMultipart(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (an(str)) {
                ((m) this.qY).at(str);
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                a(str.getBytes(this.qK.rb), "application/x-www-form-urlencoded");
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, jSONObject)) == null) {
            if (jSONObject != null) {
                a(jSONObject.toString().getBytes(this.qK.rb), "application/json");
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setBody(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bArr)) == null) ? a(bArr, null) : (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setCharset(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charset)) == null) {
            this.qK.rb = charset;
            this.qX.a(charset);
            k kVar = this.qY;
            if (kVar != null) {
                kVar.a(charset);
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setConnectionTimeout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.qK.rc.rg = i2;
            return this;
        }
        return (IHttpRequest) invokeI.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setMethod(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (str != null) {
                this.qK.method = str.toUpperCase();
            }
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public void setProgressCallback(IProgressCallback iProgressCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iProgressCallback) == null) {
            this.qN = iProgressCallback;
        }
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setReadTimeout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            this.qK.rc.rh = i2;
            return this;
        }
        return (IHttpRequest) invokeI.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            this.qX.au(str);
            return this;
        }
        return (IHttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.ar.ihttp.IHttpRequest
    public IHttpRequest setUseCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            this.qK.rc.ri = z;
            return this;
        }
        return (IHttpRequest) invokeZ.objValue;
    }
}
