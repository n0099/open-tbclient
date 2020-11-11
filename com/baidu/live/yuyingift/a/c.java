package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.gift.l;
import com.baidu.live.utils.r;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public long aVA;
    public String appId;
    public g bbc;
    public int bbe;
    public long bbi;
    public boolean bbk;
    public String bbl;
    public String bku;
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
    public boolean bbb = false;
    public String bbd = "";
    public long bbf = 0;
    public long fansCount = 0;
    public String location = "";
    public int priority = 1;
    public long bbj = 0;
    private boolean bbm = true;
    public boolean bbn = false;
    public boolean bbo = false;
    public boolean bbr = false;
    public List<l> aVY = new ArrayList();

    public c(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, long j2, String str9) {
        this.giftId = str;
        this.bbi = j;
        this.bbc = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.bbk = z;
        this.bbl = str7;
        this.appId = str8;
        this.msgId = j2;
        this.bku = str9;
        IB();
    }

    public c(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9, long j2, String str10) {
        this.giftId = str;
        this.bbi = j;
        this.bbc = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.bbe = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.bbk = z;
        this.bbl = str8;
        this.appId = str9;
        this.msgId = j2;
        this.bku = str10;
        IB();
    }

    public void as(long j) {
        this.sendTime = j;
    }

    public long IA() {
        return this.sendTime;
    }

    private void IB() {
        this.bbd = r.A(this.giftId, this.userId, this.bku);
    }

    public String IC() {
        return this.bbd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: XD */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean IE() {
        return this.bbm;
    }

    public void bN(boolean z) {
        this.bbm = z;
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
                if (cVar.bbc != null && cVar2.bbc != null) {
                    try {
                        long parseLong = Long.parseLong(cVar.bbc.getPrice());
                        long parseLong2 = Long.parseLong(cVar2.bbc.getPrice());
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
