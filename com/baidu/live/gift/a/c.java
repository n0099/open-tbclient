package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public String aHY;
    public String aHZ;
    public long aTm;
    public g aYo;
    public int aYq;
    public boolean aYs;
    public long aYt;
    public boolean aYv;
    public String aYw;
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
    public boolean aYn = false;
    public String aYp = "";
    public long aYr = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long aYu = 0;
    private boolean aYx = true;
    public boolean aYy = false;
    public boolean aYz = false;
    public boolean aYA = false;
    public List<m> aTK = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this.giftId = str;
        this.aYt = j;
        this.aYo = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aYv = z;
        this.aYw = str7;
        this.appId = str8;
        this.msgId = j2;
        HF();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, boolean z2) {
        this.giftId = str;
        this.aYt = j;
        this.aYo = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aYv = z;
        this.aYw = str7;
        this.appId = str8;
        this.msgId = j2;
        this.aYs = z2;
        HF();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2) {
        this.giftId = str;
        this.aYt = j;
        this.aYo = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aYq = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aYv = z;
        this.aYw = str8;
        this.appId = str9;
        this.msgId = j2;
        HF();
    }

    public void af(long j) {
        this.sendTime = j;
    }

    public long HE() {
        return this.sendTime;
    }

    private void HF() {
        this.aYp = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String HG() {
        return this.aYp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: HH */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean HI() {
        return this.aYx;
    }

    public void bK(boolean z) {
        this.aYx = z;
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
                if (cVar.aYo != null && cVar2.aYo != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.aYo.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.aYo.getPrice());
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
