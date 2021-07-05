package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CustomMapStyleLoader {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7944a = "CustomMapStyleLoader";

    /* renamed from: c  reason: collision with root package name */
    public static String f7945c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f7946b;

    /* renamed from: d  reason: collision with root package name */
    public Context f7947d;

    /* renamed from: e  reason: collision with root package name */
    public String f7948e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7949f;

    /* renamed from: g  reason: collision with root package name */
    public AsyncHttpClient f7950g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomMapStyleLoader f7951a;

        public a(CustomMapStyleLoader customMapStyleLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customMapStyleLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7951a = customMapStyleLoader;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7951a.b();
                String d2 = this.f7951a.d();
                if (TextUtils.isEmpty(d2)) {
                    Log.e(CustomMapStyleLoader.f7944a, "build request url failed");
                } else {
                    this.f7951a.a(d2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final CustomMapStyleLoader f7952a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(531759901, "Lcom/baidu/mapsdkplatform/comapi/util/CustomMapStyleLoader$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(531759901, "Lcom/baidu/mapsdkplatform/comapi/util/CustomMapStyleLoader$b;");
                    return;
                }
            }
            f7952a = new CustomMapStyleLoader(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1291065317, "Lcom/baidu/mapsdkplatform/comapi/util/CustomMapStyleLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1291065317, "Lcom/baidu/mapsdkplatform/comapi/util/CustomMapStyleLoader;");
        }
    }

    public CustomMapStyleLoader() {
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
        this.f7949f = true;
        this.f7950g = new AsyncHttpClient();
    }

    public /* synthetic */ CustomMapStyleLoader(c cVar) {
        this();
    }

    private String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, map)) == null) {
            if (map.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String str : map.keySet()) {
                String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(map.get(str));
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(str);
                sb.append("=");
                sb.append(encodeUrlParamsValue);
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            this.f7950g.get(str, new c(this));
        }
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, jSONObject) == null) {
            File file = new File(f7945c);
            if (file.exists()) {
                file.delete();
            }
            try {
                if (file.createNewFile()) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                Log.e(f7944a, "create custom file failed", e2);
            }
            String optString = jSONObject.optString("json");
            String optString2 = jSONObject.optString(PackageTable.MD5, StringUtil.NULL_STRING);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("json", optString);
                jSONObject2.put(PackageTable.MD5, optString2);
            } catch (JSONException e3) {
                Log.e(f7944a, "build style data failed", e3);
            }
            String jSONObject3 = jSONObject2.toString();
            try {
                FileOutputStream openFileOutput = this.f7947d.openFileOutput("server_custom_style_file.json", 0);
                openFileOutput.write(jSONObject3.getBytes());
                openFileOutput.flush();
                openFileOutput.close();
            } catch (IOException e4) {
                Log.e(f7944a, "write style data into file failed", e4);
            }
        }
    }

    private boolean a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, this, i2, str)) == null) {
            if (103 == i2 && c()) {
                b(i2, str);
                return false;
            }
            b(i2, str);
            return i2 == 0;
        }
        return invokeIL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (!c()) {
                this.f7946b = StringUtil.NULL_STRING;
                return;
            }
            try {
                FileInputStream openFileInput = this.f7947d.openFileInput("server_custom_style_file.json");
                JsonReader jsonReader = new JsonReader(new InputStreamReader(openFileInput));
                try {
                    try {
                        try {
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if (jsonReader.nextName().equals(PackageTable.MD5)) {
                                    this.f7946b = jsonReader.nextString();
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            jsonReader.close();
                            openFileInput.close();
                        } catch (IOException e2) {
                            this.f7946b = StringUtil.NULL_STRING;
                            Log.e(f7944a, "Read custom style failed", e2);
                            jsonReader.close();
                            openFileInput.close();
                        }
                    } catch (Throwable th) {
                        try {
                            jsonReader.close();
                            openFileInput.close();
                        } catch (IOException e3) {
                            Log.e(f7944a, "Close custom style failed", e3);
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    Log.e(f7944a, "Close custom style failed", e4);
                }
            } catch (FileNotFoundException e5) {
                this.f7946b = StringUtil.NULL_STRING;
                Log.e(f7944a, "Open custom style failed", e5);
            }
        }
    }

    private void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65548, this, i2, str) == null) {
            Intent intent = i2 == 0 ? new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_LOAD_CUSTOM_STYLE_SUCCESS) : new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_LOAD_CUSTOM_STYLE_ERROR);
            intent.putExtra("error_code", i2);
            intent.putExtra("error_message", str);
            this.f7947d.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (a(jSONObject.optInt("status"), jSONObject.optString("message"))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || optJSONObject.length() == 0) {
                    Log.e(f7944a, "custom style data is null");
                } else {
                    a(optJSONObject);
                }
            }
        } catch (JSONException e2) {
            Log.e(f7944a, "parse response result failed", e2);
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? new File(f7945c).exists() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("style_id", this.f7948e);
            linkedHashMap.put("type", this.f7949f ? "publish" : "edit");
            linkedHashMap.put(PackageTable.MD5, this.f7946b);
            linkedHashMap.put("token", i.f7995d);
            return e() + "?" + ((a(linkedHashMap) + i.c()) + "&sign=" + AppMD5.getSignMD5String(str));
        }
        return (String) invokeV.objValue;
    }

    private String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? HttpClient.isHttpsEnable ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle" : "http://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle" : (String) invokeV.objValue;
    }

    public static String getCustomStyleFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? f7945c : (String) invokeV.objValue;
    }

    public static CustomMapStyleLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? b.f7952a : (CustomMapStyleLoader) invokeV.objValue;
    }

    public void initCustomStyleFilePath(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f7947d = context;
            f7945c = context.getFilesDir().getAbsolutePath();
            f7945c += "/server_custom_style_file.json";
        }
    }

    public void loadCustomMapStyleFile(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) && NetworkUtil.isNetworkAvailable(this.f7947d) && !TextUtils.isEmpty(str)) {
            this.f7948e = str;
            this.f7949f = z;
            new Thread(new a(this), "Load custom style").start();
        }
    }
}
