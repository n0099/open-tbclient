package c.a.b0.u.s;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public URL a;

    /* renamed from: b  reason: collision with root package name */
    public String f2032b;

    /* renamed from: c  reason: collision with root package name */
    public Headers.a f2033c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public c f2034d;

    /* renamed from: e  reason: collision with root package name */
    public Object f2035e;

    /* renamed from: f  reason: collision with root package name */
    public int f2036f;

    /* renamed from: g  reason: collision with root package name */
    public int f2037g;

    /* renamed from: h  reason: collision with root package name */
    public int f2038h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.b0.u.q.b f2039i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2040j;

    public d() {
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
        this.f2040j = true;
        this.f2032b = "GET";
        this.f2033c = new Headers.a();
        new Headers.a();
        this.f2036f = 30000;
        this.f2037g = 30000;
        this.f2038h = 30000;
        this.f2039i = h.a().a(true);
    }

    public d a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.f2033c.a(str, str2);
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public RequestError b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RequestError requestError = this.a == null ? new RequestError("url is null") : null;
            if (this.f2034d != null && !c.a.b0.u.r.a.a(this.f2032b)) {
                requestError = new RequestError("method " + this.f2032b + " must not have a request body.");
            }
            if (this.f2034d == null && c.a.b0.u.r.a.b(this.f2032b)) {
                return new RequestError("method " + this.f2032b + " must have a request body.");
            }
            return requestError;
        }
        return (RequestError) invokeV.objValue;
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e("GET", null);
            return this;
        }
        return (d) invokeV.objValue;
    }

    public d d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            this.f2033c.e(str, str2);
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public d delete(@Nullable c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            e(HttpDelete.METHOD_NAME, cVar);
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d e(String str, @Nullable c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, cVar)) == null) {
            this.f2032b = str;
            this.f2034d = cVar;
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public d f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            e("POST", cVar);
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.f2036f = i2;
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.f2040j = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public d i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f2037g = i2;
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            this.f2038h = i2;
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.a = null;
                return this;
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            try {
                l(new URL(str));
                return this;
            } catch (MalformedURLException | Exception unused) {
                l(null);
                return this;
            }
        }
        return (d) invokeL.objValue;
    }

    public d l(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, url)) == null) {
            this.a = url;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? delete(c.f2026h) : (d) invokeV.objValue;
    }
}
