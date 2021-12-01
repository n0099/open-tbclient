package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import c.a.p0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"urlTransform", "", "prefix", "compatPath", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class WebCompatImpl$getWebCompatUrl$1 extends Lambda implements Function2<String, String, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String $url;
    public final /* synthetic */ WebCompatImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebCompatImpl$getWebCompatUrl$1(WebCompatImpl webCompatImpl, String str) {
        super(2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webCompatImpl, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = webCompatImpl;
        this.$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final String invoke(String prefix, String compatPath) {
        InterceptResult invokeLL;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefix, compatPath)) == null) {
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
                d.i("WebCompatImpl", "getWebCompatUrl urlTransform path0=" + substring);
                int i2 = 0;
                if (substring.length() > 0 && '/' == substring.charAt(0)) {
                    i2 = 1;
                }
                d.i("WebCompatImpl", "getWebCompatUrl urlTransform headerSlashCount=" + i2);
                if (i2 > 0) {
                    if (substring == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    substring = substring.substring(i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                }
                d.i("WebCompatImpl", "getWebCompatUrl urlTransform path1=" + substring);
                Uri.Builder scheme = new Uri.Builder().scheme("http");
                n = this.this$0.n();
                String builder = scheme.authority(n).appendPath(compatPath).appendEncodedPath(substring).toString();
                Intrinsics.checkNotNullExpressionValue(builder, "Uri.Builder()\n          …              .toString()");
                return builder;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return (String) invokeLL.objValue;
    }
}
