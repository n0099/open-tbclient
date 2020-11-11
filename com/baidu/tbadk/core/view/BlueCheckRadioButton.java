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
    private TextView eRt;
    private RadioButton eRu;
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
        this.eRt = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.eRu = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        bsh();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.eRu != null) {
                    BlueCheckRadioButton.this.eRu.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.eRu.toggle();
                }
            }
        });
    }

    public void bsh() {
        if (this.eRt != null) {
            ap.setViewTextColor(this.eRt, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eRu != null) {
            this.eRu.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.eRt != null) {
            this.eRt.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eRu != null) {
            this.eRu.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eRu.getTag();
    }

    public void setChecked(boolean z) {
        this.eRu.setChecked(z);
    }
}
