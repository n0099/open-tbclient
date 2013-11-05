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
    

    /* renamed from: a  reason: collision with root package name */
    private static HashMap f831a = new HashMap();
    private String b;

    static {
        f831a.put(SINAWEIBO.toString(), SINAWEIBO);
        f831a.put(QQWEIBO.toString(), QQWEIBO);
        f831a.put(QZONE.toString(), QZONE);
        f831a.put(QQFRIEND.toString(), QQFRIEND);
        f831a.put(WEIXIN.toString(), WEIXIN);
        f831a.put(WEIXIN_FRIEND.toString(), WEIXIN_FRIEND);
        f831a.put(WEIXIN_TIMELINE.toString(), WEIXIN_TIMELINE);
        f831a.put(KAIXIN.toString(), KAIXIN);
        f831a.put(RENREN.toString(), RENREN);
        f831a.put(BAIDU.toString(), BAIDU);
        f831a.put(TIEBA.toString(), TIEBA);
        f831a.put(TAOBAO.toString(), TAOBAO);
        f831a.put(ZHIFUBAO.toString(), ZHIFUBAO);
        f831a.put(GOOGLE.toString(), GOOGLE);
        f831a.put(DOUBAN.toString(), DOUBAN);
        f831a.put(FEIXIN.toString(), FEIXIN);
        f831a.put(WANGYI.toString(), WANGYI);
        f831a.put(YOUDAO_NOTE.toString(), YOUDAO_NOTE);
        f831a.put(SOHUWEIBO.toString(), SOHUWEIBO);
        f831a.put(TIANYA.toString(), TIANYA);
        f831a.put(EMAIL.toString(), EMAIL);
        f831a.put(SMS.toString(), SMS);
        f831a.put(BATCHSHARE.toString(), BATCHSHARE);
        f831a.put(COPYLINK.toString(), COPYLINK);
        f831a.put(OTHERS.toString(), OTHERS);
    }

    MediaType(String str) {
        this.b = str;
    }

    public static MediaType fromString(String str) {
        if (f831a.containsKey(str)) {
            return (MediaType) f831a.get(str);
        }
        throw new IllegalArgumentException("mediaType invalid");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
