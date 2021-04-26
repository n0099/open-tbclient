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
public class ChannelOfficialView extends ChannelViewBase {
    public NetImageView activeIcon;
    public NetImageView imageView;
    public LinearLayout mCommonCardViewCOntainer;
    public ChannelDescLayout mCommonUsedCardDescContainer;
    public TextView mCommonUsedCardName;
    public ImageView radioButton;
    public TextView tvChannelCouponDesc;
    public ChannelDescLayout tvChannelDesc;
    public TextView tvChannelName;

    public ChannelOfficialView(Context context) {
        super(context);
        initView();
    }

    private void addCommonCardView(NewCashierContent.CommonUsedCard commonUsedCard) {
        setCommonUsedCardName(commonUsedCard.getCardName());
        setCommonUsedCardDesc(commonUsedCard.getCardMarketings());
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_customview_official_channel"), (ViewGroup) this, true);
        inflate.setPadding(0, DisplayUtils.dip2px(getContext(), 20.0f), 0, DisplayUtils.dip2px(getContext(), 10.0f));
        this.imageView = (NetImageView) inflate.findViewById(ResUtils.id(getContext(), "official_paysdk_id_imageview"));
        this.tvChannelName = (TextView) inflate.findViewById(ResUtils.id(getContext(), "official_paysdk_id_tv_name"));
        this.tvChannelDesc = (ChannelDescLayout) inflate.findViewById(ResUtils.id(getContext(), "official_layout_tv_desc"));
        ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(getContext(), "official_paysdk_id_cb"));
        this.radioButton = imageView;
        imageView.setClickable(false);
        if (Build.VERSION.SDK_INT >= 16) {
            this.radioButton.setBackground(ResUtils.getDrawable(getContext(), "wallet_juhe_bg_custom_checkbox"));
        } else {
            this.radioButton.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_juhe_bg_custom_checkbox"));
        }
        this.activeIcon = (NetImageView) inflate.findViewById(ResUtils.id(getContext(), "official_paysdk_id_tuijian_imageview"));
        this.tvChannelCouponDesc = (TextView) findViewById(ResUtils.id(getContext(), "official_paysdk_coupon_desc"));
        this.mCommonCardViewCOntainer = (LinearLayout) inflate.findViewById(ResUtils.id(getContext(), "common_card_view_container"));
        this.mCommonUsedCardName = (TextView) inflate.findViewById(ResUtils.id(getContext(), "common_used_card_name"));
        this.mCommonUsedCardDescContainer = (ChannelDescLayout) inflate.findViewById(ResUtils.id(getContext(), "common_used_card_desc_container"));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_juhe_bg_list_item"));
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setChannel(NewCashierContent.IBaseChannel iBaseChannel) {
        if (iBaseChannel == null) {
            return;
        }
        if (!TextUtils.isEmpty(iBaseChannel.getIcon())) {
            this.imageView.releaseRemoteDrawable();
            this.imageView.setImageUrl(iBaseChannel.getIcon());
        }
        if (!TextUtils.isEmpty(iBaseChannel.getName())) {
            this.tvChannelName.setText(iBaseChannel.getName());
        }
        if (!TextUtils.isEmpty(iBaseChannel.getDesc())) {
            this.tvChannelDesc.setVisibility(0);
            this.tvChannelDesc.addDescView(iBaseChannel.getDesc());
        } else {
            this.tvChannelDesc.setVisibility(8);
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
        } else {
            this.tvChannelCouponDesc.setVisibility(8);
        }
        if (iBaseChannel.getCommonUsedCard() != null) {
            this.mCommonCardViewCOntainer.setVisibility(0);
            addCommonCardView(iBaseChannel.getCommonUsedCard());
            return;
        }
        this.mCommonCardViewCOntainer.setVisibility(8);
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setChecked(boolean z) {
        if (isEnabled()) {
            this.radioButton.setSelected(z);
        }
    }

    public void setCommonUsedCardDesc(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.mCommonUsedCardDescContainer.setVisibility(0);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    this.mCommonUsedCardDescContainer.addDescView(str);
                }
            }
            return;
        }
        this.mCommonUsedCardDescContainer.setVisibility(8);
    }

    public void setCommonUsedCardName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mCommonUsedCardName.setVisibility(0);
            this.mCommonUsedCardName.setText(str);
            return;
        }
        this.mCommonUsedCardName.setVisibility(8);
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setEnabled(boolean z, NewCashierContent.IBaseChannel iBaseChannel) {
        int color = ResUtils.getColor(getContext(), "lbspay_color_111111");
        int color2 = ResUtils.getColor(getContext(), "lbspay_color_aaaaaa");
        int color3 = ResUtils.getColor(getContext(), "lbspay_color_e94643");
        int color4 = ResUtils.getColor(getContext(), "lbspay_text_caption_color");
        if (!z) {
            this.imageView.setAlpha(100);
            this.tvChannelName.setTextColor(Color.argb(100, Color.red(color), Color.green(color), Color.blue(color)));
            if (!iBaseChannel.getIsRed() && iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                this.tvChannelDesc.setTextColor(Color.argb(100, Color.red(color2), Color.green(color2), Color.blue(color2)));
            } else {
                this.tvChannelDesc.setTextColor(Color.argb(100, Color.red(color3), Color.green(color3), Color.blue(color3)));
            }
            if (iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                this.tvChannelCouponDesc.setTextColor(Color.argb(100, Color.red(color4), Color.green(color4), Color.blue(color4)));
            } else {
                this.tvChannelCouponDesc.setTextColor(Color.argb(100, Color.red(color3), Color.green(color3), Color.blue(color3)));
            }
            this.radioButton.setVisibility(4);
        } else {
            this.imageView.setAlpha(255);
            this.tvChannelName.setTextColor(Color.argb(255, Color.red(color), Color.green(color), Color.blue(color)));
            if (!iBaseChannel.getIsRed() && iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                this.tvChannelDesc.setTextColor(Color.argb(255, Color.red(color2), Color.green(color2), Color.blue(color2)));
            } else {
                this.tvChannelDesc.setTextColor(Color.argb(255, Color.red(color3), Color.green(color3), Color.blue(color3)));
            }
            if (iBaseChannel.getChanelId() != 126 && iBaseChannel.getChanelId() != -2) {
                this.tvChannelCouponDesc.setTextColor(Color.argb(255, Color.red(color4), Color.green(color4), Color.blue(color4)));
            } else {
                this.tvChannelCouponDesc.setTextColor(Color.argb(255, Color.red(color3), Color.green(color3), Color.blue(color3)));
            }
            this.radioButton.setVisibility(0);
        }
        super.setEnabled(z);
    }

    public ChannelOfficialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    @TargetApi(11)
    public ChannelOfficialView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView();
    }
}
