package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";
    public transient /* synthetic */ FieldHolder $fh;
    public AsyncHttpClient b;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, String str2);

        void a(String str);

        void a(boolean z, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(724782158, "Lcom/baidu/mapsdkplatform/comapi/map/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(724782158, "Lcom/baidu/mapsdkplatform/comapi/map/f;");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(730932880, "Lcom/baidu/mapsdkplatform/comapi/map/f$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(730932880, "Lcom/baidu/mapsdkplatform/comapi/map/f$b;");
                    return;
                }
            }
            a = new f(null);
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new AsyncHttpClient();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (f) invokeV.objValue;
    }

    public /* synthetic */ f(g gVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            BufferedReader bufferedReader = null;
            if (context == null) {
                return null;
            }
            File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
            if (!file.exists()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                    return sb.toString();
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, context, str)) == null) {
            if (context == null) {
                return null;
            }
            return context.getFilesDir().getAbsolutePath() + File.separator + "sc_sty_" + str + ".sty";
        }
        return (String) invokeLL.objValue;
    }

    private String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, context, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(a(context));
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = ((JSONObject) jSONArray.opt(i)).optString(str);
                    if (!TextUtils.isEmpty(optString)) {
                        return optString;
                    }
                }
                return "";
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    private String a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, this, context, str, z)) == null) {
            if (context == null) {
                return "";
            }
            String b2 = b(context, str);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(MapBundleKey.MapObjKey.OBJ_STYLE_ID, str);
            if (z) {
                linkedHashMap.put("type", "publish");
            } else {
                linkedHashMap.put("type", StatKey.EDITADDR_TAG_STAGE_EDIT);
            }
            linkedHashMap.put("md5", b2);
            linkedHashMap.put("token", SyncSysInfo.getAuthToken());
            return b("api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle") + "?" + ((a(linkedHashMap) + SyncSysInfo.getPhoneInfo()) + "&sign=" + AppMD5.getSignMD5String(str2));
        }
        return (String) invokeLLZ.objValue;
    }

    private String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, map)) == null) {
            if (map.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String str : map.keySet()) {
                String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(map.get(str));
                if (i == 0) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(encodeUrlParamsValue);
                } else {
                    sb.append("&");
                    sb.append(str);
                    sb.append("=");
                    sb.append(encodeUrlParamsValue);
                }
                i++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) {
        JSONArray jSONArray;
        PrintWriter printWriter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65545, this, context, str, str2) != null) || context == null) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        String a2 = a(context);
        PrintWriter printWriter2 = null;
        try {
            try {
                if (TextUtils.isEmpty(a2)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(a2);
                }
                int length = jSONArray.length();
                if (length == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, str2);
                    jSONArray.put(jSONObject);
                } else {
                    int i = 0;
                    JSONObject jSONObject2 = null;
                    while (true) {
                        if (i < length) {
                            jSONObject2 = (JSONObject) jSONArray.opt(i);
                            if (jSONObject2 != null && jSONObject2.has(str)) {
                                break;
                            }
                            i++;
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1 && jSONObject2 != null) {
                        jSONObject2.put(str, str2);
                        jSONArray.put(i, jSONObject2);
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(str, str2);
                        jSONArray.put(jSONObject3);
                    }
                }
                printWriter = new PrintWriter(new FileWriter(file.getAbsoluteFile()));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            printWriter.write(jSONArray.toString());
            printWriter.close();
        } catch (Exception e2) {
            e = e2;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    private void a(Context context, String str, String str2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, this, context, str, str2, aVar) == null) {
            this.b.get(str, new g(this, context, str2, aVar));
        }
    }

    private void a(Context context, String str, String str2, String str3, a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65547, this, context, str, str2, str3, aVar) == null) && !TextUtils.isEmpty(str) && context != null) {
            String b2 = b(str);
            String a2 = a(context, str2);
            String absolutePath = context.getFilesDir().getAbsolutePath();
            new com.baidu.mapsdkplatform.comapi.commonutils.a.c().a(b2, absolutePath, str2 + ".zip", 2, new h(this, context, str2, aVar, str3, a2));
        }
    }

    private void a(Context context, String str, boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{context, str, Boolean.valueOf(z), aVar}) == null) {
            String a2 = a(context, str);
            if (!a(a2)) {
                a2 = null;
            }
            if (aVar != null) {
                aVar.a(a2);
            }
            if (!NetworkUtil.isNetworkAvailable(context)) {
                if (aVar != null) {
                    aVar.a(HttpClient.HttpStateError.NETWORK_ERROR.ordinal(), HttpClient.HttpStateError.NETWORK_ERROR.name(), a2);
                }
            } else if (TextUtils.isEmpty(str)) {
            } else {
                String a3 = a(context, str, z);
                if (TextUtils.isEmpty(a3)) {
                    Log.e(a, "build request url failed");
                } else {
                    a(context, a3, str, aVar);
                }
            }
        }
    }

    private boolean a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, this, i, str)) == null) {
            if (103 == i && a(str)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, File file, String str) {
        InterceptResult invokeLLL;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, this, context, file, str)) == null) {
            if (file == null || context == null) {
                return false;
            }
            ZipFile zipFile2 = null;
            try {
                try {
                    try {
                        zipFile = new ZipFile(file.getAbsoluteFile());
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                } catch (IllegalStateException e3) {
                    e = e3;
                } catch (NullPointerException e4) {
                    e = e4;
                } catch (SecurityException e5) {
                    e = e5;
                } catch (ZipException e6) {
                    e = e6;
                } catch (Exception unused) {
                }
            } catch (IOException e7) {
                Log.e(a, "Close zipFile failed", e7);
            }
            try {
                ZipEntry entry = zipFile.getEntry(str + ".sty");
                if (entry == null) {
                    try {
                        zipFile.close();
                    } catch (IOException e8) {
                        Log.e(a, "Close zipFile failed", e8);
                    }
                    return false;
                }
                boolean a2 = a(zipFile.getInputStream(entry), new FileOutputStream(new File(a(context, str))));
                file.delete();
                try {
                    zipFile.close();
                } catch (IOException e9) {
                    Log.e(a, "Close zipFile failed", e9);
                }
                return a2;
            } catch (FileNotFoundException e10) {
                e = e10;
                zipFile2 = zipFile;
                Log.e(a, "unzip style file FileNotFoundException", e);
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return false;
            } catch (IOException e11) {
                e = e11;
                zipFile2 = zipFile;
                Log.e(a, "unzip style file IOException", e);
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return false;
            } catch (IllegalStateException e12) {
                e = e12;
                zipFile2 = zipFile;
                Log.e(a, "unzip style file IllegalStateException", e);
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return false;
            } catch (NullPointerException e13) {
                e = e13;
                zipFile2 = zipFile;
                Log.e(a, "unzip style file NullPointerException", e);
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return false;
            } catch (SecurityException e14) {
                e = e14;
                zipFile2 = zipFile;
                Log.e(a, "unzip style file SecurityException", e);
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return false;
            } catch (ZipException e15) {
                e = e15;
                zipFile2 = zipFile;
                Log.e(a, "unzip style file ZipException", e);
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return false;
            } catch (Exception unused2) {
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e16) {
                        Log.e(a, "Close zipFile failed", e16);
                    }
                }
                throw th;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    private boolean a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException, NullPointerException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, this, inputStream, fileOutputStream)) == null) {
            if (inputStream == null || fileOutputStream == null) {
                return false;
            }
            byte[] bArr = new byte[4096];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        Log.e(a, "Close InputStream error", e);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        Log.e(a, "Close OutputStream error", e2);
                    }
                    throw th;
                }
            }
            fileOutputStream.flush();
            try {
                inputStream.close();
            } catch (IOException e3) {
                Log.e(a, "Close InputStream error", e3);
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e4) {
                Log.e(a, "Close OutputStream error", e4);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, str)) == null) {
            if (HttpClient.isHttpsEnable) {
                return "https://" + str;
            }
            return "http://" + str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, String str2, a aVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, this, context, str, str2, aVar) == null) {
            String a2 = a(context, str2);
            if (a(a2)) {
                str3 = a2;
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str)) {
                if (aVar != null) {
                    aVar.a(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), HttpClient.HttpStateError.SERVER_ERROR.name(), str3);
                    return;
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("status");
                String optString = jSONObject.optString("message");
                if (!a(optInt, a2)) {
                    if (aVar != null) {
                        aVar.a(false, str3);
                    }
                } else if (optInt != 0) {
                    if (aVar != null) {
                        aVar.a(optInt, optString, str3);
                    }
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        a(context, optJSONObject.optString("pb_url", ""), str2, optJSONObject.optString("md5", ""), aVar);
                    } else if (aVar != null) {
                        aVar.a(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", str3);
                    }
                }
            } catch (JSONException unused) {
                if (aVar != null) {
                    aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", str3);
                }
            }
        }
    }

    public void a(Context context, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, aVar) == null) {
            a(context, str, true, aVar);
        }
    }
}
