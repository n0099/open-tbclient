package com.baidu.android.lbspay.channelpay;

import com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay;
import com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPay;
import com.baidu.android.lbspay.channelpay.fast.ChannelFastPay;
import com.baidu.android.lbspay.channelpay.wxpay.ChannelWXPay;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.android.util.io.PathUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ChannelPayUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChannelPayUtil() {
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

    public static IChannelPay getChannelPay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            String str = "channelId=" + i2;
            if (i2 != -3) {
                if (i2 != -2) {
                    if (i2 != -1) {
                        if (i2 == 105) {
                            return new ChannelAliPay();
                        }
                        if (i2 != 107) {
                            if (i2 != 126) {
                                if (i2 == 158) {
                                    return ChannelWXPay.getInstance();
                                }
                                if (i2 != 175 && i2 != 178) {
                                    switch (i2) {
                                        case 163:
                                        case IChannelPay.ID_IPAY_PAY_GAME /* 164 */:
                                        case 165:
                                        case 166:
                                            try {
                                                Class<?> cls = Class.forName("com.baidu.android.lbspay.channelpay.ipay.ChannelIpay");
                                                if (cls != null) {
                                                    return (IChannelPay) cls.newInstance();
                                                }
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                            return null;
                                        default:
                                            return null;
                                    }
                                }
                            }
                        }
                    }
                }
                return new ChannelBaiduPay();
            }
            return new ChannelFastPay();
        }
        return (IChannelPay) invokeI.objValue;
    }

    public static String getChannelTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            String str = "channelId=" + i2;
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 105) {
                        if (i2 != 107) {
                            if (i2 != 126) {
                                if (i2 != 158) {
                                    if (i2 != 178) {
                                        switch (i2) {
                                            case 163:
                                            case IChannelPay.ID_IPAY_PAY_GAME /* 164 */:
                                            case 165:
                                            case 166:
                                                return "ipay";
                                            default:
                                                return "";
                                        }
                                    }
                                    return "ipay";
                                }
                                return "wxpay";
                            }
                            return PathUtils.DIRCTORY_BAIDU;
                        }
                        return "fast_pay";
                    }
                    return LBSTransAuthPresenter.AUTH_CHANNEL_ALI;
                }
                return "card_pay";
            }
            return "wise_card";
        }
        return (String) invokeI.objValue;
    }

    public static PayMode getPayMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            String str = "channelId=" + i2;
            if (getChannelPay(i2) == null) {
                return PayMode.unknownPay;
            }
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 105) {
                        if (i2 != 107) {
                            if (i2 != 126) {
                                if (i2 != 158) {
                                    if (i2 != 178) {
                                        switch (i2) {
                                            case 163:
                                                return PayMode.IPAYRECHARGECARD;
                                            case IChannelPay.ID_IPAY_PAY_GAME /* 164 */:
                                                return PayMode.IPayGame;
                                            case 165:
                                                return PayMode.IPAYSMS;
                                            case 166:
                                                return PayMode.IPAYBALANCE;
                                            default:
                                                return PayMode.unknownPay;
                                        }
                                    }
                                    return PayMode.BankCard;
                                }
                                return PayMode.WXPay;
                            }
                            return PayMode.BaiduPay;
                        }
                        return PayMode.FastPay;
                    }
                    return PayMode.AliPay;
                }
                return PayMode.CardPay;
            }
            return PayMode.BaiduCardPay;
        }
        return (PayMode) invokeI.objValue;
    }
}
