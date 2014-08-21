package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a extends n {
    public int a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public int k;
    public String l;
    public String m;
    public int n;
    public String o;
    public String p;
    public String q;
    public long r;
    public b s = new b();
    public boolean t = false;

    public boolean a() {
        if (this.h <= 0 || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.b.trim()) || this.d == 2) {
            return false;
        }
        return b() || c();
    }

    public boolean b() {
        return (this.d != 3 || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g.trim()) || TextUtils.isEmpty(this.f.trim())) ? false : true;
    }

    public boolean c() {
        return (this.d != 1 || TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.e.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.b = app.id;
            this.c = app.name;
            this.d = app.url_type.intValue();
            this.e = app.url;
            this.f = app.apk_url;
            this.g = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.h = 3;
            } else {
                this.h = com.baidu.adp.lib.e.c.a(app.pos_name.trim(), 3);
            }
            this.i = app.first_name;
            this.j = app.second_name;
            this.k = app.cpid.intValue();
            this.m = app.abtest;
            this.n = app.plan_id.intValue();
            this.o = app.user_id;
            this.p = app.verify;
            this.l = app.price;
            this.q = app.ext_info;
            this.r = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.s.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.k);
        builder.da_ext_info = this.q;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.e.c.a(str, 0));
        builder.da_good_id = String.valueOf(this.s.a);
        builder.da_locate = String.valueOf(this.h);
        builder.da_obj_id = this.b;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.n);
        builder.da_price = this.l;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.o;
        builder.da_verify = this.p;
        return builder.build(false);
    }
}
