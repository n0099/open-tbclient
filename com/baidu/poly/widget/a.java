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
/* loaded from: classes11.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView bCd;
    private TextView bCe;
    private TextView bCf;
    private ImageView bCg;
    private InterfaceC0251a bCh;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0251a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bCd = (ImageView) findViewById(b.e.channel_icon_view);
        this.bCe = (TextView) findViewById(b.e.channel_name_view);
        this.bCf = (TextView) findViewById(b.e.channel_desc_view);
        this.bCg = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0251a interfaceC0251a) {
        String displayName = oVar.getDisplayName();
        String J = oVar.J();
        String icon = oVar.getIcon();
        int G = oVar.G();
        int E = oVar.E();
        com.baidu.poly.a.c.b.NY().b(this.bCd, icon);
        this.bCe.setText(displayName);
        if (G == 1) {
            this.bCg.setImageResource(b.d.channel_checked);
        } else {
            this.bCg.setImageResource(b.d.unchecked);
        }
        if (1 == E) {
            this.bCh = interfaceC0251a;
        } else {
            this.bCd.setAlpha(0.4f);
            this.bCe.setAlpha(0.4f);
            this.bCf.setAlpha(0.4f);
            this.bCg.setVisibility(8);
        }
        if (!TextUtils.isEmpty(J)) {
            String D = oVar.D();
            if (!TextUtils.isEmpty(D)) {
                try {
                    this.bCf.setTextColor(Color.parseColor(D));
                } catch (Exception e) {
                }
            }
            this.bCf.setText(J);
            return;
        }
        this.bCf.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCe.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bCe.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0251a interfaceC0251a = this.bCh;
        if (interfaceC0251a != null) {
            interfaceC0251a.a();
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
