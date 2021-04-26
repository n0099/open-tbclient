package com.baidu.adp.widget.ListView;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.j.e.a;
import d.a.c.j.e.t;
import d.a.i0.d0.g;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LoadingViewAdapter extends a<t, TabLoadingViewHolder> {
    public final LinkedList<Pair<RelativeLayout, g>> m;
    public int n;
    public int o;

    /* loaded from: classes.dex */
    public static class TabLoadingViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public g f2370a;

        public TabLoadingViewHolder(View view) {
            super(view);
        }
    }

    public LoadingViewAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), t.f40414e);
        this.m = new LinkedList<>();
        this.n = e0(R.dimen.tbds304);
        this.o = e0(R.dimen.tbds198);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        g0(i2, view, viewGroup, tVar, tabLoadingViewHolder);
        return view;
    }

    public final int e0(int i2) {
        return l.g(TbadkCoreApplication.getInst(), i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public TabLoadingViewHolder P(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f40319e);
        ViewGroup.LayoutParams t = t(viewGroup);
        t.width = -1;
        t.height = -1;
        relativeLayout.setLayoutParams(t);
        relativeLayout.setGravity(1);
        g gVar = new g(this.f40319e, 0);
        gVar.attachView(relativeLayout);
        gVar.q(this.n);
        gVar.o(this.o);
        View view = gVar.getView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.addRule(14);
        view.setLayoutParams(layoutParams);
        this.m.add(new Pair<>(relativeLayout, gVar));
        TabLoadingViewHolder tabLoadingViewHolder = new TabLoadingViewHolder(relativeLayout);
        tabLoadingViewHolder.f2370a = gVar;
        return tabLoadingViewHolder;
    }

    public View g0(int i2, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        g gVar;
        if (tabLoadingViewHolder != null && (gVar = tabLoadingViewHolder.f2370a) != null) {
            gVar.l(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }
}
