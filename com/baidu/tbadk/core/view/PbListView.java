package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.b.j.e.b;
/* loaded from: classes3.dex */
public class PbListView extends b {
    public Context j;
    public ImageView p;
    public boolean r;

    /* renamed from: f  reason: collision with root package name */
    public final int f13454f = R.drawable.new_pic_emotion_03;

    /* renamed from: g  reason: collision with root package name */
    public final int f13455g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);

    /* renamed from: h  reason: collision with root package name */
    public final int f13456h = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds256);
    public final int i = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    public TextView k = null;
    public ProgressBar l = null;
    public View.OnClickListener m = null;
    public View n = null;
    public View o = null;
    public int q = this.f13454f;
    public int s = 0;
    public String t = null;
    public LinearLayout u = null;
    public int v = 0;
    public int w = R.color.CAM_X0110;
    public int x = R.color.CAM_X0205;
    public ImageView y = null;
    public LinearLayout z = null;
    public boolean A = true;
    public int B = -1;
    public int C = 0;
    public boolean D = false;

    /* loaded from: classes3.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD
    }

    public PbListView(Context context) {
        this.j = null;
        this.j = context;
    }

    public void A(String str) {
        B(str, this.i);
    }

    public void B(String str, int i) {
        this.t = str;
        this.k.setText(str);
        this.r = false;
        this.p.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams.height = i;
        layoutParams.bottomMargin = 0;
        this.u.setLayoutParams(layoutParams);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void C(int i) {
        this.v = i;
    }

    public void D(String str, int i) {
        this.t = str;
        this.k.setText(str);
        this.r = true;
        this.p.setVisibility(0);
        this.q = this.f13454f;
        d(TbadkCoreApplication.getInst().getSkinType());
        e(i);
        this.D = false;
    }

    public void E(int i) {
        this.k.setTextSize(0, l.g(this.j, i));
    }

    public void F(String str, int i) {
        this.t = str;
        this.k.setText(str);
        this.r = true;
        this.p.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.topMargin = i;
        this.p.setLayoutParams(layoutParams);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void G(String str, @DrawableRes int i, int i2) {
        this.t = str;
        this.k.setText(str);
        this.r = true;
        this.q = i;
        this.p.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = this.f13455g;
        this.p.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams2.height = -2;
        layoutParams2.bottomMargin = this.f13456h;
        this.u.setLayoutParams(layoutParams2);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void H() {
        if (8 != this.z.getVisibility()) {
            this.z.setVisibility(8);
        }
    }

    public void I(int i) {
        this.n.setVisibility(i);
    }

    public void J(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.o.getLayoutParams());
        layoutParams.height = i;
        this.o.setLayoutParams(layoutParams);
        this.o.setVisibility(0);
    }

    public void K() {
        this.k.setVisibility(0);
        this.u.setVisibility(0);
        f();
    }

    public void L() {
        this.l.setVisibility(0);
        this.k.setText(this.j.getText(R.string.loading));
    }

    public void M() {
        this.z.setVisibility(0);
        this.y.setVisibility(0);
        this.u.setVisibility(0);
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        i();
    }

    public void N(int i) {
        LinearLayout linearLayout = this.z;
        if (linearLayout == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = i;
        this.z.setLayoutParams(layoutParams);
        this.z.setVisibility(0);
    }

    public void O() {
        this.l.setVisibility(0);
        this.k.setText(this.j.getText(R.string.loading));
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.b.j.e.b
    public View a() {
        View inflate = LayoutInflater.from(this.j).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.n = inflate;
        this.u = (LinearLayout) inflate.findViewById(R.id.pb_more_view);
        this.k = (TextView) this.n.findViewById(R.id.pb_more_text);
        this.p = (ImageView) this.n.findViewById(R.id.no_data_image);
        if (this.A) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        this.l = (ProgressBar) this.n.findViewById(R.id.progress);
        this.y = (ImageView) this.n.findViewById(R.id.pb_more_view_top_line);
        this.o = this.n.findViewById(R.id.empty_view);
        this.z = (LinearLayout) this.n.findViewById(R.id.pb_more_top_extra_view);
        return this.n;
    }

    @Override // d.b.b.j.e.b
    public void c() {
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(this.n);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(int i) {
        int color;
        int i2;
        int i3;
        int i4 = this.B;
        if (i4 != -1) {
            i = i4;
        }
        String charSequence = this.k.getText().toString();
        boolean z = false;
        if (charSequence.equals(this.j.getText(R.string.pb_load_more))) {
            color = SkinManager.getColor(i, R.color.CAM_X0109);
        } else if (charSequence.equals(this.j.getText(R.string.loading))) {
            color = SkinManager.getColor(i, R.color.CAM_X0109);
        } else if (!charSequence.equals(this.j.getText(R.string.list_no_more)) && !charSequence.equals(this.j.getText(R.string.list_has_no_more)) && !charSequence.equals(this.j.getText(R.string.sub_pb_list_no_more))) {
            if (charSequence.equals(this.j.getText(R.string.list_no_more_new))) {
                color = SkinManager.getColor(i, R.color.CAM_X0110);
            } else {
                color = (charSequence.equals(this.j.getText(R.string.list_click_load_more)) || charSequence.equals(this.j.getText(R.string.really_great))) ? SkinManager.getColor(i, R.color.CAM_X0109) : 0;
            }
        } else {
            color = SkinManager.getColor(i, R.color.CAM_X0109);
            z = true;
        }
        if (z && (i3 = this.w) != 0) {
            color = SkinManager.getColor(i, i3);
        }
        if (color == 0 && (i2 = this.v) != 0 && !z) {
            color = i2;
        }
        if (color != 0) {
            this.k.setTextColor(color);
        }
        SkinManager.setImageResource(this.y, this.x, i);
        int i5 = this.C;
        if (i5 == 0) {
            SkinManager.setBackgroundResource(this.u, R.color.CAM_X0201, i);
        } else if (i5 > 0) {
            SkinManager.setBackgroundResource(this.u, i5, i);
        }
        int i6 = this.s;
        if (i6 != 0) {
            SkinManager.setBackgroundColor(this.o, i6, i);
        }
        if (this.r) {
            SkinManager.setImageResource(this.p, this.q);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        }
    }

    public void e(int i) {
        int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds156);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.topMargin = dimension;
        this.p.setLayoutParams(layoutParams);
        J(dimension);
    }

    public void f() {
        this.l.setVisibility(8);
        String str = this.t;
        if (str != null) {
            this.k.setText(str);
        } else {
            this.k.setText(this.j.getText(R.string.pb_load_more));
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g() {
        A(this.j.getResources().getString(R.string.list_no_more));
        f();
    }

    public String h() {
        return this.t;
    }

    public void i() {
        this.o.setVisibility(8);
    }

    public void j() {
        this.r = false;
        this.p.setVisibility(8);
        i();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams.height = this.i;
        layoutParams.bottomMargin = 0;
        this.u.setLayoutParams(layoutParams);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.o.getLayoutParams());
        layoutParams.height = i;
        this.o.setLayoutParams(layoutParams);
        this.o.setVisibility(0);
        this.z.setVisibility(8);
        this.y.setVisibility(8);
        this.u.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
    }

    public boolean l() {
        ProgressBar progressBar = this.l;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public boolean m() {
        return this.r;
    }

    public void n(int i) {
        SkinManager.setBackgroundResource(this.u, i);
    }

    public void o(int i) {
        this.C = i;
    }

    public void p(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams.height = i;
        this.y.setLayoutParams(layoutParams);
    }

    public void q() {
        this.n.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void r(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.u.getLayoutParams());
        layoutParams.height = i;
        this.u.setLayoutParams(layoutParams);
    }

    public void s(boolean z) {
        this.A = z;
    }

    public void t() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams.height = l.g(this.j, R.dimen.ds1);
        this.y.setLayoutParams(layoutParams);
    }

    public void u(int i) {
        this.x = i;
    }

    public void v() {
        this.y.setVisibility(8);
    }

    public void w() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.y.setLayoutParams(layoutParams);
    }

    public void x() {
        this.y.setVisibility(0);
    }

    public void y(int i) {
        this.w = i;
    }

    public void z(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }
}
