package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class d {
    public int Po;
    public String Pp;
    public String Pq;
    public String Pr;
    public int Ps;
    public String Pt;
    public String Pu;
    public String userName;
    public String userPortrait;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.Po = goodsInfo.id.intValue();
            this.userName = goodsInfo.user_name;
            this.userPortrait = goodsInfo.user_portrait;
            this.Pp = goodsInfo.thread_title;
            this.Pq = goodsInfo.thread_pic;
            this.Pr = goodsInfo.pop_window_text;
            this.Ps = goodsInfo.goods_style.intValue();
            this.Pt = goodsInfo.card_desc;
            this.Pu = goodsInfo.card_tag;
        }
    }
}
