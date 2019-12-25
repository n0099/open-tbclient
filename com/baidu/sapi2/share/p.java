package com.baidu.sapi2.share;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes4.dex */
public class p extends SapiResult {
    public static final String a = "您已取消%s授权登录";
    public static final String b = "互通登录失败，该应用暂未授权";
    public static final String c = "网络请求失败，请稍后再试";
    public static final String d = "互通登录失败，请换种登录方式";
    public static final String e = "互通请求失败，请换种登录方式";
    public static final String f = "系统错误，请换种登录方式";
    public static final int g = -3001;
    public static final int h = -3002;
    public static final int i = -3003;
    public static final int j = -3004;
    public static final int k = -3005;
    public static final int l = -3006;

    public p() {
        this.msgMap.put(g, a);
        this.msgMap.put(h, b);
        this.msgMap.put(i, c);
        this.msgMap.put(j, d);
        this.msgMap.put(k, e);
        this.msgMap.put(l, f);
    }
}
