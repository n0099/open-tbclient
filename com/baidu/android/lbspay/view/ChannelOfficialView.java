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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
/* loaded from: classes6.dex */
public class ChannelOfficialView extends ChannelViewBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetImageView activeIcon;
    public NetImageView imageView;
    public LinearLayout mCommonCardViewCOntainer;
    public ChannelDescLayout mCommonUsedCardDescContainer;
    public TextView mCommonUsedCardName;
    public ImageView radioButton;
    public TextView tvChannelCouponDesc;
    public ChannelDescLayout tvChannelDesc;
    public TextView tvChannelName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelOfficialView(Context context) {
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
        initView();
    }

    private void addCommonCardView(NewCashierContent.CommonUsedCard commonUsedCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, commonUsedCard) == null) {
            setCommonUsedCardName(commonUsedCard.getCardName());
            setCommonUsedCardDesc(commonUsedCard.getCardMarketings());
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
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
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setChannel(NewCashierContent.IBaseChannel iBaseChannel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iBaseChannel) == null) || iBaseChannel == null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && isEnabled()) {
            this.radioButton.setSelected(z);
        }
    }

    public void setCommonUsedCardDesc(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
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
    }

    public void setCommonUsedCardName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mCommonUsedCardName.setVisibility(0);
                this.mCommonUsedCardName.setText(str);
                return;
            }
            this.mCommonUsedCardName.setVisibility(8);
        }
    }

    @Override // com.baidu.android.lbspay.view.ChannelViewBase
    public void setEnabled(boolean z, NewCashierContent.IBaseChannel iBaseChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, iBaseChannel) == null) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelOfficialView(Context context, AttributeSet attributeSet) {
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
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(11)
    public ChannelOfficialView(Context context, AttributeSet attributeSet, int i2) {
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
        initView();
    }
}
