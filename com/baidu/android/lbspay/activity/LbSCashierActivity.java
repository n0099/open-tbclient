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
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.f;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LbSCashierActivity extends LBSBaseActivity implements LBSPayAli.INoSupportAliAuthorizePay {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1554582140, "Lcom/baidu/android/lbspay/activity/LbSCashierActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1554582140, "Lcom/baidu/android/lbspay/activity/LbSCashierActivity;");
        }
    }

    public LbSCashierActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncGetPayAPI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
            hashMap.put("pay_amount", StatHelper.getPayAmount());
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
    }

    private String getCommonMarketUrl(NewCashierContent newCashierContent) {
        InterceptResult invokeL;
        NewCashierContent.CommonMarketing[] commonMarketingArr;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, newCashierContent)) == null) ? (newCashierContent == null || (commonMarketingArr = newCashierContent.common_marketing) == null || commonMarketingArr.length <= 0 || TextUtils.isEmpty(commonMarketingArr[0].url)) ? "" : newCashierContent.common_marketing[0].url : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || CheckUtils.isFastDoubleClick()) {
            return;
        }
        NewCashierContent.IBaseChannel channel = this.mChannelListView.getChannel();
        this.mBaseChannel = channel;
        if (channel != null) {
            asyncGetPayAPI();
        }
    }

    private NewCashierContent.CashierChannel getSupportBaiFuBaoChannel() {
        InterceptResult invokeV;
        List<NewCashierContent.CashierChannel> officialChannels;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
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
        return (NewCashierContent.CashierChannel) invokeV.objValue;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, bundle) == null) {
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
                    Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "dxm_wallet_base_font/FDCfont-Bold.ttf");
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
    }

    private void initEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mPay.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LbSCashierActivity f36809a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36809a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f36809a.getPay();
                    }
                }
            });
            this.mChannelListView.setSelectChannelListener(new PayChannelController.SelectChannelListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LbSCashierActivity f36810a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36810a = this;
                }

                @Override // com.baidu.android.lbspay.view.PayChannelController.SelectChannelListener
                public void onSelectChannel(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        TextView textView = this.f36810a.mPayText;
                        textView.setText(ResUtils.getString(this.f36810a, "lbspay_pay_confirm_paydesc") + "   " + String.format(ResUtils.getString(this.f36810a, "lbspay_pay_confirm_payamount"), StringUtils.fen2Yuan(str)));
                    }
                }
            });
            this.mChannelListView.setShowAllChannelClickListener(new PayChannelController.DoShowAllChannelClick(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LbSCashierActivity f36811a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36811a = this;
                }

                @Override // com.baidu.android.lbspay.view.PayChannelController.DoShowAllChannelClick
                public void doClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36811a.setBootomDivierVisiable();
                    }
                }
            });
            EventBus.getInstance().register(this, EVENT_BANNER_CLICK_PAY, 0, EventBus.ThreadMode.MainThread);
            EventBus.getInstance().register(this, EVENT_BANNER_HIDE, 0, EventBus.ThreadMode.MainThread);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSystemBrowser() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://d.alipay.com"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    private void renderTitleBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            int color = ResUtils.getColor(getActivity(), "lbspay_white");
            int color2 = ResUtils.getColor(getActivity(), "lbspay_color_222222");
            Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_juhe_back");
            this.titleBar.setBackgroundColor(color);
            ((TextView) this.titleBar.findViewById(ResUtils.id(getActivity(), "title_tv"))).setTextColor(color2);
            ((ImageView) this.titleBar.findViewById(ResUtils.id(getActivity(), "title_left_btn"))).setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBootomDivierVisiable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            findViewById(ResUtils.id(this, "content_layout")).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LbSCashierActivity f36807a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36807a = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LbSCashierActivity lbSCashierActivity = this.f36807a;
                        View findViewById = lbSCashierActivity.findViewById(ResUtils.id(lbSCashierActivity, "lbspay_cashier_wap"));
                        LbSCashierActivity lbSCashierActivity2 = this.f36807a;
                        if (lbSCashierActivity2.findViewById(ResUtils.id(lbSCashierActivity2, "content_layout")).getMeasuredHeight() > findViewById.getMeasuredHeight()) {
                            if (this.f36807a.mChannelFootView != null) {
                                this.f36807a.mChannelFootView.setPadding(30, 30, 30, 30);
                            }
                        } else if (this.f36807a.mChannelFootView != null) {
                            this.f36807a.mChannelFootView.setPadding(30, 30, 30, 0);
                        }
                    }
                }
            });
        }
    }

    private void setBtnImge() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_juhe_security_icon");
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mPayText.setCompoundDrawables(drawable, null, null, null);
        }
    }

    private void tryChangingTheme() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            renderTitleBar();
        }
    }

    private void updateChannels() {
        ChannelListView channelListView;
        NewCashierContent newCashierContent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (channelListView = this.mChannelListView) == null || (newCashierContent = this.mCashierContent) == null || newCashierContent.pay == null) {
            return;
        }
        channelListView.setAdapter(newCashierContent);
        this.mPayWrap.setVisibility(0);
    }

    private void updateFooter() {
        ChannelFootView channelFootView;
        NewCashierContent.CashierPay cashierPay;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (channelFootView = this.mChannelFootView) == null) {
            return;
        }
        NewCashierContent newCashierContent = this.mCashierContent;
        if (newCashierContent != null && (cashierPay = newCashierContent.pay) != null && cashierPay.brand != null) {
            channelFootView.setVisibility(0);
            this.mChannelFootView.initBrandData(this.mCashierContent.pay.brand);
            return;
        }
        this.mChannelFootView.setVisibility(8);
    }

    public void doPay(GetPayContent getPayContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, getPayContent) == null) {
            IChannelPay iChannelPay = this.mChannelPay;
            if (iChannelPay != null) {
                if ((iChannelPay instanceof ChannelFastPay) && TextUtils.isEmpty(((ChannelFastPay) iChannelPay).getUrl(getPayContent))) {
                    GlobalUtils.toast(this, EventAlias.PayEventAlias.PAY_FAIL);
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
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
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
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i2, Object obj, String str) {
        IChannelPay iChannelPay;
        GetPayBean getPayBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
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
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            String str = "requestCode=" + i2 + "#resultCode=" + i3;
            if (intent == null || (extras = intent.getExtras()) == null) {
                return;
            }
            String str2 = "bundle =" + extras.toString();
            String string = extras.getString(WalletPayResultActivityConfig.PAY_RESULT);
            String str3 = "result =" + string;
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
                string.equalsIgnoreCase(f.f36109j);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LBSPayResult.payResult(getActivity(), 2, "");
            super.onBackPressed();
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            initView();
            initEvent();
            initData(bundle);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 == 61186) {
                return new PromptDialog(getActivity());
            }
            if (i2 == 61185) {
                return new PromptMultiBtnDialog(getActivity());
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            EventBus.getInstance().unregister(this);
            BeanManager.getInstance().removeAllBeans(BEAN_TAG);
            StatisticManager.onEvent(LbsStatistics.QUIT_CASHDESK);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                StatisticManager.onEvent(StatServiceEvent.LBS_KEY_BACK);
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, event) == null) || event == null) {
            return;
        }
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
                    this.mChannelListView.postDelayed(new Runnable(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ LbSCashierActivity f36805a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f36805a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f36805a.getPay();
                            }
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            initData(null);
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.alipay.LBSPayAli.INoSupportAliAuthorizePay
    public void onNoSupportAliAuthorizePay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            NewCashierContent.CashierChannel supportBaiFuBaoChannel = getSupportBaiFuBaoChannel();
            this.mSupportBaiFuBaoChannel = supportBaiFuBaoChannel;
            if (supportBaiFuBaoChannel != null) {
                WalletGlobalUtils.safeShowDialog(this, DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY, "");
            } else {
                WalletGlobalUtils.safeShowDialog(this, DIALOG_PROMPT_GUIDE_INSTALL_ALI_PAY_PKG, "");
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, dialog) == null) {
            if (i2 == 3) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(ResUtils.getString(this, "lbspay_pay_timeout_prompt"));
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.hideNegativeButton();
                promptDialog.setPositiveBtn(ResUtils.getString(this, "lbspay_make_sure_confirm"), new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LbSCashierActivity f36812a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36812a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f36812a, 3);
                            this.f36812a.onBackPressed();
                        }
                    }
                });
            } else if (i2 == 61185) {
                PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
                promptMultiBtnDialog.setMessage(ResUtils.getString(getActivity(), "lbspay_pay_guide_dxm_wallet_pay_type_msg"));
                promptMultiBtnDialog.setCanceledOnTouchOutside(false);
                promptMultiBtnDialog.setFirstBtnTextBold();
                promptMultiBtnDialog.setFirstBtn(ResUtils.getString(getActivity(), "lbspay_pay_use_dxm_wallet_pay_type"), new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LbSCashierActivity f36813a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36813a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_CONFIRM);
                            LbSCashierActivity lbSCashierActivity = this.f36813a;
                            lbSCashierActivity.mBaseChannel = lbSCashierActivity.mSupportBaiFuBaoChannel;
                            this.f36813a.mChannelListView.selectChannelById(this.f36813a.mBaseChannel.getChanelId());
                            WalletGlobalUtils.safeDismissDialog(this.f36813a, LbSCashierActivity.DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY);
                            this.f36813a.asyncGetPayAPI();
                        }
                    }
                });
                promptMultiBtnDialog.setSecondBtn(ResUtils.getString(getActivity(), "lbspay_pay_guide_install_ali_pay_pkg_confirm"), new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LbSCashierActivity f36814a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36814a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_INSTALL_ALI_PAY_PKG);
                            WalletGlobalUtils.safeDismissDialog(this.f36814a, LbSCashierActivity.DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY);
                            this.f36814a.openSystemBrowser();
                        }
                    }
                });
                promptMultiBtnDialog.setThirdBtn(ResUtils.getString(getActivity(), "lbspay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LbSCashierActivity f36815a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36815a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_CANCEL);
                            WalletGlobalUtils.safeDismissDialog(this.f36815a, LbSCashierActivity.DIALOG_PROMPT_GUIDE_DXM_WALLET_PAY);
                        }
                    }
                });
            } else if (i2 == 61186) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(ResUtils.getString(getActivity(), "lbspay_pay_guide_install_ali_pay_pkg_msg"));
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.cancelPositiveBtnTextBold();
                promptDialog2.setNegativeBtnTextColor(ResUtils.getColor(getActivity(), "lbspay_color_121C32"));
                promptDialog2.setNegativeBtn(new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LbSCashierActivity f36816a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36816a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_INSTALL_CANCEL);
                            WalletGlobalUtils.safeDismissDialog(this.f36816a, LbSCashierActivity.DIALOG_PROMPT_GUIDE_INSTALL_ALI_PAY_PKG);
                        }
                    }
                });
                promptDialog2.setPositiveBtnTextColor(ResUtils.getColor(getActivity(), "lbspay_color_121C32"));
                promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "lbspay_pay_guide_install_ali_pay_pkg_confirm"), new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LbSCashierActivity f36806a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36806a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(LbsStatistics.WALLET_LBS_ALI_FAIL_GUIDE_INSTALL_CONFIRM);
                            WalletGlobalUtils.safeDismissDialog(this.f36806a, LbSCashierActivity.DIALOG_PROMPT_GUIDE_INSTALL_ALI_PAY_PKG);
                            this.f36806a.openSystemBrowser();
                        }
                    }
                });
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            bundle.putSerializable(CashierDataNew.DELIVERY_CASHIER_DATA, this.mCashierData);
            bundle.putSerializable(CASHIER_CONTENT, this.mCashierContent);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void setBackButton() {
        TitleBar titleBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (titleBar = this.titleBar) == null) {
            return;
        }
        titleBar.setLeftButton(new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.activity.LbSCashierActivity.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LbSCashierActivity f36808a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36808a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    StatisticManager.onEvent(StatServiceEvent.LBS_TITLE_BACK);
                    this.f36808a.onBackPressed();
                }
            }
        });
    }
}
