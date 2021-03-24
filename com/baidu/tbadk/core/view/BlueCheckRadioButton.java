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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class BlueCheckRadioButton extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f13339e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13340f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f13341g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BlueCheckRadioButton.this.f13341g != null) {
                BlueCheckRadioButton.this.f13341g.setButtonDrawable(R.drawable.chx_tips_list_ok_selector);
                BlueCheckRadioButton.this.f13341g.toggle();
            }
        }
    }

    public BlueCheckRadioButton(Context context) {
        super(context);
        this.f13339e = context;
        b();
    }

    public final void b() {
        LayoutInflater.from(this.f13339e).inflate(R.layout.custom_blue_check_radio_button_layout, (ViewGroup) this, true);
        this.f13340f = (TextView) findViewById(R.id.custom_check_radio_button_tv);
        this.f13341g = (RadioButton) findViewById(R.id.custom_check_radio_button_rb);
        c();
        setOnClickListener(new a());
    }

    public void c() {
        TextView textView = this.f13340f;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, "CAM_X0302");
        }
    }

    @Override // android.view.View
    public Object getTag() {
        return this.f13341g.getTag();
    }

    public void setChecked(boolean z) {
        this.f13341g.setChecked(z);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        RadioButton radioButton = this.f13341g;
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        RadioButton radioButton = this.f13341g;
        if (radioButton != null) {
            radioButton.setTag(obj);
        }
    }

    public void setText(String str) {
        TextView textView = this.f13340f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public BlueCheckRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13339e = context;
        b();
    }
}
