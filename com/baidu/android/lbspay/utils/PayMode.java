package com.baidu.android.lbspay.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class PayMode {
    public static final /* synthetic */ PayMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayMode AliPay;
    public static final PayMode BaiduCardPay;
    public static final PayMode BaiduPay;
    public static final PayMode BankCard;
    public static final PayMode CardPay;
    public static final PayMode FastPay;
    public static final PayMode IPAYBALANCE;
    public static final PayMode IPAYRECHARGECARD;
    public static final PayMode IPAYSMS;
    public static final PayMode IPayGame;
    public static final PayMode WXPay;
    public static final PayMode unknownPay;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-667479100, "Lcom/baidu/android/lbspay/utils/PayMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-667479100, "Lcom/baidu/android/lbspay/utils/PayMode;");
                return;
            }
        }
        unknownPay = new PayMode("unknownPay", 0);
        AliPay = new PayMode("AliPay", 1);
        BaiduPay = new PayMode("BaiduPay", 2);
        BaiduCardPay = new PayMode("BaiduCardPay", 3);
        WXPay = new PayMode("WXPay", 4);
        FastPay = new PayMode("FastPay", 5);
        CardPay = new PayMode("CardPay", 6);
        IPayGame = new PayMode("IPayGame", 7);
        IPAYRECHARGECARD = new PayMode("IPAYRECHARGECARD", 8);
        IPAYSMS = new PayMode("IPAYSMS", 9);
        IPAYBALANCE = new PayMode("IPAYBALANCE", 10);
        PayMode payMode = new PayMode("BankCard", 11);
        BankCard = payMode;
        $VALUES = new PayMode[]{unknownPay, AliPay, BaiduPay, BaiduCardPay, WXPay, FastPay, CardPay, IPayGame, IPAYRECHARGECARD, IPAYSMS, IPAYBALANCE, payMode};
    }

    public PayMode(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PayMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PayMode) Enum.valueOf(PayMode.class, str) : (PayMode) invokeL.objValue;
    }

    public static PayMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PayMode[]) $VALUES.clone() : (PayMode[]) invokeV.objValue;
    }
}
