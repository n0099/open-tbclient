package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class d {
    public int PK;
    public String PL;
    public String PM;
    public String PN;
    public int PO;
    public String PP;
    public String PQ;
    public String PR;
    public String userName;
    public String userPortrait;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.PK = goodsInfo.id.intValue();
            this.userName = goodsInfo.user_name;
            this.userPortrait = goodsInfo.user_portrait;
            this.PL = goodsInfo.thread_title;
            this.PM = goodsInfo.thread_pic;
            this.PN = goodsInfo.pop_window_text;
            this.PO = goodsInfo.goods_style.intValue();
            this.PP = goodsInfo.card_desc;
            this.PQ = goodsInfo.card_tag;
            this.PR = goodsInfo.button_text;
        }
    }
}
