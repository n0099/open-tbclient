package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView ato;
    private RadioButton atp;
    private Context mContext;

    public BlueCheckRadioButton(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public BlueCheckRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(f.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.ato = (TextView) findViewById(f.g.custom_check_radio_button_tv);
        this.atp = (RadioButton) findViewById(f.g.custom_check_radio_button_rb);
        Af();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.atp != null) {
                    BlueCheckRadioButton.this.atp.setButtonDrawable(f.C0146f.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.atp.toggle();
                }
            }
        });
    }

    public void Af() {
        if (this.ato != null) {
            am.a(this.ato, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.atp != null) {
            this.atp.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.ato != null) {
            this.ato.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.atp != null) {
            this.atp.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.atp.getTag();
    }

    public void setChecked(boolean z) {
        this.atp.setChecked(z);
    }
}
