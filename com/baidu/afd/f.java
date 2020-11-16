package com.baidu.afd;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static e j(JSONObject jSONObject, String str) throws ParseError {
        if (jSONObject == null) {
            throw new ParseError(1, "afd/entry retun null");
        }
        if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, 0) > 0) {
            return new e();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("res");
        if (optJSONObject == null) {
            throw new ParseError(1, "root missing key res");
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(MapBundleKey.MapObjKey.OBJ_AD);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            throw new ParseError(1, "res missing key ad");
        }
        return k(optJSONArray.optJSONObject(0), str);
    }

    private static e k(JSONObject jSONObject, String str) throws ParseError {
        String str2;
        if (jSONObject == null) {
            throw new ParseError(1, "ad has no element");
        }
        String optString = jSONObject.optString("locCode");
        if (TextUtils.isEmpty(optString)) {
            throw new ParseError(2, "missing locCode");
        }
        if (str == null || optString.startsWith(str)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                throw new ParseError(1, "first ad has no adInfo");
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            if (optJSONObject == null) {
                throw new ParseError(1, "adInfo array has no element");
            }
            boolean z = optJSONObject.optInt("advisible", 1) == 0;
            if (z) {
                str2 = optJSONObject.has(UgcConstant.EXT_INFO) ? optJSONObject.optString(UgcConstant.EXT_INFO, null) : null;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("extra");
                if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                    throw new ParseError(1, "adInfo has no extraParams");
                }
                int length = optJSONArray2.length();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        String optString2 = optJSONObject2.optString("k");
                        String optString3 = optJSONObject2.optString("v");
                        if (!TextUtils.isEmpty(optString3) && TextUtils.equals("extraParam", optString2)) {
                            str2 = optString3;
                            break;
                        }
                    }
                    i++;
                }
            }
            if (str2 == null) {
                throw new ParseError(1, "adInfo has no extraParam info");
            }
            if (z) {
                return a.L(str2, str);
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
            if (optJSONArray3 == null || optJSONArray3.length() == 0) {
                throw new ParseError(1, "adInfo has no material info");
            }
            JSONObject optJSONObject3 = optJSONArray3.optJSONObject(0);
            if (optJSONObject3 == null) {
                throw new ParseError(1, "adInfo has no material info");
            }
            try {
                JSONArray jSONArray = new JSONArray(optJSONObject3.optString("info"));
                if (jSONArray.length() == 0) {
                    throw new ParseError(1, "material has no info array");
                }
                JSONObject optJSONObject4 = jSONArray.optJSONObject(0);
                if (optJSONObject4 == null) {
                    throw new ParseError(1, "info array has no first element");
                }
                e eVar = new e();
                eVar.YV = z;
                eVar.YW = com.baidu.tieba.lego.card.b.Nh(optJSONObject4.optJSONObject("lego_card").toString());
                eVar.ext = str2;
                return eVar;
            } catch (JSONException e) {
                throw new ParseError(1, "material has no info array");
            }
        }
        return null;
    }
}
