package com.baidu.searchbox.live.interfaces.service.bd;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.feedpay.LiveFeedPayCallback;
import com.baidu.searchbox.live.interfaces.feedpay.LiveFeedPayInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J{\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022<\u0010\f\u001a8\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\n0\bj\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005`\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0017\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/LiveFeedPayService;", "Lkotlin/Any;", "", "originUrl", "path", "", "postParams", "paymentNid", "Lkotlin/Function3;", "", "", "Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayRequesterCallback;", "cb", "doSendRequestAsync", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/Function3;)V", "Landroid/content/Context;", "ctx", "Landroid/view/View;", "attachView", "Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;", "payInfo", "Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayCallback;", "callback", "startPayment", "(Landroid/content/Context;Landroid/view/View;Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayCallback;)V", "Companion", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveFeedPayService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/LiveFeedPayService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(851831477, "Lcom/baidu/searchbox/live/interfaces/service/bd/LiveFeedPayService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(851831477, "Lcom/baidu/searchbox/live/interfaces/service/bd/LiveFeedPayService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.BD.FEED_PAY);
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SERVICE_REFERENCE : (ServiceReference) invokeV.objValue;
        }
    }

    void doSendRequestAsync(String str, String str2, Map<String, String> map, String str3, Function3<? super Boolean, ? super Map<?, ?>, ? super String, Unit> function3);

    void startPayment(Context context, View view, LiveFeedPayInfo liveFeedPayInfo, LiveFeedPayCallback liveFeedPayCallback);
}
