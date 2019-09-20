package com.baidu.poly.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.poly.b;
import com.baidu.poly.bean.PayChannel;
/* loaded from: classes2.dex */
public class ChannelItemView extends RelativeLayout implements View.OnClickListener {
    private ImageView aiI;
    private TextView aiJ;
    private TextView aiK;
    private ImageView aiL;
    private a aiM;

    /* loaded from: classes2.dex */
    public interface a {
        void uZ();
    }

    public ChannelItemView(Context context) {
        this(context, null);
    }

    public ChannelItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChannelItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(b.e.view_channel_list_item, (ViewGroup) this, true);
        this.aiI = (ImageView) findViewById(b.d.channel_icon_view);
        this.aiJ = (TextView) findViewById(b.d.channel_name_view);
        this.aiK = (TextView) findViewById(b.d.channel_desc_view);
        this.aiL = (ImageView) findViewById(b.d.channel_select_view);
        setOnClickListener(this);
    }

    public void setChannelInfo(PayChannel payChannel, a aVar) {
        String displayName = payChannel.getDisplayName();
        String payText = payChannel.getPayText();
        String icon = payChannel.getIcon();
        boolean isSelected = payChannel.isSelected();
        boolean isEnable = payChannel.isEnable();
        com.baidu.poly.b.b.uN().b(this.aiI, icon);
        this.aiJ.setText(displayName);
        if (isSelected) {
            this.aiL.setImageResource(b.c.channel_checked);
        } else {
            this.aiL.setImageResource(b.c.unchecked);
        }
        if (isEnable) {
            this.aiM = aVar;
        } else {
            this.aiI.setAlpha(0.4f);
            this.aiJ.setAlpha(0.4f);
            this.aiK.setAlpha(0.4f);
            this.aiL.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payText)) {
            if ("度小满支付".equals(displayName)) {
                this.aiK.setTextColor(getResources().getColor(b.C0098b.duxiaomancolor));
            }
            this.aiK.setText(payText);
            return;
        }
        this.aiK.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiJ.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aiJ.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiM != null) {
            this.aiM.uZ();
        }
    }
}
