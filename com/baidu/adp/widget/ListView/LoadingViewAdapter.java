package com.baidu.adp.widget.ListView;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.b.j.e.a;
import d.b.b.j.e.t;
import d.b.h0.d0.g;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LoadingViewAdapter extends a<t, TabLoadingViewHolder> {
    public final LinkedList<Pair<RelativeLayout, g>> m;
    public int n;
    public int o;

    /* loaded from: classes.dex */
    public static class TabLoadingViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public g f2353a;

        public TabLoadingViewHolder(View view) {
            super(view);
        }
    }

    public LoadingViewAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), t.f42445e);
        this.m = new LinkedList<>();
        this.n = h0(R.dimen.tbds304);
        this.o = h0(R.dimen.tbds198);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        j0(i, view, viewGroup, tVar, tabLoadingViewHolder);
        return view;
    }

    public final int h0(int i) {
        return l.g(TbadkCoreApplication.getInst(), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public TabLoadingViewHolder R(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f42358e);
        ViewGroup.LayoutParams u = u(viewGroup);
        u.width = -1;
        u.height = -1;
        relativeLayout.setLayoutParams(u);
        relativeLayout.setGravity(1);
        g gVar = new g(this.f42358e, 0);
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
        tabLoadingViewHolder.f2353a = gVar;
        return tabLoadingViewHolder;
    }

    public View j0(int i, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        g gVar;
        if (tabLoadingViewHolder != null && (gVar = tabLoadingViewHolder.f2353a) != null) {
            gVar.l(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }
}
