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
/* loaded from: classes11.dex */
public class c implements Cloneable {
    public List<l> aYX;
    public long aYz;
    public String appId;
    public boolean beA;
    public JSONObject beB;
    public long beC;
    public long beD;
    private long beE;
    public boolean beF;
    public String beG;
    private boolean beH;
    public boolean beI;
    public boolean beJ;
    public boolean beK;
    public r beL;
    public boolean beM;
    public String beN;
    public boolean bew;
    public g bex;
    public String bey;
    public int bez;
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
        this.bew = false;
        this.bey = "";
        this.followCount = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.beD = 0L;
        this.beH = true;
        this.beI = false;
        this.beJ = false;
        this.beK = false;
        this.beM = false;
        this.giftId = str;
        this.beC = j;
        this.bex = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.beF = z;
        this.beG = str7;
        this.appId = str8;
        this.msgId = j2;
        this.beA = z2;
        this.beB = jSONObject;
        this.aYX = new ArrayList();
        this.beL = new r();
        if (jSONObject != null) {
            this.beL.parserJson(jSONObject);
            this.beK = jSONObject.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) && this.beL.aZn == 1;
        }
        Jl();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this(str, j, gVar, str2, str3, str4, str5, str6, z, str7, str8, j2, false, null);
    }

    public void aP(long j) {
        this.beE = j;
    }

    public long Jk() {
        return this.beE;
    }

    private void Jl() {
        this.bey = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String Jm() {
        return this.bey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Jn */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Jo() {
        return this.beH;
    }

    public void bW(boolean z) {
        this.beH = z;
    }

    /* loaded from: classes11.dex */
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
                if (cVar.bex != null && cVar2.bex != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.bex.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.bex.getPrice());
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
