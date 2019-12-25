package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    public g aiC;
    public int aiE;
    public long aiH;
    public boolean aiJ;
    public String aiK;
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
    public boolean aiB = false;
    public String aiD = "";
    public long aiF = 0;
    public long aiG = 0;
    public String location = "";
    public int priority = 1;
    public long aiI = 0;
    private boolean aiL = true;
    public boolean aiM = false;
    public List<m> aeE = new ArrayList();

    public b(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
        this.giftId = str;
        this.aiH = j;
        this.aiC = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aiJ = z;
        this.aiK = str7;
        this.appId = str8;
        so();
    }

    public b(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9) {
        this.giftId = str;
        this.aiH = j;
        this.aiC = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aiE = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aiJ = z;
        this.aiK = str8;
        this.appId = str9;
        so();
    }

    public void A(long j) {
        this.sendTime = j;
    }

    public long sn() {
        return this.sendTime;
    }

    private void so() {
        this.aiD = this.userId + this.giftId + this.userName;
    }

    public String sp() {
        return this.aiD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: sq */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean sr() {
        return this.aiL;
    }

    public void aI(boolean z) {
        this.aiL = z;
    }

    /* loaded from: classes2.dex */
    public static class a implements Comparator<b> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            if (bVar != null && bVar2 != null) {
                if (bVar.priority > bVar2.priority) {
                    return 1;
                }
                if (bVar.priority < bVar2.priority) {
                    return -1;
                }
                if (bVar.aiC != null && bVar2.aiC != null) {
                    try {
                        long parseLong = Long.parseLong(bVar.aiC.getPrice());
                        long parseLong2 = Long.parseLong(bVar2.aiC.getPrice());
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
