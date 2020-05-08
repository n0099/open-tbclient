package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements Cloneable {
    public g aEd;
    public int aEf;
    public long aEh;
    public boolean aEj;
    public String aEk;
    public String appId;
    public String aqw;
    public String aqx;
    public long azH;
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
    public boolean aEc = false;
    public String aEe = "";
    public long aEg = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long aEi = 0;
    private boolean aEl = true;
    public boolean aEm = false;
    public List<m> aAe = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this.giftId = str;
        this.aEh = j;
        this.aEd = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aEj = z;
        this.aEk = str7;
        this.appId = str8;
        this.msgId = j2;
        yo();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2) {
        this.giftId = str;
        this.aEh = j;
        this.aEd = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aEf = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aEj = z;
        this.aEk = str8;
        this.appId = str9;
        this.msgId = j2;
        yo();
    }

    public void Z(long j) {
        this.sendTime = j;
    }

    public long yn() {
        return this.sendTime;
    }

    private void yo() {
        this.aEe = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String yp() {
        return this.aEe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: yq */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean yr() {
        return this.aEl;
    }

    public void bp(boolean z) {
        this.aEl = z;
    }

    /* loaded from: classes3.dex */
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
                if (cVar.aEd != null && cVar2.aEd != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.aEd.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.aEd.getPrice());
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
