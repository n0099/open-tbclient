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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView bOo;
    private RadioButton bOp;
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
        LayoutInflater.from(this.mContext).inflate(d.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.bOo = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.bOp = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        aeh();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.bOp != null) {
                    BlueCheckRadioButton.this.bOp.setButtonDrawable(d.f.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.bOp.toggle();
                }
            }
        });
    }

    public void aeh() {
        if (this.bOo != null) {
            al.e(this.bOo, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.bOp != null) {
            this.bOp.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.bOo != null) {
            this.bOo.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.bOp != null) {
            this.bOp.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.bOp.getTag();
    }

    public void setChecked(boolean z) {
        this.bOp.setChecked(z);
    }
}
