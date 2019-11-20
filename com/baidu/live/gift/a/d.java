package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class d implements Cloneable {
    private long SK;
    public int aaB;
    public long aaE;
    public boolean aaG;
    public String aaH;
    public g aaz;
    public String appId;
    public String description;
    public String giftId;
    public String groupId;
    public String liveId;
    public String portrait;
    public int sex;
    public String userId;
    public String userName;
    public int userStatus;
    public boolean aay = false;
    public String aaA = "";
    public long aaC = 0;
    public long aaD = 0;
    public String location = "";
    public int priority = 1;
    public long aaF = 0;
    private boolean aaI = true;
    public boolean aaJ = false;

    public d(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
        this.giftId = str;
        this.aaE = j;
        this.aaz = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aaG = z;
        this.aaH = str7;
        this.appId = str8;
        qF();
    }

    public d(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9) {
        this.giftId = str;
        this.aaE = j;
        this.aaz = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aaB = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aaG = z;
        this.aaH = str8;
        this.appId = str9;
        qF();
    }

    public void y(long j) {
        this.SK = j;
    }

    public long qE() {
        return this.SK;
    }

    private void qF() {
        this.aaA = this.userId + this.giftId + this.userName;
    }

    public String qG() {
        return this.aaA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: qH */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean qI() {
        return this.aaI;
    }

    public void as(boolean z) {
        this.aaI = z;
    }

    /* loaded from: classes6.dex */
    public static class a implements Comparator<d> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            if (dVar != null && dVar2 != null) {
                if (dVar.priority > dVar2.priority) {
                    return 1;
                }
                if (dVar.priority < dVar2.priority) {
                    return -1;
                }
                if (dVar.aaz != null && dVar2.aaz != null) {
                    try {
                        long parseLong = Long.parseLong(dVar.aaz.getPrice());
                        long parseLong2 = Long.parseLong(dVar2.aaz.getPrice());
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
