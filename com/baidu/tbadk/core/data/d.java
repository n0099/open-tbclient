package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class d {
    public int Pm;
    public String Pn;
    public String Po;
    public String Pp;
    public int Pq;
    public String Pr;
    public String Ps;
    public String userName;
    public String userPortrait;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.Pm = goodsInfo.id.intValue();
            this.userName = goodsInfo.user_name;
            this.userPortrait = goodsInfo.user_portrait;
            this.Pn = goodsInfo.thread_title;
            this.Po = goodsInfo.thread_pic;
            this.Pp = goodsInfo.pop_window_text;
            this.Pq = goodsInfo.goods_style.intValue();
            this.Pr = goodsInfo.card_desc;
            this.Ps = goodsInfo.card_tag;
        }
    }
}
