package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import com.baidu.live.utils.r;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public long aUi;
    public g aZJ;
    public int aZL;
    public long aZP;
    public boolean aZR;
    public String aZS;
    public String appId;
    public String bja;
    public String chatMCastId;
    public String description;
    public String ensureMCastId;
    public String giftId;
    public String groupId;
    public String liveId;
    public long msgId;
    public String portrait;
    private long sendTime;
    public int sex;
    public String userId;
    public String userName;
    public int userStatus;
    public boolean aZI = false;
    public String aZK = "";
    public long aZM = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long aZQ = 0;
    private boolean aZT = true;
    public boolean aZU = false;
    public boolean aZV = false;
    public boolean aZY = false;
    public List<m> aUG = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9) {
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
        this.bja = str9;
        Ia();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10) {
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
        this.bja = str10;
        Ia();
    }

    public void ag(long j) {
        this.sendTime = j;
    }

    public long HZ() {
        return this.sendTime;
    }

    private void Ia() {
        this.aZK = r.A(this.giftId, this.userId, this.bja);
    }

    public String Ib() {
        return this.aZK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ve */
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
