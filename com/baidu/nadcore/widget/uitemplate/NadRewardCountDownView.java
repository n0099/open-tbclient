package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.m11;
import com.baidu.tieba.r11;
import com.baidu.tieba.v81;
/* loaded from: classes3.dex */
public class NadRewardCountDownView extends RelativeLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public r11 d;
    public String e;
    public String f;
    public int g;
    public c h;
    public v81 i;

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadRewardCountDownView.this.g == 1) {
                return;
            }
            if (NadRewardCountDownView.this.g == 2) {
                NadRewardCountDownView.this.e();
                if (NadRewardCountDownView.this.i != null) {
                    m11.b(NadRewardCountDownView.this.i);
                    if (NadRewardCountDownView.this.h != null) {
                        NadRewardCountDownView.this.h.a();
                    }
                }
            } else if (NadRewardCountDownView.this.g == 3 && NadRewardCountDownView.this.h != null) {
                NadRewardCountDownView.this.h.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadRewardCountDownView.this.g == 4 && NadRewardCountDownView.this.h != null) {
                NadRewardCountDownView.this.h.d();
            }
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
            f();
        }
        if (!z) {
            e();
        }
    }

    public void setRewardDownInnerListener(c cVar) {
        this.h = cVar;
    }

    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = "奖励";
        String str = "%2ss后可以领取" + this.e;
        this.f = "%2ss";
        this.g = 1;
        d(context);
    }

    public final void d(Context context) {
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

    public void e() {
        r11 r11Var = this.d;
        if (r11Var != null) {
            r11Var.d();
            c cVar = this.h;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void f() {
        r11 r11Var = this.d;
        if (r11Var != null) {
            r11Var.e();
            c cVar = this.h;
            if (cVar != null) {
                cVar.b();
            }
        }
    }
}
