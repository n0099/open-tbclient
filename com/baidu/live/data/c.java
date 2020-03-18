package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public String Xw;
    public List<a> Xx = new ArrayList();
    public String mName;

    /* loaded from: classes3.dex */
    public static class a {
        public String Xy;
        public int Xz;
        public String ip;
        public String status;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("mName:%s, mRanme:%s mIpList.size():%d\n", this.mName, this.Xw, Integer.valueOf(this.Xx.size())));
        for (int i = 0; i < this.Xx.size(); i++) {
            a aVar = this.Xx.get(i);
            stringBuffer.append(String.format("ip:%s isp:%d status:%s idc:%s\n", aVar.ip, Integer.valueOf(aVar.Xz), aVar.status, aVar.Xy));
        }
        return stringBuffer.toString();
    }
}
