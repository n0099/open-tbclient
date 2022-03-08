package com.baidu.swan.webcompat.impl;

import androidx.webkit.WebViewAssetLoader;
import c.a.p0.a.t1.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class WebCompatImpl$internalStorageFilesPathHandler$2 extends Lambda implements Function0<WebViewAssetLoader.InternalStoragePathHandler> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ WebCompatImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebCompatImpl$internalStorageFilesPathHandler$2(WebCompatImpl webCompatImpl) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webCompatImpl};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WebViewAssetLoader.InternalStoragePathHandler invoke() {
        InterceptResult invokeV;
        FilePathInfo l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d J = d.J();
            l = this.this$0.l();
            return new WebViewAssetLoader.InternalStoragePathHandler(J, l.c());
        }
        return (WebViewAssetLoader.InternalStoragePathHandler) invokeV.objValue;
    }
}
