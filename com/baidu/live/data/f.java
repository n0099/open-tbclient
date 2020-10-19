package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String aGP;
    public List<a> aGQ = new ArrayList();
    public boolean aGR;
    public String mName;

    /* loaded from: classes4.dex */
    public static class a {
        public String aGS;
        public int aGT;
        public String ip;
        public String status;
    }

    private int gf(String str) {
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

    public void gg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aGR = jSONObject.optInt("switch", 1) == 1;
            this.mName = jSONObject.optString("name");
            this.aGP = jSONObject.optString("rname");
            JSONArray optJSONArray = jSONObject.optJSONArray("ipInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aGS = jSONObject2.optString("idc");
                        aVar.ip = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_IP);
                        aVar.aGT = gf(jSONObject2.optString("isp"));
                        aVar.status = jSONObject2.optString("status");
                        this.aGQ.add(aVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.aGP, Integer.valueOf(this.aGQ.size())));
        for (int i = 0; i < this.aGQ.size(); i++) {
            a aVar = this.aGQ.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.aGT), aVar.status, aVar.aGS));
        }
        return stringBuffer.toString();
    }
}
