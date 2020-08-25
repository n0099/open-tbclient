package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public String aCY;
    public List<a> aCZ = new ArrayList();
    public boolean aDa;
    public String mName;

    /* loaded from: classes7.dex */
    public static class a {
        public String aDb;
        public int aDc;
        public String ip;
        public String status;
    }

    private int fL(String str) {
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

    public void fM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aDa = jSONObject.optInt("switch", 1) == 1;
            this.mName = jSONObject.optString("name");
            this.aCY = jSONObject.optString("rname");
            JSONArray optJSONArray = jSONObject.optJSONArray("ipInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aDb = jSONObject2.optString("idc");
                        aVar.ip = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_IP);
                        aVar.aDc = fL(jSONObject2.optString("isp"));
                        aVar.status = jSONObject2.optString("status");
                        this.aCZ.add(aVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.aCY, Integer.valueOf(this.aCZ.size())));
        for (int i = 0; i < this.aCZ.size(); i++) {
            a aVar = this.aCZ.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.aDc), aVar.status, aVar.aDb));
        }
        return stringBuffer.toString();
    }
}
