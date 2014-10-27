package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes.dex */
public enum NMLoginType {
    QQ("qq"),
    RENREN("renren"),
    SINA_WEIBO("sina"),
    ALIPAY("alipay"),
    QIHU_360("360");
    
    private String a;

    NMLoginType(String str) {
        this.a = str;
    }

    public String getName() {
        return this.a;
    }

    public static NMLoginType mapStrToValue(String str) {
        NMLoginType[] values;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (NMLoginType nMLoginType : values()) {
            if (str.equals(nMLoginType.getName())) {
                return nMLoginType;
            }
        }
        return null;
    }
}
