package b.a.p0.f.j.n;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9950i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9951a;

    /* renamed from: b  reason: collision with root package name */
    public String f9952b;

    /* renamed from: c  reason: collision with root package name */
    public String f9953c;

    /* renamed from: d  reason: collision with root package name */
    public String f9954d;

    /* renamed from: e  reason: collision with root package name */
    public String f9955e;

    /* renamed from: f  reason: collision with root package name */
    public String f9956f;

    /* renamed from: g  reason: collision with root package name */
    public long f9957g;

    /* renamed from: h  reason: collision with root package name */
    public Download f9958h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1705857135, "Lb/a/p0/f/j/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1705857135, "Lb/a/p0/f/j/n/a;");
                return;
            }
        }
        f9950i = k.f6397a;
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
        this.f9951a = "";
        this.f9953c = "";
        this.f9954d = "";
        this.f9955e = "";
        this.f9956f = "";
        this.f9957g = System.currentTimeMillis();
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
            this.f9953c = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public Download b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Download download = new Download();
            download.setUrl(this.f9951a);
            download.setKeyByUser(this.f9952b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apk_id", this.f9953c);
                jSONObject.put("download_time", this.f9957g);
                jSONObject.put("from_view", this.f9954d);
                jSONObject.put("from_value", this.f9955e);
                jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f9956f);
            } catch (JSONException e2) {
                if (f9950i) {
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
            this.f9956f = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f9955e = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f9954d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9953c : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Download download = this.f9958h;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f9957g : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f9951a : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f9952b : (String) invokeV.objValue;
    }

    public a l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f9952b = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public <T> void m(String str, T t) {
        Download download;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, str, t) == null) || (download = this.f9958h) == null) {
            return;
        }
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            jSONObject.put(str, t);
            this.f9958h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f9951a = str;
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
        this.f9951a = "";
        this.f9953c = "";
        this.f9954d = "";
        this.f9955e = "";
        this.f9956f = "";
        this.f9957g = System.currentTimeMillis();
        this.f9958h = download;
        this.f9951a = download.getUrl();
        this.f9952b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f9953c = jSONObject.optString("apk_id");
            this.f9954d = jSONObject.optString("from_view");
            this.f9955e = jSONObject.optString("from_value");
            this.f9956f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f9957g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f9950i) {
                e2.printStackTrace();
            }
        }
    }
}
