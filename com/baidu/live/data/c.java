package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public String Xm;
    public List<a> Xn = new ArrayList();
    public String mName;

    /* loaded from: classes3.dex */
    public static class a {
        public String Xo;
        public int Xp;
        public String ip;
        public String status;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.Xm, Integer.valueOf(this.Xn.size())));
        for (int i = 0; i < this.Xn.size(); i++) {
            a aVar = this.Xn.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.Xp), aVar.status, aVar.Xo));
        }
        return stringBuffer.toString();
    }
}
