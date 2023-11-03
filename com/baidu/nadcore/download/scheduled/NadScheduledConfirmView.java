package com.baidu.nadcore.download.scheduled;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.baidu.tieba.d71;
import com.baidu.tieba.gf0;
/* loaded from: classes3.dex */
public class NadScheduledConfirmView extends LinearLayout {
    public RadioButton a;
    public TextView b;
    public LinearLayout c;
    public LinearLayout d;
    public LinearLayout e;

    public NadScheduledConfirmView(Context context) {
        this(context, null);
    }

    public void setOnPosBtnClickListener(@NonNull View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setOnWifiBtnClickListener(@NonNull View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public NadScheduledConfirmView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadScheduledConfirmView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nad_scheduled_confirm_dialog_view, this);
        this.c = (LinearLayout) findViewById(R.id.ad_dialog_container);
        this.d = (LinearLayout) findViewById(R.id.ll_dialog_content_container);
        this.e = (LinearLayout) findViewById(R.id.ll_dialog_btn_container);
        this.b = (TextView) findViewById(R.id.tv_positive);
        this.a = (RadioButton) findViewById(R.id.rb_scheduled_dialog_wifi_confirm_btn);
        this.c.setBackground(gf0.b().getResources().getDrawable(R.drawable.nad_dialog_bg));
        this.c.setDividerDrawable(gf0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_horizon));
        this.e.setDividerDrawable(gf0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_vertical));
        this.b.setTextSize(16.0f);
        this.b.setText(getResources().getString(R.string.nad_scheduled_dialog_pos_btn_text));
        this.b.setTextColor(d71.a().getResources().getColor(R.color.nad_dialog_pos_text_color));
        this.b.setVisibility(0);
    }
}
