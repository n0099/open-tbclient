package com.baidu.cloudsdk.social.core;

import java.util.HashMap;
/* loaded from: classes.dex */
public enum MediaType {
    SINAWEIBO("sinaweibo"),
    QQWEIBO("qqweibo"),
    QZONE("qqdenglu"),
    KAIXIN("kaixin"),
    RENREN("renren"),
    GOOGLE("google"),
    DOUBAN("douban"),
    FEIXIN("feixin"),
    WANGYI("wangyi"),
    SOHUWEIBO("sohuweibo"),
    TIANYA("tianya"),
    BAIDU("baidu"),
    TAOBAO("taobao"),
    ZHIFUBAO("zhifubao"),
    QQFRIEND("qqfriend"),
    WEIXIN("weixin"),
    WEIXIN_FRIEND("weixin_friend"),
    WEIXIN_TIMELINE("weixin_timeline"),
    TIEBA("tieba"),
    YOUDAO_NOTE("youdao_note"),
    EMAIL("email"),
    SMS("sms"),
    BATCHSHARE("batchshare"),
    COPYLINK("copylink"),
    OTHERS("others");
    
    private static HashMap a = new HashMap();
    private String b;

    static {
        a.put(SINAWEIBO.toString(), SINAWEIBO);
        a.put(QQWEIBO.toString(), QQWEIBO);
        a.put(QZONE.toString(), QZONE);
        a.put(QQFRIEND.toString(), QQFRIEND);
        a.put(WEIXIN.toString(), WEIXIN);
        a.put(WEIXIN_FRIEND.toString(), WEIXIN_FRIEND);
        a.put(WEIXIN_TIMELINE.toString(), WEIXIN_TIMELINE);
        a.put(KAIXIN.toString(), KAIXIN);
        a.put(RENREN.toString(), RENREN);
        a.put(BAIDU.toString(), BAIDU);
        a.put(TIEBA.toString(), TIEBA);
        a.put(TAOBAO.toString(), TAOBAO);
        a.put(ZHIFUBAO.toString(), ZHIFUBAO);
        a.put(GOOGLE.toString(), GOOGLE);
        a.put(DOUBAN.toString(), DOUBAN);
        a.put(FEIXIN.toString(), FEIXIN);
        a.put(WANGYI.toString(), WANGYI);
        a.put(YOUDAO_NOTE.toString(), YOUDAO_NOTE);
        a.put(SOHUWEIBO.toString(), SOHUWEIBO);
        a.put(TIANYA.toString(), TIANYA);
        a.put(EMAIL.toString(), EMAIL);
        a.put(SMS.toString(), SMS);
        a.put(BATCHSHARE.toString(), BATCHSHARE);
        a.put(COPYLINK.toString(), COPYLINK);
        a.put(OTHERS.toString(), OTHERS);
    }

    MediaType(String str) {
        this.b = str;
    }

    public static MediaType fromString(String str) {
        if (a.containsKey(str)) {
            return (MediaType) a.get(str);
        }
        throw new IllegalArgumentException("mediaType invalid");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
