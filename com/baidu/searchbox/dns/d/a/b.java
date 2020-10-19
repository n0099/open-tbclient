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
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class b {
    private HashMap<String, a> T;
    private HashMap<String, a> U;
    private boolean V;
    private String W;
    private String X;
    private boolean o;

    public b(String str) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        this.V = false;
        this.o = false;
        this.W = null;
        this.X = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("msg", BdStatsConstant.StatsType.ERROR);
                String optString2 = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                int optInt = jSONObject.optInt("ttl", 60) * 1000;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                JSONObject optJSONObject3 = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
                JSONObject optJSONObject4 = jSONObject.optJSONObject("ext-info");
                this.X = jSONObject.optString("version");
                long optLong = jSONObject.optLong("cachetime", System.currentTimeMillis());
                if (optJSONObject2 != null) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject5 = optJSONObject2.optJSONObject(next);
                        if (optJSONObject5 != null) {
                            JSONArray optJSONArray2 = optJSONObject5.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                            ArrayList arrayList = new ArrayList(optJSONArray2.length());
                            for (int i = 0; i < optJSONArray2.length(); i++) {
                                arrayList.add(optJSONArray2.getString(i));
                            }
                            JSONArray optJSONArray3 = optJSONObject5.optJSONArray("ipv6");
                            ArrayList arrayList2 = null;
                            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                arrayList2 = new ArrayList(optJSONArray3.length());
                                for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                                    arrayList2.add(optJSONArray3.getString(i2));
                                }
                            }
                            if (!arrayList.isEmpty() || (arrayList2 != null && !arrayList2.isEmpty())) {
                                a aVar = new a(optString, optInt, optString2, optLong, arrayList, arrayList2);
                                if (this.T == null) {
                                    this.T = new HashMap<>();
                                }
                                this.T.put(next, aVar);
                                if ("httpsdns.baidu.com".equalsIgnoreCase(next) && arrayList.size() > 0) {
                                    c.k((String) arrayList.get(0));
                                    c.a(optLong);
                                }
                            }
                        }
                    }
                }
                if (optJSONObject3 != null) {
                    Iterator<String> keys2 = optJSONObject3.keys();
                    this.U = new HashMap<>();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        JSONObject optJSONObject6 = optJSONObject3.optJSONObject(next2);
                        if (optJSONObject6 != null) {
                            JSONArray optJSONArray4 = optJSONObject6.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                            ArrayList arrayList3 = new ArrayList(optJSONArray4.length());
                            for (int i3 = 0; i3 < optJSONArray4.length(); i3++) {
                                arrayList3.add(optJSONArray4.getString(i3));
                            }
                            if (!arrayList3.isEmpty()) {
                                this.U.put(next2, new a(optString, optInt, optString2, optLong, arrayList3, null));
                            }
                        }
                    }
                    this.W = optJSONObject3.toString();
                }
                if (optJSONObject4 != null) {
                    this.V = true;
                    boolean optBoolean = optJSONObject4.optBoolean("ipv6-test-area");
                    this.o = optBoolean;
                    if (optBoolean && (optJSONObject = optJSONObject4.optJSONObject("ipv6-group")) != null) {
                        Iterator<String> keys3 = optJSONObject.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            JSONObject optJSONObject7 = optJSONObject.optJSONObject(next3);
                            if (optJSONObject7 != null && (optJSONArray = optJSONObject7.optJSONArray("ipv6")) != null && optJSONArray.length() > 0) {
                                ArrayList arrayList4 = new ArrayList(optJSONArray.length());
                                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    arrayList4.add(optJSONArray.getString(i4));
                                }
                                JSONArray optJSONArray5 = optJSONObject7.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                                List<String> list = null;
                                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    list = new ArrayList<>(optJSONArray5.length());
                                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                                        list.add(optJSONArray5.getString(i5));
                                    }
                                }
                                if (this.T == null) {
                                    this.T = new HashMap<>();
                                }
                                this.T.put(next3, new a(optString, optInt, optString2, optLong, (list == null || list.isEmpty()) ? this.T.get(next3).getIpList() : list, arrayList4));
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, a> B() {
        if (this.T != null) {
            return Collections.unmodifiableMap(this.T);
        }
        return null;
    }

    public Map<String, a> C() {
        if (this.U != null) {
            return Collections.unmodifiableMap(this.U);
        }
        return null;
    }

    public String D() {
        return this.W;
    }

    public String E() {
        return this.X;
    }

    public boolean isIPv6TestArea() {
        return this.o;
    }

    public boolean F() {
        return this.V;
    }
}
