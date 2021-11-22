package com.baidu.swan.webcompat.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"externalUrlTransform", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class WebCompatImpl$getWebCompatUrl$2 extends Lambda implements Function0<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String $url;
    public final /* synthetic */ WebCompatImpl$getWebCompatUrl$1 $urlTransform$1;
    public final /* synthetic */ WebCompatImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebCompatImpl$getWebCompatUrl$2(WebCompatImpl webCompatImpl, WebCompatImpl$getWebCompatUrl$1 webCompatImpl$getWebCompatUrl$1, String str) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webCompatImpl, webCompatImpl$getWebCompatUrl$1, str};
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
        this.$urlTransform$1 = webCompatImpl$getWebCompatUrl$1;
        this.$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        InterceptResult invokeV;
        FilePathInfo j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            j = this.this$0.j();
            if (j != null) {
                WebCompatImpl$getWebCompatUrl$1 webCompatImpl$getWebCompatUrl$1 = this.$urlTransform$1;
                String b2 = j.b();
                Intrinsics.checkNotNullExpressionValue(b2, "it.filesUrl");
                String invoke = webCompatImpl$getWebCompatUrl$1.invoke(b2, "external_files");
                if (invoke != null) {
                    return invoke;
                }
            }
            return this.$url;
        }
        return (String) invokeV.objValue;
    }
}
