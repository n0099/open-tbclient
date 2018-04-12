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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BlueCheckRadioButton extends RelativeLayout {
    private TextView akY;
    private RadioButton akZ;
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
        LayoutInflater.from(this.mContext).inflate(d.i.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.akY = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.akZ = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        wC();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BlueCheckRadioButton.this.akZ != null) {
                    BlueCheckRadioButton.this.akZ.setButtonDrawable(d.f.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.akZ.toggle();
                }
            }
        });
    }

    public void wC() {
        if (this.akY != null) {
            ak.a(this.akY, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.akZ != null) {
            this.akZ.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.akY != null) {
            this.akY.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.akZ != null) {
            this.akZ.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.akZ.getTag();
    }

    public void setChecked(boolean z) {
        this.akZ.setChecked(z);
    }
}
