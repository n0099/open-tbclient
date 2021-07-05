package com.baidu.android.lbspay.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.android.lbspay.view.LbsPayRadioGroup;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ChannelListView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<NewCashierContent.CashierChannel> iBaseChannels;
    public List<NewCashierContent.CashierChannel> iOfficialChannels;
    public View mBannerView;
    public ImageView mCommonMarketLine;
    public Context mContext;
    public PayChannelController.GetPayModeListener mGetPayModeListener;
    public PayChannelController.SelectChannelListener mSelectChannelListener;
    public PayChannelController.DoShowAllChannelClick mShowAllChannelClick;
    public LbsPayRadioGroup radioGroupChannels;
    public ViewGroup vgMoreChannels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.iBaseChannels = new ArrayList();
        this.iOfficialChannels = new ArrayList();
        this.mContext = context;
        initView();
    }

    private View getNormalGroupView(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, context)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 19;
            TextView textView = new TextView(context);
            textView.setTextSize(0, ResUtils.getDimension(context, "lbspay_textsize_12"));
            textView.setTextColor(ResUtils.getColor(context, "lbspay_color_aaaaaa"));
            textView.setLayoutParams(layoutParams);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(DisplayUtils.dip2px(context, 15.0f), DisplayUtils.dip2px(context, 30.0f), DisplayUtils.dip2px(context, 15.0f), DisplayUtils.dip2px(context, 7.0f));
            textView.setText(str);
            return textView;
        }
        return (View) invokeLL.objValue;
    }

    private View getOtherGroupView(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, str, z)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_channel_showall"), (ViewGroup) null);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(ResUtils.id(getContext(), "show_all"));
            ((TextView) inflate.findViewById(ResUtils.id(getContext(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC))).setText(str);
            if (z) {
                viewGroup.setVisibility(0);
            } else {
                viewGroup.setVisibility(8);
            }
            viewGroup.setOnClickListener(new View.OnClickListener(this, viewGroup) { // from class: com.baidu.android.lbspay.view.ChannelListView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ViewGroup f2674a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ChannelListView f2675b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, viewGroup};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f2675b = this;
                    this.f2674a = viewGroup;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f2674a.setVisibility(4);
                        if (this.f2675b.radioGroupChannels != null) {
                            this.f2675b.radioGroupChannels.showAllChannels();
                        }
                        PayChannelController.DoShowAllChannelClick doShowAllChannelClick = this.f2675b.mShowAllChannelClick;
                        if (doShowAllChannelClick != null) {
                            doShowAllChannelClick.doClick();
                        }
                    }
                }
            });
            return inflate;
        }
        return (View) invokeLZ.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_customview_channel_list"), this);
            this.vgMoreChannels = (ViewGroup) findViewById(ResUtils.id(getContext(), "pasdk_id_vg_more_channels"));
            LbsPayRadioGroup lbsPayRadioGroup = (LbsPayRadioGroup) findViewById(ResUtils.id(getContext(), "paysdk_id_radiogroup"));
            this.radioGroupChannels = lbsPayRadioGroup;
            lbsPayRadioGroup.setOnCheckedListener(new LbsPayRadioGroup.OnCheckedListener(this) { // from class: com.baidu.android.lbspay.view.ChannelListView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChannelListView f2669a;

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
                    this.f2669a = this;
                }

                @Override // com.baidu.android.lbspay.view.LbsPayRadioGroup.OnCheckedListener
                public void onChecked(ChannelViewBase channelViewBase) {
                    ChannelListView channelListView;
                    PayChannelController.SelectChannelListener selectChannelListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, channelViewBase) == null) || this.f2669a.radioGroupChannels.getChannel() == null || (selectChannelListener = (channelListView = this.f2669a).mSelectChannelListener) == null) {
                        return;
                    }
                    selectChannelListener.onSelectChannel(channelListView.radioGroupChannels.getChannel().getPayAmount());
                }
            });
            setOrientation(1);
        }
    }

    public NewCashierContent.IBaseChannel getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LbsPayRadioGroup lbsPayRadioGroup = this.radioGroupChannels;
            if (lbsPayRadioGroup != null) {
                return lbsPayRadioGroup.getChannel();
            }
            return null;
        }
        return (NewCashierContent.IBaseChannel) invokeV.objValue;
    }

    public List<NewCashierContent.CashierChannel> getOfficialChannels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.iOfficialChannels : (List) invokeV.objValue;
    }

    public void hideCommonMarket() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (view = this.mBannerView) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void reSetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LbsPayRadioGroup lbsPayRadioGroup = this.radioGroupChannels;
            if (lbsPayRadioGroup != null) {
                lbsPayRadioGroup.removeAllViews();
                this.radioGroupChannels.setOncheckedView(null);
            }
            this.iBaseChannels.clear();
            this.vgMoreChannels.setVisibility(8);
            this.vgMoreChannels.setOnClickListener(null);
        }
    }

    public boolean selectChannelById(int i2) {
        InterceptResult invokeI;
        NewCashierContent.CashierChannel cashierChannel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int childCount = this.radioGroupChannels.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.radioGroupChannels.getChildAt(i3);
                if ((childAt instanceof ChannelViewBase) && childAt.getVisibility() == 0) {
                    ChannelViewBase channelViewBase = (ChannelViewBase) childAt;
                    Object tag = childAt.getTag();
                    if ((tag instanceof NewCashierContent.CashierChannel) && (cashierChannel = (NewCashierContent.CashierChannel) tag) != null && i2 == cashierChannel.getChanelId()) {
                        this.radioGroupChannels.onChecked(channelViewBase);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setAdapter(NewCashierContent newCashierContent) {
        NewCashierContent.CashierPay cashierPay;
        boolean z;
        PayChannelController.SelectChannelListener selectChannelListener;
        NewCashierContent.CommonMarketing[] commonMarketingArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, newCashierContent) == null) || newCashierContent == null || (cashierPay = newCashierContent.pay) == null) {
            return;
        }
        NewCashierContent.CashierChannels cashierChannels = cashierPay.channels;
        NewCashierContent.CashierChannel[] cashierChannelArr = cashierChannels != null ? cashierChannels.official_platform : null;
        NewCashierContent.CashierChannels cashierChannels2 = cashierPay.channels;
        NewCashierContent.CashierChannel[] cashierChannelArr2 = cashierChannels2 != null ? cashierChannels2.platform : null;
        if (this.iBaseChannels == null) {
            this.iBaseChannels = new ArrayList();
        }
        Comparator<NewCashierContent.IBaseChannel> comparator = new Comparator<NewCashierContent.IBaseChannel>(this) { // from class: com.baidu.android.lbspay.view.ChannelListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ChannelListView f2670a;

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
                this.f2670a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(NewCashierContent.IBaseChannel iBaseChannel, NewCashierContent.IBaseChannel iBaseChannel2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, iBaseChannel, iBaseChannel2)) == null) ? iBaseChannel.getPriority() - iBaseChannel2.getPriority() : invokeLL.intValue;
            }
        };
        LbsPayRadioGroup lbsPayRadioGroup = this.radioGroupChannels;
        if (lbsPayRadioGroup != null) {
            lbsPayRadioGroup.setGetPayModeListener(this.mGetPayModeListener);
        }
        if (cashierChannelArr != null && cashierChannelArr.length > 0) {
            Collections.addAll(this.iOfficialChannels, cashierChannelArr);
            Collections.sort(this.iOfficialChannels, comparator);
        }
        ChannelOfficialView channelOfficialView = null;
        ChannelOfficialView channelOfficialView2 = null;
        for (NewCashierContent.CashierChannel cashierChannel : this.iOfficialChannels) {
            ChannelOfficialView channelOfficialView3 = new ChannelOfficialView(getContext());
            channelOfficialView3.setEnabled(cashierChannel.isAvailable(), cashierChannel);
            if (cashierChannel.isAvailable()) {
                channelOfficialView3.setEnabled(true, cashierChannel);
                if (channelOfficialView == null && PayChannelController.BAIFUBAO_PAYCHANNEL.equals(cashierChannel.channel_alias)) {
                    channelOfficialView = channelOfficialView3;
                }
            } else {
                channelOfficialView3.setEnabled(false, cashierChannel);
            }
            channelOfficialView3.setTag(cashierChannel);
            channelOfficialView3.setChannel(cashierChannel);
            LbsPayRadioGroup lbsPayRadioGroup2 = this.radioGroupChannels;
            if (lbsPayRadioGroup2 != null) {
                lbsPayRadioGroup2.addView(channelOfficialView3);
            }
            if (channelOfficialView2 == null && cashierChannel.isChecked() && 1 == cashierChannel.is_available) {
                channelOfficialView3.setChecked(true);
                if (this.mGetPayModeListener != null) {
                    if (channelOfficialView3.getTag() instanceof NewCashierContent.IBaseChannel) {
                        this.mGetPayModeListener.getSelectPayMode(ChannelPayUtil.getPayMode(((NewCashierContent.IBaseChannel) channelOfficialView3.getTag()).getChanelId()));
                    } else {
                        this.mGetPayModeListener.getSelectPayMode(PayMode.unknownPay);
                    }
                }
                LbsPayRadioGroup lbsPayRadioGroup3 = this.radioGroupChannels;
                if (lbsPayRadioGroup3 != null) {
                    lbsPayRadioGroup3.setOncheckedView(channelOfficialView3);
                }
                channelOfficialView2 = channelOfficialView3;
            }
        }
        if (newCashierContent != null && (commonMarketingArr = newCashierContent.common_marketing) != null && commonMarketingArr.length > 0) {
            NewCashierContent.CommonMarketing commonMarketing = commonMarketingArr[0];
            if (!TextUtils.isEmpty(commonMarketing.text)) {
                if (this.mBannerView == null) {
                    this.mBannerView = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_banner"), (ViewGroup) null);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    int dip2px = DisplayUtils.dip2px(getContext(), 25.0f);
                    layoutParams.setMargins(dip2px, 0, dip2px, 0);
                    LbsPayRadioGroup lbsPayRadioGroup4 = this.radioGroupChannels;
                    if (lbsPayRadioGroup4 != null) {
                        lbsPayRadioGroup4.addView(this.mBannerView, layoutParams);
                    }
                }
                StatisticManager.onEventWithValue(LbsStatistics.WALLET_LBS_BANNER_SHOW, commonMarketing.url);
                showCommonMarket();
                if (TextUtils.isEmpty(commonMarketing.url)) {
                    this.mBannerView.findViewById(ResUtils.id(getContext(), "lbspay_promotion_array")).setVisibility(8);
                }
                ((TextView) this.mBannerView.findViewById(ResUtils.id(getContext(), "lbspay_promotion_text"))).setText(commonMarketing.text);
                this.mBannerView.setOnClickListener(new View.OnClickListener(this, commonMarketing) { // from class: com.baidu.android.lbspay.view.ChannelListView.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewCashierContent.CommonMarketing f2671a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ChannelListView f2672b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, commonMarketing};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f2672b = this;
                        this.f2671a = commonMarketing;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick() || TextUtils.isEmpty(this.f2671a.url)) {
                            return;
                        }
                        StatisticManager.onEventWithValue(LbsStatistics.WALLET_LBS_BANNER_CLICK, this.f2671a.url);
                        BaiduWalletDelegate.getInstance().openH5Module(this.f2672b.getContext(), this.f2671a.url, false);
                    }
                });
            }
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(ResUtils.dimen(this.mContext, "lbspay_item_devider_height")));
        layoutParams2.leftMargin = (int) ResUtils.getDimension(getContext(), "lbspay_cashier_item_marginleft");
        layoutParams2.rightMargin = (int) ResUtils.getDimension(getContext(), "lbspay_cashier_item_marginleft");
        layoutParams2.topMargin = (int) ResUtils.getDimension(getContext(), "lbspay_divider_margin_top");
        ImageView imageView = new ImageView(this.mContext);
        this.mCommonMarketLine = imageView;
        imageView.setImageResource(ResUtils.color(this.mContext, "lbspay_bg_item_devider_color"));
        this.mCommonMarketLine.setLayoutParams(layoutParams2);
        LbsPayRadioGroup lbsPayRadioGroup5 = this.radioGroupChannels;
        if (lbsPayRadioGroup5 != null) {
            lbsPayRadioGroup5.addView(this.mCommonMarketLine);
        }
        if (cashierChannelArr2 != null) {
            Collections.addAll(this.iBaseChannels, cashierChannelArr2);
        }
        Collections.sort(this.iBaseChannels, comparator);
        if (this.iBaseChannels.size() > 0) {
            String string = ResUtils.getString(this.mContext, "lbspay_channel_choose");
            NewCashierContent.CashierChannels cashierChannels3 = cashierPay.channels;
            if (cashierChannels3 != null && !TextUtils.isEmpty(cashierChannels3.platform_name)) {
                string = cashierPay.channels.platform_name;
            }
            Iterator<NewCashierContent.CashierChannel> it = this.iBaseChannels.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().isShow()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            View otherGroupView = getOtherGroupView(string, z);
            LbsPayRadioGroup lbsPayRadioGroup6 = this.radioGroupChannels;
            if (lbsPayRadioGroup6 != null) {
                lbsPayRadioGroup6.addView(otherGroupView);
            }
        } else {
            z = true;
        }
        boolean z2 = false;
        for (NewCashierContent.CashierChannel cashierChannel2 : this.iBaseChannels) {
            ChannelView channelView = new ChannelView(getContext());
            if (cashierChannel2.isShow()) {
                channelView.setVisibility(0);
            } else {
                channelView.setVisibility(8);
                z2 = true;
            }
            channelView.setEnabled(cashierChannel2.isAvailable(), cashierChannel2);
            channelView.setTag(cashierChannel2);
            channelView.setChannel(cashierChannel2);
            LbsPayRadioGroup lbsPayRadioGroup7 = this.radioGroupChannels;
            if (lbsPayRadioGroup7 != null) {
                lbsPayRadioGroup7.addView(channelView);
            }
            if (channelOfficialView2 == null && cashierChannel2.isChecked() && 1 == cashierChannel2.is_available) {
                channelView.setChecked(true);
                if (this.mGetPayModeListener != null) {
                    if (channelView.getTag() instanceof NewCashierContent.IBaseChannel) {
                        this.mGetPayModeListener.getSelectPayMode(ChannelPayUtil.getPayMode(((NewCashierContent.IBaseChannel) channelView.getTag()).getChanelId()));
                    } else {
                        this.mGetPayModeListener.getSelectPayMode(PayMode.unknownPay);
                    }
                }
                LbsPayRadioGroup lbsPayRadioGroup8 = this.radioGroupChannels;
                if (lbsPayRadioGroup8 != null) {
                    lbsPayRadioGroup8.setOncheckedView(channelView);
                }
                channelOfficialView2 = channelView;
            }
        }
        if (channelOfficialView2 == null && channelOfficialView != null) {
            channelOfficialView.setChecked(true);
            if (this.mGetPayModeListener != null) {
                if (channelOfficialView.getTag() instanceof NewCashierContent.IBaseChannel) {
                    this.mGetPayModeListener.getSelectPayMode(ChannelPayUtil.getPayMode(((NewCashierContent.IBaseChannel) channelOfficialView.getTag()).getChanelId()));
                } else {
                    this.mGetPayModeListener.getSelectPayMode(PayMode.unknownPay);
                }
            }
            LbsPayRadioGroup lbsPayRadioGroup9 = this.radioGroupChannels;
            if (lbsPayRadioGroup9 != null) {
                lbsPayRadioGroup9.setOncheckedView(channelOfficialView);
            }
        }
        if (z2 && !z) {
            this.vgMoreChannels.setVisibility(0);
            this.vgMoreChannels.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.lbspay.view.ChannelListView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChannelListView f2673a;

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
                    this.f2673a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayChannelController.DoShowAllChannelClick doShowAllChannelClick = this.f2673a.mShowAllChannelClick;
                        if (doShowAllChannelClick != null) {
                            doShowAllChannelClick.doClick();
                        }
                        if (this.f2673a.radioGroupChannels != null) {
                            this.f2673a.radioGroupChannels.showAllChannels();
                        }
                        this.f2673a.vgMoreChannels.setVisibility(8);
                        this.f2673a.vgMoreChannels.setOnClickListener(null);
                        StatisticManager.onEvent(LbsStatistics.LBS_MORE_CHANNELS);
                    }
                }
            });
        } else {
            this.vgMoreChannels.setVisibility(8);
        }
        if (this.radioGroupChannels.getChannel() != null && (selectChannelListener = this.mSelectChannelListener) != null) {
            selectChannelListener.onSelectChannel(this.radioGroupChannels.getChannel().getPayAmount());
        }
        LbsPayRadioGroup lbsPayRadioGroup10 = this.radioGroupChannels;
        if (lbsPayRadioGroup10 != null) {
            lbsPayRadioGroup10.changeChannelDivide();
        }
    }

    public void setGetSelectedModeListener(PayChannelController.GetPayModeListener getPayModeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, getPayModeListener) == null) {
            this.mGetPayModeListener = getPayModeListener;
        }
    }

    public void setSelectChannelListener(PayChannelController.SelectChannelListener selectChannelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, selectChannelListener) == null) {
            this.mSelectChannelListener = selectChannelListener;
        }
    }

    public void setShowAllChannelClickListener(PayChannelController.DoShowAllChannelClick doShowAllChannelClick) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, doShowAllChannelClick) == null) {
            this.mShowAllChannelClick = doShowAllChannelClick;
        }
    }

    public void showCommonMarket() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view = this.mBannerView) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void updateBaiduDesc(NewCashierContent.IBaseChannel iBaseChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iBaseChannel) == null) {
            this.radioGroupChannels.updateBaiduPayDesc(iBaseChannel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.iBaseChannels = new ArrayList();
        this.iOfficialChannels = new ArrayList();
        this.mContext = context;
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(11)
    public ChannelListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.iBaseChannels = new ArrayList();
        this.iOfficialChannels = new ArrayList();
        this.mContext = context;
        initView();
    }
}
