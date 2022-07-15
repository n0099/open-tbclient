package com.baidu.nadcore.max.uicomponent;

import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tk0;
import com.repackage.x11;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/nadcore/webview/container/base/AbsContainer;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class WebViewComponent$baseBrowserContainer$2 extends Lambda implements Function0<AbsContainer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ WebViewComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewComponent$baseBrowserContainer$2(WebViewComponent webViewComponent) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webViewComponent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = webViewComponent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AbsContainer invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            x11.a aVar = x11.a;
            WebViewComponent webViewComponent = this.this$0;
            return aVar.a(webViewComponent, webViewComponent, tk0.b().a().a("key_webview_core_type", 0));
        }
        return (AbsContainer) invokeV.objValue;
    }
}
