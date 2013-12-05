package com.baidu.android.systemmonitor.b;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f776a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public int g;
    public int h;
    public int i;
    public String j;
    public long k;
    public String l;
    public long m;
    public ArrayList n;
    public int o;
    public ArrayList p;
    public ArrayList q;
    public ArrayList r;
    public ArrayList s;
    public String t;
    public String u;

    public b(Cursor cursor) {
        this.f = "";
        this.g = 0;
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("pn");
        int columnIndex3 = cursor.getColumnIndex("lautimes");
        int columnIndex4 = cursor.getColumnIndex("totaltime");
        int columnIndex5 = cursor.getColumnIndex("laucur");
        int columnIndex6 = cursor.getColumnIndex("lauper");
        int columnIndex7 = cursor.getColumnIndex("timeper");
        int columnIndex8 = cursor.getColumnIndex("timecur");
        this.f776a = cursor.getInt(columnIndex);
        this.d = cursor.getString(columnIndex2);
        if (!TextUtils.isEmpty(this.d)) {
            try {
                this.c = com.baidu.android.systemmonitor.security.a.b(this.d);
            } catch (Exception e) {
            }
        }
        this.h = cursor.getInt(columnIndex3);
        this.k = cursor.getLong(columnIndex4);
        this.i = cursor.getInt(columnIndex5);
        this.j = cursor.getString(columnIndex6);
        this.l = cursor.getString(columnIndex7);
        this.m = cursor.getLong(columnIndex8);
        this.n = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.p = new ArrayList();
    }

    public b(String str, boolean z) {
        this.f = "";
        this.g = 0;
        this.h = 0;
        this.k = 0L;
        if (str == null) {
            if (z) {
                this.d = "";
            } else {
                this.c = "";
            }
        } else if (z) {
            this.d = str;
        } else {
            this.c = str;
        }
        this.b = "";
        this.e = 0;
        this.i = 0;
        this.j = "";
        this.l = "";
        this.m = 0L;
        this.n = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.p = new ArrayList();
    }
}
