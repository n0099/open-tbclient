package c.a.r0.h.j.n;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10602b;

    /* renamed from: c  reason: collision with root package name */
    public String f10603c;

    /* renamed from: d  reason: collision with root package name */
    public String f10604d;

    /* renamed from: e  reason: collision with root package name */
    public String f10605e;

    /* renamed from: f  reason: collision with root package name */
    public String f10606f;

    /* renamed from: g  reason: collision with root package name */
    public long f10607g;

    /* renamed from: h  reason: collision with root package name */
    public Download f10608h;

    /* renamed from: i  reason: collision with root package name */
    public String f10609i;

    /* renamed from: j  reason: collision with root package name */
    public String f10610j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-306587374, "Lc/a/r0/h/j/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-306587374, "Lc/a/r0/h/j/n/a;");
                return;
            }
        }
        k = k.a;
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
        this.f10603c = "";
        this.f10604d = "";
        this.f10605e = "";
        this.f10606f = "";
        this.f10607g = System.currentTimeMillis();
        this.f10609i = "";
        this.f10610j = "";
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
            this.f10603c = str;
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
            download.setKeyByUser(this.f10602b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apk_id", this.f10603c);
                jSONObject.put("download_time", this.f10607g);
                jSONObject.put("from_view", this.f10604d);
                jSONObject.put("from_value", this.f10605e);
                jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f10606f);
            } catch (JSONException e2) {
                if (k) {
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
            download.setKeyByUser(this.f10602b);
            download.setMimetype("application/zip");
            download.setWifiOnly(false);
            String n = n();
            if (!TextUtils.isEmpty(n)) {
                download.setSavedPathForUser(n);
            }
            download.setFileName(this.f10609i + ".zip");
            download.setFromParam(this.f10610j);
            return download;
        }
        return (Download) invokeV.objValue;
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f10606f = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f10609i = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f10605e = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f10604d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f10603c : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Download download = this.f10608h;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f10607g : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f10602b : (String) invokeV.objValue;
    }

    public a o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f10602b = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public <T> void p(String str, T t) {
        Download download;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, t) == null) || (download = this.f10608h) == null) {
            return;
        }
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            jSONObject.put(str, t);
            this.f10608h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f10610j = str;
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
        this.f10603c = "";
        this.f10604d = "";
        this.f10605e = "";
        this.f10606f = "";
        this.f10607g = System.currentTimeMillis();
        this.f10609i = "";
        this.f10610j = "";
        this.f10608h = download;
        this.a = download.getUrl();
        this.f10602b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f10603c = jSONObject.optString("apk_id");
            this.f10604d = jSONObject.optString("from_view");
            this.f10605e = jSONObject.optString("from_value");
            this.f10606f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f10607g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (k) {
                e2.printStackTrace();
            }
        }
    }
}
