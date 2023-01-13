package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.payment.IPaymentLogDelegate;
import com.baidu.searchbox.live.interfaces.payment.IPaymentStateCallback;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J)\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0085\u0001\u0010\u0015\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/Media2YYService;", "Lkotlin/Any;", "", "", "", "extraParams", "", "release", "(Ljava/util/Map;)V", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;", "logDelegate", "title", "", PayUiEventContent.AMOUNT, "", "closeOnSuc", "customExpandParams", LiveYYPluginManager.USE_FROM_START_PAYMENT, "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface Media2YYService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void release(Map<String, ? extends Object> map);

    void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map<String, String> map, Map<String, ? extends Object> map2);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/Media2YYService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1804091730, "Lcom/baidu/searchbox/live/interfaces/service/Media2YYService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1804091730, "Lcom/baidu/searchbox/live/interfaces/service/Media2YYService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.MINI_SHELL.MEDIA_2_YY);
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return SERVICE_REFERENCE;
            }
            return (ServiceReference) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.interfaces.service.Media2YYService */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void release$default(Media2YYService media2YYService, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = null;
                }
                media2YYService.release(map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: release");
        }

        public static /* synthetic */ void startPayment$default(Media2YYService media2YYService, Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map map, Map map2, int i, Object obj) {
            IPaymentStateCallback iPaymentStateCallback2;
            String str2;
            Long l2;
            Boolean bool2;
            Map map3;
            Map map4;
            if (obj == null) {
                if ((i & 2) != 0) {
                    iPaymentStateCallback2 = null;
                } else {
                    iPaymentStateCallback2 = iPaymentStateCallback;
                }
                if ((i & 8) != 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
                if ((i & 16) != 0) {
                    l2 = null;
                } else {
                    l2 = l;
                }
                if ((i & 32) != 0) {
                    bool2 = null;
                } else {
                    bool2 = bool;
                }
                if ((i & 64) != 0) {
                    map3 = null;
                } else {
                    map3 = map;
                }
                if ((i & 128) != 0) {
                    map4 = null;
                } else {
                    map4 = map2;
                }
                media2YYService.startPayment(context, iPaymentStateCallback2, iPaymentLogDelegate, str2, l2, bool2, map3, map4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPayment");
        }
    }
}
