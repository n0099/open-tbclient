package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
/* loaded from: classes.dex */
public enum SocialType {
    UNKNOWN(0, AiAppsFileUtils.UNKNOW),
    SINA_WEIBO(2, "新浪微博"),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    TENCENT_WEIBO(4, "腾讯微博"),
    QQ_SSO(15, "QQ_SSO"),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    WANDA_FEIFAN(46, "万达飞凡"),
    CHUANKE(-1, "百度传课"),
    IQIYI(47, "爱奇艺"),
    XIAOMI(49, "小米"),
    MEIZU(50, "魅族");
    
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
                return QQ_SSO;
            case 42:
                return WEIXIN;
            case 45:
                return HUAWEI;
            case 46:
                return WANDA_FEIFAN;
            case 47:
                return IQIYI;
            case 49:
                return XIAOMI;
            case 50:
                return MEIZU;
            default:
                return UNKNOWN;
        }
    }
}
