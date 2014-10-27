package com.baidu.tbadk.core.data;

import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class b {
    public String userName;
    public String userPortrait;
    public int zA;
    public int zw;
    public String zx;
    public String zy;
    public String zz;

    public void a(GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            this.zw = goodsInfo.id.intValue();
            this.userName = goodsInfo.user_name;
            this.userPortrait = goodsInfo.user_portrait;
            this.zx = goodsInfo.thread_title;
            this.zy = goodsInfo.thread_pic;
            this.zz = goodsInfo.pop_window_text;
            this.zA = goodsInfo.goods_style.intValue();
        }
    }
}
