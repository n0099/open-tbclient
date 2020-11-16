package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.utils.r;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public long aTP;
    public g aZq;
    public int aZs;
    public long aZw;
    public boolean aZy;
    public String aZz;
    public String appId;
    public String biJ;
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
    public boolean aZp = false;
    public String aZr = "";
    public long aZt = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long aZx = 0;
    private boolean aZA = true;
    public boolean aZB = false;
    public boolean aZC = false;
    public boolean aZF = false;
    public List<l> aUn = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9) {
        this.giftId = str;
        this.aZw = j;
        this.aZq = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aZy = z;
        this.aZz = str7;
        this.appId = str8;
        this.msgId = j2;
        this.biJ = str9;
        HS();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10) {
        this.giftId = str;
        this.aZw = j;
        this.aZq = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aZs = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aZy = z;
        this.aZz = str8;
        this.appId = str9;
        this.msgId = j2;
        this.biJ = str10;
        HS();
    }

    public void as(long j) {
        this.sendTime = j;
    }

    public long HR() {
        return this.sendTime;
    }

    private void HS() {
        this.aZr = r.A(this.giftId, this.userId, this.biJ);
    }

    public String HT() {
        return this.aZr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: WU */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean HV() {
        return this.aZA;
    }

    public void bP(boolean z) {
        this.aZA = z;
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
                if (cVar.aZq != null && cVar2.aZq != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.aZq.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.aZq.getPrice());
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
