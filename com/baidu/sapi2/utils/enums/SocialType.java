package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum SocialType {
    UNKNOWN(0, "未知"),
    RENREN(1, "人人"),
    SINA_WEIBO(2, "新浪微博"),
    TENCENT_WEIBO(4, "腾讯微博"),
    QZONE(15, "QQ空间"),
    QQ(15, "QQ");
    
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
            case 1:
                return RENREN;
            case 2:
                return SINA_WEIBO;
            case 4:
                return TENCENT_WEIBO;
            case 15:
                return QQ;
            default:
                return UNKNOWN;
        }
    }
}
