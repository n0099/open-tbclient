package com.baidu.android.lbspay.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import java.io.Serializable;
import org.json.JSONException;
/* loaded from: classes.dex */
public class NewCashierContent implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6404441585155615479L;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes.dex */
    public static class Brand implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String desc;
        public String icon;

        public Brand() {
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
    }

    /* loaded from: classes.dex */
    public static class CashierChannel implements IBaseChannel, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
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

        public CashierChannel() {
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

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getActiveIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.activity_icon : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getBankId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public int getChanelId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pay_channel_id : invokeV.intValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getChannelAlias() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.channel_alias : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public CommonUsedCard getCommonUsedCard() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.commonUsed : (CommonUsedCard) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.channel_desc_only : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.channel_icon : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean getIsRed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.desc_is_red == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getMarketingDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.marketing_desc : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.channel_name : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getPayAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.marketing_need_pay_amount : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public int getPriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.priority : invokeV.intValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getRecommendIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getShortCard() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public String getUc_ext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.uc_ext : (String) invokeV.objValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.is_available == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.showDefault == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
        public boolean isShow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.is_show == 1 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class CashierChannelCoupon implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8163949050735544670L;
        public transient /* synthetic */ FieldHolder $fh;
        public String amount;
        public String desc;
        public String icon;
        public String type;

        public CashierChannelCoupon() {
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

        public String getAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.amount : (String) invokeV.objValue;
        }

        public String getDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.desc : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class CashierChannels implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public CashierChannel[] official_platform;
        public String official_platform_name;
        public CashierChannel[] platform;
        public String platform_name;

        public CashierChannels() {
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
    }

    /* loaded from: classes.dex */
    public static class CashierOrder implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String paid_amount;
        public String total_amount;

        public CashierOrder() {
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
    }

    /* loaded from: classes.dex */
    public static class CashierPay implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public Brand brand;
        public CashierChannels channels;
        public String tn;

        public CashierPay() {
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
    }

    /* loaded from: classes.dex */
    public static class CommonMarketing implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String pic;
        public String text;
        public String url;

        public CommonMarketing() {
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
    }

    /* loaded from: classes.dex */
    public static class CommonUsedCard implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] cardMarketings;
        public String cardName;

        public CommonUsedCard() {
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

        public String[] getCardMarketings() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cardMarketings : (String[]) invokeV.objValue;
        }

        public String getCardName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cardName : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static class ReqField implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String card_holder_id;
        public String card_holder_name;
        public String card_no;
        public String cvv2;
        public String expired_date;
        public String id_type;
        public String phone;

        public ReqField() {
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
    }

    public NewCashierContent() {
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

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getOrderInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
        }
    }
}
