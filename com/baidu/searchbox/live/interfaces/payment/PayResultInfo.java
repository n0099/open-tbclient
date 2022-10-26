package com.baidu.searchbox.live.interfaces.payment;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R\"\u00104\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010\u0005\"\u0004\b6\u0010\u0007R\"\u00107\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/payment/PayResultInfo;", "", PayUiEventContent.AMOUNT, "J", "getAmount", "()J", "setAmount", "(J)V", "", "", "appClientExpand", "Ljava/util/Map;", "getAppClientExpand", "()Ljava/util/Map;", "setAppClientExpand", "(Ljava/util/Map;)V", "", "appid", "I", "getAppid", "()I", "setAppid", "(I)V", "currencyAmount", "getCurrencyAmount", "setCurrencyAmount", "currencyType", "getCurrencyType", "setCurrencyType", "expand", "Ljava/lang/String;", "getExpand", "()Ljava/lang/String;", "setExpand", "(Ljava/lang/String;)V", "", "extraParams", "getExtraParams", "setExtraParams", "orderId", "getOrderId", "setOrderId", "", "pollingTimeout", "Z", "getPollingTimeout", "()Z", "setPollingTimeout", "(Z)V", "status", "getStatus", "setStatus", "uid", "getUid", "setUid", "usedChannel", "getUsedChannel", "setUsedChannel", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PayResultInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long amount;
    public Map appClientExpand;
    public int appid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public Map extraParams;
    public String orderId;
    public boolean pollingTimeout;
    public int status;
    public long uid;
    public int usedChannel;

    public PayResultInfo() {
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

    public final long getAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.amount;
        }
        return invokeV.longValue;
    }

    public final Map getAppClientExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.appClientExpand;
        }
        return (Map) invokeV.objValue;
    }

    public final int getAppid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.appid;
        }
        return invokeV.intValue;
    }

    public final long getCurrencyAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.currencyAmount;
        }
        return invokeV.longValue;
    }

    public final int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.currencyType;
        }
        return invokeV.intValue;
    }

    public final String getExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.expand;
        }
        return (String) invokeV.objValue;
    }

    public final Map getExtraParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.extraParams;
        }
        return (Map) invokeV.objValue;
    }

    public final String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.orderId;
        }
        return (String) invokeV.objValue;
    }

    public final boolean getPollingTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.pollingTimeout;
        }
        return invokeV.booleanValue;
    }

    public final int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.status;
        }
        return invokeV.intValue;
    }

    public final long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.uid;
        }
        return invokeV.longValue;
    }

    public final int getUsedChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.usedChannel;
        }
        return invokeV.intValue;
    }

    public final void setAmount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.amount = j;
        }
    }

    public final void setAppClientExpand(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            this.appClientExpand = map;
        }
    }

    public final void setAppid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.appid = i;
        }
    }

    public final void setCurrencyAmount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.currencyAmount = j;
        }
    }

    public final void setCurrencyType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.currencyType = i;
        }
    }

    public final void setExpand(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.expand = str;
        }
    }

    public final void setExtraParams(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, map) == null) {
            this.extraParams = map;
        }
    }

    public final void setOrderId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.orderId = str;
        }
    }

    public final void setPollingTimeout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.pollingTimeout = z;
        }
    }

    public final void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.status = i;
        }
    }

    public final void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.uid = j;
        }
    }

    public final void setUsedChannel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.usedChannel = i;
        }
    }
}
