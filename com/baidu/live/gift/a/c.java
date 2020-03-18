package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements Cloneable {
    public String Yh;
    public String Yi;
    public g alH;
    public int alJ;
    public long alL;
    public boolean alN;
    public String alO;
    public String appId;
    public String description;
    public String giftId;
    public String groupId;
    public String liveId;
    public String portrait;
    private long sendTime;
    public int sex;
    public String userId;
    public String userName;
    public int userStatus;
    public boolean alG = false;
    public String alI = "";
    public long alK = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long alM = 0;
    private boolean alP = true;
    public boolean alQ = false;
    public List<m> ahE = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
        this.giftId = str;
        this.alL = j;
        this.alH = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.alN = z;
        this.alO = str7;
        this.appId = str8;
        tV();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9) {
        this.giftId = str;
        this.alL = j;
        this.alH = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.alJ = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.alN = z;
        this.alO = str8;
        this.appId = str9;
        tV();
    }

    public void B(long j) {
        this.sendTime = j;
    }

    public long tU() {
        return this.sendTime;
    }

    private void tV() {
        this.alI = this.userId + this.giftId + this.userName;
    }

    public String tW() {
        return this.alI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: tX */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean tY() {
        return this.alP;
    }

    public void aN(boolean z) {
        this.alP = z;
    }

    /* loaded from: classes3.dex */
    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            if (cVar != null && cVar2 != null) {
                if (cVar.priority > cVar2.priority) {
                    return 1;
                }
                if (cVar.priority < cVar2.priority) {
                    return -1;
                }
                if (cVar.alH != null && cVar2.alH != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.alH.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.alH.getPrice());
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
