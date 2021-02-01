package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.utils.s;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements Cloneable {
    public long aWR;
    public long aYl;
    public String appId;
    public boolean bZd;
    public int bZe;
    public boolean bZf;
    public g bcO;
    public int bcQ;
    public long bcT;
    private long bcV;
    public boolean bcW;
    public String bcX;
    public String bno;
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
    public boolean bcN = false;
    public String bcP = "";
    public long followCount = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long bcU = 0;
    private boolean bcY = true;
    public boolean bcZ = false;
    public boolean bda = false;
    public boolean bdd = false;
    public List<l> aXp = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9, long j3) {
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
        this.aYl = j3;
        this.bno = str9;
        GG();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10, long j3) {
        this.giftId = str;
        this.bcT = j;
        this.bcO = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.bcQ = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.bcW = z;
        this.aYl = j3;
        this.bcX = str8;
        this.appId = str9;
        this.msgId = j2;
        this.bno = str10;
        GG();
    }

    public void aS(long j) {
        this.bcV = j;
    }

    public long GF() {
        return this.bcV;
    }

    private void GG() {
        this.bcP = s.a(this.aYl, this.giftId, this.userId, this.bno);
    }

    public String GH() {
        return this.bcP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: YQ */
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
                        long parseLong = Long.parseLong(cVar.bcO.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.bcO.getPrice());
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
