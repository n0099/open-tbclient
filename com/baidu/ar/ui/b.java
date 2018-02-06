package com.baidu.ar.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class b extends Dialog implements View.OnClickListener {
    private ImageView a;
    private Button b;
    private TextView c;
    private TextView d;
    private a e;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public b(Context context) {
        super(context, Res.getStyle("MyDialog"));
        Res.addResource(context);
    }

    private void a() {
        this.a = (ImageView) findViewById(Res.id("btn_close"));
        this.b = (Button) findViewById(Res.id("btn_setting"));
        this.c = (TextView) findViewById(Res.id("tv_title"));
        this.d = (TextView) findViewById(Res.id("tv_content"));
        Log.e("ZBB", "initView");
    }

    private void b() {
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        Log.e("ZBB", "setListener");
    }

    public void a(a aVar) {
        this.e = aVar;
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == Res.id("btn_setting")) {
            if (this.e != null) {
                this.e.b();
            }
        } else if (view.getId() != Res.id("btn_close") || this.e == null) {
        } else {
            this.e.a();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(Res.inflate("bdar_layout_alert_dialog2"));
        setCanceledOnTouchOutside(false);
        a();
        b();
    }
}
