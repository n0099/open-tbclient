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
    private static HashMap f845a = new HashMap();
    private String b;

    static {
        f845a.put(SINAWEIBO.toString(), SINAWEIBO);
        f845a.put(QQWEIBO.toString(), QQWEIBO);
        f845a.put(QZONE.toString(), QZONE);
        f845a.put(QQFRIEND.toString(), QQFRIEND);
        f845a.put(WEIXIN.toString(), WEIXIN);
        f845a.put(WEIXIN_FRIEND.toString(), WEIXIN_FRIEND);
        f845a.put(WEIXIN_TIMELINE.toString(), WEIXIN_TIMELINE);
        f845a.put(KAIXIN.toString(), KAIXIN);
        f845a.put(RENREN.toString(), RENREN);
        f845a.put(BAIDU.toString(), BAIDU);
        f845a.put(TIEBA.toString(), TIEBA);
        f845a.put(TAOBAO.toString(), TAOBAO);
        f845a.put(ZHIFUBAO.toString(), ZHIFUBAO);
        f845a.put(GOOGLE.toString(), GOOGLE);
        f845a.put(DOUBAN.toString(), DOUBAN);
        f845a.put(FEIXIN.toString(), FEIXIN);
        f845a.put(WANGYI.toString(), WANGYI);
        f845a.put(YOUDAO_NOTE.toString(), YOUDAO_NOTE);
        f845a.put(SOHUWEIBO.toString(), SOHUWEIBO);
        f845a.put(TIANYA.toString(), TIANYA);
        f845a.put(EMAIL.toString(), EMAIL);
        f845a.put(SMS.toString(), SMS);
        f845a.put(BATCHSHARE.toString(), BATCHSHARE);
        f845a.put(COPYLINK.toString(), COPYLINK);
        f845a.put(OTHERS.toString(), OTHERS);
    }

    MediaType(String str) {
        this.b = str;
    }

    public static MediaType fromString(String str) {
        if (f845a.containsKey(str)) {
            return (MediaType) f845a.get(str);
        }
        throw new IllegalArgumentException("mediaType invalid");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
