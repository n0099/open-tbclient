package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.connect.NetWorkUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.ii0;
import com.baidu.tieba.l11;
import com.baidu.tieba.wj0;
/* loaded from: classes2.dex */
public abstract class NadDialogActivity extends BaseActivity {
    public String A;
    public Intent B;
    public TextView u;
    public TextView v;
    public LinearLayout w;
    public LinearLayout x;
    public LinearLayout y;
    public String z;

    public void a2() {
    }

    public void b2() {
    }

    public abstract int c2();

    public void e2() {
    }

    public boolean f2() {
        return false;
    }

    public boolean g2() {
        return false;
    }

    public String h2() {
        return null;
    }

    public String i2() {
        return null;
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            NadDialogActivity.this.b2();
            NadDialogActivity nadDialogActivity = NadDialogActivity.this;
            nadDialogActivity.j2(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_POSITIVE.type, NadDialogActivity.this.z);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            NadDialogActivity.this.a2();
            NadDialogActivity nadDialogActivity = NadDialogActivity.this;
            nadDialogActivity.j2(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_NAGITIVE.type, NadDialogActivity.this.z);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1(Bundle bundle) {
        super.B1(bundle);
        setContentView(wj0.a().a());
        Intent intent = getIntent();
        this.B = intent;
        if (intent != null) {
            this.z = intent.getStringExtra("ext");
            this.A = this.B.getStringExtra("alsPage");
        }
        d2();
        e2();
        j2(this.A, ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_DIALOG_SHOW.type, this.z);
    }

    public final void d2() {
        this.v = (TextView) findViewById(R.id.tv_nagitive);
        this.u = (TextView) findViewById(R.id.tv_positive);
        this.w = (LinearLayout) findViewById(R.id.ad_dialog_container);
        this.x = (LinearLayout) findViewById(R.id.ll_dialog_content_container);
        this.y = (LinearLayout) findViewById(R.id.ll_dialog_btn_container);
        LayoutInflater.from(this).inflate(c2(), (ViewGroup) this.x, true);
        this.w.setBackground(ii0.b().getResources().getDrawable(R.drawable.nad_dialog_bg));
        this.w.setDividerDrawable(ii0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_horizon));
        this.y.setDividerDrawable(ii0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_vertical));
        if (g2()) {
            this.u.setText(i2());
            this.u.setOnClickListener(new a());
        } else {
            this.u.setVisibility(8);
        }
        if (f2()) {
            this.v.setText(h2());
            this.v.setOnClickListener(new b());
            return;
        }
        this.v.setVisibility(8);
    }

    public final void j2(String str, String str2, String str3, String str4) {
        if (!NetWorkUtils.b(ii0.b())) {
            return;
        }
        l11.b(new ClogBuilder().z(str2).v(str).j(str3).p(str4));
    }
}
