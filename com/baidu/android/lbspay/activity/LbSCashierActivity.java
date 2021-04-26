package com.baidu.android.lbspay.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.util.e;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.channelpay.fast.ChannelFastPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.view.ChannelFootView;
import com.baidu.android.lbspay.view.ChannelListView;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.lbspay.view.TitleBar;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LbSCashierActivity extends LBSBaseActivity implements LBSPayAli.INoSupportAliAuthorizePay {
    public static final String AUTHPAY_CANCEL_HOST = "BdwAliPayWithholdingCancel";
    public static final String AUTHPAY_SUCCESS_HOST = "BdwAliPayWithholdingSuccess";
    public static final String BEAN_TAG = "LbSCashierActivity";
    public static String CASHIER_CONTENT = "cashiercontent";
    public static final int DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY = 61185;
    public static final int DIALOG_PROMPT_GUIDE_INSTALL_ALI_PAY_PKG = 61186;
    public static final String EVENT_BANNER_CLICK_PAY = "wallet_sdk_langbridge_juhe_banner_click_pay";
    public static final String EVENT_BANNER_HIDE = "wallet_sdk_langbridge_juhe_banner_hide";
    public static final int WITHHOLDING_FAIL = 110000;
    public static final int WITHHOLDING_SUCCESS = 100000;
    public TextView mAmount;
    public NewCashierContent.IBaseChannel mBaseChannel;
    public NewCashierContent mCashierContent;
    public CashierDataNew mCashierData;
    public ChannelFootView mChannelFootView;
    public int mChannelId;
    public ChannelListView mChannelListView;
    public IChannelPay mChannelPay;
    public GetPayBean mGetPayBean;
    public TextView mGoodsName;
    public LinearLayout mPay;
    public TextView mPayText;
    public View mPayWrap;
    public NewCashierContent.CashierChannel mSupportBaiFuBaoChannel;

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncGetPayAPI() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        int chanelId = this.mBaseChannel.getChanelId();
        this.mChannelId = chanelId;
        IChannelPay channelPay = ChannelPayUtil.getChannelPay(chanelId);
        this.mChannelPay = channelPay;
        if (channelPay == null || this.mCashierData == null) {
            return;
        }
        StatHelper.cacheChannelId(this.mChannelId + "");
        String orderNo = this.mCashierData.getOrderNo();
        List<String> collectData = StatHelper.collectData(orderNo, this.mChannelId + "");
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_CHANNEL, collectData, hashMap);
        StatisticManager.onEventWithValue(StatServiceEvent.LBS_DO_PAY_CLICK, ChannelPayUtil.getChannelTag(this.mBaseChannel.getChanelId()));
        StatisticManager.onEventStart(StatServiceEvent.LBS_API_GET_PAY);
        this.mGetPayBean = (GetPayBean) LbsPayBeanFactory.getInstance().getBean((Context) this, 2, BEAN_TAG);
        ((AbstractChannelPay) this.mChannelPay).setNotifyOnError(false);
        this.mGetPayBean.setmCashierData(this.mCashierData);
        this.mGetPayBean.setmChannel(this.mBaseChannel);
        this.mGetPayBean.setmCashierContent(this.mCashierContent);
        this.mGetPayBean.setResponseCallback(this);
        this.mGetPayBean.execBean();
    }

    private String getCommonMarketUrl(NewCashierContent newCashierContent) {
        NewCashierContent.CommonMarketing[] commonMarketingArr;
        return (newCashierContent == null || (commonMarketingArr = newCashierContent.common_marketing) == null || commonMarketingArr.length <= 0 || TextUtils.isEmpty(commonMarketingArr[0].url)) ? "" : newCashierContent.common_marketing[0].url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPay() {
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        NewCashierContent.IBaseChannel channel = this.mChannelListView.getChannel();
        this.mBaseChannel = channel;
        if (channel != null) {
            asyncGetPayAPI();
        }
    }

    private NewCashierContent.CashierChannel getSupportBaiFuBaoChannel() {
        List<NewCashierContent.CashierChannel> officialChannels;
        ChannelListView channelListView = this.mChannelListView;
        if (channelListView == null || (officialChannels = channelListView.getOfficialChannels()) == null || officialChannels.size() <= 0) {
            return null;
        }
        for (NewCashierContent.CashierChannel cashierChannel : officialChannels) {
            if (cashierChannel != null && cashierChannel.isAvailable() && TextUtils.equals(cashierChannel.channel_code, PayChannelController.BAIFUBAO_PAYCHANNEL_CODE)) {
                return cashierChannel;
            }
        }
        return null;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mCashierData = (CashierDataNew) bundle.getSerializable(CashierDataNew.DELIVERY_CASHIER_DATA);
            this.mCashierContent = (NewCashierContent) bundle.getSerializable(CASHIER_CONTENT);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    Serializable serializableExtra = intent.getSerializableExtra(CashierDataNew.DELIVERY_CASHIER_DATA);
                    if (serializableExtra != null && (serializableExtra instanceof CashierDataNew)) {
                        this.mCashierData = (CashierDataNew) serializableExtra;
                    }
                    Serializable serializableExtra2 = intent.getSerializableExtra(CashierDataNew.DELIVERY_CASHIER_CONTENT);
                    if (serializableExtra2 != null && (serializableExtra2 instanceof NewCashierContent)) {
                        this.mCashierContent = (NewCashierContent) serializableExtra2;
                    }
                } catch (Exception unused) {
                }
            }
        }
        CashierDataNew cashierDataNew = this.mCashierData;
        if (cashierDataNew != null) {
            String goodsName = cashierDataNew.getGoodsName();
            if (!TextUtils.isEmpty(goodsName)) {
                this.mGoodsName.setText(goodsName);
                this.mGoodsName.setVisibility(0);
            } else {
                this.mGoodsName.setText("");
                this.mGoodsName.setVisibility(8);
            }
            String amount = this.mCashierData.amount();
            if (!TextUtils.isEmpty(amount)) {
                this.mAmount.setText(StringUtils.fen2Yuan(amount));
            }
            try {
                Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "wallet_base_font/FDCfont-Bold.ttf");
                if (createFromAsset != null) {
                    this.mAmount.setTypeface(createFromAsset);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        NewCashierContent newCashierContent = this.mCashierContent;
        if (newCashierContent != null && newCashierContent.pay != null) {
            updateChannels();
            updateFooter();
            setBootomDivierVisiable();
            return;
        }
        finish();
    }

    private void initEvent() {
        this.mPay.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LbSCashierActivity.this.getPay();
            }
        });
        this.mChannelListView.setSelectChannelListener(new PayChannelController.SelectChannelListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.3
            @Override // com.baidu.android.lbspay.view.PayChannelController.SelectChannelListener
            public void onSelectChannel(String str) {
                TextView textView = LbSCashierActivity.this.mPayText;
                textView.setText(ResUtils.getString(LbSCashierActivity.this, "lbspay_pay_confirm_paydesc") + "   " + String.format(ResUtils.getString(LbSCashierActivity.this, "lbspay_pay_confirm_payamount"), StringUtils.fen2Yuan(str)));
            }
        });
        this.mChannelListView.setShowAllChannelClickListener(new PayChannelController.DoShowAllChannelClick() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.4
            @Override // com.baidu.android.lbspay.view.PayChannelController.DoShowAllChannelClick
            public void doClick() {
                LbSCashierActivity.this.setBootomDivierVisiable();
            }
        });
        EventBus.getInstance().register(this, EVENT_BANNER_CLICK_PAY, 0, EventBus.ThreadMode.MainThread);
        EventBus.getInstance().register(this, EVENT_BANNER_HIDE, 0, EventBus.ThreadMode.MainThread);
    }

    private void initView() {
        setContentView(ResUtils.layout(this, "wallet_juhe_layout_cashier"));
        TitleBar titleBar = (TitleBar) findViewById(ResUtils.id(this, "wallet_lbs_titlebar"));
        this.titleBar = titleBar;
        titleBar.setTitle(ResUtils.getString(this, "lbspay_title_name"));
        this.mGoodsName = (TextView) findViewById(ResUtils.id(this, "goodsName"));
        this.mAmount = (TextView) findViewById(ResUtils.id(this, "price"));
        this.mChannelListView = (ChannelListView) findViewById(ResUtils.id(this, "paysdk_id_channellistview"));
        this.mChannelFootView = (ChannelFootView) findViewById(ResUtils.id(this, "lbspay_channel_foot_layout"));
        this.mPayWrap = findViewById(ResUtils.id(this, "lbspay_pay_warp"));
        this.mPay = (LinearLayout) findViewById(ResUtils.id(this, "lbspay_pay"));
        this.mPayText = (TextView) findViewById(ResUtils.id(this, "wallet_lbs_pay_textview"));
        setBtnImge();
        setBackButton();
        tryChangingTheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSystemBrowser() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://d.alipay.com"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void renderTitleBar() {
        int color = ResUtils.getColor(getActivity(), "lbspay_white");
        int color2 = ResUtils.getColor(getActivity(), "lbspay_color_222222");
        Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_juhe_back");
        this.titleBar.setBackgroundColor(color);
        ((TextView) this.titleBar.findViewById(ResUtils.id(getActivity(), "title_tv"))).setTextColor(color2);
        ((ImageView) this.titleBar.findViewById(ResUtils.id(getActivity(), "title_left_btn"))).setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBootomDivierVisiable() {
        findViewById(ResUtils.id(this, "content_layout")).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LbSCashierActivity lbSCashierActivity = LbSCashierActivity.this;
                View findViewById = lbSCashierActivity.findViewById(ResUtils.id(lbSCashierActivity, "lbspay_cashier_wap"));
                LbSCashierActivity lbSCashierActivity2 = LbSCashierActivity.this;
                if (lbSCashierActivity2.findViewById(ResUtils.id(lbSCashierActivity2, "content_layout")).getMeasuredHeight() > findViewById.getMeasuredHeight()) {
                    if (LbSCashierActivity.this.mChannelFootView != null) {
                        LbSCashierActivity.this.mChannelFootView.setPadding(30, 30, 30, 30);
                    }
                } else if (LbSCashierActivity.this.mChannelFootView != null) {
                    LbSCashierActivity.this.mChannelFootView.setPadding(30, 30, 30, 0);
                }
            }
        });
    }

    private void setBtnImge() {
        Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_juhe_security_icon");
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mPayText.setCompoundDrawables(drawable, null, null, null);
    }

    private void tryChangingTheme() {
        renderTitleBar();
    }

    private void updateChannels() {
        NewCashierContent newCashierContent;
        ChannelListView channelListView = this.mChannelListView;
        if (channelListView == null || (newCashierContent = this.mCashierContent) == null || newCashierContent.pay == null) {
            return;
        }
        channelListView.setAdapter(newCashierContent);
        this.mPayWrap.setVisibility(0);
    }

    private void updateFooter() {
        NewCashierContent.CashierPay cashierPay;
        ChannelFootView channelFootView = this.mChannelFootView;
        if (channelFootView != null) {
            NewCashierContent newCashierContent = this.mCashierContent;
            if (newCashierContent != null && (cashierPay = newCashierContent.pay) != null && cashierPay.brand != null) {
                channelFootView.setVisibility(0);
                this.mChannelFootView.initBrandData(this.mCashierContent.pay.brand);
                return;
            }
            this.mChannelFootView.setVisibility(8);
        }
    }

    public void doPay(GetPayContent getPayContent) {
        IChannelPay iChannelPay = this.mChannelPay;
        if (iChannelPay != null) {
            if ((iChannelPay instanceof ChannelFastPay) && TextUtils.isEmpty(((ChannelFastPay) iChannelPay).getUrl(getPayContent))) {
                GlobalUtils.toast(this, "支付失败");
                return;
            }
            if ((this.mChannelPay instanceof ChannelAliPay) && getPayContent.getPayData() != null && getPayContent.getPayData().isAliAuthPay()) {
                ((ChannelAliPay) this.mChannelPay).setAliPayNoSupportCallBack(this);
            }
            this.mChannelPay.pay(getActivity(), getPayContent);
            return;
        }
        GlobalUtils.toast(this, "暂不支持这种支付方式");
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i2, int i3, String str) {
        LogUtil.d("LbsCashier handle failed!");
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (i2 == 2) {
            LBSPayAli.getInstance().clearChannelPay();
            this.mChannelPay = null;
            if (!TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this, str);
            }
        }
        CashierDataNew cashierDataNew = this.mCashierData;
        String orderNo = cashierDataNew != null ? cashierDataNew.getOrderNo() : "";
        if (i2 == 2) {
            StatisticManager.onEventEndWithValue(StatServiceEvent.LBS_API_GET_PAY, i3, orderNo);
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i2, Object obj, String str) {
        IChannelPay iChannelPay;
        GetPayBean getPayBean;
        LogUtil.d("LbsCashier handle success");
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (obj != null && i2 == 2) {
            CashierDataNew cashierDataNew = this.mCashierData;
            StatisticManager.onEventEndWithValue(StatServiceEvent.LBS_API_GET_PAY, 0, cashierDataNew == null ? "" : cashierDataNew.getOrderNo());
            GetPayContent getPayContent = null;
            if (obj instanceof GetPayContent) {
                getPayContent = (GetPayContent) obj;
                getPayContent.extraOrderInfo = this.mCashierData;
            }
            if (getPayContent != null) {
                if (!TextUtils.isEmpty(getPayContent.redirect_sp_succpage_remain_time) && !"0".equals(getPayContent.redirect_sp_succpage_remain_time) && (iChannelPay = this.mChannelPay) != null && (getPayBean = this.mGetPayBean) != null && 126 != this.mChannelId) {
                    ((AbstractChannelPay) iChannelPay).setPayBean(getPayBean);
                }
                int i3 = getPayContent.authorize_err_no;
                if (i3 == 100000) {
                    LBSPayResult.payResult(this, 0, getPayContent.authorize_return_data);
                } else if (i3 > 100000 && i3 <= 110000) {
                    doPay(getPayContent);
                } else {
                    doPay(getPayContent);
                }
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        super.onActivityResult(i2, i3, intent);
        LogUtil.logd("requestCode=" + i2 + "#resultCode=" + i3);
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        LogUtil.logd("bundle =" + extras.toString());
        String string = extras.getString(WalletPayResultActivityConfig.PAY_RESULT);
        LogUtil.logd("result =" + string);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (string.equalsIgnoreCase("success")) {
            IChannelPay iChannelPay = this.mChannelPay;
            if (iChannelPay != null) {
                iChannelPay.paySuccess("");
            }
        } else if (string.equalsIgnoreCase(QueryResponse.Options.CANCEL)) {
            IChannelPay iChannelPay2 = this.mChannelPay;
            if (iChannelPay2 != null) {
                iChannelPay2.payCancel();
            }
        } else {
            string.equalsIgnoreCase(e.f1950a);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LBSPayResult.payResult(getActivity(), 2, "");
        super.onBackPressed();
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initEvent();
        initData(bundle);
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 61186) {
            return new PromptDialog(getActivity());
        }
        if (i2 == 61185) {
            return new PromptMultiBtnDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregister(this);
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
        StatisticManager.onEvent(LbsStatistics.QUIT_CASHDESK);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            StatisticManager.onEvent(StatServiceEvent.LBS_KEY_BACK);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null) {
            if (EVENT_BANNER_CLICK_PAY.equals(event.mEventKey)) {
                Object obj = event.mEventObj;
                if (obj == null || !(obj instanceof String)) {
                    return;
                }
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    int optInt = new JSONObject(str).optInt("pay_channel_id", 0);
                    if (this.mChannelListView.selectChannelById(optInt)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(getCommonMarketUrl(this.mCashierContent));
                        arrayList.add(optInt + "");
                        StatisticManager.onEventWithValues(LbsStatistics.WALLET_LBS_BANNER_CLICK_PAY, arrayList);
                        this.mChannelListView.hideCommonMarket();
                        this.mChannelListView.postDelayed(new Runnable() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LbSCashierActivity.this.getPay();
                            }
                        }, 500L);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (EVENT_BANNER_HIDE.equals(event.mEventKey)) {
                StatisticManager.onEventWithValue(LbsStatistics.WALLET_LBS_BANNER_HIDE, getCommonMarketUrl(this.mCashierContent));
                this.mChannelListView.hideCommonMarket();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        initData(null);
    }

    @Override // com.baidu.android.lbspay.channelpay.alipay.LBSPayAli.INoSupportAliAuthorizePay
    public void onNoSupportAliAuthorizePay() {
        NewCashierContent.CashierChannel supportBaiFuBaoChannel = getSupportBaiFuBaoChannel();
        this.mSupportBaiFuBaoChannel = supportBaiFuBaoChannel;
        if (supportBaiFuBaoChannel != null) {
            WalletGlobalUtils.safeShowDialog(this, DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY, "");
        } else {
            WalletGlobalUtils.safeShowDialog(this, DIALOG_PROMPT_GUIDE_INSTALL_ALI_PAY_PKG, "");
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(ResUtils.getString(this, "lbspay_pay_timeout_prompt"));
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.hideNegativeButton();
            promptDialog.setPositiveBtn(ResUtils.getString(this, "lbspay_make_sure_confirm"), new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(LbSCashierActivity.this, 3);
                    LbSCashierActivity.this.onBackPressed();
                }
            });
        } else if (i2 == 61185) {
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog.setMessage(ResUtils.getString(getActivity(), "lbspay_pay_guide_dxm_wallet_pay_type_msg"));
            promptMultiBtnDialog.setCanceledOnTouchOutside(false);
            promptMultiBtnDialog.setFirstBtnTextBold();
            promptMultiBtnDialog.setFirstBtn(ResUtils.getString(getActivity(), "lbspay_pay_use_dxm_wallet_pay_type"), new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_CONFIRM);
                    LbSCashierActivity lbSCashierActivity = LbSCashierActivity.this;
                    lbSCashierActivity.mBaseChannel = lbSCashierActivity.mSupportBaiFuBaoChannel;
                    LbSCashierActivity.this.mChannelListView.selectChannelById(LbSCashierActivity.this.mBaseChannel.getChanelId());
                    WalletGlobalUtils.safeDismissDialog(LbSCashierActivity.this, LbSCashierActivity.DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY);
                    LbSCashierActivity.this.asyncGetPayAPI();
                }
            });
            promptMultiBtnDialog.setSecondBtn(ResUtils.getString(getActivity(), "lbspay_pay_guide_install_ali_pay_pkg_confirm"), new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_INSTALL_ALI_PAY_PKG);
                    WalletGlobalUtils.safeDismissDialog(LbSCashierActivity.this, LbSCashierActivity.DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY);
                    LbSCashierActivity.this.openSystemBrowser();
                }
            });
            promptMultiBtnDialog.setThirdBtn(ResUtils.getString(getActivity(), "lbspay_cancel"), new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_CANCEL);
                    WalletGlobalUtils.safeDismissDialog(LbSCashierActivity.this, LbSCashierActivity.DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY);
                }
            });
        } else if (i2 == 61186) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage(ResUtils.getString(getActivity(), "lbspay_pay_guide_install_ali_pay_pkg_msg"));
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.cancelPositiveBtnTextBold();
            promptDialog2.setNegativeBtnTextColor(ResUtils.getColor(getActivity(), "lbspay_color_121C32"));
            promptDialog2.setNegativeBtn(new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_INSTALL_CANCEL);
                    WalletGlobalUtils.safeDismissDialog(LbSCashierActivity.this, LbSCashierActivity.DIALOG_PROMPT_GUIDE_INSTALL_ALI_PAY_PKG);
                }
            });
            promptDialog2.setPositiveBtnTextColor(ResUtils.getColor(getActivity(), "lbspay_color_121C32"));
            promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "lbspay_pay_guide_install_ali_pay_pkg_confirm"), new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_INSTALL_CONFIRM);
                    WalletGlobalUtils.safeDismissDialog(LbSCashierActivity.this, LbSCashierActivity.DIALOG_PROMPT_GUIDE_INSTALL_ALI_PAY_PKG);
                    LbSCashierActivity.this.openSystemBrowser();
                }
            });
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(CashierDataNew.DELIVERY_CASHIER_DATA, this.mCashierData);
        bundle.putSerializable(CASHIER_CONTENT, this.mCashierContent);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void setBackButton() {
        TitleBar titleBar = this.titleBar;
        if (titleBar != null) {
            titleBar.setLeftButton(new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(StatServiceEvent.LBS_TITLE_BACK);
                    LbSCashierActivity.this.onBackPressed();
                }
            });
        }
    }
}
