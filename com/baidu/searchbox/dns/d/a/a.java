package com.baidu.searchbox.dns.d.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {
    public int B;
    public String C;
    public long D;
    public String R;
    private List<String> S;
    private String T;
    private List<String> m;

    public a(String str, int i, String str2, long j, List<String> list, List<String> list2) {
        this.C = str;
        this.B = i;
        this.R = str2;
        this.D = j;
        this.m = list;
        this.S = list2;
        this.T = z();
    }

    public a(String str) {
        this.T = str;
        if (!TextUtils.isEmpty(this.T)) {
            try {
                JSONObject jSONObject = new JSONObject(this.T);
                this.C = jSONObject.optString("msg", BdStatsConstant.StatsType.ERROR);
                this.R = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                this.B = jSONObject.optInt("ttl", -1);
                this.D = jSONObject.optLong("cachetime", -1L);
                JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                this.m = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.m.add(optJSONArray.getString(i));
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.S = new ArrayList(optJSONArray2.length());
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.S.add(optJSONArray2.getString(i2));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getIpList() {
        if (this.m != null) {
            if (DnsUtil.DEBUG) {
                Log.i(DnsUtil.TAG, " getIp v4 List: " + b(this.m));
            }
            return Collections.unmodifiableList(this.m);
        }
        return null;
    }

    private String z() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) this.m);
            JSONArray jSONArray2 = new JSONArray((Collection) this.S);
            jSONObject.put("msg", this.C);
            jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.R);
            jSONObject.put("ttl", this.B);
            jSONObject.put("cachetime", this.D);
            jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, jSONArray);
            jSONObject.put("ipv6", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return this.T;
    }

    public static String b(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
