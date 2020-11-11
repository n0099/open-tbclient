package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.gift.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public long aVA;
    public List<l> aVY;
    public String appId;
    public boolean bbb;
    public g bbc;
    public String bbd;
    public int bbe;
    public long bbf;
    public boolean bbg;
    public JSONObject bbh;
    public long bbi;
    public long bbj;
    public boolean bbk;
    public String bbl;
    private boolean bbm;
    public boolean bbn;
    public boolean bbo;
    public boolean bbp;
    public q bbq;
    public boolean bbr;
    public String chatMCastId;
    public String description;
    public String ensureMCastId;
    public long fansCount;
    public String giftId;
    public String groupId;
    public String liveId;
    public String location;
    public long msgId;
    public String portrait;
    public int priority;
    private long sendTime;
    public int sex;
    public String userId;
    public String userName;
    public int userStatus;

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this.bbb = false;
        this.bbd = "";
        this.bbf = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.bbj = 0L;
        this.bbm = true;
        this.bbn = false;
        this.bbo = false;
        this.bbp = false;
        this.bbr = false;
        this.giftId = str;
        this.bbi = j;
        this.bbc = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.bbk = z;
        this.bbl = str7;
        this.appId = str8;
        this.msgId = j2;
        this.aVY = new ArrayList();
        this.bbq = new q();
        IB();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, boolean z2, JSONObject jSONObject) {
        this.bbb = false;
        this.bbd = "";
        this.bbf = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.bbj = 0L;
        this.bbm = true;
        this.bbn = false;
        this.bbo = false;
        this.bbp = false;
        this.bbr = false;
        this.giftId = str;
        this.bbi = j;
        this.bbc = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.bbk = z;
        this.bbl = str7;
        this.appId = str8;
        this.msgId = j2;
        this.bbg = z2;
        this.bbh = jSONObject;
        this.aVY = new ArrayList();
        this.bbq = new q();
        if (jSONObject != null) {
            this.bbq.parserJson(jSONObject);
            this.bbp = jSONObject.optString("content_type").equals("tying_gift") && this.bbq.aWm == 1;
        }
        IB();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2) {
        this.bbb = false;
        this.bbd = "";
        this.bbf = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.bbj = 0L;
        this.bbm = true;
        this.bbn = false;
        this.bbo = false;
        this.bbp = false;
        this.bbr = false;
        this.giftId = str;
        this.bbi = j;
        this.bbc = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.bbe = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.bbk = z;
        this.bbl = str8;
        this.appId = str9;
        this.msgId = j2;
        this.aVY = new ArrayList();
        this.bbq = new q();
        IB();
    }

    public void as(long j) {
        this.sendTime = j;
    }

    public long IA() {
        return this.sendTime;
    }

    private void IB() {
        this.bbd = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String IC() {
        return this.bbd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ID */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean IE() {
        return this.bbm;
    }

    public void bN(boolean z) {
        this.bbm = z;
    }

    /* loaded from: classes4.dex */
    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(c cVar, c cVar2) {
            if (cVar != null && cVar2 != null) {
                if (cVar.priority > cVar2.priority) {
                    return 1;
                }
                if (cVar.priority < cVar2.priority) {
                    return -1;
                }
                if (cVar.bbc != null && cVar2.bbc != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.bbc.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.bbc.getPrice());
                        if (parseLong <= parseLong2) {
                            return parseLong < parseLong2 ? -1 : 0;
                        }
                        return 1;
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }
            return 0;
        }
    }
}
