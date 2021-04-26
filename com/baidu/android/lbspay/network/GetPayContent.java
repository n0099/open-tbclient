package com.baidu.android.lbspay.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import java.io.Serializable;
import org.json.JSONException;
/* loaded from: classes.dex */
public class GetPayContent implements IBeanResponse, Serializable {
    public static final long serialVersionUID = 1;
    public int authorize_err_no;
    public String authorize_return_data;
    public CashierDataNew extraOrderInfo;
    public String order_info;
    public int payId;
    public String pay_result_param;
    public String pay_result_url;
    public String paydata;
    public String payurl;
    public String quthorize_err_msg;
    public String redirect_sp_succpage_remain_time;
    public PrecashierCreateOrderResponse sdk_info;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public PayDataBean getPayData() {
        if (!TextUtils.isEmpty(this.paydata)) {
            String str = new String(Base64.decode(this.paydata, 0));
            LogUtil.logd("decodeddata=" + str);
            try {
                return (PayDataBean) JsonUtils.fromJson(str, PayDataBean.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public int getPayId() {
        return this.payId;
    }

    public void setPayId(int i2) {
        this.payId = i2;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
