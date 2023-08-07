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
import com.baidu.tieba.dl0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.q31;
/* loaded from: classes3.dex */
public abstract class NadDialogActivity extends BaseActivity {
    public String A;
    public Intent B;
    public TextView u;
    public TextView v;
    public LinearLayout w;
    public LinearLayout x;
    public LinearLayout y;
    public String z;

    public void P1() {
    }

    public void Q1() {
    }

    public abstract int R1();

    public void T1() {
    }

    public boolean U1() {
        return false;
    }

    public boolean V1() {
        return false;
    }

    public String W1() {
        return null;
    }

    public String X1() {
        return null;
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            NadDialogActivity.this.Q1();
            NadDialogActivity nadDialogActivity = NadDialogActivity.this;
            nadDialogActivity.Y1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_POSITIVE.type, NadDialogActivity.this.z);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            NadDialogActivity.this.P1();
            NadDialogActivity nadDialogActivity = NadDialogActivity.this;
            nadDialogActivity.Y1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_NAGITIVE.type, NadDialogActivity.this.z);
        }
    }

    public final void S1() {
        this.v = (TextView) findViewById(R.id.tv_nagitive);
        this.u = (TextView) findViewById(R.id.tv_positive);
        this.w = (LinearLayout) findViewById(R.id.ad_dialog_container);
        this.x = (LinearLayout) findViewById(R.id.ll_dialog_content_container);
        this.y = (LinearLayout) findViewById(R.id.ll_dialog_btn_container);
        LayoutInflater.from(this).inflate(R1(), (ViewGroup) this.x, true);
        this.w.setBackground(pj0.b().getResources().getDrawable(R.drawable.nad_dialog_bg));
        this.w.setDividerDrawable(pj0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_horizon));
        this.y.setDividerDrawable(pj0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_vertical));
        if (V1()) {
            this.u.setText(X1());
            this.u.setOnClickListener(new a());
        } else {
            this.u.setVisibility(8);
        }
        if (U1()) {
            this.v.setText(W1());
            this.v.setOnClickListener(new b());
            return;
        }
        this.v.setVisibility(8);
    }

    public final void Y1(String str, String str2, String str3, String str4) {
        if (!NetWorkUtils.b(pj0.b())) {
            return;
        }
        q31.e(new ClogBuilder().z(str2).v(str).j(str3).p(str4));
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void z1(Bundle bundle) {
        super.z1(bundle);
        setContentView(dl0.a().a());
        Intent intent = getIntent();
        this.B = intent;
        if (intent != null) {
            this.z = intent.getStringExtra("ext");
            this.A = this.B.getStringExtra("alsPage");
        }
        S1();
        T1();
        Y1(this.A, ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_DIALOG_SHOW.type, this.z);
    }
}
