package com.baidu.searchbox.live.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.payment.IPaymentLogDelegate;
import com.baidu.searchbox.live.interfaces.payment.IPaymentStateCallback;
import com.baidu.searchbox.live.interfaces.service.Media2YYService;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJy\u0010\u0015\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/service/Media2YYServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/Media2YYService;", "", "", "", "extraParams", "", "release", "(Ljava/util/Map;)V", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;", "logDelegate", "title", "", PayUiEventContent.AMOUNT, "", "closeOnSuc", "customExpandParams", LiveYYPluginManager.USE_FROM_START_PAYMENT, "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;)V", "<init>", "()V", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class Media2YYServiceImpl implements Media2YYService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Media2YYServiceImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.Media2YYService
    public void release(Map<String, ? extends Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            LiveYYPluginManager.getInstance().releasePayment(map);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.Media2YYService
    public void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map<String, String> map, Map<String, ? extends Object> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2}) == null) {
            LiveYYPluginManager.getInstance().startPayment(context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2);
        }
    }
}
