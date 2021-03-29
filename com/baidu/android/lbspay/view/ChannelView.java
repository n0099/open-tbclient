package com.baidu.android.lbspay.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes.dex */
public class ChannelView extends ChannelViewBase {
    public NetImageView activeIcon;
    public LinearLayout channelDescContainer;
    public View devider;
    public NetImageView imageView;
    public ImageView radioButton;
    public ChannelDescLayout redChannelDesc;
    public TextView tvChannelCouponDesc;
    public TextView tvChannelDesc;
    public TextView tvChannelName;

    public ChannelView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_customview_channel"), (ViewGroup) this, true);
        inflate.setPadding(0, DisplayUtils.dip2px(getContext(), 20.0f), 0, 0);
        this.imageView = (NetImageView) inflate.findViewById(ResUtils.id(getContext(), "paysdk_id_imageview"));
        this.channelDescContainer = (LinearLayout) inflate.findViewById(ResUtils.id(getContext(), "paysdk_channelview_main_layout"));
        this.tvChannelName = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paysdk_id_tv_name"));
        this.tvChannelDesc = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paysdk_id_tv_desc"));
        this.redChannelDesc = (ChannelDescLayout) inflate.findViewById(ResUtils.id(getContext(), "red_desc_container"));
        ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(getContext(), "paysdk_id_cb"));
        this.radioButton = imageView;
        imageView.setClickable(false);
        if (Build.VERSION.SDK_INT >= 16) {
            this.radioButton.setBackground(ResUtils.getDrawable(getContext(), "wallet_juhe_bg_custom_checkbox"));
        } else {
            this.radioButton.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_juhe_bg_custom_checkbox"));
        }
        this.activeIcon = (NetImageView) inflate.findViewById(ResUtils.id(getContext(), "paysdk_id_tuijian_imageview"));
        this.devider = inflate.findViewById(ResUtils.id(getContext(), "paysdk_id_devider"));
        this.tvChannelCouponDesc = (TextView) findViewById(ResUtils.id(getContext(), "paysdk_coupon_desc"));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ResUtils.getDimension(getContext(), "lbspay_cashier_item_height")));
        setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_juhe_bg_list_item"));
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setChannel(NewCashierContent.IBaseChannel iBaseChannel) {
        if (iBaseChannel == null) {
            return;
        }
        if (!TextUtils.isEmpty(iBaseChannel.getIcon())) {
            this.imageView.setImageUrl(iBaseChannel.getIcon());
        }
        if (!TextUtils.isEmpty(iBaseChannel.getName())) {
            this.tvChannelName.setText(iBaseChannel.getName());
        }
        if (!TextUtils.isEmpty(iBaseChannel.getActiveIcon())) {
            LogUtil.errord("channel getActiveIcon=" + iBaseChannel.getActiveIcon());
            this.activeIcon.setImageUrl(iBaseChannel.getActiveIcon());
        } else {
            this.activeIcon.setVisibility(8);
        }
        if (!TextUtils.isEmpty(iBaseChannel.getMarketingDesc())) {
            this.tvChannelCouponDesc.setVisibility(0);
            this.tvChannelCouponDesc.setText(iBaseChannel.getMarketingDesc());
            return;
        }
        this.tvChannelCouponDesc.setVisibility(8);
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setChecked(boolean z) {
        if (isEnabled()) {
            this.radioButton.setSelected(z);
        }
    }

    public void setDividerMargin(int i) {
        View view = this.devider;
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.devider.requestLayout();
        }
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setEnabled(boolean z, NewCashierContent.IBaseChannel iBaseChannel) {
        int color = ResUtils.getColor(getContext(), "lbspay_color_666666");
        int color2 = ResUtils.getColor(getContext(), "lbspay_color_aaaaaa");
        int color3 = ResUtils.getColor(getContext(), "lbspay_color_e94643");
        if (!z) {
            this.imageView.setAlpha(128);
            this.tvChannelName.setTextColor(Color.argb(128, Color.red(color), Color.green(color), Color.blue(color)));
            if (!TextUtils.isEmpty(iBaseChannel.getDesc())) {
                if (!iBaseChannel.getIsRed() && iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                    this.redChannelDesc.setVisibility(8);
                    this.tvChannelDesc.setVisibility(0);
                    this.tvChannelDesc.setText(iBaseChannel.getDesc());
                    this.tvChannelDesc.setTextColor(Color.argb(128, Color.red(color2), Color.green(color2), Color.blue(color2)));
                } else {
                    this.redChannelDesc.setVisibility(0);
                    this.tvChannelDesc.setVisibility(8);
                    this.redChannelDesc.addDescView(iBaseChannel.getDesc());
                    this.tvChannelDesc.setTextColor(Color.argb(128, Color.red(color3), Color.green(color3), Color.blue(color3)));
                }
            } else {
                this.redChannelDesc.setVisibility(8);
                this.tvChannelDesc.setVisibility(8);
                ((RelativeLayout.LayoutParams) this.channelDescContainer.getLayoutParams()).addRule(15);
                ((RelativeLayout.LayoutParams) this.imageView.getLayoutParams()).addRule(15);
            }
            if (iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                this.tvChannelCouponDesc.setTextColor(Color.argb(128, Color.red(color2), Color.green(color2), Color.blue(color2)));
            } else {
                this.tvChannelCouponDesc.setTextColor(Color.argb(128, Color.red(color3), Color.green(color3), Color.blue(color3)));
            }
            this.radioButton.setVisibility(4);
        } else {
            this.imageView.setAlpha(255);
            this.tvChannelName.setTextColor(Color.argb(255, Color.red(color), Color.green(color), Color.blue(color)));
            if (!TextUtils.isEmpty(iBaseChannel.getDesc())) {
                if (!iBaseChannel.getIsRed() && iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                    this.redChannelDesc.setVisibility(8);
                    this.tvChannelDesc.setVisibility(0);
                    this.tvChannelDesc.setText(iBaseChannel.getDesc());
                    this.tvChannelDesc.setTextColor(Color.argb(128, Color.red(color2), Color.green(color2), Color.blue(color2)));
                } else {
                    this.redChannelDesc.setVisibility(0);
                    this.tvChannelDesc.setVisibility(8);
                    this.redChannelDesc.addDescView(iBaseChannel.getDesc());
                    this.tvChannelDesc.setTextColor(Color.argb(128, Color.red(color3), Color.green(color3), Color.blue(color3)));
                }
            } else {
                this.redChannelDesc.setVisibility(8);
                this.tvChannelDesc.setVisibility(8);
                ((RelativeLayout.LayoutParams) this.channelDescContainer.getLayoutParams()).addRule(15);
                ((RelativeLayout.LayoutParams) this.imageView.getLayoutParams()).addRule(15);
            }
            if (iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                this.tvChannelCouponDesc.setTextColor(Color.argb(255, Color.red(color2), Color.green(color2), Color.blue(color2)));
            } else {
                this.tvChannelCouponDesc.setTextColor(Color.argb(255, Color.red(color3), Color.green(color3), Color.blue(color3)));
            }
            this.radioButton.setVisibility(0);
        }
        super.setEnabled(z);
    }

    public ChannelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    @TargetApi(11)
    public ChannelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
