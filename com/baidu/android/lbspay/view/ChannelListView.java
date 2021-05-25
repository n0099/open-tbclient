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
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.android.lbspay.view.LbsPayRadioGroup;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ChannelListView extends LinearLayout {
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

    public ChannelListView(Context context) {
        super(context);
        this.iBaseChannels = new ArrayList();
        this.iOfficialChannels = new ArrayList();
        this.mContext = context;
        initView();
    }

    private View getNormalGroupView(String str, Context context) {
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

    private View getOtherGroupView(String str, boolean z) {
        View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_channel_showall"), (ViewGroup) null);
        final ViewGroup viewGroup = (ViewGroup) inflate.findViewById(ResUtils.id(getContext(), "show_all"));
        ((TextView) inflate.findViewById(ResUtils.id(getContext(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC))).setText(str);
        if (z) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.lbspay.view.ChannelListView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                viewGroup.setVisibility(4);
                if (ChannelListView.this.radioGroupChannels != null) {
                    ChannelListView.this.radioGroupChannels.showAllChannels();
                }
                PayChannelController.DoShowAllChannelClick doShowAllChannelClick = ChannelListView.this.mShowAllChannelClick;
                if (doShowAllChannelClick != null) {
                    doShowAllChannelClick.doClick();
                }
            }
        });
        return inflate;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_customview_channel_list"), this);
        this.vgMoreChannels = (ViewGroup) findViewById(ResUtils.id(getContext(), "pasdk_id_vg_more_channels"));
        LbsPayRadioGroup lbsPayRadioGroup = (LbsPayRadioGroup) findViewById(ResUtils.id(getContext(), "paysdk_id_radiogroup"));
        this.radioGroupChannels = lbsPayRadioGroup;
        lbsPayRadioGroup.setOnCheckedListener(new LbsPayRadioGroup.OnCheckedListener() { // from class: com.baidu.android.lbspay.view.ChannelListView.1
            @Override // com.baidu.android.lbspay.view.LbsPayRadioGroup.OnCheckedListener
            public void onChecked(ChannelViewBase channelViewBase) {
                ChannelListView channelListView;
                PayChannelController.SelectChannelListener selectChannelListener;
                if (ChannelListView.this.radioGroupChannels.getChannel() == null || (selectChannelListener = (channelListView = ChannelListView.this).mSelectChannelListener) == null) {
                    return;
                }
                selectChannelListener.onSelectChannel(channelListView.radioGroupChannels.getChannel().getPayAmount());
            }
        });
        setOrientation(1);
    }

    public NewCashierContent.IBaseChannel getChannel() {
        LbsPayRadioGroup lbsPayRadioGroup = this.radioGroupChannels;
        if (lbsPayRadioGroup != null) {
            return lbsPayRadioGroup.getChannel();
        }
        return null;
    }

    public List<NewCashierContent.CashierChannel> getOfficialChannels() {
        return this.iOfficialChannels;
    }

    public void hideCommonMarket() {
        View view = this.mBannerView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void reSetView() {
        LbsPayRadioGroup lbsPayRadioGroup = this.radioGroupChannels;
        if (lbsPayRadioGroup != null) {
            lbsPayRadioGroup.removeAllViews();
            this.radioGroupChannels.setOncheckedView(null);
        }
        this.iBaseChannels.clear();
        this.vgMoreChannels.setVisibility(8);
        this.vgMoreChannels.setOnClickListener(null);
    }

    public boolean selectChannelById(int i2) {
        NewCashierContent.CashierChannel cashierChannel;
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

    public void setAdapter(NewCashierContent newCashierContent) {
        NewCashierContent.CashierPay cashierPay;
        boolean z;
        PayChannelController.SelectChannelListener selectChannelListener;
        NewCashierContent.CommonMarketing[] commonMarketingArr;
        if (newCashierContent == null || (cashierPay = newCashierContent.pay) == null) {
            return;
        }
        NewCashierContent.CashierChannels cashierChannels = cashierPay.channels;
        NewCashierContent.CashierChannel[] cashierChannelArr = cashierChannels != null ? cashierChannels.official_platform : null;
        NewCashierContent.CashierChannels cashierChannels2 = cashierPay.channels;
        NewCashierContent.CashierChannel[] cashierChannelArr2 = cashierChannels2 != null ? cashierChannels2.platform : null;
        if (this.iBaseChannels == null) {
            this.iBaseChannels = new ArrayList();
        }
        Comparator<NewCashierContent.IBaseChannel> comparator = new Comparator<NewCashierContent.IBaseChannel>() { // from class: com.baidu.android.lbspay.view.ChannelListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(NewCashierContent.IBaseChannel iBaseChannel, NewCashierContent.IBaseChannel iBaseChannel2) {
                return iBaseChannel.getPriority() - iBaseChannel2.getPriority();
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
            final NewCashierContent.CommonMarketing commonMarketing = commonMarketingArr[0];
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
                this.mBannerView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.lbspay.view.ChannelListView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (CheckUtils.isFastDoubleClick() || TextUtils.isEmpty(commonMarketing.url)) {
                            return;
                        }
                        StatisticManager.onEventWithValue(LbsStatistics.WALLET_LBS_BANNER_CLICK, commonMarketing.url);
                        BaiduWalletDelegate.getInstance().openH5Module(ChannelListView.this.getContext(), commonMarketing.url, false);
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
            this.vgMoreChannels.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.lbspay.view.ChannelListView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayChannelController.DoShowAllChannelClick doShowAllChannelClick = ChannelListView.this.mShowAllChannelClick;
                    if (doShowAllChannelClick != null) {
                        doShowAllChannelClick.doClick();
                    }
                    if (ChannelListView.this.radioGroupChannels != null) {
                        ChannelListView.this.radioGroupChannels.showAllChannels();
                    }
                    ChannelListView.this.vgMoreChannels.setVisibility(8);
                    ChannelListView.this.vgMoreChannels.setOnClickListener(null);
                    StatisticManager.onEvent(LbsStatistics.LBS_MORE_CHANNELS);
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
        this.mGetPayModeListener = getPayModeListener;
    }

    public void setSelectChannelListener(PayChannelController.SelectChannelListener selectChannelListener) {
        this.mSelectChannelListener = selectChannelListener;
    }

    public void setShowAllChannelClickListener(PayChannelController.DoShowAllChannelClick doShowAllChannelClick) {
        this.mShowAllChannelClick = doShowAllChannelClick;
    }

    public void showCommonMarket() {
        View view = this.mBannerView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void updateBaiduDesc(NewCashierContent.IBaseChannel iBaseChannel) {
        this.radioGroupChannels.updateBaiduPayDesc(iBaseChannel);
    }

    public ChannelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iBaseChannels = new ArrayList();
        this.iOfficialChannels = new ArrayList();
        this.mContext = context;
        initView();
    }

    @TargetApi(11)
    public ChannelListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.iBaseChannels = new ArrayList();
        this.iOfficialChannels = new ArrayList();
        this.mContext = context;
        initView();
    }
}
