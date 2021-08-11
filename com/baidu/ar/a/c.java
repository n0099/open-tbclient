package com.baidu.ar.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.h.q;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Integer> bQ;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1920934134, "Lcom/baidu/ar/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1920934134, "Lcom/baidu/ar/a/c;");
                return;
            }
        }
        bQ = new HashMap();
    }

    public static int ag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (bQ.size() <= 0) {
                s("{\n  \"high\": [\n    \"kirin990\",\n    \"qualcomm technologies, inc sdm855\",\n    \"qualcomm technologies, inc sm8150\",\n    \"kirin980\",\n    \"qualcomm technologies, inc sdm845\",\n    \"kirin810\",\n    \"kirin970\",\n    \"qualcomm technologies, inc sdm730\",\n    \"qualcomm technologies, inc msm8998\",\n    \"hi3660\",\n    \"qualcomm technologies, inc sdm712\",\n    \"kirin960\",\n    \"qualcomm technologies, inc sdm710\",\n    \"qualcomm technologies, inc sdm675\",\n    \"mt6799\",\n    \"mt6785\",\n    \"mt6779\",\n    \"qualcomm technologies, inc sdm670\",\n    \"qualcomm technologies, inc msm8996\",\n    \"mt6775\",\n    \"mt6771v/c\",\n    \"qualcomm technologies, inc sdm665\",\n    \"hisilicon kirin 955\",\n    \"qualcomm technologies, inc sdm660\"\n  ],\n  \"medium\": [\n    \"sailfish\",\n    \"qualcomm technologies, inc sdm636\",\n    \"hi3650\",\n    \"qualcomm technologies, inc msm8994\",\n    \"mt6797\",\n    \"mt6758\",\n    \"mt6763\",\n    \"mt6762\",\n    \"mt6757\",\n    \"mt6795\",\n    \"mt6755\",\n    \"qualcomm technologies, inc msm8976sg\",\n    \"qualcomm technologies, inc msm8976\",\n    \"qualcomm technologies, inc msm8965\",\n    \"qualcomm technologies, inc msm8956\",\n    \"qualcomm technologies, inc msm8992\",\n    \"hi3635\",\n    \"qualcomm technologies, inc 626\",\n    \"qualcomm technologies, inc msm8953\"\n  ],\n  \"low\": [\n    \"qualcomm technologies, inc msm8940\",\n    \"qualcomm technologies, inc msm8974\",\n    \"hi3630\"\n  ],\n  \"blackList\": []\n}");
            }
            String str = ah().get("Hardware");
            if (!TextUtils.isEmpty(str)) {
                String trim = str.toLowerCase().replace("hisilicon", "").trim();
                if (bQ.containsKey(trim)) {
                    return bQ.get(trim).intValue();
                }
            }
            return q.gI() ? 2 : 0;
        }
        return invokeV.intValue;
    }

    public static Map<String, String> ah() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                HashMap hashMap = new HashMap();
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":");
                    if (split.length > 1) {
                        String replace = split[0].trim().replace(" ", "_");
                        if (replace.equals("model_name")) {
                            replace = "cpu_model";
                        }
                        String trim = split[1].trim();
                        if (replace.equals("cpu_model")) {
                            trim = trim.replaceAll("\\s+", " ");
                        }
                        hashMap.put(replace, trim);
                    }
                }
                bufferedReader.close();
                if (!hashMap.keySet().contains("Hardware")) {
                    hashMap.put("Hardware", Build.HARDWARE);
                }
                com.baidu.ar.h.b.b("DEVICE_INFO", (String) hashMap.get("Hardware"));
                return hashMap;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    public static void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("high");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    bQ.put(jSONArray.get(i2).toString(), 2);
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("medium");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    bQ.put(jSONArray2.get(i3).toString(), 1);
                }
                JSONArray jSONArray3 = jSONObject.getJSONArray("low");
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    bQ.put(jSONArray3.get(i4).toString(), 0);
                }
                JSONArray jSONArray4 = jSONObject.getJSONArray("blackList");
                for (int i5 = 0; i5 < jSONArray4.length(); i5++) {
                    bQ.put(jSONArray4.get(i5).toString(), -1);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
