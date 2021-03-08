package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.utils.s;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements Cloneable {
    public long aYr;
    public long aZL;
    public String appId;
    public g bep;
    public int ber;
    public long bev;
    private long bex;
    public boolean bey;
    public String bez;
    public String boO;
    public boolean caD;
    public int caE;
    public boolean caF;
    public String chatMCastId;
    public String description;
    public String ensureMCastId;
    public String giftId;
    public String groupId;
    public String liveId;
    public long msgId;
    public String portrait;
    public int sex;
    public String userId;
    public String userName;
    public int userStatus;
    public boolean beo = false;
    public String beq = "";
    public long followCount = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long bew = 0;
    private boolean beA = true;
    public boolean beB = false;
    public boolean beC = false;
    public boolean beF = false;
    public List<l> aYP = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9, long j3) {
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
        this.aZL = j3;
        this.boO = str9;
        GJ();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10, long j3) {
        this.giftId = str;
        this.bev = j;
        this.bep = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.ber = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.bey = z;
        this.aZL = j3;
        this.bez = str8;
        this.appId = str9;
        this.msgId = j2;
        this.boO = str10;
        GJ();
    }

    public void aS(long j) {
        this.bex = j;
    }

    public long GI() {
        return this.bex;
    }

    private void GJ() {
        this.beq = s.a(this.aZL, this.giftId, this.userId, this.boO);
    }

    public String GK() {
        return this.beq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: YT */
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
                        long parseLong = Long.parseLong(cVar.bep.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.bep.getPrice());
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
