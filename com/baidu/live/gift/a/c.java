package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.gift.r;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public long aWT;
    public List<l> aXs;
    public String appId;
    public boolean bcM;
    public g bcN;
    public String bcO;
    public int bcP;
    public long bcQ;
    public long bcR;
    public boolean bcS;
    public JSONObject bcT;
    public long bcU;
    public long bcV;
    private long bcW;
    public boolean bcX;
    public String bcY;
    private boolean bcZ;
    public boolean bda;
    public boolean bdb;
    public boolean bdc;
    public r bdd;
    public boolean bde;
    public String bdf;
    public String chatMCastId;
    public String description;
    public String ensureMCastId;
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
        this.bcM = false;
        this.bcO = "";
        this.bcQ = 0L;
        this.bcR = 0L;
        this.location = "";
        this.priority = 1;
        this.bcV = 0L;
        this.bcZ = true;
        this.bda = false;
        this.bdb = false;
        this.bdc = false;
        this.bde = false;
        this.giftId = str;
        this.bcU = j;
        this.bcN = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.bcX = z;
        this.bcY = str7;
        this.appId = str8;
        this.msgId = j2;
        this.bcS = z2;
        this.bcT = jSONObject;
        this.aXs = new ArrayList();
        this.bdd = new r();
        if (jSONObject != null) {
            this.bdd.parserJson(jSONObject);
            this.bdc = jSONObject.optString("content_type").equals("tying_gift") && this.bdd.aXI == 1;
        }
        JJ();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this(str, j, gVar, str2, str3, str4, str5, str6, z, str7, str8, j2, false, null);
    }

    public void aQ(long j) {
        this.bcW = j;
    }

    public long JI() {
        return this.bcW;
    }

    private void JJ() {
        this.bcO = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String JK() {
        return this.bcO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: JL */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean JM() {
        return this.bcZ;
    }

    public void bY(boolean z) {
        this.bcZ = z;
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
                if (cVar.bcN != null && cVar2.bcN != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.bcN.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.bcN.getPrice());
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
