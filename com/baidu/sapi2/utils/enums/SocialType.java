package com.baidu.sapi2.utils.enums;

import com.baidu.android.util.io.FileUtils;
/* loaded from: classes15.dex */
public enum SocialType {
    UNKNOWN(0, FileUtils.UNKNOW),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    QQ_SSO(15, "QQ_SSO"),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    IQIYI(47, "爱奇艺"),
    XIAOMI(49, "小米"),
    MEIZU(50, "魅族"),
    FACEBOOK(55, "facebook"),
    TWITTER(56, "twitter"),
    GOOGLE(57, "google");
    

    /* renamed from: a  reason: collision with root package name */
    private int f3552a;
    private String b;

    SocialType(int i, String str) {
        this.f3552a = i;
        this.b = str;
    }

    public static SocialType getSocialType(int i) {
        if (i != 2) {
            if (i != 15) {
                if (i != 42) {
                    if (i != 45) {
                        if (i != 47) {
                            if (i != 55) {
                                if (i != 49) {
                                    if (i != 50) {
                                        return UNKNOWN;
                                    }
                                    return MEIZU;
                                }
                                return XIAOMI;
                            }
                            return FACEBOOK;
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
        return this.b;
    }

    public int getType() {
        return this.f3552a;
    }
}
