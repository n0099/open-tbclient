package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.utils.r;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public long aWT;
    public String appId;
    public g bcN;
    public int bcP;
    public long bcU;
    private long bcW;
    public boolean bcX;
    public String bcY;
    public String bnb;
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
    public boolean bcM = false;
    public String bcO = "";
    public long bcQ = 0;
    public long bcR = 0;
    public String location = "";
    public int priority = 1;
    public long bcV = 0;
    private boolean bcZ = true;
    public boolean bda = false;
    public boolean bdb = false;
    public boolean bde = false;
    public List<l> aXs = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9) {
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
        this.bnb = str9;
        JJ();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10) {
        this.giftId = str;
        this.bcU = j;
        this.bcN = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.bcP = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.bcX = z;
        this.bcY = str8;
        this.appId = str9;
        this.msgId = j2;
        this.bnb = str10;
        JJ();
    }

    public void aQ(long j) {
        this.bcW = j;
    }

    public long JI() {
        return this.bcW;
    }

    private void JJ() {
        this.bcO = r.D(this.giftId, this.userId, this.bnb);
    }

    public String JK() {
        return this.bcO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Zt */
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
