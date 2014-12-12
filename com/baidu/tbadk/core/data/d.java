package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class d {
    public int DB;
    public String DD;
    public String DE;
    public String DF;
    public int DG;
    public String userName;
    public String userPortrait;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.DB = goodsInfo.id.intValue();
            this.userName = goodsInfo.user_name;
            this.userPortrait = goodsInfo.user_portrait;
            this.DD = goodsInfo.thread_title;
            this.DE = goodsInfo.thread_pic;
            this.DF = goodsInfo.pop_window_text;
            this.DG = goodsInfo.goods_style.intValue();
        }
    }
}
