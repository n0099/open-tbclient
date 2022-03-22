package c.a.n0.g.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f8217b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.g.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0639a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Response a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8218b;

        public C0639a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8218b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (a.a) {
                    Log.d("SwanAppExchanger", "startLaunchAction onSuccess result: " + str);
                    Log.d("SwanAppExchanger", "startLaunchAction onSuccess status: " + i);
                }
                if (i != 200) {
                    String f2 = a.f(this.a);
                    if (!TextUtils.isEmpty(f2)) {
                        b.a(f2);
                        return;
                    }
                    a.d("get launch scheme fail: request fail with code " + i, this.f8218b, str, true);
                    return;
                }
                try {
                    b.a(new JSONObject(str).optString("data"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    a.d("get launch scheme fail: " + e2.getMessage(), this.f8218b, str, false);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                a.d("get launch scheme fail: network err with exception: " + exc.getMessage(), this.f8218b, "", true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.StringResponseCallback, com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                this.a = response;
                return super.parseResponse(response, i);
            }
            return (String) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1867336656, "Lc/a/n0/g/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1867336656, "Lc/a/n0/g/h/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f8217b = SchemeConfig.getSchemeHead() + "://";
    }

    public static void d(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            if (z) {
                e.g(AppRuntime.getAppContext(), "打开失败，请检查网络设置").G();
            }
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(1L);
            aVar.i(12L);
            aVar.f(str);
            c.a.n0.a.k2.e.a().f(aVar);
            if (a) {
                Log.w("SwanAppExchanger", "open aiapp fail, url : " + str2);
            }
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().setHeader("Swan-Accept", "swan/json").userAgent(c.a.n0.a.m2.a.a()).url(str).build().executeAsyncOnUIBack(new C0639a(str));
        }
    }

    public static String f(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, response)) == null) {
            if (response == null) {
                return null;
            }
            String header = response.header(Headers.LOCATION);
            if (!TextUtils.isEmpty(header) && header.startsWith("baiduboxapp://")) {
                return header.replace("baiduboxapp://", f8217b);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
