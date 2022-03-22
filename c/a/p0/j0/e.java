package c.a.p0.j0;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Uri a;

    /* renamed from: b  reason: collision with root package name */
    public String f15564b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f15565c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1698120074, "Lc/a/p0/j0/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1698120074, "Lc/a/p0/j0/e;");
        }
    }

    public e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        g(str);
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f15565c == null) {
                this.f15565c = new Bundle();
            }
            return this.f15565c;
        }
        return (Bundle) invokeV.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? c(str, null) : (String) invokeL.objValue;
    }

    public String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Bundle bundle = this.f15565c;
            return bundle == null ? str2 : bundle.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public Uri d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (Uri) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                this.a.getScheme();
                this.a.getHost();
                String path = this.a.getPath();
                this.f15564b = path;
                if (!TextUtils.isEmpty(path) && this.f15564b.endsWith("/")) {
                    this.f15564b = this.f15564b.substring(0, this.f15564b.length() - 1);
                }
                Set<String> queryParameterNames = this.a.getQueryParameterNames();
                if (queryParameterNames == null || queryParameterNames.isEmpty()) {
                    return true;
                }
                if (this.f15565c == null) {
                    this.f15565c = new Bundle();
                }
                for (String str : queryParameterNames) {
                    String queryParameter = this.a.getQueryParameter(str);
                    this.f15565c.putString(str, queryParameter);
                    if (TextUtils.equals(str, "params") && !TextUtils.isEmpty(queryParameter)) {
                        try {
                            JSONObject jSONObject = new JSONObject(queryParameter);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                this.f15565c.putString(next, jSONObject.optString(next, ""));
                            }
                        } catch (Exception e2) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("builder parseUri e = " + e2.toString());
                            }
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("builder parseUri te = " + th.toString());
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public e f(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            this.a = uri;
            if (uri != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.i("builder uri = " + uri);
                }
                e();
            } else if (BdLog.isDebugMode()) {
                BdLog.i("builder uri = null");
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Uri uri = null;
            try {
                if (!TextUtils.isEmpty(str)) {
                    uri = Uri.parse(str);
                }
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("builder uri e = " + th.toString());
                }
            }
            f(uri);
            return this;
        }
        return (e) invokeL.objValue;
    }
}
