package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class b {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.a = goodsInfo.id.intValue();
            this.b = goodsInfo.user_name;
            this.c = goodsInfo.user_portrait;
            this.d = goodsInfo.thread_title;
            this.e = goodsInfo.thread_pic;
            this.f = goodsInfo.pop_window_text;
            this.g = goodsInfo.goods_style.intValue();
        }
    }
}
