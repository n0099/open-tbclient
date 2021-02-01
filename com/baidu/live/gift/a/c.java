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
    public long aWR;
    public List<l> aXp;
    public String appId;
    public boolean bcN;
    public g bcO;
    public String bcP;
    public int bcQ;
    public boolean bcR;
    public JSONObject bcS;
    public long bcT;
    public long bcU;
    private long bcV;
    public boolean bcW;
    public String bcX;
    private boolean bcY;
    public boolean bcZ;
    public boolean bda;
    public boolean bdb;
    public r bdc;
    public boolean bdd;
    public String bde;
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
        this.bcN = false;
        this.bcP = "";
        this.followCount = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.bcU = 0L;
        this.bcY = true;
        this.bcZ = false;
        this.bda = false;
        this.bdb = false;
        this.bdd = false;
        this.giftId = str;
        this.bcT = j;
        this.bcO = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.bcW = z;
        this.bcX = str7;
        this.appId = str8;
        this.msgId = j2;
        this.bcR = z2;
        this.bcS = jSONObject;
        this.aXp = new ArrayList();
        this.bdc = new r();
        if (jSONObject != null) {
            this.bdc.parserJson(jSONObject);
            this.bdb = jSONObject.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) && this.bdc.aXF == 1;
        }
        GG();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this(str, j, gVar, str2, str3, str4, str5, str6, z, str7, str8, j2, false, null);
    }

    public void aS(long j) {
        this.bcV = j;
    }

    public long GF() {
        return this.bcV;
    }

    private void GG() {
        this.bcP = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String GH() {
        return this.bcP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: GI */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean GJ() {
        return this.bcY;
    }

    public void bX(boolean z) {
        this.bcY = z;
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
                if (cVar.bcO != null && cVar2.bcO != null) {
                    try {
                        long DU = cVar.bcO.DU();
                        long DU2 = cVar2.bcO.DU();
                        if (DU >= DU2) {
                            return DU == DU2 ? 0 : 1;
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
