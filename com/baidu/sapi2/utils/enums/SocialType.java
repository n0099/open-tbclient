package com.baidu.sapi2.utils.enums;

import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.frs.tab.TabData;
/* loaded from: classes.dex */
public enum SocialType {
    UNKNOWN(0, "未知"),
    SINA_WEIBO(2, "新浪微博"),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    TENCENT_WEIBO(4, "腾讯微博"),
    QZONE(15, "QQ空间"),
    QQ(15, "QQ"),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    WANDA_FEIFAN(46, "万达飞凡"),
    CHUANKE(-1, "百度传课"),
    IQIYI(47, "爱奇艺"),
    XIAOMI(49, "小米");
    
    private int a;
    private String b;

    SocialType(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getType() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    public static SocialType getSocialType(int i) {
        switch (i) {
            case -1:
                return CHUANKE;
            case 2:
                return SINA_WEIBO;
            case 4:
                return TENCENT_WEIBO;
            case 15:
                return QQ;
            case 42:
                return WEIXIN;
            case TbConfig.VIEW_IMAGE_QUALITY_LOW_VALUE /* 45 */:
                return HUAWEI;
            case 46:
                return WANDA_FEIFAN;
            case 47:
                return IQIYI;
            case TabData.TYPE_TAB_ALA_LIVE /* 49 */:
                return XIAOMI;
            default:
                return UNKNOWN;
        }
    }
}
