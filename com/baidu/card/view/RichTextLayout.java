package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.j0.r.q.a2;
import d.a.j0.r.u.c;
/* loaded from: classes.dex */
public class RichTextLayout extends LinearLayout implements p<d.a.j0.r.q.a>, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final int f4497e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4498f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4499g;

    /* renamed from: h  reason: collision with root package name */
    public Context f4500h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4501i;
    public View.OnClickListener j;
    public boolean k;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RichTextLayout.this.j != null) {
                RichTextLayout.this.j.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RichTextLayout.this.j != null) {
                RichTextLayout.this.j.onClick(view);
            }
        }
    }

    public RichTextLayout(Context context) {
        super(context);
        this.f4497e = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.f4501i = false;
        this.k = false;
        this.f4500h = context;
        c();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4499g = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4498f = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: d */
    public void a(d.a.j0.r.q.a aVar) {
        if (aVar == null || aVar.m() == null) {
            return;
        }
        a2 m = aVar.m();
        OriginalThreadInfo originalThreadInfo = m.r1;
        if (originalThreadInfo != null && this.f4501i) {
            this.f4498f.setVisibility(8);
            c d2 = c.d(this.f4499g);
            d2.v(R.string.F_X01);
            d2.u(R.dimen.T_X07);
            if (originalThreadInfo.m) {
                ThreadCardUtils.setAbstract(this.f4499g, this.f4498f, new SpannableString(originalThreadInfo.f12138g), m, this.f4497e, this.f4501i, this.k);
                SkinManager.setViewTextColor(this.f4499g, R.color.CAM_X0108);
            } else {
                ThreadCardUtils.setAbstract(this.f4499g, this.f4498f, originalThreadInfo.t, m, this.f4497e, this.f4501i, this.k);
            }
        } else {
            ThreadCardUtils.setTitle(this.f4498f, m, this.k);
            ThreadCardUtils.setAbstract(this.f4499g, this.f4498f, m.D(), m, this.f4497e, this.f4501i, this.k);
        }
        if (!this.f4501i) {
            this.f4499g.setClickable(false);
            this.f4498f.setClickable(false);
        } else if (originalThreadInfo != null && originalThreadInfo.m) {
            setOnClickListener(null);
            setClickable(true);
        } else {
            setOnClickListener(this);
            this.f4499g.setOnClickListener(new a());
            this.f4498f.setOnClickListener(new b());
            this.f4499g.setClickable(true);
            this.f4498f.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.j;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setFrom(String str) {
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void setNeedFrsTabName(boolean z) {
        this.k = z;
    }

    public void setTransmit(boolean z) {
        this.f4501i = z;
    }
}
