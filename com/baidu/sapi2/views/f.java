package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.g.a.a;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes19.dex */
public class f extends Dialog implements com.baidu.sapi2.b.b {
    private LinearLayout a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private View g;
    private View h;
    private Context i;

    public f(Context context) {
        super(context, a.h.SapiSdkBeautyDialog);
        this.i = context;
        setContentView(a.f.layout_sapi_sdk_fingerprint_dialog);
        this.a = (LinearLayout) findViewById(a.e.bg_layout);
        this.b = (TextView) findViewById(a.e.title);
        this.c = (TextView) findViewById(a.e.sub_title);
        this.d = (TextView) findViewById(a.e.negative_btn);
        this.e = (TextView) findViewById(a.e.positive_btn);
        this.f = (ImageView) findViewById(a.e.icon);
        this.g = findViewById(a.e.transverse_divider_line);
        this.h = findViewById(a.e.divider_line);
        b();
        ViewUtility.setViewClickAlpha(this.d, 0.2f);
        ViewUtility.setViewClickAlpha(this.e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private void b() {
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.a.setBackgroundResource(a.d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f.setImageResource(a.d.sapi_sdk_fingerprint_dark_mode);
            this.b.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
            this.c.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.g.setBackgroundColor(this.i.getResources().getColor(a.b.sapi_sdk_fingerprint_dialog_divider_line));
            this.h.setBackgroundColor(this.i.getResources().getColor(a.b.sapi_sdk_fingerprint_dialog_divider_line));
            this.d.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
            this.e.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
        }
    }

    @Override // com.baidu.sapi2.b.b
    public com.baidu.sapi2.b.b setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.d.setText(str);
        this.d.setOnClickListener(new d(this, onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.b.b
    public com.baidu.sapi2.b.b setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.e.setText(str);
        this.e.setOnClickListener(new e(this, onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.b.b
    public void showDialog() {
        show();
    }

    @Override // com.baidu.sapi2.b.b
    public com.baidu.sapi2.b.b a(int i) {
        if (i > 2) {
            i = 2;
        } else if (i < 1) {
            i = 1;
        }
        if (i == 1) {
            this.e.setVisibility(8);
            findViewById(a.e.divider_line).setVisibility(8);
        } else {
            this.e.setVisibility(0);
            findViewById(a.e.divider_line).setVisibility(0);
        }
        return this;
    }

    @Override // com.baidu.sapi2.b.b
    public com.baidu.sapi2.b.b a(String str, String str2) {
        this.b.setText(str);
        this.c.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.b.b
    public com.baidu.sapi2.b.b a() {
        findViewById(a.e.icon).setVisibility(8);
        return this;
    }
}
