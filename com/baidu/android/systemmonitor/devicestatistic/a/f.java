package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class f extends c {

    /* renamed from: a  reason: collision with root package name */
    public int f796a;
    public int b;
    public int c;
    public String d;
    public int e;
    public String f;
    public String i;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public f(long j) {
        super(j);
        this.f796a = 0;
        this.b = 0;
        this.c = 0;
        this.e = 0;
        this.h = 4;
    }

    public f(Cursor cursor) {
        super(cursor);
        this.f796a = 0;
        this.b = 0;
        this.c = 0;
        this.e = 0;
        this.h = 4;
        this.f796a = cursor.getInt(cursor.getColumnIndex("pconum"));
        this.b = cursor.getInt(cursor.getColumnIndex("sconum"));
        this.c = cursor.getInt(cursor.getColumnIndex("msnum"));
        this.d = cursor.getString(cursor.getColumnIndex("msinfo"));
        this.e = cursor.getInt(cursor.getColumnIndex("calognum"));
        this.f = cursor.getString(cursor.getColumnIndex("caloginfo"));
        this.i = cursor.getString(cursor.getColumnIndex("sdfall"));
        this.j = cursor.getString(cursor.getColumnIndex("pfall"));
        this.k = cursor.getInt(cursor.getColumnIndex("pphnum"));
        this.l = cursor.getInt(cursor.getColumnIndex("sphnum"));
        this.m = cursor.getInt(cursor.getColumnIndex("pmpnum"));
        this.n = cursor.getInt(cursor.getColumnIndex("smpnum"));
        this.o = cursor.getInt(cursor.getColumnIndex("stvnum"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.c
    public String toString() {
        return "StoreInfomation :startStamp = " + this.g + "  phoneContactsNum =" + this.f796a + " simContactsNum = " + this.b + " smsNum = " + this.c + "\r\n smsInfo =" + this.d + "\r\n calllogNum = " + this.e + " calllogInfo = " + this.f + "\r\n sdcardFreeAll = " + this.i + " phoneFreeAll =" + this.j + " phonePhotoNum =" + this.k + " sdcardPhotoNum =" + this.l + " phoneMp3Num = " + this.m + " sdcardMp3Num =" + this.n + " sdcardTvNum =" + this.o;
    }
}
