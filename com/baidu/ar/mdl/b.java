package com.baidu.ar.mdl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<a> cD;

    public b() {
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
        this.cD = new SparseArray<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return sb2;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    private void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65538, this, str, str2, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int i3 = jSONObject.getInt("type");
                JSONArray jSONArray2 = jSONObject.getJSONArray("models");
                int length2 = jSONArray2.length();
                a aVar = new a();
                aVar.type = i3;
                aVar.f4226tv = z;
                aVar.tw = new String[length2];
                for (int i4 = 0; i4 < length2; i4++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                    int optInt = jSONObject2.optInt(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, i4);
                    File file = new File(str2, jSONObject2.getString("dir"));
                    String optString = jSONObject2.optString("design_model", "");
                    if (!TextUtils.isEmpty(optString)) {
                        file = new File(file, optString);
                    }
                    String absolutePath = file.getAbsolutePath();
                    if (z) {
                        absolutePath = absolutePath.substring(1);
                    }
                    aVar.tw[optInt] = absolutePath;
                }
                try {
                    this.cD.put(i3, aVar);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return;
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open(str), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(String str, Context context) {
        String a2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, context) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            a2 = d(context, str + "dl_config.json");
            z = true;
        } else {
            a2 = a(new File(str, "dl_config.json"));
            z = false;
        }
        a(a2, str, z);
    }

    public SparseArray<a> fm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cD : (SparseArray) invokeV.objValue;
    }
}
