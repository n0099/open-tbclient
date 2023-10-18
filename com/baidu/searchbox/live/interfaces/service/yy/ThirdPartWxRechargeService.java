package com.baidu.searchbox.live.interfaces.service.yy;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService;", "Lkotlin/Any;", "", "initWx", "()V", "", "isWxInstalled", "()Z", "", "payUrl", "Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType;", "type", "wxRecharge", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType;)V", "Companion", "WxPayType", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ThirdPartWxRechargeService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void initWx();

    boolean isWxInstalled();

    void wxRecharge(String str, WxPayType wxPayType);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000:\u0002\u0003\u0004B\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType;", "<init>", "()V", "WxPayYYLive", "WxPayYYPay", "Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType$WxPayYYLive;", "Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType$WxPayYYPay;", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static abstract class WxPayType {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType$WxPayYYLive;", "com/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes4.dex */
        public static final class WxPayYYLive extends WxPayType {
            public static final WxPayYYLive INSTANCE = new WxPayYYLive();

            public WxPayYYLive() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType$WxPayYYPay;", "com/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes4.dex */
        public static final class WxPayYYPay extends WxPayType {
            public static final WxPayYYPay INSTANCE = new WxPayYYPay();

            public WxPayYYPay() {
                super(null);
            }
        }

        public WxPayType() {
        }

        public /* synthetic */ WxPayType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.YY.THIRD_PART_WX_RECHARGE);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
