package com.baidu.searchbox.live.interfaces.feedpay;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b \u0018\u0000 -:\u0001-B\u0007¢\u0006\u0004\b+\u0010,J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\"\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0003\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010\nR$\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\n¨\u0006."}, d2 = {"Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;", "", "isValid", "()Z", "", Constant.KEY_BUSINESS, "Ljava/lang/String;", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", "couponID", "getCouponID", "setCouponID", "", "currentPrice", "I", "getCurrentPrice", "()I", "setCurrentPrice", "(I)V", "cutPrice", "getCutPrice", "setCutPrice", "ext", "getExt", "setExt", "from", "getFrom", "setFrom", "isFree", "Z", "setFree", "(Z)V", "originPrice", "getOriginPrice", "setOriginPrice", "resId", "getResId", "setResId", "source", "getSource", "setSource", "<init>", "()V", "Companion", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class LiveFeedPayInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public String business;
    public String couponID;
    public int currentPrice;
    public int cutPrice;
    public String ext;
    public String from;
    public boolean isFree;
    public int originPrice;
    public String resId;
    public String source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo$Companion;", "", "resId", "", "isFree", "source", "from", "ext", "Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;", "with", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;", "<init>", "()V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public final LiveFeedPayInfo with(String str, boolean z, String str2, String str3, String str4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4})) == null) {
                LiveFeedPayInfo liveFeedPayInfo = new LiveFeedPayInfo();
                liveFeedPayInfo.setResId(str);
                liveFeedPayInfo.setFree(z);
                liveFeedPayInfo.setSource(str2);
                liveFeedPayInfo.setFrom(str3);
                liveFeedPayInfo.setExt(str4);
                return liveFeedPayInfo;
            }
            return (LiveFeedPayInfo) invokeCommon.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(911157504, "Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(911157504, "Lcom/baidu/searchbox/live/interfaces/feedpay/LiveFeedPayInfo;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public LiveFeedPayInfo() {
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

    public final String getBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.business : (String) invokeV.objValue;
    }

    public final String getCouponID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.couponID : (String) invokeV.objValue;
    }

    public final int getCurrentPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.currentPrice : invokeV.intValue;
    }

    public final int getCutPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cutPrice : invokeV.intValue;
    }

    public final String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.ext : (String) invokeV.objValue;
    }

    public final String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.from : (String) invokeV.objValue;
    }

    public final int getOriginPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.originPrice : invokeV.intValue;
    }

    public final String getResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.resId : (String) invokeV.objValue;
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.source : (String) invokeV.objValue;
    }

    public final boolean isFree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isFree : invokeV.booleanValue;
    }

    public final boolean isValid() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !TextUtils.isEmpty(this.resId) && (i2 = this.currentPrice) >= 0 && (i3 = this.originPrice) >= 0 && i2 <= i3 : invokeV.booleanValue;
    }

    public final void setBusiness(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.business = str;
        }
    }

    public final void setCouponID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.couponID = str;
        }
    }

    public final void setCurrentPrice(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.currentPrice = i2;
        }
    }

    public final void setCutPrice(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.cutPrice = i2;
        }
    }

    public final void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.ext = str;
        }
    }

    public final void setFree(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isFree = z;
        }
    }

    public final void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.from = str;
        }
    }

    public final void setOriginPrice(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.originPrice = i2;
        }
    }

    public final void setResId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.resId = str;
        }
    }

    public final void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.source = str;
        }
    }
}
