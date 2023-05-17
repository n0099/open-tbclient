package com.baidu.sapi2.utils.enums;

import com.baidu.android.util.io.FileUtils;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes3.dex */
public enum SocialType {
    UNKNOWN(0, FileUtils.UNKNOW),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    QQ_SSO(15, "QQ_SSO"),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    HONOR(61, "荣耀"),
    IQIYI(47, "爱奇艺"),
    XIAOMI(49, "小米"),
    MEIZU(50, "魅族"),
    FACEBOOK(55, "facebook"),
    TWITTER(56, "twitter"),
    GOOGLE(57, "google"),
    YY(58, "YY"),
    CFO(60, "CFO"),
    QQ_SSO_BACKGROUND(MemberPayActivityConfig.SCENE_FROM_FRS, "QQ_SSO_BACKGROUND"),
    WEIXIN_BACKGROUND(100042, "微信");
    
    public String name;
    public int type;

    SocialType(int i, String str) {
        this.type = i;
        this.name = str;
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
                                        if (i != 60) {
                                            if (i != 61) {
                                                return UNKNOWN;
                                            }
                                            return HONOR;
                                        }
                                        return CFO;
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
        return this.name;
    }

    public int getType() {
        return this.type;
    }
}
