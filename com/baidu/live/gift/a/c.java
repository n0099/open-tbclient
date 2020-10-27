package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import com.baidu.live.gift.r;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public List<m> aUG;
    public long aUi;
    public boolean aZI;
    public g aZJ;
    public String aZK;
    public int aZL;
    public long aZM;
    public boolean aZN;
    public JSONObject aZO;
    public long aZP;
    public long aZQ;
    public boolean aZR;
    public String aZS;
    private boolean aZT;
    public boolean aZU;
    public boolean aZV;
    public boolean aZW;
    public r aZX;
    public boolean aZY;
    public String appId;
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
        this.aZI = false;
        this.aZK = "";
        this.aZM = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.aZQ = 0L;
        this.aZT = true;
        this.aZU = false;
        this.aZV = false;
        this.aZW = false;
        this.aZY = false;
        this.giftId = str;
        this.aZP = j;
        this.aZJ = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aZR = z;
        this.aZS = str7;
        this.appId = str8;
        this.msgId = j2;
        this.aUG = new ArrayList();
        this.aZX = new r();
        Ia();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, boolean z2, JSONObject jSONObject) {
        this.aZI = false;
        this.aZK = "";
        this.aZM = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.aZQ = 0L;
        this.aZT = true;
        this.aZU = false;
        this.aZV = false;
        this.aZW = false;
        this.aZY = false;
        this.giftId = str;
        this.aZP = j;
        this.aZJ = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aZR = z;
        this.aZS = str7;
        this.appId = str8;
        this.msgId = j2;
        this.aZN = z2;
        this.aZO = jSONObject;
        this.aUG = new ArrayList();
        this.aZX = new r();
        if (jSONObject != null) {
            this.aZX.parserJson(jSONObject);
            this.aZW = jSONObject.optString("content_type").equals("tying_gift") && this.aZX.aUU == 1;
        }
        Ia();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2) {
        this.aZI = false;
        this.aZK = "";
        this.aZM = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.aZQ = 0L;
        this.aZT = true;
        this.aZU = false;
        this.aZV = false;
        this.aZW = false;
        this.aZY = false;
        this.giftId = str;
        this.aZP = j;
        this.aZJ = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aZL = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aZR = z;
        this.aZS = str8;
        this.appId = str9;
        this.msgId = j2;
        this.aUG = new ArrayList();
        this.aZX = new r();
        Ia();
    }

    public void ag(long j) {
        this.sendTime = j;
    }

    public long HZ() {
        return this.sendTime;
    }

    private void Ia() {
        this.aZK = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String Ib() {
        return this.aZK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ic */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Id() {
        return this.aZT;
    }

    public void bM(boolean z) {
        this.aZT = z;
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
                if (cVar.aZJ != null && cVar2.aZJ != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.aZJ.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.aZJ.getPrice());
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
