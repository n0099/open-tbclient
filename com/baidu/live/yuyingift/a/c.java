package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.utils.s;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements Cloneable {
    public long aYz;
    public long aZQ;
    public String appId;
    public boolean bZN;
    public int bZO;
    public boolean bZP;
    public long beC;
    private long beE;
    public boolean beF;
    public String beG;
    public g bex;
    public int bez;
    public String boI;
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
    public boolean bew = false;
    public String bey = "";
    public long followCount = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long beD = 0;
    private boolean beH = true;
    public boolean beI = false;
    public boolean beJ = false;
    public boolean beM = false;
    public List<l> aYX = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9, long j3) {
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
        this.aZQ = j3;
        this.boI = str9;
        Jl();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10, long j3) {
        this.giftId = str;
        this.beC = j;
        this.bex = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.bez = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.beF = z;
        this.aZQ = j3;
        this.beG = str8;
        this.appId = str9;
        this.msgId = j2;
        this.boI = str10;
        Jl();
    }

    public void aP(long j) {
        this.beE = j;
    }

    public long Jk() {
        return this.beE;
    }

    private void Jl() {
        this.bey = s.a(this.aZQ, this.giftId, this.userId, this.boI);
    }

    public String Jm() {
        return this.bey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aaS */
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
