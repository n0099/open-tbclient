package c.a.p0.h.j.n;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f9798k;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9799b;

    /* renamed from: c  reason: collision with root package name */
    public String f9800c;

    /* renamed from: d  reason: collision with root package name */
    public String f9801d;

    /* renamed from: e  reason: collision with root package name */
    public String f9802e;

    /* renamed from: f  reason: collision with root package name */
    public String f9803f;

    /* renamed from: g  reason: collision with root package name */
    public long f9804g;

    /* renamed from: h  reason: collision with root package name */
    public Download f9805h;

    /* renamed from: i  reason: collision with root package name */
    public String f9806i;

    /* renamed from: j  reason: collision with root package name */
    public String f9807j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1007651952, "Lc/a/p0/h/j/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1007651952, "Lc/a/p0/h/j/n/a;");
                return;
            }
        }
        f9798k = k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f9800c = "";
        this.f9801d = "";
        this.f9802e = "";
        this.f9803f = "";
        this.f9804g = System.currentTimeMillis();
        this.f9806i = "";
        this.f9807j = "";
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "gameCenter/download/apk";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return str;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "gameCenter/download/zip";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return str;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f9800c = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public Download b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Download download = new Download();
            download.setUrl(this.a);
            download.setKeyByUser(this.f9799b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apk_id", this.f9800c);
                jSONObject.put("download_time", this.f9804g);
                jSONObject.put("from_view", this.f9801d);
                jSONObject.put("from_value", this.f9802e);
                jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f9803f);
            } catch (JSONException e2) {
                if (f9798k) {
                    e2.printStackTrace();
                }
            }
            download.setFromParam(jSONObject.toString());
            download.setMimetype("application/vnd.android.package-archive");
            download.setWifiOnly(false);
            String i2 = i();
            if (!TextUtils.isEmpty(i2)) {
                download.setSavedPathForUser(i2);
            }
            download.setFileName(System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            return download;
        }
        return (Download) invokeV.objValue;
    }

    public Download c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Download download = new Download();
            download.setUrl(this.a);
            download.setKeyByUser(this.f9799b);
            download.setMimetype("application/zip");
            download.setWifiOnly(false);
            String n = n();
            if (!TextUtils.isEmpty(n)) {
                download.setSavedPathForUser(n);
            }
            download.setFileName(this.f9806i + ".zip");
            download.setFromParam(this.f9807j);
            return download;
        }
        return (Download) invokeV.objValue;
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f9803f = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f9806i = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f9802e = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f9801d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f9800c : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Download download = this.f9805h;
            if (download == null) {
                return null;
            }
            return download.getFromParam();
        }
        return (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f9804g : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f9799b : (String) invokeV.objValue;
    }

    public a o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f9799b = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public <T> void p(String str, T t) {
        Download download;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, t) == null) || (download = this.f9805h) == null) {
            return;
        }
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            jSONObject.put(str, t);
            this.f9805h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f9807j = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a(@NonNull Download download) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {download};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f9800c = "";
        this.f9801d = "";
        this.f9802e = "";
        this.f9803f = "";
        this.f9804g = System.currentTimeMillis();
        this.f9806i = "";
        this.f9807j = "";
        this.f9805h = download;
        this.a = download.getUrl();
        this.f9799b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f9800c = jSONObject.optString("apk_id");
            this.f9801d = jSONObject.optString("from_view");
            this.f9802e = jSONObject.optString("from_value");
            this.f9803f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f9804g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f9798k) {
                e2.printStackTrace();
            }
        }
    }
}
