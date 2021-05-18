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
import d.a.j0.r.q.a;
import d.a.j0.r.q.a2;
/* loaded from: classes.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f4381e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f4382f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f4383g;

    /* renamed from: h  reason: collision with root package name */
    public int f4384h;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f4381e = context;
        this.f4382f = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public final boolean b(a aVar) {
        return (aVar == null || aVar.m() == null || !aVar.m().B2() || aVar.m().v1() == null) ? false : true;
    }

    public final boolean c(a aVar) {
        return (aVar == null || aVar.m() == null || aVar.m().O0() == null || aVar.m().O0().getOptions() == null || aVar.m().O0().getOptions().size() <= 0) ? false : true;
    }

    public void d(TbPageContext tbPageContext, int i2) {
        this.f4382f.e();
    }

    public void setData(a aVar) {
        boolean z;
        a2 m = aVar.m();
        if (c(aVar) || b(aVar) || aVar.m() == null || !aVar.m().c2() || this.f4384h == 3) {
            z = false;
        } else {
            this.f4382f.setVisibility(0);
            this.f4382f.setFrom(2);
            this.f4382f.a(m);
            this.f4382f.setAfterClickListener(this.f4383g);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void setFrom(int i2) {
    }

    public void setFrstype(int i2) {
        this.f4384h = i2;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.f4383g = onClickListener;
    }

    public void setSourceForPb(int i2) {
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
