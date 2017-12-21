package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private TextView ajG;
    private RadioButton ajH;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.ajG = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.ajH = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        we();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajH != null) {
                    a.this.ajH.setButtonDrawable(d.f.chx_tips_list_ok_selector);
                    a.this.ajH.toggle();
                }
            }
        });
    }

    public void we() {
        if (this.ajG != null) {
            aj.a(this.ajG, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.ajH != null) {
            this.ajH.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.ajG != null) {
            this.ajG.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.ajH != null) {
            this.ajH.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.ajH.getTag();
    }

    public void setChecked(boolean z) {
        this.ajH.setChecked(z);
    }
}
