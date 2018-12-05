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
    private ImageView aiC;
    private TextView aiD;
    private TextView aiE;
    private ImageView aiF;
    private a aiG;

    /* loaded from: classes2.dex */
    public interface a {
        void uF();
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
        LayoutInflater.from(context).inflate(b.d.view_channel_list_item, (ViewGroup) this, true);
        this.aiC = (ImageView) findViewById(b.c.channel_icon_view);
        this.aiD = (TextView) findViewById(b.c.channel_name_view);
        this.aiE = (TextView) findViewById(b.c.channel_desc_view);
        this.aiF = (ImageView) findViewById(b.c.channel_select_view);
        setOnClickListener(this);
    }

    public void setChannelInfo(PayChannel payChannel, a aVar) {
        String displayName = payChannel.getDisplayName();
        String payText = payChannel.getPayText();
        String icon = payChannel.getIcon();
        boolean isSelected = payChannel.isSelected();
        boolean isEnable = payChannel.isEnable();
        com.baidu.poly.b.b.ut().b(this.aiC, icon);
        this.aiD.setText(displayName);
        if (isSelected) {
            this.aiF.setImageResource(b.C0114b.channel_checked);
        }
        if (isEnable) {
            this.aiG = aVar;
        } else {
            this.aiC.setAlpha(0.4f);
            this.aiD.setAlpha(0.4f);
            this.aiE.setAlpha(0.4f);
            this.aiF.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payText)) {
            this.aiE.setText(payText);
        } else {
            this.aiE.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiG != null) {
            this.aiG.uF();
        }
    }
}
