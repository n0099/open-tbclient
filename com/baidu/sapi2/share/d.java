package com.baidu.sapi2.share;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes15.dex */
public class d extends SapiResult {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5067a = "您已取消%s授权登录";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5068b = "互通登录失败，该应用暂未授权";
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

    public d() {
        this.msgMap.put(-3001, f5067a);
        this.msgMap.put(-3002, f5068b);
        this.msgMap.put(-3003, c);
        this.msgMap.put(j, d);
        this.msgMap.put(k, e);
        this.msgMap.put(l, f);
    }
}
