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
    private static HashMap f846a = new HashMap();
    private String b;

    static {
        f846a.put(SINAWEIBO.toString(), SINAWEIBO);
        f846a.put(QQWEIBO.toString(), QQWEIBO);
        f846a.put(QZONE.toString(), QZONE);
        f846a.put(QQFRIEND.toString(), QQFRIEND);
        f846a.put(WEIXIN.toString(), WEIXIN);
        f846a.put(WEIXIN_FRIEND.toString(), WEIXIN_FRIEND);
        f846a.put(WEIXIN_TIMELINE.toString(), WEIXIN_TIMELINE);
        f846a.put(KAIXIN.toString(), KAIXIN);
        f846a.put(RENREN.toString(), RENREN);
        f846a.put(BAIDU.toString(), BAIDU);
        f846a.put(TIEBA.toString(), TIEBA);
        f846a.put(TAOBAO.toString(), TAOBAO);
        f846a.put(ZHIFUBAO.toString(), ZHIFUBAO);
        f846a.put(GOOGLE.toString(), GOOGLE);
        f846a.put(DOUBAN.toString(), DOUBAN);
        f846a.put(FEIXIN.toString(), FEIXIN);
        f846a.put(WANGYI.toString(), WANGYI);
        f846a.put(YOUDAO_NOTE.toString(), YOUDAO_NOTE);
        f846a.put(SOHUWEIBO.toString(), SOHUWEIBO);
        f846a.put(TIANYA.toString(), TIANYA);
        f846a.put(EMAIL.toString(), EMAIL);
        f846a.put(SMS.toString(), SMS);
        f846a.put(BATCHSHARE.toString(), BATCHSHARE);
        f846a.put(COPYLINK.toString(), COPYLINK);
        f846a.put(OTHERS.toString(), OTHERS);
    }

    MediaType(String str) {
        this.b = str;
    }

    public static MediaType fromString(String str) {
        if (f846a.containsKey(str)) {
            return (MediaType) f846a.get(str);
        }
        throw new IllegalArgumentException("mediaType invalid");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
