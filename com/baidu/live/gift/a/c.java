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
    public long aTM;
    public List<l> aUk;
    public boolean aZG;
    public g aZH;
    public String aZI;
    public int aZJ;
    public boolean aZK;
    public JSONObject aZL;
    public long aZM;
    public long aZN;
    private long aZO;
    public boolean aZP;
    public String aZQ;
    private boolean aZR;
    public boolean aZS;
    public boolean aZT;
    public boolean aZU;
    public r aZV;
    public boolean aZW;
    public String aZX;
    public String appId;
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
        this.aZG = false;
        this.aZI = "";
        this.followCount = 0L;
        this.fansCount = 0L;
        this.location = "";
        this.priority = 1;
        this.aZN = 0L;
        this.aZR = true;
        this.aZS = false;
        this.aZT = false;
        this.aZU = false;
        this.aZW = false;
        this.giftId = str;
        this.aZM = j;
        this.aZH = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aZP = z;
        this.aZQ = str7;
        this.appId = str8;
        this.msgId = j2;
        this.aZK = z2;
        this.aZL = jSONObject;
        this.aUk = new ArrayList();
        this.aZV = new r();
        if (jSONObject != null) {
            this.aZV.parserJson(jSONObject);
            this.aZU = jSONObject.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) && this.aZV.aUA == 1;
        }
        Fq();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this(str, j, gVar, str2, str3, str4, str5, str6, z, str7, str8, j2, false, null);
    }

    public void aP(long j) {
        this.aZO = j;
    }

    public long Fp() {
        return this.aZO;
    }

    private void Fq() {
        this.aZI = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String Fr() {
        return this.aZI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Fs */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Ft() {
        return this.aZR;
    }

    public void bS(boolean z) {
        this.aZR = z;
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
                if (cVar.aZH != null && cVar2.aZH != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.aZH.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.aZH.getPrice());
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
