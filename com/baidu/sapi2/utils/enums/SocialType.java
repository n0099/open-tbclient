package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum SocialType {
    UNKNOWN(0, "未知"),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    QQ_SSO(15, "QQ_SSO"),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    IQIYI(47, "爱奇艺"),
    XIAOMI(49, "小米"),
    MEIZU(50, "魅族");
    
    private int b;
    private String c;

    SocialType(int i, String str) {
        this.b = i;
        this.c = str;
    }

    public static SocialType getSocialType(int i) {
        if (i != 2) {
            if (i != 15) {
                if (i != 42) {
                    if (i != 45) {
                        if (i != 47) {
                            if (i != 49) {
                                if (i != 50) {
                                    return UNKNOWN;
                                }
                                return MEIZU;
                            }
                            return XIAOMI;
                        }
                        return IQIYI;
                    }
                    return HUAWEI;
                }
                return WEIXIN;
            }
            return QQ_SSO;
        }
        return SINA_WEIBO_SSO;
    }

    public String getName() {
        return this.c;
    }

    public int getType() {
        return this.b;
    }
}
