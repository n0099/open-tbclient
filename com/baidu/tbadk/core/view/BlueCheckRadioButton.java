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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView fhj;
    private RadioButton fhk;
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
        this.fhj = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.fhk = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        bxn();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.fhk != null) {
                    BlueCheckRadioButton.this.fhk.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.fhk.toggle();
                }
            }
        });
    }

    public void bxn() {
        if (this.fhj != null) {
            ao.setViewTextColor(this.fhj, "CAM_X0302");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.fhk != null) {
            this.fhk.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.fhj != null) {
            this.fhj.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.fhk != null) {
            this.fhk.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.fhk.getTag();
    }

    public void setChecked(boolean z) {
        this.fhk.setChecked(z);
    }
}
