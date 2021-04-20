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
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.u.c;
import d.b.i.p;
/* loaded from: classes.dex */
public class RichTextLayout extends LinearLayout implements p<d.b.h0.r.q.a>, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final int f4545e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4546f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4547g;

    /* renamed from: h  reason: collision with root package name */
    public Context f4548h;
    public boolean i;
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
        this.f4545e = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.i = false;
        this.k = false;
        this.f4548h = context;
        c();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4547g = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4546f = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: d */
    public void a(d.b.h0.r.q.a aVar) {
        if (aVar == null || aVar.n() == null) {
            return;
        }
        a2 n = aVar.n();
        OriginalThreadInfo originalThreadInfo = n.r1;
        if (originalThreadInfo != null && this.i) {
            this.f4546f.setVisibility(8);
            c d2 = c.d(this.f4547g);
            d2.v(R.string.F_X01);
            d2.u(R.dimen.T_X07);
            if (originalThreadInfo.m) {
                ThreadCardUtils.setAbstract(this.f4547g, this.f4546f, new SpannableString(originalThreadInfo.f12878g), n, this.f4545e, this.i, this.k);
                SkinManager.setViewTextColor(this.f4547g, R.color.CAM_X0108);
            } else {
                ThreadCardUtils.setAbstract(this.f4547g, this.f4546f, originalThreadInfo.t, n, this.f4545e, this.i, this.k);
            }
        } else {
            ThreadCardUtils.setTitle(this.f4546f, n, this.k);
            ThreadCardUtils.setAbstract(this.f4547g, this.f4546f, n.D(), n, this.f4545e, this.i, this.k);
        }
        if (!this.i) {
            this.f4547g.setClickable(false);
            this.f4546f.setClickable(false);
        } else if (originalThreadInfo != null && originalThreadInfo.m) {
            setOnClickListener(null);
            setClickable(true);
        } else {
            setOnClickListener(this);
            this.f4547g.setOnClickListener(new a());
            this.f4546f.setOnClickListener(new b());
            this.f4547g.setClickable(true);
            this.f4546f.setClickable(true);
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
        this.i = z;
    }
}
