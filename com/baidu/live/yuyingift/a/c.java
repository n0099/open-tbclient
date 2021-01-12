package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.utils.s;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements Cloneable {
    public long aTM;
    public long aVd;
    public g aZH;
    public int aZJ;
    public long aZM;
    private long aZO;
    public boolean aZP;
    public String aZQ;
    public String appId;
    public boolean bVb;
    public int bVc;
    public boolean bVd;
    public String bjV;
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
    public boolean aZG = false;
    public String aZI = "";
    public long followCount = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long aZN = 0;
    private boolean aZR = true;
    public boolean aZS = false;
    public boolean aZT = false;
    public boolean aZW = false;
    public List<l> aUk = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9, long j3) {
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
        this.aVd = j3;
        this.bjV = str9;
        Fq();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10, long j3) {
        this.giftId = str;
        this.aZM = j;
        this.aZH = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aZJ = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aZP = z;
        this.aVd = j3;
        this.aZQ = str8;
        this.appId = str9;
        this.msgId = j2;
        this.bjV = str10;
        Fq();
    }

    public void aP(long j) {
        this.aZO = j;
    }

    public long Fp() {
        return this.aZO;
    }

    private void Fq() {
        this.aZI = s.a(this.aVd, this.giftId, this.userId, this.bjV);
    }

    public String Fr() {
        return this.aZI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Xa */
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
