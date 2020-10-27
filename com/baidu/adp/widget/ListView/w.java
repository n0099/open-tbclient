package com.baidu.adp.widget.ListView;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<x, a> {
    private final LinkedList<Pair<RelativeLayout, com.baidu.tbadk.k.g>> Xn;
    private int Xo;
    private int Xp;

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), x.Xr);
        this.Xn = new LinkedList<>();
        this.Xo = aT(R.dimen.tbds304);
        this.Xp = aT(R.dimen.tbds198);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public a c(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = -1;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(1);
        com.baidu.tbadk.k.g gVar = new com.baidu.tbadk.k.g(this.mContext, 0);
        gVar.attachView(relativeLayout);
        gVar.setTopMargin(this.Xo);
        gVar.br(this.Xp);
        View view = gVar.getView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.addRule(14);
        view.setLayoutParams(layoutParams);
        this.Xn.add(new Pair<>(relativeLayout, gVar));
        a aVar = new a(relativeLayout);
        aVar.Xq = gVar;
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, x xVar, a aVar) {
        if (aVar != null && aVar.Xq != null) {
            aVar.Xq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends af.a {
        public com.baidu.tbadk.k.g Xq;

        public a(View view) {
            super(view);
        }
    }
}
