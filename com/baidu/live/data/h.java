package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    public String aJn;
    public List<a> aJo = new ArrayList();
    public boolean aJp;
    public String mName;

    /* loaded from: classes11.dex */
    public static class a {
        public String aJq;
        public int aJr;
        public String ip;
        public String status;
    }

    private int gj(String str) {
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

    public void gk(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aJp = jSONObject.optInt("switch", 1) == 1;
            this.mName = jSONObject.optString("name");
            this.aJn = jSONObject.optString("rname");
            JSONArray optJSONArray = jSONObject.optJSONArray("ipInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aJq = jSONObject2.optString("idc");
                        aVar.ip = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_IP);
                        aVar.aJr = gj(jSONObject2.optString("isp"));
                        aVar.status = jSONObject2.optString("status");
                        this.aJo.add(aVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.aJn, Integer.valueOf(this.aJo.size())));
        for (int i = 0; i < this.aJo.size(); i++) {
            a aVar = this.aJo.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.aJr), aVar.status, aVar.aJq));
        }
        return stringBuffer.toString();
    }
}
