package com.baidu.poly.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.poly.b;
/* loaded from: classes9.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView bCv;
    private TextView bCw;
    private TextView bCx;
    private ImageView bCy;
    private InterfaceC0254a bCz;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0254a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bCv = (ImageView) findViewById(b.e.channel_icon_view);
        this.bCw = (TextView) findViewById(b.e.channel_name_view);
        this.bCx = (TextView) findViewById(b.e.channel_desc_view);
        this.bCy = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0254a interfaceC0254a) {
        String displayName = oVar.getDisplayName();
        String R = oVar.R();
        String icon = oVar.getIcon();
        int O = oVar.O();
        int M = oVar.M();
        com.baidu.poly.a.d.b.Og().b(this.bCv, icon);
        this.bCw.setText(displayName);
        if (O == 1) {
            this.bCy.setImageResource(b.d.channel_checked);
        } else {
            this.bCy.setImageResource(b.d.unchecked);
        }
        if (1 == M) {
            this.bCz = interfaceC0254a;
        } else {
            this.bCv.setAlpha(0.4f);
            this.bCw.setAlpha(0.4f);
            this.bCx.setAlpha(0.4f);
            this.bCy.setVisibility(8);
        }
        if (!TextUtils.isEmpty(R)) {
            String L = oVar.L();
            if (!TextUtils.isEmpty(L)) {
                try {
                    this.bCx.setTextColor(Color.parseColor(L));
                } catch (Exception e) {
                }
            }
            this.bCx.setText(R);
            return;
        }
        this.bCx.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCw.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bCw.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0254a interfaceC0254a = this.bCz;
        if (interfaceC0254a != null) {
            interfaceC0254a.a();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
