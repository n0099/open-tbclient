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
    private ImageView ahn;
    private TextView aho;
    private TextView ahp;
    private ImageView ahq;
    private a ahr;

    /* loaded from: classes2.dex */
    public interface a {
        void tL();
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
        this.ahn = (ImageView) findViewById(b.c.channel_icon_view);
        this.aho = (TextView) findViewById(b.c.channel_name_view);
        this.ahp = (TextView) findViewById(b.c.channel_desc_view);
        this.ahq = (ImageView) findViewById(b.c.channel_select_view);
        setOnClickListener(this);
    }

    public void setChannelInfo(PayChannel payChannel, a aVar) {
        String displayName = payChannel.getDisplayName();
        String payText = payChannel.getPayText();
        String icon = payChannel.getIcon();
        boolean isSelected = payChannel.isSelected();
        boolean isEnable = payChannel.isEnable();
        com.baidu.poly.b.b.tz().b(this.ahn, icon);
        this.aho.setText(displayName);
        if (isSelected) {
            this.ahq.setImageResource(b.C0082b.channel_checked);
        }
        if (isEnable) {
            this.ahr = aVar;
        } else {
            this.ahn.setAlpha(0.4f);
            this.aho.setAlpha(0.4f);
            this.ahp.setAlpha(0.4f);
            this.ahq.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payText)) {
            this.ahp.setText(payText);
        } else {
            this.ahp.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahr != null) {
            this.ahr.tL();
        }
    }
}
