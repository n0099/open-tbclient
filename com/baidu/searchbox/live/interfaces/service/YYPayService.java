package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService;", "Lkotlin/Any;", "Landroid/content/Context;", "ctx", "Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;", "callback", "", "startPayment", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;)V", "", "title", "(Landroid/content/Context;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;)V", "Companion", "YYPayResultCallback", "YYPayResultMessage", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface YYPayService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.YYPAY.YY_PAY);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;", "Lkotlin/Any;", "", "code", "", "msg", "", "onFail", "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultMessage;", "onSuccess", "(Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultMessage;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface YYPayResultCallback {
        void onFail(int i2, String str);

        void onSuccess(YYPayResultMessage yYPayResultMessage);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000B\u0007¢\u0006\u0004\b0\u00101J\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0003\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0003\"\u0004\b\u001f\u0010\u001cR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR\"\u0010-\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\r\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011¨\u00062"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultMessage;", "", "toString", "()Ljava/lang/String;", "", PayUiEventContent.AMOUNT, "J", "getAmount", "()J", "setAmount", "(J)V", "", "appid", "I", "getAppid", "()I", "setAppid", "(I)V", "currencyAmount", "getCurrencyAmount", "setCurrencyAmount", "currencyType", "getCurrencyType", "setCurrencyType", "expand", "Ljava/lang/String;", "getExpand", "setExpand", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "", "pollingTimeout", "Z", "getPollingTimeout", "()Z", "setPollingTimeout", "(Z)V", "status", "getStatus", "setStatus", "uid", "getUid", "setUid", "usedChannel", "getUsedChannel", "setUsedChannel", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class YYPayResultMessage {
        public long amount;
        public int appid;
        public long currencyAmount;
        public int currencyType;
        public String expand;
        public String orderId;
        public boolean pollingTimeout;
        public int status;
        public long uid;
        public int usedChannel;

        public final long getAmount() {
            return this.amount;
        }

        public final int getAppid() {
            return this.appid;
        }

        public final long getCurrencyAmount() {
            return this.currencyAmount;
        }

        public final int getCurrencyType() {
            return this.currencyType;
        }

        public final String getExpand() {
            return this.expand;
        }

        public final String getOrderId() {
            return this.orderId;
        }

        public final boolean getPollingTimeout() {
            return this.pollingTimeout;
        }

        public final int getStatus() {
            return this.status;
        }

        public final long getUid() {
            return this.uid;
        }

        public final int getUsedChannel() {
            return this.usedChannel;
        }

        public final void setAmount(long j) {
            this.amount = j;
        }

        public final void setAppid(int i2) {
            this.appid = i2;
        }

        public final void setCurrencyAmount(long j) {
            this.currencyAmount = j;
        }

        public final void setCurrencyType(int i2) {
            this.currencyType = i2;
        }

        public final void setExpand(String str) {
            this.expand = str;
        }

        public final void setOrderId(String str) {
            this.orderId = str;
        }

        public final void setPollingTimeout(boolean z) {
            this.pollingTimeout = z;
        }

        public final void setStatus(int i2) {
            this.status = i2;
        }

        public final void setUid(long j) {
            this.uid = j;
        }

        public final void setUsedChannel(int i2) {
            this.usedChannel = i2;
        }

        public String toString() {
            return "YYPayResultMessage{appid=" + this.appid + ", uid=" + this.uid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", orderId=" + this.orderId + ", expand='" + this.expand + "', status='" + this.status + "', pollingTimeout='" + this.pollingTimeout + "'}";
        }
    }

    void startPayment(Context context, YYPayResultCallback yYPayResultCallback);

    void startPayment(Context context, String str, YYPayResultCallback yYPayResultCallback);
}
