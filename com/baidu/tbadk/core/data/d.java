package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class d {
    public int DA;
    public String DB;
    public String DD;
    public String DE;
    public int DF;
    public String userName;
    public String userPortrait;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.DA = goodsInfo.id.intValue();
            this.userName = goodsInfo.user_name;
            this.userPortrait = goodsInfo.user_portrait;
            this.DB = goodsInfo.thread_title;
            this.DD = goodsInfo.thread_pic;
            this.DE = goodsInfo.pop_window_text;
            this.DF = goodsInfo.goods_style.intValue();
        }
    }
}
