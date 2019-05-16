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
    private ImageView ahK;
    private TextView ahL;
    private TextView ahM;
    private ImageView ahN;
    private a ahO;

    /* loaded from: classes2.dex */
    public interface a {
        void uv();
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
        this.ahK = (ImageView) findViewById(b.d.channel_icon_view);
        this.ahL = (TextView) findViewById(b.d.channel_name_view);
        this.ahM = (TextView) findViewById(b.d.channel_desc_view);
        this.ahN = (ImageView) findViewById(b.d.channel_select_view);
        setOnClickListener(this);
    }

    public void setChannelInfo(PayChannel payChannel, a aVar) {
        String displayName = payChannel.getDisplayName();
        String payText = payChannel.getPayText();
        String icon = payChannel.getIcon();
        boolean isSelected = payChannel.isSelected();
        boolean isEnable = payChannel.isEnable();
        com.baidu.poly.b.b.uj().b(this.ahK, icon);
        this.ahL.setText(displayName);
        if (isSelected) {
            this.ahN.setImageResource(b.c.channel_checked);
        } else {
            this.ahN.setImageResource(b.c.unchecked);
        }
        if (isEnable) {
            this.ahO = aVar;
        } else {
            this.ahK.setAlpha(0.4f);
            this.ahL.setAlpha(0.4f);
            this.ahM.setAlpha(0.4f);
            this.ahN.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payText)) {
            if ("度小满支付".equals(displayName)) {
                this.ahM.setTextColor(getResources().getColor(b.C0084b.duxiaomancolor));
            }
            this.ahM.setText(payText);
            return;
        }
        this.ahM.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahL.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.ahL.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahO != null) {
            this.ahO.uv();
        }
    }
}
