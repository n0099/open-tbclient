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
    public Context f4444e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f4445f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f4446g;

    /* renamed from: h  reason: collision with root package name */
    public int f4447h;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f4444e = context;
        this.f4445f = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public final boolean b(a aVar) {
        return (aVar == null || aVar.n() == null || !aVar.n().z2() || aVar.n().u1() == null) ? false : true;
    }

    public final boolean c(a aVar) {
        return (aVar == null || aVar.n() == null || aVar.n().O0() == null || aVar.n().O0().getOptions() == null || aVar.n().O0().getOptions().size() <= 0) ? false : true;
    }

    public void d(TbPageContext tbPageContext, int i) {
        this.f4445f.e();
    }

    public void setData(a aVar) {
        boolean z;
        a2 n = aVar.n();
        if (c(aVar) || b(aVar) || aVar.n() == null || !aVar.n().b2() || this.f4447h == 3) {
            z = false;
        } else {
            this.f4445f.setVisibility(0);
            this.f4445f.setFrom(2);
            this.f4445f.a(n);
            this.f4445f.setAfterClickListener(this.f4446g);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void setFrom(int i) {
    }

    public void setFrstype(int i) {
        this.f4447h = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.f4446g = onClickListener;
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
