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
    private ImageView aCf;
    private TextView aCg;
    private TextView aCh;
    private ImageView aCi;
    private a aCj;

    /* loaded from: classes2.dex */
    public interface a {
        void zT();
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
        this.aCf = (ImageView) findViewById(b.d.channel_icon_view);
        this.aCg = (TextView) findViewById(b.d.channel_name_view);
        this.aCh = (TextView) findViewById(b.d.channel_desc_view);
        this.aCi = (ImageView) findViewById(b.d.channel_select_view);
        setOnClickListener(this);
    }

    public void setChannelInfo(PayChannel payChannel, a aVar) {
        String displayName = payChannel.getDisplayName();
        String payText = payChannel.getPayText();
        String icon = payChannel.getIcon();
        boolean isSelected = payChannel.isSelected();
        boolean isEnable = payChannel.isEnable();
        com.baidu.poly.b.b.zH().b(this.aCf, icon);
        this.aCg.setText(displayName);
        if (isSelected) {
            this.aCi.setImageResource(b.c.channel_checked);
        } else {
            this.aCi.setImageResource(b.c.unchecked);
        }
        if (isEnable) {
            this.aCj = aVar;
        } else {
            this.aCf.setAlpha(0.4f);
            this.aCg.setAlpha(0.4f);
            this.aCh.setAlpha(0.4f);
            this.aCi.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payText)) {
            if ("度小满支付".equals(displayName)) {
                this.aCh.setTextColor(getResources().getColor(b.C0130b.duxiaomancolor));
            }
            this.aCh.setText(payText);
            return;
        }
        this.aCh.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aCg.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aCg.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCj != null) {
            this.aCj.zT();
        }
    }
}
