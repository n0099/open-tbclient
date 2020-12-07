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
    private TextView eXJ;
    private RadioButton eXK;
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
        this.eXJ = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.eXK = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        buS();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.BlueCheckRadioButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BlueCheckRadioButton.this.eXK != null) {
                    BlueCheckRadioButton.this.eXK.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                    BlueCheckRadioButton.this.eXK.toggle();
                }
            }
        });
    }

    public void buS() {
        if (this.eXJ != null) {
            ap.setViewTextColor(this.eXJ, "CAM_X0302");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.eXK != null) {
            this.eXK.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.eXJ != null) {
            this.eXJ.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.eXK != null) {
            this.eXK.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.eXK.getTag();
    }

    public void setChecked(boolean z) {
        this.eXK.setChecked(z);
    }
}
