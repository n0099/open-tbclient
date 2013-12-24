package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class a extends f {
    public int a;
    public int b;
    public int c;
    public String d;
    public int e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    public a(long j) {
        super(j);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.e = 0;
        this.o = 4;
    }

    public a(Cursor cursor) {
        super(cursor);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.e = 0;
        this.o = 4;
        this.a = cursor.getInt(cursor.getColumnIndex("pconum"));
        this.b = cursor.getInt(cursor.getColumnIndex("sconum"));
        this.c = cursor.getInt(cursor.getColumnIndex("msnum"));
        this.d = cursor.getString(cursor.getColumnIndex("msinfo"));
        this.e = cursor.getInt(cursor.getColumnIndex("calognum"));
        this.f = cursor.getString(cursor.getColumnIndex("caloginfo"));
        this.g = cursor.getString(cursor.getColumnIndex("sdfall"));
        this.h = cursor.getString(cursor.getColumnIndex("pfall"));
        this.i = cursor.getInt(cursor.getColumnIndex("pphnum"));
        this.j = cursor.getInt(cursor.getColumnIndex("sphnum"));
        this.k = cursor.getInt(cursor.getColumnIndex("pmpnum"));
        this.l = cursor.getInt(cursor.getColumnIndex("smpnum"));
        this.m = cursor.getInt(cursor.getColumnIndex("stvnum"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public String toString() {
        return "StoreInfomation :startStamp = " + this.n + "  phoneContactsNum =" + this.a + " simContactsNum = " + this.b + " smsNum = " + this.c + "\r\n smsInfo =" + this.d + "\r\n calllogNum = " + this.e + " calllogInfo = " + this.f + "\r\n sdcardFreeAll = " + this.g + " phoneFreeAll =" + this.h + " phonePhotoNum =" + this.i + " sdcardPhotoNum =" + this.j + " phoneMp3Num = " + this.k + " sdcardMp3Num =" + this.l + " sdcardTvNum =" + this.m;
    }
}
