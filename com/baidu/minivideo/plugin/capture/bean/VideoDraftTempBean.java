package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class VideoDraftTempBean {
    public String mFilterId;
    public String mPath;
    public float mSpeed;
    public String mStickerId;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", this.mPath);
            jSONObject.put("speed", this.mSpeed);
            jSONObject.put("sticker", this.mStickerId);
            jSONObject.put(FilterImageAction.ACTION_NAME, this.mFilterId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String toJsonString(VideoDraftTempBean videoDraftTempBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", videoDraftTempBean.mPath);
            jSONObject.put("speed", videoDraftTempBean.mSpeed);
            jSONObject.put("sticker", videoDraftTempBean.mStickerId);
            jSONObject.put(FilterImageAction.ACTION_NAME, videoDraftTempBean.mFilterId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static List<VideoDraftTempBean> arrayToBean(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray != null && jSONArray.length() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    VideoDraftTempBean videoDraftTempBean = new VideoDraftTempBean();
                    JSONObject jSONObject = new JSONObject((String) jSONArray.get(i2));
                    videoDraftTempBean.mPath = jSONObject.optString("path");
                    videoDraftTempBean.mSpeed = jSONObject.optInt("speed");
                    videoDraftTempBean.mStickerId = jSONObject.optString("sticker");
                    videoDraftTempBean.mFilterId = jSONObject.optString(FilterImageAction.ACTION_NAME);
                    arrayList.add(videoDraftTempBean);
                    i = i2 + 1;
                }
            }
        } catch (JSONException e) {
        }
        return arrayList;
    }

    public static JSONArray getStickersFilters(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject = new JSONObject((String) jSONArray2.get(i2));
                    if (i == 1) {
                        String optString = jSONObject.optString("sticker");
                        if (!TextUtils.isEmpty(optString) && !hashSet.contains(optString)) {
                            hashSet.add(optString);
                            jSONArray.put(optString);
                        }
                    } else if (i == 2) {
                        String optString2 = jSONObject.optString(FilterImageAction.ACTION_NAME);
                        if (!TextUtils.isEmpty(optString2) && !hashSet.contains(optString2)) {
                            hashSet.add(optString2);
                            jSONArray.put(optString2);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
        return jSONArray;
    }
}
