package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements Cloneable {
    public long aHv;
    public g aMi;
    public int aMk;
    public long aMm;
    public boolean aMo;
    public String aMp;
    public String appId;
    public String axB;
    public String axC;
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
    public boolean aMh = false;
    public String aMj = "";
    public long aMl = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long aMn = 0;
    private boolean aMq = true;
    public boolean aMr = false;
    public boolean aMs = false;
    public boolean aMt = false;
    public List<m> aHS = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2) {
        this.giftId = str;
        this.aMm = j;
        this.aMi = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aMo = z;
        this.aMp = str7;
        this.appId = str8;
        this.msgId = j2;
        Ae();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2) {
        this.giftId = str;
        this.aMm = j;
        this.aMi = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aMk = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aMo = z;
        this.aMp = str8;
        this.appId = str9;
        this.msgId = j2;
        Ae();
    }

    public void ad(long j) {
        this.sendTime = j;
    }

    public long Ad() {
        return this.sendTime;
    }

    private void Ae() {
        this.aMj = this.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.userName;
    }

    public String Af() {
        return this.aMj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ag */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Ah() {
        return this.aMq;
    }

    public void bx(boolean z) {
        this.aMq = z;
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
                if (cVar.aMi != null && cVar2.aMi != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.aMi.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.aMi.getPrice());
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
