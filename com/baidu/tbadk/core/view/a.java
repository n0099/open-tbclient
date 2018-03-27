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
    private TextView aZv;
    private RadioButton aZw;
    private Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.aZv = (TextView) findViewById(d.g.custom_check_radio_button_tv);
        this.aZw = (RadioButton) findViewById(d.g.custom_check_radio_button_rb);
        DQ();
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZw != null) {
                    a.this.aZw.setButtonDrawable(d.f.chx_tips_list_ok_selector);
                    a.this.aZw.toggle();
                }
            }
        });
    }

    public void DQ() {
        if (this.aZv != null) {
            aj.a(this.aZv, "cp_link_tip_a");
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.aZw != null) {
            this.aZw.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setText(String str) {
        if (this.aZv != null) {
            this.aZv.setText(str);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (this.aZw != null) {
            this.aZw.setTag(obj);
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.aZw.getTag();
    }

    public void setChecked(boolean z) {
        this.aZw.setChecked(z);
    }
}
