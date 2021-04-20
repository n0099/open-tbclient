package com.alipay.sdk.protocol;

import android.text.TextUtils;
/* loaded from: classes.dex */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");
    

    /* renamed from: g  reason: collision with root package name */
    public String f1955g;

    a(String str) {
        this.f1955g = str;
    }

    public static a a(String str) {
        a[] values;
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        for (a aVar2 : values()) {
            if (str.startsWith(aVar2.f1955g)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
