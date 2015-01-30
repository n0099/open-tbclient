package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class d {
    public int DE;
    public String DF;
    public String DG;
    public String DH;
    public int DI;
    public String userName;
    public String userPortrait;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.DE = goodsInfo.id.intValue();
            this.userName = goodsInfo.user_name;
            this.userPortrait = goodsInfo.user_portrait;
            this.DF = goodsInfo.thread_title;
            this.DG = goodsInfo.thread_pic;
            this.DH = goodsInfo.pop_window_text;
            this.DI = goodsInfo.goods_style.intValue();
        }
    }
}
