package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.gift.r;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements Cloneable {
    public List<l> aYP;
    public long aYr;
    public String appId;
    private boolean beA;
    public boolean beB;
    public boolean beC;
    public boolean beD;
    public r beE;
    public boolean beF;
    public String beG;
    public boolean beo;
    public g bep;
    public String beq;
    public int ber;
    public boolean bes;
    public JSONObject beu;
    public long bev;
    public long bew;
    private long bex;
    public boolean bey;
    public String bez;
    public String chatMCastId;
    public String description;
    public String ensureMCastId;
    public long fansCount;
    public long followCount;
    public String giftId;
    public String groupId;
    public String liveId;
    public String location;
    public long msgId;
    public String portrait;
    public int priority;
    public int sex;
    public String userId;
    public String userName;
    public int userStatus;

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, boolean z2, JSONObject jSONObject) {
        this.beo = false;
        this.beq = "";
        this.followCount = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.bew = 0L;
        this.beA = true;
        this.beB = false;
        this.beC = false;
        this.beD = false;
        this.beF = false;
        this.giftId = str;
        this.bev = j;
        this.bep = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.bey = z;
        this.bez = str7;
        this.appId = str8;
        this.msgId = j2;
        this.bes = z2;
        this.beu = jSONObject;
        this.aYP = new ArrayList();
        this.beE = new r();
        if (jSONObject != null) {
            this.beE.parserJson(jSONObject);
            this.beD = jSONObject.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) && this.beE.aZf == 1;
        }
        GJ();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this(str, j, gVar, str2, str3, str4, str5, str6, z, str7, str8, j2, false, null);
    }

    public void aS(long j) {
        this.bex = j;
    }

    public long GI() {
        return this.bex;
    }

    private void GJ() {
        this.beq = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String GK() {
        return this.beq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: GL */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean GM() {
        return this.beA;
    }

    public void bX(boolean z) {
        this.beA = z;
    }

    /* loaded from: classes10.dex */
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
                if (cVar.bep != null && cVar2.bep != null) {
                    try {
                        long DX = cVar.bep.DX();
                        long DX2 = cVar2.bep.DX();
                        if (DX >= DX2) {
                            return DX == DX2 ? 0 : 1;
                        }
                        return -1;
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }
            return 0;
        }
    }
}
