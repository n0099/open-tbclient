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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView awC;
    private RadioButton awD;
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
        LayoutInflater.from(this.mContext).inflate(e.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.awC = (TextView) findViewById(e.g.custom_check_radio_button_tv);
        this.awD = (RadioButton) findViewById(e.g.custom_check_radio_button_rb);
        Br();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.awD != null) {
                    BlueCheckRadioButton.this.awD.setButtonDrawable(e.f.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.awD.toggle();
                }
            }
        });
    }

    public void Br() {
        if (this.awC != null) {
            al.d(this.awC, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.awD != null) {
            this.awD.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.awC != null) {
            this.awC.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.awD != null) {
            this.awD.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.awD.getTag();
    }

    public void setChecked(boolean z) {
        this.awD.setChecked(z);
    }
}
