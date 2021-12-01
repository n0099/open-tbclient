package com.baidu.android.lbspay.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.beans.NewCashierBean;
import com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPayForTransCashier;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class LBSTransCashierActivity extends LBSBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "LBSTransCashierActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAct;
    public CashierDataNew mCashierData;
    public NewCashierBean mNewcashierBean;

    public LBSTransCashierActivity() {
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

    private void cancleNewCashierBean() {
        NewCashierBean newCashierBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (newCashierBean = this.mNewcashierBean) == null) {
            return;
        }
        newCashierBean.destroyBean();
    }

    private void getCashier() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.mCashierData == null) {
            return;
        }
        StatisticManager.onEventStart(StatServiceEvent.LBS_API_GET_CASHIER);
        NewCashierBean newCashierBean = (NewCashierBean) LbsPayBeanFactory.getInstance().getBean((Context) this, 1, BEAN_TAG);
        this.mNewcashierBean = newCashierBean;
        newCashierBean.setmCashierData(this.mCashierData);
        this.mNewcashierBean.setResponseCallback(this);
        this.mNewcashierBean.execBean();
    }

    private ArrayList<String> getChannelDesc(NewCashierContent newCashierContent) {
        InterceptResult invokeL;
        NewCashierContent.CashierPay cashierPay;
        NewCashierContent.CashierChannels cashierChannels;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, newCashierContent)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            CashierDataNew cashierDataNew = this.mCashierData;
            if (cashierDataNew != null) {
                arrayList.add(cashierDataNew.getData().get("payAmount"));
            }
            if (newCashierContent != null && (cashierPay = newCashierContent.pay) != null && (cashierChannels = cashierPay.channels) != null && cashierChannels.platform != null) {
                int i2 = 0;
                while (true) {
                    NewCashierContent.CashierChannel[] cashierChannelArr = newCashierContent.pay.channels.platform;
                    if (i2 >= cashierChannelArr.length) {
                        break;
                    } else if (cashierChannelArr[i2].getChanelId() == 126) {
                        arrayList.add(newCashierContent.pay.channels.platform[i2].getDesc());
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private final String getGroupStr(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, strArr)) == null) {
            if (strArr == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (!TextUtils.isEmpty(strArr[i2])) {
                    sb.append(strArr[i2]);
                } else {
                    sb.append("");
                }
                sb.append("_");
            }
            sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_layout_loading"));
            AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
            animationDrawable.stop();
            animationDrawable.start();
            setImmersiveActivityMargeinTop();
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i2, int i3, String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this.mAct, str);
            }
            CashierDataNew cashierDataNew = this.mCashierData;
            String str4 = "";
            if (cashierDataNew != null) {
                String orderNo = cashierDataNew.getOrderNo();
                str3 = NetworkUtils.getNetName(this.mAct);
                str2 = orderNo;
                str4 = this.mCashierData.getCustomId();
            } else {
                str2 = "";
                str3 = str2;
            }
            StatisticManager.onEventEndWithValue(StatServiceEvent.LBS_API_GET_CASHIER, i3, getGroupStr(String.valueOf(i3), str4, str2, str3));
            ChannelBaiduPayForTransCashier.getInstance().payCancel(this.mAct);
            finishWithoutAnim();
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            StatisticManager.onEventEnd(StatServiceEvent.LBS_API_GET_CASHIER, 0);
            NewCashierContent newCashierContent = obj instanceof NewCashierContent ? (NewCashierContent) obj : null;
            if (newCashierContent != null) {
                String orderInfo = newCashierContent.getOrderInfo();
                if (newCashierContent.sdk_info != null && !TextUtils.isEmpty(orderInfo)) {
                    ChannelBaiduPayForTransCashier.getInstance().pay(this.mAct, orderInfo, newCashierContent.sdk_info, this.mCashierData);
                    finishWithoutAnim();
                    return;
                }
                this.mCashierData.setShowAllPayType(1 == newCashierContent.bfb_only);
                StatisticManager.onEventWithValues(StatServiceEvent.LBS_PAY_AMOUNT, getChannelDesc(newCashierContent));
                Intent intent = new Intent(this.mAct, LbSCashierActivity.class);
                intent.setFlags(536870912);
                intent.putExtra(CashierDataNew.DELIVERY_CASHIER_DATA, this.mCashierData);
                intent.putExtra(CashierDataNew.DELIVERY_CASHIER_CONTENT, newCashierContent);
                startActivityWithoutAnim(intent);
                finishWithoutAnim();
                return;
            }
            ChannelBaiduPayForTransCashier.getInstance().payCancel(this.mAct);
            finishWithoutAnim();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cancleNewCashierBean();
            onBackPressedWithoutAnim();
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mAct = getActivity();
            initView();
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("mCashierData");
                if (serializable != null && (serializable instanceof CashierDataNew)) {
                    this.mCashierData = (CashierDataNew) serializable;
                }
            } else if (getIntent().getExtras() != null) {
                this.mCashierData = (CashierDataNew) getIntent().getExtras().get(CashierDataNew.DELIVERY_CASHIER_DATA);
            }
            if (this.mCashierData != null) {
                getCashier();
                return;
            }
            ChannelBaiduPayForTransCashier.getInstance().payCancel(this.mAct);
            finishWithoutAnim();
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(BEAN_TAG);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            CashierDataNew cashierDataNew = this.mCashierData;
            if (cashierDataNew != null) {
                bundle.putSerializable("mCashierData", cashierDataNew);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void setImmersiveActivityMargeinTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 19 || getActivity() == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "welcome_page"));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
    }
}
