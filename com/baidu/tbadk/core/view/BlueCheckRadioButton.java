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
    private TextView eDi;
    private RadioButton eDj;
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
        this.eDi = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.eDj = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        bnO();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.eDj != null) {
                    BlueCheckRadioButton.this.eDj.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.eDj.toggle();
                }
            }
        });
    }

    public void bnO() {
        if (this.eDi != null) {
            ap.setViewTextColor(this.eDi, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eDj != null) {
            this.eDj.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.eDi != null) {
            this.eDi.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eDj != null) {
            this.eDj.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eDj.getTag();
    }

    public void setChecked(boolean z) {
        this.eDj.setChecked(z);
    }
}
