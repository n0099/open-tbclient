package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import kotlin.Metadata;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u000bJ5\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService;", "Lkotlin/Any;", "Landroid/content/Context;", "ctx", "Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;", "callback", "", "startPayment", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;)V", "", "title", "(Landroid/content/Context;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;)V", "", PayUiEventContent.AMOUNT, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;)V", "Companion", "YYPayResultCallback", "YYPayResultMessage", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public interface YYPayService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-320866976, "Lcom/baidu/searchbox/live/interfaces/service/YYPayService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-320866976, "Lcom/baidu/searchbox/live/interfaces/service/YYPayService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.YYPAY.YY_PAY);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultCallback;", "Lkotlin/Any;", "", "code", "", "msg", "", "onFail", "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultMessage;", "onSuccess", "(Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultMessage;)V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public interface YYPayResultCallback {
        void onFail(int i2, String str);

        void onSuccess(YYPayResultMessage yYPayResultMessage);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000B\u0007¢\u0006\u0004\b0\u00101J\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0003\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0003\"\u0004\b\u001f\u0010\u001cR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR\"\u0010-\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\r\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011¨\u00062"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/YYPayService$YYPayResultMessage;", "", "toString", "()Ljava/lang/String;", "", PayUiEventContent.AMOUNT, "J", "getAmount", "()J", "setAmount", "(J)V", "", "appid", "I", "getAppid", "()I", "setAppid", "(I)V", "currencyAmount", "getCurrencyAmount", "setCurrencyAmount", "currencyType", "getCurrencyType", "setCurrencyType", "expand", "Ljava/lang/String;", "getExpand", "setExpand", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "", "pollingTimeout", "Z", "getPollingTimeout", "()Z", "setPollingTimeout", "(Z)V", "status", "getStatus", "setStatus", "uid", "getUid", "setUid", "usedChannel", "getUsedChannel", "setUsedChannel", "<init>", "()V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public static final class YYPayResultMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        public YYPayResultMessage() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final long getAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.amount : invokeV.longValue;
        }

        public final int getAppid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appid : invokeV.intValue;
        }

        public final long getCurrencyAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.currencyAmount : invokeV.longValue;
        }

        public final int getCurrencyType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.currencyType : invokeV.intValue;
        }

        public final String getExpand() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.expand : (String) invokeV.objValue;
        }

        public final String getOrderId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.orderId : (String) invokeV.objValue;
        }

        public final boolean getPollingTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pollingTimeout : invokeV.booleanValue;
        }

        public final int getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.status : invokeV.intValue;
        }

        public final long getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.uid : invokeV.longValue;
        }

        public final int getUsedChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.usedChannel : invokeV.intValue;
        }

        public final void setAmount(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
                this.amount = j2;
            }
        }

        public final void setAppid(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
                this.appid = i2;
            }
        }

        public final void setCurrencyAmount(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
                this.currencyAmount = j2;
            }
        }

        public final void setCurrencyType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
                this.currencyType = i2;
            }
        }

        public final void setExpand(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.expand = str;
            }
        }

        public final void setOrderId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.orderId = str;
            }
        }

        public final void setPollingTimeout(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
                this.pollingTimeout = z;
            }
        }

        public final void setStatus(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
                this.status = i2;
            }
        }

        public final void setUid(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
                this.uid = j2;
            }
        }

        public final void setUsedChannel(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
                this.usedChannel = i2;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return "YYPayResultMessage{appid=" + this.appid + ", uid=" + this.uid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", orderId=" + this.orderId + ", expand='" + this.expand + ExtendedMessageFormat.QUOTE + ", status='" + this.status + ExtendedMessageFormat.QUOTE + ", pollingTimeout='" + this.pollingTimeout + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void startPayment(Context context, YYPayResultCallback yYPayResultCallback);

    void startPayment(Context context, String str, YYPayResultCallback yYPayResultCallback);

    void startPayment(Context context, String str, Long l, YYPayResultCallback yYPayResultCallback);
}
