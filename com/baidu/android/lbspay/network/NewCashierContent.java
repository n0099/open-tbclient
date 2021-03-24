package com.baidu.android.lbspay.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import java.io.Serializable;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class NewCashierContent implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -6404441585155615479L;
    public String bdstoken;
    public int bfb_only;
    public CommonMarketing[] common_marketing;
    public String customerId;
    public String data;
    public CashierOrder order;
    public long order_expire_time;
    public CashierPay pay;
    public String paydata;
    public PrecashierCreateOrderResponse sdk_info;
    public long system_time;
    public String tn;
    public String token;

    /* loaded from: classes2.dex */
    public static class Brand implements Serializable {
        public static final long serialVersionUID = 1;
        public String desc;
        public String icon;
    }

    /* loaded from: classes2.dex */
    public static class CashierChannel implements IBaseChannel, Serializable {
        public static final long serialVersionUID = 1;
        public String activity_icon;
        public String agent_channel_code;
        public String agent_name;
        public String balance;
        public String channel_alias;
        public String channel_code;
        public String channel_desc_only;
        public String channel_ext;
        public String channel_icon;
        public String channel_name;
        public String channel_rank;
        public CommonUsedCard commonUsed;
        public String create_time;
        public int desc_is_red;
        public String group_name;
        public String icon_position;
        public int is_available;
        public int is_show;
        public String is_visible;
        public String marketing_desc;
        public String marketing_need_pay_amount;
        public int pay_channel_id;
        public int priority;
        public int showDefault;
        public String uc_ext;
        public String update_time;

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getActiveIcon() {
            return this.activity_icon;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getBankId() {
            return "";
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public int getChanelId() {
            return this.pay_channel_id;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getChannelAlias() {
            return this.channel_alias;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public CommonUsedCard getCommonUsedCard() {
            return this.commonUsed;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getDesc() {
            return this.channel_desc_only;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getIcon() {
            return this.channel_icon;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean getIsRed() {
            return this.desc_is_red == 1;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getMarketingDesc() {
            return this.marketing_desc;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getName() {
            return this.channel_name;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getPayAmount() {
            return this.marketing_need_pay_amount;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public int getPriority() {
            return this.priority;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getRecommendIcon() {
            return "";
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getShortCard() {
            return "";
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getUc_ext() {
            return this.uc_ext;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean isAvailable() {
            return this.is_available == 1;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean isChecked() {
            return this.showDefault == 1;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean isShow() {
            return this.is_show == 1;
        }
    }

    /* loaded from: classes2.dex */
    public static class CashierChannelCoupon implements Serializable {
        public static final long serialVersionUID = 8163949050735544670L;
        public String amount;
        public String desc;
        public String icon;
        public String type;

        public String getAmount() {
            return this.amount;
        }

        public String getDesc() {
            return this.desc;
        }
    }

    /* loaded from: classes2.dex */
    public static class CashierChannels implements Serializable {
        public static final long serialVersionUID = 1;
        public CashierChannel[] official_platform;
        public String official_platform_name;
        public CashierChannel[] platform;
        public String platform_name;
    }

    /* loaded from: classes2.dex */
    public static class CashierOrder implements Serializable {
        public static final long serialVersionUID = 1;
        public String paid_amount;
        public String total_amount;
    }

    /* loaded from: classes2.dex */
    public static class CashierPay implements Serializable {
        public static final long serialVersionUID = 1;
        public Brand brand;
        public CashierChannels channels;
        public String tn;
    }

    /* loaded from: classes2.dex */
    public static class CommonMarketing implements Serializable {
        public String pic;
        public String text;
        public String url;
    }

    /* loaded from: classes2.dex */
    public static class CommonUsedCard implements Serializable {
        public static final long serialVersionUID = 1;
        public String[] cardMarketings;
        public String cardName;

        public String[] getCardMarketings() {
            return this.cardMarketings;
        }

        public String getCardName() {
            return this.cardName;
        }
    }

    /* loaded from: classes2.dex */
    public interface IBaseChannel {
        String getActiveIcon();

        String getBankId();

        int getChanelId();

        String getChannelAlias();

        CommonUsedCard getCommonUsedCard();

        String getDesc();

        String getIcon();

        boolean getIsRed();

        String getMarketingDesc();

        String getName();

        String getPayAmount();

        int getPriority();

        String getRecommendIcon();

        String getShortCard();

        String getUc_ext();

        boolean isAvailable();

        boolean isChecked();

        boolean isShow();
    }

    /* loaded from: classes2.dex */
    public static class ReqField implements Serializable {
        public static final long serialVersionUID = 1;
        public String card_holder_id;
        public String card_holder_name;
        public String card_no;
        public String cvv2;
        public String expired_date;
        public String id_type;
        public String phone;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public String getOrderInfo() {
        if (TextUtils.isEmpty(this.paydata)) {
            return "";
        }
        String str = new String(Base64.decode(this.paydata, 0));
        LogUtil.logd("decodeddata=" + str);
        try {
            PayDataBean payDataBean = (PayDataBean) JsonUtils.fromJson(str, PayDataBean.class);
            return payDataBean != null ? payDataBean.params : "";
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
