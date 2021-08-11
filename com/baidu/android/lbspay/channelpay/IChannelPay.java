package com.baidu.android.lbspay.channelpay;

import android.app.Activity;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public interface IChannelPay {
    public static final String BAIDU_CHANNEL_ALIAS = "BAIDU-BAIFUBAO-WISE-CARD";
    public static final int ID_ALI_PAY = 105;
    public static final int ID_BAIDU_PAY = 126;
    public static final int ID_BAIFUBAO_WISE_CARD = -2;
    public static final int ID_BANK_CARD_PAY = 178;
    public static final int ID_CARD_PAY = -1;
    public static final int ID_FAST_PAY = 107;
    public static final int ID_IPAY_PAY_GAME = 164;
    public static final int ID_IPAY_PAY_RECHARGEABLE_CARD = 163;
    public static final int ID_IPAY_PAY_SMS = 165;
    public static final int ID_IPAY_PAY_VIRTUALBALANCE = 166;
    public static final int ID_KUAIQIAN_CARD = -3;
    public static final int ID_SMS_PAY = 175;
    public static final int ID_WX_PAY = 158;
    public static final String KUAIQIAN_CHANNEL_ALIAS = "BAIDU-QUICKPAY-WISE";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State Init;
        public static final State PayEnd;
        public static final State Paying;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1916242804, "Lcom/baidu/android/lbspay/channelpay/IChannelPay$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1916242804, "Lcom/baidu/android/lbspay/channelpay/IChannelPay$State;");
                    return;
                }
            }
            Init = new State("Init", 0);
            Paying = new State("Paying", 1);
            State state = new State("PayEnd", 2);
            PayEnd = state;
            $VALUES = new State[]{Init, Paying, state};
        }

        public State(String str, int i2) {
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

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    int getChannelId();

    PayDataBean getPayData(GetPayContent getPayContent);

    State getState();

    void pay(Activity activity, Activity activity2, GetPayContent getPayContent);

    void pay(Activity activity, GetPayContent getPayContent);

    void payCancel();

    void payError(String str, String str2);

    void paySuccess(String str);

    void paying();
}
