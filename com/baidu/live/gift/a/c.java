package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements Cloneable {
    public String aDW;
    public String aDX;
    public long aOb;
    public g aSQ;
    public int aSS;
    public long aSU;
    public boolean aSW;
    public String aSX;
    public String appId;
    public String description;
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
    public boolean aSP = false;
    public String aSR = "";
    public long aST = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long aSV = 0;
    private boolean aSY = true;
    public boolean aSZ = false;
    public boolean aTa = false;
    public boolean aTb = false;
    public List<m> aOy = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this.giftId = str;
        this.aSU = j;
        this.aSQ = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aSW = z;
        this.aSX = str7;
        this.appId = str8;
        this.msgId = j2;
        Gj();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2) {
        this.giftId = str;
        this.aSU = j;
        this.aSQ = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aSS = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aSW = z;
        this.aSX = str8;
        this.appId = str9;
        this.msgId = j2;
        Gj();
    }

    public void ae(long j) {
        this.sendTime = j;
    }

    public long Gi() {
        return this.sendTime;
    }

    private void Gj() {
        this.aSR = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String Gk() {
        return this.aSR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Gl */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Gm() {
        return this.aSY;
    }

    public void bF(boolean z) {
        this.aSY = z;
    }

    /* loaded from: classes7.dex */
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
                if (cVar.aSQ != null && cVar2.aSQ != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.aSQ.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.aSQ.getPrice());
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
