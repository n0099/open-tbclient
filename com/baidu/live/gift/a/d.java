package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
/* loaded from: classes6.dex */
public class d implements Cloneable {
    private long Tf;
    public g aaR;
    public int aaT;
    public long aaW;
    public boolean aaY;
    public String aaZ;
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
    public boolean aaQ = false;
    public String aaS = "";
    public long aaU = 0;
    public long aaV = 0;
    public String location = "";
    public int priority = 1;
    public long aaX = 0;
    private boolean aba = true;
    public boolean abb = false;

    public d(String str, long j, g gVar, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
        this.giftId = str;
        this.aaW = j;
        this.aaR = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.liveId = str5;
        this.groupId = str6;
        this.aaY = z;
        this.aaZ = str7;
        this.appId = str8;
        qE();
    }

    public d(String str, long j, g gVar, String str2, String str3, String str4, int i, int i2, String str5, int i3, String str6, String str7, boolean z, String str8, String str9) {
        this.giftId = str;
        this.aaW = j;
        this.aaR = gVar;
        this.userId = str2;
        this.portrait = str3;
        this.userName = str4;
        this.aaT = i;
        this.sex = i2;
        this.description = str5;
        this.userStatus = i3;
        this.liveId = str6;
        this.groupId = str7;
        this.aaY = z;
        this.aaZ = str8;
        this.appId = str9;
        qE();
    }

    public void z(long j) {
        this.Tf = j;
    }

    public long qD() {
        return this.Tf;
    }

    private void qE() {
        this.aaS = this.userId + this.giftId + this.userName;
    }

    public String qF() {
        return this.aaS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: qG */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean qH() {
        return this.aba;
    }

    public void as(boolean z) {
        this.aba = z;
    }
}
