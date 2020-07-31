package com.baidu.ar.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static Map<String, Integer> bW = new HashMap();

    public static int ae() {
        if (bW.size() <= 0) {
            p("{\n  \"high\": [\n    \"kirin990\",\n    \"Qualcomm Technologies, Inc SDM855\",\n    \"Qualcomm Technologies, Inc SM8150\",\n    \"kirin980\",\n    \"Qualcomm Technologies, Inc SDM845\",\n    \"kirin970\",\n    \"Qualcomm Technologies, Inc SDM730\",\n    \"Qualcomm Technologies, Inc MSM8998\",\n    \"hi3660\",\n    \"Qualcomm Technologies, Inc SDM712\",\n    \"kirin960\",\n    \"Qualcomm Technologies, Inc SDM710\",\n    \"Qualcomm Technologies, Inc SDM675\",\n    \"MT6799\",\n    \"MT6785\",\n    \"MT6779\",\n    \"Qualcomm Technologies, Inc SDM670\",\n    \"Qualcomm Technologies, Inc MSM8996\",\n    \"MT6775\",\n    \"MT6771V/C\",\n    \"Qualcomm Technologies, Inc SDM665\",\n    \"Hisilicon Kirin 955\",\n    \"Qualcomm Technologies, Inc SDM660\"\n  ],\n  \"medium\": [\n    \"sailfish\",\n    \"Qualcomm Technologies, Inc SDM636\",\n    \"hi3650\",\n    \"Qualcomm Technologies, Inc MSM8994\",\n    \"MT6797\",\n    \"MT6758\",\n    \"MT6763\",\n    \"MT6762\",\n    \"MT6757\",\n    \"MT6795\",\n    \"MT6755\",\n    \"Qualcomm Technologies, Inc MSM8976SG\",\n    \"Qualcomm Technologies, Inc MSM8976\",\n    \"Qualcomm Technologies, Inc MSM8965\",\n    \"Qualcomm Technologies, Inc MSM8956\",\n    \"Qualcomm Technologies, Inc MSM8992\",\n    \"hi3635\",\n    \"Qualcomm Technologies, Inc 626\",\n    \"Qualcomm Technologies, Inc MSM8953\"\n  ],\n  \"low\": [\n    \"Qualcomm Technologies, Inc MSM8940\",\n    \"Qualcomm Technologies, Inc MSM8974\",\n    \"hi3630\"\n  ],\n  \"blackList\": []\n}");
        }
        String str = af().get("Hardware");
        if (TextUtils.isEmpty(str) || !bW.containsKey(str)) {
            return 0;
        }
        return bW.get(str).intValue();
    }

    private static Map<String, String> af() {
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
                    String replace = split[0].trim().replace(" ", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    String str = replace.equals("model_name") ? "cpu_model" : replace;
                    String trim = split[1].trim();
                    if (str.equals("cpu_model")) {
                        trim = trim.replaceAll("\\s+", " ");
                    }
                    hashMap.put(str, trim);
                }
            }
            bufferedReader.close();
            if (!hashMap.keySet().contains("Hardware")) {
                hashMap.put("Hardware", Build.HARDWARE);
            }
            com.baidu.ar.f.b.b("DEVICE_INFO", (String) hashMap.get("Hardware"));
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void p(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("high");
            for (int i = 0; i < jSONArray.length(); i++) {
                bW.put(jSONArray.get(i).toString(), 2);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("medium");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                bW.put(jSONArray2.get(i2).toString(), 1);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray(Config.EXCEPTION_MEMORY_LOW);
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                bW.put(jSONArray3.get(i3).toString(), 0);
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray("blackList");
            for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                bW.put(jSONArray4.get(i4).toString(), -1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
