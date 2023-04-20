package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.R;
import com.baidu.tieba.lc1;
import com.baidu.tieba.t31;
import com.baidu.tieba.y31;
import com.baidu.tieba.zp0;
/* loaded from: classes2.dex */
public class NadRewardCountDownView extends RelativeLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public y31 d;
    public int e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public int k;
    public g l;
    public lc1 m;

    /* loaded from: classes2.dex */
    public interface g {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadRewardCountDownView.this.k == 1) {
                return;
            }
            if (NadRewardCountDownView.this.k == 2) {
                NadRewardCountDownView.this.r();
                if (NadRewardCountDownView.this.m != null) {
                    t31.b(NadRewardCountDownView.this.m);
                    if (NadRewardCountDownView.this.l != null) {
                        NadRewardCountDownView.this.l.d();
                    }
                }
            } else if (NadRewardCountDownView.this.k == 3 && NadRewardCountDownView.this.l != null) {
                NadRewardCountDownView.this.l.f();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadRewardCountDownView.this.k == 4 && NadRewardCountDownView.this.l != null) {
                NadRewardCountDownView.this.l.e();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends y31.c {
        public c() {
        }

        @Override // com.baidu.tieba.y31.c
        public void b() {
            super.b();
            if (NadRewardCountDownView.this.k < 3) {
                NadRewardCountDownView nadRewardCountDownView = NadRewardCountDownView.this;
                nadRewardCountDownView.i = "恭喜您已获得" + NadRewardCountDownView.this.h + "!";
                NadRewardCountDownView.this.k = 3;
            }
            if (NadRewardCountDownView.this.b.getVisibility() != 0) {
                NadRewardCountDownView.this.b.setVisibility(0);
            }
            NadRewardCountDownView.this.a.setText(String.format(NadRewardCountDownView.this.i, Integer.valueOf(NadRewardCountDownView.this.f)));
            NadRewardCountDownView.this.invalidate();
        }

        @Override // com.baidu.tieba.y31.c
        public void f(long j) {
            super.f(j);
            NadRewardCountDownView.this.f = (((int) j) / 1000) + 1;
            if (NadRewardCountDownView.this.k < 2 && NadRewardCountDownView.this.g > 0 && NadRewardCountDownView.this.e - NadRewardCountDownView.this.f > NadRewardCountDownView.this.g) {
                if (NadRewardCountDownView.this.b.getVisibility() != 0) {
                    NadRewardCountDownView.this.b.setVisibility(0);
                }
                NadRewardCountDownView.this.k = 2;
            }
            NadRewardCountDownView.this.a.setText(String.format(NadRewardCountDownView.this.i, Integer.valueOf(NadRewardCountDownView.this.f)));
            NadRewardCountDownView.this.invalidate();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements lc1.b {
        public d() {
        }

        @Override // com.baidu.tieba.lc1.b
        public void a(boolean z) {
            NadRewardCountDownView.this.m.dismiss();
            if (z && NadRewardCountDownView.this.l != null) {
                NadRewardCountDownView.this.l.c();
            }
            NadRewardCountDownView.this.t();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnDismissListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (NadRewardCountDownView.this.l != null) {
                NadRewardCountDownView.this.l.g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends y31.c {
        public f() {
        }

        @Override // com.baidu.tieba.y31.c
        public void b() {
            super.b();
            if (NadRewardCountDownView.this.k != 4) {
                NadRewardCountDownView.this.j = "";
                NadRewardCountDownView.this.k = 4;
            }
            NadRewardCountDownView.this.c.setText(NadRewardCountDownView.this.j);
            NadRewardCountDownView.this.c.setBackground(NadRewardCountDownView.this.getResources().getDrawable(R.drawable.nad_reward_close_icon_bg));
            NadRewardCountDownView.this.requestLayout();
        }

        @Override // com.baidu.tieba.y31.c
        public void f(long j) {
            super.f(j);
            NadRewardCountDownView.this.f = (((int) j) / 1000) + 1;
            NadRewardCountDownView.this.c.setText(String.format(NadRewardCountDownView.this.j, Integer.valueOf(NadRewardCountDownView.this.f)));
            NadRewardCountDownView.this.invalidate();
        }
    }

    public NadRewardCountDownView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        boolean z;
        super.dispatchWindowVisibilityChanged(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            t();
        }
        if (!z) {
            r();
        }
    }

    public void setRewardDownInnerListener(g gVar) {
        this.l = gVar;
    }

    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = -1;
        this.h = "奖励";
        this.i = "%2ss后可以领取" + this.h;
        this.j = "%2ss";
        this.k = 1;
        q(context);
    }

    public final void q(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nad_reward_count_down_view, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R.id.nad_skip_view);
        this.b = textView;
        textView.setText("跳过");
        this.b.setVisibility(8);
        this.a = (TextView) findViewById(R.id.nad_count_down_view);
        this.c = (TextView) findViewById(R.id.nad_tail_count_down_view);
        this.a.setClickable(true);
        this.b.setOnClickListener(new a());
        this.c.setOnClickListener(new b());
        setVisibility(8);
    }

    public void r() {
        y31 y31Var = this.d;
        if (y31Var != null) {
            y31Var.d();
            g gVar = this.l;
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    public void s() {
        y31 y31Var = this.d;
        if (y31Var != null) {
            y31Var.b();
            this.d = null;
        }
    }

    public void t() {
        y31 y31Var = this.d;
        if (y31Var != null) {
            y31Var.e();
            g gVar = this.l;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public void u() {
        s();
        this.b.setVisibility(8);
        this.a.setVisibility(8);
        this.c.setVisibility(0);
        y31 y31Var = new y31(3000L, 1000L);
        this.d = y31Var;
        y31Var.f(new f());
        this.d.g();
    }

    public void update(AdBaseModel adBaseModel) {
        if (adBaseModel != null && adBaseModel.j != null) {
            setTag(adBaseModel);
            zp0 zp0Var = adBaseModel.p;
            float f2 = 1.0f;
            if (zp0Var != null) {
                this.g = zp0Var.e;
                String str = zp0Var.i;
                if (!TextUtils.isEmpty(str) && str.length() <= 4) {
                    this.h = str;
                    this.i = "%2ss后可以领取" + this.h;
                }
                float f3 = adBaseModel.p.g;
                if (f3 > 0.0f && f3 <= 1.0f) {
                    f2 = f3;
                }
            }
            int floor = (int) Math.floor(adBaseModel.j.c * f2);
            this.e = floor;
            this.f = floor;
            y31 y31Var = new y31(floor * 1000, 1000L);
            this.d = y31Var;
            y31Var.f(new c());
            lc1 lc1Var = new lc1(getContext(), adBaseModel, new d());
            this.m = lc1Var;
            lc1Var.setOnDismissListener(new e());
            this.a.setVisibility(0);
            setVisibility(0);
            this.d.g();
        }
    }
}
