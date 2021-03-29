package com.baidu.android.lbspay.channelpay;

import com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay;
import com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPay;
import com.baidu.android.lbspay.channelpay.fast.ChannelFastPay;
import com.baidu.android.lbspay.channelpay.wxpay.ChannelWXPay;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes.dex */
public class ChannelPayUtil {
    public static IChannelPay getChannelPay(int i) {
        LogUtil.logd("channelId=" + i);
        if (i != -3) {
            if (i != -2) {
                if (i != -1) {
                    if (i == 105) {
                        return new ChannelAliPay();
                    }
                    if (i != 107) {
                        if (i != 126) {
                            if (i == 158) {
                                return ChannelWXPay.getInstance();
                            }
                            if (i != 175 && i != 178) {
                                switch (i) {
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

    public static String getChannelTag(int i) {
        LogUtil.logd("channelId=" + i);
        if (i != -2) {
            if (i != -1) {
                if (i != 105) {
                    if (i != 107) {
                        if (i != 126) {
                            if (i != 158) {
                                if (i != 178) {
                                    switch (i) {
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
                        return "baidu";
                    }
                    return "fast_pay";
                }
                return LBSTransAuthPresenter.AUTH_CHANNEL_ALI;
            }
            return "card_pay";
        }
        return "wise_card";
    }

    public static PayMode getPayMode(int i) {
        LogUtil.logd("channelId=" + i);
        if (getChannelPay(i) == null) {
            return PayMode.unknownPay;
        }
        if (i != -2) {
            if (i != -1) {
                if (i != 105) {
                    if (i != 107) {
                        if (i != 126) {
                            if (i != 158) {
                                if (i != 178) {
                                    switch (i) {
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
}
