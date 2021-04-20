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
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.beans.NewCashierBean;
import com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPayForTransCashier;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanManager;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class LBSTransCashierActivity extends LBSBaseActivity {
    public static final String BEAN_TAG = "LBSTransCashierActivity";
    public Context mAct;
    public CashierDataNew mCashierData;
    public NewCashierBean mNewcashierBean;

    private void cancleNewCashierBean() {
        NewCashierBean newCashierBean = this.mNewcashierBean;
        if (newCashierBean != null) {
            newCashierBean.destroyBean();
        }
    }

    private void getCashier() {
        if (this.mCashierData != null) {
            PayStatisticsUtil.onEventStart(StatServiceEvent.LBS_API_GET_CASHIER);
            NewCashierBean newCashierBean = (NewCashierBean) LbsPayBeanFactory.getInstance().getBean((Context) this, 1, BEAN_TAG);
            this.mNewcashierBean = newCashierBean;
            newCashierBean.setmCashierData(this.mCashierData);
            this.mNewcashierBean.setResponseCallback(this);
            this.mNewcashierBean.execBean();
        }
    }

    private ArrayList<String> getChannelDesc(NewCashierContent newCashierContent) {
        NewCashierContent.CashierPay cashierPay;
        NewCashierContent.CashierChannels cashierChannels;
        ArrayList<String> arrayList = new ArrayList<>();
        CashierDataNew cashierDataNew = this.mCashierData;
        if (cashierDataNew != null) {
            arrayList.add(cashierDataNew.getData().get("payAmount"));
        }
        if (newCashierContent != null && (cashierPay = newCashierContent.pay) != null && (cashierChannels = cashierPay.channels) != null && cashierChannels.platform != null) {
            int i = 0;
            while (true) {
                NewCashierContent.CashierChannel[] cashierChannelArr = newCashierContent.pay.channels.platform;
                if (i >= cashierChannelArr.length) {
                    break;
                } else if (cashierChannelArr[i].getChanelId() == 126) {
                    arrayList.add(newCashierContent.pay.channels.platform[i].getDesc());
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private final String getGroupStr(String... strArr) {
        if (strArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                sb.append(strArr[i]);
            } else {
                sb.append("");
            }
            sb.append("_");
        }
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        return sb.toString();
    }

    private void initView() {
        setContentView(ResUtils.layout(getActivity(), "wallet_base_layout_loading"));
        AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i, int i2, String str) {
        String str2;
        String str3;
        String str4;
        if (!TextUtils.isEmpty(str)) {
            GlobalUtils.toast(this.mAct, str);
        }
        CashierDataNew cashierDataNew = this.mCashierData;
        String str5 = "";
        if (cashierDataNew != null) {
            str5 = cashierDataNew.getUid();
            str2 = this.mCashierData.getOrderNo();
            str3 = NetworkUtils.getNetName(this.mAct);
            str4 = this.mCashierData.getCustomId();
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
        }
        PayStatisticsUtil.onEventEndWithValue(StatServiceEvent.LBS_API_GET_CASHIER, i2, getGroupStr(String.valueOf(i2), str5, str4, str2, str3));
        ChannelBaiduPayForTransCashier.getInstance().payCancel(this.mAct);
        finishWithoutAnim();
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i, Object obj, String str) {
        PayStatisticsUtil.onEventEnd(StatServiceEvent.LBS_API_GET_CASHIER, 0);
        NewCashierContent newCashierContent = obj instanceof NewCashierContent ? (NewCashierContent) obj : null;
        if (newCashierContent != null) {
            String orderInfo = newCashierContent.getOrderInfo();
            if (newCashierContent.sdk_info != null && !TextUtils.isEmpty(orderInfo)) {
                ChannelBaiduPayForTransCashier.getInstance().pay(this.mAct, orderInfo, newCashierContent.sdk_info, this.mCashierData);
                finishWithoutAnim();
                return;
            }
            this.mCashierData.setShowAllPayType(1 == newCashierContent.bfb_only);
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.LBS_PAY_AMOUNT, getChannelDesc(newCashierContent));
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        cancleNewCashierBean();
        onBackPressedWithoutAnim();
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        CashierDataNew cashierDataNew = this.mCashierData;
        if (cashierDataNew != null) {
            bundle.putSerializable("mCashierData", cashierDataNew);
        }
        super.onSaveInstanceState(bundle);
    }

    public void setImmersiveActivityMargeinTop() {
        if (Build.VERSION.SDK_INT >= 19 && getActivity() != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "welcome_page"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }
}
