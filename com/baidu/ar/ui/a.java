package com.baidu.ar.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.ar.Config;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class a extends Dialog {
    private ImageView a;
    private Button b;
    private TextView c;
    private TextView d;
    private View e;
    private InterfaceC0047a f;

    /* renamed from: com.baidu.ar.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0047a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context, Res.getStyle("bdar_NoTitleDialog"));
    }

    private void a() {
        this.a = (ImageView) findViewById(Res.id("bdar_host_btn_close"));
        this.b = (Button) findViewById(Res.id("bdar_host_btn_setting"));
        this.c = (TextView) findViewById(Res.id("bdar_host_tv_title"));
        this.d = (TextView) findViewById(Res.id("bdar_host_tv_content"));
        this.e = findViewById(Res.id("bdar_host_dialog_night_mask"));
        this.e.setVisibility(Config.isNightMode() ? 0 : 8);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f != null) {
                    a.this.f.a();
                }
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f != null) {
                    a.this.f.b();
                }
            }
        });
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        this.f = interfaceC0047a;
    }

    public void a(String str) {
        if (this.c != null) {
            this.c.setText(str);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.d != null) {
            this.d.setText(str);
        }
    }

    public void c(String str) {
        if (this.b != null) {
            this.b.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(Res.inflate("bdar_layout_alert_dialog_permission"));
        setCanceledOnTouchOutside(false);
        a();
    }
}
