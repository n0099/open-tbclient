package com.baidu.android.lbspay.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes2.dex */
public class ChannelFootView extends RelativeLayout {
    public View layoutView;
    public TextView logoDesc;

    public ChannelFootView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        int layout = ResUtils.layout(getContext(), "wallet_juhe_channel_foot");
        if (this.layoutView == null) {
            this.layoutView = LayoutInflater.from(getContext()).inflate(layout, (ViewGroup) this, true);
        }
        TextView textView = (TextView) this.layoutView.findViewById(ResUtils.id(getContext(), "lbspay_powerby_tx"));
        this.logoDesc = textView;
        textView.setText(ResUtils.getString(getContext(), "lbspay_pay_brand_desc"));
    }

    public void initBrandData(NewCashierContent.Brand brand) {
        if (brand == null || TextUtils.isEmpty(brand.desc)) {
            return;
        }
        this.logoDesc.setVisibility(0);
        this.logoDesc.setText(brand.desc);
    }

    public ChannelFootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
