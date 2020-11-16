package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public String aGg;
    public List<a> aGh = new ArrayList();
    public boolean aGi;
    public String mName;

    /* loaded from: classes4.dex */
    public static class a {
        public String aGj;
        public int aGk;
        public String ip;
        public String status;
    }

    private int ge(String str) {
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

    public void gf(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aGi = jSONObject.optInt("switch", 1) == 1;
            this.mName = jSONObject.optString("name");
            this.aGg = jSONObject.optString("rname");
            JSONArray optJSONArray = jSONObject.optJSONArray("ipInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aGj = jSONObject2.optString("idc");
                        aVar.ip = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_IP);
                        aVar.aGk = ge(jSONObject2.optString("isp"));
                        aVar.status = jSONObject2.optString("status");
                        this.aGh.add(aVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.aGg, Integer.valueOf(this.aGh.size())));
        for (int i = 0; i < this.aGh.size(); i++) {
            a aVar = this.aGh.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.aGk), aVar.status, aVar.aGj));
        }
        return stringBuffer.toString();
    }
}
