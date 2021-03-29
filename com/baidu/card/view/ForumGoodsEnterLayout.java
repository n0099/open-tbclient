package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import d.b.h0.r.q.a;
import d.b.h0.r.q.a2;
/* loaded from: classes.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f4409e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f4410f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f4411g;

    /* renamed from: h  reason: collision with root package name */
    public int f4412h;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f4409e = context;
        this.f4410f = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public final boolean b(a aVar) {
        return (aVar == null || aVar.n() == null || !aVar.n().y2() || aVar.n().u1() == null) ? false : true;
    }

    public final boolean c(a aVar) {
        return (aVar == null || aVar.n() == null || aVar.n().O0() == null || aVar.n().O0().getOptions() == null || aVar.n().O0().getOptions().size() <= 0) ? false : true;
    }

    public void d(TbPageContext tbPageContext, int i) {
        this.f4410f.e();
    }

    public void setData(a aVar) {
        boolean z;
        a2 n = aVar.n();
        if (c(aVar) || b(aVar) || aVar.n() == null || !aVar.n().a2() || this.f4412h == 3) {
            z = false;
        } else {
            this.f4410f.setVisibility(0);
            this.f4410f.setFrom(2);
            this.f4410f.a(n);
            this.f4410f.setAfterClickListener(this.f4411g);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void setFrom(int i) {
    }

    public void setFrstype(int i) {
        this.f4412h = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.f4411g = onClickListener;
    }

    public void setSourceForPb(int i) {
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
