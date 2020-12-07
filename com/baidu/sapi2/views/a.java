package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.l.a.a;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes6.dex */
public class a extends Dialog implements com.baidu.sapi2.g.b {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f3581a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private View g;
    private View h;
    private Context i;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0356a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f3582a;

        View$OnClickListenerC0356a(View.OnClickListener onClickListener) {
            this.f3582a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) a.this.i, a.this);
                this.f3582a.onClick(view);
            } catch (Exception e) {
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f3583a;

        b(View.OnClickListener onClickListener) {
            this.f3583a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) a.this.i, a.this);
                this.f3583a.onClick(view);
            } catch (Exception e) {
            }
        }
    }

    public a(Context context) {
        super(context, a.h.SapiSdkBeautyDialog);
        this.i = context;
        setContentView(a.f.layout_sapi_sdk_fingerprint_dialog);
        this.f3581a = (LinearLayout) findViewById(a.e.bg_layout);
        this.b = (TextView) findViewById(a.e.title);
        this.c = (TextView) findViewById(a.e.sub_title);
        this.d = (TextView) findViewById(a.e.negative_btn);
        this.e = (TextView) findViewById(a.e.positive_btn);
        this.f = (ImageView) findViewById(a.e.icon);
        this.g = findViewById(a.e.transverse_divider_line);
        this.h = findViewById(a.e.divider_line);
        c();
        ViewUtility.setViewClickAlpha(this.d, 0.2f);
        ViewUtility.setViewClickAlpha(this.e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private void c() {
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f3581a.setBackgroundResource(a.d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f.setImageResource(a.d.sapi_sdk_fingerprint_dark_mode);
            this.b.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
            this.c.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.g.setBackgroundColor(this.i.getResources().getColor(a.b.sapi_sdk_fingerprint_dialog_divider_line));
            this.h.setBackgroundColor(this.i.getResources().getColor(a.b.sapi_sdk_fingerprint_dialog_divider_line));
            this.d.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
            this.e.setTextColor(this.i.getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
        }
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b b(String str, View.OnClickListener onClickListener) {
        this.e.setText(str);
        this.e.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b a(int i) {
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

    @Override // com.baidu.sapi2.g.b
    public void b() {
        show();
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b a(String str, String str2) {
        this.b.setText(str);
        this.c.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b a(String str, View.OnClickListener onClickListener) {
        this.d.setText(str);
        this.d.setOnClickListener(new View$OnClickListenerC0356a(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b a() {
        findViewById(a.e.icon).setVisibility(8);
        return this;
    }
}
