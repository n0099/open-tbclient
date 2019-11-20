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
    private ImageView aBN;
    private TextView aBO;
    private TextView aBP;
    private ImageView aBQ;
    private a aBR;

    /* loaded from: classes2.dex */
    public interface a {
        void zU();
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
        this.aBN = (ImageView) findViewById(b.d.channel_icon_view);
        this.aBO = (TextView) findViewById(b.d.channel_name_view);
        this.aBP = (TextView) findViewById(b.d.channel_desc_view);
        this.aBQ = (ImageView) findViewById(b.d.channel_select_view);
        setOnClickListener(this);
    }

    public void setChannelInfo(PayChannel payChannel, a aVar) {
        String displayName = payChannel.getDisplayName();
        String payText = payChannel.getPayText();
        String icon = payChannel.getIcon();
        boolean isSelected = payChannel.isSelected();
        boolean isEnable = payChannel.isEnable();
        com.baidu.poly.b.b.zI().b(this.aBN, icon);
        this.aBO.setText(displayName);
        if (isSelected) {
            this.aBQ.setImageResource(b.c.channel_checked);
        } else {
            this.aBQ.setImageResource(b.c.unchecked);
        }
        if (isEnable) {
            this.aBR = aVar;
        } else {
            this.aBN.setAlpha(0.4f);
            this.aBO.setAlpha(0.4f);
            this.aBP.setAlpha(0.4f);
            this.aBQ.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payText)) {
            if ("度小满支付".equals(displayName)) {
                this.aBP.setTextColor(getResources().getColor(b.C0130b.duxiaomancolor));
            }
            this.aBP.setText(payText);
            return;
        }
        this.aBP.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aBO.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aBO.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aBR != null) {
            this.aBR.zU();
        }
    }
}
