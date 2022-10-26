package com.baidu.poly.widget;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.poly.widget.entitiy.PayChannelExtInfoEntity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PayChannelEntity implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IS_FOLD_FALSE = 0;
    public static final int IS_FOLD_TRUE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean alreadySigned;
    public long available_par_money;
    public List childrenPayChannels;
    public int disAbled;
    public String disAbledMsg;
    public String display_color;
    public String display_name;
    public int enable;
    public String error_text;
    public boolean flow;
    public int free_pay;
    public String host_marketing_detail;
    public String icon;
    public String installmentPeriod;
    public int is_fold;
    public int is_private;
    public int is_selected;
    public String loadingIcon;
    public boolean needAgreementGuide;
    public int parasitifer;
    public PayChannelExtInfoEntity payChannelExtInfoEntity;
    public String pay_channel;
    public String pay_text;
    public long pre_pay_money;
    public String queryOrderString;

    public PayChannelEntity() {
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

    public long getAvailableParMoney() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.available_par_money;
        }
        return invokeV.longValue;
    }

    public String getDisplayColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.display_color;
        }
        return (String) invokeV.objValue;
    }

    public String getDisplayName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.display_name;
        }
        return (String) invokeV.objValue;
    }

    public int getEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.enable;
        }
        return invokeV.intValue;
    }

    public String getHostMarketingDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.host_marketing_detail;
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.icon;
        }
        return (String) invokeV.objValue;
    }

    public String getInstallmentPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.installmentPeriod;
        }
        return (String) invokeV.objValue;
    }

    public int getIsFold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.is_fold;
        }
        return invokeV.intValue;
    }

    public int getIsSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.is_selected;
        }
        return invokeV.intValue;
    }

    public String getLoadingIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.loadingIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getPayChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.pay_channel;
        }
        return (String) invokeV.objValue;
    }

    public PayChannelExtInfoEntity getPayChannelExtInfoEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.payChannelExtInfoEntity;
        }
        return (PayChannelExtInfoEntity) invokeV.objValue;
    }

    public String getPayText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.pay_text;
        }
        return (String) invokeV.objValue;
    }

    public String getQueryOrderString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.queryOrderString;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAlreadySigned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.alreadySigned;
        }
        return invokeV.booleanValue;
    }

    public boolean isFold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.is_fold == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedAgreementGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.needAgreementGuide;
        }
        return invokeV.booleanValue;
    }

    public PayChannelEntity(JSONObject jSONObject) {
        String str;
        JSONArray optJSONArray;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.display_name = jSONObject.optString("display_name");
        this.pay_channel = jSONObject.optString(DI.PAY_CHANNEL);
        this.pay_text = jSONObject.optString("pay_text");
        this.error_text = jSONObject.optString("error_text");
        this.available_par_money = jSONObject.optLong("available_par_money");
        this.icon = jSONObject.optString("icon");
        this.is_fold = jSONObject.optInt("is_fold");
        String str3 = "is_selected";
        this.is_selected = jSONObject.optInt("is_selected");
        this.is_private = jSONObject.optInt("is_private");
        this.free_pay = jSONObject.optInt("free_pay");
        this.enable = jSONObject.optInt("enable");
        this.display_color = jSONObject.optString("display_color");
        this.flow = jSONObject.optBoolean("flow");
        this.disAbled = jSONObject.optInt("disAbled", 0);
        this.disAbledMsg = jSONObject.optString("disAbledMsg", "");
        this.parasitifer = jSONObject.optInt("parasitifer");
        this.host_marketing_detail = jSONObject.optString("host_marketing_detail");
        this.needAgreementGuide = jSONObject.optBoolean("needAgreementGuide");
        this.alreadySigned = jSONObject.optBoolean("alreadySigned");
        this.queryOrderString = jSONObject.optString("queryOrderString");
        this.pre_pay_money = jSONObject.optLong("pre_pay_money");
        this.loadingIcon = jSONObject.optString("loading_icon");
        JSONObject optJSONObject = jSONObject.optJSONObject("installment");
        if (optJSONObject != null) {
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("detail");
            String optString = optJSONObject.optString("total");
            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                while (i3 < optJSONArray2.length()) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    String optString2 = optJSONObject2.optString("title");
                    String optString3 = optJSONObject2.optString("pay_text");
                    String optString4 = optJSONObject2.optString("commission");
                    String optString5 = optJSONObject2.optString(CriusAttrConstants.DISPLAY);
                    JSONArray jSONArray = optJSONArray2;
                    String optString6 = optJSONObject2.optString(str3);
                    String str4 = str3;
                    String optString7 = optJSONObject2.optString("installment_period");
                    InstallmentEntity installmentEntity = new InstallmentEntity();
                    installmentEntity.setTitle(optString2);
                    installmentEntity.setPayText(optString3);
                    installmentEntity.setCommission(optString4);
                    installmentEntity.setDisplay(optString5);
                    installmentEntity.setIsSelected(optString6);
                    installmentEntity.setInstallmentPeriod(optString7);
                    arrayList.add(installmentEntity);
                    i3++;
                    optJSONArray2 = jSONArray;
                    str3 = str4;
                }
                str = str3;
                PayChannelExtInfoEntity payChannelExtInfoEntity = new PayChannelExtInfoEntity();
                this.payChannelExtInfoEntity = payChannelExtInfoEntity;
                payChannelExtInfoEntity.setInstallmentEntities(arrayList);
                this.payChannelExtInfoEntity.setInstallmentTotal(optString);
                optJSONArray = jSONObject.optJSONArray("childrenPayChannels");
                if (optJSONArray == null && optJSONArray.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (i4 < optJSONArray.length()) {
                        try {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                            PayChannelEntity payChannelEntity = new PayChannelEntity();
                            payChannelEntity.display_name = jSONObject2.optString("display_name");
                            payChannelEntity.pay_channel = jSONObject2.optString(DI.PAY_CHANNEL);
                            payChannelEntity.pay_text = jSONObject2.optString("pay_text");
                            payChannelEntity.icon = jSONObject2.optString("icon");
                            str2 = str;
                            try {
                                payChannelEntity.is_selected = jSONObject2.optInt(str2);
                                arrayList2.add(payChannelEntity);
                            } catch (JSONException e) {
                                e = e;
                                e.printStackTrace();
                                i4++;
                                str = str2;
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            str2 = str;
                        }
                        i4++;
                        str = str2;
                    }
                    this.childrenPayChannels = arrayList2;
                    return;
                }
            }
        }
        str = "is_selected";
        optJSONArray = jSONObject.optJSONArray("childrenPayChannels");
        if (optJSONArray == null) {
        }
    }

    public void setHostMarketingDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.host_marketing_detail = str;
        }
    }

    public void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.icon = str;
        }
    }

    public void setInstallmentPeriod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.installmentPeriod = str;
        }
    }

    public void setIsFold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.is_fold = i;
        }
    }

    public void setIsSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.is_selected = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "PayChannelEntity{display_name='" + this.display_name + "', pay_channel='" + this.pay_channel + "', pay_text='" + this.pay_text + "', error_text='" + this.error_text + "', icon='" + this.icon + "', is_fold=" + this.is_fold + ", is_selected=" + this.is_selected + ", is_private=" + this.is_private + ", free_pay=" + this.free_pay + ", needAgreementGuide=" + this.needAgreementGuide + ", alreadySigned=" + this.alreadySigned + ", queryOrderString=" + this.queryOrderString + ", pre_pay_money=" + this.pre_pay_money + ", enable=" + this.enable + ", display_color='" + this.display_color + "', flow=" + this.flow + ", parasitifer=" + this.parasitifer + '}';
        }
        return (String) invokeV.objValue;
    }
}
