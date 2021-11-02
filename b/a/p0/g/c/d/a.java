package b.a.p0.g.c.d;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
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

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10070e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10071a;

    /* renamed from: b  reason: collision with root package name */
    public String f10072b;

    /* renamed from: c  reason: collision with root package name */
    public String f10073c;

    /* renamed from: d  reason: collision with root package name */
    public long f10074d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-163748767, "Lb/a/p0/g/c/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-163748767, "Lb/a/p0/g/c/d/a;");
                return;
            }
        }
        f10070e = k.f6397a;
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
        this.f10071a = "";
        this.f10073c = "";
        this.f10074d = System.currentTimeMillis();
    }

    public static String d() {
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
            this.f10073c = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public Download b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Download download = new Download();
            download.setUrl(this.f10071a);
            download.setKeyByUser(this.f10072b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apk_id", this.f10073c);
                jSONObject.put("download_time", this.f10074d);
            } catch (JSONException e2) {
                if (f10070e) {
                    e2.printStackTrace();
                }
            }
            download.setFromParam(jSONObject.toString());
            download.setMimetype("application/vnd.android.package-archive");
            download.setWifiOnly(false);
            String d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                download.setSavedPathForUser(d2);
            }
            download.setFileName(System.currentTimeMillis() + ".apk");
            return download;
        }
        return (Download) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10073c : (String) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10074d : invokeV.longValue;
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f10072b = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f10071a = str;
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
        this.f10071a = "";
        this.f10073c = "";
        this.f10074d = System.currentTimeMillis();
        this.f10071a = download.getUrl();
        this.f10072b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f10073c = jSONObject.optString("apk_id");
            this.f10074d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f10070e) {
                e2.printStackTrace();
            }
        }
    }
}
