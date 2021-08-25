package c.a.o0.f.j.n;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f10706i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10707a;

    /* renamed from: b  reason: collision with root package name */
    public String f10708b;

    /* renamed from: c  reason: collision with root package name */
    public String f10709c;

    /* renamed from: d  reason: collision with root package name */
    public String f10710d;

    /* renamed from: e  reason: collision with root package name */
    public String f10711e;

    /* renamed from: f  reason: collision with root package name */
    public String f10712f;

    /* renamed from: g  reason: collision with root package name */
    public long f10713g;

    /* renamed from: h  reason: collision with root package name */
    public Download f10714h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1598646033, "Lc/a/o0/f/j/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1598646033, "Lc/a/o0/f/j/n/a;");
                return;
            }
        }
        f10706i = k.f7049a;
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
        this.f10707a = "";
        this.f10709c = "";
        this.f10710d = "";
        this.f10711e = "";
        this.f10712f = "";
        this.f10713g = System.currentTimeMillis();
    }

    public static String g() {
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

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f10709c = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public Download b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Download download = new Download();
            download.setUrl(this.f10707a);
            download.setKeyByUser(this.f10708b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apk_id", this.f10709c);
                jSONObject.put("download_time", this.f10713g);
                jSONObject.put("from_view", this.f10710d);
                jSONObject.put("from_value", this.f10711e);
                jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f10712f);
            } catch (JSONException e2) {
                if (f10706i) {
                    e2.printStackTrace();
                }
            }
            download.setFromParam(jSONObject.toString());
            download.setMimetype("application/vnd.android.package-archive");
            download.setWifiOnly(false);
            String g2 = g();
            if (!TextUtils.isEmpty(g2)) {
                download.setSavedPathForUser(g2);
            }
            download.setFileName(System.currentTimeMillis() + ".apk");
            return download;
        }
        return (Download) invokeV.objValue;
    }

    public a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f10712f = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f10711e = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f10710d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f10709c : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Download download = this.f10714h;
            if (download == null) {
                return null;
            }
            return download.getFromParam();
        }
        return (String) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f10713g : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f10707a : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f10708b : (String) invokeV.objValue;
    }

    public a l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f10708b = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public <T> void m(String str, T t) {
        Download download;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, str, t) == null) || (download = this.f10714h) == null) {
            return;
        }
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            jSONObject.put(str, t);
            this.f10714h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f10707a = str;
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
        this.f10707a = "";
        this.f10709c = "";
        this.f10710d = "";
        this.f10711e = "";
        this.f10712f = "";
        this.f10713g = System.currentTimeMillis();
        this.f10714h = download;
        this.f10707a = download.getUrl();
        this.f10708b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f10709c = jSONObject.optString("apk_id");
            this.f10710d = jSONObject.optString("from_view");
            this.f10711e = jSONObject.optString("from_value");
            this.f10712f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f10713g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f10706i) {
                e2.printStackTrace();
            }
        }
    }
}
