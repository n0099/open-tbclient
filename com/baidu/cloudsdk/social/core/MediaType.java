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
    private static HashMap f851a = new HashMap();
    private String b;

    static {
        f851a.put(SINAWEIBO.toString(), SINAWEIBO);
        f851a.put(QQWEIBO.toString(), QQWEIBO);
        f851a.put(QZONE.toString(), QZONE);
        f851a.put(QQFRIEND.toString(), QQFRIEND);
        f851a.put(WEIXIN.toString(), WEIXIN);
        f851a.put(WEIXIN_FRIEND.toString(), WEIXIN_FRIEND);
        f851a.put(WEIXIN_TIMELINE.toString(), WEIXIN_TIMELINE);
        f851a.put(KAIXIN.toString(), KAIXIN);
        f851a.put(RENREN.toString(), RENREN);
        f851a.put(BAIDU.toString(), BAIDU);
        f851a.put(TIEBA.toString(), TIEBA);
        f851a.put(TAOBAO.toString(), TAOBAO);
        f851a.put(ZHIFUBAO.toString(), ZHIFUBAO);
        f851a.put(GOOGLE.toString(), GOOGLE);
        f851a.put(DOUBAN.toString(), DOUBAN);
        f851a.put(FEIXIN.toString(), FEIXIN);
        f851a.put(WANGYI.toString(), WANGYI);
        f851a.put(YOUDAO_NOTE.toString(), YOUDAO_NOTE);
        f851a.put(SOHUWEIBO.toString(), SOHUWEIBO);
        f851a.put(TIANYA.toString(), TIANYA);
        f851a.put(EMAIL.toString(), EMAIL);
        f851a.put(SMS.toString(), SMS);
        f851a.put(BATCHSHARE.toString(), BATCHSHARE);
        f851a.put(COPYLINK.toString(), COPYLINK);
        f851a.put(OTHERS.toString(), OTHERS);
    }

    MediaType(String str) {
        this.b = str;
    }

    public static MediaType fromString(String str) {
        if (f851a.containsKey(str)) {
            return (MediaType) f851a.get(str);
        }
        throw new IllegalArgumentException("mediaType invalid");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
