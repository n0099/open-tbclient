package com.baidu.mobads.container.h5;

import android.webkit.WebView;
import com.baidu.mobads.container.XBaseHtmlAdContainer;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler;
import com.baidu.mobads.container.bridge.BridgeListener;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdservBridgeHandler extends BaseHtmlBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdservBridgeHandler(XBaseHtmlAdContainer xBaseHtmlAdContainer, WebView webView, BridgeListener bridgeListener, XAdContainerContext xAdContainerContext) {
        super(xBaseHtmlAdContainer, webView, bridgeListener, xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xBaseHtmlAdContainer, webView, bridgeListener, xAdContainerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((XBaseHtmlAdContainer) objArr2[0], (WebView) objArr2[1], (BridgeListener) objArr2[2], (XAdContainerContext) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler
    public JSONObject getConfs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new XDeviceInfo(this.mAdContainerCxt).getConfs() : (JSONObject) invokeV.objValue;
    }
}
