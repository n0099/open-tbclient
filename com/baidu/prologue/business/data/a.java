package com.baidu.prologue.business.data;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.prologue.a.c.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;

    public static List<e> ar(String str, String str2) throws ParseError {
        if (TextUtils.isEmpty(str)) {
            throw new ParseError(1, "afd/entry retun null");
        }
        try {
            return j(new JSONObject(str), str2);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new ParseError(1, "afd/entry retun invalid json");
        }
    }

    public static List<e> j(JSONObject jSONObject, String str) throws ParseError {
        List<e> list;
        List<e> LU;
        if (DEBUG) {
            Log.d("AfdResponseParser", "AFD response : " + jSONObject.toString());
        }
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || jSONObject.optInt(BaseJsonData.TAG_ERRNO, 0) > 0) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("res");
        if (optJSONObject == null) {
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("splash");
        JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
        if (optJSONObject2 != null) {
            String optString = optJSONObject2.optString("cmd");
            SplashStyleRecorder.S(optJSONObject2.optJSONObject("style_desc"));
            if (TextUtils.equals(IMTrack.DbBuilder.ACTION_UPDATE, optString)) {
                list = a(optJSONArray, str, false);
                String optString2 = optJSONObject2.optString("empty_ext_info");
                if (!TextUtils.isEmpty(optString2)) {
                    j.setString("empty_ext_info", optString2);
                } else if (DEBUG) {
                    throw new IllegalStateException("splash empty接口没有empty_ext_info信息");
                }
            } else if (TextUtils.equals("query", optString)) {
                if (optJSONObject2.optInt("isCPC") == 1) {
                    list = a(optJSONArray, str, true);
                } else {
                    String optString3 = optJSONObject2.optString("ukey");
                    if (!TextUtils.isEmpty(optString3) && (LU = d.LU()) != null) {
                        for (e eVar : LU) {
                            if (TextUtils.equals(eVar.bsq, optString3)) {
                                arrayList.add(eVar);
                                list = arrayList;
                                break;
                            }
                        }
                    } else {
                        return arrayList;
                    }
                }
            }
            return list;
        }
        list = arrayList;
        return list;
    }

    private static List<e> a(JSONArray jSONArray, String str, boolean z) throws ParseError {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        List<e> o = e.o(jSONArray);
        if (z) {
            for (e eVar : o) {
                eVar.bsA = true;
            }
        } else {
            new ArrayList();
            HashMap<String, e> LV = d.LV();
            if (LV == null || LV.size() == 0) {
                d.Q(o);
            } else {
                d.LT();
                d.Q(o);
            }
            d.R(o);
        }
        return o;
    }
}
