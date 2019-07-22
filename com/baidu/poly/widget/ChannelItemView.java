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
    private ImageView ail;
    private TextView aim;
    private TextView ain;
    private ImageView aio;
    private a aip;

    /* loaded from: classes2.dex */
    public interface a {
        void uV();
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
        this.ail = (ImageView) findViewById(b.d.channel_icon_view);
        this.aim = (TextView) findViewById(b.d.channel_name_view);
        this.ain = (TextView) findViewById(b.d.channel_desc_view);
        this.aio = (ImageView) findViewById(b.d.channel_select_view);
        setOnClickListener(this);
    }

    public void setChannelInfo(PayChannel payChannel, a aVar) {
        String displayName = payChannel.getDisplayName();
        String payText = payChannel.getPayText();
        String icon = payChannel.getIcon();
        boolean isSelected = payChannel.isSelected();
        boolean isEnable = payChannel.isEnable();
        com.baidu.poly.b.b.uJ().b(this.ail, icon);
        this.aim.setText(displayName);
        if (isSelected) {
            this.aio.setImageResource(b.c.channel_checked);
        } else {
            this.aio.setImageResource(b.c.unchecked);
        }
        if (isEnable) {
            this.aip = aVar;
        } else {
            this.ail.setAlpha(0.4f);
            this.aim.setAlpha(0.4f);
            this.ain.setAlpha(0.4f);
            this.aio.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payText)) {
            if ("度小满支付".equals(displayName)) {
                this.ain.setTextColor(getResources().getColor(b.C0084b.duxiaomancolor));
            }
            this.ain.setText(payText);
            return;
        }
        this.ain.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aim.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aim.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aip != null) {
            this.aip.uV();
        }
    }
}
