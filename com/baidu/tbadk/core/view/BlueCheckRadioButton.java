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
/* loaded from: classes2.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView eoO;
    private RadioButton eoP;
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
        this.eoO = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.eoP = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        bkj();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.eoP != null) {
                    BlueCheckRadioButton.this.eoP.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.eoP.toggle();
                }
            }
        });
    }

    public void bkj() {
        if (this.eoO != null) {
            ap.setViewTextColor(this.eoO, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eoP != null) {
            this.eoP.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.eoO != null) {
            this.eoO.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eoP != null) {
            this.eoP.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eoP.getTag();
    }

    public void setChecked(boolean z) {
        this.eoP.setChecked(z);
    }
}
