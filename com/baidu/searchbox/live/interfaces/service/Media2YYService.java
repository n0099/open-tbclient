package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.payment.IPaymentLogDelegate;
import com.baidu.searchbox.live.interfaces.payment.IPaymentStateCallback;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ;\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\b2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0085\u0001\u0010\u001a\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/Media2YYService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "key", "", "params", "", "postOnBeforeMixLiveActivityLaunch", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "", "", "extraParams", "release", "(Ljava/util/Map;)V", "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;", "logDelegate", "title", "", PayUiEventContent.AMOUNT, "", "closeOnSuc", "customExpandParams", LiveYYPluginManager.USE_FROM_START_PAYMENT, "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentStateCallback;Lcom/baidu/searchbox/live/interfaces/payment/IPaymentLogDelegate;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface Media2YYService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void postOnBeforeMixLiveActivityLaunch(Context context, String str, Map<String, String> map);

    void release(Map<String, ? extends Object> map);

    void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map<String, String> map, Map<String, ? extends Object> map2);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/Media2YYService$Companion;", "", "MEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG", "Ljava/lang/String;", "getMEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG", "()Ljava/lang/String;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.MINI_SHELL.MEDIA_2_YY);
        public static final String MEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG = MEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG;
        public static final String MEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG = MEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG;

        public final String getMEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG() {
            return MEDIA_2YY_POST_BEFORE_ACTIVITY_CONFIG;
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
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
