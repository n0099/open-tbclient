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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView feQ;
    private RadioButton feR;
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
        this.feQ = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.feR = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        btO();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.feR != null) {
                    BlueCheckRadioButton.this.feR.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.feR.toggle();
                }
            }
        });
    }

    public void btO() {
        if (this.feQ != null) {
            ap.setViewTextColor(this.feQ, "CAM_X0302");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.feR != null) {
            this.feR.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.feQ != null) {
            this.feQ.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.feR != null) {
            this.feR.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.feR.getTag();
    }

    public void setChecked(boolean z) {
        this.feR.setChecked(z);
    }
}
