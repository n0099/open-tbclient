package com.baidu.adp.widget.ListView;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LoadingViewAdapter extends a<t, TabLoadingViewHolder> {
    private int ZA;
    private int ZB;
    private final LinkedList<Pair<RelativeLayout, com.baidu.tbadk.l.g>> Zz;

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    public LoadingViewAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), t.ZD);
        this.Zz = new LinkedList<>();
        this.ZA = getDimens(R.dimen.tbds304);
        this.ZB = getDimens(R.dimen.tbds198);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public TabLoadingViewHolder e(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = -1;
        relativeLayout.setLayoutParams(generateLayoutParamsByParent);
        relativeLayout.setGravity(1);
        com.baidu.tbadk.l.g gVar = new com.baidu.tbadk.l.g(this.mContext, 0);
        gVar.attachView(relativeLayout);
        gVar.setTopMargin(this.ZA);
        gVar.bu(this.ZB);
        View view = gVar.getView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.addRule(14);
        view.setLayoutParams(layoutParams);
        this.Zz.add(new Pair<>(relativeLayout, gVar));
        TabLoadingViewHolder tabLoadingViewHolder = new TabLoadingViewHolder(relativeLayout);
        tabLoadingViewHolder.ZC = gVar;
        return tabLoadingViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        if (tabLoadingViewHolder != null && tabLoadingViewHolder.ZC != null) {
            tabLoadingViewHolder.ZC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public static class TabLoadingViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tbadk.l.g ZC;

        public TabLoadingViewHolder(View view) {
            super(view);
        }
    }
}
