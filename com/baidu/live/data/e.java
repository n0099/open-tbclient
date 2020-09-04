package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public String aDa;
    public List<a> aDb = new ArrayList();
    public boolean aDc;
    public String mName;

    /* loaded from: classes7.dex */
    public static class a {
        public String aDd;
        public int aDe;
        public String ip;
        public String status;
    }

    private int fM(String str) {
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

    public void fN(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aDc = jSONObject.optInt("switch", 1) == 1;
            this.mName = jSONObject.optString("name");
            this.aDa = jSONObject.optString("rname");
            JSONArray optJSONArray = jSONObject.optJSONArray("ipInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aDd = jSONObject2.optString("idc");
                        aVar.ip = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_IP);
                        aVar.aDe = fM(jSONObject2.optString("isp"));
                        aVar.status = jSONObject2.optString("status");
                        this.aDb.add(aVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.aDa, Integer.valueOf(this.aDb.size())));
        for (int i = 0; i < this.aDb.size(); i++) {
            a aVar = this.aDb.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.aDe), aVar.status, aVar.aDd));
        }
        return stringBuffer.toString();
    }
}
