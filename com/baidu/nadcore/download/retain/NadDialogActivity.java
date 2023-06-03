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
import com.baidu.tieba.kk0;
import com.baidu.tieba.n31;
import com.baidu.tieba.yl0;
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

    public void Q1() {
    }

    public void R1() {
    }

    public abstract int S1();

    public void U1() {
    }

    public boolean V1() {
        return false;
    }

    public boolean W1() {
        return false;
    }

    public String X1() {
        return null;
    }

    public String Y1() {
        return null;
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            NadDialogActivity.this.R1();
            NadDialogActivity nadDialogActivity = NadDialogActivity.this;
            nadDialogActivity.Z1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_POSITIVE.type, NadDialogActivity.this.z);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            NadDialogActivity.this.Q1();
            NadDialogActivity nadDialogActivity = NadDialogActivity.this;
            nadDialogActivity.Z1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_NAGITIVE.type, NadDialogActivity.this.z);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Bundle bundle) {
        super.A1(bundle);
        setContentView(yl0.a().a());
        Intent intent = getIntent();
        this.B = intent;
        if (intent != null) {
            this.z = intent.getStringExtra("ext");
            this.A = this.B.getStringExtra("alsPage");
        }
        T1();
        U1();
        Z1(this.A, ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_DIALOG_SHOW.type, this.z);
    }

    public final void T1() {
        this.v = (TextView) findViewById(R.id.tv_nagitive);
        this.u = (TextView) findViewById(R.id.tv_positive);
        this.w = (LinearLayout) findViewById(R.id.ad_dialog_container);
        this.x = (LinearLayout) findViewById(R.id.ll_dialog_content_container);
        this.y = (LinearLayout) findViewById(R.id.ll_dialog_btn_container);
        LayoutInflater.from(this).inflate(S1(), (ViewGroup) this.x, true);
        this.w.setBackground(kk0.b().getResources().getDrawable(R.drawable.nad_dialog_bg));
        this.w.setDividerDrawable(kk0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_horizon));
        this.y.setDividerDrawable(kk0.b().getResources().getDrawable(R.drawable.nad_dialog_divider_vertical));
        if (W1()) {
            this.u.setText(Y1());
            this.u.setOnClickListener(new a());
        } else {
            this.u.setVisibility(8);
        }
        if (V1()) {
            this.v.setText(X1());
            this.v.setOnClickListener(new b());
            return;
        }
        this.v.setVisibility(8);
    }

    public final void Z1(String str, String str2, String str3, String str4) {
        if (!NetWorkUtils.b(kk0.b())) {
            return;
        }
        n31.b(new ClogBuilder().z(str2).v(str).j(str3).p(str4));
    }
}
