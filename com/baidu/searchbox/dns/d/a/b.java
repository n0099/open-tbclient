package com.baidu.searchbox.dns.d.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.dns.d.c;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private HashMap<String, a> U;
    private HashMap<String, a> V;
    private String W;
    private String X;

    public b(String str) {
        this.W = null;
        this.X = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("msg", BdStatsConstant.StatsType.ERROR);
                String optString2 = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                int optInt = jSONObject.optInt("ttl", 60) * 1000;
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                JSONObject optJSONObject2 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
                this.X = jSONObject.optString("version");
                long optLong = jSONObject.optLong("cachetime", System.currentTimeMillis());
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    this.U = new HashMap<>();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject(next);
                        if (optJSONObject3 != null) {
                            JSONArray optJSONArray = optJSONObject3.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                            ArrayList arrayList = new ArrayList(optJSONArray.length());
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.getString(i));
                            }
                            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("ipv6");
                            ArrayList arrayList2 = null;
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                arrayList2 = new ArrayList(optJSONArray2.length());
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    arrayList2.add(optJSONArray2.getString(i2));
                                }
                            }
                            if (!arrayList.isEmpty() || (arrayList2 != null && !arrayList2.isEmpty())) {
                                this.U.put(next, new a(optString, optInt, optString2, optLong, arrayList, arrayList2));
                                if ("httpsdns.baidu.com".equalsIgnoreCase(next) && arrayList.size() > 0) {
                                    c.k((String) arrayList.get(0));
                                    c.a(optLong);
                                }
                            }
                        }
                    }
                }
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    this.V = new HashMap<>();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject(next2);
                        if (optJSONObject4 != null) {
                            JSONArray optJSONArray3 = optJSONObject4.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                            ArrayList arrayList3 = new ArrayList(optJSONArray3.length());
                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                arrayList3.add(optJSONArray3.getString(i3));
                            }
                            if (!arrayList3.isEmpty()) {
                                this.V.put(next2, new a(optString, optInt, optString2, optLong, arrayList3, null));
                            }
                        }
                    }
                    this.W = optJSONObject2.toString();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, a> A() {
        if (this.U != null) {
            return Collections.unmodifiableMap(this.U);
        }
        return null;
    }

    public Map<String, a> B() {
        if (this.V != null) {
            return Collections.unmodifiableMap(this.V);
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
