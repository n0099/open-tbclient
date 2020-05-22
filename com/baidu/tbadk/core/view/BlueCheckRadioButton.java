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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView dSi;
    private RadioButton dSj;
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
        this.dSi = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.dSj = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        aVS();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.dSj != null) {
                    BlueCheckRadioButton.this.dSj.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.dSj.toggle();
                }
            }
        });
    }

    public void aVS() {
        if (this.dSi != null) {
            am.setViewTextColor(this.dSi, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.dSj != null) {
            this.dSj.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.dSi != null) {
            this.dSi.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.dSj != null) {
            this.dSj.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.dSj.getTag();
    }

    public void setChecked(boolean z) {
        this.dSj.setChecked(z);
    }
}
