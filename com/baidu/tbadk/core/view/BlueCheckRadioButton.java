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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView bWg;
    private RadioButton bWh;
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
        LayoutInflater.from(this.mContext).inflate(R.layout.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.bWg = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.bWh = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        ajd();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.bWh != null) {
                    BlueCheckRadioButton.this.bWh.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.bWh.toggle();
                }
            }
        });
    }

    public void ajd() {
        if (this.bWg != null) {
            al.e(this.bWg, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.bWh != null) {
            this.bWh.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.bWg != null) {
            this.bWg.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.bWh != null) {
            this.bWh.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.bWh.getTag();
    }

    public void setChecked(boolean z) {
        this.bWh.setChecked(z);
    }
}
