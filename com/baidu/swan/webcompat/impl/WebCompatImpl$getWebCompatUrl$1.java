package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tieba.z82;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"urlTransform", "", "prefix", "compatPath", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class WebCompatImpl$getWebCompatUrl$1 extends Lambda implements Function2<String, String, String> {
    public final /* synthetic */ String $url;
    public final /* synthetic */ WebCompatImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebCompatImpl$getWebCompatUrl$1(WebCompatImpl webCompatImpl, String str) {
        super(2);
        this.this$0 = webCompatImpl;
        this.$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final String invoke(String prefix, String compatPath) {
        String n;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(compatPath, "compatPath");
        if (prefix.length() > this.$url.length()) {
            return this.$url;
        }
        String str = this.$url;
        int length = prefix.length();
        if (str != null) {
            String substring = str.substring(length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            z82.i("WebCompatImpl", "getWebCompatUrl urlTransform path0=" + substring);
            int i = 0;
            if (substring.length() > 0 && '/' == substring.charAt(0)) {
                i = 1;
            }
            z82.i("WebCompatImpl", "getWebCompatUrl urlTransform headerSlashCount=" + i);
            if (i > 0) {
                if (substring != null) {
                    substring = substring.substring(i);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            z82.i("WebCompatImpl", "getWebCompatUrl urlTransform path1=" + substring);
            Uri.Builder scheme = new Uri.Builder().scheme("http");
            n = this.this$0.n();
            String builder = scheme.authority(n).appendPath(compatPath).appendEncodedPath(substring).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "Uri.Builder()\n          …              .toString()");
            return builder;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
