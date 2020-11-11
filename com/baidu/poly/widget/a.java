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
/* loaded from: classes6.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView ceT;
    private TextView ceU;
    private TextView ceV;
    private ImageView ceW;
    private InterfaceC0314a ceX;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0314a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.ceT = (ImageView) findViewById(b.e.channel_icon_view);
        this.ceU = (TextView) findViewById(b.e.channel_name_view);
        this.ceV = (TextView) findViewById(b.e.channel_desc_view);
        this.ceW = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0314a interfaceC0314a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.aaY().b(this.ceT, icon);
        this.ceU.setText(displayName);
        if (P == 1) {
            this.ceW.setImageResource(b.d.channel_checked);
        } else {
            this.ceW.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.ceX = interfaceC0314a;
        } else {
            this.ceT.setAlpha(0.4f);
            this.ceU.setAlpha(0.4f);
            this.ceV.setAlpha(0.4f);
            this.ceW.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.ceV.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.ceV.setText(S);
            return;
        }
        this.ceV.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ceU.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.ceU.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0314a interfaceC0314a = this.ceX;
        if (interfaceC0314a != null) {
            interfaceC0314a.a();
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
