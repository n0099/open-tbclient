package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements Cloneable {
    public String XX;
    public String XY;
    public long alA;
    public boolean alC;
    public String alD;
    public g alw;
    public int aly;
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
    public boolean alv = false;
    public String alx = "";
    public long alz = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long alB = 0;
    private boolean alE = true;
    public boolean alF = false;
    public List<m> ahu = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
        this.giftId = str;
        this.alA = j;
        this.alw = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.alC = z;
        this.alD = str7;
        this.appId = str8;
        tQ();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9) {
        this.giftId = str;
        this.alA = j;
        this.alw = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aly = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.alC = z;
        this.alD = str8;
        this.appId = str9;
        tQ();
    }

    public void B(long j) {
        this.sendTime = j;
    }

    public long tP() {
        return this.sendTime;
    }

    private void tQ() {
        this.alx = this.userId + this.giftId + this.userName;
    }

    public String tR() {
        return this.alx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: tS */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean tT() {
        return this.alE;
    }

    public void aN(boolean z) {
        this.alE = z;
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
                if (cVar.alw != null && cVar2.alw != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.alw.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.alw.getPrice());
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
