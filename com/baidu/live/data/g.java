package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public String aHa;
    public List<a> aHb = new ArrayList();
    public boolean aHc;
    public String mName;

    /* loaded from: classes4.dex */
    public static class a {
        public String aHd;
        public int aHe;
        public String ip;
        public String status;
    }

    private int gg(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.contains("联通")) {
            return 1;
        }
        if (str.contains("移动")) {
            return 2;
        }
        return str.contains("电信") ? 3 : 0;
    }

    public void gh(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aHc = jSONObject.optInt("switch", 1) == 1;
            this.mName = jSONObject.optString("name");
            this.aHa = jSONObject.optString("rname");
            JSONArray optJSONArray = jSONObject.optJSONArray("ipInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aHd = jSONObject2.optString("idc");
                        aVar.ip = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_IP);
                        aVar.aHe = gg(jSONObject2.optString("isp"));
                        aVar.status = jSONObject2.optString("status");
                        this.aHb.add(aVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.aHa, Integer.valueOf(this.aHb.size())));
        for (int i = 0; i < this.aHb.size(); i++) {
            a aVar = this.aHb.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.aHe), aVar.status, aVar.aHd));
        }
        return stringBuffer.toString();
    }
}
