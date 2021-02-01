package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class s {

    /* loaded from: classes11.dex */
    public static class a {
        public String name;
        public String uk;

        public a(String str, String str2) {
            this.uk = str;
            this.name = str2;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static List<a> m22if(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        arrayList.add(new a(optJSONObject.optString("user_uk"), optJSONObject.optString("user_name")));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static String Vw() {
        AlaWheatInfoData Yl = com.baidu.live.ao.a.Yj().Yl();
        if (Yl != null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("user_uk", Yl.uk);
                jSONObject.put("user_name", Yl.userName);
                jSONArray.put(jSONObject);
                return jSONArray.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String al(List<AlaWheatInfoData> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (AlaWheatInfoData alaWheatInfoData : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("user_uk", alaWheatInfoData.uk);
                    jSONObject.put("user_name", alaWheatInfoData.userName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray.toString();
    }

    public static String a(long j, String str, String str2, String str3) {
        return "" + j + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
    }

    public static final String ig(String str) {
        return !TextUtils.isEmpty(str) ? Base64.encodeBytes(str.getBytes()).replace("+", Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace("/", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).replace("=", "") : "";
    }
}
