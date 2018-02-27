package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView aZt;
    private RadioButton aZu;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.aZt = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.aZu = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        DP();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZu != null) {
                    a.this.aZu.setButtonDrawable(d.f.chx_tips_list_ok_selector);
                    a.this.aZu.toggle();
                }
            }
        });
    }

    public void DP() {
        if (this.aZt != null) {
            aj.a(this.aZt, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.aZu != null) {
            this.aZu.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.aZt != null) {
            this.aZt.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.aZu != null) {
            this.aZu.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.aZu.getTag();
    }

    public void setChecked(boolean z) {
        this.aZu.setChecked(z);
    }
}
