package com.baidu.nadcore.webview.data;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/baidu/nadcore/webview/data/NadPageType;", "Ljava/lang/Enum;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PAGE_NAD_FEED", "PAGE_NAD_SPLASH", "PAGE_NAD_POP_WEB", "PAGE_FENGCHAO", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public enum NadPageType {
    PAGE_NAD_FEED("ad"),
    PAGE_NAD_SPLASH("xuzhang"),
    PAGE_NAD_POP_WEB("pop_web"),
    PAGE_FENGCHAO("fc");
    
    public final String value;

    NadPageType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
