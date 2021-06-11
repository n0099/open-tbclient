package com.baidu.searchbox.dns.d.a;

import android.text.TextUtils;
import com.baidu.searchbox.dns.d.c;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public HashMap<String, a> U;
    public HashMap<String, a> V;
    public String W;
    public String X;

    public b(String str) {
        String str2;
        JSONObject jSONObject;
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        this.W = null;
        this.X = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("msg", "error");
            String optString2 = jSONObject2.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
            int optInt = jSONObject2.optInt(ResultTB.TTL, 60) * 1000;
            JSONObject optJSONObject = jSONObject2.optJSONObject("data");
            JSONObject optJSONObject2 = jSONObject2.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
            this.X = jSONObject2.optString("version");
            long optLong = jSONObject2.optLong("cachetime", System.currentTimeMillis());
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                this.U = new HashMap<>();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject(next);
                    if (optJSONObject3 != null) {
                        JSONArray optJSONArray = optJSONObject3.optJSONArray("ip");
                        ArrayList arrayList3 = new ArrayList(optJSONArray.length());
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList3.add(optJSONArray.getString(i2));
                        }
                        JSONArray optJSONArray2 = optJSONObject3.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                            arrayList = arrayList2;
                        } else {
                            ArrayList arrayList4 = new ArrayList(optJSONArray2.length());
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                arrayList4.add(optJSONArray2.getString(i3));
                            }
                            arrayList = arrayList4;
                        }
                        if (!arrayList3.isEmpty() || (arrayList != null && !arrayList.isEmpty())) {
                            jSONObject = optJSONObject;
                            str2 = optString2;
                            this.U.put(next, new a(optString, optInt, optString2, optLong, arrayList3, arrayList));
                            if ("httpsdns.baidu.com".equalsIgnoreCase(next) && arrayList3.size() > 0) {
                                c.k((String) arrayList3.get(0));
                                c.a(optLong);
                            }
                        }
                    } else {
                        str2 = optString2;
                        jSONObject = optJSONObject;
                    }
                    optJSONObject = jSONObject;
                    optString2 = str2;
                    arrayList2 = null;
                }
            }
            String str3 = optString2;
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                this.V = new HashMap<>();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject(next2);
                    if (optJSONObject4 != null) {
                        JSONArray optJSONArray3 = optJSONObject4.optJSONArray("ip");
                        ArrayList arrayList5 = new ArrayList(optJSONArray3.length());
                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                            arrayList5.add(optJSONArray3.getString(i4));
                        }
                        if (!arrayList5.isEmpty()) {
                            this.V.put(next2, new a(optString, optInt, str3, optLong, arrayList5, null));
                        }
                    }
                }
                this.W = optJSONObject2.toString();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public Map<String, a> A() {
        HashMap<String, a> hashMap = this.U;
        if (hashMap != null) {
            return Collections.unmodifiableMap(hashMap);
        }
        return null;
    }

    public Map<String, a> B() {
        HashMap<String, a> hashMap = this.V;
        if (hashMap != null) {
            return Collections.unmodifiableMap(hashMap);
        }
        return null;
    }

    public String C() {
        return this.W;
    }

    public String D() {
        return this.X;
    }
}
